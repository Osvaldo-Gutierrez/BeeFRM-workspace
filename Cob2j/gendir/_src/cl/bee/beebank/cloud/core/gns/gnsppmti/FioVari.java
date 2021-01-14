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
public class FioVari extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(FioVari.class);

    /** TODO_javadoc. */
    private static DecimalFormat form1z = new DecimalFormat("0");

    /** TODO_javadoc. */
    private static DecimalFormat form4z = new DecimalFormat("0000");

    /** TODO_javadoc. */
    private static DecimalFormat form9z = new DecimalFormat("000000000");

    /** TODO_javadoc. */
    private FioStat fioStat = new FioStat();

    /** TODO_javadoc. */
    private FioVoid fioVoid = new FioVoid();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public FioVari() {

        initBuffer(80);

        replaceValue(0, 80, "                                000000000000000000000{                          "); // FIO-VARI
        replaceValue(0, 32, "                                "); // FIO-AKEY
        replaceValue(43, 47, form4z.format(0)); // FIO-CMND
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
        replaceValue(0, 80, value);
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
        return subValue(0, 80);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setFioAkey
     *******************************************************************************************************/
    /**
     *
     * @param fioAkey TODO_javadoc.
     *
     */
    public void setFioAkey(String fioAkey) {
        replaceValue(0, 32, fioAkey);
    }

    /*******************************************************************************************************
     * setFioRkey
     *******************************************************************************************************/
    /**
     *
     * @param fioRkey TODO_javadoc.
     *
     */
    public void setFioRkey(int fioRkey) {
        replaceValue(34, 43, form9z.format(fioRkey));
    }

    /*******************************************************************************************************
     * setFioCmnd
     *******************************************************************************************************/
    /**
     *
     * @param fioCmnd TODO_javadoc.
     *
     */
    public void setFioCmnd(int fioCmnd) {
        replaceValue(43, 47, form4z.format(fioCmnd));
    }

    /*******************************************************************************************************
     * setFioAccs
     *******************************************************************************************************/
    /**
     *
     * @param fioAccs TODO_javadoc.
     *
     */
    public void setFioAccs(int fioAccs) {
        replaceValue(47, 48, form1z.format(fioAccs));
    }

    /*******************************************************************************************************
     * setFioRlck
     *******************************************************************************************************/
    /**
     *
     * @param fioRlck TODO_javadoc.
     *
     */
    public void setFioRlck(int fioRlck) {
        replaceValue(48, 49, form1z.format(fioRlck));
    }

    /*******************************************************************************************************
     * setFioIfnf
     *******************************************************************************************************/
    /**
     *
     * @param fioIfnf TODO_javadoc.
     *
     */
    public void setFioIfnf(int fioIfnf) {
        replaceValue(49, 50, form1z.format(fioIfnf));
    }

    /*******************************************************************************************************
     * setFioRlen
     *******************************************************************************************************/
    /**
     *
     * @param fioRlen TODO_javadoc.
     *
     */
    public void setFioRlen(int fioRlen) {
        replaceValue(50, 54, setCompNumber(fioRlen, form4z));
    }

    /*******************************************************************************************************
     * setFioSistBkp
     *******************************************************************************************************/
    /**
     *
     * @param fioSistBkp TODO_javadoc.
     *
     */
    public void setFioSistBkp(String fioSistBkp) {
        replaceValue(62, 65, fioSistBkp);
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
        replaceValue(65, 80, filler);
    }

    /*******************************************************************************************************
     * getFioAkey
     *******************************************************************************************************/
    /**
     *
     * @return fioAkey TODO_javadoc.
     *
     */
    public String getFioAkey() {
        return subValue(0, 32);
    }

    /*******************************************************************************************************
     * getFioStat
     *******************************************************************************************************/
    /**
     *
     * @return fioStat TODO_javadoc.
     *
     */
    public FioStat getFioStat() {
        return fioStat;
    }

    /*******************************************************************************************************
     * getFioRkey
     *******************************************************************************************************/
    /**
     *
     * @return fioRkey TODO_javadoc.
     *
     */
    public int getFioRkey() {
        return Integer.parseInt(subValue(34, 43));
    }

    /*******************************************************************************************************
     * getFioCmnd
     *******************************************************************************************************/
    /**
     *
     * @return fioCmnd TODO_javadoc.
     *
     */
    public int getFioCmnd() {
        return Integer.parseInt(subValue(43, 47));
    }

    /*******************************************************************************************************
     * getFioAccs
     *******************************************************************************************************/
    /**
     *
     * @return fioAccs TODO_javadoc.
     *
     */
    public int getFioAccs() {
        return Integer.parseInt(subValue(47, 48));
    }

    /*******************************************************************************************************
     * getFioRlck
     *******************************************************************************************************/
    /**
     *
     * @return fioRlck TODO_javadoc.
     *
     */
    public int getFioRlck() {
        return Integer.parseInt(subValue(48, 49));
    }

    /*******************************************************************************************************
     * getFioIfnf
     *******************************************************************************************************/
    /**
     *
     * @return fioIfnf TODO_javadoc.
     *
     */
    public int getFioIfnf() {
        return Integer.parseInt(subValue(49, 50));
    }

    /*******************************************************************************************************
     * getFioRlen
     *******************************************************************************************************/
    /**
     *
     * @return fioRlen TODO_javadoc.
     *
     */
    public int getFioRlen() {
        return (int) getCompNumber(subValue(50, 54));
    }

    /*******************************************************************************************************
     * getFioVoid
     *******************************************************************************************************/
    /**
     *
     * @return fioVoid TODO_javadoc.
     *
     */
    public FioVoid getFioVoid() {
        return fioVoid;
    }

    /*******************************************************************************************************
     * getFioSistBkp
     *******************************************************************************************************/
    /**
     *
     * @return fioSistBkp TODO_javadoc.
     *
     */
    public String getFioSistBkp() {
        return subValue(62, 65);
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
        return subValue(65, 80);
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class FioStat {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public FioStat() {
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
            replaceValue(32, 34, value);
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
            return subValue(32, 32 + 2);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setFioStt1
         *******************************************************************************************************/
        /**
         *
         * @param fioStt1 TODO_javadoc.
         *
         */
        public void setFioStt1(int fioStt1) {
            replaceValue(32, 33, form1z.format(fioStt1));
        }

        /*******************************************************************************************************
         * setFioStt2
         *******************************************************************************************************/
        /**
         *
         * @param fioStt2 TODO_javadoc.
         *
         */
        public void setFioStt2(int fioStt2) {
            replaceValue(33, 34, form1z.format(fioStt2));
        }

        /*******************************************************************************************************
         * getFioStt1
         *******************************************************************************************************/
        /**
         *
         * @return fioStt1 TODO_javadoc.
         *
         */
        public int getFioStt1() {
            return Integer.parseInt(subValue(32, 33));
        }

        /*******************************************************************************************************
         * getFioStt2
         *******************************************************************************************************/
        /**
         *
         * @return fioStt2 TODO_javadoc.
         *
         */
        public int getFioStt2() {
            return Integer.parseInt(subValue(33, 34));
        }

        /*******************************************************************************************************
         * setFioStatCdk
         *******************************************************************************************************/
        /**
         *
         * @param fioStatCdk TODO_javadoc.
         *
         */
        public void setFioStatCdk(boolean fioStatCdk) {

            if (!fioStatCdk) {
                throw new RuntimeException("Se intento setear fioStatCdk con false.");
            }

            setValue("02");
        }

        /*******************************************************************************************************
         * isFioStatCdk
         *******************************************************************************************************/
        /**
         *
         * @return fioStatCdk TODO_javadoc.
         *
         */
        public boolean isFioStatCdk() {
            return getValue().equals("02");
        }

        /*******************************************************************************************************
         * setFioStatEof
         *******************************************************************************************************/
        /**
         *
         * @param fioStatEof TODO_javadoc.
         *
         */
        public void setFioStatEof(boolean fioStatEof) {

            if (!fioStatEof) {
                throw new RuntimeException("Se intento setear fioStatEof con false.");
            }

            setValue("10");
        }

        /*******************************************************************************************************
         * isFioStatEof
         *******************************************************************************************************/
        /**
         *
         * @return fioStatEof TODO_javadoc.
         *
         */
        public boolean isFioStatEof() {
            return getValue().equals("10");
        }

        /*******************************************************************************************************
         * setFioStatNak
         *******************************************************************************************************/
        /**
         *
         * @param fioStatNak TODO_javadoc.
         *
         */
        public void setFioStatNak(boolean fioStatNak) {

            if (!fioStatNak) {
                throw new RuntimeException("Se intento setear fioStatNak con false.");
            }

            setValue("21");
        }

        /*******************************************************************************************************
         * isFioStatNak
         *******************************************************************************************************/
        /**
         *
         * @return fioStatNak TODO_javadoc.
         *
         */
        public boolean isFioStatNak() {
            return getValue().equals("21");
        }

        /*******************************************************************************************************
         * setFioStatIky
         *******************************************************************************************************/
        /**
         *
         * @param fioStatIky TODO_javadoc.
         *
         */
        public void setFioStatIky(boolean fioStatIky) {

            if (!fioStatIky) {
                throw new RuntimeException("Se intento setear fioStatIky con false.");
            }

                throw new RuntimeException("Se intento setear fioStatIky (multivaluada).");        }

        /*******************************************************************************************************
         * isFioStatIky
         *******************************************************************************************************/
        /**
         *
         * @return fioStatIky TODO_javadoc.
         *
         */
        public boolean isFioStatIky() {
            return Arrays.binarySearch(new Object[] {  }, getValue()) >= 0;
        }

        /*******************************************************************************************************
         * setFioStatDak
         *******************************************************************************************************/
        /**
         *
         * @param fioStatDak TODO_javadoc.
         *
         */
        public void setFioStatDak(boolean fioStatDak) {

            if (!fioStatDak) {
                throw new RuntimeException("Se intento setear fioStatDak con false.");
            }

            setValue("22");
        }

        /*******************************************************************************************************
         * isFioStatDak
         *******************************************************************************************************/
        /**
         *
         * @return fioStatDak TODO_javadoc.
         *
         */
        public boolean isFioStatDak() {
            return getValue().equals("22");
        }

        /*******************************************************************************************************
         * setFioStatRnf
         *******************************************************************************************************/
        /**
         *
         * @param fioStatRnf TODO_javadoc.
         *
         */
        public void setFioStatRnf(boolean fioStatRnf) {

            if (!fioStatRnf) {
                throw new RuntimeException("Se intento setear fioStatRnf con false.");
            }

            setValue("23");
        }

        /*******************************************************************************************************
         * isFioStatRnf
         *******************************************************************************************************/
        /**
         *
         * @return fioStatRnf TODO_javadoc.
         *
         */
        public boolean isFioStatRnf() {
            return getValue().equals("23");
        }

        /*******************************************************************************************************
         * setFioStatBve
         *******************************************************************************************************/
        /**
         *
         * @param fioStatBve TODO_javadoc.
         *
         */
        public void setFioStatBve(boolean fioStatBve) {

            if (!fioStatBve) {
                throw new RuntimeException("Se intento setear fioStatBve con false.");
            }

                throw new RuntimeException("Se intento setear fioStatBve (multivaluada).");        }

        /*******************************************************************************************************
         * isFioStatBve
         *******************************************************************************************************/
        /**
         *
         * @return fioStatBve TODO_javadoc.
         *
         */
        public boolean isFioStatBve() {
            return Arrays.binarySearch(new Object[] {  }, getValue()) >= 0;
        }

        /*******************************************************************************************************
         * setFioStatOpe
         *******************************************************************************************************/
        /**
         *
         * @param fioStatOpe TODO_javadoc.
         *
         */
        public void setFioStatOpe(boolean fioStatOpe) {

            if (!fioStatOpe) {
                throw new RuntimeException("Se intento setear fioStatOpe con false.");
            }

            setValue("30");
        }

        /*******************************************************************************************************
         * isFioStatOpe
         *******************************************************************************************************/
        /**
         *
         * @return fioStatOpe TODO_javadoc.
         *
         */
        public boolean isFioStatOpe() {
            return getValue().equals("30");
        }

        /*******************************************************************************************************
         * setFioStatOde
         *******************************************************************************************************/
        /**
         *
         * @param fioStatOde TODO_javadoc.
         *
         */
        public void setFioStatOde(boolean fioStatOde) {

            if (!fioStatOde) {
                throw new RuntimeException("Se intento setear fioStatOde con false.");
            }

            setValue("90");
        }

        /*******************************************************************************************************
         * isFioStatOde
         *******************************************************************************************************/
        /**
         *
         * @return fioStatOde TODO_javadoc.
         *
         */
        public boolean isFioStatOde() {
            return getValue().equals("90");
        }

        /*******************************************************************************************************
         * setFioStatPwf
         *******************************************************************************************************/
        /**
         *
         * @param fioStatPwf TODO_javadoc.
         *
         */
        public void setFioStatPwf(boolean fioStatPwf) {

            if (!fioStatPwf) {
                throw new RuntimeException("Se intento setear fioStatPwf con false.");
            }

            setValue("91");
        }

        /*******************************************************************************************************
         * isFioStatPwf
         *******************************************************************************************************/
        /**
         *
         * @return fioStatPwf TODO_javadoc.
         *
         */
        public boolean isFioStatPwf() {
            return getValue().equals("91");
        }

        /*******************************************************************************************************
         * setFioStatLge
         *******************************************************************************************************/
        /**
         *
         * @param fioStatLge TODO_javadoc.
         *
         */
        public void setFioStatLge(boolean fioStatLge) {

            if (!fioStatLge) {
                throw new RuntimeException("Se intento setear fioStatLge con false.");
            }

            setValue("92");
        }

        /*******************************************************************************************************
         * isFioStatLge
         *******************************************************************************************************/
        /**
         *
         * @return fioStatLge TODO_javadoc.
         *
         */
        public boolean isFioStatLge() {
            return getValue().equals("92");
        }

        /*******************************************************************************************************
         * setFioStatRna
         *******************************************************************************************************/
        /**
         *
         * @param fioStatRna TODO_javadoc.
         *
         */
        public void setFioStatRna(boolean fioStatRna) {

            if (!fioStatRna) {
                throw new RuntimeException("Se intento setear fioStatRna con false.");
            }

            setValue("93");
        }

        /*******************************************************************************************************
         * isFioStatRna
         *******************************************************************************************************/
        /**
         *
         * @return fioStatRna TODO_javadoc.
         *
         */
        public boolean isFioStatRna() {
            return getValue().equals("93");
        }

        /*******************************************************************************************************
         * setFioStatNpr
         *******************************************************************************************************/
        /**
         *
         * @param fioStatNpr TODO_javadoc.
         *
         */
        public void setFioStatNpr(boolean fioStatNpr) {

            if (!fioStatNpr) {
                throw new RuntimeException("Se intento setear fioStatNpr con false.");
            }

            setValue("94");
        }

        /*******************************************************************************************************
         * isFioStatNpr
         *******************************************************************************************************/
        /**
         *
         * @return fioStatNpr TODO_javadoc.
         *
         */
        public boolean isFioStatNpr() {
            return getValue().equals("94");
        }

        /*******************************************************************************************************
         * setFioStatIfi
         *******************************************************************************************************/
        /**
         *
         * @param fioStatIfi TODO_javadoc.
         *
         */
        public void setFioStatIfi(boolean fioStatIfi) {

            if (!fioStatIfi) {
                throw new RuntimeException("Se intento setear fioStatIfi con false.");
            }

            setValue("95");
        }

        /*******************************************************************************************************
         * isFioStatIfi
         *******************************************************************************************************/
        /**
         *
         * @return fioStatIfi TODO_javadoc.
         *
         */
        public boolean isFioStatIfi() {
            return getValue().equals("95");
        }

        /*******************************************************************************************************
         * setFioStatBfi
         *******************************************************************************************************/
        /**
         *
         * @param fioStatBfi TODO_javadoc.
         *
         */
        public void setFioStatBfi(boolean fioStatBfi) {

            if (!fioStatBfi) {
                throw new RuntimeException("Se intento setear fioStatBfi con false.");
            }

            setValue("96");
        }

        /*******************************************************************************************************
         * isFioStatBfi
         *******************************************************************************************************/
        /**
         *
         * @return fioStatBfi TODO_javadoc.
         *
         */
        public boolean isFioStatBfi() {
            return getValue().equals("96");
        }

        /*******************************************************************************************************
         * setFioStatFiv
         *******************************************************************************************************/
        /**
         *
         * @param fioStatFiv TODO_javadoc.
         *
         */
        public void setFioStatFiv(boolean fioStatFiv) {

            if (!fioStatFiv) {
                throw new RuntimeException("Se intento setear fioStatFiv con false.");
            }

            setValue("97");
        }

        /*******************************************************************************************************
         * isFioStatFiv
         *******************************************************************************************************/
        /**
         *
         * @return fioStatFiv TODO_javadoc.
         *
         */
        public boolean isFioStatFiv() {
            return getValue().equals("97");
        }

        /*******************************************************************************************************
         * setFioStatFtl
         *******************************************************************************************************/
        /**
         *
         * @param fioStatFtl TODO_javadoc.
         *
         */
        public void setFioStatFtl(boolean fioStatFtl) {

            if (!fioStatFtl) {
                throw new RuntimeException("Se intento setear fioStatFtl con false.");
            }

            setValue("99");
        }

        /*******************************************************************************************************
         * isFioStatFtl
         *******************************************************************************************************/
        /**
         *
         * @return fioStatFtl TODO_javadoc.
         *
         */
        public boolean isFioStatFtl() {
            return getValue().equals("99");
        }

        /*******************************************************************************************************
         * setFioStatDmk
         *******************************************************************************************************/
        /**
         *
         * @param fioStatDmk TODO_javadoc.
         *
         */
        public void setFioStatDmk(boolean fioStatDmk) {

            if (!fioStatDmk) {
                throw new RuntimeException("Se intento setear fioStatDmk con false.");
            }

            setValue("22");
        }

        /*******************************************************************************************************
         * isFioStatDmk
         *******************************************************************************************************/
        /**
         *
         * @return fioStatDmk TODO_javadoc.
         *
         */
        public boolean isFioStatDmk() {
            return getValue().equals("22");
        }

        /*******************************************************************************************************
         * setFioStatImk
         *******************************************************************************************************/
        /**
         *
         * @param fioStatImk TODO_javadoc.
         *
         */
        public void setFioStatImk(boolean fioStatImk) {

            if (!fioStatImk) {
                throw new RuntimeException("Se intento setear fioStatImk con false.");
            }

            setValue("23");
        }

        /*******************************************************************************************************
         * isFioStatImk
         *******************************************************************************************************/
        /**
         *
         * @return fioStatImk TODO_javadoc.
         *
         */
        public boolean isFioStatImk() {
            return getValue().equals("23");
        }

        /*******************************************************************************************************
         * setFioStatSdr
         *******************************************************************************************************/
        /**
         *
         * @param fioStatSdr TODO_javadoc.
         *
         */
        public void setFioStatSdr(boolean fioStatSdr) {

            if (!fioStatSdr) {
                throw new RuntimeException("Se intento setear fioStatSdr con false.");
            }

            setValue("43");
        }

        /*******************************************************************************************************
         * isFioStatSdr
         *******************************************************************************************************/
        /**
         *
         * @return fioStatSdr TODO_javadoc.
         *
         */
        public boolean isFioStatSdr() {
            return getValue().equals("43");
        }

        /*******************************************************************************************************
         * setFioStatEcd
         *******************************************************************************************************/
        /**
         *
         * @param fioStatEcd TODO_javadoc.
         *
         */
        public void setFioStatEcd(boolean fioStatEcd) {

            if (!fioStatEcd) {
                throw new RuntimeException("Se intento setear fioStatEcd con false.");
            }

            setValue("44");
        }

        /*******************************************************************************************************
         * isFioStatEcd
         *******************************************************************************************************/
        /**
         *
         * @return fioStatEcd TODO_javadoc.
         *
         */
        public boolean isFioStatEcd() {
            return getValue().equals("44");
        }

        /*******************************************************************************************************
         * setFioStatSsi
         *******************************************************************************************************/
        /**
         *
         * @param fioStatSsi TODO_javadoc.
         *
         */
        public void setFioStatSsi(boolean fioStatSsi) {

            if (!fioStatSsi) {
                throw new RuntimeException("Se intento setear fioStatSsi con false.");
            }

            setValue("45");
        }

        /*******************************************************************************************************
         * isFioStatSsi
         *******************************************************************************************************/
        /**
         *
         * @return fioStatSsi TODO_javadoc.
         *
         */
        public boolean isFioStatSsi() {
            return getValue().equals("45");
        }

        /*******************************************************************************************************
         * setFioStatAps
         *******************************************************************************************************/
        /**
         *
         * @param fioStatAps TODO_javadoc.
         *
         */
        public void setFioStatAps(boolean fioStatAps) {

            if (!fioStatAps) {
                throw new RuntimeException("Se intento setear fioStatAps con false.");
            }

            setValue("46");
        }

        /*******************************************************************************************************
         * isFioStatAps
         *******************************************************************************************************/
        /**
         *
         * @return fioStatAps TODO_javadoc.
         *
         */
        public boolean isFioStatAps() {
            return getValue().equals("46");
        }

        /*******************************************************************************************************
         * setFioStatEci
         *******************************************************************************************************/
        /**
         *
         * @param fioStatEci TODO_javadoc.
         *
         */
        public void setFioStatEci(boolean fioStatEci) {

            if (!fioStatEci) {
                throw new RuntimeException("Se intento setear fioStatEci con false.");
            }

            setValue("47");
        }

        /*******************************************************************************************************
         * isFioStatEci
         *******************************************************************************************************/
        /**
         *
         * @return fioStatEci TODO_javadoc.
         *
         */
        public boolean isFioStatEci() {
            return getValue().equals("47");
        }

        /*******************************************************************************************************
         * setFioStatOks
         *******************************************************************************************************/
        /**
         *
         * @param fioStatOks TODO_javadoc.
         *
         */
        public void setFioStatOks(boolean fioStatOks) {

            if (!fioStatOks) {
                throw new RuntimeException("Se intento setear fioStatOks con false.");
            }

            setFioStt1(0);
        }

        /*******************************************************************************************************
         * isFioStatOks
         *******************************************************************************************************/
        /**
         *
         * @return fioStatOks TODO_javadoc.
         *
         */
        public boolean isFioStatOks() {
            return getFioStt1() == 0;
        }

        /*******************************************************************************************************
         * setFioStatAes
         *******************************************************************************************************/
        /**
         *
         * @param fioStatAes TODO_javadoc.
         *
         */
        public void setFioStatAes(boolean fioStatAes) {

            if (!fioStatAes) {
                throw new RuntimeException("Se intento setear fioStatAes con false.");
            }

            setFioStt1(1);
        }

        /*******************************************************************************************************
         * isFioStatAes
         *******************************************************************************************************/
        /**
         *
         * @return fioStatAes TODO_javadoc.
         *
         */
        public boolean isFioStatAes() {
            return getFioStt1() == 1;
        }

        /*******************************************************************************************************
         * setFioStatIks
         *******************************************************************************************************/
        /**
         *
         * @param fioStatIks TODO_javadoc.
         *
         */
        public void setFioStatIks(boolean fioStatIks) {

            if (!fioStatIks) {
                throw new RuntimeException("Se intento setear fioStatIks con false.");
            }

            setFioStt1(2);
        }

        /*******************************************************************************************************
         * isFioStatIks
         *******************************************************************************************************/
        /**
         *
         * @return fioStatIks TODO_javadoc.
         *
         */
        public boolean isFioStatIks() {
            return getFioStt1() == 2;
        }

        /*******************************************************************************************************
         * setFioStatErr
         *******************************************************************************************************/
        /**
         *
         * @param fioStatErr TODO_javadoc.
         *
         */
        public void setFioStatErr(boolean fioStatErr) {

            if (!fioStatErr) {
                throw new RuntimeException("Se intento setear fioStatErr con false.");
            }

            setFioStt1(3);
        }

        /*******************************************************************************************************
         * isFioStatErr
         *******************************************************************************************************/
        /**
         *
         * @return fioStatErr TODO_javadoc.
         *
         */
        public boolean isFioStatErr() {
            return getFioStt1() == 3;
        }

        /*******************************************************************************************************
         * setFioStatDtc
         *******************************************************************************************************/
        /**
         *
         * @param fioStatDtc TODO_javadoc.
         *
         */
        public void setFioStatDtc(boolean fioStatDtc) {

            if (!fioStatDtc) {
                throw new RuntimeException("Se intento setear fioStatDtc con false.");
            }

            setFioStt1(4);
        }

        /*******************************************************************************************************
         * isFioStatDtc
         *******************************************************************************************************/
        /**
         *
         * @return fioStatDtc TODO_javadoc.
         *
         */
        public boolean isFioStatDtc() {
            return getFioStt1() == 4;
        }

        /*******************************************************************************************************
         * setFioStatDde
         *******************************************************************************************************/
        /**
         *
         * @param fioStatDde TODO_javadoc.
         *
         */
        public void setFioStatDde(boolean fioStatDde) {

            if (!fioStatDde) {
                throw new RuntimeException("Se intento setear fioStatDde con false.");
            }

            setFioStt1(9);
        }

        /*******************************************************************************************************
         * isFioStatDde
         *******************************************************************************************************/
        /**
         *
         * @return fioStatDde TODO_javadoc.
         *
         */
        public boolean isFioStatDde() {
            return getFioStt1() == 9;
        }

        /*******************************************************************************************************
         * setFioStatNfi
         *******************************************************************************************************/
        /**
         *
         * @param fioStatNfi TODO_javadoc.
         *
         */
        public void setFioStatNfi(boolean fioStatNfi) {

            if (!fioStatNfi) {
                throw new RuntimeException("Se intento setear fioStatNfi con false.");
            }

            setFioStt2(0);
        }

        /*******************************************************************************************************
         * isFioStatNfi
         *******************************************************************************************************/
        /**
         *
         * @return fioStatNfi TODO_javadoc.
         *
         */
        public boolean isFioStatNfi() {
            return getFioStt2() == 0;
        }

        /*******************************************************************************************************
         * setFioStatSeq
         *******************************************************************************************************/
        /**
         *
         * @param fioStatSeq TODO_javadoc.
         *
         */
        public void setFioStatSeq(boolean fioStatSeq) {

            if (!fioStatSeq) {
                throw new RuntimeException("Se intento setear fioStatSeq con false.");
            }

            setFioStt2(1);
        }

        /*******************************************************************************************************
         * isFioStatSeq
         *******************************************************************************************************/
        /**
         *
         * @return fioStatSeq TODO_javadoc.
         *
         */
        public boolean isFioStatSeq() {
            return getFioStt2() == 1;
        }

        /*******************************************************************************************************
         * setFioStatDup
         *******************************************************************************************************/
        /**
         *
         * @param fioStatDup TODO_javadoc.
         *
         */
        public void setFioStatDup(boolean fioStatDup) {

            if (!fioStatDup) {
                throw new RuntimeException("Se intento setear fioStatDup con false.");
            }

            setFioStt2(2);
        }

        /*******************************************************************************************************
         * isFioStatDup
         *******************************************************************************************************/
        /**
         *
         * @return fioStatDup TODO_javadoc.
         *
         */
        public boolean isFioStatDup() {
            return getFioStt2() == 2;
        }

        /*******************************************************************************************************
         * setFioStatNcr
         *******************************************************************************************************/
        /**
         *
         * @param fioStatNcr TODO_javadoc.
         *
         */
        public void setFioStatNcr(boolean fioStatNcr) {

            if (!fioStatNcr) {
                throw new RuntimeException("Se intento setear fioStatNcr con false.");
            }

            setFioStt2(3);
        }

        /*******************************************************************************************************
         * isFioStatNcr
         *******************************************************************************************************/
        /**
         *
         * @return fioStatNcr TODO_javadoc.
         *
         */
        public boolean isFioStatNcr() {
            return getFioStt2() == 3;
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
    public class FioVoid {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public FioVoid() {
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
            replaceValue(54, 62, value);
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
            return subValue(54, 54 + 8);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setFioSist
         *******************************************************************************************************/
        /**
         *
         * @param fioSist TODO_javadoc.
         *
         */
        public void setFioSist(String fioSist) {
            replaceValue(54, 57, fioSist);
        }

        /*******************************************************************************************************
         * setFioFtyp
         *******************************************************************************************************/
        /**
         *
         * @param fioFtyp TODO_javadoc.
         *
         */
        public void setFioFtyp(String fioFtyp) {
            replaceValue(57, 58, fioFtyp);
        }

        /*******************************************************************************************************
         * setFioFnam
         *******************************************************************************************************/
        /**
         *
         * @param fioFnam TODO_javadoc.
         *
         */
        public void setFioFnam(String fioFnam) {
            replaceValue(58, 62, fioFnam);
        }

        /*******************************************************************************************************
         * getFioSist
         *******************************************************************************************************/
        /**
         *
         * @return fioSist TODO_javadoc.
         *
         */
        public String getFioSist() {
            return subValue(54, 57);
        }

        /*******************************************************************************************************
         * getFioFtyp
         *******************************************************************************************************/
        /**
         *
         * @return fioFtyp TODO_javadoc.
         *
         */
        public String getFioFtyp() {
            return subValue(57, 58);
        }

        /*******************************************************************************************************
         * getFioFnam
         *******************************************************************************************************/
        /**
         *
         * @return fioFnam TODO_javadoc.
         *
         */
        public String getFioFnam() {
            return subValue(58, 62);
        }

    }

}

