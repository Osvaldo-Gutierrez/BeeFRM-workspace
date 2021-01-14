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
public class MsgTdo extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(MsgTdo.class);

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public MsgTdo() {

        initBuffer(92);

        replaceValue(0, 92, "                                                                                            "); // MSG-TDO
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
        replaceValue(0, 92, value);
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
        return subValue(0, 92);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setMsgTdoCodStat
     *******************************************************************************************************/
    /**
     *
     * @param msgTdoCodStat TODO_javadoc.
     *
     */
    public void setMsgTdoCodStat(String msgTdoCodStat) {
        replaceValue(0, 1, msgTdoCodStat);
    }

    /*******************************************************************************************************
     * setMsgTdoCodMsje
     *******************************************************************************************************/
    /**
     *
     * @param msgTdoCodMsje TODO_javadoc.
     *
     */
    public void setMsgTdoCodMsje(String msgTdoCodMsje) {
        replaceValue(1, 13, msgTdoCodMsje);
    }

    /*******************************************************************************************************
     * setMsgTdoGlsMsje
     *******************************************************************************************************/
    /**
     *
     * @param msgTdoGlsMsje TODO_javadoc.
     *
     */
    public void setMsgTdoGlsMsje(String msgTdoGlsMsje) {
        replaceValue(13, 92, msgTdoGlsMsje);
    }

    /*******************************************************************************************************
     * getMsgTdoCodStat
     *******************************************************************************************************/
    /**
     *
     * @return msgTdoCodStat TODO_javadoc.
     *
     */
    public String getMsgTdoCodStat() {
        return subValue(0, 1);
    }

    /*******************************************************************************************************
     * getMsgTdoCodMsje
     *******************************************************************************************************/
    /**
     *
     * @return msgTdoCodMsje TODO_javadoc.
     *
     */
    public String getMsgTdoCodMsje() {
        return subValue(1, 13);
    }

    /*******************************************************************************************************
     * getMsgTdoGlsMsje
     *******************************************************************************************************/
    /**
     *
     * @return msgTdoGlsMsje TODO_javadoc.
     *
     */
    public String getMsgTdoGlsMsje() {
        return subValue(13, 92);
    }

}

