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
public class TabVari extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(TabVari.class);

    /** TODO_javadoc. */
    private TabGlsFtab tabGlsFtab = new TabGlsFtab();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public TabVari() {

        initBuffer(8);

        replaceValue(0, 8, "        "); // TAB-VARI
        replaceValue(3, 8, "PFTAB"); // TAB-COD-FTAB
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
     * getTabGlsFtab
     *******************************************************************************************************/
    /**
     *
     * @return tabGlsFtab TODO_javadoc.
     *
     */
    public TabGlsFtab getTabGlsFtab() {
        return tabGlsFtab;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class TabGlsFtab {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public TabGlsFtab() {
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
         * setTabCodSist
         *******************************************************************************************************/
        /**
         *
         * @param tabCodSist TODO_javadoc.
         *
         */
        public void setTabCodSist(String tabCodSist) {
            replaceValue(0, 3, tabCodSist);
        }

        /*******************************************************************************************************
         * setTabCodFtab
         *******************************************************************************************************/
        /**
         *
         * @param tabCodFtab TODO_javadoc.
         *
         */
        public void setTabCodFtab(String tabCodFtab) {
            replaceValue(3, 8, tabCodFtab);
        }

        /*******************************************************************************************************
         * getTabCodSist
         *******************************************************************************************************/
        /**
         *
         * @return tabCodSist TODO_javadoc.
         *
         */
        public String getTabCodSist() {
            return subValue(0, 3);
        }

        /*******************************************************************************************************
         * getTabCodFtab
         *******************************************************************************************************/
        /**
         *
         * @return tabCodFtab TODO_javadoc.
         *
         */
        public String getTabCodFtab() {
            return subValue(3, 8);
        }

    }

}

