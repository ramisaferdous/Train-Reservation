import java.util.List;

public interface DisplayManager {
        void displayStationOptions(List<Station> stations);
        void displayTicketPriceOptions();
        void displayAllPassengers(List<Passenger> passengers);
        void displayTicketInformation(Ticket ticket);
    }

