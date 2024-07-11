/*
 * @(#)GRoundRect.java   1.99.1 08/12/08
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

// -- V2.0 --
// Bug fix 26-Apr-07 (ESR, JTFBug 2007-005, reported by Leland Beck)
//   1. Fixed problems with cross-file references to ArcRenderer.
//
// Feature enhancement 26-May-08 (ESR)
//   1. Added support for serialization.

package acm.graphics;

import java.awt.*;

/* Class: GRoundRect */
/**
 * The <code>GRoundRect</code> class is a graphical object whose appearance consists
 * of a rounded rectangle.
 */
public class GRoundRect extends GRect {

/* Constant: DEFAULT_ARC */
/**
 * The default arc diameter used for the corners of a rounded rectangle.
 */
	public static final double DEFAULT_ARC = 10;

/* Constructor: GRoundRect(width, height) */
/**
 * Constructs a new rounded rectangle with the specified width and height,
 * positioned at the origin.
 *
 * @usage GRoundRect rr = new GRoundRect(width, height);
 * @param width The width of the rectangle in pixels
 * @param height The height of the rectangle in pixels
 */
	public GRoundRect(double width, double height) {
		this(0, 0, width, height, DEFAULT_ARC);
	}

/* Constructor: GRoundRect(x, y, width, height) */
/**
 * Constructs a new rounded rectangle with the specified bounds.
 *
 * @usage GRoundRect rr = new GRoundRect(x, y, width, height);
 * @param x The x-coordinate of the upper left corner
 * @param y The y-coordinate of the upper left corner
 * @param width The width of the rectangle in pixels
 * @param height The height of the rectangle in pixels
 */
	public GRoundRect(double x, double y, double width, double height) {
		this(x, y, width, height, DEFAULT_ARC);
	}

/* Constructor: GRoundRect(x, y, width, height, arcSize) */
/**
 * Constructs a new rounded rectangle with the specified bounds and a single
 * parameter describing both the  describing the curvature at the corners.
 *
 * @usage GRoundRect rr = new GRoundRect(x, y, width, height, arcSize);
 * @param x The x-coordinate of the upper left corner
 * @param y The y-coordinate of the upper left corner
 * @param width The width of the rectangle in pixels
 * @param height The height of the rectangle in pixels
 * @param arcSize The diameter of the circle in place at each corner
 */
	public GRoundRect(double x, double y, double width, double height,
	                  double arcSize) {
		this(x, y, width, height, arcSize, arcSize);
	}

/* Constructor: GRoundRect(x, y, width, height, arcWidth, arcHeight) */
/**
 * Constructs a new rounded rectangle with the specified bounds and
 * arc parameters describing the curvature at the corners.
 *
 * @usage GRoundRect rr = new GRoundRect(x, y, width, height, arcWidth, arcHeight);
 * @param x The x-coordinate of the upper left corner
 * @param y The y-coordinate of the upper left corner
 * @param width The width of the rectangle in pixels
 * @param height The height of the rectangle in pixels
 * @param arcWidth The width of the oval in place at each corner
 * @param arcHeight The height of the oval in place at each corner
 */
	public GRoundRect(double x, double y, double width, double height,
	                  double arcWidth, double arcHeight) {
		super(x, y, width, height);
		aWidth = arcWidth;
		aHeight = arcHeight;
		renderer = new GArc(this);
	}

/* Method: getArcWidth() */
/**
 * Returns the <i>x</i> component of the corner radius.
 *
 * @usage double arcWidth = rr.getArcWidth();
 * @return The <i>x</i> component of the corner radius, in pixels.
 */
	public double getArcWidth() {
		return aWidth;
	}

/* Method: getArcHeight() */
/**
 * Returns the <i>y</i> component of the corner radius.
 *
 * @usage double arcHeight = rr.getArcHeight();
 * @return The <i>y</i> component of the corner radius, in pixels.
 */
	public double getArcHeight() {
		return aHeight;
	}

/* Method: paint(g) */
/**
 * Implements the <code>paint</code> operation for this graphical object.  This method
 * is not called directly by clients.
 * @noshow
 */
	public void paint(Graphics g) {
		Component comp = getComponent();
		if ((comp instanceof GCanvas) && ((GCanvas) comp).getNativeArcFlag()) {
			renderer.paint(g);
		} else {
			Rectangle r = getAWTBounds();
			int iArcWidth = GMath.round(aWidth);
			int iArcHeight = GMath.round(aHeight);
			if (isFilled()) {
				g.setColor(getFillColor());
				g.fillRoundRect(r.x, r.y, r.width, r.height, iArcWidth, iArcHeight);
				g.setColor(getColor());
			}
			g.drawRoundRect(r.x, r.y, r.width, r.height, iArcWidth, iArcHeight);
		}
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
/**
 * @inherited GObject#void removeMouseMotionListener(MouseMotionListener listener)
 * Removes a mouse motion listener from this graphical object.
 */
/* Private instance variables */
	private final double aWidth;
	private final double aHeight;
	private final GArc renderer;

/* Serial version UID */
/**
 * The serialization code for this class.  This value should be incremented
 * whenever you change the structure of this class in an incompatible way,
 * typically by adding a new instance variable.
 */
	static final long serialVersionUID = 1L;
}
