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
public class Ifd extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(Ifd.class);

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public Ifd() {

        initBuffer(241);

        replaceValue(0, 241, "                                                                                                                                                                                                                                                 "); // IFD
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
        replaceValue(0, 241, value);
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
        return subValue(0, 241);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setFiller
     *******************************************************************************************************/
    /**
     *
     * @param filler TODO_javadoc.
     *
     */
    public void setFiller(String filler) {
        replaceValue(0, 1, filler);
    }

    /*******************************************************************************************************
     * setIfdCodCifd
     *******************************************************************************************************/
    /**
     *
     * @param ifdCodCifd TODO_javadoc.
     *
     */
    public void setIfdCodCifd(String ifdCodCifd) {
        replaceValue(1, 13, ifdCodCifd);
    }

    /*******************************************************************************************************
     * setIfdGlsData
     *******************************************************************************************************/
    /**
     *
     * @param ifdGlsData TODO_javadoc.
     *
     */
    public void setIfdGlsData(String ifdGlsData) {
        replaceValue(13, 223, ifdGlsData);
    }

    /*******************************************************************************************************
     * setFiller1
     *******************************************************************************************************/
    /**
     *
     * @param filler1 TODO_javadoc.
     *
     */
    public void setFiller1(String filler1) {
        replaceValue(223, 241, filler1);
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
        return subValue(0, 1);
    }

    /*******************************************************************************************************
     * getIfdCodCifd
     *******************************************************************************************************/
    /**
     *
     * @return ifdCodCifd TODO_javadoc.
     *
     */
    public String getIfdCodCifd() {
        return subValue(1, 13);
    }

    /*******************************************************************************************************
     * getIfdGlsData
     *******************************************************************************************************/
    /**
     *
     * @return ifdGlsData TODO_javadoc.
     *
     */
    public String getIfdGlsData() {
        return subValue(13, 223);
    }

    /*******************************************************************************************************
     * getFiller1
     *******************************************************************************************************/
    /**
     *
     * @return filler1 TODO_javadoc.
     *
     */
    public String getFiller1() {
        return subValue(223, 241);
    }

}

