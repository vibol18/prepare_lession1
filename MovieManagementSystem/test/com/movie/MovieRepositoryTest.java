package com.movie;

import com.movie.exception.MovieNotFoundException;
import com.movie.model.Genre;
import com.movie.model.Movie;
import com.movie.model.MovieStatus;
import com.movie.repository.MovieRepository;
import com.movie.repository.MovieRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MovieRepositoryTest {
    private MovieRepository repository;

    @BeforeEach
    void setUp() {
        repository = new MovieRepositoryImpl();
    }

    @Test
    void createsFindsUpdatesAndDeletesMovies() {
        Movie original = new Movie(1, "Spirited Away", Genre.ANIMATION, 2001, 8.6, MovieStatus.WATCHED);
        repository.create(original);
        assertEquals(original, repository.getById(1));
        assertEquals(1, repository.getAll().size());

        Movie replacement = new Movie(1, "Spirited Away", Genre.ANIMATION, 2001, 9.0, MovieStatus.WATCHED);
        assertEquals(9.0, repository.update(1, replacement).getRating());

        repository.delete(1);
        assertEquals(0, repository.getAll().size());
        assertThrows(MovieNotFoundException.class, () -> repository.getById(1));
    }

    @Test
    void throwsWhenUpdatingOrDeletingMissingMovie() {
        Movie movie = new Movie(1, "Missing", Genre.DRAMA, 2000, 5.0, MovieStatus.AVAILABLE);
        assertThrows(MovieNotFoundException.class, () -> repository.update(99, movie));
        assertThrows(MovieNotFoundException.class, () -> repository.delete(99));
    }
}
