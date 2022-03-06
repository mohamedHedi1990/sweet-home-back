package org.sweetrooms.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sweetrooms.enumeration.AnnouncementStatus;
import org.sweetrooms.enumeration.AnnouncementType;
import org.sweetrooms.enumeration.BedType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sweet_rooms_announcement")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long announcementId;
    private String announcementDescription;
    private String announcementTitle;
    private Date announcementCreatedDate;
    @Enumerated(EnumType.STRING)
    private AnnouncementStatus announcementStatus;
    private Integer announcementNumberLike;
    private Integer announcementNumberDislike;
    @Enumerated(EnumType.STRING)
    private AnnouncementType announcementType;
    @ManyToOne
    private Address announcementAddress;
    private Integer announcementGuestNumber;
    private Integer announcementBedNumber;
    private Integer announcementRoomNumber;
    private Integer announcementBathRoomNumber;
    @Enumerated(EnumType.STRING)
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
    private double globalRateDate;
    @ManyToOne
    private Admin announcementAdminApprouved;
    @ManyToOne
    private Owner announcementOwnerPublished;
    @ManyToOne
    private Lodger announcementLodgerInteracted;
    @ManyToOne
    private Reduction announcementReduction;



}
