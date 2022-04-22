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
    public Boolean saveLodger(UserRequest lodgerIn)
    {
    	Lodger lodger = new Lodger();
    	lodger.setUserId(lodgerIn.getUserId());
    	lodger.setProvider(lodgerIn.getProvider());
    	lodger.setUserAddress(lodgerIn.getUserAddress() != null ? AddressMapper.toAddress(lodgerIn.getUserAddress()) : null);
    	lodger.setUserBirthDate(lodgerIn.getUserBirthDate());
    	lodger.setUserEmail(lodgerIn.getUserEmail());
    	lodger.setUserFirstName(lodgerIn.getUserFirstName());
    	lodger.setUserLastName(lodgerIn.getUserLastName());
    	lodger.setUserLogin(lodgerIn.getUserLogin());
    	lodger.setUserPassword(encoder.encode(lodgerIn.getUserPassword()));
    	
    	Role lodgerRole = this.roleRepository.findByRoleCode(RoleCode.LODGER);
    	lodger.setUserRole(lodgerRole);
    	lodger.setUserIsActif(true);
    	lodger.setUserDateInscription(new Date());
        System.out.println("Lodger to save : "+lodger.getUserLogin()+ " "+lodger.getUserAddress());
        try {
            this.lodgerRepository.save(lodger);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public void deleteLodger(Long id)
    {
        this.lodgerRepository.deleteById(id);
    }
}
