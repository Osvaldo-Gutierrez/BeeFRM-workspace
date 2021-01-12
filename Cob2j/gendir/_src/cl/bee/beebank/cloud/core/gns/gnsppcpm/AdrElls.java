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
public class AdrElls extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(AdrElls.class);

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public AdrElls() {

        initBuffer(11);

        replaceValue(0, 11, "           "); // ADR-ELLS
        replaceValue(6, 11, "     "); // FILLER
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
        replaceValue(0, 11, value);
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
        return subValue(0, 11);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setAdrElm1
     *******************************************************************************************************/
    /**
     *
     * @param adrElm1 TODO_javadoc.
     *
     */
    public void setAdrElm1(String adrElm1) {
        replaceValue(0, 5, adrElm1);
    }

    /*******************************************************************************************************
     * setAdrCseg
     *******************************************************************************************************/
    /**
     *
     * @param adrCseg TODO_javadoc.
     *
     */
    public void setAdrCseg(String adrCseg) {
        replaceValue(5, 6, adrCseg);
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
        replaceValue(6, 11, filler);
    }

    /*******************************************************************************************************
     * getAdrElm1
     *******************************************************************************************************/
    /**
     *
     * @return adrElm1 TODO_javadoc.
     *
     */
    public String getAdrElm1() {
        return subValue(0, 5);
    }

    /*******************************************************************************************************
     * getAdrCseg
     *******************************************************************************************************/
    /**
     *
     * @return adrCseg TODO_javadoc.
     *
     */
    public String getAdrCseg() {
        return subValue(5, 6);
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
        return subValue(6, 11);
    }

}

