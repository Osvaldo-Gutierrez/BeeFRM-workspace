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
public class CicEdt extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(CicEdt.class);

    /** TODO_javadoc. */
    private static DecimalFormat form8z = new DecimalFormat("00000000");

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public CicEdt() {

        initBuffer(8);

        replaceValue(0, 8, "00000000"); // CIC-EDT
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
     * setCicNumIcicEdt
     *******************************************************************************************************/
    /**
     *
     * @param cicNumIcicEdt TODO_javadoc.
     *
     */
    public void setCicNumIcicEdt(int cicNumIcicEdt) {
        replaceValue(0, 8, form8z.format(cicNumIcicEdt));
    }

    /*******************************************************************************************************
     * getCicNumIcicEdt
     *******************************************************************************************************/
    /**
     *
     * @return cicNumIcicEdt TODO_javadoc.
     *
     */
    public int getCicNumIcicEdt() {
        return Integer.parseInt(subValue(0, 8));
    }

}

