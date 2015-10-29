package org.ea.lab3.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Office {
	@Id
	private int id;

	@Column(name = "room_number")
	private String roomNumber;
	private String building;
	
	@OneToMany(mappedBy="office")
	private List<Employee> employees;
}
