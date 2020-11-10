/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.genfrmjava.flgparser.syntaxtree;

/**
 * Grammar production:
 * f0 -> <NAMED_DATA>
 * f1 -> ( <INDEX_ST_NAMED_DATA> <EQUAL_ST_NAMED_DATA> <INTEGER_ST_NAMED_DATA> | <NAME_ST_NAMED_DATA> <EQUAL_ST_NAMED_DATA> <STRING_ST_NAMED_DATA> | <DATA> <EQUAL_ST_NAMED_DATA> <STRING_ST_NAMED_DATA> )+
 * f2 -> <SEMICOLON_ST_NAMED_DATA>
 */
public class ndata implements Node {
    private Node parent;
    public NodeToken f0;
    public NodeList f1;
    public NodeToken f2;

    public ndata(NodeToken n0, NodeList n1, NodeToken n2) {
        f0 = n0;
        if ( f0 != null ) f0.setParent(this);
        f1 = n1;
        if ( f1 != null ) f1.setParent(this);
        f2 = n2;
        if ( f2 != null ) f2.setParent(this);
    }

    public ndata(NodeList n0) {
        f0 = new NodeToken("NAMED_DATA");
        if ( f0 != null ) f0.setParent(this);
        f1 = n0;
        if ( f1 != null ) f1.setParent(this);
        f2 = new NodeToken(";");
        if ( f2 != null ) f2.setParent(this);
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

