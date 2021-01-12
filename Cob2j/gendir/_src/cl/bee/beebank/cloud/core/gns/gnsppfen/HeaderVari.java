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
public class HeaderVari extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(HeaderVari.class);

    /** TODO_javadoc. */
    private HeaderNomTspt headerNomTspt = new HeaderNomTspt();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public HeaderVari() {

        initBuffer(8);

        replaceValue(0, 8, "        "); // HEADER-VARI
        replaceValue(0, 2, "HE"); // HEADER-COD-TERM
        replaceValue(2, 8, "      "); // HEADER-COD-TYPE
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
     * getHeaderNomTspt
     *******************************************************************************************************/
    /**
     *
     * @return headerNomTspt TODO_javadoc.
     *
     */
    public HeaderNomTspt getHeaderNomTspt() {
        return headerNomTspt;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class HeaderNomTspt {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public HeaderNomTspt() {
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
         * setHeaderCodTerm
         *******************************************************************************************************/
        /**
         *
         * @param headerCodTerm TODO_javadoc.
         *
         */
        public void setHeaderCodTerm(String headerCodTerm) {
            replaceValue(0, 2, headerCodTerm);
        }

        /*******************************************************************************************************
         * setHeaderCodType
         *******************************************************************************************************/
        /**
         *
         * @param headerCodType TODO_javadoc.
         *
         */
        public void setHeaderCodType(String headerCodType) {
            replaceValue(2, 8, headerCodType);
        }

        /*******************************************************************************************************
         * getHeaderCodTerm
         *******************************************************************************************************/
        /**
         *
         * @return headerCodTerm TODO_javadoc.
         *
         */
        public String getHeaderCodTerm() {
            return subValue(0, 2);
        }

        /*******************************************************************************************************
         * getHeaderCodType
         *******************************************************************************************************/
        /**
         *
         * @return headerCodType TODO_javadoc.
         *
         */
        public String getHeaderCodType() {
            return subValue(2, 8);
        }

    }

}

