package com.core.movies.interfaces;

import com.core.movies.model.Movie;

public interface IOmdbService {
	public Movie fetchMovieByTitleFromApi(String title);

}
