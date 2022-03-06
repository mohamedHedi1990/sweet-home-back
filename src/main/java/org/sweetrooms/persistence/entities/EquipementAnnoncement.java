package org.sweetrooms.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "sweet_rooms_equipement_annoncement")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipementAnnoncement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long equipementAnnoncementId;
    @ManyToOne
    private Equipement equipement;
    @ManyToOne
    private Announcement announcement;
}
