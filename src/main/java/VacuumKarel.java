import java.nio.file.Files;
import java.nio.file.Paths;

import stanford.karel.*;


public class VacuumKarel extends Karel {

    private void moveAndScoop(){
        move();
        while(beepersPresent()){
            pickBeeper();
        }
    }

    private void turnNorth() {
        while (!facingNorth()) {
            turnLeft();
        }
    }

    private void turnSouth() {
        while (!facingSouth()) {
            turnLeft();
        }
    }

    private void turnEast() {
        while (!facingEast()) {
            turnLeft();
        }
    }

    private void turnWest() {
        while (!facingWest()) {
            turnLeft();
        }
    }


    public void run() {
        turnSouth();
        while(frontIsClear()){
            move();
        }
        turnWest();
        while(frontIsClear()){
            move();
        }
        while(true) {
            turnEast();
            while(frontIsClear()) {
                moveAndScoop();
            }
            turnNorth();
            if(frontIsBlocked()){
                break;
            }
            moveAndScoop();
            turnWest();
            while(frontIsClear()) {
                moveAndScoop();
            }
            turnNorth();
            if(frontIsBlocked()){
                break;
            }
            moveAndScoop();
        }
        turnSouth();
        while(frontIsClear()){
            move();
        }
        turnWest();
        while(frontIsClear()){
            move();
        }
        while(beepersInBag()){
            putBeeper();
        }
        turnEast();
        move();
    }

    protected String getKarelWorld() {
        String world_str = "";
        try{
            world_str = Files.readString(Paths.get("src/main/java/worlds/vacuum_test.txt"));
        } catch (Exception e) {
            System.out.println("Could not read file.");
        }
        return world_str;
    }

    public static void main(String... args) {
        Karel.main(args);
    }
}
