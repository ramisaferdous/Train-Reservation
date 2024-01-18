import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> destinationNames = RandomGenerator.generateRandomDestinations();

        Station stationA = RandomGenerator.createRandomStation(destinationNames);
        Station stationB = RandomGenerator.createRandomStation(destinationNames);
        Station stationC = RandomGenerator.createRandomStation(destinationNames);
        Station stationD = RandomGenerator.createRandomStation(destinationNames);
        Station stationE = RandomGenerator.createRandomStation(destinationNames);



        List<Station> routeStations = new ArrayList<>();
        routeStations.add(stationA);
        routeStations.add(stationB);
        routeStations.add(stationC);
        routeStations.add(stationD);
        routeStations.add(stationE);
        Route route = new Route(routeStations);

        System.out.println("Welcome to Railway Management System!");
        int choice;

        do {
            System.out.println("\nMain Menu:");
            System.out.println("1. Create Passenger");
            System.out.println("2. Login As Passenger");
            System.out.println("3. Show All Passengers");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    PassengerService.createPassenger(scanner);
                    break;
                case 2:
                    Passenger passenger = PassengerService.loginPassenger(scanner);
                    if (passenger != null) {
                        RailwayManagementSystem.bookTicket(scanner, route, passenger);
                    }

                    break;
                case 3:
                    DisplayClass.displayAllPassengers();
                    break;
                case 0:
                    System.out.println("Exiting Railway Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }
}
