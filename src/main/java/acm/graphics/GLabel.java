/*
 * @(#)GLabel.java   1.99.1 08/12/08
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

package acm.graphics;

import acm.util.*;
import java.awt.*;

/* Class: GLabel */
/**
 * The <code>GLabel</code> class is a graphical object whose appearance
 * consists of a text string.
 */
public class GLabel extends GObject {

/* Constant: DEFAULT_FONT */
/**
 * The default font used to display strings.  You can change the font by invoking
 * the <a href="#setFont(Font)"><code>setFont</code></a> method.
 */
	public static final Font DEFAULT_FONT = new Font("Default", Font.PLAIN, 12);

/* Constructor: GLabel(str, x, y) */
/**
 * Creates a new <code>GLabel</code> object initialized to contain the specified string.
 *
 * @usage GLabel glabel = new GLabel(str);
 * @param str The initial contents of the <code>GLabel</code>
 */
	public GLabel(String str) {
		this(str, 0, 0);
	}

/* Constructor: GLabel(str, x, y) */
/**
 * Creates a new <code>GLabel</code> object with its baseline origin at the
 * specified position.
 *
 * @usage GLabel glabel = new GLabel(str, x, y);
 * @param str The initial contents of the <code>GLabel</code>
 * @param x The x-coordinate of the label origin
 * @param y The y-coordinate of the baseline for the label
 */
	public GLabel(String str, double x, double y) {
		label = str;
		setFont(DEFAULT_FONT);
		setLocation(x, y);
	}

/* Method: setFont(font) */
/**
 * Changes the font used to display the <code>GLabel</code>.  This call will
 * usually change the size of the displayed object and will therefore affect
 * the result of calls to <a href="GObject.html#getSize()"><code>getSize</code></a>
 * and <a href="GObject.html#getBounds()"><code>getBounds</code></a>.
 *
 * @usage glabel.setFont(font);
 * @param font A <code>Font</code> object indicating the new font
 */
	public void setFont(Font font) {
		labelFont = JTFTools.getStandardFont(font);
		repaint();
	}

/* Method: setFont(str) */
/**
 * Changes the font used to display the <code>GLabel</code> as specified by
 * the string <code>str</code>, which is interpreted in the style of
 * <code>Font.decode</code>.  The usual format of the font string is
 *
 * <p><pre><code>
 * &nbsp;    <font face="serif;times"><i>family</i></font>-<font face="serif;times"><i>style</i></font>-<font face="serif;times"><i>size</i></font>
 *
 * <p>where both <i>style</i> and <i>size</i> are optional.  If any of these
 * parts are specified as an asterisk, the existing value is retained.
 *
 * @usage glabel.setFont(str);
 * @param str A <code>String</code> specifying the new font
 */
	public void setFont(String str) {
		setFont(JTFTools.decodeFont(str, getFont()));
	}

/* Method: getFont() */
/**
 * Returns the font in which the <code>GLabel</code> is displayed.
 *
 * @usage Font font = glabel.getFont();
 * @return The font in use by this object
 */
	public Font getFont() {
		return labelFont;
	}

/* Method: setLabel(str) */
/**
 * Changes the string stored within the <code>GLabel</code> object, so that
 * a new text string appears on the display.
 *
 * @usage glabel.setLabel(str);
 * @param str The new string to display
 */
	public void setLabel(String str) {
		label = str;
		repaint();
	}

/* Method: getLabel() */
/**
 * Returns the string displayed by this object.
 *
 * @usage String str = glabel.getLabel();
 * @return The string displayed by this object
 */
	public String getLabel() {
		return label;
	}

/* Method: paint(g) */
/**
 * Implements the <code>paint</code> operation for this graphical object.  This method
 * is not called directly by clients.
 * @noshow
 */
	public void paint(Graphics g) {
		g.setFont(labelFont);
		g.drawString(label, GMath.round(getX()), GMath.round(getY()));
	}

/* Method: getWidth() */
/**
 * Returns the width of this string, as it appears on the display.
 *
 * @usage double width = glabel.getWidth();
 * @return The width of this object
 */
	public double getWidth() {
		return getFontMetrics().stringWidth(label);
	}

/* Method: getHeight() */
/**
 * Returns the height of this string, as it appears on the display.
 *
 * @usage double height = glabel.getHeight();
 * @return The height of this string
 */
	public double getHeight() {
		return getFontMetrics().getHeight();
	}

/* Method: getAscent() */
/**
 * Returns the distance this string extends above the baseline.
 *
 * @usage double ascent = glabel.getAscent();
 * @return The ascent of this string in pixels
 */
	public double getAscent() {
		return getFontMetrics().getAscent();
	}

/* Method: getDescent() */
/**
 * Returns the distance this string descends below the baseline.
 *
 * @usage double descent = glabel.getDescent();
 * @return The descent of this string in pixels
 */
	public double getDescent() {
		return getFontMetrics().getDescent();
	}

/* Method: getFontMetrics() */
/**
 * Returns a <code>FontMetrics</code> object describing the dimensions of this string.
 *
 * @usage FontMetrics fm = glabel.getFontMetrics();
 * @return A <code>FontMetrics</code> object describing the dimensions of this string
 * @noshow
 */
	public FontMetrics getFontMetrics() {
		Component comp = getComponent();
		if (comp == null) comp = DUMMY_COMPONENT;
		return comp.getFontMetrics(labelFont);
	}

/* Method: getBounds() */
/**
 * Returns a <code>GRectangle</code> that specifies the bounding box for the string.
 *
 * @usage GRectangle bounds = glabel.getBounds();
 * @return The bounding box for this object
 */
	public GRectangle getBounds() {
		return new GRectangle(getX(), getY() - getAscent(), getWidth(), getHeight());
	}

/* Inherited method: getSize() */

    /* Inherited method: contains(x, y) */

    /* Inherited method: contains(pt) */

    /* Inherited method: setLocation(x, y) */

    /* Inherited method: setLocation(pt) */

    /* Inherited method: getLocation() */

    /* Inherited method: getX() */

    /* Inherited method: getY() */

    /* Inherited method: move(dx, dy) */

    /* Inherited method: movePolar(r, theta) */

    /* Inherited method: sendToFront() */

    /* Inherited method: sendToBack() */

    /* Inherited method: sendForward() */

    /* Inherited method: sendBackward() */

    /* Inherited method: setColor(color) */

    /* Inherited method: getColor() */

    /* Inherited method: setVisible(visible) */

    /* Inherited method: isVisible() */

    /* Inherited method: addMouseListener(listener) */

    /* Inherited method: removeMouseListener(listener) */

    /* Inherited method: addMouseMotionListener(listener) */

    /* Inherited method: removeMouseMotionListener(listener) */

    /* Protected method: paramString() */
/**
 * Returns a string indicating the parameters of this object.
 * @noshow
 */
	public String paramString() {
		return super.paramString() + ", string=\"" + label + "\"";
	}

/* Private instance variables */
	private String label;
	private Font labelFont;

	private static final Component DUMMY_COMPONENT = MediaTools.getImageObserver();

/* Serial version UID */
/**
 * The serialization code for this class.  This value should be incremented
 * whenever you change the structure of this class in an incompatible way,
 * typically by adding a new instance variable.
 */
	static final long serialVersionUID = 1L;
}
