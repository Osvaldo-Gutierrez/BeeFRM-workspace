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
public class WssEstd extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(WssEstd.class);

    /** TODO_javadoc. */
    private static DecimalFormat form2z = new DecimalFormat("00");

    /** TODO_javadoc. */
    private static DecimalFormat form9z = new DecimalFormat("000000000");

    /** TODO_javadoc. */
    private WssEstdCtab wssEstdCtab = new WssEstdCtab();

    /** TODO_javadoc. */
    private WssEstdDesc wssEstdDesc = new WssEstdDesc();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public WssEstd() {

        initBuffer(83);

        replaceValue(0, 83, "          000000000          00                                                    "); // WSS-ESTD
        replaceValue(0, 10, "          "); // WSS-ESTD-ELIM
        replaceValue(19, 29, "MONITORPTC"); // WSS-ESTD-CTAB-01
        replaceValue(29, 31, form2z.format(0)); // WSS-ESTD-CTAB-02
        replaceValue(31, 43, "            "); // WSS-ESTD-DESC-01
        replaceValue(43, 45, "  "); // WSS-ESTD-DESC-02
        replaceValue(45, 51, "      "); // WSS-ESTD-DESC-03
        replaceValue(51, 53, "  "); // WSS-ESTD-DESC-04
        replaceValue(53, 83, "                              "); // WSS-ESTD-DESC-05
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
        replaceValue(0, 83, value);
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
        return subValue(0, 83);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setWssEstdElim
     *******************************************************************************************************/
    /**
     *
     * @param wssEstdElim TODO_javadoc.
     *
     */
    public void setWssEstdElim(String wssEstdElim) {
        replaceValue(0, 10, wssEstdElim);
    }

    /*******************************************************************************************************
     * setWssEstdHora
     *******************************************************************************************************/
    /**
     *
     * @param wssEstdHora TODO_javadoc.
     *
     */
    public void setWssEstdHora(int wssEstdHora) {
        replaceValue(10, 19, form9z.format(wssEstdHora));
    }

    /*******************************************************************************************************
     * getWssEstdElim
     *******************************************************************************************************/
    /**
     *
     * @return wssEstdElim TODO_javadoc.
     *
     */
    public String getWssEstdElim() {
        return subValue(0, 10);
    }

    /*******************************************************************************************************
     * getWssEstdHora
     *******************************************************************************************************/
    /**
     *
     * @return wssEstdHora TODO_javadoc.
     *
     */
    public int getWssEstdHora() {
        return Integer.parseInt(subValue(10, 19));
    }

    /*******************************************************************************************************
     * getWssEstdCtab
     *******************************************************************************************************/
    /**
     *
     * @return wssEstdCtab TODO_javadoc.
     *
     */
    public WssEstdCtab getWssEstdCtab() {
        return wssEstdCtab;
    }

    /*******************************************************************************************************
     * getWssEstdDesc
     *******************************************************************************************************/
    /**
     *
     * @return wssEstdDesc TODO_javadoc.
     *
     */
    public WssEstdDesc getWssEstdDesc() {
        return wssEstdDesc;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class WssEstdCtab {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssEstdCtab() {
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
            replaceValue(19, 31, value);
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
            return subValue(19, 19 + 12);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setWssEstdCtab01
         *******************************************************************************************************/
        /**
         *
         * @param wssEstdCtab01 TODO_javadoc.
         *
         */
        public void setWssEstdCtab01(String wssEstdCtab01) {
            replaceValue(19, 29, wssEstdCtab01);
        }

        /*******************************************************************************************************
         * setWssEstdCtab02
         *******************************************************************************************************/
        /**
         *
         * @param wssEstdCtab02 TODO_javadoc.
         *
         */
        public void setWssEstdCtab02(int wssEstdCtab02) {
            replaceValue(29, 31, form2z.format(wssEstdCtab02));
        }

        /*******************************************************************************************************
         * getWssEstdCtab01
         *******************************************************************************************************/
        /**
         *
         * @return wssEstdCtab01 TODO_javadoc.
         *
         */
        public String getWssEstdCtab01() {
            return subValue(19, 29);
        }

        /*******************************************************************************************************
         * getWssEstdCtab02
         *******************************************************************************************************/
        /**
         *
         * @return wssEstdCtab02 TODO_javadoc.
         *
         */
        public int getWssEstdCtab02() {
            return Integer.parseInt(subValue(29, 31));
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
    public class WssEstdDesc {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssEstdDesc() {
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
            replaceValue(31, 83, value);
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
            return subValue(31, 31 + 52);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setWssEstdDesc01
         *******************************************************************************************************/
        /**
         *
         * @param wssEstdDesc01 TODO_javadoc.
         *
         */
        public void setWssEstdDesc01(String wssEstdDesc01) {
            replaceValue(31, 43, wssEstdDesc01);
        }

        /*******************************************************************************************************
         * setWssEstdDesc02
         *******************************************************************************************************/
        /**
         *
         * @param wssEstdDesc02 TODO_javadoc.
         *
         */
        public void setWssEstdDesc02(String wssEstdDesc02) {
            replaceValue(43, 45, wssEstdDesc02);
        }

        /*******************************************************************************************************
         * setWssEstdDesc03
         *******************************************************************************************************/
        /**
         *
         * @param wssEstdDesc03 TODO_javadoc.
         *
         */
        public void setWssEstdDesc03(String wssEstdDesc03) {
            replaceValue(45, 51, wssEstdDesc03);
        }

        /*******************************************************************************************************
         * setWssEstdDesc04
         *******************************************************************************************************/
        /**
         *
         * @param wssEstdDesc04 TODO_javadoc.
         *
         */
        public void setWssEstdDesc04(String wssEstdDesc04) {
            replaceValue(51, 53, wssEstdDesc04);
        }

        /*******************************************************************************************************
         * setWssEstdDesc05
         *******************************************************************************************************/
        /**
         *
         * @param wssEstdDesc05 TODO_javadoc.
         *
         */
        public void setWssEstdDesc05(String wssEstdDesc05) {
            replaceValue(53, 83, wssEstdDesc05);
        }

        /*******************************************************************************************************
         * getWssEstdDesc01
         *******************************************************************************************************/
        /**
         *
         * @return wssEstdDesc01 TODO_javadoc.
         *
         */
        public String getWssEstdDesc01() {
            return subValue(31, 43);
        }

        /*******************************************************************************************************
         * getWssEstdDesc02
         *******************************************************************************************************/
        /**
         *
         * @return wssEstdDesc02 TODO_javadoc.
         *
         */
        public String getWssEstdDesc02() {
            return subValue(43, 45);
        }

        /*******************************************************************************************************
         * getWssEstdDesc03
         *******************************************************************************************************/
        /**
         *
         * @return wssEstdDesc03 TODO_javadoc.
         *
         */
        public String getWssEstdDesc03() {
            return subValue(45, 51);
        }

        /*******************************************************************************************************
         * getWssEstdDesc04
         *******************************************************************************************************/
        /**
         *
         * @return wssEstdDesc04 TODO_javadoc.
         *
         */
        public String getWssEstdDesc04() {
            return subValue(51, 53);
        }

        /*******************************************************************************************************
         * getWssEstdDesc05
         *******************************************************************************************************/
        /**
         *
         * @return wssEstdDesc05 TODO_javadoc.
         *
         */
        public String getWssEstdDesc05() {
            return subValue(53, 83);
        }

    }

}

