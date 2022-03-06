package org.sweetrooms.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "sweet_rooms_annoncement_rate_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementRateDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long announcementRateDetailsId;
    private Long announcementRateDetailsLabel;
    private Long announcementRateDetailsValue;
    @ManyToOne
    private Announcement announcement;

}
