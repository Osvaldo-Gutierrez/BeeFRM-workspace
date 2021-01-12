/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.perseus.cobolparser.syntaxtree;

/**
 * Grammar production:
 * f0 -> <OPEN>
 * f1 -> ( <INPUT> ( FileName() [ ( <REVERSED> | [ <WITH> ] <NO> <REWIND> ) ] )+ | <OUTPUT> ( FileName() [ [ <WITH> ] <NO> <REWIND> ] )+ | <I_O> ( FileName() )+ | <EXTEND> ( FileName() )+ )+
 */
public class OpenStatement implements Node {
    private Node parent;
    public NodeToken f0;
    public NodeList f1;

    public OpenStatement(NodeToken n0, NodeList n1) {
        f0 = n0;
        if ( f0 != null ) f0.setParent(this);
        f1 = n1;
        if ( f1 != null ) f1.setParent(this);
    }

    public OpenStatement(NodeList n0) {
        f0 = new NodeToken("OPEN");
        if ( f0 != null ) f0.setParent(this);
        f1 = n0;
        if ( f1 != null ) f1.setParent(this);
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

