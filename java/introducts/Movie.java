
import java.util.Scanner;

public class Movie {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[][] seats = {
                { "A1", "A2", "A3", "A4" },
                { "B1", "B2", "B3", "B4" },
                { "C1", "C2", "C3", "C4" }
        };

        boolean[][] booked = new boolean[3][4];

        while (true) {

            System.out.println("\n===== MOVIE BOOKING =====");
            System.out.println("1. Show Seats");
            System.out.println("2. Book Seat");
            System.out.println("3. Check Booking");
            System.out.println("4. Cancel Booking");
            System.out.print("Choose: ");

            int menu = input.nextInt();
            input.nextLine();

            if (menu == 1) {

                // Show all seats
                for (int i = 0; i < seats.length; i++) {
                    for (int j = 0; j < seats[i].length; j++) {

                        System.out.print(seats[i][j]);

                        if (booked[i][j]) {
                            System.out.print("[X] ");
                        } else {
                            System.out.print("[O] ");
                        }
                    }
                    System.out.println();
                }

            } else if (menu == 2) {

                // Book seat
                System.out.print("Enter seat to book: ");
                String selected = input.nextLine().trim().toUpperCase();

                boolean found = false;

                for (int i = 0; i < seats.length; i++) {
                    for (int j = 0; j < seats[i].length; j++) {

                        if (seats[i][j].equals(selected)) {
                            found = true;

                            if (!booked[i][j]) {
                                booked[i][j] = true;
                                System.out.println(
                                        "Booking successful: " + selected);
                            } else {
                                System.out.println(
                                        "Seat already booked: " + selected);
                            }

                            break;
                        }
                    }

                    if (found) {
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Seat not found!");
                }

            } else if (menu == 3) {

                // Check booking status
                System.out.print("Enter seat to check: ");
                String selected = input.nextLine().trim().toUpperCase();

                boolean found = false;

                for (int i = 0; i < seats.length; i++) {
                    for (int j = 0; j < seats[i].length; j++) {

                        if (seats[i][j].equals(selected)) {
                            found = true;

                            if (booked[i][j]) {
                                System.out.println(
                                        selected + " is BOOKED [X]");
                            } else {
                                System.out.println(
                                        selected + " is AVAILABLE [O]");
                            }

                            break;
                        }
                    }

                    if (found) {
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Seat not found!");
                }

            } else if (menu == 4) {

                System.out.print("Enter seat to cancel: ");
                String selected = input.nextLine()
                        .trim()
                        .toUpperCase();

                boolean found = false;

                for (int i = 0; i < seats.length; i++) {
                    for (int j = 0; j < seats[i].length; j++) {

                        if (seats[i][j].equals(selected)) {
                            found = true;

                            if (booked[i][j]) {
                                booked[i][j] = false;
                                System.out.println(
                                        "Booking cancelled: " + selected);
                            } else {
                                System.out.println(
                                        "This seat is not booked!");
                            }

                            break;
                        }
                    }

                    if (found) {
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Seat not found!");
                }

            } else if (menu == 5) {

                System.out.println("Thank you!");
                break;

            } else {
                System.out.println("Invalid menu!");
            }
        }

        input.close();
    }
}
