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
public class WssFormRcv extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(WssFormRcv.class);

    /** TODO_javadoc. */
    private WssPcATraductor wssPcATraductor = new WssPcATraductor();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public WssFormRcv() {

        initBuffer(12);

        replaceValue(0, 12, "            "); // WSS-FORM-RCV
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
     * getWssPcATraductor
     *******************************************************************************************************/
    /**
     *
     * @return wssPcATraductor TODO_javadoc.
     *
     */
    public WssPcATraductor getWssPcATraductor() {
        return wssPcATraductor;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class WssPcATraductor {

        /** TODO_javadoc. */
        private WssHeader wssHeader = new WssHeader();

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssPcATraductor() {
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
         * getWssHeader
         *******************************************************************************************************/
        /**
         *
         * @return wssHeader TODO_javadoc.
         *
         */
        public WssHeader getWssHeader() {
            return wssHeader;
        }

        /**
         *
         * TODO_javadoc.
         *
         * @author  BEE S.A.
         * @version 1.0
         *
         */
        public class WssHeader {

            /*******************************************************************************************************
             *
             *******************************************************************************************************/
            /**
             *
             */
            public WssHeader() {
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
             * setWssTran
             *******************************************************************************************************/
            /**
             *
             * @param wssTran TODO_javadoc.
             *
             */
            public void setWssTran(String wssTran) {
                replaceValue(0, 12, wssTran);
            }

            /*******************************************************************************************************
             * getWssTran
             *******************************************************************************************************/
            /**
             *
             * @return wssTran TODO_javadoc.
             *
             */
            public String getWssTran() {
                return subValue(0, 12);
            }

        }

    }

}

