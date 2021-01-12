/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.perseus.cobolparser.syntaxtree;

/**
 * Grammar production:
 * f0 -> <RERUN>
 * f1 -> [ <ON> ( AssignmentName() | FileName() ) ]
 * f2 -> <EVERY>
 * f3 -> ( Rerun2() | IntegerConstant() [ <CLOCK_UNITS> ] )
 */
public class RerunClause implements Node {
    private Node parent;
    public NodeToken f0;
    public NodeOptional f1;
    public NodeToken f2;
    public NodeChoice f3;

    public RerunClause(NodeToken n0, NodeOptional n1, NodeToken n2, NodeChoice n3) {
        f0 = n0;
        if ( f0 != null ) f0.setParent(this);
        f1 = n1;
        if ( f1 != null ) f1.setParent(this);
        f2 = n2;
        if ( f2 != null ) f2.setParent(this);
        f3 = n3;
        if ( f3 != null ) f3.setParent(this);
    }

    public RerunClause(NodeOptional n0, NodeChoice n1) {
        f0 = new NodeToken("RERUN");
        if ( f0 != null ) f0.setParent(this);
        f1 = n0;
        if ( f1 != null ) f1.setParent(this);
        f2 = new NodeToken("EVERY");
        if ( f2 != null ) f2.setParent(this);
        f3 = n1;
        if ( f3 != null ) f3.setParent(this);
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

