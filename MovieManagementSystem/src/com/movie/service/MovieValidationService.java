package com.movie.service;

import com.movie.exception.InvalidMovieException;
import com.movie.model.Genre;
import com.movie.model.MovieStatus;

import java.time.Year;

public class MovieValidationService {
    public void validate(String title, Genre genre, int releaseYear, double rating, MovieStatus status) {
        if (title == null || title.isBlank()) {
            throw new InvalidMovieException("Title cannot be empty.");
        }
        if (genre == null) {
            throw new InvalidMovieException("Genre is required.");
        }
        int currentYear = Year.now().getValue();
        if (releaseYear < 1888 || releaseYear > currentYear + 5) {
            throw new InvalidMovieException("Release year must be between 1888 and " + (currentYear + 5) + ".");
        }
        if (!Double.isFinite(rating) || rating < 0 || rating > 10) {
            throw new InvalidMovieException("Rating must be a number between 0 and 10.");
        }
        if (status == null) {
            throw new InvalidMovieException("Movie status is required.");
        }
    }
}
