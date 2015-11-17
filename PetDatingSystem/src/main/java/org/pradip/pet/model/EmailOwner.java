package org.pradip.pet.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class EmailOwner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emailOwnerId;

	@OneToOne
	@JoinColumn(name = "petId")
	private Pet pet;

	private String subject;
	private String message;

	@Temporal(TemporalType.TIMESTAMP)
	private Date emailRequested;

	@Temporal(TemporalType.TIMESTAMP)
	private Date emailSent;

	private boolean hasEmailSent;

	@OneToOne
	@JoinColumn(name = "contactedBy")
	private Owner contactOwner;

	public int getEmailOwnerId() {
		return emailOwnerId;
	}

	public void setEmailOwnerId(int emailOwnerId) {
		this.emailOwnerId = emailOwnerId;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getEmailRequested() {
		return emailRequested;
	}

	public void setEmailRequested(Date emailRequested) {
		this.emailRequested = emailRequested;
	}

	public Date getEmailSent() {
		return emailSent;
	}

	public void setEmailSent(Date emailSent) {
		this.emailSent = emailSent;
	}

	public boolean isHasEmailSent() {
		return hasEmailSent;
	}

	public void setHasEmailSent(boolean hasEmailSent) {
		this.hasEmailSent = hasEmailSent;
	}

	public Owner getContactOwner() {
		return contactOwner;
	}

	public void setContactOwner(Owner contactOwner) {
		this.contactOwner = contactOwner;
	}
}
