/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.perseus.cobolparser.syntaxtree;

/**
 * Grammar production:
 * f0 -> <DISPLAY>
 *       | <DISPLAY_1>
 *       | <COMP>
 *       | <COMPUTATIONAL>
 *       | <COMP_N>
 *       | <COMPUTATIONAL_N>
 *       | <COMP_1>
 *       | <COMPUTATIONAL_1>
 *       | <COMP_1_REV>
 *       | <COMPUTATIONAL_1_REV>
 *       | <COMP_1_M>
 *       | <COMPUTATIONAL_1_M>
 *       | <COMP_1_MVS>
 *       | <COMPUTATIONAL_1_MVS>
 *       | <COMP_1_E>
 *       | <COMPUTATIONAL_1_E>
 *       | <COMP_2>
 *       | <COMPUTATIONAL_2>
 *       | <COMP_2_REV>
 *       | <COMPUTATIONAL_2_REV>
 *       | <COMP_2_M>
 *       | <COMPUTATIONAL_2_M>
 *       | <COMP_2_MVS>
 *       | <COMPUTATIONAL_2_MVS>
 *       | <COMP_2_E>
 *       | <COMPUTATIONAL_2_E>
 *       | <COMP_3>
 *       | <COMPUTATIONAL_3>
 *       | <COMP_4>
 *       | <COMPUTATIONAL_4>
 *       | <COMP_5>
 *       | <COMPUTATIONAL_5>
 *       | <COMP_6>
 *       | <COMPUTATIONAL_6>
 *       | <COMP_S>
 *       | <COMPUTATIONAL_S>
 *       | <COMP_1_A>
 *       | <COMPUTATIONAL_1_A>
 *       | <COMP_D>
 *       | <COMPUTATIONAL_D>
 *       | <COMP_2_A>
 *       | <COMPUTATIONAL_2_A>
 *       | <PACKED_DECIMAL>
 *       | <COMP_P>
 *       | <COMPUTATIONAL_P>
 *       | <PACKED_DECIMAL_A>
 *       | <COMP_3_A>
 *       | <COMPUTATIONAL_3_A>
 *       | <PACKED_DECIMAL_I>
 *       | <PACKED_DECIMAL_E>
 *       | <PACKED_DECIMAL_H>
 *       | <COMP_3_M>
 *       | <COMPUTATIONAL_3_M>
 *       | <PACKED_DECIMAL_M>
 *       | <BINARY>
 *       | <BINARY_M>
 *       | <COMP_M>
 *       | <COMPUTATIONAL_M>
 *       | <COMP_A>
 *       | <COMPUTATIONAL_A>
 *       | <COMP_4_M>
 *       | <COMPUTATIONAL_4_M>
 *       | <COMP_B>
 *       | <COMPUTATIONAL_B>
 *       | <BINARY_REV>
 *       | <SQLIND>
 *       | <COMP_X>
 *       | <COMP_X>
 *       | <COMPUTATIONAL_X>
 *       | <COMPUTATIONAL_X>
 *       | <COMP_5_M>
 *       | <COMPUTATIONAL_5_M>
 *       | <COMP_X_REV>
 *       | <COMPUTATIONAL_X_REV>
 *       | <DISPLAY_WS>
 *       | <EXTERNAL_FORM>
 *       | <NATIONAL>
 *       | <KANJI>
 *       | <SIGNED_SHORT>
 *       | <UNSIGNED_SHORT>
 *       | <SIGNED_INT>
 *       | <UNSIGNED_INT>
 *       | <SIGNED_LONG>
 *       | <UNSIGNED_LONG>
 *       | <FLOAT>
 *       | <DOUBLE>
 *       | <HANDLE> <OF> <THREAD>
 *       | <HANDLE> [ [ <OF> ] HandleComponent() [ ImplicitTitle() ] ]
 *       | <HANDLE> [ <OF> ] <FONT> [ <FIXED_FONT> | <TRADITIONAL_FONT> | <DEFAULT_FONT> | <SMALL_FONT> | <MEDIUM_FONT> | <LARGE_FONT> ]
 *       | <HANDLE> [ <OF> ] <WINDOW> [ ImplicitTitle() ]
 *       | <WINDOW>
 */
public class MemoryUsage implements Node {
    private Node parent;
    public NodeChoice f0;

    public MemoryUsage(NodeChoice n0) {
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

