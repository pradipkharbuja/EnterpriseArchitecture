package org.pradip.pet.dao;

import java.util.List;

import org.pradip.pet.model.EmailOwner;

public interface EmailOwnerDAO {

	public void saveEmailRecord(EmailOwner emailOwner);
	
	public List<EmailOwner> getUnSentRecords();
	
	public void updateEmailRecord(EmailOwner emailOwner);
	
}
