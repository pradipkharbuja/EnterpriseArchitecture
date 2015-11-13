package org.pradip.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int petId;

	@OneToOne
	@JoinColumn(name = "breedId")
	private Owner breed;

	@OneToOne
	@JoinColumn(name = "ownerId")
	private Owner owner;

	private String petName;
	private byte[] petPhoto;

	@OneToMany(mappedBy = "pet")
	private List<Comment> comments = new ArrayList<>();

}
