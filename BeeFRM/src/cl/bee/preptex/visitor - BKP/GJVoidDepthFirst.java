/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.preptex.visitor;


import java.io.*;

import java.util.*;

import cl.bee.preptex.syntaxtree.*;


/**
 *
 * TODO_javadoc.
 *
 * @version 1.0 (01/01/20XX).
 *
 */
public class GJVoidDepthFirst<A> implements GJVoidVisitor<A> {

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     */
    public void visit(NodeList n, A argu) {

        int _count=0;

        for (Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {

            e.nextElement().accept(this, argu);

            _count++;
        }
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     */
    public void visit(NodeListOptional n, A argu) {

        if (n.present()) {

            int _count=0;

            for (Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {

                e.nextElement().accept(this, argu);

                _count++;
            }
        }
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     */
    public void visit(NodeOptional n, A argu) {

        if (n.present()) {
            n.node.accept(this, argu);
        }
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     */
    public void visit(NodeSequence n, A argu) {

        int _count=0;

        for (Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {

            e.nextElement().accept(this, argu);

            _count++;
        }
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     */
    public void visit(NodeToken n, A argu) {}

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
     * @param argu TODO_javadoc.
     *
     */
    public void visit(specification n, A argu) {

        n.f0.accept(this, argu);
        n.f1.accept(this, argu);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( statement() )*
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     */
    public void visit(statement_list n, A argu) {
        n.f0.accept(this, argu);
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
     * @param argu TODO_javadoc.
     *
     */
    public void visit(statement n, A argu) {
        n.f0.accept(this, argu);
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
     * @param argu TODO_javadoc.
     *
     */
    public void visit(selection_statement n, A argu) {

        n.f0.accept(this, argu);
        n.f1.accept(this, argu);
        n.f2.accept(this, argu);
        n.f3.accept(this, argu);
        n.f4.accept(this, argu);
        n.f5.accept(this, argu);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <WHILE> expression_statement() statement_list() <END>
     *       | <FOR> <EACH> <IDENTIFIER> <IN> <LPAREN> argument_expression_list() <RPAREN> statement_list() <END>
     *       | <FOR> <IDENTIFIER> <EQUAL> expression_statement() <TO> expression_statement() [ <STEP> expression_statement() ] statement_list() <NEXT> <IDENTIFIER>
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     */
    public void visit(iteration_statement n, A argu) {
        n.f0.accept(this, argu);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <INCLUDE>
     * f1 -> [ identifier_list() <OF> ]
     * f2 -> <STRING>
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     */
    public void visit(include_statement n, A argu) {

        n.f0.accept(this, argu);
        n.f1.accept(this, argu);
        n.f2.accept(this, argu);
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
     * @param argu TODO_javadoc.
     *
     */
    public void visit(text_statement n, A argu) {
        n.f0.accept(this, argu);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> unary_expression()
     * f1 -> assignment_operator()
     * f2 -> expression_statement()
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     */
    public void visit(assignment_statement n, A argu) {

        n.f0.accept(this, argu);
        n.f1.accept(this, argu);
        n.f2.accept(this, argu);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <IDENTIFIER>
     * f1 -> ( <COMMA> <IDENTIFIER> )*
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     */
    public void visit(identifier_list n, A argu) {

        n.f0.accept(this, argu);
        n.f1.accept(this, argu);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> logical_or_expression()
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     */
    public void visit(expression_statement n, A argu) {
        n.f0.accept(this, argu);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <EQUAL>
     *       | <PLUSASSIGN>
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     */
    public void visit(assignment_operator n, A argu) {
        n.f0.accept(this, argu);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> logical_and_expression()
     * f1 -> ( <OR> logical_and_expression() )*
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     */
    public void visit(logical_or_expression n, A argu) {

        n.f0.accept(this, argu);
        n.f1.accept(this, argu);
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
     * @param argu TODO_javadoc.
     *
     */
    public void visit(logical_and_expression n, A argu) {

        n.f0.accept(this, argu);
        n.f1.accept(this, argu);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> relational_expression()
     * f1 -> [ ( <EQUAL> | <NE> ) relational_expression() ]
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     */
    public void visit(equality_expression n, A argu) {

        n.f0.accept(this, argu);
        n.f1.accept(this, argu);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> additive_expression()
     * f1 -> [ ( <LT> | <GT> | <LE> | <GE> ) additive_expression() ]
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     */
    public void visit(relational_expression n, A argu) {

        n.f0.accept(this, argu);
        n.f1.accept(this, argu);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> multiplicative_expression()
     * f1 -> ( ( <PLUS> | <MINUS> ) multiplicative_expression() )*
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     */
    public void visit(additive_expression n, A argu) {

        n.f0.accept(this, argu);
        n.f1.accept(this, argu);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> unary_expression()
     * f1 -> ( ( <STAR> | <SLASH> ) unary_expression() )*
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     */
    public void visit(multiplicative_expression n, A argu) {

        n.f0.accept(this, argu);
        n.f1.accept(this, argu);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> postfix_expression()
     *       | unary_operator() unary_expression()
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     */
    public void visit(unary_expression n, A argu) {
        n.f0.accept(this, argu);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <MINUS>
     *       | <NOT>
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     */
    public void visit(unary_operator n, A argu) {
        n.f0.accept(this, argu);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> primary_expression()
     * f1 -> [ <LPAREN> argument_expression_list() <RPAREN> ]
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     */
    public void visit(postfix_expression n, A argu) {

        n.f0.accept(this, argu);
        n.f1.accept(this, argu);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> expression_statement()
     * f1 -> ( <COMMA> expression_statement() )*
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     */
    public void visit(argument_expression_list n, A argu) {

        n.f0.accept(this, argu);
        n.f1.accept(this, argu);
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
     * @param argu TODO_javadoc.
     *
     */
    public void visit(primary_expression n, A argu) {
        n.f0.accept(this, argu);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <DOUBLE>
     *       | <STRING>
     *       | <TRUE>
     *       | <FALSE>
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     */
    public void visit(constant n, A argu) {
        n.f0.accept(this, argu);
    }

}
