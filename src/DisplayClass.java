import java.util.List;

public class DisplayClass {

    public static void displayStationOptions(List<Station> stations) {
        int index = 1;
        for (Station station : stations) {
            System.out.println(index + ". " + station.getName());
            index++;
        }
    }
    static void displayTicketPriceOptions() {
        System.out.println("\nSelect Ticket Price:");
        System.out.println("1. $30");
        System.out.println("2. $45");
    }
    public static void displayAllPassengers() {
        System.out.println("\nAll Passengers:");
        if (PassengerService.passengersCollection.isEmpty()) {
            System.out.println("No passengers added yet.");
        } else {
            for (Passenger passenger : PassengerService.passengersCollection) {
                System.out.println("User_Id: " + passenger.getID() + ", Name: " + passenger.getName() +
                        ", Contact Number: " + passenger.getContactNumber());
            }
        }
    }
    static void displayTicketInformation(Ticket ticket) {
        System.out.println("Train Number: " + ticket.getTrain().getTrainNumber());
        System.out.println("Passenger Name: " + ticket.getPassenger().getName());
        System.out.println("From Station: " + ticket.getFromStation().getName());
        System.out.println("To Station: " + ticket.getToStation().getName());
        System.out.println("Journey Date: " + ticket.getJourneyDate());
        System.out.println("Price: $" + ticket.getPrice());
    }
}
