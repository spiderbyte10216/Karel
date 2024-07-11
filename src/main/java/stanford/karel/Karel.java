/*
 * File: Karel.java
 * ----------------
 * This class implements the basic Karel-the-Robot object.
 */

package stanford.karel;

import acm.util.*;
import java.awt.*;

/* Class: Karel */
/**
 * The <code>Karel</code> class represents the simplest possible Karel-the-Robot
 * object.  Each instance of the <code>Karel</code> class represents an individual
 * robot that can move inside a world laid out as a grid of streets and avenues.
 * The other characteristics of Karel's world include <b>walls,</b> which separate
 * individual corners, and <b>beepers,</b> which are described by Karel's creator
 * as "plastic cones which emit a quiet beeping noise."  As it is shipped from
 * the factory, Karel can execute only four operations:
 *
 * <dl>
 * <dt><code><a href="#move()">move</a>()</code></dt>
 *    <dd>Moves this Karel forward one block.  Karel cannot move forward if there
 *        is a wall blocking the way.</dd>
 * <dt><code><a href="#turnLeft()">turnLeft</a>()</code></dt>
 *    <dd>Rotates this Karel 90 degrees to the left (counterclockwise).</dd>
 * <dt><code><a href="#pickBeeper()">pickBeeper</a>()</code></dt>
 *    <dd>Picks up one beeper from the current corner and stores the beeper in
 *        this Karel's beeper bag, which can hold an infinite number of beepers.
 *        Karel can execute a <code>pickBeeper</code> instruction only if there
 *        is a beeper on the current corner.</dd>
 * <dt><code><a href="#putBeeper()">putBeeper</a>()</code></dt>
 *    <dd>Takes one beeper from this Karel's beeper bag and deposits it on the
 *        current corner.  Karel can execute a <code>pickBeeper</code> instruction
 *        only if there is a beeper in its bag.</dd>
 * </dl>
 *
 * <p>&nbsp;</p>Karel programs are executed by defining a new subclass that extends
 * <code>Karel</code> and provides it with a <code>run</code> method that
 * defines its operation.  For example, the following Karel subclass represents
 * a Karel program that moves forward, picks up a beeper from the square, and
 * then moves forward one more time:
 *
 * <p>&nbsp;</p><table><caption>&nbsp;</caption><tr><td>&nbsp;</td>
 * <td><table><caption>&nbsp;</caption><tr><td><pre><code>
 * public class SimpleKarelExample extends Karel {
 * &nbsp;&nbsp;&nbsp;public void run() {
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;move();
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;putBeeper();
 * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;move();
 * &nbsp;&nbsp;&nbsp;}
 * }
 * </code></pre></td></tr></table></td></tr></table>
 */

public class Karel implements Runnable {

/**
 * Creates a new <code>Karel</code> object.  You will not
 * ordinarily need to call this method explicitly; it is
 * the default constructor and will be executed automatically
 * if you write a Karel program.
 */
    public Karel() {
        x = 1;
        y = 1;
        dir = EAST;
        world = null;
    }

    protected String getKarelWorld() {
        return null;
    }

