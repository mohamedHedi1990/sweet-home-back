package org.sweetrooms.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sweetrooms.business.services.OwnerService;
import org.sweetrooms.persistence.entities.Owner;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/owner")
@Tag(description = "Restfull APIs for owner",name = "owner ressource")
public class OwnerController {
    @Autowired
    OwnerService ownerService;
    @Operation(summary = "Get owners",
            description = "Provides all available owners list")
    @GetMapping("")
    public List<Owner> getAllOwners()
    {
        return this.ownerService.getAllOwners();
    }
    @Operation(summary = "Get owner",
            description = "Provides owner by ID")
    @GetMapping("/{id}")
    public Owner getOwnersById(@PathVariable(name = "id") Long id)
    {
        return this.ownerService.getOwnerById(id);
    }
    @Operation(summary = "save owner",
            description = "save a new owner")
    @PostMapping("")
    public Owner saveOwner(Owner owner)
    {
        return this.ownerService.saveOwner(owner);
    }
    @Operation(summary = "Delete owner",
            description = "Delete a specific owner by ID")
    @DeleteMapping("/{id}")
    public void deleteOwner(@PathVariable(name = "id")Long id)
    {
        this.ownerService.deleteOwner(id);
    }
}
