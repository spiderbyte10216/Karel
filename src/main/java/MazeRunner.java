import java.nio.file.Files;
import java.nio.file.Paths;

import stanford.karel.*;


public class MazeRunner extends BetterKarel {

    public void run() {
        while(noBeepersPresent()){
            turnRight();
            while(frontIsBlocked()){
                turnLeft();
            }
            move();
        }
    }

    protected String getKarelWorld() {
        String world_str = "";
        try{
            world_str = Files.readString(Paths.get("src/main/java/worlds/maze_test.txt"));
        } catch (Exception e) {
            System.out.println("Could not read file.");
        }
        return world_str;
    }

    public static void main(String... args) {
        Karel.main(args);
    }
}
