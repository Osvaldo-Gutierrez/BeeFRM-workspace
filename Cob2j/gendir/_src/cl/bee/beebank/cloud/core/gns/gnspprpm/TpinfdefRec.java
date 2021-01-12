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
public class TpinfdefRec extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(TpinfdefRec.class);

    /** TODO_javadoc. */
    private static DecimalFormat form9z = new DecimalFormat("000000000");

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public TpinfdefRec() {

        initBuffer(156);

        replaceValue(0, 156, ""); // TPINFDEF-REC
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
        replaceValue(0, 156, value);
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
        return subValue(0, 156);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setUsrname
     *******************************************************************************************************/
    /**
     *
     * @param usrname TODO_javadoc.
     *
     */
    public void setUsrname(String usrname) {
        replaceValue(0, 30, usrname);
    }

    /*******************************************************************************************************
     * setCltname
     *******************************************************************************************************/
    /**
     *
     * @param cltname TODO_javadoc.
     *
     */
    public void setCltname(String cltname) {
        replaceValue(30, 60, cltname);
    }

    /*******************************************************************************************************
     * setPasswd
     *******************************************************************************************************/
    /**
     *
     * @param passwd TODO_javadoc.
     *
     */
    public void setPasswd(String passwd) {
        replaceValue(60, 90, passwd);
    }

    /*******************************************************************************************************
     * setGrpname
     *******************************************************************************************************/
    /**
     *
     * @param grpname TODO_javadoc.
     *
     */
    public void setGrpname(String grpname) {
        replaceValue(90, 120, grpname);
    }

    /*******************************************************************************************************
     * setNotificationFlag
     *******************************************************************************************************/
    /**
     *
     * @param notificationFlag TODO_javadoc.
     *
     */
    public void setNotificationFlag(int notificationFlag) {
        replaceValue(120, 129, setCompNumber(notificationFlag, form9z));
    }

    /*******************************************************************************************************
     * setAccessFlag
     *******************************************************************************************************/
    /**
     *
     * @param accessFlag TODO_javadoc.
     *
     */
    public void setAccessFlag(int accessFlag) {
        replaceValue(129, 138, setCompNumber(accessFlag, form9z));
    }

    /*******************************************************************************************************
     * setContextsFlag
     *******************************************************************************************************/
    /**
     *
     * @param contextsFlag TODO_javadoc.
     *
     */
    public void setContextsFlag(int contextsFlag) {
        replaceValue(138, 147, setCompNumber(contextsFlag, form9z));
    }

    /*******************************************************************************************************
     * setDatalen
     *******************************************************************************************************/
    /**
     *
     * @param datalen TODO_javadoc.
     *
     */
    public void setDatalen(int datalen) {
        replaceValue(147, 156, setCompNumber(datalen, form9z));
    }

    /*******************************************************************************************************
     * getUsrname
     *******************************************************************************************************/
    /**
     *
     * @return usrname TODO_javadoc.
     *
     */
    public String getUsrname() {
        return subValue(0, 30);
    }

    /*******************************************************************************************************
     * getCltname
     *******************************************************************************************************/
    /**
     *
     * @return cltname TODO_javadoc.
     *
     */
    public String getCltname() {
        return subValue(30, 60);
    }

    /*******************************************************************************************************
     * getPasswd
     *******************************************************************************************************/
    /**
     *
     * @return passwd TODO_javadoc.
     *
     */
    public String getPasswd() {
        return subValue(60, 90);
    }

    /*******************************************************************************************************
     * getGrpname
     *******************************************************************************************************/
    /**
     *
     * @return grpname TODO_javadoc.
     *
     */
    public String getGrpname() {
        return subValue(90, 120);
    }

    /*******************************************************************************************************
     * getNotificationFlag
     *******************************************************************************************************/
    /**
     *
     * @return notificationFlag TODO_javadoc.
     *
     */
    public int getNotificationFlag() {
        return (int) getCompNumber(subValue(120, 129));
    }

    /*******************************************************************************************************
     * getAccessFlag
     *******************************************************************************************************/
    /**
     *
     * @return accessFlag TODO_javadoc.
     *
     */
    public int getAccessFlag() {
        return (int) getCompNumber(subValue(129, 138));
    }

    /*******************************************************************************************************
     * getContextsFlag
     *******************************************************************************************************/
    /**
     *
     * @return contextsFlag TODO_javadoc.
     *
     */
    public int getContextsFlag() {
        return (int) getCompNumber(subValue(138, 147));
    }

    /*******************************************************************************************************
     * getDatalen
     *******************************************************************************************************/
    /**
     *
     * @return datalen TODO_javadoc.
     *
     */
    public int getDatalen() {
        return (int) getCompNumber(subValue(147, 156));
    }

    /*******************************************************************************************************
     * setTpuSig
     *******************************************************************************************************/
    /**
     *
     * @param tpuSig TODO_javadoc.
     *
     */
    public void setTpuSig(boolean tpuSig) {

        if (!tpuSig) {
            throw new RuntimeException("Se intento setear tpuSig con false.");
        }

        setNotificationFlag(1);
    }

    /*******************************************************************************************************
     * isTpuSig
     *******************************************************************************************************/
    /**
     *
     * @return tpuSig TODO_javadoc.
     *
     */
    public boolean isTpuSig() {
        return getNotificationFlag() == 1;
    }

    /*******************************************************************************************************
     * setTpuDip
     *******************************************************************************************************/
    /**
     *
     * @param tpuDip TODO_javadoc.
     *
     */
    public void setTpuDip(boolean tpuDip) {

        if (!tpuDip) {
            throw new RuntimeException("Se intento setear tpuDip con false.");
        }

        setNotificationFlag(2);
    }

    /*******************************************************************************************************
     * isTpuDip
     *******************************************************************************************************/
    /**
     *
     * @return tpuDip TODO_javadoc.
     *
     */
    public boolean isTpuDip() {
        return getNotificationFlag() == 2;
    }

    /*******************************************************************************************************
     * setTpuIgn
     *******************************************************************************************************/
    /**
     *
     * @param tpuIgn TODO_javadoc.
     *
     */
    public void setTpuIgn(boolean tpuIgn) {

        if (!tpuIgn) {
            throw new RuntimeException("Se intento setear tpuIgn con false.");
        }

        setNotificationFlag(3);
    }

    /*******************************************************************************************************
     * isTpuIgn
     *******************************************************************************************************/
    /**
     *
     * @return tpuIgn TODO_javadoc.
     *
     */
    public boolean isTpuIgn() {
        return getNotificationFlag() == 3;
    }

    /*******************************************************************************************************
     * setTpsaFastpath
     *******************************************************************************************************/
    /**
     *
     * @param tpsaFastpath TODO_javadoc.
     *
     */
    public void setTpsaFastpath(boolean tpsaFastpath) {

        if (!tpsaFastpath) {
            throw new RuntimeException("Se intento setear tpsaFastpath con false.");
        }

        setAccessFlag(1);
    }

    /*******************************************************************************************************
     * isTpsaFastpath
     *******************************************************************************************************/
    /**
     *
     * @return tpsaFastpath TODO_javadoc.
     *
     */
    public boolean isTpsaFastpath() {
        return getAccessFlag() == 1;
    }

    /*******************************************************************************************************
     * setTpsaProtected
     *******************************************************************************************************/
    /**
     *
     * @param tpsaProtected TODO_javadoc.
     *
     */
    public void setTpsaProtected(boolean tpsaProtected) {

        if (!tpsaProtected) {
            throw new RuntimeException("Se intento setear tpsaProtected con false.");
        }

        setAccessFlag(2);
    }

    /*******************************************************************************************************
     * isTpsaProtected
     *******************************************************************************************************/
    /**
     *
     * @return tpsaProtected TODO_javadoc.
     *
     */
    public boolean isTpsaProtected() {
        return getAccessFlag() == 2;
    }

    /*******************************************************************************************************
     * setTpSingleContext
     *******************************************************************************************************/
    /**
     *
     * @param tpSingleContext TODO_javadoc.
     *
     */
    public void setTpSingleContext(boolean tpSingleContext) {

        if (!tpSingleContext) {
            throw new RuntimeException("Se intento setear tpSingleContext con false.");
        }

        setContextsFlag(0);
    }

    /*******************************************************************************************************
     * isTpSingleContext
     *******************************************************************************************************/
    /**
     *
     * @return tpSingleContext TODO_javadoc.
     *
     */
    public boolean isTpSingleContext() {
        return getContextsFlag() == 0;
    }

    /*******************************************************************************************************
     * setTpMultiContexts
     *******************************************************************************************************/
    /**
     *
     * @param tpMultiContexts TODO_javadoc.
     *
     */
    public void setTpMultiContexts(boolean tpMultiContexts) {

        if (!tpMultiContexts) {
            throw new RuntimeException("Se intento setear tpMultiContexts con false.");
        }

        setContextsFlag(1);
    }

    /*******************************************************************************************************
     * isTpMultiContexts
     *******************************************************************************************************/
    /**
     *
     * @return tpMultiContexts TODO_javadoc.
     *
     */
    public boolean isTpMultiContexts() {
        return getContextsFlag() == 1;
    }

}