    protected boolean isAutorunEnabled() {
        return true;
    }

/**
 * Specifies the code for this <code>Karel</code> program.
 * You need to provide a new implementation of this method
 * whenever you extend <code>Karel</code>.
 */
    public void run() {
        /* Empty */
    }

/**
 * Instructs Karel to move forward to the next corner.  This
 * method fails if Karel is blocked by a wall.
 */
    public void move() {
        checkWorld("move");
        if (world.checkWall(x, y, dir)) throw new ErrorException("Karel is blocked");
        setLocation(KarelWorld.adjacentPoint(x, y, dir));
        world.trace();
    }

/**
 * Instructs Karel to turn left by 90 degrees.
 */
    public void turnLeft() {
        checkWorld("turnLeft");
        setDirection(KarelWorld.leftFrom(dir));
        world.trace();
    }

/**
 * Instructs Karel to pick up a beeper from the current
 * corner.  This method fails if there are no beepers present.
 */
    public void pickBeeper() {
        checkWorld("pickBeeper");
        int nb = world.getBeepersOnCorner(x, y);
        if (nb < 1) throw new ErrorException("pickBeeper: No beepers on this corner");
        world.setBeepersOnCorner(x, y, KarelWorld.adjustBeepers(nb, -1));
        setBeepersInBag(KarelWorld.adjustBeepers(getBeepersInBag(), +1));
        world.trace();
    }

/**
 * Instructs Karel to take a beeper from its beeper bag and place
 * it on the current corner.  This method fails if there are no
 * beepers in the bag.
 */
    public void putBeeper() {
        checkWorld("putBeeper");
        int nb = getBeepersInBag();
        if (nb < 1) throw new ErrorException("putBeeper: No beepers in bag");
        world.setBeepersOnCorner(x, y, KarelWorld.adjustBeepers(world.getBeepersOnCorner(x, y), +1));
        setBeepersInBag(KarelWorld.adjustBeepers(nb, -1));
        world.trace();
    }

/**
 * Checks to see if Karel can move forward.
 *
 * @return <code>true</code> if the corner in front of Karel is clear
 */
    public boolean frontIsClear() {
        checkWorld("frontIsClear");
        return !world.checkWall(x, y, dir);
    }

/**
 * Checks to see if Karel is blocked by a wall.
 *
 * @return <code>true</code> if there is a wall in front of Karel
 */
    public boolean frontIsBlocked() {
        checkWorld("frontIsBlocked");
        return world.checkWall(x, y, dir);
    }

/**
 * Checks to see if there is no wall to Karel's left.
 *
 * @return <code>true</code> if there is no wall to Karel's left
 */
    public boolean leftIsClear() {
        checkWorld("leftIsClear");
        return !world.checkWall(x, y, KarelWorld.leftFrom(dir));
    }

/**
 * Checks to see if there is a wall to Karel's left.
 *
 * @return <code>true</code> if there is a wall to Karel's left
 */
    public boolean leftIsBlocked() {
        checkWorld("leftIsBlocked");
        return world.checkWall(x, y, KarelWorld.leftFrom(dir));
    }

/**
 * Checks to see if there is no wall to Karel's right.
 *
 * @return <code>true</code> if there is no wall to Karel's right
 */
    public boolean rightIsClear() {
        checkWorld("rightIsClear");
        return !world.checkWall(x, y, KarelWorld.rightFrom(dir));
    }

/**
 * Checks to see if there is a wall to Karel's right.
 *
 * @return <code>true</code> if there is a wall to Karel's right
 */
    public boolean rightIsBlocked() {
        checkWorld("rightIsBlocked");
        return world.checkWall(x, y, KarelWorld.rightFrom(dir));
    }

/**
 * Checks to see if the current corner has at least one beeper.
 *
 * @return <code>true</code> if there are any beepers on this corner
 */
    public boolean beepersPresent() {
        checkWorld("beepersPresent");
        return world.getBeepersOnCorner(x, y) > 0;
    }

/**
 * Checks to see if the current corner is empty of beepers.
 *
 * @return <code>true</code> if there are no beepers on this corner
 */
    public boolean noBeepersPresent() {
        checkWorld("noBeepersPresent");
        return world.getBeepersOnCorner(x, y) == 0;
    }

/**
 * Checks to see if the beeper bag contains at least one beeper.
 *
 * @return <code>true</code> if there are any beepers in the bag
 */
    public boolean beepersInBag() {
        checkWorld("beepersInBag");
        return getBeepersInBag() > 0;
    }

/**
 * Checks to see if the beeper bag is empty.
 *
 * @return <code>true</code> if there are no beepers in the bag
 */
    public boolean noBeepersInBag() {
        checkWorld("noBeepersInBag");
        return getBeepersInBag() == 0;
    }

/**
 * Checks to see if Karel is facing north.
 *
 * @return <code>true</code> if Karel is facing north
 */
    public boolean facingNorth() {
        checkWorld("facingNorth");
        return dir == NORTH;
    }

/**
 * Checks to see if Karel is facing east.
 *
 * @return <code>true</code> if Karel is facing east
 */
    public boolean facingEast() {
        checkWorld("facingEast");
        return dir == EAST;
    }

/**
 * Checks to see if Karel is facing south.
 *
 * @return <code>true</code> if Karel is facing south
 */
    public boolean facingSouth() {
        checkWorld("facingSouth");
        return dir == SOUTH;
    }

/**
 * Checks to see if Karel is facing west.
 *
 * @return <code>true</code> if Karel is facing west
 */
    public boolean facingWest() {
        checkWorld("facingWest");
        return dir == WEST;
    }

/**
 * Checks to see if Karel is facing some direction other than north.
 *
 * @return <code>true</code> if Karel is not facing north
 */
    public boolean notFacingNorth() {
        checkWorld("notFacingNorth");
        return dir != NORTH;
    }

/**
 * Checks to see if Karel is facing some direction other than east.
 *
 * @return <code>true</code> if Karel is not facing east
 */
    public boolean notFacingEast() {
        checkWorld("notFacingEast");
        return dir != EAST;
    }

/**
 * Checks to see if Karel is facing some direction other than south.
 *
 * @return <code>true</code> if Karel is not facing south
 */
    public boolean notFacingSouth() {
        checkWorld("notFacingSouth");
        return dir != SOUTH;
    }

/**
 * Checks to see if Karel is facing some direction other than west.
 *
 * @return <code>true</code> if Karel is not facing west
 */
    public boolean notFacingWest() {
        checkWorld("notFacingWest");
        return dir != WEST;
    }

/* Entry points for program operation */

