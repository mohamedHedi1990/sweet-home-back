package org.sweetrooms.business.mappers;

import org.sweetrooms.dtos.CountryDto;
import org.sweetrooms.persistence.entities.Country;

public class CountryMapper {

	public static Country toCountry(CountryDto countryRequest) {
		return new Country(countryRequest.getCountryId(), countryRequest.getCountryLabel(),
				countryRequest.getCountryCode());
	}
	
	public static CountryDto toCountryDto(Country country) {
		return new CountryDto(country.getCountryId(), country.getCountryLabel(), country.getCountryCode());
	}
}
