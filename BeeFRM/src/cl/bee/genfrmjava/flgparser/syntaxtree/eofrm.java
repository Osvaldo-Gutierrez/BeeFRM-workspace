/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.genfrmjava.flgparser.syntaxtree;

/**
 * Grammar production:
 * f0 -> <END_OF_FORM>
 * f1 -> <NAME>
 * f2 -> <EQUAL>
 * f3 -> <STRING>
 * f4 -> <SEMICOLON>
 */
public class eofrm implements Node {
    private Node parent;
    public NodeToken f0;
    public NodeToken f1;
    public NodeToken f2;
    public NodeToken f3;
    public NodeToken f4;

    public eofrm(NodeToken n0, NodeToken n1, NodeToken n2, NodeToken n3, NodeToken n4) {
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
    }

    public eofrm() {
        f0 = new NodeToken("END_OF_FORM");
        if ( f0 != null ) f0.setParent(this);
        f1 = new NodeToken("NAME");
        if ( f1 != null ) f1.setParent(this);
        f2 = new NodeToken("=");
        if ( f2 != null ) f2.setParent(this);
        f3 = new NodeToken("'");
        if ( f3 != null ) f3.setParent(this);
        f4 = new NodeToken(";");
        if ( f4 != null ) f4.setParent(this);
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

