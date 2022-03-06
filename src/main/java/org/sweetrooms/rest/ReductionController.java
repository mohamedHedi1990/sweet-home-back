package org.sweetrooms.rest;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sweetrooms.business.services.ReductionService;
import org.sweetrooms.persistence.entities.Reduction;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/reduction")
@Api(value = "Restfull APIs for reduction")
public class ReductionController {

    @Autowired
    ReductionService reductionService;
    @GetMapping("")
    public List<Reduction> getAllReductions()
    {
        return this.reductionService.getAllReductions();
    }
    @GetMapping("/{id}")
    public Reduction getReductionById(@PathVariable(name = "id") Long id)
    {
        return this.reductionService.getReductionById(id);
    }
    @PostMapping("")
    public Reduction saveReduction(Reduction reduction)
    {
        return this.reductionService.saveReduction(reduction);
    }
    @DeleteMapping("/{id}")
    public void deleteReduction(@PathVariable(name = "id")Long id)
    {
        this.reductionService.deleteReduction(id);
    }
}
