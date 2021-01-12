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
public class WssDedaBdd extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(WssDedaBdd.class);

    /** TODO_javadoc. */
    private WssDedaBddHst wssDedaBddHst = new WssDedaBddHst();

    /** TODO_javadoc. */
    private WssDedaBddSrv wssDedaBddSrv = new WssDedaBddSrv();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public WssDedaBdd() {

        initBuffer(100);

        replaceValue(0, 100, "                                                                                                    "); // WSS-DEDA-BDD
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
     * getWssDedaBddHst
     *******************************************************************************************************/
    /**
     *
     * @return wssDedaBddHst TODO_javadoc.
     *
     */
    public WssDedaBddHst getWssDedaBddHst() {
        return wssDedaBddHst;
    }

    /*******************************************************************************************************
     * getWssDedaBddSrv
     *******************************************************************************************************/
    /**
     *
     * @return wssDedaBddSrv TODO_javadoc.
     *
     */
    public WssDedaBddSrv getWssDedaBddSrv() {
        return wssDedaBddSrv;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class WssDedaBddHst {

        /** TODO_javadoc. */
        private WssDedaBddTblHst[] wssDedaBddTblHst = new WssDedaBddTblHst[50];

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssDedaBddHst() {

            for (int i = 0; i < 50; i++) {
                wssDedaBddTblHst[i] = new WssDedaBddTblHst(i);
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
         * getWssDedaBddTblHst
         *******************************************************************************************************/
        /**
         *
         * @param i TODO_javadoc.
         *
         * @return wssDedaBddTblHst TODO_javadoc.
         *
         */
        public WssDedaBddTblHst getWssDedaBddTblHst(int i) {

            if (i < 0 || i >= 50) {
                throw new ArrayIndexOutOfBoundsException("wssDedaBddTblHst[]: indice debe estar en rango [0..49]");
            }

            return wssDedaBddTblHst[i];
        }

        /*******************************************************************************************************
         * getWssDedaBddTblHstSize
         *******************************************************************************************************/
        /**
         *
         * @return TODO_javadoc.
         *
         */
        public final int getWssDedaBddTblHstSize() {
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
        public class WssDedaBddTblHst {

            /** TODO_javadoc. */
            private final int length_wssdedabddtblhst = 2;

            /** TODO_javadoc. */
            private int idx_wssdedabddtblhst;

            /*******************************************************************************************************
             *
             *******************************************************************************************************/
            /**
             *
             * @param idx TODO_javadoc.
             *
             */
            public WssDedaBddTblHst(int idx) {

                this.idx_wssdedabddtblhst = idx;
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
                replaceValue(idx_wssdedabddtblhst * length_wssdedabddtblhst + 0, idx_wssdedabddtblhst * length_wssdedabddtblhst + 2, value);
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
                return subValue(idx_wssdedabddtblhst * length_wssdedabddtblhst + 0, (idx_wssdedabddtblhst + 1) * length_wssdedabddtblhst + 0);
            }

            //
            //
            //

            /*******************************************************************************************************
             * setWssDedaBddElmHst
             *******************************************************************************************************/
            /**
             *
             * @param wssDedaBddElmHst TODO_javadoc.
             *
             */
            public void setWssDedaBddElmHst(String wssDedaBddElmHst) {
                replaceValue(idx_wssdedabddtblhst * length_wssdedabddtblhst + 0, idx_wssdedabddtblhst * length_wssdedabddtblhst + 2, wssDedaBddElmHst);
            }

            /*******************************************************************************************************
             * getWssDedaBddElmHst
             *******************************************************************************************************/
            /**
             *
             * @return wssDedaBddElmHst TODO_javadoc.
             *
             */
            public String getWssDedaBddElmHst() {
                return subValue(idx_wssdedabddtblhst * length_wssdedabddtblhst + 0, idx_wssdedabddtblhst * length_wssdedabddtblhst + 2);
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
    public class WssDedaBddSrv {

        /** TODO_javadoc. */
        private WssDedaBddTblSrv[] wssDedaBddTblSrv = new WssDedaBddTblSrv[33];

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssDedaBddSrv() {

            for (int i = 0; i < 33; i++) {
                wssDedaBddTblSrv[i] = new WssDedaBddTblSrv(i);
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
         * setWssDedaBddCpl
         *******************************************************************************************************/
        /**
         *
         * @param wssDedaBddCpl TODO_javadoc.
         *
         */
        public void setWssDedaBddCpl(String wssDedaBddCpl) {
            replaceValue(99, 100, wssDedaBddCpl);
        }

        /*******************************************************************************************************
         * getWssDedaBddTblSrv
         *******************************************************************************************************/
        /**
         *
         * @param i TODO_javadoc.
         *
         * @return wssDedaBddTblSrv TODO_javadoc.
         *
         */
        public WssDedaBddTblSrv getWssDedaBddTblSrv(int i) {

            if (i < 0 || i >= 33) {
                throw new ArrayIndexOutOfBoundsException("wssDedaBddTblSrv[]: indice debe estar en rango [0..32]");
            }

            return wssDedaBddTblSrv[i];
        }

        /*******************************************************************************************************
         * getWssDedaBddTblSrvSize
         *******************************************************************************************************/
        /**
         *
         * @return TODO_javadoc.
         *
         */
        public final int getWssDedaBddTblSrvSize() {
            return 33;
        }

        /*******************************************************************************************************
         * getWssDedaBddCpl
         *******************************************************************************************************/
        /**
         *
         * @return wssDedaBddCpl TODO_javadoc.
         *
         */
        public String getWssDedaBddCpl() {
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
        public class WssDedaBddTblSrv {

            /** TODO_javadoc. */
            private final int length_wssdedabddtblsrv = 3;

            /** TODO_javadoc. */
            private int idx_wssdedabddtblsrv;

            /*******************************************************************************************************
             *
             *******************************************************************************************************/
            /**
             *
             * @param idx TODO_javadoc.
             *
             */
            public WssDedaBddTblSrv(int idx) {

                this.idx_wssdedabddtblsrv = idx;
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
                replaceValue(idx_wssdedabddtblsrv * length_wssdedabddtblsrv + 0, idx_wssdedabddtblsrv * length_wssdedabddtblsrv + 3, value);
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
                return subValue(idx_wssdedabddtblsrv * length_wssdedabddtblsrv + 0, (idx_wssdedabddtblsrv + 1) * length_wssdedabddtblsrv + 0);
            }

            //
            //
            //

            /*******************************************************************************************************
             * setWssDedaBddElmSrv
             *******************************************************************************************************/
            /**
             *
             * @param wssDedaBddElmSrv TODO_javadoc.
             *
             */
            public void setWssDedaBddElmSrv(String wssDedaBddElmSrv) {
                replaceValue(idx_wssdedabddtblsrv * length_wssdedabddtblsrv + 0, idx_wssdedabddtblsrv * length_wssdedabddtblsrv + 3, wssDedaBddElmSrv);
            }

            /*******************************************************************************************************
             * getWssDedaBddElmSrv
             *******************************************************************************************************/
            /**
             *
             * @return wssDedaBddElmSrv TODO_javadoc.
             *
             */
            public String getWssDedaBddElmSrv() {
                return subValue(idx_wssdedabddtblsrv * length_wssdedabddtblsrv + 0, idx_wssdedabddtblsrv * length_wssdedabddtblsrv + 3);
            }

        }

    }

}

