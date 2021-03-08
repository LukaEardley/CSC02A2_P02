package accse.model;
/**
 * accse.model.Sensor class that has all the information relating to the drones sensor
 *
 * @author Luka Eardley
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
