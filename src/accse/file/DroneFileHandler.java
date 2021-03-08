package accse.file;

import accse.model.Drones;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * accse.model.Sensor class that has all the information relating to the drones sensor
 *
 * @author Luka Eardley
 */
//Class that is responsible for reading each accse.file, parsing the strings and setting the values for each drone.
public class DroneFileHandler {

    public static List<Drones> readDrones(String FileName) {

        try {
            File myObj = new File(String.format("./data/%s", FileName));
            Scanner myReader = new Scanner(myObj);
            List<Drones> droneList = new ArrayList<Drones>();
            int counter = -1;

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (Pattern.matches("([a-zA-Z0-9]{5,}[ \\t]+\\b(FLYING|GROUND)\\b)", data)) {
                    String ID = data.split("[ \\t]")[0];
                    String Type = data.split("[ \\t]")[1];
                    droneList.add(new Drones(ID, Type));
                    counter += 1;
                } else if (Pattern.matches("([a-zA-Z0-9\\t]{5,}([0-9]{3,},[0-9]{1})\\d)", data)) {
                    String sensorID = data.split("[ \\t]")[0];
                    String orientation = data.split("[ \\t]")[1];
                    droneList.get(counter).addDroneSensor(sensorID, orientation);
                }
            }
            myReader.close();
            return droneList;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }
}