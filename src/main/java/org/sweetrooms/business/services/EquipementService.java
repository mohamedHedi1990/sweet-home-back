package org.sweetrooms.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.sweetrooms.persistence.entities.Equipement;
import org.sweetrooms.persistence.repositories.EquipementRepository;

import java.util.List;

@Service
public class EquipementService {
    @Autowired
    EquipementRepository equipementRepository;

    public List<Equipement> getAllEquipements()
    {
        return this.equipementRepository.findAll();
    }

    public Equipement getEquipementById(Long id)
    {
        return this.equipementRepository.getById(id);
    }
    public Equipement saveEquipement(Equipement equipement)
    {
        return this.equipementRepository.save(equipement);
    }
    public void deleteEquipement(Long id)
    {
        this.equipementRepository.deleteById(id);
    }
}
