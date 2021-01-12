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

        initBuffer(180);

        replaceValue(0, 180, "000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"); // WSS-TOT
        replaceValue(0, 5, form5z.format(0)); // WSS-MNU-ERP
        replaceValue(10, 15, form5z.format(0)); // WSS-MNU-ERM
        replaceValue(20, 25, form5z.format(0)); // WSS-MNU-ERE
        replaceValue(30, 35, form5z.format(0)); // WSS-MNU-PUT
        replaceValue(40, 45, form5z.format(0)); // WSS-MNU-MOD
        replaceValue(50, 55, form5z.format(0)); // WSS-MNU-ELI
        replaceValue(60, 65, form5z.format(0)); // WSS-RPF-ERP
        replaceValue(70, 75, form5z.format(0)); // WSS-RPF-ERM
        replaceValue(80, 85, form5z.format(0)); // WSS-RPF-ERE
        replaceValue(90, 95, form5z.format(0)); // WSS-RPF-PUT
        replaceValue(100, 105, form5z.format(0)); // WSS-RPF-MOD
        replaceValue(110, 115, form5z.format(0)); // WSS-RPF-ELI
        replaceValue(120, 125, form5z.format(0)); // WSS-TAB-ERP
        replaceValue(130, 135, form5z.format(0)); // WSS-TAB-ERM
        replaceValue(140, 145, form5z.format(0)); // WSS-TAB-ERE
        replaceValue(150, 155, form5z.format(0)); // WSS-TAB-PUT
        replaceValue(160, 165, form5z.format(0)); // WSS-TAB-MOD
        replaceValue(170, 175, form5z.format(0)); // WSS-TAB-ELI
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
        replaceValue(0, 180, value);
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
        return subValue(0, 180);
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
     * setWssMnuEre
     *******************************************************************************************************/
    /**
     *
     * @param wssMnuEre TODO_javadoc.
     *
     */
    public void setWssMnuEre(int wssMnuEre) {
        replaceValue(20, 25, form5z.format(wssMnuEre));
    }

    /*******************************************************************************************************
     * setWssMnuEreEdt
     *******************************************************************************************************/
    /**
     *
     * @param wssMnuEreEdt TODO_javadoc.
     *
     */
    public void setWssMnuEreEdt(int wssMnuEreEdt) {
        replaceValue(25, 30, form5z.format(wssMnuEreEdt));
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
        replaceValue(30, 35, form5z.format(wssMnuPut));
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
        replaceValue(35, 40, form5z.format(wssMnuPutEdt));
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
        replaceValue(40, 45, form5z.format(wssMnuMod));
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
        replaceValue(45, 50, form5z.format(wssMnuModEdt));
    }

    /*******************************************************************************************************
     * setWssMnuEli
     *******************************************************************************************************/
    /**
     *
     * @param wssMnuEli TODO_javadoc.
     *
     */
    public void setWssMnuEli(int wssMnuEli) {
        replaceValue(50, 55, form5z.format(wssMnuEli));
    }

    /*******************************************************************************************************
     * setWssMnuEliEdt
     *******************************************************************************************************/
    /**
     *
     * @param wssMnuEliEdt TODO_javadoc.
     *
     */
    public void setWssMnuEliEdt(int wssMnuEliEdt) {
        replaceValue(55, 60, form5z.format(wssMnuEliEdt));
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
        replaceValue(60, 65, form5z.format(wssRpfErp));
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
        replaceValue(65, 70, form5z.format(wssRpfErpEdt));
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
        replaceValue(70, 75, form5z.format(wssRpfErm));
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
        replaceValue(75, 80, form5z.format(wssRpfErmEdt));
    }

    /*******************************************************************************************************
     * setWssRpfEre
     *******************************************************************************************************/
    /**
     *
     * @param wssRpfEre TODO_javadoc.
     *
     */
    public void setWssRpfEre(int wssRpfEre) {
        replaceValue(80, 85, form5z.format(wssRpfEre));
    }

    /*******************************************************************************************************
     * setWssRpfEreEdt
     *******************************************************************************************************/
    /**
     *
     * @param wssRpfEreEdt TODO_javadoc.
     *
     */
    public void setWssRpfEreEdt(int wssRpfEreEdt) {
        replaceValue(85, 90, form5z.format(wssRpfEreEdt));
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
        replaceValue(90, 95, form5z.format(wssRpfPut));
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
        replaceValue(95, 100, form5z.format(wssRpfPutEdt));
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
        replaceValue(100, 105, form5z.format(wssRpfMod));
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
        replaceValue(105, 110, form5z.format(wssRpfModEdt));
    }

    /*******************************************************************************************************
     * setWssRpfEli
     *******************************************************************************************************/
    /**
     *
     * @param wssRpfEli TODO_javadoc.
     *
     */
    public void setWssRpfEli(int wssRpfEli) {
        replaceValue(110, 115, form5z.format(wssRpfEli));
    }

    /*******************************************************************************************************
     * setWssRpfEliEdt
     *******************************************************************************************************/
    /**
     *
     * @param wssRpfEliEdt TODO_javadoc.
     *
     */
    public void setWssRpfEliEdt(int wssRpfEliEdt) {
        replaceValue(115, 120, form5z.format(wssRpfEliEdt));
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
        replaceValue(120, 125, form5z.format(wssTabErp));
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
        replaceValue(125, 130, form5z.format(wssTabErpEdt));
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
        replaceValue(130, 135, form5z.format(wssTabErm));
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
        replaceValue(135, 140, form5z.format(wssTabErmEdt));
    }

    /*******************************************************************************************************
     * setWssTabEre
     *******************************************************************************************************/
    /**
     *
     * @param wssTabEre TODO_javadoc.
     *
     */
    public void setWssTabEre(int wssTabEre) {
        replaceValue(140, 145, form5z.format(wssTabEre));
    }

    /*******************************************************************************************************
     * setWssTabEreEdt
     *******************************************************************************************************/
    /**
     *
     * @param wssTabEreEdt TODO_javadoc.
     *
     */
    public void setWssTabEreEdt(int wssTabEreEdt) {
        replaceValue(145, 150, form5z.format(wssTabEreEdt));
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
        replaceValue(150, 155, form5z.format(wssTabPut));
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
        replaceValue(155, 160, form5z.format(wssTabPutEdt));
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
        replaceValue(160, 165, form5z.format(wssTabMod));
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
        replaceValue(165, 170, form5z.format(wssTabModEdt));
    }

    /*******************************************************************************************************
     * setWssTabEli
     *******************************************************************************************************/
    /**
     *
     * @param wssTabEli TODO_javadoc.
     *
     */
    public void setWssTabEli(int wssTabEli) {
        replaceValue(170, 175, form5z.format(wssTabEli));
    }

    /*******************************************************************************************************
     * setWssTabEliEdt
     *******************************************************************************************************/
    /**
     *
     * @param wssTabEliEdt TODO_javadoc.
     *
     */
    public void setWssTabEliEdt(int wssTabEliEdt) {
        replaceValue(175, 180, form5z.format(wssTabEliEdt));
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
     * getWssMnuEre
     *******************************************************************************************************/
    /**
     *
     * @return wssMnuEre TODO_javadoc.
     *
     */
    public int getWssMnuEre() {
        return Integer.parseInt(subValue(20, 25));
    }

    /*******************************************************************************************************
     * getWssMnuEreEdt
     *******************************************************************************************************/
    /**
     *
     * @return wssMnuEreEdt TODO_javadoc.
     *
     */
    public int getWssMnuEreEdt() {
        return Integer.parseInt(subValue(25, 30));
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
        return Integer.parseInt(subValue(30, 35));
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
        return Integer.parseInt(subValue(35, 40));
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
        return Integer.parseInt(subValue(40, 45));
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
        return Integer.parseInt(subValue(45, 50));
    }

    /*******************************************************************************************************
     * getWssMnuEli
     *******************************************************************************************************/
    /**
     *
     * @return wssMnuEli TODO_javadoc.
     *
     */
    public int getWssMnuEli() {
        return Integer.parseInt(subValue(50, 55));
    }

    /*******************************************************************************************************
     * getWssMnuEliEdt
     *******************************************************************************************************/
    /**
     *
     * @return wssMnuEliEdt TODO_javadoc.
     *
     */
    public int getWssMnuEliEdt() {
        return Integer.parseInt(subValue(55, 60));
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
        return Integer.parseInt(subValue(60, 65));
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
        return Integer.parseInt(subValue(65, 70));
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
        return Integer.parseInt(subValue(70, 75));
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
        return Integer.parseInt(subValue(75, 80));
    }

    /*******************************************************************************************************
     * getWssRpfEre
     *******************************************************************************************************/
    /**
     *
     * @return wssRpfEre TODO_javadoc.
     *
     */
    public int getWssRpfEre() {
        return Integer.parseInt(subValue(80, 85));
    }

    /*******************************************************************************************************
     * getWssRpfEreEdt
     *******************************************************************************************************/
    /**
     *
     * @return wssRpfEreEdt TODO_javadoc.
     *
     */
    public int getWssRpfEreEdt() {
        return Integer.parseInt(subValue(85, 90));
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
        return Integer.parseInt(subValue(90, 95));
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
        return Integer.parseInt(subValue(95, 100));
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
        return Integer.parseInt(subValue(100, 105));
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
        return Integer.parseInt(subValue(105, 110));
    }

    /*******************************************************************************************************
     * getWssRpfEli
     *******************************************************************************************************/
    /**
     *
     * @return wssRpfEli TODO_javadoc.
     *
     */
    public int getWssRpfEli() {
        return Integer.parseInt(subValue(110, 115));
    }

    /*******************************************************************************************************
     * getWssRpfEliEdt
     *******************************************************************************************************/
    /**
     *
     * @return wssRpfEliEdt TODO_javadoc.
     *
     */
    public int getWssRpfEliEdt() {
        return Integer.parseInt(subValue(115, 120));
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
        return Integer.parseInt(subValue(120, 125));
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
        return Integer.parseInt(subValue(125, 130));
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
        return Integer.parseInt(subValue(130, 135));
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
        return Integer.parseInt(subValue(135, 140));
    }

    /*******************************************************************************************************
     * getWssTabEre
     *******************************************************************************************************/
    /**
     *
     * @return wssTabEre TODO_javadoc.
     *
     */
    public int getWssTabEre() {
        return Integer.parseInt(subValue(140, 145));
    }

    /*******************************************************************************************************
     * getWssTabEreEdt
     *******************************************************************************************************/
    /**
     *
     * @return wssTabEreEdt TODO_javadoc.
     *
     */
    public int getWssTabEreEdt() {
        return Integer.parseInt(subValue(145, 150));
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
        return Integer.parseInt(subValue(150, 155));
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
        return Integer.parseInt(subValue(155, 160));
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
        return Integer.parseInt(subValue(160, 165));
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
        return Integer.parseInt(subValue(165, 170));
    }

    /*******************************************************************************************************
     * getWssTabEli
     *******************************************************************************************************/
    /**
     *
     * @return wssTabEli TODO_javadoc.
     *
     */
    public int getWssTabEli() {
        return Integer.parseInt(subValue(170, 175));
    }

    /*******************************************************************************************************
     * getWssTabEliEdt
     *******************************************************************************************************/
    /**
     *
     * @return wssTabEliEdt TODO_javadoc.
     *
     */
    public int getWssTabEliEdt() {
        return Integer.parseInt(subValue(175, 180));
    }

}

