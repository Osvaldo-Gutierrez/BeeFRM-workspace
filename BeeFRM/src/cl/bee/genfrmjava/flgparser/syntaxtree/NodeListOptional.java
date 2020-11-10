/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.genfrmjava.flgparser.syntaxtree;

import java.util.*;

/**
 * Represents an optional grammar list, e.g. ( A )*
 */
public class NodeListOptional implements NodeListInterface {
   public NodeListOptional() {
      nodes = new Vector<Node>();
   }

   public NodeListOptional(Node firstNode) {
      nodes = new Vector<Node>();
      addNode(firstNode);
   }

   public void addNode(Node n) {
      nodes.addElement(n);
      n.setParent(this);
   }

   public Enumeration<Node> elements() { return nodes.elements(); }
   public Node elementAt(int i)  { return nodes.elementAt(i); }
   public int size()             { return nodes.size(); }
   public boolean present()      { return nodes.size() != 0; }
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

   private Node parent;
   public Vector<Node> nodes;
}

