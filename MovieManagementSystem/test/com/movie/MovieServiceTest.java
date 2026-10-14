package com.movie;

import com.movie.exception.InvalidMovieException;
import com.movie.exception.MovieNotFoundException;
import com.movie.model.Genre;
import com.movie.model.Movie;
import com.movie.model.MovieStatus;
import com.movie.repository.MovieRepositoryImpl;
import com.movie.service.MovieService;
import com.movie.service.MovieValidationService;
import com.movie.util.IdGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MovieServiceTest {
    private MovieService movieService;

    @BeforeEach
    void setUp() {
        movieService = new MovieService(new MovieRepositoryImpl(), new MovieValidationService(), new IdGenerator());
    }

    @Test
    void addsMovieAndAssignsIncreasingIds() {
        Movie first = movieService.addMovie("Arrival", Genre.SCIENCE_FICTION, 2016, 8.0, MovieStatus.WATCHED);
        Movie second = movieService.addMovie("The Grand Budapest Hotel", Genre.COMEDY,
                2014, 7.8, MovieStatus.WATCHLIST);

        assertEquals(1, first.getId());
        assertEquals(2, second.getId());
        assertEquals(2, movieService.getAllMovies().size());
    }

    @Test
    void rejectsInvalidMovieData() {
        assertThrows(InvalidMovieException.class, () -> movieService.addMovie(
                " ", Genre.DRAMA, 2000, 7.0, MovieStatus.WATCHLIST));
        assertThrows(InvalidMovieException.class, () -> movieService.addMovie(
                "A movie", Genre.DRAMA, Year.now().getValue(), 11.0, MovieStatus.WATCHLIST));
    }

    @Test
    void updatesAndDeletesMovies() {
        Movie movie = movieService.addMovie("Old title", Genre.DRAMA, 2000, 6.0, MovieStatus.WATCHLIST);
        Movie updated = movieService.updateMovie(movie.getId(), "New title", Genre.ACTION,
                2020, 9.0, MovieStatus.WATCHED);

        assertEquals("New title", updated.getTitle());
        assertEquals(Genre.ACTION, updated.getGenre());
        movieService.deleteMovie(movie.getId());
        assertThrows(MovieNotFoundException.class, () -> movieService.getMovie(movie.getId()));
    }
}
