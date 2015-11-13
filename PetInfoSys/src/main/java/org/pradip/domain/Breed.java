package org.pradip.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Breed {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int breedId;

	@OneToOne
	@JoinColumn(name = "petTypeId")
	private PetType petType;

	private String breedName;

}
