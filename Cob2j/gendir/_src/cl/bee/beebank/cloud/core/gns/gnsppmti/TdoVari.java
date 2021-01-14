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
public class TdoVari extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(TdoVari.class);

    /** TODO_javadoc. */
    private static DecimalFormat form7z = new DecimalFormat("0000000");

    /** TODO_javadoc. */
    private TdoCola tdoCola = new TdoCola();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public TdoVari() {

        initBuffer(11);

        replaceValue(0, 11, "000000{    "); // TDO-VARI
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
     * getTdoCola
     *******************************************************************************************************/
    /**
     *
     * @return tdoCola TODO_javadoc.
     *
     */
    public TdoCola getTdoCola() {
        return tdoCola;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class TdoCola {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public TdoCola() {
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
         * setTdoTypeR
         *******************************************************************************************************/
        /**
         *
         * @param tdoTypeR TODO_javadoc.
         *
         */
        public void setTdoTypeR(int tdoTypeR) {
            replaceValue(0, 7, setCompNumber(tdoTypeR, form7z));
        }

        /*******************************************************************************************************
         * setTdoType
         *******************************************************************************************************/
        /**
         *
         * @param tdoType TODO_javadoc.
         *
         */
        public void setTdoType(String tdoType) {
            replaceValue(0, 4, tdoType);
        }

        /*******************************************************************************************************
         * setTdoTerm
         *******************************************************************************************************/
        /**
         *
         * @param tdoTerm TODO_javadoc.
         *
         */
        public void setTdoTerm(String tdoTerm) {
            replaceValue(7, 11, tdoTerm);
        }

        /*******************************************************************************************************
         * getTdoTypeR
         *******************************************************************************************************/
        /**
         *
         * @return tdoTypeR TODO_javadoc.
         *
         */
        public int getTdoTypeR() {
            return (int) getCompNumber(subValue(0, 7));
        }

        /*******************************************************************************************************
         * getTdoType
         *******************************************************************************************************/
        /**
         *
         * @return tdoType TODO_javadoc.
         *
         */
        public String getTdoType() {
            return subValue(0, 4);
        }

        /*******************************************************************************************************
         * getTdoTerm
         *******************************************************************************************************/
        /**
         *
         * @return tdoTerm TODO_javadoc.
         *
         */
        public String getTdoTerm() {
            return subValue(7, 11);
        }

    }

}

