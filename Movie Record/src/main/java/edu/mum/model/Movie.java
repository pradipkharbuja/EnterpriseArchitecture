package edu.mum.model;

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

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieId;

	private String name;

	@Enumerated(EnumType.STRING)
	@ElementCollection
	@JoinTable(joinColumns = { @JoinColumn(name = "movie_id") })
	private List<Genre> genres;

	private double rating;
	private int year;

	@ManyToMany(cascade = { CascadeType.PERSIST })
	@JoinTable(joinColumns = { @JoinColumn(name = "movie_id") }, inverseJoinColumns = {
			@JoinColumn(name = "artist_id") })
	private List<Artist> artists = new ArrayList<>();

	@ManyToMany(cascade = { CascadeType.PERSIST })
	@JoinTable(joinColumns = { @JoinColumn(name = "movie_id") }, inverseJoinColumns = {
			@JoinColumn(name = "moviecharacter_id") })
	private List<MovieCharacter> movieCharacters = new ArrayList<>();

	@ManyToMany(cascade = { CascadeType.PERSIST })
	@JoinTable(joinColumns = { @JoinColumn(name = "movie_id") }, inverseJoinColumns = {
			@JoinColumn(name = "director_id") })
	private List<Director> directors = new ArrayList<>();

	// Not implemented
	private byte[] poster;

	private String summary;

	@ElementCollection
	@JoinTable(joinColumns = { @JoinColumn(name = "movie_id") })
	private List<String> comments = new ArrayList<>();

	public Movie() {
		super();
	}

	public Movie(String name, double rating, int year, List<Genre> genres, List<Artist> artists,
			List<MovieCharacter> movieCharacters, List<Director> directors) {
		super();
		this.name = name;
		this.genres = genres;
		this.rating = rating;
		this.year = year;
		this.artists = artists;
		this.movieCharacters = movieCharacters;
		this.directors = directors;
	}

	public Movie(String name, List<Artist> artists) {
		super();
		this.name = name;
		this.artists = artists;
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

	public List<MovieCharacter> getMovieCharacters() {
		return movieCharacters;
	}

	public void setMovieCharacters(List<MovieCharacter> movieCharacters) {
		this.movieCharacters = movieCharacters;
	}

	public List<Director> getDirectors() {
		return directors;
	}

	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}

	public byte[] getPoster() {
		return poster;
	}

	public void setPoster(byte[] poster) {
		this.poster = poster;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Movie Name: " + name + " Year: " + year + " Rating: " + rating + " Genre: " + genres;
	}
}
