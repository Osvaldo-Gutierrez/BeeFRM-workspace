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
public class TdoGlsDescFrm extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(TdoGlsDescFrm.class);

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public TdoGlsDescFrm() {

        initBuffer(1920);

        replaceValue(0, 1920, "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "); // TDO-GLS-DESC-FRM
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
        replaceValue(0, 1920, value);
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
        return subValue(0, 1920);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setTdoCodTdoFrm
     *******************************************************************************************************/
    /**
     *
     * @param tdoCodTdoFrm TODO_javadoc.
     *
     */
    public void setTdoCodTdoFrm(String[] tdoCodTdoFrm) {

        if (tdoCodTdoFrm == null || tdoCodTdoFrm.length != 1920) {
            throw new IllegalArgumentException("tdoCodTdoFrm[]: no debe ser nulo y largo debe ser 1920");
        }

        for (int i = 0; i < 1920; i++) {
            replaceValue(0 + 1 * i, 0 + 1 * (i + 1), tdoCodTdoFrm[i]);
        }
    }

    /*******************************************************************************************************
     * setTdoCodTdoFrm
     *******************************************************************************************************/
    /**
     *
     * @param i TODO_javadoc.
     * @param tdoCodTdoFrm TODO_javadoc.
     *
     */
    public void setTdoCodTdoFrm(int i, String tdoCodTdoFrm) {

        if (i < 0 || i >= 1920) {
            throw new ArrayIndexOutOfBoundsException("tdoCodTdoFrm[]: indice debe estar en rango [0..1919]");
        }

        replaceValue(0 + 1 * i, 0 + 1 * (i + 1), tdoCodTdoFrm);
    }

    /*******************************************************************************************************
     * getTdoCodTdoFrm
     *******************************************************************************************************/
    /**
     *
     * @param i TODO_javadoc.
     *
     * @return tdoCodTdoFrm TODO_javadoc.
     *
     */
    public String getTdoCodTdoFrm(int i) {

        if (i < 0 || i >= 1920) {
            throw new ArrayIndexOutOfBoundsException("tdoCodTdoFrm[]: indice debe estar en rango [0..1919]");
        }

        return subValue(0 + 1 * i, 0 + 1 * (i + 1));
    }

    /*******************************************************************************************************
     * getTdoCodTdoFrmSize
     *******************************************************************************************************/
    /**
     *
     * @return TODO_javadoc.
     *
     */
    public final int getTdoCodTdoFrmSize() {
        return 1920;
    }

}

