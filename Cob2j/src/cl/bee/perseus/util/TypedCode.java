/*
 *   Copyright (c) 2020 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.perseus.util;


import java.io.*;

import java.util.*;

import cl.bee.perseus.cobolparser.util.*;

import org.apache.log4j.*;


/**
 *
 * TODO_javadoc.
 *
 * @version 1.0 (01/01/2020).
 *
 */
public class TypedCode {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(TypedCode.class);

    /** TODO_javadoc. */
    public static final String TYPE_EXPECTED = "type_expected";


    /** TODO_javadoc. */
    public static final int UNDEF    = -1;

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
    public final static String[] typesNames = { "", "INTEGER", "LONG", "DOUBLE",  "STRING", "BOOLEAN" };

    /** TODO_javadoc. */
    public static final String[]  javaNames = { "", "int",     "long", "double",  "String", "boolean" };

    //

    /** TODO_javadoc. */
    public static final int SIMPLE = 1;

    /** TODO_javadoc. */
    public static final int COMPLEX = 2;

    /** TODO_javadoc. */
    public final static String[] aggregationsNames = { "", "SIMPLE", "COMPLEX" };

    //

    /** TODO_javadoc. */
    public static final int NE = 0;

    /** TODO_javadoc. */
    public static final int LT = 1;

    /** TODO_javadoc. */
    public static final int LE = 2;

    /** TODO_javadoc. */
    public static final int EQ = 3;

    /** TODO_javadoc. */
    public static final int GT = 4;

    /** TODO_javadoc. */
    public static final int GE = 5;

    /** TODO_javadoc. */
    public static final String[] relationalOper = { "!=", "<", "<=", "==", ">", ">=" };

    //

    /** TODO_javadoc. */
    public int type = UNDEF;

    /** TODO_javadoc. */
    public String code = null;

    /** TODO_javadoc. */
    public int aggregation = UNDEF;

    /** TODO_javadoc. */
    public int size = UNDEF;

    /** TODO_javadoc. */
    public boolean sign = false;

    /** TODO_javadoc. */
    private HashMap<String, Object> hash = new HashMap<String, Object>();

    /******************************************************************************
     * TypedCode
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param type TODO_javadoc.
     * @param code TODO_javadoc.
     * @param aggregation TODO_javadoc.
     * @param size TODO_javadoc.
     * @param hash TODO_javadoc.
     *
     */
    public TypedCode(int type, String code, int aggregation, int size, HashMap<String, Object> hash) {

        this.type        = type;
        this.code        = code;
        this.aggregation = aggregation;
        this.size        = size;
        this.hash        = hash;
    }

    /******************************************************************************
     * TypedCode
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param type TODO_javadoc.
     * @param code TODO_javadoc.
     * @param code TODO_javadoc.
     * @param aggregation TODO_javadoc.
     *
     */
    public TypedCode(int type, String code, int aggregation) {
        this(            type,        code,     aggregation, UNDEF, new HashMap<String, Object>());
    }

    /******************************************************************************
     * TypedCode
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param type TODO_javadoc.
     * @param code TODO_javadoc.
     * @param code TODO_javadoc.
     * @param aggregation TODO_javadoc.
     *
     */
    public TypedCode(int type, String code, int aggregation, int size) {
        this(            type,        code,     aggregation,     size, new HashMap<String, Object>());
    }

    /******************************************************************************
     * isNumeric
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public boolean isNumeric() {

        switch (type) {
        case INTEGER :
        case LONG :
        case DOUBLE :
            return true;
        case STRING  :
        case BOOLEAN :
            return false;
        }

        throw new RuntimeException("isNumeric:: tipo " + type + " no utilizable.");
    }

    /******************************************************************************
     * toStringCode
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String toStringCode() {

        switch (type) {
        case INTEGER :
            return "Integer.toString(" + code + ")";
        case LONG :
            return "Long.toString(" + code + ")";
        case DOUBLE :
            return "Double.toString(" + code + ")";
        case STRING  :
            return code;
        case BOOLEAN :
            return "Boolean.toString(" + code + ")";
        }

        throw new RuntimeException("toStringCode:: tipo " + type + " no utilizable.");
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
     * get
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public  HashMap<String, Object> getHash() {
        return hash;
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
     */
    public String toString() {

        String s = "";

        s += "[type : " + (type == UNDEF ? "(UNDEF)" : typesNames[type]) + "]";
        s += "[code : " + (code == null ? "(NULL)" : code) + "]";
        s += "[aggregation : " + (aggregation == UNDEF ? "(UNDEF)" : aggregationsNames[aggregation]) + "]";
        s += "[size : " + (size == UNDEF ? "(UNDEF)" : size) + "]";
        s += "[hash : " + hash + "]";

        return s;
    }
}
