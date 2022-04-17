package org.sweetrooms.client.dtos.request;

import org.sweetrooms.dtos.CityDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequest {
	private String addressStreet;
	private Integer addressStreetNumber;
	private CityDto addressCity;
	// private CountryDto addressCountry;

}
