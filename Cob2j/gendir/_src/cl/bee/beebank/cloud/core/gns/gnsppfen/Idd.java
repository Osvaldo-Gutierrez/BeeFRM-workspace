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
public class Idd extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(Idd.class);

    /** TODO_javadoc. */
    private IddGlsFsis iddGlsFsis = new IddGlsFsis();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public Idd() {

        initBuffer(490);

        replaceValue(0, 490, "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          "); // IDD
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
        replaceValue(0, 490, value);
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
        return subValue(0, 490);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setIddGlsFlag
     *******************************************************************************************************/
    /**
     *
     * @param iddGlsFlag TODO_javadoc.
     *
     */
    public void setIddGlsFlag(String iddGlsFlag) {
        replaceValue(0, 1, iddGlsFlag);
    }

    /*******************************************************************************************************
     * setIddCodCidd
     *******************************************************************************************************/
    /**
     *
     * @param iddCodCidd TODO_javadoc.
     *
     */
    public void setIddCodCidd(String iddCodCidd) {
        replaceValue(1, 13, iddCodCidd);
    }

    /*******************************************************************************************************
     * setIddGlsDisp
     *******************************************************************************************************/
    /**
     *
     * @param iddGlsDisp TODO_javadoc.
     *
     */
    public void setIddGlsDisp(String iddGlsDisp) {
        replaceValue(486, 490, iddGlsDisp);
    }

    /*******************************************************************************************************
     * getIddGlsFlag
     *******************************************************************************************************/
    /**
     *
     * @return iddGlsFlag TODO_javadoc.
     *
     */
    public String getIddGlsFlag() {
        return subValue(0, 1);
    }

    /*******************************************************************************************************
     * getIddCodCidd
     *******************************************************************************************************/
    /**
     *
     * @return iddCodCidd TODO_javadoc.
     *
     */
    public String getIddCodCidd() {
        return subValue(1, 13);
    }

    /*******************************************************************************************************
     * getIddGlsFsis
     *******************************************************************************************************/
    /**
     *
     * @return iddGlsFsis TODO_javadoc.
     *
     */
    public IddGlsFsis getIddGlsFsis() {
        return iddGlsFsis;
    }

    /*******************************************************************************************************
     * getIddGlsDisp
     *******************************************************************************************************/
    /**
     *
     * @return iddGlsDisp TODO_javadoc.
     *
     */
    public String getIddGlsDisp() {
        return subValue(486, 490);
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class IddGlsFsis {

        /** TODO_javadoc. */
        private IddGlsVsis[] iddGlsVsis = new IddGlsVsis[43];

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public IddGlsFsis() {

            for (int i = 0; i < 43; i++) {
                iddGlsVsis[i] = new IddGlsVsis(i);
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
            replaceValue(13, 486, value);
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
            return subValue(13, 13 + 473);
        }

        //
        //
        //

        /*******************************************************************************************************
         * getIddGlsVsis
         *******************************************************************************************************/
        /**
         *
         * @param i TODO_javadoc.
         *
         * @return iddGlsVsis TODO_javadoc.
         *
         */
        public IddGlsVsis getIddGlsVsis(int i) {

            if (i < 0 || i >= 43) {
                throw new ArrayIndexOutOfBoundsException("iddGlsVsis[]: indice debe estar en rango [0..42]");
            }

            return iddGlsVsis[i];
        }

        /*******************************************************************************************************
         * getIddGlsVsisSize
         *******************************************************************************************************/
        /**
         *
         * @return TODO_javadoc.
         *
         */
        public final int getIddGlsVsisSize() {
            return 43;
        }

        /**
         *
         * TODO_javadoc.
         *
         * @author  BEE S.A.
         * @version 1.0
         *
         */
        public class IddGlsVsis {

            /** TODO_javadoc. */
            private final int length_iddglsvsis = 11;

            /** TODO_javadoc. */
            private int idx_iddglsvsis;

            /** TODO_javadoc. */
            private IddGlsDent iddGlsDent = new IddGlsDent();

            /*******************************************************************************************************
             *
             *******************************************************************************************************/
            /**
             *
             * @param idx TODO_javadoc.
             *
             */
            public IddGlsVsis(int idx) {

                this.idx_iddglsvsis = idx;
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
                replaceValue(idx_iddglsvsis * length_iddglsvsis + 13, idx_iddglsvsis * length_iddglsvsis + 24, value);
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
                return subValue(idx_iddglsvsis * length_iddglsvsis + 13, (idx_iddglsvsis + 1) * length_iddglsvsis + 13);
            }

            //
            //
            //

            /*******************************************************************************************************
             * setIddCodTent
             *******************************************************************************************************/
            /**
             *
             * @param iddCodTent TODO_javadoc.
             *
             */
            public void setIddCodTent(String iddCodTent) {
                replaceValue(idx_iddglsvsis * length_iddglsvsis + 20, idx_iddglsvsis * length_iddglsvsis + 21, iddCodTent);
            }

            /*******************************************************************************************************
             * setIddCodIent
             *******************************************************************************************************/
            /**
             *
             * @param iddCodIent TODO_javadoc.
             *
             */
            public void setIddCodIent(String iddCodIent) {
                replaceValue(idx_iddglsvsis * length_iddglsvsis + 21, idx_iddglsvsis * length_iddglsvsis + 24, iddCodIent);
            }

            /*******************************************************************************************************
             * getIddGlsDent
             *******************************************************************************************************/
            /**
             *
             * @return iddGlsDent TODO_javadoc.
             *
             */
            public IddGlsDent getIddGlsDent() {
                return iddGlsDent;
            }

            /*******************************************************************************************************
             * getIddCodTent
             *******************************************************************************************************/
            /**
             *
             * @return iddCodTent TODO_javadoc.
             *
             */
            public String getIddCodTent() {
                return subValue(idx_iddglsvsis * length_iddglsvsis + 20, idx_iddglsvsis * length_iddglsvsis + 21);
            }

            /*******************************************************************************************************
             * getIddCodIent
             *******************************************************************************************************/
            /**
             *
             * @return iddCodIent TODO_javadoc.
             *
             */
            public String getIddCodIent() {
                return subValue(idx_iddglsvsis * length_iddglsvsis + 21, idx_iddglsvsis * length_iddglsvsis + 24);
            }

            /**
             *
             * TODO_javadoc.
             *
             * @author  BEE S.A.
             * @version 1.0
             *
             */
            public class IddGlsDent {

                /*******************************************************************************************************
                 *
                 *******************************************************************************************************/
                /**
                 *
                 */
                public IddGlsDent() {
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
                    replaceValue(idx_iddglsvsis * length_iddglsvsis + 13, idx_iddglsvsis * length_iddglsvsis + 20, value);
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
                    return subValue(idx_iddglsvsis * length_iddglsvsis + 13, (idx_iddglsvsis + 1) * length_iddglsvsis + 13);
                }

                //
                //
                //

                /*******************************************************************************************************
                 * setIddCodSist
                 *******************************************************************************************************/
                /**
                 *
                 * @param iddCodSist TODO_javadoc.
                 *
                 */
                public void setIddCodSist(String iddCodSist) {
                    replaceValue(idx_iddglsvsis * length_iddglsvsis + 13, idx_iddglsvsis * length_iddglsvsis + 16, iddCodSist);
                }

                /*******************************************************************************************************
                 * setIddCodGrpo
                 *******************************************************************************************************/
                /**
                 *
                 * @param iddCodGrpo TODO_javadoc.
                 *
                 */
                public void setIddCodGrpo(String iddCodGrpo) {
                    replaceValue(idx_iddglsvsis * length_iddglsvsis + 16, idx_iddglsvsis * length_iddglsvsis + 17, iddCodGrpo);
                }

                /*******************************************************************************************************
                 * setIddCodRgst
                 *******************************************************************************************************/
                /**
                 *
                 * @param iddCodRgst TODO_javadoc.
                 *
                 */
                public void setIddCodRgst(String iddCodRgst) {
                    replaceValue(idx_iddglsvsis * length_iddglsvsis + 17, idx_iddglsvsis * length_iddglsvsis + 20, iddCodRgst);
                }

                /*******************************************************************************************************
                 * getIddCodSist
                 *******************************************************************************************************/
                /**
                 *
                 * @return iddCodSist TODO_javadoc.
                 *
                 */
                public String getIddCodSist() {
                    return subValue(idx_iddglsvsis * length_iddglsvsis + 13, idx_iddglsvsis * length_iddglsvsis + 16);
                }

                /*******************************************************************************************************
                 * getIddCodGrpo
                 *******************************************************************************************************/
                /**
                 *
                 * @return iddCodGrpo TODO_javadoc.
                 *
                 */
                public String getIddCodGrpo() {
                    return subValue(idx_iddglsvsis * length_iddglsvsis + 16, idx_iddglsvsis * length_iddglsvsis + 17);
                }

                /*******************************************************************************************************
                 * getIddCodRgst
                 *******************************************************************************************************/
                /**
                 *
                 * @return iddCodRgst TODO_javadoc.
                 *
                 */
                public String getIddCodRgst() {
                    return subValue(idx_iddglsvsis * length_iddglsvsis + 17, idx_iddglsvsis * length_iddglsvsis + 20);
                }

            }

        }

    }

}

