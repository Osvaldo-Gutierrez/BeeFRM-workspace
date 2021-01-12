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
public class NumVari extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(NumVari.class);

    /** TODO_javadoc. */
    private static DecimalFormat form1z = new DecimalFormat("0");

    /** TODO_javadoc. */
    private static DecimalFormat form2z = new DecimalFormat("00");

    /** TODO_javadoc. */
    private static DecimalFormat form5z = new DecimalFormat("00000");

    /** TODO_javadoc. */
    private static DecimalFormat form13z = new DecimalFormat("0000000000000");

    /** TODO_javadoc. */
    private static DecimalFormat form18z = new DecimalFormat("000000000000000000");

    /** TODO_javadoc. */
    private NumCndv numCndv = new NumCndv();

    /** TODO_javadoc. */
    private NumNumv numNumv = new NumNumv();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public NumVari() {

        initBuffer(130);

        replaceValue(0, 130, "                         00000000                                                                               00000000000000000{"); // NUM-VARI
        replaceValue(25, 27, form2z.format(0)); // NUM-NENT
        replaceValue(27, 29, form2z.format(0)); // NUM-NDCM
        replaceValue(29, 30, form1z.format(0)); // NUM-ZERO
        replaceValue(30, 31, form1z.format(0)); // NUM-SGNO
        replaceValue(31, 33, form2z.format(0)); // NUM-STAT
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
        replaceValue(0, 130, value);
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
        return subValue(0, 130);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setNumNume
     *******************************************************************************************************/
    /**
     *
     * @param numNume TODO_javadoc.
     *
     */
    public void setNumNume(String numNume) {
        replaceValue(0, 25, numNume);
    }

    /*******************************************************************************************************
     * setNumStat
     *******************************************************************************************************/
    /**
     *
     * @param numStat TODO_javadoc.
     *
     */
    public void setNumStat(int numStat) {
        replaceValue(31, 33, form2z.format(numStat));
    }

    /*******************************************************************************************************
     * setNumMens
     *******************************************************************************************************/
    /**
     *
     * @param numMens TODO_javadoc.
     *
     */
    public void setNumMens(String numMens) {
        replaceValue(33, 112, numMens);
    }

    /*******************************************************************************************************
     * getNumNume
     *******************************************************************************************************/
    /**
     *
     * @return numNume TODO_javadoc.
     *
     */
    public String getNumNume() {
        return subValue(0, 25);
    }

    /*******************************************************************************************************
     * getNumCndv
     *******************************************************************************************************/
    /**
     *
     * @return numCndv TODO_javadoc.
     *
     */
    public NumCndv getNumCndv() {
        return numCndv;
    }

    /*******************************************************************************************************
     * getNumStat
     *******************************************************************************************************/
    /**
     *
     * @return numStat TODO_javadoc.
     *
     */
    public int getNumStat() {
        return Integer.parseInt(subValue(31, 33));
    }

    /*******************************************************************************************************
     * getNumMens
     *******************************************************************************************************/
    /**
     *
     * @return numMens TODO_javadoc.
     *
     */
    public String getNumMens() {
        return subValue(33, 112);
    }

    /*******************************************************************************************************
     * getNumNumv
     *******************************************************************************************************/
    /**
     *
     * @return numNumv TODO_javadoc.
     *
     */
    public NumNumv getNumNumv() {
        return numNumv;
    }

    /*******************************************************************************************************
     * setNumStatOks
     *******************************************************************************************************/
    /**
     *
     * @param numStatOks TODO_javadoc.
     *
     */
    public void setNumStatOks(boolean numStatOks) {

        if (!numStatOks) {
            throw new RuntimeException("Se intento setear numStatOks con false.");
        }

        setNumStat(0);
    }

    /*******************************************************************************************************
     * isNumStatOks
     *******************************************************************************************************/
    /**
     *
     * @return numStatOks TODO_javadoc.
     *
     */
    public boolean isNumStatOks() {
        return getNumStat() == 0;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class NumCndv {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public NumCndv() {
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
            replaceValue(25, 31, value);
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
            return subValue(25, 25 + 6);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setNumNent
         *******************************************************************************************************/
        /**
         *
         * @param numNent TODO_javadoc.
         *
         */
        public void setNumNent(int numNent) {
            replaceValue(25, 27, form2z.format(numNent));
        }

        /*******************************************************************************************************
         * setNumNdcm
         *******************************************************************************************************/
        /**
         *
         * @param numNdcm TODO_javadoc.
         *
         */
        public void setNumNdcm(int numNdcm) {
            replaceValue(27, 29, form2z.format(numNdcm));
        }

        /*******************************************************************************************************
         * setNumZero
         *******************************************************************************************************/
        /**
         *
         * @param numZero TODO_javadoc.
         *
         */
        public void setNumZero(int numZero) {
            replaceValue(29, 30, form1z.format(numZero));
        }

        /*******************************************************************************************************
         * setNumSgno
         *******************************************************************************************************/
        /**
         *
         * @param numSgno TODO_javadoc.
         *
         */
        public void setNumSgno(int numSgno) {
            replaceValue(30, 31, form1z.format(numSgno));
        }

        /*******************************************************************************************************
         * getNumNent
         *******************************************************************************************************/
        /**
         *
         * @return numNent TODO_javadoc.
         *
         */
        public int getNumNent() {
            return Integer.parseInt(subValue(25, 27));
        }

        /*******************************************************************************************************
         * getNumNdcm
         *******************************************************************************************************/
        /**
         *
         * @return numNdcm TODO_javadoc.
         *
         */
        public int getNumNdcm() {
            return Integer.parseInt(subValue(27, 29));
        }

        /*******************************************************************************************************
         * getNumZero
         *******************************************************************************************************/
        /**
         *
         * @return numZero TODO_javadoc.
         *
         */
        public int getNumZero() {
            return Integer.parseInt(subValue(29, 30));
        }

        /*******************************************************************************************************
         * getNumSgno
         *******************************************************************************************************/
        /**
         *
         * @return numSgno TODO_javadoc.
         *
         */
        public int getNumSgno() {
            return Integer.parseInt(subValue(30, 31));
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
    public class NumNumv {

        /** TODO_javadoc. */
        private NumRed4 numRed4 = new NumRed4();

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public NumNumv() {
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
            replaceValue(112, 130, value);
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
            return subValue(112, 112 + 18);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setNumNs9v
         *******************************************************************************************************/
        /**
         *
         * @param numNs9v TODO_javadoc.
         *
         */
        public void setNumNs9v(double numNs9v) {
            setNumNs9v(numNs9v, TRUNCATED);
        }

        /*******************************************************************************************************
         * setNumNs9v
         *******************************************************************************************************/
        /**
         *
         * @param numNs9v TODO_javadoc.
         * @param rounded TODO_javadoc.
         *
         */
        public void setNumNs9v(double numNs9v, boolean rounded) {
            replaceValue(112, 130, setCompNumber((long) (rounded ? Math.round(numNs9v * Math.pow(10, 5)) : numNs9v * Math.pow(10, 5)), form18z));
        }

        /*******************************************************************************************************
         * setNumNs9n
         *******************************************************************************************************/
        /**
         *
         * @param numNs9n TODO_javadoc.
         *
         */
        public void setNumNs9n(double numNs9n) {
            setNumNs9n(numNs9n, TRUNCATED);
        }

        /*******************************************************************************************************
         * setNumNs9n
         *******************************************************************************************************/
        /**
         *
         * @param numNs9n TODO_javadoc.
         * @param rounded TODO_javadoc.
         *
         */
        public void setNumNs9n(double numNs9n, boolean rounded) {
            replaceValue(112, 130, setCompNumber((long) (rounded ? Math.round(numNs9n * Math.pow(10, 5)) : numNs9n * Math.pow(10, 5)), form18z));
        }

        /*******************************************************************************************************
         * setNumNn9v
         *******************************************************************************************************/
        /**
         *
         * @param numNn9v TODO_javadoc.
         *
         */
        public void setNumNn9v(double numNn9v) {
            setNumNn9v(numNn9v, TRUNCATED);
        }

        /*******************************************************************************************************
         * setNumNn9v
         *******************************************************************************************************/
        /**
         *
         * @param numNn9v TODO_javadoc.
         * @param rounded TODO_javadoc.
         *
         */
        public void setNumNn9v(double numNn9v, boolean rounded) {
            replaceValue(112, 130, setCompNumber((long) (rounded ? Math.round(numNn9v * Math.pow(10, 5)) : numNn9v * Math.pow(10, 5)), form18z));
        }

        /*******************************************************************************************************
         * setNumNn9n
         *******************************************************************************************************/
        /**
         *
         * @param numNn9n TODO_javadoc.
         *
         */
        public void setNumNn9n(double numNn9n) {
            setNumNn9n(numNn9n, TRUNCATED);
        }

        /*******************************************************************************************************
         * setNumNn9n
         *******************************************************************************************************/
        /**
         *
         * @param numNn9n TODO_javadoc.
         * @param rounded TODO_javadoc.
         *
         */
        public void setNumNn9n(double numNn9n, boolean rounded) {
            replaceValue(112, 130, setCompNumber((long) (rounded ? Math.round(numNn9n * Math.pow(10, 5)) : numNn9n * Math.pow(10, 5)), form18z));
        }

        /*******************************************************************************************************
         * getNumNs9v
         *******************************************************************************************************/
        /**
         *
         * @return numNs9v TODO_javadoc.
         *
         */
        public double getNumNs9v() {
            return getCompNumber(subValue(112, 130)) / Math.pow(10, 5);
        }

        /*******************************************************************************************************
         * getNumRed4
         *******************************************************************************************************/
        /**
         *
         * @return numRed4 TODO_javadoc.
         *
         */
        public NumRed4 getNumRed4() {
            return numRed4;
        }

        /*******************************************************************************************************
         * getNumNs9n
         *******************************************************************************************************/
        /**
         *
         * @return numNs9n TODO_javadoc.
         *
         */
        public double getNumNs9n() {
            return getCompNumber(subValue(112, 130)) / Math.pow(10, 5);
        }

        /*******************************************************************************************************
         * getNumNn9v
         *******************************************************************************************************/
        /**
         *
         * @return numNn9v TODO_javadoc.
         *
         */
        public double getNumNn9v() {
            return getCompNumber(subValue(112, 130)) / Math.pow(10, 5);
        }

        /*******************************************************************************************************
         * getNumNn9n
         *******************************************************************************************************/
        /**
         *
         * @return numNn9n TODO_javadoc.
         *
         */
        public double getNumNn9n() {
            return getCompNumber(subValue(112, 130)) / Math.pow(10, 5);
        }

        /**
         *
         * TODO_javadoc.
         *
         * @author  BEE S.A.
         * @version 1.0
         *
         */
        public class NumRed4 {

            /*******************************************************************************************************
             *
             *******************************************************************************************************/
            /**
             *
             */
            public NumRed4() {
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
                replaceValue(112, 4208, value);
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
                return subValue(112, 112 + 4096);
            }

            //
            //
            //

            /*******************************************************************************************************
             * setNumPent
             *******************************************************************************************************/
            /**
             *
             * @param numPent TODO_javadoc.
             *
             */
            public void setNumPent(long numPent) {
                replaceValue(112, 125, form13z.format(numPent));
            }

            /*******************************************************************************************************
             * setNumPentRed
             *******************************************************************************************************/
            /**
             *
             * @param numPentRed TODO_javadoc.
             *
             */
            public void setNumPentRed(String[] numPentRed) {

                if (numPentRed == null || numPentRed.length != 13) {
                    throw new IllegalArgumentException("numPentRed[]: no debe ser nulo y largo debe ser 13");
                }

                for (int i = 0; i < 13; i++) {
                    replaceValue(112 + 1 * i, 112 + 1 * (i + 1), numPentRed[i]);
                }
            }

            /*******************************************************************************************************
             * setNumPentRed
             *******************************************************************************************************/
            /**
             *
             * @param i TODO_javadoc.
             * @param numPentRed TODO_javadoc.
             *
             */
            public void setNumPentRed(int i, String numPentRed) {

                if (i < 0 || i >= 13) {
                    throw new ArrayIndexOutOfBoundsException("numPentRed[]: indice debe estar en rango [0..12]");
                }

                replaceValue(112 + 1 * i, 112 + 1 * (i + 1), numPentRed);
            }

            /*******************************************************************************************************
             * setNumPdcm
             *******************************************************************************************************/
            /**
             *
             * @param numPdcm TODO_javadoc.
             *
             */
            public void setNumPdcm(double numPdcm) {
                setNumPdcm(numPdcm, TRUNCATED);
            }

            /*******************************************************************************************************
             * setNumPdcm
             *******************************************************************************************************/
            /**
             *
             * @param numPdcm TODO_javadoc.
             * @param rounded TODO_javadoc.
             *
             */
            public void setNumPdcm(double numPdcm, boolean rounded) {
                replaceValue(125, 130, form5z.format((long) (numPdcm * Math.pow(10, 5))));
            }

            /*******************************************************************************************************
             * setNumPdcmRed
             *******************************************************************************************************/
            /**
             *
             * @param numPdcmRed TODO_javadoc.
             *
             */
            public void setNumPdcmRed(String[] numPdcmRed) {

                if (numPdcmRed == null || numPdcmRed.length != 5) {
                    throw new IllegalArgumentException("numPdcmRed[]: no debe ser nulo y largo debe ser 5");
                }

                for (int i = 0; i < 5; i++) {
                    replaceValue(125 + 1 * i, 125 + 1 * (i + 1), numPdcmRed[i]);
                }
            }

            /*******************************************************************************************************
             * setNumPdcmRed
             *******************************************************************************************************/
            /**
             *
             * @param i TODO_javadoc.
             * @param numPdcmRed TODO_javadoc.
             *
             */
            public void setNumPdcmRed(int i, String numPdcmRed) {

                if (i < 0 || i >= 5) {
                    throw new ArrayIndexOutOfBoundsException("numPdcmRed[]: indice debe estar en rango [0..4]");
                }

                replaceValue(125 + 1 * i, 125 + 1 * (i + 1), numPdcmRed);
            }

            /*******************************************************************************************************
             * getNumPent
             *******************************************************************************************************/
            /**
             *
             * @return numPent TODO_javadoc.
             *
             */
            public long getNumPent() {
                return Long.parseLong(subValue(112, 125));
            }

            /*******************************************************************************************************
             * getNumPentRed
             *******************************************************************************************************/
            /**
             *
             * @param i TODO_javadoc.
             *
             * @return numPentRed TODO_javadoc.
             *
             */
            public String getNumPentRed(int i) {

                if (i < 0 || i >= 13) {
                    throw new ArrayIndexOutOfBoundsException("numPentRed[]: indice debe estar en rango [0..12]");
                }

                return subValue(112 + 1 * i, 112 + 1 * (i + 1));
            }

            /*******************************************************************************************************
             * getNumPentRedSize
             *******************************************************************************************************/
            /**
             *
             * @return TODO_javadoc.
             *
             */
            public final int getNumPentRedSize() {
                return 13;
            }

            /*******************************************************************************************************
             * getNumPdcm
             *******************************************************************************************************/
            /**
             *
             * @return numPdcm TODO_javadoc.
             *
             */
            public double getNumPdcm() {
                return Long.parseLong(subValue(125, 130)) / Math.pow(10, 5);
            }

            /*******************************************************************************************************
             * getNumPdcmRed
             *******************************************************************************************************/
            /**
             *
             * @param i TODO_javadoc.
             *
             * @return numPdcmRed TODO_javadoc.
             *
             */
            public String getNumPdcmRed(int i) {

                if (i < 0 || i >= 5) {
                    throw new ArrayIndexOutOfBoundsException("numPdcmRed[]: indice debe estar en rango [0..4]");
                }

                return subValue(125 + 1 * i, 125 + 1 * (i + 1));
            }

            /*******************************************************************************************************
             * getNumPdcmRedSize
             *******************************************************************************************************/
            /**
             *
             * @return TODO_javadoc.
             *
             */
            public final int getNumPdcmRedSize() {
                return 5;
            }

        }

    }

}

