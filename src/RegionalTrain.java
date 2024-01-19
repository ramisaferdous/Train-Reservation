public class RegionalTrain extends Train {
    public RegionalTrain(String trainNumber, int availableSeats) {
        super(trainNumber, availableSeats);

    }
    @Override
    public boolean bookSeats(int numberOfSeats) {
        if (numberOfSeats <= availableSeats) {
            availableSeats -= numberOfSeats;
            return true;
        }
        return false;
    }
}