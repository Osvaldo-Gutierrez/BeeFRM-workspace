/*
 *   Copyright (c) 2021 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.beebank.cloud.core.gns.gnsppcpm;


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
public class TskTxInfoArea extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(TskTxInfoArea.class);

    /** TODO_javadoc. */
    private static DecimalFormat form9z = new DecimalFormat("000000000");

    /** TODO_javadoc. */
    private TskXidRec tskXidRec = new TskXidRec();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public TskTxInfoArea() {

        initBuffer(200);

        replaceValue(0, 200, "00000000{00000000{00000000{                                                                                                                                00000000{00000000{00000000{00000000{00000000{"); // TSK-TX-INFO-AREA
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
        replaceValue(0, 200, value);
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
        return subValue(0, 200);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setTskTransactionMode
     *******************************************************************************************************/
    /**
     *
     * @param tskTransactionMode TODO_javadoc.
     *
     */
    public void setTskTransactionMode(int tskTransactionMode) {
        replaceValue(155, 164, setCompNumber(tskTransactionMode, form9z));
    }

    /*******************************************************************************************************
     * setTskCommitReturn
     *******************************************************************************************************/
    /**
     *
     * @param tskCommitReturn TODO_javadoc.
     *
     */
    public void setTskCommitReturn(int tskCommitReturn) {
        replaceValue(164, 173, setCompNumber(tskCommitReturn, form9z));
    }

    /*******************************************************************************************************
     * setTskTransactionControl
     *******************************************************************************************************/
    /**
     *
     * @param tskTransactionControl TODO_javadoc.
     *
     */
    public void setTskTransactionControl(int tskTransactionControl) {
        replaceValue(173, 182, setCompNumber(tskTransactionControl, form9z));
    }

    /*******************************************************************************************************
     * setTskTransactionTimeout
     *******************************************************************************************************/
    /**
     *
     * @param tskTransactionTimeout TODO_javadoc.
     *
     */
    public void setTskTransactionTimeout(int tskTransactionTimeout) {
        replaceValue(182, 191, setCompNumber(tskTransactionTimeout, form9z));
    }

    /*******************************************************************************************************
     * setTskTransactionState
     *******************************************************************************************************/
    /**
     *
     * @param tskTransactionState TODO_javadoc.
     *
     */
    public void setTskTransactionState(int tskTransactionState) {
        replaceValue(191, 200, setCompNumber(tskTransactionState, form9z));
    }

    /*******************************************************************************************************
     * getTskXidRec
     *******************************************************************************************************/
    /**
     *
     * @return tskXidRec TODO_javadoc.
     *
     */
    public TskXidRec getTskXidRec() {
        return tskXidRec;
    }

    /*******************************************************************************************************
     * getTskTransactionMode
     *******************************************************************************************************/
    /**
     *
     * @return tskTransactionMode TODO_javadoc.
     *
     */
    public int getTskTransactionMode() {
        return (int) getCompNumber(subValue(155, 164));
    }

    /*******************************************************************************************************
     * getTskCommitReturn
     *******************************************************************************************************/
    /**
     *
     * @return tskCommitReturn TODO_javadoc.
     *
     */
    public int getTskCommitReturn() {
        return (int) getCompNumber(subValue(164, 173));
    }

    /*******************************************************************************************************
     * getTskTransactionControl
     *******************************************************************************************************/
    /**
     *
     * @return tskTransactionControl TODO_javadoc.
     *
     */
    public int getTskTransactionControl() {
        return (int) getCompNumber(subValue(173, 182));
    }

    /*******************************************************************************************************
     * getTskTransactionTimeout
     *******************************************************************************************************/
    /**
     *
     * @return tskTransactionTimeout TODO_javadoc.
     *
     */
    public int getTskTransactionTimeout() {
        return (int) getCompNumber(subValue(182, 191));
    }

    /*******************************************************************************************************
     * getTskTransactionState
     *******************************************************************************************************/
    /**
     *
     * @return tskTransactionState TODO_javadoc.
     *
     */
    public int getTskTransactionState() {
        return (int) getCompNumber(subValue(191, 200));
    }

    /*******************************************************************************************************
     * setTskTxNotInTran
     *******************************************************************************************************/
    /**
     *
     * @param tskTxNotInTran TODO_javadoc.
     *
     */
    public void setTskTxNotInTran(boolean tskTxNotInTran) {

        if (!tskTxNotInTran) {
            throw new RuntimeException("Se intento setear tskTxNotInTran con false.");
        }

        setTskTransactionMode(0);
    }

    /*******************************************************************************************************
     * isTskTxNotInTran
     *******************************************************************************************************/
    /**
     *
     * @return tskTxNotInTran TODO_javadoc.
     *
     */
    public boolean isTskTxNotInTran() {
        return getTskTransactionMode() == 0;
    }

    /*******************************************************************************************************
     * setTskTxInTran
     *******************************************************************************************************/
    /**
     *
     * @param tskTxInTran TODO_javadoc.
     *
     */
    public void setTskTxInTran(boolean tskTxInTran) {

        if (!tskTxInTran) {
            throw new RuntimeException("Se intento setear tskTxInTran con false.");
        }

        setTskTransactionMode(1);
    }

    /*******************************************************************************************************
     * isTskTxInTran
     *******************************************************************************************************/
    /**
     *
     * @return tskTxInTran TODO_javadoc.
     *
     */
    public boolean isTskTxInTran() {
        return getTskTransactionMode() == 1;
    }

    /*******************************************************************************************************
     * setTskTxCommitCompleted
     *******************************************************************************************************/
    /**
     *
     * @param tskTxCommitCompleted TODO_javadoc.
     *
     */
    public void setTskTxCommitCompleted(boolean tskTxCommitCompleted) {

        if (!tskTxCommitCompleted) {
            throw new RuntimeException("Se intento setear tskTxCommitCompleted con false.");
        }

        setTskCommitReturn(0);
    }

    /*******************************************************************************************************
     * isTskTxCommitCompleted
     *******************************************************************************************************/
    /**
     *
     * @return tskTxCommitCompleted TODO_javadoc.
     *
     */
    public boolean isTskTxCommitCompleted() {
        return getTskCommitReturn() == 0;
    }

    /*******************************************************************************************************
     * setTskTxCommitDecisionLogged
     *******************************************************************************************************/
    /**
     *
     * @param tskTxCommitDecisionLogged TODO_javadoc.
     *
     */
    public void setTskTxCommitDecisionLogged(boolean tskTxCommitDecisionLogged) {

        if (!tskTxCommitDecisionLogged) {
            throw new RuntimeException("Se intento setear tskTxCommitDecisionLogged con false.");
        }

        setTskCommitReturn(1);
    }

    /*******************************************************************************************************
     * isTskTxCommitDecisionLogged
     *******************************************************************************************************/
    /**
     *
     * @return tskTxCommitDecisionLogged TODO_javadoc.
     *
     */
    public boolean isTskTxCommitDecisionLogged() {
        return getTskCommitReturn() == 1;
    }

    /*******************************************************************************************************
     * setTskTxUnchained
     *******************************************************************************************************/
    /**
     *
     * @param tskTxUnchained TODO_javadoc.
     *
     */
    public void setTskTxUnchained(boolean tskTxUnchained) {

        if (!tskTxUnchained) {
            throw new RuntimeException("Se intento setear tskTxUnchained con false.");
        }

        setTskTransactionControl(0);
    }

    /*******************************************************************************************************
     * isTskTxUnchained
     *******************************************************************************************************/
    /**
     *
     * @return tskTxUnchained TODO_javadoc.
     *
     */
    public boolean isTskTxUnchained() {
        return getTskTransactionControl() == 0;
    }

    /*******************************************************************************************************
     * setTskTxChained
     *******************************************************************************************************/
    /**
     *
     * @param tskTxChained TODO_javadoc.
     *
     */
    public void setTskTxChained(boolean tskTxChained) {

        if (!tskTxChained) {
            throw new RuntimeException("Se intento setear tskTxChained con false.");
        }

        setTskTransactionControl(1);
    }

    /*******************************************************************************************************
     * isTskTxChained
     *******************************************************************************************************/
    /**
     *
     * @return tskTxChained TODO_javadoc.
     *
     */
    public boolean isTskTxChained() {
        return getTskTransactionControl() == 1;
    }

    /*******************************************************************************************************
     * setNoTimeout
     *******************************************************************************************************/
    /**
     *
     * @param noTimeout TODO_javadoc.
     *
     */
    public void setNoTimeout(boolean noTimeout) {

        if (!noTimeout) {
            throw new RuntimeException("Se intento setear noTimeout con false.");
        }

        setTskTransactionTimeout(0);
    }

    /*******************************************************************************************************
     * isNoTimeout
     *******************************************************************************************************/
    /**
     *
     * @return noTimeout TODO_javadoc.
     *
     */
    public boolean isNoTimeout() {
        return getTskTransactionTimeout() == 0;
    }

    /*******************************************************************************************************
     * setTskTxActive
     *******************************************************************************************************/
    /**
     *
     * @param tskTxActive TODO_javadoc.
     *
     */
    public void setTskTxActive(boolean tskTxActive) {

        if (!tskTxActive) {
            throw new RuntimeException("Se intento setear tskTxActive con false.");
        }

        setTskTransactionState(0);
    }

    /*******************************************************************************************************
     * isTskTxActive
     *******************************************************************************************************/
    /**
     *
     * @return tskTxActive TODO_javadoc.
     *
     */
    public boolean isTskTxActive() {
        return getTskTransactionState() == 0;
    }

    /*******************************************************************************************************
     * setTskTxTimeoutRollbackOnly
     *******************************************************************************************************/
    /**
     *
     * @param tskTxTimeoutRollbackOnly TODO_javadoc.
     *
     */
    public void setTskTxTimeoutRollbackOnly(boolean tskTxTimeoutRollbackOnly) {

        if (!tskTxTimeoutRollbackOnly) {
            throw new RuntimeException("Se intento setear tskTxTimeoutRollbackOnly con false.");
        }

        setTskTransactionState(1);
    }

    /*******************************************************************************************************
     * isTskTxTimeoutRollbackOnly
     *******************************************************************************************************/
    /**
     *
     * @return tskTxTimeoutRollbackOnly TODO_javadoc.
     *
     */
    public boolean isTskTxTimeoutRollbackOnly() {
        return getTskTransactionState() == 1;
    }

    /*******************************************************************************************************
     * setTskTxRollbackOnly
     *******************************************************************************************************/
    /**
     *
     * @param tskTxRollbackOnly TODO_javadoc.
     *
     */
    public void setTskTxRollbackOnly(boolean tskTxRollbackOnly) {

        if (!tskTxRollbackOnly) {
            throw new RuntimeException("Se intento setear tskTxRollbackOnly con false.");
        }

        setTskTransactionState(2);
    }

    /*******************************************************************************************************
     * isTskTxRollbackOnly
     *******************************************************************************************************/
    /**
     *
     * @return tskTxRollbackOnly TODO_javadoc.
     *
     */
    public boolean isTskTxRollbackOnly() {
        return getTskTransactionState() == 2;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class TskXidRec {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public TskXidRec() {
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
            replaceValue(0, 155, value);
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
            return subValue(0, 155);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setTskFormatId
         *******************************************************************************************************/
        /**
         *
         * @param tskFormatId TODO_javadoc.
         *
         */
        public void setTskFormatId(int tskFormatId) {
            replaceValue(0, 9, setCompNumber(tskFormatId, form9z));
        }

        /*******************************************************************************************************
         * setTskGtridLength
         *******************************************************************************************************/
        /**
         *
         * @param tskGtridLength TODO_javadoc.
         *
         */
        public void setTskGtridLength(int tskGtridLength) {
            replaceValue(9, 18, setCompNumber(tskGtridLength, form9z));
        }

        /*******************************************************************************************************
         * setTskBranchLength
         *******************************************************************************************************/
        /**
         *
         * @param tskBranchLength TODO_javadoc.
         *
         */
        public void setTskBranchLength(int tskBranchLength) {
            replaceValue(18, 27, setCompNumber(tskBranchLength, form9z));
        }

        /*******************************************************************************************************
         * setTskXidData
         *******************************************************************************************************/
        /**
         *
         * @param tskXidData TODO_javadoc.
         *
         */
        public void setTskXidData(String tskXidData) {
            replaceValue(27, 155, tskXidData);
        }

        /*******************************************************************************************************
         * getTskFormatId
         *******************************************************************************************************/
        /**
         *
         * @return tskFormatId TODO_javadoc.
         *
         */
        public int getTskFormatId() {
            return (int) getCompNumber(subValue(0, 9));
        }

        /*******************************************************************************************************
         * getTskGtridLength
         *******************************************************************************************************/
        /**
         *
         * @return tskGtridLength TODO_javadoc.
         *
         */
        public int getTskGtridLength() {
            return (int) getCompNumber(subValue(9, 18));
        }

        /*******************************************************************************************************
         * getTskBranchLength
         *******************************************************************************************************/
        /**
         *
         * @return tskBranchLength TODO_javadoc.
         *
         */
        public int getTskBranchLength() {
            return (int) getCompNumber(subValue(18, 27));
        }

        /*******************************************************************************************************
         * getTskXidData
         *******************************************************************************************************/
        /**
         *
         * @return tskXidData TODO_javadoc.
         *
         */
        public String getTskXidData() {
            return subValue(27, 155);
        }

    }

}

