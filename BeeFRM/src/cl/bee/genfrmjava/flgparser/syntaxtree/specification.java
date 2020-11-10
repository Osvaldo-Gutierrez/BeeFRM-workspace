/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.genfrmjava.flgparser.syntaxtree;

/**
 * Grammar production:
 * f0 -> form()
 * f1 -> ( text() )+
 * f2 -> adef()
 * f3 -> ( field() )+
 * f4 -> order()
 * f5 -> [ ( ndata() )+ ]
 * f6 -> eofrm()
 * f7 -> <EOF>
 */
public class specification implements Node {
    private Node parent;
    public form f0;
    public NodeList f1;
    public adef f2;
    public NodeList f3;
    public order f4;
    public NodeOptional f5;
    public eofrm f6;
    public NodeToken f7;

    public specification(form n0, NodeList n1, adef n2, NodeList n3, order n4, NodeOptional n5, eofrm n6, NodeToken n7) {
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
        f7 = n7;
        if ( f7 != null ) f7.setParent(this);
    }

    public specification(form n0, NodeList n1, adef n2, NodeList n3, order n4, NodeOptional n5, eofrm n6) {
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
        f7 = new NodeToken("");
        if ( f7 != null ) f7.setParent(this);
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

