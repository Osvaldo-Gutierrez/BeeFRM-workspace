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
public class QueTptypeRecSend extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(QueTptypeRecSend.class);

    /** TODO_javadoc. */
    private static DecimalFormat form9z = new DecimalFormat("000000000");

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public QueTptypeRecSend() {

        initBuffer(42);

        replaceValue(0, 42, "                        00000000{00000000{"); // QUE-TPTYPE-REC-SEND
        replaceValue(0, 8, "CARRAY  "); // QUE-REC-SEND-REC-TYPE
        replaceValue(24, 33, setCompNumber(9568, form9z)); // QUE-REC-SEND-LEN
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
     * setQueRecSendRecType
     *******************************************************************************************************/
    /**
     *
     * @param queRecSendRecType TODO_javadoc.
     *
     */
    public void setQueRecSendRecType(String queRecSendRecType) {
        replaceValue(0, 8, queRecSendRecType);
    }

    /*******************************************************************************************************
     * setQueRecSendSubType
     *******************************************************************************************************/
    /**
     *
     * @param queRecSendSubType TODO_javadoc.
     *
     */
    public void setQueRecSendSubType(String queRecSendSubType) {
        replaceValue(8, 24, queRecSendSubType);
    }

    /*******************************************************************************************************
     * setQueRecSendLen
     *******************************************************************************************************/
    /**
     *
     * @param queRecSendLen TODO_javadoc.
     *
     */
    public void setQueRecSendLen(int queRecSendLen) {
        replaceValue(24, 33, setCompNumber(queRecSendLen, form9z));
    }

    /*******************************************************************************************************
     * setQueRecSendTptypeStatus
     *******************************************************************************************************/
    /**
     *
     * @param queRecSendTptypeStatus TODO_javadoc.
     *
     */
    public void setQueRecSendTptypeStatus(int queRecSendTptypeStatus) {
        replaceValue(33, 42, setCompNumber(queRecSendTptypeStatus, form9z));
    }

    /*******************************************************************************************************
     * getQueRecSendRecType
     *******************************************************************************************************/
    /**
     *
     * @return queRecSendRecType TODO_javadoc.
     *
     */
    public String getQueRecSendRecType() {
        return subValue(0, 8);
    }

    /*******************************************************************************************************
     * getQueRecSendSubType
     *******************************************************************************************************/
    /**
     *
     * @return queRecSendSubType TODO_javadoc.
     *
     */
    public String getQueRecSendSubType() {
        return subValue(8, 24);
    }

    /*******************************************************************************************************
     * getQueRecSendLen
     *******************************************************************************************************/
    /**
     *
     * @return queRecSendLen TODO_javadoc.
     *
     */
    public int getQueRecSendLen() {
        return (int) getCompNumber(subValue(24, 33));
    }

    /*******************************************************************************************************
     * getQueRecSendTptypeStatus
     *******************************************************************************************************/
    /**
     *
     * @return queRecSendTptypeStatus TODO_javadoc.
     *
     */
    public int getQueRecSendTptypeStatus() {
        return (int) getCompNumber(subValue(33, 42));
    }

    /*******************************************************************************************************
     * setQueTptypeRecSendTptypeok
     *******************************************************************************************************/
    /**
     *
     * @param queTptypeRecSendTptypeok TODO_javadoc.
     *
     */
    public void setQueTptypeRecSendTptypeok(boolean queTptypeRecSendTptypeok) {

        if (!queTptypeRecSendTptypeok) {
            throw new RuntimeException("Se intento setear queTptypeRecSendTptypeok con false.");
        }

        setQueRecSendTptypeStatus(0);
    }

    /*******************************************************************************************************
     * isQueTptypeRecSendTptypeok
     *******************************************************************************************************/
    /**
     *
     * @return queTptypeRecSendTptypeok TODO_javadoc.
     *
     */
    public boolean isQueTptypeRecSendTptypeok() {
        return getQueRecSendTptypeStatus() == 0;
    }

    /*******************************************************************************************************
     * setQueTptypeRecSendTptruncate
     *******************************************************************************************************/
    /**
     *
     * @param queTptypeRecSendTptruncate TODO_javadoc.
     *
     */
    public void setQueTptypeRecSendTptruncate(boolean queTptypeRecSendTptruncate) {

        if (!queTptypeRecSendTptruncate) {
            throw new RuntimeException("Se intento setear queTptypeRecSendTptruncate con false.");
        }

        setQueRecSendTptypeStatus(1);
    }

    /*******************************************************************************************************
     * isQueTptypeRecSendTptruncate
     *******************************************************************************************************/
    /**
     *
     * @return queTptypeRecSendTptruncate TODO_javadoc.
     *
     */
    public boolean isQueTptypeRecSendTptruncate() {
        return getQueRecSendTptypeStatus() == 1;
    }

}

