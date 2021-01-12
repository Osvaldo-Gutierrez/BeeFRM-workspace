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
public class CmnVari extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(CmnVari.class);

    /** TODO_javadoc. */
    private static DecimalFormat form2z = new DecimalFormat("00");

    /** TODO_javadoc. */
    private CmnSind cmnSind = new CmnSind();

    /** TODO_javadoc. */
    private CmnIdxCcmn cmnIdxCcmn = new CmnIdxCcmn();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public CmnVari() {

        initBuffer(44);

        replaceValue(0, 44, "0000                                        "); // CMN-VARI
        replaceValue(4, 44, "                                        "); // CMN-IDX-CCMN
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
        replaceValue(0, 44, value);
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
        return subValue(0, 44);
    }

    //
    //
    //

    /*******************************************************************************************************
     * getCmnSind
     *******************************************************************************************************/
    /**
     *
     * @return cmnSind TODO_javadoc.
     *
     */
    public CmnSind getCmnSind() {
        return cmnSind;
    }

    /*******************************************************************************************************
     * getCmnIdxCcmn
     *******************************************************************************************************/
    /**
     *
     * @return cmnIdxCcmn TODO_javadoc.
     *
     */
    public CmnIdxCcmn getCmnIdxCcmn() {
        return cmnIdxCcmn;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class CmnSind {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public CmnSind() {
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
            replaceValue(0, 4, value);
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
            return subValue(0, 4);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setCmnI
         *******************************************************************************************************/
        /**
         *
         * @param cmnI TODO_javadoc.
         *
         */
        public void setCmnI(int cmnI) {
            replaceValue(0, 2, form2z.format(cmnI));
        }

        /*******************************************************************************************************
         * setCmnK
         *******************************************************************************************************/
        /**
         *
         * @param cmnK TODO_javadoc.
         *
         */
        public void setCmnK(int cmnK) {
            replaceValue(2, 4, form2z.format(cmnK));
        }

        /*******************************************************************************************************
         * getCmnI
         *******************************************************************************************************/
        /**
         *
         * @return cmnI TODO_javadoc.
         *
         */
        public int getCmnI() {
            return Integer.parseInt(subValue(0, 2));
        }

        /*******************************************************************************************************
         * getCmnK
         *******************************************************************************************************/
        /**
         *
         * @return cmnK TODO_javadoc.
         *
         */
        public int getCmnK() {
            return Integer.parseInt(subValue(2, 4));
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
    public class CmnIdxCcmn {

        /** TODO_javadoc. */
        private CmnVecCcmn[] cmnVecCcmn = new CmnVecCcmn[10];

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public CmnIdxCcmn() {

            for (int i = 0; i < 10; i++) {
                cmnVecCcmn[i] = new CmnVecCcmn(i);
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
            replaceValue(4, 44, value);
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
            return subValue(4, 4 + 40);
        }

        //
        //
        //

        /*******************************************************************************************************
         * getCmnVecCcmn
         *******************************************************************************************************/
        /**
         *
         * @param i TODO_javadoc.
         *
         * @return cmnVecCcmn TODO_javadoc.
         *
         */
        public CmnVecCcmn getCmnVecCcmn(int i) {

            if (i < 0 || i >= 10) {
                throw new ArrayIndexOutOfBoundsException("cmnVecCcmn[]: indice debe estar en rango [0..9]");
            }

            return cmnVecCcmn[i];
        }

        /*******************************************************************************************************
         * getCmnVecCcmnSize
         *******************************************************************************************************/
        /**
         *
         * @return TODO_javadoc.
         *
         */
        public final int getCmnVecCcmnSize() {
            return 10;
        }

        /**
         *
         * TODO_javadoc.
         *
         * @author  BEE S.A.
         * @version 1.0
         *
         */
        public class CmnVecCcmn {

            /** TODO_javadoc. */
            private final int length_cmnvecccmn = 4;

            /** TODO_javadoc. */
            private int idx_cmnvecccmn;

            /*******************************************************************************************************
             *
             *******************************************************************************************************/
            /**
             *
             * @param idx TODO_javadoc.
             *
             */
            public CmnVecCcmn(int idx) {

                this.idx_cmnvecccmn = idx;
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
                replaceValue(idx_cmnvecccmn * length_cmnvecccmn + 4, idx_cmnvecccmn * length_cmnvecccmn + 8, value);
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
                return subValue(idx_cmnvecccmn * length_cmnvecccmn + 4, (idx_cmnvecccmn + 1) * length_cmnvecccmn + 4);
            }

            //
            //
            //

            /*******************************************************************************************************
             * setCmnCodCcmn
             *******************************************************************************************************/
            /**
             *
             * @param cmnCodCcmn TODO_javadoc.
             *
             */
            public void setCmnCodCcmn(String cmnCodCcmn) {
                replaceValue(idx_cmnvecccmn * length_cmnvecccmn + 4, idx_cmnvecccmn * length_cmnvecccmn + 7, cmnCodCcmn);
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
                replaceValue(idx_cmnvecccmn * length_cmnvecccmn + 7, idx_cmnvecccmn * length_cmnvecccmn + 8, filler);
            }

            /*******************************************************************************************************
             * getCmnCodCcmn
             *******************************************************************************************************/
            /**
             *
             * @return cmnCodCcmn TODO_javadoc.
             *
             */
            public String getCmnCodCcmn() {
                return subValue(idx_cmnvecccmn * length_cmnvecccmn + 4, idx_cmnvecccmn * length_cmnvecccmn + 7);
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
                return subValue(idx_cmnvecccmn * length_cmnvecccmn + 7, idx_cmnvecccmn * length_cmnvecccmn + 8);
            }

        }

    }

}

