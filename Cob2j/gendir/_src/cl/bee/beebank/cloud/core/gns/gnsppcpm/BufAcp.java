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
public class BufAcp extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(BufAcp.class);

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public BufAcp() {

        initBuffer(60);

        replaceValue(0, 60, "                                                            "); // BUF-ACP
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
        replaceValue(0, 60, value);
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
        return subValue(0, 60);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setBufAcp1
     *******************************************************************************************************/
    /**
     *
     * @param bufAcp1 TODO_javadoc.
     *
     */
    public void setBufAcp1(String bufAcp1) {
        replaceValue(0, 6, bufAcp1);
    }

    /*******************************************************************************************************
     * setBufAcp2
     *******************************************************************************************************/
    /**
     *
     * @param bufAcp2 TODO_javadoc.
     *
     */
    public void setBufAcp2(String bufAcp2) {
        replaceValue(6, 9, bufAcp2);
    }

    /*******************************************************************************************************
     * setBufAcp3
     *******************************************************************************************************/
    /**
     *
     * @param bufAcp3 TODO_javadoc.
     *
     */
    public void setBufAcp3(String bufAcp3) {
        replaceValue(9, 60, bufAcp3);
    }

    /*******************************************************************************************************
     * getBufAcp1
     *******************************************************************************************************/
    /**
     *
     * @return bufAcp1 TODO_javadoc.
     *
     */
    public String getBufAcp1() {
        return subValue(0, 6);
    }

    /*******************************************************************************************************
     * getBufAcp2
     *******************************************************************************************************/
    /**
     *
     * @return bufAcp2 TODO_javadoc.
     *
     */
    public String getBufAcp2() {
        return subValue(6, 9);
    }

    /*******************************************************************************************************
     * getBufAcp3
     *******************************************************************************************************/
    /**
     *
     * @return bufAcp3 TODO_javadoc.
     *
     */
    public String getBufAcp3() {
        return subValue(9, 60);
    }

}

