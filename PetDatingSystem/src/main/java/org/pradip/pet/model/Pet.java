package org.pradip.pet.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int petId;

	@OneToOne
	@JoinColumn(name = "breedId")
	@NotNull(message = "Please select the breed.")
	private Breed breed;

	@OneToOne
	@JoinColumn(name = "ownerId")
	private Owner owner;

	@NotEmpty(message = "Please enter the pet name.")
	private String petName;

	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] petPhoto;

	@OneToMany(mappedBy = "pet")
	private List<Comment> comments = new ArrayList<>();

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public Breed getBreed() {
		return breed;
	}

	public void setBreed(Breed breed) {
		this.breed = breed;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public byte[] getPetPhoto() {
		return petPhoto;
	}

	public void setPetPhoto(byte[] petPhoto) {
		this.petPhoto = petPhoto;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Pet Id: " + getPetId() + " Pet Name: " + getPetName();
	}
}
