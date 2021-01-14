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
public class WssCmma extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(WssCmma.class);

    /** TODO_javadoc. */
    private WssOrig wssOrig = new WssOrig();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public WssCmma() {

        initBuffer(5);

        replaceValue(0, 5, "     "); // WSS-CMMA
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
        replaceValue(0, 5, value);
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
        return subValue(0, 5);
    }

    //
    //
    //

    /*******************************************************************************************************
     * getWssOrig
     *******************************************************************************************************/
    /**
     *
     * @return wssOrig TODO_javadoc.
     *
     */
    public WssOrig getWssOrig() {
        return wssOrig;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class WssOrig {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssOrig() {
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
            replaceValue(0, 5, value);
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
            return subValue(0, 5);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setWssModo
         *******************************************************************************************************/
        /**
         *
         * @param wssModo TODO_javadoc.
         *
         */
        public void setWssModo(String wssModo) {
            replaceValue(0, 1, wssModo);
        }

        /*******************************************************************************************************
         * setWssCnal
         *******************************************************************************************************/
        /**
         *
         * @param wssCnal TODO_javadoc.
         *
         */
        public void setWssCnal(String wssCnal) {
            replaceValue(1, 4, wssCnal);
        }

        /*******************************************************************************************************
         * setWssIerr
         *******************************************************************************************************/
        /**
         *
         * @param wssIerr TODO_javadoc.
         *
         */
        public void setWssIerr(String wssIerr) {
            replaceValue(4, 5, wssIerr);
        }

        /*******************************************************************************************************
         * getWssModo
         *******************************************************************************************************/
        /**
         *
         * @return wssModo TODO_javadoc.
         *
         */
        public String getWssModo() {
            return subValue(0, 1);
        }

        /*******************************************************************************************************
         * getWssCnal
         *******************************************************************************************************/
        /**
         *
         * @return wssCnal TODO_javadoc.
         *
         */
        public String getWssCnal() {
            return subValue(1, 4);
        }

        /*******************************************************************************************************
         * getWssIerr
         *******************************************************************************************************/
        /**
         *
         * @return wssIerr TODO_javadoc.
         *
         */
        public String getWssIerr() {
            return subValue(4, 5);
        }

    }

}

