package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CinemaHall[] cinemaHalls = new CinemaHall[5];
        for (int i = 0; i < cinemaHalls.length; i++) {
            cinemaHalls[i] = new CinemaHall(5, 10, 20);
        }

        int selectedHall = 0;

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Print hall layout");
            System.out.println("2. Book a place");
            System.out.println("3. Cancel seat booking");
            System.out.println("4. Check the availability of the place");
            System.out.println("5. Change the selected hall");
            System.out.println("6. Exit");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        cinemaHalls[selectedHall].printSeatingArrangement(selectedHall);
                        break;
                    case 2:
                        System.out.print("Enter a row: ");
                        int row = scanner.nextInt();
                        System.out.print("Enter seat numbers (separate them by spaces): ");
                        String seatsInput = scanner.next();
                        String[] seatsArray = seatsInput.split(" ");
                        int[] seats = new int[seatsArray.length];
                        for (int i = 0; i < seatsArray.length; i++) {
                            seats[i] = Integer.parseInt(seatsArray[i]);
                        }
                        try {
                            cinemaHalls[selectedHall].bookSeats(selectedHall, row, seats);
                        } catch (InvalidBookingException e) {
                            System.out.println("Booking error : " + e.getMessage());
                        }
                        break;
                    case 3:
                        System.out.print("Enter a row: ");
                        row = scanner.nextInt();
                        System.out.print("Enter seat numbers (separate them by spaces): ");
                        seatsInput = scanner.next();
                        seatsArray = seatsInput.split(" ");
                        seats = new int[seatsArray.length];
                        for (int i = 0; i < seatsArray.length; i++) {
                            seats[i] = Integer.parseInt(seatsArray[i]);
                        }
                        cinemaHalls[selectedHall].cancelBooking(selectedHall, row, seats);
                        break;
                    case 4:
                        System.out.print("Enter the number of seats: ");
                        int numSeatsToCheck = scanner.nextInt();
                        boolean available = cinemaHalls[selectedHall].checkAvailability(selectedHall, numSeatsToCheck);
                        if (available) {
                            System.out.println("Seats are available for reservation.");
                        } else {
                            System.out.println("There are not enough available places to book.");
                        }
                        break;
                    case 5:
                        System.out.print("Choose another hall (1-5): ");
                        selectedHall = scanner.nextInt() - 1;
                        break;
                    case 6:
                        System.out.println("Of you go");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Wrong choice. Try again.");
                }
            } catch (InputMismatchException e) {

                System.out.println("Invalid input. Enter an integer.");
                scanner.nextLine();
        }

        }
    }
}