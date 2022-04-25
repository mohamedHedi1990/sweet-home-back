package org.sweetrooms.business.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.sweetrooms.business.mappers.AddressMapper;
import org.sweetrooms.client.dtos.request.UserRequest;
import org.sweetrooms.enumeration.RoleCode;
import org.sweetrooms.persistence.entities.Owner;
import org.sweetrooms.persistence.entities.Role;
import org.sweetrooms.persistence.repositories.OwnerRepository;
import org.sweetrooms.persistence.repositories.RoleRepository;

@Service
public class OwnerService {
    @Autowired
    OwnerRepository ownerRepository;
    
    @Autowired
	private RoleRepository roleRepository;
    
    @Autowired
    PasswordEncoder encoder;

    public List<Owner> getAllOwners()
    {
        return this.ownerRepository.findAll();
    }

    public Owner getOwnerById(Long id)
    {
        return this.ownerRepository.getById(id);
    }
    public Owner saveOwner(UserRequest ownerIn)
    {
    	Owner owner = new Owner();
    	owner.setProvider(ownerIn.getProvider());
    	owner.setUserAddress(ownerIn.getUserAddress() != null ? AddressMapper.toAddress(ownerIn.getUserAddress()) : null);
    	owner.setUserBirthDate(ownerIn.getUserBirthDate());
    	owner.setUserEmail(ownerIn.getUserEmail());
    	owner.setUserFirstName(ownerIn.getUserFirstName());
    	owner.setUserLastName(ownerIn.getUserLastName());
    	owner.setUserLogin(ownerIn.getUserLogin());
    	owner.setUserPassword(encoder.encode(ownerIn.getUserPassword()));
    	owner.setUserPhoneNumber(ownerIn.getUserPhoneNumber());
    	
    	Role lodgerRole = this.roleRepository.findByRoleCode(RoleCode.OWNER);
    	owner.setUserRole(lodgerRole);
    	owner.setUserIsActif(true);
    	owner.setUserDateInscription(new Date());
        return this.ownerRepository.save(owner);
    }
    public void deleteOwner(Long id)
    {
        this.ownerRepository.deleteById(id);
    }
}
