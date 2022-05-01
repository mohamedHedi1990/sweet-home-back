package org.sweetrooms.persistence.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.sweetrooms.enumeration.AnnouncementStatus;
import org.sweetrooms.enumeration.AnnouncementType;
import org.sweetrooms.enumeration.BedType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sweet_rooms_announcement")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Announcement extends AuditableSql implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long announcementId;
	@Lob
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
    @Lob
    private String announcementSummary;
    @Lob
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
    @OneToMany(cascade = CascadeType.MERGE)
    private List<Media> medias = new ArrayList<>();
    
    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Equipement> equipments = new ArrayList<>();



}
