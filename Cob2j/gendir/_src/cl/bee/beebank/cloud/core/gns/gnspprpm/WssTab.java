/*
 *   Copyright (c) 2021 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.beebank.cloud.core.gns.gnspprpm;


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
public class WssTab extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(WssTab.class);

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public WssTab() {

        initBuffer(240);

        replaceValue(0, 240, "                                                                                                                                                                                                                                                "); // WSS-TAB
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
        replaceValue(0, 240, value);
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
        return subValue(0, 240);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setWssTab1
     *******************************************************************************************************/
    /**
     *
     * @param wssTab1 TODO_javadoc.
     *
     */
    public void setWssTab1(String wssTab1) {
        replaceValue(0, 60, wssTab1);
    }

    /*******************************************************************************************************
     * setWssTab2
     *******************************************************************************************************/
    /**
     *
     * @param wssTab2 TODO_javadoc.
     *
     */
    public void setWssTab2(String wssTab2) {
        replaceValue(60, 120, wssTab2);
    }

    /*******************************************************************************************************
     * setWssTab3
     *******************************************************************************************************/
    /**
     *
     * @param wssTab3 TODO_javadoc.
     *
     */
    public void setWssTab3(String wssTab3) {
        replaceValue(120, 180, wssTab3);
    }

    /*******************************************************************************************************
     * setWssTab4
     *******************************************************************************************************/
    /**
     *
     * @param wssTab4 TODO_javadoc.
     *
     */
    public void setWssTab4(String wssTab4) {
        replaceValue(180, 240, wssTab4);
    }

    /*******************************************************************************************************
     * getWssTab1
     *******************************************************************************************************/
    /**
     *
     * @return wssTab1 TODO_javadoc.
     *
     */
    public String getWssTab1() {
        return subValue(0, 60);
    }

    /*******************************************************************************************************
     * getWssTab2
     *******************************************************************************************************/
    /**
     *
     * @return wssTab2 TODO_javadoc.
     *
     */
    public String getWssTab2() {
        return subValue(60, 120);
    }

    /*******************************************************************************************************
     * getWssTab3
     *******************************************************************************************************/
    /**
     *
     * @return wssTab3 TODO_javadoc.
     *
     */
    public String getWssTab3() {
        return subValue(120, 180);
    }

    /*******************************************************************************************************
     * getWssTab4
     *******************************************************************************************************/
    /**
     *
     * @return wssTab4 TODO_javadoc.
     *
     */
    public String getWssTab4() {
        return subValue(180, 240);
    }

}

