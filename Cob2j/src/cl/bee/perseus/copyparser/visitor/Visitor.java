/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.perseus.copyparser.visitor;
import cl.bee.perseus.copyparser.syntaxtree.*;
import java.util.*;

/**
 * All void visitors must implement this interface.
 */

public interface Visitor {

   //
   // void Auto class visitors
   //

   public void visit(NodeList n);
   public void visit(NodeListOptional n);
   public void visit(NodeOptional n);
   public void visit(NodeSequence n);
   public void visit(NodeToken n);

    //
    // User-generated visitor methods below
    //

    /**
     * f0 -> <COPY>
     * f1 -> ( <IDENTIFIER> | Literal() )
     * f2 -> [ ( <OF> | <IN> ) ( <IDENTIFIER> | Literal() ) ]
     * f3 -> [ <SUPPRESS> ]
     * f4 -> [ <REPLACING> ( CopyOperand() <BY> CopyOperand() )+ ]
     * f5 -> <DOTCHAR>
     * f6 -> <EOF>
     */
    public void visit(CopyStatement n);

    /**
     * f0 -> [ <ALL> ]
     * f1 -> ( NonNumericConstant() | NumericConstant() | FigurativeConstant() )
     */
    public void visit(Literal n);

    /**
     * f0 -> ( ( <QUOTEDSTRING> )+ | <HEXNUMBER> )
     */
    public void visit(NonNumericConstant n);

    /**
     * f0 -> ( <PLUSCHAR> | <MINUSCHAR> )?
     * f1 -> ( IntegerConstant() | <REAL> )
     */
    public void visit(NumericConstant n);

    /**
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
     */
    public void visit(FigurativeConstant n);

    /**
     * f0 -> <INTEGER>
     */
    public void visit(IntegerConstant n);

    /**
     * f0 -> ( <QUOTEDPSEUDOTEXT> | <IDENTIFIER> )
     */
    public void visit(CopyOperand n);

}

