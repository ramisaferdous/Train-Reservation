import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RailwayManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create stations
        System.out.print("Enter the name of Station A: ");
        Station stationA = new Station(scanner.nextLine());

        System.out.print("Enter the name of Station B: ");
        Station stationB = new Station(scanner.nextLine());

        System.out.print("Enter the name of Station C: ");
        Station stationC = new Station(scanner.nextLine());

        // Create route with stations
        List<Station> routeStations = new ArrayList<>();
        routeStations.add(stationA);
        routeStations.add(stationB);
        routeStations.add(stationC);
        Route route = new Route(routeStations);

        // Create trains
        System.out.print("Enter the train number for Train 001: ");
        Train train1 = new Train(scanner.nextLine(), 200, route);

        System.out.print("Enter the train number for Train 002: ");
        Train train2 = new Train(scanner.nextLine(), 150, route);

        // Create platforms
        Platform platform1 = new Platform(1);
        Platform platform2 = new Platform(2);

        // Assign platforms to stations
        stationA.addPlatform(platform1);
        stationB.addPlatform(platform2);

        // Create schedules with arrival timings
        Map<Station, LocalTime> arrivalTimingsTrain1 = getArrivalTimingsFromUser(scanner, "Train 001");
        Map<Station, LocalTime> arrivalTimingsTrain2 = getArrivalTimingsFromUser(scanner, "Train 002");

        Schedule scheduleTrain1 = new Schedule(train1, arrivalTimingsTrain1);
        Schedule scheduleTrain2 = new Schedule(train2, arrivalTimingsTrain2);


        Passenger passenger1 = createPassengerFromUserInput(scanner);
        Passenger passenger2 = createPassengerFromUserInput(scanner);

        // Create tickets
        LocalDate journeyDate = LocalDate.of(2024, 1, 15);
        Ticket ticket1 = new Ticket(train1, passenger1, stationA, stationC, journeyDate, 50.0);
        Ticket ticket2 = new Ticket(train2, passenger2, stationB, stationC, journeyDate, 35.0);

        // Perform any additional operations or display information as needed
        // ...

        // Example: Display ticket information
        System.out.println("\nTicket 1 Information:");
        displayTicketInformation(ticket1);

        System.out.println("\nTicket 2 Information:");
        displayTicketInformation(ticket2);

        scanner.close();
    }

    private static Map<Station, LocalTime> getArrivalTimingsFromUser(Scanner scanner, String trainNumber) {
        Map<Station, LocalTime> arrivalTimings = new HashMap<>();

        for (Station station : Route.stations) {
            System.out.printf("Enter arrival time for %s at %s (HH:mm): ", trainNumber, station.getName());
            String arrivalTimeStr = scanner.next();
            LocalTime arrivalTime = LocalTime.parse(arrivalTimeStr);
            arrivalTimings.put(station, arrivalTime);
        }

        return arrivalTimings;
    }

    private static Passenger createPassengerFromUserInput(Scanner scanner) {
        System.out.print("Enter passenger name: ");
        String name = scanner.nextLine();

        System.out.print("Enter passenger contact number: ");
        String contactNumber = scanner.nextLine();

        return new Passenger(name, contactNumber);
    }

    private static void displayTicketInformation(Ticket ticket) {
        System.out.println("Train Number: " + ticket.getTrain().getTrainNumber());
        System.out.println("Passenger Name: " + ticket.getPassenger().getName());
        System.out.println("From Station: " + ticket.getFromStation().getName());
        System.out.println("To Station: " + ticket.getToStation().getName());
        System.out.println("Journey Date: " + ticket.getJourneyDate());
        System.out.println("Price: $" + ticket.getPrice());
    }
}
