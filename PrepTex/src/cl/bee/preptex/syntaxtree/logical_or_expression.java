/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.preptex.syntaxtree;

/**
 * Grammar production:
 * f0 -> logical_and_expression()
 * f1 -> ( <OR> logical_and_expression() )*
 */
public class logical_or_expression implements Node {
    private Node parent;
    public logical_and_expression f0;
    public NodeListOptional f1;

    public logical_or_expression(logical_and_expression n0, NodeListOptional n1) {
        f0 = n0;
        if ( f0 != null ) f0.setParent(this);
        f1 = n1;
        if ( f1 != null ) f1.setParent(this);
    }

    public void accept(cl.bee.preptex.visitor.Visitor v) {
        v.visit(this);
    }
    public <R,A> R accept(cl.bee.preptex.visitor.GJVisitor<R,A> v, A argu) {
        return v.visit(this,argu);
    }
    public <R> R accept(cl.bee.preptex.visitor.GJNoArguVisitor<R> v) {
        return v.visit(this);
    }
    public <A> void accept(cl.bee.preptex.visitor.GJVoidVisitor<A> v, A argu) {
        v.visit(this,argu);
    }
    public void setParent(Node n) { parent = n; }
    public Node getParent()       { return parent; }
}

