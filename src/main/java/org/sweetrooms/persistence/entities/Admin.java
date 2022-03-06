package org.sweetrooms.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sweet_rooms_admin")
@Data
@AllArgsConstructor
@DiscriminatorValue("admin")
public class Admin extends User {
}
