package org.sweetrooms.business.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.sweetrooms.client.dtos.response.AnnouncementDetailsResponse;
import org.sweetrooms.client.dtos.response.AnnouncementResponse;
import org.sweetrooms.client.dtos.response.MyAnnouncementResponse;
import org.sweetrooms.dtos.EquipementDto;
import org.sweetrooms.persistence.entities.Announcement;
import org.sweetrooms.persistence.entities.Media;

public class AnnouncementMapper {

	public static AnnouncementResponse toAnnouncementResponse(Announcement announcement) {
		return new AnnouncementResponse(announcement.getAnnouncementId(), announcement.getAnnouncementTitle(),
				announcement.getAnnouncementCreatedDate(), announcement.getAnnouncementNumberLike(),
				announcement.getAnnouncementNumberDislike(), announcement.getAnnouncementType(),
				AddressMapper.toAddressDto(announcement.getAnnouncementAddress()),
				announcement.getAnnouncementBedNumber(), announcement.getAnnouncementRoomNumber(),
				announcement.getAnnouncementBathRoomNumber(), announcement.getGlobalRate(),
				announcement.getAnnouncementCost(), UserMapper.toUserDto(announcement.getAnnouncementOwnerPublished()),
				!announcement.getMedias().isEmpty()
						? announcement.getMedias().get(0).getMediaUrl()
						: null);
	}

	public static AnnouncementDetailsResponse toAnnouncementDetailsResponse(Announcement announcement,
			List<EquipementDto> equipments) {

		List<String> listofPictures = announcement.getMedias().stream().map(Media::getMediaUrl)
				.collect(Collectors.toList());

		return new AnnouncementDetailsResponse(announcement.getAnnouncementId(), announcement.getAnnouncementTitle(),
				announcement.getAnnouncementDescription(), announcement.getAnnouncementCreatedDate(),
				announcement.getAnnouncementBedType(), announcement.getAnnouncementAuthorizedExtraGuests(),
				announcement.getAnnouncementSummary(), announcement.getAnnouncementRules(),
				announcement.getAnnouncementType(), AddressMapper.toAddressDto(announcement.getAnnouncementAddress()),
				announcement.getAnnouncementBedNumber(), announcement.getAnnouncementRoomNumber(),
				announcement.getAnnouncementBathRoomNumber(), announcement.getGlobalRate(),
				announcement.getAnnouncementCost(), UserMapper.toUserDto(announcement.getAnnouncementOwnerPublished()),
				listofPictures, equipments, announcement.getAnnouncementMinStay(),
				announcement.getAnnouncementMaxStay(), announcement.getAnnouncementFirstAvailableDate(),
				announcement.getAnnouncementEndAvailableDate(), announcement.getAnnouncementGuestNumber(),
				announcement.getComments().stream().map(c ->CommentMapper.toCommentDto(c)).collect(Collectors.toList()));
	}

	public static AnnouncementDetailsResponse toAnnouncementDetailsResponse(Announcement announcement) {

		List<String> listofPictures = announcement.getMedias().stream().map(Media::getMediaUrl)
				.collect(Collectors.toList());

		return new AnnouncementDetailsResponse(announcement.getAnnouncementId(), announcement.getAnnouncementTitle(),
				announcement.getAnnouncementDescription(), announcement.getAnnouncementCreatedDate(),
				announcement.getAnnouncementBedType(), announcement.getAnnouncementAuthorizedExtraGuests(),
				announcement.getAnnouncementSummary(), announcement.getAnnouncementRules(),
				announcement.getAnnouncementType(), AddressMapper.toAddressDto(announcement.getAnnouncementAddress()),
				announcement.getAnnouncementBedNumber(), announcement.getAnnouncementRoomNumber(),
				announcement.getAnnouncementBathRoomNumber(), announcement.getGlobalRate(),
				announcement.getAnnouncementCost(), UserMapper.toUserDto(announcement.getAnnouncementOwnerPublished()),
				listofPictures,
				announcement.getEquipments().stream().map(equipment -> EquipementMapper.toEquipementDto(equipment))
						.collect(Collectors.toList()),
				announcement.getAnnouncementMinStay(), announcement.getAnnouncementMaxStay(),
				announcement.getAnnouncementFirstAvailableDate(), announcement.getAnnouncementEndAvailableDate(),
				announcement.getAnnouncementGuestNumber(),
				announcement.getComments().stream().map(c ->CommentMapper.toCommentDto(c)).collect(Collectors.toList()));
	}

	public static MyAnnouncementResponse toMyAnnouncementResponse(Announcement announcement) {
		return new MyAnnouncementResponse(announcement.getAnnouncementId(), announcement.getAnnouncementTitle(),
				announcement.getAnnouncementCreatedDate(), announcement.getAnnouncementEndAvailableDate(), announcement.getAnnouncementNumberLike(),
				announcement.getAnnouncementNumberDislike(), announcement.getAnnouncementType(),
				AddressMapper.toAddressDto(announcement.getAnnouncementAddress()),
				announcement.getAnnouncementBedNumber(), announcement.getAnnouncementRoomNumber(),
				announcement.getAnnouncementBathRoomNumber(), announcement.getGlobalRate(),
				announcement.getAnnouncementCost(), UserMapper.toUserDto(announcement.getAnnouncementOwnerPublished()),
				!announcement.getMedias().isEmpty() ? announcement.getMedias().get(0).getMediaUrl() : null,
				announcement.getAnnouncementStatus());
	}
}
