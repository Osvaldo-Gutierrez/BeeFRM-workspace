/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.perseus.cobolparser.syntaxtree;

/**
 * Grammar production:
 * f0 -> <PROCEDURE>
 * f1 -> <DIVISION>
 * f2 -> [ ConventionName() ]
 * f3 -> [ <USING> ( DataName() )+ ]
 * f4 -> <DOT>
 * f5 -> [ Declaratives() ]
 * f6 -> ProcedureBody()
 */
public class ProcedureDivision implements Node {
    private Node parent;
    public NodeToken f0;
    public NodeToken f1;
    public NodeOptional f2;
    public NodeOptional f3;
    public NodeToken f4;
    public NodeOptional f5;
    public ProcedureBody f6;

    public ProcedureDivision(NodeToken n0, NodeToken n1, NodeOptional n2, NodeOptional n3, NodeToken n4, NodeOptional n5, ProcedureBody n6) {
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

    public ProcedureDivision(NodeOptional n0, NodeOptional n1, NodeToken n2, NodeOptional n3, ProcedureBody n4) {
        f0 = new NodeToken("PROCEDURE");
        if ( f0 != null ) f0.setParent(this);
        f1 = new NodeToken("DIVISION");
        if ( f1 != null ) f1.setParent(this);
        f2 = n0;
        if ( f2 != null ) f2.setParent(this);
        f3 = n1;
        if ( f3 != null ) f3.setParent(this);
        f4 = n2;
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

