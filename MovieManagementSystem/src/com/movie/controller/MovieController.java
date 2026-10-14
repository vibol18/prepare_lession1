package com.movie.controller;

import com.movie.model.Movie;
import com.movie.service.MovieSearchService;
import com.movie.service.MovieService;
import com.movie.util.ConsoleUtil;
import com.movie.view.InputView;
import com.movie.view.MenuView;
import com.movie.view.MovieView;

import java.util.List;
import java.util.NoSuchElementException;

public class MovieController {
    private final MovieService movieService;
    private final MovieSearchService searchService;
    private final MenuView menuView;
    private final MovieView movieView;
    private final InputView inputView;

    public MovieController(MovieService movieService, MovieSearchService searchService,
            MenuView menuView, MovieView movieView, InputView inputView) {
        this.movieService = movieService;
        this.searchService = searchService;
        this.menuView = menuView;
        this.movieView = movieView;
        this.inputView = inputView;
    }

    public void run() {
        boolean running = true;
        while (running) {
            try {
                menuView.display();
                switch (inputView.readMenuChoice()) {
                    case 0 -> running = false;
                    case 1 -> movieView.displayMovies(movieService.getAllMovies());
                    case 2 -> addMovie();
                    case 3 -> searchMovies();
                    case 4 -> updateMovie();
                    case 5 -> deleteMovie();
                    default -> ConsoleUtil.printError("Choose an option from 0 to 5.");
                }
            } catch (NoSuchElementException exception) {
                running = false;
            } catch (RuntimeException exception) {
                ConsoleUtil.printError(exception.getMessage());
            }
        }
        System.out.println("Goodbye!");
    }

    private void addMovie() {
        Movie movie = movieService.addMovie(inputView.readTitle(), inputView.readGenre(),
                inputView.readReleaseYear(), inputView.readRating(), inputView.readStatus());
        ConsoleUtil.printSuccess("Added " + movie.getTitle() + " with ID " + movie.getId() + ".");
    }

    private void searchMovies() {
        String query = inputView.readTitle();
        List<Movie> results = searchService.search(query);
        movieView.displayMovies(results);
    }

    private void updateMovie() {
        int id = inputView.readMovieId();
        Movie updated = movieService.updateMovie(id, inputView.readTitle(), inputView.readGenre(),
                inputView.readReleaseYear(), inputView.readRating(), inputView.readStatus());
        ConsoleUtil.printSuccess("Updated " + updated.getTitle() + ".");
    }

    private void deleteMovie() {
        int id = inputView.readMovieId();
        movieService.deleteMovie(id);
        ConsoleUtil.printSuccess("Deleted movie " + id + ".");
    }
}
