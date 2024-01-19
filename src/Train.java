public abstract class Train implements ITrain {
    protected final String trainNumber;
    protected int availableSeats;

    public Train(String trainNumber, int availableSeats) {
        this.trainNumber = trainNumber;
        this.availableSeats = availableSeats;
    }
    public int getAvailableSeats() {
        return availableSeats;
    }
    public String getTrainNumber() {
        return trainNumber;
    }
}
