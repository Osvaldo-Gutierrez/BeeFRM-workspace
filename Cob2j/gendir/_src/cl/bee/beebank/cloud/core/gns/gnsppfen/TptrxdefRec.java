/*
 *   Copyright (c) 2021 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.beebank.cloud.core.gns.gnsppfen;


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
public class TptrxdefRec extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(TptrxdefRec.class);

    /** TODO_javadoc. */
    private static DecimalFormat form9z = new DecimalFormat("000000000");

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public TptrxdefRec() {

        initBuffer(63);

        replaceValue(0, 63, "00000000{00000000{00000000{00000000{00000000{00000000{00000000{"); // TPTRXDEF-REC
        replaceValue(0, 9, setCompNumber(0, form9z)); // T-OUT
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
        replaceValue(0, 63, value);
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
        return subValue(0, 63);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setTOut
     *******************************************************************************************************/
    /**
     *
     * @param tOut TODO_javadoc.
     *
     */
    public void setTOut(int tOut) {
        replaceValue(0, 9, setCompNumber(tOut, form9z));
    }

    /*******************************************************************************************************
     * setTranid
     *******************************************************************************************************/
    /**
     *
     * @param tranid TODO_javadoc.
     *
     */
    public void setTranid(int[] tranid) {

        if (tranid == null || tranid.length != 6) {
            throw new IllegalArgumentException("tranid[]: no debe ser nulo y largo debe ser 6");
        }

        for (int i = 0; i < 6; i++) {
            replaceValue(9 + 9 * i, 9 + 9 * (i + 1), setCompNumber(tranid[i], form9z));
        }
    }

    /*******************************************************************************************************
     * setTranid
     *******************************************************************************************************/
    /**
     *
     * @param i TODO_javadoc.
     * @param tranid TODO_javadoc.
     *
     */
    public void setTranid(int i, int tranid) {

        if (i < 0 || i >= 6) {
            throw new ArrayIndexOutOfBoundsException("tranid[]: indice debe estar en rango [0..5]");
        }

        replaceValue(9 + 9 * i, 9 + 9 * (i + 1), setCompNumber(tranid, form9z));
    }

    /*******************************************************************************************************
     * getTOut
     *******************************************************************************************************/
    /**
     *
     * @return tOut TODO_javadoc.
     *
     */
    public int getTOut() {
        return (int) getCompNumber(subValue(0, 9));
    }

    /*******************************************************************************************************
     * getTranid
     *******************************************************************************************************/
    /**
     *
     * @param i TODO_javadoc.
     *
     * @return tranid TODO_javadoc.
     *
     */
    public int getTranid(int i) {

        if (i < 0 || i >= 6) {
            throw new ArrayIndexOutOfBoundsException("tranid[]: indice debe estar en rango [0..5]");
        }

        return (int) getCompNumber(subValue(9 + 9 * i, 9 + 9 * (i + 1)));
    }

    /*******************************************************************************************************
     * getTranidSize
     *******************************************************************************************************/
    /**
     *
     * @return TODO_javadoc.
     *
     */
    public final int getTranidSize() {
        return 6;
    }

}

