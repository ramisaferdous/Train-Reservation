import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class RailwayManagementSystem  {
    private static final List<Passenger> passengersCollection = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final PassengerService passengerService = new PassengerService(passengersCollection, scanner);

static DisplayClass display = new DisplayClass();





    public static void bookTicket(Scanner scanner, Route route, Passenger passenger) {
        System.out.println("\nBooking Ticket:");
        System.out.println("Select Departure Station:");
        display.displayStationOptions(route.getStations());

        System.out.print("Enter the number for Departure Station: ");
        int departureIndex = PassengerService.getUserInputIndex(route.getStations().size(), scanner);
        Station departureStation = route.getStations().get(departureIndex - 1);

        System.out.println("\nSelect Destination Station:");
        List<Station> destinationOptions = new ArrayList<>(route.getStations());
        destinationOptions.remove(departureStation);
        display.displayStationOptions(destinationOptions);

        System.out.print("Enter the number for Destination Station: ");
        int destinationIndex = PassengerService.getUserInputIndex(destinationOptions.size(), scanner);
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

        display.displayTicketPriceOptions();
        System.out.print("Enter the number for Ticket Price: ");
        int priceChoice = scanner.nextInt();
        double ticketPrice = getTicketPriceForChoice(priceChoice, seatsToBook);

        Ticket ticket = new Ticket(train, passenger, departureStation, destinationStation, journeyDate, ticketPrice);
        display.displayTicketInformation(ticket);
    }

    public static Train selectTrainForRoute(Scanner scanner) {
        System.out.println("Select Train Type:");
        System.out.println("1. Express Train");
        System.out.println("2. Regional Train");
        int choice = PassengerService.getUserInputIndex(2, scanner);

        // Example train selection logic
        if (choice == 1) {
            return new ExpressTrain("EXP123", 200);
        } else if (choice == 2) {
            return new RegionalTrain("REG456", 150);
        } else {
            return null;
        }
    }

    private static double getTicketPriceForChoice(int choice, int numberOfSeats) {
        double pricePerSeat = (choice == 1) ? 30.0 : 45.0;
        return pricePerSeat * numberOfSeats;
    }



    static Passenger findPassengerById(String userId) {
        for (Passenger passenger : passengersCollection) {
            if (passenger.getID().equals(userId)) {
                return passenger;
            }
        }
        return null;
    }

    public static List<Passenger> getCustomersCollection() {
        return passengersCollection;
    }
}
