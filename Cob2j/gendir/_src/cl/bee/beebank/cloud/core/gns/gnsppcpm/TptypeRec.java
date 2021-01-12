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
public class TptypeRec extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(TptypeRec.class);

    /** TODO_javadoc. */
    private static DecimalFormat form9z = new DecimalFormat("000000000");

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public TptypeRec() {

        initBuffer(42);

        replaceValue(0, 42, "                        00000000{00000000{"); // TPTYPE-REC
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
        replaceValue(0, 42, value);
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
        return subValue(0, 42);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setRecType
     *******************************************************************************************************/
    /**
     *
     * @param recType TODO_javadoc.
     *
     */
    public void setRecType(String recType) {
        replaceValue(0, 8, recType);
    }

    /*******************************************************************************************************
     * setSubType
     *******************************************************************************************************/
    /**
     *
     * @param subType TODO_javadoc.
     *
     */
    public void setSubType(String subType) {
        replaceValue(8, 24, subType);
    }

    /*******************************************************************************************************
     * setLen
     *******************************************************************************************************/
    /**
     *
     * @param len TODO_javadoc.
     *
     */
    public void setLen(int len) {
        replaceValue(24, 33, setCompNumber(len, form9z));
    }

    /*******************************************************************************************************
     * setTptypeStatus
     *******************************************************************************************************/
    /**
     *
     * @param tptypeStatus TODO_javadoc.
     *
     */
    public void setTptypeStatus(int tptypeStatus) {
        replaceValue(33, 42, setCompNumber(tptypeStatus, form9z));
    }

    /*******************************************************************************************************
     * getRecType
     *******************************************************************************************************/
    /**
     *
     * @return recType TODO_javadoc.
     *
     */
    public String getRecType() {
        return subValue(0, 8);
    }

    /*******************************************************************************************************
     * getSubType
     *******************************************************************************************************/
    /**
     *
     * @return subType TODO_javadoc.
     *
     */
    public String getSubType() {
        return subValue(8, 24);
    }

    /*******************************************************************************************************
     * getLen
     *******************************************************************************************************/
    /**
     *
     * @return len TODO_javadoc.
     *
     */
    public int getLen() {
        return (int) getCompNumber(subValue(24, 33));
    }

    /*******************************************************************************************************
     * getTptypeStatus
     *******************************************************************************************************/
    /**
     *
     * @return tptypeStatus TODO_javadoc.
     *
     */
    public int getTptypeStatus() {
        return (int) getCompNumber(subValue(33, 42));
    }

    /*******************************************************************************************************
     * setXOctet
     *******************************************************************************************************/
    /**
     *
     * @param xOctet TODO_javadoc.
     *
     */
    public void setXOctet(boolean xOctet) {

        if (!xOctet) {
            throw new RuntimeException("Se intento setear xOctet con false.");
        }

        setRecType("X_OCTET");
    }

    /*******************************************************************************************************
     * isXOctet
     *******************************************************************************************************/
    /**
     *
     * @return xOctet TODO_javadoc.
     *
     */
    public boolean isXOctet() {
        return getRecType().equals("X_OCTET");
    }

    /*******************************************************************************************************
     * setXCommon
     *******************************************************************************************************/
    /**
     *
     * @param xCommon TODO_javadoc.
     *
     */
    public void setXCommon(boolean xCommon) {

        if (!xCommon) {
            throw new RuntimeException("Se intento setear xCommon con false.");
        }

        setRecType("X_COMMON");
    }

    /*******************************************************************************************************
     * isXCommon
     *******************************************************************************************************/
    /**
     *
     * @return xCommon TODO_javadoc.
     *
     */
    public boolean isXCommon() {
        return getRecType().equals("X_COMMON");
    }

    /*******************************************************************************************************
     * setNoLength
     *******************************************************************************************************/
    /**
     *
     * @param noLength TODO_javadoc.
     *
     */
    public void setNoLength(boolean noLength) {

        if (!noLength) {
            throw new RuntimeException("Se intento setear noLength con false.");
        }

        setLen(0);
    }

    /*******************************************************************************************************
     * isNoLength
     *******************************************************************************************************/
    /**
     *
     * @return noLength TODO_javadoc.
     *
     */
    public boolean isNoLength() {
        return getLen() == 0;
    }

    /*******************************************************************************************************
     * setTptypeok
     *******************************************************************************************************/
    /**
     *
     * @param tptypeok TODO_javadoc.
     *
     */
    public void setTptypeok(boolean tptypeok) {

        if (!tptypeok) {
            throw new RuntimeException("Se intento setear tptypeok con false.");
        }

        setTptypeStatus(0);
    }

    /*******************************************************************************************************
     * isTptypeok
     *******************************************************************************************************/
    /**
     *
     * @return tptypeok TODO_javadoc.
     *
     */
    public boolean isTptypeok() {
        return getTptypeStatus() == 0;
    }

    /*******************************************************************************************************
     * setTptruncate
     *******************************************************************************************************/
    /**
     *
     * @param tptruncate TODO_javadoc.
     *
     */
    public void setTptruncate(boolean tptruncate) {

        if (!tptruncate) {
            throw new RuntimeException("Se intento setear tptruncate con false.");
        }

        setTptypeStatus(1);
    }

    /*******************************************************************************************************
     * isTptruncate
     *******************************************************************************************************/
    /**
     *
     * @return tptruncate TODO_javadoc.
     *
     */
    public boolean isTptruncate() {
        return getTptypeStatus() == 1;
    }

}

