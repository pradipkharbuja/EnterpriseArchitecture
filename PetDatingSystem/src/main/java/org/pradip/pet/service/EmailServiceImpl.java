package org.pradip.pet.service;

import org.pradip.pet.email.InstantEmail;
import org.pradip.pet.model.EmailOwner;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailServiceImpl implements EmailService {

	@Autowired
	private InstantEmail instantEmail;

	@Override
	public void sendInstantEmail(EmailOwner emailOwner) {
		instantEmail.sendEmail(emailOwner);
	}

}
