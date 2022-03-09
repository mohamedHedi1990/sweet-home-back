package org.sweetrooms.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sweetrooms.business.services.LodgerService;
import org.sweetrooms.persistence.entities.Lodger;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/lodger")
@Tag(description = "Restfull APIs for Lodger",name = "Lodger ressource")
public class LodgerController {
    @Autowired
    LodgerService lodgerService;
    @Operation(summary = "Get lodgers",
            description = "Provides all available lodgers list")
    @GetMapping("")
    public List<Lodger> getAllLodgers()
    {
        return this.lodgerService.getAllLodgers();
    }
    @Operation(summary = "Get Lodger",
            description = "Provides Lodger by ID")
    @GetMapping("/{id}")
    public Lodger getLodgerById(@PathVariable(name = "id") Long id)
    {
        return this.lodgerService.getLodgerById(id);
    }
    @Operation(summary = "save lodger",
            description = "save a new Lodger")
    @PostMapping("")
    public Lodger saveLodger(Lodger lodger )
    {
        return this.lodgerService.saveLodger(lodger);
    }
    @Operation(summary = "Delete a Lodger",
            description = "Delete a lodger by a specific ID")
    @DeleteMapping("/{id}")
    public void deleteLodger(@PathVariable(name = "id")Long id)
    {
        this.lodgerService.deleteLodger(id);
    }
}
