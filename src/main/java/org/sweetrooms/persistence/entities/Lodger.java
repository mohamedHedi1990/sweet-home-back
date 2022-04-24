package org.sweetrooms.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "sweet_rooms_lodger")
@Data
@AllArgsConstructor
@DiscriminatorValue("lodger")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Lodger  extends User{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
