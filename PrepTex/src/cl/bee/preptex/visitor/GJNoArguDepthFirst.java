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
public class GJNoArguDepthFirst<R> implements GJNoArguVisitor<R> {

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public R visit(NodeList n) {

        R   _ret   = null;
        int _count = 0;

        for (Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {

            e.nextElement().accept(this);

            _count++;
        }

        return _ret;
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public R visit(NodeListOptional n) {

        if (n.present()) {

            R   _ret   = null;
            int _count = 0;

            for (Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {

                e.nextElement().accept(this);

                _count++;
            }

            return _ret;
        }
        else {
            return null;
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
     *
     * @return TODO_javadoc.
     *
     */
    public R visit(NodeOptional n) {

        if (n.present()) {
            return n.node.accept(this);
        }
        else {
            return null;
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
     *
     * @return TODO_javadoc.
     *
     */
    public R visit(NodeSequence n) {

        R   _ret   = null;
        int _count = 0;

        for (Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {

            e.nextElement().accept(this);

            _count++;
        }

        return _ret;
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public R visit(NodeToken n) {
        return null;
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
    public R visit(specification n) {

        R _ret = null;

        n.f0.accept(this);
        n.f1.accept(this);

        return _ret;
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
     *
     * @return TODO_javadoc.
     *
     */
    public R visit(statement_list n) {

        R _ret = null;

        n.f0.accept(this);

        return _ret;
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
    public R visit(statement n) {

        R _ret = null;

        n.f0.accept(this);

        return _ret;
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
    public R visit(selection_statement n) {

        R _ret = null;

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
        n.f5.accept(this);

        return _ret;
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
     *
     * @return TODO_javadoc.
     *
     */
    public R visit(iteration_statement n) {

        R _ret = null;

        n.f0.accept(this);

        return _ret;
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
     *
     * @return TODO_javadoc.
     *
     */
    public R visit(include_statement n) {

        R _ret = null;

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);

        return _ret;
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
    public R visit(text_statement n) {

        R _ret = null;

        n.f0.accept(this);

        return _ret;
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
     *
     * @return TODO_javadoc.
     *
     */
    public R visit(assignment_statement n) {

        R _ret = null;

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);

        return _ret;
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
     *
     * @return TODO_javadoc.
     *
     */
    public R visit(identifier_list n) {

        R _ret = null;

        n.f0.accept(this);
        n.f1.accept(this);

        return _ret;
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
     *
     * @return TODO_javadoc.
     *
     */
    public R visit(expression_statement n) {

        R _ret = null;

        n.f0.accept(this);

        return _ret;
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
     *
     * @return TODO_javadoc.
     *
     */
    public R visit(assignment_operator n) {

        R _ret = null;

        n.f0.accept(this);

        return _ret;
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
     *
     * @return TODO_javadoc.
     *
     */
    public R visit(logical_or_expression n) {

        R _ret = null;

        n.f0.accept(this);
        n.f1.accept(this);

        return _ret;
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
     * @return TODO_javadoc.
     *
     */
    public R visit(logical_and_expression n) {

        R _ret = null;

        n.f0.accept(this);
        n.f1.accept(this);

        return _ret;
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
     *
     * @return TODO_javadoc.
     *
     */
    public R visit(equality_expression n) {

        R _ret = null;

        n.f0.accept(this);
        n.f1.accept(this);

        return _ret;
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
     *
     * @return TODO_javadoc.
     *
     */
    public R visit(relational_expression n) {

        R _ret = null;

        n.f0.accept(this);
        n.f1.accept(this);

        return _ret;
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
     *
     * @return TODO_javadoc.
     *
     */
    public R visit(additive_expression n) {

        R _ret = null;

        n.f0.accept(this);
        n.f1.accept(this);

        return _ret;
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
     *
     * @return TODO_javadoc.
     *
     */
    public R visit(multiplicative_expression n) {

        R _ret = null;

        n.f0.accept(this);
        n.f1.accept(this);

        return _ret;
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
     *
     * @return TODO_javadoc.
     *
     */
    public R visit(unary_expression n) {

        R _ret = null;

        n.f0.accept(this);

        return _ret;
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
     *
     * @return TODO_javadoc.
     *
     */
    public R visit(unary_operator n) {

        R _ret = null;

        n.f0.accept(this);

        return _ret;
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
     *
     * @return TODO_javadoc.
     *
     */
    public R visit(postfix_expression n) {

        R _ret = null;

        n.f0.accept(this);
        n.f1.accept(this);

        return _ret;
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
     *
     * @return TODO_javadoc.
     *
     */
    public R visit(argument_expression_list n) {

        R _ret = null;

        n.f0.accept(this);
        n.f1.accept(this);

        return _ret;
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
     * @return TODO_javadoc.
     *
     */
    public R visit(primary_expression n) {

        R _ret = null;

        n.f0.accept(this);

        return _ret;
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
     *
     * @return TODO_javadoc.
     *
     */
    public R visit(constant n) {

        R _ret = null;

        n.f0.accept(this);

        return _ret;
    }

}
