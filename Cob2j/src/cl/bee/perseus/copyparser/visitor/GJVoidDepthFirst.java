/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.perseus.copyparser.visitor;


import java.io.*;

import java.util.*;

import cl.bee.perseus.copyparser.syntaxtree.*;


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
     * f0 -> <COPY>
     * f1 -> ( <IDENTIFIER> | Literal() )
     * f2 -> [ ( <OF> | <IN> ) ( <IDENTIFIER> | Literal() ) ]
     * f3 -> [ <SUPPRESS> ]
     * f4 -> [ <REPLACING> ( CopyOperand() <BY> CopyOperand() )+ ]
     * f5 -> <DOTCHAR>
     * f6 -> <EOF>
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     */
    public void visit(CopyStatement n, A argu) {

        n.f0.accept(this, argu);
        n.f1.accept(this, argu);
        n.f2.accept(this, argu);
        n.f3.accept(this, argu);
        n.f4.accept(this, argu);
        n.f5.accept(this, argu);
        n.f6.accept(this, argu);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> [ <ALL> ]
     * f1 -> ( NonNumericConstant() | NumericConstant() | FigurativeConstant() )
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     */
    public void visit(Literal n, A argu) {

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
     * f0 -> ( ( <QUOTEDSTRING> )+ | <HEXNUMBER> )
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     */
    public void visit(NonNumericConstant n, A argu) {
        n.f0.accept(this, argu);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( <PLUSCHAR> | <MINUSCHAR> )?
     * f1 -> ( IntegerConstant() | <REAL> )
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     */
    public void visit(NumericConstant n, A argu) {

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
     * f0 -> <ZERO>
     *       | <ZEROS>
     *       | <ZEROES>
     *       | <SPACE>
     *       | <SPACES>
     *       | <HIGH_VALUE>
     *       | <HIGH_VALUES>
     *       | <LOW_VALUE>
     *       | <LOW_VALUES>
     *       | <QUOTE>
     *       | <QUOTES>
     *       | <NULL>
     *       | <NULLS>
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     */
    public void visit(FigurativeConstant n, A argu) {
        n.f0.accept(this, argu);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <INTEGER>
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     */
    public void visit(IntegerConstant n, A argu) {
        n.f0.accept(this, argu);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( <QUOTEDPSEUDOTEXT> | <IDENTIFIER> )
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     */
    public void visit(CopyOperand n, A argu) {
        n.f0.accept(this, argu);
    }

}
