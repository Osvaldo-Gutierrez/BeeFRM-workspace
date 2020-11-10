/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.genfrmjava.flgparser.syntaxtree;

/**
 * Grammar production:
 * f0 -> <ORDER>
 * f1 -> <BEGIN_WITH>
 * f2 -> <EQUAL_ST_ORDER>
 * f3 -> <INTEGER_ST_ORDER>
 * f4 -> ( <NAME_ST_ORDER> <EQUAL_ST_ORDER> <STRING_ST_ORDER> )+
 * f5 -> <SEMICOLON_ST_ORDER>
 */
public class order implements Node {
    private Node parent;
    public NodeToken f0;
    public NodeToken f1;
    public NodeToken f2;
    public NodeToken f3;
    public NodeList f4;
    public NodeToken f5;

    public order(NodeToken n0, NodeToken n1, NodeToken n2, NodeToken n3, NodeList n4, NodeToken n5) {
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

    public order(NodeToken n0, NodeList n1) {
        f0 = new NodeToken("ORDER");
        if ( f0 != null ) f0.setParent(this);
        f1 = new NodeToken("BEGIN_WITH");
        if ( f1 != null ) f1.setParent(this);
        f2 = new NodeToken("=");
        if ( f2 != null ) f2.setParent(this);
        f3 = n0;
        if ( f3 != null ) f3.setParent(this);
        f4 = n1;
        if ( f4 != null ) f4.setParent(this);
        f5 = new NodeToken(";");
        if ( f5 != null ) f5.setParent(this);
    }

    public void accept(cl.bee.genfrmjava.flgparser.visitor.Visitor v) {
        v.visit(this);
    }
    public <R,A> R accept(cl.bee.genfrmjava.flgparser.visitor.GJVisitor<R,A> v, A argu) {
        return v.visit(this,argu);
    }
    public <R> R accept(cl.bee.genfrmjava.flgparser.visitor.GJNoArguVisitor<R> v) {
        return v.visit(this);
    }
    public <A> void accept(cl.bee.genfrmjava.flgparser.visitor.GJVoidVisitor<A> v, A argu) {
        v.visit(this,argu);
    }
    public void setParent(Node n) { parent = n; }
    public Node getParent()       { return parent; }
}

