package edu.mum.movie.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.movie.data.Artist;
import edu.mum.movie.data.Director;
import edu.mum.movie.data.Genre;
import edu.mum.movie.data.Movie;
import edu.mum.movie.model.IMovieDao;

@Controller
public class MovieController {

	private final String FOLDER = "movie/";

	@Resource
	private IMovieDao movieDao;

	@RequestMapping(value = "/")
	public String index() {
		return "redirect:/movies";
	}

	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("movies", movieDao.getAll());
		return FOLDER + "movieList";
	}

	@RequestMapping(value = "/movies/delete/{id}", method = RequestMethod.GET)
	public String deleteMovie(@PathVariable int id) {
		movieDao.delete(id);
		return "redirect:/movies";
	}

	@RequestMapping(value = "/movies/add", method = RequestMethod.GET)
	public String addMovie(Movie movie, Model model) {
		model.addAttribute("genresList", Genre.getAllGenres());
		model.addAttribute("directorsList", getAllDirectors());
		model.addAttribute("artistsList", getAllArtists());
		return FOLDER + "addUpdateMovie";
	}

	@RequestMapping(value = "/movies/add", method = RequestMethod.POST)
	public String addMoviePost(Model model, @Valid Movie movie, BindingResult result) {
		if (result.hasErrors()) {
			model.addAttribute("genresList", Genre.getAllGenres());
			model.addAttribute("directorsList", getAllDirectors());
			model.addAttribute("artistsList", getAllArtists());
			return FOLDER + "addUpdateMovie";
		} else {
			movieDao.add(movie);
			return "redirect:/movies";
		}
	}

	@RequestMapping(value = "/movies/udpate/{id}", method = RequestMethod.GET)
	public String updateMovie(@PathVariable int id, Model model) {
		// model.addAttribute("genresList", Genre.getAllGenres());
		// model.addAttribute("book", movieDao.get(id));
		return FOLDER + "addUpdateMovie";
	}

	public static List<Director> getAllDirectors() {
		List<Director> directors = new ArrayList<>();
		directors.add(new Director("Chuck"));
		directors.add(new Director("Michelle Jacks"));
		return directors;
	}

	public static List<Artist> getAllArtists() {
		List<Artist> artists = new ArrayList<>();
		artists.add(new Artist("Julia Roberts"));
		artists.add(new Artist("Tom Cruise"));
		return artists;
	}

	// @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	// public String updateBook(@PathVariable int id, Model model) {
	// model.addAttribute("book", bookDao.get(id));
	// return "book/addUpdateBook";
	// }

	// @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	// public String updatePostBook(@Valid Book book, BindingResult result,
	// @PathVariable int id) {
	// if (!result.hasErrors()) {
	// bookDao.update(id, book);
	// return "redirect:/books";
	// } else {
	// return "book/addUpdateBook";
	// }
	// }
}
