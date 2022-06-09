package org.sweetrooms.client.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.sweetrooms.dtos.AddressDto;
import org.sweetrooms.dtos.EquipementDto;
import org.sweetrooms.enumeration.AnnouncementType;
import org.sweetrooms.enumeration.BedType;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AnnouncementUpdateRequest {

    private Long announcementId;
    private String announcementDescription;
    private String announcementTitle;
    private AnnouncementType announcementType;
    private AddressDto announcementAddress;
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
    private List<EquipementDto> equipments;
}
