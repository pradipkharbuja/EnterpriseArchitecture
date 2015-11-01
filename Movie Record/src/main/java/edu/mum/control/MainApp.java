package edu.mum.control;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.mum.model.Artist;
import edu.mum.model.Director;
import edu.mum.model.Genre;
import edu.mum.model.Movie;
import edu.mum.model.MovieCharacter;

public class MainApp {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static void main(String[] args) {
		EntityTransaction entityTransaction = null;

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("cs544_week1");
			entityManager = entityManagerFactory.createEntityManager();

			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();

			addMovies();

			listMoviesAndArtist();
			listMovieByCriteria();

			entityTransaction.commit();
		} catch (Exception ex) {
			if (entityTransaction != null && entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
			ex.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
			entityManagerFactory.close();
		}

	}

	public static void addMovies() {
		Artist a1 = new Artist("James Bond", "19/10/1980", "USA");
		Artist a2 = new Artist("Julia Roberts", "15/1/1987", "UK");
		Artist a3 = new Artist("Will Smith", "29/04/1984", "Australia");

		Director d1 = new Director("J.J. Abrams");
		Director d2 = new Director("Barry Levinson");

		MovieCharacter m1 = new MovieCharacter("Captain Sparrow");
		MovieCharacter m2 = new MovieCharacter("Salsa");

		Movie movie1 = new Movie("Casino Royal 007", 4, 2007, Arrays.asList(Genre.ACTION, Genre.SCFI),
				Arrays.asList(a1, a2), Arrays.asList(m1), Arrays.asList(d1, d2));
		Movie movie2 = new Movie("The Bourne Legacy", 5, 2012, Arrays.asList(Genre.ACTION), Arrays.asList(a1, a2, a3),
				Arrays.asList(m1, m2), Arrays.asList(d1));

		entityManager.persist(movie1);
		entityManager.persist(movie2);
	}

	public static void listMoviesAndArtist() {

		List<Movie> movies = entityManager.createQuery("FROM Movie", Movie.class).getResultList();

		System.out.println("List all Movies and Artist: ");
		for (Movie movie : movies) {
			System.out.println(movie);
		}
	}

	public static void listMovieByCriteria() {
		Query query = entityManager.createQuery("FROM Movie WHERE rating = :rating AND year = :year", Movie.class);
		query.setParameter("rating", 4.0);
		query.setParameter("year", 2007);

		List<Movie> movies = query.getResultList();

		System.out.println("List all Movies and Artist searched by rating and year: ");
		for (Movie movie : movies) {
			System.out.println(movie);
		}
	}
}
