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
public class TxReturnStatus extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(TxReturnStatus.class);

    /** TODO_javadoc. */
    private static DecimalFormat form9z = new DecimalFormat("000000000");

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public TxReturnStatus() {

        initBuffer(9);

        replaceValue(0, 9, "00000000{"); // TX-RETURN-STATUS
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
     * setTxStatus
     *******************************************************************************************************/
    /**
     *
     * @param txStatus TODO_javadoc.
     *
     */
    public void setTxStatus(int txStatus) {
        replaceValue(0, 9, setCompNumber(txStatus, form9z));
    }

    /*******************************************************************************************************
     * getTxStatus
     *******************************************************************************************************/
    /**
     *
     * @return txStatus TODO_javadoc.
     *
     */
    public int getTxStatus() {
        return (int) getCompNumber(subValue(0, 9));
    }

    /*******************************************************************************************************
     * setTxNotSupported
     *******************************************************************************************************/
    /**
     *
     * @param txNotSupported TODO_javadoc.
     *
     */
    public void setTxNotSupported(boolean txNotSupported) {

        if (!txNotSupported) {
            throw new RuntimeException("Se intento setear txNotSupported con false.");
        }

        setTxStatus(1);
    }

    /*******************************************************************************************************
     * isTxNotSupported
     *******************************************************************************************************/
    /**
     *
     * @return txNotSupported TODO_javadoc.
     *
     */
    public boolean isTxNotSupported() {
        return getTxStatus() == 1;
    }

    /*******************************************************************************************************
     * setTxOk
     *******************************************************************************************************/
    /**
     *
     * @param txOk TODO_javadoc.
     *
     */
    public void setTxOk(boolean txOk) {

        if (!txOk) {
            throw new RuntimeException("Se intento setear txOk con false.");
        }

        setTxStatus(0);
    }

    /*******************************************************************************************************
     * isTxOk
     *******************************************************************************************************/
    /**
     *
     * @return txOk TODO_javadoc.
     *
     */
    public boolean isTxOk() {
        return getTxStatus() == 0;
    }

    /*******************************************************************************************************
     * setTxOutside
     *******************************************************************************************************/
    /**
     *
     * @param txOutside TODO_javadoc.
     *
     */
    public void setTxOutside(boolean txOutside) {

        if (!txOutside) {
            throw new RuntimeException("Se intento setear txOutside con false.");
        }

        setTxStatus(-1);
    }

    /*******************************************************************************************************
     * isTxOutside
     *******************************************************************************************************/
    /**
     *
     * @return txOutside TODO_javadoc.
     *
     */
    public boolean isTxOutside() {
        return getTxStatus() == -1;
    }

    /*******************************************************************************************************
     * setTxRollback
     *******************************************************************************************************/
    /**
     *
     * @param txRollback TODO_javadoc.
     *
     */
    public void setTxRollback(boolean txRollback) {

        if (!txRollback) {
            throw new RuntimeException("Se intento setear txRollback con false.");
        }

        setTxStatus(-2);
    }

    /*******************************************************************************************************
     * isTxRollback
     *******************************************************************************************************/
    /**
     *
     * @return txRollback TODO_javadoc.
     *
     */
    public boolean isTxRollback() {
        return getTxStatus() == -2;
    }

    /*******************************************************************************************************
     * setTxMixed
     *******************************************************************************************************/
    /**
     *
     * @param txMixed TODO_javadoc.
     *
     */
    public void setTxMixed(boolean txMixed) {

        if (!txMixed) {
            throw new RuntimeException("Se intento setear txMixed con false.");
        }

        setTxStatus(-3);
    }

    /*******************************************************************************************************
     * isTxMixed
     *******************************************************************************************************/
    /**
     *
     * @return txMixed TODO_javadoc.
     *
     */
    public boolean isTxMixed() {
        return getTxStatus() == -3;
    }

    /*******************************************************************************************************
     * setTxHazard
     *******************************************************************************************************/
    /**
     *
     * @param txHazard TODO_javadoc.
     *
     */
    public void setTxHazard(boolean txHazard) {

        if (!txHazard) {
            throw new RuntimeException("Se intento setear txHazard con false.");
        }

        setTxStatus(-4);
    }

    /*******************************************************************************************************
     * isTxHazard
     *******************************************************************************************************/
    /**
     *
     * @return txHazard TODO_javadoc.
     *
     */
    public boolean isTxHazard() {
        return getTxStatus() == -4;
    }

    /*******************************************************************************************************
     * setTxProtocolError
     *******************************************************************************************************/
    /**
     *
     * @param txProtocolError TODO_javadoc.
     *
     */
    public void setTxProtocolError(boolean txProtocolError) {

        if (!txProtocolError) {
            throw new RuntimeException("Se intento setear txProtocolError con false.");
        }

        setTxStatus(-5);
    }

    /*******************************************************************************************************
     * isTxProtocolError
     *******************************************************************************************************/
    /**
     *
     * @return txProtocolError TODO_javadoc.
     *
     */
    public boolean isTxProtocolError() {
        return getTxStatus() == -5;
    }

    /*******************************************************************************************************
     * setTxError
     *******************************************************************************************************/
    /**
     *
     * @param txError TODO_javadoc.
     *
     */
    public void setTxError(boolean txError) {

        if (!txError) {
            throw new RuntimeException("Se intento setear txError con false.");
        }

        setTxStatus(-6);
    }

    /*******************************************************************************************************
     * isTxError
     *******************************************************************************************************/
    /**
     *
     * @return txError TODO_javadoc.
     *
     */
    public boolean isTxError() {
        return getTxStatus() == -6;
    }

    /*******************************************************************************************************
     * setTxFail
     *******************************************************************************************************/
    /**
     *
     * @param txFail TODO_javadoc.
     *
     */
    public void setTxFail(boolean txFail) {

        if (!txFail) {
            throw new RuntimeException("Se intento setear txFail con false.");
        }

        setTxStatus(-7);
    }

    /*******************************************************************************************************
     * isTxFail
     *******************************************************************************************************/
    /**
     *
     * @return txFail TODO_javadoc.
     *
     */
    public boolean isTxFail() {
        return getTxStatus() == -7;
    }

    /*******************************************************************************************************
     * setTxEinval
     *******************************************************************************************************/
    /**
     *
     * @param txEinval TODO_javadoc.
     *
     */
    public void setTxEinval(boolean txEinval) {

        if (!txEinval) {
            throw new RuntimeException("Se intento setear txEinval con false.");
        }

        setTxStatus(-8);
    }

    /*******************************************************************************************************
     * isTxEinval
     *******************************************************************************************************/
    /**
     *
     * @return txEinval TODO_javadoc.
     *
     */
    public boolean isTxEinval() {
        return getTxStatus() == -8;
    }

    /*******************************************************************************************************
     * setTxCommitted
     *******************************************************************************************************/
    /**
     *
     * @param txCommitted TODO_javadoc.
     *
     */
    public void setTxCommitted(boolean txCommitted) {

        if (!txCommitted) {
            throw new RuntimeException("Se intento setear txCommitted con false.");
        }

        setTxStatus(-9);
    }

    /*******************************************************************************************************
     * isTxCommitted
     *******************************************************************************************************/
    /**
     *
     * @return txCommitted TODO_javadoc.
     *
     */
    public boolean isTxCommitted() {
        return getTxStatus() == -9;
    }

    /*******************************************************************************************************
     * setTxNoBegin
     *******************************************************************************************************/
    /**
     *
     * @param txNoBegin TODO_javadoc.
     *
     */
    public void setTxNoBegin(boolean txNoBegin) {

        if (!txNoBegin) {
            throw new RuntimeException("Se intento setear txNoBegin con false.");
        }

        setTxStatus(-100);
    }

    /*******************************************************************************************************
     * isTxNoBegin
     *******************************************************************************************************/
    /**
     *
     * @return txNoBegin TODO_javadoc.
     *
     */
    public boolean isTxNoBegin() {
        return getTxStatus() == -100;
    }

    /*******************************************************************************************************
     * setTxRollbackNoBegin
     *******************************************************************************************************/
    /**
     *
     * @param txRollbackNoBegin TODO_javadoc.
     *
     */
    public void setTxRollbackNoBegin(boolean txRollbackNoBegin) {

        if (!txRollbackNoBegin) {
            throw new RuntimeException("Se intento setear txRollbackNoBegin con false.");
        }

        setTxStatus(-102);
    }

    /*******************************************************************************************************
     * isTxRollbackNoBegin
     *******************************************************************************************************/
    /**
     *
     * @return txRollbackNoBegin TODO_javadoc.
     *
     */
    public boolean isTxRollbackNoBegin() {
        return getTxStatus() == -102;
    }

    /*******************************************************************************************************
     * setTxMixedNoBegin
     *******************************************************************************************************/
    /**
     *
     * @param txMixedNoBegin TODO_javadoc.
     *
     */
    public void setTxMixedNoBegin(boolean txMixedNoBegin) {

        if (!txMixedNoBegin) {
            throw new RuntimeException("Se intento setear txMixedNoBegin con false.");
        }

        setTxStatus(-103);
    }

    /*******************************************************************************************************
     * isTxMixedNoBegin
     *******************************************************************************************************/
    /**
     *
     * @return txMixedNoBegin TODO_javadoc.
     *
     */
    public boolean isTxMixedNoBegin() {
        return getTxStatus() == -103;
    }

    /*******************************************************************************************************
     * setTxHazardNoBegin
     *******************************************************************************************************/
    /**
     *
     * @param txHazardNoBegin TODO_javadoc.
     *
     */
    public void setTxHazardNoBegin(boolean txHazardNoBegin) {

        if (!txHazardNoBegin) {
            throw new RuntimeException("Se intento setear txHazardNoBegin con false.");
        }

        setTxStatus(-104);
    }

    /*******************************************************************************************************
     * isTxHazardNoBegin
     *******************************************************************************************************/
    /**
     *
     * @return txHazardNoBegin TODO_javadoc.
     *
     */
    public boolean isTxHazardNoBegin() {
        return getTxStatus() == -104;
    }

    /*******************************************************************************************************
     * setTxCommittedNoBegin
     *******************************************************************************************************/
    /**
     *
     * @param txCommittedNoBegin TODO_javadoc.
     *
     */
    public void setTxCommittedNoBegin(boolean txCommittedNoBegin) {

        if (!txCommittedNoBegin) {
            throw new RuntimeException("Se intento setear txCommittedNoBegin con false.");
        }

        setTxStatus(-109);
    }

    /*******************************************************************************************************
     * isTxCommittedNoBegin
     *******************************************************************************************************/
    /**
     *
     * @return txCommittedNoBegin TODO_javadoc.
     *
     */
    public boolean isTxCommittedNoBegin() {
        return getTxStatus() == -109;
    }

}

