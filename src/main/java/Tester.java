import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import stanford.karel.*;


public class Tester extends Karel {
    public void run() {
        while(frontIsClear())
        {
            putBeeper();
            move();
        }
    }

    protected String getKarelWorld() {
        String world_str = "";
        try{
            world_str = Files.readString(Paths.get("src/main/java/worlds/test.txt"));
        } catch (Exception e) {
            System.out.println("Could not read file.");
        }
        return world_str;
    }

    public static void main(String... args) {
        Karel.main(args);
    }
}
