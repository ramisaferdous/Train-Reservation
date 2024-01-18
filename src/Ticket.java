import java.time.LocalDate;

class Ticket {
    private Train train;
    private Passenger passenger;
    private Station fromStation;
    private Station toStation;
    private LocalDate journeyDate;
    private double price;

    public Ticket(Train train, Passenger passenger, Station fromStation, Station toStation, LocalDate journeyDate, double price) {
        this.train = train;
        this.passenger = passenger;
        this.fromStation = fromStation;
        this.toStation = toStation;
        this.journeyDate = journeyDate;
        this.price = price;
    }



    public LocalDate getJourneyDate() {
        return journeyDate;
    }

    public double getPrice() {
        return price;
    }
    public Train getTrain() {
        return train;
    }
    public Passenger getPassenger() {
        return passenger;
    }
    public Station getFromStation(){
        return fromStation;
    }
    public Station getToStation(){
        return toStation;
    }


}