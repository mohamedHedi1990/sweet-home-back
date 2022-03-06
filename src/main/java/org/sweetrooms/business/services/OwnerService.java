package org.sweetrooms.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sweetrooms.persistence.entities.Owner;
import org.sweetrooms.persistence.repositories.OwnerRepository;

import java.util.List;

@Service
public class OwnerService {
    @Autowired
    OwnerRepository ownerRepository;

    public List<Owner> getAllOwners()
    {
        return this.ownerRepository.findAll();
    }

    public Owner getOwnerById(Long id)
    {
        return this.ownerRepository.getById(id);
    }
    public Owner saveOwner(Owner owner)
    {
        return this.ownerRepository.save(owner);
    }
    public void deleteOwner(Long id)
    {
        this.ownerRepository.deleteById(id);
    }
}
