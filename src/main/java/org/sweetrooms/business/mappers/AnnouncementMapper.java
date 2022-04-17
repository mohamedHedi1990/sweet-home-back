package org.sweetrooms.business.mappers;

import org.sweetrooms.client.dtos.response.AnnouncementResponse;
import org.sweetrooms.persistence.entities.Announcement;

public class AnnouncementMapper {

	public static AnnouncementResponse toAnnouncementResponse(Announcement announcement) {
		return new AnnouncementResponse(announcement.getAnnouncementId(), announcement.getAnnouncementTitle(),
				announcement.getAnnouncementCreatedDate(), announcement.getAnnouncementNumberLike(),
				announcement.getAnnouncementNumberDislike(), announcement.getAnnouncementType(),
				AddressMapper.toAddressDto(announcement.getAnnouncementAddress()),
				announcement.getAnnouncementBedNumber(), announcement.getAnnouncementRoomNumber(),
				announcement.getAnnouncementBathRoomNumber(), announcement.getGlobalRate(),
				announcement.getAnnouncementCost(), UserMapper.toUserDto(announcement.getAnnouncementOwnerPublished()), null);
	}
}
