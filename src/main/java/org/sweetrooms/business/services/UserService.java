package org.sweetrooms.business.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.sweetrooms.business.mappers.AddressMapper;
import org.sweetrooms.business.mappers.UserMapper;
import org.sweetrooms.business.services.email.EmailService;
import org.sweetrooms.client.dtos.request.UserRequest;
import org.sweetrooms.client.dtos.response.UserDetailsResponse;
import org.sweetrooms.enumeration.RoleCode;
import org.sweetrooms.enumeration.TokenStatus;
import org.sweetrooms.persistence.entities.PasswordResetToken;
import org.sweetrooms.persistence.entities.User;
import org.sweetrooms.persistence.repositories.PasswordTokenRepository;
import org.sweetrooms.persistence.repositories.UserRepository;
import org.sweetrooms.utils.MailingConstants;
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

	@Autowired
	private PasswordTokenRepository passwordTokenRepository;

	@Autowired
	private EmailService mailSender;
	

	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}

	public User getUserById(Long id) {
		return this.userRepository.getById(id);
	}

	public User saveUser(User user) {
		//user.setUserPassword(encoder.encode(user.getUserPassword()));
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
	public User findUserByEmail(String email) {
		User user= this.lodgerService.findByUserEmail(email);
				if(user==null){
				return this.ownerService.findByUserEmail(email);}
		return user;
	}
	
	public void changeUserPassword(User user, String password) {
	    user.setUserPassword(encoder.encode(password));
	    userRepository.save(user);
	}

	public void patchUser(UserRequest userRequest) {
		User user = getCurrentUser();
		user.setUserFirstName(userRequest.getUserFirstName());
		user.setUserLastName(userRequest.getUserLastName());
		user.setUserBirthDate(userRequest.getUserBirthDate());
		user.setUserEmail(userRequest.getUserEmail());
		user.setUserAddress(userRequest.getUserAddress() != null ? AddressMapper.toAddress(userRequest.getUserAddress()) : null);
		userRepository.save(user);
	}

	public void createPasswordResetTokenForUser(User user, String token) {
		PasswordResetToken myToken = new PasswordResetToken(token, user);
		this.passwordTokenRepository.save(myToken);
	}

	public TokenStatus validatePasswordResetToken(String token) {
		final PasswordResetToken passToken = passwordTokenRepository.findByToken(token);

		return !isTokenFound(passToken) ? TokenStatus.INVALID : isTokenExpired(passToken) ? TokenStatus.EXPIRED : TokenStatus.VALID;
	}

	public boolean forgetPassword(User user) {

		String token = UUID.randomUUID().toString();
		createPasswordResetTokenForUser(user, token);
		Map<String, String> map = new HashMap<>();
		map.put("code", token);
		this.mailSender.sendMessage(MailingConstants.FORGOT_PASSWORD_CONTEXT, user.getUserFirstName(),
				user.getUserEmail(), map);
		return true;
	}

	private boolean isTokenFound(PasswordResetToken passToken) {
		return passToken != null;
	}

	private boolean isTokenExpired(PasswordResetToken passToken) {
		final Calendar cal = Calendar.getInstance();
		return passToken.getExpiryDate().before(cal.getTime());
	}

	public Optional<User> getUserByPasswordResetToken(final String token) {
		return Optional.ofNullable(passwordTokenRepository.findByToken(token).getUser());
	}
}
