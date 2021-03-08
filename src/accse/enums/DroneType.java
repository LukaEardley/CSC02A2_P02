package accse.enums;

/**
 * accse.model.Sensor class that has all the information relating to the drones sensor
 *
 * @author Luka Eardley
 */

//accse.enums for the type of drone.
public enum DroneType {
    FLYING("FLYING"),
    GROUND("GROUND");

    public final String type;

    private DroneType(String type) {
        this.type = type;
    }

}
