package org.sweetrooms.business.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sweetrooms.business.mappers.ReservationMapper;
import org.sweetrooms.client.dtos.request.ReservationRequest;
import org.sweetrooms.client.dtos.response.ReservationDetailsResponse;
import org.sweetrooms.enumeration.AnnouncementStatus;
import org.sweetrooms.enumeration.ReservationStatus;
import org.sweetrooms.enumeration.RoleCode;
import org.sweetrooms.persistence.entities.*;
import org.sweetrooms.persistence.repositories.ReservationRepository;
import org.sweetrooms.utils.SecurityUtil;

@Service
public class ReservationService {
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	UserService userService;
	
	@Autowired
	private LodgerService lodgerService;
	
	@Autowired
	private AnnouncementService announcementService;

	public List<Reservation> getAllReservations() {
		return this.reservationRepository.findAll();
	}

	public Reservation getReservationById(Long id) {
		return this.reservationRepository.getById(id);
	}

	public Reservation saveReservation(Reservation reservation) {
		return this.reservationRepository.save(reservation);
	}
	
	public void saveReservation(ReservationRequest reservationIn, Long announcementId) {
		//Lodger lodger=lodgerService.getLodgerById(SecurityUtil.getCurrentUserId());
		User user= userService.getUserById(SecurityUtil.getCurrentUserId());
		Announcement announcement = announcementService.getAnnouncementById(announcementId);
    	
		Reservation reservation = new Reservation();
		reservation.setReservationAnnouncmeent(announcement);
		reservation.setReservationEndDate(reservationIn.getReservationEndDate());
		reservation.setReservationGuestNumber(reservationIn.getReservationGuestNumber());
		reservation.setReservationUser(user);
		reservation.setReservationStartDate(reservationIn.getReservationStartDate());
		reservation.setReservationStatus(ReservationStatus.PENDING);
		this.saveReservation(reservation);
		
		announcement.setAnnouncementStatus(AnnouncementStatus.BOOKED);
		this.announcementService.save(announcement);
	}

	public void deleteReservation(Long id) {
		this.reservationRepository.deleteById(id);
	}

	public List<Reservation> getMyReservations() {

		User user = userService.getCurrentUser();
		if (user.getUserRole().getRoleCode() == RoleCode.LODGER) {
			return this.reservationRepository.findByReservationUser(user);
		}
		return null;
	}

	public List<ReservationDetailsResponse> getUserReservations() {

		User user = userService.getCurrentUser();
		List<Reservation> reservations=this.reservationRepository.findByReservationUser(user);
		return reservations.stream().map(r -> ReservationMapper.toReservationDetailsResponse(r)).collect(Collectors.toList());

	}

    public List<Reservation> findAllByAnnouncementId(Long announcementId) {

        return this.reservationRepository.findAllByReservationAnnouncmeentAnnouncementId(announcementId);

    }

	public boolean checkIfTheCurrentUserIsTheOwner(Long announcementId) {
		User user=userService.getUserById(SecurityUtil.getCurrentUserId());
		Owner owner = this.announcementService.getAnnouncementById(announcementId).getAnnouncementOwnerPublished();
		if(owner.getUserId() == user.getUserId()) return true;

		return false;
	}

	public List<ReservationDetailsResponse> getReservationsAnnouncement(Long announcementId) {
		List<Reservation> reservations=findAllByAnnouncementId(announcementId);
		System.out.println(reservations);
		return reservations.stream().map(r -> ReservationMapper.toReservationDetailsResponse(r)).collect(Collectors.toList());

	}

	public void validateReservation(Long id) {
		Reservation reservation=getReservationById(id);
		reservation.setReservationStatus(ReservationStatus.ACCEPTED);

		saveReservation(reservation);
	}

	public void refuseReservation(Long id) {
		Reservation reservation=getReservationById(id);
		reservation.setReservationStatus(ReservationStatus.REFUSED);

		saveReservation(reservation);
	}

	public void cancelReservation(Long id) {
		Reservation reservation=getReservationById(id);
		reservation.setReservationStatus(ReservationStatus.CANCELED);

		saveReservation(reservation);
	}
}
