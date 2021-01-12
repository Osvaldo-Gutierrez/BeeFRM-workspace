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
public class KeyVari extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(KeyVari.class);

    /** TODO_javadoc. */
    private static DecimalFormat form2z = new DecimalFormat("00");

    /** TODO_javadoc. */
    private static DecimalFormat form3z = new DecimalFormat("000");

    /** TODO_javadoc. */
    private static DecimalFormat form8z = new DecimalFormat("00000000");

    /** TODO_javadoc. */
    private KeyCicIrut keyCicIrut = new KeyCicIrut();

    /** TODO_javadoc. */
    private KeyCicIope keyCicIope = new KeyCicIope();

    /** TODO_javadoc. */
    private KeyFecFent keyFecFent = new KeyFecFent();

    /** TODO_javadoc. */
    private KeyFecFcmt keyFecFcmt = new KeyFecFcmt();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public KeyVari() {

        initBuffer(125);

        replaceValue(0, 125, "                                                               00000000                 00000000000   00000000000            "); // KEY-VARI
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
        replaceValue(0, 125, value);
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
        return subValue(0, 125);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setKeyCodEnti
     *******************************************************************************************************/
    /**
     *
     * @param keyCodEnti TODO_javadoc.
     *
     */
    public void setKeyCodEnti(String keyCodEnti) {
        replaceValue(0, 3, keyCodEnti);
    }

    /*******************************************************************************************************
     * setKeyGlsNomc
     *******************************************************************************************************/
    /**
     *
     * @param keyGlsNomc TODO_javadoc.
     *
     */
    public void setKeyGlsNomc(String keyGlsNomc) {
        replaceValue(3, 63, keyGlsNomc);
    }

    /*******************************************************************************************************
     * setKeyNumIent
     *******************************************************************************************************/
    /**
     *
     * @param keyNumIent TODO_javadoc.
     *
     */
    public void setKeyNumIent(int keyNumIent) {
        replaceValue(96, 99, form3z.format(keyNumIent));
    }

    /*******************************************************************************************************
     * setKeyCodIent
     *******************************************************************************************************/
    /**
     *
     * @param keyCodIent TODO_javadoc.
     *
     */
    public void setKeyCodIent(String keyCodIent) {
        replaceValue(99, 102, keyCodIent);
    }

    /*******************************************************************************************************
     * setKeyNumGcmt
     *******************************************************************************************************/
    /**
     *
     * @param keyNumGcmt TODO_javadoc.
     *
     */
    public void setKeyNumGcmt(int keyNumGcmt) {
        replaceValue(110, 113, form3z.format(keyNumGcmt));
    }

    /*******************************************************************************************************
     * setKeyCodUser
     *******************************************************************************************************/
    /**
     *
     * @param keyCodUser TODO_javadoc.
     *
     */
    public void setKeyCodUser(String keyCodUser) {
        replaceValue(113, 125, keyCodUser);
    }

    /*******************************************************************************************************
     * getKeyCodEnti
     *******************************************************************************************************/
    /**
     *
     * @return keyCodEnti TODO_javadoc.
     *
     */
    public String getKeyCodEnti() {
        return subValue(0, 3);
    }

    /*******************************************************************************************************
     * getKeyGlsNomc
     *******************************************************************************************************/
    /**
     *
     * @return keyGlsNomc TODO_javadoc.
     *
     */
    public String getKeyGlsNomc() {
        return subValue(3, 63);
    }

    /*******************************************************************************************************
     * getKeyCicIrut
     *******************************************************************************************************/
    /**
     *
     * @return keyCicIrut TODO_javadoc.
     *
     */
    public KeyCicIrut getKeyCicIrut() {
        return keyCicIrut;
    }

    /*******************************************************************************************************
     * getKeyCicIope
     *******************************************************************************************************/
    /**
     *
     * @return keyCicIope TODO_javadoc.
     *
     */
    public KeyCicIope getKeyCicIope() {
        return keyCicIope;
    }

    /*******************************************************************************************************
     * getKeyFecFent
     *******************************************************************************************************/
    /**
     *
     * @return keyFecFent TODO_javadoc.
     *
     */
    public KeyFecFent getKeyFecFent() {
        return keyFecFent;
    }

    /*******************************************************************************************************
     * getKeyNumIent
     *******************************************************************************************************/
    /**
     *
     * @return keyNumIent TODO_javadoc.
     *
     */
    public int getKeyNumIent() {
        return Integer.parseInt(subValue(96, 99));
    }

    /*******************************************************************************************************
     * getKeyCodIent
     *******************************************************************************************************/
    /**
     *
     * @return keyCodIent TODO_javadoc.
     *
     */
    public String getKeyCodIent() {
        return subValue(99, 102);
    }

    /*******************************************************************************************************
     * getKeyFecFcmt
     *******************************************************************************************************/
    /**
     *
     * @return keyFecFcmt TODO_javadoc.
     *
     */
    public KeyFecFcmt getKeyFecFcmt() {
        return keyFecFcmt;
    }

    /*******************************************************************************************************
     * getKeyNumGcmt
     *******************************************************************************************************/
    /**
     *
     * @return keyNumGcmt TODO_javadoc.
     *
     */
    public int getKeyNumGcmt() {
        return Integer.parseInt(subValue(110, 113));
    }

    /*******************************************************************************************************
     * getKeyCodUser
     *******************************************************************************************************/
    /**
     *
     * @return keyCodUser TODO_javadoc.
     *
     */
    public String getKeyCodUser() {
        return subValue(113, 125);
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class KeyCicIrut {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public KeyCicIrut() {
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
            replaceValue(63, 76, value);
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
            return subValue(63, 63 + 13);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setKeyNumIcli
         *******************************************************************************************************/
        /**
         *
         * @param keyNumIcli TODO_javadoc.
         *
         */
        public void setKeyNumIcli(int keyNumIcli) {
            replaceValue(63, 71, form8z.format(keyNumIcli));
        }

        /*******************************************************************************************************
         * setKeyVrfIcli
         *******************************************************************************************************/
        /**
         *
         * @param keyVrfIcli TODO_javadoc.
         *
         */
        public void setKeyVrfIcli(String keyVrfIcli) {
            replaceValue(71, 72, keyVrfIcli);
        }

        /*******************************************************************************************************
         * setKeyIndIcli
         *******************************************************************************************************/
        /**
         *
         * @param keyIndIcli TODO_javadoc.
         *
         */
        public void setKeyIndIcli(String keyIndIcli) {
            replaceValue(72, 73, keyIndIcli);
        }

        /*******************************************************************************************************
         * setKeyGlsIcli
         *******************************************************************************************************/
        /**
         *
         * @param keyGlsIcli TODO_javadoc.
         *
         */
        public void setKeyGlsIcli(String keyGlsIcli) {
            replaceValue(73, 76, keyGlsIcli);
        }

        /*******************************************************************************************************
         * getKeyNumIcli
         *******************************************************************************************************/
        /**
         *
         * @return keyNumIcli TODO_javadoc.
         *
         */
        public int getKeyNumIcli() {
            return Integer.parseInt(subValue(63, 71));
        }

        /*******************************************************************************************************
         * getKeyVrfIcli
         *******************************************************************************************************/
        /**
         *
         * @return keyVrfIcli TODO_javadoc.
         *
         */
        public String getKeyVrfIcli() {
            return subValue(71, 72);
        }

        /*******************************************************************************************************
         * getKeyIndIcli
         *******************************************************************************************************/
        /**
         *
         * @return keyIndIcli TODO_javadoc.
         *
         */
        public String getKeyIndIcli() {
            return subValue(72, 73);
        }

        /*******************************************************************************************************
         * getKeyGlsIcli
         *******************************************************************************************************/
        /**
         *
         * @return keyGlsIcli TODO_javadoc.
         *
         */
        public String getKeyGlsIcli() {
            return subValue(73, 76);
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
    public class KeyCicIope {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public KeyCicIope() {
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
            replaceValue(76, 88, value);
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
            return subValue(76, 76 + 12);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setKeyCaiIope
         *******************************************************************************************************/
        /**
         *
         * @param keyCaiIope TODO_javadoc.
         *
         */
        public void setKeyCaiIope(String keyCaiIope) {
            replaceValue(76, 80, keyCaiIope);
        }

        /*******************************************************************************************************
         * setKeyIicIope
         *******************************************************************************************************/
        /**
         *
         * @param keyIicIope TODO_javadoc.
         *
         */
        public void setKeyIicIope(String keyIicIope) {
            replaceValue(80, 88, keyIicIope);
        }

        /*******************************************************************************************************
         * getKeyCaiIope
         *******************************************************************************************************/
        /**
         *
         * @return keyCaiIope TODO_javadoc.
         *
         */
        public String getKeyCaiIope() {
            return subValue(76, 80);
        }

        /*******************************************************************************************************
         * getKeyIicIope
         *******************************************************************************************************/
        /**
         *
         * @return keyIicIope TODO_javadoc.
         *
         */
        public String getKeyIicIope() {
            return subValue(80, 88);
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
    public class KeyFecFent {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public KeyFecFent() {
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
            replaceValue(88, 96, value);
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
            return subValue(88, 88 + 8);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setKeyNumDent
         *******************************************************************************************************/
        /**
         *
         * @param keyNumDent TODO_javadoc.
         *
         */
        public void setKeyNumDent(int keyNumDent) {
            replaceValue(88, 90, form2z.format(keyNumDent));
        }

        /*******************************************************************************************************
         * setKeyNumMent
         *******************************************************************************************************/
        /**
         *
         * @param keyNumMent TODO_javadoc.
         *
         */
        public void setKeyNumMent(int keyNumMent) {
            replaceValue(90, 92, form2z.format(keyNumMent));
        }

        /*******************************************************************************************************
         * setKeyNumSent
         *******************************************************************************************************/
        /**
         *
         * @param keyNumSent TODO_javadoc.
         *
         */
        public void setKeyNumSent(int keyNumSent) {
            replaceValue(92, 94, form2z.format(keyNumSent));
        }

        /*******************************************************************************************************
         * setKeyNumAent
         *******************************************************************************************************/
        /**
         *
         * @param keyNumAent TODO_javadoc.
         *
         */
        public void setKeyNumAent(int keyNumAent) {
            replaceValue(94, 96, form2z.format(keyNumAent));
        }

        /*******************************************************************************************************
         * getKeyNumDent
         *******************************************************************************************************/
        /**
         *
         * @return keyNumDent TODO_javadoc.
         *
         */
        public int getKeyNumDent() {
            return Integer.parseInt(subValue(88, 90));
        }

        /*******************************************************************************************************
         * getKeyNumMent
         *******************************************************************************************************/
        /**
         *
         * @return keyNumMent TODO_javadoc.
         *
         */
        public int getKeyNumMent() {
            return Integer.parseInt(subValue(90, 92));
        }

        /*******************************************************************************************************
         * getKeyNumSent
         *******************************************************************************************************/
        /**
         *
         * @return keyNumSent TODO_javadoc.
         *
         */
        public int getKeyNumSent() {
            return Integer.parseInt(subValue(92, 94));
        }

        /*******************************************************************************************************
         * getKeyNumAent
         *******************************************************************************************************/
        /**
         *
         * @return keyNumAent TODO_javadoc.
         *
         */
        public int getKeyNumAent() {
            return Integer.parseInt(subValue(94, 96));
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
    public class KeyFecFcmt {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public KeyFecFcmt() {
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
            replaceValue(102, 110, value);
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
            return subValue(102, 102 + 8);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setKeyNumDcmt
         *******************************************************************************************************/
        /**
         *
         * @param keyNumDcmt TODO_javadoc.
         *
         */
        public void setKeyNumDcmt(int keyNumDcmt) {
            replaceValue(102, 104, form2z.format(keyNumDcmt));
        }

        /*******************************************************************************************************
         * setKeyNumMcmt
         *******************************************************************************************************/
        /**
         *
         * @param keyNumMcmt TODO_javadoc.
         *
         */
        public void setKeyNumMcmt(int keyNumMcmt) {
            replaceValue(104, 106, form2z.format(keyNumMcmt));
        }

        /*******************************************************************************************************
         * setKeyNumScmt
         *******************************************************************************************************/
        /**
         *
         * @param keyNumScmt TODO_javadoc.
         *
         */
        public void setKeyNumScmt(int keyNumScmt) {
            replaceValue(106, 108, form2z.format(keyNumScmt));
        }

        /*******************************************************************************************************
         * setKeyNumAcmt
         *******************************************************************************************************/
        /**
         *
         * @param keyNumAcmt TODO_javadoc.
         *
         */
        public void setKeyNumAcmt(int keyNumAcmt) {
            replaceValue(108, 110, form2z.format(keyNumAcmt));
        }

        /*******************************************************************************************************
         * getKeyNumDcmt
         *******************************************************************************************************/
        /**
         *
         * @return keyNumDcmt TODO_javadoc.
         *
         */
        public int getKeyNumDcmt() {
            return Integer.parseInt(subValue(102, 104));
        }

        /*******************************************************************************************************
         * getKeyNumMcmt
         *******************************************************************************************************/
        /**
         *
         * @return keyNumMcmt TODO_javadoc.
         *
         */
        public int getKeyNumMcmt() {
            return Integer.parseInt(subValue(104, 106));
        }

        /*******************************************************************************************************
         * getKeyNumScmt
         *******************************************************************************************************/
        /**
         *
         * @return keyNumScmt TODO_javadoc.
         *
         */
        public int getKeyNumScmt() {
            return Integer.parseInt(subValue(106, 108));
        }

        /*******************************************************************************************************
         * getKeyNumAcmt
         *******************************************************************************************************/
        /**
         *
         * @return keyNumAcmt TODO_javadoc.
         *
         */
        public int getKeyNumAcmt() {
            return Integer.parseInt(subValue(108, 110));
        }

    }

}
