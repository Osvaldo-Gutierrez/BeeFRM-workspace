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
public class FrmCtts extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(FrmCtts.class);

    /** TODO_javadoc. */
    private static DecimalFormat form1z = new DecimalFormat("0");

    /** TODO_javadoc. */
    private static DecimalFormat form2z = new DecimalFormat("00");

    /** TODO_javadoc. */
    private static DecimalFormat form4z = new DecimalFormat("0000");

    /** TODO_javadoc. */
    private static DecimalFormat form5z = new DecimalFormat("00000");

    /** TODO_javadoc. */
    private FrmCpim frmCpim = new FrmCpim();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public FrmCtts() {

        initBuffer(90);

        replaceValue(0, 90, "00000000000000000000000000                                                000{000{000{000{"); // FRM-CTTS
        replaceValue(0, 2, form2z.format(1)); // FRM-INI
        replaceValue(2, 4, form2z.format(2)); // FRM-GET-ALL
        replaceValue(4, 6, form2z.format(3)); // FRM-PUT-ALL
        replaceValue(6, 8, form2z.format(4)); // FRM-CLR-ALL
        replaceValue(8, 10, form2z.format(5)); // FRM-MSG
        replaceValue(10, 12, form2z.format(6)); // FRM-RCV
        replaceValue(12, 14, form2z.format(10)); // FRM-ABT
        replaceValue(14, 16, form2z.format(7)); // FRM-CLR-FRM
        replaceValue(16, 17, form1z.format(0)); // FRM-SINI-DB1F
        replaceValue(17, 18, form1z.format(1)); // FRM-SINI-DBNF
        replaceValue(18, 19, form1z.format(2)); // FRM-SINI-DBLF
        replaceValue(19, 20, form1z.format(3)); // FRM-SINI-MB1F
        replaceValue(20, 21, form1z.format(4)); // FRM-SINI-MBNF
        replaceValue(21, 26, form5z.format(5)); // FRM-SINI-MBLF
        replaceValue(26, 27, "%"); // FRM-FFLD-PA1
        replaceValue(27, 28, ">"); // FRM-FFLD-PA2
        replaceValue(28, 29, ","); // FRM-FFLD-PA3
        replaceValue(29, 30, "'"); // FRM-FFLD-RET
        replaceValue(30, 31, "3"); // FRM-FFLD-TAB
        replaceValue(31, 32, "1"); // FRM-FFLD-PF1
        replaceValue(32, 33, "2"); // FRM-FFLD-PF2
        replaceValue(33, 34, "3"); // FRM-FFLD-PF3
        replaceValue(34, 35, "4"); // FRM-FFLD-PF4
        replaceValue(35, 36, "5"); // FRM-FFLD-PF5
        replaceValue(36, 37, "6"); // FRM-FFLD-PF6
        replaceValue(37, 38, "7"); // FRM-FFLD-PF7
        replaceValue(38, 39, "8"); // FRM-FFLD-PF8
        replaceValue(39, 40, "9"); // FRM-FFLD-PF9
        replaceValue(40, 41, ":"); // FRM-FFLD-PF10
        replaceValue(41, 42, "#"); // FRM-FFLD-PF11
        replaceValue(42, 43, "@"); // FRM-FFLD-PF12
        replaceValue(43, 44, "A"); // FRM-FFLD-PFA
        replaceValue(44, 45, "B"); // FRM-FFLD-PFB
        replaceValue(45, 46, "C"); // FRM-FFLD-PFC
        replaceValue(46, 47, "D"); // FRM-FFLD-PFD
        replaceValue(47, 48, "E"); // FRM-FFLD-PFE
        replaceValue(48, 49, "F"); // FRM-FFLD-PFF
        replaceValue(49, 50, "G"); // FRM-FFLD-PFG
        replaceValue(50, 51, "H"); // FRM-FFLD-PFH
        replaceValue(51, 52, "I"); // FRM-FFLD-PFI
        replaceValue(52, 53, "?"); // FRM-FFLD-PFJ
        replaceValue(53, 54, "."); // FRM-FFLD-PFK
        replaceValue(54, 55, "<"); // FRM-FFLD-PFL
        replaceValue(55, 58, "MAL"); // FRM-SUAR-MAL
        replaceValue(58, 61, "WRN"); // FRM-SUAR-WRN
        replaceValue(61, 64, "CLR"); // FRM-SUAR-CLR
        replaceValue(64, 67, "OKS"); // FRM-SUAR-OKS
        replaceValue(67, 68, "1"); // FRM-CPIM-AEY
        replaceValue(68, 69, "I"); // FRM-CPIM-UBY
        replaceValue(69, 70, "_"); // FRM-CPIM-ANY
        replaceValue(70, 71, "("); // FRM-CPIM-UNY
        replaceValue(71, 72, "-"); // FRM-CPSF-AEY
        replaceValue(72, 73, "9"); // FRM-CPIM-ABY
        replaceValue(73, 74, " "); // FRM-CPIM-UST
        replaceValue(74, 78, setCompNumber(-1, form4z)); // FRM-POS-CURS
        replaceValue(78, 82, setCompNumber(-1, form4z)); // FRM-IND-ERRO
        replaceValue(82, 86, setCompNumber(-9, form4z)); // FRM-ERR-NUME
        replaceValue(86, 90, setCompNumber(0, form4z)); // FRM-RST-PCUR
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
        replaceValue(0, 90, value);
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
        return subValue(0, 90);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setFrmIni
     *******************************************************************************************************/
    /**
     *
     * @param frmIni TODO_javadoc.
     *
     */
    public void setFrmIni(int frmIni) {
        replaceValue(0, 2, form2z.format(frmIni));
    }

    /*******************************************************************************************************
     * setFrmGetAll
     *******************************************************************************************************/
    /**
     *
     * @param frmGetAll TODO_javadoc.
     *
     */
    public void setFrmGetAll(int frmGetAll) {
        replaceValue(2, 4, form2z.format(frmGetAll));
    }

    /*******************************************************************************************************
     * setFrmPutAll
     *******************************************************************************************************/
    /**
     *
     * @param frmPutAll TODO_javadoc.
     *
     */
    public void setFrmPutAll(int frmPutAll) {
        replaceValue(4, 6, form2z.format(frmPutAll));
    }

    /*******************************************************************************************************
     * setFrmClrAll
     *******************************************************************************************************/
    /**
     *
     * @param frmClrAll TODO_javadoc.
     *
     */
    public void setFrmClrAll(int frmClrAll) {
        replaceValue(6, 8, form2z.format(frmClrAll));
    }

    /*******************************************************************************************************
     * setFrmMsg
     *******************************************************************************************************/
    /**
     *
     * @param frmMsg TODO_javadoc.
     *
     */
    public void setFrmMsg(int frmMsg) {
        replaceValue(8, 10, form2z.format(frmMsg));
    }

    /*******************************************************************************************************
     * setFrmRcv
     *******************************************************************************************************/
    /**
     *
     * @param frmRcv TODO_javadoc.
     *
     */
    public void setFrmRcv(int frmRcv) {
        replaceValue(10, 12, form2z.format(frmRcv));
    }

    /*******************************************************************************************************
     * setFrmAbt
     *******************************************************************************************************/
    /**
     *
     * @param frmAbt TODO_javadoc.
     *
     */
    public void setFrmAbt(int frmAbt) {
        replaceValue(12, 14, form2z.format(frmAbt));
    }

    /*******************************************************************************************************
     * setFrmClrFrm
     *******************************************************************************************************/
    /**
     *
     * @param frmClrFrm TODO_javadoc.
     *
     */
    public void setFrmClrFrm(int frmClrFrm) {
        replaceValue(14, 16, form2z.format(frmClrFrm));
    }

    /*******************************************************************************************************
     * setFrmSiniDb1f
     *******************************************************************************************************/
    /**
     *
     * @param frmSiniDb1f TODO_javadoc.
     *
     */
    public void setFrmSiniDb1f(int frmSiniDb1f) {
        replaceValue(16, 17, form1z.format(frmSiniDb1f));
    }

    /*******************************************************************************************************
     * setFrmSiniDbnf
     *******************************************************************************************************/
    /**
     *
     * @param frmSiniDbnf TODO_javadoc.
     *
     */
    public void setFrmSiniDbnf(int frmSiniDbnf) {
        replaceValue(17, 18, form1z.format(frmSiniDbnf));
    }

    /*******************************************************************************************************
     * setFrmSiniDblf
     *******************************************************************************************************/
    /**
     *
     * @param frmSiniDblf TODO_javadoc.
     *
     */
    public void setFrmSiniDblf(int frmSiniDblf) {
        replaceValue(18, 19, form1z.format(frmSiniDblf));
    }

    /*******************************************************************************************************
     * setFrmSiniMb1f
     *******************************************************************************************************/
    /**
     *
     * @param frmSiniMb1f TODO_javadoc.
     *
     */
    public void setFrmSiniMb1f(int frmSiniMb1f) {
        replaceValue(19, 20, form1z.format(frmSiniMb1f));
    }

    /*******************************************************************************************************
     * setFrmSiniMbnf
     *******************************************************************************************************/
    /**
     *
     * @param frmSiniMbnf TODO_javadoc.
     *
     */
    public void setFrmSiniMbnf(int frmSiniMbnf) {
        replaceValue(20, 21, form1z.format(frmSiniMbnf));
    }

    /*******************************************************************************************************
     * setFrmSiniMblf
     *******************************************************************************************************/
    /**
     *
     * @param frmSiniMblf TODO_javadoc.
     *
     */
    public void setFrmSiniMblf(int frmSiniMblf) {
        replaceValue(21, 26, form5z.format(frmSiniMblf));
    }

    /*******************************************************************************************************
     * setFrmFfldPa1
     *******************************************************************************************************/
    /**
     *
     * @param frmFfldPa1 TODO_javadoc.
     *
     */
    public void setFrmFfldPa1(String frmFfldPa1) {
        replaceValue(26, 27, frmFfldPa1);
    }

    /*******************************************************************************************************
     * setFrmFfldPa2
     *******************************************************************************************************/
    /**
     *
     * @param frmFfldPa2 TODO_javadoc.
     *
     */
    public void setFrmFfldPa2(String frmFfldPa2) {
        replaceValue(27, 28, frmFfldPa2);
    }

    /*******************************************************************************************************
     * setFrmFfldPa3
     *******************************************************************************************************/
    /**
     *
     * @param frmFfldPa3 TODO_javadoc.
     *
     */
    public void setFrmFfldPa3(String frmFfldPa3) {
        replaceValue(28, 29, frmFfldPa3);
    }

    /*******************************************************************************************************
     * setFrmFfldRet
     *******************************************************************************************************/
    /**
     *
     * @param frmFfldRet TODO_javadoc.
     *
     */
    public void setFrmFfldRet(String frmFfldRet) {
        replaceValue(29, 30, frmFfldRet);
    }

    /*******************************************************************************************************
     * setFrmFfldTab
     *******************************************************************************************************/
    /**
     *
     * @param frmFfldTab TODO_javadoc.
     *
     */
    public void setFrmFfldTab(String frmFfldTab) {
        replaceValue(30, 31, frmFfldTab);
    }

    /*******************************************************************************************************
     * setFrmFfldPf1
     *******************************************************************************************************/
    /**
     *
     * @param frmFfldPf1 TODO_javadoc.
     *
     */
    public void setFrmFfldPf1(String frmFfldPf1) {
        replaceValue(31, 32, frmFfldPf1);
    }

    /*******************************************************************************************************
     * setFrmFfldPf2
     *******************************************************************************************************/
    /**
     *
     * @param frmFfldPf2 TODO_javadoc.
     *
     */
    public void setFrmFfldPf2(String frmFfldPf2) {
        replaceValue(32, 33, frmFfldPf2);
    }

    /*******************************************************************************************************
     * setFrmFfldPf3
     *******************************************************************************************************/
    /**
     *
     * @param frmFfldPf3 TODO_javadoc.
     *
     */
    public void setFrmFfldPf3(String frmFfldPf3) {
        replaceValue(33, 34, frmFfldPf3);
    }

    /*******************************************************************************************************
     * setFrmFfldPf4
     *******************************************************************************************************/
    /**
     *
     * @param frmFfldPf4 TODO_javadoc.
     *
     */
    public void setFrmFfldPf4(String frmFfldPf4) {
        replaceValue(34, 35, frmFfldPf4);
    }

    /*******************************************************************************************************
     * setFrmFfldPf5
     *******************************************************************************************************/
    /**
     *
     * @param frmFfldPf5 TODO_javadoc.
     *
     */
    public void setFrmFfldPf5(String frmFfldPf5) {
        replaceValue(35, 36, frmFfldPf5);
    }

    /*******************************************************************************************************
     * setFrmFfldPf6
     *******************************************************************************************************/
    /**
     *
     * @param frmFfldPf6 TODO_javadoc.
     *
     */
    public void setFrmFfldPf6(String frmFfldPf6) {
        replaceValue(36, 37, frmFfldPf6);
    }

    /*******************************************************************************************************
     * setFrmFfldPf7
     *******************************************************************************************************/
    /**
     *
     * @param frmFfldPf7 TODO_javadoc.
     *
     */
    public void setFrmFfldPf7(String frmFfldPf7) {
        replaceValue(37, 38, frmFfldPf7);
    }

    /*******************************************************************************************************
     * setFrmFfldPf8
     *******************************************************************************************************/
    /**
     *
     * @param frmFfldPf8 TODO_javadoc.
     *
     */
    public void setFrmFfldPf8(String frmFfldPf8) {
        replaceValue(38, 39, frmFfldPf8);
    }

    /*******************************************************************************************************
     * setFrmFfldPf9
     *******************************************************************************************************/
    /**
     *
     * @param frmFfldPf9 TODO_javadoc.
     *
     */
    public void setFrmFfldPf9(String frmFfldPf9) {
        replaceValue(39, 40, frmFfldPf9);
    }

    /*******************************************************************************************************
     * setFrmFfldPf10
     *******************************************************************************************************/
    /**
     *
     * @param frmFfldPf10 TODO_javadoc.
     *
     */
    public void setFrmFfldPf10(String frmFfldPf10) {
        replaceValue(40, 41, frmFfldPf10);
    }

    /*******************************************************************************************************
     * setFrmFfldPf11
     *******************************************************************************************************/
    /**
     *
     * @param frmFfldPf11 TODO_javadoc.
     *
     */
    public void setFrmFfldPf11(String frmFfldPf11) {
        replaceValue(41, 42, frmFfldPf11);
    }

    /*******************************************************************************************************
     * setFrmFfldPf12
     *******************************************************************************************************/
    /**
     *
     * @param frmFfldPf12 TODO_javadoc.
     *
     */
    public void setFrmFfldPf12(String frmFfldPf12) {
        replaceValue(42, 43, frmFfldPf12);
    }

    /*******************************************************************************************************
     * setFrmFfldPfa
     *******************************************************************************************************/
    /**
     *
     * @param frmFfldPfa TODO_javadoc.
     *
     */
    public void setFrmFfldPfa(String frmFfldPfa) {
        replaceValue(43, 44, frmFfldPfa);
    }

    /*******************************************************************************************************
     * setFrmFfldPfb
     *******************************************************************************************************/
    /**
     *
     * @param frmFfldPfb TODO_javadoc.
     *
     */
    public void setFrmFfldPfb(String frmFfldPfb) {
        replaceValue(44, 45, frmFfldPfb);
    }

    /*******************************************************************************************************
     * setFrmFfldPfc
     *******************************************************************************************************/
    /**
     *
     * @param frmFfldPfc TODO_javadoc.
     *
     */
    public void setFrmFfldPfc(String frmFfldPfc) {
        replaceValue(45, 46, frmFfldPfc);
    }

    /*******************************************************************************************************
     * setFrmFfldPfd
     *******************************************************************************************************/
    /**
     *
     * @param frmFfldPfd TODO_javadoc.
     *
     */
    public void setFrmFfldPfd(String frmFfldPfd) {
        replaceValue(46, 47, frmFfldPfd);
    }

    /*******************************************************************************************************
     * setFrmFfldPfe
     *******************************************************************************************************/
    /**
     *
     * @param frmFfldPfe TODO_javadoc.
     *
     */
    public void setFrmFfldPfe(String frmFfldPfe) {
        replaceValue(47, 48, frmFfldPfe);
    }

    /*******************************************************************************************************
     * setFrmFfldPff
     *******************************************************************************************************/
    /**
     *
     * @param frmFfldPff TODO_javadoc.
     *
     */
    public void setFrmFfldPff(String frmFfldPff) {
        replaceValue(48, 49, frmFfldPff);
    }

    /*******************************************************************************************************
     * setFrmFfldPfg
     *******************************************************************************************************/
    /**
     *
     * @param frmFfldPfg TODO_javadoc.
     *
     */
    public void setFrmFfldPfg(String frmFfldPfg) {
        replaceValue(49, 50, frmFfldPfg);
    }

    /*******************************************************************************************************
     * setFrmFfldPfh
     *******************************************************************************************************/
    /**
     *
     * @param frmFfldPfh TODO_javadoc.
     *
     */
    public void setFrmFfldPfh(String frmFfldPfh) {
        replaceValue(50, 51, frmFfldPfh);
    }

    /*******************************************************************************************************
     * setFrmFfldPfi
     *******************************************************************************************************/
    /**
     *
     * @param frmFfldPfi TODO_javadoc.
     *
     */
    public void setFrmFfldPfi(String frmFfldPfi) {
        replaceValue(51, 52, frmFfldPfi);
    }

    /*******************************************************************************************************
     * setFrmFfldPfj
     *******************************************************************************************************/
    /**
     *
     * @param frmFfldPfj TODO_javadoc.
     *
     */
    public void setFrmFfldPfj(String frmFfldPfj) {
        replaceValue(52, 53, frmFfldPfj);
    }

    /*******************************************************************************************************
     * setFrmFfldPfk
     *******************************************************************************************************/
    /**
     *
     * @param frmFfldPfk TODO_javadoc.
     *
     */
    public void setFrmFfldPfk(String frmFfldPfk) {
        replaceValue(53, 54, frmFfldPfk);
    }

    /*******************************************************************************************************
     * setFrmFfldPfl
     *******************************************************************************************************/
    /**
     *
     * @param frmFfldPfl TODO_javadoc.
     *
     */
    public void setFrmFfldPfl(String frmFfldPfl) {
        replaceValue(54, 55, frmFfldPfl);
    }

    /*******************************************************************************************************
     * setFrmSuarMal
     *******************************************************************************************************/
    /**
     *
     * @param frmSuarMal TODO_javadoc.
     *
     */
    public void setFrmSuarMal(String frmSuarMal) {
        replaceValue(55, 58, frmSuarMal);
    }

    /*******************************************************************************************************
     * setFrmSuarWrn
     *******************************************************************************************************/
    /**
     *
     * @param frmSuarWrn TODO_javadoc.
     *
     */
    public void setFrmSuarWrn(String frmSuarWrn) {
        replaceValue(58, 61, frmSuarWrn);
    }

    /*******************************************************************************************************
     * setFrmSuarClr
     *******************************************************************************************************/
    /**
     *
     * @param frmSuarClr TODO_javadoc.
     *
     */
    public void setFrmSuarClr(String frmSuarClr) {
        replaceValue(61, 64, frmSuarClr);
    }

    /*******************************************************************************************************
     * setFrmSuarOks
     *******************************************************************************************************/
    /**
     *
     * @param frmSuarOks TODO_javadoc.
     *
     */
    public void setFrmSuarOks(String frmSuarOks) {
        replaceValue(64, 67, frmSuarOks);
    }

    /*******************************************************************************************************
     * setFrmPosCurs
     *******************************************************************************************************/
    /**
     *
     * @param frmPosCurs TODO_javadoc.
     *
     */
    public void setFrmPosCurs(int frmPosCurs) {
        replaceValue(74, 78, setCompNumber(frmPosCurs, form4z));
    }

    /*******************************************************************************************************
     * setFrmIndErro
     *******************************************************************************************************/
    /**
     *
     * @param frmIndErro TODO_javadoc.
     *
     */
    public void setFrmIndErro(int frmIndErro) {
        replaceValue(78, 82, setCompNumber(frmIndErro, form4z));
    }

    /*******************************************************************************************************
     * setFrmErrNume
     *******************************************************************************************************/
    /**
     *
     * @param frmErrNume TODO_javadoc.
     *
     */
    public void setFrmErrNume(int frmErrNume) {
        replaceValue(82, 86, setCompNumber(frmErrNume, form4z));
    }

    /*******************************************************************************************************
     * setFrmRstPcur
     *******************************************************************************************************/
    /**
     *
     * @param frmRstPcur TODO_javadoc.
     *
     */
    public void setFrmRstPcur(int frmRstPcur) {
        replaceValue(86, 90, setCompNumber(frmRstPcur, form4z));
    }

    /*******************************************************************************************************
     * getFrmIni
     *******************************************************************************************************/
    /**
     *
     * @return frmIni TODO_javadoc.
     *
     */
    public int getFrmIni() {
        return Integer.parseInt(subValue(0, 2));
    }

    /*******************************************************************************************************
     * getFrmGetAll
     *******************************************************************************************************/
    /**
     *
     * @return frmGetAll TODO_javadoc.
     *
     */
    public int getFrmGetAll() {
        return Integer.parseInt(subValue(2, 4));
    }

    /*******************************************************************************************************
     * getFrmPutAll
     *******************************************************************************************************/
    /**
     *
     * @return frmPutAll TODO_javadoc.
     *
     */
    public int getFrmPutAll() {
        return Integer.parseInt(subValue(4, 6));
    }

    /*******************************************************************************************************
     * getFrmClrAll
     *******************************************************************************************************/
    /**
     *
     * @return frmClrAll TODO_javadoc.
     *
     */
    public int getFrmClrAll() {
        return Integer.parseInt(subValue(6, 8));
    }

    /*******************************************************************************************************
     * getFrmMsg
     *******************************************************************************************************/
    /**
     *
     * @return frmMsg TODO_javadoc.
     *
     */
    public int getFrmMsg() {
        return Integer.parseInt(subValue(8, 10));
    }

    /*******************************************************************************************************
     * getFrmRcv
     *******************************************************************************************************/
    /**
     *
     * @return frmRcv TODO_javadoc.
     *
     */
    public int getFrmRcv() {
        return Integer.parseInt(subValue(10, 12));
    }

    /*******************************************************************************************************
     * getFrmAbt
     *******************************************************************************************************/
    /**
     *
     * @return frmAbt TODO_javadoc.
     *
     */
    public int getFrmAbt() {
        return Integer.parseInt(subValue(12, 14));
    }

    /*******************************************************************************************************
     * getFrmClrFrm
     *******************************************************************************************************/
    /**
     *
     * @return frmClrFrm TODO_javadoc.
     *
     */
    public int getFrmClrFrm() {
        return Integer.parseInt(subValue(14, 16));
    }

    /*******************************************************************************************************
     * getFrmSiniDb1f
     *******************************************************************************************************/
    /**
     *
     * @return frmSiniDb1f TODO_javadoc.
     *
     */
    public int getFrmSiniDb1f() {
        return Integer.parseInt(subValue(16, 17));
    }

    /*******************************************************************************************************
     * getFrmSiniDbnf
     *******************************************************************************************************/
    /**
     *
     * @return frmSiniDbnf TODO_javadoc.
     *
     */
    public int getFrmSiniDbnf() {
        return Integer.parseInt(subValue(17, 18));
    }

    /*******************************************************************************************************
     * getFrmSiniDblf
     *******************************************************************************************************/
    /**
     *
     * @return frmSiniDblf TODO_javadoc.
     *
     */
    public int getFrmSiniDblf() {
        return Integer.parseInt(subValue(18, 19));
    }

    /*******************************************************************************************************
     * getFrmSiniMb1f
     *******************************************************************************************************/
    /**
     *
     * @return frmSiniMb1f TODO_javadoc.
     *
     */
    public int getFrmSiniMb1f() {
        return Integer.parseInt(subValue(19, 20));
    }

    /*******************************************************************************************************
     * getFrmSiniMbnf
     *******************************************************************************************************/
    /**
     *
     * @return frmSiniMbnf TODO_javadoc.
     *
     */
    public int getFrmSiniMbnf() {
        return Integer.parseInt(subValue(20, 21));
    }

    /*******************************************************************************************************
     * getFrmSiniMblf
     *******************************************************************************************************/
    /**
     *
     * @return frmSiniMblf TODO_javadoc.
     *
     */
    public int getFrmSiniMblf() {
        return Integer.parseInt(subValue(21, 26));
    }

    /*******************************************************************************************************
     * getFrmFfldPa1
     *******************************************************************************************************/
    /**
     *
     * @return frmFfldPa1 TODO_javadoc.
     *
     */
    public String getFrmFfldPa1() {
        return subValue(26, 27);
    }

    /*******************************************************************************************************
     * getFrmFfldPa2
     *******************************************************************************************************/
    /**
     *
     * @return frmFfldPa2 TODO_javadoc.
     *
     */
    public String getFrmFfldPa2() {
        return subValue(27, 28);
    }

    /*******************************************************************************************************
     * getFrmFfldPa3
     *******************************************************************************************************/
    /**
     *
     * @return frmFfldPa3 TODO_javadoc.
     *
     */
    public String getFrmFfldPa3() {
        return subValue(28, 29);
    }

    /*******************************************************************************************************
     * getFrmFfldRet
     *******************************************************************************************************/
    /**
     *
     * @return frmFfldRet TODO_javadoc.
     *
     */
    public String getFrmFfldRet() {
        return subValue(29, 30);
    }

    /*******************************************************************************************************
     * getFrmFfldTab
     *******************************************************************************************************/
    /**
     *
     * @return frmFfldTab TODO_javadoc.
     *
     */
    public String getFrmFfldTab() {
        return subValue(30, 31);
    }

    /*******************************************************************************************************
     * getFrmFfldPf1
     *******************************************************************************************************/
    /**
     *
     * @return frmFfldPf1 TODO_javadoc.
     *
     */
    public String getFrmFfldPf1() {
        return subValue(31, 32);
    }

    /*******************************************************************************************************
     * getFrmFfldPf2
     *******************************************************************************************************/
    /**
     *
     * @return frmFfldPf2 TODO_javadoc.
     *
     */
    public String getFrmFfldPf2() {
        return subValue(32, 33);
    }

    /*******************************************************************************************************
     * getFrmFfldPf3
     *******************************************************************************************************/
    /**
     *
     * @return frmFfldPf3 TODO_javadoc.
     *
     */
    public String getFrmFfldPf3() {
        return subValue(33, 34);
    }

    /*******************************************************************************************************
     * getFrmFfldPf4
     *******************************************************************************************************/
    /**
     *
     * @return frmFfldPf4 TODO_javadoc.
     *
     */
    public String getFrmFfldPf4() {
        return subValue(34, 35);
    }

    /*******************************************************************************************************
     * getFrmFfldPf5
     *******************************************************************************************************/
    /**
     *
     * @return frmFfldPf5 TODO_javadoc.
     *
     */
    public String getFrmFfldPf5() {
        return subValue(35, 36);
    }

    /*******************************************************************************************************
     * getFrmFfldPf6
     *******************************************************************************************************/
    /**
     *
     * @return frmFfldPf6 TODO_javadoc.
     *
     */
    public String getFrmFfldPf6() {
        return subValue(36, 37);
    }

    /*******************************************************************************************************
     * getFrmFfldPf7
     *******************************************************************************************************/
    /**
     *
     * @return frmFfldPf7 TODO_javadoc.
     *
     */
    public String getFrmFfldPf7() {
        return subValue(37, 38);
    }

    /*******************************************************************************************************
     * getFrmFfldPf8
     *******************************************************************************************************/
    /**
     *
     * @return frmFfldPf8 TODO_javadoc.
     *
     */
    public String getFrmFfldPf8() {
        return subValue(38, 39);
    }

    /*******************************************************************************************************
     * getFrmFfldPf9
     *******************************************************************************************************/
    /**
     *
     * @return frmFfldPf9 TODO_javadoc.
     *
     */
    public String getFrmFfldPf9() {
        return subValue(39, 40);
    }

    /*******************************************************************************************************
     * getFrmFfldPf10
     *******************************************************************************************************/
    /**
     *
     * @return frmFfldPf10 TODO_javadoc.
     *
     */
    public String getFrmFfldPf10() {
        return subValue(40, 41);
    }

    /*******************************************************************************************************
     * getFrmFfldPf11
     *******************************************************************************************************/
    /**
     *
     * @return frmFfldPf11 TODO_javadoc.
     *
     */
    public String getFrmFfldPf11() {
        return subValue(41, 42);
    }

    /*******************************************************************************************************
     * getFrmFfldPf12
     *******************************************************************************************************/
    /**
     *
     * @return frmFfldPf12 TODO_javadoc.
     *
     */
    public String getFrmFfldPf12() {
        return subValue(42, 43);
    }

    /*******************************************************************************************************
     * getFrmFfldPfa
     *******************************************************************************************************/
    /**
     *
     * @return frmFfldPfa TODO_javadoc.
     *
     */
    public String getFrmFfldPfa() {
        return subValue(43, 44);
    }

    /*******************************************************************************************************
     * getFrmFfldPfb
     *******************************************************************************************************/
    /**
     *
     * @return frmFfldPfb TODO_javadoc.
     *
     */
    public String getFrmFfldPfb() {
        return subValue(44, 45);
    }

    /*******************************************************************************************************
     * getFrmFfldPfc
     *******************************************************************************************************/
    /**
     *
     * @return frmFfldPfc TODO_javadoc.
     *
     */
    public String getFrmFfldPfc() {
        return subValue(45, 46);
    }

    /*******************************************************************************************************
     * getFrmFfldPfd
     *******************************************************************************************************/
    /**
     *
     * @return frmFfldPfd TODO_javadoc.
     *
     */
    public String getFrmFfldPfd() {
        return subValue(46, 47);
    }

    /*******************************************************************************************************
     * getFrmFfldPfe
     *******************************************************************************************************/
    /**
     *
     * @return frmFfldPfe TODO_javadoc.
     *
     */
    public String getFrmFfldPfe() {
        return subValue(47, 48);
    }

    /*******************************************************************************************************
     * getFrmFfldPff
     *******************************************************************************************************/
    /**
     *
     * @return frmFfldPff TODO_javadoc.
     *
     */
    public String getFrmFfldPff() {
        return subValue(48, 49);
    }

    /*******************************************************************************************************
     * getFrmFfldPfg
     *******************************************************************************************************/
    /**
     *
     * @return frmFfldPfg TODO_javadoc.
     *
     */
    public String getFrmFfldPfg() {
        return subValue(49, 50);
    }

    /*******************************************************************************************************
     * getFrmFfldPfh
     *******************************************************************************************************/
    /**
     *
     * @return frmFfldPfh TODO_javadoc.
     *
     */
    public String getFrmFfldPfh() {
        return subValue(50, 51);
    }

    /*******************************************************************************************************
     * getFrmFfldPfi
     *******************************************************************************************************/
    /**
     *
     * @return frmFfldPfi TODO_javadoc.
     *
     */
    public String getFrmFfldPfi() {
        return subValue(51, 52);
    }

    /*******************************************************************************************************
     * getFrmFfldPfj
     *******************************************************************************************************/
    /**
     *
     * @return frmFfldPfj TODO_javadoc.
     *
     */
    public String getFrmFfldPfj() {
        return subValue(52, 53);
    }

    /*******************************************************************************************************
     * getFrmFfldPfk
     *******************************************************************************************************/
    /**
     *
     * @return frmFfldPfk TODO_javadoc.
     *
     */
    public String getFrmFfldPfk() {
        return subValue(53, 54);
    }

    /*******************************************************************************************************
     * getFrmFfldPfl
     *******************************************************************************************************/
    /**
     *
     * @return frmFfldPfl TODO_javadoc.
     *
     */
    public String getFrmFfldPfl() {
        return subValue(54, 55);
    }

    /*******************************************************************************************************
     * getFrmSuarMal
     *******************************************************************************************************/
    /**
     *
     * @return frmSuarMal TODO_javadoc.
     *
     */
    public String getFrmSuarMal() {
        return subValue(55, 58);
    }

    /*******************************************************************************************************
     * getFrmSuarWrn
     *******************************************************************************************************/
    /**
     *
     * @return frmSuarWrn TODO_javadoc.
     *
     */
    public String getFrmSuarWrn() {
        return subValue(58, 61);
    }

    /*******************************************************************************************************
     * getFrmSuarClr
     *******************************************************************************************************/
    /**
     *
     * @return frmSuarClr TODO_javadoc.
     *
     */
    public String getFrmSuarClr() {
        return subValue(61, 64);
    }

    /*******************************************************************************************************
     * getFrmSuarOks
     *******************************************************************************************************/
    /**
     *
     * @return frmSuarOks TODO_javadoc.
     *
     */
    public String getFrmSuarOks() {
        return subValue(64, 67);
    }

    /*******************************************************************************************************
     * getFrmCpim
     *******************************************************************************************************/
    /**
     *
     * @return frmCpim TODO_javadoc.
     *
     */
    public FrmCpim getFrmCpim() {
        return frmCpim;
    }

    /*******************************************************************************************************
     * getFrmPosCurs
     *******************************************************************************************************/
    /**
     *
     * @return frmPosCurs TODO_javadoc.
     *
     */
    public int getFrmPosCurs() {
        return (int) getCompNumber(subValue(74, 78));
    }

    /*******************************************************************************************************
     * getFrmIndErro
     *******************************************************************************************************/
    /**
     *
     * @return frmIndErro TODO_javadoc.
     *
     */
    public int getFrmIndErro() {
        return (int) getCompNumber(subValue(78, 82));
    }

    /*******************************************************************************************************
     * getFrmErrNume
     *******************************************************************************************************/
    /**
     *
     * @return frmErrNume TODO_javadoc.
     *
     */
    public int getFrmErrNume() {
        return (int) getCompNumber(subValue(82, 86));
    }

    /*******************************************************************************************************
     * getFrmRstPcur
     *******************************************************************************************************/
    /**
     *
     * @return frmRstPcur TODO_javadoc.
     *
     */
    public int getFrmRstPcur() {
        return (int) getCompNumber(subValue(86, 90));
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class FrmCpim {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public FrmCpim() {
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
            replaceValue(67, 74, value);
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
            return subValue(67, 67 + 7);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setFrmCpimAey
         *******************************************************************************************************/
        /**
         *
         * @param frmCpimAey TODO_javadoc.
         *
         */
        public void setFrmCpimAey(String frmCpimAey) {
            replaceValue(67, 68, frmCpimAey);
        }

        /*******************************************************************************************************
         * setFrmCpimUby
         *******************************************************************************************************/
        /**
         *
         * @param frmCpimUby TODO_javadoc.
         *
         */
        public void setFrmCpimUby(String frmCpimUby) {
            replaceValue(68, 69, frmCpimUby);
        }

        /*******************************************************************************************************
         * setFrmCpimAny
         *******************************************************************************************************/
        /**
         *
         * @param frmCpimAny TODO_javadoc.
         *
         */
        public void setFrmCpimAny(String frmCpimAny) {
            replaceValue(69, 70, frmCpimAny);
        }

        /*******************************************************************************************************
         * setFrmCpimUny
         *******************************************************************************************************/
        /**
         *
         * @param frmCpimUny TODO_javadoc.
         *
         */
        public void setFrmCpimUny(String frmCpimUny) {
            replaceValue(70, 71, frmCpimUny);
        }

        /*******************************************************************************************************
         * setFrmCpsfAey
         *******************************************************************************************************/
        /**
         *
         * @param frmCpsfAey TODO_javadoc.
         *
         */
        public void setFrmCpsfAey(String frmCpsfAey) {
            replaceValue(71, 72, frmCpsfAey);
        }

        /*******************************************************************************************************
         * setFrmCpimAby
         *******************************************************************************************************/
        /**
         *
         * @param frmCpimAby TODO_javadoc.
         *
         */
        public void setFrmCpimAby(String frmCpimAby) {
            replaceValue(72, 73, frmCpimAby);
        }

        /*******************************************************************************************************
         * setFrmCpimUst
         *******************************************************************************************************/
        /**
         *
         * @param frmCpimUst TODO_javadoc.
         *
         */
        public void setFrmCpimUst(String frmCpimUst) {
            replaceValue(73, 74, frmCpimUst);
        }

        /*******************************************************************************************************
         * getFrmCpimAey
         *******************************************************************************************************/
        /**
         *
         * @return frmCpimAey TODO_javadoc.
         *
         */
        public String getFrmCpimAey() {
            return subValue(67, 68);
        }

        /*******************************************************************************************************
         * getFrmCpimUby
         *******************************************************************************************************/
        /**
         *
         * @return frmCpimUby TODO_javadoc.
         *
         */
        public String getFrmCpimUby() {
            return subValue(68, 69);
        }

        /*******************************************************************************************************
         * getFrmCpimAny
         *******************************************************************************************************/
        /**
         *
         * @return frmCpimAny TODO_javadoc.
         *
         */
        public String getFrmCpimAny() {
            return subValue(69, 70);
        }

        /*******************************************************************************************************
         * getFrmCpimUny
         *******************************************************************************************************/
        /**
         *
         * @return frmCpimUny TODO_javadoc.
         *
         */
        public String getFrmCpimUny() {
            return subValue(70, 71);
        }

        /*******************************************************************************************************
         * getFrmCpsfAey
         *******************************************************************************************************/
        /**
         *
         * @return frmCpsfAey TODO_javadoc.
         *
         */
        public String getFrmCpsfAey() {
            return subValue(71, 72);
        }

        /*******************************************************************************************************
         * getFrmCpimAby
         *******************************************************************************************************/
        /**
         *
         * @return frmCpimAby TODO_javadoc.
         *
         */
        public String getFrmCpimAby() {
            return subValue(72, 73);
        }

        /*******************************************************************************************************
         * getFrmCpimUst
         *******************************************************************************************************/
        /**
         *
         * @return frmCpimUst TODO_javadoc.
         *
         */
        public String getFrmCpimUst() {
            return subValue(73, 74);
        }

    }

}

