package enums;

public enum DroneType {
    FLYING("FLYING"),
    GROUND("GROUND");

    public final String type;

    private DroneType(String type) {
        this.type = type;
    }

}
