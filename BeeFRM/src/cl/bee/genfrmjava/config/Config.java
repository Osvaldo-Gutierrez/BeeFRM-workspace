/*
 *   Copyright (c) 2019 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.genfrmjava.config;


import java.util.*;

import cl.bee.genfrmjava.util.*;


/**
 *
 * TODO_javadoc.
 *
 * @version 1.0 (01/01/2013).
 *
 */
public interface Config {

    /******************************************************************************
     * getFieldFromXML
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param filename TODO_javadoc.
     * @param fields TODO_javadoc.
     * @param texts TODO_javadoc.
     *
     * @throws Exception TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public void getInfoFromXML(String filename, ArrayList<Object> fields, ArrayList<TextDef> texts, FormDef forms) throws Exception;

}
