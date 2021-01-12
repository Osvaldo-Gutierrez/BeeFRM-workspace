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
 * All GJ visitors with no argument must implement this interface.
 */

public interface GJNoArguVisitor<R> {

   //
   // GJ Auto class visitors with no argument
   //

   public R visit(NodeList n);
   public R visit(NodeListOptional n);
   public R visit(NodeOptional n);
   public R visit(NodeSequence n);
   public R visit(NodeToken n);

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
    public R visit(CopyStatement n);

    /**
     * f0 -> [ <ALL> ]
     * f1 -> ( NonNumericConstant() | NumericConstant() | FigurativeConstant() )
     */
    public R visit(Literal n);

    /**
     * f0 -> ( ( <QUOTEDSTRING> )+ | <HEXNUMBER> )
     */
    public R visit(NonNumericConstant n);

    /**
     * f0 -> ( <PLUSCHAR> | <MINUSCHAR> )?
     * f1 -> ( IntegerConstant() | <REAL> )
     */
    public R visit(NumericConstant n);

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
    public R visit(FigurativeConstant n);

    /**
     * f0 -> <INTEGER>
     */
    public R visit(IntegerConstant n);

    /**
     * f0 -> ( <QUOTEDPSEUDOTEXT> | <IDENTIFIER> )
     */
    public R visit(CopyOperand n);

}

