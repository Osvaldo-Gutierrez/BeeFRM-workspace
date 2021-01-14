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
public class Eibtaskn1 extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(Eibtaskn1.class);

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public Eibtaskn1() {

        initBuffer(8);

        replaceValue(0, 8, "        "); // EIBTASKN-1
        replaceValue(0, 4, "    "); // EIBTASKN-11
        replaceValue(4, 8, "    "); // EIBTASKN-12
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
        replaceValue(0, 8, value);
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
        return subValue(0, 8);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setEibtaskn11
     *******************************************************************************************************/
    /**
     *
     * @param eibtaskn11 TODO_javadoc.
     *
     */
    public void setEibtaskn11(String eibtaskn11) {
        replaceValue(0, 4, eibtaskn11);
    }

    /*******************************************************************************************************
     * setEibtaskn12
     *******************************************************************************************************/
    /**
     *
     * @param eibtaskn12 TODO_javadoc.
     *
     */
    public void setEibtaskn12(String eibtaskn12) {
        replaceValue(4, 8, eibtaskn12);
    }

    /*******************************************************************************************************
     * getEibtaskn11
     *******************************************************************************************************/
    /**
     *
     * @return eibtaskn11 TODO_javadoc.
     *
     */
    public String getEibtaskn11() {
        return subValue(0, 4);
    }

    /*******************************************************************************************************
     * getEibtaskn12
     *******************************************************************************************************/
    /**
     *
     * @return eibtaskn12 TODO_javadoc.
     *
     */
    public String getEibtaskn12() {
        return subValue(4, 8);
    }

}

