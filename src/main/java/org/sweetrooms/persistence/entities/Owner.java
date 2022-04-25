package org.sweetrooms.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sweet_rooms_owner")
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("owner")
public class Owner extends User {
    private double ownerRate = 0.0;
}
