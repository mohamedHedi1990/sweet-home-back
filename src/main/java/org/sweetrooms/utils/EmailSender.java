package org.sweetrooms.utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EmailSender {

	private static final String SENDER = "spring.mail.username";
	private static final String APP_NAME = "sweetrooms.app.name";
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private SpringTemplateEngine emailTemplateEngine;
	@Autowired
	private Environment environment;

	public EmailSender() {
		
	}

	@Async
	public void sendSimpleMail(final Context ctx, final String template, final String subject,
			final String recipientEmail, boolean isHtml) throws MessagingException, UnsupportedEncodingException {

		MimeMessage mimeMessage = this.mailSender.createMimeMessage();
		MimeMessageHelper message = new MimeMessageHelper(mimeMessage, StandardCharsets.UTF_8.toString());
		message.setSubject(subject);
		message.setFrom(
				new InternetAddress(this.environment.getProperty(SENDER), this.environment.getProperty(APP_NAME)));
		message.setTo(recipientEmail);

		String htmlContent = this.emailTemplateEngine.process(template, ctx);
		message.setText(htmlContent, isHtml);

		this.mailSender.send(mimeMessage);

	}

}
