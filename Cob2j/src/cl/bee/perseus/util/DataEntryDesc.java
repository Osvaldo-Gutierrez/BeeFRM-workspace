/*
 *   Copyright (c) 2017 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.perseus.util;


import java.io.*;

import java.util.*;


/**
 *
 * TODO_javadoc.
 *
 * @version 1.0 (01/01/2016).
 *
 */
public class DataEntryDesc implements Serializable  {

    /** TODO_javadoc. */
    public static final int UNDEF   = -1;

    //

    /** TODO_javadoc. */
    public static final int INTEGER = 1;

    /** TODO_javadoc. */
    public static final int LONG    = 2;

    /** TODO_javadoc. */
    public static final int DOUBLE  = 3;

    /** TODO_javadoc. */
    public static final int STRING  = 4;

    /** TODO_javadoc. */
    public static final int BOOLEAN = 5; // LEVEL_88

    //

    /** TODO_javadoc. */
    public final static String[]  typesNames      = { "",    "INTEGER", "LONG",   "DOUBLE",  "STRING", "BOOLEAN" };

    /** TODO_javadoc. */
    public static final String[]  javaObjectNames = { "",    "Integer", "Long",   "Double",  "String", "Boolean" };

    /** TODO_javadoc. */
    public static final String[]  javaNames       = { "",    "int",     "long",   "double",  "String", "boolean" };

    /** TODO_javadoc. */
    public static final boolean[] javaObjects     = { false, false,     false,    false,     true,     false };

    //

    /** TODO_javadoc. */
    public static final int VARIABLE  = 1;

    /** TODO_javadoc. */
    public static final int CONDITION = 2;

    /** TODO_javadoc. */
    public static final int INDEXER   = 3;

    /** TODO_javadoc. */
    public static final int SPECIAL   = 4;

    /** TODO_javadoc. */
    public static final String[] modesNames = { "", "VARIABLE", "CONDITION", "INDEXER", "SPECIAL" };

    //

    /** TODO_javadoc. */
    public int level = UNDEF;

    /** TODO_javadoc. */
    public String name = null;

    /** TODO_javadoc. */
    public int occurs = UNDEF;

    /** TODO_javadoc. */
    public Object value = null;

    /** TODO_javadoc. */
    public String redefining = null;

    /** TODO_javadoc. */
    public String indexer = null;

    /** TODO_javadoc. */
    public int type = UNDEF;

    /** TODO_javadoc. */
    public int mode = UNDEF;

    //

    /** TODO_javadoc. */
    public int totalLen = 0;

    /** TODO_javadoc. */
    public int ints = 0;

    /** TODO_javadoc. */
    public int decs = 0;

    /** TODO_javadoc. */
    public boolean sign = false;

    //

    /** TODO_javadoc. */
    public int offset = UNDEF;

    /** TODO_javadoc. */
    public ArrayList<DataEntryDesc> childs = null;

    //

    /** TODO_javadoc. */
    public String addendum = null;

    /** TODO_javadoc. */
    private HashMap<String, Object> hash = new HashMap<String, Object>();

    /******************************************************************************
     * DataEntryDesc
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param level TODO_javadoc.
     * @param name TODO_javadoc.
     * @param occurs TODO_javadoc.
     * @param value TODO_javadoc.
     * @param redefining TODO_javadoc.
     * @param indexer TODO_javadoc.
     * @param type TODO_javadoc.
     * @param ints TODO_javadoc.
     * @param decs TODO_javadoc.
     * @param totalLen TODO_javadoc.
     * @param sign TODO_javadoc.
     * @param mode TODO_javadoc.
     * @param offset TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public DataEntryDesc(int level, String name, int occurs, Object value, String redefining, String indexer, int type, int ints, int decs, int totalLen, boolean sign, int mode, int offset) {

        this.level      = level;
        this.name       = name;
        this.occurs     = occurs;
        this.value      = value;
        this.redefining = redefining;
        this.indexer    = indexer;
        this.type       = type;
        this.ints       = ints;
        this.decs       = decs;
        this.totalLen   = totalLen;
        this.sign       = sign;
        this.mode       = mode;
        this.offset     = offset;
    }

    /******************************************************************************
     * DataEntryDesc
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param value TODO_javadoc.
     * @param type TODO_javadoc.
     * @param mode TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public DataEntryDesc(Object value, int type, int mode) {
        this(0, null, 1, value, null, null, type, 0, 0, 0, false, mode, DataEntryDesc.UNDEF);
    }

    /******************************************************************************
     * set
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param name TODO_javadoc.
     * @param value TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public void set(String name, Object value) {
        hash.put(name, value);
    }

    /******************************************************************************
     * get
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param name TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public Object get(String name) {
        return hash.get(name);
    }

    /******************************************************************************
     * get
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param name TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public boolean getBool(String name) {

        if (hash.containsKey(name)) {
            return ((Boolean) hash.get(name)).booleanValue();
        }
        else {
            throw new RuntimeException("no existe '" + name + "' en hash.");
        }
    }

    /******************************************************************************
     * toString
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public String toString() {

        String s = "{ ";

        s +=   "\"level\" : "        + level;
        s += ", \"name\" : \""       + name                                                           + "\"";
        s += ", \"occurs\" : "       + occurs;
        s += ", \"value\" : \""      + (value      != null  ? scape(String.valueOf(value)) : "NULL")  + "\"";
        s += ", \"redefining\" : \"" + (redefining != null  ? redefining                   : "NULL")  + "\"";
        s += ", \"indexer\" : \""    + (indexer    != null  ? indexer                      : "NULL")  + "\"";
        s += ", \"type\" : \""       + (type       != UNDEF ? typesNames[type]             : "UNDEF") + "\"";
        s += ", \"ints\" : "         + ints;
        s += ", \"decs\" : "         + decs;
        s += ", \"totalLen\" : "     + totalLen;
        s += ", \"sign\" : "         + sign;
        s += ", \"mode\" : \""       + (mode       != UNDEF ? modesNames[mode]             : "UNDEF") + "\"";
        s += ", \"offset\" : "       + offset;
        s += ", \"addendum\" : \""   + (addendum   != null  ? addendum                     : "NULL")  + "\"";
        s += ", \"hash\" : \""       + (hash       != null  ? hash                         : "NULL")  + "\"";

        if (childs != null) {

            s += ", \"childs\" : [ ";

            for (int i = 0; i < childs.size(); i++) {
                s += (i > 0 ? ", ": "") + childs.get(i);
            }

            s += " ]";
        }

        s += " }";

        return s;
    }

    /******************************************************************************
     * scape
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param s TODO_javadoc.
     *
     */
    private static String scape(String s) {

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '"') {
                sb.append('\\');
            }

            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

}
