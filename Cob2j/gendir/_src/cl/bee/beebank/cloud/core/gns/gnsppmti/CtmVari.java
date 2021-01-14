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
public class CtmVari extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(CtmVari.class);

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public CtmVari() {

        initBuffer(18);

        replaceValue(0, 18, "                  "); // CTM-VARI
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
        replaceValue(0, 18, value);
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
        return subValue(0, 18);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setCtmCodTcpip
     *******************************************************************************************************/
    /**
     *
     * @param ctmCodTcpip TODO_javadoc.
     *
     */
    public void setCtmCodTcpip(String ctmCodTcpip) {
        replaceValue(0, 6, ctmCodTcpip);
    }

    /*******************************************************************************************************
     * setCtmCodTran
     *******************************************************************************************************/
    /**
     *
     * @param ctmCodTran TODO_javadoc.
     *
     */
    public void setCtmCodTran(String ctmCodTran) {
        replaceValue(6, 18, ctmCodTran);
    }

    /*******************************************************************************************************
     * getCtmCodTcpip
     *******************************************************************************************************/
    /**
     *
     * @return ctmCodTcpip TODO_javadoc.
     *
     */
    public String getCtmCodTcpip() {
        return subValue(0, 6);
    }

    /*******************************************************************************************************
     * getCtmCodTran
     *******************************************************************************************************/
    /**
     *
     * @return ctmCodTran TODO_javadoc.
     *
     */
    public String getCtmCodTran() {
        return subValue(6, 18);
    }

}

