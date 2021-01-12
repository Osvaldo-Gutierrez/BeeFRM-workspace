/*
 *   Copyright (c) 2021 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.beebank.cloud.core.gns.gnsppidd;


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
public class QueVari extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(QueVari.class);

    /** TODO_javadoc. */
    private static DecimalFormat form4z = new DecimalFormat("0000");

    /** TODO_javadoc. */
    private QueCola queCola = new QueCola();

    /** TODO_javadoc. */
    private QueItem queItem = new QueItem();

    /** TODO_javadoc. */
    private QueMens queMens = new QueMens();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public QueVari() {

        initBuffer(3121);

        replaceValue(0, 3121, "        000{000{   000{000{                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      "); // QUE-VARI
        replaceValue(8, 12, setCompNumber(0, form4z)); // QUE-NITM
        replaceValue(19, 23, setCompNumber(0, form4z)); // QUE-LDAT
        replaceValue(23, 27, setCompNumber(0, form4z)); // QUE-PCUR
        replaceValue(3027, 3030, "OKS"); // QUE-STAT
        replaceValue(3030, 3033, "OKS"); // QUE-STAT-OKS
        replaceValue(3033, 3036, "NEX"); // QUE-STAT-NEX
        replaceValue(3036, 3039, "EOQ"); // QUE-STAT-EOQ
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
        replaceValue(0, 3121, value);
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
        return subValue(0, 3121);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setQueNitm
     *******************************************************************************************************/
    /**
     *
     * @param queNitm TODO_javadoc.
     *
     */
    public void setQueNitm(int queNitm) {
        replaceValue(8, 12, setCompNumber(queNitm, form4z));
    }

    /*******************************************************************************************************
     * setQueLitm
     *******************************************************************************************************/
    /**
     *
     * @param queLitm TODO_javadoc.
     *
     */
    public void setQueLitm(int queLitm) {
        replaceValue(12, 16, setCompNumber(queLitm, form4z));
    }

    /*******************************************************************************************************
     * setQueStat
     *******************************************************************************************************/
    /**
     *
     * @param queStat TODO_javadoc.
     *
     */
    public void setQueStat(String queStat) {
        replaceValue(3027, 3030, queStat);
    }

    /*******************************************************************************************************
     * setQueStatOks
     *******************************************************************************************************/
    /**
     *
     * @param queStatOks TODO_javadoc.
     *
     */
    public void setQueStatOks(String queStatOks) {
        replaceValue(3030, 3033, queStatOks);
    }

    /*******************************************************************************************************
     * setQueStatNex
     *******************************************************************************************************/
    /**
     *
     * @param queStatNex TODO_javadoc.
     *
     */
    public void setQueStatNex(String queStatNex) {
        replaceValue(3033, 3036, queStatNex);
    }

    /*******************************************************************************************************
     * setQueStatEoq
     *******************************************************************************************************/
    /**
     *
     * @param queStatEoq TODO_javadoc.
     *
     */
    public void setQueStatEoq(String queStatEoq) {
        replaceValue(3036, 3039, queStatEoq);
    }

    /*******************************************************************************************************
     * setQueCmnd
     *******************************************************************************************************/
    /**
     *
     * @param queCmnd TODO_javadoc.
     *
     */
    public void setQueCmnd(String queCmnd) {
        replaceValue(3039, 3042, queCmnd);
    }

    /*******************************************************************************************************
     * getQueCola
     *******************************************************************************************************/
    /**
     *
     * @return queCola TODO_javadoc.
     *
     */
    public QueCola getQueCola() {
        return queCola;
    }

    /*******************************************************************************************************
     * getQueNitm
     *******************************************************************************************************/
    /**
     *
     * @return queNitm TODO_javadoc.
     *
     */
    public int getQueNitm() {
        return (int) getCompNumber(subValue(8, 12));
    }

    /*******************************************************************************************************
     * getQueLitm
     *******************************************************************************************************/
    /**
     *
     * @return queLitm TODO_javadoc.
     *
     */
    public int getQueLitm() {
        return (int) getCompNumber(subValue(12, 16));
    }

    /*******************************************************************************************************
     * getQueItem
     *******************************************************************************************************/
    /**
     *
     * @return queItem TODO_javadoc.
     *
     */
    public QueItem getQueItem() {
        return queItem;
    }

    /*******************************************************************************************************
     * getQueStat
     *******************************************************************************************************/
    /**
     *
     * @return queStat TODO_javadoc.
     *
     */
    public String getQueStat() {
        return subValue(3027, 3030);
    }

    /*******************************************************************************************************
     * getQueStatOks
     *******************************************************************************************************/
    /**
     *
     * @return queStatOks TODO_javadoc.
     *
     */
    public String getQueStatOks() {
        return subValue(3030, 3033);
    }

    /*******************************************************************************************************
     * getQueStatNex
     *******************************************************************************************************/
    /**
     *
     * @return queStatNex TODO_javadoc.
     *
     */
    public String getQueStatNex() {
        return subValue(3033, 3036);
    }

    /*******************************************************************************************************
     * getQueStatEoq
     *******************************************************************************************************/
    /**
     *
     * @return queStatEoq TODO_javadoc.
     *
     */
    public String getQueStatEoq() {
        return subValue(3036, 3039);
    }

    /*******************************************************************************************************
     * getQueCmnd
     *******************************************************************************************************/
    /**
     *
     * @return queCmnd TODO_javadoc.
     *
     */
    public String getQueCmnd() {
        return subValue(3039, 3042);
    }

    /*******************************************************************************************************
     * getQueMens
     *******************************************************************************************************/
    /**
     *
     * @return queMens TODO_javadoc.
     *
     */
    public QueMens getQueMens() {
        return queMens;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class QueCola {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public QueCola() {
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
         * setQueTerm
         *******************************************************************************************************/
        /**
         *
         * @param queTerm TODO_javadoc.
         *
         */
        public void setQueTerm(String queTerm) {
            replaceValue(0, 4, queTerm);
        }

        /*******************************************************************************************************
         * setQueType
         *******************************************************************************************************/
        /**
         *
         * @param queType TODO_javadoc.
         *
         */
        public void setQueType(String queType) {
            replaceValue(4, 8, queType);
        }

        /*******************************************************************************************************
         * getQueTerm
         *******************************************************************************************************/
        /**
         *
         * @return queTerm TODO_javadoc.
         *
         */
        public String getQueTerm() {
            return subValue(0, 4);
        }

        /*******************************************************************************************************
         * getQueType
         *******************************************************************************************************/
        /**
         *
         * @return queType TODO_javadoc.
         *
         */
        public String getQueType() {
            return subValue(4, 8);
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
    public class QueItem {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public QueItem() {
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
            replaceValue(16, 3027, value);
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
            return subValue(16, 16 + 3011);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setQueIkey
         *******************************************************************************************************/
        /**
         *
         * @param queIkey TODO_javadoc.
         *
         */
        public void setQueIkey(String queIkey) {
            replaceValue(16, 19, queIkey);
        }

        /*******************************************************************************************************
         * setQueLdat
         *******************************************************************************************************/
        /**
         *
         * @param queLdat TODO_javadoc.
         *
         */
        public void setQueLdat(int queLdat) {
            replaceValue(19, 23, setCompNumber(queLdat, form4z));
        }

        /*******************************************************************************************************
         * setQuePcur
         *******************************************************************************************************/
        /**
         *
         * @param quePcur TODO_javadoc.
         *
         */
        public void setQuePcur(int quePcur) {
            replaceValue(23, 27, setCompNumber(quePcur, form4z));
        }

        /*******************************************************************************************************
         * setQueData
         *******************************************************************************************************/
        /**
         *
         * @param queData TODO_javadoc.
         *
         */
        public void setQueData(String queData) {
            replaceValue(27, 3027, queData);
        }

        /*******************************************************************************************************
         * getQueIkey
         *******************************************************************************************************/
        /**
         *
         * @return queIkey TODO_javadoc.
         *
         */
        public String getQueIkey() {
            return subValue(16, 19);
        }

        /*******************************************************************************************************
         * getQueLdat
         *******************************************************************************************************/
        /**
         *
         * @return queLdat TODO_javadoc.
         *
         */
        public int getQueLdat() {
            return (int) getCompNumber(subValue(19, 23));
        }

        /*******************************************************************************************************
         * getQuePcur
         *******************************************************************************************************/
        /**
         *
         * @return quePcur TODO_javadoc.
         *
         */
        public int getQuePcur() {
            return (int) getCompNumber(subValue(23, 27));
        }

        /*******************************************************************************************************
         * getQueData
         *******************************************************************************************************/
        /**
         *
         * @return queData TODO_javadoc.
         *
         */
        public String getQueData() {
            return subValue(27, 3027);
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
    public class QueMens {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public QueMens() {
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
            replaceValue(3042, 3121, value);
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
            return subValue(3042, 3042 + 79);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setQueMen1
         *******************************************************************************************************/
        /**
         *
         * @param queMen1 TODO_javadoc.
         *
         */
        public void setQueMen1(String queMen1) {
            replaceValue(3042, 3082, queMen1);
        }

        /*******************************************************************************************************
         * setQueMen2
         *******************************************************************************************************/
        /**
         *
         * @param queMen2 TODO_javadoc.
         *
         */
        public void setQueMen2(String queMen2) {
            replaceValue(3082, 3121, queMen2);
        }

        /*******************************************************************************************************
         * getQueMen1
         *******************************************************************************************************/
        /**
         *
         * @return queMen1 TODO_javadoc.
         *
         */
        public String getQueMen1() {
            return subValue(3042, 3082);
        }

        /*******************************************************************************************************
         * getQueMen2
         *******************************************************************************************************/
        /**
         *
         * @return queMen2 TODO_javadoc.
         *
         */
        public String getQueMen2() {
            return subValue(3082, 3121);
        }

    }

}
