package com.movie.service;

import com.movie.model.Genre;
import com.movie.model.Movie;
import com.movie.model.MovieStatus;
import com.movie.repository.MovieRepository;
import com.movie.util.IdGenerator;

import java.util.List;

public class MovieService {
    private final MovieRepository repository;
    private final MovieValidationService validator;
    private final IdGenerator idGenerator;

    public MovieService(MovieRepository repository, MovieValidationService validator, IdGenerator idGenerator) {
        this.repository = repository;
        this.validator = validator;
        this.idGenerator = idGenerator;
    }

    public Movie addMovie(String title, Genre genre, int releaseYear, double rating, MovieStatus status) {
        validator.validate(title, genre, releaseYear, rating, status);
        Movie movie = new Movie(idGenerator.nextId(), title.trim(), genre, releaseYear, rating, status);
        return repository.create(movie);
    }

    public Movie getMovie(int id) {
        return repository.getById(id);
    }

    public List<Movie> getAllMovies() {
        return repository.getAll();
    }

    public Movie updateMovie(int id, String title, Genre genre, int releaseYear,
            double rating, MovieStatus status) {
        validator.validate(title, genre, releaseYear, rating, status);
        Movie replacement = new Movie(id, title.trim(), genre, releaseYear, rating, status);
        return repository.update(id, replacement);
    }

    public void deleteMovie(int id) {
        repository.delete(id);
    }
}
