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
public class WssTscAuxi extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(WssTscAuxi.class);

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public WssTscAuxi() {

        initBuffer(68);

        replaceValue(0, 68, "                                                                    "); // WSS-TSC-AUXI
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
        replaceValue(0, 68, value);
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
        return subValue(0, 68);
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
        replaceValue(0, 5, filler);
    }

    /*******************************************************************************************************
     * setWssCmaOpci
     *******************************************************************************************************/
    /**
     *
     * @param wssCmaOpci TODO_javadoc.
     *
     */
    public void setWssCmaOpci(String wssCmaOpci) {
        replaceValue(5, 8, wssCmaOpci);
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
        replaceValue(8, 65, filler1);
    }

    /*******************************************************************************************************
     * setWssTscOpci
     *******************************************************************************************************/
    /**
     *
     * @param wssTscOpci TODO_javadoc.
     *
     */
    public void setWssTscOpci(String wssTscOpci) {
        replaceValue(65, 68, wssTscOpci);
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
        return subValue(0, 5);
    }

    /*******************************************************************************************************
     * getWssCmaOpci
     *******************************************************************************************************/
    /**
     *
     * @return wssCmaOpci TODO_javadoc.
     *
     */
    public String getWssCmaOpci() {
        return subValue(5, 8);
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
        return subValue(8, 65);
    }

    /*******************************************************************************************************
     * getWssTscOpci
     *******************************************************************************************************/
    /**
     *
     * @return wssTscOpci TODO_javadoc.
     *
     */
    public String getWssTscOpci() {
        return subValue(65, 68);
    }

}

