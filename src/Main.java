import file.DroneFileHandler;
import model.Drones;
import model.Sensor;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //TODO
        List<Drones> dronesList = DroneFileHandler.readDrones("corrupt.transmission");
        for (Drones drone : dronesList) {
            drone.displayDrones();
        }
    }
}
