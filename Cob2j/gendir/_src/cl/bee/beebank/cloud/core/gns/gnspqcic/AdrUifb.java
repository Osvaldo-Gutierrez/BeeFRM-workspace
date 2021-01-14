/*
 *   Copyright (c) 2021 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.beebank.cloud.core.gns.gnspqcic;


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
public class AdrUifb extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(AdrUifb.class);

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public AdrUifb() {

        initBuffer(32);

        replaceValue(0, 32, "                                "); // ADR-UIFB
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
        replaceValue(0, 32, value);
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
        return subValue(0, 32);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setAdrProg
     *******************************************************************************************************/
    /**
     *
     * @param adrProg TODO_javadoc.
     *
     */
    public void setAdrProg(String adrProg) {
        replaceValue(0, 8, adrProg);
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
        replaceValue(8, 32, filler);
    }

    /*******************************************************************************************************
     * getAdrProg
     *******************************************************************************************************/
    /**
     *
     * @return adrProg TODO_javadoc.
     *
     */
    public String getAdrProg() {
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
        return subValue(8, 32);
    }

}

