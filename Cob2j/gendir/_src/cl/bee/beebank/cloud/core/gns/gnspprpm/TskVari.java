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
public class TskVari extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(TskVari.class);

    /** TODO_javadoc. */
    private static DecimalFormat form1z = new DecimalFormat("0");

    /** TODO_javadoc. */
    private static DecimalFormat form6z = new DecimalFormat("000000");

    /** TODO_javadoc. */
    private static DecimalFormat form7z = new DecimalFormat("0000000");

    /** TODO_javadoc. */
    private static DecimalFormat form10z = new DecimalFormat("0000000000");

    /** TODO_javadoc. */
    private TskTranid tskTranid = new TskTranid();

    /** TODO_javadoc. */
    private TskInfoTran tskInfoTran = new TskInfoTran();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public TskVari() {

        initBuffer(345);

        replaceValue(0, 345, " 000000000{000000000{000000000{000000000{000000000{000000000{00000000000000{                                                                                                                                                                                                                                                                0000000000000"); // TSK-VARI
        replaceValue(0, 1, "N"); // TSK-TERM-ORIGEN
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
        replaceValue(0, 345, value);
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
        return subValue(0, 345);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setTskTermOrigen
     *******************************************************************************************************/
    /**
     *
     * @param tskTermOrigen TODO_javadoc.
     *
     */
    public void setTskTermOrigen(String tskTermOrigen) {
        replaceValue(0, 1, tskTermOrigen);
    }

    /*******************************************************************************************************
     * setTskTranidAlf
     *******************************************************************************************************/
    /**
     *
     * @param tskTranidAlf TODO_javadoc.
     *
     */
    public void setTskTranidAlf(String tskTranidAlf) {
        replaceValue(1, 61, tskTranidAlf);
    }

    /*******************************************************************************************************
     * setTskTermNum
     *******************************************************************************************************/
    /**
     *
     * @param tskTermNum TODO_javadoc.
     *
     */
    public void setTskTermNum(int tskTermNum) {
        replaceValue(69, 76, setCompNumber(tskTermNum, form7z));
    }

    /*******************************************************************************************************
     * setTskTermAlf
     *******************************************************************************************************/
    /**
     *
     * @param tskTermAlf TODO_javadoc.
     *
     */
    public void setTskTermAlf(String tskTermAlf) {
        replaceValue(69, 73, tskTermAlf);
    }

    /*******************************************************************************************************
     * setTskTermTux
     *******************************************************************************************************/
    /**
     *
     * @param tskTermTux TODO_javadoc.
     *
     */
    public void setTskTermTux(String tskTermTux) {
        replaceValue(76, 332, tskTermTux);
    }

    /*******************************************************************************************************
     * setTskTermNumTux
     *******************************************************************************************************/
    /**
     *
     * @param tskTermNumTux TODO_javadoc.
     *
     */
    public void setTskTermNumTux(int tskTermNumTux) {
        replaceValue(332, 339, form7z.format(tskTermNumTux));
    }

    /*******************************************************************************************************
     * setTskTermNumTuxAlf
     *******************************************************************************************************/
    /**
     *
     * @param tskTermNumTuxAlf TODO_javadoc.
     *
     */
    public void setTskTermNumTuxAlf(String tskTermNumTuxAlf) {
        replaceValue(332, 339, tskTermNumTuxAlf);
    }

    /*******************************************************************************************************
     * setTskTermNumTux6
     *******************************************************************************************************/
    /**
     *
     * @param tskTermNumTux6 TODO_javadoc.
     *
     */
    public void setTskTermNumTux6(int tskTermNumTux6) {
        replaceValue(339, 345, form6z.format(tskTermNumTux6));
    }

    /*******************************************************************************************************
     * setTskTermNumTuxAlf6
     *******************************************************************************************************/
    /**
     *
     * @param tskTermNumTuxAlf6 TODO_javadoc.
     *
     */
    public void setTskTermNumTuxAlf6(String tskTermNumTuxAlf6) {
        replaceValue(339, 345, tskTermNumTuxAlf6);
    }

    /*******************************************************************************************************
     * getTskTermOrigen
     *******************************************************************************************************/
    /**
     *
     * @return tskTermOrigen TODO_javadoc.
     *
     */
    public String getTskTermOrigen() {
        return subValue(0, 1);
    }

    /*******************************************************************************************************
     * getTskTranid
     *******************************************************************************************************/
    /**
     *
     * @return tskTranid TODO_javadoc.
     *
     */
    public TskTranid getTskTranid() {
        return tskTranid;
    }

    /*******************************************************************************************************
     * getTskTranidAlf
     *******************************************************************************************************/
    /**
     *
     * @return tskTranidAlf TODO_javadoc.
     *
     */
    public String getTskTranidAlf() {
        return subValue(1, 61);
    }

    /*******************************************************************************************************
     * getTskInfoTran
     *******************************************************************************************************/
    /**
     *
     * @return tskInfoTran TODO_javadoc.
     *
     */
    public TskInfoTran getTskInfoTran() {
        return tskInfoTran;
    }

    /*******************************************************************************************************
     * getTskTermNum
     *******************************************************************************************************/
    /**
     *
     * @return tskTermNum TODO_javadoc.
     *
     */
    public int getTskTermNum() {
        return (int) getCompNumber(subValue(69, 76));
    }

    /*******************************************************************************************************
     * getTskTermAlf
     *******************************************************************************************************/
    /**
     *
     * @return tskTermAlf TODO_javadoc.
     *
     */
    public String getTskTermAlf() {
        return subValue(69, 73);
    }

    /*******************************************************************************************************
     * getTskTermTux
     *******************************************************************************************************/
    /**
     *
     * @return tskTermTux TODO_javadoc.
     *
     */
    public String getTskTermTux() {
        return subValue(76, 332);
    }

    /*******************************************************************************************************
     * getTskTermNumTux
     *******************************************************************************************************/
    /**
     *
     * @return tskTermNumTux TODO_javadoc.
     *
     */
    public int getTskTermNumTux() {
        return Integer.parseInt(subValue(332, 339));
    }

    /*******************************************************************************************************
     * getTskTermNumTuxAlf
     *******************************************************************************************************/
    /**
     *
     * @return tskTermNumTuxAlf TODO_javadoc.
     *
     */
    public String getTskTermNumTuxAlf() {
        return subValue(332, 339);
    }

    /*******************************************************************************************************
     * getTskTermNumTux6
     *******************************************************************************************************/
    /**
     *
     * @return tskTermNumTux6 TODO_javadoc.
     *
     */
    public int getTskTermNumTux6() {
        return Integer.parseInt(subValue(339, 345));
    }

    /*******************************************************************************************************
     * getTskTermNumTuxAlf6
     *******************************************************************************************************/
    /**
     *
     * @return tskTermNumTuxAlf6 TODO_javadoc.
     *
     */
    public String getTskTermNumTuxAlf6() {
        return subValue(339, 345);
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class TskTranid {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public TskTranid() {
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
            replaceValue(1, 61, value);
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
            return subValue(1, 1 + 60);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setTskTranid1
         *******************************************************************************************************/
        /**
         *
         * @param tskTranid1 TODO_javadoc.
         *
         */
        public void setTskTranid1(long tskTranid1) {
            replaceValue(1, 11, setCompNumber(tskTranid1, form10z));
        }

        /*******************************************************************************************************
         * setTskTranid2
         *******************************************************************************************************/
        /**
         *
         * @param tskTranid2 TODO_javadoc.
         *
         */
        public void setTskTranid2(long tskTranid2) {
            replaceValue(11, 21, setCompNumber(tskTranid2, form10z));
        }

        /*******************************************************************************************************
         * setTskTranid3
         *******************************************************************************************************/
        /**
         *
         * @param tskTranid3 TODO_javadoc.
         *
         */
        public void setTskTranid3(long tskTranid3) {
            replaceValue(21, 31, setCompNumber(tskTranid3, form10z));
        }

        /*******************************************************************************************************
         * setTskTranid4
         *******************************************************************************************************/
        /**
         *
         * @param tskTranid4 TODO_javadoc.
         *
         */
        public void setTskTranid4(long tskTranid4) {
            replaceValue(31, 41, setCompNumber(tskTranid4, form10z));
        }

        /*******************************************************************************************************
         * setTskTranid5
         *******************************************************************************************************/
        /**
         *
         * @param tskTranid5 TODO_javadoc.
         *
         */
        public void setTskTranid5(long tskTranid5) {
            replaceValue(41, 51, setCompNumber(tskTranid5, form10z));
        }

        /*******************************************************************************************************
         * setTskTranid6
         *******************************************************************************************************/
        /**
         *
         * @param tskTranid6 TODO_javadoc.
         *
         */
        public void setTskTranid6(long tskTranid6) {
            replaceValue(51, 61, setCompNumber(tskTranid6, form10z));
        }

        /*******************************************************************************************************
         * getTskTranid1
         *******************************************************************************************************/
        /**
         *
         * @return tskTranid1 TODO_javadoc.
         *
         */
        public long getTskTranid1() {
            return getCompNumber(subValue(1, 11));
        }

        /*******************************************************************************************************
         * getTskTranid2
         *******************************************************************************************************/
        /**
         *
         * @return tskTranid2 TODO_javadoc.
         *
         */
        public long getTskTranid2() {
            return getCompNumber(subValue(11, 21));
        }

        /*******************************************************************************************************
         * getTskTranid3
         *******************************************************************************************************/
        /**
         *
         * @return tskTranid3 TODO_javadoc.
         *
         */
        public long getTskTranid3() {
            return getCompNumber(subValue(21, 31));
        }

        /*******************************************************************************************************
         * getTskTranid4
         *******************************************************************************************************/
        /**
         *
         * @return tskTranid4 TODO_javadoc.
         *
         */
        public long getTskTranid4() {
            return getCompNumber(subValue(31, 41));
        }

        /*******************************************************************************************************
         * getTskTranid5
         *******************************************************************************************************/
        /**
         *
         * @return tskTranid5 TODO_javadoc.
         *
         */
        public long getTskTranid5() {
            return getCompNumber(subValue(41, 51));
        }

        /*******************************************************************************************************
         * getTskTranid6
         *******************************************************************************************************/
        /**
         *
         * @return tskTranid6 TODO_javadoc.
         *
         */
        public long getTskTranid6() {
            return getCompNumber(subValue(51, 61));
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
    public class TskInfoTran {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public TskInfoTran() {
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
            replaceValue(61, 69, value);
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
            return subValue(61, 61 + 8);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setTskInfoTranid
         *******************************************************************************************************/
        /**
         *
         * @param tskInfoTranid TODO_javadoc.
         *
         */
        public void setTskInfoTranid(int tskInfoTranid) {
            replaceValue(61, 68, form7z.format(tskInfoTranid));
        }

        /*******************************************************************************************************
         * setTskInfoTranidAlf
         *******************************************************************************************************/
        /**
         *
         * @param tskInfoTranidAlf TODO_javadoc.
         *
         */
        public void setTskInfoTranidAlf(String tskInfoTranidAlf) {
            replaceValue(61, 68, tskInfoTranidAlf);
        }

        /*******************************************************************************************************
         * setTskInfoCommit
         *******************************************************************************************************/
        /**
         *
         * @param tskInfoCommit TODO_javadoc.
         *
         */
        public void setTskInfoCommit(int tskInfoCommit) {
            replaceValue(68, 69, form1z.format(tskInfoCommit));
        }

        /*******************************************************************************************************
         * getTskInfoTranid
         *******************************************************************************************************/
        /**
         *
         * @return tskInfoTranid TODO_javadoc.
         *
         */
        public int getTskInfoTranid() {
            return Integer.parseInt(subValue(61, 68));
        }

        /*******************************************************************************************************
         * getTskInfoTranidAlf
         *******************************************************************************************************/
        /**
         *
         * @return tskInfoTranidAlf TODO_javadoc.
         *
         */
        public String getTskInfoTranidAlf() {
            return subValue(61, 68);
        }

        /*******************************************************************************************************
         * getTskInfoCommit
         *******************************************************************************************************/
        /**
         *
         * @return tskInfoCommit TODO_javadoc.
         *
         */
        public int getTskInfoCommit() {
            return Integer.parseInt(subValue(68, 69));
        }

    }

}

