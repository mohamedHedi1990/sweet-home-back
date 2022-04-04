package org.sweetrooms.business.mappers;

import org.sweetrooms.client.dtos.request.CountryRequest;
import org.sweetrooms.persistence.entities.Country;

public class CountryMapper {

	public static Country toCountry(CountryRequest countryRequest) {
		return new Country(countryRequest.getCountryId(), countryRequest.getCountryLabel(),
				countryRequest.getCountryCode());
	}
}
