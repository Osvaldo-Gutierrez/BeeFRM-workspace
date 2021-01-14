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
public class NumCtts extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(NumCtts.class);

    /** TODO_javadoc. */
    private static DecimalFormat form1z = new DecimalFormat("0");

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public NumCtts() {

        initBuffer(4);

        replaceValue(0, 4, "0000"); // NUM-CTTS
        replaceValue(0, 1, form1z.format(1)); // NUM-ZERO-N
        replaceValue(1, 2, form1z.format(0)); // NUM-ZERO-S
        replaceValue(2, 3, form1z.format(0)); // NUM-SGNO-N
        replaceValue(3, 4, form1z.format(1)); // NUM-SGNO-S
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
        replaceValue(0, 4, value);
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
        return subValue(0, 4);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setNumZeroN
     *******************************************************************************************************/
    /**
     *
     * @param numZeroN TODO_javadoc.
     *
     */
    public void setNumZeroN(int numZeroN) {
        replaceValue(0, 1, form1z.format(numZeroN));
    }

    /*******************************************************************************************************
     * setNumZeroS
     *******************************************************************************************************/
    /**
     *
     * @param numZeroS TODO_javadoc.
     *
     */
    public void setNumZeroS(int numZeroS) {
        replaceValue(1, 2, form1z.format(numZeroS));
    }

    /*******************************************************************************************************
     * setNumSgnoN
     *******************************************************************************************************/
    /**
     *
     * @param numSgnoN TODO_javadoc.
     *
     */
    public void setNumSgnoN(int numSgnoN) {
        replaceValue(2, 3, form1z.format(numSgnoN));
    }

    /*******************************************************************************************************
     * setNumSgnoS
     *******************************************************************************************************/
    /**
     *
     * @param numSgnoS TODO_javadoc.
     *
     */
    public void setNumSgnoS(int numSgnoS) {
        replaceValue(3, 4, form1z.format(numSgnoS));
    }

    /*******************************************************************************************************
     * getNumZeroN
     *******************************************************************************************************/
    /**
     *
     * @return numZeroN TODO_javadoc.
     *
     */
    public int getNumZeroN() {
        return Integer.parseInt(subValue(0, 1));
    }

    /*******************************************************************************************************
     * getNumZeroS
     *******************************************************************************************************/
    /**
     *
     * @return numZeroS TODO_javadoc.
     *
     */
    public int getNumZeroS() {
        return Integer.parseInt(subValue(1, 2));
    }

    /*******************************************************************************************************
     * getNumSgnoN
     *******************************************************************************************************/
    /**
     *
     * @return numSgnoN TODO_javadoc.
     *
     */
    public int getNumSgnoN() {
        return Integer.parseInt(subValue(2, 3));
    }

    /*******************************************************************************************************
     * getNumSgnoS
     *******************************************************************************************************/
    /**
     *
     * @return numSgnoS TODO_javadoc.
     *
     */
    public int getNumSgnoS() {
        return Integer.parseInt(subValue(3, 4));
    }

}

