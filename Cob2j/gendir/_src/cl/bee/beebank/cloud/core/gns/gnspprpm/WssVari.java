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
public class WssVari extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(WssVari.class);

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public WssVari() {

        initBuffer(3);

        replaceValue(0, 3, "   "); // WSS-VARI
        replaceValue(0, 3, "   "); // WSS-SIST
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
        replaceValue(0, 3, value);
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
        return subValue(0, 3);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setWssSist
     *******************************************************************************************************/
    /**
     *
     * @param wssSist TODO_javadoc.
     *
     */
    public void setWssSist(String wssSist) {
        replaceValue(0, 3, wssSist);
    }

    /*******************************************************************************************************
     * getWssSist
     *******************************************************************************************************/
    /**
     *
     * @return wssSist TODO_javadoc.
     *
     */
    public String getWssSist() {
        return subValue(0, 3);
    }

}

