/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.perseus.cobolparser.syntaxtree;

/**
 * Grammar production:
 * f0 -> Identifier()
 * f1 -> <FROM>
 * f2 -> ( Identifier() | Literal() )
 * f3 -> <BY>
 * f4 -> ( Identifier() | Literal() )
 * f5 -> PerformUntilClause()
 */
public class PerformVaryingPhrase implements Node {
    private Node parent;
    public Identifier f0;
    public NodeToken f1;
    public NodeChoice f2;
    public NodeToken f3;
    public NodeChoice f4;
    public PerformUntilClause f5;

    public PerformVaryingPhrase(Identifier n0, NodeToken n1, NodeChoice n2, NodeToken n3, NodeChoice n4, PerformUntilClause n5) {
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
    }

    public PerformVaryingPhrase(Identifier n0, NodeChoice n1, NodeChoice n2, PerformUntilClause n3) {
        f0 = n0;
        if ( f0 != null ) f0.setParent(this);
        f1 = new NodeToken("FROM");
        if ( f1 != null ) f1.setParent(this);
        f2 = n1;
        if ( f2 != null ) f2.setParent(this);
        f3 = new NodeToken("BY");
        if ( f3 != null ) f3.setParent(this);
        f4 = n2;
        if ( f4 != null ) f4.setParent(this);
        f5 = n3;
        if ( f5 != null ) f5.setParent(this);
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

