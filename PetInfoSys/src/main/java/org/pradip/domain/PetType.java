package org.pradip.domain;

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
}
