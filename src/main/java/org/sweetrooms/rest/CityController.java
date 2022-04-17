package org.sweetrooms.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sweetrooms.business.services.CityService;
import org.sweetrooms.dtos.CityDto;
import org.sweetrooms.persistence.entities.City;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin
@RequestMapping("/city")
@Tag(description = "Restfull APIs for City",name = "City ressource")
public class CityController {
    @Autowired
    CityService cityService;
    @Operation(summary = "Get cities",
            description = "Provides all available countries list")
    @GetMapping("")
    public List<CityDto> getAllCitys()
    {
        return this.cityService.getAllCities();
    }
    @Operation(summary = "Get City",
            description = "Provides a specific City By ID")
    @GetMapping("/{id}")
    public City getCityById(@PathVariable(name = "id") Long id)
    {
        return this.cityService.getCityById(id);
    }
    @Operation(summary = "save City",
            description = "save a new City")
    @PostMapping("")
    public City saveCity(@RequestBody City City )
    {
        return this.cityService.saveCity(City);
    }
    @Operation(summary = "delete City",
            description = "Delete a specific City by ID")
    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable(name = "id")Long id)
    {
        this.cityService.deleteCity(id);
    }
}
