/*
 *   Copyright (c) 2019 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.genfrmjava.util;


import java.util.*;
import java.util.regex.*;

import org.apache.log4j.*;


/**
 *
 * TODO_javadoc.
 *
 * @version 1.0 (01/01/2013).
 *
 */
public class TextDef {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(TextDef.class);

    /** TODO_javadoc. */
    public static final int UNDEF = -1;

    //

    /** TODO_javadoc. */
    public String caption = null;

    /** TODO_javadoc. */
    public int row = UNDEF;

    /** TODO_javadoc. */
    public int column = UNDEF;

    /******************************************************************************
     * TextDef
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public TextDef() {}

    /******************************************************************************
     * TextDef
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param caption TODO_javadoc.
     * @param row TODO_javadoc. 
     * @param column TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public TextDef(String caption, int row, int column) {

        this.caption = caption;
        this.row     = row;
        this.column  = column;
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

        StringBuffer sb = new StringBuffer();

        sb.append("[caption : " + caption + "]");
        sb.append("[row : " + row + "]");
        sb.append("[column : " + column + "]");

        return sb.toString();
    }
}