    public static void main(String[] args) {
        String[] newArgs = new String[args.length + 1];
        for (int i = 0; i < args.length; i++) {
            newArgs[i] = args[i];
        }
        newArgs[args.length] = "program=stanford.karel.KarelProgram";
        KarelProgram.main(newArgs);
    }

/* Protected method: start() */
/**
 * Starts a <code>GraphicsProgram</code> containing this object.
 */
    protected void start() {
        start(null);
    }

/* Protected method: start(args) */
/**
 * Starts a <code>KarelProgram</code> containing this Karel instance, passing
 * it the specified arguments.
 *
 * @param args Argument array passed to acm program
 */
    protected void start(String[] args) {
        KarelProgram program = new KarelProgram();
        program.setStartupObject(this);
        program.start(args);
    }

/* Protected methods */

    protected Point getLocation() {
        return new Point(x, y);
    }

    protected void setLocation(Point pt) {
        setLocation(pt.x, pt.y);
    }

    protected void setLocation(int x, int y) {
        if (world != null) {
            if (world.outOfBounds(x, y)) throw new ErrorException("setLocation: Out of bounds");
            Karel occupant = world.getKarelOnSquare(x, y);
            if (occupant == this) return;
            if (occupant != null) throw new ErrorException("setLocation: Square is already occupied");
        }
        int x0 = this.x;
        int y0 = this.y;
        this.x = x;
        this.y = y;
        if (world != null) {
            world.updateCorner(x, y);
            world.updateCorner(x0, y0);
        }
    }

    protected int getDirection() {
        return dir;
    }

    protected void setDirection(int dir) {
        this.dir = dir;
        if (world != null) world.updateCorner(x, y);
    }

    protected int getBeepersInBag() {
        return (beepers);
    }

    protected void setBeepersInBag(int nBeepers) {
        beepers = nBeepers;
    }

    protected KarelWorld getWorld() {
        return world;
    }

    protected void setWorld(KarelWorld world) {
        this.world = world;
    }

    protected void checkWorld(String caller) {
        if (world == null) throw new ErrorException(caller + ": Karel is not living in a world");
    }

    public void setDisplayOneFlag(boolean flag) {
        world.setDisplayOneFlag(flag);
    }

/* Private constants */

    private static final int NORTH = KarelWorld.NORTH;
    private static final int EAST = KarelWorld.EAST;
    private static final int SOUTH = KarelWorld.SOUTH;
    private static final int WEST = KarelWorld.WEST;

/* Private state */

    private KarelWorld world;
    private int x, y;
    private int dir;
    private int beepers;

  public void exit() {
    System.out.println("Exit!");
  }
}
