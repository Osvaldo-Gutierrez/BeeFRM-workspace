/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.genfrmjava.flgparser.syntaxtree;

/**
 * The interface which all syntax tree classes must implement.
 */
public interface Node extends java.io.Serializable {
   public void accept(cl.bee.genfrmjava.flgparser.visitor.Visitor v);
   public <R,A> R accept(cl.bee.genfrmjava.flgparser.visitor.GJVisitor<R,A> v, A argu);
   public <R> R accept(cl.bee.genfrmjava.flgparser.visitor.GJNoArguVisitor<R> v);
   public <A> void accept(cl.bee.genfrmjava.flgparser.visitor.GJVoidVisitor<A> v, A argu);
   // It is the responsibility of each implementing class to call
   // setParent() on each of its child Nodes.
   public void setParent(Node n);
   public Node getParent();
}

