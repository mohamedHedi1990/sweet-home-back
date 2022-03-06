package org.sweetrooms.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sweetrooms.persistence.entities.Country;
import org.sweetrooms.persistence.repositories.CountryRepository;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository;

    public List<Country> getAllCountrys()
    {
        return this.countryRepository.findAll();
    }

    public Country getCountryById(Long id)
    {
        return this.countryRepository.getById(id);
    }
    public Country saveCountry(Country country)
    {
        return this.countryRepository.save(country);
    }
    public void deleteCountry(Long id)
    {
        this.countryRepository.deleteById(id);
    }
}
