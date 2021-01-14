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
public class WssTslCola extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(WssTslCola.class);

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public WssTslCola() {

        initBuffer(8);

        replaceValue(0, 8, "        "); // WSS-TSL-COLA
        replaceValue(0, 4, "    "); // WSS-TSL-TERM
        replaceValue(4, 8, "AMBI"); // WSS-TSL-TYPE
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
        replaceValue(0, 8, value);
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
        return subValue(0, 8);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setWssTslTerm
     *******************************************************************************************************/
    /**
     *
     * @param wssTslTerm TODO_javadoc.
     *
     */
    public void setWssTslTerm(String wssTslTerm) {
        replaceValue(0, 4, wssTslTerm);
    }

    /*******************************************************************************************************
     * setWssTslType
     *******************************************************************************************************/
    /**
     *
     * @param wssTslType TODO_javadoc.
     *
     */
    public void setWssTslType(String wssTslType) {
        replaceValue(4, 8, wssTslType);
    }

    /*******************************************************************************************************
     * getWssTslTerm
     *******************************************************************************************************/
    /**
     *
     * @return wssTslTerm TODO_javadoc.
     *
     */
    public String getWssTslTerm() {
        return subValue(0, 4);
    }

    /*******************************************************************************************************
     * getWssTslType
     *******************************************************************************************************/
    /**
     *
     * @return wssTslType TODO_javadoc.
     *
     */
    public String getWssTslType() {
        return subValue(4, 8);
    }

}

