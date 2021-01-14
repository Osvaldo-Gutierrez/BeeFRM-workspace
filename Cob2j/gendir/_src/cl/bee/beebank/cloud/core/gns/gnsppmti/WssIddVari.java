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
public class WssIddVari extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(WssIddVari.class);

    /** TODO_javadoc. */
    private static DecimalFormat form4z = new DecimalFormat("0000");

    /** TODO_javadoc. */
    private WssQidd wssQidd = new WssQidd();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public WssIddVari() {

        initBuffer(12);

        replaceValue(0, 12, "000{        "); // WSS-IDD-VARI
        replaceValue(0, 4, setCompNumber(490, form4z)); // WSS-QIDD-LEN
        replaceValue(4, 8, "GIDD"); // WSS-NIDD
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
        replaceValue(0, 12, value);
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
        return subValue(0, 12);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setWssQiddLen
     *******************************************************************************************************/
    /**
     *
     * @param wssQiddLen TODO_javadoc.
     *
     */
    public void setWssQiddLen(int wssQiddLen) {
        replaceValue(0, 4, setCompNumber(wssQiddLen, form4z));
    }

    /*******************************************************************************************************
     * getWssQiddLen
     *******************************************************************************************************/
    /**
     *
     * @return wssQiddLen TODO_javadoc.
     *
     */
    public int getWssQiddLen() {
        return (int) getCompNumber(subValue(0, 4));
    }

    /*******************************************************************************************************
     * getWssQidd
     *******************************************************************************************************/
    /**
     *
     * @return wssQidd TODO_javadoc.
     *
     */
    public WssQidd getWssQidd() {
        return wssQidd;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class WssQidd {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssQidd() {
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
            replaceValue(4, 12, value);
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
            return subValue(4, 4 + 8);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setWssNidd
         *******************************************************************************************************/
        /**
         *
         * @param wssNidd TODO_javadoc.
         *
         */
        public void setWssNidd(String wssNidd) {
            replaceValue(4, 8, wssNidd);
        }

        /*******************************************************************************************************
         * setWssTidd
         *******************************************************************************************************/
        /**
         *
         * @param wssTidd TODO_javadoc.
         *
         */
        public void setWssTidd(String wssTidd) {
            replaceValue(8, 12, wssTidd);
        }

        /*******************************************************************************************************
         * getWssNidd
         *******************************************************************************************************/
        /**
         *
         * @return wssNidd TODO_javadoc.
         *
         */
        public String getWssNidd() {
            return subValue(4, 8);
        }

        /*******************************************************************************************************
         * getWssTidd
         *******************************************************************************************************/
        /**
         *
         * @return wssTidd TODO_javadoc.
         *
         */
        public String getWssTidd() {
            return subValue(8, 12);
        }

    }

}

