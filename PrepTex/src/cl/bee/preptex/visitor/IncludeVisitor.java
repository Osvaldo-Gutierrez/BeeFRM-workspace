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

import org.apache.log4j.*;


/**
 *
 * TODO_javadoc.
 *
 * @version 1.0 (01/01/2020).
 *
 */
public class IncludeVisitor extends BaseVisitor implements GJNoArguVisitor<Object> {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(IncludeVisitor.class);

    /** TODO_javadoc. */
    private ArrayList<statement_list> stmts = new ArrayList<statement_list>();

    /** TODO_javadoc. */
    boolean full_include;

    /** TODO_javadoc. */
    int selectionDeep = 0;

    /******************************************************************************
     * IncludeVisitor
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
     * @param full_include TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public IncludeVisitor(String filename, HashMap<String, Object> symbolsTable, String control, String country, String client, String system, boolean logging, boolean full_include) {

        super(filename, symbolsTable, control, country, client, system, logging);

        this.full_include = full_include;
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> statement_list()
     * f1 -> <EOF>
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    @Override
    public Object visit(specification n) {

        if (full_include) {
            stmts.add(cloner.deepClone(n.f0)); // statement_list()
        }
        else {

            for (int i = 0; i < n.f0.f0.size(); i++) { // ( statement() )+

                statement stmt = (statement) n.f0.f0.elementAt(i);

                if (stmt.f0.which == 1 /*selection_statement*/) {
                    stmt.accept(this);
                }
            }
        }

        return stmts;
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <IF>
     * f1 -> expression_statement()
     * f2 -> [ <THEN> ]
     * f3 -> statement_list()
     * f4 -> [ <ELSE> statement_list() ]
     * f5 -> <END>
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    @Override
    public Object visit(selection_statement n) {

        Object obj = n.f1.accept(this); // expression_statement()

        if (obj == null) {
            throw new RuntimeException("condicion del <IF> nula.");
        }

        if (!(obj instanceof Boolean)) {
            throw new RuntimeException("tipo condicion del <IF> debe ser Boolean '" + obj + "' (" + obj.getClass().getSimpleName() + ").");
        }

        //

        if (((Boolean) obj).booleanValue()) {
            stmts.add(cloner.deepClone(n.f3)); // statement_list()
        }
        else if (n.f4.present()) { // [ <ELSE> statement_list() ]

          //throw new RuntimeException("el <ELSE> no esta contemplado en IncludeVisitor.");
        }

        return null;
    }
}
