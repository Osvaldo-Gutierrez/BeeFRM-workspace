/*
 *   Copyright (c) 2021 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.beebank.cloud.core.gns.gnsppidd;


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
public class QueCtts extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(QueCtts.class);

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public QueCtts() {

        initBuffer(12);

        replaceValue(0, 12, "            "); // QUE-CTTS
        replaceValue(0, 3, "PUT"); // QUE-PUT
        replaceValue(3, 6, "GET"); // QUE-GET
        replaceValue(6, 9, "MOD"); // QUE-MOD
        replaceValue(9, 12, "DEL"); // QUE-DEL
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
        replaceValue(0, 12, value);
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
        return subValue(0, 12);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setQuePut
     *******************************************************************************************************/
    /**
     *
     * @param quePut TODO_javadoc.
     *
     */
    public void setQuePut(String quePut) {
        replaceValue(0, 3, quePut);
    }

    /*******************************************************************************************************
     * setQueGet
     *******************************************************************************************************/
    /**
     *
     * @param queGet TODO_javadoc.
     *
     */
    public void setQueGet(String queGet) {
        replaceValue(3, 6, queGet);
    }

    /*******************************************************************************************************
     * setQueMod
     *******************************************************************************************************/
    /**
     *
     * @param queMod TODO_javadoc.
     *
     */
    public void setQueMod(String queMod) {
        replaceValue(6, 9, queMod);
    }

    /*******************************************************************************************************
     * setQueDel
     *******************************************************************************************************/
    /**
     *
     * @param queDel TODO_javadoc.
     *
     */
    public void setQueDel(String queDel) {
        replaceValue(9, 12, queDel);
    }

    /*******************************************************************************************************
     * getQuePut
     *******************************************************************************************************/
    /**
     *
     * @return quePut TODO_javadoc.
     *
     */
    public String getQuePut() {
        return subValue(0, 3);
    }

    /*******************************************************************************************************
     * getQueGet
     *******************************************************************************************************/
    /**
     *
     * @return queGet TODO_javadoc.
     *
     */
    public String getQueGet() {
        return subValue(3, 6);
    }

    /*******************************************************************************************************
     * getQueMod
     *******************************************************************************************************/
    /**
     *
     * @return queMod TODO_javadoc.
     *
     */
    public String getQueMod() {
        return subValue(6, 9);
    }

    /*******************************************************************************************************
     * getQueDel
     *******************************************************************************************************/
    /**
     *
     * @return queDel TODO_javadoc.
     *
     */
    public String getQueDel() {
        return subValue(9, 12);
    }

}

