package model;
import java.util.ArrayList;
import java.util.List;

/**
 * Drone class that handles all the creation of each drone
 */
public class Drones {
    //Variables
    private String ID;
    private List<Sensor> sensorList = new ArrayList<Sensor>();
    private String type;

    //Parameterized constructor
    public Drones(String ID, String Type) {
        this.ID = ID;
        this.type = Type;
    }

    public void addDroneSensor(String sensorID, String orientation) {
        this.sensorList.add(new Sensor(sensorID, orientation));
    }

    public void displayDrones() {
        System.out.println(String.format("Drone ID: %s Drone Type: %s", this.ID, this.type));
        for (Sensor sensor : sensorList) {
            sensor.displaySense();
        }
        System.out.println("");
    }
}
