/*
 *   Copyright (c) 2021 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.beebank.cloud.core.gns.gnsppcpm;


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
public class SysCtts extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(SysCtts.class);

    /** TODO_javadoc. */
    private static DecimalFormat form1z = new DecimalFormat("0");

    /** TODO_javadoc. */
    private static DecimalFormat form3z = new DecimalFormat("000");

    /** TODO_javadoc. */
    private SysVacu sysVacu = new SysVacu();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public SysCtts() {

        initBuffer(42);

        replaceValue(0, 42, "000000000000000000000000000000000000000000"); // SYS-CTTS
        replaceValue(0, 1, form1z.format(1)); // SYS-GET-DATE
        replaceValue(1, 2, form1z.format(2)); // SYS-GET-TIME
        replaceValue(2, 3, form1z.format(3)); // SYS-RTRN
        replaceValue(3, 4, form1z.format(4)); // SYS-XCTL
        replaceValue(4, 5, form1z.format(5)); // SYS-LINK
        replaceValue(5, 6, form1z.format(6)); // SYS-ABOR
        replaceValue(6, 42, "000031060091121152182213244274305335"); // SYS-VACU
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
        replaceValue(0, 42, value);
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
        return subValue(0, 42);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setSysGetDate
     *******************************************************************************************************/
    /**
     *
     * @param sysGetDate TODO_javadoc.
     *
     */
    public void setSysGetDate(int sysGetDate) {
        replaceValue(0, 1, form1z.format(sysGetDate));
    }

    /*******************************************************************************************************
     * setSysGetTime
     *******************************************************************************************************/
    /**
     *
     * @param sysGetTime TODO_javadoc.
     *
     */
    public void setSysGetTime(int sysGetTime) {
        replaceValue(1, 2, form1z.format(sysGetTime));
    }

    /*******************************************************************************************************
     * setSysRtrn
     *******************************************************************************************************/
    /**
     *
     * @param sysRtrn TODO_javadoc.
     *
     */
    public void setSysRtrn(int sysRtrn) {
        replaceValue(2, 3, form1z.format(sysRtrn));
    }

    /*******************************************************************************************************
     * setSysXctl
     *******************************************************************************************************/
    /**
     *
     * @param sysXctl TODO_javadoc.
     *
     */
    public void setSysXctl(int sysXctl) {
        replaceValue(3, 4, form1z.format(sysXctl));
    }

    /*******************************************************************************************************
     * setSysLink
     *******************************************************************************************************/
    /**
     *
     * @param sysLink TODO_javadoc.
     *
     */
    public void setSysLink(int sysLink) {
        replaceValue(4, 5, form1z.format(sysLink));
    }

    /*******************************************************************************************************
     * setSysAbor
     *******************************************************************************************************/
    /**
     *
     * @param sysAbor TODO_javadoc.
     *
     */
    public void setSysAbor(int sysAbor) {
        replaceValue(5, 6, form1z.format(sysAbor));
    }

    /*******************************************************************************************************
     * getSysGetDate
     *******************************************************************************************************/
    /**
     *
     * @return sysGetDate TODO_javadoc.
     *
     */
    public int getSysGetDate() {
        return Integer.parseInt(subValue(0, 1));
    }

    /*******************************************************************************************************
     * getSysGetTime
     *******************************************************************************************************/
    /**
     *
     * @return sysGetTime TODO_javadoc.
     *
     */
    public int getSysGetTime() {
        return Integer.parseInt(subValue(1, 2));
    }

    /*******************************************************************************************************
     * getSysRtrn
     *******************************************************************************************************/
    /**
     *
     * @return sysRtrn TODO_javadoc.
     *
     */
    public int getSysRtrn() {
        return Integer.parseInt(subValue(2, 3));
    }

    /*******************************************************************************************************
     * getSysXctl
     *******************************************************************************************************/
    /**
     *
     * @return sysXctl TODO_javadoc.
     *
     */
    public int getSysXctl() {
        return Integer.parseInt(subValue(3, 4));
    }

    /*******************************************************************************************************
     * getSysLink
     *******************************************************************************************************/
    /**
     *
     * @return sysLink TODO_javadoc.
     *
     */
    public int getSysLink() {
        return Integer.parseInt(subValue(4, 5));
    }

    /*******************************************************************************************************
     * getSysAbor
     *******************************************************************************************************/
    /**
     *
     * @return sysAbor TODO_javadoc.
     *
     */
    public int getSysAbor() {
        return Integer.parseInt(subValue(5, 6));
    }

    /*******************************************************************************************************
     * getSysVacu
     *******************************************************************************************************/
    /**
     *
     * @return sysVacu TODO_javadoc.
     *
     */
    public SysVacu getSysVacu() {
        return sysVacu;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class SysVacu {

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public SysVacu() {
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
            replaceValue(6, 42, value);
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
            return subValue(6, 6 + 36);
        }

        //
        //
        //

        /*******************************************************************************************************
         * setSysDacu
         *******************************************************************************************************/
        /**
         *
         * @param sysDacu TODO_javadoc.
         *
         */
        public void setSysDacu(int[] sysDacu) {

            if (sysDacu == null || sysDacu.length != 12) {
                throw new IllegalArgumentException("sysDacu[]: no debe ser nulo y largo debe ser 12");
            }

            for (int i = 0; i < 12; i++) {
                replaceValue(6 + 3 * i, 6 + 3 * (i + 1), form3z.format(sysDacu[i]));
            }
        }

        /*******************************************************************************************************
         * setSysDacu
         *******************************************************************************************************/
        /**
         *
         * @param i TODO_javadoc.
         * @param sysDacu TODO_javadoc.
         *
         */
        public void setSysDacu(int i, int sysDacu) {

            if (i < 0 || i >= 12) {
                throw new ArrayIndexOutOfBoundsException("sysDacu[]: indice debe estar en rango [0..11]");
            }

            replaceValue(6 + 3 * i, 6 + 3 * (i + 1), form3z.format(sysDacu));
        }

        /*******************************************************************************************************
         * getSysDacu
         *******************************************************************************************************/
        /**
         *
         * @param i TODO_javadoc.
         *
         * @return sysDacu TODO_javadoc.
         *
         */
        public int getSysDacu(int i) {

            if (i < 0 || i >= 12) {
                throw new ArrayIndexOutOfBoundsException("sysDacu[]: indice debe estar en rango [0..11]");
            }

            return Integer.parseInt(subValue(6 + 3 * i, 6 + 3 * (i + 1)));
        }

        /*******************************************************************************************************
         * getSysDacuSize
         *******************************************************************************************************/
        /**
         *
         * @return TODO_javadoc.
         *
         */
        public final int getSysDacuSize() {
            return 12;
        }

    }

}

