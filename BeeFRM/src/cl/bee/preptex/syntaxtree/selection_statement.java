/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.preptex.syntaxtree;

/**
 * Grammar production:
 * f0 -> <IF>
 * f1 -> expression_statement()
 * f2 -> [ <THEN> ]
 * f3 -> statement_list()
 * f4 -> [ <ELSE> statement_list() ]
 * f5 -> <END>
 */
public class selection_statement implements Node {
    private Node parent;
    public NodeToken f0;
    public expression_statement f1;
    public NodeOptional f2;
    public statement_list f3;
    public NodeOptional f4;
    public NodeToken f5;

    public selection_statement(NodeToken n0, expression_statement n1, NodeOptional n2, statement_list n3, NodeOptional n4, NodeToken n5) {
        f0 = n0;
        if ( f0 != null ) f0.setParent(this);
        f1 = n1;
        if ( f1 != null ) f1.setParent(this);
        f2 = n2;
        if ( f2 != null ) f2.setParent(this);
        f3 = n3;
        if ( f3 != null ) f3.setParent(this);
        f4 = n4;
        if ( f4 != null ) f4.setParent(this);
        f5 = n5;
        if ( f5 != null ) f5.setParent(this);
    }

    public selection_statement(expression_statement n0, NodeOptional n1, statement_list n2, NodeOptional n3) {
        f0 = new NodeToken("IF");
        if ( f0 != null ) f0.setParent(this);
        f1 = n0;
        if ( f1 != null ) f1.setParent(this);
        f2 = n1;
        if ( f2 != null ) f2.setParent(this);
        f3 = n2;
        if ( f3 != null ) f3.setParent(this);
        f4 = n3;
        if ( f4 != null ) f4.setParent(this);
        f5 = new NodeToken("END");
        if ( f5 != null ) f5.setParent(this);
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

