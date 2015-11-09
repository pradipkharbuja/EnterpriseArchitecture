package edu.mum.movie.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping(value= "/movies/add", method = RequestMethod.GET)
	public String addMovie(){
		return FOLDER + "addMovie";
	}
	
	@RequestMapping(value= "/movies/add", method = RequestMethod.POST)
	public String addMoviePost(Movie movie){
		movieDao.add(movie);
		return FOLDER + "addMovie";
	}
}
