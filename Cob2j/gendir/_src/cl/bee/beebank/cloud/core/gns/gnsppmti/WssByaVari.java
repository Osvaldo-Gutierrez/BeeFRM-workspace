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
public class WssByaVari extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(WssByaVari.class);

    /** TODO_javadoc. */
    private static DecimalFormat form4z = new DecimalFormat("0000");

    /** TODO_javadoc. */
    private WssByaCola wssByaCola = new WssByaCola();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public WssByaVari() {

        initBuffer(13);

        replaceValue(0, 13, "        000{ "); // WSS-BYA-VARI
        replaceValue(0, 4, "MBYA"); // WSS-BYA-TYPE
        replaceValue(8, 12, setCompNumber(1, form4z)); // WSS-BYA-LITM
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
        replaceValue(0, 13, value);
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
        return subValue(0, 13);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setWssByaLitm
     *******************************************************************************************************/
    /**
     *
     * @param wssByaLitm TODO_javadoc.
     *
     */
    public void setWssByaLitm(int wssByaLitm) {
        replaceValue(8, 12, setCompNumber(wssByaLitm, form4z));
    }

    /*******************************************************************************************************
     * setWssByaItem
     *******************************************************************************************************/
    /**
     *
     * @param wssByaItem TODO_javadoc.
     *
     */
    public void setWssByaItem(String wssByaItem) {
        replaceValue(12, 13, wssByaItem);
    }

    /*******************************************************************************************************
     * getWssByaCola
     *******************************************************************************************************/
    /**
     *
     * @return wssByaCola TODO_javadoc.
     *
     */
    public WssByaCola getWssByaCola() {
        return wssByaCola;
    }

    /*******************************************************************************************************
     * getWssByaLitm
     *******************************************************************************************************/
    /**
     *
     * @return wssByaLitm TODO_javadoc.
     *
     */
    public int getWssByaLitm() {
        return (int) getCompNumber(subValue(8, 12));
    }

    /*******************************************************************************************************
     * getWssByaItem
     *******************************************************************************************************/
    /**
     *
     * @return wssByaItem TODO_javadoc.
     *
     */
    public String getWssByaItem() {
        return subValue(12, 13);
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class WssByaCola {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssByaCola() {
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
         * setWssByaType
         *******************************************************************************************************/
        /**
         *
         * @param wssByaType TODO_javadoc.
         *
         */
        public void setWssByaType(String wssByaType) {
            replaceValue(0, 4, wssByaType);
        }

        /*******************************************************************************************************
         * setWssByaTerm
         *******************************************************************************************************/
        /**
         *
         * @param wssByaTerm TODO_javadoc.
         *
         */
        public void setWssByaTerm(String wssByaTerm) {
            replaceValue(4, 8, wssByaTerm);
        }

        /*******************************************************************************************************
         * getWssByaType
         *******************************************************************************************************/
        /**
         *
         * @return wssByaType TODO_javadoc.
         *
         */
        public String getWssByaType() {
            return subValue(0, 4);
        }

        /*******************************************************************************************************
         * getWssByaTerm
         *******************************************************************************************************/
        /**
         *
         * @return wssByaTerm TODO_javadoc.
         *
         */
        public String getWssByaTerm() {
            return subValue(4, 8);
        }

    }

}

