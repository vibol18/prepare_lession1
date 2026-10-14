package com.movie.view;

import com.movie.model.Movie;
import com.movie.util.ConsoleUtil;

import java.util.List;

public class MovieView {
    public void displayMovies(List<Movie> movies) {
        ConsoleUtil.printHeader("MOVIES (" + movies.size() + ")");
        if (movies.isEmpty()) {
            System.out.println("No movies to display.");
            return;
        }
        movies.forEach(System.out::println);
    }

    public void displayMovie(Movie movie) {
        ConsoleUtil.printHeader("MOVIE DETAILS");
        System.out.println(movie);
    }
}
