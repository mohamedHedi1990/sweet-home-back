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
import org.sweetrooms.business.services.EquipementService;
import org.sweetrooms.dtos.EquipementDto;
import org.sweetrooms.persistence.entities.Equipement;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin
@RequestMapping("/equipement")
@Tag(description = "Restfull APIs for Equipement",name = "Equipement ressource")
public class EquipementController {
    @Autowired
    EquipementService equipementService;
    @Operation(summary = "Get equipements",
            description = "Provides all available equipements list")
    @GetMapping()
    public List<EquipementDto> getAllEquipements()
    {
        return this.equipementService.getAllEquipements();
    }
    @Operation(summary = "Get equipement",
            description = "Provides an equipement By a specific ID")
    @GetMapping("/{id}")
    public Equipement getEquipementById(@PathVariable(name = "id") Long id)
    {
        return this.equipementService.getEquipementById(id);
    }
    @Operation(summary = "Save an equipement",
            description = "save a new Equipement")
    @PostMapping("")
    public Equipement saveEquipement(@RequestBody Equipement equipement )
    {
        return this.equipementService.saveEquipement(equipement);
    }
    @Operation(summary = "Delete Equipement",
            description = "Delete an Equipement By ID")
    @DeleteMapping("/{id}")
    public void deleteEquipement(@PathVariable(name = "id")Long id)
    {
        this.equipementService.deleteEquipement(id);
    }
}
