/*
 *   Copyright (c) 2017 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.perseus.util;


/**
 *
 * TODO_javadoc.
 *
 * @version 1.0 (01/01/2016).
 *
 */
public class LineDesc {

    /** TODO_javadoc. */
    private int globalNum = 0;

    /** TODO_javadoc. */
    private String source = null;

    /** TODO_javadoc. */
    private String line = null;

    /** TODO_javadoc. */
    private int programNum = 0;

    /** TODO_javadoc. */
    private int localNum = 0;

    /******************************************************************************
     * LineDesc
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param globalNum TODO_javadoc.
     * @param source TODO_javadoc.
     * @param line TODO_javadoc.
     * @param globalNum TODO_javadoc.
     * @param localNum TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public LineDesc(int globalNum, String source, String line, int programNum, int localNum) {

        this.globalNum  = globalNum;
        this.source     = source;
        this.line       = line;
        this.programNum = programNum;
        this.localNum   = localNum;
    }

    /******************************************************************************
     * getGlobalNum
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
    public int getGlobalNum() {
        return globalNum;
    }

    /******************************************************************************
     * getSource
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
    public String getSource() {
        return source;
    }

    /******************************************************************************
     * getLine
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
    public String getLine() {
        return line;
    }

    /******************************************************************************
     * getProgramNum
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
    public int getProgramNum() {
        return programNum;
    }

    /******************************************************************************
     * getLocalNum
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
    public int getLocalNum() {
        return localNum;
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

        String s = "";

        s += "[globalNum : " + globalNum + "]";
        s += "[source : " + (source == null ? "(NULL)" : source) + "]";
        s += "[line : " + (line == null ? "(NULL)" : line) + "]";
        s += "[programNum : " + programNum + "]";
        s += "[localNum : " + localNum + "]";

        return s;
    }
}
