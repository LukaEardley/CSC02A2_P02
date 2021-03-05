import java.util.Random;

/**
 * Drone class that handles all the creation of each drone
 */
public class Drones {
  //Variables
  private String ID;
  private Sensor sensor;
  private char type;

  //Functions
  //generates a new drone
  Drones() {
    this.ID = getAlphaNumericString(6);
    this.type = getDroneType();
  }

  public void addDroneSensor() {
    this.sensor = new Sensor();
  }

  public Sensor getDroneSense() {
    return this.sensor;
  }

  //Generates a random AlphaNumeric string for the ID of size 6
  static String getAlphaNumericString(int n) {
    int lowerLimit = 97;
    int upperLimit = 122;
    Random random = new Random();
    StringBuffer r = new StringBuffer(n);

    for (int i = 0; i < n; i++) {
      int nextRandomChar = lowerLimit
          + (int) (random.nextFloat()
          * (upperLimit - lowerLimit + 1));
      r.append((char) nextRandomChar);
    }
    return r.toString();
  }

  //randomly selects if the drone will be a flying drone (F) or a ground drone (G)
  static char getDroneType() {
    java.util.Random random = new java.util.Random();
    int tmp = random.nextInt(2) + 1;
    if (tmp == 1) {
      return 'F';
    } else {
      return 'G';
    }
  }

}
