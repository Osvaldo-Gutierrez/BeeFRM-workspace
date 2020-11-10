/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.genfrmjava.flgparser.visitor;
import cl.bee.genfrmjava.flgparser.syntaxtree.*;
import java.util.*;

/**
 * All GJ visitors must implement this interface.
 */

public interface GJVisitor<R,A> {

   //
   // GJ Auto class visitors
   //

   public R visit(NodeList n, A argu);
   public R visit(NodeListOptional n, A argu);
   public R visit(NodeOptional n, A argu);
   public R visit(NodeSequence n, A argu);
   public R visit(NodeToken n, A argu);

    //
    // User-generated visitor methods below
    //

    /**
     * f0 -> form()
     * f1 -> ( text() )+
     * f2 -> adef()
     * f3 -> ( field() )+
     * f4 -> order()
     * f5 -> [ ( ndata() )+ ]
     * f6 -> eofrm()
     * f7 -> <EOF>
     */
    public R visit(specification n, A argu);

    /**
     * f0 -> <FORM>
     * f1 -> ( <NAME_ST_FORM> <EQUAL_ST_FORM> <STRING_ST_FORM> | <HELP_FORM> <EQUAL_ST_FORM> <STRING_ST_FORM> | <AREA_TO_CLEAR> <EQUAL_ST_FORM> <INTEGER_ST_FORM> <COLON_ST_FORM> <INTEGER_ST_FORM> | <WIDTH> <EQUAL_ST_FORM> ( <INTEGER_ST_FORM> | <CURRENT> ) | <BACKGROUND> <EQUAL_ST_FORM> <CURRENT> | <HIGHLIGHT> <EQUAL_ST_FORM> <REVERSE_FORM> | <PRE_HELP_ACTION_ROUTINE> <EQUAL_ST_FORM> <STRING_ST_FORM> | <POST_HELP_ACTION_ROUTINE> <EQUAL_ST_FORM> <STRING_ST_FORM> <COLON_ST_FORM> <STRING_ST_FORM> )+
     * f2 -> <SEMICOLON_ST_FORM>
     */
    public R visit(form n, A argu);

    /**
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
     */
    public R visit(text n, A argu);

    /**
     * f0 -> <ATTRIBUTE_DEFAULTS>
     * f1 -> <FIELD>
     * f2 -> ( field_assign() | field_attribute() )+
     * f3 -> <SEMICOLON_ST_FIELD>
     */
    public R visit(adef n, A argu);

    /**
     * f0 -> <CLEAR_CHARACTER> <EQUAL_ST_FIELD> <STRING_ST_FIELD>
     *       | <DEF> <EQUAL_ST_FIELD> <STRING_ST_FIELD>
     *       | <HELP> <EQUAL_ST_FIELD> <STRING_ST_FIELD>
     *       | <NAME_ST_FIELD> <EQUAL_ST_FIELD> <STRING_ST_FIELD> <LPAR_ST_FIELD> <INTEGER_ST_FIELD> <COMMA_ST_FIELD> <INTEGER_ST_FIELD> <RPAR_ST_FIELD>
     *       | <PICTURE> <EQUAL_ST_FIELD> [ <INTEGER_ST_FIELD> ] <STRING_ST_FIELD>
     *       | <INDEX_ST_FIELD> <EQUAL_ST_FIELD> <LPAR_ST_FIELD> <INTEGER_ST_FIELD> <COMMA_ST_FIELD> <INTEGER_ST_FIELD> <RPAR_ST_FIELD> ( <COLON_ST_FIELD> <LPAR_ST_FIELD> <INTEGER_ST_FIELD> <COMMA_ST_FIELD> <INTEGER_ST_FIELD> <RPAR_ST_FIELD> )*
     */
    public R visit(field_assign n, A argu);

    /**
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
     */
    public R visit(field_attribute n, A argu);

    /**
     * f0 -> <FIELD>
     * f1 -> ( field_assign() | field_attribute() )+
     * f2 -> <SEMICOLON_ST_FIELD>
     */
    public R visit(field n, A argu);

    /**
     * f0 -> <ORDER>
     * f1 -> <BEGIN_WITH>
     * f2 -> <EQUAL_ST_ORDER>
     * f3 -> <INTEGER_ST_ORDER>
     * f4 -> ( <NAME_ST_ORDER> <EQUAL_ST_ORDER> <STRING_ST_ORDER> )+
     * f5 -> <SEMICOLON_ST_ORDER>
     */
    public R visit(order n, A argu);

    /**
     * f0 -> <NAMED_DATA>
     * f1 -> ( <INDEX_ST_NAMED_DATA> <EQUAL_ST_NAMED_DATA> <INTEGER_ST_NAMED_DATA> | <NAME_ST_NAMED_DATA> <EQUAL_ST_NAMED_DATA> <STRING_ST_NAMED_DATA> | <DATA> <EQUAL_ST_NAMED_DATA> <STRING_ST_NAMED_DATA> )+
     * f2 -> <SEMICOLON_ST_NAMED_DATA>
     */
    public R visit(ndata n, A argu);

    /**
     * f0 -> <END_OF_FORM>
     * f1 -> <NAME>
     * f2 -> <EQUAL>
     * f3 -> <STRING>
     * f4 -> <SEMICOLON>
     */
    public R visit(eofrm n, A argu);

}
