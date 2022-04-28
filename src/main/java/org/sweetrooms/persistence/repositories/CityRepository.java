package org.sweetrooms.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sweetrooms.persistence.entities.City;
@Repository
public interface CityRepository  extends JpaRepository<City,Long> {
	City findByCityCode(String cityCode);
	List<City> findByCountryCountryCodeOrderByCityLabel(String countryCode);

	List<City> findByCountryCountryId(Long countryId);
}
