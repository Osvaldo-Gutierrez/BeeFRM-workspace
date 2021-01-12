/*
 *   Copyright (c) 2021 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.beebank.cloud.core.gns.gnsppfen;


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
public class WssPppv extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(WssPppv.class);

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public WssPppv() {

        initBuffer(13);

        replaceValue(0, 13, "             "); // WSS-PPPV
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
        replaceValue(0, 13, value);
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
        return subValue(0, 13);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setWssProv
     *******************************************************************************************************/
    /**
     *
     * @param wssProv TODO_javadoc.
     *
     */
    public void setWssProv(String wssProv) {
        replaceValue(0, 8, wssProv);
    }

    /*******************************************************************************************************
     * setFiller
     *******************************************************************************************************/
    /**
     *
     * @param filler TODO_javadoc.
     *
     */
    public void setFiller(String filler) {
        replaceValue(8, 9, filler);
    }

    /*******************************************************************************************************
     * setWssNtrv
     *******************************************************************************************************/
    /**
     *
     * @param wssNtrv TODO_javadoc.
     *
     */
    public void setWssNtrv(String wssNtrv) {
        replaceValue(9, 13, wssNtrv);
    }

    /*******************************************************************************************************
     * getWssProv
     *******************************************************************************************************/
    /**
     *
     * @return wssProv TODO_javadoc.
     *
     */
    public String getWssProv() {
        return subValue(0, 8);
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
        return subValue(8, 9);
    }

    /*******************************************************************************************************
     * getWssNtrv
     *******************************************************************************************************/
    /**
     *
     * @return wssNtrv TODO_javadoc.
     *
     */
    public String getWssNtrv() {
        return subValue(9, 13);
    }

}

