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
public class WssTot extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(WssTot.class);

    /** TODO_javadoc. */
    private static DecimalFormat form5z = new DecimalFormat("00000");

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public WssTot() {

        initBuffer(120);

        replaceValue(0, 120, "000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"); // WSS-TOT
        replaceValue(0, 5, form5z.format(0)); // WSS-MNU-ERP
        replaceValue(10, 15, form5z.format(0)); // WSS-MNU-ERM
        replaceValue(20, 25, form5z.format(0)); // WSS-MNU-PUT
        replaceValue(30, 35, form5z.format(0)); // WSS-MNU-MOD
        replaceValue(40, 45, form5z.format(0)); // WSS-RPF-ERP
        replaceValue(50, 55, form5z.format(0)); // WSS-RPF-ERM
        replaceValue(60, 65, form5z.format(0)); // WSS-RPF-PUT
        replaceValue(70, 75, form5z.format(0)); // WSS-RPF-MOD
        replaceValue(80, 85, form5z.format(0)); // WSS-TAB-ERP
        replaceValue(90, 95, form5z.format(0)); // WSS-TAB-ERM
        replaceValue(100, 105, form5z.format(0)); // WSS-TAB-PUT
        replaceValue(110, 115, form5z.format(0)); // WSS-TAB-MOD
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
        replaceValue(0, 120, value);
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
        return subValue(0, 120);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setWssMnuErp
     *******************************************************************************************************/
    /**
     *
     * @param wssMnuErp TODO_javadoc.
     *
     */
    public void setWssMnuErp(int wssMnuErp) {
        replaceValue(0, 5, form5z.format(wssMnuErp));
    }

    /*******************************************************************************************************
     * setWssMnuErpEdt
     *******************************************************************************************************/
    /**
     *
     * @param wssMnuErpEdt TODO_javadoc.
     *
     */
    public void setWssMnuErpEdt(int wssMnuErpEdt) {
        replaceValue(5, 10, form5z.format(wssMnuErpEdt));
    }

    /*******************************************************************************************************
     * setWssMnuErm
     *******************************************************************************************************/
    /**
     *
     * @param wssMnuErm TODO_javadoc.
     *
     */
    public void setWssMnuErm(int wssMnuErm) {
        replaceValue(10, 15, form5z.format(wssMnuErm));
    }

    /*******************************************************************************************************
     * setWssMnuErmEdt
     *******************************************************************************************************/
    /**
     *
     * @param wssMnuErmEdt TODO_javadoc.
     *
     */
    public void setWssMnuErmEdt(int wssMnuErmEdt) {
        replaceValue(15, 20, form5z.format(wssMnuErmEdt));
    }

    /*******************************************************************************************************
     * setWssMnuPut
     *******************************************************************************************************/
    /**
     *
     * @param wssMnuPut TODO_javadoc.
     *
     */
    public void setWssMnuPut(int wssMnuPut) {
        replaceValue(20, 25, form5z.format(wssMnuPut));
    }

    /*******************************************************************************************************
     * setWssMnuPutEdt
     *******************************************************************************************************/
    /**
     *
     * @param wssMnuPutEdt TODO_javadoc.
     *
     */
    public void setWssMnuPutEdt(int wssMnuPutEdt) {
        replaceValue(25, 30, form5z.format(wssMnuPutEdt));
    }

    /*******************************************************************************************************
     * setWssMnuMod
     *******************************************************************************************************/
    /**
     *
     * @param wssMnuMod TODO_javadoc.
     *
     */
    public void setWssMnuMod(int wssMnuMod) {
        replaceValue(30, 35, form5z.format(wssMnuMod));
    }

    /*******************************************************************************************************
     * setWssMnuModEdt
     *******************************************************************************************************/
    /**
     *
     * @param wssMnuModEdt TODO_javadoc.
     *
     */
    public void setWssMnuModEdt(int wssMnuModEdt) {
        replaceValue(35, 40, form5z.format(wssMnuModEdt));
    }

    /*******************************************************************************************************
     * setWssRpfErp
     *******************************************************************************************************/
    /**
     *
     * @param wssRpfErp TODO_javadoc.
     *
     */
    public void setWssRpfErp(int wssRpfErp) {
        replaceValue(40, 45, form5z.format(wssRpfErp));
    }

    /*******************************************************************************************************
     * setWssRpfErpEdt
     *******************************************************************************************************/
    /**
     *
     * @param wssRpfErpEdt TODO_javadoc.
     *
     */
    public void setWssRpfErpEdt(int wssRpfErpEdt) {
        replaceValue(45, 50, form5z.format(wssRpfErpEdt));
    }

    /*******************************************************************************************************
     * setWssRpfErm
     *******************************************************************************************************/
    /**
     *
     * @param wssRpfErm TODO_javadoc.
     *
     */
    public void setWssRpfErm(int wssRpfErm) {
        replaceValue(50, 55, form5z.format(wssRpfErm));
    }

    /*******************************************************************************************************
     * setWssRpfErmEdt
     *******************************************************************************************************/
    /**
     *
     * @param wssRpfErmEdt TODO_javadoc.
     *
     */
    public void setWssRpfErmEdt(int wssRpfErmEdt) {
        replaceValue(55, 60, form5z.format(wssRpfErmEdt));
    }

    /*******************************************************************************************************
     * setWssRpfPut
     *******************************************************************************************************/
    /**
     *
     * @param wssRpfPut TODO_javadoc.
     *
     */
    public void setWssRpfPut(int wssRpfPut) {
        replaceValue(60, 65, form5z.format(wssRpfPut));
    }

    /*******************************************************************************************************
     * setWssRpfPutEdt
     *******************************************************************************************************/
    /**
     *
     * @param wssRpfPutEdt TODO_javadoc.
     *
     */
    public void setWssRpfPutEdt(int wssRpfPutEdt) {
        replaceValue(65, 70, form5z.format(wssRpfPutEdt));
    }

    /*******************************************************************************************************
     * setWssRpfMod
     *******************************************************************************************************/
    /**
     *
     * @param wssRpfMod TODO_javadoc.
     *
     */
    public void setWssRpfMod(int wssRpfMod) {
        replaceValue(70, 75, form5z.format(wssRpfMod));
    }

    /*******************************************************************************************************
     * setWssRpfModEdt
     *******************************************************************************************************/
    /**
     *
     * @param wssRpfModEdt TODO_javadoc.
     *
     */
    public void setWssRpfModEdt(int wssRpfModEdt) {
        replaceValue(75, 80, form5z.format(wssRpfModEdt));
    }

    /*******************************************************************************************************
     * setWssTabErp
     *******************************************************************************************************/
    /**
     *
     * @param wssTabErp TODO_javadoc.
     *
     */
    public void setWssTabErp(int wssTabErp) {
        replaceValue(80, 85, form5z.format(wssTabErp));
    }

    /*******************************************************************************************************
     * setWssTabErpEdt
     *******************************************************************************************************/
    /**
     *
     * @param wssTabErpEdt TODO_javadoc.
     *
     */
    public void setWssTabErpEdt(int wssTabErpEdt) {
        replaceValue(85, 90, form5z.format(wssTabErpEdt));
    }

    /*******************************************************************************************************
     * setWssTabErm
     *******************************************************************************************************/
    /**
     *
     * @param wssTabErm TODO_javadoc.
     *
     */
    public void setWssTabErm(int wssTabErm) {
        replaceValue(90, 95, form5z.format(wssTabErm));
    }

    /*******************************************************************************************************
     * setWssTabErmEdt
     *******************************************************************************************************/
    /**
     *
     * @param wssTabErmEdt TODO_javadoc.
     *
     */
    public void setWssTabErmEdt(int wssTabErmEdt) {
        replaceValue(95, 100, form5z.format(wssTabErmEdt));
    }

    /*******************************************************************************************************
     * setWssTabPut
     *******************************************************************************************************/
    /**
     *
     * @param wssTabPut TODO_javadoc.
     *
     */
    public void setWssTabPut(int wssTabPut) {
        replaceValue(100, 105, form5z.format(wssTabPut));
    }

    /*******************************************************************************************************
     * setWssTabPutEdt
     *******************************************************************************************************/
    /**
     *
     * @param wssTabPutEdt TODO_javadoc.
     *
     */
    public void setWssTabPutEdt(int wssTabPutEdt) {
        replaceValue(105, 110, form5z.format(wssTabPutEdt));
    }

    /*******************************************************************************************************
     * setWssTabMod
     *******************************************************************************************************/
    /**
     *
     * @param wssTabMod TODO_javadoc.
     *
     */
    public void setWssTabMod(int wssTabMod) {
        replaceValue(110, 115, form5z.format(wssTabMod));
    }

    /*******************************************************************************************************
     * setWssTabModEdt
     *******************************************************************************************************/
    /**
     *
     * @param wssTabModEdt TODO_javadoc.
     *
     */
    public void setWssTabModEdt(int wssTabModEdt) {
        replaceValue(115, 120, form5z.format(wssTabModEdt));
    }

    /*******************************************************************************************************
     * getWssMnuErp
     *******************************************************************************************************/
    /**
     *
     * @return wssMnuErp TODO_javadoc.
     *
     */
    public int getWssMnuErp() {
        return Integer.parseInt(subValue(0, 5));
    }

    /*******************************************************************************************************
     * getWssMnuErpEdt
     *******************************************************************************************************/
    /**
     *
     * @return wssMnuErpEdt TODO_javadoc.
     *
     */
    public int getWssMnuErpEdt() {
        return Integer.parseInt(subValue(5, 10));
    }

    /*******************************************************************************************************
     * getWssMnuErm
     *******************************************************************************************************/
    /**
     *
     * @return wssMnuErm TODO_javadoc.
     *
     */
    public int getWssMnuErm() {
        return Integer.parseInt(subValue(10, 15));
    }

    /*******************************************************************************************************
     * getWssMnuErmEdt
     *******************************************************************************************************/
    /**
     *
     * @return wssMnuErmEdt TODO_javadoc.
     *
     */
    public int getWssMnuErmEdt() {
        return Integer.parseInt(subValue(15, 20));
    }

    /*******************************************************************************************************
     * getWssMnuPut
     *******************************************************************************************************/
    /**
     *
     * @return wssMnuPut TODO_javadoc.
     *
     */
    public int getWssMnuPut() {
        return Integer.parseInt(subValue(20, 25));
    }

    /*******************************************************************************************************
     * getWssMnuPutEdt
     *******************************************************************************************************/
    /**
     *
     * @return wssMnuPutEdt TODO_javadoc.
     *
     */
    public int getWssMnuPutEdt() {
        return Integer.parseInt(subValue(25, 30));
    }

    /*******************************************************************************************************
     * getWssMnuMod
     *******************************************************************************************************/
    /**
     *
     * @return wssMnuMod TODO_javadoc.
     *
     */
    public int getWssMnuMod() {
        return Integer.parseInt(subValue(30, 35));
    }

    /*******************************************************************************************************
     * getWssMnuModEdt
     *******************************************************************************************************/
    /**
     *
     * @return wssMnuModEdt TODO_javadoc.
     *
     */
    public int getWssMnuModEdt() {
        return Integer.parseInt(subValue(35, 40));
    }

    /*******************************************************************************************************
     * getWssRpfErp
     *******************************************************************************************************/
    /**
     *
     * @return wssRpfErp TODO_javadoc.
     *
     */
    public int getWssRpfErp() {
        return Integer.parseInt(subValue(40, 45));
    }

    /*******************************************************************************************************
     * getWssRpfErpEdt
     *******************************************************************************************************/
    /**
     *
     * @return wssRpfErpEdt TODO_javadoc.
     *
     */
    public int getWssRpfErpEdt() {
        return Integer.parseInt(subValue(45, 50));
    }

    /*******************************************************************************************************
     * getWssRpfErm
     *******************************************************************************************************/
    /**
     *
     * @return wssRpfErm TODO_javadoc.
     *
     */
    public int getWssRpfErm() {
        return Integer.parseInt(subValue(50, 55));
    }

    /*******************************************************************************************************
     * getWssRpfErmEdt
     *******************************************************************************************************/
    /**
     *
     * @return wssRpfErmEdt TODO_javadoc.
     *
     */
    public int getWssRpfErmEdt() {
        return Integer.parseInt(subValue(55, 60));
    }

    /*******************************************************************************************************
     * getWssRpfPut
     *******************************************************************************************************/
    /**
     *
     * @return wssRpfPut TODO_javadoc.
     *
     */
    public int getWssRpfPut() {
        return Integer.parseInt(subValue(60, 65));
    }

    /*******************************************************************************************************
     * getWssRpfPutEdt
     *******************************************************************************************************/
    /**
     *
     * @return wssRpfPutEdt TODO_javadoc.
     *
     */
    public int getWssRpfPutEdt() {
        return Integer.parseInt(subValue(65, 70));
    }

    /*******************************************************************************************************
     * getWssRpfMod
     *******************************************************************************************************/
    /**
     *
     * @return wssRpfMod TODO_javadoc.
     *
     */
    public int getWssRpfMod() {
        return Integer.parseInt(subValue(70, 75));
    }

    /*******************************************************************************************************
     * getWssRpfModEdt
     *******************************************************************************************************/
    /**
     *
     * @return wssRpfModEdt TODO_javadoc.
     *
     */
    public int getWssRpfModEdt() {
        return Integer.parseInt(subValue(75, 80));
    }

    /*******************************************************************************************************
     * getWssTabErp
     *******************************************************************************************************/
    /**
     *
     * @return wssTabErp TODO_javadoc.
     *
     */
    public int getWssTabErp() {
        return Integer.parseInt(subValue(80, 85));
    }

    /*******************************************************************************************************
     * getWssTabErpEdt
     *******************************************************************************************************/
    /**
     *
     * @return wssTabErpEdt TODO_javadoc.
     *
     */
    public int getWssTabErpEdt() {
        return Integer.parseInt(subValue(85, 90));
    }

    /*******************************************************************************************************
     * getWssTabErm
     *******************************************************************************************************/
    /**
     *
     * @return wssTabErm TODO_javadoc.
     *
     */
    public int getWssTabErm() {
        return Integer.parseInt(subValue(90, 95));
    }

    /*******************************************************************************************************
     * getWssTabErmEdt
     *******************************************************************************************************/
    /**
     *
     * @return wssTabErmEdt TODO_javadoc.
     *
     */
    public int getWssTabErmEdt() {
        return Integer.parseInt(subValue(95, 100));
    }

    /*******************************************************************************************************
     * getWssTabPut
     *******************************************************************************************************/
    /**
     *
     * @return wssTabPut TODO_javadoc.
     *
     */
    public int getWssTabPut() {
        return Integer.parseInt(subValue(100, 105));
    }

    /*******************************************************************************************************
     * getWssTabPutEdt
     *******************************************************************************************************/
    /**
     *
     * @return wssTabPutEdt TODO_javadoc.
     *
     */
    public int getWssTabPutEdt() {
        return Integer.parseInt(subValue(105, 110));
    }

    /*******************************************************************************************************
     * getWssTabMod
     *******************************************************************************************************/
    /**
     *
     * @return wssTabMod TODO_javadoc.
     *
     */
    public int getWssTabMod() {
        return Integer.parseInt(subValue(110, 115));
    }

    /*******************************************************************************************************
     * getWssTabModEdt
     *******************************************************************************************************/
    /**
     *
     * @return wssTabModEdt TODO_javadoc.
     *
     */
    public int getWssTabModEdt() {
        return Integer.parseInt(subValue(115, 120));
    }

}

