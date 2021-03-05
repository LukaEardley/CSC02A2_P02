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
//adds the sensor to the sensor list
    public void addDroneSensor(String sensorID, String orientation) {
        this.sensorList.add(new Sensor(sensorID, orientation));
    }
//formats the correct method for displaying the details about each drone
    public void displayDrones() {
        System.out.println(String.format("Drone ID: %s Drone Type: %s", this.ID, this.type));
        for (Sensor sensor : sensorList) {
            sensor.displaySense();
        }
        //new line creation
        System.out.println("");
    }
}
