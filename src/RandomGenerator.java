import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public  class RandomGenerator{
    List<String> destinationNames = generateRandomDestinations();
static Station createRandomStation(List<String> destinationNames) {
        if (destinationNames.isEmpty()) {
        throw new IllegalArgumentException("No destination names available.");
        }

        Random random = new Random();
        int randomIndex = random.nextInt(destinationNames.size());
        String randomName = destinationNames.get(randomIndex);
        destinationNames.remove(randomIndex);
        return new Station(randomName);
        }
    static List<String> generateRandomDestinations(){
        List<String> destinations = new ArrayList<>();
        destinations.add("City1");
        destinations.add("City2");
        destinations.add("City3");
        destinations.add("City4");
        destinations.add("City5");
        return destinations;
    }
}