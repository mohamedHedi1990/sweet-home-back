package org.sweetrooms.business.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.sweetrooms.business.mappers.AddressMapper;
import org.sweetrooms.business.mappers.AnnouncementMapper;
import org.sweetrooms.business.mappers.EquipementMapper;
import org.sweetrooms.client.dtos.request.AnnouncementRequest;
import org.sweetrooms.client.dtos.request.AnnouncementUpdateRequest;
import org.sweetrooms.client.dtos.request.SearchAnnouncementRequest;
import org.sweetrooms.client.dtos.response.AnnouncementDetailsResponse;
import org.sweetrooms.client.dtos.response.AnnouncementResponse;
import org.sweetrooms.client.dtos.response.MyAnnouncementResponse;
import org.sweetrooms.client.dtos.response.SearchAnnouncementResponse;
import org.sweetrooms.dtos.AnnouncementSearchCriteria;
import org.sweetrooms.enumeration.AnnouncementStatus;
import org.sweetrooms.enumeration.RoleCode;
import org.sweetrooms.persistence.entities.Announcement;
import org.sweetrooms.persistence.entities.Lodger;
import org.sweetrooms.persistence.entities.Owner;
import org.sweetrooms.persistence.entities.User;
import org.sweetrooms.persistence.repositories.AnnouncementRepository;
import org.sweetrooms.persistence.repositories.OwnerRepository;

@Service
public class AnnouncementService {
	@Autowired
	AnnouncementRepository announcementRepository;

	@Autowired
	private OwnerRepository ownerRepository;
	@Autowired
	private UserService userService;

	public List<Announcement> getAllAnnouncements() {

		return this.announcementRepository.findAll();
	}

	public Announcement getAnnouncementById(Long id) {
		return this.announcementRepository.getById(id);
	}

	public AnnouncementDetailsResponse getAnnouncementDetailsById(Long id) {
		Announcement announcement = getAnnouncementById(id);
		return AnnouncementMapper.toAnnouncementDetailsResponse(announcement);
	}

	public Announcement save(Announcement announcement) {
		return this.announcementRepository.save(announcement);
	}

	public List<MyAnnouncementResponse> getMyAnnoucements() {
		User user = userService.getCurrentUser();
		if (user.getUserRole().getRoleCode() == RoleCode.OWNER) {
			return this.announcementRepository.findByAnnouncementOwnerPublished(((Owner) user)).stream()
					.map(announcement -> AnnouncementMapper.toMyAnnouncementResponse(announcement))
					.collect(Collectors.toList());
		} else if (user.getUserRole().getRoleCode() == RoleCode.LODGER) {
			return this.announcementRepository.findByAnnouncementLodgerInteracted((Lodger) user).stream()
					.map(announcement -> AnnouncementMapper.toMyAnnouncementResponse(announcement))
					.collect(Collectors.toList());
		}
		return this.announcementRepository.findAll().stream()
				.map(announcement -> AnnouncementMapper.toMyAnnouncementResponse(announcement))
				.collect(Collectors.toList());

	}

