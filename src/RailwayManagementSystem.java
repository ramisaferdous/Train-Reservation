import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class RailwayManagementSystem  {
    private static final List<Passenger> passengersCollection = new ArrayList<>();



    public static void createPassenger(Scanner scanner) {
        scanner.nextLine();
        System.out.print("Enter passenger ID: ");
        String userId = scanner.nextLine();
        if (findPassengerById(userId) != null) {
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

    public static void loginAndBookTicket(Scanner scanner, Route route) {
        scanner.nextLine();
        System.out.print("Enter passenger ID: ");
        String userId = scanner.nextLine();


        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        Passenger passenger = findPassengerById(userId);

        if (passenger == null || !passenger.checkPassword(password)) {
            System.out.println("Invalid login credentials. Please try again.");
            return;
        }

        System.out.println("\nLogin successful! Welcome, " + passenger.getName() + "!");

        // Book Ticket
        System.out.println("\nBooking Ticket:");
        System.out.println("Select Departure Station:");

        displayStationOptions(route.getStations());

        System.out.print("Enter the number for Departure Station: ");
        int departureIndex = getUserInputIndex(route.getStations().size(), scanner);
        Station departureStation = route.getStations().get(departureIndex - 1);

        System.out.println("\nSelect Destination Station:");
        List<Station> destinationOptions = new ArrayList<>(route.getStations());
        destinationOptions.remove(departureStation);
        displayStationOptions(destinationOptions);

        System.out.print("Enter the number for Destination Station: ");
        int destinationIndex = getUserInputIndex(destinationOptions.size(), scanner);
        Station destinationStation = destinationOptions.get(destinationIndex - 1);

        System.out.print("Enter the journey date (YYYY-MM-DD): ");
        String journeyDateStr = scanner.next();
        LocalDate journeyDate = LocalDate.parse(journeyDateStr);



        Train train = selectTrainForRoute(scanner);
        if (train == null) {
            System.out.println("Invalid train selection.");
            return;

        }
        System.out.print("Enter the number of seats to book: ");
        int seatsToBook = scanner.nextInt();
        if (!train.bookSeats(seatsToBook)) {
            System.out.println("Not enough seats available. Available seats: " + train.getAvailableSeats());
            return;
        }

        displayTicketPriceOptions();
        System.out.print("Enter the number for Ticket Price: ");
        int priceChoice = scanner.nextInt();
        double ticketPrice = getTicketPriceForChoice(priceChoice, seatsToBook);


        Ticket ticket = new Ticket(train, passenger, departureStation, destinationStation, journeyDate, ticketPrice);
        System.out.println("\nTicket Information:");
        displayTicketInformation(ticket);
    }
    public static Train selectTrainForRoute(Scanner scanner) {
        System.out.println("Select Train Type:");
        System.out.println("1. Express Train");
        System.out.println("2. Regional Train");
        int choice = getUserInputIndex(2, scanner);

        // Example train selection logic
        if (choice == 1) {
            return new ExpressTrain("EXP123", 200);
        } else if (choice == 2) {
            return new RegionalTrain("REG456", 150);
        } else {
            return null;
        }
    }



    public static void displayStationOptions(List<Station> stations) {
        int index = 1;
        for (Station station : stations) {
            System.out.println(index + ". " + station.getName());
            index++;
        }
    }

    private static int getUserInputIndex(int maxIndex, Scanner scanner) {
        int userInput;
        do {
            userInput = scanner.nextInt();
            if (userInput < 1 || userInput > maxIndex) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        } while (userInput < 1 || userInput > maxIndex);
        return userInput;
    }

    private static void displayTicketPriceOptions() {
        System.out.println("\nSelect Ticket Price:");
        System.out.println("1. $30");
        System.out.println("2. $45");
    }

    private static double getTicketPriceForChoice(int choice, int numberOfSeats) {
        double pricePerSeat = (choice == 1) ? 30.0 : 45.0;
        return pricePerSeat * numberOfSeats;
    }

    public static void displayAllPassengers() {
        System.out.println("\nAll Passengers:");
        if (passengersCollection.isEmpty()) {
            System.out.println("No passengers added yet.");
        } else {
            for (Passenger passenger : passengersCollection) {
                System.out.println("User_Id: " + passenger.getID() + ", Name: " + passenger.getName() +
                        ", Contact Number: " + passenger.getContactNumber());
            }
        }
    }

    private static Passenger findPassengerById(String userId) {
        for (Passenger passenger : passengersCollection) {
            if (passenger.getID().equals(userId)) {
                return passenger;
            }
        }
        return null;
    }

    private static void displayTicketInformation(Ticket ticket) {
        System.out.println("Train Number: " + ticket.getTrain().getTrainNumber());
        System.out.println("Passenger Name: " + ticket.getPassenger().getName());
        System.out.println("From Station: " + ticket.getFromStation().getName());
        System.out.println("To Station: " + ticket.getToStation().getName());
        System.out.println("Journey Date: " + ticket.getJourneyDate());
        System.out.println("Price: $" + ticket.getPrice());
    }

    public static List<Passenger> getCustomersCollection() {
        return passengersCollection;
    }
}
