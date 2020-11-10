/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.genfrmjava.flgparser.syntaxtree;

/**
 * Grammar production:
 * f0 -> <TEXT>
 * f1 -> <LPAR_ST_TEXT>
 * f2 -> <INTEGER_ST_TEXT>
 * f3 -> <COMMA_ST_TEXT>
 * f4 -> <INTEGER_ST_TEXT>
 * f5 -> <RPAR_ST_TEXT>
 * f6 -> [ <INTEGER_ST_TEXT> ]
 * f7 -> <STRING_ST_TEXT>
 * f8 -> [ <AMPERSAND> <STRING_ST_TEXT> ]
 * f9 -> ( <BOLD_TEXT> | <BLINK> )*
 * f10 -> <SEMICOLON_ST_TEXT>
 */
public class text implements Node {
    private Node parent;
    public NodeToken f0;
    public NodeToken f1;
    public NodeToken f2;
    public NodeToken f3;
    public NodeToken f4;
    public NodeToken f5;
    public NodeOptional f6;
    public NodeToken f7;
    public NodeOptional f8;
    public NodeListOptional f9;
    public NodeToken f10;

    public text(NodeToken n0, NodeToken n1, NodeToken n2, NodeToken n3, NodeToken n4, NodeToken n5, NodeOptional n6, NodeToken n7, NodeOptional n8, NodeListOptional n9, NodeToken n10) {
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
        f8 = n8;
        if ( f8 != null ) f8.setParent(this);
        f9 = n9;
        if ( f9 != null ) f9.setParent(this);
        f10 = n10;
        if ( f10 != null ) f10.setParent(this);
    }

    public text(NodeToken n0, NodeToken n1, NodeOptional n2, NodeOptional n3, NodeListOptional n4) {
        f0 = new NodeToken("TEXT");
        if ( f0 != null ) f0.setParent(this);
        f1 = new NodeToken("(");
        if ( f1 != null ) f1.setParent(this);
        f2 = n0;
        if ( f2 != null ) f2.setParent(this);
        f3 = new NodeToken(",");
        if ( f3 != null ) f3.setParent(this);
        f4 = n1;
        if ( f4 != null ) f4.setParent(this);
        f5 = new NodeToken(")");
        if ( f5 != null ) f5.setParent(this);
        f6 = n2;
        if ( f6 != null ) f6.setParent(this);
        f7 = new NodeToken("'");
        if ( f7 != null ) f7.setParent(this);
        f8 = n3;
        if ( f8 != null ) f8.setParent(this);
        f9 = n4;
        if ( f9 != null ) f9.setParent(this);
        f10 = new NodeToken(";");
        if ( f10 != null ) f10.setParent(this);
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