	public Announcement saveAnnouncement(AnnouncementRequest announcementIn) {
		Owner owner = (Owner) this.userService.getCurrentUser();
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
			announcement.setEquipments(announcementIn.getEquipments().stream()
					.map(equipment -> EquipementMapper.toEquipement(equipment)).collect(Collectors.toList()));
			return this.announcementRepository.save(announcement);
		}
		return null;
	}

	public Announcement updateAnnouncement(AnnouncementUpdateRequest announcementIn) {
		Owner owner = (Owner) this.userService.getCurrentUser();
		Announcement existingAnn=announcementRepository.findById(announcementIn.getAnnouncementId()).get();
		System.out.println(owner.equals(existingAnn.getAnnouncementOwnerPublished()));
		if (owner != null && existingAnn!=null && owner.equals(existingAnn.getAnnouncementOwnerPublished())) {
			existingAnn.setAnnouncementOwnerPublished(owner);
			existingAnn.setAnnouncementAddress(AddressMapper.toAddress(announcementIn.getAnnouncementAddress()));
			existingAnn.setAnnouncementAuthorizedExtraGuests(announcementIn.getAnnouncementAuthorizedExtraGuests());
			existingAnn.setAnnouncementBathRoomNumber(announcementIn.getAnnouncementBathRoomNumber());
			existingAnn.setAnnouncementBedNumber(announcementIn.getAnnouncementBedNumber());
			existingAnn.setAnnouncementBedType(announcementIn.getAnnouncementBedType());
			existingAnn.setAnnouncementCost(announcementIn.getAnnouncementCost());
			existingAnn.setAnnouncementCreatedDate(new Date());
			existingAnn.setAnnouncementDescription(announcementIn.getAnnouncementDescription());
			existingAnn.setAnnouncementEndAvailableDate(announcementIn.getAnnouncementEndAvailableDate());
			existingAnn.setAnnouncementFirstAvailableDate(announcementIn.getAnnouncementFirstAvailableDate());
			existingAnn.setAnnouncementGuestNumber(announcementIn.getAnnouncementGuestNumber());
			existingAnn.setAnnouncementMaxStay(announcementIn.getAnnouncementMaxStay());
			existingAnn.setAnnouncementMinStay(announcementIn.getAnnouncementMinStay());
			existingAnn.setAnnouncementRoomNumber(announcementIn.getAnnouncementRoomNumber());
			existingAnn.setAnnouncementRules(announcementIn.getAnnouncementRules());
			existingAnn.setAnnouncementStatus(AnnouncementStatus.CREATED);
			existingAnn.setAnnouncementSummary(announcementIn.getAnnouncementSummary());
			existingAnn.setAnnouncementTitle(announcementIn.getAnnouncementTitle());
			existingAnn.setAnnouncementType(announcementIn.getAnnouncementType());
			existingAnn.setEquipments(announcementIn.getEquipments().stream()
					.map(equipment -> EquipementMapper.toEquipement(equipment)).collect(Collectors.toList()));
			return this.announcementRepository.save(existingAnn);
		}
		return null;
	}

	public void deleteAnnouncement(Long id) {
		this.announcementRepository.deleteById(id);
	}

	public List<AnnouncementResponse> findAnnouncementsByCriteria(
			AnnouncementSearchCriteria announcementSearchCriteria) {
        System.out.println("announcementSearchCriteria : "+announcementSearchCriteria.toString());
        List<AnnouncementResponse> list=this.announcementRepository
				.findAllByAnnouncementAddressAddressCityCityLabelContainingAndAnnouncementFirstAvailableDateGreaterThanEqualAndAnnouncementEndAvailableDateLessThanEqualAndAnnouncementGuestNumberEquals(
						announcementSearchCriteria.getAnnouncementCityLabel(),
						announcementSearchCriteria.getAnnouncementStartDate(),
						announcementSearchCriteria.getAnnouncementEndDate(), announcementSearchCriteria.getNbGuest())
				.stream().map(announcement -> AnnouncementMapper.toAnnouncementResponse(announcement))
				.collect(Collectors.toList());

        return list;
	}

	public List<AnnouncementResponse> findLastAnnouncements() {
		return announcementRepository.findTop12ByOrderByCreatedAtDesc().stream()
				.map(announcement -> AnnouncementMapper.toAnnouncementResponse(announcement))
				.collect(Collectors.toList());
	}

    public SearchAnnouncementResponse searchByAnnouncementRequest(SearchAnnouncementRequest announcementRequest) {
        System.out.println(announcementRequest.toString());
		Page<Announcement> announcements=this.announcementRepository
				.findAllByAnnouncementSearchRequest(
						announcementRequest.getSearchCriteria().getAnnouncementCityLabel(),
                        announcementRequest.getSearchCriteria().getNbGuest(),
						announcementRequest.getSearchCriteria().getAnnouncementStartDate(),
						announcementRequest.getSearchCriteria().getAnnouncementEndDate(),
                        PageRequest.of(announcementRequest.getCurrentPage()-1, announcementRequest.getSize()));

		SearchAnnouncementResponse response=new SearchAnnouncementResponse();
		response.setTotalItems(announcements.getTotalElements());

		List<AnnouncementResponse> responses=announcements.getContent().stream().map(r -> AnnouncementMapper.toAnnouncementResponse(r)).collect(Collectors.toList());
	    response.setAnnouncementResponseList(responses);

	    return response;
	}
}
