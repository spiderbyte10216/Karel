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
        return "Dimension: (19, 12)\n"
                + "Beeper: (4, 1) 1\n"
                + "Beeper: (4, 3) 1\n"
                + "Beeper: (4, 5) 1\n"
                + "Beeper: (4, 7) 1\n"
                + "Beeper: (6, 1) 1\n"
                + "Beeper: (6, 3) 1\n"
                + "Beeper: (6, 5) 1\n"
                + "Beeper: (8, 1) 1\n"
                + "Beeper: (8, 3) 1\n"
                + "Beeper: (8, 5) 1\n"
                + "Beeper: (10, 1) 1\n"
                + "Beeper: (12, 1) 1\n"
                + "Karel: (1, 1) east\n"
                + "\n"
                + "BeeperBag: INFINITE\n"
                + "Speed: 0.00\n";
    }

    public static void main(String... args) {
        Karel.main(args);
    }
}
