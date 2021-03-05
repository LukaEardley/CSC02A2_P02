/**
 * Sensor class that inherits from the Drone class
 */
public class Sensor extends Drones {
  //Variables
  private String sensorID;
  private String orientation;

  Sensor() {
    this.generateSensors();
  }

  Sensor(String sensorID, String orientation) {
    this.sensorID = sensorID;
    this.orientation = orientation;
  }

  //Functions
  //generates a new sensor for the drone
  private void generateSensors() {
    this.sensorID = getAlphaNumericString(4);
    this.orientation = getSensorDirection();
  }

  //Generates a random number between 1 and 4, each number having a corresponding direction in-which the drone will face
  static String getSensorDirection() {
    java.util.Random random = new java.util.Random();
    int tmp = random.nextInt(4) + 1;
    if (tmp == 1) {
      return "North";
    } else if (tmp == 2) {
      return "East";
    } else if (tmp == 3) {
      return "South";
    } else {
      return "West";
    }
  }

  public void displaySense() {
    System.out.println(String.format("ID: %s , Orientation: %s ", this.sensorID, this.orientation));
  }
}
