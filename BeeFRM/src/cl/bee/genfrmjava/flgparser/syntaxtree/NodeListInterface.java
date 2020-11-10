/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.genfrmjava.flgparser.syntaxtree;

/**
 * The interface which NodeList, NodeListOptional, and NodeSequence
 * implement.
 */
public interface NodeListInterface extends Node {
   public void addNode(Node n);
   public Node elementAt(int i);
   public java.util.Enumeration<Node> elements();
   public int size();

   public void accept(cl.bee.genfrmjava.flgparser.visitor.Visitor v);
   public <R,A> R accept(cl.bee.genfrmjava.flgparser.visitor.GJVisitor<R,A> v, A argu);
   public <R> R accept(cl.bee.genfrmjava.flgparser.visitor.GJNoArguVisitor<R> v);
   public <A> void accept(cl.bee.genfrmjava.flgparser.visitor.GJVoidVisitor<A> v, A argu);
}

