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
 * All GJ void visitors must implement this interface.
 */

public interface GJVoidVisitor<A> {

   //
   // GJ void Auto class visitors
   //

   public void visit(NodeList n, A argu);
   public void visit(NodeListOptional n, A argu);
   public void visit(NodeOptional n, A argu);
   public void visit(NodeSequence n, A argu);
   public void visit(NodeToken n, A argu);

    //
    // User-generated visitor methods below
    //

    /**
     * f0 -> statement_list()
     * f1 -> <EOF>
     */
    public void visit(specification n, A argu);

    /**
     * f0 -> ( statement() )*
     */
    public void visit(statement_list n, A argu);

    /**
     * f0 -> assignment_statement()
     *       | selection_statement()
     *       | iteration_statement()
     *       | include_statement()
     *       | text_statement()
     */
    public void visit(statement n, A argu);

    /**
     * f0 -> <IF>
     * f1 -> expression_statement()
     * f2 -> [ <THEN> ]
     * f3 -> statement_list()
     * f4 -> [ <ELSE> statement_list() ]
     * f5 -> <END>
     */
    public void visit(selection_statement n, A argu);

    /**
     * f0 -> <WHILE> expression_statement() statement_list() <END>
     *       | <FOR> <EACH> <IDENTIFIER> <IN> <LPAREN> argument_expression_list() <RPAREN> statement_list() <END>
     *       | <FOR> <IDENTIFIER> <EQUAL> expression_statement() <TO> expression_statement() [ <STEP> expression_statement() ] statement_list() <NEXT> <IDENTIFIER>
     */
    public void visit(iteration_statement n, A argu);

    /**
     * f0 -> <INCLUDE>
     * f1 -> [ identifier_list() <OF> ]
     * f2 -> <STRING>
     */
    public void visit(include_statement n, A argu);

    /**
     * f0 -> <TEXT>
     */
    public void visit(text_statement n, A argu);

    /**
     * f0 -> unary_expression()
     * f1 -> assignment_operator()
     * f2 -> expression_statement()
     */
    public void visit(assignment_statement n, A argu);

    /**
     * f0 -> <IDENTIFIER>
     * f1 -> ( <COMMA> <IDENTIFIER> )*
     */
    public void visit(identifier_list n, A argu);

    /**
     * f0 -> logical_or_expression()
     */
    public void visit(expression_statement n, A argu);

    /**
     * f0 -> <EQUAL>
     *       | <PLUSASSIGN>
     */
    public void visit(assignment_operator n, A argu);

    /**
     * f0 -> logical_and_expression()
     * f1 -> ( <OR> logical_and_expression() )*
     */
    public void visit(logical_or_expression n, A argu);

    /**
     * f0 -> equality_expression()
     * f1 -> ( <AND> equality_expression() )*
     */
    public void visit(logical_and_expression n, A argu);

    /**
     * f0 -> relational_expression()
     * f1 -> [ ( <EQUAL> | <NE> ) relational_expression() ]
     */
    public void visit(equality_expression n, A argu);

    /**
     * f0 -> additive_expression()
     * f1 -> [ ( <LT> | <GT> | <LE> | <GE> ) additive_expression() ]
     */
    public void visit(relational_expression n, A argu);

    /**
     * f0 -> multiplicative_expression()
     * f1 -> ( ( <PLUS> | <MINUS> ) multiplicative_expression() )*
     */
    public void visit(additive_expression n, A argu);

    /**
     * f0 -> unary_expression()
     * f1 -> ( ( <STAR> | <SLASH> ) unary_expression() )*
     */
    public void visit(multiplicative_expression n, A argu);

    /**
     * f0 -> postfix_expression()
     *       | unary_operator() unary_expression()
     */
    public void visit(unary_expression n, A argu);

    /**
     * f0 -> <MINUS>
     *       | <NOT>
     */
    public void visit(unary_operator n, A argu);

    /**
     * f0 -> primary_expression()
     * f1 -> [ <LPAREN> argument_expression_list() <RPAREN> ]
     */
    public void visit(postfix_expression n, A argu);

    /**
     * f0 -> expression_statement()
     * f1 -> ( <COMMA> expression_statement() )*
     */
    public void visit(argument_expression_list n, A argu);

    /**
     * f0 -> <IDENTIFIER>
     *       | constant()
     *       | <LPAREN> expression_statement() <RPAREN>
     *       | <LBRACE> expression_statement() <RBRACE>
     */
    public void visit(primary_expression n, A argu);

    /**
     * f0 -> <DOUBLE>
     *       | <STRING>
     *       | <TRUE>
     *       | <FALSE>
     */
    public void visit(constant n, A argu);

}

