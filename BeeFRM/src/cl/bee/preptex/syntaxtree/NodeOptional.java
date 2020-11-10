/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.preptex.syntaxtree;

/**
 * Represents an grammar optional node, e.g. ( A )? or [ A ]
 */
public class NodeOptional implements Node {
   public NodeOptional() {
      node = null;
   }

   public NodeOptional(Node n) {
      addNode(n);
   }

   public void addNode(Node n)  {
      if ( node != null)                // Oh oh!
         throw new Error("Attempt to set optional node twice");

      node = n;
      n.setParent(this);
   }
   public void accept(cl.bee.preptex.visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(cl.bee.preptex.visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(cl.bee.preptex.visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(cl.bee.preptex.visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
   public boolean present()   { return node != null; }

   public void setParent(Node n) { parent = n; }
   public Node getParent()       { return parent; }

   private Node parent;
   public Node node;
}

