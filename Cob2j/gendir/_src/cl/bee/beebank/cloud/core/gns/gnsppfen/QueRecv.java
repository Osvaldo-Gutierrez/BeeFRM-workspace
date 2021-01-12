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
public class QueRecv extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(QueRecv.class);

    /** TODO_javadoc. */
    private static DecimalFormat form2z = new DecimalFormat("00");

    /** TODO_javadoc. */
    private static DecimalFormat form4z = new DecimalFormat("0000");

    /** TODO_javadoc. */
    private static DecimalFormat form18z = new DecimalFormat("000000000000000000");

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public QueRecv() {

        initBuffer(9284);

        replaceValue(0, 9284, "0000000000000000000000000000                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "); // QUE-RECV
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
        replaceValue(0, 9284, value);
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
        return subValue(0, 9284);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setQueFilRecv
     *******************************************************************************************************/
    /**
     *
     * @param queFilRecv TODO_javadoc.
     *
     */
    public void setQueFilRecv(int queFilRecv) {
        replaceValue(0, 2, form2z.format(queFilRecv));
    }

    /*******************************************************************************************************
     * setQueStaRecv
     *******************************************************************************************************/
    /**
     *
     * @param queStaRecv TODO_javadoc.
     *
     */
    public void setQueStaRecv(long queStaRecv) {
        replaceValue(2, 20, form18z.format(queStaRecv));
    }

    /*******************************************************************************************************
     * setQueNumRecv
     *******************************************************************************************************/
    /**
     *
     * @param queNumRecv TODO_javadoc.
     *
     */
    public void setQueNumRecv(int queNumRecv) {
        replaceValue(20, 24, form4z.format(queNumRecv));
    }

    /*******************************************************************************************************
     * setQueLarRecv
     *******************************************************************************************************/
    /**
     *
     * @param queLarRecv TODO_javadoc.
     *
     */
    public void setQueLarRecv(int queLarRecv) {
        replaceValue(24, 28, form4z.format(queLarRecv));
    }

    /*******************************************************************************************************
     * setQueTrxRecv
     *******************************************************************************************************/
    /**
     *
     * @param queTrxRecv TODO_javadoc.
     *
     */
    public void setQueTrxRecv(String queTrxRecv) {
        replaceValue(28, 284, queTrxRecv);
    }

    /*******************************************************************************************************
     * setQueDatRecv
     *******************************************************************************************************/
    /**
     *
     * @param queDatRecv TODO_javadoc.
     *
     */
    public void setQueDatRecv(String queDatRecv) {
        replaceValue(284, 9284, queDatRecv);
    }

    /*******************************************************************************************************
     * getQueFilRecv
     *******************************************************************************************************/
    /**
     *
     * @return queFilRecv TODO_javadoc.
     *
     */
    public int getQueFilRecv() {
        return Integer.parseInt(subValue(0, 2));
    }

    /*******************************************************************************************************
     * getQueStaRecv
     *******************************************************************************************************/
    /**
     *
     * @return queStaRecv TODO_javadoc.
     *
     */
    public long getQueStaRecv() {
        return Long.parseLong(subValue(2, 20));
    }

    /*******************************************************************************************************
     * getQueNumRecv
     *******************************************************************************************************/
    /**
     *
     * @return queNumRecv TODO_javadoc.
     *
     */
    public int getQueNumRecv() {
        return Integer.parseInt(subValue(20, 24));
    }

    /*******************************************************************************************************
     * getQueLarRecv
     *******************************************************************************************************/
    /**
     *
     * @return queLarRecv TODO_javadoc.
     *
     */
    public int getQueLarRecv() {
        return Integer.parseInt(subValue(24, 28));
    }

    /*******************************************************************************************************
     * getQueTrxRecv
     *******************************************************************************************************/
    /**
     *
     * @return queTrxRecv TODO_javadoc.
     *
     */
    public String getQueTrxRecv() {
        return subValue(28, 284);
    }

    /*******************************************************************************************************
     * getQueDatRecv
     *******************************************************************************************************/
    /**
     *
     * @return queDatRecv TODO_javadoc.
     *
     */
    public String getQueDatRecv() {
        return subValue(284, 9284);
    }

}

