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
public class PtcIbyaVari extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(PtcIbyaVari.class);

    /** TODO_javadoc. */
    private static DecimalFormat form4z = new DecimalFormat("0000");

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public PtcIbyaVari() {

        initBuffer(8);

        replaceValue(0, 8, "    000{"); // PTC-IBYA-VARI
        replaceValue(0, 4, "IBYA"); // PTC-IBYA-TYPE
        replaceValue(4, 8, setCompNumber(1, form4z)); // PTC-IBYA-LENG
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
     * setPtcIbyaType
     *******************************************************************************************************/
    /**
     *
     * @param ptcIbyaType TODO_javadoc.
     *
     */
    public void setPtcIbyaType(String ptcIbyaType) {
        replaceValue(0, 4, ptcIbyaType);
    }

    /*******************************************************************************************************
     * setPtcIbyaLeng
     *******************************************************************************************************/
    /**
     *
     * @param ptcIbyaLeng TODO_javadoc.
     *
     */
    public void setPtcIbyaLeng(int ptcIbyaLeng) {
        replaceValue(4, 8, setCompNumber(ptcIbyaLeng, form4z));
    }

    /*******************************************************************************************************
     * getPtcIbyaType
     *******************************************************************************************************/
    /**
     *
     * @return ptcIbyaType TODO_javadoc.
     *
     */
    public String getPtcIbyaType() {
        return subValue(0, 4);
    }

    /*******************************************************************************************************
     * getPtcIbyaLeng
     *******************************************************************************************************/
    /**
     *
     * @return ptcIbyaLeng TODO_javadoc.
     *
     */
    public int getPtcIbyaLeng() {
        return (int) getCompNumber(subValue(4, 8));
    }

}

