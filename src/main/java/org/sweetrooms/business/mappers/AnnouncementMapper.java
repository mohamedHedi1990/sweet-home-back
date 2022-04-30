package org.sweetrooms.business.mappers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.sweetrooms.client.dtos.response.AnnouncementDetailsResponse;
import org.sweetrooms.client.dtos.response.AnnouncementResponse;
import org.sweetrooms.client.dtos.response.EquipementResponse;
import org.sweetrooms.dtos.AddressDto;
import org.sweetrooms.dtos.UserDto;
import org.sweetrooms.enumeration.AnnouncementType;
import org.sweetrooms.enumeration.BedType;
import org.sweetrooms.persistence.entities.Announcement;
import org.sweetrooms.persistence.entities.EquipementAnnoncement;
import org.sweetrooms.persistence.entities.Media;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AnnouncementMapper {

	public static AnnouncementResponse toAnnouncementResponse(Announcement announcement) {
		return new AnnouncementResponse(announcement.getAnnouncementId(), announcement.getAnnouncementTitle(),
				announcement.getAnnouncementCreatedDate(), announcement.getAnnouncementNumberLike(),
				announcement.getAnnouncementNumberDislike(), announcement.getAnnouncementType(),
				AddressMapper.toAddressDto(announcement.getAnnouncementAddress()),
				announcement.getAnnouncementBedNumber(), announcement.getAnnouncementRoomNumber(),
				announcement.getAnnouncementBathRoomNumber(), announcement.getGlobalRate(),
				announcement.getAnnouncementCost(), UserMapper.toUserDto(announcement.getAnnouncementOwnerPublished()),
				!announcement.getAnnouncementMedias().isEmpty() ? announcement.getAnnouncementMedias().get(0).getMediaUrl() : null);
	}
	public static AnnouncementDetailsResponse toAnnouncementDetailsResponse(Announcement announcement,List<EquipementAnnoncement> ea) {
		
		List<String > listofPictures=announcement.getAnnouncementMedias().stream()
				.map(Media::getMediaUrl).collect(Collectors.toList());
		 
		List<EquipementResponse> listOfEquipements=ea.stream()
				.map(EquipementMapper::toEquipementFromEquipeAnnounce).collect(Collectors.toList());		
		return new AnnouncementDetailsResponse(announcement.getAnnouncementId(), announcement.getAnnouncementTitle(), announcement.getAnnouncementDescription(), 
				announcement.getAnnouncementCreatedDate(),
		announcement.getAnnouncementBedType(),
		announcement.getAnnouncementAuthorizedExtraGuests(),
		announcement.getAnnouncementSummary(),
		announcement.getAnnouncementRules(),
		announcement.getAnnouncementType(),
		AddressMapper.toAddressDto(announcement.getAnnouncementAddress()),
		announcement.getAnnouncementBedNumber(),
		announcement.getAnnouncementRoomNumber(),
		announcement.getAnnouncementBathRoomNumber(),
		announcement.getGlobalRate() ,
		announcement.getAnnouncementCost(),
		UserMapper.toUserDto(announcement.getAnnouncementOwnerPublished()),
		listofPictures,listOfEquipements,
		announcement.getAnnouncementMinStay(),
		announcement.getAnnouncementMaxStay(),
		announcement.getAnnouncementFirstAvailableDate(),
		announcement.getAnnouncementEndAvailableDate(),
		announcement.getAnnouncementGuestNumber());
	}
}
