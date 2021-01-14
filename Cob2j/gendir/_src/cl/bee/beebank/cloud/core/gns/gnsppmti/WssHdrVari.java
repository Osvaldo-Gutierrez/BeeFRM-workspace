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
public class WssHdrVari extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(WssHdrVari.class);

    /** TODO_javadoc. */
    private static DecimalFormat form3z = new DecimalFormat("000");

    /** TODO_javadoc. */
    private static DecimalFormat form4z = new DecimalFormat("0000");

    /** TODO_javadoc. */
    private WssHdrCola wssHdrCola = new WssHdrCola();

    /** TODO_javadoc. */
    private WssHdrItem wssHdrItem = new WssHdrItem();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public WssHdrVari() {

        initBuffer(15);

        replaceValue(0, 15, "        000{000"); // WSS-HDR-VARI
        replaceValue(0, 4, "MHDR"); // WSS-HDR-TYPE
        replaceValue(8, 12, setCompNumber(3, form4z)); // WSS-HDR-LITM
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
        replaceValue(0, 15, value);
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
        return subValue(0, 15);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setWssHdrLitm
     *******************************************************************************************************/
    /**
     *
     * @param wssHdrLitm TODO_javadoc.
     *
     */
    public void setWssHdrLitm(int wssHdrLitm) {
        replaceValue(8, 12, setCompNumber(wssHdrLitm, form4z));
    }

    /*******************************************************************************************************
     * getWssHdrCola
     *******************************************************************************************************/
    /**
     *
     * @return wssHdrCola TODO_javadoc.
     *
     */
    public WssHdrCola getWssHdrCola() {
        return wssHdrCola;
    }

    /*******************************************************************************************************
     * getWssHdrLitm
     *******************************************************************************************************/
    /**
     *
     * @return wssHdrLitm TODO_javadoc.
     *
     */
    public int getWssHdrLitm() {
        return (int) getCompNumber(subValue(8, 12));
    }

    /*******************************************************************************************************
     * getWssHdrItem
     *******************************************************************************************************/
    /**
     *
     * @return wssHdrItem TODO_javadoc.
     *
     */
    public WssHdrItem getWssHdrItem() {
        return wssHdrItem;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class WssHdrCola {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssHdrCola() {
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
         * setWssHdrType
         *******************************************************************************************************/
        /**
         *
         * @param wssHdrType TODO_javadoc.
         *
         */
        public void setWssHdrType(String wssHdrType) {
            replaceValue(0, 4, wssHdrType);
        }

        /*******************************************************************************************************
         * setWssHdrTerm
         *******************************************************************************************************/
        /**
         *
         * @param wssHdrTerm TODO_javadoc.
         *
         */
        public void setWssHdrTerm(String wssHdrTerm) {
            replaceValue(4, 8, wssHdrTerm);
        }

        /*******************************************************************************************************
         * getWssHdrType
         *******************************************************************************************************/
        /**
         *
         * @return wssHdrType TODO_javadoc.
         *
         */
        public String getWssHdrType() {
            return subValue(0, 4);
        }

        /*******************************************************************************************************
         * getWssHdrTerm
         *******************************************************************************************************/
        /**
         *
         * @return wssHdrTerm TODO_javadoc.
         *
         */
        public String getWssHdrTerm() {
            return subValue(4, 8);
        }

    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class WssHdrItem {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssHdrItem() {
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
            replaceValue(12, 15, value);
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
            return subValue(12, 12 + 3);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setWssHdrLhdr
         *******************************************************************************************************/
        /**
         *
         * @param wssHdrLhdr TODO_javadoc.
         *
         */
        public void setWssHdrLhdr(int wssHdrLhdr) {
            replaceValue(12, 15, form3z.format(wssHdrLhdr));
        }

        /*******************************************************************************************************
         * getWssHdrLhdr
         *******************************************************************************************************/
        /**
         *
         * @return wssHdrLhdr TODO_javadoc.
         *
         */
        public int getWssHdrLhdr() {
            return Integer.parseInt(subValue(12, 15));
        }

    }

}

