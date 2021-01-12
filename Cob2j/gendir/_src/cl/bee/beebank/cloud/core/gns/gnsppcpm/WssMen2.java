/*
 *   Copyright (c) 2021 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.beebank.cloud.core.gns.gnsppcpm;


import java.text.DecimalFormat;

import java.util.Arrays;

import cl.bee.beebank.cloud.core.gns.Root;

//import org.apache.log4j.Logger;

/**
 *
 * TODO_javadoc.
 *
 * @author  BEE S.A.
 * @version 1.0
 *
 */
public class WssMen2 extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(WssMen2.class);

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public WssMen2() {

        initBuffer(70);

        replaceValue(0, 70, "                                                                      "); // WSS-MEN2
        replaceValue(0, 10, "| CMT : | "); // FILLER
        replaceValue(10, 69, "                                                           "); // MEN2-AREA
        replaceValue(69, 70, "|"); // FILLER-1
    }

    //
    //
    //

    /*******************************************************************************************************
     * setValue
     *******************************************************************************************************/
    /**
     *
     * @param value TODO_javadoc.
     *
     */
    public void setValue(String value) {
        replaceValue(0, 70, value);
    }

    /*******************************************************************************************************
     * getValue
     *******************************************************************************************************/
    /**
     *
     * @return value TODO_javadoc.
     *
     */
    public String getValue() {
        return subValue(0, 70);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setFiller
     *******************************************************************************************************/
    /**
     *
     * @param filler TODO_javadoc.
     *
     */
    public void setFiller(String filler) {
        replaceValue(0, 10, filler);
    }

    /*******************************************************************************************************
     * setMen2Area
     *******************************************************************************************************/
    /**
     *
     * @param men2Area TODO_javadoc.
     *
     */
    public void setMen2Area(String men2Area) {
        replaceValue(10, 69, men2Area);
    }

    /*******************************************************************************************************
     * setFiller1
     *******************************************************************************************************/
    /**
     *
     * @param filler1 TODO_javadoc.
     *
     */
    public void setFiller1(String filler1) {
        replaceValue(69, 70, filler1);
    }

    /*******************************************************************************************************
     * getFiller
     *******************************************************************************************************/
    /**
     *
     * @return filler TODO_javadoc.
     *
     */
    public String getFiller() {
        return subValue(0, 10);
    }

    /*******************************************************************************************************
     * getMen2Area
     *******************************************************************************************************/
    /**
     *
     * @return men2Area TODO_javadoc.
     *
     */
    public String getMen2Area() {
        return subValue(10, 69);
    }

    /*******************************************************************************************************
     * getFiller1
     *******************************************************************************************************/
    /**
     *
     * @return filler1 TODO_javadoc.
     *
     */
    public String getFiller1() {
        return subValue(69, 70);
    }

}

