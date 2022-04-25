package org.sweetrooms.business.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.sweetrooms.business.mappers.UserMapper;
import org.sweetrooms.client.dtos.request.UserRequest;
import org.sweetrooms.client.dtos.response.UserDetailsResponse;
import org.sweetrooms.enumeration.RoleCode;
import org.sweetrooms.persistence.entities.User;
import org.sweetrooms.persistence.repositories.UserRepository;
import org.sweetrooms.utils.SecurityUtil;

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

	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}

	public User getUserById(Long id) {
		return this.userRepository.getById(id);
	}

	public User saveUser(User user) {
		user.setUserPassword(encoder.encode(user.getUserPassword()));
		return this.userRepository.save(user);
	}

	public void deleteUser(Long id) {
		this.userRepository.deleteById(id);
	}

	public void saveUser(UserRequest user) {
		if (user.getUserType() == RoleCode.OWNER) {
			this.ownerService.saveOwner(user);
		} else if (user.getUserType() == RoleCode.LODGER) {
			this.lodgerService.saveLodger(user);
		}

	}

	public UserDetailsResponse getUserInfo() {
		User user = getCurrentUser();
		return user != null ? UserMapper.toUserDetailsResponse(getCurrentUser()) : null;
	}

	public User getCurrentUser() {
		Long currentuserId = SecurityUtil.getCurrentUserId();
		User user = userRepository.findById(currentuserId).orElse(null);
		return user;
	}
}
