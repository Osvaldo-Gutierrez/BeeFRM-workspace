/*
 *   Copyright (c) 2021 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.beebank.cloud.core.gns.gnsppidd;


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
public class MulmsgMens extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(MulmsgMens.class);

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public MulmsgMens() {

        initBuffer(1024);

        replaceValue(0, 1024, "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "); // MULMSG-MENS
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
        replaceValue(0, 1024, value);
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
        return subValue(0, 1024);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setMulmsgTipo
     *******************************************************************************************************/
    /**
     *
     * @param mulmsgTipo TODO_javadoc.
     *
     */
    public void setMulmsgTipo(String mulmsgTipo) {
        replaceValue(0, 1, mulmsgTipo);
    }

    /*******************************************************************************************************
     * setMulmsgForm
     *******************************************************************************************************/
    /**
     *
     * @param mulmsgForm TODO_javadoc.
     *
     */
    public void setMulmsgForm(String mulmsgForm) {
        replaceValue(1, 4, mulmsgForm);
    }

    /*******************************************************************************************************
     * setMulmsgSist
     *******************************************************************************************************/
    /**
     *
     * @param mulmsgSist TODO_javadoc.
     *
     */
    public void setMulmsgSist(String mulmsgSist) {
        replaceValue(4, 7, mulmsgSist);
    }

    /*******************************************************************************************************
     * setMulmsgCodi
     *******************************************************************************************************/
    /**
     *
     * @param mulmsgCodi TODO_javadoc.
     *
     */
    public void setMulmsgCodi(String mulmsgCodi) {
        replaceValue(7, 19, mulmsgCodi);
    }

    /*******************************************************************************************************
     * setMulmsgDato
     *******************************************************************************************************/
    /**
     *
     * @param mulmsgDato TODO_javadoc.
     *
     */
    public void setMulmsgDato(String mulmsgDato) {
        replaceValue(19, 1024, mulmsgDato);
    }

    /*******************************************************************************************************
     * getMulmsgTipo
     *******************************************************************************************************/
    /**
     *
     * @return mulmsgTipo TODO_javadoc.
     *
     */
    public String getMulmsgTipo() {
        return subValue(0, 1);
    }

    /*******************************************************************************************************
     * getMulmsgForm
     *******************************************************************************************************/
    /**
     *
     * @return mulmsgForm TODO_javadoc.
     *
     */
    public String getMulmsgForm() {
        return subValue(1, 4);
    }

    /*******************************************************************************************************
     * getMulmsgSist
     *******************************************************************************************************/
    /**
     *
     * @return mulmsgSist TODO_javadoc.
     *
     */
    public String getMulmsgSist() {
        return subValue(4, 7);
    }

    /*******************************************************************************************************
     * getMulmsgCodi
     *******************************************************************************************************/
    /**
     *
     * @return mulmsgCodi TODO_javadoc.
     *
     */
    public String getMulmsgCodi() {
        return subValue(7, 19);
    }

    /*******************************************************************************************************
     * getMulmsgDato
     *******************************************************************************************************/
    /**
     *
     * @return mulmsgDato TODO_javadoc.
     *
     */
    public String getMulmsgDato() {
        return subValue(19, 1024);
    }

}

