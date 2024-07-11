/*
 * @(#)DialogProgram.java   1.99.1 08/12/08
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
// Code cleanup 28-May-07 (ESR)
//   1. Rewrote code to call setInputModel/setOutputModel

package acm.program;

import acm.io.*;

/* Class: DialogProgram() */
/**
 * This class is a standard subclass of <code><a href="Program.html">Program</a></code>
 * that takes its input from a <code>IODialog</code> object.
 */
public abstract class DialogProgram extends Program {

/* Constructor: DialogProgram() */
/**
 * Creates a new dialog program.
 *
 * @usage DialogProgram program = new DialogProgram();
 */
	public DialogProgram() {
		IODialog dialog = getDialog();
		setInputModel(dialog);
		setOutputModel(dialog);
	}

/* Method: run() */
/**
 * Specifies the code to be executed as the program runs.
 * The <code>run</code> method is required for applications that have
 * a thread of control that runs even in the absence of user actions,
 * such as a program that uses console interation or that involves
 * animation.  GUI-based programs that operate by setting up an initial
 * configuration and then wait for user events usually do not specify a
 * <code>run</code> method and supply a new definition for <code>init</code>
 * instead.
 */
	public void run() {
		/* Empty */
	}

/* Method: init() */
/**
 * Specifies the code to be executed as startup time before the
 * <code>run</code> method is called.  Subclasses can override this
 * method to perform any initialization code that would ordinarily
 * be included in an applet <code>init</code> method.  In general,
 * subclasses will override <code>init</code> in GUI-based programs
 * where the program simply sets up an initial state and then waits
 * for events from the user.  The <code>run</code> method is required
 * for applications in which there needs to be some control thread
 * while the program runs, as in a typical animation.
 *
 * @usage program.init();
 */
	public void init() {
		/* Empty */
	}

/* Inherited method: print(value) */

    /* Inherited method: println() */

    /* Inherited method: println(value) */

    /* Inherited method: readLine() */

    /* Inherited method: readLine(prompt) */

    /* Inherited method: readInt() */

    /* Inherited method: readInt(prompt) */

    /* Inherited method: readDouble() */

    /* Inherited method: readDouble(prompt) */

    /* Inherited method: readBoolean() */

    /* Inherited method: readBoolean(prompt) */

    /* Inherited method: readBoolean(prompt) */

    /* Inherited method: getConsole() */

    /* Inherited method: getDialog() */

    /* Inherited method: getReader() */

    /* Inherited method: getWriter() */

    /* Inherited method: setTitle(title) */

    /* Inherited method: getTitle() */

    /* Inherited method: pause(milliseconds) */
}
