package org.ea.lab3.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	private int id;

	@Column(unique = true)
	private String isbn;

	private String title;
	private String author;

	@ManyToOne
	@JoinTable(name = "book_publisher", joinColumns = { @JoinColumn(name = "book_id") }, inverseJoinColumns = {
			@JoinColumn(name = "publisher_id") })
	private Publisher publisher;

}
