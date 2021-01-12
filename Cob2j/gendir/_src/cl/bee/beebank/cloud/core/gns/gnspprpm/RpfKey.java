/*
 *   Copyright (c) 2021 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.beebank.cloud.core.gns.gnspprpm;


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
public class RpfKey extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(RpfKey.class);

    /** TODO_javadoc. */
    private RpfCodDptr rpfCodDptr = new RpfCodDptr();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public RpfKey() {

        initBuffer(22);

        replaceValue(0, 22, "                      "); // RPF-KEY
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
        replaceValue(0, 22, value);
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
        return subValue(0, 22);
    }

    //
    //
    //

    /*******************************************************************************************************
     * getRpfCodDptr
     *******************************************************************************************************/
    /**
     *
     * @return rpfCodDptr TODO_javadoc.
     *
     */
    public RpfCodDptr getRpfCodDptr() {
        return rpfCodDptr;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class RpfCodDptr {

        /** TODO_javadoc. */
        private RpfCodTryc rpfCodTryc = new RpfCodTryc();

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public RpfCodDptr() {
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
            replaceValue(0, 22, value);
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
            return subValue(0, 22);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setRpfCodDpro
         *******************************************************************************************************/
        /**
         *
         * @param rpfCodDpro TODO_javadoc.
         *
         */
        public void setRpfCodDpro(String rpfCodDpro) {
            replaceValue(0, 12, rpfCodDpro);
        }

        /*******************************************************************************************************
         * setRpfCodDarc
         *******************************************************************************************************/
        /**
         *
         * @param rpfCodDarc TODO_javadoc.
         *
         */
        public void setRpfCodDarc(String rpfCodDarc) {
            replaceValue(14, 22, rpfCodDarc);
        }

        /*******************************************************************************************************
         * getRpfCodDpro
         *******************************************************************************************************/
        /**
         *
         * @return rpfCodDpro TODO_javadoc.
         *
         */
        public String getRpfCodDpro() {
            return subValue(0, 12);
        }

        /*******************************************************************************************************
         * getRpfCodTryc
         *******************************************************************************************************/
        /**
         *
         * @return rpfCodTryc TODO_javadoc.
         *
         */
        public RpfCodTryc getRpfCodTryc() {
            return rpfCodTryc;
        }

        /*******************************************************************************************************
         * getRpfCodDarc
         *******************************************************************************************************/
        /**
         *
         * @return rpfCodDarc TODO_javadoc.
         *
         */
        public String getRpfCodDarc() {
            return subValue(14, 22);
        }

        /**
         *
         * TODO_javadoc.
         *
         * @author  BEE S.A.
         * @version 1.0
         *
         */
        public class RpfCodTryc {

            /*******************************************************************************************************
             *
             *******************************************************************************************************/
            /**
             *
             */
            public RpfCodTryc() {
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
                replaceValue(12, 14, value);
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
                return subValue(12, 12 + 2);
            }

            //
            //
            //

            /*******************************************************************************************************
             * setRpfCodTreg
             *******************************************************************************************************/
            /**
             *
             * @param rpfCodTreg TODO_javadoc.
             *
             */
            public void setRpfCodTreg(String rpfCodTreg) {
                replaceValue(12, 13, rpfCodTreg);
            }

            /*******************************************************************************************************
             * setRpfCodCorr
             *******************************************************************************************************/
            /**
             *
             * @param rpfCodCorr TODO_javadoc.
             *
             */
            public void setRpfCodCorr(String rpfCodCorr) {
                replaceValue(13, 14, rpfCodCorr);
            }

            /*******************************************************************************************************
             * getRpfCodTreg
             *******************************************************************************************************/
            /**
             *
             * @return rpfCodTreg TODO_javadoc.
             *
             */
            public String getRpfCodTreg() {
                return subValue(12, 13);
            }

            /*******************************************************************************************************
             * getRpfCodCorr
             *******************************************************************************************************/
            /**
             *
             * @return rpfCodCorr TODO_javadoc.
             *
             */
            public String getRpfCodCorr() {
                return subValue(13, 14);
            }

        }

    }

}

