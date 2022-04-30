package org.sweetrooms.business.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sweetrooms.business.mappers.AddressMapper;
import org.sweetrooms.business.mappers.AnnouncementMapper;
import org.sweetrooms.client.dtos.request.AnnouncementRequest;
import org.sweetrooms.client.dtos.response.AnnouncementDetailsResponse;
import org.sweetrooms.client.dtos.response.AnnouncementResponse;
import org.sweetrooms.dtos.AnnouncementSearchCriteria;
import org.sweetrooms.enumeration.AnnouncementStatus;
import org.sweetrooms.enumeration.RoleCode;
import org.sweetrooms.persistence.entities.Announcement;
import org.sweetrooms.persistence.entities.EquipementAnnoncement;
import org.sweetrooms.persistence.entities.Lodger;
import org.sweetrooms.persistence.entities.Owner;
import org.sweetrooms.persistence.entities.User;
import org.sweetrooms.persistence.repositories.AnnouncementRepository;
import org.sweetrooms.persistence.repositories.EquipementAnnoncementRepository;
import org.sweetrooms.persistence.repositories.OwnerRepository;

@Service
public class AnnouncementService {
	@Autowired
	AnnouncementRepository announcementRepository;

	@Autowired
	private OwnerRepository ownerRepository;
	@Autowired
	private UserService userService;
	@Autowired
private EquipementAnnoncementRepository annoncementRepository;
	public List<Announcement> getAllAnnouncements() {

		return this.announcementRepository.findAll();
	}

	public Announcement getAnnouncementById(Long id) {
		return this.announcementRepository.getById(id);
	}
	public AnnouncementDetailsResponse getAnnouncementDetailsById(Long id) {
		Announcement announcement=getAnnouncementById(id);
		List<EquipementAnnoncement> listofAE= annoncementRepository.findByAnnouncement(announcement);
		return AnnouncementMapper.toAnnouncementDetailsResponse(announcement,listofAE);
	}
	public Announcement save(Announcement announcement) {
		return this.announcementRepository.save(announcement);
	}

	public List<AnnouncementResponse> getMyAnnoucements() {
		User user = userService.getCurrentUser();
		if (user.getUserRole().getRoleCode() == RoleCode.OWNER) {
			return this.announcementRepository.findByAnnouncementOwnerPublished(((Owner) user)).stream()
					.map(announcement -> AnnouncementMapper.toAnnouncementResponse(announcement))
					.collect(Collectors.toList());
		} else if (user.getUserRole().getRoleCode() == RoleCode.LODGER) {
			return this.announcementRepository.findByAnnouncementLodgerInteracted((Lodger) user).stream()
					.map(announcement -> AnnouncementMapper.toAnnouncementResponse(announcement))
					.collect(Collectors.toList());
		}
		return this.announcementRepository.findAll().stream()
				.map(announcement -> AnnouncementMapper.toAnnouncementResponse(announcement))
				.collect(Collectors.toList());

	}

	public Announcement saveAnnouncement(AnnouncementRequest announcementIn, Long ownerId) {
		Owner owner = this.ownerRepository.findByUserId(ownerId);
		if (owner != null) {
			Announcement announcement = new Announcement();
			announcement.setAnnouncementOwnerPublished(owner);
			announcement.setAnnouncementAddress(AddressMapper.toAddress(announcementIn.getAnnouncementAddress()));
			announcement.setAnnouncementAuthorizedExtraGuests(announcementIn.getAnnouncementAuthorizedExtraGuests());
			announcement.setAnnouncementBathRoomNumber(announcementIn.getAnnouncementBathRoomNumber());
			announcement.setAnnouncementBedNumber(announcementIn.getAnnouncementBedNumber());
			announcement.setAnnouncementBedType(announcementIn.getAnnouncementBedType());
			announcement.setAnnouncementCost(announcementIn.getAnnouncementCost());
			announcement.setAnnouncementCreatedDate(new Date());
			announcement.setAnnouncementDescription(announcementIn.getAnnouncementDescription());
			announcement.setAnnouncementEndAvailableDate(announcementIn.getAnnouncementEndAvailableDate());
			announcement.setAnnouncementFirstAvailableDate(announcementIn.getAnnouncementFirstAvailableDate());
			announcement.setAnnouncementGuestNumber(announcementIn.getAnnouncementGuestNumber());
			announcement.setAnnouncementMaxStay(announcementIn.getAnnouncementMaxStay());
			announcement.setAnnouncementMinStay(announcementIn.getAnnouncementMinStay());
			announcement.setAnnouncementRoomNumber(announcementIn.getAnnouncementRoomNumber());
			announcement.setAnnouncementRules(announcementIn.getAnnouncementRules());
			announcement.setAnnouncementStatus(AnnouncementStatus.CREATED);
			announcement.setAnnouncementSummary(announcementIn.getAnnouncementSummary());
			announcement.setAnnouncementTitle(announcementIn.getAnnouncementTitle());
			announcement.setAnnouncementType(announcementIn.getAnnouncementType());
			return this.announcementRepository.save(announcement);
		}
		return null;
	}

	public void deleteAnnouncement(Long id) {
		this.announcementRepository.deleteById(id);
	}

	public List<AnnouncementResponse> findAnnouncementsByCriteria(
			AnnouncementSearchCriteria announcementSearchCriteria) {
		return this.announcementRepository
				.findAllByAnnouncementAddressAddressCityCityLabelContainingAndAnnouncementFirstAvailableDateGreaterThanEqualAndAnnouncementEndAvailableDateLessThanEqualAndAnnouncementGuestNumberEquals(
						announcementSearchCriteria.getAnnouncementCityLabel(),
						announcementSearchCriteria.getAnnouncementStartDate(),
						announcementSearchCriteria.getAnnouncementEndDate(), announcementSearchCriteria.getNbGuest())
				.stream().map(announcement -> AnnouncementMapper.toAnnouncementResponse(announcement))
				.collect(Collectors.toList());
	}

	public List<AnnouncementResponse> findLastAnnouncements() {
		return announcementRepository.findTop12ByOrderByCreatedAtDesc().stream()
				.map(announcement -> AnnouncementMapper.toAnnouncementResponse(announcement))
				.collect(Collectors.toList());
	}
}
