package org.pradip.pet.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ownerId;

	@NotEmpty(message = "Please enter full name.")
	private String ownerName;

	@NotEmpty(message = "Please enter username.")
	@Column(unique = true)
	private String userName;

	@NotEmpty(message = "Please enter password.")
	private String password;

	@NotEmpty(message = "Please enter city.")
	private String city;

	@NotEmpty(message = "Please enter email.")
	@Email(message = "Please enter valid email.")
	@Column(unique = true)
	private String email;

	private boolean instantEmail;

	@OneToMany(mappedBy = "owner")
	private List<Pet> pets = new ArrayList<>();

	@OneToMany(mappedBy = "owner")
	private List<Comment> comments = new ArrayList<>();

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isInstantEmail() {
		return instantEmail;
	}

	public void setInstantEmail(boolean instantEmail) {
		this.instantEmail = instantEmail;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Owner ID: " + getOwnerId() + " Owner Name: " + getOwnerName() + " City: " + getCity() + " Username: "
				+ getUserName();
	}
}
