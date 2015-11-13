package org.pradip.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentId;

	private String comments;

	@Temporal(TemporalType.TIMESTAMP)
	private Date commentDate;

	@OneToOne
	@JoinColumn(name = "ownerId")
	private Owner owner;

	@OneToOne
	@JoinColumn(name = "petId")
	private Pet pet;
}
