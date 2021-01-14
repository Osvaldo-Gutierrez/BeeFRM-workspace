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
public class Tso extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(Tso.class);

    /** TODO_javadoc. */
    private static DecimalFormat form3z = new DecimalFormat("000");

    /** TODO_javadoc. */
    private TsoData tsoData = new TsoData();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public Tso() {

        initBuffer(2014);

        replaceValue(0, 2014, "000                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           "); // TSO
        replaceValue(94, 2014, "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "); // TSO-GLS-FRM-HST
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
     * setTsoNumReco
     *******************************************************************************************************/
    /**
     *
     * @param tsoNumReco TODO_javadoc.
     *
     */
    public void setTsoNumReco(int tsoNumReco) {
        replaceValue(0, 3, form3z.format(tsoNumReco));
    }

    /*******************************************************************************************************
     * getTsoNumReco
     *******************************************************************************************************/
    /**
     *
     * @return tsoNumReco TODO_javadoc.
     *
     */
    public int getTsoNumReco() {
        return Integer.parseInt(subValue(0, 3));
    }

    /*******************************************************************************************************
     * getTsoData
     *******************************************************************************************************/
    /**
     *
     * @return tsoData TODO_javadoc.
     *
     */
    public TsoData getTsoData() {
        return tsoData;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class TsoData {

        /** TODO_javadoc. */
        private TsoMsje tsoMsje = new TsoMsje();

        /** TODO_javadoc. */
        private TsoGlsFrmHst tsoGlsFrmHst = new TsoGlsFrmHst();

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public TsoData() {
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
         * getTsoMsje
         *******************************************************************************************************/
        /**
         *
         * @return tsoMsje TODO_javadoc.
         *
         */
        public TsoMsje getTsoMsje() {
            return tsoMsje;
        }

        /*******************************************************************************************************
         * getTsoGlsFrmHst
         *******************************************************************************************************/
        /**
         *
         * @return tsoGlsFrmHst TODO_javadoc.
         *
         */
        public TsoGlsFrmHst getTsoGlsFrmHst() {
            return tsoGlsFrmHst;
        }

        /**
         *
         * TODO_javadoc.
         *
         * @author  BEE S.A.
         * @version 1.0
         *
         */
        public class TsoMsje {

            /*******************************************************************************************************
             *
             *******************************************************************************************************/
            /**
             *
             */
            public TsoMsje() {
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
                replaceValue(3, 94, value);
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
                return subValue(3, 3 + 91);
            }

            //
            //
            //

            /*******************************************************************************************************
             * setTsoCodMsje
             *******************************************************************************************************/
            /**
             *
             * @param tsoCodMsje TODO_javadoc.
             *
             */
            public void setTsoCodMsje(String tsoCodMsje) {
                replaceValue(3, 15, tsoCodMsje);
            }

            /*******************************************************************************************************
             * setTsoGlsMsje
             *******************************************************************************************************/
            /**
             *
             * @param tsoGlsMsje TODO_javadoc.
             *
             */
            public void setTsoGlsMsje(String tsoGlsMsje) {
                replaceValue(15, 94, tsoGlsMsje);
            }

            /*******************************************************************************************************
             * getTsoCodMsje
             *******************************************************************************************************/
            /**
             *
             * @return tsoCodMsje TODO_javadoc.
             *
             */
            public String getTsoCodMsje() {
                return subValue(3, 15);
            }

            /*******************************************************************************************************
             * getTsoGlsMsje
             *******************************************************************************************************/
            /**
             *
             * @return tsoGlsMsje TODO_javadoc.
             *
             */
            public String getTsoGlsMsje() {
                return subValue(15, 94);
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
        public class TsoGlsFrmHst {

            /*******************************************************************************************************
             *
             *******************************************************************************************************/
            /**
             *
             */
            public TsoGlsFrmHst() {
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
             * setTsoCodFrmHst
             *******************************************************************************************************/
            /**
             *
             * @param tsoCodFrmHst TODO_javadoc.
             *
             */
            public void setTsoCodFrmHst(String[] tsoCodFrmHst) {

                if (tsoCodFrmHst == null || tsoCodFrmHst.length != 1920) {
                    throw new IllegalArgumentException("tsoCodFrmHst[]: no debe ser nulo y largo debe ser 1920");
                }

                for (int i = 0; i < 1920; i++) {
                    replaceValue(94 + 1 * i, 94 + 1 * (i + 1), tsoCodFrmHst[i]);
                }
            }

            /*******************************************************************************************************
             * setTsoCodFrmHst
             *******************************************************************************************************/
            /**
             *
             * @param i TODO_javadoc.
             * @param tsoCodFrmHst TODO_javadoc.
             *
             */
            public void setTsoCodFrmHst(int i, String tsoCodFrmHst) {

                if (i < 0 || i >= 1920) {
                    throw new ArrayIndexOutOfBoundsException("tsoCodFrmHst[]: indice debe estar en rango [0..1919]");
                }

                replaceValue(94 + 1 * i, 94 + 1 * (i + 1), tsoCodFrmHst);
            }

            /*******************************************************************************************************
             * getTsoCodFrmHst
             *******************************************************************************************************/
            /**
             *
             * @param i TODO_javadoc.
             *
             * @return tsoCodFrmHst TODO_javadoc.
             *
             */
            public String getTsoCodFrmHst(int i) {

                if (i < 0 || i >= 1920) {
                    throw new ArrayIndexOutOfBoundsException("tsoCodFrmHst[]: indice debe estar en rango [0..1919]");
                }

                return subValue(94 + 1 * i, 94 + 1 * (i + 1));
            }

            /*******************************************************************************************************
             * getTsoCodFrmHstSize
             *******************************************************************************************************/
            /**
             *
             * @return TODO_javadoc.
             *
             */
            public final int getTsoCodFrmHstSize() {
                return 1920;
            }

        }

    }

}

