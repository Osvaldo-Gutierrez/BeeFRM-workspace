/*
 *   Copyright (c) 2021 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.beebank.cloud.core.gns.gnsppmti;


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
public class WssErrMnuMens extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(WssErrMnuMens.class);

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public WssErrMnuMens() {

        initBuffer(79);

        replaceValue(0, 79, "                                                                               "); // WSS-ERR-MNU-MENS
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
        replaceValue(0, 79, value);
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
        return subValue(0, 79);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setWssErrMnuMens1
     *******************************************************************************************************/
    /**
     *
     * @param wssErrMnuMens1 TODO_javadoc.
     *
     */
    public void setWssErrMnuMens1(String wssErrMnuMens1) {
        replaceValue(0, 4, wssErrMnuMens1);
    }

    /*******************************************************************************************************
     * setWssErrMnuMens2
     *******************************************************************************************************/
    /**
     *
     * @param wssErrMnuMens2 TODO_javadoc.
     *
     */
    public void setWssErrMnuMens2(String wssErrMnuMens2) {
        replaceValue(4, 17, wssErrMnuMens2);
    }

    /*******************************************************************************************************
     * setWssErrMnuMens3
     *******************************************************************************************************/
    /**
     *
     * @param wssErrMnuMens3 TODO_javadoc.
     *
     */
    public void setWssErrMnuMens3(String wssErrMnuMens3) {
        replaceValue(17, 79, wssErrMnuMens3);
    }

    /*******************************************************************************************************
     * getWssErrMnuMens1
     *******************************************************************************************************/
    /**
     *
     * @return wssErrMnuMens1 TODO_javadoc.
     *
     */
    public String getWssErrMnuMens1() {
        return subValue(0, 4);
    }

    /*******************************************************************************************************
     * getWssErrMnuMens2
     *******************************************************************************************************/
    /**
     *
     * @return wssErrMnuMens2 TODO_javadoc.
     *
     */
    public String getWssErrMnuMens2() {
        return subValue(4, 17);
    }

    /*******************************************************************************************************
     * getWssErrMnuMens3
     *******************************************************************************************************/
    /**
     *
     * @return wssErrMnuMens3 TODO_javadoc.
     *
     */
    public String getWssErrMnuMens3() {
        return subValue(17, 79);
    }

}

