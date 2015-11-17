package org.pradip.pet.service;

import java.util.List;

import org.pradip.pet.dao.EmailOwnerDAO;
import org.pradip.pet.model.EmailOwner;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailOwnerServiceImpl implements EmailOwnerService {

	@Autowired
	private EmailOwnerDAO emailOwnerDAO;

	@Override
	public void saveEmailRecord(EmailOwner emailOwner) {
		emailOwnerDAO.saveEmailRecord(emailOwner);
	}

	@Override
	public List<EmailOwner> getUnSentRecords() {
		return emailOwnerDAO.getUnSentRecords();
	}

	@Override
	public void updateEmailRecord(EmailOwner emailOwner) {
		emailOwnerDAO.updateEmailRecord(emailOwner);		
	}

}
