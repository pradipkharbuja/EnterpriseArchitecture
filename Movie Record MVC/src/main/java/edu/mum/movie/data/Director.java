package edu.mum.movie.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Director {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int directorId;

	private String directorName;

	@ManyToMany(mappedBy = "directors")
	private List<Movie> movies = new ArrayList<>();

	public Director() {
		super();
	}

	public Director(String directorName) {
		super();
		this.directorName = directorName;
	}

	public int getDirectorId() {
		return directorId;
	}

	public void setDirectorId(int directorId) {
		this.directorId = directorId;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getDirectorName();
	}
}
