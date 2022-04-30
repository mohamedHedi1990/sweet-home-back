package org.sweetrooms.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sweetrooms.persistence.entities.Announcement;
import org.sweetrooms.persistence.entities.EquipementAnnoncement;
import org.sweetrooms.persistence.repositories.EquipementAnnoncementRepository;

@Service
public class EquipementAnnocementService {
    @Autowired
    EquipementAnnoncementRepository equipementRepository;

    public List<EquipementAnnoncement> getAllEquipements()
    {
        return this.equipementRepository.findAll();
    }

    public EquipementAnnoncement getEquipementById(Long id)
    {
        return this.equipementRepository.getById(id);
    }
    public EquipementAnnoncement saveEquipement(EquipementAnnoncement equipement)
    {
        return this.equipementRepository.save(equipement);
    }
    public void deleteEquipement(Long id)
    {
        this.equipementRepository.deleteById(id);
    }
    public List<EquipementAnnoncement> findByAnnoucement(Announcement Annoncement){
    	return this.equipementRepository.findByAnnouncement(Annoncement);
    }
}
