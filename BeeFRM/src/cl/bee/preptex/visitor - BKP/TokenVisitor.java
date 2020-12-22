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
public class TokenVisitor implements GJNoArguVisitor<StringBuffer> {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(TokenVisitor.class);

    /** TODO_javadoc. */
    private StringBuffer sb = null;

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
    public StringBuffer visit(NodeList n) {

        StringBuffer   _ret   = new StringBuffer();
      //int _count = 0;

        for (Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {

            sb = e.nextElement().accept(this);

            _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

          //_count++;
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
    public StringBuffer visit(NodeListOptional n) {

        if (n.present()) {

            StringBuffer   _ret   = new StringBuffer();
          //int _count = 0;

            for (Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {

                sb = e.nextElement().accept(this);

                _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

              //_count++;
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
    public StringBuffer visit(NodeOptional n) {

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
    public StringBuffer visit(NodeSequence n) {

        StringBuffer   _ret   = new StringBuffer();
      //int _count = 0;

        for (Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {

            sb = e.nextElement().accept(this);

            _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

          //_count++;
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
    public StringBuffer visit(NodeToken n) {
        return new StringBuffer(n.tokenImage);
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
    public StringBuffer visit(specification n) {

        StringBuffer _ret = new StringBuffer();

        sb = n.f0.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

        sb = n.f1.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

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
    public StringBuffer visit(statement_list n) {

        StringBuffer _ret = new StringBuffer();

        sb = n.f0.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

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
    public StringBuffer visit(statement n) {

        StringBuffer _ret = new StringBuffer();

        sb = n.f0.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

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
    public StringBuffer visit(selection_statement n) {

        StringBuffer _ret = new StringBuffer();

        sb = n.f0.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

        sb = n.f1.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

        sb = n.f2.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

        sb = n.f3.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

        sb = n.f4.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

        sb = n.f5.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

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
    public StringBuffer visit(iteration_statement n) {

        StringBuffer _ret = new StringBuffer();

        sb = n.f0.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

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
    public StringBuffer visit(include_statement n) {

        StringBuffer _ret = new StringBuffer();

        sb = n.f0.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

        sb = n.f1.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

        sb = n.f2.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

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
    public StringBuffer visit(text_statement n) {

        StringBuffer _ret = new StringBuffer();

        sb = n.f0.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

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
    public StringBuffer visit(assignment_statement n) {

        StringBuffer _ret = new StringBuffer();

        sb = n.f0.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

        sb = n.f1.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

        sb = n.f2.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

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
    public StringBuffer visit(identifier_list n) {

        StringBuffer _ret = new StringBuffer();

        sb = n.f0.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

        sb = n.f1.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

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
    public StringBuffer visit(expression_statement n) {

        StringBuffer _ret = new StringBuffer();

        sb = n.f0.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

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
    public StringBuffer visit(assignment_operator n) {

        StringBuffer _ret = new StringBuffer();

        sb = n.f0.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

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
    public StringBuffer visit(logical_or_expression n) {

        StringBuffer _ret = new StringBuffer();

        sb = n.f0.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

        sb = n.f1.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

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
    public StringBuffer visit(logical_and_expression n) {

        StringBuffer _ret = new StringBuffer();

        sb = n.f0.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

        sb = n.f1.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

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
    public StringBuffer visit(equality_expression n) {

        StringBuffer _ret = new StringBuffer();

        sb = n.f0.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

        sb = n.f1.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

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
    public StringBuffer visit(relational_expression n) {

        StringBuffer _ret = new StringBuffer();

        sb = n.f0.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

        sb = n.f1.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

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
    public StringBuffer visit(additive_expression n) {

        StringBuffer _ret = new StringBuffer();

        sb = n.f0.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

        sb = n.f1.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

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
    public StringBuffer visit(multiplicative_expression n) {

        StringBuffer _ret = new StringBuffer();

        sb = n.f0.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

        sb = n.f1.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

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
    public StringBuffer visit(unary_expression n) {

        StringBuffer _ret = new StringBuffer();

        sb = n.f0.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

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
    public StringBuffer visit(unary_operator n) {

        StringBuffer _ret = new StringBuffer();

        sb = n.f0.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

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
    public StringBuffer visit(postfix_expression n) {

        StringBuffer _ret = new StringBuffer();

        sb = n.f0.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

        sb = n.f1.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

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
    public StringBuffer visit(argument_expression_list n) {

        StringBuffer _ret = new StringBuffer();

        sb = n.f0.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

        sb = n.f1.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

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
    public StringBuffer visit(primary_expression n) {

        StringBuffer _ret = new StringBuffer();

        sb = n.f0.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

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
    public StringBuffer visit(constant n) {

        StringBuffer _ret = new StringBuffer();

        sb = n.f0.accept(this);

        _ret.append(sb == null || sb.length() == 0 ? "" : " " + sb.toString());

        return _ret;
    }

}
