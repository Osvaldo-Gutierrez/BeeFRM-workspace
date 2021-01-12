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
public class WssDedaBddDeda extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(WssDedaBddDeda.class);

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public WssDedaBddDeda() {

        initBuffer(100);

        replaceValue(0, 100, "                                                                                                    "); // WSS-DEDA-BDD-DEDA
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
        replaceValue(0, 100, value);
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
        return subValue(0, 100);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setWssDedaBddDesc
     *******************************************************************************************************/
    /**
     *
     * @param wssDedaBddDesc TODO_javadoc.
     *
     */
    public void setWssDedaBddDesc(String wssDedaBddDesc) {
        replaceValue(0, 40, wssDedaBddDesc);
    }

    /*******************************************************************************************************
     * setWssDedaBddData
     *******************************************************************************************************/
    /**
     *
     * @param wssDedaBddData TODO_javadoc.
     *
     */
    public void setWssDedaBddData(String wssDedaBddData) {
        replaceValue(40, 100, wssDedaBddData);
    }

    /*******************************************************************************************************
     * getWssDedaBddDesc
     *******************************************************************************************************/
    /**
     *
     * @return wssDedaBddDesc TODO_javadoc.
     *
     */
    public String getWssDedaBddDesc() {
        return subValue(0, 40);
    }

    /*******************************************************************************************************
     * getWssDedaBddData
     *******************************************************************************************************/
    /**
     *
     * @return wssDedaBddData TODO_javadoc.
     *
     */
    public String getWssDedaBddData() {
        return subValue(40, 100);
    }

}

