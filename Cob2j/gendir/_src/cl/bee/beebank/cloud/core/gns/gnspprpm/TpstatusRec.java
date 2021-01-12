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
public class TpstatusRec extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(TpstatusRec.class);

    /** TODO_javadoc. */
    private static DecimalFormat form9z = new DecimalFormat("000000000");

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public TpstatusRec() {

        initBuffer(27);

        replaceValue(0, 27, "00000000{00000000{00000000{"); // TPSTATUS-REC
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
        replaceValue(0, 27, value);
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
        return subValue(0, 27);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setTpStatus
     *******************************************************************************************************/
    /**
     *
     * @param tpStatus TODO_javadoc.
     *
     */
    public void setTpStatus(int tpStatus) {
        replaceValue(0, 9, setCompNumber(tpStatus, form9z));
    }

    /*******************************************************************************************************
     * setTpevent
     *******************************************************************************************************/
    /**
     *
     * @param tpevent TODO_javadoc.
     *
     */
    public void setTpevent(int tpevent) {
        replaceValue(9, 18, setCompNumber(tpevent, form9z));
    }

    /*******************************************************************************************************
     * setApplReturnCode
     *******************************************************************************************************/
    /**
     *
     * @param applReturnCode TODO_javadoc.
     *
     */
    public void setApplReturnCode(int applReturnCode) {
        replaceValue(18, 27, setCompNumber(applReturnCode, form9z));
    }

    /*******************************************************************************************************
     * getTpStatus
     *******************************************************************************************************/
    /**
     *
     * @return tpStatus TODO_javadoc.
     *
     */
    public int getTpStatus() {
        return (int) getCompNumber(subValue(0, 9));
    }

    /*******************************************************************************************************
     * getTpevent
     *******************************************************************************************************/
    /**
     *
     * @return tpevent TODO_javadoc.
     *
     */
    public int getTpevent() {
        return (int) getCompNumber(subValue(9, 18));
    }

    /*******************************************************************************************************
     * getApplReturnCode
     *******************************************************************************************************/
    /**
     *
     * @return applReturnCode TODO_javadoc.
     *
     */
    public int getApplReturnCode() {
        return (int) getCompNumber(subValue(18, 27));
    }

    /*******************************************************************************************************
     * setTpok
     *******************************************************************************************************/
    /**
     *
     * @param tpok TODO_javadoc.
     *
     */
    public void setTpok(boolean tpok) {

        if (!tpok) {
            throw new RuntimeException("Se intento setear tpok con false.");
        }

        setTpStatus(0);
    }

    /*******************************************************************************************************
     * isTpok
     *******************************************************************************************************/
    /**
     *
     * @return tpok TODO_javadoc.
     *
     */
    public boolean isTpok() {
        return getTpStatus() == 0;
    }

    /*******************************************************************************************************
     * setTpeabort
     *******************************************************************************************************/
    /**
     *
     * @param tpeabort TODO_javadoc.
     *
     */
    public void setTpeabort(boolean tpeabort) {

        if (!tpeabort) {
            throw new RuntimeException("Se intento setear tpeabort con false.");
        }

        setTpStatus(1);
    }

    /*******************************************************************************************************
     * isTpeabort
     *******************************************************************************************************/
    /**
     *
     * @return tpeabort TODO_javadoc.
     *
     */
    public boolean isTpeabort() {
        return getTpStatus() == 1;
    }

    /*******************************************************************************************************
     * setTpebaddesc
     *******************************************************************************************************/
    /**
     *
     * @param tpebaddesc TODO_javadoc.
     *
     */
    public void setTpebaddesc(boolean tpebaddesc) {

        if (!tpebaddesc) {
            throw new RuntimeException("Se intento setear tpebaddesc con false.");
        }

        setTpStatus(2);
    }

    /*******************************************************************************************************
     * isTpebaddesc
     *******************************************************************************************************/
    /**
     *
     * @return tpebaddesc TODO_javadoc.
     *
     */
    public boolean isTpebaddesc() {
        return getTpStatus() == 2;
    }

    /*******************************************************************************************************
     * setTpeblock
     *******************************************************************************************************/
    /**
     *
     * @param tpeblock TODO_javadoc.
     *
     */
    public void setTpeblock(boolean tpeblock) {

        if (!tpeblock) {
            throw new RuntimeException("Se intento setear tpeblock con false.");
        }

        setTpStatus(3);
    }

    /*******************************************************************************************************
     * isTpeblock
     *******************************************************************************************************/
    /**
     *
     * @return tpeblock TODO_javadoc.
     *
     */
    public boolean isTpeblock() {
        return getTpStatus() == 3;
    }

    /*******************************************************************************************************
     * setTpeinval
     *******************************************************************************************************/
    /**
     *
     * @param tpeinval TODO_javadoc.
     *
     */
    public void setTpeinval(boolean tpeinval) {

        if (!tpeinval) {
            throw new RuntimeException("Se intento setear tpeinval con false.");
        }

        setTpStatus(4);
    }

    /*******************************************************************************************************
     * isTpeinval
     *******************************************************************************************************/
    /**
     *
     * @return tpeinval TODO_javadoc.
     *
     */
    public boolean isTpeinval() {
        return getTpStatus() == 4;
    }

    /*******************************************************************************************************
     * setTpelimit
     *******************************************************************************************************/
    /**
     *
     * @param tpelimit TODO_javadoc.
     *
     */
    public void setTpelimit(boolean tpelimit) {

        if (!tpelimit) {
            throw new RuntimeException("Se intento setear tpelimit con false.");
        }

        setTpStatus(5);
    }

    /*******************************************************************************************************
     * isTpelimit
     *******************************************************************************************************/
    /**
     *
     * @return tpelimit TODO_javadoc.
     *
     */
    public boolean isTpelimit() {
        return getTpStatus() == 5;
    }

    /*******************************************************************************************************
     * setTpenoent
     *******************************************************************************************************/
    /**
     *
     * @param tpenoent TODO_javadoc.
     *
     */
    public void setTpenoent(boolean tpenoent) {

        if (!tpenoent) {
            throw new RuntimeException("Se intento setear tpenoent con false.");
        }

        setTpStatus(6);
    }

    /*******************************************************************************************************
     * isTpenoent
     *******************************************************************************************************/
    /**
     *
     * @return tpenoent TODO_javadoc.
     *
     */
    public boolean isTpenoent() {
        return getTpStatus() == 6;
    }

    /*******************************************************************************************************
     * setTpeos
     *******************************************************************************************************/
    /**
     *
     * @param tpeos TODO_javadoc.
     *
     */
    public void setTpeos(boolean tpeos) {

        if (!tpeos) {
            throw new RuntimeException("Se intento setear tpeos con false.");
        }

        setTpStatus(7);
    }

    /*******************************************************************************************************
     * isTpeos
     *******************************************************************************************************/
    /**
     *
     * @return tpeos TODO_javadoc.
     *
     */
    public boolean isTpeos() {
        return getTpStatus() == 7;
    }

    /*******************************************************************************************************
     * setTpeperm
     *******************************************************************************************************/
    /**
     *
     * @param tpeperm TODO_javadoc.
     *
     */
    public void setTpeperm(boolean tpeperm) {

        if (!tpeperm) {
            throw new RuntimeException("Se intento setear tpeperm con false.");
        }

        setTpStatus(8);
    }

    /*******************************************************************************************************
     * isTpeperm
     *******************************************************************************************************/
    /**
     *
     * @return tpeperm TODO_javadoc.
     *
     */
    public boolean isTpeperm() {
        return getTpStatus() == 8;
    }

    /*******************************************************************************************************
     * setTpeproto
     *******************************************************************************************************/
    /**
     *
     * @param tpeproto TODO_javadoc.
     *
     */
    public void setTpeproto(boolean tpeproto) {

        if (!tpeproto) {
            throw new RuntimeException("Se intento setear tpeproto con false.");
        }

        setTpStatus(9);
    }

    /*******************************************************************************************************
     * isTpeproto
     *******************************************************************************************************/
    /**
     *
     * @return tpeproto TODO_javadoc.
     *
     */
    public boolean isTpeproto() {
        return getTpStatus() == 9;
    }

    /*******************************************************************************************************
     * setTpesvcerr
     *******************************************************************************************************/
    /**
     *
     * @param tpesvcerr TODO_javadoc.
     *
     */
    public void setTpesvcerr(boolean tpesvcerr) {

        if (!tpesvcerr) {
            throw new RuntimeException("Se intento setear tpesvcerr con false.");
        }

        setTpStatus(10);
    }

    /*******************************************************************************************************
     * isTpesvcerr
     *******************************************************************************************************/
    /**
     *
     * @return tpesvcerr TODO_javadoc.
     *
     */
    public boolean isTpesvcerr() {
        return getTpStatus() == 10;
    }

    /*******************************************************************************************************
     * setTpesvcfail
     *******************************************************************************************************/
    /**
     *
     * @param tpesvcfail TODO_javadoc.
     *
     */
    public void setTpesvcfail(boolean tpesvcfail) {

        if (!tpesvcfail) {
            throw new RuntimeException("Se intento setear tpesvcfail con false.");
        }

        setTpStatus(11);
    }

    /*******************************************************************************************************
     * isTpesvcfail
     *******************************************************************************************************/
    /**
     *
     * @return tpesvcfail TODO_javadoc.
     *
     */
    public boolean isTpesvcfail() {
        return getTpStatus() == 11;
    }

    /*******************************************************************************************************
     * setTpesystem
     *******************************************************************************************************/
    /**
     *
     * @param tpesystem TODO_javadoc.
     *
     */
    public void setTpesystem(boolean tpesystem) {

        if (!tpesystem) {
            throw new RuntimeException("Se intento setear tpesystem con false.");
        }

        setTpStatus(12);
    }

    /*******************************************************************************************************
     * isTpesystem
     *******************************************************************************************************/
    /**
     *
     * @return tpesystem TODO_javadoc.
     *
     */
    public boolean isTpesystem() {
        return getTpStatus() == 12;
    }

    /*******************************************************************************************************
     * setTpetime
     *******************************************************************************************************/
    /**
     *
     * @param tpetime TODO_javadoc.
     *
     */
    public void setTpetime(boolean tpetime) {

        if (!tpetime) {
            throw new RuntimeException("Se intento setear tpetime con false.");
        }

        setTpStatus(13);
    }

    /*******************************************************************************************************
     * isTpetime
     *******************************************************************************************************/
    /**
     *
     * @return tpetime TODO_javadoc.
     *
     */
    public boolean isTpetime() {
        return getTpStatus() == 13;
    }

    /*******************************************************************************************************
     * setTpetran
     *******************************************************************************************************/
    /**
     *
     * @param tpetran TODO_javadoc.
     *
     */
    public void setTpetran(boolean tpetran) {

        if (!tpetran) {
            throw new RuntimeException("Se intento setear tpetran con false.");
        }

        setTpStatus(14);
    }

    /*******************************************************************************************************
     * isTpetran
     *******************************************************************************************************/
    /**
     *
     * @return tpetran TODO_javadoc.
     *
     */
    public boolean isTpetran() {
        return getTpStatus() == 14;
    }

    /*******************************************************************************************************
     * setTpegotsig
     *******************************************************************************************************/
    /**
     *
     * @param tpegotsig TODO_javadoc.
     *
     */
    public void setTpegotsig(boolean tpegotsig) {

        if (!tpegotsig) {
            throw new RuntimeException("Se intento setear tpegotsig con false.");
        }

        setTpStatus(15);
    }

    /*******************************************************************************************************
     * isTpegotsig
     *******************************************************************************************************/
    /**
     *
     * @return tpegotsig TODO_javadoc.
     *
     */
    public boolean isTpegotsig() {
        return getTpStatus() == 15;
    }

    /*******************************************************************************************************
     * setTpermerr
     *******************************************************************************************************/
    /**
     *
     * @param tpermerr TODO_javadoc.
     *
     */
    public void setTpermerr(boolean tpermerr) {

        if (!tpermerr) {
            throw new RuntimeException("Se intento setear tpermerr con false.");
        }

        setTpStatus(16);
    }

    /*******************************************************************************************************
     * isTpermerr
     *******************************************************************************************************/
    /**
     *
     * @return tpermerr TODO_javadoc.
     *
     */
    public boolean isTpermerr() {
        return getTpStatus() == 16;
    }

    /*******************************************************************************************************
     * setTpeitype
     *******************************************************************************************************/
    /**
     *
     * @param tpeitype TODO_javadoc.
     *
     */
    public void setTpeitype(boolean tpeitype) {

        if (!tpeitype) {
            throw new RuntimeException("Se intento setear tpeitype con false.");
        }

        setTpStatus(17);
    }

    /*******************************************************************************************************
     * isTpeitype
     *******************************************************************************************************/
    /**
     *
     * @return tpeitype TODO_javadoc.
     *
     */
    public boolean isTpeitype() {
        return getTpStatus() == 17;
    }

    /*******************************************************************************************************
     * setTpeotype
     *******************************************************************************************************/
    /**
     *
     * @param tpeotype TODO_javadoc.
     *
     */
    public void setTpeotype(boolean tpeotype) {

        if (!tpeotype) {
            throw new RuntimeException("Se intento setear tpeotype con false.");
        }

        setTpStatus(18);
    }

    /*******************************************************************************************************
     * isTpeotype
     *******************************************************************************************************/
    /**
     *
     * @return tpeotype TODO_javadoc.
     *
     */
    public boolean isTpeotype() {
        return getTpStatus() == 18;
    }

    /*******************************************************************************************************
     * setTperelease
     *******************************************************************************************************/
    /**
     *
     * @param tperelease TODO_javadoc.
     *
     */
    public void setTperelease(boolean tperelease) {

        if (!tperelease) {
            throw new RuntimeException("Se intento setear tperelease con false.");
        }

        setTpStatus(19);
    }

    /*******************************************************************************************************
     * isTperelease
     *******************************************************************************************************/
    /**
     *
     * @return tperelease TODO_javadoc.
     *
     */
    public boolean isTperelease() {
        return getTpStatus() == 19;
    }

    /*******************************************************************************************************
     * setTpehazard
     *******************************************************************************************************/
    /**
     *
     * @param tpehazard TODO_javadoc.
     *
     */
    public void setTpehazard(boolean tpehazard) {

        if (!tpehazard) {
            throw new RuntimeException("Se intento setear tpehazard con false.");
        }

        setTpStatus(20);
    }

    /*******************************************************************************************************
     * isTpehazard
     *******************************************************************************************************/
    /**
     *
     * @return tpehazard TODO_javadoc.
     *
     */
    public boolean isTpehazard() {
        return getTpStatus() == 20;
    }

    /*******************************************************************************************************
     * setTpeheuristic
     *******************************************************************************************************/
    /**
     *
     * @param tpeheuristic TODO_javadoc.
     *
     */
    public void setTpeheuristic(boolean tpeheuristic) {

        if (!tpeheuristic) {
            throw new RuntimeException("Se intento setear tpeheuristic con false.");
        }

        setTpStatus(21);
    }

    /*******************************************************************************************************
     * isTpeheuristic
     *******************************************************************************************************/
    /**
     *
     * @return tpeheuristic TODO_javadoc.
     *
     */
    public boolean isTpeheuristic() {
        return getTpStatus() == 21;
    }

    /*******************************************************************************************************
     * setTpeevent
     *******************************************************************************************************/
    /**
     *
     * @param tpeevent TODO_javadoc.
     *
     */
    public void setTpeevent(boolean tpeevent) {

        if (!tpeevent) {
            throw new RuntimeException("Se intento setear tpeevent con false.");
        }

        setTpStatus(22);
    }

    /*******************************************************************************************************
     * isTpeevent
     *******************************************************************************************************/
    /**
     *
     * @return tpeevent TODO_javadoc.
     *
     */
    public boolean isTpeevent() {
        return getTpStatus() == 22;
    }

    /*******************************************************************************************************
     * setTpematch
     *******************************************************************************************************/
    /**
     *
     * @param tpematch TODO_javadoc.
     *
     */
    public void setTpematch(boolean tpematch) {

        if (!tpematch) {
            throw new RuntimeException("Se intento setear tpematch con false.");
        }

        setTpStatus(23);
    }

    /*******************************************************************************************************
     * isTpematch
     *******************************************************************************************************/
    /**
     *
     * @return tpematch TODO_javadoc.
     *
     */
    public boolean isTpematch() {
        return getTpStatus() == 23;
    }

    /*******************************************************************************************************
     * setTpediagnostic
     *******************************************************************************************************/
    /**
     *
     * @param tpediagnostic TODO_javadoc.
     *
     */
    public void setTpediagnostic(boolean tpediagnostic) {

        if (!tpediagnostic) {
            throw new RuntimeException("Se intento setear tpediagnostic con false.");
        }

        setTpStatus(24);
    }

    /*******************************************************************************************************
     * isTpediagnostic
     *******************************************************************************************************/
    /**
     *
     * @return tpediagnostic TODO_javadoc.
     *
     */
    public boolean isTpediagnostic() {
        return getTpStatus() == 24;
    }

    /*******************************************************************************************************
     * setTpemib
     *******************************************************************************************************/
    /**
     *
     * @param tpemib TODO_javadoc.
     *
     */
    public void setTpemib(boolean tpemib) {

        if (!tpemib) {
            throw new RuntimeException("Se intento setear tpemib con false.");
        }

        setTpStatus(25);
    }

    /*******************************************************************************************************
     * isTpemib
     *******************************************************************************************************/
    /**
     *
     * @return tpemib TODO_javadoc.
     *
     */
    public boolean isTpemib() {
        return getTpStatus() == 25;
    }

    /*******************************************************************************************************
     * setTpemaxval
     *******************************************************************************************************/
    /**
     *
     * @param tpemaxval TODO_javadoc.
     *
     */
    public void setTpemaxval(boolean tpemaxval) {

        if (!tpemaxval) {
            throw new RuntimeException("Se intento setear tpemaxval con false.");
        }

        setTpStatus(26);
    }

    /*******************************************************************************************************
     * isTpemaxval
     *******************************************************************************************************/
    /**
     *
     * @return tpemaxval TODO_javadoc.
     *
     */
    public boolean isTpemaxval() {
        return getTpStatus() == 26;
    }

    /*******************************************************************************************************
     * setTpevNoevent
     *******************************************************************************************************/
    /**
     *
     * @param tpevNoevent TODO_javadoc.
     *
     */
    public void setTpevNoevent(boolean tpevNoevent) {

        if (!tpevNoevent) {
            throw new RuntimeException("Se intento setear tpevNoevent con false.");
        }

        setTpevent(0);
    }

    /*******************************************************************************************************
     * isTpevNoevent
     *******************************************************************************************************/
    /**
     *
     * @return tpevNoevent TODO_javadoc.
     *
     */
    public boolean isTpevNoevent() {
        return getTpevent() == 0;
    }

    /*******************************************************************************************************
     * setTpevDisconimm
     *******************************************************************************************************/
    /**
     *
     * @param tpevDisconimm TODO_javadoc.
     *
     */
    public void setTpevDisconimm(boolean tpevDisconimm) {

        if (!tpevDisconimm) {
            throw new RuntimeException("Se intento setear tpevDisconimm con false.");
        }

        setTpevent(1);
    }

    /*******************************************************************************************************
     * isTpevDisconimm
     *******************************************************************************************************/
    /**
     *
     * @return tpevDisconimm TODO_javadoc.
     *
     */
    public boolean isTpevDisconimm() {
        return getTpevent() == 1;
    }

    /*******************************************************************************************************
     * setTpevSendonly
     *******************************************************************************************************/
    /**
     *
     * @param tpevSendonly TODO_javadoc.
     *
     */
    public void setTpevSendonly(boolean tpevSendonly) {

        if (!tpevSendonly) {
            throw new RuntimeException("Se intento setear tpevSendonly con false.");
        }

        setTpevent(2);
    }

    /*******************************************************************************************************
     * isTpevSendonly
     *******************************************************************************************************/
    /**
     *
     * @return tpevSendonly TODO_javadoc.
     *
     */
    public boolean isTpevSendonly() {
        return getTpevent() == 2;
    }

    /*******************************************************************************************************
     * setTpevSvcerr
     *******************************************************************************************************/
    /**
     *
     * @param tpevSvcerr TODO_javadoc.
     *
     */
    public void setTpevSvcerr(boolean tpevSvcerr) {

        if (!tpevSvcerr) {
            throw new RuntimeException("Se intento setear tpevSvcerr con false.");
        }

        setTpevent(3);
    }

    /*******************************************************************************************************
     * isTpevSvcerr
     *******************************************************************************************************/
    /**
     *
     * @return tpevSvcerr TODO_javadoc.
     *
     */
    public boolean isTpevSvcerr() {
        return getTpevent() == 3;
    }

    /*******************************************************************************************************
     * setTpevSvcfail
     *******************************************************************************************************/
    /**
     *
     * @param tpevSvcfail TODO_javadoc.
     *
     */
    public void setTpevSvcfail(boolean tpevSvcfail) {

        if (!tpevSvcfail) {
            throw new RuntimeException("Se intento setear tpevSvcfail con false.");
        }

        setTpevent(4);
    }

    /*******************************************************************************************************
     * isTpevSvcfail
     *******************************************************************************************************/
    /**
     *
     * @return tpevSvcfail TODO_javadoc.
     *
     */
    public boolean isTpevSvcfail() {
        return getTpevent() == 4;
    }

    /*******************************************************************************************************
     * setTpevSvcsucc
     *******************************************************************************************************/
    /**
     *
     * @param tpevSvcsucc TODO_javadoc.
     *
     */
    public void setTpevSvcsucc(boolean tpevSvcsucc) {

        if (!tpevSvcsucc) {
            throw new RuntimeException("Se intento setear tpevSvcsucc con false.");
        }

        setTpevent(5);
    }

    /*******************************************************************************************************
     * isTpevSvcsucc
     *******************************************************************************************************/
    /**
     *
     * @return tpevSvcsucc TODO_javadoc.
     *
     */
    public boolean isTpevSvcsucc() {
        return getTpevent() == 5;
    }

}

