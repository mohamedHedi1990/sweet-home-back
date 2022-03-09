package org.sweetrooms.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sweetrooms.business.services.ReductionService;
import org.sweetrooms.persistence.entities.Reduction;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/reduction")
@Tag(description = "Restfull APIs for Reduction",name = "reduction ressource")
public class ReductionController {

    @Autowired
    ReductionService reductionService;
    @Operation(summary = "Get reductions",
            description = "Provides all available reductions list")
    @GetMapping("")
    public List<Reduction> getAllReductions()
    {
        return this.reductionService.getAllReductions();
    }
    @Operation(summary = "Get reduction",
            description = "Provides reduction By ID")
    @GetMapping("/{id}")
    public Reduction getReductionById(@PathVariable(name = "id") Long id)
    {
        return this.reductionService.getReductionById(id);
    }
    @Operation(summary = "save reduction",
            description = "save new reduction")
    @PostMapping("")
    public Reduction saveReduction(Reduction reduction)
    {
        return this.reductionService.saveReduction(reduction);
    }
    @Operation(summary = "delete reduction",
            description = "Delete specifiv reduction By ID")
    @DeleteMapping("/{id}")
    public void deleteReduction(@PathVariable(name = "id")Long id)
    {
        this.reductionService.deleteReduction(id);
    }
}
