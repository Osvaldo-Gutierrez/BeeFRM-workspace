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
public class Tsi extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(Tsi.class);

    /** TODO_javadoc. */
    private static DecimalFormat form3z = new DecimalFormat("000");

    /** TODO_javadoc. */
    private TsiData tsiData = new TsiData();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public Tsi() {

        initBuffer(2014);

        replaceValue(0, 2014, "000                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           "); // TSI
        replaceValue(94, 2014, "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "); // TSI-GLS-FRM-HST
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
        replaceValue(0, 2014, value);
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
        return subValue(0, 2014);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setTsiNumReco
     *******************************************************************************************************/
    /**
     *
     * @param tsiNumReco TODO_javadoc.
     *
     */
    public void setTsiNumReco(int tsiNumReco) {
        replaceValue(0, 3, form3z.format(tsiNumReco));
    }

    /*******************************************************************************************************
     * getTsiNumReco
     *******************************************************************************************************/
    /**
     *
     * @return tsiNumReco TODO_javadoc.
     *
     */
    public int getTsiNumReco() {
        return Integer.parseInt(subValue(0, 3));
    }

    /*******************************************************************************************************
     * getTsiData
     *******************************************************************************************************/
    /**
     *
     * @return tsiData TODO_javadoc.
     *
     */
    public TsiData getTsiData() {
        return tsiData;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class TsiData {

        /** TODO_javadoc. */
        private TsiGlsFrmHst tsiGlsFrmHst = new TsiGlsFrmHst();

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public TsiData() {
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
            replaceValue(3, 2014, value);
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
            return subValue(3, 3 + 2011);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setTsiCodMsje
         *******************************************************************************************************/
        /**
         *
         * @param tsiCodMsje TODO_javadoc.
         *
         */
        public void setTsiCodMsje(String tsiCodMsje) {
            replaceValue(3, 15, tsiCodMsje);
        }

        /*******************************************************************************************************
         * setTsiGlsMsje
         *******************************************************************************************************/
        /**
         *
         * @param tsiGlsMsje TODO_javadoc.
         *
         */
        public void setTsiGlsMsje(String tsiGlsMsje) {
            replaceValue(15, 94, tsiGlsMsje);
        }

        /*******************************************************************************************************
         * getTsiCodMsje
         *******************************************************************************************************/
        /**
         *
         * @return tsiCodMsje TODO_javadoc.
         *
         */
        public String getTsiCodMsje() {
            return subValue(3, 15);
        }

        /*******************************************************************************************************
         * getTsiGlsMsje
         *******************************************************************************************************/
        /**
         *
         * @return tsiGlsMsje TODO_javadoc.
         *
         */
        public String getTsiGlsMsje() {
            return subValue(15, 94);
        }

        /*******************************************************************************************************
         * getTsiGlsFrmHst
         *******************************************************************************************************/
        /**
         *
         * @return tsiGlsFrmHst TODO_javadoc.
         *
         */
        public TsiGlsFrmHst getTsiGlsFrmHst() {
            return tsiGlsFrmHst;
        }

        /**
         *
         * TODO_javadoc.
         *
         * @author  BEE S.A.
         * @version 1.0
         *
         */
        public class TsiGlsFrmHst {

            /*******************************************************************************************************
             *
             *******************************************************************************************************/
            /**
             *
             */
            public TsiGlsFrmHst() {
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
                replaceValue(94, 2014, value);
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
                return subValue(94, 94 + 1920);
            }

            //
            //
            //

            /*******************************************************************************************************
             * setTsiGlsNfrm
             *******************************************************************************************************/
            /**
             *
             * @param tsiGlsNfrm TODO_javadoc.
             *
             */
            public void setTsiGlsNfrm(String tsiGlsNfrm) {
                replaceValue(94, 106, tsiGlsNfrm);
            }

            /*******************************************************************************************************
             * setTsiCodFrmHst
             *******************************************************************************************************/
            /**
             *
             * @param tsiCodFrmHst TODO_javadoc.
             *
             */
            public void setTsiCodFrmHst(String[] tsiCodFrmHst) {

                if (tsiCodFrmHst == null || tsiCodFrmHst.length != 1908) {
                    throw new IllegalArgumentException("tsiCodFrmHst[]: no debe ser nulo y largo debe ser 1908");
                }

                for (int i = 0; i < 1908; i++) {
                    replaceValue(106 + 1 * i, 106 + 1 * (i + 1), tsiCodFrmHst[i]);
                }
            }

            /*******************************************************************************************************
             * setTsiCodFrmHst
             *******************************************************************************************************/
            /**
             *
             * @param i TODO_javadoc.
             * @param tsiCodFrmHst TODO_javadoc.
             *
             */
            public void setTsiCodFrmHst(int i, String tsiCodFrmHst) {

                if (i < 0 || i >= 1908) {
                    throw new ArrayIndexOutOfBoundsException("tsiCodFrmHst[]: indice debe estar en rango [0..1907]");
                }

                replaceValue(106 + 1 * i, 106 + 1 * (i + 1), tsiCodFrmHst);
            }

            /*******************************************************************************************************
             * getTsiGlsNfrm
             *******************************************************************************************************/
            /**
             *
             * @return tsiGlsNfrm TODO_javadoc.
             *
             */
            public String getTsiGlsNfrm() {
                return subValue(94, 106);
            }

            /*******************************************************************************************************
             * getTsiCodFrmHst
             *******************************************************************************************************/
            /**
             *
             * @param i TODO_javadoc.
             *
             * @return tsiCodFrmHst TODO_javadoc.
             *
             */
            public String getTsiCodFrmHst(int i) {

                if (i < 0 || i >= 1908) {
                    throw new ArrayIndexOutOfBoundsException("tsiCodFrmHst[]: indice debe estar en rango [0..1907]");
                }

                return subValue(106 + 1 * i, 106 + 1 * (i + 1));
            }

            /*******************************************************************************************************
             * getTsiCodFrmHstSize
             *******************************************************************************************************/
            /**
             *
             * @return TODO_javadoc.
             *
             */
            public final int getTsiCodFrmHstSize() {
                return 1908;
            }

        }

    }

}

