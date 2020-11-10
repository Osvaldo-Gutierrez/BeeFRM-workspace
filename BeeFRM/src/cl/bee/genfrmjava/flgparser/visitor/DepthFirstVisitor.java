/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.genfrmjava.flgparser.visitor;


import java.io.*;

import java.util.*;

import cl.bee.genfrmjava.flgparser.syntaxtree.*;


/**
 *
 * TODO_javadoc.
 *
 * @version 1.0 (01/01/20XX).
 *
 */
public class DepthFirstVisitor implements Visitor {

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(NodeList n) {

        for (Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this);
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
     */
    public void visit(NodeListOptional n) {

        if (n.present()) {

            for (Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
                e.nextElement().accept(this);
            }
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
     */
    public void visit(NodeOptional n) {

        if (n.present()) {
            n.node.accept(this);
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
     */
    public void visit(NodeSequence n) {

        for (Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this);
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
     */
    public void visit(NodeToken n) {}

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> form()
     * f1 -> ( text() )+
     * f2 -> adef()
     * f3 -> ( field() )+
     * f4 -> order()
     * f5 -> [ ( ndata() )+ ]
     * f6 -> eofrm()
     * f7 -> <EOF>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(specification n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
        n.f5.accept(this);
        n.f6.accept(this);
        n.f7.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <FORM>
     * f1 -> ( <NAME_ST_FORM> <EQUAL_ST_FORM> <STRING_ST_FORM> | <HELP_FORM> <EQUAL_ST_FORM> <STRING_ST_FORM> | <AREA_TO_CLEAR> <EQUAL_ST_FORM> <INTEGER_ST_FORM> <COLON_ST_FORM> <INTEGER_ST_FORM> | <WIDTH> <EQUAL_ST_FORM> ( <INTEGER_ST_FORM> | <CURRENT> ) | <BACKGROUND> <EQUAL_ST_FORM> <CURRENT> | <HIGHLIGHT> <EQUAL_ST_FORM> <REVERSE_FORM> | <PRE_HELP_ACTION_ROUTINE> <EQUAL_ST_FORM> <STRING_ST_FORM> | <POST_HELP_ACTION_ROUTINE> <EQUAL_ST_FORM> <STRING_ST_FORM> <COLON_ST_FORM> <STRING_ST_FORM> )+
     * f2 -> <SEMICOLON_ST_FORM>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(form n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <TEXT>
     * f1 -> <LPAR_ST_TEXT>
     * f2 -> <INTEGER_ST_TEXT>
     * f3 -> <COMMA_ST_TEXT>
     * f4 -> <INTEGER_ST_TEXT>
     * f5 -> <RPAR_ST_TEXT>
     * f6 -> [ <INTEGER_ST_TEXT> ]
     * f7 -> <STRING_ST_TEXT>
     * f8 -> [ <AMPERSAND> <STRING_ST_TEXT> ]
     * f9 -> ( <BOLD_TEXT> | <BLINK> )*
     * f10 -> <SEMICOLON_ST_TEXT>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(text n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
        n.f5.accept(this);
        n.f6.accept(this);
        n.f7.accept(this);
        n.f8.accept(this);
        n.f9.accept(this);
        n.f10.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <ATTRIBUTE_DEFAULTS>
     * f1 -> <FIELD>
     * f2 -> ( field_assign() | field_attribute() )+
     * f3 -> <SEMICOLON_ST_FIELD>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(adef n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <CLEAR_CHARACTER> <EQUAL_ST_FIELD> <STRING_ST_FIELD>
     *       | <DEF> <EQUAL_ST_FIELD> <STRING_ST_FIELD>
     *       | <HELP> <EQUAL_ST_FIELD> <STRING_ST_FIELD>
     *       | <NAME_ST_FIELD> <EQUAL_ST_FIELD> <STRING_ST_FIELD> <LPAR_ST_FIELD> <INTEGER_ST_FIELD> <COMMA_ST_FIELD> <INTEGER_ST_FIELD> <RPAR_ST_FIELD>
     *       | <PICTURE> <EQUAL_ST_FIELD> [ <INTEGER_ST_FIELD> ] <STRING_ST_FIELD>
     *       | <INDEX_ST_FIELD> <EQUAL_ST_FIELD> <LPAR_ST_FIELD> <INTEGER_ST_FIELD> <COMMA_ST_FIELD> <INTEGER_ST_FIELD> <RPAR_ST_FIELD> ( <COLON_ST_FIELD> <LPAR_ST_FIELD> <INTEGER_ST_FIELD> <COMMA_ST_FIELD> <INTEGER_ST_FIELD> <RPAR_ST_FIELD> )*
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(field_assign n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <BLANK_FILL>
     *       | <DISPLAY_ONLY>
     *       | <ECHO>
     *       | <FIXED_DECIMAL>
     *       | <LEFT_JUSTIFIED>
     *       | <NOAUTOTAB>
     *       | <NOBLINKING>
     *       | <NOBOLD>
     *       | <NODISPLAY_ONLY>
     *       | <NOECHO>
     *       | <NOFIXED_DECIMAL>
     *       | <NOREVERSE>
     *       | <NOSUPERVISOR_ONLY>
     *       | <NOSUPPRESS>
     *       | <NOUNDERLINE>
     *       | <NOUPPERCASE>
     *       | <RESPONSE_REQUIRED>
     *       | <REVERSE>
     *       | <RIGHT_JUSTIFIED>
     *       | <SUPPRESS>
     *       | <ZERO_FILL>
     *       | <BOLD_FIELD>
     *       | <UNDERLINE>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(field_attribute n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <FIELD>
     * f1 -> ( field_assign() | field_attribute() )+
     * f2 -> <SEMICOLON_ST_FIELD>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(field n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <ORDER>
     * f1 -> <BEGIN_WITH>
     * f2 -> <EQUAL_ST_ORDER>
     * f3 -> <INTEGER_ST_ORDER>
     * f4 -> ( <NAME_ST_ORDER> <EQUAL_ST_ORDER> <STRING_ST_ORDER> )+
     * f5 -> <SEMICOLON_ST_ORDER>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(order n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
        n.f5.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <NAMED_DATA>
     * f1 -> ( <INDEX_ST_NAMED_DATA> <EQUAL_ST_NAMED_DATA> <INTEGER_ST_NAMED_DATA> | <NAME_ST_NAMED_DATA> <EQUAL_ST_NAMED_DATA> <STRING_ST_NAMED_DATA> | <DATA> <EQUAL_ST_NAMED_DATA> <STRING_ST_NAMED_DATA> )+
     * f2 -> <SEMICOLON_ST_NAMED_DATA>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ndata n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <END_OF_FORM>
     * f1 -> <NAME>
     * f2 -> <EQUAL>
     * f3 -> <STRING>
     * f4 -> <SEMICOLON>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(eofrm n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
    }

}
