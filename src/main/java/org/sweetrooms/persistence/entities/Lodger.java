package org.sweetrooms.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sweet_rooms_lodger")
@Data
@AllArgsConstructor
@DiscriminatorValue("lodger")
@ToString
public class Lodger  extends User{
}
