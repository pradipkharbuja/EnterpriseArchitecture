package org.pradip.pet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PetType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int petTypeId;

	private String petType;

	public int getPetTypeId() {
		return petTypeId;
	}

	public void setPetTypeId(int petTypeId) {
		this.petTypeId = petTypeId;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}
}
