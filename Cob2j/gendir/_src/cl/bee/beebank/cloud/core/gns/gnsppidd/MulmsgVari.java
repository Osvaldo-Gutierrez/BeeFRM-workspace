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
public class MulmsgVari extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(MulmsgVari.class);

    /** TODO_javadoc. */
    private MulmsgNomTspt mulmsgNomTspt = new MulmsgNomTspt();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public MulmsgVari() {

        initBuffer(8);

        replaceValue(0, 8, "        "); // MULMSG-VARI
        replaceValue(0, 4, "    "); // MULMSG-COD-TERM
        replaceValue(4, 8, "MMSG"); // MULMSG-COD-TYPE
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
     * getMulmsgNomTspt
     *******************************************************************************************************/
    /**
     *
     * @return mulmsgNomTspt TODO_javadoc.
     *
     */
    public MulmsgNomTspt getMulmsgNomTspt() {
        return mulmsgNomTspt;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class MulmsgNomTspt {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public MulmsgNomTspt() {
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
         * setMulmsgCodTerm
         *******************************************************************************************************/
        /**
         *
         * @param mulmsgCodTerm TODO_javadoc.
         *
         */
        public void setMulmsgCodTerm(String mulmsgCodTerm) {
            replaceValue(0, 4, mulmsgCodTerm);
        }

        /*******************************************************************************************************
         * setMulmsgCodType
         *******************************************************************************************************/
        /**
         *
         * @param mulmsgCodType TODO_javadoc.
         *
         */
        public void setMulmsgCodType(String mulmsgCodType) {
            replaceValue(4, 8, mulmsgCodType);
        }

        /*******************************************************************************************************
         * getMulmsgCodTerm
         *******************************************************************************************************/
        /**
         *
         * @return mulmsgCodTerm TODO_javadoc.
         *
         */
        public String getMulmsgCodTerm() {
            return subValue(0, 4);
        }

        /*******************************************************************************************************
         * getMulmsgCodType
         *******************************************************************************************************/
        /**
         *
         * @return mulmsgCodType TODO_javadoc.
         *
         */
        public String getMulmsgCodType() {
            return subValue(4, 8);
        }

    }

}

