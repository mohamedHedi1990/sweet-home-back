package org.sweetrooms.business.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sweetrooms.business.mappers.EquipementMapper;
import org.sweetrooms.dtos.EquipementDto;
import org.sweetrooms.persistence.entities.Equipement;
import org.sweetrooms.persistence.repositories.EquipementRepository;

@Service
public class EquipementService {
    @Autowired
    EquipementRepository equipementRepository;

    public List<EquipementDto> getAllEquipements()
    {
        return this.equipementRepository.findAll().stream().map(equipment -> EquipementMapper.toEquipementDto(equipment)).collect(Collectors.toList());
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
