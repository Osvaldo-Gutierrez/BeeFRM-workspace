/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.perseus.cobolparser.syntaxtree;

/**
 * Grammar production:
 * f0 -> <MULTIPLY>
 * f1 -> ( Identifier() | Literal() )
 * f2 -> <BY>
 * f3 -> ( ( Identifier() | Literal() ) [ <ROUNDED> ] )+
 * f4 -> [ <GIVING> ( Identifier() [ <ROUNDED> ] )+ ]
 * f5 -> [ [ <ON> ] <SIZE> <ERROR> StatementList() ]
 * f6 -> [ <NOT> [ <ON> ] <SIZE> <ERROR> StatementList() ]
 * f7 -> [ <END_MULTIPLY> ]
 */
public class MultiplyStatement implements Node {
    private Node parent;
    public NodeToken f0;
    public NodeChoice f1;
    public NodeToken f2;
    public NodeList f3;
    public NodeOptional f4;
    public NodeOptional f5;
    public NodeOptional f6;
    public NodeOptional f7;

    public MultiplyStatement(NodeToken n0, NodeChoice n1, NodeToken n2, NodeList n3, NodeOptional n4, NodeOptional n5, NodeOptional n6, NodeOptional n7) {
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

    public MultiplyStatement(NodeChoice n0, NodeList n1, NodeOptional n2, NodeOptional n3, NodeOptional n4, NodeOptional n5) {
        f0 = new NodeToken("MULTIPLY");
        if ( f0 != null ) f0.setParent(this);
        f1 = n0;
        if ( f1 != null ) f1.setParent(this);
        f2 = new NodeToken("BY");
        if ( f2 != null ) f2.setParent(this);
        f3 = n1;
        if ( f3 != null ) f3.setParent(this);
        f4 = n2;
        if ( f4 != null ) f4.setParent(this);
        f5 = n3;
        if ( f5 != null ) f5.setParent(this);
        f6 = n4;
        if ( f6 != null ) f6.setParent(this);
        f7 = n5;
        if ( f7 != null ) f7.setParent(this);
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

