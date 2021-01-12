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
public class TptrxlevRec extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(TptrxlevRec.class);

    /** TODO_javadoc. */
    private static DecimalFormat form9z = new DecimalFormat("000000000");

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public TptrxlevRec() {

        initBuffer(9);

        replaceValue(0, 9, "00000000{"); // TPTRXLEV-REC
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
        replaceValue(0, 9, value);
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
        return subValue(0, 9);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setTptrxlevFlag
     *******************************************************************************************************/
    /**
     *
     * @param tptrxlevFlag TODO_javadoc.
     *
     */
    public void setTptrxlevFlag(int tptrxlevFlag) {
        replaceValue(0, 9, setCompNumber(tptrxlevFlag, form9z));
    }

    /*******************************************************************************************************
     * getTptrxlevFlag
     *******************************************************************************************************/
    /**
     *
     * @return tptrxlevFlag TODO_javadoc.
     *
     */
    public int getTptrxlevFlag() {
        return (int) getCompNumber(subValue(0, 9));
    }

    /*******************************************************************************************************
     * setTpNotInTran
     *******************************************************************************************************/
    /**
     *
     * @param tpNotInTran TODO_javadoc.
     *
     */
    public void setTpNotInTran(boolean tpNotInTran) {

        if (!tpNotInTran) {
            throw new RuntimeException("Se intento setear tpNotInTran con false.");
        }

        setTptrxlevFlag(0);
    }

    /*******************************************************************************************************
     * isTpNotInTran
     *******************************************************************************************************/
    /**
     *
     * @return tpNotInTran TODO_javadoc.
     *
     */
    public boolean isTpNotInTran() {
        return getTptrxlevFlag() == 0;
    }

    /*******************************************************************************************************
     * setTpInTran
     *******************************************************************************************************/
    /**
     *
     * @param tpInTran TODO_javadoc.
     *
     */
    public void setTpInTran(boolean tpInTran) {

        if (!tpInTran) {
            throw new RuntimeException("Se intento setear tpInTran con false.");
        }

        setTptrxlevFlag(1);
    }

    /*******************************************************************************************************
     * isTpInTran
     *******************************************************************************************************/
    /**
     *
     * @return tpInTran TODO_javadoc.
     *
     */
    public boolean isTpInTran() {
        return getTptrxlevFlag() == 1;
    }

}

