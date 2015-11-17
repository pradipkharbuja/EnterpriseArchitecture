package org.pradip.pet.service;

import java.util.List;

import org.pradip.pet.model.EmailOwner;

public interface EmailOwnerService {

	public void saveEmailRecord(EmailOwner emailOwner);

	public List<EmailOwner> getUnSentRecords();
	
	public void updateEmailRecord(EmailOwner emailOwner);
}
