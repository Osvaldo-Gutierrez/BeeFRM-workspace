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
public class QueTpsvcdefRec extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(QueTpsvcdefRec.class);

    /** TODO_javadoc. */
    private static DecimalFormat form9z = new DecimalFormat("000000000");

    /** TODO_javadoc. */
    private QueTpackFlag queTpackFlag = new QueTpackFlag();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public QueTpsvcdefRec() {

        initBuffer(262);

        replaceValue(0, 262, "00000000{00000000{00000000{00000000{00000000{00000000{00000000{00000000{00000000{00000000{00000000{00000000{00000000{00000000{00000000{                                                                                                                               "); // QUE-TPSVCDEF-REC
        replaceValue(135, 262, "ts                                                                                                                             "); // QUE-SERVICE-NAME
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
        replaceValue(0, 262, value);
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
        return subValue(0, 262);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setQueCommHandle
     *******************************************************************************************************/
    /**
     *
     * @param queCommHandle TODO_javadoc.
     *
     */
    public void setQueCommHandle(int queCommHandle) {
        replaceValue(0, 9, setCompNumber(queCommHandle, form9z));
    }

    /*******************************************************************************************************
     * setQueTpblockFlag
     *******************************************************************************************************/
    /**
     *
     * @param queTpblockFlag TODO_javadoc.
     *
     */
    public void setQueTpblockFlag(int queTpblockFlag) {
        replaceValue(9, 18, setCompNumber(queTpblockFlag, form9z));
    }

    /*******************************************************************************************************
     * setQueTptranFlag
     *******************************************************************************************************/
    /**
     *
     * @param queTptranFlag TODO_javadoc.
     *
     */
    public void setQueTptranFlag(int queTptranFlag) {
        replaceValue(18, 27, setCompNumber(queTptranFlag, form9z));
    }

    /*******************************************************************************************************
     * setQueTpreplyFlag
     *******************************************************************************************************/
    /**
     *
     * @param queTpreplyFlag TODO_javadoc.
     *
     */
    public void setQueTpreplyFlag(int queTpreplyFlag) {
        replaceValue(27, 36, setCompNumber(queTpreplyFlag, form9z));
    }

    /*******************************************************************************************************
     * setQueTptimeFlag
     *******************************************************************************************************/
    /**
     *
     * @param queTptimeFlag TODO_javadoc.
     *
     */
    public void setQueTptimeFlag(int queTptimeFlag) {
        replaceValue(36, 45, setCompNumber(queTptimeFlag, form9z));
    }

    /*******************************************************************************************************
     * setQueTpsigrstrtFlag
     *******************************************************************************************************/
    /**
     *
     * @param queTpsigrstrtFlag TODO_javadoc.
     *
     */
    public void setQueTpsigrstrtFlag(int queTpsigrstrtFlag) {
        replaceValue(45, 54, setCompNumber(queTpsigrstrtFlag, form9z));
    }

    /*******************************************************************************************************
     * setQueTpgetanyFlag
     *******************************************************************************************************/
    /**
     *
     * @param queTpgetanyFlag TODO_javadoc.
     *
     */
    public void setQueTpgetanyFlag(int queTpgetanyFlag) {
        replaceValue(54, 63, setCompNumber(queTpgetanyFlag, form9z));
    }

    /*******************************************************************************************************
     * setQueTpsendrecvFlag
     *******************************************************************************************************/
    /**
     *
     * @param queTpsendrecvFlag TODO_javadoc.
     *
     */
    public void setQueTpsendrecvFlag(int queTpsendrecvFlag) {
        replaceValue(63, 72, setCompNumber(queTpsendrecvFlag, form9z));
    }

    /*******************************************************************************************************
     * setQueTpnochangeFlag
     *******************************************************************************************************/
    /**
     *
     * @param queTpnochangeFlag TODO_javadoc.
     *
     */
    public void setQueTpnochangeFlag(int queTpnochangeFlag) {
        replaceValue(72, 81, setCompNumber(queTpnochangeFlag, form9z));
    }

    /*******************************************************************************************************
     * setQueTpservicetypeFlag
     *******************************************************************************************************/
    /**
     *
     * @param queTpservicetypeFlag TODO_javadoc.
     *
     */
    public void setQueTpservicetypeFlag(int queTpservicetypeFlag) {
        replaceValue(81, 90, setCompNumber(queTpservicetypeFlag, form9z));
    }

    /*******************************************************************************************************
     * setQueAppkey
     *******************************************************************************************************/
    /**
     *
     * @param queAppkey TODO_javadoc.
     *
     */
    public void setQueAppkey(int queAppkey) {
        replaceValue(90, 99, setCompNumber(queAppkey, form9z));
    }

    /*******************************************************************************************************
     * setQueClientid
     *******************************************************************************************************/
    /**
     *
     * @param queClientid TODO_javadoc.
     *
     */
    public void setQueClientid(int[] queClientid) {

        if (queClientid == null || queClientid.length != 4) {
            throw new IllegalArgumentException("queClientid[]: no debe ser nulo y largo debe ser 4");
        }

        for (int i = 0; i < 4; i++) {
            replaceValue(99 + 9 * i, 99 + 9 * (i + 1), setCompNumber(queClientid[i], form9z));
        }
    }

    /*******************************************************************************************************
     * setQueClientid
     *******************************************************************************************************/
    /**
     *
     * @param i TODO_javadoc.
     * @param queClientid TODO_javadoc.
     *
     */
    public void setQueClientid(int i, int queClientid) {

        if (i < 0 || i >= 4) {
            throw new ArrayIndexOutOfBoundsException("queClientid[]: indice debe estar en rango [0..3]");
        }

        replaceValue(99 + 9 * i, 99 + 9 * (i + 1), setCompNumber(queClientid, form9z));
    }

    /*******************************************************************************************************
     * setQueServiceName
     *******************************************************************************************************/
    /**
     *
     * @param queServiceName TODO_javadoc.
     *
     */
    public void setQueServiceName(String queServiceName) {
        replaceValue(135, 262, queServiceName);
    }

    /*******************************************************************************************************
     * getQueCommHandle
     *******************************************************************************************************/
    /**
     *
     * @return queCommHandle TODO_javadoc.
     *
     */
    public int getQueCommHandle() {
        return (int) getCompNumber(subValue(0, 9));
    }

    /*******************************************************************************************************
     * getQueTpblockFlag
     *******************************************************************************************************/
    /**
     *
     * @return queTpblockFlag TODO_javadoc.
     *
     */
    public int getQueTpblockFlag() {
        return (int) getCompNumber(subValue(9, 18));
    }

    /*******************************************************************************************************
     * getQueTptranFlag
     *******************************************************************************************************/
    /**
     *
     * @return queTptranFlag TODO_javadoc.
     *
     */
    public int getQueTptranFlag() {
        return (int) getCompNumber(subValue(18, 27));
    }

    /*******************************************************************************************************
     * getQueTpreplyFlag
     *******************************************************************************************************/
    /**
     *
     * @return queTpreplyFlag TODO_javadoc.
     *
     */
    public int getQueTpreplyFlag() {
        return (int) getCompNumber(subValue(27, 36));
    }

    /*******************************************************************************************************
     * getQueTpackFlag
     *******************************************************************************************************/
    /**
     *
     * @return queTpackFlag TODO_javadoc.
     *
     */
    public QueTpackFlag getQueTpackFlag() {
        return queTpackFlag;
    }

    /*******************************************************************************************************
     * getQueTptimeFlag
     *******************************************************************************************************/
    /**
     *
     * @return queTptimeFlag TODO_javadoc.
     *
     */
    public int getQueTptimeFlag() {
        return (int) getCompNumber(subValue(36, 45));
    }

    /*******************************************************************************************************
     * getQueTpsigrstrtFlag
     *******************************************************************************************************/
    /**
     *
     * @return queTpsigrstrtFlag TODO_javadoc.
     *
     */
    public int getQueTpsigrstrtFlag() {
        return (int) getCompNumber(subValue(45, 54));
    }

    /*******************************************************************************************************
     * getQueTpgetanyFlag
     *******************************************************************************************************/
    /**
     *
     * @return queTpgetanyFlag TODO_javadoc.
     *
     */
    public int getQueTpgetanyFlag() {
        return (int) getCompNumber(subValue(54, 63));
    }

    /*******************************************************************************************************
     * getQueTpsendrecvFlag
     *******************************************************************************************************/
    /**
     *
     * @return queTpsendrecvFlag TODO_javadoc.
     *
     */
    public int getQueTpsendrecvFlag() {
        return (int) getCompNumber(subValue(63, 72));
    }

    /*******************************************************************************************************
     * getQueTpnochangeFlag
     *******************************************************************************************************/
    /**
     *
     * @return queTpnochangeFlag TODO_javadoc.
     *
     */
    public int getQueTpnochangeFlag() {
        return (int) getCompNumber(subValue(72, 81));
    }

    /*******************************************************************************************************
     * getQueTpservicetypeFlag
     *******************************************************************************************************/
    /**
     *
     * @return queTpservicetypeFlag TODO_javadoc.
     *
     */
    public int getQueTpservicetypeFlag() {
        return (int) getCompNumber(subValue(81, 90));
    }

    /*******************************************************************************************************
     * getQueAppkey
     *******************************************************************************************************/
    /**
     *
     * @return queAppkey TODO_javadoc.
     *
     */
    public int getQueAppkey() {
        return (int) getCompNumber(subValue(90, 99));
    }

    /*******************************************************************************************************
     * getQueClientid
     *******************************************************************************************************/
    /**
     *
     * @param i TODO_javadoc.
     *
     * @return queClientid TODO_javadoc.
     *
     */
    public int getQueClientid(int i) {

        if (i < 0 || i >= 4) {
            throw new ArrayIndexOutOfBoundsException("queClientid[]: indice debe estar en rango [0..3]");
        }

        return (int) getCompNumber(subValue(99 + 9 * i, 99 + 9 * (i + 1)));
    }

    /*******************************************************************************************************
     * getQueClientidSize
     *******************************************************************************************************/
    /**
     *
     * @return TODO_javadoc.
     *
     */
    public final int getQueClientidSize() {
        return 4;
    }

    /*******************************************************************************************************
     * getQueServiceName
     *******************************************************************************************************/
    /**
     *
     * @return queServiceName TODO_javadoc.
     *
     */
    public String getQueServiceName() {
        return subValue(135, 262);
    }

    /*******************************************************************************************************
     * setQueTpblock
     *******************************************************************************************************/
    /**
     *
     * @param queTpblock TODO_javadoc.
     *
     */
    public void setQueTpblock(boolean queTpblock) {

        if (!queTpblock) {
            throw new RuntimeException("Se intento setear queTpblock con false.");
        }

        setQueTpblockFlag(0);
    }

    /*******************************************************************************************************
     * isQueTpblock
     *******************************************************************************************************/
    /**
     *
     * @return queTpblock TODO_javadoc.
     *
     */
    public boolean isQueTpblock() {
        return getQueTpblockFlag() == 0;
    }

    /*******************************************************************************************************
     * setQueTpnoblock
     *******************************************************************************************************/
    /**
     *
     * @param queTpnoblock TODO_javadoc.
     *
     */
    public void setQueTpnoblock(boolean queTpnoblock) {

        if (!queTpnoblock) {
            throw new RuntimeException("Se intento setear queTpnoblock con false.");
        }

        setQueTpblockFlag(1);
    }

    /*******************************************************************************************************
     * isQueTpnoblock
     *******************************************************************************************************/
    /**
     *
     * @return queTpnoblock TODO_javadoc.
     *
     */
    public boolean isQueTpnoblock() {
        return getQueTpblockFlag() == 1;
    }

    /*******************************************************************************************************
     * setQueTptran
     *******************************************************************************************************/
    /**
     *
     * @param queTptran TODO_javadoc.
     *
     */
    public void setQueTptran(boolean queTptran) {

        if (!queTptran) {
            throw new RuntimeException("Se intento setear queTptran con false.");
        }

        setQueTptranFlag(0);
    }

    /*******************************************************************************************************
     * isQueTptran
     *******************************************************************************************************/
    /**
     *
     * @return queTptran TODO_javadoc.
     *
     */
    public boolean isQueTptran() {
        return getQueTptranFlag() == 0;
    }

    /*******************************************************************************************************
     * setQueTpnotran
     *******************************************************************************************************/
    /**
     *
     * @param queTpnotran TODO_javadoc.
     *
     */
    public void setQueTpnotran(boolean queTpnotran) {

        if (!queTpnotran) {
            throw new RuntimeException("Se intento setear queTpnotran con false.");
        }

        setQueTptranFlag(1);
    }

    /*******************************************************************************************************
     * isQueTpnotran
     *******************************************************************************************************/
    /**
     *
     * @return queTpnotran TODO_javadoc.
     *
     */
    public boolean isQueTpnotran() {
        return getQueTptranFlag() == 1;
    }

    /*******************************************************************************************************
     * setQueTpreply
     *******************************************************************************************************/
    /**
     *
     * @param queTpreply TODO_javadoc.
     *
     */
    public void setQueTpreply(boolean queTpreply) {

        if (!queTpreply) {
            throw new RuntimeException("Se intento setear queTpreply con false.");
        }

        setQueTpreplyFlag(0);
    }

    /*******************************************************************************************************
     * isQueTpreply
     *******************************************************************************************************/
    /**
     *
     * @return queTpreply TODO_javadoc.
     *
     */
    public boolean isQueTpreply() {
        return getQueTpreplyFlag() == 0;
    }

    /*******************************************************************************************************
     * setQueTpnoreply
     *******************************************************************************************************/
    /**
     *
     * @param queTpnoreply TODO_javadoc.
     *
     */
    public void setQueTpnoreply(boolean queTpnoreply) {

        if (!queTpnoreply) {
            throw new RuntimeException("Se intento setear queTpnoreply con false.");
        }

        setQueTpreplyFlag(1);
    }

    /*******************************************************************************************************
     * isQueTpnoreply
     *******************************************************************************************************/
    /**
     *
     * @return queTpnoreply TODO_javadoc.
     *
     */
    public boolean isQueTpnoreply() {
        return getQueTpreplyFlag() == 1;
    }

    /*******************************************************************************************************
     * setQueTptime
     *******************************************************************************************************/
    /**
     *
     * @param queTptime TODO_javadoc.
     *
     */
    public void setQueTptime(boolean queTptime) {

        if (!queTptime) {
            throw new RuntimeException("Se intento setear queTptime con false.");
        }

        setQueTptimeFlag(0);
    }

    /*******************************************************************************************************
     * isQueTptime
     *******************************************************************************************************/
    /**
     *
     * @return queTptime TODO_javadoc.
     *
     */
    public boolean isQueTptime() {
        return getQueTptimeFlag() == 0;
    }

    /*******************************************************************************************************
     * setQueTpnotime
     *******************************************************************************************************/
    /**
     *
     * @param queTpnotime TODO_javadoc.
     *
     */
    public void setQueTpnotime(boolean queTpnotime) {

        if (!queTpnotime) {
            throw new RuntimeException("Se intento setear queTpnotime con false.");
        }

        setQueTptimeFlag(1);
    }

    /*******************************************************************************************************
     * isQueTpnotime
     *******************************************************************************************************/
    /**
     *
     * @return queTpnotime TODO_javadoc.
     *
     */
    public boolean isQueTpnotime() {
        return getQueTptimeFlag() == 1;
    }

    /*******************************************************************************************************
     * setQueTpnosigrstrt
     *******************************************************************************************************/
    /**
     *
     * @param queTpnosigrstrt TODO_javadoc.
     *
     */
    public void setQueTpnosigrstrt(boolean queTpnosigrstrt) {

        if (!queTpnosigrstrt) {
            throw new RuntimeException("Se intento setear queTpnosigrstrt con false.");
        }

        setQueTpsigrstrtFlag(0);
    }

    /*******************************************************************************************************
     * isQueTpnosigrstrt
     *******************************************************************************************************/
    /**
     *
     * @return queTpnosigrstrt TODO_javadoc.
     *
     */
    public boolean isQueTpnosigrstrt() {
        return getQueTpsigrstrtFlag() == 0;
    }

    /*******************************************************************************************************
     * setQueTpsigrstrt
     *******************************************************************************************************/
    /**
     *
     * @param queTpsigrstrt TODO_javadoc.
     *
     */
    public void setQueTpsigrstrt(boolean queTpsigrstrt) {

        if (!queTpsigrstrt) {
            throw new RuntimeException("Se intento setear queTpsigrstrt con false.");
        }

        setQueTpsigrstrtFlag(1);
    }

    /*******************************************************************************************************
     * isQueTpsigrstrt
     *******************************************************************************************************/
    /**
     *
     * @return queTpsigrstrt TODO_javadoc.
     *
     */
    public boolean isQueTpsigrstrt() {
        return getQueTpsigrstrtFlag() == 1;
    }

    /*******************************************************************************************************
     * setQueTpgethandle
     *******************************************************************************************************/
    /**
     *
     * @param queTpgethandle TODO_javadoc.
     *
     */
    public void setQueTpgethandle(boolean queTpgethandle) {

        if (!queTpgethandle) {
            throw new RuntimeException("Se intento setear queTpgethandle con false.");
        }

        setQueTpgetanyFlag(0);
    }

    /*******************************************************************************************************
     * isQueTpgethandle
     *******************************************************************************************************/
    /**
     *
     * @return queTpgethandle TODO_javadoc.
     *
     */
    public boolean isQueTpgethandle() {
        return getQueTpgetanyFlag() == 0;
    }

    /*******************************************************************************************************
     * setQueTpgetany
     *******************************************************************************************************/
    /**
     *
     * @param queTpgetany TODO_javadoc.
     *
     */
    public void setQueTpgetany(boolean queTpgetany) {

        if (!queTpgetany) {
            throw new RuntimeException("Se intento setear queTpgetany con false.");
        }

        setQueTpgetanyFlag(1);
    }

    /*******************************************************************************************************
     * isQueTpgetany
     *******************************************************************************************************/
    /**
     *
     * @return queTpgetany TODO_javadoc.
     *
     */
    public boolean isQueTpgetany() {
        return getQueTpgetanyFlag() == 1;
    }

    /*******************************************************************************************************
     * setQueTpsendonly
     *******************************************************************************************************/
    /**
     *
     * @param queTpsendonly TODO_javadoc.
     *
     */
    public void setQueTpsendonly(boolean queTpsendonly) {

        if (!queTpsendonly) {
            throw new RuntimeException("Se intento setear queTpsendonly con false.");
        }

        setQueTpsendrecvFlag(0);
    }

    /*******************************************************************************************************
     * isQueTpsendonly
     *******************************************************************************************************/
    /**
     *
     * @return queTpsendonly TODO_javadoc.
     *
     */
    public boolean isQueTpsendonly() {
        return getQueTpsendrecvFlag() == 0;
    }

    /*******************************************************************************************************
     * setQueTprecvonly
     *******************************************************************************************************/
    /**
     *
     * @param queTprecvonly TODO_javadoc.
     *
     */
    public void setQueTprecvonly(boolean queTprecvonly) {

        if (!queTprecvonly) {
            throw new RuntimeException("Se intento setear queTprecvonly con false.");
        }

        setQueTpsendrecvFlag(1);
    }

    /*******************************************************************************************************
     * isQueTprecvonly
     *******************************************************************************************************/
    /**
     *
     * @return queTprecvonly TODO_javadoc.
     *
     */
    public boolean isQueTprecvonly() {
        return getQueTpsendrecvFlag() == 1;
    }

    /*******************************************************************************************************
     * setQueTpchange
     *******************************************************************************************************/
    /**
     *
     * @param queTpchange TODO_javadoc.
     *
     */
    public void setQueTpchange(boolean queTpchange) {

        if (!queTpchange) {
            throw new RuntimeException("Se intento setear queTpchange con false.");
        }

        setQueTpnochangeFlag(0);
    }

    /*******************************************************************************************************
     * isQueTpchange
     *******************************************************************************************************/
    /**
     *
     * @return queTpchange TODO_javadoc.
     *
     */
    public boolean isQueTpchange() {
        return getQueTpnochangeFlag() == 0;
    }

    /*******************************************************************************************************
     * setQueTpnochange
     *******************************************************************************************************/
    /**
     *
     * @param queTpnochange TODO_javadoc.
     *
     */
    public void setQueTpnochange(boolean queTpnochange) {

        if (!queTpnochange) {
            throw new RuntimeException("Se intento setear queTpnochange con false.");
        }

        setQueTpnochangeFlag(1);
    }

    /*******************************************************************************************************
     * isQueTpnochange
     *******************************************************************************************************/
    /**
     *
     * @return queTpnochange TODO_javadoc.
     *
     */
    public boolean isQueTpnochange() {
        return getQueTpnochangeFlag() == 1;
    }

    /*******************************************************************************************************
     * setQueTpreqrsp
     *******************************************************************************************************/
    /**
     *
     * @param queTpreqrsp TODO_javadoc.
     *
     */
    public void setQueTpreqrsp(boolean queTpreqrsp) {

        if (!queTpreqrsp) {
            throw new RuntimeException("Se intento setear queTpreqrsp con false.");
        }

        setQueTpservicetypeFlag(0);
    }

    /*******************************************************************************************************
     * isQueTpreqrsp
     *******************************************************************************************************/
    /**
     *
     * @return queTpreqrsp TODO_javadoc.
     *
     */
    public boolean isQueTpreqrsp() {
        return getQueTpservicetypeFlag() == 0;
    }

    /*******************************************************************************************************
     * setQueTpconv
     *******************************************************************************************************/
    /**
     *
     * @param queTpconv TODO_javadoc.
     *
     */
    public void setQueTpconv(boolean queTpconv) {

        if (!queTpconv) {
            throw new RuntimeException("Se intento setear queTpconv con false.");
        }

        setQueTpservicetypeFlag(1);
    }

    /*******************************************************************************************************
     * isQueTpconv
     *******************************************************************************************************/
    /**
     *
     * @return queTpconv TODO_javadoc.
     *
     */
    public boolean isQueTpconv() {
        return getQueTpservicetypeFlag() == 1;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class QueTpackFlag {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public QueTpackFlag() {
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
            replaceValue(27, 4123, value);
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
            return subValue(27, 27 + 4096);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setFiller
         *******************************************************************************************************/
        /**
         *
         * @param filler TODO_javadoc.
         *
         */
        public void setFiller(int filler) {
            replaceValue(27, 36, setCompNumber(filler, form9z));
        }

        /*******************************************************************************************************
         * getFiller
         *******************************************************************************************************/
        /**
         *
         * @return filler TODO_javadoc.
         *
         */
        public int getFiller() {
            return (int) getCompNumber(subValue(27, 36));
        }

        /*******************************************************************************************************
         * setQueTpnoack
         *******************************************************************************************************/
        /**
         *
         * @param queTpnoack TODO_javadoc.
         *
         */
        public void setQueTpnoack(boolean queTpnoack) {

            if (!queTpnoack) {
                throw new RuntimeException("Se intento setear queTpnoack con false.");
            }

            setFiller(0);
        }

        /*******************************************************************************************************
         * isQueTpnoack
         *******************************************************************************************************/
        /**
         *
         * @return queTpnoack TODO_javadoc.
         *
         */
        public boolean isQueTpnoack() {
            return getFiller() == 0;
        }

        /*******************************************************************************************************
         * setQueTpack
         *******************************************************************************************************/
        /**
         *
         * @param queTpack TODO_javadoc.
         *
         */
        public void setQueTpack(boolean queTpack) {

            if (!queTpack) {
                throw new RuntimeException("Se intento setear queTpack con false.");
            }

            setFiller(1);
        }

        /*******************************************************************************************************
         * isQueTpack
         *******************************************************************************************************/
        /**
         *
         * @return queTpack TODO_javadoc.
         *
         */
        public boolean isQueTpack() {
            return getFiller() == 1;
        }

    }

}

