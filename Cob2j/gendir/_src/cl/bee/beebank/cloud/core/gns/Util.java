/*
 *   Copyright (c) 2020 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.beebank.cloud.core.gns;


import java.util.Arrays;

//import org.apache.log4j.Logger;


/**
 *
 * TODO_javadoc.
 *
 * @version 1.0 (01/01/2016).
 *
 */
public class Util {

    /** TODO_javadoc. */
  //private static Logger logger = Logger.getLogger(Util.class);

    /*******************************************************************************************************
     * spaces
     *******************************************************************************************************/
    /**
     *
     * @param size TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public static String spaces(int size) {

        char[] arr = new char[size];

        Arrays.fill(arr, ' ');

        return new String(arr);
    }

    /*******************************************************************************************************
     * intToString
     *******************************************************************************************************/
    /**
     *
     * @param i TODO_javadoc.
     * @param size TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public static String intToString(int i, int size) {
        throw new RuntimeException("intToString:: implementar.");
    }

    /*******************************************************************************************************
     * longToString
     *******************************************************************************************************/
    /**
     *
     * @param l TODO_javadoc.
     * @param size TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public static String longToString(long l, int size) {
        throw new RuntimeException("longToString:: implementar.");
    }

    /*******************************************************************************************************
     * doubleToString
     *******************************************************************************************************/
    /**
     *
     * @param d TODO_javadoc.
     * @param size TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public static String doubleToString(double d, int size) {
        throw new RuntimeException("doubleToString:: implementar.");
    }

}
