package org.sweetrooms.client.dtos.request;

import java.util.Date;

import org.sweetrooms.enumeration.AnnouncementType;
import org.sweetrooms.enumeration.BedType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementRequest {

	private String announcementDescription;
	private String announcementTitle;
	private AnnouncementType announcementType;
	private AddressRequest announcementAddress;
	private Integer announcementGuestNumber;
	private Integer announcementBedNumber;
	private Integer announcementRoomNumber;
	private Integer announcementBathRoomNumber;
	private BedType announcementBedType;
	private Boolean announcementAuthorizedExtraGuests;
	private String announcementSummary;
	private String announcementRules;
	private Integer announcementMinStay;
	private Integer announcementMaxStay;
	private Date announcementFirstAvailableDate;
	private Date announcementEndAvailableDate;
	private String announcementMapsLongitude;
	private String announcementMapsLatitude;
	private Double announcementCost;

}
