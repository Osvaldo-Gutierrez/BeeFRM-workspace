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
public class WssDedaDspDsp extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(WssDedaDspDsp.class);

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public WssDedaDspDsp() {

        initBuffer(100);

        replaceValue(0, 100, "                                                                                                    "); // WSS-DEDA-DSP-DSP
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
     * setWssDedaDspDesc
     *******************************************************************************************************/
    /**
     *
     * @param wssDedaDspDesc TODO_javadoc.
     *
     */
    public void setWssDedaDspDesc(String wssDedaDspDesc) {
        replaceValue(0, 40, wssDedaDspDesc);
    }

    /*******************************************************************************************************
     * setWssDedaDspData
     *******************************************************************************************************/
    /**
     *
     * @param wssDedaDspData TODO_javadoc.
     *
     */
    public void setWssDedaDspData(String wssDedaDspData) {
        replaceValue(40, 100, wssDedaDspData);
    }

    /*******************************************************************************************************
     * getWssDedaDspDesc
     *******************************************************************************************************/
    /**
     *
     * @return wssDedaDspDesc TODO_javadoc.
     *
     */
    public String getWssDedaDspDesc() {
        return subValue(0, 40);
    }

    /*******************************************************************************************************
     * getWssDedaDspData
     *******************************************************************************************************/
    /**
     *
     * @return wssDedaDspData TODO_javadoc.
     *
     */
    public String getWssDedaDspData() {
        return subValue(40, 100);
    }

}

