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
public class Logmsg extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(Logmsg.class);

    /** TODO_javadoc. */
    private LogmsgText logmsgText = new LogmsgText();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public Logmsg() {

        initBuffer(70);

        replaceValue(0, 70, "                                                                      "); // LOGMSG
        replaceValue(0, 10, "GNSPQTAB :"); // LOGMSG-PROG
        replaceValue(10, 12, "00"); // LOGMSG-NUMB
        replaceValue(12, 20, "00000000"); // LOGMSG-TIME
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
        replaceValue(0, 70, value);
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
        return subValue(0, 70);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setLogmsgProg
     *******************************************************************************************************/
    /**
     *
     * @param logmsgProg TODO_javadoc.
     *
     */
    public void setLogmsgProg(String logmsgProg) {
        replaceValue(0, 10, logmsgProg);
    }

    /*******************************************************************************************************
     * setLogmsgNumb
     *******************************************************************************************************/
    /**
     *
     * @param logmsgNumb TODO_javadoc.
     *
     */
    public void setLogmsgNumb(String logmsgNumb) {
        replaceValue(10, 12, logmsgNumb);
    }

    /*******************************************************************************************************
     * setLogmsgTime
     *******************************************************************************************************/
    /**
     *
     * @param logmsgTime TODO_javadoc.
     *
     */
    public void setLogmsgTime(String logmsgTime) {
        replaceValue(12, 20, logmsgTime);
    }

    /*******************************************************************************************************
     * getLogmsgProg
     *******************************************************************************************************/
    /**
     *
     * @return logmsgProg TODO_javadoc.
     *
     */
    public String getLogmsgProg() {
        return subValue(0, 10);
    }

    /*******************************************************************************************************
     * getLogmsgNumb
     *******************************************************************************************************/
    /**
     *
     * @return logmsgNumb TODO_javadoc.
     *
     */
    public String getLogmsgNumb() {
        return subValue(10, 12);
    }

    /*******************************************************************************************************
     * getLogmsgTime
     *******************************************************************************************************/
    /**
     *
     * @return logmsgTime TODO_javadoc.
     *
     */
    public String getLogmsgTime() {
        return subValue(12, 20);
    }

    /*******************************************************************************************************
     * getLogmsgText
     *******************************************************************************************************/
    /**
     *
     * @return logmsgText TODO_javadoc.
     *
     */
    public LogmsgText getLogmsgText() {
        return logmsgText;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class LogmsgText {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public LogmsgText() {
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
            replaceValue(20, 70, value);
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
            return subValue(20, 20 + 50);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setLogmsgText1
         *******************************************************************************************************/
        /**
         *
         * @param logmsgText1 TODO_javadoc.
         *
         */
        public void setLogmsgText1(String logmsgText1) {
            replaceValue(20, 24, logmsgText1);
        }

        /*******************************************************************************************************
         * setLogmsgText2
         *******************************************************************************************************/
        /**
         *
         * @param logmsgText2 TODO_javadoc.
         *
         */
        public void setLogmsgText2(String logmsgText2) {
            replaceValue(24, 30, logmsgText2);
        }

        /*******************************************************************************************************
         * setLogmsgText3
         *******************************************************************************************************/
        /**
         *
         * @param logmsgText3 TODO_javadoc.
         *
         */
        public void setLogmsgText3(String logmsgText3) {
            replaceValue(30, 70, logmsgText3);
        }

        /*******************************************************************************************************
         * getLogmsgText1
         *******************************************************************************************************/
        /**
         *
         * @return logmsgText1 TODO_javadoc.
         *
         */
        public String getLogmsgText1() {
            return subValue(20, 24);
        }

        /*******************************************************************************************************
         * getLogmsgText2
         *******************************************************************************************************/
        /**
         *
         * @return logmsgText2 TODO_javadoc.
         *
         */
        public String getLogmsgText2() {
            return subValue(24, 30);
        }

        /*******************************************************************************************************
         * getLogmsgText3
         *******************************************************************************************************/
        /**
         *
         * @return logmsgText3 TODO_javadoc.
         *
         */
        public String getLogmsgText3() {
            return subValue(30, 70);
        }

    }

}

