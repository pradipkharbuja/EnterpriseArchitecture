package org.pradip.pet.email;

import java.util.List;

import org.pradip.pet.model.EmailOwner;
import org.pradip.pet.service.EmailOwnerService;
import org.springframework.beans.factory.annotation.Autowired;

public class ScheduledEmail {

	@Autowired
	private EmailOwnerService emailOwnerService;

	@Autowired
	private InstantEmail instantEmail;

	public void sendEmail() {

		List<EmailOwner> emailOwners = emailOwnerService.getUnSentRecords();
		for (EmailOwner emailOwner : emailOwners) {
			instantEmail.sendEmail(emailOwner);
		}
	}

}
