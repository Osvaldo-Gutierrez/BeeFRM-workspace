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
public class Tdo extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(Tdo.class);

    /** TODO_javadoc. */
    private static DecimalFormat form3z = new DecimalFormat("000");

    /** TODO_javadoc. */
    private TdoGlsData tdoGlsData = new TdoGlsData();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public Tdo() {

        initBuffer(18003);

        replaceValue(0, 18003, "000                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "); // TDO
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
     * setTdoNumReco
     *******************************************************************************************************/
    /**
     *
     * @param tdoNumReco TODO_javadoc.
     *
     */
    public void setTdoNumReco(int tdoNumReco) {
        replaceValue(0, 3, form3z.format(tdoNumReco));
    }

    /*******************************************************************************************************
     * getTdoNumReco
     *******************************************************************************************************/
    /**
     *
     * @return tdoNumReco TODO_javadoc.
     *
     */
    public int getTdoNumReco() {
        return Integer.parseInt(subValue(0, 3));
    }

    /*******************************************************************************************************
     * getTdoGlsData
     *******************************************************************************************************/
    /**
     *
     * @return tdoGlsData TODO_javadoc.
     *
     */
    public TdoGlsData getTdoGlsData() {
        return tdoGlsData;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class TdoGlsData {

        /** TODO_javadoc. */
        private TdoGlsDesc tdoGlsDesc = new TdoGlsDesc();

        /** TODO_javadoc. */
        private TdoGlsDescRed tdoGlsDescRed = new TdoGlsDescRed();

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public TdoGlsData() {
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
         * getTdoGlsDesc
         *******************************************************************************************************/
        /**
         *
         * @return tdoGlsDesc TODO_javadoc.
         *
         */
        public TdoGlsDesc getTdoGlsDesc() {
            return tdoGlsDesc;
        }

        /*******************************************************************************************************
         * getTdoGlsDescRed
         *******************************************************************************************************/
        /**
         *
         * @return tdoGlsDescRed TODO_javadoc.
         *
         */
        public TdoGlsDescRed getTdoGlsDescRed() {
            return tdoGlsDescRed;
        }

        /**
         *
         * TODO_javadoc.
         *
         * @author  BEE S.A.
         * @version 1.0
         *
         */
        public class TdoGlsDesc {

            /** TODO_javadoc. */
            private TdoGlsMensMsg tdoGlsMensMsg = new TdoGlsMensMsg();

            /** TODO_javadoc. */
            private TdoDescOcc tdoDescOcc = new TdoDescOcc();

            /*******************************************************************************************************
             *
             *******************************************************************************************************/
            /**
             *
             */
            public TdoGlsDesc() {
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
             * getTdoGlsMensMsg
             *******************************************************************************************************/
            /**
             *
             * @return tdoGlsMensMsg TODO_javadoc.
             *
             */
            public TdoGlsMensMsg getTdoGlsMensMsg() {
                return tdoGlsMensMsg;
            }

            /*******************************************************************************************************
             * getTdoDescOcc
             *******************************************************************************************************/
            /**
             *
             * @return tdoDescOcc TODO_javadoc.
             *
             */
            public TdoDescOcc getTdoDescOcc() {
                return tdoDescOcc;
            }

            /**
             *
             * TODO_javadoc.
             *
             * @author  BEE S.A.
             * @version 1.0
             *
             */
            public class TdoGlsMensMsg {

                /** TODO_javadoc. */
                private TdoGlsMens tdoGlsMens = new TdoGlsMens();

                /*******************************************************************************************************
                 *
                 *******************************************************************************************************/
                /**
                 *
                 */
                public TdoGlsMensMsg() {
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
                    replaceValue(3, 83, value);
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
                    return subValue(3, 3 + 80);
                }

                //
                //
                //

                /*******************************************************************************************************
                 * setTdoCodStat
                 *******************************************************************************************************/
                /**
                 *
                 * @param tdoCodStat TODO_javadoc.
                 *
                 */
                public void setTdoCodStat(String tdoCodStat) {
                    replaceValue(3, 4, tdoCodStat);
                }

                /*******************************************************************************************************
                 * getTdoCodStat
                 *******************************************************************************************************/
                /**
                 *
                 * @return tdoCodStat TODO_javadoc.
                 *
                 */
                public String getTdoCodStat() {
                    return subValue(3, 4);
                }

                /*******************************************************************************************************
                 * getTdoGlsMens
                 *******************************************************************************************************/
                /**
                 *
                 * @return tdoGlsMens TODO_javadoc.
                 *
                 */
                public TdoGlsMens getTdoGlsMens() {
                    return tdoGlsMens;
                }

                /**
                 *
                 * TODO_javadoc.
                 *
                 * @author  BEE S.A.
                 * @version 1.0
                 *
                 */
                public class TdoGlsMens {

                    /*******************************************************************************************************
                     *
                     *******************************************************************************************************/
                    /**
                     *
                     */
                    public TdoGlsMens() {
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
                        replaceValue(4, 83, value);
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
                        return subValue(4, 4 + 79);
                    }

                    //
                    //
                    //

                    /*******************************************************************************************************
                     * setTdoGlsMens1
                     *******************************************************************************************************/
                    /**
                     *
                     * @param tdoGlsMens1 TODO_javadoc.
                     *
                     */
                    public void setTdoGlsMens1(String tdoGlsMens1) {
                        replaceValue(4, 24, tdoGlsMens1);
                    }

                    /*******************************************************************************************************
                     * setTdoGlsMens2
                     *******************************************************************************************************/
                    /**
                     *
                     * @param tdoGlsMens2 TODO_javadoc.
                     *
                     */
                    public void setTdoGlsMens2(String tdoGlsMens2) {
                        replaceValue(24, 83, tdoGlsMens2);
                    }

                    /*******************************************************************************************************
                     * getTdoGlsMens1
                     *******************************************************************************************************/
                    /**
                     *
                     * @return tdoGlsMens1 TODO_javadoc.
                     *
                     */
                    public String getTdoGlsMens1() {
                        return subValue(4, 24);
                    }

                    /*******************************************************************************************************
                     * getTdoGlsMens2
                     *******************************************************************************************************/
                    /**
                     *
                     * @return tdoGlsMens2 TODO_javadoc.
                     *
                     */
                    public String getTdoGlsMens2() {
                        return subValue(24, 83);
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
            public class TdoDescOcc {

                /*******************************************************************************************************
                 *
                 *******************************************************************************************************/
                /**
                 *
                 */
                public TdoDescOcc() {
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
                    replaceValue(83, 18003, value);
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
                    return subValue(83, 83 + 17920);
                }

                //
                //
                //

                /*******************************************************************************************************
                 * setTdoCodTdo
                 *******************************************************************************************************/
                /**
                 *
                 * @param tdoCodTdo TODO_javadoc.
                 *
                 */
                public void setTdoCodTdo(String[] tdoCodTdo) {

                    if (tdoCodTdo == null || tdoCodTdo.length != 17920) {
                        throw new IllegalArgumentException("tdoCodTdo[]: no debe ser nulo y largo debe ser 17920");
                    }

                    for (int i = 0; i < 17920; i++) {
                        replaceValue(83 + 1 * i, 83 + 1 * (i + 1), tdoCodTdo[i]);
                    }
                }

                /*******************************************************************************************************
                 * setTdoCodTdo
                 *******************************************************************************************************/
                /**
                 *
                 * @param i TODO_javadoc.
                 * @param tdoCodTdo TODO_javadoc.
                 *
                 */
                public void setTdoCodTdo(int i, String tdoCodTdo) {

                    if (i < 0 || i >= 17920) {
                        throw new ArrayIndexOutOfBoundsException("tdoCodTdo[]: indice debe estar en rango [0..17919]");
                    }

                    replaceValue(83 + 1 * i, 83 + 1 * (i + 1), tdoCodTdo);
                }

                /*******************************************************************************************************
                 * getTdoCodTdo
                 *******************************************************************************************************/
                /**
                 *
                 * @param i TODO_javadoc.
                 *
                 * @return tdoCodTdo TODO_javadoc.
                 *
                 */
                public String getTdoCodTdo(int i) {

                    if (i < 0 || i >= 17920) {
                        throw new ArrayIndexOutOfBoundsException("tdoCodTdo[]: indice debe estar en rango [0..17919]");
                    }

                    return subValue(83 + 1 * i, 83 + 1 * (i + 1));
                }

                /*******************************************************************************************************
                 * getTdoCodTdoSize
                 *******************************************************************************************************/
                /**
                 *
                 * @return TODO_javadoc.
                 *
                 */
                public final int getTdoCodTdoSize() {
                    return 17920;
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
        public class TdoGlsDescRed {

            /*******************************************************************************************************
             *
             *******************************************************************************************************/
            /**
             *
             */
            public TdoGlsDescRed() {
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
             * setTdoGlsDesc1
             *******************************************************************************************************/
            /**
             *
             * @param tdoGlsDesc1 TODO_javadoc.
             *
             */
            public void setTdoGlsDesc1(String tdoGlsDesc1) {
                replaceValue(3, 9003, tdoGlsDesc1);
            }

            /*******************************************************************************************************
             * setTdoGlsDesc2
             *******************************************************************************************************/
            /**
             *
             * @param tdoGlsDesc2 TODO_javadoc.
             *
             */
            public void setTdoGlsDesc2(String tdoGlsDesc2) {
                replaceValue(9003, 18003, tdoGlsDesc2);
            }

            /*******************************************************************************************************
             * getTdoGlsDesc1
             *******************************************************************************************************/
            /**
             *
             * @return tdoGlsDesc1 TODO_javadoc.
             *
             */
            public String getTdoGlsDesc1() {
                return subValue(3, 9003);
            }

            /*******************************************************************************************************
             * getTdoGlsDesc2
             *******************************************************************************************************/
            /**
             *
             * @return tdoGlsDesc2 TODO_javadoc.
             *
             */
            public String getTdoGlsDesc2() {
                return subValue(9003, 18003);
            }

        }

    }

}

