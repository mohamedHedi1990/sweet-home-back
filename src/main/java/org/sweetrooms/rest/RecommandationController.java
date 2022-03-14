package org.sweetrooms.rest;

//import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sweetrooms.business.services.RecommandationService;
import org.sweetrooms.persistence.entities.Recommandation;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/recommandation")
@Tag(description = "Restfull APIs for Recommandation",name = "Recommandation ressource")
public class RecommandationController {
    @Autowired
    RecommandationService recommandationService;
    @Operation(summary = "Get recommandation",
            description = "Provides all available recommandation list")
    @GetMapping("")
    public List<Recommandation> getAllRecommandations()
    {
        return this.recommandationService.getAllRecommandations();
    }
    @Operation(summary = "Get recommandation",
            description = "Provides recommandation by ID")
    @GetMapping("/{id}")
    public Recommandation getRecommandationById(@PathVariable(name = "id") Long id)
    {
        return this.recommandationService.getRecommandationById(id);
    }
    @Operation(summary = "save recommandation",
            description = "save new recommandation")
    @PostMapping("")
    public Recommandation saveRecommandation(@RequestBody Recommandation recommandation)
    {
        return this.recommandationService.saveRecommandation(recommandation);
    }
    @Operation(summary = "Delete recommandation",
            description = "Delete a sp)ecific recommandation by ID")
    @DeleteMapping("/{id}")
    public void deleteRecommandation(@PathVariable(name = "id")Long id)
    {
        this.recommandationService.deleteRecommandation(id);
    }
}
