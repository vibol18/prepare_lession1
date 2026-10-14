package com.movie;

import com.movie.controller.MovieController;
import com.movie.repository.MovieRepository;
import com.movie.repository.MovieRepositoryImpl;
import com.movie.service.MovieSearchService;
import com.movie.service.MovieService;
import com.movie.service.MovieValidationService;
import com.movie.util.IdGenerator;
import com.movie.util.InputUtil;
import com.movie.view.InputView;
import com.movie.view.MenuView;
import com.movie.view.MovieView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MovieRepository repository = new MovieRepositoryImpl();
        MovieService movieService = new MovieService(repository, new MovieValidationService(), new IdGenerator());
        MovieSearchService searchService = new MovieSearchService(repository);
        InputView inputView = new InputView(new InputUtil(new Scanner(System.in)));
        MovieController controller = new MovieController(movieService, searchService,
                new MenuView(), new MovieView(), inputView);
        controller.run();
    }
}
