package enums;
//enums for the type of drone.
public enum DroneType {
    FLYING("FLYING"),
    GROUND("GROUND");

    public final String type;

    private DroneType(String type) {
        this.type = type;
    }

}
