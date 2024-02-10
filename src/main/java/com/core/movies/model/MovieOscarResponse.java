package com.core.movies.model;

public class MovieOscarResponse {
    private final String message;
    private final Movie movie;

    public MovieOscarResponse(String message, Movie movie) {
        this.message = message;
        this.movie = movie;
    }

    public String getMessage() {
        return message;
    }

    public Movie getMovie() {
        return movie;
    }
}