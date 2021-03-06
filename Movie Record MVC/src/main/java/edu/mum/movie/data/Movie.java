package edu.mum.movie.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieId;

	@NotEmpty(message = "Movie name cannot be empty.")
	private String name;

	@Enumerated(EnumType.STRING)
	@ElementCollection
	@JoinTable(joinColumns = { @JoinColumn(name = "movie_id") })
	private List<Genre> genres;

	@Range(min = 0, max = 5)
	private double rating;

	@Range(min = 1990, max = 2020)
	private int year;

	@ManyToMany(cascade = { CascadeType.PERSIST })
	@JoinTable(joinColumns = { @JoinColumn(name = "movie_id") }, inverseJoinColumns = {
			@JoinColumn(name = "artist_id") })
	private List<Artist> artists = new ArrayList<>();

	// @ManyToMany(cascade = { CascadeType.PERSIST })
	// @JoinTable(joinColumns = { @JoinColumn(name = "movie_id") },
	// inverseJoinColumns = {
	// @JoinColumn(name = "moviecharacter_id") })
	// private List<MovieCharacter> movieCharacters = new ArrayList<>();

	@ManyToMany(cascade = { CascadeType.PERSIST })
	@JoinTable(joinColumns = { @JoinColumn(name = "movie_id") }, inverseJoinColumns = {
			@JoinColumn(name = "director_id") })
	private List<Director> directors = new ArrayList<>();

	// // Not implemented
	// private byte[] poster;

	private String summary;

	// @ElementCollection
	// @JoinTable(joinColumns = { @JoinColumn(name = "movie_id") })
	// private List<String> comments = new ArrayList<>();

	public Movie() {
		super();
	}

	public Movie(String name, double rating, int year) {
		super();
		this.name = name;
		this.rating = rating;
		this.year = year;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<Artist> getArtists() {
		return artists;
	}

	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}
	//
	// public List<MovieCharacter> getMovieCharacters() {
	// return movieCharacters;
	// }
	//
	// public void setMovieCharacters(List<MovieCharacter> movieCharacters) {
	// this.movieCharacters = movieCharacters;
	// }

	public List<Director> getDirectors() {
		return directors;
	}

	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Movie Name: " + name + " Year: " + year + " Rating: " + rating + " Genre: ";
	}
}
