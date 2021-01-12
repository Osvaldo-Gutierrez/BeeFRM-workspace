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
public class WssDedaPi1Deda extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(WssDedaPi1Deda.class);

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public WssDedaPi1Deda() {

        initBuffer(100);

        replaceValue(0, 100, "                                                                                                    "); // WSS-DEDA-PI1-DEDA
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
        replaceValue(0, 100, value);
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
        return subValue(0, 100);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setWssDedaPi1Desc
     *******************************************************************************************************/
    /**
     *
     * @param wssDedaPi1Desc TODO_javadoc.
     *
     */
    public void setWssDedaPi1Desc(String wssDedaPi1Desc) {
        replaceValue(0, 40, wssDedaPi1Desc);
    }

    /*******************************************************************************************************
     * setWssDedaPi1Data
     *******************************************************************************************************/
    /**
     *
     * @param wssDedaPi1Data TODO_javadoc.
     *
     */
    public void setWssDedaPi1Data(String wssDedaPi1Data) {
        replaceValue(40, 100, wssDedaPi1Data);
    }

    /*******************************************************************************************************
     * getWssDedaPi1Desc
     *******************************************************************************************************/
    /**
     *
     * @return wssDedaPi1Desc TODO_javadoc.
     *
     */
    public String getWssDedaPi1Desc() {
        return subValue(0, 40);
    }

    /*******************************************************************************************************
     * getWssDedaPi1Data
     *******************************************************************************************************/
    /**
     *
     * @return wssDedaPi1Data TODO_javadoc.
     *
     */
    public String getWssDedaPi1Data() {
        return subValue(40, 100);
    }

}

