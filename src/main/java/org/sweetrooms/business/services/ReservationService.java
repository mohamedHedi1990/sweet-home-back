package org.sweetrooms.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sweetrooms.business.mappers.ReservationMapper;
import org.sweetrooms.client.dtos.request.ReservationRequest;
import org.sweetrooms.enumeration.AnnouncementStatus;
import org.sweetrooms.enumeration.ReservationStatus;
import org.sweetrooms.enumeration.RoleCode;
import org.sweetrooms.persistence.entities.Announcement;
import org.sweetrooms.persistence.entities.Lodger;
import org.sweetrooms.persistence.entities.Reservation;
import org.sweetrooms.persistence.entities.User;
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
		Lodger lodger=lodgerService.getLodgerById(SecurityUtil.getCurrentUserId());
		Announcement announcement = announcementService.getAnnouncementById(announcementId);
    	
		Reservation reservation = new Reservation();
		reservation.setReservationAnnouncmeent(announcement);
		reservation.setReservationEndDate(reservationIn.getReservationEndDate());
		reservation.setReservationGuestNumber(reservationIn.getReservationGuestNumber());
		reservation.setReservationLodger(lodger);
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
			return this.reservationRepository.findByReservationLodger((Lodger) user);
		}
		return null;
	}

    public List<Reservation> findAllByAnnouncementId(Long announcementId) {

        return this.reservationRepository.findAllByReservationAnnouncmeentAnnouncementId(announcementId);

    }
}
