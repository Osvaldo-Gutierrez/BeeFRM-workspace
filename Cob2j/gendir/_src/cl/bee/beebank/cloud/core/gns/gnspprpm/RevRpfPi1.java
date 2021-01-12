/*
 *   Copyright (c) 2021 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.beebank.cloud.core.gns.gnspprpm;


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
public class RevRpfPi1 extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(RevRpfPi1.class);

    /** TODO_javadoc. */
    private RevRpfPi1Tbl[] revRpfPi1Tbl = new RevRpfPi1Tbl[70];

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public RevRpfPi1() {

        initBuffer(70);

        replaceValue(0, 70, "                                                                      "); // REV-RPF-PI1

        for (int i = 0; i < 70; i++) {
            revRpfPi1Tbl[i] = new RevRpfPi1Tbl(i);
        }
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
        replaceValue(0, 70, value);
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
        return subValue(0, 70);
    }

    //
    //
    //

    /*******************************************************************************************************
     * getRevRpfPi1Tbl
     *******************************************************************************************************/
    /**
     *
     * @param i TODO_javadoc.
     *
     * @return revRpfPi1Tbl TODO_javadoc.
     *
     */
    public RevRpfPi1Tbl getRevRpfPi1Tbl(int i) {

        if (i < 0 || i >= 70) {
            throw new ArrayIndexOutOfBoundsException("revRpfPi1Tbl[]: indice debe estar en rango [0..69]");
        }

        return revRpfPi1Tbl[i];
    }

    /*******************************************************************************************************
     * getRevRpfPi1TblSize
     *******************************************************************************************************/
    /**
     *
     * @return TODO_javadoc.
     *
     */
    public final int getRevRpfPi1TblSize() {
        return 70;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class RevRpfPi1Tbl {

        /** TODO_javadoc. */
        private final int length_revrpfpi1tbl = 1;

        /** TODO_javadoc. */
        private int idx_revrpfpi1tbl;

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         * @param idx TODO_javadoc.
         *
         */
        public RevRpfPi1Tbl(int idx) {

            this.idx_revrpfpi1tbl = idx;
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
            replaceValue(idx_revrpfpi1tbl * length_revrpfpi1tbl + 0, idx_revrpfpi1tbl * length_revrpfpi1tbl + 1, value);
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
            return subValue(idx_revrpfpi1tbl * length_revrpfpi1tbl + 0, (idx_revrpfpi1tbl + 1) * length_revrpfpi1tbl + 0);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setRevRpfPi1Elm
         *******************************************************************************************************/
        /**
         *
         * @param revRpfPi1Elm TODO_javadoc.
         *
         */
        public void setRevRpfPi1Elm(String revRpfPi1Elm) {
            replaceValue(idx_revrpfpi1tbl * length_revrpfpi1tbl + 0, idx_revrpfpi1tbl * length_revrpfpi1tbl + 1, revRpfPi1Elm);
        }

        /*******************************************************************************************************
         * getRevRpfPi1Elm
         *******************************************************************************************************/
        /**
         *
         * @return revRpfPi1Elm TODO_javadoc.
         *
         */
        public String getRevRpfPi1Elm() {
            return subValue(idx_revrpfpi1tbl * length_revrpfpi1tbl + 0, idx_revrpfpi1tbl * length_revrpfpi1tbl + 1);
        }

    }

}

