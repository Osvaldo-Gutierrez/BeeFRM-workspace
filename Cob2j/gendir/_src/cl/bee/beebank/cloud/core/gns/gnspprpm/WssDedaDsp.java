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
public class WssDedaDsp extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(WssDedaDsp.class);

    /** TODO_javadoc. */
    private WssDedaDspHstGrp wssDedaDspHstGrp = new WssDedaDspHstGrp();

    /** TODO_javadoc. */
    private WssDedaDspSrvGrp wssDedaDspSrvGrp = new WssDedaDspSrvGrp();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public WssDedaDsp() {

        initBuffer(100);

        replaceValue(0, 100, "                                                                                                    "); // WSS-DEDA-DSP
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
        replaceValue(0, 100, value);
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
        return subValue(0, 100);
    }

    //
    //
    //

    /*******************************************************************************************************
     * getWssDedaDspHstGrp
     *******************************************************************************************************/
    /**
     *
     * @return wssDedaDspHstGrp TODO_javadoc.
     *
     */
    public WssDedaDspHstGrp getWssDedaDspHstGrp() {
        return wssDedaDspHstGrp;
    }

    /*******************************************************************************************************
     * getWssDedaDspSrvGrp
     *******************************************************************************************************/
    /**
     *
     * @return wssDedaDspSrvGrp TODO_javadoc.
     *
     */
    public WssDedaDspSrvGrp getWssDedaDspSrvGrp() {
        return wssDedaDspSrvGrp;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class WssDedaDspHstGrp {

        /** TODO_javadoc. */
        private WssDedaDspHst wssDedaDspHst = new WssDedaDspHst();

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssDedaDspHstGrp() {
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
            replaceValue(0, 100, value);
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
            return subValue(0, 100);
        }

        //
        //
        //

        /*******************************************************************************************************
         * getWssDedaDspHst
         *******************************************************************************************************/
        /**
         *
         * @return wssDedaDspHst TODO_javadoc.
         *
         */
        public WssDedaDspHst getWssDedaDspHst() {
            return wssDedaDspHst;
        }

        /**
         *
         * TODO_javadoc.
         *
         * @author  BEE S.A.
         * @version 1.0
         *
         */
        public class WssDedaDspHst {

            /** TODO_javadoc. */
            private WssDedaDspTblHst[] wssDedaDspTblHst = new WssDedaDspTblHst[50];

            /*******************************************************************************************************
             *
             *******************************************************************************************************/
            /**
             *
             */
            public WssDedaDspHst() {

                for (int i = 0; i < 50; i++) {
                    wssDedaDspTblHst[i] = new WssDedaDspTblHst(i);
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
                replaceValue(0, 100, value);
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
                return subValue(0, 100);
            }

            //
            //
            //

            /*******************************************************************************************************
             * getWssDedaDspTblHst
             *******************************************************************************************************/
            /**
             *
             * @param i TODO_javadoc.
             *
             * @return wssDedaDspTblHst TODO_javadoc.
             *
             */
            public WssDedaDspTblHst getWssDedaDspTblHst(int i) {

                if (i < 0 || i >= 50) {
                    throw new ArrayIndexOutOfBoundsException("wssDedaDspTblHst[]: indice debe estar en rango [0..49]");
                }

                return wssDedaDspTblHst[i];
            }

            /*******************************************************************************************************
             * getWssDedaDspTblHstSize
             *******************************************************************************************************/
            /**
             *
             * @return TODO_javadoc.
             *
             */
            public final int getWssDedaDspTblHstSize() {
                return 50;
            }

            /**
             *
             * TODO_javadoc.
             *
             * @author  BEE S.A.
             * @version 1.0
             *
             */
            public class WssDedaDspTblHst {

                /** TODO_javadoc. */
                private final int length_wssdedadsptblhst = 2;

                /** TODO_javadoc. */
                private int idx_wssdedadsptblhst;

                /*******************************************************************************************************
                 *
                 *******************************************************************************************************/
                /**
                 *
                 * @param idx TODO_javadoc.
                 *
                 */
                public WssDedaDspTblHst(int idx) {

                    this.idx_wssdedadsptblhst = idx;
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
                    replaceValue(idx_wssdedadsptblhst * length_wssdedadsptblhst + 0, idx_wssdedadsptblhst * length_wssdedadsptblhst + 2, value);
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
                    return subValue(idx_wssdedadsptblhst * length_wssdedadsptblhst + 0, (idx_wssdedadsptblhst + 1) * length_wssdedadsptblhst + 0);
                }

                //
                //
                //

                /*******************************************************************************************************
                 * setWssDedaDspElmHst
                 *******************************************************************************************************/
                /**
                 *
                 * @param wssDedaDspElmHst TODO_javadoc.
                 *
                 */
                public void setWssDedaDspElmHst(String wssDedaDspElmHst) {
                    replaceValue(idx_wssdedadsptblhst * length_wssdedadsptblhst + 0, idx_wssdedadsptblhst * length_wssdedadsptblhst + 2, wssDedaDspElmHst);
                }

                /*******************************************************************************************************
                 * getWssDedaDspElmHst
                 *******************************************************************************************************/
                /**
                 *
                 * @return wssDedaDspElmHst TODO_javadoc.
                 *
                 */
                public String getWssDedaDspElmHst() {
                    return subValue(idx_wssdedadsptblhst * length_wssdedadsptblhst + 0, idx_wssdedadsptblhst * length_wssdedadsptblhst + 2);
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
    public class WssDedaDspSrvGrp {

        /** TODO_javadoc. */
        private WssDedaDspSrv wssDedaDspSrv = new WssDedaDspSrv();

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssDedaDspSrvGrp() {
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
            replaceValue(0, 4096, value);
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
            return subValue(0, 4096);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setWssDedaDspSrvCpl
         *******************************************************************************************************/
        /**
         *
         * @param wssDedaDspSrvCpl TODO_javadoc.
         *
         */
        public void setWssDedaDspSrvCpl(String wssDedaDspSrvCpl) {
            replaceValue(99, 100, wssDedaDspSrvCpl);
        }

        /*******************************************************************************************************
         * getWssDedaDspSrv
         *******************************************************************************************************/
        /**
         *
         * @return wssDedaDspSrv TODO_javadoc.
         *
         */
        public WssDedaDspSrv getWssDedaDspSrv() {
            return wssDedaDspSrv;
        }

        /*******************************************************************************************************
         * getWssDedaDspSrvCpl
         *******************************************************************************************************/
        /**
         *
         * @return wssDedaDspSrvCpl TODO_javadoc.
         *
         */
        public String getWssDedaDspSrvCpl() {
            return subValue(99, 100);
        }

        /**
         *
         * TODO_javadoc.
         *
         * @author  BEE S.A.
         * @version 1.0
         *
         */
        public class WssDedaDspSrv {

            /** TODO_javadoc. */
            private WssDedaDspTblSrv[] wssDedaDspTblSrv = new WssDedaDspTblSrv[33];

            /*******************************************************************************************************
             *
             *******************************************************************************************************/
            /**
             *
             */
            public WssDedaDspSrv() {

                for (int i = 0; i < 33; i++) {
                    wssDedaDspTblSrv[i] = new WssDedaDspTblSrv(i);
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
                replaceValue(0, 99, value);
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
                return subValue(0, 99);
            }

            //
            //
            //

            /*******************************************************************************************************
             * getWssDedaDspTblSrv
             *******************************************************************************************************/
            /**
             *
             * @param i TODO_javadoc.
             *
             * @return wssDedaDspTblSrv TODO_javadoc.
             *
             */
            public WssDedaDspTblSrv getWssDedaDspTblSrv(int i) {

                if (i < 0 || i >= 33) {
                    throw new ArrayIndexOutOfBoundsException("wssDedaDspTblSrv[]: indice debe estar en rango [0..32]");
                }

                return wssDedaDspTblSrv[i];
            }

            /*******************************************************************************************************
             * getWssDedaDspTblSrvSize
             *******************************************************************************************************/
            /**
             *
             * @return TODO_javadoc.
             *
             */
            public final int getWssDedaDspTblSrvSize() {
                return 33;
            }

            /**
             *
             * TODO_javadoc.
             *
             * @author  BEE S.A.
             * @version 1.0
             *
             */
            public class WssDedaDspTblSrv {

                /** TODO_javadoc. */
                private final int length_wssdedadsptblsrv = 3;

                /** TODO_javadoc. */
                private int idx_wssdedadsptblsrv;

                /*******************************************************************************************************
                 *
                 *******************************************************************************************************/
                /**
                 *
                 * @param idx TODO_javadoc.
                 *
                 */
                public WssDedaDspTblSrv(int idx) {

                    this.idx_wssdedadsptblsrv = idx;
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
                    replaceValue(idx_wssdedadsptblsrv * length_wssdedadsptblsrv + 0, idx_wssdedadsptblsrv * length_wssdedadsptblsrv + 3, value);
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
                    return subValue(idx_wssdedadsptblsrv * length_wssdedadsptblsrv + 0, (idx_wssdedadsptblsrv + 1) * length_wssdedadsptblsrv + 0);
                }

                //
                //
                //

                /*******************************************************************************************************
                 * setWssDedaDspElmSrv
                 *******************************************************************************************************/
                /**
                 *
                 * @param wssDedaDspElmSrv TODO_javadoc.
                 *
                 */
                public void setWssDedaDspElmSrv(String wssDedaDspElmSrv) {
                    replaceValue(idx_wssdedadsptblsrv * length_wssdedadsptblsrv + 0, idx_wssdedadsptblsrv * length_wssdedadsptblsrv + 3, wssDedaDspElmSrv);
                }

                /*******************************************************************************************************
                 * getWssDedaDspElmSrv
                 *******************************************************************************************************/
                /**
                 *
                 * @return wssDedaDspElmSrv TODO_javadoc.
                 *
                 */
                public String getWssDedaDspElmSrv() {
                    return subValue(idx_wssdedadsptblsrv * length_wssdedadsptblsrv + 0, idx_wssdedadsptblsrv * length_wssdedadsptblsrv + 3);
                }

            }

        }

    }

}

