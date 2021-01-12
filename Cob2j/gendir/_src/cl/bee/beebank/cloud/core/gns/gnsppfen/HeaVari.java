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
public class HeaVari extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(HeaVari.class);

    /** TODO_javadoc. */
    private static DecimalFormat form2z = new DecimalFormat("00");

    /** TODO_javadoc. */
    private HeaSimp heaSimp = new HeaSimp();

    /** TODO_javadoc. */
    private HeaDobl heaDobl = new HeaDobl();

    /** TODO_javadoc. */
    private HeaFecDmsa heaFecDmsa = new HeaFecDmsa();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public HeaVari() {

        initBuffer(102);

        replaceValue(0, 102, "                                                                                            00 00 0000"); // HEA-VARI
        replaceValue(0, 31, "                               "); // HEA-SIMP
        replaceValue(31, 92, "                                                             "); // HEA-DOBL
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
        replaceValue(0, 102, value);
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
        return subValue(0, 102);
    }

    //
    //
    //

    /*******************************************************************************************************
     * getHeaSimp
     *******************************************************************************************************/
    /**
     *
     * @return heaSimp TODO_javadoc.
     *
     */
    public HeaSimp getHeaSimp() {
        return heaSimp;
    }

    /*******************************************************************************************************
     * getHeaDobl
     *******************************************************************************************************/
    /**
     *
     * @return heaDobl TODO_javadoc.
     *
     */
    public HeaDobl getHeaDobl() {
        return heaDobl;
    }

    /*******************************************************************************************************
     * getHeaFecDmsa
     *******************************************************************************************************/
    /**
     *
     * @return heaFecDmsa TODO_javadoc.
     *
     */
    public HeaFecDmsa getHeaFecDmsa() {
        return heaFecDmsa;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class HeaSimp {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public HeaSimp() {
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
            replaceValue(0, 31, value);
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
            return subValue(0, 31);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setHeaGlsSimp
         *******************************************************************************************************/
        /**
         *
         * @param heaGlsSimp TODO_javadoc.
         *
         */
        public void setHeaGlsSimp(String[] heaGlsSimp) {

            if (heaGlsSimp == null || heaGlsSimp.length != 31) {
                throw new IllegalArgumentException("heaGlsSimp[]: no debe ser nulo y largo debe ser 31");
            }

            for (int i = 0; i < 31; i++) {
                replaceValue(0 + 1 * i, 0 + 1 * (i + 1), heaGlsSimp[i]);
            }
        }

        /*******************************************************************************************************
         * setHeaGlsSimp
         *******************************************************************************************************/
        /**
         *
         * @param i TODO_javadoc.
         * @param heaGlsSimp TODO_javadoc.
         *
         */
        public void setHeaGlsSimp(int i, String heaGlsSimp) {

            if (i < 0 || i >= 31) {
                throw new ArrayIndexOutOfBoundsException("heaGlsSimp[]: indice debe estar en rango [0..30]");
            }

            replaceValue(0 + 1 * i, 0 + 1 * (i + 1), heaGlsSimp);
        }

        /*******************************************************************************************************
         * getHeaGlsSimp
         *******************************************************************************************************/
        /**
         *
         * @param i TODO_javadoc.
         *
         * @return heaGlsSimp TODO_javadoc.
         *
         */
        public String getHeaGlsSimp(int i) {

            if (i < 0 || i >= 31) {
                throw new ArrayIndexOutOfBoundsException("heaGlsSimp[]: indice debe estar en rango [0..30]");
            }

            return subValue(0 + 1 * i, 0 + 1 * (i + 1));
        }

        /*******************************************************************************************************
         * getHeaGlsSimpSize
         *******************************************************************************************************/
        /**
         *
         * @return TODO_javadoc.
         *
         */
        public final int getHeaGlsSimpSize() {
            return 31;
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
    public class HeaDobl {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public HeaDobl() {
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
            replaceValue(31, 92, value);
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
            return subValue(31, 31 + 61);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setHeaGlsDobl
         *******************************************************************************************************/
        /**
         *
         * @param heaGlsDobl TODO_javadoc.
         *
         */
        public void setHeaGlsDobl(String[] heaGlsDobl) {

            if (heaGlsDobl == null || heaGlsDobl.length != 61) {
                throw new IllegalArgumentException("heaGlsDobl[]: no debe ser nulo y largo debe ser 61");
            }

            for (int i = 0; i < 61; i++) {
                replaceValue(31 + 1 * i, 31 + 1 * (i + 1), heaGlsDobl[i]);
            }
        }

        /*******************************************************************************************************
         * setHeaGlsDobl
         *******************************************************************************************************/
        /**
         *
         * @param i TODO_javadoc.
         * @param heaGlsDobl TODO_javadoc.
         *
         */
        public void setHeaGlsDobl(int i, String heaGlsDobl) {

            if (i < 0 || i >= 61) {
                throw new ArrayIndexOutOfBoundsException("heaGlsDobl[]: indice debe estar en rango [0..60]");
            }

            replaceValue(31 + 1 * i, 31 + 1 * (i + 1), heaGlsDobl);
        }

        /*******************************************************************************************************
         * getHeaGlsDobl
         *******************************************************************************************************/
        /**
         *
         * @param i TODO_javadoc.
         *
         * @return heaGlsDobl TODO_javadoc.
         *
         */
        public String getHeaGlsDobl(int i) {

            if (i < 0 || i >= 61) {
                throw new ArrayIndexOutOfBoundsException("heaGlsDobl[]: indice debe estar en rango [0..60]");
            }

            return subValue(31 + 1 * i, 31 + 1 * (i + 1));
        }

        /*******************************************************************************************************
         * getHeaGlsDoblSize
         *******************************************************************************************************/
        /**
         *
         * @return TODO_javadoc.
         *
         */
        public final int getHeaGlsDoblSize() {
            return 61;
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
    public class HeaFecDmsa {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public HeaFecDmsa() {
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
            replaceValue(92, 102, value);
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
            return subValue(92, 92 + 10);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setHeaNumDmsa
         *******************************************************************************************************/
        /**
         *
         * @param heaNumDmsa TODO_javadoc.
         *
         */
        public void setHeaNumDmsa(int heaNumDmsa) {
            replaceValue(92, 94, form2z.format(heaNumDmsa));
        }

        /*******************************************************************************************************
         * setHeaGlsSla1
         *******************************************************************************************************/
        /**
         *
         * @param heaGlsSla1 TODO_javadoc.
         *
         */
        public void setHeaGlsSla1(String heaGlsSla1) {
            replaceValue(94, 95, heaGlsSla1);
        }

        /*******************************************************************************************************
         * setHeaNumMmsa
         *******************************************************************************************************/
        /**
         *
         * @param heaNumMmsa TODO_javadoc.
         *
         */
        public void setHeaNumMmsa(int heaNumMmsa) {
            replaceValue(95, 97, form2z.format(heaNumMmsa));
        }

        /*******************************************************************************************************
         * setHeaGlsSla2
         *******************************************************************************************************/
        /**
         *
         * @param heaGlsSla2 TODO_javadoc.
         *
         */
        public void setHeaGlsSla2(String heaGlsSla2) {
            replaceValue(97, 98, heaGlsSla2);
        }

        /*******************************************************************************************************
         * setHeaNumSmsa
         *******************************************************************************************************/
        /**
         *
         * @param heaNumSmsa TODO_javadoc.
         *
         */
        public void setHeaNumSmsa(int heaNumSmsa) {
            replaceValue(98, 100, form2z.format(heaNumSmsa));
        }

        /*******************************************************************************************************
         * setHeaNumAmsa
         *******************************************************************************************************/
        /**
         *
         * @param heaNumAmsa TODO_javadoc.
         *
         */
        public void setHeaNumAmsa(int heaNumAmsa) {
            replaceValue(100, 102, form2z.format(heaNumAmsa));
        }

        /*******************************************************************************************************
         * getHeaNumDmsa
         *******************************************************************************************************/
        /**
         *
         * @return heaNumDmsa TODO_javadoc.
         *
         */
        public int getHeaNumDmsa() {
            return Integer.parseInt(subValue(92, 94));
        }

        /*******************************************************************************************************
         * getHeaGlsSla1
         *******************************************************************************************************/
        /**
         *
         * @return heaGlsSla1 TODO_javadoc.
         *
         */
        public String getHeaGlsSla1() {
            return subValue(94, 95);
        }

        /*******************************************************************************************************
         * getHeaNumMmsa
         *******************************************************************************************************/
        /**
         *
         * @return heaNumMmsa TODO_javadoc.
         *
         */
        public int getHeaNumMmsa() {
            return Integer.parseInt(subValue(95, 97));
        }

        /*******************************************************************************************************
         * getHeaGlsSla2
         *******************************************************************************************************/
        /**
         *
         * @return heaGlsSla2 TODO_javadoc.
         *
         */
        public String getHeaGlsSla2() {
            return subValue(97, 98);
        }

        /*******************************************************************************************************
         * getHeaNumSmsa
         *******************************************************************************************************/
        /**
         *
         * @return heaNumSmsa TODO_javadoc.
         *
         */
        public int getHeaNumSmsa() {
            return Integer.parseInt(subValue(98, 100));
        }

        /*******************************************************************************************************
         * getHeaNumAmsa
         *******************************************************************************************************/
        /**
         *
         * @return heaNumAmsa TODO_javadoc.
         *
         */
        public int getHeaNumAmsa() {
            return Integer.parseInt(subValue(100, 102));
        }

    }

}

