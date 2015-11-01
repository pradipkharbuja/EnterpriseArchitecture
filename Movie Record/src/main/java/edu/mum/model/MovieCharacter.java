package edu.mum.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MovieCharacter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieCharacterId;
	
	private String name;

	public MovieCharacter() {
		super();
	}

	public MovieCharacter(String name) {
		super();
		this.name = name;
	}

	public int getMovieCharacterId() {
		return movieCharacterId;
	}

	public void setMovieCharacterId(int movieCharacterId) {
		this.movieCharacterId = movieCharacterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
