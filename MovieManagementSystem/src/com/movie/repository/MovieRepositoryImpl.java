package com.movie.repository;

import com.movie.exception.MovieNotFoundException;
import com.movie.model.Movie;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MovieRepositoryImpl implements MovieRepository {
    private final Map<Integer, Movie> movies = new LinkedHashMap<>();

    @Override
    public synchronized Movie create(Movie movie) {
        if (movies.containsKey(movie.getId())) {
            throw new IllegalArgumentException("A movie with ID " + movie.getId() + " already exists.");
        }
        movies.put(movie.getId(), movie);
        return movie;
    }

    @Override
    public synchronized Movie getById(Integer id) {
        Movie movie = movies.get(id);
        if (movie == null) {
            throw new MovieNotFoundException(id);
        }
        return movie;
    }

    @Override
    public synchronized List<Movie> getAll() {
        return new ArrayList<>(movies.values());
    }

    @Override
    public synchronized Movie update(Integer id, Movie movie) {
        if (!movies.containsKey(id)) {
            throw new MovieNotFoundException(id);
        }
        Movie updated = new Movie(id, movie.getTitle(), movie.getGenre(), movie.getReleaseYear(),
                movie.getRating(), movie.getStatus());
        movies.put(id, updated);
        return updated;
    }

    @Override
    public synchronized void delete(Integer id) {
        if (movies.remove(id) == null) {
            throw new MovieNotFoundException(id);
        }
    }
}
