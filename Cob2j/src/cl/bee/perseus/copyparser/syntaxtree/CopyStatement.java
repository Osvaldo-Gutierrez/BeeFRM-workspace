/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.perseus.copyparser.syntaxtree;

/**
 * Grammar production:
 * f0 -> <COPY>
 * f1 -> ( <IDENTIFIER> | Literal() )
 * f2 -> [ ( <OF> | <IN> ) ( <IDENTIFIER> | Literal() ) ]
 * f3 -> [ <SUPPRESS> ]
 * f4 -> [ <REPLACING> ( CopyOperand() <BY> CopyOperand() )+ ]
 * f5 -> <DOTCHAR>
 * f6 -> <EOF>
 */
public class CopyStatement implements Node {
    public NodeToken f0;
    public NodeChoice f1;
    public NodeOptional f2;
    public NodeOptional f3;
    public NodeOptional f4;
    public NodeToken f5;
    public NodeToken f6;

    public CopyStatement(NodeToken n0, NodeChoice n1, NodeOptional n2, NodeOptional n3, NodeOptional n4, NodeToken n5, NodeToken n6) {
        f0 = n0;
        f1 = n1;
        f2 = n2;
        f3 = n3;
        f4 = n4;
        f5 = n5;
        f6 = n6;
    }

    public CopyStatement(NodeChoice n0, NodeOptional n1, NodeOptional n2, NodeOptional n3) {
        f0 = new NodeToken("COPY");
        f1 = n0;
        f2 = n1;
        f3 = n2;
        f4 = n3;
        f5 = new NodeToken(".");
        f6 = new NodeToken("");
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

