package com.core.movies.exception;
public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException(String title) {
        super("Movie not found with title: " + title);
    }
}