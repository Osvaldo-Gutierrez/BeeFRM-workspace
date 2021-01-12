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
public class HeaderMens extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(HeaderMens.class);

    /** TODO_javadoc. */
    private HeaderIreq headerIreq = new HeaderIreq();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public HeaderMens() {

        initBuffer(100);

        replaceValue(0, 100, "                                                                                                    "); // HEADER-MENS
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
        replaceValue(0, 100, value);
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
        return subValue(0, 100);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setHeaderVers
     *******************************************************************************************************/
    /**
     *
     * @param headerVers TODO_javadoc.
     *
     */
    public void setHeaderVers(String headerVers) {
        replaceValue(0, 4, headerVers);
    }

    /*******************************************************************************************************
     * setHeaderBnco
     *******************************************************************************************************/
    /**
     *
     * @param headerBnco TODO_javadoc.
     *
     */
    public void setHeaderBnco(String headerBnco) {
        replaceValue(4, 7, headerBnco);
    }

    /*******************************************************************************************************
     * setHeaderMrca
     *******************************************************************************************************/
    /**
     *
     * @param headerMrca TODO_javadoc.
     *
     */
    public void setHeaderMrca(String headerMrca) {
        replaceValue(7, 10, headerMrca);
    }

    /*******************************************************************************************************
     * setHeaderCart
     *******************************************************************************************************/
    /**
     *
     * @param headerCart TODO_javadoc.
     *
     */
    public void setHeaderCart(String headerCart) {
        replaceValue(10, 13, headerCart);
    }

    /*******************************************************************************************************
     * setHeaderLeng
     *******************************************************************************************************/
    /**
     *
     * @param headerLeng TODO_javadoc.
     *
     */
    public void setHeaderLeng(String headerLeng) {
        replaceValue(13, 15, headerLeng);
    }

    /*******************************************************************************************************
     * setHeaderPais
     *******************************************************************************************************/
    /**
     *
     * @param headerPais TODO_javadoc.
     *
     */
    public void setHeaderPais(String headerPais) {
        replaceValue(15, 17, headerPais);
    }

    /*******************************************************************************************************
     * setHeaderVrnt
     *******************************************************************************************************/
    /**
     *
     * @param headerVrnt TODO_javadoc.
     *
     */
    public void setHeaderVrnt(String headerVrnt) {
        replaceValue(17, 18, headerVrnt);
    }

    /*******************************************************************************************************
     * setHeaderUser
     *******************************************************************************************************/
    /**
     *
     * @param headerUser TODO_javadoc.
     *
     */
    public void setHeaderUser(String headerUser) {
        replaceValue(18, 30, headerUser);
    }

    /*******************************************************************************************************
     * setHeaderCnal
     *******************************************************************************************************/
    /**
     *
     * @param headerCnal TODO_javadoc.
     *
     */
    public void setHeaderCnal(String headerCnal) {
        replaceValue(30, 35, headerCnal);
    }

    /*******************************************************************************************************
     * setHeaderUmua
     *******************************************************************************************************/
    /**
     *
     * @param headerUmua TODO_javadoc.
     *
     */
    public void setHeaderUmua(String headerUmua) {
        replaceValue(35, 47, headerUmua);
    }

    /*******************************************************************************************************
     * setHeaderProg
     *******************************************************************************************************/
    /**
     *
     * @param headerProg TODO_javadoc.
     *
     */
    public void setHeaderProg(String headerProg) {
        replaceValue(47, 55, headerProg);
    }

    /*******************************************************************************************************
     * setHeaderIbya
     *******************************************************************************************************/
    /**
     *
     * @param headerIbya TODO_javadoc.
     *
     */
    public void setHeaderIbya(String headerIbya) {
        replaceValue(55, 56, headerIbya);
    }

    /*******************************************************************************************************
     * setHeaderBcki
     *******************************************************************************************************/
    /**
     *
     * @param headerBcki TODO_javadoc.
     *
     */
    public void setHeaderBcki(String headerBcki) {
        replaceValue(56, 57, headerBcki);
    }

    /*******************************************************************************************************
     * setHeaderI24h
     *******************************************************************************************************/
    /**
     *
     * @param headerI24h TODO_javadoc.
     *
     */
    public void setHeaderI24h(String headerI24h) {
        replaceValue(57, 58, headerI24h);
    }

    /*******************************************************************************************************
     * setHeaderModo
     *******************************************************************************************************/
    /**
     *
     * @param headerModo TODO_javadoc.
     *
     */
    public void setHeaderModo(String headerModo) {
        replaceValue(57, 58, headerModo);
    }

    /*******************************************************************************************************
     * setHeaderMnsf
     *******************************************************************************************************/
    /**
     *
     * @param headerMnsf TODO_javadoc.
     *
     */
    public void setHeaderMnsf(String headerMnsf) {
        replaceValue(58, 59, headerMnsf);
    }

    /*******************************************************************************************************
     * setHeaderOrig
     *******************************************************************************************************/
    /**
     *
     * @param headerOrig TODO_javadoc.
     *
     */
    public void setHeaderOrig(String headerOrig) {
        replaceValue(59, 62, headerOrig);
    }

    /*******************************************************************************************************
     * setHeaderMsgc
     *******************************************************************************************************/
    /**
     *
     * @param headerMsgc TODO_javadoc.
     *
     */
    public void setHeaderMsgc(String headerMsgc) {
        replaceValue(62, 63, headerMsgc);
    }

    /*******************************************************************************************************
     * setHeaderMsgm
     *******************************************************************************************************/
    /**
     *
     * @param headerMsgm TODO_javadoc.
     *
     */
    public void setHeaderMsgm(String headerMsgm) {
        replaceValue(63, 64, headerMsgm);
    }

    /*******************************************************************************************************
     * setHeaderDis1
     *******************************************************************************************************/
    /**
     *
     * @param headerDis1 TODO_javadoc.
     *
     */
    public void setHeaderDis1(String headerDis1) {
        replaceValue(64, 90, headerDis1);
    }

    /*******************************************************************************************************
     * getHeaderVers
     *******************************************************************************************************/
    /**
     *
     * @return headerVers TODO_javadoc.
     *
     */
    public String getHeaderVers() {
        return subValue(0, 4);
    }

    /*******************************************************************************************************
     * getHeaderBnco
     *******************************************************************************************************/
    /**
     *
     * @return headerBnco TODO_javadoc.
     *
     */
    public String getHeaderBnco() {
        return subValue(4, 7);
    }

    /*******************************************************************************************************
     * getHeaderMrca
     *******************************************************************************************************/
    /**
     *
     * @return headerMrca TODO_javadoc.
     *
     */
    public String getHeaderMrca() {
        return subValue(7, 10);
    }

    /*******************************************************************************************************
     * getHeaderCart
     *******************************************************************************************************/
    /**
     *
     * @return headerCart TODO_javadoc.
     *
     */
    public String getHeaderCart() {
        return subValue(10, 13);
    }

    /*******************************************************************************************************
     * getHeaderLeng
     *******************************************************************************************************/
    /**
     *
     * @return headerLeng TODO_javadoc.
     *
     */
    public String getHeaderLeng() {
        return subValue(13, 15);
    }

    /*******************************************************************************************************
     * getHeaderPais
     *******************************************************************************************************/
    /**
     *
     * @return headerPais TODO_javadoc.
     *
     */
    public String getHeaderPais() {
        return subValue(15, 17);
    }

    /*******************************************************************************************************
     * getHeaderVrnt
     *******************************************************************************************************/
    /**
     *
     * @return headerVrnt TODO_javadoc.
     *
     */
    public String getHeaderVrnt() {
        return subValue(17, 18);
    }

    /*******************************************************************************************************
     * getHeaderUser
     *******************************************************************************************************/
    /**
     *
     * @return headerUser TODO_javadoc.
     *
     */
    public String getHeaderUser() {
        return subValue(18, 30);
    }

    /*******************************************************************************************************
     * getHeaderCnal
     *******************************************************************************************************/
    /**
     *
     * @return headerCnal TODO_javadoc.
     *
     */
    public String getHeaderCnal() {
        return subValue(30, 35);
    }

    /*******************************************************************************************************
     * getHeaderUmua
     *******************************************************************************************************/
    /**
     *
     * @return headerUmua TODO_javadoc.
     *
     */
    public String getHeaderUmua() {
        return subValue(35, 47);
    }

    /*******************************************************************************************************
     * getHeaderProg
     *******************************************************************************************************/
    /**
     *
     * @return headerProg TODO_javadoc.
     *
     */
    public String getHeaderProg() {
        return subValue(47, 55);
    }

    /*******************************************************************************************************
     * getHeaderIbya
     *******************************************************************************************************/
    /**
     *
     * @return headerIbya TODO_javadoc.
     *
     */
    public String getHeaderIbya() {
        return subValue(55, 56);
    }

    /*******************************************************************************************************
     * getHeaderBcki
     *******************************************************************************************************/
    /**
     *
     * @return headerBcki TODO_javadoc.
     *
     */
    public String getHeaderBcki() {
        return subValue(56, 57);
    }

    /*******************************************************************************************************
     * getHeaderI24h
     *******************************************************************************************************/
    /**
     *
     * @return headerI24h TODO_javadoc.
     *
     */
    public String getHeaderI24h() {
        return subValue(57, 58);
    }

    /*******************************************************************************************************
     * getHeaderModo
     *******************************************************************************************************/
    /**
     *
     * @return headerModo TODO_javadoc.
     *
     */
    public String getHeaderModo() {
        return subValue(57, 58);
    }

    /*******************************************************************************************************
     * getHeaderMnsf
     *******************************************************************************************************/
    /**
     *
     * @return headerMnsf TODO_javadoc.
     *
     */
    public String getHeaderMnsf() {
        return subValue(58, 59);
    }

    /*******************************************************************************************************
     * getHeaderOrig
     *******************************************************************************************************/
    /**
     *
     * @return headerOrig TODO_javadoc.
     *
     */
    public String getHeaderOrig() {
        return subValue(59, 62);
    }

    /*******************************************************************************************************
     * getHeaderMsgc
     *******************************************************************************************************/
    /**
     *
     * @return headerMsgc TODO_javadoc.
     *
     */
    public String getHeaderMsgc() {
        return subValue(62, 63);
    }

    /*******************************************************************************************************
     * getHeaderMsgm
     *******************************************************************************************************/
    /**
     *
     * @return headerMsgm TODO_javadoc.
     *
     */
    public String getHeaderMsgm() {
        return subValue(63, 64);
    }

    /*******************************************************************************************************
     * getHeaderDis1
     *******************************************************************************************************/
    /**
     *
     * @return headerDis1 TODO_javadoc.
     *
     */
    public String getHeaderDis1() {
        return subValue(64, 90);
    }

    /*******************************************************************************************************
     * getHeaderIreq
     *******************************************************************************************************/
    /**
     *
     * @return headerIreq TODO_javadoc.
     *
     */
    public HeaderIreq getHeaderIreq() {
        return headerIreq;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class HeaderIreq {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public HeaderIreq() {
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
            replaceValue(90, 100, value);
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
            return subValue(90, 90 + 10);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setHeaderIr01
         *******************************************************************************************************/
        /**
         *
         * @param headerIr01 TODO_javadoc.
         *
         */
        public void setHeaderIr01(String headerIr01) {
            replaceValue(90, 91, headerIr01);
        }

        /*******************************************************************************************************
         * setHeaderIr02
         *******************************************************************************************************/
        /**
         *
         * @param headerIr02 TODO_javadoc.
         *
         */
        public void setHeaderIr02(String headerIr02) {
            replaceValue(91, 92, headerIr02);
        }

        /*******************************************************************************************************
         * setHeaderIr03
         *******************************************************************************************************/
        /**
         *
         * @param headerIr03 TODO_javadoc.
         *
         */
        public void setHeaderIr03(String headerIr03) {
            replaceValue(92, 93, headerIr03);
        }

        /*******************************************************************************************************
         * setHeaderIr04
         *******************************************************************************************************/
        /**
         *
         * @param headerIr04 TODO_javadoc.
         *
         */
        public void setHeaderIr04(String headerIr04) {
            replaceValue(93, 94, headerIr04);
        }

        /*******************************************************************************************************
         * setHeaderIr05
         *******************************************************************************************************/
        /**
         *
         * @param headerIr05 TODO_javadoc.
         *
         */
        public void setHeaderIr05(String headerIr05) {
            replaceValue(94, 95, headerIr05);
        }

        /*******************************************************************************************************
         * setHeaderIr06
         *******************************************************************************************************/
        /**
         *
         * @param headerIr06 TODO_javadoc.
         *
         */
        public void setHeaderIr06(String headerIr06) {
            replaceValue(95, 96, headerIr06);
        }

        /*******************************************************************************************************
         * setHeaderIr07
         *******************************************************************************************************/
        /**
         *
         * @param headerIr07 TODO_javadoc.
         *
         */
        public void setHeaderIr07(String headerIr07) {
            replaceValue(96, 97, headerIr07);
        }

        /*******************************************************************************************************
         * setHeaderIr08
         *******************************************************************************************************/
        /**
         *
         * @param headerIr08 TODO_javadoc.
         *
         */
        public void setHeaderIr08(String headerIr08) {
            replaceValue(97, 98, headerIr08);
        }

        /*******************************************************************************************************
         * setHeaderIr09
         *******************************************************************************************************/
        /**
         *
         * @param headerIr09 TODO_javadoc.
         *
         */
        public void setHeaderIr09(String headerIr09) {
            replaceValue(98, 99, headerIr09);
        }

        /*******************************************************************************************************
         * setHeaderIr10
         *******************************************************************************************************/
        /**
         *
         * @param headerIr10 TODO_javadoc.
         *
         */
        public void setHeaderIr10(String headerIr10) {
            replaceValue(99, 100, headerIr10);
        }

        /*******************************************************************************************************
         * getHeaderIr01
         *******************************************************************************************************/
        /**
         *
         * @return headerIr01 TODO_javadoc.
         *
         */
        public String getHeaderIr01() {
            return subValue(90, 91);
        }

        /*******************************************************************************************************
         * getHeaderIr02
         *******************************************************************************************************/
        /**
         *
         * @return headerIr02 TODO_javadoc.
         *
         */
        public String getHeaderIr02() {
            return subValue(91, 92);
        }

        /*******************************************************************************************************
         * getHeaderIr03
         *******************************************************************************************************/
        /**
         *
         * @return headerIr03 TODO_javadoc.
         *
         */
        public String getHeaderIr03() {
            return subValue(92, 93);
        }

        /*******************************************************************************************************
         * getHeaderIr04
         *******************************************************************************************************/
        /**
         *
         * @return headerIr04 TODO_javadoc.
         *
         */
        public String getHeaderIr04() {
            return subValue(93, 94);
        }

        /*******************************************************************************************************
         * getHeaderIr05
         *******************************************************************************************************/
        /**
         *
         * @return headerIr05 TODO_javadoc.
         *
         */
        public String getHeaderIr05() {
            return subValue(94, 95);
        }

        /*******************************************************************************************************
         * getHeaderIr06
         *******************************************************************************************************/
        /**
         *
         * @return headerIr06 TODO_javadoc.
         *
         */
        public String getHeaderIr06() {
            return subValue(95, 96);
        }

        /*******************************************************************************************************
         * getHeaderIr07
         *******************************************************************************************************/
        /**
         *
         * @return headerIr07 TODO_javadoc.
         *
         */
        public String getHeaderIr07() {
            return subValue(96, 97);
        }

        /*******************************************************************************************************
         * getHeaderIr08
         *******************************************************************************************************/
        /**
         *
         * @return headerIr08 TODO_javadoc.
         *
         */
        public String getHeaderIr08() {
            return subValue(97, 98);
        }

        /*******************************************************************************************************
         * getHeaderIr09
         *******************************************************************************************************/
        /**
         *
         * @return headerIr09 TODO_javadoc.
         *
         */
        public String getHeaderIr09() {
            return subValue(98, 99);
        }

        /*******************************************************************************************************
         * getHeaderIr10
         *******************************************************************************************************/
        /**
         *
         * @return headerIr10 TODO_javadoc.
         *
         */
        public String getHeaderIr10() {
            return subValue(99, 100);
        }

    }

}

