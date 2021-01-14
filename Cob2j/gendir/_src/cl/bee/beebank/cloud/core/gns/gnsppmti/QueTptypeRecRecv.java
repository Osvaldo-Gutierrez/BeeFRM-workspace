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
public class QueTptypeRecRecv extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(QueTptypeRecRecv.class);

    /** TODO_javadoc. */
    private static DecimalFormat form9z = new DecimalFormat("000000000");

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public QueTptypeRecRecv() {

        initBuffer(42);

        replaceValue(0, 42, "                        00000000{00000000{"); // QUE-TPTYPE-REC-RECV
        replaceValue(0, 8, "CARRAY  "); // QUE-REC-RECV-REC-TYPE
        replaceValue(24, 33, setCompNumber(9285, form9z)); // QUE-REC-RECV-LEN
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
     * setQueRecRecvRecType
     *******************************************************************************************************/
    /**
     *
     * @param queRecRecvRecType TODO_javadoc.
     *
     */
    public void setQueRecRecvRecType(String queRecRecvRecType) {
        replaceValue(0, 8, queRecRecvRecType);
    }

    /*******************************************************************************************************
     * setQueRecRecvSubType
     *******************************************************************************************************/
    /**
     *
     * @param queRecRecvSubType TODO_javadoc.
     *
     */
    public void setQueRecRecvSubType(String queRecRecvSubType) {
        replaceValue(8, 24, queRecRecvSubType);
    }

    /*******************************************************************************************************
     * setQueRecRecvLen
     *******************************************************************************************************/
    /**
     *
     * @param queRecRecvLen TODO_javadoc.
     *
     */
    public void setQueRecRecvLen(int queRecRecvLen) {
        replaceValue(24, 33, setCompNumber(queRecRecvLen, form9z));
    }

    /*******************************************************************************************************
     * setQueRecRecvTptypeStatus
     *******************************************************************************************************/
    /**
     *
     * @param queRecRecvTptypeStatus TODO_javadoc.
     *
     */
    public void setQueRecRecvTptypeStatus(int queRecRecvTptypeStatus) {
        replaceValue(33, 42, setCompNumber(queRecRecvTptypeStatus, form9z));
    }

    /*******************************************************************************************************
     * getQueRecRecvRecType
     *******************************************************************************************************/
    /**
     *
     * @return queRecRecvRecType TODO_javadoc.
     *
     */
    public String getQueRecRecvRecType() {
        return subValue(0, 8);
    }

    /*******************************************************************************************************
     * getQueRecRecvSubType
     *******************************************************************************************************/
    /**
     *
     * @return queRecRecvSubType TODO_javadoc.
     *
     */
    public String getQueRecRecvSubType() {
        return subValue(8, 24);
    }

    /*******************************************************************************************************
     * getQueRecRecvLen
     *******************************************************************************************************/
    /**
     *
     * @return queRecRecvLen TODO_javadoc.
     *
     */
    public int getQueRecRecvLen() {
        return (int) getCompNumber(subValue(24, 33));
    }

    /*******************************************************************************************************
     * getQueRecRecvTptypeStatus
     *******************************************************************************************************/
    /**
     *
     * @return queRecRecvTptypeStatus TODO_javadoc.
     *
     */
    public int getQueRecRecvTptypeStatus() {
        return (int) getCompNumber(subValue(33, 42));
    }

    /*******************************************************************************************************
     * setQueTptypeRecRecvTptypeok
     *******************************************************************************************************/
    /**
     *
     * @param queTptypeRecRecvTptypeok TODO_javadoc.
     *
     */
    public void setQueTptypeRecRecvTptypeok(boolean queTptypeRecRecvTptypeok) {

        if (!queTptypeRecRecvTptypeok) {
            throw new RuntimeException("Se intento setear queTptypeRecRecvTptypeok con false.");
        }

        setQueRecRecvTptypeStatus(0);
    }

    /*******************************************************************************************************
     * isQueTptypeRecRecvTptypeok
     *******************************************************************************************************/
    /**
     *
     * @return queTptypeRecRecvTptypeok TODO_javadoc.
     *
     */
    public boolean isQueTptypeRecRecvTptypeok() {
        return getQueRecRecvTptypeStatus() == 0;
    }

    /*******************************************************************************************************
     * setQueTptypeRecRecvTptruncate
     *******************************************************************************************************/
    /**
     *
     * @param queTptypeRecRecvTptruncate TODO_javadoc.
     *
     */
    public void setQueTptypeRecRecvTptruncate(boolean queTptypeRecRecvTptruncate) {

        if (!queTptypeRecRecvTptruncate) {
            throw new RuntimeException("Se intento setear queTptypeRecRecvTptruncate con false.");
        }

        setQueRecRecvTptypeStatus(1);
    }

    /*******************************************************************************************************
     * isQueTptypeRecRecvTptruncate
     *******************************************************************************************************/
    /**
     *
     * @return queTptypeRecRecvTptruncate TODO_javadoc.
     *
     */
    public boolean isQueTptypeRecRecvTptruncate() {
        return getQueRecRecvTptypeStatus() == 1;
    }

}

