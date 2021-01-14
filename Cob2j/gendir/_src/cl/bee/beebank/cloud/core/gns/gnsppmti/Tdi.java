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
public class Tdi extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(Tdi.class);

    /** TODO_javadoc. */
    private static DecimalFormat form3z = new DecimalFormat("000");

    /** TODO_javadoc. */
    private TdiGlsData tdiGlsData = new TdiGlsData();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public Tdi() {

        initBuffer(18003);

        replaceValue(0, 18003, "000                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "); // TDI
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
        replaceValue(0, 18003, value);
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
        return subValue(0, 18003);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setTdiNumReco
     *******************************************************************************************************/
    /**
     *
     * @param tdiNumReco TODO_javadoc.
     *
     */
    public void setTdiNumReco(int tdiNumReco) {
        replaceValue(0, 3, form3z.format(tdiNumReco));
    }

    /*******************************************************************************************************
     * getTdiNumReco
     *******************************************************************************************************/
    /**
     *
     * @return tdiNumReco TODO_javadoc.
     *
     */
    public int getTdiNumReco() {
        return Integer.parseInt(subValue(0, 3));
    }

    /*******************************************************************************************************
     * getTdiGlsData
     *******************************************************************************************************/
    /**
     *
     * @return tdiGlsData TODO_javadoc.
     *
     */
    public TdiGlsData getTdiGlsData() {
        return tdiGlsData;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class TdiGlsData {

        /** TODO_javadoc. */
        private TdiGlsDesc tdiGlsDesc = new TdiGlsDesc();

        /** TODO_javadoc. */
        private TdiGlsDescRed tdiGlsDescRed = new TdiGlsDescRed();

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public TdiGlsData() {
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
            replaceValue(3, 18003, value);
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
            return subValue(3, 3 + 18000);
        }

        //
        //
        //

        /*******************************************************************************************************
         * getTdiGlsDesc
         *******************************************************************************************************/
        /**
         *
         * @return tdiGlsDesc TODO_javadoc.
         *
         */
        public TdiGlsDesc getTdiGlsDesc() {
            return tdiGlsDesc;
        }

        /*******************************************************************************************************
         * getTdiGlsDescRed
         *******************************************************************************************************/
        /**
         *
         * @return tdiGlsDescRed TODO_javadoc.
         *
         */
        public TdiGlsDescRed getTdiGlsDescRed() {
            return tdiGlsDescRed;
        }

        /**
         *
         * TODO_javadoc.
         *
         * @author  BEE S.A.
         * @version 1.0
         *
         */
        public class TdiGlsDesc {

            /*******************************************************************************************************
             *
             *******************************************************************************************************/
            /**
             *
             */
            public TdiGlsDesc() {
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
                replaceValue(3, 18003, value);
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
                return subValue(3, 3 + 18000);
            }

            //
            //
            //

            /*******************************************************************************************************
             * setTdiCodTdi
             *******************************************************************************************************/
            /**
             *
             * @param tdiCodTdi TODO_javadoc.
             *
             */
            public void setTdiCodTdi(String[] tdiCodTdi) {

                if (tdiCodTdi == null || tdiCodTdi.length != 18000) {
                    throw new IllegalArgumentException("tdiCodTdi[]: no debe ser nulo y largo debe ser 18000");
                }

                for (int i = 0; i < 18000; i++) {
                    replaceValue(3 + 1 * i, 3 + 1 * (i + 1), tdiCodTdi[i]);
                }
            }

            /*******************************************************************************************************
             * setTdiCodTdi
             *******************************************************************************************************/
            /**
             *
             * @param i TODO_javadoc.
             * @param tdiCodTdi TODO_javadoc.
             *
             */
            public void setTdiCodTdi(int i, String tdiCodTdi) {

                if (i < 0 || i >= 18000) {
                    throw new ArrayIndexOutOfBoundsException("tdiCodTdi[]: indice debe estar en rango [0..17999]");
                }

                replaceValue(3 + 1 * i, 3 + 1 * (i + 1), tdiCodTdi);
            }

            /*******************************************************************************************************
             * getTdiCodTdi
             *******************************************************************************************************/
            /**
             *
             * @param i TODO_javadoc.
             *
             * @return tdiCodTdi TODO_javadoc.
             *
             */
            public String getTdiCodTdi(int i) {

                if (i < 0 || i >= 18000) {
                    throw new ArrayIndexOutOfBoundsException("tdiCodTdi[]: indice debe estar en rango [0..17999]");
                }

                return subValue(3 + 1 * i, 3 + 1 * (i + 1));
            }

            /*******************************************************************************************************
             * getTdiCodTdiSize
             *******************************************************************************************************/
            /**
             *
             * @return TODO_javadoc.
             *
             */
            public final int getTdiCodTdiSize() {
                return 18000;
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
        public class TdiGlsDescRed {

            /*******************************************************************************************************
             *
             *******************************************************************************************************/
            /**
             *
             */
            public TdiGlsDescRed() {
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
                replaceValue(3, 4099, value);
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
                return subValue(3, 3 + 4096);
            }

            //
            //
            //

            /*******************************************************************************************************
             * setTdiGlsDesc1
             *******************************************************************************************************/
            /**
             *
             * @param tdiGlsDesc1 TODO_javadoc.
             *
             */
            public void setTdiGlsDesc1(String tdiGlsDesc1) {
                replaceValue(3, 9003, tdiGlsDesc1);
            }

            /*******************************************************************************************************
             * setTdiGlsDesc2
             *******************************************************************************************************/
            /**
             *
             * @param tdiGlsDesc2 TODO_javadoc.
             *
             */
            public void setTdiGlsDesc2(String tdiGlsDesc2) {
                replaceValue(9003, 18003, tdiGlsDesc2);
            }

            /*******************************************************************************************************
             * getTdiGlsDesc1
             *******************************************************************************************************/
            /**
             *
             * @return tdiGlsDesc1 TODO_javadoc.
             *
             */
            public String getTdiGlsDesc1() {
                return subValue(3, 9003);
            }

            /*******************************************************************************************************
             * getTdiGlsDesc2
             *******************************************************************************************************/
            /**
             *
             * @return tdiGlsDesc2 TODO_javadoc.
             *
             */
            public String getTdiGlsDesc2() {
                return subValue(9003, 18003);
            }

        }

    }

}

