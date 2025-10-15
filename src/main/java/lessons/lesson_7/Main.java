package lessons.lesson_7;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter flight date (YYYY-MM-DD): ");
        LocalDate flightDate = LocalDate.parse(scanner.nextLine());
        Airplane airplane = new Airplane();


        while (true) {
            System.out.println("\nAIRPLANE BOOKING SYSTEM:");
            System.out.println("1. Show all seats");
            System.out.println("2. Book a seat");
            System.out.println("3. Cancel a booking");
            System.out.println("4. Show seat information");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> airplane.showAllSeats();
                case 2 -> {
                    System.out.print("Enter seat number: ");
                    int num = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter passenger full name: ");
                    String name = scanner.nextLine();
                    airplane.bookSeat(num, name);
                }
                case 3 -> {
                    System.out.print("Enter seat number: ");
                    int num = scanner.nextInt();
                    airplane.cancelBooking(num);
                }
                case 4 -> {
                    System.out.print("Enter seat number: ");
                    int num = scanner.nextInt();
                    airplane.showSeatInfo(num);
                }
                case 0 -> {
                    System.out.println("Program finished. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
