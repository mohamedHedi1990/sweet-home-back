package org.sweetrooms.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.sweetrooms.client.dtos.request.UserRequest;
import org.sweetrooms.enumeration.RoleCode;
import org.sweetrooms.persistence.entities.Owner;
import org.sweetrooms.persistence.entities.User;
import org.sweetrooms.persistence.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;
    
    @Autowired
    private LodgerService lodgerService;
    
    @Autowired
    private OwnerService ownerService;

    public List<User> getAllUsers()
    {
        return this.userRepository.findAll();
    }

    public User getUserById(Long id)
    {
        return this.userRepository.getById(id);
    }
    public User saveUser(User user)
    {
        user.setUserPassword(encoder.encode(user.getUserPassword()));
        return this.userRepository.save(user);
    }
    public void deleteUser(Long id)
    {
        this.userRepository.deleteById(id);
    }

	public Boolean saveUser(UserRequest user) {
        System.out.println("UserRequest : "+user.toString());
		if(user.getUserType() == RoleCode.OWNER) {
			return this.ownerService.saveOwner(user);
		} else if(user.getUserType() == RoleCode.LODGER) {
			return this.lodgerService.saveLodger(user);
		}

		return false;
	
	}
}
