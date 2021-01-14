/*
 *   Copyright (c) 2021 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.beebank.cloud.core.gns.gnspqcic;


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
public class CicFld extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(CicFld.class);

    /** TODO_javadoc. */
    private static DecimalFormat form4z = new DecimalFormat("0000");

    /** TODO_javadoc. */
    private static DecimalFormat form8z = new DecimalFormat("00000000");

    /** TODO_javadoc. */
    private CicGlsMens cicGlsMens = new CicGlsMens();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public CicFld() {

        initBuffer(129);

        replaceValue(0, 129, "            000{  000{    000{         000{  000{                                                                                "); // CIC-FLD
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
        replaceValue(0, 129, value);
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
        return subValue(0, 129);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setFillerCic
     *******************************************************************************************************/
    /**
     *
     * @param fillerCic TODO_javadoc.
     *
     */
    public void setFillerCic(String fillerCic) {
        replaceValue(0, 12, fillerCic);
    }

    /*******************************************************************************************************
     * setCicCodTcicLen
     *******************************************************************************************************/
    /**
     *
     * @param cicCodTcicLen TODO_javadoc.
     *
     */
    public void setCicCodTcicLen(int cicCodTcicLen) {
        replaceValue(12, 16, setCompNumber(cicCodTcicLen, form4z));
    }

    /*******************************************************************************************************
     * setCicCodTcicAtr
     *******************************************************************************************************/
    /**
     *
     * @param cicCodTcicAtr TODO_javadoc.
     *
     */
    public void setCicCodTcicAtr(String cicCodTcicAtr) {
        replaceValue(16, 17, cicCodTcicAtr);
    }

    /*******************************************************************************************************
     * setCicCodTcic
     *******************************************************************************************************/
    /**
     *
     * @param cicCodTcic TODO_javadoc.
     *
     */
    public void setCicCodTcic(String cicCodTcic) {
        replaceValue(17, 18, cicCodTcic);
    }

    /*******************************************************************************************************
     * setCicCodCcicLen
     *******************************************************************************************************/
    /**
     *
     * @param cicCodCcicLen TODO_javadoc.
     *
     */
    public void setCicCodCcicLen(int cicCodCcicLen) {
        replaceValue(18, 22, setCompNumber(cicCodCcicLen, form4z));
    }

    /*******************************************************************************************************
     * setCicCodCcicAtr
     *******************************************************************************************************/
    /**
     *
     * @param cicCodCcicAtr TODO_javadoc.
     *
     */
    public void setCicCodCcicAtr(String cicCodCcicAtr) {
        replaceValue(22, 23, cicCodCcicAtr);
    }

    /*******************************************************************************************************
     * setCicCodCcic
     *******************************************************************************************************/
    /**
     *
     * @param cicCodCcic TODO_javadoc.
     *
     */
    public void setCicCodCcic(String cicCodCcic) {
        replaceValue(23, 26, cicCodCcic);
    }

    /*******************************************************************************************************
     * setCicNumIcicLen
     *******************************************************************************************************/
    /**
     *
     * @param cicNumIcicLen TODO_javadoc.
     *
     */
    public void setCicNumIcicLen(int cicNumIcicLen) {
        replaceValue(26, 30, setCompNumber(cicNumIcicLen, form4z));
    }

    /*******************************************************************************************************
     * setCicNumIcicAtr
     *******************************************************************************************************/
    /**
     *
     * @param cicNumIcicAtr TODO_javadoc.
     *
     */
    public void setCicNumIcicAtr(String cicNumIcicAtr) {
        replaceValue(30, 31, cicNumIcicAtr);
    }

    /*******************************************************************************************************
     * setCicNumIcicAlf
     *******************************************************************************************************/
    /**
     *
     * @param cicNumIcicAlf TODO_javadoc.
     *
     */
    public void setCicNumIcicAlf(String cicNumIcicAlf) {
        replaceValue(31, 39, cicNumIcicAlf);
    }

    /*******************************************************************************************************
     * setCicNumIcic
     *******************************************************************************************************/
    /**
     *
     * @param cicNumIcic TODO_javadoc.
     *
     */
    public void setCicNumIcic(int cicNumIcic) {
        replaceValue(31, 39, form8z.format(cicNumIcic));
    }

    /*******************************************************************************************************
     * setCicIndVigeLen
     *******************************************************************************************************/
    /**
     *
     * @param cicIndVigeLen TODO_javadoc.
     *
     */
    public void setCicIndVigeLen(int cicIndVigeLen) {
        replaceValue(39, 43, setCompNumber(cicIndVigeLen, form4z));
    }

    /*******************************************************************************************************
     * setCicIndVigeAtr
     *******************************************************************************************************/
    /**
     *
     * @param cicIndVigeAtr TODO_javadoc.
     *
     */
    public void setCicIndVigeAtr(String cicIndVigeAtr) {
        replaceValue(43, 44, cicIndVigeAtr);
    }

    /*******************************************************************************************************
     * setCicIndVige
     *******************************************************************************************************/
    /**
     *
     * @param cicIndVige TODO_javadoc.
     *
     */
    public void setCicIndVige(String cicIndVige) {
        replaceValue(44, 45, cicIndVige);
    }

    /*******************************************************************************************************
     * setCicGlsMensLen
     *******************************************************************************************************/
    /**
     *
     * @param cicGlsMensLen TODO_javadoc.
     *
     */
    public void setCicGlsMensLen(int cicGlsMensLen) {
        replaceValue(45, 49, setCompNumber(cicGlsMensLen, form4z));
    }

    /*******************************************************************************************************
     * setCicGlsMensAtr
     *******************************************************************************************************/
    /**
     *
     * @param cicGlsMensAtr TODO_javadoc.
     *
     */
    public void setCicGlsMensAtr(String cicGlsMensAtr) {
        replaceValue(49, 50, cicGlsMensAtr);
    }

    /*******************************************************************************************************
     * getFillerCic
     *******************************************************************************************************/
    /**
     *
     * @return fillerCic TODO_javadoc.
     *
     */
    public String getFillerCic() {
        return subValue(0, 12);
    }

    /*******************************************************************************************************
     * getCicCodTcicLen
     *******************************************************************************************************/
    /**
     *
     * @return cicCodTcicLen TODO_javadoc.
     *
     */
    public int getCicCodTcicLen() {
        return (int) getCompNumber(subValue(12, 16));
    }

    /*******************************************************************************************************
     * getCicCodTcicAtr
     *******************************************************************************************************/
    /**
     *
     * @return cicCodTcicAtr TODO_javadoc.
     *
     */
    public String getCicCodTcicAtr() {
        return subValue(16, 17);
    }

    /*******************************************************************************************************
     * getCicCodTcic
     *******************************************************************************************************/
    /**
     *
     * @return cicCodTcic TODO_javadoc.
     *
     */
    public String getCicCodTcic() {
        return subValue(17, 18);
    }

    /*******************************************************************************************************
     * getCicCodCcicLen
     *******************************************************************************************************/
    /**
     *
     * @return cicCodCcicLen TODO_javadoc.
     *
     */
    public int getCicCodCcicLen() {
        return (int) getCompNumber(subValue(18, 22));
    }

    /*******************************************************************************************************
     * getCicCodCcicAtr
     *******************************************************************************************************/
    /**
     *
     * @return cicCodCcicAtr TODO_javadoc.
     *
     */
    public String getCicCodCcicAtr() {
        return subValue(22, 23);
    }

    /*******************************************************************************************************
     * getCicCodCcic
     *******************************************************************************************************/
    /**
     *
     * @return cicCodCcic TODO_javadoc.
     *
     */
    public String getCicCodCcic() {
        return subValue(23, 26);
    }

    /*******************************************************************************************************
     * getCicNumIcicLen
     *******************************************************************************************************/
    /**
     *
     * @return cicNumIcicLen TODO_javadoc.
     *
     */
    public int getCicNumIcicLen() {
        return (int) getCompNumber(subValue(26, 30));
    }

    /*******************************************************************************************************
     * getCicNumIcicAtr
     *******************************************************************************************************/
    /**
     *
     * @return cicNumIcicAtr TODO_javadoc.
     *
     */
    public String getCicNumIcicAtr() {
        return subValue(30, 31);
    }

    /*******************************************************************************************************
     * getCicNumIcicAlf
     *******************************************************************************************************/
    /**
     *
     * @return cicNumIcicAlf TODO_javadoc.
     *
     */
    public String getCicNumIcicAlf() {
        return subValue(31, 39);
    }

    /*******************************************************************************************************
     * getCicNumIcic
     *******************************************************************************************************/
    /**
     *
     * @return cicNumIcic TODO_javadoc.
     *
     */
    public int getCicNumIcic() {
        return Integer.parseInt(subValue(31, 39));
    }

    /*******************************************************************************************************
     * getCicIndVigeLen
     *******************************************************************************************************/
    /**
     *
     * @return cicIndVigeLen TODO_javadoc.
     *
     */
    public int getCicIndVigeLen() {
        return (int) getCompNumber(subValue(39, 43));
    }

    /*******************************************************************************************************
     * getCicIndVigeAtr
     *******************************************************************************************************/
    /**
     *
     * @return cicIndVigeAtr TODO_javadoc.
     *
     */
    public String getCicIndVigeAtr() {
        return subValue(43, 44);
    }

    /*******************************************************************************************************
     * getCicIndVige
     *******************************************************************************************************/
    /**
     *
     * @return cicIndVige TODO_javadoc.
     *
     */
    public String getCicIndVige() {
        return subValue(44, 45);
    }

    /*******************************************************************************************************
     * getCicGlsMensLen
     *******************************************************************************************************/
    /**
     *
     * @return cicGlsMensLen TODO_javadoc.
     *
     */
    public int getCicGlsMensLen() {
        return (int) getCompNumber(subValue(45, 49));
    }

    /*******************************************************************************************************
     * getCicGlsMensAtr
     *******************************************************************************************************/
    /**
     *
     * @return cicGlsMensAtr TODO_javadoc.
     *
     */
    public String getCicGlsMensAtr() {
        return subValue(49, 50);
    }

    /*******************************************************************************************************
     * getCicGlsMens
     *******************************************************************************************************/
    /**
     *
     * @return cicGlsMens TODO_javadoc.
     *
     */
    public CicGlsMens getCicGlsMens() {
        return cicGlsMens;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class CicGlsMens {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public CicGlsMens() {
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
            replaceValue(50, 129, value);
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
            return subValue(50, 50 + 79);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setCicGlsMen1
         *******************************************************************************************************/
        /**
         *
         * @param cicGlsMen1 TODO_javadoc.
         *
         */
        public void setCicGlsMen1(String cicGlsMen1) {
            replaceValue(50, 90, cicGlsMen1);
        }

        /*******************************************************************************************************
         * setCicGlsMen2
         *******************************************************************************************************/
        /**
         *
         * @param cicGlsMen2 TODO_javadoc.
         *
         */
        public void setCicGlsMen2(String cicGlsMen2) {
            replaceValue(90, 129, cicGlsMen2);
        }

        /*******************************************************************************************************
         * getCicGlsMen1
         *******************************************************************************************************/
        /**
         *
         * @return cicGlsMen1 TODO_javadoc.
         *
         */
        public String getCicGlsMen1() {
            return subValue(50, 90);
        }

        /*******************************************************************************************************
         * getCicGlsMen2
         *******************************************************************************************************/
        /**
         *
         * @return cicGlsMen2 TODO_javadoc.
         *
         */
        public String getCicGlsMen2() {
            return subValue(90, 129);
        }

    }

}

