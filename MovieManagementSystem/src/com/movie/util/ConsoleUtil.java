package com.movie.util;

public final class ConsoleUtil {
    private ConsoleUtil() {
    }

    public static void printHeader(String title) {
        System.out.println("\n" + "=".repeat(56));
        System.out.println("  " + title);
        System.out.println("=".repeat(56));
    }

    public static void printSuccess(String message) {
        System.out.println("✓ " + message);
    }

    public static void printError(String message) {
        System.out.println("Error: " + message);
    }
}
