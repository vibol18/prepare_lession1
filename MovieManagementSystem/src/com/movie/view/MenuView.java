package com.movie.view;

import com.movie.util.ConsoleUtil;

public class MenuView {
    public void display() {
        ConsoleUtil.printHeader("MOVIE MANAGEMENT SYSTEM");
        System.out.println("1. List movies");
        System.out.println("2. Add movie");
        System.out.println("3. Search movies");
        System.out.println("4. Update movie");
        System.out.println("5. Delete movie");
        System.out.println("0. Exit");
    }
}
