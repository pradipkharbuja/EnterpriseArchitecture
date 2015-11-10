package edu.mum.movie.data;

import java.util.ArrayList;
import java.util.List;

public enum Genre {
	ACTION, ANIMATED, SCFI, HORROR, FANTASY;

	public static List<Genre> getAllGenres() {
		List<Genre> genres = new ArrayList<>();
		genres.add(ACTION);
		genres.add(ANIMATED);

		genres.add(SCFI);
		genres.add(HORROR);
		genres.add(FANTASY);

		return genres;
	}
}
