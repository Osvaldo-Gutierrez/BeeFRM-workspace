/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.perseus.cobolparser.syntaxtree;

/**
 * Grammar production:
 * f0 -> <LPARENCHAR>
 * f1 -> ArithmeticExpression()
 * f2 -> ( [ <COMMACHAR> ] ArithmeticExpression() )*
 * f3 -> <RPARENCHAR>
 */
public class Subscript implements Node {
    private Node parent;
    public NodeToken f0;
    public ArithmeticExpression f1;
    public NodeListOptional f2;
    public NodeToken f3;

    public Subscript(NodeToken n0, ArithmeticExpression n1, NodeListOptional n2, NodeToken n3) {
        f0 = n0;
        if ( f0 != null ) f0.setParent(this);
        f1 = n1;
        if ( f1 != null ) f1.setParent(this);
        f2 = n2;
        if ( f2 != null ) f2.setParent(this);
        f3 = n3;
        if ( f3 != null ) f3.setParent(this);
    }

    public Subscript(ArithmeticExpression n0, NodeListOptional n1) {
        f0 = new NodeToken("(");
        if ( f0 != null ) f0.setParent(this);
        f1 = n0;
        if ( f1 != null ) f1.setParent(this);
        f2 = n1;
        if ( f2 != null ) f2.setParent(this);
        f3 = new NodeToken(")");
        if ( f3 != null ) f3.setParent(this);
    }

    public void accept(cl.bee.perseus.cobolparser.visitor.Visitor v) {
        v.visit(this);
    }
    public <R,A> R accept(cl.bee.perseus.cobolparser.visitor.GJVisitor<R,A> v, A argu) {
        return v.visit(this,argu);
    }
    public <R> R accept(cl.bee.perseus.cobolparser.visitor.GJNoArguVisitor<R> v) {
        return v.visit(this);
    }
    public <A> void accept(cl.bee.perseus.cobolparser.visitor.GJVoidVisitor<A> v, A argu) {
        v.visit(this,argu);
    }
    public void setParent(Node n) { parent = n; }
    public Node getParent()       { return parent; }
}
