import java.util.List;
import java.util.Scanner;

public class PassengerService {
    static List<Passenger> passengersCollection;
    private Scanner scanner;

    public PassengerService(List<Passenger> passengersCollection, Scanner scanner) {
        PassengerService.passengersCollection = passengersCollection;
        this.scanner = scanner;
    }
    public static void createPassenger(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Enter passenger ID: ");
        String userId = scanner.nextLine();
        if (RailwayManagementSystem.findPassengerById(userId) != null) {
            System.out.println("A passenger with this ID already exists. Please use a different ID.");
            return;
        }
        System.out.print("Enter passenger name: ");
        String name = scanner.nextLine();
        System.out.print("Enter passenger contact number: ");
        String contactNumber = scanner.nextLine();
        System.out.print("Enter passenger password: ");
        String password = scanner.nextLine();

        Passenger passenger = new Passenger(name, contactNumber, userId,password);
        passengersCollection.add(passenger);
        System.out.println("Passenger created successfully!");
    }
    public static Passenger loginPassenger(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Enter passenger ID: ");
        String userId = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        Passenger passenger = RailwayManagementSystem.findPassengerById(userId);
        if (passenger == null || !passenger.checkPassword(password)) {
            System.out.println("Invalid login credentials. Please try again.");
            return null;
        }

        System.out.println("\nLogin successful! Welcome, " + passenger.getName() + "!");
        return passenger;
    }
    static int getUserInputIndex(int maxIndex, Scanner scanner) {
        int userInput;
        do {
            userInput = scanner.nextInt();
            if (userInput < 1 || userInput > maxIndex) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        } while (userInput < 1 || userInput > maxIndex);
        return userInput;
    }
}
