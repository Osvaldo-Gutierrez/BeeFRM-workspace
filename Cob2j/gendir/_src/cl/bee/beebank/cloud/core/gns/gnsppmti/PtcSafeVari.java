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
public class PtcSafeVari extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(PtcSafeVari.class);

    /** TODO_javadoc. */
    private static DecimalFormat form4z = new DecimalFormat("0000");

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public PtcSafeVari() {

        initBuffer(8);

        replaceValue(0, 8, "    000{"); // PTC-SAFE-VARI
        replaceValue(0, 4, "SAFE"); // PTC-SAFE-TYPE
        replaceValue(4, 8, setCompNumber(3, form4z)); // PTC-SAFE-LENG
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
     * setPtcSafeType
     *******************************************************************************************************/
    /**
     *
     * @param ptcSafeType TODO_javadoc.
     *
     */
    public void setPtcSafeType(String ptcSafeType) {
        replaceValue(0, 4, ptcSafeType);
    }

    /*******************************************************************************************************
     * setPtcSafeLeng
     *******************************************************************************************************/
    /**
     *
     * @param ptcSafeLeng TODO_javadoc.
     *
     */
    public void setPtcSafeLeng(int ptcSafeLeng) {
        replaceValue(4, 8, setCompNumber(ptcSafeLeng, form4z));
    }

    /*******************************************************************************************************
     * getPtcSafeType
     *******************************************************************************************************/
    /**
     *
     * @return ptcSafeType TODO_javadoc.
     *
     */
    public String getPtcSafeType() {
        return subValue(0, 4);
    }

    /*******************************************************************************************************
     * getPtcSafeLeng
     *******************************************************************************************************/
    /**
     *
     * @return ptcSafeLeng TODO_javadoc.
     *
     */
    public int getPtcSafeLeng() {
        return (int) getCompNumber(subValue(4, 8));
    }

}

