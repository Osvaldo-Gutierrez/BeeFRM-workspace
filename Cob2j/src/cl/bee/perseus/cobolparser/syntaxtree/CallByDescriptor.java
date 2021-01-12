/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.perseus.cobolparser.syntaxtree;

/**
 * Grammar production:
 * f0 -> [ <BY> ]
 * f1 -> <DESCRIPTOR>
 * f2 -> ( <ADDRESS> <OF> Identifier() | Identifier() | FileName() | <OMITTED> )+
 */
public class CallByDescriptor implements Node {
    private Node parent;
    public NodeOptional f0;
    public NodeToken f1;
    public NodeList f2;

    public CallByDescriptor(NodeOptional n0, NodeToken n1, NodeList n2) {
        f0 = n0;
        if ( f0 != null ) f0.setParent(this);
        f1 = n1;
        if ( f1 != null ) f1.setParent(this);
        f2 = n2;
        if ( f2 != null ) f2.setParent(this);
    }

    public CallByDescriptor(NodeOptional n0, NodeList n1) {
        f0 = n0;
        if ( f0 != null ) f0.setParent(this);
        f1 = new NodeToken("DESCRIPTOR");
        if ( f1 != null ) f1.setParent(this);
        f2 = n1;
        if ( f2 != null ) f2.setParent(this);
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

