package org.sweetrooms.rest;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sweetrooms.business.services.CountryService;
import org.sweetrooms.persistence.entities.Country;


import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/country")
@Api(value = "Restfull APIs for country")
public class CountryController {
    @Autowired
    CountryService countryService;
    @GetMapping("")
    public List<Country> getAllCountrys()
    {
        return this.countryService.getAllCountrys();
    }
    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable(name = "id") Long id)
    {
        return this.countryService.getCountryById(id);
    }
    @PostMapping("")
    public Country saveCountry(Country country )
    {
        return this.countryService.saveCountry(country);
    }
    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable(name = "id")Long id)
    {
        this.countryService.deleteCountry(id);
    }
}
