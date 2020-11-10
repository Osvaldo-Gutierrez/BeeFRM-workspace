/*
 *   Copyright (c) 2020 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.preptex.visitor;


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
public class IdentifiersVisitor extends DepthFirstVisitor implements Visitor {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(IdentifiersVisitor.class);

    /** TODO_javadoc. */
    private ArrayList<String> list = null;

    /** TODO_javadoc. */
    protected TokenVisitor tokenVisitor = new TokenVisitor();

    /******************************************************************************
     * IdentifiersVisitor
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param list TODO_javadoc.
     *
     */
    public IdentifiersVisitor(ArrayList<String> list) {

        this.list = list;
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> equality_expression()
     * f1 -> ( <AND> equality_expression() )*
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(logical_and_expression n) {

        logger.warn("******************************************************************************************************");
        logger.warn("**** revisar solucion operador logico 'and' (" + n.accept(tokenVisitor).toString().trim() + ")");
        logger.warn("******************************************************************************************************");

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <IDENTIFIER>
     *       | constant()
     *       | <LPAREN> expression_statement() <RPAREN>
     *       | <LBRACE> expression_statement() <RBRACE>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(primary_expression n) {

        switch (n.f0.which) {

        case 0 : // <IDENTIFIER>

            list.add(((NodeToken) n.f0.choice).tokenImage);
        }
    }
}
