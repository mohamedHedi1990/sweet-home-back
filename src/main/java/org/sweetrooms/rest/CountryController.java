package org.sweetrooms.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sweetrooms.business.services.CountryService;
import org.sweetrooms.persistence.entities.Country;


import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/country")
@Tag(description = "Restfull APIs for country",name = "country ressource")
public class CountryController {
    @Autowired
    CountryService countryService;
    @Operation(summary = "Get countries",
            description = "Provides all available countries list")
    @GetMapping("")
    public List<Country> getAllCountrys()
    {
        return this.countryService.getAllCountrys();
    }
    @Operation(summary = "Get country",
            description = "Provides a specific country By ID")
    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable(name = "id") Long id)
    {
        return this.countryService.getCountryById(id);
    }
    @Operation(summary = "save country",
            description = "save a new country")
    @PostMapping("")
    public Country saveCountry(Country country )
    {
        return this.countryService.saveCountry(country);
    }
    @Operation(summary = "delete country",
            description = "Delete a specific country by ID")
    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable(name = "id")Long id)
    {
        this.countryService.deleteCountry(id);
    }
}
