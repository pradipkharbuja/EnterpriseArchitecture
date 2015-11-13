package org.pradip.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ownerId;

	private String ownerName;
	private String userName;
	private String password;
	private String city;

	@OneToMany(mappedBy = "owner")
	private List<Pet> pets = new ArrayList<>();

	@OneToMany(mappedBy = "owner")
	private List<Comment> comments = new ArrayList<>();

}
