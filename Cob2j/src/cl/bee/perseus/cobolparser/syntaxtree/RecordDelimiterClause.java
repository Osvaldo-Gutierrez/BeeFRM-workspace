/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.perseus.cobolparser.syntaxtree;

/**
 * Grammar production:
 * f0 -> <RECORD>
 * f1 -> <DELIMITER>
 * f2 -> [ <IS> ]
 * f3 -> ( <STANDARD_1> | <IMPLICIT> | AssignmentName() )
 */
public class RecordDelimiterClause implements Node {
    private Node parent;
    public NodeToken f0;
    public NodeToken f1;
    public NodeOptional f2;
    public NodeChoice f3;

    public RecordDelimiterClause(NodeToken n0, NodeToken n1, NodeOptional n2, NodeChoice n3) {
        f0 = n0;
        if ( f0 != null ) f0.setParent(this);
        f1 = n1;
        if ( f1 != null ) f1.setParent(this);
        f2 = n2;
        if ( f2 != null ) f2.setParent(this);
        f3 = n3;
        if ( f3 != null ) f3.setParent(this);
    }

    public RecordDelimiterClause(NodeOptional n0, NodeChoice n1) {
        f0 = new NodeToken("RECORD");
        if ( f0 != null ) f0.setParent(this);
        f1 = new NodeToken("DELIMITER");
        if ( f1 != null ) f1.setParent(this);
        f2 = n0;
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

