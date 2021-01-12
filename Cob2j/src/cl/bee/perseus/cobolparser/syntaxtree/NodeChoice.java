/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.perseus.cobolparser.syntaxtree;

/**
 * Represents a grammar choice, e.g. ( A | B )
 */
public class NodeChoice implements Node {
   public NodeChoice(Node node) {
      this(node, -1);
   }

   public NodeChoice(Node node, int whichChoice) {
      choice = node;
      choice.setParent(this);
      which = whichChoice;
   }

   public void accept(cl.bee.perseus.cobolparser.visitor.Visitor v) {
      choice.accept(v);
   }
   public <R,A> R accept(cl.bee.perseus.cobolparser.visitor.GJVisitor<R,A> v, A argu) {
      return choice.accept(v,argu);
   }
   public <R> R accept(cl.bee.perseus.cobolparser.visitor.GJNoArguVisitor<R> v) {
      return choice.accept(v);
   }
   public <A> void accept(cl.bee.perseus.cobolparser.visitor.GJVoidVisitor<A> v, A argu) {
      choice.accept(v,argu);
   }

   public void setParent(Node n) { parent = n; }
   public Node getParent()       { return parent; }

   private Node parent;
   public Node choice;
   public int which;
}

