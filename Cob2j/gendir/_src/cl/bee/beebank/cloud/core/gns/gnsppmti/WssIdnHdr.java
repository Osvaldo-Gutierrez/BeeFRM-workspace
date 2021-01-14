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
public class WssIdnHdr extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(WssIdnHdr.class);

    /** TODO_javadoc. */
    private WssIdnHdrOcc[] wssIdnHdrOcc = new WssIdnHdrOcc[12];

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public WssIdnHdr() {

        initBuffer(12);

        replaceValue(0, 12, "            "); // WSS-IDN-HDR

        for (int i = 0; i < 12; i++) {
            wssIdnHdrOcc[i] = new WssIdnHdrOcc(i);
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
     * getWssIdnHdrOcc
     *******************************************************************************************************/
    /**
     *
     * @param i TODO_javadoc.
     *
     * @return wssIdnHdrOcc TODO_javadoc.
     *
     */
    public WssIdnHdrOcc getWssIdnHdrOcc(int i) {

        if (i < 0 || i >= 12) {
            throw new ArrayIndexOutOfBoundsException("wssIdnHdrOcc[]: indice debe estar en rango [0..11]");
        }

        return wssIdnHdrOcc[i];
    }

    /*******************************************************************************************************
     * getWssIdnHdrOccSize
     *******************************************************************************************************/
    /**
     *
     * @return TODO_javadoc.
     *
     */
    public final int getWssIdnHdrOccSize() {
        return 12;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class WssIdnHdrOcc {

        /** TODO_javadoc. */
        private final int length_wssidnhdrocc = 1;

        /** TODO_javadoc. */
        private int idx_wssidnhdrocc;

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         * @param idx TODO_javadoc.
         *
         */
        public WssIdnHdrOcc(int idx) {

            this.idx_wssidnhdrocc = idx;
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
            replaceValue(idx_wssidnhdrocc * length_wssidnhdrocc + 0, idx_wssidnhdrocc * length_wssidnhdrocc + 1, value);
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
            return subValue(idx_wssidnhdrocc * length_wssidnhdrocc + 0, (idx_wssidnhdrocc + 1) * length_wssidnhdrocc + 0);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setWssIdnHdrElm
         *******************************************************************************************************/
        /**
         *
         * @param wssIdnHdrElm TODO_javadoc.
         *
         */
        public void setWssIdnHdrElm(String wssIdnHdrElm) {
            replaceValue(idx_wssidnhdrocc * length_wssidnhdrocc + 0, idx_wssidnhdrocc * length_wssidnhdrocc + 1, wssIdnHdrElm);
        }

        /*******************************************************************************************************
         * getWssIdnHdrElm
         *******************************************************************************************************/
        /**
         *
         * @return wssIdnHdrElm TODO_javadoc.
         *
         */
        public String getWssIdnHdrElm() {
            return subValue(idx_wssidnhdrocc * length_wssidnhdrocc + 0, idx_wssidnhdrocc * length_wssidnhdrocc + 1);
        }

    }

}

