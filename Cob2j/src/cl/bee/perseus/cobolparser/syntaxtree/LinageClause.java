/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.perseus.cobolparser.syntaxtree;

/**
 * Grammar production:
 * f0 -> <LINAGE>
 * f1 -> [ <IS> ]
 * f2 -> ( DataName() | IntegerConstant() )
 * f3 -> [ <LINES> ]
 * f4 -> ( [ <WITH> ] <FOOTING> [ <AT> ] ( DataName() | IntegerConstant() ) | [ <LINES> ] [ <AT> ] ( <TOP> | <BOTTOM> ) ( DataName() | IntegerConstant() ) )*
 */
public class LinageClause implements Node {
    private Node parent;
    public NodeToken f0;
    public NodeOptional f1;
    public NodeChoice f2;
    public NodeOptional f3;
    public NodeListOptional f4;

    public LinageClause(NodeToken n0, NodeOptional n1, NodeChoice n2, NodeOptional n3, NodeListOptional n4) {
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

    public LinageClause(NodeOptional n0, NodeChoice n1, NodeOptional n2, NodeListOptional n3) {
        f0 = new NodeToken("LINAGE");
        if ( f0 != null ) f0.setParent(this);
        f1 = n0;
        if ( f1 != null ) f1.setParent(this);
        f2 = n1;
        if ( f2 != null ) f2.setParent(this);
        f3 = n2;
        if ( f3 != null ) f3.setParent(this);
        f4 = n3;
        if ( f4 != null ) f4.setParent(this);
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

