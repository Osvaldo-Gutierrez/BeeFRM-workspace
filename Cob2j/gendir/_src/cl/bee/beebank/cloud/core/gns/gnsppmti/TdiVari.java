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
public class TdiVari extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(TdiVari.class);

    /** TODO_javadoc. */
    private static DecimalFormat form7z = new DecimalFormat("0000000");

    /** TODO_javadoc. */
    private TdiCola tdiCola = new TdiCola();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public TdiVari() {

        initBuffer(11);

        replaceValue(0, 11, "000000{    "); // TDI-VARI
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
        replaceValue(0, 11, value);
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
        return subValue(0, 11);
    }

    //
    //
    //

    /*******************************************************************************************************
     * getTdiCola
     *******************************************************************************************************/
    /**
     *
     * @return tdiCola TODO_javadoc.
     *
     */
    public TdiCola getTdiCola() {
        return tdiCola;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class TdiCola {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public TdiCola() {
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
            replaceValue(0, 11, value);
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
            return subValue(0, 11);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setTdiTypeR
         *******************************************************************************************************/
        /**
         *
         * @param tdiTypeR TODO_javadoc.
         *
         */
        public void setTdiTypeR(int tdiTypeR) {
            replaceValue(0, 7, setCompNumber(tdiTypeR, form7z));
        }

        /*******************************************************************************************************
         * setTdiType
         *******************************************************************************************************/
        /**
         *
         * @param tdiType TODO_javadoc.
         *
         */
        public void setTdiType(String tdiType) {
            replaceValue(0, 4, tdiType);
        }

        /*******************************************************************************************************
         * setTdiTerm
         *******************************************************************************************************/
        /**
         *
         * @param tdiTerm TODO_javadoc.
         *
         */
        public void setTdiTerm(String tdiTerm) {
            replaceValue(7, 11, tdiTerm);
        }

        /*******************************************************************************************************
         * getTdiTypeR
         *******************************************************************************************************/
        /**
         *
         * @return tdiTypeR TODO_javadoc.
         *
         */
        public int getTdiTypeR() {
            return (int) getCompNumber(subValue(0, 7));
        }

        /*******************************************************************************************************
         * getTdiType
         *******************************************************************************************************/
        /**
         *
         * @return tdiType TODO_javadoc.
         *
         */
        public String getTdiType() {
            return subValue(0, 4);
        }

        /*******************************************************************************************************
         * getTdiTerm
         *******************************************************************************************************/
        /**
         *
         * @return tdiTerm TODO_javadoc.
         *
         */
        public String getTdiTerm() {
            return subValue(7, 11);
        }

    }

}

