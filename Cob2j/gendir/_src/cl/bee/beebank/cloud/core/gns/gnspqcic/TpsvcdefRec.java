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
public class TpsvcdefRec extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(TpsvcdefRec.class);

    /** TODO_javadoc. */
    private static DecimalFormat form9z = new DecimalFormat("000000000");

    /** TODO_javadoc. */
    private TpackFlag tpackFlag = new TpackFlag();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public TpsvcdefRec() {

        initBuffer(262);

        replaceValue(0, 262, "00000000{00000000{00000000{00000000{00000000{00000000{00000000{00000000{00000000{00000000{00000000{00000000{00000000{00000000{00000000{                                                                                                                               "); // TPSVCDEF-REC
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
     * setCommHandle
     *******************************************************************************************************/
    /**
     *
     * @param commHandle TODO_javadoc.
     *
     */
    public void setCommHandle(int commHandle) {
        replaceValue(0, 9, setCompNumber(commHandle, form9z));
    }

    /*******************************************************************************************************
     * setTpblockFlag
     *******************************************************************************************************/
    /**
     *
     * @param tpblockFlag TODO_javadoc.
     *
     */
    public void setTpblockFlag(int tpblockFlag) {
        replaceValue(9, 18, setCompNumber(tpblockFlag, form9z));
    }

    /*******************************************************************************************************
     * setTptranFlag
     *******************************************************************************************************/
    /**
     *
     * @param tptranFlag TODO_javadoc.
     *
     */
    public void setTptranFlag(int tptranFlag) {
        replaceValue(18, 27, setCompNumber(tptranFlag, form9z));
    }

    /*******************************************************************************************************
     * setTpreplyFlag
     *******************************************************************************************************/
    /**
     *
     * @param tpreplyFlag TODO_javadoc.
     *
     */
    public void setTpreplyFlag(int tpreplyFlag) {
        replaceValue(27, 36, setCompNumber(tpreplyFlag, form9z));
    }

    /*******************************************************************************************************
     * setTptimeFlag
     *******************************************************************************************************/
    /**
     *
     * @param tptimeFlag TODO_javadoc.
     *
     */
    public void setTptimeFlag(int tptimeFlag) {
        replaceValue(36, 45, setCompNumber(tptimeFlag, form9z));
    }

    /*******************************************************************************************************
     * setTpsigrstrtFlag
     *******************************************************************************************************/
    /**
     *
     * @param tpsigrstrtFlag TODO_javadoc.
     *
     */
    public void setTpsigrstrtFlag(int tpsigrstrtFlag) {
        replaceValue(45, 54, setCompNumber(tpsigrstrtFlag, form9z));
    }

    /*******************************************************************************************************
     * setTpgetanyFlag
     *******************************************************************************************************/
    /**
     *
     * @param tpgetanyFlag TODO_javadoc.
     *
     */
    public void setTpgetanyFlag(int tpgetanyFlag) {
        replaceValue(54, 63, setCompNumber(tpgetanyFlag, form9z));
    }

    /*******************************************************************************************************
     * setTpsendrecvFlag
     *******************************************************************************************************/
    /**
     *
     * @param tpsendrecvFlag TODO_javadoc.
     *
     */
    public void setTpsendrecvFlag(int tpsendrecvFlag) {
        replaceValue(63, 72, setCompNumber(tpsendrecvFlag, form9z));
    }

    /*******************************************************************************************************
     * setTpnochangeFlag
     *******************************************************************************************************/
    /**
     *
     * @param tpnochangeFlag TODO_javadoc.
     *
     */
    public void setTpnochangeFlag(int tpnochangeFlag) {
        replaceValue(72, 81, setCompNumber(tpnochangeFlag, form9z));
    }

    /*******************************************************************************************************
     * setTpservicetypeFlag
     *******************************************************************************************************/
    /**
     *
     * @param tpservicetypeFlag TODO_javadoc.
     *
     */
    public void setTpservicetypeFlag(int tpservicetypeFlag) {
        replaceValue(81, 90, setCompNumber(tpservicetypeFlag, form9z));
    }

    /*******************************************************************************************************
     * setAppkey
     *******************************************************************************************************/
    /**
     *
     * @param appkey TODO_javadoc.
     *
     */
    public void setAppkey(int appkey) {
        replaceValue(90, 99, setCompNumber(appkey, form9z));
    }

    /*******************************************************************************************************
     * setClientid
     *******************************************************************************************************/
    /**
     *
     * @param clientid TODO_javadoc.
     *
     */
    public void setClientid(int[] clientid) {

        if (clientid == null || clientid.length != 4) {
            throw new IllegalArgumentException("clientid[]: no debe ser nulo y largo debe ser 4");
        }

        for (int i = 0; i < 4; i++) {
            replaceValue(99 + 9 * i, 99 + 9 * (i + 1), setCompNumber(clientid[i], form9z));
        }
    }

    /*******************************************************************************************************
     * setClientid
     *******************************************************************************************************/
    /**
     *
     * @param i TODO_javadoc.
     * @param clientid TODO_javadoc.
     *
     */
    public void setClientid(int i, int clientid) {

        if (i < 0 || i >= 4) {
            throw new ArrayIndexOutOfBoundsException("clientid[]: indice debe estar en rango [0..3]");
        }

        replaceValue(99 + 9 * i, 99 + 9 * (i + 1), setCompNumber(clientid, form9z));
    }

    /*******************************************************************************************************
     * setServiceName
     *******************************************************************************************************/
    /**
     *
     * @param serviceName TODO_javadoc.
     *
     */
    public void setServiceName(String serviceName) {
        replaceValue(135, 262, serviceName);
    }

    /*******************************************************************************************************
     * getCommHandle
     *******************************************************************************************************/
    /**
     *
     * @return commHandle TODO_javadoc.
     *
     */
    public int getCommHandle() {
        return (int) getCompNumber(subValue(0, 9));
    }

    /*******************************************************************************************************
     * getTpblockFlag
     *******************************************************************************************************/
    /**
     *
     * @return tpblockFlag TODO_javadoc.
     *
     */
    public int getTpblockFlag() {
        return (int) getCompNumber(subValue(9, 18));
    }

    /*******************************************************************************************************
     * getTptranFlag
     *******************************************************************************************************/
    /**
     *
     * @return tptranFlag TODO_javadoc.
     *
     */
    public int getTptranFlag() {
        return (int) getCompNumber(subValue(18, 27));
    }

    /*******************************************************************************************************
     * getTpreplyFlag
     *******************************************************************************************************/
    /**
     *
     * @return tpreplyFlag TODO_javadoc.
     *
     */
    public int getTpreplyFlag() {
        return (int) getCompNumber(subValue(27, 36));
    }

    /*******************************************************************************************************
     * getTpackFlag
     *******************************************************************************************************/
    /**
     *
     * @return tpackFlag TODO_javadoc.
     *
     */
    public TpackFlag getTpackFlag() {
        return tpackFlag;
    }

    /*******************************************************************************************************
     * getTptimeFlag
     *******************************************************************************************************/
    /**
     *
     * @return tptimeFlag TODO_javadoc.
     *
     */
    public int getTptimeFlag() {
        return (int) getCompNumber(subValue(36, 45));
    }

    /*******************************************************************************************************
     * getTpsigrstrtFlag
     *******************************************************************************************************/
    /**
     *
     * @return tpsigrstrtFlag TODO_javadoc.
     *
     */
    public int getTpsigrstrtFlag() {
        return (int) getCompNumber(subValue(45, 54));
    }

    /*******************************************************************************************************
     * getTpgetanyFlag
     *******************************************************************************************************/
    /**
     *
     * @return tpgetanyFlag TODO_javadoc.
     *
     */
    public int getTpgetanyFlag() {
        return (int) getCompNumber(subValue(54, 63));
    }

    /*******************************************************************************************************
     * getTpsendrecvFlag
     *******************************************************************************************************/
    /**
     *
     * @return tpsendrecvFlag TODO_javadoc.
     *
     */
    public int getTpsendrecvFlag() {
        return (int) getCompNumber(subValue(63, 72));
    }

    /*******************************************************************************************************
     * getTpnochangeFlag
     *******************************************************************************************************/
    /**
     *
     * @return tpnochangeFlag TODO_javadoc.
     *
     */
    public int getTpnochangeFlag() {
        return (int) getCompNumber(subValue(72, 81));
    }

    /*******************************************************************************************************
     * getTpservicetypeFlag
     *******************************************************************************************************/
    /**
     *
     * @return tpservicetypeFlag TODO_javadoc.
     *
     */
    public int getTpservicetypeFlag() {
        return (int) getCompNumber(subValue(81, 90));
    }

    /*******************************************************************************************************
     * getAppkey
     *******************************************************************************************************/
    /**
     *
     * @return appkey TODO_javadoc.
     *
     */
    public int getAppkey() {
        return (int) getCompNumber(subValue(90, 99));
    }

    /*******************************************************************************************************
     * getClientid
     *******************************************************************************************************/
    /**
     *
     * @param i TODO_javadoc.
     *
     * @return clientid TODO_javadoc.
     *
     */
    public int getClientid(int i) {

        if (i < 0 || i >= 4) {
            throw new ArrayIndexOutOfBoundsException("clientid[]: indice debe estar en rango [0..3]");
        }

        return (int) getCompNumber(subValue(99 + 9 * i, 99 + 9 * (i + 1)));
    }

    /*******************************************************************************************************
     * getClientidSize
     *******************************************************************************************************/
    /**
     *
     * @return TODO_javadoc.
     *
     */
    public final int getClientidSize() {
        return 4;
    }

    /*******************************************************************************************************
     * getServiceName
     *******************************************************************************************************/
    /**
     *
     * @return serviceName TODO_javadoc.
     *
     */
    public String getServiceName() {
        return subValue(135, 262);
    }

    /*******************************************************************************************************
     * setTpblock
     *******************************************************************************************************/
    /**
     *
     * @param tpblock TODO_javadoc.
     *
     */
    public void setTpblock(boolean tpblock) {

        if (!tpblock) {
            throw new RuntimeException("Se intento setear tpblock con false.");
        }

        setTpblockFlag(0);
    }

    /*******************************************************************************************************
     * isTpblock
     *******************************************************************************************************/
    /**
     *
     * @return tpblock TODO_javadoc.
     *
     */
    public boolean isTpblock() {
        return getTpblockFlag() == 0;
    }

    /*******************************************************************************************************
     * setTpnoblock
     *******************************************************************************************************/
    /**
     *
     * @param tpnoblock TODO_javadoc.
     *
     */
    public void setTpnoblock(boolean tpnoblock) {

        if (!tpnoblock) {
            throw new RuntimeException("Se intento setear tpnoblock con false.");
        }

        setTpblockFlag(1);
    }

    /*******************************************************************************************************
     * isTpnoblock
     *******************************************************************************************************/
    /**
     *
     * @return tpnoblock TODO_javadoc.
     *
     */
    public boolean isTpnoblock() {
        return getTpblockFlag() == 1;
    }

    /*******************************************************************************************************
     * setTptran
     *******************************************************************************************************/
    /**
     *
     * @param tptran TODO_javadoc.
     *
     */
    public void setTptran(boolean tptran) {

        if (!tptran) {
            throw new RuntimeException("Se intento setear tptran con false.");
        }

        setTptranFlag(0);
    }

    /*******************************************************************************************************
     * isTptran
     *******************************************************************************************************/
    /**
     *
     * @return tptran TODO_javadoc.
     *
     */
    public boolean isTptran() {
        return getTptranFlag() == 0;
    }

    /*******************************************************************************************************
     * setTpnotran
     *******************************************************************************************************/
    /**
     *
     * @param tpnotran TODO_javadoc.
     *
     */
    public void setTpnotran(boolean tpnotran) {

        if (!tpnotran) {
            throw new RuntimeException("Se intento setear tpnotran con false.");
        }

        setTptranFlag(1);
    }

    /*******************************************************************************************************
     * isTpnotran
     *******************************************************************************************************/
    /**
     *
     * @return tpnotran TODO_javadoc.
     *
     */
    public boolean isTpnotran() {
        return getTptranFlag() == 1;
    }

    /*******************************************************************************************************
     * setTpreply
     *******************************************************************************************************/
    /**
     *
     * @param tpreply TODO_javadoc.
     *
     */
    public void setTpreply(boolean tpreply) {

        if (!tpreply) {
            throw new RuntimeException("Se intento setear tpreply con false.");
        }

        setTpreplyFlag(0);
    }

    /*******************************************************************************************************
     * isTpreply
     *******************************************************************************************************/
    /**
     *
     * @return tpreply TODO_javadoc.
     *
     */
    public boolean isTpreply() {
        return getTpreplyFlag() == 0;
    }

    /*******************************************************************************************************
     * setTpnoreply
     *******************************************************************************************************/
    /**
     *
     * @param tpnoreply TODO_javadoc.
     *
     */
    public void setTpnoreply(boolean tpnoreply) {

        if (!tpnoreply) {
            throw new RuntimeException("Se intento setear tpnoreply con false.");
        }

        setTpreplyFlag(1);
    }

    /*******************************************************************************************************
     * isTpnoreply
     *******************************************************************************************************/
    /**
     *
     * @return tpnoreply TODO_javadoc.
     *
     */
    public boolean isTpnoreply() {
        return getTpreplyFlag() == 1;
    }

    /*******************************************************************************************************
     * setTptime
     *******************************************************************************************************/
    /**
     *
     * @param tptime TODO_javadoc.
     *
     */
    public void setTptime(boolean tptime) {

        if (!tptime) {
            throw new RuntimeException("Se intento setear tptime con false.");
        }

        setTptimeFlag(0);
    }

    /*******************************************************************************************************
     * isTptime
     *******************************************************************************************************/
    /**
     *
     * @return tptime TODO_javadoc.
     *
     */
    public boolean isTptime() {
        return getTptimeFlag() == 0;
    }

    /*******************************************************************************************************
     * setTpnotime
     *******************************************************************************************************/
    /**
     *
     * @param tpnotime TODO_javadoc.
     *
     */
    public void setTpnotime(boolean tpnotime) {

        if (!tpnotime) {
            throw new RuntimeException("Se intento setear tpnotime con false.");
        }

        setTptimeFlag(1);
    }

    /*******************************************************************************************************
     * isTpnotime
     *******************************************************************************************************/
    /**
     *
     * @return tpnotime TODO_javadoc.
     *
     */
    public boolean isTpnotime() {
        return getTptimeFlag() == 1;
    }

    /*******************************************************************************************************
     * setTpnosigrstrt
     *******************************************************************************************************/
    /**
     *
     * @param tpnosigrstrt TODO_javadoc.
     *
     */
    public void setTpnosigrstrt(boolean tpnosigrstrt) {

        if (!tpnosigrstrt) {
            throw new RuntimeException("Se intento setear tpnosigrstrt con false.");
        }

        setTpsigrstrtFlag(0);
    }

    /*******************************************************************************************************
     * isTpnosigrstrt
     *******************************************************************************************************/
    /**
     *
     * @return tpnosigrstrt TODO_javadoc.
     *
     */
    public boolean isTpnosigrstrt() {
        return getTpsigrstrtFlag() == 0;
    }

    /*******************************************************************************************************
     * setTpsigrstrt
     *******************************************************************************************************/
    /**
     *
     * @param tpsigrstrt TODO_javadoc.
     *
     */
    public void setTpsigrstrt(boolean tpsigrstrt) {

        if (!tpsigrstrt) {
            throw new RuntimeException("Se intento setear tpsigrstrt con false.");
        }

        setTpsigrstrtFlag(1);
    }

    /*******************************************************************************************************
     * isTpsigrstrt
     *******************************************************************************************************/
    /**
     *
     * @return tpsigrstrt TODO_javadoc.
     *
     */
    public boolean isTpsigrstrt() {
        return getTpsigrstrtFlag() == 1;
    }

    /*******************************************************************************************************
     * setTpgethandle
     *******************************************************************************************************/
    /**
     *
     * @param tpgethandle TODO_javadoc.
     *
     */
    public void setTpgethandle(boolean tpgethandle) {

        if (!tpgethandle) {
            throw new RuntimeException("Se intento setear tpgethandle con false.");
        }

        setTpgetanyFlag(0);
    }

    /*******************************************************************************************************
     * isTpgethandle
     *******************************************************************************************************/
    /**
     *
     * @return tpgethandle TODO_javadoc.
     *
     */
    public boolean isTpgethandle() {
        return getTpgetanyFlag() == 0;
    }

    /*******************************************************************************************************
     * setTpgetany
     *******************************************************************************************************/
    /**
     *
     * @param tpgetany TODO_javadoc.
     *
     */
    public void setTpgetany(boolean tpgetany) {

        if (!tpgetany) {
            throw new RuntimeException("Se intento setear tpgetany con false.");
        }

        setTpgetanyFlag(1);
    }

    /*******************************************************************************************************
     * isTpgetany
     *******************************************************************************************************/
    /**
     *
     * @return tpgetany TODO_javadoc.
     *
     */
    public boolean isTpgetany() {
        return getTpgetanyFlag() == 1;
    }

    /*******************************************************************************************************
     * setTpsendonly
     *******************************************************************************************************/
    /**
     *
     * @param tpsendonly TODO_javadoc.
     *
     */
    public void setTpsendonly(boolean tpsendonly) {

        if (!tpsendonly) {
            throw new RuntimeException("Se intento setear tpsendonly con false.");
        }

        setTpsendrecvFlag(0);
    }

    /*******************************************************************************************************
     * isTpsendonly
     *******************************************************************************************************/
    /**
     *
     * @return tpsendonly TODO_javadoc.
     *
     */
    public boolean isTpsendonly() {
        return getTpsendrecvFlag() == 0;
    }

    /*******************************************************************************************************
     * setTprecvonly
     *******************************************************************************************************/
    /**
     *
     * @param tprecvonly TODO_javadoc.
     *
     */
    public void setTprecvonly(boolean tprecvonly) {

        if (!tprecvonly) {
            throw new RuntimeException("Se intento setear tprecvonly con false.");
        }

        setTpsendrecvFlag(1);
    }

    /*******************************************************************************************************
     * isTprecvonly
     *******************************************************************************************************/
    /**
     *
     * @return tprecvonly TODO_javadoc.
     *
     */
    public boolean isTprecvonly() {
        return getTpsendrecvFlag() == 1;
    }

    /*******************************************************************************************************
     * setTpchange
     *******************************************************************************************************/
    /**
     *
     * @param tpchange TODO_javadoc.
     *
     */
    public void setTpchange(boolean tpchange) {

        if (!tpchange) {
            throw new RuntimeException("Se intento setear tpchange con false.");
        }

        setTpnochangeFlag(0);
    }

    /*******************************************************************************************************
     * isTpchange
     *******************************************************************************************************/
    /**
     *
     * @return tpchange TODO_javadoc.
     *
     */
    public boolean isTpchange() {
        return getTpnochangeFlag() == 0;
    }

    /*******************************************************************************************************
     * setTpnochange
     *******************************************************************************************************/
    /**
     *
     * @param tpnochange TODO_javadoc.
     *
     */
    public void setTpnochange(boolean tpnochange) {

        if (!tpnochange) {
            throw new RuntimeException("Se intento setear tpnochange con false.");
        }

        setTpnochangeFlag(1);
    }

    /*******************************************************************************************************
     * isTpnochange
     *******************************************************************************************************/
    /**
     *
     * @return tpnochange TODO_javadoc.
     *
     */
    public boolean isTpnochange() {
        return getTpnochangeFlag() == 1;
    }

    /*******************************************************************************************************
     * setTpreqrsp
     *******************************************************************************************************/
    /**
     *
     * @param tpreqrsp TODO_javadoc.
     *
     */
    public void setTpreqrsp(boolean tpreqrsp) {

        if (!tpreqrsp) {
            throw new RuntimeException("Se intento setear tpreqrsp con false.");
        }

        setTpservicetypeFlag(0);
    }

    /*******************************************************************************************************
     * isTpreqrsp
     *******************************************************************************************************/
    /**
     *
     * @return tpreqrsp TODO_javadoc.
     *
     */
    public boolean isTpreqrsp() {
        return getTpservicetypeFlag() == 0;
    }

    /*******************************************************************************************************
     * setTpconv
     *******************************************************************************************************/
    /**
     *
     * @param tpconv TODO_javadoc.
     *
     */
    public void setTpconv(boolean tpconv) {

        if (!tpconv) {
            throw new RuntimeException("Se intento setear tpconv con false.");
        }

        setTpservicetypeFlag(1);
    }

    /*******************************************************************************************************
     * isTpconv
     *******************************************************************************************************/
    /**
     *
     * @return tpconv TODO_javadoc.
     *
     */
    public boolean isTpconv() {
        return getTpservicetypeFlag() == 1;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class TpackFlag {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public TpackFlag() {
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
         * setTpnoack
         *******************************************************************************************************/
        /**
         *
         * @param tpnoack TODO_javadoc.
         *
         */
        public void setTpnoack(boolean tpnoack) {

            if (!tpnoack) {
                throw new RuntimeException("Se intento setear tpnoack con false.");
            }

            setFiller(0);
        }

        /*******************************************************************************************************
         * isTpnoack
         *******************************************************************************************************/
        /**
         *
         * @return tpnoack TODO_javadoc.
         *
         */
        public boolean isTpnoack() {
            return getFiller() == 0;
        }

        /*******************************************************************************************************
         * setTpack
         *******************************************************************************************************/
        /**
         *
         * @param tpack TODO_javadoc.
         *
         */
        public void setTpack(boolean tpack) {

            if (!tpack) {
                throw new RuntimeException("Se intento setear tpack con false.");
            }

            setFiller(1);
        }

        /*******************************************************************************************************
         * isTpack
         *******************************************************************************************************/
        /**
         *
         * @return tpack TODO_javadoc.
         *
         */
        public boolean isTpack() {
            return getFiller() == 1;
        }

    }

}

