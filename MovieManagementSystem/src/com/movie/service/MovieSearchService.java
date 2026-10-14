package com.movie.service;

import com.movie.contract.Searchable;
import com.movie.model.Movie;
import com.movie.repository.MovieRepository;

import java.util.List;
import java.util.Locale;

public class MovieSearchService implements Searchable<Movie> {
    private final MovieRepository repository;

    public MovieSearchService(MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Movie> search(String query) {
        if (query == null || query.isBlank()) {
            return List.of();
        }
        String normalizedQuery = query.trim().toLowerCase(Locale.ROOT);
        return repository.getAll().stream()
                .filter(movie -> movie.getTitle().toLowerCase(Locale.ROOT).contains(normalizedQuery)
                        || movie.getGenre().name().toLowerCase(Locale.ROOT).contains(normalizedQuery))
                .toList();
    }
}
