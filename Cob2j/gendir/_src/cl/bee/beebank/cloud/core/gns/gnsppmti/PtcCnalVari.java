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
public class PtcCnalVari extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(PtcCnalVari.class);

    /** TODO_javadoc. */
    private static DecimalFormat form4z = new DecimalFormat("0000");

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public PtcCnalVari() {

        initBuffer(8);

        replaceValue(0, 8, "    000{"); // PTC-CNAL-VARI
        replaceValue(0, 4, "CNAL"); // PTC-CNAL-TYPE
        replaceValue(4, 8, setCompNumber(15, form4z)); // PTC-CNAL-LENG
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
     * setPtcCnalType
     *******************************************************************************************************/
    /**
     *
     * @param ptcCnalType TODO_javadoc.
     *
     */
    public void setPtcCnalType(String ptcCnalType) {
        replaceValue(0, 4, ptcCnalType);
    }

    /*******************************************************************************************************
     * setPtcCnalLeng
     *******************************************************************************************************/
    /**
     *
     * @param ptcCnalLeng TODO_javadoc.
     *
     */
    public void setPtcCnalLeng(int ptcCnalLeng) {
        replaceValue(4, 8, setCompNumber(ptcCnalLeng, form4z));
    }

    /*******************************************************************************************************
     * getPtcCnalType
     *******************************************************************************************************/
    /**
     *
     * @return ptcCnalType TODO_javadoc.
     *
     */
    public String getPtcCnalType() {
        return subValue(0, 4);
    }

    /*******************************************************************************************************
     * getPtcCnalLeng
     *******************************************************************************************************/
    /**
     *
     * @return ptcCnalLeng TODO_javadoc.
     *
     */
    public int getPtcCnalLeng() {
        return (int) getCompNumber(subValue(4, 8));
    }

}

