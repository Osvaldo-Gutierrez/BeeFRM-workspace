/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.perseus.cobolparser.syntaxtree;

/**
 * Grammar production:
 * f0 -> ( <ADDRESS> <OF> DataName() | <DEBUG_ITEM> | <LENGTH> <OF> Identifier() | <RETURN_CODE> | <SHIFT_OUT> | <SHIFT_IN> | <SORT_CONTROL> | <SORT_CORE_SIZE> | <SORT_FILE_SIZE> | <SORT_MESSAGE> | <SORT_MODE_SIZE> | <SORT_RETURN> | <TALLY> | <WHEN_COMPILED> )
 */
public class SpecialRegister implements Node {
    private Node parent;
    public NodeChoice f0;

    public SpecialRegister(NodeChoice n0) {
        f0 = n0;
        if ( f0 != null ) f0.setParent(this);
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

