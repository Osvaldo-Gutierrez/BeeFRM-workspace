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
public class WssTcmaCmn extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(WssTcmaCmn.class);

    /** TODO_javadoc. */
    private static DecimalFormat form1z = new DecimalFormat("0");

    /** TODO_javadoc. */
    private static DecimalFormat form3z = new DecimalFormat("000");

    /** TODO_javadoc. */
    private static DecimalFormat form4z = new DecimalFormat("0000");

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public WssTcmaCmn() {

        initBuffer(29);

        replaceValue(0, 29, "000000000000000           000"); // WSS-TCMA-CMN
        replaceValue(0, 4, form4z.format(0)); // WSS-J
        replaceValue(4, 8, form4z.format(0)); // WSS-K
        replaceValue(8, 9, form1z.format(0)); // WSS-IND-PRIMER
        replaceValue(9, 12, form3z.format(0)); // WSS-NUM-TSO
        replaceValue(12, 15, form3z.format(999)); // WSS-IND-ERROR
        replaceValue(15, 22, "       "); // WSS-MNU-GLS-ERRO
        replaceValue(22, 25, "   "); // WSS-MNU-COD-CMND
        replaceValue(25, 26, " "); // WSS-TDI-ERROR
        replaceValue(26, 29, form3z.format(1)); // WSS-NITM
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
    public void setValue(int value) {
        replaceValue(0, 29, setCompNumber(value, form4z));
    }

    /*******************************************************************************************************
     * getValue
     *******************************************************************************************************/
    /**
     *
     * @return value TODO_javadoc.
     *
     */
    public int getValue() {
        return (int) getCompNumber(subValue(0, 29));
    }

    //
    //
    //

    /*******************************************************************************************************
     * setWssJ
     *******************************************************************************************************/
    /**
     *
     * @param wssJ TODO_javadoc.
     *
     */
    public void setWssJ(int wssJ) {
        replaceValue(0, 4, form4z.format(wssJ));
    }

    /*******************************************************************************************************
     * setWssK
     *******************************************************************************************************/
    /**
     *
     * @param wssK TODO_javadoc.
     *
     */
    public void setWssK(int wssK) {
        replaceValue(4, 8, form4z.format(wssK));
    }

    /*******************************************************************************************************
     * setWssIndPrimer
     *******************************************************************************************************/
    /**
     *
     * @param wssIndPrimer TODO_javadoc.
     *
     */
    public void setWssIndPrimer(int wssIndPrimer) {
        replaceValue(8, 9, form1z.format(wssIndPrimer));
    }

    /*******************************************************************************************************
     * setWssNumTso
     *******************************************************************************************************/
    /**
     *
     * @param wssNumTso TODO_javadoc.
     *
     */
    public void setWssNumTso(int wssNumTso) {
        replaceValue(9, 12, form3z.format(wssNumTso));
    }

    /*******************************************************************************************************
     * setWssIndError
     *******************************************************************************************************/
    /**
     *
     * @param wssIndError TODO_javadoc.
     *
     */
    public void setWssIndError(int wssIndError) {
        replaceValue(12, 15, form3z.format(wssIndError));
    }

    /*******************************************************************************************************
     * setWssMnuGlsErro
     *******************************************************************************************************/
    /**
     *
     * @param wssMnuGlsErro TODO_javadoc.
     *
     */
    public void setWssMnuGlsErro(String wssMnuGlsErro) {
        replaceValue(15, 22, wssMnuGlsErro);
    }

    /*******************************************************************************************************
     * setWssMnuCodCmnd
     *******************************************************************************************************/
    /**
     *
     * @param wssMnuCodCmnd TODO_javadoc.
     *
     */
    public void setWssMnuCodCmnd(String wssMnuCodCmnd) {
        replaceValue(22, 25, wssMnuCodCmnd);
    }

    /*******************************************************************************************************
     * setWssTdiError
     *******************************************************************************************************/
    /**
     *
     * @param wssTdiError TODO_javadoc.
     *
     */
    public void setWssTdiError(String wssTdiError) {
        replaceValue(25, 26, wssTdiError);
    }

    /*******************************************************************************************************
     * setWssNitm
     *******************************************************************************************************/
    /**
     *
     * @param wssNitm TODO_javadoc.
     *
     */
    public void setWssNitm(int wssNitm) {
        replaceValue(26, 29, form3z.format(wssNitm));
    }

    /*******************************************************************************************************
     * getWssJ
     *******************************************************************************************************/
    /**
     *
     * @return wssJ TODO_javadoc.
     *
     */
    public int getWssJ() {
        return Integer.parseInt(subValue(0, 4));
    }

    /*******************************************************************************************************
     * getWssK
     *******************************************************************************************************/
    /**
     *
     * @return wssK TODO_javadoc.
     *
     */
    public int getWssK() {
        return Integer.parseInt(subValue(4, 8));
    }

    /*******************************************************************************************************
     * getWssIndPrimer
     *******************************************************************************************************/
    /**
     *
     * @return wssIndPrimer TODO_javadoc.
     *
     */
    public int getWssIndPrimer() {
        return Integer.parseInt(subValue(8, 9));
    }

    /*******************************************************************************************************
     * getWssNumTso
     *******************************************************************************************************/
    /**
     *
     * @return wssNumTso TODO_javadoc.
     *
     */
    public int getWssNumTso() {
        return Integer.parseInt(subValue(9, 12));
    }

    /*******************************************************************************************************
     * getWssIndError
     *******************************************************************************************************/
    /**
     *
     * @return wssIndError TODO_javadoc.
     *
     */
    public int getWssIndError() {
        return Integer.parseInt(subValue(12, 15));
    }

    /*******************************************************************************************************
     * getWssMnuGlsErro
     *******************************************************************************************************/
    /**
     *
     * @return wssMnuGlsErro TODO_javadoc.
     *
     */
    public String getWssMnuGlsErro() {
        return subValue(15, 22);
    }

    /*******************************************************************************************************
     * getWssMnuCodCmnd
     *******************************************************************************************************/
    /**
     *
     * @return wssMnuCodCmnd TODO_javadoc.
     *
     */
    public String getWssMnuCodCmnd() {
        return subValue(22, 25);
    }

    /*******************************************************************************************************
     * getWssTdiError
     *******************************************************************************************************/
    /**
     *
     * @return wssTdiError TODO_javadoc.
     *
     */
    public String getWssTdiError() {
        return subValue(25, 26);
    }

    /*******************************************************************************************************
     * getWssNitm
     *******************************************************************************************************/
    /**
     *
     * @return wssNitm TODO_javadoc.
     *
     */
    public int getWssNitm() {
        return Integer.parseInt(subValue(26, 29));
    }

    /*******************************************************************************************************
     * setPrimeraVez
     *******************************************************************************************************/
    /**
     *
     * @param primeraVez TODO_javadoc.
     *
     */
    public void setPrimeraVez(boolean primeraVez) {

        if (!primeraVez) {
            throw new RuntimeException("Se intento setear primeraVez con false.");
        }

        setWssIndPrimer(1);
    }

    /*******************************************************************************************************
     * isPrimeraVez
     *******************************************************************************************************/
    /**
     *
     * @return primeraVez TODO_javadoc.
     *
     */
    public boolean isPrimeraVez() {
        return getWssIndPrimer() == 1;
    }

    /*******************************************************************************************************
     * setTdiGlsError
     *******************************************************************************************************/
    /**
     *
     * @param tdiGlsError TODO_javadoc.
     *
     */
    public void setTdiGlsError(boolean tdiGlsError) {

        if (!tdiGlsError) {
            throw new RuntimeException("Se intento setear tdiGlsError con false.");
        }

        setWssTdiError("S");
    }

    /*******************************************************************************************************
     * isTdiGlsError
     *******************************************************************************************************/
    /**
     *
     * @return tdiGlsError TODO_javadoc.
     *
     */
    public boolean isTdiGlsError() {
        return getWssTdiError().equals("S");
    }

}

