package com.movie.util;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputUtil {
    private final Scanner scanner;

    public InputUtil(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readRequired(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!scanner.hasNextLine()) {
                throw new NoSuchElementException("Input stream has been closed.");
            }
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Please enter a value.");
        }
    }

    public int readInt(String prompt) {
        while (true) {
            String value = readRequired(prompt);
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    public double readDouble(String prompt) {
        while (true) {
            String value = readRequired(prompt);
            try {
                return Double.parseDouble(value);
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public <E extends Enum<E>> E readEnum(String prompt, Class<E> enumType) {
        while (true) {
            String value = readRequired(prompt);
            try {
                return Enum.valueOf(enumType, value.trim().replace(' ', '_').toUpperCase());
            } catch (IllegalArgumentException exception) {
                System.out.println("Choose one of: " + String.join(", ", enumNames(enumType)));
            }
        }
    }

    private <E extends Enum<E>> String[] enumNames(Class<E> enumType) {
        E[] values = enumType.getEnumConstants();
        String[] names = new String[values.length];
        for (int index = 0; index < values.length; index++) {
            names[index] = values[index].name();
        }
        return names;
    }
}
