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
import org.sweetrooms.business.services.OwnerService;
import org.sweetrooms.client.dtos.request.UserRequest;
import org.sweetrooms.persistence.entities.Owner;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

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
    public Boolean saveOwner(@RequestBody UserRequest owner)
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
