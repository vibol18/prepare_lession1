package com.movie.exception;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(int id) {
        super("No movie found with ID " + id + ".");
    }
}
