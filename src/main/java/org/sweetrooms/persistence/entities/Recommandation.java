package org.sweetrooms.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "sweet_rooms_recommandation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recommandation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recommandationId;
    private String recommandationText;
    @ManyToOne
    private Lodger recommandationLodger;
    @ManyToOne
    private Announcement recommandationAnnouncement;
}
