/*
 *   Copyright (c) 2021 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.beebank.cloud.core.gns.gnsppfen;


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

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public WssCmma() {

        initBuffer(317);

        replaceValue(0, 317, "                                                                                                                                                                                                                                                                                                                             "); // WSS-CMMA
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
        replaceValue(0, 317, value);
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
        return subValue(0, 317);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setWssRfun
     *******************************************************************************************************/
    /**
     *
     * @param wssRfun TODO_javadoc.
     *
     */
    public void setWssRfun(String wssRfun) {
        replaceValue(0, 300, wssRfun);
    }

    /*******************************************************************************************************
     * setWssNsxc
     *******************************************************************************************************/
    /**
     *
     * @param wssNsxc TODO_javadoc.
     *
     */
    public void setWssNsxc(String wssNsxc) {
        replaceValue(300, 303, wssNsxc);
    }

    /*******************************************************************************************************
     * setWssGsxc
     *******************************************************************************************************/
    /**
     *
     * @param wssGsxc TODO_javadoc.
     *
     */
    public void setWssGsxc(String wssGsxc) {
        replaceValue(303, 306, wssGsxc);
    }

    /*******************************************************************************************************
     * setFiller
     *******************************************************************************************************/
    /**
     *
     * @param filler TODO_javadoc.
     *
     */
    public void setFiller(String filler) {
        replaceValue(306, 317, filler);
    }

    /*******************************************************************************************************
     * getWssRfun
     *******************************************************************************************************/
    /**
     *
     * @return wssRfun TODO_javadoc.
     *
     */
    public String getWssRfun() {
        return subValue(0, 300);
    }

    /*******************************************************************************************************
     * getWssNsxc
     *******************************************************************************************************/
    /**
     *
     * @return wssNsxc TODO_javadoc.
     *
     */
    public String getWssNsxc() {
        return subValue(300, 303);
    }

    /*******************************************************************************************************
     * getWssGsxc
     *******************************************************************************************************/
    /**
     *
     * @return wssGsxc TODO_javadoc.
     *
     */
    public String getWssGsxc() {
        return subValue(303, 306);
    }

    /*******************************************************************************************************
     * getFiller
     *******************************************************************************************************/
    /**
     *
     * @return filler TODO_javadoc.
     *
     */
    public String getFiller() {
        return subValue(306, 317);
    }

}

