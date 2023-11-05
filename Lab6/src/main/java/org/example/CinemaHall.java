package org.example;

public class CinemaHall {
    private int[][][] Halls;

    public CinemaHall(int numHalls, int numRows, int numSeatsPerRow) {
        Halls = new int[numHalls][numRows][numSeatsPerRow];
    }

    public void bookSeats(int hallNumber, int row, int[] seats) {
        for (int seat : seats) {
            if (Halls[hallNumber][row][seat] == 1) {
                System.out.println("Seat " + seat + " \n" +
                        "in a row " + row + " of hall№ " + hallNumber + " already booked");
            } else {
                Halls[hallNumber][row][seat] = 1;
                System.out.println("Seat " + seat + " in a row " + row + " of hall№ " + hallNumber + " successfully booked.");
            }
        }
    }

    public void cancelBooking(int hallNumber, int row, int[] seats) {
        for (int seat : seats) {
            if (Halls[hallNumber][row][seat] == 0) {
                System.out.println("Seat " + seat + " in a row " + row + " of hall№ " + hallNumber + " already free");
            } else {
                Halls[hallNumber][row][seat] = 0;
                System.out.println("Cancellation of a reservation for a seat " + seat + "in a row " + row + " of hall№ "
                        + hallNumber + " done successfully");
            }
        }
    }

    public boolean checkAvailability(int hallNumber, int numSeats) {
        for (int row = 0; row < Halls[hallNumber].length; row++) {
            int consecutiveSeats = 0;
            for (int seat = 0; seat < Halls[hallNumber][row].length; seat++) {
                if (Halls[hallNumber][row][seat] == 0) {
                    consecutiveSeats++;
                    if (consecutiveSeats == numSeats) {
                        return true;
                    }
                } else {
                    consecutiveSeats = 0;
                }
            }
        }
        return false;
    }

    public void printSeatingArrangement(int hallNumber) {
        System.out.println("Placement scheme for the hall " + hallNumber + ":");
        for (int row = 0; row < Halls[hallNumber].length; row++) {
            for (int seat = 0; seat < Halls[hallNumber][row].length; seat++) {
                if (Halls[hallNumber][row][seat] == 0) {
                    System.out.print("O ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
