package org.sweetrooms.business.mappers;

import org.sweetrooms.dtos.CityDto;
import org.sweetrooms.persistence.entities.City;

public class CityMapper {

	public static City toCity(CityDto cityRequest) {
		return new City(cityRequest.getCityId(), cityRequest.getCityLabel(), cityRequest.getCityCode(),
				CountryMapper.toCountry(cityRequest.getCountry()));
	}

	public static CityDto toCityDto(City city) {
		return new CityDto(city.getCityId(), city.getCityLabel(), city.getCityCode(),
				CountryMapper.toCountryDto(city.getCountry()));
	}
}
