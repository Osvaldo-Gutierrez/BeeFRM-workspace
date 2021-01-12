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
public class WssVari extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(WssVari.class);

    /** TODO_javadoc. */
    private static DecimalFormat form1z = new DecimalFormat("0");

    /** TODO_javadoc. */
    private static DecimalFormat form2z = new DecimalFormat("00");

    /** TODO_javadoc. */
    private static DecimalFormat form4z = new DecimalFormat("0000");

    /** TODO_javadoc. */
    private WssCodMsg0 wssCodMsg0 = new WssCodMsg0();

    /** TODO_javadoc. */
    private WssAux1 wssAux1 = new WssAux1();

    /** TODO_javadoc. */
    private WssAux2 wssAux2 = new WssAux2();

    /** TODO_javadoc. */
    private WssQidd wssQidd = new WssQidd();

    /** TODO_javadoc. */
    private WssDfld wssDfld = new WssDfld();

    /** TODO_javadoc. */
    private WssFunc wssFunc = new WssFunc();

    /** TODO_javadoc. */
    private WssAfun wssAfun = new WssAfun();

    /** TODO_javadoc. */
    private WssOpci wssOpci = new WssOpci();

    /** TODO_javadoc. */
    private WssCmnd wssCmnd = new WssCmnd();

    /** TODO_javadoc. */
    private WssMaut wssMaut = new WssMaut();

    /** TODO_javadoc. */
    private WssMautRed wssMautRed = new WssMautRed();

    /** TODO_javadoc. */
    private WssSind wssSind = new WssSind();

    /** TODO_javadoc. */
    private UypPrta uypPrta = new UypPrta();

    /** TODO_javadoc. */
    private WssMens wssMens = new WssMens();

    /** TODO_javadoc. */
    private WssCodMens wssCodMens = new WssCodMens();

    /** TODO_javadoc. */
    private WssAuxCrpf wssAuxCrpf = new WssAuxCrpf();

    /** TODO_javadoc. */
    private WssKnmo wssKnmo = new WssKnmo();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public WssVari() {

        initBuffer(1244);

        replaceValue(0, 1244, "000{                                 000{                                                             0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000                                                                                                                                                   0                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    "); // WSS-VARI
        replaceValue(0, 4, setCompNumber(490, form4z)); // WSS-QIDD-LEN
        replaceValue(37, 41, setCompNumber(3588, form4z)); // WSS-SXCT
        replaceValue(41, 45, "GIDD"); // WSS-NIDD
        replaceValue(49, 54, "     "); // WSS-CCOD
        replaceValue(318, 320, form2z.format(1)); // WSS-STDO
        replaceValue(320, 322, form2z.format(0)); // WSS-ISIS
        replaceValue(322, 324, form2z.format(0)); // WSS-IOPC
        replaceValue(324, 326, form2z.format(0)); // WSS-ICMD
        replaceValue(326, 328, form2z.format(0)); // WSS-IMAX
        replaceValue(328, 330, form2z.format(9)); // WSS-IVAL
        replaceValue(351, 352, "/"); // FILLER
        replaceValue(487, 488, form1z.format(0)); // WSS-IND-CMND
        replaceValue(1215, 1244, "                             "); // WSS-KNMO
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
        replaceValue(0, 1244, value);
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
        return subValue(0, 1244);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setWssQiddLen
     *******************************************************************************************************/
    /**
     *
     * @param wssQiddLen TODO_javadoc.
     *
     */
    public void setWssQiddLen(int wssQiddLen) {
        replaceValue(0, 4, setCompNumber(wssQiddLen, form4z));
    }

    /*******************************************************************************************************
     * setWssTransaccional
     *******************************************************************************************************/
    /**
     *
     * @param wssTransaccional TODO_javadoc.
     *
     */
    public void setWssTransaccional(String wssTransaccional) {
        replaceValue(32, 33, wssTransaccional);
    }

    /*******************************************************************************************************
     * setWssScod
     *******************************************************************************************************/
    /**
     *
     * @param wssScod TODO_javadoc.
     *
     */
    public void setWssScod(String wssScod) {
        replaceValue(33, 35, wssScod);
    }

    /*******************************************************************************************************
     * setWssSefn
     *******************************************************************************************************/
    /**
     *
     * @param wssSefn TODO_javadoc.
     *
     */
    public void setWssSefn(String wssSefn) {
        replaceValue(35, 37, wssSefn);
    }

    /*******************************************************************************************************
     * setWssSxct
     *******************************************************************************************************/
    /**
     *
     * @param wssSxct TODO_javadoc.
     *
     */
    public void setWssSxct(int wssSxct) {
        replaceValue(37, 41, setCompNumber(wssSxct, form4z));
    }

    /*******************************************************************************************************
     * setWssSxctRed
     *******************************************************************************************************/
    /**
     *
     * @param wssSxctRed TODO_javadoc.
     *
     */
    public void setWssSxctRed(String wssSxctRed) {
        replaceValue(37, 39, wssSxctRed);
    }

    /*******************************************************************************************************
     * setWssCcod
     *******************************************************************************************************/
    /**
     *
     * @param wssCcod TODO_javadoc.
     *
     */
    public void setWssCcod(String wssCcod) {
        replaceValue(49, 54, wssCcod);
    }

    /*******************************************************************************************************
     * setWssStdo
     *******************************************************************************************************/
    /**
     *
     * @param wssStdo TODO_javadoc.
     *
     */
    public void setWssStdo(int wssStdo) {
        replaceValue(318, 320, form2z.format(wssStdo));
    }

    /*******************************************************************************************************
     * setWssIsis
     *******************************************************************************************************/
    /**
     *
     * @param wssIsis TODO_javadoc.
     *
     */
    public void setWssIsis(int wssIsis) {
        replaceValue(320, 322, form2z.format(wssIsis));
    }

    /*******************************************************************************************************
     * setWssIopc
     *******************************************************************************************************/
    /**
     *
     * @param wssIopc TODO_javadoc.
     *
     */
    public void setWssIopc(int wssIopc) {
        replaceValue(322, 324, form2z.format(wssIopc));
    }

    /*******************************************************************************************************
     * setWssIcmd
     *******************************************************************************************************/
    /**
     *
     * @param wssIcmd TODO_javadoc.
     *
     */
    public void setWssIcmd(int wssIcmd) {
        replaceValue(324, 326, form2z.format(wssIcmd));
    }

    /*******************************************************************************************************
     * setWssImax
     *******************************************************************************************************/
    /**
     *
     * @param wssImax TODO_javadoc.
     *
     */
    public void setWssImax(int wssImax) {
        replaceValue(326, 328, form2z.format(wssImax));
    }

    /*******************************************************************************************************
     * setWssIval
     *******************************************************************************************************/
    /**
     *
     * @param wssIval TODO_javadoc.
     *
     */
    public void setWssIval(int wssIval) {
        replaceValue(328, 330, form2z.format(wssIval));
    }

    /*******************************************************************************************************
     * setWssAuxi
     *******************************************************************************************************/
    /**
     *
     * @param wssAuxi TODO_javadoc.
     *
     */
    public void setWssAuxi(String wssAuxi) {
        replaceValue(340, 343, wssAuxi);
    }

    /*******************************************************************************************************
     * setWssIcmn
     *******************************************************************************************************/
    /**
     *
     * @param wssIcmn TODO_javadoc.
     *
     */
    public void setWssIcmn(String wssIcmn) {
        replaceValue(486, 487, wssIcmn);
    }

    /*******************************************************************************************************
     * setWssIndCmnd
     *******************************************************************************************************/
    /**
     *
     * @param wssIndCmnd TODO_javadoc.
     *
     */
    public void setWssIndCmnd(int wssIndCmnd) {
        replaceValue(487, 488, form1z.format(wssIndCmnd));
    }

    /*******************************************************************************************************
     * setWssAuxCmnp
     *******************************************************************************************************/
    /**
     *
     * @param wssAuxCmnp TODO_javadoc.
     *
     */
    public void setWssAuxCmnp(String wssAuxCmnp) {
        replaceValue(488, 496, wssAuxCmnp);
    }

    /*******************************************************************************************************
     * setWssAuxPrmc
     *******************************************************************************************************/
    /**
     *
     * @param wssAuxPrmc TODO_javadoc.
     *
     */
    public void setWssAuxPrmc(String wssAuxPrmc) {
        replaceValue(496, 521, wssAuxPrmc);
    }

    /*******************************************************************************************************
     * setWssAuxCmnd
     *******************************************************************************************************/
    /**
     *
     * @param wssAuxCmnd TODO_javadoc.
     *
     */
    public void setWssAuxCmnd(String wssAuxCmnd) {
        replaceValue(521, 524, wssAuxCmnd);
    }

    /*******************************************************************************************************
     * setWssIprv
     *******************************************************************************************************/
    /**
     *
     * @param wssIprv TODO_javadoc.
     *
     */
    public void setWssIprv(String wssIprv) {
        replaceValue(1214, 1215, wssIprv);
    }

    /*******************************************************************************************************
     * getWssQiddLen
     *******************************************************************************************************/
    /**
     *
     * @return wssQiddLen TODO_javadoc.
     *
     */
    public int getWssQiddLen() {
        return (int) getCompNumber(subValue(0, 4));
    }

    /*******************************************************************************************************
     * getWssCodMsg0
     *******************************************************************************************************/
    /**
     *
     * @return wssCodMsg0 TODO_javadoc.
     *
     */
    public WssCodMsg0 getWssCodMsg0() {
        return wssCodMsg0;
    }

    /*******************************************************************************************************
     * getWssAux1
     *******************************************************************************************************/
    /**
     *
     * @return wssAux1 TODO_javadoc.
     *
     */
    public WssAux1 getWssAux1() {
        return wssAux1;
    }

    /*******************************************************************************************************
     * getWssAux2
     *******************************************************************************************************/
    /**
     *
     * @return wssAux2 TODO_javadoc.
     *
     */
    public WssAux2 getWssAux2() {
        return wssAux2;
    }

    /*******************************************************************************************************
     * getWssTransaccional
     *******************************************************************************************************/
    /**
     *
     * @return wssTransaccional TODO_javadoc.
     *
     */
    public String getWssTransaccional() {
        return subValue(32, 33);
    }

    /*******************************************************************************************************
     * getWssScod
     *******************************************************************************************************/
    /**
     *
     * @return wssScod TODO_javadoc.
     *
     */
    public String getWssScod() {
        return subValue(33, 35);
    }

    /*******************************************************************************************************
     * getWssSefn
     *******************************************************************************************************/
    /**
     *
     * @return wssSefn TODO_javadoc.
     *
     */
    public String getWssSefn() {
        return subValue(35, 37);
    }

    /*******************************************************************************************************
     * getWssSxct
     *******************************************************************************************************/
    /**
     *
     * @return wssSxct TODO_javadoc.
     *
     */
    public int getWssSxct() {
        return (int) getCompNumber(subValue(37, 41));
    }

    /*******************************************************************************************************
     * getWssSxctRed
     *******************************************************************************************************/
    /**
     *
     * @return wssSxctRed TODO_javadoc.
     *
     */
    public String getWssSxctRed() {
        return subValue(37, 39);
    }

    /*******************************************************************************************************
     * getWssQidd
     *******************************************************************************************************/
    /**
     *
     * @return wssQidd TODO_javadoc.
     *
     */
    public WssQidd getWssQidd() {
        return wssQidd;
    }

    /*******************************************************************************************************
     * getWssCcod
     *******************************************************************************************************/
    /**
     *
     * @return wssCcod TODO_javadoc.
     *
     */
    public String getWssCcod() {
        return subValue(49, 54);
    }

    /*******************************************************************************************************
     * getWssDfld
     *******************************************************************************************************/
    /**
     *
     * @return wssDfld TODO_javadoc.
     *
     */
    public WssDfld getWssDfld() {
        return wssDfld;
    }

    /*******************************************************************************************************
     * getWssFunc
     *******************************************************************************************************/
    /**
     *
     * @return wssFunc TODO_javadoc.
     *
     */
    public WssFunc getWssFunc() {
        return wssFunc;
    }

    /*******************************************************************************************************
     * getWssAfun
     *******************************************************************************************************/
    /**
     *
     * @return wssAfun TODO_javadoc.
     *
     */
    public WssAfun getWssAfun() {
        return wssAfun;
    }

    /*******************************************************************************************************
     * getWssOpci
     *******************************************************************************************************/
    /**
     *
     * @return wssOpci TODO_javadoc.
     *
     */
    public WssOpci getWssOpci() {
        return wssOpci;
    }

    /*******************************************************************************************************
     * getWssCmnd
     *******************************************************************************************************/
    /**
     *
     * @return wssCmnd TODO_javadoc.
     *
     */
    public WssCmnd getWssCmnd() {
        return wssCmnd;
    }

    /*******************************************************************************************************
     * getWssMaut
     *******************************************************************************************************/
    /**
     *
     * @return wssMaut TODO_javadoc.
     *
     */
    public WssMaut getWssMaut() {
        return wssMaut;
    }

    /*******************************************************************************************************
     * getWssMautRed
     *******************************************************************************************************/
    /**
     *
     * @return wssMautRed TODO_javadoc.
     *
     */
    public WssMautRed getWssMautRed() {
        return wssMautRed;
    }

    /*******************************************************************************************************
     * getWssStdo
     *******************************************************************************************************/
    /**
     *
     * @return wssStdo TODO_javadoc.
     *
     */
    public int getWssStdo() {
        return Integer.parseInt(subValue(318, 320));
    }

    /*******************************************************************************************************
     * getWssIsis
     *******************************************************************************************************/
    /**
     *
     * @return wssIsis TODO_javadoc.
     *
     */
    public int getWssIsis() {
        return Integer.parseInt(subValue(320, 322));
    }

    /*******************************************************************************************************
     * getWssIopc
     *******************************************************************************************************/
    /**
     *
     * @return wssIopc TODO_javadoc.
     *
     */
    public int getWssIopc() {
        return Integer.parseInt(subValue(322, 324));
    }

    /*******************************************************************************************************
     * getWssIcmd
     *******************************************************************************************************/
    /**
     *
     * @return wssIcmd TODO_javadoc.
     *
     */
    public int getWssIcmd() {
        return Integer.parseInt(subValue(324, 326));
    }

    /*******************************************************************************************************
     * getWssImax
     *******************************************************************************************************/
    /**
     *
     * @return wssImax TODO_javadoc.
     *
     */
    public int getWssImax() {
        return Integer.parseInt(subValue(326, 328));
    }

    /*******************************************************************************************************
     * getWssIval
     *******************************************************************************************************/
    /**
     *
     * @return wssIval TODO_javadoc.
     *
     */
    public int getWssIval() {
        return Integer.parseInt(subValue(328, 330));
    }

    /*******************************************************************************************************
     * getWssSind
     *******************************************************************************************************/
    /**
     *
     * @return wssSind TODO_javadoc.
     *
     */
    public WssSind getWssSind() {
        return wssSind;
    }

    /*******************************************************************************************************
     * getWssAuxi
     *******************************************************************************************************/
    /**
     *
     * @return wssAuxi TODO_javadoc.
     *
     */
    public String getWssAuxi() {
        return subValue(340, 343);
    }

    /*******************************************************************************************************
     * getUypPrta
     *******************************************************************************************************/
    /**
     *
     * @return uypPrta TODO_javadoc.
     *
     */
    public UypPrta getUypPrta() {
        return uypPrta;
    }

    /*******************************************************************************************************
     * getWssMens
     *******************************************************************************************************/
    /**
     *
     * @return wssMens TODO_javadoc.
     *
     */
    public WssMens getWssMens() {
        return wssMens;
    }

    /*******************************************************************************************************
     * getWssCodMens
     *******************************************************************************************************/
    /**
     *
     * @return wssCodMens TODO_javadoc.
     *
     */
    public WssCodMens getWssCodMens() {
        return wssCodMens;
    }

    /*******************************************************************************************************
     * getWssIcmn
     *******************************************************************************************************/
    /**
     *
     * @return wssIcmn TODO_javadoc.
     *
     */
    public String getWssIcmn() {
        return subValue(486, 487);
    }

    /*******************************************************************************************************
     * getWssIndCmnd
     *******************************************************************************************************/
    /**
     *
     * @return wssIndCmnd TODO_javadoc.
     *
     */
    public int getWssIndCmnd() {
        return Integer.parseInt(subValue(487, 488));
    }

    /*******************************************************************************************************
     * getWssAuxCmnp
     *******************************************************************************************************/
    /**
     *
     * @return wssAuxCmnp TODO_javadoc.
     *
     */
    public String getWssAuxCmnp() {
        return subValue(488, 496);
    }

    /*******************************************************************************************************
     * getWssAuxPrmc
     *******************************************************************************************************/
    /**
     *
     * @return wssAuxPrmc TODO_javadoc.
     *
     */
    public String getWssAuxPrmc() {
        return subValue(496, 521);
    }

    /*******************************************************************************************************
     * getWssAuxCmnd
     *******************************************************************************************************/
    /**
     *
     * @return wssAuxCmnd TODO_javadoc.
     *
     */
    public String getWssAuxCmnd() {
        return subValue(521, 524);
    }

    /*******************************************************************************************************
     * getWssAuxCrpf
     *******************************************************************************************************/
    /**
     *
     * @return wssAuxCrpf TODO_javadoc.
     *
     */
    public WssAuxCrpf getWssAuxCrpf() {
        return wssAuxCrpf;
    }

    /*******************************************************************************************************
     * getWssIprv
     *******************************************************************************************************/
    /**
     *
     * @return wssIprv TODO_javadoc.
     *
     */
    public String getWssIprv() {
        return subValue(1214, 1215);
    }

    /*******************************************************************************************************
     * getWssKnmo
     *******************************************************************************************************/
    /**
     *
     * @return wssKnmo TODO_javadoc.
     *
     */
    public WssKnmo getWssKnmo() {
        return wssKnmo;
    }

    /*******************************************************************************************************
     * setWssCcodApct
     *******************************************************************************************************/
    /**
     *
     * @param wssCcodApct TODO_javadoc.
     *
     */
    public void setWssCcodApct(boolean wssCcodApct) {

        if (!wssCcodApct) {
            throw new RuntimeException("Se intento setear wssCcodApct con false.");
        }

        setWssCcod("APCT");
    }

    /*******************************************************************************************************
     * isWssCcodApct
     *******************************************************************************************************/
    /**
     *
     * @return wssCcodApct TODO_javadoc.
     *
     */
    public boolean isWssCcodApct() {
        return getWssCcod().equals("APCT");
    }

    /*******************************************************************************************************
     * setWssCcodAbm0
     *******************************************************************************************************/
    /**
     *
     * @param wssCcodAbm0 TODO_javadoc.
     *
     */
    public void setWssCcodAbm0(boolean wssCcodAbm0) {

        if (!wssCcodAbm0) {
            throw new RuntimeException("Se intento setear wssCcodAbm0 con false.");
        }

        setWssCcod("ABM0");
    }

    /*******************************************************************************************************
     * isWssCcodAbm0
     *******************************************************************************************************/
    /**
     *
     * @return wssCcodAbm0 TODO_javadoc.
     *
     */
    public boolean isWssCcodAbm0() {
        return getWssCcod().equals("ABM0");
    }

    /*******************************************************************************************************
     * setFuncionInvalida
     *******************************************************************************************************/
    /**
     *
     * @param funcionInvalida TODO_javadoc.
     *
     */
    public void setFuncionInvalida(boolean funcionInvalida) {

        if (!funcionInvalida) {
            throw new RuntimeException("Se intento setear funcionInvalida con false.");
        }

        setWssIval(0);
    }

    /*******************************************************************************************************
     * isFuncionInvalida
     *******************************************************************************************************/
    /**
     *
     * @return funcionInvalida TODO_javadoc.
     *
     */
    public boolean isFuncionInvalida() {
        return getWssIval() == 0;
    }

    /*******************************************************************************************************
     * setFuncionValida
     *******************************************************************************************************/
    /**
     *
     * @param funcionValida TODO_javadoc.
     *
     */
    public void setFuncionValida(boolean funcionValida) {

        if (!funcionValida) {
            throw new RuntimeException("Se intento setear funcionValida con false.");
        }

        setWssIval(1);
    }

    /*******************************************************************************************************
     * isFuncionValida
     *******************************************************************************************************/
    /**
     *
     * @return funcionValida TODO_javadoc.
     *
     */
    public boolean isFuncionValida() {
        return getWssIval() == 1;
    }

    /*******************************************************************************************************
     * setWssDesdeCmn
     *******************************************************************************************************/
    /**
     *
     * @param wssDesdeCmn TODO_javadoc.
     *
     */
    public void setWssDesdeCmn(boolean wssDesdeCmn) {

        if (!wssDesdeCmn) {
            throw new RuntimeException("Se intento setear wssDesdeCmn con false.");
        }

        setWssIcmn("K");
    }

    /*******************************************************************************************************
     * isWssDesdeCmn
     *******************************************************************************************************/
    /**
     *
     * @return wssDesdeCmn TODO_javadoc.
     *
     */
    public boolean isWssDesdeCmn() {
        return getWssIcmn().equals("K");
    }

    /*******************************************************************************************************
     * setWssExisteComando
     *******************************************************************************************************/
    /**
     *
     * @param wssExisteComando TODO_javadoc.
     *
     */
    public void setWssExisteComando(boolean wssExisteComando) {

        if (!wssExisteComando) {
            throw new RuntimeException("Se intento setear wssExisteComando con false.");
        }

        setWssIndCmnd(1);
    }

    /*******************************************************************************************************
     * isWssExisteComando
     *******************************************************************************************************/
    /**
     *
     * @return wssExisteComando TODO_javadoc.
     *
     */
    public boolean isWssExisteComando() {
        return getWssIndCmnd() == 1;
    }

    /*******************************************************************************************************
     * setWssComandoSinprv
     *******************************************************************************************************/
    /**
     *
     * @param wssComandoSinprv TODO_javadoc.
     *
     */
    public void setWssComandoSinprv(boolean wssComandoSinprv) {

        if (!wssComandoSinprv) {
            throw new RuntimeException("Se intento setear wssComandoSinprv con false.");
        }

        setWssIndCmnd(2);
    }

    /*******************************************************************************************************
     * isWssComandoSinprv
     *******************************************************************************************************/
    /**
     *
     * @return wssComandoSinprv TODO_javadoc.
     *
     */
    public boolean isWssComandoSinprv() {
        return getWssIndCmnd() == 2;
    }

    /*******************************************************************************************************
     * setWssIprvTodo
     *******************************************************************************************************/
    /**
     *
     * @param wssIprvTodo TODO_javadoc.
     *
     */
    public void setWssIprvTodo(boolean wssIprvTodo) {

        if (!wssIprvTodo) {
            throw new RuntimeException("Se intento setear wssIprvTodo con false.");
        }

        setWssIprv("*");
    }

    /*******************************************************************************************************
     * isWssIprvTodo
     *******************************************************************************************************/
    /**
     *
     * @return wssIprvTodo TODO_javadoc.
     *
     */
    public boolean isWssIprvTodo() {
        return getWssIprv().equals("*");
    }

    /*******************************************************************************************************
     * setWssIprvTodosMenus
     *******************************************************************************************************/
    /**
     *
     * @param wssIprvTodosMenus TODO_javadoc.
     *
     */
    public void setWssIprvTodosMenus(boolean wssIprvTodosMenus) {

        if (!wssIprvTodosMenus) {
            throw new RuntimeException("Se intento setear wssIprvTodosMenus con false.");
        }

            throw new RuntimeException("Se intento setear wssIprvTodosMenus (multivaluada).");    }

    /*******************************************************************************************************
     * isWssIprvTodosMenus
     *******************************************************************************************************/
    /**
     *
     * @return wssIprvTodosMenus TODO_javadoc.
     *
     */
    public boolean isWssIprvTodosMenus() {
        return Arrays.binarySearch(new Object[] {  }, getWssIprv()) >= 0;
    }

    /*******************************************************************************************************
     * setWssIprvTodosMan
     *******************************************************************************************************/
    /**
     *
     * @param wssIprvTodosMan TODO_javadoc.
     *
     */
    public void setWssIprvTodosMan(boolean wssIprvTodosMan) {

        if (!wssIprvTodosMan) {
            throw new RuntimeException("Se intento setear wssIprvTodosMan con false.");
        }

            throw new RuntimeException("Se intento setear wssIprvTodosMan (multivaluada).");    }

    /*******************************************************************************************************
     * isWssIprvTodosMan
     *******************************************************************************************************/
    /**
     *
     * @return wssIprvTodosMan TODO_javadoc.
     *
     */
    public boolean isWssIprvTodosMan() {
        return Arrays.binarySearch(new Object[] {  }, getWssIprv()) >= 0;
    }

    /*******************************************************************************************************
     * setWssIprvTodosCon
     *******************************************************************************************************/
    /**
     *
     * @param wssIprvTodosCon TODO_javadoc.
     *
     */
    public void setWssIprvTodosCon(boolean wssIprvTodosCon) {

        if (!wssIprvTodosCon) {
            throw new RuntimeException("Se intento setear wssIprvTodosCon con false.");
        }

            throw new RuntimeException("Se intento setear wssIprvTodosCon (multivaluada).");    }

    /*******************************************************************************************************
     * isWssIprvTodosCon
     *******************************************************************************************************/
    /**
     *
     * @return wssIprvTodosCon TODO_javadoc.
     *
     */
    public boolean isWssIprvTodosCon() {
        return Arrays.binarySearch(new Object[] {  }, getWssIprv()) >= 0;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class WssCodMsg0 {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssCodMsg0() {
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
            replaceValue(4, 16, value);
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
            return subValue(4, 4 + 12);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setWssCodMsg1
         *******************************************************************************************************/
        /**
         *
         * @param wssCodMsg1 TODO_javadoc.
         *
         */
        public void setWssCodMsg1(String wssCodMsg1) {
            replaceValue(4, 5, wssCodMsg1);
        }

        /*******************************************************************************************************
         * setWssCodMsg2
         *******************************************************************************************************/
        /**
         *
         * @param wssCodMsg2 TODO_javadoc.
         *
         */
        public void setWssCodMsg2(String wssCodMsg2) {
            replaceValue(5, 13, wssCodMsg2);
        }

        /*******************************************************************************************************
         * setWssCodMsg3
         *******************************************************************************************************/
        /**
         *
         * @param wssCodMsg3 TODO_javadoc.
         *
         */
        public void setWssCodMsg3(String wssCodMsg3) {
            replaceValue(13, 16, wssCodMsg3);
        }

        /*******************************************************************************************************
         * getWssCodMsg1
         *******************************************************************************************************/
        /**
         *
         * @return wssCodMsg1 TODO_javadoc.
         *
         */
        public String getWssCodMsg1() {
            return subValue(4, 5);
        }

        /*******************************************************************************************************
         * getWssCodMsg2
         *******************************************************************************************************/
        /**
         *
         * @return wssCodMsg2 TODO_javadoc.
         *
         */
        public String getWssCodMsg2() {
            return subValue(5, 13);
        }

        /*******************************************************************************************************
         * getWssCodMsg3
         *******************************************************************************************************/
        /**
         *
         * @return wssCodMsg3 TODO_javadoc.
         *
         */
        public String getWssCodMsg3() {
            return subValue(13, 16);
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
    public class WssAux1 {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssAux1() {
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
            replaceValue(16, 24, value);
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
            return subValue(16, 16 + 8);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setWssAux11
         *******************************************************************************************************/
        /**
         *
         * @param wssAux11 TODO_javadoc.
         *
         */
        public void setWssAux11(String wssAux11) {
            replaceValue(16, 18, wssAux11);
        }

        /*******************************************************************************************************
         * setWssAux12
         *******************************************************************************************************/
        /**
         *
         * @param wssAux12 TODO_javadoc.
         *
         */
        public void setWssAux12(String wssAux12) {
            replaceValue(18, 20, wssAux12);
        }

        /*******************************************************************************************************
         * setWssAux13
         *******************************************************************************************************/
        /**
         *
         * @param wssAux13 TODO_javadoc.
         *
         */
        public void setWssAux13(String wssAux13) {
            replaceValue(20, 22, wssAux13);
        }

        /*******************************************************************************************************
         * setWssAux14
         *******************************************************************************************************/
        /**
         *
         * @param wssAux14 TODO_javadoc.
         *
         */
        public void setWssAux14(String wssAux14) {
            replaceValue(22, 24, wssAux14);
        }

        /*******************************************************************************************************
         * getWssAux11
         *******************************************************************************************************/
        /**
         *
         * @return wssAux11 TODO_javadoc.
         *
         */
        public String getWssAux11() {
            return subValue(16, 18);
        }

        /*******************************************************************************************************
         * getWssAux12
         *******************************************************************************************************/
        /**
         *
         * @return wssAux12 TODO_javadoc.
         *
         */
        public String getWssAux12() {
            return subValue(18, 20);
        }

        /*******************************************************************************************************
         * getWssAux13
         *******************************************************************************************************/
        /**
         *
         * @return wssAux13 TODO_javadoc.
         *
         */
        public String getWssAux13() {
            return subValue(20, 22);
        }

        /*******************************************************************************************************
         * getWssAux14
         *******************************************************************************************************/
        /**
         *
         * @return wssAux14 TODO_javadoc.
         *
         */
        public String getWssAux14() {
            return subValue(22, 24);
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
    public class WssAux2 {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssAux2() {
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
            replaceValue(24, 32, value);
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
            return subValue(24, 24 + 8);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setWssAux21
         *******************************************************************************************************/
        /**
         *
         * @param wssAux21 TODO_javadoc.
         *
         */
        public void setWssAux21(String wssAux21) {
            replaceValue(24, 26, wssAux21);
        }

        /*******************************************************************************************************
         * setWssAux22
         *******************************************************************************************************/
        /**
         *
         * @param wssAux22 TODO_javadoc.
         *
         */
        public void setWssAux22(String wssAux22) {
            replaceValue(26, 28, wssAux22);
        }

        /*******************************************************************************************************
         * setWssAux23
         *******************************************************************************************************/
        /**
         *
         * @param wssAux23 TODO_javadoc.
         *
         */
        public void setWssAux23(String wssAux23) {
            replaceValue(28, 30, wssAux23);
        }

        /*******************************************************************************************************
         * setWssAux24
         *******************************************************************************************************/
        /**
         *
         * @param wssAux24 TODO_javadoc.
         *
         */
        public void setWssAux24(String wssAux24) {
            replaceValue(30, 32, wssAux24);
        }

        /*******************************************************************************************************
         * getWssAux21
         *******************************************************************************************************/
        /**
         *
         * @return wssAux21 TODO_javadoc.
         *
         */
        public String getWssAux21() {
            return subValue(24, 26);
        }

        /*******************************************************************************************************
         * getWssAux22
         *******************************************************************************************************/
        /**
         *
         * @return wssAux22 TODO_javadoc.
         *
         */
        public String getWssAux22() {
            return subValue(26, 28);
        }

        /*******************************************************************************************************
         * getWssAux23
         *******************************************************************************************************/
        /**
         *
         * @return wssAux23 TODO_javadoc.
         *
         */
        public String getWssAux23() {
            return subValue(28, 30);
        }

        /*******************************************************************************************************
         * getWssAux24
         *******************************************************************************************************/
        /**
         *
         * @return wssAux24 TODO_javadoc.
         *
         */
        public String getWssAux24() {
            return subValue(30, 32);
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
    public class WssQidd {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssQidd() {
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
            replaceValue(41, 49, value);
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
            return subValue(41, 41 + 8);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setWssNidd
         *******************************************************************************************************/
        /**
         *
         * @param wssNidd TODO_javadoc.
         *
         */
        public void setWssNidd(String wssNidd) {
            replaceValue(41, 45, wssNidd);
        }

        /*******************************************************************************************************
         * setWssTidd
         *******************************************************************************************************/
        /**
         *
         * @param wssTidd TODO_javadoc.
         *
         */
        public void setWssTidd(String wssTidd) {
            replaceValue(45, 49, wssTidd);
        }

        /*******************************************************************************************************
         * getWssNidd
         *******************************************************************************************************/
        /**
         *
         * @return wssNidd TODO_javadoc.
         *
         */
        public String getWssNidd() {
            return subValue(41, 45);
        }

        /*******************************************************************************************************
         * getWssTidd
         *******************************************************************************************************/
        /**
         *
         * @return wssTidd TODO_javadoc.
         *
         */
        public String getWssTidd() {
            return subValue(45, 49);
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
    public class WssDfld {

        /** TODO_javadoc. */
        private WssCaxc wssCaxc = new WssCaxc();

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssDfld() {
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
            replaceValue(54, 74, value);
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
            return subValue(54, 54 + 20);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setWssNtrn
         *******************************************************************************************************/
        /**
         *
         * @param wssNtrn TODO_javadoc.
         *
         */
        public void setWssNtrn(String wssNtrn) {
            replaceValue(54, 58, wssNtrn);
        }

        /*******************************************************************************************************
         * getWssNtrn
         *******************************************************************************************************/
        /**
         *
         * @return wssNtrn TODO_javadoc.
         *
         */
        public String getWssNtrn() {
            return subValue(54, 58);
        }

        /*******************************************************************************************************
         * getWssCaxc
         *******************************************************************************************************/
        /**
         *
         * @return wssCaxc TODO_javadoc.
         *
         */
        public WssCaxc getWssCaxc() {
            return wssCaxc;
        }

        /**
         *
         * TODO_javadoc.
         *
         * @author  BEE S.A.
         * @version 1.0
         *
         */
        public class WssCaxc {

            /** TODO_javadoc. */
            private WssSist wssSist = new WssSist();

            /*******************************************************************************************************
             *
             *******************************************************************************************************/
            /**
             *
             */
            public WssCaxc() {
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
                replaceValue(58, 74, value);
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
                return subValue(58, 58 + 16);
            }

            //
            //
            //

            /*******************************************************************************************************
             * setWssFill
             *******************************************************************************************************/
            /**
             *
             * @param wssFill TODO_javadoc.
             *
             */
            public void setWssFill(String wssFill) {
                replaceValue(61, 62, wssFill);
            }

            /*******************************************************************************************************
             * setWssSisg
             *******************************************************************************************************/
            /**
             *
             * @param wssSisg TODO_javadoc.
             *
             */
            public void setWssSisg(String wssSisg) {
                replaceValue(62, 65, wssSisg);
            }

            /*******************************************************************************************************
             * setWssDisp
             *******************************************************************************************************/
            /**
             *
             * @param wssDisp TODO_javadoc.
             *
             */
            public void setWssDisp(String wssDisp) {
                replaceValue(65, 74, wssDisp);
            }

            /*******************************************************************************************************
             * getWssSist
             *******************************************************************************************************/
            /**
             *
             * @return wssSist TODO_javadoc.
             *
             */
            public WssSist getWssSist() {
                return wssSist;
            }

            /*******************************************************************************************************
             * getWssFill
             *******************************************************************************************************/
            /**
             *
             * @return wssFill TODO_javadoc.
             *
             */
            public String getWssFill() {
                return subValue(61, 62);
            }

            /*******************************************************************************************************
             * getWssSisg
             *******************************************************************************************************/
            /**
             *
             * @return wssSisg TODO_javadoc.
             *
             */
            public String getWssSisg() {
                return subValue(62, 65);
            }

            /*******************************************************************************************************
             * getWssDisp
             *******************************************************************************************************/
            /**
             *
             * @return wssDisp TODO_javadoc.
             *
             */
            public String getWssDisp() {
                return subValue(65, 74);
            }

            /**
             *
             * TODO_javadoc.
             *
             * @author  BEE S.A.
             * @version 1.0
             *
             */
            public class WssSist {

                /*******************************************************************************************************
                 *
                 *******************************************************************************************************/
                /**
                 *
                 */
                public WssSist() {
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
                    replaceValue(58, 61, value);
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
                    return subValue(58, 58 + 3);
                }

                //
                //
                //

                /*******************************************************************************************************
                 * setWssCsis
                 *******************************************************************************************************/
                /**
                 *
                 * @param wssCsis TODO_javadoc.
                 *
                 */
                public void setWssCsis(String[] wssCsis) {

                    if (wssCsis == null || wssCsis.length != 3) {
                        throw new IllegalArgumentException("wssCsis[]: no debe ser nulo y largo debe ser 3");
                    }

                    for (int i = 0; i < 3; i++) {
                        replaceValue(58 + 1 * i, 58 + 1 * (i + 1), wssCsis[i]);
                    }
                }

                /*******************************************************************************************************
                 * setWssCsis
                 *******************************************************************************************************/
                /**
                 *
                 * @param i TODO_javadoc.
                 * @param wssCsis TODO_javadoc.
                 *
                 */
                public void setWssCsis(int i, String wssCsis) {

                    if (i < 0 || i >= 3) {
                        throw new ArrayIndexOutOfBoundsException("wssCsis[]: indice debe estar en rango [0..2]");
                    }

                    replaceValue(58 + 1 * i, 58 + 1 * (i + 1), wssCsis);
                }

                /*******************************************************************************************************
                 * getWssCsis
                 *******************************************************************************************************/
                /**
                 *
                 * @param i TODO_javadoc.
                 *
                 * @return wssCsis TODO_javadoc.
                 *
                 */
                public String getWssCsis(int i) {

                    if (i < 0 || i >= 3) {
                        throw new ArrayIndexOutOfBoundsException("wssCsis[]: indice debe estar en rango [0..2]");
                    }

                    return subValue(58 + 1 * i, 58 + 1 * (i + 1));
                }

                /*******************************************************************************************************
                 * getWssCsisSize
                 *******************************************************************************************************/
                /**
                 *
                 * @return TODO_javadoc.
                 *
                 */
                public final int getWssCsisSize() {
                    return 3;
                }

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
    public class WssFunc {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssFunc() {
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
            replaceValue(74, 85, value);
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
            return subValue(74, 74 + 11);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setWssFchr
         *******************************************************************************************************/
        /**
         *
         * @param wssFchr TODO_javadoc.
         *
         */
        public void setWssFchr(String[] wssFchr) {

            if (wssFchr == null || wssFchr.length != 11) {
                throw new IllegalArgumentException("wssFchr[]: no debe ser nulo y largo debe ser 11");
            }

            for (int i = 0; i < 11; i++) {
                replaceValue(74 + 1 * i, 74 + 1 * (i + 1), wssFchr[i]);
            }
        }

        /*******************************************************************************************************
         * setWssFchr
         *******************************************************************************************************/
        /**
         *
         * @param i TODO_javadoc.
         * @param wssFchr TODO_javadoc.
         *
         */
        public void setWssFchr(int i, String wssFchr) {

            if (i < 0 || i >= 11) {
                throw new ArrayIndexOutOfBoundsException("wssFchr[]: indice debe estar en rango [0..10]");
            }

            replaceValue(74 + 1 * i, 74 + 1 * (i + 1), wssFchr);
        }

        /*******************************************************************************************************
         * getWssFchr
         *******************************************************************************************************/
        /**
         *
         * @param i TODO_javadoc.
         *
         * @return wssFchr TODO_javadoc.
         *
         */
        public String getWssFchr(int i) {

            if (i < 0 || i >= 11) {
                throw new ArrayIndexOutOfBoundsException("wssFchr[]: indice debe estar en rango [0..10]");
            }

            return subValue(74 + 1 * i, 74 + 1 * (i + 1));
        }

        /*******************************************************************************************************
         * getWssFchrSize
         *******************************************************************************************************/
        /**
         *
         * @return TODO_javadoc.
         *
         */
        public final int getWssFchrSize() {
            return 11;
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
    public class WssAfun {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssAfun() {
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
            replaceValue(85, 96, value);
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
            return subValue(85, 85 + 11);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setWssAchr
         *******************************************************************************************************/
        /**
         *
         * @param wssAchr TODO_javadoc.
         *
         */
        public void setWssAchr(String[] wssAchr) {

            if (wssAchr == null || wssAchr.length != 11) {
                throw new IllegalArgumentException("wssAchr[]: no debe ser nulo y largo debe ser 11");
            }

            for (int i = 0; i < 11; i++) {
                replaceValue(85 + 1 * i, 85 + 1 * (i + 1), wssAchr[i]);
            }
        }

        /*******************************************************************************************************
         * setWssAchr
         *******************************************************************************************************/
        /**
         *
         * @param i TODO_javadoc.
         * @param wssAchr TODO_javadoc.
         *
         */
        public void setWssAchr(int i, String wssAchr) {

            if (i < 0 || i >= 11) {
                throw new ArrayIndexOutOfBoundsException("wssAchr[]: indice debe estar en rango [0..10]");
            }

            replaceValue(85 + 1 * i, 85 + 1 * (i + 1), wssAchr);
        }

        /*******************************************************************************************************
         * getWssAchr
         *******************************************************************************************************/
        /**
         *
         * @param i TODO_javadoc.
         *
         * @return wssAchr TODO_javadoc.
         *
         */
        public String getWssAchr(int i) {

            if (i < 0 || i >= 11) {
                throw new ArrayIndexOutOfBoundsException("wssAchr[]: indice debe estar en rango [0..10]");
            }

            return subValue(85 + 1 * i, 85 + 1 * (i + 1));
        }

        /*******************************************************************************************************
         * getWssAchrSize
         *******************************************************************************************************/
        /**
         *
         * @return TODO_javadoc.
         *
         */
        public final int getWssAchrSize() {
            return 11;
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
    public class WssOpci {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssOpci() {
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
            replaceValue(96, 99, value);
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
            return subValue(96, 96 + 3);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setWssCopc
         *******************************************************************************************************/
        /**
         *
         * @param wssCopc TODO_javadoc.
         *
         */
        public void setWssCopc(String[] wssCopc) {

            if (wssCopc == null || wssCopc.length != 3) {
                throw new IllegalArgumentException("wssCopc[]: no debe ser nulo y largo debe ser 3");
            }

            for (int i = 0; i < 3; i++) {
                replaceValue(96 + 1 * i, 96 + 1 * (i + 1), wssCopc[i]);
            }
        }

        /*******************************************************************************************************
         * setWssCopc
         *******************************************************************************************************/
        /**
         *
         * @param i TODO_javadoc.
         * @param wssCopc TODO_javadoc.
         *
         */
        public void setWssCopc(int i, String wssCopc) {

            if (i < 0 || i >= 3) {
                throw new ArrayIndexOutOfBoundsException("wssCopc[]: indice debe estar en rango [0..2]");
            }

            replaceValue(96 + 1 * i, 96 + 1 * (i + 1), wssCopc);
        }

        /*******************************************************************************************************
         * getWssCopc
         *******************************************************************************************************/
        /**
         *
         * @param i TODO_javadoc.
         *
         * @return wssCopc TODO_javadoc.
         *
         */
        public String getWssCopc(int i) {

            if (i < 0 || i >= 3) {
                throw new ArrayIndexOutOfBoundsException("wssCopc[]: indice debe estar en rango [0..2]");
            }

            return subValue(96 + 1 * i, 96 + 1 * (i + 1));
        }

        /*******************************************************************************************************
         * getWssCopcSize
         *******************************************************************************************************/
        /**
         *
         * @return TODO_javadoc.
         *
         */
        public final int getWssCopcSize() {
            return 3;
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
    public class WssCmnd {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssCmnd() {
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
            replaceValue(99, 102, value);
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
            return subValue(99, 99 + 3);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setWssCcmd
         *******************************************************************************************************/
        /**
         *
         * @param wssCcmd TODO_javadoc.
         *
         */
        public void setWssCcmd(String[] wssCcmd) {

            if (wssCcmd == null || wssCcmd.length != 3) {
                throw new IllegalArgumentException("wssCcmd[]: no debe ser nulo y largo debe ser 3");
            }

            for (int i = 0; i < 3; i++) {
                replaceValue(99 + 1 * i, 99 + 1 * (i + 1), wssCcmd[i]);
            }
        }

        /*******************************************************************************************************
         * setWssCcmd
         *******************************************************************************************************/
        /**
         *
         * @param i TODO_javadoc.
         * @param wssCcmd TODO_javadoc.
         *
         */
        public void setWssCcmd(int i, String wssCcmd) {

            if (i < 0 || i >= 3) {
                throw new ArrayIndexOutOfBoundsException("wssCcmd[]: indice debe estar en rango [0..2]");
            }

            replaceValue(99 + 1 * i, 99 + 1 * (i + 1), wssCcmd);
        }

        /*******************************************************************************************************
         * getWssCcmd
         *******************************************************************************************************/
        /**
         *
         * @param i TODO_javadoc.
         *
         * @return wssCcmd TODO_javadoc.
         *
         */
        public String getWssCcmd(int i) {

            if (i < 0 || i >= 3) {
                throw new ArrayIndexOutOfBoundsException("wssCcmd[]: indice debe estar en rango [0..2]");
            }

            return subValue(99 + 1 * i, 99 + 1 * (i + 1));
        }

        /*******************************************************************************************************
         * getWssCcmdSize
         *******************************************************************************************************/
        /**
         *
         * @return TODO_javadoc.
         *
         */
        public final int getWssCcmdSize() {
            return 3;
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
    public class WssMaut {

        /** TODO_javadoc. */
        private WssFila[] wssFila = new WssFila[12];

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssMaut() {

            for (int i = 0; i < 12; i++) {
                wssFila[i] = new WssFila(i);
            }
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
            replaceValue(102, 318, value);
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
            return subValue(102, 102 + 216);
        }

        //
        //
        //

        /*******************************************************************************************************
         * getWssFila
         *******************************************************************************************************/
        /**
         *
         * @param i TODO_javadoc.
         *
         * @return wssFila TODO_javadoc.
         *
         */
        public WssFila getWssFila(int i) {

            if (i < 0 || i >= 12) {
                throw new ArrayIndexOutOfBoundsException("wssFila[]: indice debe estar en rango [0..11]");
            }

            return wssFila[i];
        }

        /*******************************************************************************************************
         * getWssFilaSize
         *******************************************************************************************************/
        /**
         *
         * @return TODO_javadoc.
         *
         */
        public final int getWssFilaSize() {
            return 12;
        }

        /**
         *
         * TODO_javadoc.
         *
         * @author  BEE S.A.
         * @version 1.0
         *
         */
        public class WssFila {

            /** TODO_javadoc. */
            private final int length_wssfila = 18;

            /** TODO_javadoc. */
            private int idx_wssfila;

            /** TODO_javadoc. */
            private WssColu[] wssColu = new WssColu[9];

            /*******************************************************************************************************
             *
             *******************************************************************************************************/
            /**
             *
             * @param idx TODO_javadoc.
             *
             */
            public WssFila(int idx) {

                for (int i = 0; i < 9; i++) {
                    wssColu[i] = new WssColu(i);
                }

                this.idx_wssfila = idx;
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
                replaceValue(idx_wssfila * length_wssfila + 102, idx_wssfila * length_wssfila + 120, value);
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
                return subValue(idx_wssfila * length_wssfila + 102, (idx_wssfila + 1) * length_wssfila + 102);
            }

            //
            //
            //

            /*******************************************************************************************************
             * getWssColu
             *******************************************************************************************************/
            /**
             *
             * @param i TODO_javadoc.
             *
             * @return wssColu TODO_javadoc.
             *
             */
            public WssColu getWssColu(int i) {

                if (i < 0 || i >= 9) {
                    throw new ArrayIndexOutOfBoundsException("wssColu[]: indice debe estar en rango [0..8]");
                }

                return wssColu[i];
            }

            /*******************************************************************************************************
             * getWssColuSize
             *******************************************************************************************************/
            /**
             *
             * @return TODO_javadoc.
             *
             */
            public final int getWssColuSize() {
                return 9;
            }

            /**
             *
             * TODO_javadoc.
             *
             * @author  BEE S.A.
             * @version 1.0
             *
             */
            public class WssColu {

                /** TODO_javadoc. */
                private final int length_wsscolu = 2;

                /** TODO_javadoc. */
                private int idx_wsscolu;

                /*******************************************************************************************************
                 *
                 *******************************************************************************************************/
                /**
                 *
                 * @param idx TODO_javadoc.
                 *
                 */
                public WssColu(int idx) {

                    this.idx_wsscolu = idx;
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
                    replaceValue(idx_wssfila * length_wssfila + idx_wsscolu * length_wsscolu + 102, idx_wssfila * length_wssfila + idx_wsscolu * length_wsscolu + 104, value);
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
                    return subValue(idx_wssfila * length_wssfila + idx_wsscolu * length_wsscolu + 102, idx_wssfila * length_wssfila + (idx_wsscolu + 1) * length_wsscolu + 102);
                }

                //
                //
                //

                /*******************************************************************************************************
                 * setWssAuto
                 *******************************************************************************************************/
                /**
                 *
                 * @param wssAuto TODO_javadoc.
                 *
                 */
                public void setWssAuto(int wssAuto) {
                    replaceValue(idx_wssfila * length_wssfila + idx_wsscolu * length_wsscolu + 102, idx_wssfila * length_wssfila + idx_wsscolu * length_wsscolu + 104, form2z.format(wssAuto));
                }

                /*******************************************************************************************************
                 * getWssAuto
                 *******************************************************************************************************/
                /**
                 *
                 * @return wssAuto TODO_javadoc.
                 *
                 */
                public int getWssAuto() {
                    return Integer.parseInt(subValue(idx_wssfila * length_wssfila + idx_wsscolu * length_wsscolu + 102, idx_wssfila * length_wssfila + idx_wsscolu * length_wsscolu + 104));
                }

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
    public class WssMautRed {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssMautRed() {
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
            replaceValue(102, 4198, value);
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
            return subValue(102, 102 + 4096);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setWssItm1
         *******************************************************************************************************/
        /**
         *
         * @param wssItm1 TODO_javadoc.
         *
         */
        public void setWssItm1(String wssItm1) {
            replaceValue(102, 120, wssItm1);
        }

        /*******************************************************************************************************
         * setWssItm2
         *******************************************************************************************************/
        /**
         *
         * @param wssItm2 TODO_javadoc.
         *
         */
        public void setWssItm2(String wssItm2) {
            replaceValue(120, 138, wssItm2);
        }

        /*******************************************************************************************************
         * setWssItm3
         *******************************************************************************************************/
        /**
         *
         * @param wssItm3 TODO_javadoc.
         *
         */
        public void setWssItm3(String wssItm3) {
            replaceValue(138, 156, wssItm3);
        }

        /*******************************************************************************************************
         * setWssItm4
         *******************************************************************************************************/
        /**
         *
         * @param wssItm4 TODO_javadoc.
         *
         */
        public void setWssItm4(String wssItm4) {
            replaceValue(156, 174, wssItm4);
        }

        /*******************************************************************************************************
         * setWssItm5
         *******************************************************************************************************/
        /**
         *
         * @param wssItm5 TODO_javadoc.
         *
         */
        public void setWssItm5(String wssItm5) {
            replaceValue(174, 192, wssItm5);
        }

        /*******************************************************************************************************
         * setWssItm6
         *******************************************************************************************************/
        /**
         *
         * @param wssItm6 TODO_javadoc.
         *
         */
        public void setWssItm6(String wssItm6) {
            replaceValue(192, 210, wssItm6);
        }

        /*******************************************************************************************************
         * setWssItm7
         *******************************************************************************************************/
        /**
         *
         * @param wssItm7 TODO_javadoc.
         *
         */
        public void setWssItm7(String wssItm7) {
            replaceValue(210, 228, wssItm7);
        }

        /*******************************************************************************************************
         * setWssItm8
         *******************************************************************************************************/
        /**
         *
         * @param wssItm8 TODO_javadoc.
         *
         */
        public void setWssItm8(String wssItm8) {
            replaceValue(228, 246, wssItm8);
        }

        /*******************************************************************************************************
         * setWssItm9
         *******************************************************************************************************/
        /**
         *
         * @param wssItm9 TODO_javadoc.
         *
         */
        public void setWssItm9(String wssItm9) {
            replaceValue(246, 264, wssItm9);
        }

        /*******************************************************************************************************
         * setWssItma
         *******************************************************************************************************/
        /**
         *
         * @param wssItma TODO_javadoc.
         *
         */
        public void setWssItma(String wssItma) {
            replaceValue(264, 282, wssItma);
        }

        /*******************************************************************************************************
         * setWssItmb
         *******************************************************************************************************/
        /**
         *
         * @param wssItmb TODO_javadoc.
         *
         */
        public void setWssItmb(String wssItmb) {
            replaceValue(282, 300, wssItmb);
        }

        /*******************************************************************************************************
         * setWssItmc
         *******************************************************************************************************/
        /**
         *
         * @param wssItmc TODO_javadoc.
         *
         */
        public void setWssItmc(String wssItmc) {
            replaceValue(300, 318, wssItmc);
        }

        /*******************************************************************************************************
         * getWssItm1
         *******************************************************************************************************/
        /**
         *
         * @return wssItm1 TODO_javadoc.
         *
         */
        public String getWssItm1() {
            return subValue(102, 120);
        }

        /*******************************************************************************************************
         * getWssItm2
         *******************************************************************************************************/
        /**
         *
         * @return wssItm2 TODO_javadoc.
         *
         */
        public String getWssItm2() {
            return subValue(120, 138);
        }

        /*******************************************************************************************************
         * getWssItm3
         *******************************************************************************************************/
        /**
         *
         * @return wssItm3 TODO_javadoc.
         *
         */
        public String getWssItm3() {
            return subValue(138, 156);
        }

        /*******************************************************************************************************
         * getWssItm4
         *******************************************************************************************************/
        /**
         *
         * @return wssItm4 TODO_javadoc.
         *
         */
        public String getWssItm4() {
            return subValue(156, 174);
        }

        /*******************************************************************************************************
         * getWssItm5
         *******************************************************************************************************/
        /**
         *
         * @return wssItm5 TODO_javadoc.
         *
         */
        public String getWssItm5() {
            return subValue(174, 192);
        }

        /*******************************************************************************************************
         * getWssItm6
         *******************************************************************************************************/
        /**
         *
         * @return wssItm6 TODO_javadoc.
         *
         */
        public String getWssItm6() {
            return subValue(192, 210);
        }

        /*******************************************************************************************************
         * getWssItm7
         *******************************************************************************************************/
        /**
         *
         * @return wssItm7 TODO_javadoc.
         *
         */
        public String getWssItm7() {
            return subValue(210, 228);
        }

        /*******************************************************************************************************
         * getWssItm8
         *******************************************************************************************************/
        /**
         *
         * @return wssItm8 TODO_javadoc.
         *
         */
        public String getWssItm8() {
            return subValue(228, 246);
        }

        /*******************************************************************************************************
         * getWssItm9
         *******************************************************************************************************/
        /**
         *
         * @return wssItm9 TODO_javadoc.
         *
         */
        public String getWssItm9() {
            return subValue(246, 264);
        }

        /*******************************************************************************************************
         * getWssItma
         *******************************************************************************************************/
        /**
         *
         * @return wssItma TODO_javadoc.
         *
         */
        public String getWssItma() {
            return subValue(264, 282);
        }

        /*******************************************************************************************************
         * getWssItmb
         *******************************************************************************************************/
        /**
         *
         * @return wssItmb TODO_javadoc.
         *
         */
        public String getWssItmb() {
            return subValue(282, 300);
        }

        /*******************************************************************************************************
         * getWssItmc
         *******************************************************************************************************/
        /**
         *
         * @return wssItmc TODO_javadoc.
         *
         */
        public String getWssItmc() {
            return subValue(300, 318);
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
    public class WssSind {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssSind() {
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
            replaceValue(330, 340, value);
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
            return subValue(330, 330 + 10);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setWssI
         *******************************************************************************************************/
        /**
         *
         * @param wssI TODO_javadoc.
         *
         */
        public void setWssI(int wssI) {
            replaceValue(330, 332, form2z.format(wssI));
        }

        /*******************************************************************************************************
         * setWssJ
         *******************************************************************************************************/
        /**
         *
         * @param wssJ TODO_javadoc.
         *
         */
        public void setWssJ(int wssJ) {
            replaceValue(332, 334, form2z.format(wssJ));
        }

        /*******************************************************************************************************
         * setWssK
         *******************************************************************************************************/
        /**
         *
         * @param wssK TODO_javadoc.
         *
         */
        public void setWssK(int wssK) {
            replaceValue(334, 336, form2z.format(wssK));
        }

        /*******************************************************************************************************
         * setWssL
         *******************************************************************************************************/
        /**
         *
         * @param wssL TODO_javadoc.
         *
         */
        public void setWssL(int wssL) {
            replaceValue(336, 338, form2z.format(wssL));
        }

        /*******************************************************************************************************
         * setWssM
         *******************************************************************************************************/
        /**
         *
         * @param wssM TODO_javadoc.
         *
         */
        public void setWssM(int wssM) {
            replaceValue(338, 340, form2z.format(wssM));
        }

        /*******************************************************************************************************
         * getWssI
         *******************************************************************************************************/
        /**
         *
         * @return wssI TODO_javadoc.
         *
         */
        public int getWssI() {
            return Integer.parseInt(subValue(330, 332));
        }

        /*******************************************************************************************************
         * getWssJ
         *******************************************************************************************************/
        /**
         *
         * @return wssJ TODO_javadoc.
         *
         */
        public int getWssJ() {
            return Integer.parseInt(subValue(332, 334));
        }

        /*******************************************************************************************************
         * getWssK
         *******************************************************************************************************/
        /**
         *
         * @return wssK TODO_javadoc.
         *
         */
        public int getWssK() {
            return Integer.parseInt(subValue(334, 336));
        }

        /*******************************************************************************************************
         * getWssL
         *******************************************************************************************************/
        /**
         *
         * @return wssL TODO_javadoc.
         *
         */
        public int getWssL() {
            return Integer.parseInt(subValue(336, 338));
        }

        /*******************************************************************************************************
         * getWssM
         *******************************************************************************************************/
        /**
         *
         * @return wssM TODO_javadoc.
         *
         */
        public int getWssM() {
            return Integer.parseInt(subValue(338, 340));
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
    public class UypPrta {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public UypPrta() {
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
            replaceValue(343, 355, value);
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
            return subValue(343, 343 + 12);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setUypProg
         *******************************************************************************************************/
        /**
         *
         * @param uypProg TODO_javadoc.
         *
         */
        public void setUypProg(String uypProg) {
            replaceValue(343, 351, uypProg);
        }

        /*******************************************************************************************************
         * setFiller
         *******************************************************************************************************/
        /**
         *
         * @param filler TODO_javadoc.
         *
         */
        public void setFiller(String filler) {
            replaceValue(351, 352, filler);
        }

        /*******************************************************************************************************
         * setUypCmnd
         *******************************************************************************************************/
        /**
         *
         * @param uypCmnd TODO_javadoc.
         *
         */
        public void setUypCmnd(String uypCmnd) {
            replaceValue(352, 355, uypCmnd);
        }

        /*******************************************************************************************************
         * getUypProg
         *******************************************************************************************************/
        /**
         *
         * @return uypProg TODO_javadoc.
         *
         */
        public String getUypProg() {
            return subValue(343, 351);
        }

        /*******************************************************************************************************
         * getFiller
         *******************************************************************************************************/
        /**
         *
         * @return filler TODO_javadoc.
         *
         */
        public String getFiller() {
            return subValue(351, 352);
        }

        /*******************************************************************************************************
         * getUypCmnd
         *******************************************************************************************************/
        /**
         *
         * @return uypCmnd TODO_javadoc.
         *
         */
        public String getUypCmnd() {
            return subValue(352, 355);
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
    public class WssMens {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssMens() {
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
            replaceValue(355, 474, value);
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
            return subValue(355, 355 + 119);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setWssMen1
         *******************************************************************************************************/
        /**
         *
         * @param wssMen1 TODO_javadoc.
         *
         */
        public void setWssMen1(String wssMen1) {
            replaceValue(355, 395, wssMen1);
        }

        /*******************************************************************************************************
         * setWssMen2
         *******************************************************************************************************/
        /**
         *
         * @param wssMen2 TODO_javadoc.
         *
         */
        public void setWssMen2(String wssMen2) {
            replaceValue(395, 474, wssMen2);
        }

        /*******************************************************************************************************
         * getWssMen1
         *******************************************************************************************************/
        /**
         *
         * @return wssMen1 TODO_javadoc.
         *
         */
        public String getWssMen1() {
            return subValue(355, 395);
        }

        /*******************************************************************************************************
         * getWssMen2
         *******************************************************************************************************/
        /**
         *
         * @return wssMen2 TODO_javadoc.
         *
         */
        public String getWssMen2() {
            return subValue(395, 474);
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
    public class WssCodMens {

        /** TODO_javadoc. */
        private WssCodTmsg wssCodTmsg = new WssCodTmsg();

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssCodMens() {
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
            replaceValue(474, 486, value);
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
            return subValue(474, 474 + 12);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setWssCodCmsg
         *******************************************************************************************************/
        /**
         *
         * @param wssCodCmsg TODO_javadoc.
         *
         */
        public void setWssCodCmsg(String wssCodCmsg) {
            replaceValue(481, 486, wssCodCmsg);
        }

        /*******************************************************************************************************
         * getWssCodTmsg
         *******************************************************************************************************/
        /**
         *
         * @return wssCodTmsg TODO_javadoc.
         *
         */
        public WssCodTmsg getWssCodTmsg() {
            return wssCodTmsg;
        }

        /*******************************************************************************************************
         * getWssCodCmsg
         *******************************************************************************************************/
        /**
         *
         * @return wssCodCmsg TODO_javadoc.
         *
         */
        public String getWssCodCmsg() {
            return subValue(481, 486);
        }

        /**
         *
         * TODO_javadoc.
         *
         * @author  BEE S.A.
         * @version 1.0
         *
         */
        public class WssCodTmsg {

            /*******************************************************************************************************
             *
             *******************************************************************************************************/
            /**
             *
             */
            public WssCodTmsg() {
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
                replaceValue(474, 481, value);
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
                return subValue(474, 474 + 7);
            }

            //
            //
            //

            /*******************************************************************************************************
             * setWssCodTmn1
             *******************************************************************************************************/
            /**
             *
             * @param wssCodTmn1 TODO_javadoc.
             *
             */
            public void setWssCodTmn1(String wssCodTmn1) {
                replaceValue(474, 477, wssCodTmn1);
            }

            /*******************************************************************************************************
             * setWssCodTmn2
             *******************************************************************************************************/
            /**
             *
             * @param wssCodTmn2 TODO_javadoc.
             *
             */
            public void setWssCodTmn2(String wssCodTmn2) {
                replaceValue(477, 480, wssCodTmn2);
            }

            /*******************************************************************************************************
             * setWssCodTmn3
             *******************************************************************************************************/
            /**
             *
             * @param wssCodTmn3 TODO_javadoc.
             *
             */
            public void setWssCodTmn3(String wssCodTmn3) {
                replaceValue(480, 481, wssCodTmn3);
            }

            /*******************************************************************************************************
             * getWssCodTmn1
             *******************************************************************************************************/
            /**
             *
             * @return wssCodTmn1 TODO_javadoc.
             *
             */
            public String getWssCodTmn1() {
                return subValue(474, 477);
            }

            /*******************************************************************************************************
             * getWssCodTmn2
             *******************************************************************************************************/
            /**
             *
             * @return wssCodTmn2 TODO_javadoc.
             *
             */
            public String getWssCodTmn2() {
                return subValue(477, 480);
            }

            /*******************************************************************************************************
             * getWssCodTmn3
             *******************************************************************************************************/
            /**
             *
             * @return wssCodTmn3 TODO_javadoc.
             *
             */
            public String getWssCodTmn3() {
                return subValue(480, 481);
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
    public class WssAuxCrpf {

        /** TODO_javadoc. */
        private WssTabl[] wssTabl = new WssTabl[10];

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssAuxCrpf() {

            for (int i = 0; i < 10; i++) {
                wssTabl[i] = new WssTabl(i);
            }
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
            replaceValue(524, 1214, value);
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
            return subValue(524, 524 + 690);
        }

        //
        //
        //

        /*******************************************************************************************************
         * getWssTabl
         *******************************************************************************************************/
        /**
         *
         * @param i TODO_javadoc.
         *
         * @return wssTabl TODO_javadoc.
         *
         */
        public WssTabl getWssTabl(int i) {

            if (i < 0 || i >= 10) {
                throw new ArrayIndexOutOfBoundsException("wssTabl[]: indice debe estar en rango [0..9]");
            }

            return wssTabl[i];
        }

        /*******************************************************************************************************
         * getWssTablSize
         *******************************************************************************************************/
        /**
         *
         * @return TODO_javadoc.
         *
         */
        public final int getWssTablSize() {
            return 10;
        }

        /**
         *
         * TODO_javadoc.
         *
         * @author  BEE S.A.
         * @version 1.0
         *
         */
        public class WssTabl {

            /** TODO_javadoc. */
            private final int length_wsstabl = 69;

            /** TODO_javadoc. */
            private int idx_wsstabl;

            /*******************************************************************************************************
             *
             *******************************************************************************************************/
            /**
             *
             * @param idx TODO_javadoc.
             *
             */
            public WssTabl(int idx) {

                this.idx_wsstabl = idx;
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
                replaceValue(idx_wsstabl * length_wsstabl + 524, idx_wsstabl * length_wsstabl + 593, value);
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
                return subValue(idx_wsstabl * length_wsstabl + 524, (idx_wsstabl + 1) * length_wsstabl + 524);
            }

            //
            //
            //

            /*******************************************************************************************************
             * setWssCodCmnd
             *******************************************************************************************************/
            /**
             *
             * @param wssCodCmnd TODO_javadoc.
             *
             */
            public void setWssCodCmnd(String wssCodCmnd) {
                replaceValue(idx_wsstabl * length_wsstabl + 524, idx_wsstabl * length_wsstabl + 527, wssCodCmnd);
            }

            /*******************************************************************************************************
             * setWssCodCcpp
             *******************************************************************************************************/
            /**
             *
             * @param wssCodCcpp TODO_javadoc.
             *
             */
            public void setWssCodCcpp(String wssCodCcpp) {
                replaceValue(idx_wsstabl * length_wsstabl + 527, idx_wsstabl * length_wsstabl + 530, wssCodCcpp);
            }

            /*******************************************************************************************************
             * setWssIndStpp
             *******************************************************************************************************/
            /**
             *
             * @param wssIndStpp TODO_javadoc.
             *
             */
            public void setWssIndStpp(String wssIndStpp) {
                replaceValue(idx_wsstabl * length_wsstabl + 530, idx_wsstabl * length_wsstabl + 531, wssIndStpp);
            }

            /*******************************************************************************************************
             * setWssGlsPrmt
             *******************************************************************************************************/
            /**
             *
             * @param wssGlsPrmt TODO_javadoc.
             *
             */
            public void setWssGlsPrmt(String wssGlsPrmt) {
                replaceValue(idx_wsstabl * length_wsstabl + 531, idx_wsstabl * length_wsstabl + 556, wssGlsPrmt);
            }

            /*******************************************************************************************************
             * setWssGlsConf
             *******************************************************************************************************/
            /**
             *
             * @param wssGlsConf TODO_javadoc.
             *
             */
            public void setWssGlsConf(String wssGlsConf) {
                replaceValue(idx_wsstabl * length_wsstabl + 556, idx_wsstabl * length_wsstabl + 581, wssGlsConf);
            }

            /*******************************************************************************************************
             * setWssGlsUarc
             *******************************************************************************************************/
            /**
             *
             * @param wssGlsUarc TODO_javadoc.
             *
             */
            public void setWssGlsUarc(String wssGlsUarc) {
                replaceValue(idx_wsstabl * length_wsstabl + 581, idx_wsstabl * length_wsstabl + 593, wssGlsUarc);
            }

            /*******************************************************************************************************
             * getWssCodCmnd
             *******************************************************************************************************/
            /**
             *
             * @return wssCodCmnd TODO_javadoc.
             *
             */
            public String getWssCodCmnd() {
                return subValue(idx_wsstabl * length_wsstabl + 524, idx_wsstabl * length_wsstabl + 527);
            }

            /*******************************************************************************************************
             * getWssCodCcpp
             *******************************************************************************************************/
            /**
             *
             * @return wssCodCcpp TODO_javadoc.
             *
             */
            public String getWssCodCcpp() {
                return subValue(idx_wsstabl * length_wsstabl + 527, idx_wsstabl * length_wsstabl + 530);
            }

            /*******************************************************************************************************
             * getWssIndStpp
             *******************************************************************************************************/
            /**
             *
             * @return wssIndStpp TODO_javadoc.
             *
             */
            public String getWssIndStpp() {
                return subValue(idx_wsstabl * length_wsstabl + 530, idx_wsstabl * length_wsstabl + 531);
            }

            /*******************************************************************************************************
             * getWssGlsPrmt
             *******************************************************************************************************/
            /**
             *
             * @return wssGlsPrmt TODO_javadoc.
             *
             */
            public String getWssGlsPrmt() {
                return subValue(idx_wsstabl * length_wsstabl + 531, idx_wsstabl * length_wsstabl + 556);
            }

            /*******************************************************************************************************
             * getWssGlsConf
             *******************************************************************************************************/
            /**
             *
             * @return wssGlsConf TODO_javadoc.
             *
             */
            public String getWssGlsConf() {
                return subValue(idx_wsstabl * length_wsstabl + 556, idx_wsstabl * length_wsstabl + 581);
            }

            /*******************************************************************************************************
             * getWssGlsUarc
             *******************************************************************************************************/
            /**
             *
             * @return wssGlsUarc TODO_javadoc.
             *
             */
            public String getWssGlsUarc() {
                return subValue(idx_wsstabl * length_wsstabl + 581, idx_wsstabl * length_wsstabl + 593);
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
    public class WssKnmo {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public WssKnmo() {
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
            replaceValue(1215, 1244, value);
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
            return subValue(1215, 1215 + 29);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setWssKnmoSist
         *******************************************************************************************************/
        /**
         *
         * @param wssKnmoSist TODO_javadoc.
         *
         */
        public void setWssKnmoSist(String wssKnmoSist) {
            replaceValue(1215, 1218, wssKnmoSist);
        }

        /*******************************************************************************************************
         * setWssKnmoSisg
         *******************************************************************************************************/
        /**
         *
         * @param wssKnmoSisg TODO_javadoc.
         *
         */
        public void setWssKnmoSisg(String wssKnmoSisg) {
            replaceValue(1218, 1221, wssKnmoSisg);
        }

        /*******************************************************************************************************
         * setWssKnmoNemo
         *******************************************************************************************************/
        /**
         *
         * @param wssKnmoNemo TODO_javadoc.
         *
         */
        public void setWssKnmoNemo(String wssKnmoNemo) {
            replaceValue(1221, 1233, wssKnmoNemo);
        }

        /*******************************************************************************************************
         * setWssKnmoCmnd
         *******************************************************************************************************/
        /**
         *
         * @param wssKnmoCmnd TODO_javadoc.
         *
         */
        public void setWssKnmoCmnd(String wssKnmoCmnd) {
            replaceValue(1233, 1236, wssKnmoCmnd);
        }

        /*******************************************************************************************************
         * setWssKnmoProg
         *******************************************************************************************************/
        /**
         *
         * @param wssKnmoProg TODO_javadoc.
         *
         */
        public void setWssKnmoProg(String wssKnmoProg) {
            replaceValue(1236, 1244, wssKnmoProg);
        }

        /*******************************************************************************************************
         * getWssKnmoSist
         *******************************************************************************************************/
        /**
         *
         * @return wssKnmoSist TODO_javadoc.
         *
         */
        public String getWssKnmoSist() {
            return subValue(1215, 1218);
        }

        /*******************************************************************************************************
         * getWssKnmoSisg
         *******************************************************************************************************/
        /**
         *
         * @return wssKnmoSisg TODO_javadoc.
         *
         */
        public String getWssKnmoSisg() {
            return subValue(1218, 1221);
        }

        /*******************************************************************************************************
         * getWssKnmoNemo
         *******************************************************************************************************/
        /**
         *
         * @return wssKnmoNemo TODO_javadoc.
         *
         */
        public String getWssKnmoNemo() {
            return subValue(1221, 1233);
        }

        /*******************************************************************************************************
         * getWssKnmoCmnd
         *******************************************************************************************************/
        /**
         *
         * @return wssKnmoCmnd TODO_javadoc.
         *
         */
        public String getWssKnmoCmnd() {
            return subValue(1233, 1236);
        }

        /*******************************************************************************************************
         * getWssKnmoProg
         *******************************************************************************************************/
        /**
         *
         * @return wssKnmoProg TODO_javadoc.
         *
         */
        public String getWssKnmoProg() {
            return subValue(1236, 1244);
        }

    }

}

