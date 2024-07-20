import java.nio.file.Files;
import java.nio.file.Paths;

import stanford.karel.*;


public class BetterKarel extends Karel {

    public void turnRight(){
        turnLeft();
        turnLeft();
        turnLeft();
    }
    public void turnAround() {
        turnLeft();
        turnLeft();
    }
    public void moveX(int x){
        for(int i = 0; i < x; i++){
            move();
        }
    }

    public void run() {
        moveX(5);
        turnAround();
        moveX(3);
        turnRight();
        moveX(5);
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
