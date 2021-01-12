/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.perseus.copyparser.syntaxtree;

import java.util.*;

/**
 * Represents a grammar list, e.g. ( A )+
 */
public class NodeList implements NodeListInterface {
   public NodeList() {
      nodes = new Vector<Node>();
   }

   public NodeList(Node firstNode) {
      nodes = new Vector<Node>();
      addNode(firstNode);
   }

   public void addNode(Node n) {
      nodes.addElement(n);
   }

   public Enumeration<Node> elements() { return nodes.elements(); }
   public Node elementAt(int i)  { return nodes.elementAt(i); }
   public int size()             { return nodes.size(); }
   public void accept(cl.bee.perseus.copyparser.visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(cl.bee.perseus.copyparser.visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(cl.bee.perseus.copyparser.visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(cl.bee.perseus.copyparser.visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }

   public Vector<Node> nodes;
}

