package org.ea.lab3.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Publisher {
	@Id
	private int id;
	private String name;
}
