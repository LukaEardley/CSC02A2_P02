package file;

import model.Drones;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DroneFileHandler {

    public static List<Drones> readDrones(String FileName) {

        try {
            File myObj = new File(String.format("./data/%s", FileName));
            Scanner myReader = new Scanner(myObj);
            List<Drones> droneList = new ArrayList<Drones>();
            int counter = -1;

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (Pattern.matches("([a-zA-Z0-9]{5,}[ \t]+\b(FLYING|GROUND)\b)", data)) {
                    String ID = data.split("    ")[0];
                    String Type = data.split("    ")[1];
                    droneList.add(new Drones(ID, Type));
                    counter += 1;
                } else if (Pattern.matches("([a-zA-Z0-9\t]{5,}([0-9]{2,},[0-9]{1})\\w)", data)) {
                    String sensorID = data.split("    ")[0];
                    String orientation = data.split("    ")[1];
                    droneList.get(counter).addDroneSensor(sensorID, orientation);
                }
            }
            myReader.close();
            return droneList;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //return arr of drones
        return null;
    }
}
//REGEX for ids ([a-zA-Z0-9]{5,})\w
//REGEX for sensor ids and orientation ([0-9]{2,},[0-9]{1})\w