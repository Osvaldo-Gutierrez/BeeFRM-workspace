/*
 *   Copyright (c) 2020 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.beebank.cloud.core.gns;


import java.io.UnsupportedEncodingException;

import java.text.DecimalFormat;

import java.util.Arrays;

//import org.apache.log4j.Logger;


/**
 *
 * TODO_javadoc.
 *
 * @version 1.0 (01/01/2016).
 *
 */
public class Root {

    /** TODO_javadoc. */
  //private static Logger logger = Logger.getLogger(Root.class);

    /** TODO_javadoc. */
    private byte[] buffer = null;
                                       //          ----------
    /** TODO_javadoc. */               //01234567890123456789
    private static final String SIGNS = "{ABCDEFGHI}JKLMNOPQR";

    //

    /** TODO_javadoc. */
    public static final boolean ROUNDED = true;

    /** TODO_javadoc. */
    public static final boolean TRUNCATED = false;

    /*******************************************************************************************************
     * initBuffer
     *******************************************************************************************************/
    /**
     *
     * @param size TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    protected void initBuffer(int size) {
        buffer = new byte[size];
    }

    /*******************************************************************************************************
     * replaceValue
     *******************************************************************************************************/
    /**
     *
     * @param int TODO_javadoc.
     * @param fin TODO_javadoc.
     * @param value TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    protected void replaceValue(int ini, int fin, String value) {

        if (value == null) {
           throw new NullPointerException("[replaceValue] value es null.");
        }

        if (ini < 0 || fin < ini || buffer.length < fin) {
           throw new IndexOutOfBoundsException("[replaceValue] indices {" + ini + "," + fin + "} inadecuados.");
        }

        try {

            if (value.length() < fin - ini) {

                byte[] arr = new byte[fin - ini - value.length()];

                Arrays.fill(arr, (byte) 0x00);

                System.arraycopy(value.getBytes("UTF-8"), 0, buffer, ini,                              value.length());
                System.arraycopy(arr,                     0, buffer, ini + value.length(), fin - ini - value.length());
            }
            else { // value.length() puede ser mayor a (fin - ini), pero solo copia esta ultima cantidad
                System.arraycopy(value.getBytes("UTF-8"), 0, buffer, ini,                  fin - ini);
            }
        }
        catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /*******************************************************************************************************
     * subValue
     *******************************************************************************************************/
    /**
     *
     * @param int TODO_javadoc.
     * @param fin TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    protected String subValue(int ini, int fin) {

        if (ini < 0 || fin < ini || buffer.length < fin) {
           throw new IndexOutOfBoundsException("[subValue] indices {" + ini + "," + fin + "} inadecuados.");
        }

        try {
            return new String(buffer, ini, fin - ini, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /*******************************************************************************************************
     * setCompNumber
     *******************************************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param l TODO_javadoc.
     * @param formz TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    protected String setCompNumber(long l, DecimalFormat formz) {

        String s = formz.format(Math.abs(l));

        return s.substring(0, s.length() - 1) + Character.toString(l < 0 ? SIGNS.charAt(10 - (int) l % 10) :
                                                                           SIGNS.charAt(     (int) l % 10));
    }

    /*******************************************************************************************************
     * getCompNumber
     *******************************************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param s TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    protected long getCompNumber(String s) {

        if (s == null || s.trim().length() < 1) {
            throw new IllegalArgumentException("'" + s + "' no es valido en getCompNumber().");
        }

        s = s.trim();

        int pos = SIGNS.indexOf(s.charAt(s.length() - 1));

        if (pos < 0) {
            throw new IllegalArgumentException("'" + s + "' no es valido en getCompNumber().");
        }

        return pos > 9 ? -10 * Long.parseLong(s.substring(0, s.length() - 1)) - pos + 10
                       :  10 * Long.parseLong(s.substring(0, s.length() - 1)) + pos;
    }

    /*******************************************************************************************************
     * setBuffer
     *******************************************************************************************************/
    /**
     *
     * @param buffer TODO_javadoc.
     *
     */
    public void setBuffer(byte[] buffer) {

        if (buffer == null) {
           throw new NullPointerException("[setBuffer] buffer es null.");
        }

        if (buffer.length != this.buffer.length) {
           throw new ArrayStoreException("[setBuffer] largo de buffer debe ser "  + this.buffer.length + ".");
        }

        System.arraycopy(buffer, 0, this.buffer, 0, this.buffer.length);
    }

    /*******************************************************************************************************
     * getBuffer
     *******************************************************************************************************/
    /**
     *
     * @return TODO_javadoc.
     *
     */
    public byte[] getBuffer() {
        return buffer == null ? null : (byte[]) buffer.clone();
    }

}
