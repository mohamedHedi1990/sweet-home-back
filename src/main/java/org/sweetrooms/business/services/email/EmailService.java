package org.sweetrooms.business.services.email;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.sweetrooms.utils.EmailSender;
import org.sweetrooms.utils.MailingConstants;
import org.thymeleaf.context.Context;

@Service
public class EmailService {
	@Autowired
	private EmailSender emailSender;

	@Value("${sweetrooms.app.base-url}")
	private String baseUrl;

	private static final Logger LOG = LoggerFactory.getLogger(EmailService.class);

	public EmailService() {
	}

	@Async
	public void sendMessage(String context, String fullName, String email, Map<String, String> extraInformations) {
		Context replacements = new Context();
		replacements.setVariable("title", getTitle(context));
		replacements.setVariable("body", getBody(context, extraInformations));
		replacements.setVariable("link", getLink(context, extraInformations));
		replacements.setVariable("fullName", fullName);
		String subject = getSubject(context);

		try {
			// maintenant on a un seul contexte => un seul template
			emailSender.sendSimpleMail(replacements, MailingConstants.TEMPLATE_FORGOT_PASSWORD, subject, email, true);
		} catch (MessagingException | UnsupportedEncodingException e) {
			LOG.error(e.getMessage(), e);
		}
	}

	private String getSubject(String context) {
		switch (context) {
		case MailingConstants.FORGOT_PASSWORD_CONTEXT:
			return MailingConstants.FORGOT_PASSWORD_SUBECT;
		default:
			return "";
		}
	}

	private String getTitle(String context) {
		switch (context) {
		case MailingConstants.FORGOT_PASSWORD_CONTEXT:
			return MailingConstants.FORGOT_PASSWORD_TITLE;

		default:
			return "";
		}
	}

	private String getBody(String context, Map<String, String> extraInformations) {

		switch (context) {

		case MailingConstants.FORGOT_PASSWORD_CONTEXT:

			return "";

		default:
			return "";
		}
	}

	private String getLink(String context, Map<String, String> extraInformations) {
		switch (context) {
		case MailingConstants.FORGOT_PASSWORD_CONTEXT:
			return baseUrl + "/reset-password?code=" + extraInformations.get(MailingConstants.CODE);

		default:
			return "";
		}
	}
}
