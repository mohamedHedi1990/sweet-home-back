package org.sweetrooms.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sweetrooms.persistence.entities.Recommandation;
import org.sweetrooms.persistence.repositories.RecommandationRepository;

import java.util.List;

@Service
public class RecommandationService {
    @Autowired
    RecommandationRepository recommandationRepository;

    public List<Recommandation> getAllRecommandations()
    {
        return this.recommandationRepository.findAll();
    }

    public Recommandation getRecommandationById(Long id)
    {
        return this.recommandationRepository.getById(id);
    }
    public Recommandation saveRecommandation(Recommandation recommandation)
    {
        return this.recommandationRepository.save(recommandation);
    }
    public void deleteRecommandation(Long id)
    {
        this.recommandationRepository.deleteById(id);
    }
}
