package org.sweetrooms.client.dtos.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sweetrooms.dtos.AddressDto;
import org.sweetrooms.dtos.UserDto;
import org.sweetrooms.enumeration.AnnouncementStatus;
import org.sweetrooms.enumeration.AnnouncementType;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyAnnouncementResponse {

    private Long announcementId;
    private String announcementTitle;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Africa/Tunis")
    private Date announcementCreatedDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Africa/Tunis")
    private Date announcementEndAvailableDate;

    private Integer announcementNumberLike = 0;
    private Integer announcementNumberDislike = 0;

    private AnnouncementType announcementType;

    private AddressDto announcementAddress;

    private Integer announcementBedNumber;
    private Integer announcementRoomNumber;
    private Integer announcementBathRoomNumber;

    private double globalRate = 0.0;
    private Double announcementCost;

    private UserDto announcementOwnerPublished;
    private String announcementMainPictureUrl;

    private AnnouncementStatus announcementStatus;


}
