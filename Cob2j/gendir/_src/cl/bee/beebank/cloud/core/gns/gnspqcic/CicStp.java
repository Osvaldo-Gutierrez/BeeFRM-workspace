/*
 *   Copyright (c) 2021 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.beebank.cloud.core.gns.gnspqcic;


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
public class CicStp extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(CicStp.class);

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public CicStp() {

        initBuffer(4);

        replaceValue(0, 4, "    "); // CIC-STP
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
        replaceValue(0, 4, value);
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
        return subValue(0, 4);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setCicCodTcicStp
     *******************************************************************************************************/
    /**
     *
     * @param cicCodTcicStp TODO_javadoc.
     *
     */
    public void setCicCodTcicStp(String cicCodTcicStp) {
        replaceValue(0, 1, cicCodTcicStp);
    }

    /*******************************************************************************************************
     * setCicCodCcicStp
     *******************************************************************************************************/
    /**
     *
     * @param cicCodCcicStp TODO_javadoc.
     *
     */
    public void setCicCodCcicStp(String cicCodCcicStp) {
        replaceValue(1, 2, cicCodCcicStp);
    }

    /*******************************************************************************************************
     * setCicNumIcicStp
     *******************************************************************************************************/
    /**
     *
     * @param cicNumIcicStp TODO_javadoc.
     *
     */
    public void setCicNumIcicStp(String cicNumIcicStp) {
        replaceValue(2, 3, cicNumIcicStp);
    }

    /*******************************************************************************************************
     * setCicIndVigeStp
     *******************************************************************************************************/
    /**
     *
     * @param cicIndVigeStp TODO_javadoc.
     *
     */
    public void setCicIndVigeStp(String cicIndVigeStp) {
        replaceValue(3, 4, cicIndVigeStp);
    }

    /*******************************************************************************************************
     * getCicCodTcicStp
     *******************************************************************************************************/
    /**
     *
     * @return cicCodTcicStp TODO_javadoc.
     *
     */
    public String getCicCodTcicStp() {
        return subValue(0, 1);
    }

    /*******************************************************************************************************
     * getCicCodCcicStp
     *******************************************************************************************************/
    /**
     *
     * @return cicCodCcicStp TODO_javadoc.
     *
     */
    public String getCicCodCcicStp() {
        return subValue(1, 2);
    }

    /*******************************************************************************************************
     * getCicNumIcicStp
     *******************************************************************************************************/
    /**
     *
     * @return cicNumIcicStp TODO_javadoc.
     *
     */
    public String getCicNumIcicStp() {
        return subValue(2, 3);
    }

    /*******************************************************************************************************
     * getCicIndVigeStp
     *******************************************************************************************************/
    /**
     *
     * @return cicIndVigeStp TODO_javadoc.
     *
     */
    public String getCicIndVigeStp() {
        return subValue(3, 4);
    }

}

