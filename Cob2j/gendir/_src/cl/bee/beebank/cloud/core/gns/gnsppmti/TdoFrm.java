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
public class TdoFrm extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(TdoFrm.class);

    /** TODO_javadoc. */
    private TdoHdrFrm tdoHdrFrm = new TdoHdrFrm();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public TdoFrm() {

        initBuffer(1920);

        replaceValue(0, 1920, "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                "); // TDO-FRM
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
     * getTdoHdrFrm
     *******************************************************************************************************/
    /**
     *
     * @return tdoHdrFrm TODO_javadoc.
     *
     */
    public TdoHdrFrm getTdoHdrFrm() {
        return tdoHdrFrm;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class TdoHdrFrm {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public TdoHdrFrm() {
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
         * setTdoCodSistFrm
         *******************************************************************************************************/
        /**
         *
         * @param tdoCodSistFrm TODO_javadoc.
         *
         */
        public void setTdoCodSistFrm(String tdoCodSistFrm) {
            replaceValue(0, 3, tdoCodSistFrm);
        }

        /*******************************************************************************************************
         * setTdoCodNemoFrm
         *******************************************************************************************************/
        /**
         *
         * @param tdoCodNemoFrm TODO_javadoc.
         *
         */
        public void setTdoCodNemoFrm(String tdoCodNemoFrm) {
            replaceValue(3, 15, tdoCodNemoFrm);
        }

        /*******************************************************************************************************
         * setTdoCodNfrmFrm
         *******************************************************************************************************/
        /**
         *
         * @param tdoCodNfrmFrm TODO_javadoc.
         *
         */
        public void setTdoCodNfrmFrm(String tdoCodNfrmFrm) {
            replaceValue(15, 22, tdoCodNfrmFrm);
        }

        /*******************************************************************************************************
         * setTdoCodFinpFrm
         *******************************************************************************************************/
        /**
         *
         * @param tdoCodFinpFrm TODO_javadoc.
         *
         */
        public void setTdoCodFinpFrm(String tdoCodFinpFrm) {
            replaceValue(22, 25, tdoCodFinpFrm);
        }

        /*******************************************************************************************************
         * setTdoCodFoutFrm
         *******************************************************************************************************/
        /**
         *
         * @param tdoCodFoutFrm TODO_javadoc.
         *
         */
        public void setTdoCodFoutFrm(String tdoCodFoutFrm) {
            replaceValue(25, 28, tdoCodFoutFrm);
        }

        /*******************************************************************************************************
         * setTdoGlsDispFrm
         *******************************************************************************************************/
        /**
         *
         * @param tdoGlsDispFrm TODO_javadoc.
         *
         */
        public void setTdoGlsDispFrm(String tdoGlsDispFrm) {
            replaceValue(28, 1920, tdoGlsDispFrm);
        }

        /*******************************************************************************************************
         * getTdoCodSistFrm
         *******************************************************************************************************/
        /**
         *
         * @return tdoCodSistFrm TODO_javadoc.
         *
         */
        public String getTdoCodSistFrm() {
            return subValue(0, 3);
        }

        /*******************************************************************************************************
         * getTdoCodNemoFrm
         *******************************************************************************************************/
        /**
         *
         * @return tdoCodNemoFrm TODO_javadoc.
         *
         */
        public String getTdoCodNemoFrm() {
            return subValue(3, 15);
        }

        /*******************************************************************************************************
         * getTdoCodNfrmFrm
         *******************************************************************************************************/
        /**
         *
         * @return tdoCodNfrmFrm TODO_javadoc.
         *
         */
        public String getTdoCodNfrmFrm() {
            return subValue(15, 22);
        }

        /*******************************************************************************************************
         * getTdoCodFinpFrm
         *******************************************************************************************************/
        /**
         *
         * @return tdoCodFinpFrm TODO_javadoc.
         *
         */
        public String getTdoCodFinpFrm() {
            return subValue(22, 25);
        }

        /*******************************************************************************************************
         * getTdoCodFoutFrm
         *******************************************************************************************************/
        /**
         *
         * @return tdoCodFoutFrm TODO_javadoc.
         *
         */
        public String getTdoCodFoutFrm() {
            return subValue(25, 28);
        }

        /*******************************************************************************************************
         * getTdoGlsDispFrm
         *******************************************************************************************************/
        /**
         *
         * @return tdoGlsDispFrm TODO_javadoc.
         *
         */
        public String getTdoGlsDispFrm() {
            return subValue(28, 1920);
        }

    }

}

