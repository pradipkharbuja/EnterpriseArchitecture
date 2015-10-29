package org.ea.lab3.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reservation {
	@Id
	private int id;

	@Column(name = "reservation_date")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne
	private Book book;
}
