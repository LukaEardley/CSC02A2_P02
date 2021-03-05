import file.DroneFileHandler;
import model.Drones;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //TODO
        List<Drones> dronesList = Stream.of(DroneFileHandler.readDrones("corrupt.transmission"), DroneFileHandler.readDrones("large.transmission"), DroneFileHandler.readDrones("normal.transmission")).filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        for (Drones drone : dronesList) {
            drone.displayDrones();
        }
    }
}
