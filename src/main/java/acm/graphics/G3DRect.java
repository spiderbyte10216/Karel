/*
 * @(#)G3DRect.java   1.99.1 08/12/08
 */

// ************************************************************************
// * Copyright (c) 2008 by the Association for Computing Machinery        *
// *                                                                      *
// * The Java Task Force seeks to impose few restrictions on the use of   *
// * these packages so that users have as much freedom as possible to     *
// * use this software in constructive ways and can make the benefits of  *
// * that work available to others.  In view of the legal complexities    *
// * of software development, however, it is essential for the ACM to     *
// * maintain its copyright to guard against attempts by others to        *
// * claim ownership rights.  The full text of the JTF Software License   *
// * is available at the following URL:                                   *
// *                                                                      *
// *          http://www.acm.org/jtf/jtf-software-license.pdf             *
// *                                                                      *
// ************************************************************************

// REVISION HISTORY
//
// -- V2.0 --
// Feature enhancement 26-May-08 (ESR)
//   1. Added support for serialization.
//   2. Revised bounding box calculation to conform to Java standard.

package acm.graphics;

import java.awt.*;

/* Class: G3DRect */
/**
 * The <code>G3DRect</code> class is used to represent a rectangle whose
 * borders are drawn to create a three-dimensional effect.  The
 * <code>G3DRect</code> class is a subclass of
 * <a href="GRect.html"><code>GRect</code></a>, and therefore
 * implements all the methods defined for that class.  In addition, the
 * <code>G3DRect</code> class supports the following methods:
 *
 * <p><table cellpadding=0 cellspacing=0 border=0><tr>
 * <td width=20>&nbsp;</td>
 * <td><table cellpadding=2 cellspacing=0 border=1>
 * <tr><td><code>void setRaised(boolean raised)</code><br>
 * <code>&nbsp;&nbsp;&nbsp;</code>Sets the <code>G3DRect</code> to appear
 * raised or lowered as specified by the parameter</td></tr>
 * <tr><td><code>boolean isRaised()</code><br>
 * <code>&nbsp;&nbsp;&nbsp;</code>Returns <code>true</code> if this
 * <code>G3DRect</code> is raised.</td></tr>
 * </table></td></tr></table>
 * <p>The appearance of a <code>G3DRect</code> object depends on the system on
 * which it is displayed and is typically more effective if the
 * <code>G3DRect</code> is filled.
 */
public class G3DRect extends GRect {

/* Constructor: G3DRect(width, height) */
/**
 * Constructs a new 3D rectangle with the specified width and height,
 * positioned at the origin.
 *
 * @usage G3DRect grect = new G3DRect(width, height);
 * @param width The width of the rectangle in pixels
 * @param height The height of the rectangle in pixels
 */
	public G3DRect(double width, double height) {
		this(0, 0, width, height, false);
	}

/* Constructor: G3DRect(x, y, width, height) */
/**
 * Constructs a new 3D rectangle with the specified bounds.
 *
 * @usage G3DRect grect = new G3DRect(x, y, width, height);
 * @param x The x-coordinate of the upper left corner
 * @param y The y-coordinate of the upper left corner
 * @param width The width of the rectangle in pixels
 * @param height The height of the rectangle in pixels
 */
	public G3DRect(double x, double y, double width, double height) {
		this(x, y, width, height, false);
	}

/* Constructor: G3DRect(x, y, width, height, raised) */
/**
 * Constructs a new 3D rectangle with the specified bounds which is
 * raised if the final parameter is <code>true</code>.
 *
 * @usage G3DRect grect = new G3DRect(x, y, width, height, raised);
 * @param x The x-coordinate of the upper left corner
 * @param y The y-coordinate of the upper left corner
 * @param width The width of the rectangle in pixels
 * @param height The height of the rectangle in pixels
 * @param raised <code>true</code> if this rectangle should appear raised
 */
	public G3DRect(double x, double y, double width, double height, boolean raised) {
		super(x, y, width, height);
		isRaised = raised;
	}

/* Method: paint(g) */
/**
 * Implements the <code>paint</code> operation for this graphical object.  This method
 * is not called directly by clients.
 * @noshow
 */
	public void paint(Graphics g) {
		Rectangle r = getAWTBounds();
		if (isFilled()) {
			g.setColor(getFillColor());
			g.fill3DRect(r.x, r.y, r.width, r.height, isRaised);
			g.setColor(getColor());
		}
		g.draw3DRect(r.x, r.y, r.width, r.height, isRaised);
	}

/* Inherited method: setLocation(x, y) */

    /* Inherited method: setLocation(pt) */

    /* Inherited method: getLocation() */

    /* Inherited method: getX() */

    /* Inherited method: getY() */

    /* Inherited method: move(dx, dy) */

    /* Inherited method: movePolar(r, theta) */

    /* Inherited method: scale(sx, sy) */

    /* Inherited method: scale(sf) */

    /* Inherited method: setSize(width, height) */

    /* Inherited method: setBounds(size) */

    /* Inherited method: getSize() */

    /* Inherited method: getWidth() */

    /* Inherited method: getHeight() */

    /* Inherited method: setBounds(x, y, width, height) */

    /* Inherited method: setBounds(bounds) */

    /* Inherited method: getBounds() */

    /* Inherited method: contains(x, y) */

    /* Inherited method: contains(pt) */

    /* Inherited method: sendToFront() */

    /* Inherited method: sendToBack() */

    /* Inherited method: sendForward() */

    /* Inherited method: sendBackward() */

    /* Inherited method: setColor(color) */

    /* Inherited method: getColor() */

    /* Inherited method: setFillColor(color) */

    /* Inherited method: getFillColor() */

    /* Inherited method: setFilled(fill) */

    /* Inherited method: isFilled() */

    /* Inherited method: setVisible(visible) */

    /* Inherited method: isVisible() */

    /* Inherited method: addMouseListener(listener) */

    /* Inherited method: removeMouseListener(listener) */

    /* Inherited method: addMouseMotionListener(listener) */

    /* Inherited method: removeMouseMotionListener(listener) */

    /* Method: setRaised(raised) */
/**
 * Sets whether this object appears raised.
 *
 * @usage grect.setRaised(raised);
 * @param raised <code>true</code> if the object appears raised, <code>false</code> otherwise
 */
	public void setRaised(boolean raised) {
		isRaised = raised;
	}

/* Method: isRaised() */
/**
 * Tests whether this object appears raised.
 *
 * @usage if (grect.isRaised()) . . .
 * @return <code>true</code> if the object appears raised, <code>false</code> otherwise
 */
	public boolean isRaised() {
		return isRaised;
	}

/* Private instance variables */
	private boolean isRaised;

/* Serial version UID */
/**
 * The serialization code for this class.  This value should be incremented
 * whenever you change the structure of this class in an incompatible way,
 * typically by adding a new instance variable.
 */
	static final long serialVersionUID = 1L;
}
