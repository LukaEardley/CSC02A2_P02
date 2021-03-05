package model;
/**
 * model.Sensor class that inherits from the Drone class
 */
public class Sensor {
    //Variables
    private String sensorID;
    private String orientation;

    Sensor(String sensorID, String orientation) {
        this.sensorID = sensorID;
        this.orientation = orientation;
    }

    public void displaySense() {
        System.out.println(String.format("Sensor ID: %s , Sensor Orientation: %s ", this.sensorID, this.orientation));
    }
}
