public class Train implements ITrain {
    protected final String trainNumber;
    protected int availableSeats;

    public Train(String trainNumber, int availableSeats) {
        this.trainNumber = trainNumber;
        this.availableSeats = availableSeats;
    }

    @Override
    public boolean bookSeats(int numberOfSeats) {
        if (numberOfSeats <= availableSeats) {
            availableSeats -= numberOfSeats;
            return true;
        }
        return false;
    }

    @Override
    public int getAvailableSeats() {
        return availableSeats;
    }

    @Override
    public String getTrainNumber() {
        return trainNumber;
    }
}
