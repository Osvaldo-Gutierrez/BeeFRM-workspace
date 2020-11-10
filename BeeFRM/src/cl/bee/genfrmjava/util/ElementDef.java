/*
 *   Copyright (c) 2019 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.genfrmjava.util;


import java.util.*;

import org.apache.log4j.*;


/**
 *
 * TODO_javadoc.
 *
 * @version 1.0 (01/01/2013).
 *
 */
public class ElementDef {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(ElementDef.class);

    //

    /** TODO_javadoc. */
    public FieldDef field = null;

    /** TODO_javadoc. */
    public ArrayList<PositionDef> index = null;

    /******************************************************************************
     * ElementDef
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public ElementDef() {}

    /******************************************************************************
     * ElementDef
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param field TODO_javadoc.
     * @param index TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public ElementDef(FieldDef field, ArrayList<PositionDef> index) {

        this.field = field;
        this.index = index;
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

        sb.append("[field : " + field + "]");
        sb.append("[index : "  + index + "]");

        return sb.toString();
    }
}
