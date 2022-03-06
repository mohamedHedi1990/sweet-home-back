package org.sweetrooms.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "sweet_rooms_reduction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reduction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reductionId;
    private String reductionLabel;
    private Integer reductionRate;

}
