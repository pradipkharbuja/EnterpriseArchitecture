package org.ea.lab3.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	private int id;

	private String name;

	@OneToMany
	private List<Reservation> reservation;
}
