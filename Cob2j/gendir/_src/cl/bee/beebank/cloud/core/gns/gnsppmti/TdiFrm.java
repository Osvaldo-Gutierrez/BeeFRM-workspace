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
public class TdiFrm extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(TdiFrm.class);

    /** TODO_javadoc. */
    private TdiHdrFrm tdiHdrFrm = new TdiHdrFrm();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public TdiFrm() {

        initBuffer(1920);

        replaceValue(0, 1920, "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "); // TDI-FRM
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
        replaceValue(0, 1920, value);
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
        return subValue(0, 1920);
    }

    //
    //
    //

    /*******************************************************************************************************
     * getTdiHdrFrm
     *******************************************************************************************************/
    /**
     *
     * @return tdiHdrFrm TODO_javadoc.
     *
     */
    public TdiHdrFrm getTdiHdrFrm() {
        return tdiHdrFrm;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class TdiHdrFrm {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public TdiHdrFrm() {
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
            replaceValue(0, 1920, value);
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
            return subValue(0, 1920);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setTdiCodSistFrm
         *******************************************************************************************************/
        /**
         *
         * @param tdiCodSistFrm TODO_javadoc.
         *
         */
        public void setTdiCodSistFrm(String tdiCodSistFrm) {
            replaceValue(0, 3, tdiCodSistFrm);
        }

        /*******************************************************************************************************
         * setTdiCodNemoFrm
         *******************************************************************************************************/
        /**
         *
         * @param tdiCodNemoFrm TODO_javadoc.
         *
         */
        public void setTdiCodNemoFrm(String tdiCodNemoFrm) {
            replaceValue(3, 15, tdiCodNemoFrm);
        }

        /*******************************************************************************************************
         * setTdiCodFinpFrm
         *******************************************************************************************************/
        /**
         *
         * @param tdiCodFinpFrm TODO_javadoc.
         *
         */
        public void setTdiCodFinpFrm(String tdiCodFinpFrm) {
            replaceValue(15, 18, tdiCodFinpFrm);
        }

        /*******************************************************************************************************
         * setTdiCodFoutFrm
         *******************************************************************************************************/
        /**
         *
         * @param tdiCodFoutFrm TODO_javadoc.
         *
         */
        public void setTdiCodFoutFrm(String tdiCodFoutFrm) {
            replaceValue(18, 21, tdiCodFoutFrm);
        }

        /*******************************************************************************************************
         * setTdiGlsDispFrm
         *******************************************************************************************************/
        /**
         *
         * @param tdiGlsDispFrm TODO_javadoc.
         *
         */
        public void setTdiGlsDispFrm(String tdiGlsDispFrm) {
            replaceValue(21, 1920, tdiGlsDispFrm);
        }

        /*******************************************************************************************************
         * getTdiCodSistFrm
         *******************************************************************************************************/
        /**
         *
         * @return tdiCodSistFrm TODO_javadoc.
         *
         */
        public String getTdiCodSistFrm() {
            return subValue(0, 3);
        }

        /*******************************************************************************************************
         * getTdiCodNemoFrm
         *******************************************************************************************************/
        /**
         *
         * @return tdiCodNemoFrm TODO_javadoc.
         *
         */
        public String getTdiCodNemoFrm() {
            return subValue(3, 15);
        }

        /*******************************************************************************************************
         * getTdiCodFinpFrm
         *******************************************************************************************************/
        /**
         *
         * @return tdiCodFinpFrm TODO_javadoc.
         *
         */
        public String getTdiCodFinpFrm() {
            return subValue(15, 18);
        }

        /*******************************************************************************************************
         * getTdiCodFoutFrm
         *******************************************************************************************************/
        /**
         *
         * @return tdiCodFoutFrm TODO_javadoc.
         *
         */
        public String getTdiCodFoutFrm() {
            return subValue(18, 21);
        }

        /*******************************************************************************************************
         * getTdiGlsDispFrm
         *******************************************************************************************************/
        /**
         *
         * @return tdiGlsDispFrm TODO_javadoc.
         *
         */
        public String getTdiGlsDispFrm() {
            return subValue(21, 1920);
        }

    }

}

