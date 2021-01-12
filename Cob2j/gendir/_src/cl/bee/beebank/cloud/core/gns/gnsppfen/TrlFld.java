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
public class TrlFld extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(TrlFld.class);

    /** TODO_javadoc. */
    private static DecimalFormat form4z = new DecimalFormat("0000");

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public TrlFld() {

        initBuffer(270);

        replaceValue(0, 270, "            000{                                                                                000{                                        000{                          000{            000{                                                                                "); // TRL-FLD
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
        replaceValue(0, 270, value);
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
        return subValue(0, 270);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setFiller
     *******************************************************************************************************/
    /**
     *
     * @param filler TODO_javadoc.
     *
     */
    public void setFiller(String filler) {
        replaceValue(0, 12, filler);
    }

    /*******************************************************************************************************
     * setTrlGlsTermLen
     *******************************************************************************************************/
    /**
     *
     * @param trlGlsTermLen TODO_javadoc.
     *
     */
    public void setTrlGlsTermLen(int trlGlsTermLen) {
        replaceValue(12, 16, setCompNumber(trlGlsTermLen, form4z));
    }

    /*******************************************************************************************************
     * setTrlGlsTermAtr
     *******************************************************************************************************/
    /**
     *
     * @param trlGlsTermAtr TODO_javadoc.
     *
     */
    public void setTrlGlsTermAtr(String trlGlsTermAtr) {
        replaceValue(16, 17, trlGlsTermAtr);
    }

    /*******************************************************************************************************
     * setTrlGlsTerm
     *******************************************************************************************************/
    /**
     *
     * @param trlGlsTerm TODO_javadoc.
     *
     */
    public void setTrlGlsTerm(String trlGlsTerm) {
        replaceValue(17, 96, trlGlsTerm);
    }

    /*******************************************************************************************************
     * setTrlCodCmndLen
     *******************************************************************************************************/
    /**
     *
     * @param trlCodCmndLen TODO_javadoc.
     *
     */
    public void setTrlCodCmndLen(int trlCodCmndLen) {
        replaceValue(96, 100, setCompNumber(trlCodCmndLen, form4z));
    }

    /*******************************************************************************************************
     * setTrlCodCmndAtr
     *******************************************************************************************************/
    /**
     *
     * @param trlCodCmndAtr TODO_javadoc.
     *
     */
    public void setTrlCodCmndAtr(String trlCodCmndAtr) {
        replaceValue(100, 101, trlCodCmndAtr);
    }

    /*******************************************************************************************************
     * setTrlCodCmnd
     *******************************************************************************************************/
    /**
     *
     * @param trlCodCmnd TODO_javadoc.
     *
     */
    public void setTrlCodCmnd(String trlCodCmnd) {
        replaceValue(101, 140, trlCodCmnd);
    }

    /*******************************************************************************************************
     * setTrlGlsPrmtLen
     *******************************************************************************************************/
    /**
     *
     * @param trlGlsPrmtLen TODO_javadoc.
     *
     */
    public void setTrlGlsPrmtLen(int trlGlsPrmtLen) {
        replaceValue(140, 144, setCompNumber(trlGlsPrmtLen, form4z));
    }

    /*******************************************************************************************************
     * setTrlGlsPrmtAtr
     *******************************************************************************************************/
    /**
     *
     * @param trlGlsPrmtAtr TODO_javadoc.
     *
     */
    public void setTrlGlsPrmtAtr(String trlGlsPrmtAtr) {
        replaceValue(144, 145, trlGlsPrmtAtr);
    }

    /*******************************************************************************************************
     * setTrlGlsPrmt
     *******************************************************************************************************/
    /**
     *
     * @param trlGlsPrmt TODO_javadoc.
     *
     */
    public void setTrlGlsPrmt(String trlGlsPrmt) {
        replaceValue(145, 170, trlGlsPrmt);
    }

    /*******************************************************************************************************
     * setTrlCodCaccLen
     *******************************************************************************************************/
    /**
     *
     * @param trlCodCaccLen TODO_javadoc.
     *
     */
    public void setTrlCodCaccLen(int trlCodCaccLen) {
        replaceValue(170, 174, setCompNumber(trlCodCaccLen, form4z));
    }

    /*******************************************************************************************************
     * setTrlCodCaccAtr
     *******************************************************************************************************/
    /**
     *
     * @param trlCodCaccAtr TODO_javadoc.
     *
     */
    public void setTrlCodCaccAtr(String trlCodCaccAtr) {
        replaceValue(174, 175, trlCodCaccAtr);
    }

    /*******************************************************************************************************
     * setTrlCodCacc
     *******************************************************************************************************/
    /**
     *
     * @param trlCodCacc TODO_javadoc.
     *
     */
    public void setTrlCodCacc(String trlCodCacc) {
        replaceValue(175, 186, trlCodCacc);
    }

    /*******************************************************************************************************
     * setTrlGlsMensLen
     *******************************************************************************************************/
    /**
     *
     * @param trlGlsMensLen TODO_javadoc.
     *
     */
    public void setTrlGlsMensLen(int trlGlsMensLen) {
        replaceValue(186, 190, setCompNumber(trlGlsMensLen, form4z));
    }

    /*******************************************************************************************************
     * setTrlGlsMensAtr
     *******************************************************************************************************/
    /**
     *
     * @param trlGlsMensAtr TODO_javadoc.
     *
     */
    public void setTrlGlsMensAtr(String trlGlsMensAtr) {
        replaceValue(190, 191, trlGlsMensAtr);
    }

    /*******************************************************************************************************
     * setTrlGlsMens
     *******************************************************************************************************/
    /**
     *
     * @param trlGlsMens TODO_javadoc.
     *
     */
    public void setTrlGlsMens(String trlGlsMens) {
        replaceValue(191, 270, trlGlsMens);
    }

    /*******************************************************************************************************
     * getFiller
     *******************************************************************************************************/
    /**
     *
     * @return filler TODO_javadoc.
     *
     */
    public String getFiller() {
        return subValue(0, 12);
    }

    /*******************************************************************************************************
     * getTrlGlsTermLen
     *******************************************************************************************************/
    /**
     *
     * @return trlGlsTermLen TODO_javadoc.
     *
     */
    public int getTrlGlsTermLen() {
        return (int) getCompNumber(subValue(12, 16));
    }

    /*******************************************************************************************************
     * getTrlGlsTermAtr
     *******************************************************************************************************/
    /**
     *
     * @return trlGlsTermAtr TODO_javadoc.
     *
     */
    public String getTrlGlsTermAtr() {
        return subValue(16, 17);
    }

    /*******************************************************************************************************
     * getTrlGlsTerm
     *******************************************************************************************************/
    /**
     *
     * @return trlGlsTerm TODO_javadoc.
     *
     */
    public String getTrlGlsTerm() {
        return subValue(17, 96);
    }

    /*******************************************************************************************************
     * getTrlCodCmndLen
     *******************************************************************************************************/
    /**
     *
     * @return trlCodCmndLen TODO_javadoc.
     *
     */
    public int getTrlCodCmndLen() {
        return (int) getCompNumber(subValue(96, 100));
    }

    /*******************************************************************************************************
     * getTrlCodCmndAtr
     *******************************************************************************************************/
    /**
     *
     * @return trlCodCmndAtr TODO_javadoc.
     *
     */
    public String getTrlCodCmndAtr() {
        return subValue(100, 101);
    }

    /*******************************************************************************************************
     * getTrlCodCmnd
     *******************************************************************************************************/
    /**
     *
     * @return trlCodCmnd TODO_javadoc.
     *
     */
    public String getTrlCodCmnd() {
        return subValue(101, 140);
    }

    /*******************************************************************************************************
     * getTrlGlsPrmtLen
     *******************************************************************************************************/
    /**
     *
     * @return trlGlsPrmtLen TODO_javadoc.
     *
     */
    public int getTrlGlsPrmtLen() {
        return (int) getCompNumber(subValue(140, 144));
    }

    /*******************************************************************************************************
     * getTrlGlsPrmtAtr
     *******************************************************************************************************/
    /**
     *
     * @return trlGlsPrmtAtr TODO_javadoc.
     *
     */
    public String getTrlGlsPrmtAtr() {
        return subValue(144, 145);
    }

    /*******************************************************************************************************
     * getTrlGlsPrmt
     *******************************************************************************************************/
    /**
     *
     * @return trlGlsPrmt TODO_javadoc.
     *
     */
    public String getTrlGlsPrmt() {
        return subValue(145, 170);
    }

    /*******************************************************************************************************
     * getTrlCodCaccLen
     *******************************************************************************************************/
    /**
     *
     * @return trlCodCaccLen TODO_javadoc.
     *
     */
    public int getTrlCodCaccLen() {
        return (int) getCompNumber(subValue(170, 174));
    }

    /*******************************************************************************************************
     * getTrlCodCaccAtr
     *******************************************************************************************************/
    /**
     *
     * @return trlCodCaccAtr TODO_javadoc.
     *
     */
    public String getTrlCodCaccAtr() {
        return subValue(174, 175);
    }

    /*******************************************************************************************************
     * getTrlCodCacc
     *******************************************************************************************************/
    /**
     *
     * @return trlCodCacc TODO_javadoc.
     *
     */
    public String getTrlCodCacc() {
        return subValue(175, 186);
    }

    /*******************************************************************************************************
     * getTrlGlsMensLen
     *******************************************************************************************************/
    /**
     *
     * @return trlGlsMensLen TODO_javadoc.
     *
     */
    public int getTrlGlsMensLen() {
        return (int) getCompNumber(subValue(186, 190));
    }

    /*******************************************************************************************************
     * getTrlGlsMensAtr
     *******************************************************************************************************/
    /**
     *
     * @return trlGlsMensAtr TODO_javadoc.
     *
     */
    public String getTrlGlsMensAtr() {
        return subValue(190, 191);
    }

    /*******************************************************************************************************
     * getTrlGlsMens
     *******************************************************************************************************/
    /**
     *
     * @return trlGlsMens TODO_javadoc.
     *
     */
    public String getTrlGlsMens() {
        return subValue(191, 270);
    }

}

