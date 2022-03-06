package org.sweetrooms.rest;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sweetrooms.business.services.EquipementService;
import org.sweetrooms.persistence.entities.Equipement;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/equipement")
@Api(value = "Restfull APIs for equipement")
public class EquipementController {
    @Autowired
    EquipementService equipementService;
    @GetMapping("")
    public List<Equipement> getAllEquipements()
    {
        return this.equipementService.getAllEquipements();
    }
    @GetMapping("/{id}")
    public Equipement getEquipementById(@PathVariable(name = "id") Long id)
    {
        return this.equipementService.getEquipementById(id);
    }
    @PostMapping("")
    public Equipement saveEquipement(Equipement equipement )
    {
        return this.equipementService.saveEquipement(equipement);
    }
    @DeleteMapping("/{id}")
    public void deleteEquipement(@PathVariable(name = "id")Long id)
    {
        this.equipementService.deleteEquipement(id);
    }
}
