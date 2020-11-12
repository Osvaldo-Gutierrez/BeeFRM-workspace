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
public class AdditCodeVisitor extends BaseVisitor implements GJNoArguVisitor<Object> {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(AdditCodeVisitor.class);

    /** TODO_javadoc. */
    private TreeMap<String, String> tree = null;

    /** TODO_javadoc. */
    private int if_level;

    /** TODO_javadoc. */
    private boolean cond_mode;

    /** TODO_javadoc. */
    private TokenVisitor tokenVisitor = new TokenVisitor();

    /******************************************************************************
     * AdditCodeVisitor
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param filename TODO_javadoc.
     * @param symbolsTable TODO_javadoc.
     * @param country TODO_javadoc.
     * @param client TODO_javadoc.
     * @param system TODO_javadoc.
     * @param logging TODO_javadoc.
     * @param cond_mode TODO_javadoc.
     * @param tree TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public AdditCodeVisitor(String filename, HashMap<String, Object> symbolsTable, String country, String client, String system, boolean logging, TreeMap<String, String> tree, boolean cond_mode) {

        super(filename, symbolsTable, null, country, client, system, logging);

      //logger.debug("entrando a '<init>() ...'");

        this.tree      = tree;
        this.cond_mode = cond_mode;

        if_level = 1;
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
    public Object visit(specification n) {

      //logger.debug("entrando a 'visit(specification n, if_level:"  + if_level + ") ...'");

        return n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> assignment_statement()
     *       | selection_statement()
     *       | iteration_statement()
     *       | include_statement()
     *       | text_statement()
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public Object visit(statement n) {

      //logger.debug("entrando a 'visit(statement n) ...'");

        switch(n.f0.which) {

        case 0 : // assignment_statement()
        case 1 : // selection_statement()
      //case 2: // iteration_statement()
      //case 3: // include_statement()
        case 4 : // text_statement()
            return n.f0.accept(this);
        }

        logger.error("antes del error: [" + n.accept(tokenVisitor).toString().trim() + "]");

        throw new RuntimeException("error");
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
    public Object visit(selection_statement n) {

        //logger.debug("entrando a 'visit(selection_statement n, if_level: " + if_level + ")' " + n.f1.accept(tokenVisitor).toString().trim() + ")");

        if (if_level == 1) {

            String            cond = null;
            ArrayList<String> list = new ArrayList<String>();

            if (cond_mode) {
                cond = n.f1.accept(tokenVisitor).toString().replaceAll("[ ]+", " ").trim();
            }
            else {
                n.f1.accept(new IdentifiersVisitor(list));
            }

            /*
            if (n.f4.present()) {
                throw new RuntimeException("se encontro un 'if' de primer nivel con un 'else'.");
            }
            */

            if_level++;

            String text = getTextFormStatementList(n.f3);

            if_level--;

            if (cond_mode) {

              logger.debug("cond: [" + cond + "]");

                tree.put(cond, text);
            }
            else {

                for (int i = 0; i < list.size(); i++) {

                  logger.debug("agregando para '" + list.get(i) + "' ...");

                    tree.put(list.get(i), text);
                }
            }
        }
        else {
            return getTextFormSelectionStatement(n);
        }

        return null;
    }

    //
    //
    //

    /******************************************************************************
     * getTextFormStatementList
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( statement() )+
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private String getTextFormStatementList(statement_list n) {

      //logger.debug("entrando a 'getTextFormStatementList(" + if_level + ")' ...");

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < n.f0.size(); i++) { // ( statement() )+

            statement stmt = (statement) n.f0.elementAt(i);

            switch(stmt.f0.which) {
            case 0 : // assignment_statement()
            case 2 : // iteration_statement()
            case 3 : // include_statement()
                break;

            case 1 : // selection_statement()

                String text = getTextFormSelectionStatement((selection_statement) stmt.f0.choice);

                if (text != null) {
                    sb.append(text);
                }

                break;

            case 4 : // text_statement()

                String s = trimLines(((text_statement) stmt.f0.choice).f0.tokenImage);

                sb.append(s.substring(6, s.length() - 2)); // TEXT[::]);

                break;
            }
        }

      //logger.debug("saliendo de 'getTextFormStatementList(" + if_level + ")' ...");

        return sb.toString();
    }

    /******************************************************************************
     * getTextFormSelectionStatement
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
    private String getTextFormSelectionStatement(selection_statement n) {

        Object obj = n.f1.accept(this); // expression_statement()

        if (!(obj instanceof Boolean)) {
            throw new RuntimeException("valor en condition en if debe ser boolean (" + obj.getClass().getSimpleName() + ").");
        }

        statement_list sl = null;

        if (((Boolean) obj).booleanValue()) {

            sl = n.f3;

            if (sl != null) {
                return getTextFormStatementList(sl);
            }
            else {
                throw new RuntimeException("statement_list en getTextFormSelectionStatement es nula.");
            }
        }
        else if (n.f4.present()) {

            sl = (statement_list) ((NodeSequence) n.f4.node).elementAt(1);

            if (sl != null) {
                return getTextFormStatementList(sl);
            }
            else {
                throw new RuntimeException("statement_list en getTextFormSelectionStatement es nula.");
            }
        }

        return null;
    }

}
