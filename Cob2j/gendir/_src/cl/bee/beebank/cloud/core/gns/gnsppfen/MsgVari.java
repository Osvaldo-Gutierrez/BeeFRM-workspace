/*
 *   Copyright (c) 2021 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.beebank.cloud.core.gns.gnsppfen;


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
public class MsgVari extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(MsgVari.class);

    /** TODO_javadoc. */
    private MsgGlsFmsg msgGlsFmsg = new MsgGlsFmsg();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public MsgVari() {

        initBuffer(8);

        replaceValue(0, 8, "        "); // MSG-VARI
        replaceValue(3, 8, "PFTAB"); // MSG-COD-FMSG
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
        replaceValue(0, 8, value);
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
        return subValue(0, 8);
    }

    //
    //
    //

    /*******************************************************************************************************
     * getMsgGlsFmsg
     *******************************************************************************************************/
    /**
     *
     * @return msgGlsFmsg TODO_javadoc.
     *
     */
    public MsgGlsFmsg getMsgGlsFmsg() {
        return msgGlsFmsg;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class MsgGlsFmsg {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public MsgGlsFmsg() {
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
            replaceValue(0, 8, value);
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
            return subValue(0, 8);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setMsgCodSist
         *******************************************************************************************************/
        /**
         *
         * @param msgCodSist TODO_javadoc.
         *
         */
        public void setMsgCodSist(String msgCodSist) {
            replaceValue(0, 3, msgCodSist);
        }

        /*******************************************************************************************************
         * setMsgCodFmsg
         *******************************************************************************************************/
        /**
         *
         * @param msgCodFmsg TODO_javadoc.
         *
         */
        public void setMsgCodFmsg(String msgCodFmsg) {
            replaceValue(3, 8, msgCodFmsg);
        }

        /*******************************************************************************************************
         * getMsgCodSist
         *******************************************************************************************************/
        /**
         *
         * @return msgCodSist TODO_javadoc.
         *
         */
        public String getMsgCodSist() {
            return subValue(0, 3);
        }

        /*******************************************************************************************************
         * getMsgCodFmsg
         *******************************************************************************************************/
        /**
         *
         * @return msgCodFmsg TODO_javadoc.
         *
         */
        public String getMsgCodFmsg() {
            return subValue(3, 8);
        }

    }

}

