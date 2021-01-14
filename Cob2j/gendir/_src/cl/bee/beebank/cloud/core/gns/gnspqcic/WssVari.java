/*
 *   Copyright (c) 2021 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.beebank.cloud.core.gns.gnspqcic;


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
public class WssVari extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(WssVari.class);

    /** TODO_javadoc. */
    private static DecimalFormat form3z = new DecimalFormat("000");

    /** TODO_javadoc. */
    private WssOgb01 wssOgb01 = new WssOgb01();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public WssVari() {

        initBuffer(7);

        replaceValue(0, 7, "    000"); // WSS-VARI
        replaceValue(0, 1, "X"); // WSS-X
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
        replaceValue(0, 7, value);
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
        return subValue(0, 7);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setWssX
     *******************************************************************************************************/
    /**
     *
     * @param wssX TODO_javadoc.
     *
     */
    public void setWssX(String wssX) {
        replaceValue(0, 1, wssX);
    }

    /*******************************************************************************************************
     * getWssX
     *******************************************************************************************************/
    /**
     *
     * @return wssX TODO_javadoc.
     *
     */
    public String getWssX() {
        return subValue(0, 1);
    }

    /*******************************************************************************************************
     * getWssOgb01
     *******************************************************************************************************/
    /**
     *
     * @return wssOgb01 TODO_javadoc.
     *
     */
    public WssOgb01 getWssOgb01() {
        return wssOgb01;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class WssOgb01 {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssOgb01() {
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
            replaceValue(1, 7, value);
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
            return subValue(1, 1 + 6);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setWssOgb11
         *******************************************************************************************************/
        /**
         *
         * @param wssOgb11 TODO_javadoc.
         *
         */
        public void setWssOgb11(String wssOgb11) {
            replaceValue(1, 4, wssOgb11);
        }

        /*******************************************************************************************************
         * setWssOgb12
         *******************************************************************************************************/
        /**
         *
         * @param wssOgb12 TODO_javadoc.
         *
         */
        public void setWssOgb12(int wssOgb12) {
            replaceValue(4, 7, form3z.format(wssOgb12));
        }

        /*******************************************************************************************************
         * getWssOgb11
         *******************************************************************************************************/
        /**
         *
         * @return wssOgb11 TODO_javadoc.
         *
         */
        public String getWssOgb11() {
            return subValue(1, 4);
        }

        /*******************************************************************************************************
         * getWssOgb12
         *******************************************************************************************************/
        /**
         *
         * @return wssOgb12 TODO_javadoc.
         *
         */
        public int getWssOgb12() {
            return Integer.parseInt(subValue(4, 7));
        }

    }

}

