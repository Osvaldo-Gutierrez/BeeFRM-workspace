/*
 *   Copyright (c) 2020 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.preptex.visitor;


import java.io.*;

import java.util.*;

import cl.bee.preptex.syntaxtree.*;

import com.rits.cloning.*;

import org.apache.log4j.*;


/**
 *
 * TODO_javadoc.
 *
 * @version 1.0 (01/01/20202019).
 *
 */
public class PrintVisitor extends BaseVisitor implements GJNoArguVisitor<Object> {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(PrintVisitor.class);

    /** TODO_javadoc. */
    private ArrayList<statement_list> stmts = new ArrayList<statement_list>();

    /** TODO_javadoc. */
    private PrintStream gen = null;

    /******************************************************************************
     * PrintVisitor
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param filename TODO_javadoc.
     * @param symbolsTable TODO_javadoc.
     * @param control TODO_javadoc.
     * @param country TODO_javadoc.
     * @param client TODO_javadoc.
     * @param system TODO_javadoc.
     * @param logging TODO_javadoc.
     * @param gen TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public PrintVisitor(String filename, HashMap<String, Object> symbolsTable, String control, String country, String client, String system, boolean logging, PrintStream gen) {

        super(filename, symbolsTable, control, country, client, system, logging);

        this.gen = gen;
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <TEXT>
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    @Override
    public Object visit(text_statement n) {

        String s = trimLines(n.f0.tokenImage);

        try {
            gen.print(replace(s.substring(6, s.length() - 2))); // TEXT[::]
            //ogb-ini
            logger.debug("PrintVisitor.java - OGB");
            logger.debug(replace(s.substring(6, s.length() - 2)));
            //ogb-fin
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        return null;
    }
}
