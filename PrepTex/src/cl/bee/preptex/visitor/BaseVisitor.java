/*
 *   Copyright (c) 2019 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.preptex.visitor;


import java.io.*;

import java.util.*;

import cl.bee.preptex.*;
import cl.bee.preptex.syntaxtree.*;
import cl.bee.preptex.util.*;
import cl.bee.preptex.visitor.*;

import com.rits.cloning.*;

import org.apache.log4j.*;


/**
 *
 * TODO_javadoc.
 *
 * @version 1.0 (01/01/2019).
 *
 */
public class BaseVisitor implements GJNoArguVisitor<Object> {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(BaseVisitor.class);

    //

    /** TODO_javadoc. */
    protected String filename = null;

    /** TODO_javadoc. */
    protected HashMap<String, Object> symbolsTable = null;

    /** TODO_javadoc. */
    protected String control = null;

    /** TODO_javadoc. */
    protected String country = null;

    /** TODO_javadoc. */
    protected String client = null;

    /** TODO_javadoc. */
    protected String system = null;

    /** TODO_javadoc. */
    protected boolean logging = false;

    //

    /** TODO_javadoc. */
    protected TokenVisitor tokenVisitor = new TokenVisitor();

    /** TODO_javadoc. */
    protected String prefix = null;

    /** TODO_javadoc. */
    protected Cloner cloner = new Cloner();

