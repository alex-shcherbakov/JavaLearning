package org.example;

public class CinemaHall {
    private int[][][] Halls;
    private int numRows;
    private int numSeatsPerRow;

    public CinemaHall(int numHalls, int numRows, int numSeatsPerRow) {
        this.numRows = numRows;
        this.numSeatsPerRow = numSeatsPerRow;
        Halls = new int[numHalls][numRows][numSeatsPerRow];
    }

    public void bookSeats(int hallNumber, int row, int[] seats) throws InvalidBookingException {
        for (int seat : seats) {
            if (seat < 1 || row < 1 || hallNumber < 0 || hallNumber >= Halls.length || row > Halls[hallNumber].length || seat > Halls[hallNumber][row - 1].length) {
                throw new InvalidBookingException(row);
            }

            if (Halls[hallNumber][row - 1][seat - 1] == 1) {
                throw new InvalidBookingException(row);
            } else {
                Halls[hallNumber][row - 1][seat - 1] = 1;
                System.out.println("Місце " + seat + " в ряді " + row + " залу №" + hallNumber + " успішно заброньоване.");
            }
        }
    }


    public void cancelBooking(int hallNumber, int row, int[] seats) {
        for (int seat : seats) {
            if (Halls[hallNumber][row - 1][seat - 1] == 0) {
                System.out.println("Seat " + seat + " in row " + row + " of hall №" + hallNumber + " is already free.");
            } else {
                Halls[hallNumber][row - 1][seat - 1] = 0;
                System.out.println("Cancellation of a reservation for seat " + seat + " in row " + row + " of hall №"
                        + hallNumber + " is done successfully.");
            }
        }
    }

    public boolean checkAvailability(int hallNumber, int numSeats) {
        for (int row = 0; row < numRows; row++) {
            for (int seat = 0; seat < numSeatsPerRow - numSeats + 1; seat++) {
                boolean available = true;
                for (int i = 0; i < numSeats; i++) {
                    if (Halls[hallNumber][row][seat + i] == 1) {
                        available = false;
                        break;
                    }
                }
                if (available) {
                    return true;
                }
            }
        }
        return false;
    }


    public void printSeatingArrangement(int hallNumber) {
        System.out.println("Seating arrangement for hall " + hallNumber + ":");
        for (int row = 0; row < numRows; row++) {
            for (int seat = 0; seat < numSeatsPerRow; seat++) {
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
