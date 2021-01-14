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
public class PtcI24hVari extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(PtcI24hVari.class);

    /** TODO_javadoc. */
    private static DecimalFormat form4z = new DecimalFormat("0000");

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public PtcI24hVari() {

        initBuffer(8);

        replaceValue(0, 8, "    000{"); // PTC-I24H-VARI
        replaceValue(0, 4, "I24H"); // PTC-I24H-TYPE
        replaceValue(4, 8, setCompNumber(20, form4z)); // PTC-I24H-LENG
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
     * setPtcI24hType
     *******************************************************************************************************/
    /**
     *
     * @param ptcI24hType TODO_javadoc.
     *
     */
    public void setPtcI24hType(String ptcI24hType) {
        replaceValue(0, 4, ptcI24hType);
    }

    /*******************************************************************************************************
     * setPtcI24hLeng
     *******************************************************************************************************/
    /**
     *
     * @param ptcI24hLeng TODO_javadoc.
     *
     */
    public void setPtcI24hLeng(int ptcI24hLeng) {
        replaceValue(4, 8, setCompNumber(ptcI24hLeng, form4z));
    }

    /*******************************************************************************************************
     * getPtcI24hType
     *******************************************************************************************************/
    /**
     *
     * @return ptcI24hType TODO_javadoc.
     *
     */
    public String getPtcI24hType() {
        return subValue(0, 4);
    }

    /*******************************************************************************************************
     * getPtcI24hLeng
     *******************************************************************************************************/
    /**
     *
     * @return ptcI24hLeng TODO_javadoc.
     *
     */
    public int getPtcI24hLeng() {
        return (int) getCompNumber(subValue(4, 8));
    }

}

