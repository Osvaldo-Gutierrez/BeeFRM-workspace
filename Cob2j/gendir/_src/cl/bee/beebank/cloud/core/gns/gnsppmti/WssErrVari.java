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
public class WssErrVari extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(WssErrVari.class);

    /** TODO_javadoc. */
    private static DecimalFormat form3z = new DecimalFormat("000");

    /** TODO_javadoc. */
    private static DecimalFormat form4z = new DecimalFormat("0000");

    /** TODO_javadoc. */
    private static DecimalFormat form5z = new DecimalFormat("00000");

    /** TODO_javadoc. */
    private WssMsgPtc wssMsgPtc = new WssMsgPtc();

    /** TODO_javadoc. */
    private WssSepNfrm wssSepNfrm = new WssSepNfrm();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public WssErrVari() {

        initBuffer(59);

        replaceValue(0, 59, " 000000000000000000                0000                    "); // WSS-ERR-VARI
        replaceValue(39, 59, "                    "); // WSS-GLS-ERR-PTC
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
        replaceValue(0, 59, value);
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
        return subValue(0, 59);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setWssDtcErr
     *******************************************************************************************************/
    /**
     *
     * @param wssDtcErr TODO_javadoc.
     *
     */
    public void setWssDtcErr(String wssDtcErr) {
        replaceValue(0, 1, wssDtcErr);
    }

    /*******************************************************************************************************
     * setWssIdxErr
     *******************************************************************************************************/
    /**
     *
     * @param wssIdxErr TODO_javadoc.
     *
     */
    public void setWssIdxErr(int wssIdxErr) {
        replaceValue(1, 6, form5z.format(wssIdxErr));
    }

    /*******************************************************************************************************
     * setWssIdxFldErr
     *******************************************************************************************************/
    /**
     *
     * @param wssIdxFldErr TODO_javadoc.
     *
     */
    public void setWssIdxFldErr(int wssIdxFldErr) {
        replaceValue(6, 11, form5z.format(wssIdxFldErr));
    }

    /*******************************************************************************************************
     * setWssMaxFldHst
     *******************************************************************************************************/
    /**
     *
     * @param wssMaxFldHst TODO_javadoc.
     *
     */
    public void setWssMaxFldHst(int wssMaxFldHst) {
        replaceValue(11, 16, form5z.format(wssMaxFldHst));
    }

    /*******************************************************************************************************
     * setWssNumL3
     *******************************************************************************************************/
    /**
     *
     * @param wssNumL3 TODO_javadoc.
     *
     */
    public void setWssNumL3(int wssNumL3) {
        replaceValue(16, 19, form3z.format(wssNumL3));
    }

    /*******************************************************************************************************
     * setWssNumErrPtc
     *******************************************************************************************************/
    /**
     *
     * @param wssNumErrPtc TODO_javadoc.
     *
     */
    public void setWssNumErrPtc(int wssNumErrPtc) {
        replaceValue(35, 39, form4z.format(wssNumErrPtc));
    }

    /*******************************************************************************************************
     * setWssGlsErrPtc
     *******************************************************************************************************/
    /**
     *
     * @param wssGlsErrPtc TODO_javadoc.
     *
     */
    public void setWssGlsErrPtc(String wssGlsErrPtc) {
        replaceValue(39, 59, wssGlsErrPtc);
    }

    /*******************************************************************************************************
     * getWssDtcErr
     *******************************************************************************************************/
    /**
     *
     * @return wssDtcErr TODO_javadoc.
     *
     */
    public String getWssDtcErr() {
        return subValue(0, 1);
    }

    /*******************************************************************************************************
     * getWssIdxErr
     *******************************************************************************************************/
    /**
     *
     * @return wssIdxErr TODO_javadoc.
     *
     */
    public int getWssIdxErr() {
        return Integer.parseInt(subValue(1, 6));
    }

    /*******************************************************************************************************
     * getWssIdxFldErr
     *******************************************************************************************************/
    /**
     *
     * @return wssIdxFldErr TODO_javadoc.
     *
     */
    public int getWssIdxFldErr() {
        return Integer.parseInt(subValue(6, 11));
    }

    /*******************************************************************************************************
     * getWssMaxFldHst
     *******************************************************************************************************/
    /**
     *
     * @return wssMaxFldHst TODO_javadoc.
     *
     */
    public int getWssMaxFldHst() {
        return Integer.parseInt(subValue(11, 16));
    }

    /*******************************************************************************************************
     * getWssNumL3
     *******************************************************************************************************/
    /**
     *
     * @return wssNumL3 TODO_javadoc.
     *
     */
    public int getWssNumL3() {
        return Integer.parseInt(subValue(16, 19));
    }

    /*******************************************************************************************************
     * getWssMsgPtc
     *******************************************************************************************************/
    /**
     *
     * @return wssMsgPtc TODO_javadoc.
     *
     */
    public WssMsgPtc getWssMsgPtc() {
        return wssMsgPtc;
    }

    /*******************************************************************************************************
     * getWssSepNfrm
     *******************************************************************************************************/
    /**
     *
     * @return wssSepNfrm TODO_javadoc.
     *
     */
    public WssSepNfrm getWssSepNfrm() {
        return wssSepNfrm;
    }

    /*******************************************************************************************************
     * getWssNumErrPtc
     *******************************************************************************************************/
    /**
     *
     * @return wssNumErrPtc TODO_javadoc.
     *
     */
    public int getWssNumErrPtc() {
        return Integer.parseInt(subValue(35, 39));
    }

    /*******************************************************************************************************
     * getWssGlsErrPtc
     *******************************************************************************************************/
    /**
     *
     * @return wssGlsErrPtc TODO_javadoc.
     *
     */
    public String getWssGlsErrPtc() {
        return subValue(39, 59);
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class WssMsgPtc {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssMsgPtc() {
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
            replaceValue(19, 28, value);
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
            return subValue(19, 19 + 9);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setWssMsgPtc0
         *******************************************************************************************************/
        /**
         *
         * @param wssMsgPtc0 TODO_javadoc.
         *
         */
        public void setWssMsgPtc0(String wssMsgPtc0) {
            replaceValue(19, 21, wssMsgPtc0);
        }

        /*******************************************************************************************************
         * setWssMsgPtc1
         *******************************************************************************************************/
        /**
         *
         * @param wssMsgPtc1 TODO_javadoc.
         *
         */
        public void setWssMsgPtc1(String wssMsgPtc1) {
            replaceValue(21, 24, wssMsgPtc1);
        }

        /*******************************************************************************************************
         * setWssMsgPtc3
         *******************************************************************************************************/
        /**
         *
         * @param wssMsgPtc3 TODO_javadoc.
         *
         */
        public void setWssMsgPtc3(String wssMsgPtc3) {
            replaceValue(24, 28, wssMsgPtc3);
        }

        /*******************************************************************************************************
         * getWssMsgPtc0
         *******************************************************************************************************/
        /**
         *
         * @return wssMsgPtc0 TODO_javadoc.
         *
         */
        public String getWssMsgPtc0() {
            return subValue(19, 21);
        }

        /*******************************************************************************************************
         * getWssMsgPtc1
         *******************************************************************************************************/
        /**
         *
         * @return wssMsgPtc1 TODO_javadoc.
         *
         */
        public String getWssMsgPtc1() {
            return subValue(21, 24);
        }

        /*******************************************************************************************************
         * getWssMsgPtc3
         *******************************************************************************************************/
        /**
         *
         * @return wssMsgPtc3 TODO_javadoc.
         *
         */
        public String getWssMsgPtc3() {
            return subValue(24, 28);
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
    public class WssSepNfrm {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssSepNfrm() {
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
            replaceValue(28, 35, value);
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
            return subValue(28, 28 + 7);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setWssSepNfrm1
         *******************************************************************************************************/
        /**
         *
         * @param wssSepNfrm1 TODO_javadoc.
         *
         */
        public void setWssSepNfrm1(String wssSepNfrm1) {
            replaceValue(28, 32, wssSepNfrm1);
        }

        /*******************************************************************************************************
         * setWssSepNfrm2
         *******************************************************************************************************/
        /**
         *
         * @param wssSepNfrm2 TODO_javadoc.
         *
         */
        public void setWssSepNfrm2(String wssSepNfrm2) {
            replaceValue(32, 35, wssSepNfrm2);
        }

        /*******************************************************************************************************
         * getWssSepNfrm1
         *******************************************************************************************************/
        /**
         *
         * @return wssSepNfrm1 TODO_javadoc.
         *
         */
        public String getWssSepNfrm1() {
            return subValue(28, 32);
        }

        /*******************************************************************************************************
         * getWssSepNfrm2
         *******************************************************************************************************/
        /**
         *
         * @return wssSepNfrm2 TODO_javadoc.
         *
         */
        public String getWssSepNfrm2() {
            return subValue(32, 35);
        }

    }

}

