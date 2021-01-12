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
public class FioCtts extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(FioCtts.class);

    /** TODO_javadoc. */
    private static DecimalFormat form1z = new DecimalFormat("0");

    /** TODO_javadoc. */
    private static DecimalFormat form2z = new DecimalFormat("00");

    /** TODO_javadoc. */
    private static DecimalFormat form4z = new DecimalFormat("0000");

    /** TODO_javadoc. */
    private FioVcmn fioVcmn = new FioVcmn();

    /** TODO_javadoc. */
    private FioVcmnRed fioVcmnRed = new FioVcmnRed();

    /** TODO_javadoc. */
    private FioMens fioMens = new FioMens();

    /** TODO_javadoc. */
    private FioMensRed fioMensRed = new FioMensRed();

    /** TODO_javadoc. */
    private FioMsfl fioMsfl = new FioMsfl();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public FioCtts() {

        initBuffer(2339);

        replaceValue(0, 2339, "00000000  00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000                                                                                                                                                                                                                                                                                                                                                                                        000{                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                00000000000                                                                                                                                             00 00"); // FIO-CTTS
        replaceValue(0, 1, form1z.format(0)); // FIO-ACCS-DEF
        replaceValue(1, 2, form1z.format(1)); // FIO-ACCS-NOT
        replaceValue(2, 3, form1z.format(2)); // FIO-ACCS-INP
        replaceValue(3, 4, form1z.format(3)); // FIO-ACCS-UPD
        replaceValue(4, 5, form1z.format(0)); // FIO-RLCK-FIO
        replaceValue(5, 6, form1z.format(1)); // FIO-RLCK-PGM
        replaceValue(6, 7, form1z.format(0)); // FIO-IFNF-FIO
        replaceValue(7, 8, form1z.format(1)); // FIO-IFNF-PGM
        replaceValue(8, 10, "39"); // FIO-STAT-NEX
        replaceValue(10, 14, form4z.format(1)); // FIO-GET-KEY
        replaceValue(14, 18, form4z.format(2)); // FIO-GET-NXT
        replaceValue(18, 22, form4z.format(3)); // FIO-GET-FST
        replaceValue(22, 26, form4z.format(4)); // FIO-GET-NLS
        replaceValue(26, 30, form4z.format(5)); // FIO-GET-GRT
        replaceValue(30, 34, form4z.format(6)); // FIO-PUT
        replaceValue(34, 38, form4z.format(7)); // FIO-MOD
        replaceValue(38, 42, form4z.format(8)); // FIO-DEL
        replaceValue(42, 46, form4z.format(9)); // FIO-CHG
        replaceValue(46, 50, form4z.format(10)); // FIO-INP
        replaceValue(50, 54, form4z.format(11)); // FIO-OUT
        replaceValue(54, 58, form4z.format(12)); // FIO-UPD
        replaceValue(58, 62, form4z.format(13)); // FIO-CLO
        replaceValue(62, 66, form4z.format(14)); // FIO-FND-EQL
        replaceValue(66, 70, form4z.format(15)); // FIO-FND-FST
        replaceValue(70, 74, form4z.format(16)); // FIO-FND-NLS
        replaceValue(74, 78, form4z.format(17)); // FIO-FND-GRT
        replaceValue(78, 82, form4z.format(18)); // FIO-ULK-REC
        replaceValue(82, 86, form4z.format(19)); // FIO-ULK-ALL
        replaceValue(86, 90, form4z.format(20)); // FIO-VID
        replaceValue(90, 94, form4z.format(21)); // FIO-ACC
        replaceValue(94, 98, form4z.format(22)); // FIO-REC-LCK
        replaceValue(98, 102, form4z.format(23)); // FIO-FNF
        replaceValue(102, 106, form4z.format(24)); // FIO-REC-LEN
        replaceValue(106, 110, form4z.format(25)); // FIO-EXT
        replaceValue(110, 114, form4z.format(26)); // FIO-GET-KEY-ALT
        replaceValue(114, 118, form4z.format(27)); // FIO-GET-FST-ALT
        replaceValue(118, 122, form4z.format(28)); // FIO-GET-NLS-ALT
        replaceValue(122, 126, form4z.format(29)); // FIO-GET-GRT-ALT
        replaceValue(126, 130, form4z.format(30)); // FIO-FND-EQL-ALT
        replaceValue(130, 134, form4z.format(31)); // FIO-FND-FST-ALT
        replaceValue(134, 138, form4z.format(32)); // FIO-FND-NLS-ALT
        replaceValue(138, 142, form4z.format(33)); // FIO-FND-GRT-ALT
        replaceValue(142, 146, form4z.format(34)); // FIO-GET-NXT-ALT
        replaceValue(146, 150, form4z.format(35)); // FIO-GET-KEY-UPD-ALT
        replaceValue(150, 154, form4z.format(36)); // FIO-GET-KEY-UPD
        replaceValue(154, 158, form4z.format(37)); // FIO-END-BRW
        replaceValue(158, 162, form4z.format(38)); // FIO-BCK-OUT
        replaceValue(162, 166, form4z.format(39)); // FIO-GET-LEQ
        replaceValue(166, 170, form4z.format(40)); // FIO-GET-PRV
        replaceValue(170, 174, form4z.format(41)); // FIO-CHK-PNT
        replaceValue(174, 178, form4z.format(42)); // FIO-BFR-RFH
        replaceValue(178, 182, form4z.format(43)); // FIO-EBR-ALL
        replaceValue(182, 186, form4z.format(44)); // FIO-BEG-TRN
        replaceValue(2102, 2182, "                                                                                "); // FIO-MENS
        replaceValue(2182, 2186, form4z.format(0)); // FIO-IAKY
        replaceValue(2186, 2190, form4z.format(0)); // FIO-IGET
        replaceValue(2190, 2191, form1z.format(0)); // FIO-KDEF
        replaceValue(2191, 2192, form1z.format(0)); // FIO-KDEF-N
        replaceValue(2192, 2193, form1z.format(1)); // FIO-KDEF-S
        replaceValue(2193, 2194, " "); // FIO-IVEZ
        replaceValue(2194, 2334, "                                                                                                                                            "); // FIO-MSFL
        replaceValue(2334, 2336, form2z.format(20)); // FIO-MXFL
        replaceValue(2336, 2337, "N"); // FIO-ISBR
        replaceValue(2337, 2339, form2z.format(0)); // FIO-IAUX
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
        replaceValue(0, 2339, value);
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
        return subValue(0, 2339);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setFioAccsDef
     *******************************************************************************************************/
    /**
     *
     * @param fioAccsDef TODO_javadoc.
     *
     */
    public void setFioAccsDef(int fioAccsDef) {
        replaceValue(0, 1, form1z.format(fioAccsDef));
    }

    /*******************************************************************************************************
     * setFioAccsNot
     *******************************************************************************************************/
    /**
     *
     * @param fioAccsNot TODO_javadoc.
     *
     */
    public void setFioAccsNot(int fioAccsNot) {
        replaceValue(1, 2, form1z.format(fioAccsNot));
    }

    /*******************************************************************************************************
     * setFioAccsInp
     *******************************************************************************************************/
    /**
     *
     * @param fioAccsInp TODO_javadoc.
     *
     */
    public void setFioAccsInp(int fioAccsInp) {
        replaceValue(2, 3, form1z.format(fioAccsInp));
    }

    /*******************************************************************************************************
     * setFioAccsUpd
     *******************************************************************************************************/
    /**
     *
     * @param fioAccsUpd TODO_javadoc.
     *
     */
    public void setFioAccsUpd(int fioAccsUpd) {
        replaceValue(3, 4, form1z.format(fioAccsUpd));
    }

    /*******************************************************************************************************
     * setFioRlckFio
     *******************************************************************************************************/
    /**
     *
     * @param fioRlckFio TODO_javadoc.
     *
     */
    public void setFioRlckFio(int fioRlckFio) {
        replaceValue(4, 5, form1z.format(fioRlckFio));
    }

    /*******************************************************************************************************
     * setFioRlckPgm
     *******************************************************************************************************/
    /**
     *
     * @param fioRlckPgm TODO_javadoc.
     *
     */
    public void setFioRlckPgm(int fioRlckPgm) {
        replaceValue(5, 6, form1z.format(fioRlckPgm));
    }

    /*******************************************************************************************************
     * setFioIfnfFio
     *******************************************************************************************************/
    /**
     *
     * @param fioIfnfFio TODO_javadoc.
     *
     */
    public void setFioIfnfFio(int fioIfnfFio) {
        replaceValue(6, 7, form1z.format(fioIfnfFio));
    }

    /*******************************************************************************************************
     * setFioIfnfPgm
     *******************************************************************************************************/
    /**
     *
     * @param fioIfnfPgm TODO_javadoc.
     *
     */
    public void setFioIfnfPgm(int fioIfnfPgm) {
        replaceValue(7, 8, form1z.format(fioIfnfPgm));
    }

    /*******************************************************************************************************
     * setFioStatNex
     *******************************************************************************************************/
    /**
     *
     * @param fioStatNex TODO_javadoc.
     *
     */
    public void setFioStatNex(String fioStatNex) {
        replaceValue(8, 10, fioStatNex);
    }

    /*******************************************************************************************************
     * setFioProg
     *******************************************************************************************************/
    /**
     *
     * @param fioProg TODO_javadoc.
     *
     */
    public void setFioProg(String fioProg) {
        replaceValue(186, 194, fioProg);
    }

    /*******************************************************************************************************
     * setFioGlsProg
     *******************************************************************************************************/
    /**
     *
     * @param fioGlsProg TODO_javadoc.
     *
     */
    public void setFioGlsProg(String fioGlsProg) {
        replaceValue(194, 202, fioGlsProg);
    }

    /*******************************************************************************************************
     * setFioVkey
     *******************************************************************************************************/
    /**
     *
     * @param fioVkey TODO_javadoc.
     *
     */
    public void setFioVkey(String fioVkey) {
        replaceValue(202, 382, fioVkey);
    }

    /*******************************************************************************************************
     * setFioCkey
     *******************************************************************************************************/
    /**
     *
     * @param fioCkey TODO_javadoc.
     *
     */
    public void setFioCkey(String fioCkey) {
        replaceValue(382, 562, fioCkey);
    }

    /*******************************************************************************************************
     * setFioKlen
     *******************************************************************************************************/
    /**
     *
     * @param fioKlen TODO_javadoc.
     *
     */
    public void setFioKlen(int fioKlen) {
        replaceValue(562, 566, setCompNumber(fioKlen, form4z));
    }

    /*******************************************************************************************************
     * setFioDfld
     *******************************************************************************************************/
    /**
     *
     * @param fioDfld TODO_javadoc.
     *
     */
    public void setFioDfld(String fioDfld) {
        replaceValue(566, 2102, fioDfld);
    }

    /*******************************************************************************************************
     * setFioIaky
     *******************************************************************************************************/
    /**
     *
     * @param fioIaky TODO_javadoc.
     *
     */
    public void setFioIaky(int fioIaky) {
        replaceValue(2182, 2186, form4z.format(fioIaky));
    }

    /*******************************************************************************************************
     * setFioIget
     *******************************************************************************************************/
    /**
     *
     * @param fioIget TODO_javadoc.
     *
     */
    public void setFioIget(int fioIget) {
        replaceValue(2186, 2190, form4z.format(fioIget));
    }

    /*******************************************************************************************************
     * setFioKdef
     *******************************************************************************************************/
    /**
     *
     * @param fioKdef TODO_javadoc.
     *
     */
    public void setFioKdef(int fioKdef) {
        replaceValue(2190, 2191, form1z.format(fioKdef));
    }

    /*******************************************************************************************************
     * setFioKdefN
     *******************************************************************************************************/
    /**
     *
     * @param fioKdefN TODO_javadoc.
     *
     */
    public void setFioKdefN(int fioKdefN) {
        replaceValue(2191, 2192, form1z.format(fioKdefN));
    }

    /*******************************************************************************************************
     * setFioKdefS
     *******************************************************************************************************/
    /**
     *
     * @param fioKdefS TODO_javadoc.
     *
     */
    public void setFioKdefS(int fioKdefS) {
        replaceValue(2192, 2193, form1z.format(fioKdefS));
    }

    /*******************************************************************************************************
     * setFioIvez
     *******************************************************************************************************/
    /**
     *
     * @param fioIvez TODO_javadoc.
     *
     */
    public void setFioIvez(String fioIvez) {
        replaceValue(2193, 2194, fioIvez);
    }

    /*******************************************************************************************************
     * setFioMxfl
     *******************************************************************************************************/
    /**
     *
     * @param fioMxfl TODO_javadoc.
     *
     */
    public void setFioMxfl(int fioMxfl) {
        replaceValue(2334, 2336, form2z.format(fioMxfl));
    }

    /*******************************************************************************************************
     * setFioIsbr
     *******************************************************************************************************/
    /**
     *
     * @param fioIsbr TODO_javadoc.
     *
     */
    public void setFioIsbr(String fioIsbr) {
        replaceValue(2336, 2337, fioIsbr);
    }

    /*******************************************************************************************************
     * setFioIaux
     *******************************************************************************************************/
    /**
     *
     * @param fioIaux TODO_javadoc.
     *
     */
    public void setFioIaux(int fioIaux) {
        replaceValue(2337, 2339, form2z.format(fioIaux));
    }

    /*******************************************************************************************************
     * getFioAccsDef
     *******************************************************************************************************/
    /**
     *
     * @return fioAccsDef TODO_javadoc.
     *
     */
    public int getFioAccsDef() {
        return Integer.parseInt(subValue(0, 1));
    }

    /*******************************************************************************************************
     * getFioAccsNot
     *******************************************************************************************************/
    /**
     *
     * @return fioAccsNot TODO_javadoc.
     *
     */
    public int getFioAccsNot() {
        return Integer.parseInt(subValue(1, 2));
    }

    /*******************************************************************************************************
     * getFioAccsInp
     *******************************************************************************************************/
    /**
     *
     * @return fioAccsInp TODO_javadoc.
     *
     */
    public int getFioAccsInp() {
        return Integer.parseInt(subValue(2, 3));
    }

    /*******************************************************************************************************
     * getFioAccsUpd
     *******************************************************************************************************/
    /**
     *
     * @return fioAccsUpd TODO_javadoc.
     *
     */
    public int getFioAccsUpd() {
        return Integer.parseInt(subValue(3, 4));
    }

    /*******************************************************************************************************
     * getFioRlckFio
     *******************************************************************************************************/
    /**
     *
     * @return fioRlckFio TODO_javadoc.
     *
     */
    public int getFioRlckFio() {
        return Integer.parseInt(subValue(4, 5));
    }

    /*******************************************************************************************************
     * getFioRlckPgm
     *******************************************************************************************************/
    /**
     *
     * @return fioRlckPgm TODO_javadoc.
     *
     */
    public int getFioRlckPgm() {
        return Integer.parseInt(subValue(5, 6));
    }

    /*******************************************************************************************************
     * getFioIfnfFio
     *******************************************************************************************************/
    /**
     *
     * @return fioIfnfFio TODO_javadoc.
     *
     */
    public int getFioIfnfFio() {
        return Integer.parseInt(subValue(6, 7));
    }

    /*******************************************************************************************************
     * getFioIfnfPgm
     *******************************************************************************************************/
    /**
     *
     * @return fioIfnfPgm TODO_javadoc.
     *
     */
    public int getFioIfnfPgm() {
        return Integer.parseInt(subValue(7, 8));
    }

    /*******************************************************************************************************
     * getFioStatNex
     *******************************************************************************************************/
    /**
     *
     * @return fioStatNex TODO_javadoc.
     *
     */
    public String getFioStatNex() {
        return subValue(8, 10);
    }

    /*******************************************************************************************************
     * getFioVcmn
     *******************************************************************************************************/
    /**
     *
     * @return fioVcmn TODO_javadoc.
     *
     */
    public FioVcmn getFioVcmn() {
        return fioVcmn;
    }

    /*******************************************************************************************************
     * getFioVcmnRed
     *******************************************************************************************************/
    /**
     *
     * @return fioVcmnRed TODO_javadoc.
     *
     */
    public FioVcmnRed getFioVcmnRed() {
        return fioVcmnRed;
    }

    /*******************************************************************************************************
     * getFioProg
     *******************************************************************************************************/
    /**
     *
     * @return fioProg TODO_javadoc.
     *
     */
    public String getFioProg() {
        return subValue(186, 194);
    }

    /*******************************************************************************************************
     * getFioGlsProg
     *******************************************************************************************************/
    /**
     *
     * @return fioGlsProg TODO_javadoc.
     *
     */
    public String getFioGlsProg() {
        return subValue(194, 202);
    }

    /*******************************************************************************************************
     * getFioVkey
     *******************************************************************************************************/
    /**
     *
     * @return fioVkey TODO_javadoc.
     *
     */
    public String getFioVkey() {
        return subValue(202, 382);
    }

    /*******************************************************************************************************
     * getFioCkey
     *******************************************************************************************************/
    /**
     *
     * @return fioCkey TODO_javadoc.
     *
     */
    public String getFioCkey() {
        return subValue(382, 562);
    }

    /*******************************************************************************************************
     * getFioKlen
     *******************************************************************************************************/
    /**
     *
     * @return fioKlen TODO_javadoc.
     *
     */
    public int getFioKlen() {
        return (int) getCompNumber(subValue(562, 566));
    }

    /*******************************************************************************************************
     * getFioDfld
     *******************************************************************************************************/
    /**
     *
     * @return fioDfld TODO_javadoc.
     *
     */
    public String getFioDfld() {
        return subValue(566, 2102);
    }

    /*******************************************************************************************************
     * getFioMens
     *******************************************************************************************************/
    /**
     *
     * @return fioMens TODO_javadoc.
     *
     */
    public FioMens getFioMens() {
        return fioMens;
    }

    /*******************************************************************************************************
     * getFioMensRed
     *******************************************************************************************************/
    /**
     *
     * @return fioMensRed TODO_javadoc.
     *
     */
    public FioMensRed getFioMensRed() {
        return fioMensRed;
    }

    /*******************************************************************************************************
     * getFioIaky
     *******************************************************************************************************/
    /**
     *
     * @return fioIaky TODO_javadoc.
     *
     */
    public int getFioIaky() {
        return Integer.parseInt(subValue(2182, 2186));
    }

    /*******************************************************************************************************
     * getFioIget
     *******************************************************************************************************/
    /**
     *
     * @return fioIget TODO_javadoc.
     *
     */
    public int getFioIget() {
        return Integer.parseInt(subValue(2186, 2190));
    }

    /*******************************************************************************************************
     * getFioKdef
     *******************************************************************************************************/
    /**
     *
     * @return fioKdef TODO_javadoc.
     *
     */
    public int getFioKdef() {
        return Integer.parseInt(subValue(2190, 2191));
    }

    /*******************************************************************************************************
     * getFioKdefN
     *******************************************************************************************************/
    /**
     *
     * @return fioKdefN TODO_javadoc.
     *
     */
    public int getFioKdefN() {
        return Integer.parseInt(subValue(2191, 2192));
    }

    /*******************************************************************************************************
     * getFioKdefS
     *******************************************************************************************************/
    /**
     *
     * @return fioKdefS TODO_javadoc.
     *
     */
    public int getFioKdefS() {
        return Integer.parseInt(subValue(2192, 2193));
    }

    /*******************************************************************************************************
     * getFioIvez
     *******************************************************************************************************/
    /**
     *
     * @return fioIvez TODO_javadoc.
     *
     */
    public String getFioIvez() {
        return subValue(2193, 2194);
    }

    /*******************************************************************************************************
     * getFioMsfl
     *******************************************************************************************************/
    /**
     *
     * @return fioMsfl TODO_javadoc.
     *
     */
    public FioMsfl getFioMsfl() {
        return fioMsfl;
    }

    /*******************************************************************************************************
     * getFioMxfl
     *******************************************************************************************************/
    /**
     *
     * @return fioMxfl TODO_javadoc.
     *
     */
    public int getFioMxfl() {
        return Integer.parseInt(subValue(2334, 2336));
    }

    /*******************************************************************************************************
     * getFioIsbr
     *******************************************************************************************************/
    /**
     *
     * @return fioIsbr TODO_javadoc.
     *
     */
    public String getFioIsbr() {
        return subValue(2336, 2337);
    }

    /*******************************************************************************************************
     * getFioIaux
     *******************************************************************************************************/
    /**
     *
     * @return fioIaux TODO_javadoc.
     *
     */
    public int getFioIaux() {
        return Integer.parseInt(subValue(2337, 2339));
    }

    /*******************************************************************************************************
     * setFioIakyCon
     *******************************************************************************************************/
    /**
     *
     * @param fioIakyCon TODO_javadoc.
     *
     */
    public void setFioIakyCon(boolean fioIakyCon) {

        if (!fioIakyCon) {
            throw new RuntimeException("Se intento setear fioIakyCon con false.");
        }

            throw new RuntimeException("Se intento setear fioIakyCon (multivaluada).");    }

    /*******************************************************************************************************
     * isFioIakyCon
     *******************************************************************************************************/
    /**
     *
     * @return fioIakyCon TODO_javadoc.
     *
     */
    public boolean isFioIakyCon() {
        return Arrays.binarySearch(new Object[] { 26, 27, 28, 29, 30, 31, 32, 33, 34, 35 }, getFioIaky()) >= 0;
    }

    /*******************************************************************************************************
     * setFioIgetYes
     *******************************************************************************************************/
    /**
     *
     * @param fioIgetYes TODO_javadoc.
     *
     */
    public void setFioIgetYes(boolean fioIgetYes) {

        if (!fioIgetYes) {
            throw new RuntimeException("Se intento setear fioIgetYes con false.");
        }

            throw new RuntimeException("Se intento setear fioIgetYes (multivaluada).");    }

    /*******************************************************************************************************
     * isFioIgetYes
     *******************************************************************************************************/
    /**
     *
     * @return fioIgetYes TODO_javadoc.
     *
     */
    public boolean isFioIgetYes() {
        return Arrays.binarySearch(new Object[] { 1, 2, 3, 4, 5, 26, 27, 28, 29, 34, 35, 36, 39, 40 }, getFioIget()) >= 0;
    }

    /*******************************************************************************************************
     * setFioIcbrYes
     *******************************************************************************************************/
    /**
     *
     * @param fioIcbrYes TODO_javadoc.
     *
     */
    public void setFioIcbrYes(boolean fioIcbrYes) {

        if (!fioIcbrYes) {
            throw new RuntimeException("Se intento setear fioIcbrYes con false.");
        }

            throw new RuntimeException("Se intento setear fioIcbrYes (multivaluada).");    }

    /*******************************************************************************************************
     * isFioIcbrYes
     *******************************************************************************************************/
    /**
     *
     * @return fioIcbrYes TODO_javadoc.
     *
     */
    public boolean isFioIcbrYes() {
        return Arrays.binarySearch(new Object[] { 2, 34, 40 }, getFioIget()) >= 0;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class FioVcmn {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public FioVcmn() {
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
            replaceValue(10, 186, value);
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
            return subValue(10, 10 + 176);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setFioGetKey
         *******************************************************************************************************/
        /**
         *
         * @param fioGetKey TODO_javadoc.
         *
         */
        public void setFioGetKey(int fioGetKey) {
            replaceValue(10, 14, form4z.format(fioGetKey));
        }

        /*******************************************************************************************************
         * setFioGetNxt
         *******************************************************************************************************/
        /**
         *
         * @param fioGetNxt TODO_javadoc.
         *
         */
        public void setFioGetNxt(int fioGetNxt) {
            replaceValue(14, 18, form4z.format(fioGetNxt));
        }

        /*******************************************************************************************************
         * setFioGetFst
         *******************************************************************************************************/
        /**
         *
         * @param fioGetFst TODO_javadoc.
         *
         */
        public void setFioGetFst(int fioGetFst) {
            replaceValue(18, 22, form4z.format(fioGetFst));
        }

        /*******************************************************************************************************
         * setFioGetNls
         *******************************************************************************************************/
        /**
         *
         * @param fioGetNls TODO_javadoc.
         *
         */
        public void setFioGetNls(int fioGetNls) {
            replaceValue(22, 26, form4z.format(fioGetNls));
        }

        /*******************************************************************************************************
         * setFioGetGrt
         *******************************************************************************************************/
        /**
         *
         * @param fioGetGrt TODO_javadoc.
         *
         */
        public void setFioGetGrt(int fioGetGrt) {
            replaceValue(26, 30, form4z.format(fioGetGrt));
        }

        /*******************************************************************************************************
         * setFioPut
         *******************************************************************************************************/
        /**
         *
         * @param fioPut TODO_javadoc.
         *
         */
        public void setFioPut(int fioPut) {
            replaceValue(30, 34, form4z.format(fioPut));
        }

        /*******************************************************************************************************
         * setFioMod
         *******************************************************************************************************/
        /**
         *
         * @param fioMod TODO_javadoc.
         *
         */
        public void setFioMod(int fioMod) {
            replaceValue(34, 38, form4z.format(fioMod));
        }

        /*******************************************************************************************************
         * setFioDel
         *******************************************************************************************************/
        /**
         *
         * @param fioDel TODO_javadoc.
         *
         */
        public void setFioDel(int fioDel) {
            replaceValue(38, 42, form4z.format(fioDel));
        }

        /*******************************************************************************************************
         * setFioChg
         *******************************************************************************************************/
        /**
         *
         * @param fioChg TODO_javadoc.
         *
         */
        public void setFioChg(int fioChg) {
            replaceValue(42, 46, form4z.format(fioChg));
        }

        /*******************************************************************************************************
         * setFioInp
         *******************************************************************************************************/
        /**
         *
         * @param fioInp TODO_javadoc.
         *
         */
        public void setFioInp(int fioInp) {
            replaceValue(46, 50, form4z.format(fioInp));
        }

        /*******************************************************************************************************
         * setFioOut
         *******************************************************************************************************/
        /**
         *
         * @param fioOut TODO_javadoc.
         *
         */
        public void setFioOut(int fioOut) {
            replaceValue(50, 54, form4z.format(fioOut));
        }

        /*******************************************************************************************************
         * setFioUpd
         *******************************************************************************************************/
        /**
         *
         * @param fioUpd TODO_javadoc.
         *
         */
        public void setFioUpd(int fioUpd) {
            replaceValue(54, 58, form4z.format(fioUpd));
        }

        /*******************************************************************************************************
         * setFioClo
         *******************************************************************************************************/
        /**
         *
         * @param fioClo TODO_javadoc.
         *
         */
        public void setFioClo(int fioClo) {
            replaceValue(58, 62, form4z.format(fioClo));
        }

        /*******************************************************************************************************
         * setFioFndEql
         *******************************************************************************************************/
        /**
         *
         * @param fioFndEql TODO_javadoc.
         *
         */
        public void setFioFndEql(int fioFndEql) {
            replaceValue(62, 66, form4z.format(fioFndEql));
        }

        /*******************************************************************************************************
         * setFioFndFst
         *******************************************************************************************************/
        /**
         *
         * @param fioFndFst TODO_javadoc.
         *
         */
        public void setFioFndFst(int fioFndFst) {
            replaceValue(66, 70, form4z.format(fioFndFst));
        }

        /*******************************************************************************************************
         * setFioFndNls
         *******************************************************************************************************/
        /**
         *
         * @param fioFndNls TODO_javadoc.
         *
         */
        public void setFioFndNls(int fioFndNls) {
            replaceValue(70, 74, form4z.format(fioFndNls));
        }

        /*******************************************************************************************************
         * setFioFndGrt
         *******************************************************************************************************/
        /**
         *
         * @param fioFndGrt TODO_javadoc.
         *
         */
        public void setFioFndGrt(int fioFndGrt) {
            replaceValue(74, 78, form4z.format(fioFndGrt));
        }

        /*******************************************************************************************************
         * setFioUlkRec
         *******************************************************************************************************/
        /**
         *
         * @param fioUlkRec TODO_javadoc.
         *
         */
        public void setFioUlkRec(int fioUlkRec) {
            replaceValue(78, 82, form4z.format(fioUlkRec));
        }

        /*******************************************************************************************************
         * setFioUlkAll
         *******************************************************************************************************/
        /**
         *
         * @param fioUlkAll TODO_javadoc.
         *
         */
        public void setFioUlkAll(int fioUlkAll) {
            replaceValue(82, 86, form4z.format(fioUlkAll));
        }

        /*******************************************************************************************************
         * setFioVid
         *******************************************************************************************************/
        /**
         *
         * @param fioVid TODO_javadoc.
         *
         */
        public void setFioVid(int fioVid) {
            replaceValue(86, 90, form4z.format(fioVid));
        }

        /*******************************************************************************************************
         * setFioAcc
         *******************************************************************************************************/
        /**
         *
         * @param fioAcc TODO_javadoc.
         *
         */
        public void setFioAcc(int fioAcc) {
            replaceValue(90, 94, form4z.format(fioAcc));
        }

        /*******************************************************************************************************
         * setFioRecLck
         *******************************************************************************************************/
        /**
         *
         * @param fioRecLck TODO_javadoc.
         *
         */
        public void setFioRecLck(int fioRecLck) {
            replaceValue(94, 98, form4z.format(fioRecLck));
        }

        /*******************************************************************************************************
         * setFioFnf
         *******************************************************************************************************/
        /**
         *
         * @param fioFnf TODO_javadoc.
         *
         */
        public void setFioFnf(int fioFnf) {
            replaceValue(98, 102, form4z.format(fioFnf));
        }

        /*******************************************************************************************************
         * setFioRecLen
         *******************************************************************************************************/
        /**
         *
         * @param fioRecLen TODO_javadoc.
         *
         */
        public void setFioRecLen(int fioRecLen) {
            replaceValue(102, 106, form4z.format(fioRecLen));
        }

        /*******************************************************************************************************
         * setFioExt
         *******************************************************************************************************/
        /**
         *
         * @param fioExt TODO_javadoc.
         *
         */
        public void setFioExt(int fioExt) {
            replaceValue(106, 110, form4z.format(fioExt));
        }

        /*******************************************************************************************************
         * setFioGetKeyAlt
         *******************************************************************************************************/
        /**
         *
         * @param fioGetKeyAlt TODO_javadoc.
         *
         */
        public void setFioGetKeyAlt(int fioGetKeyAlt) {
            replaceValue(110, 114, form4z.format(fioGetKeyAlt));
        }

        /*******************************************************************************************************
         * setFioGetFstAlt
         *******************************************************************************************************/
        /**
         *
         * @param fioGetFstAlt TODO_javadoc.
         *
         */
        public void setFioGetFstAlt(int fioGetFstAlt) {
            replaceValue(114, 118, form4z.format(fioGetFstAlt));
        }

        /*******************************************************************************************************
         * setFioGetNlsAlt
         *******************************************************************************************************/
        /**
         *
         * @param fioGetNlsAlt TODO_javadoc.
         *
         */
        public void setFioGetNlsAlt(int fioGetNlsAlt) {
            replaceValue(118, 122, form4z.format(fioGetNlsAlt));
        }

        /*******************************************************************************************************
         * setFioGetGrtAlt
         *******************************************************************************************************/
        /**
         *
         * @param fioGetGrtAlt TODO_javadoc.
         *
         */
        public void setFioGetGrtAlt(int fioGetGrtAlt) {
            replaceValue(122, 126, form4z.format(fioGetGrtAlt));
        }

        /*******************************************************************************************************
         * setFioFndEqlAlt
         *******************************************************************************************************/
        /**
         *
         * @param fioFndEqlAlt TODO_javadoc.
         *
         */
        public void setFioFndEqlAlt(int fioFndEqlAlt) {
            replaceValue(126, 130, form4z.format(fioFndEqlAlt));
        }

        /*******************************************************************************************************
         * setFioFndFstAlt
         *******************************************************************************************************/
        /**
         *
         * @param fioFndFstAlt TODO_javadoc.
         *
         */
        public void setFioFndFstAlt(int fioFndFstAlt) {
            replaceValue(130, 134, form4z.format(fioFndFstAlt));
        }

        /*******************************************************************************************************
         * setFioFndNlsAlt
         *******************************************************************************************************/
        /**
         *
         * @param fioFndNlsAlt TODO_javadoc.
         *
         */
        public void setFioFndNlsAlt(int fioFndNlsAlt) {
            replaceValue(134, 138, form4z.format(fioFndNlsAlt));
        }

        /*******************************************************************************************************
         * setFioFndGrtAlt
         *******************************************************************************************************/
        /**
         *
         * @param fioFndGrtAlt TODO_javadoc.
         *
         */
        public void setFioFndGrtAlt(int fioFndGrtAlt) {
            replaceValue(138, 142, form4z.format(fioFndGrtAlt));
        }

        /*******************************************************************************************************
         * setFioGetNxtAlt
         *******************************************************************************************************/
        /**
         *
         * @param fioGetNxtAlt TODO_javadoc.
         *
         */
        public void setFioGetNxtAlt(int fioGetNxtAlt) {
            replaceValue(142, 146, form4z.format(fioGetNxtAlt));
        }

        /*******************************************************************************************************
         * setFioGetKeyUpdAlt
         *******************************************************************************************************/
        /**
         *
         * @param fioGetKeyUpdAlt TODO_javadoc.
         *
         */
        public void setFioGetKeyUpdAlt(int fioGetKeyUpdAlt) {
            replaceValue(146, 150, form4z.format(fioGetKeyUpdAlt));
        }

        /*******************************************************************************************************
         * setFioGetKeyUpd
         *******************************************************************************************************/
        /**
         *
         * @param fioGetKeyUpd TODO_javadoc.
         *
         */
        public void setFioGetKeyUpd(int fioGetKeyUpd) {
            replaceValue(150, 154, form4z.format(fioGetKeyUpd));
        }

        /*******************************************************************************************************
         * setFioEndBrw
         *******************************************************************************************************/
        /**
         *
         * @param fioEndBrw TODO_javadoc.
         *
         */
        public void setFioEndBrw(int fioEndBrw) {
            replaceValue(154, 158, form4z.format(fioEndBrw));
        }

        /*******************************************************************************************************
         * setFioBckOut
         *******************************************************************************************************/
        /**
         *
         * @param fioBckOut TODO_javadoc.
         *
         */
        public void setFioBckOut(int fioBckOut) {
            replaceValue(158, 162, form4z.format(fioBckOut));
        }

        /*******************************************************************************************************
         * setFioGetLeq
         *******************************************************************************************************/
        /**
         *
         * @param fioGetLeq TODO_javadoc.
         *
         */
        public void setFioGetLeq(int fioGetLeq) {
            replaceValue(162, 166, form4z.format(fioGetLeq));
        }

        /*******************************************************************************************************
         * setFioGetPrv
         *******************************************************************************************************/
        /**
         *
         * @param fioGetPrv TODO_javadoc.
         *
         */
        public void setFioGetPrv(int fioGetPrv) {
            replaceValue(166, 170, form4z.format(fioGetPrv));
        }

        /*******************************************************************************************************
         * setFioChkPnt
         *******************************************************************************************************/
        /**
         *
         * @param fioChkPnt TODO_javadoc.
         *
         */
        public void setFioChkPnt(int fioChkPnt) {
            replaceValue(170, 174, form4z.format(fioChkPnt));
        }

        /*******************************************************************************************************
         * setFioBfrRfh
         *******************************************************************************************************/
        /**
         *
         * @param fioBfrRfh TODO_javadoc.
         *
         */
        public void setFioBfrRfh(int fioBfrRfh) {
            replaceValue(174, 178, form4z.format(fioBfrRfh));
        }

        /*******************************************************************************************************
         * setFioEbrAll
         *******************************************************************************************************/
        /**
         *
         * @param fioEbrAll TODO_javadoc.
         *
         */
        public void setFioEbrAll(int fioEbrAll) {
            replaceValue(178, 182, form4z.format(fioEbrAll));
        }

        /*******************************************************************************************************
         * setFioBegTrn
         *******************************************************************************************************/
        /**
         *
         * @param fioBegTrn TODO_javadoc.
         *
         */
        public void setFioBegTrn(int fioBegTrn) {
            replaceValue(182, 186, form4z.format(fioBegTrn));
        }

        /*******************************************************************************************************
         * getFioGetKey
         *******************************************************************************************************/
        /**
         *
         * @return fioGetKey TODO_javadoc.
         *
         */
        public int getFioGetKey() {
            return Integer.parseInt(subValue(10, 14));
        }

        /*******************************************************************************************************
         * getFioGetNxt
         *******************************************************************************************************/
        /**
         *
         * @return fioGetNxt TODO_javadoc.
         *
         */
        public int getFioGetNxt() {
            return Integer.parseInt(subValue(14, 18));
        }

        /*******************************************************************************************************
         * getFioGetFst
         *******************************************************************************************************/
        /**
         *
         * @return fioGetFst TODO_javadoc.
         *
         */
        public int getFioGetFst() {
            return Integer.parseInt(subValue(18, 22));
        }

        /*******************************************************************************************************
         * getFioGetNls
         *******************************************************************************************************/
        /**
         *
         * @return fioGetNls TODO_javadoc.
         *
         */
        public int getFioGetNls() {
            return Integer.parseInt(subValue(22, 26));
        }

        /*******************************************************************************************************
         * getFioGetGrt
         *******************************************************************************************************/
        /**
         *
         * @return fioGetGrt TODO_javadoc.
         *
         */
        public int getFioGetGrt() {
            return Integer.parseInt(subValue(26, 30));
        }

        /*******************************************************************************************************
         * getFioPut
         *******************************************************************************************************/
        /**
         *
         * @return fioPut TODO_javadoc.
         *
         */
        public int getFioPut() {
            return Integer.parseInt(subValue(30, 34));
        }

        /*******************************************************************************************************
         * getFioMod
         *******************************************************************************************************/
        /**
         *
         * @return fioMod TODO_javadoc.
         *
         */
        public int getFioMod() {
            return Integer.parseInt(subValue(34, 38));
        }

        /*******************************************************************************************************
         * getFioDel
         *******************************************************************************************************/
        /**
         *
         * @return fioDel TODO_javadoc.
         *
         */
        public int getFioDel() {
            return Integer.parseInt(subValue(38, 42));
        }

        /*******************************************************************************************************
         * getFioChg
         *******************************************************************************************************/
        /**
         *
         * @return fioChg TODO_javadoc.
         *
         */
        public int getFioChg() {
            return Integer.parseInt(subValue(42, 46));
        }

        /*******************************************************************************************************
         * getFioInp
         *******************************************************************************************************/
        /**
         *
         * @return fioInp TODO_javadoc.
         *
         */
        public int getFioInp() {
            return Integer.parseInt(subValue(46, 50));
        }

        /*******************************************************************************************************
         * getFioOut
         *******************************************************************************************************/
        /**
         *
         * @return fioOut TODO_javadoc.
         *
         */
        public int getFioOut() {
            return Integer.parseInt(subValue(50, 54));
        }

        /*******************************************************************************************************
         * getFioUpd
         *******************************************************************************************************/
        /**
         *
         * @return fioUpd TODO_javadoc.
         *
         */
        public int getFioUpd() {
            return Integer.parseInt(subValue(54, 58));
        }

        /*******************************************************************************************************
         * getFioClo
         *******************************************************************************************************/
        /**
         *
         * @return fioClo TODO_javadoc.
         *
         */
        public int getFioClo() {
            return Integer.parseInt(subValue(58, 62));
        }

        /*******************************************************************************************************
         * getFioFndEql
         *******************************************************************************************************/
        /**
         *
         * @return fioFndEql TODO_javadoc.
         *
         */
        public int getFioFndEql() {
            return Integer.parseInt(subValue(62, 66));
        }

        /*******************************************************************************************************
         * getFioFndFst
         *******************************************************************************************************/
        /**
         *
         * @return fioFndFst TODO_javadoc.
         *
         */
        public int getFioFndFst() {
            return Integer.parseInt(subValue(66, 70));
        }

        /*******************************************************************************************************
         * getFioFndNls
         *******************************************************************************************************/
        /**
         *
         * @return fioFndNls TODO_javadoc.
         *
         */
        public int getFioFndNls() {
            return Integer.parseInt(subValue(70, 74));
        }

        /*******************************************************************************************************
         * getFioFndGrt
         *******************************************************************************************************/
        /**
         *
         * @return fioFndGrt TODO_javadoc.
         *
         */
        public int getFioFndGrt() {
            return Integer.parseInt(subValue(74, 78));
        }

        /*******************************************************************************************************
         * getFioUlkRec
         *******************************************************************************************************/
        /**
         *
         * @return fioUlkRec TODO_javadoc.
         *
         */
        public int getFioUlkRec() {
            return Integer.parseInt(subValue(78, 82));
        }

        /*******************************************************************************************************
         * getFioUlkAll
         *******************************************************************************************************/
        /**
         *
         * @return fioUlkAll TODO_javadoc.
         *
         */
        public int getFioUlkAll() {
            return Integer.parseInt(subValue(82, 86));
        }

        /*******************************************************************************************************
         * getFioVid
         *******************************************************************************************************/
        /**
         *
         * @return fioVid TODO_javadoc.
         *
         */
        public int getFioVid() {
            return Integer.parseInt(subValue(86, 90));
        }

        /*******************************************************************************************************
         * getFioAcc
         *******************************************************************************************************/
        /**
         *
         * @return fioAcc TODO_javadoc.
         *
         */
        public int getFioAcc() {
            return Integer.parseInt(subValue(90, 94));
        }

        /*******************************************************************************************************
         * getFioRecLck
         *******************************************************************************************************/
        /**
         *
         * @return fioRecLck TODO_javadoc.
         *
         */
        public int getFioRecLck() {
            return Integer.parseInt(subValue(94, 98));
        }

        /*******************************************************************************************************
         * getFioFnf
         *******************************************************************************************************/
        /**
         *
         * @return fioFnf TODO_javadoc.
         *
         */
        public int getFioFnf() {
            return Integer.parseInt(subValue(98, 102));
        }

        /*******************************************************************************************************
         * getFioRecLen
         *******************************************************************************************************/
        /**
         *
         * @return fioRecLen TODO_javadoc.
         *
         */
        public int getFioRecLen() {
            return Integer.parseInt(subValue(102, 106));
        }

        /*******************************************************************************************************
         * getFioExt
         *******************************************************************************************************/
        /**
         *
         * @return fioExt TODO_javadoc.
         *
         */
        public int getFioExt() {
            return Integer.parseInt(subValue(106, 110));
        }

        /*******************************************************************************************************
         * getFioGetKeyAlt
         *******************************************************************************************************/
        /**
         *
         * @return fioGetKeyAlt TODO_javadoc.
         *
         */
        public int getFioGetKeyAlt() {
            return Integer.parseInt(subValue(110, 114));
        }

        /*******************************************************************************************************
         * getFioGetFstAlt
         *******************************************************************************************************/
        /**
         *
         * @return fioGetFstAlt TODO_javadoc.
         *
         */
        public int getFioGetFstAlt() {
            return Integer.parseInt(subValue(114, 118));
        }

        /*******************************************************************************************************
         * getFioGetNlsAlt
         *******************************************************************************************************/
        /**
         *
         * @return fioGetNlsAlt TODO_javadoc.
         *
         */
        public int getFioGetNlsAlt() {
            return Integer.parseInt(subValue(118, 122));
        }

        /*******************************************************************************************************
         * getFioGetGrtAlt
         *******************************************************************************************************/
        /**
         *
         * @return fioGetGrtAlt TODO_javadoc.
         *
         */
        public int getFioGetGrtAlt() {
            return Integer.parseInt(subValue(122, 126));
        }

        /*******************************************************************************************************
         * getFioFndEqlAlt
         *******************************************************************************************************/
        /**
         *
         * @return fioFndEqlAlt TODO_javadoc.
         *
         */
        public int getFioFndEqlAlt() {
            return Integer.parseInt(subValue(126, 130));
        }

        /*******************************************************************************************************
         * getFioFndFstAlt
         *******************************************************************************************************/
        /**
         *
         * @return fioFndFstAlt TODO_javadoc.
         *
         */
        public int getFioFndFstAlt() {
            return Integer.parseInt(subValue(130, 134));
        }

        /*******************************************************************************************************
         * getFioFndNlsAlt
         *******************************************************************************************************/
        /**
         *
         * @return fioFndNlsAlt TODO_javadoc.
         *
         */
        public int getFioFndNlsAlt() {
            return Integer.parseInt(subValue(134, 138));
        }

        /*******************************************************************************************************
         * getFioFndGrtAlt
         *******************************************************************************************************/
        /**
         *
         * @return fioFndGrtAlt TODO_javadoc.
         *
         */
        public int getFioFndGrtAlt() {
            return Integer.parseInt(subValue(138, 142));
        }

        /*******************************************************************************************************
         * getFioGetNxtAlt
         *******************************************************************************************************/
        /**
         *
         * @return fioGetNxtAlt TODO_javadoc.
         *
         */
        public int getFioGetNxtAlt() {
            return Integer.parseInt(subValue(142, 146));
        }

        /*******************************************************************************************************
         * getFioGetKeyUpdAlt
         *******************************************************************************************************/
        /**
         *
         * @return fioGetKeyUpdAlt TODO_javadoc.
         *
         */
        public int getFioGetKeyUpdAlt() {
            return Integer.parseInt(subValue(146, 150));
        }

        /*******************************************************************************************************
         * getFioGetKeyUpd
         *******************************************************************************************************/
        /**
         *
         * @return fioGetKeyUpd TODO_javadoc.
         *
         */
        public int getFioGetKeyUpd() {
            return Integer.parseInt(subValue(150, 154));
        }

        /*******************************************************************************************************
         * getFioEndBrw
         *******************************************************************************************************/
        /**
         *
         * @return fioEndBrw TODO_javadoc.
         *
         */
        public int getFioEndBrw() {
            return Integer.parseInt(subValue(154, 158));
        }

        /*******************************************************************************************************
         * getFioBckOut
         *******************************************************************************************************/
        /**
         *
         * @return fioBckOut TODO_javadoc.
         *
         */
        public int getFioBckOut() {
            return Integer.parseInt(subValue(158, 162));
        }

        /*******************************************************************************************************
         * getFioGetLeq
         *******************************************************************************************************/
        /**
         *
         * @return fioGetLeq TODO_javadoc.
         *
         */
        public int getFioGetLeq() {
            return Integer.parseInt(subValue(162, 166));
        }

        /*******************************************************************************************************
         * getFioGetPrv
         *******************************************************************************************************/
        /**
         *
         * @return fioGetPrv TODO_javadoc.
         *
         */
        public int getFioGetPrv() {
            return Integer.parseInt(subValue(166, 170));
        }

        /*******************************************************************************************************
         * getFioChkPnt
         *******************************************************************************************************/
        /**
         *
         * @return fioChkPnt TODO_javadoc.
         *
         */
        public int getFioChkPnt() {
            return Integer.parseInt(subValue(170, 174));
        }

        /*******************************************************************************************************
         * getFioBfrRfh
         *******************************************************************************************************/
        /**
         *
         * @return fioBfrRfh TODO_javadoc.
         *
         */
        public int getFioBfrRfh() {
            return Integer.parseInt(subValue(174, 178));
        }

        /*******************************************************************************************************
         * getFioEbrAll
         *******************************************************************************************************/
        /**
         *
         * @return fioEbrAll TODO_javadoc.
         *
         */
        public int getFioEbrAll() {
            return Integer.parseInt(subValue(178, 182));
        }

        /*******************************************************************************************************
         * getFioBegTrn
         *******************************************************************************************************/
        /**
         *
         * @return fioBegTrn TODO_javadoc.
         *
         */
        public int getFioBegTrn() {
            return Integer.parseInt(subValue(182, 186));
        }

    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class FioVcmnRed {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public FioVcmnRed() {
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
            replaceValue(10, 4106, value);
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
            return subValue(10, 10 + 4096);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setFioIdxVcmn
         *******************************************************************************************************/
        /**
         *
         * @param fioIdxVcmn TODO_javadoc.
         *
         */
        public void setFioIdxVcmn(int[] fioIdxVcmn) {

            if (fioIdxVcmn == null || fioIdxVcmn.length != 44) {
                throw new IllegalArgumentException("fioIdxVcmn[]: no debe ser nulo y largo debe ser 44");
            }

            for (int i = 0; i < 44; i++) {
                replaceValue(10 + 4 * i, 10 + 4 * (i + 1), form4z.format(fioIdxVcmn[i]));
            }
        }

        /*******************************************************************************************************
         * setFioIdxVcmn
         *******************************************************************************************************/
        /**
         *
         * @param i TODO_javadoc.
         * @param fioIdxVcmn TODO_javadoc.
         *
         */
        public void setFioIdxVcmn(int i, int fioIdxVcmn) {

            if (i < 0 || i >= 44) {
                throw new ArrayIndexOutOfBoundsException("fioIdxVcmn[]: indice debe estar en rango [0..43]");
            }

            replaceValue(10 + 4 * i, 10 + 4 * (i + 1), form4z.format(fioIdxVcmn));
        }

        /*******************************************************************************************************
         * getFioIdxVcmn
         *******************************************************************************************************/
        /**
         *
         * @param i TODO_javadoc.
         *
         * @return fioIdxVcmn TODO_javadoc.
         *
         */
        public int getFioIdxVcmn(int i) {

            if (i < 0 || i >= 44) {
                throw new ArrayIndexOutOfBoundsException("fioIdxVcmn[]: indice debe estar en rango [0..43]");
            }

            return Integer.parseInt(subValue(10 + 4 * i, 10 + 4 * (i + 1)));
        }

        /*******************************************************************************************************
         * getFioIdxVcmnSize
         *******************************************************************************************************/
        /**
         *
         * @return TODO_javadoc.
         *
         */
        public final int getFioIdxVcmnSize() {
            return 44;
        }

    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class FioMens {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public FioMens() {
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
            replaceValue(2102, 2182, value);
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
            return subValue(2102, 2102 + 80);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setFioMen1
         *******************************************************************************************************/
        /**
         *
         * @param fioMen1 TODO_javadoc.
         *
         */
        public void setFioMen1(String fioMen1) {
            replaceValue(2102, 2173, fioMen1);
        }

        /*******************************************************************************************************
         * setFioMen2
         *******************************************************************************************************/
        /**
         *
         * @param fioMen2 TODO_javadoc.
         *
         */
        public void setFioMen2(String fioMen2) {
            replaceValue(2173, 2182, fioMen2);
        }

        /*******************************************************************************************************
         * getFioMen1
         *******************************************************************************************************/
        /**
         *
         * @return fioMen1 TODO_javadoc.
         *
         */
        public String getFioMen1() {
            return subValue(2102, 2173);
        }

        /*******************************************************************************************************
         * getFioMen2
         *******************************************************************************************************/
        /**
         *
         * @return fioMen2 TODO_javadoc.
         *
         */
        public String getFioMen2() {
            return subValue(2173, 2182);
        }

    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class FioMensRed {

        /** TODO_javadoc. */
        private FioMensKeyRed fioMensKeyRed = new FioMensKeyRed();

        /** TODO_javadoc. */
        private FioMensFilRed fioMensFilRed = new FioMensFilRed();

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public FioMensRed() {
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
            replaceValue(2102, 6198, value);
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
            return subValue(2102, 2102 + 4096);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setFioMensDsc
         *******************************************************************************************************/
        /**
         *
         * @param fioMensDsc TODO_javadoc.
         *
         */
        public void setFioMensDsc(String fioMensDsc) {
            replaceValue(2102, 2115, fioMensDsc);
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
            replaceValue(2115, 2116, filler);
        }

        /*******************************************************************************************************
         * setFioMensStt
         *******************************************************************************************************/
        /**
         *
         * @param fioMensStt TODO_javadoc.
         *
         */
        public void setFioMensStt(String fioMensStt) {
            replaceValue(2116, 2118, fioMensStt);
        }

        /*******************************************************************************************************
         * setFioMensNtt
         *******************************************************************************************************/
        /**
         *
         * @param fioMensNtt TODO_javadoc.
         *
         */
        public void setFioMensNtt(int fioMensNtt) {
            replaceValue(2116, 2118, form2z.format(fioMensNtt));
        }

        /*******************************************************************************************************
         * setFioMensSst
         *******************************************************************************************************/
        /**
         *
         * @param fioMensSst TODO_javadoc.
         *
         */
        public void setFioMensSst(String fioMensSst) {
            replaceValue(2118, 2119, fioMensSst);
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
            replaceValue(2119, 2120, filler1);
        }

        /*******************************************************************************************************
         * setFioMensGky
         *******************************************************************************************************/
        /**
         *
         * @param fioMensGky TODO_javadoc.
         *
         */
        public void setFioMensGky(String fioMensGky) {
            replaceValue(2120, 2123, fioMensGky);
        }

        /*******************************************************************************************************
         * setFiller2
         *******************************************************************************************************/
        /**
         *
         * @param filler2 TODO_javadoc.
         *
         */
        public void setFiller2(String filler2) {
            replaceValue(2123, 2124, filler2);
        }

        /*******************************************************************************************************
         * setFioMensKey
         *******************************************************************************************************/
        /**
         *
         * @param fioMensKey TODO_javadoc.
         *
         */
        public void setFioMensKey(String fioMensKey) {
            replaceValue(2124, 2156, fioMensKey);
        }

        /*******************************************************************************************************
         * setFiller3
         *******************************************************************************************************/
        /**
         *
         * @param filler3 TODO_javadoc.
         *
         */
        public void setFiller3(String filler3) {
            replaceValue(2156, 2157, filler3);
        }

        /*******************************************************************************************************
         * setFioMensGcm
         *******************************************************************************************************/
        /**
         *
         * @param fioMensGcm TODO_javadoc.
         *
         */
        public void setFioMensGcm(String fioMensGcm) {
            replaceValue(2157, 2160, fioMensGcm);
        }

        /*******************************************************************************************************
         * setFiller4
         *******************************************************************************************************/
        /**
         *
         * @param filler4 TODO_javadoc.
         *
         */
        public void setFiller4(String filler4) {
            replaceValue(2160, 2161, filler4);
        }

        /*******************************************************************************************************
         * setFioMensCmd
         *******************************************************************************************************/
        /**
         *
         * @param fioMensCmd TODO_javadoc.
         *
         */
        public void setFioMensCmd(String fioMensCmd) {
            replaceValue(2161, 2166, fioMensCmd);
        }

        /*******************************************************************************************************
         * setFiller5
         *******************************************************************************************************/
        /**
         *
         * @param filler5 TODO_javadoc.
         *
         */
        public void setFiller5(String filler5) {
            replaceValue(2166, 2167, filler5);
        }

        /*******************************************************************************************************
         * setFioMensGfl
         *******************************************************************************************************/
        /**
         *
         * @param fioMensGfl TODO_javadoc.
         *
         */
        public void setFioMensGfl(String fioMensGfl) {
            replaceValue(2167, 2171, fioMensGfl);
        }

        /*******************************************************************************************************
         * setFiller6
         *******************************************************************************************************/
        /**
         *
         * @param filler6 TODO_javadoc.
         *
         */
        public void setFiller6(String filler6) {
            replaceValue(2171, 2172, filler6);
        }

        /*******************************************************************************************************
         * setFioMensFil
         *******************************************************************************************************/
        /**
         *
         * @param fioMensFil TODO_javadoc.
         *
         */
        public void setFioMensFil(String fioMensFil) {
            replaceValue(2172, 2181, fioMensFil);
        }

        /*******************************************************************************************************
         * setFiller7
         *******************************************************************************************************/
        /**
         *
         * @param filler7 TODO_javadoc.
         *
         */
        public void setFiller7(String filler7) {
            replaceValue(2181, 2182, filler7);
        }

        /*******************************************************************************************************
         * getFioMensDsc
         *******************************************************************************************************/
        /**
         *
         * @return fioMensDsc TODO_javadoc.
         *
         */
        public String getFioMensDsc() {
            return subValue(2102, 2115);
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
            return subValue(2115, 2116);
        }

        /*******************************************************************************************************
         * getFioMensStt
         *******************************************************************************************************/
        /**
         *
         * @return fioMensStt TODO_javadoc.
         *
         */
        public String getFioMensStt() {
            return subValue(2116, 2118);
        }

        /*******************************************************************************************************
         * getFioMensNtt
         *******************************************************************************************************/
        /**
         *
         * @return fioMensNtt TODO_javadoc.
         *
         */
        public int getFioMensNtt() {
            return Integer.parseInt(subValue(2116, 2118));
        }

        /*******************************************************************************************************
         * getFioMensSst
         *******************************************************************************************************/
        /**
         *
         * @return fioMensSst TODO_javadoc.
         *
         */
        public String getFioMensSst() {
            return subValue(2118, 2119);
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
            return subValue(2119, 2120);
        }

        /*******************************************************************************************************
         * getFioMensGky
         *******************************************************************************************************/
        /**
         *
         * @return fioMensGky TODO_javadoc.
         *
         */
        public String getFioMensGky() {
            return subValue(2120, 2123);
        }

        /*******************************************************************************************************
         * getFiller2
         *******************************************************************************************************/
        /**
         *
         * @return filler2 TODO_javadoc.
         *
         */
        public String getFiller2() {
            return subValue(2123, 2124);
        }

        /*******************************************************************************************************
         * getFioMensKey
         *******************************************************************************************************/
        /**
         *
         * @return fioMensKey TODO_javadoc.
         *
         */
        public String getFioMensKey() {
            return subValue(2124, 2156);
        }

        /*******************************************************************************************************
         * getFioMensKeyRed
         *******************************************************************************************************/
        /**
         *
         * @return fioMensKeyRed TODO_javadoc.
         *
         */
        public FioMensKeyRed getFioMensKeyRed() {
            return fioMensKeyRed;
        }

        /*******************************************************************************************************
         * getFiller3
         *******************************************************************************************************/
        /**
         *
         * @return filler3 TODO_javadoc.
         *
         */
        public String getFiller3() {
            return subValue(2156, 2157);
        }

        /*******************************************************************************************************
         * getFioMensGcm
         *******************************************************************************************************/
        /**
         *
         * @return fioMensGcm TODO_javadoc.
         *
         */
        public String getFioMensGcm() {
            return subValue(2157, 2160);
        }

        /*******************************************************************************************************
         * getFiller4
         *******************************************************************************************************/
        /**
         *
         * @return filler4 TODO_javadoc.
         *
         */
        public String getFiller4() {
            return subValue(2160, 2161);
        }

        /*******************************************************************************************************
         * getFioMensCmd
         *******************************************************************************************************/
        /**
         *
         * @return fioMensCmd TODO_javadoc.
         *
         */
        public String getFioMensCmd() {
            return subValue(2161, 2166);
        }

        /*******************************************************************************************************
         * getFiller5
         *******************************************************************************************************/
        /**
         *
         * @return filler5 TODO_javadoc.
         *
         */
        public String getFiller5() {
            return subValue(2166, 2167);
        }

        /*******************************************************************************************************
         * getFioMensGfl
         *******************************************************************************************************/
        /**
         *
         * @return fioMensGfl TODO_javadoc.
         *
         */
        public String getFioMensGfl() {
            return subValue(2167, 2171);
        }

        /*******************************************************************************************************
         * getFiller6
         *******************************************************************************************************/
        /**
         *
         * @return filler6 TODO_javadoc.
         *
         */
        public String getFiller6() {
            return subValue(2171, 2172);
        }

        /*******************************************************************************************************
         * getFioMensFil
         *******************************************************************************************************/
        /**
         *
         * @return fioMensFil TODO_javadoc.
         *
         */
        public String getFioMensFil() {
            return subValue(2172, 2181);
        }

        /*******************************************************************************************************
         * getFioMensFilRed
         *******************************************************************************************************/
        /**
         *
         * @return fioMensFilRed TODO_javadoc.
         *
         */
        public FioMensFilRed getFioMensFilRed() {
            return fioMensFilRed;
        }

        /*******************************************************************************************************
         * getFiller7
         *******************************************************************************************************/
        /**
         *
         * @return filler7 TODO_javadoc.
         *
         */
        public String getFiller7() {
            return subValue(2181, 2182);
        }

        /**
         *
         * TODO_javadoc.
         *
         * @author  BEE S.A.
         * @version 1.0
         *
         */
        public class FioMensKeyRed {

            /*******************************************************************************************************
             *
             *******************************************************************************************************/
            /**
             *
             */
            public FioMensKeyRed() {
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
                replaceValue(2124, 6220, value);
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
                return subValue(2124, 2124 + 4096);
            }

            //
            //
            //

            /*******************************************************************************************************
             * setFioMensKdt
             *******************************************************************************************************/
            /**
             *
             * @param fioMensKdt TODO_javadoc.
             *
             */
            public void setFioMensKdt(String fioMensKdt) {
                replaceValue(2124, 2129, fioMensKdt);
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
                replaceValue(2129, 2130, filler);
            }

            /*******************************************************************************************************
             * setFioMensGbd
             *******************************************************************************************************/
            /**
             *
             * @param fioMensGbd TODO_javadoc.
             *
             */
            public void setFioMensGbd(String fioMensGbd) {
                replaceValue(2130, 2140, fioMensGbd);
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
                replaceValue(2140, 2141, filler1);
            }

            /*******************************************************************************************************
             * setFioMensDbi
             *******************************************************************************************************/
            /**
             *
             * @param fioMensDbi TODO_javadoc.
             *
             */
            public void setFioMensDbi(String fioMensDbi) {
                replaceValue(2141, 2146, fioMensDbi);
            }

            /*******************************************************************************************************
             * setFiller2
             *******************************************************************************************************/
            /**
             *
             * @param filler2 TODO_javadoc.
             *
             */
            public void setFiller2(String filler2) {
                replaceValue(2146, 2156, filler2);
            }

            /*******************************************************************************************************
             * getFioMensKdt
             *******************************************************************************************************/
            /**
             *
             * @return fioMensKdt TODO_javadoc.
             *
             */
            public String getFioMensKdt() {
                return subValue(2124, 2129);
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
                return subValue(2129, 2130);
            }

            /*******************************************************************************************************
             * getFioMensGbd
             *******************************************************************************************************/
            /**
             *
             * @return fioMensGbd TODO_javadoc.
             *
             */
            public String getFioMensGbd() {
                return subValue(2130, 2140);
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
                return subValue(2140, 2141);
            }

            /*******************************************************************************************************
             * getFioMensDbi
             *******************************************************************************************************/
            /**
             *
             * @return fioMensDbi TODO_javadoc.
             *
             */
            public String getFioMensDbi() {
                return subValue(2141, 2146);
            }

            /*******************************************************************************************************
             * getFiller2
             *******************************************************************************************************/
            /**
             *
             * @return filler2 TODO_javadoc.
             *
             */
            public String getFiller2() {
                return subValue(2146, 2156);
            }

        }

        /**
         *
         * TODO_javadoc.
         *
         * @author  BEE S.A.
         * @version 1.0
         *
         */
        public class FioMensFilRed {

            /*******************************************************************************************************
             *
             *******************************************************************************************************/
            /**
             *
             */
            public FioMensFilRed() {
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
                replaceValue(2172, 6268, value);
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
                return subValue(2172, 2172 + 4096);
            }

            //
            //
            //

            /*******************************************************************************************************
             * setFioMensSis
             *******************************************************************************************************/
            /**
             *
             * @param fioMensSis TODO_javadoc.
             *
             */
            public void setFioMensSis(String fioMensSis) {
                replaceValue(2172, 2175, fioMensSis);
            }

            /*******************************************************************************************************
             * setFioMensReg
             *******************************************************************************************************/
            /**
             *
             * @param fioMensReg TODO_javadoc.
             *
             */
            public void setFioMensReg(String fioMensReg) {
                replaceValue(2175, 2181, fioMensReg);
            }

            /*******************************************************************************************************
             * getFioMensSis
             *******************************************************************************************************/
            /**
             *
             * @return fioMensSis TODO_javadoc.
             *
             */
            public String getFioMensSis() {
                return subValue(2172, 2175);
            }

            /*******************************************************************************************************
             * getFioMensReg
             *******************************************************************************************************/
            /**
             *
             * @return fioMensReg TODO_javadoc.
             *
             */
            public String getFioMensReg() {
                return subValue(2175, 2181);
            }

        }

    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class FioMsfl {

        /** TODO_javadoc. */
        private FioVsfl[] fioVsfl = new FioVsfl[20];

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public FioMsfl() {

            for (int i = 0; i < 20; i++) {
                fioVsfl[i] = new FioVsfl(i);
            }
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
            replaceValue(2194, 2334, value);
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
            return subValue(2194, 2194 + 140);
        }

        //
        //
        //

        /*******************************************************************************************************
         * getFioVsfl
         *******************************************************************************************************/
        /**
         *
         * @param i TODO_javadoc.
         *
         * @return fioVsfl TODO_javadoc.
         *
         */
        public FioVsfl getFioVsfl(int i) {

            if (i < 0 || i >= 20) {
                throw new ArrayIndexOutOfBoundsException("fioVsfl[]: indice debe estar en rango [0..19]");
            }

            return fioVsfl[i];
        }

        /*******************************************************************************************************
         * getFioVsflSize
         *******************************************************************************************************/
        /**
         *
         * @return TODO_javadoc.
         *
         */
        public final int getFioVsflSize() {
            return 20;
        }

        /**
         *
         * TODO_javadoc.
         *
         * @author  BEE S.A.
         * @version 1.0
         *
         */
        public class FioVsfl {

            /** TODO_javadoc. */
            private final int length_fiovsfl = 7;

            /** TODO_javadoc. */
            private int idx_fiovsfl;

            /*******************************************************************************************************
             *
             *******************************************************************************************************/
            /**
             *
             * @param idx TODO_javadoc.
             *
             */
            public FioVsfl(int idx) {

                this.idx_fiovsfl = idx;
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
                replaceValue(idx_fiovsfl * length_fiovsfl + 2194, idx_fiovsfl * length_fiovsfl + 2201, value);
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
                return subValue(idx_fiovsfl * length_fiovsfl + 2194, (idx_fiovsfl + 1) * length_fiovsfl + 2194);
            }

            //
            //
            //

            /*******************************************************************************************************
             * setFioNfil
             *******************************************************************************************************/
            /**
             *
             * @param fioNfil TODO_javadoc.
             *
             */
            public void setFioNfil(String fioNfil) {
                replaceValue(idx_fiovsfl * length_fiovsfl + 2194, idx_fiovsfl * length_fiovsfl + 2201, fioNfil);
            }

            /*******************************************************************************************************
             * getFioNfil
             *******************************************************************************************************/
            /**
             *
             * @return fioNfil TODO_javadoc.
             *
             */
            public String getFioNfil() {
                return subValue(idx_fiovsfl * length_fiovsfl + 2194, idx_fiovsfl * length_fiovsfl + 2201);
            }

        }

    }

}

