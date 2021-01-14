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
public class WssTabCampo extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(WssTabCampo.class);

    /** TODO_javadoc. */
    private WssTabCampoOcc[] wssTabCampoOcc = new WssTabCampoOcc[120];

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public WssTabCampo() {

        initBuffer(120);

        replaceValue(0, 120, "                                                                                                                        "); // WSS-TAB-CAMPO

        for (int i = 0; i < 120; i++) {
            wssTabCampoOcc[i] = new WssTabCampoOcc(i);
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
        replaceValue(0, 120, value);
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
        return subValue(0, 120);
    }

    //
    //
    //

    /*******************************************************************************************************
     * getWssTabCampoOcc
     *******************************************************************************************************/
    /**
     *
     * @param i TODO_javadoc.
     *
     * @return wssTabCampoOcc TODO_javadoc.
     *
     */
    public WssTabCampoOcc getWssTabCampoOcc(int i) {

        if (i < 0 || i >= 120) {
            throw new ArrayIndexOutOfBoundsException("wssTabCampoOcc[]: indice debe estar en rango [0..119]");
        }

        return wssTabCampoOcc[i];
    }

    /*******************************************************************************************************
     * getWssTabCampoOccSize
     *******************************************************************************************************/
    /**
     *
     * @return TODO_javadoc.
     *
     */
    public final int getWssTabCampoOccSize() {
        return 120;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class WssTabCampoOcc {

        /** TODO_javadoc. */
        private final int length_wsstabcampoocc = 1;

        /** TODO_javadoc. */
        private int idx_wsstabcampoocc;

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         * @param idx TODO_javadoc.
         *
         */
        public WssTabCampoOcc(int idx) {

            this.idx_wsstabcampoocc = idx;
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
            replaceValue(idx_wsstabcampoocc * length_wsstabcampoocc + 0, idx_wsstabcampoocc * length_wsstabcampoocc + 1, value);
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
            return subValue(idx_wsstabcampoocc * length_wsstabcampoocc + 0, (idx_wsstabcampoocc + 1) * length_wsstabcampoocc + 0);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setWssTabCampoElm
         *******************************************************************************************************/
        /**
         *
         * @param wssTabCampoElm TODO_javadoc.
         *
         */
        public void setWssTabCampoElm(String wssTabCampoElm) {
            replaceValue(idx_wsstabcampoocc * length_wsstabcampoocc + 0, idx_wsstabcampoocc * length_wsstabcampoocc + 1, wssTabCampoElm);
        }

        /*******************************************************************************************************
         * getWssTabCampoElm
         *******************************************************************************************************/
        /**
         *
         * @return wssTabCampoElm TODO_javadoc.
         *
         */
        public String getWssTabCampoElm() {
            return subValue(idx_wsstabcampoocc * length_wsstabcampoocc + 0, idx_wsstabcampoocc * length_wsstabcampoocc + 1);
        }

    }

}

