package org.sweetrooms.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sweetrooms.persistence.entities.Reduction;
import org.sweetrooms.persistence.repositories.ReductionRepository;

import java.util.List;

@Service
public class ReductionService {
    @Autowired
    ReductionRepository reductionRepository;

    public List<Reduction> getAllReductions()
    {
        return this.reductionRepository.findAll();
    }

    public Reduction getReductionById(Long id)
    {
        return this.reductionRepository.getById(id);
    }
    public Reduction saveReduction(Reduction reduction)
    {
        return this.reductionRepository.save(reduction);
    }
    public void deleteReduction(Long id)
    {
        this.reductionRepository.deleteById(id);
    }
}
