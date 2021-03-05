import java.util.ArrayList;
import java.util.List;

public class Main {


  public static void main(String[] args) {
    List<Drones> droneList = new ArrayList<Drones>();

    Drones drone1 = new Drones();
    drone1.addDroneSensor();
    Drones drone2 = new Drones();
    drone2.addDroneSensor();

    droneList.add(drone1);
    droneList.add(drone2);

    for (Drones drone : droneList) {
      drone.getDroneSense().displaySense();
    }

  }
}
