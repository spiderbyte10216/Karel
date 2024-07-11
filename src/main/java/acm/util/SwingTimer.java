/*
 * @(#)SwingTimer.java   1.99.1 08/12/08
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

package acm.util;

import java.awt.event.*;
import javax.swing.*;

/* Class: SwingTimer */
/**
 * This class is equivalent to <code>javax.swing.Timer</code> and
 * exists only to avoid the ambiguity that arises because there is
 * also a <code>Timer</code> class in <code>java.util</code>.
 */
public class SwingTimer extends Timer {

/* Constructor: SwingTimer(rate, listener) */
/**
 * Creates a new timer that ticks at the specified rate.  On each tick,
 * the timer sends an <code>ActionEvent</code> to the listener.
 *
 * @usage SwingTimer timer = new SwingTimer(rate, listener);
 * @param rate The number of milliseconds between ticks
 * @param listener The <code>ActionListener</code> receiving the events
 */
	public SwingTimer(int rate, ActionListener listener) {
		super(rate, listener);
	}

/* Inherited method: addActionListener(listener) */

	/* Inherited method: removeActionListener(listener) */

	/* Inherited method: setDelay(delay) */

	/* Inherited method: getDelay() */

	/* Inherited method: setRepeats(flag) */

	/* Inherited method: isRepeats() */

	/* Inherited method: start() */

	/* Inherited method: stop() */

	/* Inherited method: isRunning() */

	/* Serial version UID */
/**
 * The serialization code for this class.  This value should be incremented
 * whenever you change the structure of this class in an incompatible way,
 * typically by adding a new instance variable.
 */
	static final long serialVersionUID = 1L;
}
