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
public class PgmStat extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(PgmStat.class);

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public PgmStat() {

        initBuffer(2);

        replaceValue(0, 2, "  "); // PGM-STAT
        replaceValue(0, 2, "23"); // PGM-STAT-TSI
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
        replaceValue(0, 2, value);
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
        return subValue(0, 2);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setPgmStatTsi
     *******************************************************************************************************/
    /**
     *
     * @param pgmStatTsi TODO_javadoc.
     *
     */
    public void setPgmStatTsi(String pgmStatTsi) {
        replaceValue(0, 2, pgmStatTsi);
    }

    /*******************************************************************************************************
     * getPgmStatTsi
     *******************************************************************************************************/
    /**
     *
     * @return pgmStatTsi TODO_javadoc.
     *
     */
    public String getPgmStatTsi() {
        return subValue(0, 2);
    }

    /*******************************************************************************************************
     * setPgmStatTsiOks
     *******************************************************************************************************/
    /**
     *
     * @param pgmStatTsiOks TODO_javadoc.
     *
     */
    public void setPgmStatTsiOks(boolean pgmStatTsiOks) {

        if (!pgmStatTsiOks) {
            throw new RuntimeException("Se intento setear pgmStatTsiOks con false.");
        }

        setPgmStatTsi("00");
    }

    /*******************************************************************************************************
     * isPgmStatTsiOks
     *******************************************************************************************************/
    /**
     *
     * @return pgmStatTsiOks TODO_javadoc.
     *
     */
    public boolean isPgmStatTsiOks() {
        return getPgmStatTsi().equals("00");
    }

    /*******************************************************************************************************
     * setPgmStatTsiNul
     *******************************************************************************************************/
    /**
     *
     * @param pgmStatTsiNul TODO_javadoc.
     *
     */
    public void setPgmStatTsiNul(boolean pgmStatTsiNul) {

        if (!pgmStatTsiNul) {
            throw new RuntimeException("Se intento setear pgmStatTsiNul con false.");
        }

        setPgmStatTsi("  ");
    }

    /*******************************************************************************************************
     * isPgmStatTsiNul
     *******************************************************************************************************/
    /**
     *
     * @return pgmStatTsiNul TODO_javadoc.
     *
     */
    public boolean isPgmStatTsiNul() {
        return getPgmStatTsi().equals("  ");
    }

}

