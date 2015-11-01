package edu.mum.model;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int artistId;

	private String name;

	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	private String placeOfBirth;
	private String biography;

	// Not implemented
	private byte[] picture;

	@ManyToMany(mappedBy = "artists")
	private List<Movie> movies = new ArrayList<>();

	private final static DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);

	public Artist() {
		super();
	}

	public Artist(String name, String dateOfBirth, String placeOfBirth) {
		super();
		this.name = name;
		setDateOfBirth(dateOfBirth);
		this.placeOfBirth = placeOfBirth;
	}

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateOfBirth() {
		return df.format(dateOfBirth);
	}

	public void setDateOfBirth(String dateOfBirth) {
		try {
			this.dateOfBirth = df.parse(dateOfBirth);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
}
