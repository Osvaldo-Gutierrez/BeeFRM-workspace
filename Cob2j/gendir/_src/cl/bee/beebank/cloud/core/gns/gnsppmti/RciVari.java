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
public class RciVari extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(RciVari.class);

    /** TODO_javadoc. */
    private static DecimalFormat form3z = new DecimalFormat("000");

    /** TODO_javadoc. */
    private RciIdd rciIdd = new RciIdd();

    /** TODO_javadoc. */
    private RciMsgAbt rciMsgAbt = new RciMsgAbt();

    /** TODO_javadoc. */
    private RciKeyCpto rciKeyCpto = new RciKeyCpto();

    /** TODO_javadoc. */
    private RciKeyCptoBkp rciKeyCptoBkp = new RciKeyCptoBkp();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public RciVari() {

        initBuffer(669);

        replaceValue(0, 669, "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             "); // RCI-VARI
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
        replaceValue(0, 669, value);
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
        return subValue(0, 669);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setRciNumInd1
     *******************************************************************************************************/
    /**
     *
     * @param rciNumInd1 TODO_javadoc.
     *
     */
    public void setRciNumInd1(int rciNumInd1) {
        replaceValue(490, 493, form3z.format(rciNumInd1));
    }

    /*******************************************************************************************************
     * setRciNumInd2
     *******************************************************************************************************/
    /**
     *
     * @param rciNumInd2 TODO_javadoc.
     *
     */
    public void setRciNumInd2(int rciNumInd2) {
        replaceValue(493, 496, form3z.format(rciNumInd2));
    }

    /*******************************************************************************************************
     * getRciIdd
     *******************************************************************************************************/
    /**
     *
     * @return rciIdd TODO_javadoc.
     *
     */
    public RciIdd getRciIdd() {
        return rciIdd;
    }

    /*******************************************************************************************************
     * getRciNumInd1
     *******************************************************************************************************/
    /**
     *
     * @return rciNumInd1 TODO_javadoc.
     *
     */
    public int getRciNumInd1() {
        return Integer.parseInt(subValue(490, 493));
    }

    /*******************************************************************************************************
     * getRciNumInd2
     *******************************************************************************************************/
    /**
     *
     * @return rciNumInd2 TODO_javadoc.
     *
     */
    public int getRciNumInd2() {
        return Integer.parseInt(subValue(493, 496));
    }

    /*******************************************************************************************************
     * getRciMsgAbt
     *******************************************************************************************************/
    /**
     *
     * @return rciMsgAbt TODO_javadoc.
     *
     */
    public RciMsgAbt getRciMsgAbt() {
        return rciMsgAbt;
    }

    /*******************************************************************************************************
     * getRciKeyCpto
     *******************************************************************************************************/
    /**
     *
     * @return rciKeyCpto TODO_javadoc.
     *
     */
    public RciKeyCpto getRciKeyCpto() {
        return rciKeyCpto;
    }

    /*******************************************************************************************************
     * getRciKeyCptoBkp
     *******************************************************************************************************/
    /**
     *
     * @return rciKeyCptoBkp TODO_javadoc.
     *
     */
    public RciKeyCptoBkp getRciKeyCptoBkp() {
        return rciKeyCptoBkp;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class RciIdd {

        /** TODO_javadoc. */
        private RciGlsFsis rciGlsFsis = new RciGlsFsis();

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public RciIdd() {
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
         * setRciGlsFlag
         *******************************************************************************************************/
        /**
         *
         * @param rciGlsFlag TODO_javadoc.
         *
         */
        public void setRciGlsFlag(String rciGlsFlag) {
            replaceValue(0, 1, rciGlsFlag);
        }

        /*******************************************************************************************************
         * setRciCodCidd
         *******************************************************************************************************/
        /**
         *
         * @param rciCodCidd TODO_javadoc.
         *
         */
        public void setRciCodCidd(String rciCodCidd) {
            replaceValue(1, 13, rciCodCidd);
        }

        /*******************************************************************************************************
         * setRciGlsDisp
         *******************************************************************************************************/
        /**
         *
         * @param rciGlsDisp TODO_javadoc.
         *
         */
        public void setRciGlsDisp(String rciGlsDisp) {
            replaceValue(486, 490, rciGlsDisp);
        }

        /*******************************************************************************************************
         * getRciGlsFlag
         *******************************************************************************************************/
        /**
         *
         * @return rciGlsFlag TODO_javadoc.
         *
         */
        public String getRciGlsFlag() {
            return subValue(0, 1);
        }

        /*******************************************************************************************************
         * getRciCodCidd
         *******************************************************************************************************/
        /**
         *
         * @return rciCodCidd TODO_javadoc.
         *
         */
        public String getRciCodCidd() {
            return subValue(1, 13);
        }

        /*******************************************************************************************************
         * getRciGlsFsis
         *******************************************************************************************************/
        /**
         *
         * @return rciGlsFsis TODO_javadoc.
         *
         */
        public RciGlsFsis getRciGlsFsis() {
            return rciGlsFsis;
        }

        /*******************************************************************************************************
         * getRciGlsDisp
         *******************************************************************************************************/
        /**
         *
         * @return rciGlsDisp TODO_javadoc.
         *
         */
        public String getRciGlsDisp() {
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
        public class RciGlsFsis {

            /** TODO_javadoc. */
            private RciGlsVsis[] rciGlsVsis = new RciGlsVsis[43];

            /*******************************************************************************************************
             *
             *******************************************************************************************************/
            /**
             *
             */
            public RciGlsFsis() {

                for (int i = 0; i < 43; i++) {
                    rciGlsVsis[i] = new RciGlsVsis(i);
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
             * getRciGlsVsis
             *******************************************************************************************************/
            /**
             *
             * @param i TODO_javadoc.
             *
             * @return rciGlsVsis TODO_javadoc.
             *
             */
            public RciGlsVsis getRciGlsVsis(int i) {

                if (i < 0 || i >= 43) {
                    throw new ArrayIndexOutOfBoundsException("rciGlsVsis[]: indice debe estar en rango [0..42]");
                }

                return rciGlsVsis[i];
            }

            /*******************************************************************************************************
             * getRciGlsVsisSize
             *******************************************************************************************************/
            /**
             *
             * @return TODO_javadoc.
             *
             */
            public final int getRciGlsVsisSize() {
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
            public class RciGlsVsis {

                /** TODO_javadoc. */
                private final int length_rciglsvsis = 11;

                /** TODO_javadoc. */
                private int idx_rciglsvsis;

                /** TODO_javadoc. */
                private RciGlsDent rciGlsDent = new RciGlsDent();

                /*******************************************************************************************************
                 *
                 *******************************************************************************************************/
                /**
                 *
                 * @param idx TODO_javadoc.
                 *
                 */
                public RciGlsVsis(int idx) {

                    this.idx_rciglsvsis = idx;
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
                    replaceValue(idx_rciglsvsis * length_rciglsvsis + 13, idx_rciglsvsis * length_rciglsvsis + 24, value);
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
                    return subValue(idx_rciglsvsis * length_rciglsvsis + 13, (idx_rciglsvsis + 1) * length_rciglsvsis + 13);
                }

                //
                //
                //

                /*******************************************************************************************************
                 * setRciCodTent
                 *******************************************************************************************************/
                /**
                 *
                 * @param rciCodTent TODO_javadoc.
                 *
                 */
                public void setRciCodTent(String rciCodTent) {
                    replaceValue(idx_rciglsvsis * length_rciglsvsis + 20, idx_rciglsvsis * length_rciglsvsis + 21, rciCodTent);
                }

                /*******************************************************************************************************
                 * setRciCodIent
                 *******************************************************************************************************/
                /**
                 *
                 * @param rciCodIent TODO_javadoc.
                 *
                 */
                public void setRciCodIent(String rciCodIent) {
                    replaceValue(idx_rciglsvsis * length_rciglsvsis + 21, idx_rciglsvsis * length_rciglsvsis + 24, rciCodIent);
                }

                /*******************************************************************************************************
                 * getRciGlsDent
                 *******************************************************************************************************/
                /**
                 *
                 * @return rciGlsDent TODO_javadoc.
                 *
                 */
                public RciGlsDent getRciGlsDent() {
                    return rciGlsDent;
                }

                /*******************************************************************************************************
                 * getRciCodTent
                 *******************************************************************************************************/
                /**
                 *
                 * @return rciCodTent TODO_javadoc.
                 *
                 */
                public String getRciCodTent() {
                    return subValue(idx_rciglsvsis * length_rciglsvsis + 20, idx_rciglsvsis * length_rciglsvsis + 21);
                }

                /*******************************************************************************************************
                 * getRciCodIent
                 *******************************************************************************************************/
                /**
                 *
                 * @return rciCodIent TODO_javadoc.
                 *
                 */
                public String getRciCodIent() {
                    return subValue(idx_rciglsvsis * length_rciglsvsis + 21, idx_rciglsvsis * length_rciglsvsis + 24);
                }

                /**
                 *
                 * TODO_javadoc.
                 *
                 * @author  BEE S.A.
                 * @version 1.0
                 *
                 */
                public class RciGlsDent {

                    /*******************************************************************************************************
                     *
                     *******************************************************************************************************/
                    /**
                     *
                     */
                    public RciGlsDent() {
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
                        replaceValue(idx_rciglsvsis * length_rciglsvsis + 13, idx_rciglsvsis * length_rciglsvsis + 20, value);
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
                        return subValue(idx_rciglsvsis * length_rciglsvsis + 13, (idx_rciglsvsis + 1) * length_rciglsvsis + 13);
                    }

                    //
                    //
                    //

                    /*******************************************************************************************************
                     * setRciCodSist
                     *******************************************************************************************************/
                    /**
                     *
                     * @param rciCodSist TODO_javadoc.
                     *
                     */
                    public void setRciCodSist(String rciCodSist) {
                        replaceValue(idx_rciglsvsis * length_rciglsvsis + 13, idx_rciglsvsis * length_rciglsvsis + 16, rciCodSist);
                    }

                    /*******************************************************************************************************
                     * setRciCodGrpo
                     *******************************************************************************************************/
                    /**
                     *
                     * @param rciCodGrpo TODO_javadoc.
                     *
                     */
                    public void setRciCodGrpo(String rciCodGrpo) {
                        replaceValue(idx_rciglsvsis * length_rciglsvsis + 16, idx_rciglsvsis * length_rciglsvsis + 17, rciCodGrpo);
                    }

                    /*******************************************************************************************************
                     * setRciCodRgst
                     *******************************************************************************************************/
                    /**
                     *
                     * @param rciCodRgst TODO_javadoc.
                     *
                     */
                    public void setRciCodRgst(String rciCodRgst) {
                        replaceValue(idx_rciglsvsis * length_rciglsvsis + 17, idx_rciglsvsis * length_rciglsvsis + 20, rciCodRgst);
                    }

                    /*******************************************************************************************************
                     * getRciCodSist
                     *******************************************************************************************************/
                    /**
                     *
                     * @return rciCodSist TODO_javadoc.
                     *
                     */
                    public String getRciCodSist() {
                        return subValue(idx_rciglsvsis * length_rciglsvsis + 13, idx_rciglsvsis * length_rciglsvsis + 16);
                    }

                    /*******************************************************************************************************
                     * getRciCodGrpo
                     *******************************************************************************************************/
                    /**
                     *
                     * @return rciCodGrpo TODO_javadoc.
                     *
                     */
                    public String getRciCodGrpo() {
                        return subValue(idx_rciglsvsis * length_rciglsvsis + 16, idx_rciglsvsis * length_rciglsvsis + 17);
                    }

                    /*******************************************************************************************************
                     * getRciCodRgst
                     *******************************************************************************************************/
                    /**
                     *
                     * @return rciCodRgst TODO_javadoc.
                     *
                     */
                    public String getRciCodRgst() {
                        return subValue(idx_rciglsvsis * length_rciglsvsis + 17, idx_rciglsvsis * length_rciglsvsis + 20);
                    }

                }

            }

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
    public class RciMsgAbt {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public RciMsgAbt() {
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
            replaceValue(496, 586, value);
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
            return subValue(496, 496 + 90);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setRciMsgAbt1
         *******************************************************************************************************/
        /**
         *
         * @param rciMsgAbt1 TODO_javadoc.
         *
         */
        public void setRciMsgAbt1(String rciMsgAbt1) {
            replaceValue(496, 521, rciMsgAbt1);
        }

        /*******************************************************************************************************
         * setRciMsgAbt2
         *******************************************************************************************************/
        /**
         *
         * @param rciMsgAbt2 TODO_javadoc.
         *
         */
        public void setRciMsgAbt2(String rciMsgAbt2) {
            replaceValue(521, 586, rciMsgAbt2);
        }

        /*******************************************************************************************************
         * getRciMsgAbt1
         *******************************************************************************************************/
        /**
         *
         * @return rciMsgAbt1 TODO_javadoc.
         *
         */
        public String getRciMsgAbt1() {
            return subValue(496, 521);
        }

        /*******************************************************************************************************
         * getRciMsgAbt2
         *******************************************************************************************************/
        /**
         *
         * @return rciMsgAbt2 TODO_javadoc.
         *
         */
        public String getRciMsgAbt2() {
            return subValue(521, 586);
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
    public class RciKeyCpto {

        /** TODO_javadoc. */
        private RciGlsAmbt rciGlsAmbt = new RciGlsAmbt();

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public RciKeyCpto() {
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
            replaceValue(586, 652, value);
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
            return subValue(586, 586 + 66);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setRciCodCpto
         *******************************************************************************************************/
        /**
         *
         * @param rciCodCpto TODO_javadoc.
         *
         */
        public void setRciCodCpto(String rciCodCpto) {
            replaceValue(586, 598, rciCodCpto);
        }

        /*******************************************************************************************************
         * getRciCodCpto
         *******************************************************************************************************/
        /**
         *
         * @return rciCodCpto TODO_javadoc.
         *
         */
        public String getRciCodCpto() {
            return subValue(586, 598);
        }

        /*******************************************************************************************************
         * getRciGlsAmbt
         *******************************************************************************************************/
        /**
         *
         * @return rciGlsAmbt TODO_javadoc.
         *
         */
        public RciGlsAmbt getRciGlsAmbt() {
            return rciGlsAmbt;
        }

        /**
         *
         * TODO_javadoc.
         *
         * @author  BEE S.A.
         * @version 1.0
         *
         */
        public class RciGlsAmbt {

            /*******************************************************************************************************
             *
             *******************************************************************************************************/
            /**
             *
             */
            public RciGlsAmbt() {
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
                replaceValue(598, 652, value);
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
                return subValue(598, 598 + 54);
            }

            //
            //
            //

            /*******************************************************************************************************
             * setRciCodBnco
             *******************************************************************************************************/
            /**
             *
             * @param rciCodBnco TODO_javadoc.
             *
             */
            public void setRciCodBnco(String rciCodBnco) {
                replaceValue(598, 601, rciCodBnco);
            }

            /*******************************************************************************************************
             * setRciCodMrca
             *******************************************************************************************************/
            /**
             *
             * @param rciCodMrca TODO_javadoc.
             *
             */
            public void setRciCodMrca(String rciCodMrca) {
                replaceValue(601, 604, rciCodMrca);
            }

            /*******************************************************************************************************
             * setRciCodCart
             *******************************************************************************************************/
            /**
             *
             * @param rciCodCart TODO_javadoc.
             *
             */
            public void setRciCodCart(String rciCodCart) {
                replaceValue(604, 607, rciCodCart);
            }

            /*******************************************************************************************************
             * setRciCodLeng
             *******************************************************************************************************/
            /**
             *
             * @param rciCodLeng TODO_javadoc.
             *
             */
            public void setRciCodLeng(String rciCodLeng) {
                replaceValue(607, 609, rciCodLeng);
            }

            /*******************************************************************************************************
             * setRciCodPais
             *******************************************************************************************************/
            /**
             *
             * @param rciCodPais TODO_javadoc.
             *
             */
            public void setRciCodPais(String rciCodPais) {
                replaceValue(609, 611, rciCodPais);
            }

            /*******************************************************************************************************
             * setRciCodVrnt
             *******************************************************************************************************/
            /**
             *
             * @param rciCodVrnt TODO_javadoc.
             *
             */
            public void setRciCodVrnt(String rciCodVrnt) {
                replaceValue(611, 612, rciCodVrnt);
            }

            /*******************************************************************************************************
             * setRciCodCnal
             *******************************************************************************************************/
            /**
             *
             * @param rciCodCnal TODO_javadoc.
             *
             */
            public void setRciCodCnal(String rciCodCnal) {
                replaceValue(612, 617, rciCodCnal);
            }

            /*******************************************************************************************************
             * setRciCodUmua
             *******************************************************************************************************/
            /**
             *
             * @param rciCodUmua TODO_javadoc.
             *
             */
            public void setRciCodUmua(String rciCodUmua) {
                replaceValue(617, 629, rciCodUmua);
            }

            /*******************************************************************************************************
             * setRciCodModo
             *******************************************************************************************************/
            /**
             *
             * @param rciCodModo TODO_javadoc.
             *
             */
            public void setRciCodModo(String rciCodModo) {
                replaceValue(629, 630, rciCodModo);
            }

            /*******************************************************************************************************
             * setRciKeyDisp
             *******************************************************************************************************/
            /**
             *
             * @param rciKeyDisp TODO_javadoc.
             *
             */
            public void setRciKeyDisp(String rciKeyDisp) {
                replaceValue(630, 652, rciKeyDisp);
            }

            /*******************************************************************************************************
             * getRciCodBnco
             *******************************************************************************************************/
            /**
             *
             * @return rciCodBnco TODO_javadoc.
             *
             */
            public String getRciCodBnco() {
                return subValue(598, 601);
            }

            /*******************************************************************************************************
             * getRciCodMrca
             *******************************************************************************************************/
            /**
             *
             * @return rciCodMrca TODO_javadoc.
             *
             */
            public String getRciCodMrca() {
                return subValue(601, 604);
            }

            /*******************************************************************************************************
             * getRciCodCart
             *******************************************************************************************************/
            /**
             *
             * @return rciCodCart TODO_javadoc.
             *
             */
            public String getRciCodCart() {
                return subValue(604, 607);
            }

            /*******************************************************************************************************
             * getRciCodLeng
             *******************************************************************************************************/
            /**
             *
             * @return rciCodLeng TODO_javadoc.
             *
             */
            public String getRciCodLeng() {
                return subValue(607, 609);
            }

            /*******************************************************************************************************
             * getRciCodPais
             *******************************************************************************************************/
            /**
             *
             * @return rciCodPais TODO_javadoc.
             *
             */
            public String getRciCodPais() {
                return subValue(609, 611);
            }

            /*******************************************************************************************************
             * getRciCodVrnt
             *******************************************************************************************************/
            /**
             *
             * @return rciCodVrnt TODO_javadoc.
             *
             */
            public String getRciCodVrnt() {
                return subValue(611, 612);
            }

            /*******************************************************************************************************
             * getRciCodCnal
             *******************************************************************************************************/
            /**
             *
             * @return rciCodCnal TODO_javadoc.
             *
             */
            public String getRciCodCnal() {
                return subValue(612, 617);
            }

            /*******************************************************************************************************
             * getRciCodUmua
             *******************************************************************************************************/
            /**
             *
             * @return rciCodUmua TODO_javadoc.
             *
             */
            public String getRciCodUmua() {
                return subValue(617, 629);
            }

            /*******************************************************************************************************
             * getRciCodModo
             *******************************************************************************************************/
            /**
             *
             * @return rciCodModo TODO_javadoc.
             *
             */
            public String getRciCodModo() {
                return subValue(629, 630);
            }

            /*******************************************************************************************************
             * getRciKeyDisp
             *******************************************************************************************************/
            /**
             *
             * @return rciKeyDisp TODO_javadoc.
             *
             */
            public String getRciKeyDisp() {
                return subValue(630, 652);
            }

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
    public class RciKeyCptoBkp {

        /** TODO_javadoc. */
        private RciGlsAmbtBkp rciGlsAmbtBkp = new RciGlsAmbtBkp();

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public RciKeyCptoBkp() {
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
            replaceValue(652, 669, value);
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
            return subValue(652, 652 + 17);
        }

        //
        //
        //

        /*******************************************************************************************************
         * getRciGlsAmbtBkp
         *******************************************************************************************************/
        /**
         *
         * @return rciGlsAmbtBkp TODO_javadoc.
         *
         */
        public RciGlsAmbtBkp getRciGlsAmbtBkp() {
            return rciGlsAmbtBkp;
        }

        /**
         *
         * TODO_javadoc.
         *
         * @author  BEE S.A.
         * @version 1.0
         *
         */
        public class RciGlsAmbtBkp {

            /*******************************************************************************************************
             *
             *******************************************************************************************************/
            /**
             *
             */
            public RciGlsAmbtBkp() {
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
                replaceValue(652, 669, value);
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
                return subValue(652, 652 + 17);
            }

            //
            //
            //

            /*******************************************************************************************************
             * setRciCodCnalBkp
             *******************************************************************************************************/
            /**
             *
             * @param rciCodCnalBkp TODO_javadoc.
             *
             */
            public void setRciCodCnalBkp(String rciCodCnalBkp) {
                replaceValue(652, 657, rciCodCnalBkp);
            }

            /*******************************************************************************************************
             * setRciCodUserBkp
             *******************************************************************************************************/
            /**
             *
             * @param rciCodUserBkp TODO_javadoc.
             *
             */
            public void setRciCodUserBkp(String rciCodUserBkp) {
                replaceValue(657, 669, rciCodUserBkp);
            }

            /*******************************************************************************************************
             * getRciCodCnalBkp
             *******************************************************************************************************/
            /**
             *
             * @return rciCodCnalBkp TODO_javadoc.
             *
             */
            public String getRciCodCnalBkp() {
                return subValue(652, 657);
            }

            /*******************************************************************************************************
             * getRciCodUserBkp
             *******************************************************************************************************/
            /**
             *
             * @return rciCodUserBkp TODO_javadoc.
             *
             */
            public String getRciCodUserBkp() {
                return subValue(657, 669);
            }

        }

    }

}

