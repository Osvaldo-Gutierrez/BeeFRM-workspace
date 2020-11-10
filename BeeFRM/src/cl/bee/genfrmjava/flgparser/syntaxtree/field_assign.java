/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.genfrmjava.flgparser.syntaxtree;

/**
 * Grammar production:
 * f0 -> <CLEAR_CHARACTER> <EQUAL_ST_FIELD> <STRING_ST_FIELD>
 *       | <DEF> <EQUAL_ST_FIELD> <STRING_ST_FIELD>
 *       | <HELP> <EQUAL_ST_FIELD> <STRING_ST_FIELD>
 *       | <NAME_ST_FIELD> <EQUAL_ST_FIELD> <STRING_ST_FIELD> <LPAR_ST_FIELD> <INTEGER_ST_FIELD> <COMMA_ST_FIELD> <INTEGER_ST_FIELD> <RPAR_ST_FIELD>
 *       | <PICTURE> <EQUAL_ST_FIELD> [ <INTEGER_ST_FIELD> ] <STRING_ST_FIELD>
 *       | <INDEX_ST_FIELD> <EQUAL_ST_FIELD> <LPAR_ST_FIELD> <INTEGER_ST_FIELD> <COMMA_ST_FIELD> <INTEGER_ST_FIELD> <RPAR_ST_FIELD> ( <COLON_ST_FIELD> <LPAR_ST_FIELD> <INTEGER_ST_FIELD> <COMMA_ST_FIELD> <INTEGER_ST_FIELD> <RPAR_ST_FIELD> )*
 */
public class field_assign implements Node {
    private Node parent;
    public NodeChoice f0;

    public field_assign(NodeChoice n0) {
        f0 = n0;
        if ( f0 != null ) f0.setParent(this);
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

