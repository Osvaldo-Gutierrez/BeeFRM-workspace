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
public class WssAbpAmb extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(WssAbpAmb.class);

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public WssAbpAmb() {

        initBuffer(80);

        replaceValue(0, 80, "                                                                                "); // WSS-ABP-AMB
        replaceValue(0, 1, "N"); // WSS-ABP-AMB-COD-MENS
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
        replaceValue(0, 80, value);
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
        return subValue(0, 80);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setWssAbpAmbCodMens
     *******************************************************************************************************/
    /**
     *
     * @param wssAbpAmbCodMens TODO_javadoc.
     *
     */
    public void setWssAbpAmbCodMens(String wssAbpAmbCodMens) {
        replaceValue(0, 1, wssAbpAmbCodMens);
    }

    /*******************************************************************************************************
     * setWssAbpAmbGlsMens
     *******************************************************************************************************/
    /**
     *
     * @param wssAbpAmbGlsMens TODO_javadoc.
     *
     */
    public void setWssAbpAmbGlsMens(String wssAbpAmbGlsMens) {
        replaceValue(1, 80, wssAbpAmbGlsMens);
    }

    /*******************************************************************************************************
     * getWssAbpAmbCodMens
     *******************************************************************************************************/
    /**
     *
     * @return wssAbpAmbCodMens TODO_javadoc.
     *
     */
    public String getWssAbpAmbCodMens() {
        return subValue(0, 1);
    }

    /*******************************************************************************************************
     * getWssAbpAmbGlsMens
     *******************************************************************************************************/
    /**
     *
     * @return wssAbpAmbGlsMens TODO_javadoc.
     *
     */
    public String getWssAbpAmbGlsMens() {
        return subValue(1, 80);
    }

}

