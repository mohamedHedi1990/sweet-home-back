package org.sweetrooms.business.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sweetrooms.business.mappers.CityMapper;
import org.sweetrooms.dtos.CityDto;
import org.sweetrooms.persistence.entities.City;
import org.sweetrooms.persistence.repositories.CityRepository;

@Service
public class CityService {
	@Autowired
	CityRepository cityRepository;

	public List<CityDto> getAllCities() {
		return this.cityRepository.findByCountryCountryCodeOrderByCityLabel("TN").stream()
				.map(city -> CityMapper.toCityDto(city)).collect(Collectors.toList());
	}

	public City getCityById(Long id) {
		return this.cityRepository.getById(id);
	}

	public City saveCity(City City) {
		return this.cityRepository.save(City);
	}

	public void deleteCity(Long id) {
		this.cityRepository.deleteById(id);
	}

	public List<CityDto> getCityByCountryId(Long coutryId) {
		return cityRepository.findByCountryCountryId(coutryId).stream()
				.map(city -> CityMapper.toCityDto(city)).collect(Collectors.toList());
	}
}
