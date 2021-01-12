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
public class WssRpf extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(WssRpf.class);

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public WssRpf() {

        initBuffer(120);

        replaceValue(0, 120, "                                                                                                                        "); // WSS-RPF
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
        replaceValue(0, 120, value);
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
        return subValue(0, 120);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setWssRpf1
     *******************************************************************************************************/
    /**
     *
     * @param wssRpf1 TODO_javadoc.
     *
     */
    public void setWssRpf1(String wssRpf1) {
        replaceValue(0, 60, wssRpf1);
    }

    /*******************************************************************************************************
     * setWssRpf2
     *******************************************************************************************************/
    /**
     *
     * @param wssRpf2 TODO_javadoc.
     *
     */
    public void setWssRpf2(String wssRpf2) {
        replaceValue(60, 120, wssRpf2);
    }

    /*******************************************************************************************************
     * getWssRpf1
     *******************************************************************************************************/
    /**
     *
     * @return wssRpf1 TODO_javadoc.
     *
     */
    public String getWssRpf1() {
        return subValue(0, 60);
    }

    /*******************************************************************************************************
     * getWssRpf2
     *******************************************************************************************************/
    /**
     *
     * @return wssRpf2 TODO_javadoc.
     *
     */
    public String getWssRpf2() {
        return subValue(60, 120);
    }

}

