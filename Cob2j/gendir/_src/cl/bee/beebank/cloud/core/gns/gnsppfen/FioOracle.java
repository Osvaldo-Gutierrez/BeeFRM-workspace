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
public class FioOracle extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(FioOracle.class);

    /** TODO_javadoc. */
    private static DecimalFormat form3z = new DecimalFormat("000");

    /** TODO_javadoc. */
    private FioOracleProg fioOracleProg = new FioOracleProg();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public FioOracle() {

        initBuffer(3000);

        replaceValue(0, 3000, "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         000                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            "); // FIO-ORACLE
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
        replaceValue(0, 3000, value);
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
        return subValue(0, 3000);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setFioOracleVari
     *******************************************************************************************************/
    /**
     *
     * @param fioOracleVari TODO_javadoc.
     *
     */
    public void setFioOracleVari(String fioOracleVari) {
        replaceValue(0, 80, fioOracleVari);
    }

    /*******************************************************************************************************
     * setFioOracleDfld
     *******************************************************************************************************/
    /**
     *
     * @param fioOracleDfld TODO_javadoc.
     *
     */
    public void setFioOracleDfld(String fioOracleDfld) {
        replaceValue(80, 1616, fioOracleDfld);
    }

    /*******************************************************************************************************
     * setFioOracleRqa
     *******************************************************************************************************/
    /**
     *
     * @param fioOracleRqa TODO_javadoc.
     *
     */
    public void setFioOracleRqa(String fioOracleRqa) {
        replaceValue(1616, 2246, fioOracleRqa);
    }

    /*******************************************************************************************************
     * setFioOracleMens
     *******************************************************************************************************/
    /**
     *
     * @param fioOracleMens TODO_javadoc.
     *
     */
    public void setFioOracleMens(String fioOracleMens) {
        replaceValue(2246, 2326, fioOracleMens);
    }

    /*******************************************************************************************************
     * setFioOracleFill
     *******************************************************************************************************/
    /**
     *
     * @param fioOracleFill TODO_javadoc.
     *
     */
    public void setFioOracleFill(String fioOracleFill) {
        replaceValue(2332, 3000, fioOracleFill);
    }

    /*******************************************************************************************************
     * getFioOracleVari
     *******************************************************************************************************/
    /**
     *
     * @return fioOracleVari TODO_javadoc.
     *
     */
    public String getFioOracleVari() {
        return subValue(0, 80);
    }

    /*******************************************************************************************************
     * getFioOracleDfld
     *******************************************************************************************************/
    /**
     *
     * @return fioOracleDfld TODO_javadoc.
     *
     */
    public String getFioOracleDfld() {
        return subValue(80, 1616);
    }

    /*******************************************************************************************************
     * getFioOracleRqa
     *******************************************************************************************************/
    /**
     *
     * @return fioOracleRqa TODO_javadoc.
     *
     */
    public String getFioOracleRqa() {
        return subValue(1616, 2246);
    }

    /*******************************************************************************************************
     * getFioOracleMens
     *******************************************************************************************************/
    /**
     *
     * @return fioOracleMens TODO_javadoc.
     *
     */
    public String getFioOracleMens() {
        return subValue(2246, 2326);
    }

    /*******************************************************************************************************
     * getFioOracleProg
     *******************************************************************************************************/
    /**
     *
     * @return fioOracleProg TODO_javadoc.
     *
     */
    public FioOracleProg getFioOracleProg() {
        return fioOracleProg;
    }

    /*******************************************************************************************************
     * getFioOracleFill
     *******************************************************************************************************/
    /**
     *
     * @return fioOracleFill TODO_javadoc.
     *
     */
    public String getFioOracleFill() {
        return subValue(2332, 3000);
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class FioOracleProg {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public FioOracleProg() {
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
            replaceValue(2326, 2332, value);
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
            return subValue(2326, 2326 + 6);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setFioOracleProgTab
         *******************************************************************************************************/
        /**
         *
         * @param fioOracleProgTab TODO_javadoc.
         *
         */
        public void setFioOracleProgTab(String fioOracleProgTab) {
            replaceValue(2326, 2329, fioOracleProgTab);
        }

        /*******************************************************************************************************
         * setFioOracleProgNum
         *******************************************************************************************************/
        /**
         *
         * @param fioOracleProgNum TODO_javadoc.
         *
         */
        public void setFioOracleProgNum(int fioOracleProgNum) {
            replaceValue(2329, 2332, form3z.format(fioOracleProgNum));
        }

        /*******************************************************************************************************
         * getFioOracleProgTab
         *******************************************************************************************************/
        /**
         *
         * @return fioOracleProgTab TODO_javadoc.
         *
         */
        public String getFioOracleProgTab() {
            return subValue(2326, 2329);
        }

        /*******************************************************************************************************
         * getFioOracleProgNum
         *******************************************************************************************************/
        /**
         *
         * @return fioOracleProgNum TODO_javadoc.
         *
         */
        public int getFioOracleProgNum() {
            return Integer.parseInt(subValue(2329, 2332));
        }

    }

}

