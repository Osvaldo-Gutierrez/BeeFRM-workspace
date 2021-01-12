/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.perseus.cobolparser.syntaxtree;

/**
 * Grammar production:
 * f0 -> <OCCURS>
 * f1 -> IntegerConstant()
 * f2 -> [ <TO> IntegerConstant() ]
 * f3 -> [ <TIMES> ]
 * f4 -> [ <DEPENDING> [ <ON> ] Identifier() ]
 * f5 -> ( ( <ASCENDING> | <DESCENDING> ) [ <KEY> ] [ <IS> ] ( Identifier() )+ )*
 * f6 -> [ <INDEXED> [ <BY> ] IndexName() ( [ <COMMACHAR> ] IndexName() )* ]
 */
public class DataOccursClause implements Node {
    private Node parent;
    public NodeToken f0;
    public IntegerConstant f1;
    public NodeOptional f2;
    public NodeOptional f3;
    public NodeOptional f4;
    public NodeListOptional f5;
    public NodeOptional f6;

    public DataOccursClause(NodeToken n0, IntegerConstant n1, NodeOptional n2, NodeOptional n3, NodeOptional n4, NodeListOptional n5, NodeOptional n6) {
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

    public DataOccursClause(IntegerConstant n0, NodeOptional n1, NodeOptional n2, NodeOptional n3, NodeListOptional n4, NodeOptional n5) {
        f0 = new NodeToken("OCCURS");
        if ( f0 != null ) f0.setParent(this);
        f1 = n0;
        if ( f1 != null ) f1.setParent(this);
        f2 = n1;
        if ( f2 != null ) f2.setParent(this);
        f3 = n2;
        if ( f3 != null ) f3.setParent(this);
        f4 = n3;
        if ( f4 != null ) f4.setParent(this);
        f5 = n4;
        if ( f5 != null ) f5.setParent(this);
        f6 = n5;
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

