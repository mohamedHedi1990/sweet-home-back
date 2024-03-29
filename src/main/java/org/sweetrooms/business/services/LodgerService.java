package org.sweetrooms.business.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.sweetrooms.business.mappers.AddressMapper;
import org.sweetrooms.client.dtos.request.UserRequest;
import org.sweetrooms.enumeration.RoleCode;
import org.sweetrooms.persistence.entities.Lodger;
import org.sweetrooms.persistence.entities.Role;
import org.sweetrooms.persistence.repositories.LodgerRepository;
import org.sweetrooms.persistence.repositories.RoleRepository;

@Service
public class LodgerService {
    @Autowired
    LodgerRepository lodgerRepository;
    
    @Autowired
	private RoleRepository roleRepository;
    
    @Autowired
    PasswordEncoder encoder;

    public List<Lodger> getAllLodgers()
    {
        return this.lodgerRepository.findAll();
    }

    public Lodger getLodgerById(Long id)
    {
        return this.lodgerRepository.getById(id);
    }
    public Lodger findByUserEmail(String email)
    {
        return this.lodgerRepository.findByUserEmail(email);
    }
    public Lodger saveLodger(UserRequest lodgerIn)
    {
    	Lodger lodger = new Lodger();
    	lodger.setProvider(lodgerIn.getProvider());
    	lodger.setUserAddress(lodgerIn.getUserAddress() != null ? AddressMapper.toAddress(lodgerIn.getUserAddress()) : null);
    	lodger.setUserBirthDate(lodgerIn.getUserBirthDate());
    	lodger.setUserEmail(lodgerIn.getUserEmail());
    	lodger.setUserFirstName(lodgerIn.getUserFirstName());
    	lodger.setUserLastName(lodgerIn.getUserLastName());
    	lodger.setUserLogin(lodgerIn.getUserLogin());
    	lodger.setUserPassword(encoder.encode(lodgerIn.getUserPassword()));
    	lodger.setUserPhoneNumber(lodgerIn.getUserPhoneNumber());
    	Role lodgerRole = this.roleRepository.findByRoleCode(RoleCode.LODGER);
    	lodger.setUserRole(lodgerRole);
    	lodger.setUserIsActif(true);
    	lodger.setUserDateInscription(new Date());
        return this.lodgerRepository.save(lodger);
    }
    public void deleteLodger(Long id)
    {
        this.lodgerRepository.deleteById(id);
    }
}
