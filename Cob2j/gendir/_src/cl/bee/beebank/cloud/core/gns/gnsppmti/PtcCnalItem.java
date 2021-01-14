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
public class PtcCnalItem extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(PtcCnalItem.class);

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public PtcCnalItem() {

        initBuffer(15);

        replaceValue(0, 15, "               "); // PTC-CNAL-ITEM
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
        replaceValue(0, 15, value);
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
        return subValue(0, 15);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setPtcCnalItemCnal
     *******************************************************************************************************/
    /**
     *
     * @param ptcCnalItemCnal TODO_javadoc.
     *
     */
    public void setPtcCnalItemCnal(String ptcCnalItemCnal) {
        replaceValue(0, 3, ptcCnalItemCnal);
    }

    /*******************************************************************************************************
     * setPtcCnalItemUser
     *******************************************************************************************************/
    /**
     *
     * @param ptcCnalItemUser TODO_javadoc.
     *
     */
    public void setPtcCnalItemUser(String ptcCnalItemUser) {
        replaceValue(3, 15, ptcCnalItemUser);
    }

    /*******************************************************************************************************
     * getPtcCnalItemCnal
     *******************************************************************************************************/
    /**
     *
     * @return ptcCnalItemCnal TODO_javadoc.
     *
     */
    public String getPtcCnalItemCnal() {
        return subValue(0, 3);
    }

    /*******************************************************************************************************
     * getPtcCnalItemUser
     *******************************************************************************************************/
    /**
     *
     * @return ptcCnalItemUser TODO_javadoc.
     *
     */
    public String getPtcCnalItemUser() {
        return subValue(3, 15);
    }

}

