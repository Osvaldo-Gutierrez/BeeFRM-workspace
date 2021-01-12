/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.perseus.cobolparser.syntaxtree;

/**
 * Grammar production:
 * f0 -> <CD>
 * f1 -> CdName()
 * f2 -> [ <FOR> ]
 * f3 -> [ <INITIAL> ]
 * f4 -> <I_O>
 * f5 -> ( CommunicationIOClause() )*
 * f6 -> ( DataName() )*
 */
public class CommunicationIOEntry implements Node {
    private Node parent;
    public NodeToken f0;
    public CdName f1;
    public NodeOptional f2;
    public NodeOptional f3;
    public NodeToken f4;
    public NodeListOptional f5;
    public NodeListOptional f6;

    public CommunicationIOEntry(NodeToken n0, CdName n1, NodeOptional n2, NodeOptional n3, NodeToken n4, NodeListOptional n5, NodeListOptional n6) {
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
        f6 = n6;
        if ( f6 != null ) f6.setParent(this);
    }

    public CommunicationIOEntry(CdName n0, NodeOptional n1, NodeOptional n2, NodeListOptional n3, NodeListOptional n4) {
        f0 = new NodeToken("CD");
        if ( f0 != null ) f0.setParent(this);
        f1 = n0;
        if ( f1 != null ) f1.setParent(this);
        f2 = n1;
        if ( f2 != null ) f2.setParent(this);
        f3 = n2;
        if ( f3 != null ) f3.setParent(this);
        f4 = new NodeToken("I-O");
        if ( f4 != null ) f4.setParent(this);
        f5 = n3;
        if ( f5 != null ) f5.setParent(this);
        f6 = n4;
        if ( f6 != null ) f6.setParent(this);
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

