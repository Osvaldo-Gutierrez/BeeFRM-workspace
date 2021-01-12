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
public class MnuVari extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(MnuVari.class);

    /** TODO_javadoc. */
    private MnuGlsFmnu mnuGlsFmnu = new MnuGlsFmnu();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public MnuVari() {

        initBuffer(8);

        replaceValue(0, 8, "        "); // MNU-VARI
        replaceValue(3, 8, "PFMNU"); // MNU-COD-FMNU
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
     * getMnuGlsFmnu
     *******************************************************************************************************/
    /**
     *
     * @return mnuGlsFmnu TODO_javadoc.
     *
     */
    public MnuGlsFmnu getMnuGlsFmnu() {
        return mnuGlsFmnu;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class MnuGlsFmnu {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public MnuGlsFmnu() {
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
         * setMnuCodStma
         *******************************************************************************************************/
        /**
         *
         * @param mnuCodStma TODO_javadoc.
         *
         */
        public void setMnuCodStma(String mnuCodStma) {
            replaceValue(0, 3, mnuCodStma);
        }

        /*******************************************************************************************************
         * setMnuCodFmnu
         *******************************************************************************************************/
        /**
         *
         * @param mnuCodFmnu TODO_javadoc.
         *
         */
        public void setMnuCodFmnu(String mnuCodFmnu) {
            replaceValue(3, 8, mnuCodFmnu);
        }

        /*******************************************************************************************************
         * getMnuCodStma
         *******************************************************************************************************/
        /**
         *
         * @return mnuCodStma TODO_javadoc.
         *
         */
        public String getMnuCodStma() {
            return subValue(0, 3);
        }

        /*******************************************************************************************************
         * getMnuCodFmnu
         *******************************************************************************************************/
        /**
         *
         * @return mnuCodFmnu TODO_javadoc.
         *
         */
        public String getMnuCodFmnu() {
            return subValue(3, 8);
        }

    }

}

