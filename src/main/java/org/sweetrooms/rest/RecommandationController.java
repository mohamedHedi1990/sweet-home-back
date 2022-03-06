package org.sweetrooms.rest;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sweetrooms.business.services.RecommandationService;
import org.sweetrooms.persistence.entities.Recommandation;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/recommandation")
@Api(value = "Restfull APIs for recommandation")
public class RecommandationController {
    @Autowired
    RecommandationService recommandationService;
    @GetMapping("")
    public List<Recommandation> getAllRecommandations()
    {
        return this.recommandationService.getAllRecommandations();
    }
    @GetMapping("/{id}")
    public Recommandation getRecommandationById(@PathVariable(name = "id") Long id)
    {
        return this.recommandationService.getRecommandationById(id);
    }
    @PostMapping("")
    public Recommandation saveRecommandation(Recommandation recommandation)
    {
        return this.recommandationService.saveRecommandation(recommandation);
    }
    @DeleteMapping("/{id}")
    public void deleteRecommandation(@PathVariable(name = "id")Long id)
    {
        this.recommandationService.deleteRecommandation(id);
    }
}
