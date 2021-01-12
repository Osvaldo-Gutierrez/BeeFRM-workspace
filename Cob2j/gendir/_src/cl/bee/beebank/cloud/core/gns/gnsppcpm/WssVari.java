/*
 *   Copyright (c) 2021 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.beebank.cloud.core.gns.gnsppcpm;


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
    private static DecimalFormat form6z = new DecimalFormat("000000");

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public WssVari() {

        initBuffer(12);

        replaceValue(0, 12, "000000      "); // WSS-VARI
        replaceValue(0, 6, form6z.format(0)); // WSS-I
        replaceValue(6, 9, "   "); // WSS-SIST
        replaceValue(9, 10, "N"); // WSS-SOLO-TAB
        replaceValue(10, 11, "N"); // WSS-MNU-OPEN
        replaceValue(11, 12, "N"); // WSS-RPF-OPEN
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
     * setWssI
     *******************************************************************************************************/
    /**
     *
     * @param wssI TODO_javadoc.
     *
     */
    public void setWssI(int wssI) {
        replaceValue(0, 6, form6z.format(wssI));
    }

    /*******************************************************************************************************
     * setWssSist
     *******************************************************************************************************/
    /**
     *
     * @param wssSist TODO_javadoc.
     *
     */
    public void setWssSist(String wssSist) {
        replaceValue(6, 9, wssSist);
    }

    /*******************************************************************************************************
     * setWssSoloTab
     *******************************************************************************************************/
    /**
     *
     * @param wssSoloTab TODO_javadoc.
     *
     */
    public void setWssSoloTab(String wssSoloTab) {
        replaceValue(9, 10, wssSoloTab);
    }

    /*******************************************************************************************************
     * setWssMnuOpen
     *******************************************************************************************************/
    /**
     *
     * @param wssMnuOpen TODO_javadoc.
     *
     */
    public void setWssMnuOpen(String wssMnuOpen) {
        replaceValue(10, 11, wssMnuOpen);
    }

    /*******************************************************************************************************
     * setWssRpfOpen
     *******************************************************************************************************/
    /**
     *
     * @param wssRpfOpen TODO_javadoc.
     *
     */
    public void setWssRpfOpen(String wssRpfOpen) {
        replaceValue(11, 12, wssRpfOpen);
    }

    /*******************************************************************************************************
     * getWssI
     *******************************************************************************************************/
    /**
     *
     * @return wssI TODO_javadoc.
     *
     */
    public int getWssI() {
        return Integer.parseInt(subValue(0, 6));
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
        return subValue(6, 9);
    }

    /*******************************************************************************************************
     * getWssSoloTab
     *******************************************************************************************************/
    /**
     *
     * @return wssSoloTab TODO_javadoc.
     *
     */
    public String getWssSoloTab() {
        return subValue(9, 10);
    }

    /*******************************************************************************************************
     * getWssMnuOpen
     *******************************************************************************************************/
    /**
     *
     * @return wssMnuOpen TODO_javadoc.
     *
     */
    public String getWssMnuOpen() {
        return subValue(10, 11);
    }

    /*******************************************************************************************************
     * getWssRpfOpen
     *******************************************************************************************************/
    /**
     *
     * @return wssRpfOpen TODO_javadoc.
     *
     */
    public String getWssRpfOpen() {
        return subValue(11, 12);
    }

}

