/*
 *   Copyright (c) 2021 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.beebank.cloud.core.gns.gnsppidd;


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
public class AdrIddReqa extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(AdrIddReqa.class);

    /** TODO_javadoc. */
    private static DecimalFormat form4z = new DecimalFormat("0000");

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public AdrIddReqa() {

        initBuffer(622);

        replaceValue(0, 622, "                000{                                000{000{                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  "); // ADR-IDD-REQA
        replaceValue(13, 15, "  "); // ADR-STAT
        replaceValue(15, 16, " "); // ADR-SSTT
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
        replaceValue(0, 622, value);
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
        return subValue(0, 622);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setAdrCmnd
     *******************************************************************************************************/
    /**
     *
     * @param adrCmnd TODO_javadoc.
     *
     */
    public void setAdrCmnd(String adrCmnd) {
        replaceValue(0, 5, adrCmnd);
    }

    /*******************************************************************************************************
     * setAdrTabl
     *******************************************************************************************************/
    /**
     *
     * @param adrTabl TODO_javadoc.
     *
     */
    public void setAdrTabl(String adrTabl) {
        replaceValue(5, 8, adrTabl);
    }

    /*******************************************************************************************************
     * setAdrDkey
     *******************************************************************************************************/
    /**
     *
     * @param adrDkey TODO_javadoc.
     *
     */
    public void setAdrDkey(String adrDkey) {
        replaceValue(8, 13, adrDkey);
    }

    /*******************************************************************************************************
     * setAdrStat
     *******************************************************************************************************/
    /**
     *
     * @param adrStat TODO_javadoc.
     *
     */
    public void setAdrStat(String adrStat) {
        replaceValue(13, 15, adrStat);
    }

    /*******************************************************************************************************
     * setAdrSstt
     *******************************************************************************************************/
    /**
     *
     * @param adrSstt TODO_javadoc.
     *
     */
    public void setAdrSstt(String adrSstt) {
        replaceValue(15, 16, adrSstt);
    }

    /*******************************************************************************************************
     * setAdrDbid
     *******************************************************************************************************/
    /**
     *
     * @param adrDbid TODO_javadoc.
     *
     */
    public void setAdrDbid(int adrDbid) {
        replaceValue(16, 20, setCompNumber(adrDbid, form4z));
    }

    /*******************************************************************************************************
     * setAdrRcid
     *******************************************************************************************************/
    /**
     *
     * @param adrRcid TODO_javadoc.
     *
     */
    public void setAdrRcid(String adrRcid) {
        replaceValue(20, 27, adrRcid);
    }

    /*******************************************************************************************************
     * setFiller
     *******************************************************************************************************/
    /**
     *
     * @param filler TODO_javadoc.
     *
     */
    public void setFiller(String filler) {
        replaceValue(27, 52, filler);
    }

    /*******************************************************************************************************
     * setAdrCtmx
     *******************************************************************************************************/
    /**
     *
     * @param adrCtmx TODO_javadoc.
     *
     */
    public void setAdrCtmx(int adrCtmx) {
        replaceValue(52, 56, setCompNumber(adrCtmx, form4z));
    }

    /*******************************************************************************************************
     * setAdrCtio
     *******************************************************************************************************/
    /**
     *
     * @param adrCtio TODO_javadoc.
     *
     */
    public void setAdrCtio(int adrCtio) {
        replaceValue(56, 60, setCompNumber(adrCtio, form4z));
    }

    /*******************************************************************************************************
     * setFiller1
     *******************************************************************************************************/
    /**
     *
     * @param filler1 TODO_javadoc.
     *
     */
    public void setFiller1(String filler1) {
        replaceValue(60, 82, filler1);
    }

    /*******************************************************************************************************
     * setAdrVkey
     *******************************************************************************************************/
    /**
     *
     * @param adrVkey TODO_javadoc.
     *
     */
    public void setAdrVkey(String adrVkey) {
        replaceValue(82, 262, adrVkey);
    }

    /*******************************************************************************************************
     * setAdrVky1
     *******************************************************************************************************/
    /**
     *
     * @param adrVky1 TODO_javadoc.
     *
     */
    public void setAdrVky1(String adrVky1) {
        replaceValue(262, 442, adrVky1);
    }

    /*******************************************************************************************************
     * setAdrVky2
     *******************************************************************************************************/
    /**
     *
     * @param adrVky2 TODO_javadoc.
     *
     */
    public void setAdrVky2(String adrVky2) {
        replaceValue(442, 622, adrVky2);
    }

    /*******************************************************************************************************
     * getAdrCmnd
     *******************************************************************************************************/
    /**
     *
     * @return adrCmnd TODO_javadoc.
     *
     */
    public String getAdrCmnd() {
        return subValue(0, 5);
    }

    /*******************************************************************************************************
     * getAdrTabl
     *******************************************************************************************************/
    /**
     *
     * @return adrTabl TODO_javadoc.
     *
     */
    public String getAdrTabl() {
        return subValue(5, 8);
    }

    /*******************************************************************************************************
     * getAdrDkey
     *******************************************************************************************************/
    /**
     *
     * @return adrDkey TODO_javadoc.
     *
     */
    public String getAdrDkey() {
        return subValue(8, 13);
    }

    /*******************************************************************************************************
     * getAdrStat
     *******************************************************************************************************/
    /**
     *
     * @return adrStat TODO_javadoc.
     *
     */
    public String getAdrStat() {
        return subValue(13, 15);
    }

    /*******************************************************************************************************
     * getAdrSstt
     *******************************************************************************************************/
    /**
     *
     * @return adrSstt TODO_javadoc.
     *
     */
    public String getAdrSstt() {
        return subValue(15, 16);
    }

    /*******************************************************************************************************
     * getAdrDbid
     *******************************************************************************************************/
    /**
     *
     * @return adrDbid TODO_javadoc.
     *
     */
    public int getAdrDbid() {
        return (int) getCompNumber(subValue(16, 20));
    }

    /*******************************************************************************************************
     * getAdrRcid
     *******************************************************************************************************/
    /**
     *
     * @return adrRcid TODO_javadoc.
     *
     */
    public String getAdrRcid() {
        return subValue(20, 27);
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
        return subValue(27, 52);
    }

    /*******************************************************************************************************
     * getAdrCtmx
     *******************************************************************************************************/
    /**
     *
     * @return adrCtmx TODO_javadoc.
     *
     */
    public int getAdrCtmx() {
        return (int) getCompNumber(subValue(52, 56));
    }

    /*******************************************************************************************************
     * getAdrCtio
     *******************************************************************************************************/
    /**
     *
     * @return adrCtio TODO_javadoc.
     *
     */
    public int getAdrCtio() {
        return (int) getCompNumber(subValue(56, 60));
    }

    /*******************************************************************************************************
     * getFiller1
     *******************************************************************************************************/
    /**
     *
     * @return filler1 TODO_javadoc.
     *
     */
    public String getFiller1() {
        return subValue(60, 82);
    }

    /*******************************************************************************************************
     * getAdrVkey
     *******************************************************************************************************/
    /**
     *
     * @return adrVkey TODO_javadoc.
     *
     */
    public String getAdrVkey() {
        return subValue(82, 262);
    }

    /*******************************************************************************************************
     * getAdrVky1
     *******************************************************************************************************/
    /**
     *
     * @return adrVky1 TODO_javadoc.
     *
     */
    public String getAdrVky1() {
        return subValue(262, 442);
    }

    /*******************************************************************************************************
     * getAdrVky2
     *******************************************************************************************************/
    /**
     *
     * @return adrVky2 TODO_javadoc.
     *
     */
    public String getAdrVky2() {
        return subValue(442, 622);
    }

    /*******************************************************************************************************
     * setAdrStatOks
     *******************************************************************************************************/
    /**
     *
     * @param adrStatOks TODO_javadoc.
     *
     */
    public void setAdrStatOks(boolean adrStatOks) {

        if (!adrStatOks) {
            throw new RuntimeException("Se intento setear adrStatOks con false.");
        }

        setAdrStat("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ");
    }

    /*******************************************************************************************************
     * isAdrStatOks
     *******************************************************************************************************/
    /**
     *
     * @return adrStatOks TODO_javadoc.
     *
     */
    public boolean isAdrStatOks() {
        return getAdrStat().equals("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ");
    }

}

