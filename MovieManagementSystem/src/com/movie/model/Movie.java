package com.movie.model;

import com.movie.exception.InvalidMovieException;

public class Movie {
    private final int id;
    private final String title;
    private final Genre genre;
    private final int releaseYear;
    private final double rating;
    private final MovieStatus status;

    public Movie(int id, String title, Genre genre, int releaseYear, double rating, MovieStatus status) {
        if (id <= 0) {
            throw new InvalidMovieException("Movie ID must be positive.");
        }
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public double getRating() {
        return rating;
    }

    public MovieStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format("#%d | %s | %s | %d | %.1f/10 | %s",
                id, title, genre, releaseYear, rating, status);
    }
}
