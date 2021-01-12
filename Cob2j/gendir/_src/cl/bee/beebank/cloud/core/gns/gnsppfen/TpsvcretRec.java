/*
 *   Copyright (c) 2021 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.beebank.cloud.core.gns.gnsppfen;


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
public class TpsvcretRec extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(TpsvcretRec.class);

    /** TODO_javadoc. */
    private static DecimalFormat form9z = new DecimalFormat("000000000");

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public TpsvcretRec() {

        initBuffer(18);

        replaceValue(0, 18, "00000000{00000000{"); // TPSVCRET-REC
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
     * setTpReturnVal
     *******************************************************************************************************/
    /**
     *
     * @param tpReturnVal TODO_javadoc.
     *
     */
    public void setTpReturnVal(int tpReturnVal) {
        replaceValue(0, 9, setCompNumber(tpReturnVal, form9z));
    }

    /*******************************************************************************************************
     * setApplCode
     *******************************************************************************************************/
    /**
     *
     * @param applCode TODO_javadoc.
     *
     */
    public void setApplCode(int applCode) {
        replaceValue(9, 18, setCompNumber(applCode, form9z));
    }

    /*******************************************************************************************************
     * getTpReturnVal
     *******************************************************************************************************/
    /**
     *
     * @return tpReturnVal TODO_javadoc.
     *
     */
    public int getTpReturnVal() {
        return (int) getCompNumber(subValue(0, 9));
    }

    /*******************************************************************************************************
     * getApplCode
     *******************************************************************************************************/
    /**
     *
     * @return applCode TODO_javadoc.
     *
     */
    public int getApplCode() {
        return (int) getCompNumber(subValue(9, 18));
    }

    /*******************************************************************************************************
     * setTpsuccess
     *******************************************************************************************************/
    /**
     *
     * @param tpsuccess TODO_javadoc.
     *
     */
    public void setTpsuccess(boolean tpsuccess) {

        if (!tpsuccess) {
            throw new RuntimeException("Se intento setear tpsuccess con false.");
        }

        setTpReturnVal(0);
    }

    /*******************************************************************************************************
     * isTpsuccess
     *******************************************************************************************************/
    /**
     *
     * @return tpsuccess TODO_javadoc.
     *
     */
    public boolean isTpsuccess() {
        return getTpReturnVal() == 0;
    }

    /*******************************************************************************************************
     * setTpfail
     *******************************************************************************************************/
    /**
     *
     * @param tpfail TODO_javadoc.
     *
     */
    public void setTpfail(boolean tpfail) {

        if (!tpfail) {
            throw new RuntimeException("Se intento setear tpfail con false.");
        }

        setTpReturnVal(1);
    }

    /*******************************************************************************************************
     * isTpfail
     *******************************************************************************************************/
    /**
     *
     * @return tpfail TODO_javadoc.
     *
     */
    public boolean isTpfail() {
        return getTpReturnVal() == 1;
    }

    /*******************************************************************************************************
     * setTpexit
     *******************************************************************************************************/
    /**
     *
     * @param tpexit TODO_javadoc.
     *
     */
    public void setTpexit(boolean tpexit) {

        if (!tpexit) {
            throw new RuntimeException("Se intento setear tpexit con false.");
        }

        setTpReturnVal(2);
    }

    /*******************************************************************************************************
     * isTpexit
     *******************************************************************************************************/
    /**
     *
     * @return tpexit TODO_javadoc.
     *
     */
    public boolean isTpexit() {
        return getTpReturnVal() == 2;
    }

    /*******************************************************************************************************
     * setTplongjump
     *******************************************************************************************************/
    /**
     *
     * @param tplongjump TODO_javadoc.
     *
     */
    public void setTplongjump(boolean tplongjump) {

        if (!tplongjump) {
            throw new RuntimeException("Se intento setear tplongjump con false.");
        }

        setTpReturnVal(3);
    }

    /*******************************************************************************************************
     * isTplongjump
     *******************************************************************************************************/
    /**
     *
     * @return tplongjump TODO_javadoc.
     *
     */
    public boolean isTplongjump() {
        return getTpReturnVal() == 3;
    }

    /*******************************************************************************************************
     * setTpbreak
     *******************************************************************************************************/
    /**
     *
     * @param tpbreak TODO_javadoc.
     *
     */
    public void setTpbreak(boolean tpbreak) {

        if (!tpbreak) {
            throw new RuntimeException("Se intento setear tpbreak con false.");
        }

        setTpReturnVal(4);
    }

    /*******************************************************************************************************
     * isTpbreak
     *******************************************************************************************************/
    /**
     *
     * @return tpbreak TODO_javadoc.
     *
     */
    public boolean isTpbreak() {
        return getTpReturnVal() == 4;
    }

}

