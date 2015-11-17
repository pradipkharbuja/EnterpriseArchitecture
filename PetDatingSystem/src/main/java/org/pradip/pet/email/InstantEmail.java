package org.pradip.pet.email;

import java.util.Date;

import javax.mail.internet.MimeMessage;

import org.pradip.pet.model.EmailOwner;
import org.pradip.pet.service.EmailOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class InstantEmail {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private EmailOwnerService emailOwnerService;

	public void sendEmail(EmailOwner emailOwner) {

		try {
			System.out.println("Sending Email start...");

			String fromAddress = String.format("Pet Dating System<info@petdatingsystem.com>");
			String toAddress = emailOwner.getPet().getOwner().getEmail();

			String subject = emailOwner.getSubject();
			String msgBody = String.format(
					"<html><body>Dear %s, " + "<br><br>%s (%s) has contacted you. Here is the message: "
							+ "<p>%s</p></body></html>",
					emailOwner.getPet().getOwner().getOwnerName(), emailOwner.getContactOwner().getOwnerName(),
					emailOwner.getContactOwner().getEmail(), emailOwner.getMessage());

			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");

			mimeMessage.setContent(msgBody, "text/html");
			helper.setTo(toAddress);
			helper.setSubject(subject);
			helper.setFrom(fromAddress);
			mailSender.send(mimeMessage);

			emailOwner.setHasEmailSent(true);
			emailOwner.setEmailSent(new Date());

			emailOwnerService.updateEmailRecord(emailOwner);

			System.out.println("Email sent...");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
