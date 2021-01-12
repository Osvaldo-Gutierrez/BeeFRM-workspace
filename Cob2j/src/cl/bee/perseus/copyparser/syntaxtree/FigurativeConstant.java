/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.perseus.copyparser.syntaxtree;

/**
 * Grammar production:
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
public class FigurativeConstant implements Node {
    public NodeChoice f0;

    public FigurativeConstant(NodeChoice n0) {
        f0 = n0;
    }

    public void accept(cl.bee.perseus.copyparser.visitor.Visitor v) {
        v.visit(this);
    }
    public <R,A> R accept(cl.bee.perseus.copyparser.visitor.GJVisitor<R,A> v, A argu) {
        return v.visit(this,argu);
    }
    public <R> R accept(cl.bee.perseus.copyparser.visitor.GJNoArguVisitor<R> v) {
        return v.visit(this);
    }
    public <A> void accept(cl.bee.perseus.copyparser.visitor.GJVoidVisitor<A> v, A argu) {
        v.visit(this,argu);
    }
}

