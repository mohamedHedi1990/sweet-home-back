package org.sweetrooms.rest;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sweetrooms.business.services.OwnerService;
import org.sweetrooms.business.services.PositionService;
import org.sweetrooms.persistence.entities.Owner;
import org.sweetrooms.persistence.entities.Position;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/owner")
@Api(value = "Restfull APIs for owner")
public class OwnerController {
    @Autowired
    OwnerService ownerService;
    @GetMapping("")
    public List<Owner> getAllOwners()
    {
        return this.ownerService.getAllOwners();
    }
    @GetMapping("/{id}")
    public Owner getOwnersById(@PathVariable(name = "id") Long id)
    {
        return this.ownerService.getOwnerById(id);
    }
    @PostMapping("")
    public Owner saveOwner(Owner owner)
    {
        return this.ownerService.saveOwner(owner);
    }
    @DeleteMapping("/{id}")
    public void deleteOwner(@PathVariable(name = "id")Long id)
    {
        this.ownerService.deleteOwner(id);
    }
}
