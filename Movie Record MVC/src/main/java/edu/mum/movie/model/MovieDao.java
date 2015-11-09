package edu.mum.movie.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.mum.movie.controller.NoSuchResourceException;
import edu.mum.movie.data.Artist;
import edu.mum.movie.data.Director;
import edu.mum.movie.data.Genre;
import edu.mum.movie.data.Movie;
import edu.mum.movie.data.MovieCharacter;

public class MovieDao implements IMovieDao {

	private static int idCount = 1;
	private Map<Integer, Movie> movies = new HashMap<>();

	public MovieDao() {

		Artist a1 = new Artist("James Bond", "19/10/1980", "USA");
		Artist a2 = new Artist("Julia Roberts", "15/1/1987", "UK");
		Artist a3 = new Artist("Will Smith", "29/04/1984", "Australia");

		Director d1 = new Director("J.J. Abrams");
		Director d2 = new Director("Barry Levinson");

		MovieCharacter m1 = new MovieCharacter("Captain Sparrow");
		MovieCharacter m2 = new MovieCharacter("Salsa");

//		Movie movie1 = new Movie("Casino Royal 007", 4, 2007, Arrays.asList(Genre.ACTION, Genre.SCFI),
//				Arrays.asList(a1, a2), Arrays.asList(m1), Arrays.asList(d1, d2));
//		Movie movie2 = new Movie("The Bourne Legacy", 5, 2012, Arrays.asList(Genre.ACTION), Arrays.asList(a1, a2, a3),
//				Arrays.asList(m1, m2), Arrays.asList(d1));
//
//		add(movie1);
//		add(movie2);

	}

	@Override
	public List<Movie> getAll() {
		return new ArrayList<Movie>(movies.values());
	}

	@Override
	public void add(Movie movie) {

		movie.setMovieId(idCount);
		movies.put(idCount, movie);
		idCount++;
	}

	@Override
	public Movie get(int id) {
		Movie result = movies.get(id);

		if (result == null) {
			throw new NoSuchResourceException("Book", id);
		}

		return result;
	}

	@Override
	public void update(int movieId, Movie movie) {
		movies.put(movieId, movie);

	}

	@Override
	public void delete(int movieId) {
		Movie removed = movies.remove(movieId);
		if (removed == null) {
			throw new NoSuchResourceException("Movie", movieId);
		}
	}

}
