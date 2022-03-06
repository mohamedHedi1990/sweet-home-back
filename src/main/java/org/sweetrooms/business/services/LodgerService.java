package org.sweetrooms.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sweetrooms.persistence.entities.Lodger;
import org.sweetrooms.persistence.repositories.LodgerRepository;

import java.util.List;

@Service
public class LodgerService {
    @Autowired
    LodgerRepository lodgerRepository;

    public List<Lodger> getAllLodgers()
    {
        return this.lodgerRepository.findAll();
    }

    public Lodger getLodgerById(Long id)
    {
        return this.lodgerRepository.getById(id);
    }
    public Lodger saveLodger(Lodger lodger)
    {
        return this.lodgerRepository.save(lodger);
    }
    public void deleteLodger(Long id)
    {
        this.lodgerRepository.deleteById(id);
    }
}
