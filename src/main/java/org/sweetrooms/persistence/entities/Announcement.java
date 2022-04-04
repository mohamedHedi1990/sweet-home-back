package org.sweetrooms.persistence.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Africa/Tunis")
    private Date announcementCreatedDate;
    @Enumerated(EnumType.STRING)
    private AnnouncementStatus announcementStatus;
    private Integer announcementNumberLike = 0;
    private Integer announcementNumberDislike = 0;
    @Enumerated(EnumType.STRING)
    private AnnouncementType announcementType;
    @ManyToOne(cascade = CascadeType.PERSIST)
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Africa/Tunis")
    @Temporal(TemporalType.DATE)
    private Date announcementFirstAvailableDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Africa/Tunis")
    @Temporal(TemporalType.DATE)
    private Date announcementEndAvailableDate;
    private String announcementMapsLongitude;
    private String announcementMapsLatitude;
    private double globalRate = 0.0;
    private Double announcementCost;
    @ManyToOne
    private Admin announcementAdminApprouved;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Owner announcementOwnerPublished;
    @ManyToOne
    private Lodger announcementLodgerInteracted;
    @ManyToOne
    private Reduction announcementReduction;



}
