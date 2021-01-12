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
public class IddVari extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(IddVari.class);

    /** TODO_javadoc. */
    private static DecimalFormat form2z = new DecimalFormat("00");

    /** TODO_javadoc. */
    private IddDaux iddDaux = new IddDaux();

    /** TODO_javadoc. */
    private IddRegi iddRegi = new IddRegi();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public IddVari() {

        initBuffer(507);

        replaceValue(0, 507, "               00                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          "); // IDD-VARI
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
        replaceValue(0, 507, value);
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
        return subValue(0, 507);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setIddProg
     *******************************************************************************************************/
    /**
     *
     * @param iddProg TODO_javadoc.
     *
     */
    public void setIddProg(String iddProg) {
        replaceValue(0, 8, iddProg);
    }

    /*******************************************************************************************************
     * setIddIaux
     *******************************************************************************************************/
    /**
     *
     * @param iddIaux TODO_javadoc.
     *
     */
    public void setIddIaux(int iddIaux) {
        replaceValue(15, 17, form2z.format(iddIaux));
    }

    /*******************************************************************************************************
     * getIddProg
     *******************************************************************************************************/
    /**
     *
     * @return iddProg TODO_javadoc.
     *
     */
    public String getIddProg() {
        return subValue(0, 8);
    }

    /*******************************************************************************************************
     * getIddDaux
     *******************************************************************************************************/
    /**
     *
     * @return iddDaux TODO_javadoc.
     *
     */
    public IddDaux getIddDaux() {
        return iddDaux;
    }

    /*******************************************************************************************************
     * getIddIaux
     *******************************************************************************************************/
    /**
     *
     * @return iddIaux TODO_javadoc.
     *
     */
    public int getIddIaux() {
        return Integer.parseInt(subValue(15, 17));
    }

    /*******************************************************************************************************
     * getIddRegi
     *******************************************************************************************************/
    /**
     *
     * @return iddRegi TODO_javadoc.
     *
     */
    public IddRegi getIddRegi() {
        return iddRegi;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class IddDaux {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public IddDaux() {
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
            replaceValue(8, 15, value);
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
            return subValue(8, 8 + 7);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setIddSaux
         *******************************************************************************************************/
        /**
         *
         * @param iddSaux TODO_javadoc.
         *
         */
        public void setIddSaux(String iddSaux) {
            replaceValue(8, 11, iddSaux);
        }

        /*******************************************************************************************************
         * setIddGaux
         *******************************************************************************************************/
        /**
         *
         * @param iddGaux TODO_javadoc.
         *
         */
        public void setIddGaux(String iddGaux) {
            replaceValue(11, 12, iddGaux);
        }

        /*******************************************************************************************************
         * setIddRaux
         *******************************************************************************************************/
        /**
         *
         * @param iddRaux TODO_javadoc.
         *
         */
        public void setIddRaux(String iddRaux) {
            replaceValue(12, 15, iddRaux);
        }

        /*******************************************************************************************************
         * getIddSaux
         *******************************************************************************************************/
        /**
         *
         * @return iddSaux TODO_javadoc.
         *
         */
        public String getIddSaux() {
            return subValue(8, 11);
        }

        /*******************************************************************************************************
         * getIddGaux
         *******************************************************************************************************/
        /**
         *
         * @return iddGaux TODO_javadoc.
         *
         */
        public String getIddGaux() {
            return subValue(11, 12);
        }

        /*******************************************************************************************************
         * getIddRaux
         *******************************************************************************************************/
        /**
         *
         * @return iddRaux TODO_javadoc.
         *
         */
        public String getIddRaux() {
            return subValue(12, 15);
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
    public class IddRegi {

        /** TODO_javadoc. */
        private IddFsis iddFsis = new IddFsis();

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public IddRegi() {
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
            replaceValue(17, 507, value);
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
            return subValue(17, 17 + 490);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setFiller
         *******************************************************************************************************/
        /**
         *
         * @param filler TODO_javadoc.
         *
         */
        public void setFiller(String filler) {
            replaceValue(17, 18, filler);
        }

        /*******************************************************************************************************
         * setIddCidd
         *******************************************************************************************************/
        /**
         *
         * @param iddCidd TODO_javadoc.
         *
         */
        public void setIddCidd(String iddCidd) {
            replaceValue(18, 30, iddCidd);
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
            replaceValue(503, 507, filler1);
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
            return subValue(17, 18);
        }

        /*******************************************************************************************************
         * getIddCidd
         *******************************************************************************************************/
        /**
         *
         * @return iddCidd TODO_javadoc.
         *
         */
        public String getIddCidd() {
            return subValue(18, 30);
        }

        /*******************************************************************************************************
         * getIddFsis
         *******************************************************************************************************/
        /**
         *
         * @return iddFsis TODO_javadoc.
         *
         */
        public IddFsis getIddFsis() {
            return iddFsis;
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
            return subValue(503, 507);
        }

        /**
         *
         * TODO_javadoc.
         *
         * @author  BEE S.A.
         * @version 1.0
         *
         */
        public class IddFsis {

            /** TODO_javadoc. */
            private IddVsis[] iddVsis = new IddVsis[43];

            /*******************************************************************************************************
             *
             *******************************************************************************************************/
            /**
             *
             */
            public IddFsis() {

                for (int i = 0; i < 43; i++) {
                    iddVsis[i] = new IddVsis(i);
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
                replaceValue(30, 503, value);
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
                return subValue(30, 30 + 473);
            }

            //
            //
            //

            /*******************************************************************************************************
             * getIddVsis
             *******************************************************************************************************/
            /**
             *
             * @param i TODO_javadoc.
             *
             * @return iddVsis TODO_javadoc.
             *
             */
            public IddVsis getIddVsis(int i) {

                if (i < 0 || i >= 43) {
                    throw new ArrayIndexOutOfBoundsException("iddVsis[]: indice debe estar en rango [0..42]");
                }

                return iddVsis[i];
            }

            /*******************************************************************************************************
             * getIddVsisSize
             *******************************************************************************************************/
            /**
             *
             * @return TODO_javadoc.
             *
             */
            public final int getIddVsisSize() {
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
            public class IddVsis {

                /** TODO_javadoc. */
                private final int length_iddvsis = 11;

                /** TODO_javadoc. */
                private int idx_iddvsis;

                /** TODO_javadoc. */
                private IddDent iddDent = new IddDent();

                /*******************************************************************************************************
                 *
                 *******************************************************************************************************/
                /**
                 *
                 * @param idx TODO_javadoc.
                 *
                 */
                public IddVsis(int idx) {

                    this.idx_iddvsis = idx;
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
                    replaceValue(idx_iddvsis * length_iddvsis + 30, idx_iddvsis * length_iddvsis + 41, value);
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
                    return subValue(idx_iddvsis * length_iddvsis + 30, (idx_iddvsis + 1) * length_iddvsis + 30);
                }

                //
                //
                //

                /*******************************************************************************************************
                 * setIddTent
                 *******************************************************************************************************/
                /**
                 *
                 * @param iddTent TODO_javadoc.
                 *
                 */
                public void setIddTent(String iddTent) {
                    replaceValue(idx_iddvsis * length_iddvsis + 37, idx_iddvsis * length_iddvsis + 38, iddTent);
                }

                /*******************************************************************************************************
                 * setIddIent
                 *******************************************************************************************************/
                /**
                 *
                 * @param iddIent TODO_javadoc.
                 *
                 */
                public void setIddIent(String iddIent) {
                    replaceValue(idx_iddvsis * length_iddvsis + 38, idx_iddvsis * length_iddvsis + 41, iddIent);
                }

                /*******************************************************************************************************
                 * getIddDent
                 *******************************************************************************************************/
                /**
                 *
                 * @return iddDent TODO_javadoc.
                 *
                 */
                public IddDent getIddDent() {
                    return iddDent;
                }

                /*******************************************************************************************************
                 * getIddTent
                 *******************************************************************************************************/
                /**
                 *
                 * @return iddTent TODO_javadoc.
                 *
                 */
                public String getIddTent() {
                    return subValue(idx_iddvsis * length_iddvsis + 37, idx_iddvsis * length_iddvsis + 38);
                }

                /*******************************************************************************************************
                 * getIddIent
                 *******************************************************************************************************/
                /**
                 *
                 * @return iddIent TODO_javadoc.
                 *
                 */
                public String getIddIent() {
                    return subValue(idx_iddvsis * length_iddvsis + 38, idx_iddvsis * length_iddvsis + 41);
                }

                /**
                 *
                 * TODO_javadoc.
                 *
                 * @author  BEE S.A.
                 * @version 1.0
                 *
                 */
                public class IddDent {

                    /*******************************************************************************************************
                     *
                     *******************************************************************************************************/
                    /**
                     *
                     */
                    public IddDent() {
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
                        replaceValue(idx_iddvsis * length_iddvsis + 30, idx_iddvsis * length_iddvsis + 37, value);
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
                        return subValue(idx_iddvsis * length_iddvsis + 30, (idx_iddvsis + 1) * length_iddvsis + 30);
                    }

                    //
                    //
                    //

                    /*******************************************************************************************************
                     * setIddSist
                     *******************************************************************************************************/
                    /**
                     *
                     * @param iddSist TODO_javadoc.
                     *
                     */
                    public void setIddSist(String iddSist) {
                        replaceValue(idx_iddvsis * length_iddvsis + 30, idx_iddvsis * length_iddvsis + 33, iddSist);
                    }

                    /*******************************************************************************************************
                     * setIddGrpo
                     *******************************************************************************************************/
                    /**
                     *
                     * @param iddGrpo TODO_javadoc.
                     *
                     */
                    public void setIddGrpo(String iddGrpo) {
                        replaceValue(idx_iddvsis * length_iddvsis + 33, idx_iddvsis * length_iddvsis + 34, iddGrpo);
                    }

                    /*******************************************************************************************************
                     * setIddRgst
                     *******************************************************************************************************/
                    /**
                     *
                     * @param iddRgst TODO_javadoc.
                     *
                     */
                    public void setIddRgst(String iddRgst) {
                        replaceValue(idx_iddvsis * length_iddvsis + 34, idx_iddvsis * length_iddvsis + 37, iddRgst);
                    }

                    /*******************************************************************************************************
                     * getIddSist
                     *******************************************************************************************************/
                    /**
                     *
                     * @return iddSist TODO_javadoc.
                     *
                     */
                    public String getIddSist() {
                        return subValue(idx_iddvsis * length_iddvsis + 30, idx_iddvsis * length_iddvsis + 33);
                    }

                    /*******************************************************************************************************
                     * getIddGrpo
                     *******************************************************************************************************/
                    /**
                     *
                     * @return iddGrpo TODO_javadoc.
                     *
                     */
                    public String getIddGrpo() {
                        return subValue(idx_iddvsis * length_iddvsis + 33, idx_iddvsis * length_iddvsis + 34);
                    }

                    /*******************************************************************************************************
                     * getIddRgst
                     *******************************************************************************************************/
                    /**
                     *
                     * @return iddRgst TODO_javadoc.
                     *
                     */
                    public String getIddRgst() {
                        return subValue(idx_iddvsis * length_iddvsis + 34, idx_iddvsis * length_iddvsis + 37);
                    }

                }

            }

        }

    }

}

