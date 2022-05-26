package org.sweetrooms.business.services;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sweetrooms.business.services.email.EmailService;
import org.sweetrooms.persistence.entities.PasswordResetToken;
import org.sweetrooms.persistence.entities.User;
import org.sweetrooms.persistence.repositories.PasswordTokenRepository;
import org.sweetrooms.persistence.repositories.UserRepository;
import org.sweetrooms.utils.MailingConstants;

@Service
public class SecurityService {

	@Autowired
	private PasswordTokenRepository passwordTokenRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EmailService mailSender;

	public void createPasswordResetTokenForUser(User user, String token) {
		PasswordResetToken myToken = new PasswordResetToken(token, user);
		this.passwordTokenRepository.save(myToken);
	}

	public String validatePasswordResetToken(String token) {
		final PasswordResetToken passToken = passwordTokenRepository.findByToken(token);

		return !isTokenFound(passToken) ? "invalidToken" : isTokenExpired(passToken) ? "expired" : null;
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
