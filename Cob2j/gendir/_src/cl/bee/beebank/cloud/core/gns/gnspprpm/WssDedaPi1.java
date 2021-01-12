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
public class WssDedaPi1 extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(WssDedaPi1.class);

    /** TODO_javadoc. */
    private WssDedaPi1Hst wssDedaPi1Hst = new WssDedaPi1Hst();

    /** TODO_javadoc. */
    private WssDedaPi1Srv wssDedaPi1Srv = new WssDedaPi1Srv();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public WssDedaPi1() {

        initBuffer(100);

        replaceValue(0, 100, "                                                                                                    "); // WSS-DEDA-PI1
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
     * getWssDedaPi1Hst
     *******************************************************************************************************/
    /**
     *
     * @return wssDedaPi1Hst TODO_javadoc.
     *
     */
    public WssDedaPi1Hst getWssDedaPi1Hst() {
        return wssDedaPi1Hst;
    }

    /*******************************************************************************************************
     * getWssDedaPi1Srv
     *******************************************************************************************************/
    /**
     *
     * @return wssDedaPi1Srv TODO_javadoc.
     *
     */
    public WssDedaPi1Srv getWssDedaPi1Srv() {
        return wssDedaPi1Srv;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class WssDedaPi1Hst {

        /** TODO_javadoc. */
        private WssDedaPi1TblHst[] wssDedaPi1TblHst = new WssDedaPi1TblHst[50];

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssDedaPi1Hst() {

            for (int i = 0; i < 50; i++) {
                wssDedaPi1TblHst[i] = new WssDedaPi1TblHst(i);
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
         * getWssDedaPi1TblHst
         *******************************************************************************************************/
        /**
         *
         * @param i TODO_javadoc.
         *
         * @return wssDedaPi1TblHst TODO_javadoc.
         *
         */
        public WssDedaPi1TblHst getWssDedaPi1TblHst(int i) {

            if (i < 0 || i >= 50) {
                throw new ArrayIndexOutOfBoundsException("wssDedaPi1TblHst[]: indice debe estar en rango [0..49]");
            }

            return wssDedaPi1TblHst[i];
        }

        /*******************************************************************************************************
         * getWssDedaPi1TblHstSize
         *******************************************************************************************************/
        /**
         *
         * @return TODO_javadoc.
         *
         */
        public final int getWssDedaPi1TblHstSize() {
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
        public class WssDedaPi1TblHst {

            /** TODO_javadoc. */
            private final int length_wssdedapi1tblhst = 2;

            /** TODO_javadoc. */
            private int idx_wssdedapi1tblhst;

            /*******************************************************************************************************
             *
             *******************************************************************************************************/
            /**
             *
             * @param idx TODO_javadoc.
             *
             */
            public WssDedaPi1TblHst(int idx) {

                this.idx_wssdedapi1tblhst = idx;
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
                replaceValue(idx_wssdedapi1tblhst * length_wssdedapi1tblhst + 0, idx_wssdedapi1tblhst * length_wssdedapi1tblhst + 2, value);
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
                return subValue(idx_wssdedapi1tblhst * length_wssdedapi1tblhst + 0, (idx_wssdedapi1tblhst + 1) * length_wssdedapi1tblhst + 0);
            }

            //
            //
            //

            /*******************************************************************************************************
             * setWssDedaPi1ElmHst
             *******************************************************************************************************/
            /**
             *
             * @param wssDedaPi1ElmHst TODO_javadoc.
             *
             */
            public void setWssDedaPi1ElmHst(String wssDedaPi1ElmHst) {
                replaceValue(idx_wssdedapi1tblhst * length_wssdedapi1tblhst + 0, idx_wssdedapi1tblhst * length_wssdedapi1tblhst + 2, wssDedaPi1ElmHst);
            }

            /*******************************************************************************************************
             * getWssDedaPi1ElmHst
             *******************************************************************************************************/
            /**
             *
             * @return wssDedaPi1ElmHst TODO_javadoc.
             *
             */
            public String getWssDedaPi1ElmHst() {
                return subValue(idx_wssdedapi1tblhst * length_wssdedapi1tblhst + 0, idx_wssdedapi1tblhst * length_wssdedapi1tblhst + 2);
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
    public class WssDedaPi1Srv {

        /** TODO_javadoc. */
        private WssDedaPi1TblSrv[] wssDedaPi1TblSrv = new WssDedaPi1TblSrv[33];

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssDedaPi1Srv() {

            for (int i = 0; i < 33; i++) {
                wssDedaPi1TblSrv[i] = new WssDedaPi1TblSrv(i);
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
         * setWssDedaPi1Cpl
         *******************************************************************************************************/
        /**
         *
         * @param wssDedaPi1Cpl TODO_javadoc.
         *
         */
        public void setWssDedaPi1Cpl(String wssDedaPi1Cpl) {
            replaceValue(99, 100, wssDedaPi1Cpl);
        }

        /*******************************************************************************************************
         * getWssDedaPi1TblSrv
         *******************************************************************************************************/
        /**
         *
         * @param i TODO_javadoc.
         *
         * @return wssDedaPi1TblSrv TODO_javadoc.
         *
         */
        public WssDedaPi1TblSrv getWssDedaPi1TblSrv(int i) {

            if (i < 0 || i >= 33) {
                throw new ArrayIndexOutOfBoundsException("wssDedaPi1TblSrv[]: indice debe estar en rango [0..32]");
            }

            return wssDedaPi1TblSrv[i];
        }

        /*******************************************************************************************************
         * getWssDedaPi1TblSrvSize
         *******************************************************************************************************/
        /**
         *
         * @return TODO_javadoc.
         *
         */
        public final int getWssDedaPi1TblSrvSize() {
            return 33;
        }

        /*******************************************************************************************************
         * getWssDedaPi1Cpl
         *******************************************************************************************************/
        /**
         *
         * @return wssDedaPi1Cpl TODO_javadoc.
         *
         */
        public String getWssDedaPi1Cpl() {
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
        public class WssDedaPi1TblSrv {

            /** TODO_javadoc. */
            private final int length_wssdedapi1tblsrv = 3;

            /** TODO_javadoc. */
            private int idx_wssdedapi1tblsrv;

            /*******************************************************************************************************
             *
             *******************************************************************************************************/
            /**
             *
             * @param idx TODO_javadoc.
             *
             */
            public WssDedaPi1TblSrv(int idx) {

                this.idx_wssdedapi1tblsrv = idx;
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
                replaceValue(idx_wssdedapi1tblsrv * length_wssdedapi1tblsrv + 0, idx_wssdedapi1tblsrv * length_wssdedapi1tblsrv + 3, value);
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
                return subValue(idx_wssdedapi1tblsrv * length_wssdedapi1tblsrv + 0, (idx_wssdedapi1tblsrv + 1) * length_wssdedapi1tblsrv + 0);
            }

            //
            //
            //

            /*******************************************************************************************************
             * setWssDedaPi1ElmSrv
             *******************************************************************************************************/
            /**
             *
             * @param wssDedaPi1ElmSrv TODO_javadoc.
             *
             */
            public void setWssDedaPi1ElmSrv(String wssDedaPi1ElmSrv) {
                replaceValue(idx_wssdedapi1tblsrv * length_wssdedapi1tblsrv + 0, idx_wssdedapi1tblsrv * length_wssdedapi1tblsrv + 3, wssDedaPi1ElmSrv);
            }

            /*******************************************************************************************************
             * getWssDedaPi1ElmSrv
             *******************************************************************************************************/
            /**
             *
             * @return wssDedaPi1ElmSrv TODO_javadoc.
             *
             */
            public String getWssDedaPi1ElmSrv() {
                return subValue(idx_wssdedapi1tblsrv * length_wssdedapi1tblsrv + 0, idx_wssdedapi1tblsrv * length_wssdedapi1tblsrv + 3);
            }

        }

    }

}

