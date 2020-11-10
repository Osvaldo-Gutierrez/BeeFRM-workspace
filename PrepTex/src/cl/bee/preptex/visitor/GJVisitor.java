/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.preptex.visitor;
import cl.bee.preptex.syntaxtree.*;
import java.util.*;

/**
 * All GJ visitors must implement this interface.
 */

public interface GJVisitor<R,A> {

   //
   // GJ Auto class visitors
   //

   public R visit(NodeList n, A argu);
   public R visit(NodeListOptional n, A argu);
   public R visit(NodeOptional n, A argu);
   public R visit(NodeSequence n, A argu);
   public R visit(NodeToken n, A argu);

    //
    // User-generated visitor methods below
    //

    /**
     * f0 -> statement_list()
     * f1 -> <EOF>
     */
    public R visit(specification n, A argu);

    /**
     * f0 -> ( statement() )*
     */
    public R visit(statement_list n, A argu);

    /**
     * f0 -> assignment_statement()
     *       | selection_statement()
     *       | iteration_statement()
     *       | include_statement()
     *       | text_statement()
     */
    public R visit(statement n, A argu);

    /**
     * f0 -> <IF>
     * f1 -> expression_statement()
     * f2 -> [ <THEN> ]
     * f3 -> statement_list()
     * f4 -> [ <ELSE> statement_list() ]
     * f5 -> <END>
     */
    public R visit(selection_statement n, A argu);

    /**
     * f0 -> <WHILE> expression_statement() statement_list() <END>
     *       | <FOR> <EACH> <IDENTIFIER> <IN> <LPAREN> argument_expression_list() <RPAREN> statement_list() <END>
     *       | <FOR> <IDENTIFIER> <EQUAL> expression_statement() <TO> expression_statement() [ <STEP> expression_statement() ] statement_list() <NEXT> <IDENTIFIER>
     */
    public R visit(iteration_statement n, A argu);

    /**
     * f0 -> <INCLUDE>
     * f1 -> [ identifier_list() <OF> ]
     * f2 -> <STRING>
     */
    public R visit(include_statement n, A argu);

    /**
     * f0 -> <TEXT>
     */
    public R visit(text_statement n, A argu);

    /**
     * f0 -> unary_expression()
     * f1 -> assignment_operator()
     * f2 -> expression_statement()
     */
    public R visit(assignment_statement n, A argu);

    /**
     * f0 -> <IDENTIFIER>
     * f1 -> ( <COMMA> <IDENTIFIER> )*
     */
    public R visit(identifier_list n, A argu);

    /**
     * f0 -> logical_or_expression()
     */
    public R visit(expression_statement n, A argu);

    /**
     * f0 -> <EQUAL>
     *       | <PLUSASSIGN>
     */
    public R visit(assignment_operator n, A argu);

    /**
     * f0 -> logical_and_expression()
     * f1 -> ( <OR> logical_and_expression() )*
     */
    public R visit(logical_or_expression n, A argu);

    /**
     * f0 -> equality_expression()
     * f1 -> ( <AND> equality_expression() )*
     */
    public R visit(logical_and_expression n, A argu);

    /**
     * f0 -> relational_expression()
     * f1 -> [ ( <EQUAL> | <NE> ) relational_expression() ]
     */
    public R visit(equality_expression n, A argu);

    /**
     * f0 -> additive_expression()
     * f1 -> [ ( <LT> | <GT> | <LE> | <GE> ) additive_expression() ]
     */
    public R visit(relational_expression n, A argu);

    /**
     * f0 -> multiplicative_expression()
     * f1 -> ( ( <PLUS> | <MINUS> ) multiplicative_expression() )*
     */
    public R visit(additive_expression n, A argu);

    /**
     * f0 -> unary_expression()
     * f1 -> ( ( <STAR> | <SLASH> ) unary_expression() )*
     */
    public R visit(multiplicative_expression n, A argu);

    /**
     * f0 -> postfix_expression()
     *       | unary_operator() unary_expression()
     */
    public R visit(unary_expression n, A argu);

    /**
     * f0 -> <MINUS>
     *       | <NOT>
     */
    public R visit(unary_operator n, A argu);

    /**
     * f0 -> primary_expression()
     * f1 -> [ <LPAREN> argument_expression_list() <RPAREN> ]
     */
    public R visit(postfix_expression n, A argu);

    /**
     * f0 -> expression_statement()
     * f1 -> ( <COMMA> expression_statement() )*
     */
    public R visit(argument_expression_list n, A argu);

    /**
     * f0 -> <IDENTIFIER>
     *       | constant()
     *       | <LPAREN> expression_statement() <RPAREN>
     *       | <LBRACE> expression_statement() <RBRACE>
     */
    public R visit(primary_expression n, A argu);

    /**
     * f0 -> <DOUBLE>
     *       | <STRING>
     *       | <TRUE>
     *       | <FALSE>
     */
    public R visit(constant n, A argu);

}
