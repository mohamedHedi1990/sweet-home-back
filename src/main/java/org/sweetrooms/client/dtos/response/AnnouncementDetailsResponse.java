package org.sweetrooms.client.dtos.response;

import java.util.Date;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.sweetrooms.dtos.AddressDto;
import org.sweetrooms.dtos.UserDto;
import org.sweetrooms.enumeration.AnnouncementType;
import org.sweetrooms.enumeration.BedType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementDetailsResponse {
	private Long announcementId;
	private String announcementTitle;
	private String announcementDescription;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Africa/Tunis")
	private Date announcementCreatedDate;
	@Enumerated(EnumType.STRING)
	private BedType announcementBedType;
	private Boolean announcementAuthorizedExtraGuests;
	private String announcementSummary;
	private String announcementRules;
	private AnnouncementType announcementType;
	private AddressDto announcementAddress;
	private Integer announcementBedNumber;
	private Integer announcementRoomNumber;
	private Integer announcementBathRoomNumber;
	private double globalRate = 0.0;
	private Double announcementCost;
	private UserDto announcementOwnerPublished;
	private List<String> announcementPictureUrls;
	private Integer announcementMinStay;
	private Integer announcementMaxStay;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Africa/Tunis")
	@Temporal(TemporalType.DATE)
	private Date announcementFirstAvailableDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Africa/Tunis")
	@Temporal(TemporalType.DATE)
	private Date announcementEndAvailableDate;

}