    /******************************************************************************
     * BaseVisitor
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param filename TODO_javadoc.
     * @param symbolsTable TODO_javadoc.
     * @param control TODO_javadoc.
     * @param country TODO_javadoc.
     * @param client TODO_javadoc.
     * @param system TODO_javadoc.
     * @param logging TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public BaseVisitor(String filename, HashMap<String, Object> symbolsTable, String control, String country, String client, String system, boolean logging) {

        this.filename     = filename;
        this.symbolsTable = symbolsTable;
        this.control      = control;
        this.country      = country;
        this.client       = client;
        this.system       = system;
        this.logging      = logging;

        prefix = /*"<" + this.getClass().getSimpleName() + ">"*/ "<" + filename.substring(filename.lastIndexOf('/') + 1) + ">";
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public Object visit(NodeList n) {

        Object   _ret   = null;
        int _count = 0;

        for (Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {

            e.nextElement().accept(this);

            _count++;
        }

        return _ret;
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public Object visit(NodeListOptional n) {

        if (n.present()) {

            Object   _ret   = null;
            int _count = 0;

            for (Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {

                e.nextElement().accept(this);

                _count++;
            }

            return _ret;
        }
        else {
            return null;
        }
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public Object visit(NodeOptional n) {

        if (n.present()) {
            return n.node.accept(this);
        }
        else {
            return null;
        }
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public Object visit(NodeSequence n) {

        Object   _ret   = null;
        int _count = 0;

        for (Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {

            e.nextElement().accept(this);

            _count++;
        }

        return _ret;
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public Object visit(NodeToken n) {
        return null;
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> statement_list()
     * f1 -> <EOF>
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public Object visit(specification n) {
        return n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( statement() )*
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public Object visit(statement_list n) {

      //logger.debug("entrando a 'visit(statement_list n) ...'");

        NodeListOptional          nlo   = new NodeListOptional();
        ArrayList<statement_list> stmts = null;
        
        
        ArrayList<statement_list> stmts2 = null;

        for (int i = 0; i < n.f0.size(); i++) { // ( statement() )*

            statement stmt = (statement) n.f0.elementAt(i);

            if (stmt.f0.which == 3 /*include_statement*/) {

              //logger.debug("include_statement ...'");
            	

                stmts = getStatementsFromInclude((include_statement) stmt.f0.choice, null);

                for (int j = 0; j < stmts.size(); j++) {

                    statement_list sl = stmts.get(j);

                    for (Enumeration<Node> e = sl.f0.elements(); e.hasMoreElements(); ) {

                        Node node = e.nextElement(); //TODO_ALA: definicion interna :-)

                        nlo.addNode(node);

                        //OGB, en caso de haber un include dentro de otro include se procesa pero se hace con respecto a stmt original
                        include_statement inclstmt = (include_statement) stmt.f0.choice;
                        
                        statement stmt2 = (statement) node;
                        
                        
                        //OGB, si include tiene <OF> se agrega a vector de variables, ya que condicion puede estar anidada
                        //despues se remueve del vector.
                        Boolean flagR = false;
                        
                        
                        if (inclstmt.f1.present()) { // [ identifier_list() <OF> ]

                            NodeSequence    ns    = (NodeSequence) inclstmt.f1.node;
                            identifier_list il    = (identifier_list) ns.elementAt(0);
                            String          ident = il.f0.tokenImage;
                            if (!symbolsTable.containsKey(ident.toUpperCase())) {
                            	flagR = true;
                            	symbolsTable.put(ident.toUpperCase(), Boolean.TRUE); // <IDENTIFIER>
                            }

                        }
                        
                        
                        //OGB, Se procesa include sobre include.
                        if (stmt2.f0.which == 3) {
                        	
                        	include_statement inclstmtSec    = (include_statement) stmt2.f0.choice;

                        	stmts2 = getStatementsFromInclude((include_statement) stmt.f0.choice, inclstmtSec.f2.tokenImage );
                        	
                            for (int j2 = 0; j2 < stmts2.size(); j2++) {

                                statement_list sl2 = stmts2.get(j2);

                                for (Enumeration<Node> e2 = sl2.f0.elements(); e2.hasMoreElements(); ) {
                                    Node node2 = e2.nextElement();
                                    nlo.addNode(node2);
                                    node2.accept(this);
                                }
                            }                            
                        }
                        
                        logger.debug("ejecutando " + node.accept(tokenVisitor).toString().trim());

                        node.accept(this);
                        
                        if (inclstmt.f1.present()) { // [ identifier_list() <OF> ]

                            NodeSequence    ns    = (NodeSequence) inclstmt.f1.node;
                            identifier_list il    = (identifier_list) ns.elementAt(0);
                            String          ident = il.f0.tokenImage;

                            if (flagR)
                            	symbolsTable.remove(ident.toUpperCase()); // <IDENTIFIER>
                        }
                        else {
                        	
                        	String keyinclude = inclstmt.f2.tokenImage;
                        	if (symbolsTable.containsKey(unquote(keyinclude)))
                        		symbolsTable.remove(unquote(keyinclude));
                        	
                        	
                        }
                        
                    }
                }

              //logger.debug("================= ...'");
            }
            else {

                nlo.addNode(stmt);

              //logger.debug("ejecutando " + stmt.accept(tokenVisitor).toString().trim());

                stmt.accept(this);
            }
        }

        n.f0 = nlo;

        return null;
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> assignment_statement()
     *       | selection_statement()
     *       | iteration_statement()
     *       | include_statement()
     *       | text_statement()
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public Object visit(statement n) {
            return n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <IF>
     * f1 -> expression_statement()
     * f2 -> [ <THEN> ]
     * f3 -> statement_list()
     * f4 -> [ <ELSE> statement_list() ]
     * f5 -> <END>
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public Object visit(selection_statement n) {

        Object obj = n.f1.accept(this); // expression_statement()

        if (obj == null) {
            throw new RuntimeException("condicion del <IF> nula.");
        }

        if (!(obj instanceof Boolean)) {
            throw new RuntimeException("tipo condicion del <IF> debe ser Boolean '" + obj + "' (" + obj.getClass().getSimpleName() + ").");
        }

        //

        if (((Boolean) obj).booleanValue()) {
            return n.f3.accept(this); // statement_list()
        }
        else if (n.f4.present()) { // [ <ELSE> statement_list() ]

            NodeSequence ns = (NodeSequence) n.f4.node; // statement_list()

            return ((statement_list) ns.elementAt(1)).accept(this);
        }

        return null;
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <WHILE> expression_statement() statement_list() <END>
     *       | <FOR> <EACH> <IDENTIFIER> <IN> <LPAREN> argument_expression_list() <RPAREN> statement_list() <END>
     *       | <FOR> <IDENTIFIER> <EQUAL> expression_statement() <TO> expression_statement() [ <STEP> expression_statement() ] statement_list() <NEXT> <IDENTIFIER>
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public Object visit(iteration_statement n) {

        Object       obj = null;
        NodeSequence ns  = (NodeSequence) n.f0.choice;

        switch (n.f0.which) {

        case 0 : // <WHILE> expression_statement() statement_list() <END>

            while (true) {

                obj = ((expression_statement) ns.elementAt(1)).accept(this); // expression_statement()

                if (obj == null) {
                    throw new RuntimeException("condicion del <WHILE> nula.");
                }

                if (!(obj instanceof Boolean)) {
                    throw new RuntimeException("tipo condicion del <WHILE> debe ser Boolean '" + obj + "' (" + obj.getClass().getSimpleName() + ").");
                }

                if (((Boolean) obj).booleanValue() == false) {
                    break;
                }

                ((statement_list) ns.elementAt(2)).accept(this); // statement_list()
            }

            break;

        case 1 : // <FOR> <EACH> <IDENTIFIER> <IN> <LPAREN> argument_expression_list() <RPAREN> statement_list() <END>

            throw new RuntimeException("iteration_statement:: <FOR> <EACH> <IDENTIFIER> <IN> <LPAREN> argument_expression_list() <RPAREN> statement_list() <END> no inplementado aun.");

          //break;

        case 2 : // <FOR> <IDENTIFIER> <EQUAL> expression_statement() <TO> expression_statement() [ <STEP> expression_statement() ] statement_list() <NEXT> <IDENTIFIER>

            String ident = ((NodeToken) ns.elementAt(1)).tokenImage.toUpperCase();

            // inicial

            obj = ((expression_statement) ns.elementAt(3)).accept(this); // expression_statement()

            if (obj == null) {
                throw new RuntimeException ("valor inicial del <FOR> es nulo.");
            }

            if (!(obj instanceof Long)) {
                throw new RuntimeException("tipo del valor inicial del <FOR> debe ser Long '" + obj + "' (" + obj.getClass().getSimpleName() + ").");
            }

            long inicial = ((Long) obj).longValue();

            // final

            obj = ((expression_statement) ns.elementAt(5)).accept(this); // expression_statement()

            if (obj == null) {
                throw new RuntimeException ("valor final del <FOR> es nulo.");
            }

            if (!(obj instanceof Long)) {
                throw new RuntimeException("tipo del valor final del <FOR> debe ser Long '" + obj + "' (" + obj.getClass().getSimpleName() + ").");
            }

            long final_  = ((Long) obj).longValue();

            // step

            long step = 1;

            if (((NodeOptional) ns.elementAt(6)).present()) {

                NodeSequence ns1  = (NodeSequence) ((NodeOptional) ns.elementAt(6)).node;

                obj = ((expression_statement) ns1.elementAt(1)).accept(this); // expression_statement()

                if (obj == null) {
                    throw new RuntimeException ("valor <STEP> del <FOR> es nulo.");
                }

                if (!(obj instanceof Long)) {
                    throw new RuntimeException("tipo del valor incremental <STEP> del <FOR> debe ser Long '" + obj + "' (" + obj.getClass().getSimpleName() + ").");
                }

                step = ((Long) obj).longValue();
            }

            if (step == 0L) {
                throw new RuntimeException("valor incremental <STEP> del <FOR> no debe ser cero.");
            }

            //

            putSymbol(ident, new Long(inicial));

            long val;

            while (true) {

                obj = getSymbol(ident);
                val = ((Long) obj).intValue();

                if (val > final_) {
                    break;
                }

                ((statement_list) ns.elementAt(7)).accept(this); // statement_list()
                
                symbolsTable.remove(ident);

                putSymbol(ident, new Long(val + step));
            }
            
            symbolsTable.remove(ident);

            break;
        }

        return null;
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <INCLUDE>
     * f1 -> [ identifier_list() <OF> ]
     * f2 -> <STRING>
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public Object visit(include_statement n) {

        if (n.f1.present()) { // [ identifier_list() <OF> ]

            throw new RuntimeException("no deberia estar visitando un include_statement.");
        }


        return null;
       
        
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <TEXT>
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public Object visit(text_statement n) {

        String s = trimLines(n.f0.tokenImage);

        return s.substring(6, s.length() - 2); // TEXT[::]
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> unary_expression()
     * f1 -> assignment_operator()
     * f2 -> expression_statement()
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public Object visit(assignment_statement n) {

      //logger.debug(prefix + "entrando a 'visit(" + n.accept(tokenVisitor).toString().trim() + ")' ");

        String ident = null;

        /* unary_expression::
         * f0 -> postfix_expression()
         *       | unary_operator() unary_expression()
         */

        if (n.f0.f0.which == 0 /*postfix_expression*/) {

            /* postfix_expression::
             * f0 -> primary_expression()
             * f1 -> [ <LPAREN> argument_expression_list() <RPAREN> ]
             */
            postfix_expression px = (postfix_expression) n.f0.f0.choice;

            if (px.f1.present()) { // [ <LPAREN> argument_expression_list() <RPAREN> ]
                throw new RuntimeException("valor de '" + n.f0.accept(tokenVisitor).toString().trim() + "' no es un lvalue.");
            }
            else {

                primary_expression pe = (primary_expression) px.f0;

                if (pe.f0.which == 0 /*<IDENTIFIER>*/) {
                    ident = ((NodeToken) pe.f0.choice).tokenImage;
                }
                else {
                    throw new RuntimeException("valor de '" + n.f0.accept(tokenVisitor).toString().trim() + "' no es un lvalue.");
                }
            }
        }
        else {
            throw new RuntimeException("valor de '" + n.f0.accept(tokenVisitor).toString().trim() + "' no es un lvalue.");
        }

        //

        Object op2 = n.f2.accept(this); // expression_statement()

        if (op2 == null) {
            throw new RuntimeException("valor de '" + n.f2.accept(tokenVisitor).toString().trim() + "' es nulo.");
        }

        //

        switch (n.f1.f0.which) {

        case 0 : // <EQUAL>

            putSymbol(ident, op2);

            logger.debug(prefix + "asignado " + ident + " = " + op2);

            break;

        case 1 : // <PLUSASSIGN>

            Object _ret = getSymbol(ident);

            if (_ret == null) {
                throw new RuntimeException("valor de '" + n.f0.accept(tokenVisitor).toString().trim() + "' es nulo.");
            }

            if (_ret instanceof Long && op2 instanceof Long) {

                long lop1 = ((Long) _ret).longValue();
                long lop2 = ((Long) op2).longValue();

                putSymbol(ident, new Long(lop1 + lop2));

                break;
            }
            else if (_ret instanceof String  && op2 instanceof String) {

                String sop1 = (String) _ret;
                String sop2 = (String) op2;

                putSymbol(ident, sop1 + sop2);
            }
            else {
                throw new RuntimeException("error en assignment_statement '" + _ret + "' (" + _ret.getClass().getSimpleName() + "), '" + op2 + "' (" + op2.getClass().getSimpleName() + ").");
            }
        }

        return null;
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <IDENTIFIER>
     * f1 -> ( <COMMA> <IDENTIFIER> )*
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public Object visit(identifier_list n) {
        return null;
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> logical_or_expression()
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public Object visit(expression_statement n) {
        return n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <EQUAL>
     *       | <PLUSASSIGN>
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public Object visit(assignment_operator n) {
        return null;
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> logical_and_expression()
     * f1 -> ( <OR> logical_and_expression() )*
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public Object visit(logical_or_expression n) {

        Object _ret = n.f0.accept(this); // logical_and_expression()

        if (_ret == null) {
            throw new RuntimeException("valor de '" + n.f0.accept(tokenVisitor).toString().trim() + "' es nulo.");
        }

        if (n.f1.size() > 0) {

            if (!(_ret instanceof Boolean)) {
                throw new RuntimeException("tipo de operando debe ser Boolean '" + _ret + "' (" + _ret.getClass().getSimpleName() + ")");
            }

            for (int i = 0; i < n.f1.size(); i++) { // ( <OR> logical_and_expression() )*

                if (((Boolean) _ret).booleanValue()) {
                    return Boolean.TRUE;
                }

                NodeSequence ns  = (NodeSequence) n.f1.elementAt(i);
                Object       op2 = ((logical_and_expression) ns.elementAt(1)).accept(this);

                if (op2 == null) {
                    throw new RuntimeException("valor de '" + ns.elementAt(1).accept(tokenVisitor).toString().trim() + "' es nulo.");
                }

                if (op2 instanceof Boolean) {
                    _ret = new Boolean(((Boolean) _ret).booleanValue() || ((Boolean) op2).booleanValue());
                }
                else {
                    throw new RuntimeException("tipo de '" + op2 + "' debe ser Boolean (" + op2.getClass().getSimpleName() + ")");
                }
            }
        }

        return _ret;
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> equality_expression()
     * f1 -> ( <AND> equality_expression() )*
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public Object visit(logical_and_expression n) {

        Object _ret = n.f0.accept(this); // equality_expression()

        if (_ret == null) {
            throw new RuntimeException("valor de '" + n.f0.accept(tokenVisitor).toString().trim() + "' es nulo.");
        }

        if (n.f1.size() > 0) {

            if (!(_ret instanceof Boolean)) {
                throw new RuntimeException("tipo de operando debe ser Boolean '" + _ret + "' (" + _ret.getClass().getSimpleName() + ")");
            }

            for (int i = 0; i < n.f1.size(); i++) { // ( <AND> equality_expression() )*

                if (((Boolean) _ret).booleanValue() == false) {
                    return Boolean.FALSE;
                }

                NodeSequence ns  = (NodeSequence) n.f1.elementAt(i);
                Object       op2 = ((equality_expression) ns.elementAt(1)).accept(this); // equality_expression()

                if (op2 == null) {
                    throw new RuntimeException("valor de '" + ns.elementAt(1).accept(tokenVisitor).toString().trim() + "' es nulo.");
                }

                if (op2 instanceof Boolean) {
                    _ret = new Boolean(((Boolean) _ret).booleanValue() && ((Boolean) op2).booleanValue());
                }
                else {
                    throw new RuntimeException("tipo de '" + op2 + "' debe ser Boolean (" + op2.getClass().getSimpleName() + ").");
                }
            }
        }

        return _ret;
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> relational_expression()
     * f1 -> [ ( <EQUAL> | <NE> ) relational_expression() ]
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public Object visit(equality_expression n) {

        Object _ret = n.f0.accept(this); // relational_expression()

        if (_ret == null) {
            throw new RuntimeException("valor de '" + n.f0.accept(tokenVisitor).toString().trim() + "' es nulo.");
        }

        if (n.f1.present()) { // [ ( <EQUAL> | <NE> ) relational_expression() ]

            NodeSequence ns  = (NodeSequence) n.f1.node;
            NodeChoice   nch = (NodeChoice) ns.elementAt(0);
            Object       op2 = ((relational_expression) ns.elementAt(1)).accept(this);

            if (op2 == null) {
                throw new RuntimeException("valor de '" + ns.elementAt(1).accept(tokenVisitor).toString().trim() + "' es nulo.");
            }

            if        (_ret instanceof Boolean && op2 instanceof Boolean) {

                switch (nch.which) {

                case 0 : // <EQUAL>

                    return new Boolean(((Boolean) _ret).booleanValue() == ((Boolean) op2).booleanValue());

                case 1 : // <NE>

                    return new Boolean(((Boolean) _ret).booleanValue() != ((Boolean) op2).booleanValue());
                }

            } else if (_ret instanceof Long && op2 instanceof Long) {

                switch (nch.which) {

                case 0 : // <EQUAL>

                     return new Boolean(((Long) _ret).longValue() == ((Long) op2).longValue());

                case 1 : // <NE>

                    return new Boolean(((Long) _ret).longValue() != ((Long) op2).longValue());
                }

            } else if (_ret instanceof String  && op2 instanceof String) {

                switch (nch.which) {

                case 0 : // <EQUAL>

                    return new Boolean( ((String) _ret).equals((String) op2));

                case 1 : // <NE>

                    return new Boolean(!((String) _ret).equals((String) op2));
                }
	        } 
            else {
                throw new RuntimeException("error de tipos en (des)igualdad '" + _ret + "' (" + _ret.getClass().getSimpleName() + ") y '" + op2 + "' (" + op2.getClass().getSimpleName() + ")");
            }
        }

        return _ret;
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> additive_expression()
     * f1 -> [ ( <LT> | <GT> | <LE> | <GE> ) additive_expression() ]
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public Object visit(relational_expression n) {

        Object _ret = n.f0.accept(this); // additive_expression()

        if (_ret == null) {
            throw new RuntimeException("valor de '" + n.f0.accept(tokenVisitor).toString().trim() + "' es nulo.");
        }

        if (n.f1.present()) { // [ ( <LT> | <GT> | <LE> | <GE> ) additive_expression() ]

            if (!(_ret instanceof Long)) {
                throw new RuntimeException("tipo de operando debe ser Long '" + _ret + "' (" + _ret.getClass().getSimpleName() + ")");
            }

            NodeSequence ns  = (NodeSequence) n.f1.node;
            NodeChoice   nch = (NodeChoice) ns.elementAt(0);
            Object       op2 = ((additive_expression) ns.elementAt(1)).accept(this);

            if (op2 == null) {
                throw new RuntimeException("valor de '" + ns.elementAt(1).accept(tokenVisitor).toString().trim() + "' es nulo.");
            }

            if (op2 instanceof Long) {

                switch (nch.which) {

                case 0 : // <LT>

                    return new Boolean(((Long) _ret).longValue() < ((Long) op2).longValue());

                case 1 : // <GT>

                    return new Boolean(((Long) _ret).longValue() > ((Long) op2).longValue());

                case 2 : // <LE>

                    return new Boolean(((Long) _ret).longValue() <= ((Long) op2).longValue());

                case 3 : // <GE>

                    return new Boolean(((Long) _ret).longValue() >= ((Long) op2).longValue());
                }
            }
            else {
                throw new RuntimeException("tipo de operando debe ser Long '" + op2 + "' (" + op2.getClass().getSimpleName() + ")");
            }
        }

        return _ret;
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> multiplicative_expression()
     * f1 -> ( ( <PLUS> | <MINUS> ) multiplicative_expression() )*
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public Object visit(additive_expression n) {

        Object _ret = n.f0.accept(this); // multiplicative_expression()

        if (_ret == null) {
            throw new RuntimeException("valor de '" + n.f0.accept(tokenVisitor).toString().trim() + "' es nulo.");
        }

        if (n.f1.size() > 0) {

            if (!(_ret instanceof Long)) {
                throw new RuntimeException("tipo de operando debe ser Long '" + _ret + "' (" + _ret.getClass().getSimpleName() + ")");
            }

            for (int i = 0; i < n.f1.size(); i++) { // ( ( <PLUS> | <MINUS> ) multiplicative_expression() )*

                NodeSequence ns  = (NodeSequence) n.f1.elementAt(i);
                NodeChoice   nch = (NodeChoice) ns.elementAt(0);
                Object       op2 = ((multiplicative_expression) ns.elementAt(1)).accept(this);

                if (op2 == null) {
                    throw new RuntimeException("valor de '" + ns.elementAt(1).accept(tokenVisitor).toString().trim() + "' es nulo.");
                }

                if (op2 instanceof Long) {

                    switch (nch.which) {

                    case 0 : // <PLUS>

                        _ret = new Long(((Long) _ret).longValue() + ((Long) op2).longValue());

                        break;

                    case 1 : // <MINUS>

                        _ret = new Long(((Long) _ret).longValue() - ((Long) op2).longValue());

                        break;
                    }
                }
                else {
                    throw new RuntimeException("tipos de operandos debe ser Long '" + _ret + "' (" + _ret.getClass().getSimpleName() + ") y '" + op2 + "' (" + op2.getClass().getSimpleName() + ")");
                }
            }
        }

        return _ret;
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> unary_expression()
     * f1 -> ( ( <STAR> | <SLASH> ) unary_expression() )*
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public Object visit(multiplicative_expression n) {

        Object _ret = n.f0.accept(this); // unary_expression()

        if (_ret == null) {
            throw new RuntimeException("valor de '" + n.f0.accept(tokenVisitor).toString().trim() + "' es nulo.");
        }

        if (n.f1.size() > 0) {

            if (!(_ret instanceof Long)) {
                throw new RuntimeException("tipo de operando debe ser Long '" + _ret + "' (" + _ret.getClass().getSimpleName() + ")");
            }

            for (int i = 0; i < n.f1.size(); i++) { // ( ( <STAR> | <SLASH> ) unary_expression() )*

                NodeSequence ns  = (NodeSequence) n.f1.elementAt(i);
                NodeChoice   nch = (NodeChoice) ns.elementAt(0);
                Object       op2 = ((unary_expression) ns.elementAt(1)).accept(this);

                if (op2 == null) {
                    throw new RuntimeException("valor de '" + ns.elementAt(1).accept(tokenVisitor).toString().trim() + "' es nulo.");
                }

                if (op2 instanceof Long) {

                    switch (nch.which) {

                    case 0 : // <STAR>

                        _ret = new Long(((Long) _ret).longValue() * ((Long) op2).longValue());

                        break;

                    case 1 : // <SLASH>

                        if (((Long) op2).longValue() == 0L) {
                            throw new RuntimeException("se intento dividir por cero");
                        }

                        _ret = new Long(((Long) _ret).longValue() / ((Long) op2).longValue());

                        break;
                    }
                }
                else {
                    throw new RuntimeException("tipos de operandos debe ser Long '" + _ret + "' (" + _ret.getClass().getSimpleName() + ") y '" + op2 + "' (" + op2.getClass().getSimpleName() + ")");
                }
            }
        }

        return _ret;
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> postfix_expression()
     *       | unary_operator() unary_expression()
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public Object visit(unary_expression n) {

        switch (n.f0.which) {

        case 0 : // postfix_expression()

            return n.f0.accept(this);

        case 1 : // unary_operator() unary_expression()

            NodeSequence ns = (NodeSequence) n.f0.choice;

            unary_operator uo  = (unary_operator) ns.elementAt(0);
            Object         obj =                  ns.elementAt(1).accept(this); // unary_expression()

            if (obj == null) {
                throw new RuntimeException("valor de '" + ns.elementAt(1).accept(tokenVisitor).toString().trim() + "' es nulo.");
            }

            switch (uo.f0.which) {

            case 0: // <MINUS>

                if (obj instanceof Long) {
                    return new Long(-((Long) obj).longValue());
                }
                else {
                    throw new RuntimeException("tipos del operando debe ser Long '" + obj + "' (" + obj.getClass().getSimpleName() + ").");
                }

            case 1: // <NOT>

                if (obj instanceof Boolean) {
                    return new Boolean(!((Boolean) obj).booleanValue());
                }
                else {
                    throw new RuntimeException("tipos del operando debe ser Boolean '" + obj + "' (" + obj.getClass().getSimpleName() + ").");
                }
            }
        }

        logger.error(prefix + "antes del error: [" + n.accept(tokenVisitor).toString().trim() + "]");

        throw new RuntimeException("error");
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <MINUS>
     *       | <NOT>
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public Object visit(unary_operator n) {
        return null;
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> primary_expression()
     * f1 -> [ <LPAREN> argument_expression_list() <RPAREN> ]
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public Object visit(postfix_expression n) {

        if (n.f1.present()) {
            throw new RuntimeException("postfix_expression:: [ <LPAREN> argument_expression_list() <RPAREN> ] no implementadas aun {" + n.f1.accept(tokenVisitor).toString().trim() + "}.");
        }

        return n.f0.accept(this); // primary_expression()
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> expression_statement()
     * f1 -> ( <COMMA> expression_statement() )*
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public Object visit(argument_expression_list n) {
        return null;
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <IDENTIFIER>
     *       | constant()
     *       | <LPAREN> expression_statement() <RPAREN>
     *       | <LBRACE> expression_statement() <RBRACE>
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public Object visit(primary_expression n) {

        switch (n.f0.which) {

        case 0 : // <IDENTIFIER>

            String ident = ((NodeToken) n.f0.choice).tokenImage;

            Object obj = getSymbol(ident);

            if (obj != null) {
                return obj;
            }
            else {

              //putSymbol(ident, Boolean.FALSE);

              //logger.debug(prefix + "no encontrado '" + ident + "' en symbolsTable. asumira 'false'");

                return Boolean.FALSE;
            }

        case 1 : // Constant()

            return n.f0.accept(this);

        case 2 : // <LPAREN> expression_statement() <RPAREN>
        case 3 : // <LBRACE> expression_statement() <RBRACE>

            return ((expression_statement) ((NodeSequence) n.f0.choice).elementAt(1)).accept(this);
        }

        logger.error(prefix + "antes del error: [" + n.accept(tokenVisitor).toString().trim() + "]");

        throw new RuntimeException("error");
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <DOUBLE>
     *       | <STRING>
     *       | <TRUE>
     *       | <FALSE>
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public Object visit(constant n) {

        String token = ((NodeToken) n.f0.choice).tokenImage;

        switch (n.f0.which) {

        case 0 : // <DOUBLE>

            return new Long(token);

        case 1 : // <STRING>

            return token.substring(1, token.length() - 1);

        case 2 : // <TRUE>

            return Boolean.TRUE;

        case 3 : // <FALSE>

            return Boolean.FALSE;
        }

        logger.error(prefix + "antes del error: [" + n.accept(tokenVisitor).toString().trim() + "]");

        throw new RuntimeException("error");
    }

    //
    //
    //

    /******************************************************************************
     * getStatementsFromInclude
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <INCLUDE>
     * f1 -> [ identifier_list() <OF> ]
     * f2 -> <STRING>
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    protected ArrayList<statement_list> getStatementsFromInclude(include_statement n, String auxname) {

      //logger.debug(prefix + "entrando a 'getStatementsFromInclude(" + n.accept(tokenVisitor).toString().trim() + ")' ...");

    	//OGB, se quita symbolsTable clonado ya que variables encontradas dentro los include si influyen en el codigo base.
        //HashMap<String, Object> sym_include = cloner.deepClone(symbolsTable); //new HashMap<String, Object>();

    	//Se sustituye ingresando el identificador a buscar y luego de procesado, se remueve de la lista
    	
        Boolean indDel = false;
        
        if (n.f1.present()) { // [ identifier_list() <OF> ]

            NodeSequence    ns    = (NodeSequence) n.f1.node;
            identifier_list il    = (identifier_list) ns.elementAt(0);
            String          ident = il.f0.tokenImage;

            if (!symbolsTable.containsKey(ident.toUpperCase())) {
            	symbolsTable.put(ident.toUpperCase(), Boolean.TRUE); // <IDENTIFIER>
            	indDel = true;
            }

            for (int i = 0; i < il.f1.size(); i++) {

                NodeSequence ns1 = (NodeSequence) il.f1.elementAt(i);

                ident = ((NodeToken) ns1.elementAt(i)).tokenImage;

                symbolsTable.put(ident.toUpperCase(), Boolean.TRUE); // <IDENTIFIER>
            }
        }

        //

        String filename = unquote(n.f2.tokenImage);
        
        if (auxname != null)
        	filename = unquote(auxname);
        

        if (filename.indexOf('.') == -1) {
            filename += ".SRC";
        }

        String pathname = findFile(country, client, system, filename);

        if (pathname == null || !(new File(pathname)).exists()) {

            logger.warn(prefix + "");
            logger.warn(prefix + "****************************************************************************************************************");
            logger.warn(prefix + "**** ARCHIVO INCLUIDO '" + filename + "' NO ENCONTRADO. [" + n.accept(tokenVisitor).toString().trim()  + "] ****");
            logger.warn(prefix + "****************************************************************************************************************");
            logger.warn(prefix + "");

            return new ArrayList<statement_list>();
        }

        try {

            logger.info(prefix + "utilizando '" + pathname + "' en [" + n.accept(tokenVisitor).toString().trim() + "].");

            PrepTex parser = new PrepTex(new PrepTexStream(pathname, control, symbolsTable, false));
            Node    root   = parser.specification();

            IncludeVisitor vis = new IncludeVisitor(pathname, symbolsTable, control, country, client, system, logging, !n.f1.present()/* f1 -> [ identifier_list() <OF> ]*/);

            ArrayList<statement_list> stmts = (ArrayList<statement_list>) root.accept(vis);

            
            if (n.f1.present()) { // [ identifier_list() <OF> ]

                NodeSequence    ns    = (NodeSequence) n.f1.node;
                identifier_list il    = (identifier_list) ns.elementAt(0);
                String          ident = il.f0.tokenImage;

                if (symbolsTable.containsKey(ident.toUpperCase())) {

                	if (indDel)
                		symbolsTable.remove(ident.toUpperCase()); // <IDENTIFIER>
                }


                for (int i = 0; i < il.f1.size(); i++) {

                    NodeSequence ns1 = (NodeSequence) il.f1.elementAt(i);

                    ident = ((NodeToken) ns1.elementAt(i)).tokenImage;

                    symbolsTable.remove(ident.toUpperCase()); // <IDENTIFIER>
                }
            }

            
            return stmts;
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
        
        
    }

    /******************************************************************************
     * findFile
     ******************************************************************************/
    /**
     *
     * @param country TODO_javadoc
     * @param client TODO_javadoc
     * @param system TODO_javadoc
     * @param filename TODO_javadoc
     *
     */
    private String findFile(String country, String client, String system, String filename) {

      //logger.debug(prefix + "entrando a 'findFile(" + country + "," + client + "," + system + "," + filename + ")' ...");

        String pathname = null;

        pathname = Util.findFile("skeleton/CST/DES" + country + client + "/" + system + "/FTE/TXT", filename);

        if (pathname != null) {
            return pathname;
        }

        pathname = Util.findFile("skeleton/CST/DES" + country +          "/" + system + "/FTE/TXT", filename);

        if (pathname != null) {
            return pathname;
        }

        pathname = Util.findFile("skeleton/CST/DES" +                    "/" + system + "/FTE/TXT", filename);

        if (pathname != null) {
            return pathname;
        }

        //

        pathname = Util.findFile("skeleton/CST/DES" + country + client + "/" + system + "/FTE/GNS/DOS/BMS", filename);

        if (pathname != null) {
            return pathname;
        }

        pathname = Util.findFile("skeleton/CST/DES/GNS/FTE/SRC", filename);

        if (pathname != null) {
            return pathname;
        }

        //

      //pathname = Util.findFile("skeleton", filename); // RETHDR_1

        return pathname;
    }

    /******************************************************************************
     * unquote
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param s TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private String unquote(String s) {
        return s.substring(1, s.length() - 1);
    }

    /******************************************************************************
     * putSymbol
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param name TODO_javadoc.
     * @param value TODO_javadoc.
     *
     */
    protected void putSymbol(String name, Object value) {

        if (name == null || symbolsTable == null) {
            throw new RuntimeException("name o symbolsTable es nulo.");
        }

        symbolsTable.put(name.toUpperCase(), value);

    }
    

    /******************************************************************************
     * getSymbol
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param name TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    protected Object getSymbol(String name) {

        if (name == null || symbolsTable == null) {
            throw new RuntimeException("name o symbolsTable es nulo.");
        }

        return symbolsTable.get(name.toUpperCase());
    }

    /******************************************************************************
     * replace
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param text TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @throws Exception TODO_javadoc.
     *
     * @since 1.0
     *
     */
    protected String replace(String text, boolean pro_numassing) throws Exception {

       // logger.debug(prefix + "entrando a 'replace(" + text + ")' ...");

        StringBuffer sb    = null;
        StringBuffer ident = null;
        Object       value = null;
        int          ini;
        boolean      next = false;

        while (true) {

            sb  = new StringBuffer();

            int i = 0;

            while (i < text.length()) {

                if (text.charAt(i) != '{') {
                    sb.append(text.charAt(i));
                }
                else {

                    ini = i;

                    i++;

                    ident = new StringBuffer();

                    while (true) {

                        if (text.charAt(i) == '{') {

                            sb.append("{" + ident.toString());

                            ini = i;

                            ident = new StringBuffer();

                            next = true;
                        }
                        else if (text.charAt(i) == '}') {

                            if ((value = symbolsTable.get(ident.toString().toUpperCase())) == null) {
                                value = "{" + ident.toString() + "}";
                            }
                            else {
                                value = symbolsTable.get(ident.toString().toUpperCase());
                                
                                if (!next)
	                                if (!pro_numassing)
		                                if (value instanceof Number) {
		                                	value = "{" + ident.toString() + "}";
		                                }
                                
                            }

                            /*
                            if (!(value instanceof String)) {
                                throw new RuntimeException("tipo de '" + value + "' debe ser String (" + value.getClass().getSimpleName() + ").");
                            }
                            */

                            sb.append(value.toString());

                            break;
                        }
                        else {
                            ident.append(text.charAt(i));
                        }

                        i++;
                    }
                }

                i++;
            }

            //

            text = sb.toString();

            if (!next) {
                break;
            }

            next = false;
        }

        return text;
    }

    /******************************************************************************
     * trimLines
     ******************************************************************************/
    /**
     *
     * @param s TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    protected String trimLines(String s) {

        try {

            ByteArrayOutputStream baos   = new ByteArrayOutputStream();
            BufferedReader        fp_in  = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(s.getBytes())));
            PrintStream           fp_out = new PrintStream(baos);
            String                line   = null;
            boolean               first  = true;

            while ((line = fp_in.readLine()) != null) {

                int i = line.length() - 1;

                while (i > -1 && Character.isWhitespace(line.charAt(i))) {
                    i--;
                }

                if (first) {
                    first = false;
                }
                else {
                    fp_out.println();
                }

                fp_out.print(line.substring(0, i + 1));
            }

            fp_in.close();
            fp_out.close();

            return new String(baos.toByteArray());

        } catch (IOException e) {
            return "";
        }
    }

    /******************************************************************************
     * printStackTrace
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param e TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    protected String printStackTrace(Throwable e) {

        CharArrayWriter caw = new CharArrayWriter();

        e.printStackTrace(new PrintWriter(caw));

        return caw.toString();
    }
}
