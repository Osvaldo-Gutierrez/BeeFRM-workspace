/*
 *   Copyright (c) 2021 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.beebank.cloud.core.gns.gnsppidd;


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
public class QueSend extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(QueSend.class);

    /** TODO_javadoc. */
    private static DecimalFormat form4z = new DecimalFormat("0000");

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public QueSend() {

        initBuffer(9567);

        replaceValue(0, 9567, "                                                                                                                                                                                                                                                                                                               00000000                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "); // QUE-SEND
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
        replaceValue(0, 9567, value);
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
        return subValue(0, 9567);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setQueComSend
     *******************************************************************************************************/
    /**
     *
     * @param queComSend TODO_javadoc.
     *
     */
    public void setQueComSend(String queComSend) {
        replaceValue(0, 3, queComSend);
    }

    /*******************************************************************************************************
     * setQueNamSend
     *******************************************************************************************************/
    /**
     *
     * @param queNamSend TODO_javadoc.
     *
     */
    public void setQueNamSend(String queNamSend) {
        replaceValue(3, 303, queNamSend);
    }

    /*******************************************************************************************************
     * setQueNumSend
     *******************************************************************************************************/
    /**
     *
     * @param queNumSend TODO_javadoc.
     *
     */
    public void setQueNumSend(int queNumSend) {
        replaceValue(303, 307, form4z.format(queNumSend));
    }

    /*******************************************************************************************************
     * setQueLarSend
     *******************************************************************************************************/
    /**
     *
     * @param queLarSend TODO_javadoc.
     *
     */
    public void setQueLarSend(int queLarSend) {
        replaceValue(307, 311, form4z.format(queLarSend));
    }

    /*******************************************************************************************************
     * setQueTrxSend
     *******************************************************************************************************/
    /**
     *
     * @param queTrxSend TODO_javadoc.
     *
     */
    public void setQueTrxSend(String queTrxSend) {
        replaceValue(311, 567, queTrxSend);
    }

    /*******************************************************************************************************
     * setQueDatSend
     *******************************************************************************************************/
    /**
     *
     * @param queDatSend TODO_javadoc.
     *
     */
    public void setQueDatSend(String queDatSend) {
        replaceValue(567, 9567, queDatSend);
    }

    /*******************************************************************************************************
     * getQueComSend
     *******************************************************************************************************/
    /**
     *
     * @return queComSend TODO_javadoc.
     *
     */
    public String getQueComSend() {
        return subValue(0, 3);
    }

    /*******************************************************************************************************
     * getQueNamSend
     *******************************************************************************************************/
    /**
     *
     * @return queNamSend TODO_javadoc.
     *
     */
    public String getQueNamSend() {
        return subValue(3, 303);
    }

    /*******************************************************************************************************
     * getQueNumSend
     *******************************************************************************************************/
    /**
     *
     * @return queNumSend TODO_javadoc.
     *
     */
    public int getQueNumSend() {
        return Integer.parseInt(subValue(303, 307));
    }

    /*******************************************************************************************************
     * getQueLarSend
     *******************************************************************************************************/
    /**
     *
     * @return queLarSend TODO_javadoc.
     *
     */
    public int getQueLarSend() {
        return Integer.parseInt(subValue(307, 311));
    }

    /*******************************************************************************************************
     * getQueTrxSend
     *******************************************************************************************************/
    /**
     *
     * @return queTrxSend TODO_javadoc.
     *
     */
    public String getQueTrxSend() {
        return subValue(311, 567);
    }

    /*******************************************************************************************************
     * getQueDatSend
     *******************************************************************************************************/
    /**
     *
     * @return queDatSend TODO_javadoc.
     *
     */
    public String getQueDatSend() {
        return subValue(567, 9567);
    }

}

