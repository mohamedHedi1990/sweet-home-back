package org.sweetrooms.rest;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sweetrooms.business.services.LodgerService;
import org.sweetrooms.persistence.entities.Lodger;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/lodger")
@Api(value = "Restfull APIs for lodger")
public class LodgerController {
    @Autowired
    LodgerService lodgerService;
    @GetMapping("")
    public List<Lodger> getAllLodgers()
    {
        return this.lodgerService.getAllLodgers();
    }
    @GetMapping("/{id}")
    public Lodger getLodgerById(@PathVariable(name = "id") Long id)
    {
        return this.lodgerService.getLodgerById(id);
    }
    @PostMapping("")
    public Lodger saveLodger(Lodger lodger )
    {
        return this.lodgerService.saveLodger(lodger);
    }
    @DeleteMapping("/{id}")
    public void deleteLodger(@PathVariable(name = "id")Long id)
    {
        this.lodgerService.deleteLodger(id);
    }
}
