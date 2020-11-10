/*
 *   Copyright (c) 2019 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.preptex.util;


import java.io.*;

import java.util.*;
import java.util.regex.*;

import org.apache.log4j.*;


/**
 * @author  alarrea@bee.cl
 * @version 1.0
 */
public class IncludeFileFilter implements FileFilter {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(IncludeFileFilter.class);

    /** TODO_javadoc. */
    private Pattern pattern = null;

    /*******************************************************************************************************
     * IncludeFileFilter
     *******************************************************************************************************/
    /**
     *
     * @param filename
     *
     */
    public IncludeFileFilter(Pattern pattern) {

      //logger.debug("entrando a '<init>(" + pattern.pattern() + ") ...'");

        this.pattern = pattern;
    }

    /*******************************************************************************************************
     * accept
     *******************************************************************************************************/
    /**
     *
     * @param pathname
     *
     * @return
     *
     */
    public boolean accept(File pathname) {

        try {
            return accept(pathname.getName());
        }
        catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    /*******************************************************************************************************
     * accept
     *******************************************************************************************************/
    /**
     *
     * @param name
     *
     * @return
     *
     */
    public boolean accept(String name) throws Exception {
        return pattern.matcher(name).find();
    }
}
