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
public class WssMensaje extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(WssMensaje.class);

    /** TODO_javadoc. */
    private WssMensIni wssMensIni = new WssMensIni();

    /** TODO_javadoc. */
    private WssMensCmmaTot wssMensCmmaTot = new WssMensCmmaTot();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public WssMensaje() {

        initBuffer(7000);

        replaceValue(0, 7000, "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "); // WSS-MENSAJE
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
        replaceValue(0, 7000, value);
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
        return subValue(0, 7000);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setWssMensWi
     *******************************************************************************************************/
    /**
     *
     * @param wssMensWi TODO_javadoc.
     *
     */
    public void setWssMensWi(String wssMensWi) {
        replaceValue(4186, 6200, wssMensWi);
    }

    /*******************************************************************************************************
     * setWssMensFill
     *******************************************************************************************************/
    /**
     *
     * @param wssMensFill TODO_javadoc.
     *
     */
    public void setWssMensFill(String wssMensFill) {
        replaceValue(6200, 7000, wssMensFill);
    }

    /*******************************************************************************************************
     * getWssMensIni
     *******************************************************************************************************/
    /**
     *
     * @return wssMensIni TODO_javadoc.
     *
     */
    public WssMensIni getWssMensIni() {
        return wssMensIni;
    }

    /*******************************************************************************************************
     * getWssMensCmmaTot
     *******************************************************************************************************/
    /**
     *
     * @return wssMensCmmaTot TODO_javadoc.
     *
     */
    public WssMensCmmaTot getWssMensCmmaTot() {
        return wssMensCmmaTot;
    }

    /*******************************************************************************************************
     * getWssMensWi
     *******************************************************************************************************/
    /**
     *
     * @return wssMensWi TODO_javadoc.
     *
     */
    public String getWssMensWi() {
        return subValue(4186, 6200);
    }

    /*******************************************************************************************************
     * getWssMensFill
     *******************************************************************************************************/
    /**
     *
     * @return wssMensFill TODO_javadoc.
     *
     */
    public String getWssMensFill() {
        return subValue(6200, 7000);
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class WssMensIni {

        /** TODO_javadoc. */
        private WssMensIniFill wssMensIniFill = new WssMensIniFill();

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssMensIni() {
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
            replaceValue(0, 186, value);
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
            return subValue(0, 186);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setWssMensIniStat
         *******************************************************************************************************/
        /**
         *
         * @param wssMensIniStat TODO_javadoc.
         *
         */
        public void setWssMensIniStat(String wssMensIniStat) {
            replaceValue(0, 1, wssMensIniStat);
        }

        /*******************************************************************************************************
         * setWssMensIniMens
         *******************************************************************************************************/
        /**
         *
         * @param wssMensIniMens TODO_javadoc.
         *
         */
        public void setWssMensIniMens(String wssMensIniMens) {
            replaceValue(1, 80, wssMensIniMens);
        }

        /*******************************************************************************************************
         * setWssMensIniInic
         *******************************************************************************************************/
        /**
         *
         * @param wssMensIniInic TODO_javadoc.
         *
         */
        public void setWssMensIniInic(String wssMensIniInic) {
            replaceValue(80, 81, wssMensIniInic);
        }

        /*******************************************************************************************************
         * setWssMensIniNtrn
         *******************************************************************************************************/
        /**
         *
         * @param wssMensIniNtrn TODO_javadoc.
         *
         */
        public void setWssMensIniNtrn(String wssMensIniNtrn) {
            replaceValue(81, 85, wssMensIniNtrn);
        }

        /*******************************************************************************************************
         * setWssMensIniSist
         *******************************************************************************************************/
        /**
         *
         * @param wssMensIniSist TODO_javadoc.
         *
         */
        public void setWssMensIniSist(String wssMensIniSist) {
            replaceValue(85, 88, wssMensIniSist);
        }

        /*******************************************************************************************************
         * setWssMensIniSisg
         *******************************************************************************************************/
        /**
         *
         * @param wssMensIniSisg TODO_javadoc.
         *
         */
        public void setWssMensIniSisg(String wssMensIniSisg) {
            replaceValue(88, 91, wssMensIniSisg);
        }

        /*******************************************************************************************************
         * setWssMensIniOpci
         *******************************************************************************************************/
        /**
         *
         * @param wssMensIniOpci TODO_javadoc.
         *
         */
        public void setWssMensIniOpci(String wssMensIniOpci) {
            replaceValue(91, 94, wssMensIniOpci);
        }

        /*******************************************************************************************************
         * setWssMensIniCmnd
         *******************************************************************************************************/
        /**
         *
         * @param wssMensIniCmnd TODO_javadoc.
         *
         */
        public void setWssMensIniCmnd(String wssMensIniCmnd) {
            replaceValue(94, 97, wssMensIniCmnd);
        }

        /*******************************************************************************************************
         * setWssMensIniBnco
         *******************************************************************************************************/
        /**
         *
         * @param wssMensIniBnco TODO_javadoc.
         *
         */
        public void setWssMensIniBnco(String wssMensIniBnco) {
            replaceValue(97, 100, wssMensIniBnco);
        }

        /*******************************************************************************************************
         * setWssMensIniMrca
         *******************************************************************************************************/
        /**
         *
         * @param wssMensIniMrca TODO_javadoc.
         *
         */
        public void setWssMensIniMrca(String wssMensIniMrca) {
            replaceValue(100, 103, wssMensIniMrca);
        }

        /*******************************************************************************************************
         * setWssMensIniCart
         *******************************************************************************************************/
        /**
         *
         * @param wssMensIniCart TODO_javadoc.
         *
         */
        public void setWssMensIniCart(String wssMensIniCart) {
            replaceValue(103, 106, wssMensIniCart);
        }

        /*******************************************************************************************************
         * setWssMensIniLeng
         *******************************************************************************************************/
        /**
         *
         * @param wssMensIniLeng TODO_javadoc.
         *
         */
        public void setWssMensIniLeng(String wssMensIniLeng) {
            replaceValue(106, 108, wssMensIniLeng);
        }

        /*******************************************************************************************************
         * setWssMensIniPais
         *******************************************************************************************************/
        /**
         *
         * @param wssMensIniPais TODO_javadoc.
         *
         */
        public void setWssMensIniPais(String wssMensIniPais) {
            replaceValue(108, 110, wssMensIniPais);
        }

        /*******************************************************************************************************
         * setWssMensIniVrnt
         *******************************************************************************************************/
        /**
         *
         * @param wssMensIniVrnt TODO_javadoc.
         *
         */
        public void setWssMensIniVrnt(String wssMensIniVrnt) {
            replaceValue(110, 111, wssMensIniVrnt);
        }

        /*******************************************************************************************************
         * setWssMensIniUser
         *******************************************************************************************************/
        /**
         *
         * @param wssMensIniUser TODO_javadoc.
         *
         */
        public void setWssMensIniUser(String wssMensIniUser) {
            replaceValue(111, 123, wssMensIniUser);
        }

        /*******************************************************************************************************
         * setWssMensIniModo
         *******************************************************************************************************/
        /**
         *
         * @param wssMensIniModo TODO_javadoc.
         *
         */
        public void setWssMensIniModo(String wssMensIniModo) {
            replaceValue(123, 124, wssMensIniModo);
        }

        /*******************************************************************************************************
         * setWssMensIniCnal
         *******************************************************************************************************/
        /**
         *
         * @param wssMensIniCnal TODO_javadoc.
         *
         */
        public void setWssMensIniCnal(String wssMensIniCnal) {
            replaceValue(124, 127, wssMensIniCnal);
        }

        /*******************************************************************************************************
         * setWssMensIniTran
         *******************************************************************************************************/
        /**
         *
         * @param wssMensIniTran TODO_javadoc.
         *
         */
        public void setWssMensIniTran(String wssMensIniTran) {
            replaceValue(127, 134, wssMensIniTran);
        }

        /*******************************************************************************************************
         * getWssMensIniStat
         *******************************************************************************************************/
        /**
         *
         * @return wssMensIniStat TODO_javadoc.
         *
         */
        public String getWssMensIniStat() {
            return subValue(0, 1);
        }

        /*******************************************************************************************************
         * getWssMensIniMens
         *******************************************************************************************************/
        /**
         *
         * @return wssMensIniMens TODO_javadoc.
         *
         */
        public String getWssMensIniMens() {
            return subValue(1, 80);
        }

        /*******************************************************************************************************
         * getWssMensIniInic
         *******************************************************************************************************/
        /**
         *
         * @return wssMensIniInic TODO_javadoc.
         *
         */
        public String getWssMensIniInic() {
            return subValue(80, 81);
        }

        /*******************************************************************************************************
         * getWssMensIniNtrn
         *******************************************************************************************************/
        /**
         *
         * @return wssMensIniNtrn TODO_javadoc.
         *
         */
        public String getWssMensIniNtrn() {
            return subValue(81, 85);
        }

        /*******************************************************************************************************
         * getWssMensIniSist
         *******************************************************************************************************/
        /**
         *
         * @return wssMensIniSist TODO_javadoc.
         *
         */
        public String getWssMensIniSist() {
            return subValue(85, 88);
        }

        /*******************************************************************************************************
         * getWssMensIniSisg
         *******************************************************************************************************/
        /**
         *
         * @return wssMensIniSisg TODO_javadoc.
         *
         */
        public String getWssMensIniSisg() {
            return subValue(88, 91);
        }

        /*******************************************************************************************************
         * getWssMensIniOpci
         *******************************************************************************************************/
        /**
         *
         * @return wssMensIniOpci TODO_javadoc.
         *
         */
        public String getWssMensIniOpci() {
            return subValue(91, 94);
        }

        /*******************************************************************************************************
         * getWssMensIniCmnd
         *******************************************************************************************************/
        /**
         *
         * @return wssMensIniCmnd TODO_javadoc.
         *
         */
        public String getWssMensIniCmnd() {
            return subValue(94, 97);
        }

        /*******************************************************************************************************
         * getWssMensIniBnco
         *******************************************************************************************************/
        /**
         *
         * @return wssMensIniBnco TODO_javadoc.
         *
         */
        public String getWssMensIniBnco() {
            return subValue(97, 100);
        }

        /*******************************************************************************************************
         * getWssMensIniMrca
         *******************************************************************************************************/
        /**
         *
         * @return wssMensIniMrca TODO_javadoc.
         *
         */
        public String getWssMensIniMrca() {
            return subValue(100, 103);
        }

        /*******************************************************************************************************
         * getWssMensIniCart
         *******************************************************************************************************/
        /**
         *
         * @return wssMensIniCart TODO_javadoc.
         *
         */
        public String getWssMensIniCart() {
            return subValue(103, 106);
        }

        /*******************************************************************************************************
         * getWssMensIniLeng
         *******************************************************************************************************/
        /**
         *
         * @return wssMensIniLeng TODO_javadoc.
         *
         */
        public String getWssMensIniLeng() {
            return subValue(106, 108);
        }

        /*******************************************************************************************************
         * getWssMensIniPais
         *******************************************************************************************************/
        /**
         *
         * @return wssMensIniPais TODO_javadoc.
         *
         */
        public String getWssMensIniPais() {
            return subValue(108, 110);
        }

        /*******************************************************************************************************
         * getWssMensIniVrnt
         *******************************************************************************************************/
        /**
         *
         * @return wssMensIniVrnt TODO_javadoc.
         *
         */
        public String getWssMensIniVrnt() {
            return subValue(110, 111);
        }

        /*******************************************************************************************************
         * getWssMensIniUser
         *******************************************************************************************************/
        /**
         *
         * @return wssMensIniUser TODO_javadoc.
         *
         */
        public String getWssMensIniUser() {
            return subValue(111, 123);
        }

        /*******************************************************************************************************
         * getWssMensIniModo
         *******************************************************************************************************/
        /**
         *
         * @return wssMensIniModo TODO_javadoc.
         *
         */
        public String getWssMensIniModo() {
            return subValue(123, 124);
        }

        /*******************************************************************************************************
         * getWssMensIniCnal
         *******************************************************************************************************/
        /**
         *
         * @return wssMensIniCnal TODO_javadoc.
         *
         */
        public String getWssMensIniCnal() {
            return subValue(124, 127);
        }

        /*******************************************************************************************************
         * getWssMensIniTran
         *******************************************************************************************************/
        /**
         *
         * @return wssMensIniTran TODO_javadoc.
         *
         */
        public String getWssMensIniTran() {
            return subValue(127, 134);
        }

        /*******************************************************************************************************
         * getWssMensIniFill
         *******************************************************************************************************/
        /**
         *
         * @return wssMensIniFill TODO_javadoc.
         *
         */
        public WssMensIniFill getWssMensIniFill() {
            return wssMensIniFill;
        }

        /**
         *
         * TODO_javadoc.
         *
         * @author  BEE S.A.
         * @version 1.0
         *
         */
        public class WssMensIniFill {

            /*******************************************************************************************************
             *
             *******************************************************************************************************/
            /**
             *
             */
            public WssMensIniFill() {
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
                replaceValue(134, 186, value);
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
                return subValue(134, 134 + 52);
            }

            //
            //
            //

            /*******************************************************************************************************
             * setWssMensIniTecl
             *******************************************************************************************************/
            /**
             *
             * @param wssMensIniTecl TODO_javadoc.
             *
             */
            public void setWssMensIniTecl(String wssMensIniTecl) {
                replaceValue(134, 137, wssMensIniTecl);
            }

            /*******************************************************************************************************
             * setWssMensIniCommit
             *******************************************************************************************************/
            /**
             *
             * @param wssMensIniCommit TODO_javadoc.
             *
             */
            public void setWssMensIniCommit(String wssMensIniCommit) {
                replaceValue(137, 138, wssMensIniCommit);
            }

            /*******************************************************************************************************
             * setWssMensIniFillx
             *******************************************************************************************************/
            /**
             *
             * @param wssMensIniFillx TODO_javadoc.
             *
             */
            public void setWssMensIniFillx(String wssMensIniFillx) {
                replaceValue(138, 174, wssMensIniFillx);
            }

            /*******************************************************************************************************
             * setWssMensIniCidd
             *******************************************************************************************************/
            /**
             *
             * @param wssMensIniCidd TODO_javadoc.
             *
             */
            public void setWssMensIniCidd(String wssMensIniCidd) {
                replaceValue(174, 186, wssMensIniCidd);
            }

            /*******************************************************************************************************
             * getWssMensIniTecl
             *******************************************************************************************************/
            /**
             *
             * @return wssMensIniTecl TODO_javadoc.
             *
             */
            public String getWssMensIniTecl() {
                return subValue(134, 137);
            }

            /*******************************************************************************************************
             * getWssMensIniCommit
             *******************************************************************************************************/
            /**
             *
             * @return wssMensIniCommit TODO_javadoc.
             *
             */
            public String getWssMensIniCommit() {
                return subValue(137, 138);
            }

            /*******************************************************************************************************
             * getWssMensIniFillx
             *******************************************************************************************************/
            /**
             *
             * @return wssMensIniFillx TODO_javadoc.
             *
             */
            public String getWssMensIniFillx() {
                return subValue(138, 174);
            }

            /*******************************************************************************************************
             * getWssMensIniCidd
             *******************************************************************************************************/
            /**
             *
             * @return wssMensIniCidd TODO_javadoc.
             *
             */
            public String getWssMensIniCidd() {
                return subValue(174, 186);
            }

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
    public class WssMensCmmaTot {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssMensCmmaTot() {
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
            replaceValue(186, 4186, value);
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
            return subValue(186, 186 + 4000);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setWssMensCmmaTip
         *******************************************************************************************************/
        /**
         *
         * @param wssMensCmmaTip TODO_javadoc.
         *
         */
        public void setWssMensCmmaTip(String wssMensCmmaTip) {
            replaceValue(186, 187, wssMensCmmaTip);
        }

        /*******************************************************************************************************
         * setWssMensCmma
         *******************************************************************************************************/
        /**
         *
         * @param wssMensCmma TODO_javadoc.
         *
         */
        public void setWssMensCmma(String wssMensCmma) {
            replaceValue(187, 4186, wssMensCmma);
        }

        /*******************************************************************************************************
         * getWssMensCmmaTip
         *******************************************************************************************************/
        /**
         *
         * @return wssMensCmmaTip TODO_javadoc.
         *
         */
        public String getWssMensCmmaTip() {
            return subValue(186, 187);
        }

        /*******************************************************************************************************
         * getWssMensCmma
         *******************************************************************************************************/
        /**
         *
         * @return wssMensCmma TODO_javadoc.
         *
         */
        public String getWssMensCmma() {
            return subValue(187, 4186);
        }

    }

}

