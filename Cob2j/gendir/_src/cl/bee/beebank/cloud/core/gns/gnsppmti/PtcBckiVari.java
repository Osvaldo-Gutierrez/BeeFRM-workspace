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
public class PtcBckiVari extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(PtcBckiVari.class);

    /** TODO_javadoc. */
    private static DecimalFormat form4z = new DecimalFormat("0000");

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public PtcBckiVari() {

        initBuffer(8);

        replaceValue(0, 8, "    000{"); // PTC-BCKI-VARI
        replaceValue(0, 4, "BCKI"); // PTC-BCKI-TYPE
        replaceValue(4, 8, setCompNumber(3, form4z)); // PTC-BCKI-LENG
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
     * setPtcBckiType
     *******************************************************************************************************/
    /**
     *
     * @param ptcBckiType TODO_javadoc.
     *
     */
    public void setPtcBckiType(String ptcBckiType) {
        replaceValue(0, 4, ptcBckiType);
    }

    /*******************************************************************************************************
     * setPtcBckiLeng
     *******************************************************************************************************/
    /**
     *
     * @param ptcBckiLeng TODO_javadoc.
     *
     */
    public void setPtcBckiLeng(int ptcBckiLeng) {
        replaceValue(4, 8, setCompNumber(ptcBckiLeng, form4z));
    }

    /*******************************************************************************************************
     * getPtcBckiType
     *******************************************************************************************************/
    /**
     *
     * @return ptcBckiType TODO_javadoc.
     *
     */
    public String getPtcBckiType() {
        return subValue(0, 4);
    }

    /*******************************************************************************************************
     * getPtcBckiLeng
     *******************************************************************************************************/
    /**
     *
     * @return ptcBckiLeng TODO_javadoc.
     *
     */
    public int getPtcBckiLeng() {
        return (int) getCompNumber(subValue(4, 8));
    }

}

