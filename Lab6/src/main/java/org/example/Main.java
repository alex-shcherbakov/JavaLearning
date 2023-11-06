package org.example;
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
            System.out.println("Меню:");
            System.out.println("1. Надрукувати розміщення залу");
            System.out.println("2. Забронювати місце");
            System.out.println("3. Відмінити бронювання місця");
            System.out.println("4. Перевірити доступність місця");
            System.out.println("5. Змінити обраний зал");
            System.out.println("6. Вийти");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    cinemaHalls[selectedHall].printSeatingArrangement(selectedHall);
                    break;
                case 2:
                    System.out.print("Введіть ряд: ");
                    int row = scanner.nextInt();
                    System.out.print("Введіть номери місць (розділені пробілами): ");
                    String seatsInput = scanner.next();
                    String[] seatsArray = seatsInput.split(" ");
                    int[] seats = new int[seatsArray.length];
                    for (int i = 0; i < seatsArray.length; i++) {
                        seats[i] = Integer.parseInt(seatsArray[i]);
                    }
                    cinemaHalls[selectedHall].bookSeats(selectedHall, row, seats);
                    break;
                case 3:
                    System.out.print("Введіть ряд: ");
                    row = scanner.nextInt();
                    System.out.print("Введіть номери місць (розділені пробілами): ");
                    seatsInput = scanner.next();
                    seatsArray = seatsInput.split(" ");
                    seats = new int[seatsArray.length];
                    for (int i = 0; i < seatsArray.length; i++) {
                        seats[i] = Integer.parseInt(seatsArray[i]);
                    }
                    cinemaHalls[selectedHall].cancelBooking(selectedHall, row, seats);
                    break;
                case 4:
                    System.out.print("Введіть кількість місць: ");
                    int numSeatsToCheck = scanner.nextInt();
                    boolean available = cinemaHalls[selectedHall].checkAvailability(selectedHall, numSeatsToCheck);
                    if (available) {
                        System.out.println("Місця доступні для бронювання.");
                    } else {
                        System.out.println("Недостатньо доступних місць для бронювання.");
                    }
                    break;
                case 5:
                    System.out.print("Виберіть інший зал (1-5): ");
                    selectedHall = scanner.nextInt() - 1;
                    break;
                case 6:
                    System.out.println("До побачення!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }
}
