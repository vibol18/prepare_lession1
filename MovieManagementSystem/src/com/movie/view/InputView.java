package com.movie.view;

import com.movie.model.Genre;
import com.movie.model.MovieStatus;
import com.movie.util.InputUtil;

public class InputView {
    private final InputUtil input;

    public InputView(InputUtil input) {
        this.input = input;
    }

    public int readMenuChoice() {
        return input.readInt("Select an option: ");
    }

    public int readMovieId() {
        return input.readInt("Movie ID: ");
    }

    public String readTitle() {
        return input.readRequired("Title: ");
    }

    public Genre readGenre() {
        System.out.println("Genres: ACTION, ADVENTURE, ANIMATION, COMEDY, CRIME, DOCUMENTARY, DRAMA,");
        System.out.println("        FANTASY, HORROR, MYSTERY, ROMANCE, SCIENCE_FICTION, THRILLER, WESTERN");
        return input.readEnum("Genre: ", Genre.class);
    }

    public int readReleaseYear() {
        return input.readInt("Release year: ");
    }

    public double readRating() {
        return input.readDouble("Rating (0-10): ");
    }

    public MovieStatus readStatus() {
        return input.readEnum("Status (WATCHLIST, WATCHED, AVAILABLE): ", MovieStatus.class);
    }
}
