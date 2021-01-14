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
public class ScrCtts extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(ScrCtts.class);

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public ScrCtts() {

        initBuffer(50);

        replaceValue(0, 50, "                                                  "); // SCR-CTTS
        replaceValue(0, 3, "INI"); // SCR-INST-INI
        replaceValue(3, 6, "HCM"); // SCR-INST-HCM
        replaceValue(6, 9, "GCM"); // SCR-INST-GCM
        replaceValue(9, 12, "HKY"); // SCR-INST-HKY
        replaceValue(12, 15, "GKY"); // SCR-INST-GKY
        replaceValue(15, 18, "HFL"); // SCR-INST-HFL
        replaceValue(18, 21, "GFL"); // SCR-INST-GFL
        replaceValue(21, 24, "GCS"); // SCR-INST-GCS
        replaceValue(24, 27, "GAB"); // SCR-INST-GAB
        replaceValue(27, 30, "GCF"); // SCR-INST-GCF
        replaceValue(30, 33, "SIS"); // SCR-INST-SIS
        replaceValue(33, 36, "BRW"); // SCR-INST-BRW
        replaceValue(36, 37, "C"); // SCR-STAT-CON
        replaceValue(37, 38, "K"); // SCR-STAT-ABT
        replaceValue(38, 39, "M"); // SCR-STAT-MOD
        replaceValue(39, 40, "A"); // SCR-STAT-SON
        replaceValue(40, 43, "MOD"); // SCR-ACTU-MOD
        replaceValue(43, 46, "ING"); // SCR-ACTU-ING
        replaceValue(46, 47, "N"); // SCR-VFLD-NOT
        replaceValue(47, 48, "S"); // SCR-VFLD-YES
        replaceValue(48, 49, "N"); // SCR-MFLD-NOT
        replaceValue(49, 50, "S"); // SCR-MFLD-YES
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
        replaceValue(0, 50, value);
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
        return subValue(0, 50);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setScrInstIni
     *******************************************************************************************************/
    /**
     *
     * @param scrInstIni TODO_javadoc.
     *
     */
    public void setScrInstIni(String scrInstIni) {
        replaceValue(0, 3, scrInstIni);
    }

    /*******************************************************************************************************
     * setScrInstHcm
     *******************************************************************************************************/
    /**
     *
     * @param scrInstHcm TODO_javadoc.
     *
     */
    public void setScrInstHcm(String scrInstHcm) {
        replaceValue(3, 6, scrInstHcm);
    }

    /*******************************************************************************************************
     * setScrInstGcm
     *******************************************************************************************************/
    /**
     *
     * @param scrInstGcm TODO_javadoc.
     *
     */
    public void setScrInstGcm(String scrInstGcm) {
        replaceValue(6, 9, scrInstGcm);
    }

    /*******************************************************************************************************
     * setScrInstHky
     *******************************************************************************************************/
    /**
     *
     * @param scrInstHky TODO_javadoc.
     *
     */
    public void setScrInstHky(String scrInstHky) {
        replaceValue(9, 12, scrInstHky);
    }

    /*******************************************************************************************************
     * setScrInstGky
     *******************************************************************************************************/
    /**
     *
     * @param scrInstGky TODO_javadoc.
     *
     */
    public void setScrInstGky(String scrInstGky) {
        replaceValue(12, 15, scrInstGky);
    }

    /*******************************************************************************************************
     * setScrInstHfl
     *******************************************************************************************************/
    /**
     *
     * @param scrInstHfl TODO_javadoc.
     *
     */
    public void setScrInstHfl(String scrInstHfl) {
        replaceValue(15, 18, scrInstHfl);
    }

    /*******************************************************************************************************
     * setScrInstGfl
     *******************************************************************************************************/
    /**
     *
     * @param scrInstGfl TODO_javadoc.
     *
     */
    public void setScrInstGfl(String scrInstGfl) {
        replaceValue(18, 21, scrInstGfl);
    }

    /*******************************************************************************************************
     * setScrInstGcs
     *******************************************************************************************************/
    /**
     *
     * @param scrInstGcs TODO_javadoc.
     *
     */
    public void setScrInstGcs(String scrInstGcs) {
        replaceValue(21, 24, scrInstGcs);
    }

    /*******************************************************************************************************
     * setScrInstGab
     *******************************************************************************************************/
    /**
     *
     * @param scrInstGab TODO_javadoc.
     *
     */
    public void setScrInstGab(String scrInstGab) {
        replaceValue(24, 27, scrInstGab);
    }

    /*******************************************************************************************************
     * setScrInstGcf
     *******************************************************************************************************/
    /**
     *
     * @param scrInstGcf TODO_javadoc.
     *
     */
    public void setScrInstGcf(String scrInstGcf) {
        replaceValue(27, 30, scrInstGcf);
    }

    /*******************************************************************************************************
     * setScrInstSis
     *******************************************************************************************************/
    /**
     *
     * @param scrInstSis TODO_javadoc.
     *
     */
    public void setScrInstSis(String scrInstSis) {
        replaceValue(30, 33, scrInstSis);
    }

    /*******************************************************************************************************
     * setScrInstBrw
     *******************************************************************************************************/
    /**
     *
     * @param scrInstBrw TODO_javadoc.
     *
     */
    public void setScrInstBrw(String scrInstBrw) {
        replaceValue(33, 36, scrInstBrw);
    }

    /*******************************************************************************************************
     * setScrStatCon
     *******************************************************************************************************/
    /**
     *
     * @param scrStatCon TODO_javadoc.
     *
     */
    public void setScrStatCon(String scrStatCon) {
        replaceValue(36, 37, scrStatCon);
    }

    /*******************************************************************************************************
     * setScrStatAbt
     *******************************************************************************************************/
    /**
     *
     * @param scrStatAbt TODO_javadoc.
     *
     */
    public void setScrStatAbt(String scrStatAbt) {
        replaceValue(37, 38, scrStatAbt);
    }

    /*******************************************************************************************************
     * setScrStatMod
     *******************************************************************************************************/
    /**
     *
     * @param scrStatMod TODO_javadoc.
     *
     */
    public void setScrStatMod(String scrStatMod) {
        replaceValue(38, 39, scrStatMod);
    }

    /*******************************************************************************************************
     * setScrStatSon
     *******************************************************************************************************/
    /**
     *
     * @param scrStatSon TODO_javadoc.
     *
     */
    public void setScrStatSon(String scrStatSon) {
        replaceValue(39, 40, scrStatSon);
    }

    /*******************************************************************************************************
     * setScrActuMod
     *******************************************************************************************************/
    /**
     *
     * @param scrActuMod TODO_javadoc.
     *
     */
    public void setScrActuMod(String scrActuMod) {
        replaceValue(40, 43, scrActuMod);
    }

    /*******************************************************************************************************
     * setScrActuIng
     *******************************************************************************************************/
    /**
     *
     * @param scrActuIng TODO_javadoc.
     *
     */
    public void setScrActuIng(String scrActuIng) {
        replaceValue(43, 46, scrActuIng);
    }

    /*******************************************************************************************************
     * setScrVfldNot
     *******************************************************************************************************/
    /**
     *
     * @param scrVfldNot TODO_javadoc.
     *
     */
    public void setScrVfldNot(String scrVfldNot) {
        replaceValue(46, 47, scrVfldNot);
    }

    /*******************************************************************************************************
     * setScrVfldYes
     *******************************************************************************************************/
    /**
     *
     * @param scrVfldYes TODO_javadoc.
     *
     */
    public void setScrVfldYes(String scrVfldYes) {
        replaceValue(47, 48, scrVfldYes);
    }

    /*******************************************************************************************************
     * setScrMfldNot
     *******************************************************************************************************/
    /**
     *
     * @param scrMfldNot TODO_javadoc.
     *
     */
    public void setScrMfldNot(String scrMfldNot) {
        replaceValue(48, 49, scrMfldNot);
    }

    /*******************************************************************************************************
     * setScrMfldYes
     *******************************************************************************************************/
    /**
     *
     * @param scrMfldYes TODO_javadoc.
     *
     */
    public void setScrMfldYes(String scrMfldYes) {
        replaceValue(49, 50, scrMfldYes);
    }

    /*******************************************************************************************************
     * getScrInstIni
     *******************************************************************************************************/
    /**
     *
     * @return scrInstIni TODO_javadoc.
     *
     */
    public String getScrInstIni() {
        return subValue(0, 3);
    }

    /*******************************************************************************************************
     * getScrInstHcm
     *******************************************************************************************************/
    /**
     *
     * @return scrInstHcm TODO_javadoc.
     *
     */
    public String getScrInstHcm() {
        return subValue(3, 6);
    }

    /*******************************************************************************************************
     * getScrInstGcm
     *******************************************************************************************************/
    /**
     *
     * @return scrInstGcm TODO_javadoc.
     *
     */
    public String getScrInstGcm() {
        return subValue(6, 9);
    }

    /*******************************************************************************************************
     * getScrInstHky
     *******************************************************************************************************/
    /**
     *
     * @return scrInstHky TODO_javadoc.
     *
     */
    public String getScrInstHky() {
        return subValue(9, 12);
    }

    /*******************************************************************************************************
     * getScrInstGky
     *******************************************************************************************************/
    /**
     *
     * @return scrInstGky TODO_javadoc.
     *
     */
    public String getScrInstGky() {
        return subValue(12, 15);
    }

    /*******************************************************************************************************
     * getScrInstHfl
     *******************************************************************************************************/
    /**
     *
     * @return scrInstHfl TODO_javadoc.
     *
     */
    public String getScrInstHfl() {
        return subValue(15, 18);
    }

    /*******************************************************************************************************
     * getScrInstGfl
     *******************************************************************************************************/
    /**
     *
     * @return scrInstGfl TODO_javadoc.
     *
     */
    public String getScrInstGfl() {
        return subValue(18, 21);
    }

    /*******************************************************************************************************
     * getScrInstGcs
     *******************************************************************************************************/
    /**
     *
     * @return scrInstGcs TODO_javadoc.
     *
     */
    public String getScrInstGcs() {
        return subValue(21, 24);
    }

    /*******************************************************************************************************
     * getScrInstGab
     *******************************************************************************************************/
    /**
     *
     * @return scrInstGab TODO_javadoc.
     *
     */
    public String getScrInstGab() {
        return subValue(24, 27);
    }

    /*******************************************************************************************************
     * getScrInstGcf
     *******************************************************************************************************/
    /**
     *
     * @return scrInstGcf TODO_javadoc.
     *
     */
    public String getScrInstGcf() {
        return subValue(27, 30);
    }

    /*******************************************************************************************************
     * getScrInstSis
     *******************************************************************************************************/
    /**
     *
     * @return scrInstSis TODO_javadoc.
     *
     */
    public String getScrInstSis() {
        return subValue(30, 33);
    }

    /*******************************************************************************************************
     * getScrInstBrw
     *******************************************************************************************************/
    /**
     *
     * @return scrInstBrw TODO_javadoc.
     *
     */
    public String getScrInstBrw() {
        return subValue(33, 36);
    }

    /*******************************************************************************************************
     * getScrStatCon
     *******************************************************************************************************/
    /**
     *
     * @return scrStatCon TODO_javadoc.
     *
     */
    public String getScrStatCon() {
        return subValue(36, 37);
    }

    /*******************************************************************************************************
     * getScrStatAbt
     *******************************************************************************************************/
    /**
     *
     * @return scrStatAbt TODO_javadoc.
     *
     */
    public String getScrStatAbt() {
        return subValue(37, 38);
    }

    /*******************************************************************************************************
     * getScrStatMod
     *******************************************************************************************************/
    /**
     *
     * @return scrStatMod TODO_javadoc.
     *
     */
    public String getScrStatMod() {
        return subValue(38, 39);
    }

    /*******************************************************************************************************
     * getScrStatSon
     *******************************************************************************************************/
    /**
     *
     * @return scrStatSon TODO_javadoc.
     *
     */
    public String getScrStatSon() {
        return subValue(39, 40);
    }

    /*******************************************************************************************************
     * getScrActuMod
     *******************************************************************************************************/
    /**
     *
     * @return scrActuMod TODO_javadoc.
     *
     */
    public String getScrActuMod() {
        return subValue(40, 43);
    }

    /*******************************************************************************************************
     * getScrActuIng
     *******************************************************************************************************/
    /**
     *
     * @return scrActuIng TODO_javadoc.
     *
     */
    public String getScrActuIng() {
        return subValue(43, 46);
    }

    /*******************************************************************************************************
     * getScrVfldNot
     *******************************************************************************************************/
    /**
     *
     * @return scrVfldNot TODO_javadoc.
     *
     */
    public String getScrVfldNot() {
        return subValue(46, 47);
    }

    /*******************************************************************************************************
     * getScrVfldYes
     *******************************************************************************************************/
    /**
     *
     * @return scrVfldYes TODO_javadoc.
     *
     */
    public String getScrVfldYes() {
        return subValue(47, 48);
    }

    /*******************************************************************************************************
     * getScrMfldNot
     *******************************************************************************************************/
    /**
     *
     * @return scrMfldNot TODO_javadoc.
     *
     */
    public String getScrMfldNot() {
        return subValue(48, 49);
    }

    /*******************************************************************************************************
     * getScrMfldYes
     *******************************************************************************************************/
    /**
     *
     * @return scrMfldYes TODO_javadoc.
     *
     */
    public String getScrMfldYes() {
        return subValue(49, 50);
    }

}

