package edu.mum.movie.model;

import java.util.List;

import edu.mum.movie.data.Movie;


public interface IMovieDao {

	public abstract List<Movie> getAll();

	public abstract void add(Movie Movie);

	public abstract Movie get(int id);

	public abstract void update(int MovieId, Movie Movie);

	public abstract void delete(int MovieId);

}