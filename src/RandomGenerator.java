import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public  class RandomGenerator{

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
        destinations.add("Chattogram");
        destinations.add("Dhaka");
        destinations.add("Cumilla");
        destinations.add("Sylhet");
        destinations.add("Rajshahi");
        destinations.add("Rajshahi");
        return destinations;
    }
}