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
public class TskTxReturnStatus extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(TskTxReturnStatus.class);

    /** TODO_javadoc. */
    private static DecimalFormat form9z = new DecimalFormat("000000000");

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public TskTxReturnStatus() {

        initBuffer(9);

        replaceValue(0, 9, "00000000{"); // TSK-TX-RETURN-STATUS
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
     * setTskTxStatus
     *******************************************************************************************************/
    /**
     *
     * @param tskTxStatus TODO_javadoc.
     *
     */
    public void setTskTxStatus(int tskTxStatus) {
        replaceValue(0, 9, setCompNumber(tskTxStatus, form9z));
    }

    /*******************************************************************************************************
     * getTskTxStatus
     *******************************************************************************************************/
    /**
     *
     * @return tskTxStatus TODO_javadoc.
     *
     */
    public int getTskTxStatus() {
        return (int) getCompNumber(subValue(0, 9));
    }

    /*******************************************************************************************************
     * setTskTxNotSupported
     *******************************************************************************************************/
    /**
     *
     * @param tskTxNotSupported TODO_javadoc.
     *
     */
    public void setTskTxNotSupported(boolean tskTxNotSupported) {

        if (!tskTxNotSupported) {
            throw new RuntimeException("Se intento setear tskTxNotSupported con false.");
        }

        setTskTxStatus(1);
    }

    /*******************************************************************************************************
     * isTskTxNotSupported
     *******************************************************************************************************/
    /**
     *
     * @return tskTxNotSupported TODO_javadoc.
     *
     */
    public boolean isTskTxNotSupported() {
        return getTskTxStatus() == 1;
    }

    /*******************************************************************************************************
     * setTskTxOk
     *******************************************************************************************************/
    /**
     *
     * @param tskTxOk TODO_javadoc.
     *
     */
    public void setTskTxOk(boolean tskTxOk) {

        if (!tskTxOk) {
            throw new RuntimeException("Se intento setear tskTxOk con false.");
        }

        setTskTxStatus(0);
    }

    /*******************************************************************************************************
     * isTskTxOk
     *******************************************************************************************************/
    /**
     *
     * @return tskTxOk TODO_javadoc.
     *
     */
    public boolean isTskTxOk() {
        return getTskTxStatus() == 0;
    }

    /*******************************************************************************************************
     * setTskTxOutside
     *******************************************************************************************************/
    /**
     *
     * @param tskTxOutside TODO_javadoc.
     *
     */
    public void setTskTxOutside(boolean tskTxOutside) {

        if (!tskTxOutside) {
            throw new RuntimeException("Se intento setear tskTxOutside con false.");
        }

        setTskTxStatus(-1);
    }

    /*******************************************************************************************************
     * isTskTxOutside
     *******************************************************************************************************/
    /**
     *
     * @return tskTxOutside TODO_javadoc.
     *
     */
    public boolean isTskTxOutside() {
        return getTskTxStatus() == -1;
    }

    /*******************************************************************************************************
     * setTskTxRollback
     *******************************************************************************************************/
    /**
     *
     * @param tskTxRollback TODO_javadoc.
     *
     */
    public void setTskTxRollback(boolean tskTxRollback) {

        if (!tskTxRollback) {
            throw new RuntimeException("Se intento setear tskTxRollback con false.");
        }

        setTskTxStatus(-2);
    }

    /*******************************************************************************************************
     * isTskTxRollback
     *******************************************************************************************************/
    /**
     *
     * @return tskTxRollback TODO_javadoc.
     *
     */
    public boolean isTskTxRollback() {
        return getTskTxStatus() == -2;
    }

    /*******************************************************************************************************
     * setTskTxMixed
     *******************************************************************************************************/
    /**
     *
     * @param tskTxMixed TODO_javadoc.
     *
     */
    public void setTskTxMixed(boolean tskTxMixed) {

        if (!tskTxMixed) {
            throw new RuntimeException("Se intento setear tskTxMixed con false.");
        }

        setTskTxStatus(-3);
    }

    /*******************************************************************************************************
     * isTskTxMixed
     *******************************************************************************************************/
    /**
     *
     * @return tskTxMixed TODO_javadoc.
     *
     */
    public boolean isTskTxMixed() {
        return getTskTxStatus() == -3;
    }

    /*******************************************************************************************************
     * setTskTxHazard
     *******************************************************************************************************/
    /**
     *
     * @param tskTxHazard TODO_javadoc.
     *
     */
    public void setTskTxHazard(boolean tskTxHazard) {

        if (!tskTxHazard) {
            throw new RuntimeException("Se intento setear tskTxHazard con false.");
        }

        setTskTxStatus(-4);
    }

    /*******************************************************************************************************
     * isTskTxHazard
     *******************************************************************************************************/
    /**
     *
     * @return tskTxHazard TODO_javadoc.
     *
     */
    public boolean isTskTxHazard() {
        return getTskTxStatus() == -4;
    }

    /*******************************************************************************************************
     * setTskTxProtocolError
     *******************************************************************************************************/
    /**
     *
     * @param tskTxProtocolError TODO_javadoc.
     *
     */
    public void setTskTxProtocolError(boolean tskTxProtocolError) {

        if (!tskTxProtocolError) {
            throw new RuntimeException("Se intento setear tskTxProtocolError con false.");
        }

        setTskTxStatus(-5);
    }

    /*******************************************************************************************************
     * isTskTxProtocolError
     *******************************************************************************************************/
    /**
     *
     * @return tskTxProtocolError TODO_javadoc.
     *
     */
    public boolean isTskTxProtocolError() {
        return getTskTxStatus() == -5;
    }

    /*******************************************************************************************************
     * setTskTxError
     *******************************************************************************************************/
    /**
     *
     * @param tskTxError TODO_javadoc.
     *
     */
    public void setTskTxError(boolean tskTxError) {

        if (!tskTxError) {
            throw new RuntimeException("Se intento setear tskTxError con false.");
        }

        setTskTxStatus(-6);
    }

    /*******************************************************************************************************
     * isTskTxError
     *******************************************************************************************************/
    /**
     *
     * @return tskTxError TODO_javadoc.
     *
     */
    public boolean isTskTxError() {
        return getTskTxStatus() == -6;
    }

    /*******************************************************************************************************
     * setTskTxFail
     *******************************************************************************************************/
    /**
     *
     * @param tskTxFail TODO_javadoc.
     *
     */
    public void setTskTxFail(boolean tskTxFail) {

        if (!tskTxFail) {
            throw new RuntimeException("Se intento setear tskTxFail con false.");
        }

        setTskTxStatus(-7);
    }

    /*******************************************************************************************************
     * isTskTxFail
     *******************************************************************************************************/
    /**
     *
     * @return tskTxFail TODO_javadoc.
     *
     */
    public boolean isTskTxFail() {
        return getTskTxStatus() == -7;
    }

    /*******************************************************************************************************
     * setTskTxEinval
     *******************************************************************************************************/
    /**
     *
     * @param tskTxEinval TODO_javadoc.
     *
     */
    public void setTskTxEinval(boolean tskTxEinval) {

        if (!tskTxEinval) {
            throw new RuntimeException("Se intento setear tskTxEinval con false.");
        }

        setTskTxStatus(-8);
    }

    /*******************************************************************************************************
     * isTskTxEinval
     *******************************************************************************************************/
    /**
     *
     * @return tskTxEinval TODO_javadoc.
     *
     */
    public boolean isTskTxEinval() {
        return getTskTxStatus() == -8;
    }

    /*******************************************************************************************************
     * setTskTxCommitted
     *******************************************************************************************************/
    /**
     *
     * @param tskTxCommitted TODO_javadoc.
     *
     */
    public void setTskTxCommitted(boolean tskTxCommitted) {

        if (!tskTxCommitted) {
            throw new RuntimeException("Se intento setear tskTxCommitted con false.");
        }

        setTskTxStatus(-9);
    }

    /*******************************************************************************************************
     * isTskTxCommitted
     *******************************************************************************************************/
    /**
     *
     * @return tskTxCommitted TODO_javadoc.
     *
     */
    public boolean isTskTxCommitted() {
        return getTskTxStatus() == -9;
    }

    /*******************************************************************************************************
     * setTskTxNoBegin
     *******************************************************************************************************/
    /**
     *
     * @param tskTxNoBegin TODO_javadoc.
     *
     */
    public void setTskTxNoBegin(boolean tskTxNoBegin) {

        if (!tskTxNoBegin) {
            throw new RuntimeException("Se intento setear tskTxNoBegin con false.");
        }

        setTskTxStatus(-100);
    }

    /*******************************************************************************************************
     * isTskTxNoBegin
     *******************************************************************************************************/
    /**
     *
     * @return tskTxNoBegin TODO_javadoc.
     *
     */
    public boolean isTskTxNoBegin() {
        return getTskTxStatus() == -100;
    }

    /*******************************************************************************************************
     * setTskTxRollbackNoBegin
     *******************************************************************************************************/
    /**
     *
     * @param tskTxRollbackNoBegin TODO_javadoc.
     *
     */
    public void setTskTxRollbackNoBegin(boolean tskTxRollbackNoBegin) {

        if (!tskTxRollbackNoBegin) {
            throw new RuntimeException("Se intento setear tskTxRollbackNoBegin con false.");
        }

        setTskTxStatus(-102);
    }

    /*******************************************************************************************************
     * isTskTxRollbackNoBegin
     *******************************************************************************************************/
    /**
     *
     * @return tskTxRollbackNoBegin TODO_javadoc.
     *
     */
    public boolean isTskTxRollbackNoBegin() {
        return getTskTxStatus() == -102;
    }

    /*******************************************************************************************************
     * setTskTxMixedNoBegin
     *******************************************************************************************************/
    /**
     *
     * @param tskTxMixedNoBegin TODO_javadoc.
     *
     */
    public void setTskTxMixedNoBegin(boolean tskTxMixedNoBegin) {

        if (!tskTxMixedNoBegin) {
            throw new RuntimeException("Se intento setear tskTxMixedNoBegin con false.");
        }

        setTskTxStatus(-103);
    }

    /*******************************************************************************************************
     * isTskTxMixedNoBegin
     *******************************************************************************************************/
    /**
     *
     * @return tskTxMixedNoBegin TODO_javadoc.
     *
     */
    public boolean isTskTxMixedNoBegin() {
        return getTskTxStatus() == -103;
    }

    /*******************************************************************************************************
     * setTskTxHazardNoBegin
     *******************************************************************************************************/
    /**
     *
     * @param tskTxHazardNoBegin TODO_javadoc.
     *
     */
    public void setTskTxHazardNoBegin(boolean tskTxHazardNoBegin) {

        if (!tskTxHazardNoBegin) {
            throw new RuntimeException("Se intento setear tskTxHazardNoBegin con false.");
        }

        setTskTxStatus(-104);
    }

    /*******************************************************************************************************
     * isTskTxHazardNoBegin
     *******************************************************************************************************/
    /**
     *
     * @return tskTxHazardNoBegin TODO_javadoc.
     *
     */
    public boolean isTskTxHazardNoBegin() {
        return getTskTxStatus() == -104;
    }

    /*******************************************************************************************************
     * setTskTxCommittedNoBegin
     *******************************************************************************************************/
    /**
     *
     * @param tskTxCommittedNoBegin TODO_javadoc.
     *
     */
    public void setTskTxCommittedNoBegin(boolean tskTxCommittedNoBegin) {

        if (!tskTxCommittedNoBegin) {
            throw new RuntimeException("Se intento setear tskTxCommittedNoBegin con false.");
        }

        setTskTxStatus(-109);
    }

    /*******************************************************************************************************
     * isTskTxCommittedNoBegin
     *******************************************************************************************************/
    /**
     *
     * @return tskTxCommittedNoBegin TODO_javadoc.
     *
     */
    public boolean isTskTxCommittedNoBegin() {
        return getTskTxStatus() == -109;
    }

}

