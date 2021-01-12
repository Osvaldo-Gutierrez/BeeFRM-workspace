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
public class RevRpfBdd extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(RevRpfBdd.class);

    /** TODO_javadoc. */
    private RevRpfBddTbl[] revRpfBddTbl = new RevRpfBddTbl[70];

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public RevRpfBdd() {

        initBuffer(70);

        replaceValue(0, 70, "                                                                      "); // REV-RPF-BDD

        for (int i = 0; i < 70; i++) {
            revRpfBddTbl[i] = new RevRpfBddTbl(i);
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
     * getRevRpfBddTbl
     *******************************************************************************************************/
    /**
     *
     * @param i TODO_javadoc.
     *
     * @return revRpfBddTbl TODO_javadoc.
     *
     */
    public RevRpfBddTbl getRevRpfBddTbl(int i) {

        if (i < 0 || i >= 70) {
            throw new ArrayIndexOutOfBoundsException("revRpfBddTbl[]: indice debe estar en rango [0..69]");
        }

        return revRpfBddTbl[i];
    }

    /*******************************************************************************************************
     * getRevRpfBddTblSize
     *******************************************************************************************************/
    /**
     *
     * @return TODO_javadoc.
     *
     */
    public final int getRevRpfBddTblSize() {
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
    public class RevRpfBddTbl {

        /** TODO_javadoc. */
        private final int length_revrpfbddtbl = 1;

        /** TODO_javadoc. */
        private int idx_revrpfbddtbl;

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         * @param idx TODO_javadoc.
         *
         */
        public RevRpfBddTbl(int idx) {

            this.idx_revrpfbddtbl = idx;
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
            replaceValue(idx_revrpfbddtbl * length_revrpfbddtbl + 0, idx_revrpfbddtbl * length_revrpfbddtbl + 1, value);
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
            return subValue(idx_revrpfbddtbl * length_revrpfbddtbl + 0, (idx_revrpfbddtbl + 1) * length_revrpfbddtbl + 0);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setRevRpfBddElm
         *******************************************************************************************************/
        /**
         *
         * @param revRpfBddElm TODO_javadoc.
         *
         */
        public void setRevRpfBddElm(String revRpfBddElm) {
            replaceValue(idx_revrpfbddtbl * length_revrpfbddtbl + 0, idx_revrpfbddtbl * length_revrpfbddtbl + 1, revRpfBddElm);
        }

        /*******************************************************************************************************
         * getRevRpfBddElm
         *******************************************************************************************************/
        /**
         *
         * @return revRpfBddElm TODO_javadoc.
         *
         */
        public String getRevRpfBddElm() {
            return subValue(idx_revrpfbddtbl * length_revrpfbddtbl + 0, idx_revrpfbddtbl * length_revrpfbddtbl + 1);
        }

    }

}

