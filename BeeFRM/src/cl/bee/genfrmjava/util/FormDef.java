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
public class FormDef {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(TextDef.class);

    /** TODO_javadoc. */
    public static final int UNDEF = -1;

    //

    /** TODO_javadoc. */
    private String name = null;

	/** TODO_javadoc. */
    private long areaX = UNDEF;
    
    private long areaY = UNDEF;
    
    private long width = UNDEF;

    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAreaX() {
		return areaX;
	}

	public void setAreaX(long areaX) {
		this.areaX = areaX;
	}

	public long getAreaY() {
		return areaY;
	}

	public void setAreaY(long areaY) {
		this.areaY = areaY;
	}

	public long getWidth() {
		return width;
	}

	public void setWidth(long width) {
		this.width = width;
	}
    

    /******************************************************************************
     * FormDef
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public FormDef() {}

    /******************************************************************************
     * FormDef
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
    public FormDef(String name, int areaX, int areaY,int width) {

        this.name   = name;
        this.areaX  = areaX;
        this.areaY  = areaY;
        this.width  = width;
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

        sb.append("[name : " + this.name + "]");
        sb.append("[areaX : " + areaX + "]");
        sb.append("[areaY : " + areaY + "]");
        sb.append("[width : " + width + "]");

        return sb.toString();
    }
}
