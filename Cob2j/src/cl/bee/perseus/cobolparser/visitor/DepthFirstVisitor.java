/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.perseus.cobolparser.visitor;


import java.io.*;

import java.util.*;

import cl.bee.perseus.cobolparser.syntaxtree.*;


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
     * f0 -> <COBOL_WORD>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(CobolWord n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( IterableQuotedText() )+
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(QuotedText n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <QUOTEDSTRING>
     *       | <DOUBLEDQUOTECHAR>
     *       | <DOUBLEDAPOSTROPHE>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(IterableQuotedText n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <LEVEL_66>
     *       | <LEVEL_77>
     *       | <LEVEL_88>
     *       | <INTEGER>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(IntegerConstant n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> [ <PLUSCHAR> | <MINUSCHAR> ]
     * f1 -> ( IntegerConstant() | <REAL> )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(NumericConstant n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <INTEGER>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(LevelNumber n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <ZERO>
     *       | <ZEROS>
     *       | <ZEROES>
     *       | <SPACE>
     *       | <SPACES>
     *       | <HIGH_VALUE>
     *       | <HIGH_VALUES>
     *       | <LOW_VALUE>
     *       | <LOW_VALUES>
     *       | <QUOTE>
     *       | <QUOTES>
     *       | <NULL>
     *       | <NULLS>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(FigurativeConstant n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( QuotedText() | <HEXNUMBER> )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(NonNumericConstant n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( IterableQuotedText() | <HEXNUMBER> )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(IterableNonNumericConstant n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> [ <ALL> ]
     * f1 -> ( NonNumericConstant() | NumericConstant() | FigurativeConstant() )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(Literal n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> [ <ALL> ]
     * f1 -> ( IterableNonNumericConstant() | NumericConstant() | FigurativeConstant() )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(IterableLiteral n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ArithmeticExpression()
     *       | <LPARENCHAR> Condition() <RPARENCHAR>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(IterableCondition n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> CombinableCondition()
     * f1 -> ( ( <AND> | <OR> ) ( CombinableCondition() | AbbreviationRest() ) )*
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(Condition n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> [ <NOT> ]
     * f1 -> SimpleCondition()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(CombinableCondition n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> RelationCondition()
     *       | ArithmeticExpression()
     *       | <LPARENCHAR> Condition() <RPARENCHAR>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(SimpleCondition n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> [ <IS> ]
     * f1 -> [ <NOT> ]
     * f2 -> ( <NUMERIC> | <ALPHABETIC> | <ALPHABETIC_LOWER> | <ALPHABETIC_UPPER> | ClassName() | <DBCS> | <KANJI> )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ClassCondition n) {

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
     * f0 -> ArithmeticExpression()
     * f1 -> ( AbbreviationRest() | SignCondition() | ClassCondition() )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(RelationCondition n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> [ <IS> ]
     * f1 -> [ <NOT> ]
     * f2 -> ( <POSITIVE> | <NEGATIVE> | <ZERO> | <ZEROS> | <ZEROES> )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(SignCondition n) {

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
     * f0 -> [ <IS> ]
     * f1 -> [ <NOT> ]
     * f2 -> ( <GREATER> [ <THAN> ] [ <OR> <EQUAL> [ <TO> ] ] | <MORETHANCHAR> | <LESS> [ <THAN> ] [ <OR> <EQUAL> [ <TO> ] ] | <LESSTHANCHAR> | <EQUAL> [ <TO> ] | <EQUALCHAR> | <NOTEQUAL> | <MORETHANOREQUAL> | <LESSTHANOREQUAL> )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(RelationalOperator n) {

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
     * f0 -> ArithmeticExpression()
     *       | <LPARENCHAR> AbbreviationLeaf() ( ( <AND> | <OR> ) AbbreviationLeaf() )+ <RPARENCHAR>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(AbbreviationLeaf n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> RelationalOperator()
     * f1 -> AbbreviationLeaf()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(AbbreviationRest n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( ParagraphName() [ ( <IN> | <OF> ) SectionName() ] | SectionName() )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ProcedureName n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <LPARENCHAR>
     * f1 -> ArithmeticExpression()
     * f2 -> ( [ <COMMACHAR> ] ArithmeticExpression() )*
     * f3 -> <RPARENCHAR>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(Subscript n) {

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
     * f0 -> <FUNCTION>
     * f1 -> FunctionName()
     * f2 -> [ Subscript() ]
     * f3 -> [ <LPARENCHAR> LeftmostCharacterPosition() <COLONCHAR> [ Length() ] <RPARENCHAR> ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(FunctionClause n) {

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
     * f0 -> ( QualifiedDataName() ( Subscript() )* [ <LPARENCHAR> LeftmostCharacterPosition() <COLONCHAR> [ Length() ] <RPARENCHAR> ] | <LINAGE_COUNTER> [ ( <IN> | <OF> ) FileName() ] | <PROGRAM_STATUS> )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(Identifier n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( DataName() ( ( <IN> | <OF> ) DataName() )* [ ( <IN> | <OF> ) FileName() ] | SpecialRegister() )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(QualifiedDataName n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ArithmeticExpression()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(Length n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ArithmeticExpression()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(LeftmostCharacterPosition n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> CobolWord()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(Mode n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> CobolWord()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(AlphabetName n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> CobolWord()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ClassName n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> CobolWord()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ConditionName n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> CobolWord()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(DataName n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> CobolWord()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(FileName n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> CobolWord()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(IndexName n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> CobolWord()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(MnemonicName n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> Identifier()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(RecordName n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> CobolWord()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(RoutineName n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> CobolWord()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(SymbolicCharacter n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> CobolWord()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(LibraryName n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> CobolWord()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ProgramName n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> IntegerConstant()
     *       | CobolWord()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(SectionName n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> IntegerConstant()
     *       | CobolWord()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ParagraphName n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> CobolWord()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(SystemName n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> SystemName()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ComputerName n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> SystemName()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(LanguageName n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> SystemName()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(EnvironmentName n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> SystemName()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(AssignmentName n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ProgramName()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(BasisName n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( CobolWord() | <LENGTH> | <WHEN_COMPILED> | <SUM> | <RANDOM> )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(FunctionName n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( <ADDRESS> <OF> DataName() | <DEBUG_ITEM> | <LENGTH> <OF> Identifier() | <RETURN_CODE> | <SHIFT_OUT> | <SHIFT_IN> | <SORT_CONTROL> | <SORT_CORE_SIZE> | <SORT_FILE_SIZE> | <SORT_MESSAGE> | <SORT_MODE_SIZE> | <SORT_RETURN> | <TALLY> | <WHEN_COMPILED> )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(SpecialRegister n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> CobolWord()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(CdName n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> CobolWord()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ConventionName n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> CobolWord()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(HandleComponent n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> QuotedText()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ImplicitTitle n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> DataName()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(LevelName66 n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> DataName()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(LevelName77 n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ConditionName()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(LevelName88 n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> [ DataName() | <FILLER> | <REPLY> | <PROGRAM_STATUS> ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(LevelName n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> TimesDiv()
     * f1 -> ( ( <PLUSCHAR> | <MINUSCHAR> ) TimesDiv() )*
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ArithmeticExpression n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> Power()
     * f1 -> ( ( <ASTERISKCHAR> | <SLASHCHAR> ) Power() )*
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(TimesDiv n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> [ ( <PLUSCHAR> | <MINUSCHAR> ) ]
     * f1 -> Basis()
     * f2 -> ( <POWEROF> Basis() )*
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(Power n) {

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
     * f0 -> ( FunctionClause() | Identifier() | Literal() | <ALL> | <LPARENCHAR> ArithmeticExpression() <RPARENCHAR> )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(Basis n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( ( NonDotChars() | Literal() )+ [ <DOT> ] )+
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(CommentLine n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ProgramUnit()
     * f1 -> ( NestedProgramUnit() EndProgramStatement() )*
     * f2 -> [ EndProgramStatement() ( CompilationUnit() )* ]
     * f3 -> <EOF>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(CompilationUnit n) {

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
     * f0 -> IdentificationDivision()
     * f1 -> [ EnvironmentDivision() ]
     * f2 -> [ DataDivision() ]
     * f3 -> [ ProcedureDivision() ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ProgramUnit n) {

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
     * f0 -> NestedIdentificationDivision()
     * f1 -> [ EnvironmentDivision() ]
     * f2 -> [ DataDivision() ]
     * f3 -> [ ProcedureDivision() ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(NestedProgramUnit n) {

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
     * f0 -> <END>
     * f1 -> <PROGRAM>
     * f2 -> ProgramName()
     * f3 -> <DOT>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(EndProgramStatement n) {

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
     * f0 -> LinkageSectionEntry()
     * f1 -> <EOF>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(CopyBookUnit n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( <IDENTIFICATION> | <ID> )
     * f1 -> <DIVISION>
     * f2 -> <DOT>
     * f3 -> ProgramIdParagraph()
     * f4 -> ( IdentificationDivisionParagraph() )*
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(IdentificationDivision n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( <IDENTIFICATION> | <ID> )
     * f1 -> <DIVISION>
     * f2 -> <DOT>
     * f3 -> NestedProgramIdParagraph()
     * f4 -> ( IdentificationDivisionParagraph() )*
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(NestedIdentificationDivision n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> InstallationParagraph()
     *       | SecurityParagraph()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(IdentificationDivisionParagraph n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <PROGRAM_ID>
     * f1 -> <DOT>
     * f2 -> ProgramName()
     * f3 -> [ [ <IS> ] <INITIAL> [ <PROGRAM> ] ]
     * f4 -> <DOT>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ProgramIdParagraph n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <PROGRAM_ID>
     * f1 -> <DOT>
     * f2 -> ProgramName()
     * f3 -> [ [ <IS> ] InitialOrCommon() [ <PROGRAM> ] ]
     * f4 -> <DOT>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(NestedProgramIdParagraph n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( <INITIAL> [ <COMMON> ] | <COMMON> [ <INITIAL> ] )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(InitialOrCommon n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <INSTALLATION>
     * f1 -> <DOT>
     * f2 -> [ CommentLine() ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(InstallationParagraph n) {

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
     * f0 -> <SECURITY>
     * f1 -> <DOT>
     * f2 -> [ CommentLine() ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(SecurityParagraph n) {

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
     * f0 -> <ENVIRONMENT>
     * f1 -> <DIVISION>
     * f2 -> <DOT>
     * f3 -> ( EnvironmentSection() )*
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(EnvironmentDivision n) {

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
     * f0 -> ConfigurationSection()
     *       | InputOutputSection()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(EnvironmentSection n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <CONFIGURATION>
     * f1 -> <SECTION>
     * f2 -> <DOT>
     * f3 -> ( ConfigurationSectionParagraph() )*
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ConfigurationSection n) {

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
     * f0 -> SourceComputerParagraph()
     *       | ObjectComputerParagraph()
     *       | SpecialNamesParagraph()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ConfigurationSectionParagraph n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <SOURCE_COMPUTER>
     * f1 -> <DOT>
     * f2 -> ComputerName()
     * f3 -> [ [ <WITH> ] <DEBUGGING> <MODE> ]
     * f4 -> <DOT>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(SourceComputerParagraph n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <OBJECT_COMPUTER>
     * f1 -> <DOT>
     * f2 -> ComputerName()
     * f3 -> ( ObjectComputerClause() )*
     * f4 -> <DOT>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ObjectComputerParagraph n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> MemorySizeClause()
     *       | CollatingSequenceClause()
     *       | SegmentLimitClause()
     *       | CharacterSetClause()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ObjectComputerClause n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <MEMORY>
     * f1 -> [ <SIZE> ]
     * f2 -> IntegerConstant()
     * f3 -> [ <WORDS> | <CHARACTERS> | <MODULES> ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(MemorySizeClause n) {

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
     * f0 -> [ <PROGRAM> ]
     * f1 -> [ <COLLATING> ]
     * f2 -> <SEQUENCE>
     * f3 -> [ <IS> ]
     * f4 -> AlphabetName()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(CollatingSequenceClause n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( <SEGMENT_LIMIT> | <SEGMENT> <LIMIT> )
     * f1 -> [ <IS> ]
     * f2 -> IntegerConstant()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(SegmentLimitClause n) {

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
     * f0 -> <CHARACTER>
     * f1 -> <SET>
     * f2 -> [ CommentLine() ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(CharacterSetClause n) {

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
     * f0 -> <SPECIAL_NAMES>
     * f1 -> <DOT>
     * f2 -> [ ( SpecialNameClause() )+ <DOT> ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(SpecialNamesParagraph n) {

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
     * f0 -> AlphabetClause()
     *       | ClassClause()
     *       | CurrencySignClause()
     *       | DecimalPointClause()
     *       | SymbolicCharactersClause()
     *       | CallConventionClause()
     *       | EnvironmentNameIsMnemonicNameClause()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(SpecialNameClause n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( <THROUGH> | <THRU> ) IterableLiteral()
     *       | ( <ALSO> IterableLiteral() )+
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(IterableAlphabetPhrase n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <ALPHABET>
     * f1 -> AlphabetName()
     * f2 -> [ <IS> ]
     * f3 -> ( <STANDARD_1> | <STANDARD_2> | <NATIVE> | CobolWord() | ( IterableLiteral() [ IterableAlphabetPhrase() ] )+ )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(AlphabetClause n) {

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
     * f0 -> <CLASS>
     * f1 -> ClassName()
     * f2 -> [ <IS> ]
     * f3 -> ( ( Identifier() | IterableLiteral() ) [ ( <THROUGH> | <THRU> ) ( Identifier() | IterableLiteral() ) ] )+
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ClassClause n) {

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
     * f0 -> <CURRENCY>
     * f1 -> [ <SIGN> ]
     * f2 -> [ <IS> ]
     * f3 -> Literal()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(CurrencySignClause n) {

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
     * f0 -> <DECIMAL_POINT>
     * f1 -> [ <IS> ]
     * f2 -> <COMMA>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(DecimalPointClause n) {

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
     * f0 -> <SYMBOLIC>
     * f1 -> [ <CHARACTERS> ]
     * f2 -> ( ( SymbolicCharacter() )+ [ ( <ARE> | <IS> ) ] ( NumericConstant() | <HEXNUMBER> )+ )+
     * f3 -> [ <IN> AlphabetName() ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(SymbolicCharactersClause n) {

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
     * f0 -> <CALL_CONVENTION>
     * f1 -> IntegerConstant()
     * f2 -> [ <IS> ]
     * f3 -> ConventionName()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(CallConventionClause n) {

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
     * f0 -> EnvironmentName()
     * f1 -> ( [ <IS> ] MnemonicName() [ SpecialNamesParagraphStatusPhrase() ] | SpecialNamesParagraphStatusPhrase() )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(EnvironmentNameIsMnemonicNameClause n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( <ON> [ <STATUS> ] [ <IS> ] IterableCondition() [ <OFF> [ <STATUS> ] [ <IS> ] IterableCondition() ] | <OFF> [ <STATUS> ] [ <IS> ] IterableCondition() [ <ON> [ <STATUS> ] [ <IS> ] IterableCondition() ] )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(SpecialNamesParagraphStatusPhrase n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <INPUT_OUTPUT>
     * f1 -> <SECTION>
     * f2 -> <DOT>
     * f3 -> ( InputOutputSectionParagraph() )*
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(InputOutputSection n) {

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
     * f0 -> FileControlParagraph()
     *       | IOControlParagraph()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(InputOutputSectionParagraph n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <FILE_CONTROL>
     * f1 -> ( [ <DOT> ] FileControlEntry() )*
     * f2 -> <DOT>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(FileControlParagraph n) {

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
     * f0 -> SelectClause()
     * f1 -> ( FileControlClause() )*
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(FileControlEntry n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> AssignClause()
     *       | ReserveClause()
     *       | OrganizationClause()
     *       | PaddingCharacterClause()
     *       | RecordDelimiterClause()
     *       | AccessModeClause()
     *       | RecordKeyClause()
     *       | AlternateRecordKeyClause()
     *       | FileStatusClause()
     *       | PasswordClause()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(FileControlClause n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <SELECT>
     * f1 -> [ <OPTIONAL> ]
     * f2 -> FileName()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(SelectClause n) {

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
     * f0 -> <ASSIGN>
     * f1 -> [ <TO> ]
     * f2 -> ( AssignmentName() | Literal() )
     * f3 -> [ <USING> ( AssignmentName() | Literal() ) ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(AssignClause n) {

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
     * f0 -> <RESERVE>
     * f1 -> IntegerConstant()
     * f2 -> [ <AREA> | <AREAS> ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ReserveClause n) {

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
     * f0 -> [ <ORGANIZATION> [ <IS> ] ]
     * f1 -> ( SequentialOrganizationClause() | LineSequentialOrganizationClause() | RelativeOrganizationClause() | IndexedOrganizationClause() )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(OrganizationClause n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <SEQUENTIAL>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(SequentialOrganizationClause n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <LINE>
     * f1 -> <SEQUENTIAL>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(LineSequentialOrganizationClause n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <RELATIVE>
     * f1 -> [ Identifier() ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(RelativeOrganizationClause n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <INDEXED>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(IndexedOrganizationClause n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <PADDING>
     * f1 -> [ <CHARACTER> ]
     * f2 -> [ <IS> ]
     * f3 -> ( Identifier() | Literal() )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(PaddingCharacterClause n) {

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
     * f0 -> <RECORD>
     * f1 -> <DELIMITER>
     * f2 -> [ <IS> ]
     * f3 -> ( <STANDARD_1> | <IMPLICIT> | AssignmentName() )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(RecordDelimiterClause n) {

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
     * f0 -> <ACCESS>
     * f1 -> [ <MODE> ]
     * f2 -> [ <IS> ]
     * f3 -> ( SequentialAccessMode() | RandomAccessMode() | DynamicAccessMode() )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(AccessModeClause n) {

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
     * f0 -> <SEQUENTIAL>
     * f1 -> [ RelativeKeyClause() ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(SequentialAccessMode n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <RANDOM>
     * f1 -> [ RelativeKeyClause() ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(RandomAccessMode n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <DYNAMIC>
     * f1 -> [ RelativeKeyClause() ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(DynamicAccessMode n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <RELATIVE>
     * f1 -> [ <KEY> ]
     * f2 -> [ <IS> ]
     * f3 -> Identifier()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(RelativeKeyClause n) {

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
     * f0 -> <RECORD>
     * f1 -> [ <KEY> ]
     * f2 -> [ <IS> ]
     * f3 -> Identifier()
     * f4 -> [ PasswordClause() ]
     * f5 -> [ [ <WITH> ] <DUPLICATES> ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(RecordKeyClause n) {

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
     * f0 -> <ALTERNATE>
     * f1 -> RecordKeyClause()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(AlternateRecordKeyClause n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <PASSWORD>
     * f1 -> [ <IS> ]
     * f2 -> DataName()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(PasswordClause n) {

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
     * f0 -> [ <FILE> ]
     * f1 -> <STATUS>
     * f2 -> [ <IS> ]
     * f3 -> Identifier()
     * f4 -> [ Identifier() ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(FileStatusClause n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <I_O_CONTROL>
     * f1 -> ( [ <DOT> ] IOControlClause() )*
     * f2 -> <DOT>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(IOControlParagraph n) {

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
     * f0 -> RerunClause()
     *       | SameAreaClause()
     *       | MultipleFileClause()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(IOControlClause n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <RERUN>
     * f1 -> [ <ON> ( AssignmentName() | FileName() ) ]
     * f2 -> <EVERY>
     * f3 -> ( Rerun2() | IntegerConstant() [ <CLOCK_UNITS> ] )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(RerunClause n) {

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
     * f0 -> IntegerConstant() <RECORDS>
     *       | [ <END> ] [ <OF> ] ( <REEL> | <UNIT> ) <OF> FileName()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(Rerun2 n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <SAME>
     * f1 -> [ <RECORD> | <SORT> | <SORT_MERGE> ]
     * f2 -> [ <AREA> ]
     * f3 -> [ <FOR> ]
     * f4 -> ( FileName() )+
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(SameAreaClause n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <MULTIPLE>
     * f1 -> <FILE>
     * f2 -> [ <TAPE> ]
     * f3 -> [ <CONTAINS> ]
     * f4 -> ( FileName() [ [ <POSITION> ] IntegerConstant() ] )+
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(MultipleFileClause n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <DATA>
     * f1 -> <DIVISION>
     * f2 -> <DOT>
     * f3 -> ( DataDivisionSection() )*
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(DataDivision n) {

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
     * f0 -> FileSection()
     *       | WorkingStorageSection()
     *       | LinkageSection()
     *       | CommunicationSection()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(DataDivisionSection n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <FILE>
     * f1 -> <SECTION>
     * f2 -> <DOT>
     * f3 -> ( FileAndSortDescriptionEntry() ( DataDescriptionEntry() )* )*
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(FileSection n) {

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
     * f0 -> ( <FD> | <SD> )
     * f1 -> FileName()
     * f2 -> ( [ <DOT> ] FileAndSortDescriptionEntryClause() )*
     * f3 -> <DOT>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(FileAndSortDescriptionEntry n) {

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
     * f0 -> ExternalClause()
     *       | GlobalClause()
     *       | BlockContainsClause()
     *       | RecordContainsClause()
     *       | LabelRecordsClause()
     *       | ValueOfClause()
     *       | DataRecordClause()
     *       | LinageClause()
     *       | CodeSetClause()
     *       | ReportClause()
     *       | RecordingModeClause()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(FileAndSortDescriptionEntryClause n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> [ <IS> ]
     * f1 -> <EXTERNAL>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ExternalClause n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> [ <IS> ]
     * f1 -> <GLOBAL>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(GlobalClause n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <BLOCK>
     * f1 -> [ <CONTAINS> ]
     * f2 -> IntegerConstant()
     * f3 -> [ <TO> IntegerConstant() ]
     * f4 -> [ <RECORDS> | <CHARACTERS> ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(BlockContainsClause n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <RECORD>
     * f1 -> [ <CONTAINS> ]
     * f2 -> ( IntegerConstant() [ <TO> IntegerConstant() ] [ <CHARACTERS> ] | [ <IS> ] <VARYING> [ <IN> ] [ <SIZE> ] [ [ <FROM> ] IntegerConstant() [ <TO> IntegerConstant() ] [ <CHARACTERS> ] ] [ <DEPENDING> [ <ON> ] Identifier() ] )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(RecordContainsClause n) {

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
     * f0 -> <LABEL>
     * f1 -> ( <RECORD> [ ( <IS> | <ARE> ) ] | <RECORDS> [ ( <IS> | <ARE> ) ] )
     * f2 -> ( <OMITTED> | <STANDARD> | ( DataName() )+ )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(LabelRecordsClause n) {

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
     * f0 -> <VALUE>
     * f1 -> <OF>
     * f2 -> ( SystemName() <IS> ( Identifier() | Literal() ) )+
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ValueOfClause n) {

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
     * f0 -> <DATA>
     * f1 -> ( <RECORD> [ <IS> ] | <RECORDS> [ <ARE> ] )
     * f2 -> ( DataName() )+
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(DataRecordClause n) {

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
     * f0 -> <LINAGE>
     * f1 -> [ <IS> ]
     * f2 -> ( DataName() | IntegerConstant() )
     * f3 -> [ <LINES> ]
     * f4 -> ( [ <WITH> ] <FOOTING> [ <AT> ] ( DataName() | IntegerConstant() ) | [ <LINES> ] [ <AT> ] ( <TOP> | <BOTTOM> ) ( DataName() | IntegerConstant() ) )*
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(LinageClause n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <RECORDING>
     * f1 -> [ <MODE> ]
     * f2 -> [ <IS> ]
     * f3 -> Mode()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(RecordingModeClause n) {

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
     * f0 -> <CODE_SET>
     * f1 -> [ <IS> ]
     * f2 -> AlphabetName()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(CodeSetClause n) {

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
     * f0 -> ( <REPORT> [ <IS> ] | <REPORTS> [ <ARE> ] )
     * f1 -> ( Identifier() )+
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ReportClause n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( <LEVEL_66> LevelName66() RenamesClause() <DOT> | <LEVEL_77> LevelName77() ( DataDescriptionEntryClause() )* <DOT> | <LEVEL_88> LevelName88() ConditionValueClause() <DOT> | LevelNumber() LevelName() ( DataDescriptionEntryClause() )* <DOT> | ExecStatement() <DOT> )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(DataDescriptionEntry n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> DataPictureClause()
     *       | DataValueClause()
     *       | DataUsageClause()
     *       | DataRedefinesClause()
     *       | DataExternalClause()
     *       | DataGlobalClause()
     *       | DataIdentifiedClause()
     *       | DataSignClause()
     *       | DataOccursClause()
     *       | DataSynchronizedClause()
     *       | DataJustifiedClause()
     *       | DataBlankWhenZeroClause()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(DataDescriptionEntryClause n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <REDEFINES>
     * f1 -> DataName()
     * f2 -> [ DataPictureClause() ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(DataRedefinesClause n) {

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
     * f0 -> <BLANK>
     * f1 -> [ <WHEN> ]
     * f2 -> ( <ZERO> | <ZEROS> | <ZEROES> )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(DataBlankWhenZeroClause n) {

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
     * f0 -> ( <JUSTIFIED> | <JUST> )
     * f1 -> [ <RIGHT> ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(DataJustifiedClause n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <OCCURS>
     * f1 -> IntegerConstant()
     * f2 -> [ <TO> IntegerConstant() ]
     * f3 -> [ <TIMES> ]
     * f4 -> [ <DEPENDING> [ <ON> ] Identifier() ]
     * f5 -> ( ( <ASCENDING> | <DESCENDING> ) [ <KEY> ] [ <IS> ] ( Identifier() )+ )*
     * f6 -> [ <INDEXED> [ <BY> ] IndexName() ( [ <COMMACHAR> ] IndexName() )* ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(DataOccursClause n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
        n.f5.accept(this);
        n.f6.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( <PICTURE> | <PIC> )
     * f1 -> [ <IS> ]
     * f2 -> <PICTURE_STRING>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(DataPictureClause n) {

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
     * f0 -> <DOLLARCHAR>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(PictureCurrency n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> IntegerConstant()
     *       | CobolWord()
     *       | PictureCurrency()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(NonDotChars n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> [ <IS> ]
     * f1 -> <EXTERNAL>
     * f2 -> [ <BY> Literal() ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(DataExternalClause n) {

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
     * f0 -> [ <IS> ]
     * f1 -> <GLOBAL>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(DataGlobalClause n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> [ <IS> ]
     * f1 -> <IDENTIFIED>
     * f2 -> <BY>
     * f3 -> Literal()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(DataIdentifiedClause n) {

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
     * f0 -> [ <USAGE> [ <IS> ] ]
     * f1 -> ( MemoryUsage() | ExternalUsage() | PropertyObjectModifier() )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(DataUsageClause n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
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
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(MemoryUsage n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <INDEX>
     *       | <POINTER>
     *       | <PROCEDURE_POINTER>
     *       | <PROCEDURE> <POINTER>
     *       | <STRING>
     *       | <JPACKED_DECIMAL>
     *       | <JSTRING>
     *       | <JBYTE>
     *       | <JSHORT>
     *       | <JINT>
     *       | <JLONG>
     *       | <JBOOLEAN>
     *       | <JFLOAT>
     *       | <JDOUBLE>
     *       | <JCHAR>
     *       | <ALPHANUMERIC_HASHTABLE>
     *       | <NUMERIC_HASHTABLE>
     *       | <OBJECT_HASHTABLE>
     *       | <OBJECT> <REFERENCE> [ [ <OF> ] ( ClassName() | Literal() ) ]
     *       | ( <OBJECT> | <COMPONENT> ) [ [ <OF> ] ClassName() ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ExternalUsage n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <CHARACTER>
     *       | <BINARY_BYTE>
     *       | <BINARY_SHORT>
     *       | <BINARY>
     *       | <BINARY_LONG>
     *       | <BINARY_DOUBLE>
     *       | <FLOAT_SHORT>
     *       | <FLOAT_LONG>
     *       | <BIT>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(PropertyObjectModifier n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> [ <SIGN> [ <IS> ] ]
     * f1 -> ( <LEADING> | <TRAILING> )
     * f2 -> [ <SEPARATE> [ <CHARACTER> ] ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(DataSignClause n) {

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
     * f0 -> ( <SYNCHRONIZED> | <SYNC> )
     * f1 -> [ ( <LEFT> | <RIGHT> ) ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(DataSynchronizedClause n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( <VALUE> [ <IS> ] | <VALUES> [ <ARE> ] )
     * f1 -> Through()
     * f2 -> ( [ <COMMACHAR> ] Through() )*
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(DataValueClause n) {

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
     * f0 -> IterableLiteral()
     * f1 -> [ ( <THROUGH> | <THRU> ) IterableLiteral() ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(Through n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> DataValueClause()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ConditionValueClause n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <RENAMES>
     * f1 -> Identifier()
     * f2 -> [ ( <THROUGH> | <THRU> ) Identifier() ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(RenamesClause n) {

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
     * f0 -> ( CommunicationInputEntry() | CommunicationOutputEntry() | CommunicationIOEntry() )
     * f1 -> <DOT>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(CommunicationDescriptionEntry n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <CD>
     * f1 -> CdName()
     * f2 -> [ <FOR> ]
     * f3 -> [ <INITIAL> ]
     * f4 -> <INPUT>
     * f5 -> ( CommunicationInputClause() )*
     * f6 -> ( DataName() )*
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(CommunicationInputEntry n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
        n.f5.accept(this);
        n.f6.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <CD>
     * f1 -> CdName()
     * f2 -> [ <FOR> ]
     * f3 -> <OUTPUT>
     * f4 -> ( CommunicationOutputClause() )*
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(CommunicationOutputEntry n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <CD>
     * f1 -> CdName()
     * f2 -> [ <FOR> ]
     * f3 -> [ <INITIAL> ]
     * f4 -> <I_O>
     * f5 -> ( CommunicationIOClause() )*
     * f6 -> ( DataName() )*
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(CommunicationIOEntry n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
        n.f5.accept(this);
        n.f6.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <MESSAGE> ( <DATE> | <TIME> | <COUNT> ) [ <IS> ] DataName()
     *       | <TEXT> <LENGTH> [ <IS> ] DataName()
     *       | <END> <KEY> [ <IS> ] DataName()
     *       | <STATUS> <KEY> [ <IS> ] DataName()
     *       | <COUNT> [ <IS> ] DataName()
     *       | [ <SYMBOLIC> ] ( <QUEUE> | <SUB_QUEUE_1> | <SUB_QUEUE_2> | <SUB_QUEUE_3> | <SOURCE> ) [ <IS> ] DataName()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(CommunicationInputClause n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <DESTINATION> <COUNT> [ <IS> ] DataName()
     *       | <TEXT> <LENGTH> [ <IS> ] DataName()
     *       | <STATUS> <KEY> [ <IS> ] DataName()
     *       | [ <SYMBOLIC> ] <DESTINATION> [ <IS> ] DataName()
     *       | <DESTINATION> <TABLE> <OCCURS> IntegerConstant() [ <TIMES> ] [ <INDEXED> [ <BY> ] ( IndexName() )+ ]
     *       | <ERROR> <KEY> [ <IS> ] DataName()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(CommunicationOutputClause n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <MESSAGE> ( <DATE> | <TIME> ) [ <IS> ] DataName()
     *       | <TEXT> <LENGTH> [ <IS> ] DataName()
     *       | <END> <KEY> [ <IS> ] DataName()
     *       | <STATUS> <KEY> [ <IS> ] DataName()
     *       | [ <SYMBOLIC> ] <TERMINAL> [ <IS> ] DataName()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(CommunicationIOClause n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <WORKING_STORAGE>
     * f1 -> <SECTION>
     * f2 -> <DOT>
     * f3 -> ( DataDescriptionEntry() )*
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(WorkingStorageSection n) {

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
     * f0 -> ( DataDescriptionEntry() )*
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(LinkageSectionEntry n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <LINKAGE>
     * f1 -> <SECTION>
     * f2 -> <DOT>
     * f3 -> LinkageSectionEntry()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(LinkageSection n) {

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
     * f0 -> <COMMUNICATION>
     * f1 -> <SECTION>
     * f2 -> <DOT>
     * f3 -> ( CommunicationDescriptionEntry() ( DataDescriptionEntry() )* )*
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(CommunicationSection n) {

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
     * f0 -> <PROCEDURE>
     * f1 -> <DIVISION>
     * f2 -> [ ConventionName() ]
     * f3 -> [ <USING> ( DataName() )+ ]
     * f4 -> <DOT>
     * f5 -> [ Declaratives() ]
     * f6 -> ProcedureBody()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ProcedureDivision n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
        n.f5.accept(this);
        n.f6.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <DECLARATIVES>
     * f1 -> <DOT>
     * f2 -> ( SectionHeader() <DOT> UseStatement() <DOT> Paragraphs() )+
     * f3 -> <END>
     * f4 -> <DECLARATIVES>
     * f5 -> <DOT>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(Declaratives n) {

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
     * f0 -> Paragraphs()
     * f1 -> ( ProcedureSection() )*
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ProcedureBody n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> SectionHeader()
     * f1 -> <DOT>
     * f2 -> Paragraphs()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ProcedureSection n) {

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
     * f0 -> SectionName()
     * f1 -> <SECTION>
     * f2 -> [ IntegerConstant() ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(SectionHeader n) {

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
     * f0 -> ( Sentence() )*
     * f1 -> ( Paragraph() )*
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(Paragraphs n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ParagraphName()
     * f1 -> <DOT>
     * f2 -> ( ExitStatement() | AlteredGoto() | Sentence() )*
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(Paragraph n) {

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
     * f0 -> StatementList()
     * f1 -> <DOT>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(Sentence n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( Statement() )+
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(StatementList n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( AcceptStatement() | AddStatement() | AlterStatement() | CallStatement() | CancelStatement() | CloseStatement() | ComputeStatement() | ContinueStatement() | DeleteStatement() | DisplayStatement() | DivideStatement() | EntryStatement() | EvaluateStatement() | ExecStatement() | ExitProgramStatement() | GobackStatement() | GotoStatement() | IfStatement() | InitializeStatement() | InspectStatement() | MergeStatement() | MoveStatement() | MultiplyStatement() | OpenStatement() | PerformStatement() | ReadStatement() | ReleaseStatement() | ReturnStatement() | RewriteStatement() | SearchStatement() | SetStatement() | SortStatement() | StartStatement() | StopStatement() | StringStatement() | SubtractStatement() | UnstringStatement() | WriteStatement() | ServiceStatement() )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(Statement n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <ACCEPT>
     * f1 -> ( <REPLY> | <OMITTED> | Identifier() )
     * f2 -> [ <FROM> ( MnemonicName() | EnvironmentName() | <DATE> [ <YYYYMMDD> ] | <DAY> [ <YYYYDDD> ] | <DAY_OF_WEEK> | <TIME> ) ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(AcceptStatement n) {

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
     * f0 -> <ADD>
     * f1 -> ( ( <CORRESPONDING> | <CORR> ) Identifier() <TO> Identifier() [ <ROUNDED> ] | ( Identifier() | Literal() ) ( [ <COMMACHAR> ] ( Identifier() | Literal() ) )* [ <TO> ( Identifier() [ <ROUNDED> ] )+ ] [ <GIVING> ( Identifier() [ <ROUNDED> ] )+ ] )
     * f2 -> [ [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f3 -> [ <NOT> [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f4 -> [ <END_ADD> ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(AddStatement n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <GO>
     * f1 -> [ <TO> ]
     * f2 -> <DOT>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(AlteredGoto n) {

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
     * f0 -> <ALTER>
     * f1 -> ( ProcedureName() <TO> [ <PROCEED> <TO> ] ProcedureName() )+
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(AlterStatement n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> [ <BY> ]
     * f1 -> <CONTENT>
     * f2 -> ( <ADDRESS> <OF> Identifier() | [ <LENGTH> <OF> ] Identifier() | Literal() | <OMITTED> )
     * f3 -> ( [ <COMMACHAR> ] ( <ADDRESS> <OF> Identifier() | [ <LENGTH> <OF> ] Identifier() | Literal() | <OMITTED> ) )*
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(CallByContent n) {

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
     * f0 -> [ [ <BY> ] <REFERENCE> ]
     * f1 -> ( <ADDRESS> <OF> Identifier() | Identifier() | FileName() | <OMITTED> )
     * f2 -> ( [ <COMMACHAR> ] ( <ADDRESS> <OF> Identifier() | Identifier() | FileName() | <OMITTED> ) )*
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(CallByReference n) {

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
     * f0 -> [ <BY> ]
     * f1 -> <DESCRIPTOR>
     * f2 -> ( <ADDRESS> <OF> Identifier() | Identifier() | FileName() | <OMITTED> )+
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(CallByDescriptor n) {

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
     * f0 -> [ <BY> ]
     * f1 -> <VALUE>
     * f2 -> ( <ADDRESS> <OF> Identifier() | [ <LENGTH> <OF> ] Identifier() | Literal() | <OMITTED> )+
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(CallByValue n) {

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
     * f0 -> <CALL>
     * f1 -> ( ConventionName() ( Identifier() | Literal() ) | ( Identifier() | Literal() ) )
     * f2 -> [ [ <WITH> ] <STDCALL> [ <LINKAGE> ] ]
     * f3 -> [ <USING> ( CallByContent() | CallByDescriptor() | CallByValue() | CallByReference() )+ ]
     * f4 -> [ ( <GIVING> | <RETURNING> ) Identifier() ]
     * f5 -> [ [ <ON> ] <EXCEPTION> StatementList() ]
     * f6 -> [ <NOT> [ <ON> ] <EXCEPTION> StatementList() ]
     * f7 -> [ [ <ON> ] <OVERFLOW> StatementList() ]
     * f8 -> [ <NOT> [ <ON> ] <OVERFLOW> StatementList() ]
     * f9 -> [ <END_CALL> ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(CallStatement n) {

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
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <CANCEL>
     * f1 -> ( Identifier() | Literal() )+
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(CancelStatement n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <CLOSE>
     * f1 -> ( FileName() [ ( ( <REEL> | <UNIT> ) [ ( [ <FOR> ] <REMOVAL> | [ <WITH> ] <NO> <REWIND> ) ] | [ <WITH> ] ( <NO> <REWIND> | <LOCK> ) ) ] )+
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(CloseStatement n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <COMPUTE>
     * f1 -> ( Identifier() [ <ROUNDED> ] )+
     * f2 -> ( <EQUALCHAR> | <EQUAL> )
     * f3 -> ArithmeticExpression()
     * f4 -> [ [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f5 -> [ <NOT> [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f6 -> [ <END_COMPUTE> ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ComputeStatement n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
        n.f5.accept(this);
        n.f6.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <CONTINUE>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ContinueStatement n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <DELETE>
     * f1 -> FileName()
     * f2 -> [ <RECORD> ]
     * f3 -> [ <INVALID> [ <KEY> ] StatementList() ]
     * f4 -> [ <NOT> <INVALID> [ <KEY> ] StatementList() ]
     * f5 -> [ <END_DELETE> ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(DeleteStatement n) {

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
     * f0 -> <DISPLAY>
     * f1 -> ( Identifier() | Literal() )
     * f2 -> ( [ <COMMACHAR> ] ( Identifier() | Literal() ) )*
     * f3 -> [ <UPON> ( MnemonicName() | EnvironmentName() ) ]
     * f4 -> [ [ <WITH> ] <NO> <ADVANCING> ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(DisplayStatement n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <DIVIDE>
     * f1 -> ( Identifier() | Literal() )
     * f2 -> ( <INTO> ( Identifier() | Literal() ) [ <ROUNDED> ] ( <GIVING> ( Identifier() [ <ROUNDED> ] )+ | ( ( Identifier() | Literal() ) [ <ROUNDED> ] )* ) | <BY> ( Identifier() | Literal() ) [ <GIVING> ( Identifier() [ <ROUNDED> ] )+ ] )
     * f3 -> [ <REMAINDER> Identifier() ]
     * f4 -> [ [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f5 -> [ <NOT> [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f6 -> [ <END_DIVIDE> ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(DivideStatement n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
        n.f5.accept(this);
        n.f6.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <ENTRY>
     * f1 -> Literal()
     * f2 -> [ <USING> ( Identifier() )+ ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(EntryStatement n) {

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
     * f0 -> <EVALUATE>
     * f1 -> EvaluateValue()
     * f2 -> ( <ALSO> EvaluateValue() )*
     * f3 -> ( ( EvaluateWhenClause() )+ [ <THEN> ] StatementList() )+
     * f4 -> [ <END_EVALUATE> ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(EvaluateStatement n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( Condition() | <TRUE> | <FALSE> )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(EvaluateValue n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( <WHEN> <OTHER> | <WHEN> EvaluatePhrase() ( <ALSO> EvaluatePhrase() )* )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(EvaluateWhenClause n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> [ <NOT> ]
     * f1 -> ArithmeticExpression()
     * f2 -> ( <THROUGH> | <THRU> )
     * f3 -> ArithmeticExpression()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(EvaluateThruPhrase n) {

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
     * f0 -> ( EvaluateThruPhrase() | Condition() | <ANY> | <TRUE> | <FALSE> )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(EvaluatePhrase n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <EXEC>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ExecStatement n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <EXIT>
     * f1 -> <DOT>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ExitStatement n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <EXIT>
     * f1 -> <PROGRAM>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ExitProgramStatement n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <GOBACK>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(GobackStatement n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <GO>
     * f1 -> [ <TO> ]
     * f2 -> ( ( ProcedureName() )+ [ <DEPENDING> [ <ON> ] Identifier() ] | <MORE_LABELS> )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(GotoStatement n) {

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
     * f0 -> <IF>
     * f1 -> Condition()
     * f2 -> [ <THEN> ]
     * f3 -> ( StatementList() | <NEXT> <SENTENCE> )
     * f4 -> [ <ELSE> ( StatementList() | <NEXT> <SENTENCE> ) ]
     * f5 -> [ <END_IF> ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(IfStatement n) {

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
     * f0 -> <INITIALIZE>
     * f1 -> ( Identifier() )+
     * f2 -> [ <REPLACING> ( ( <ALPHABETIC> | <ALPHANUMERIC> | <NUMERIC> | <ALPHANUMERIC_EDITED> | <NUMERIC_EDITED> | <DBCS> | <EGCS> ) [ <DATA> ] <BY> ( Identifier() | Literal() ) )+ ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(InitializeStatement n) {

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
     * f0 -> <INSPECT>
     * f1 -> Identifier()
     * f2 -> ( TallyingPhrase() | ConvertingPhrase() | ReplacingPhrase() )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(InspectStatement n) {

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
     * f0 -> <CHARACTERS>
     * f1 -> ( IterableBeforeAfterPhrase() )*
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(IterableTallyingClause n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( <ALL> | <LEADING> )
     * f1 -> IterableBeforeAfterClause()
     * f2 -> ( ( Identifier() <FOR> ( RecursiveTallyingClause() | IterableTallyingClause() )+ )+ | IterableBeforeAfterClause() )*
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(RecursiveTallyingClause n) {

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
     * f0 -> <TALLYING>
     * f1 -> ( Identifier() <FOR> ( RecursiveTallyingClause() | IterableTallyingClause() )+ )+
     * f2 -> [ ReplacingPhrase() ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(TallyingPhrase n) {

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
     * f0 -> <CONVERTING>
     * f1 -> ( Identifier() | Literal() )
     * f2 -> <TO>
     * f3 -> IterableBeforeAfterClause()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ConvertingPhrase n) {

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
     * f0 -> <REPLACING>
     * f1 -> ( <CHARACTERS> <BY> IterableBeforeAfterClause() | ( <ALL> | <LEADING> | <FIRST> ) ( ( Identifier() | Literal() ) <BY> IterableBeforeAfterClause() )+ )+
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ReplacingPhrase n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( Identifier() | IterableLiteral() )
     * f1 -> ( IterableBeforeAfterPhrase() )*
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(IterableBeforeAfterClause n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( <BEFORE> | <AFTER> )
     * f1 -> [ <INITIAL> ]
     * f2 -> ( Identifier() | IterableLiteral() )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(IterableBeforeAfterPhrase n) {

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
     * f0 -> <MERGE>
     * f1 -> FileName()
     * f2 -> ( [ <ON> ] ( <ASCENDING> | <DESCENDING> ) [ <KEY> ] ( Identifier() )+ )+
     * f3 -> [ [ <COLLATING> ] <SEQUENCE> [ <IS> ] AlphabetName() ]
     * f4 -> <USING>
     * f5 -> FileName()
     * f6 -> ( FileName() )+
     * f7 -> ( <OUTPUT> <PROCEDURE> [ <IS> ] ProcedureName() [ ( <THROUGH> | <THRU> ) ProcedureName() ] | <GIVING> ( FileName() )+ )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(MergeStatement n) {

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
     * f0 -> <MOVE>
     * f1 -> ( ArithmeticExpression() <TO> Identifier() ( [ <COMMACHAR> ] Identifier() )* | ( <CORRESPONDING> | <CORR> ) Identifier() <TO> ( Identifier() )+ )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(MoveStatement n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <MULTIPLY>
     * f1 -> ( Identifier() | Literal() )
     * f2 -> <BY>
     * f3 -> ( ( Identifier() | Literal() ) [ <ROUNDED> ] )+
     * f4 -> [ <GIVING> ( Identifier() [ <ROUNDED> ] )+ ]
     * f5 -> [ [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f6 -> [ <NOT> [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f7 -> [ <END_MULTIPLY> ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(MultiplyStatement n) {

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
     * f0 -> <OPEN>
     * f1 -> ( <INPUT> ( FileName() [ ( <REVERSED> | [ <WITH> ] <NO> <REWIND> ) ] )+ | <OUTPUT> ( FileName() [ [ <WITH> ] <NO> <REWIND> ] )+ | <I_O> ( FileName() )+ | <EXTEND> ( FileName() )+ )+
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(OpenStatement n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <PERFORM>
     * f1 -> ( PerformFlavour() StatementList() <END_PERFORM> | PerformProcedureScopeClause() PerformFlavour() | StatementList() <END_PERFORM> | PerformProcedureScopeClause() )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(PerformStatement n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> PerformTimeClause()
     *       | [ PerformTestPositionClause() ] ( PerformUntilClause() | PerformVaryingWithAfterClause() )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(PerformFlavour n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <VARYING>
     * f1 -> PerformVaryingPhrase()
     * f2 -> ( <AFTER> PerformVaryingPhrase() )*
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(PerformVaryingWithAfterClause n) {

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
     * f0 -> Identifier()
     * f1 -> <FROM>
     * f2 -> ( Identifier() | Literal() )
     * f3 -> <BY>
     * f4 -> ( Identifier() | Literal() )
     * f5 -> PerformUntilClause()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(PerformVaryingPhrase n) {

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
     * f0 -> <UNTIL>
     * f1 -> Condition()
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(PerformUntilClause n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> [ <WITH> ]
     * f1 -> <TEST>
     * f2 -> ( <BEFORE> | <AFTER> )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(PerformTestPositionClause n) {

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
     * f0 -> ProcedureName()
     * f1 -> [ ( <THROUGH> | <THRU> ) ProcedureName() ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(PerformProcedureScopeClause n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( Identifier() | IntegerConstant() )
     * f1 -> <TIMES>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(PerformTimeClause n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <READ>
     * f1 -> FileName()
     * f2 -> [ <NEXT> ]
     * f3 -> [ <RECORD> ]
     * f4 -> [ <INTO> Identifier() ]
     * f5 -> [ <KEY> [ <IS> ] Identifier() ]
     * f6 -> [ <INVALID> [ <KEY> ] StatementList() ]
     * f7 -> [ <NOT> <INVALID> [ <KEY> ] StatementList() ]
     * f8 -> [ [ <AT> ] <END> StatementList() ]
     * f9 -> [ <NOT> [ <AT> ] <END> StatementList() ]
     * f10 -> [ <END_READ> ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ReadStatement n) {

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
     * f0 -> <RELEASE>
     * f1 -> RecordName()
     * f2 -> [ <FROM> Identifier() ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ReleaseStatement n) {

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
     * f0 -> <RETURN>
     * f1 -> FileName()
     * f2 -> [ <RECORD> ]
     * f3 -> [ <INTO> Identifier() ]
     * f4 -> [ <AT> ]
     * f5 -> <END>
     * f6 -> StatementList()
     * f7 -> [ <NOT> [ <AT> ] <END> StatementList() ]
     * f8 -> [ <END_RETURN> ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ReturnStatement n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
        n.f5.accept(this);
        n.f6.accept(this);
        n.f7.accept(this);
        n.f8.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <REWRITE>
     * f1 -> RecordName()
     * f2 -> [ <FROM> Identifier() ]
     * f3 -> [ <INVALID> [ <KEY> ] StatementList() ]
     * f4 -> [ <NOT> <INVALID> [ <KEY> ] StatementList() ]
     * f5 -> [ <END_REWRITE> ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(RewriteStatement n) {

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
     * f0 -> <SEARCH>
     * f1 -> [ <ALL> ]
     * f2 -> Identifier()
     * f3 -> [ <VARYING> Identifier() ]
     * f4 -> [ [ <AT> ] <END> StatementList() ]
     * f5 -> ( <WHEN> Condition() ( StatementList() | <NEXT> <SENTENCE> ) )+
     * f6 -> [ <END_SEARCH> ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(SearchStatement n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
        n.f5.accept(this);
        n.f6.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <SET>
     * f1 -> [ <CONFIGURATION> ]
     * f2 -> ( Identifier() | Literal() )
     * f3 -> ( [ <COMMACHAR> ] Identifier() | Literal() )*
     * f4 -> ( <TO> [ <CONFIGURATION> ] ( Identifier() | <TRUE> | <FALSE> | <ON> | <OFF> | [ <ENTRY> ] Literal() ) | ( <UP> | <DOWN> ) [ <BY> ] ( Identifier() | Literal() ) )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(SetStatement n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <SORT>
     * f1 -> FileName()
     * f2 -> ( [ <ON> ] ( <ASCENDING> | <DESCENDING> ) [ <KEY> ] ( Identifier() )+ )+
     * f3 -> [ [ <WITH> ] <DUPLICATES> [ <IN> ] [ <ORDER> ] ]
     * f4 -> [ [ <COLLATING> ] <SEQUENCE> [ <IS> ] AlphabetName() ]
     * f5 -> ( <USING> ( FileName() )+ | <INPUT> <PROCEDURE> [ <IS> ] ProcedureName() [ ( <THROUGH> | <THRU> ) ProcedureName() ] )
     * f6 -> ( <GIVING> ( FileName() )+ | <OUTPUT> <PROCEDURE> [ <IS> ] ProcedureName() [ ( <THROUGH> | <THRU> ) ProcedureName() ] )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(SortStatement n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
        n.f5.accept(this);
        n.f6.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <START>
     * f1 -> FileName()
     * f2 -> [ <KEY> RelationalOperator() Identifier() ]
     * f3 -> [ <INVALID> [ <KEY> ] StatementList() ]
     * f4 -> [ <NOT> <INVALID> [ <KEY> ] StatementList() ]
     * f5 -> [ <END_START> ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(StartStatement n) {

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
     * f0 -> <STOP>
     * f1 -> ( <RUN> | Literal() )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(StopStatement n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <STRING>
     * f1 -> ( ( Identifier() | IterableLiteral() ) ( [ <COMMACHAR> ] ( Identifier() | IterableLiteral() ) )* <DELIMITED> [ <BY> ] ( Identifier() | IterableLiteral() | <SIZE> ) )+
     * f2 -> <INTO>
     * f3 -> Identifier()
     * f4 -> [ [ <WITH> ] <POINTER> Identifier() ]
     * f5 -> [ [ <ON> ] <OVERFLOW> StatementList() ]
     * f6 -> [ <NOT> [ <ON> ] <OVERFLOW> StatementList() ]
     * f7 -> [ <END_STRING> ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(StringStatement n) {

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
     * f0 -> <SUBTRACT>
     * f1 -> ( ( Identifier() | Literal() )+ <FROM> ( ( Identifier() | Literal() ) [ <ROUNDED> ] )+ [ <GIVING> ( Identifier() [ <ROUNDED> ] )+ ] | ( <CORRESPONDING> | <CORR> ) Identifier() <FROM> Identifier() [ <ROUNDED> ] )
     * f2 -> [ [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f3 -> [ <NOT> [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f4 -> [ <END_SUBTRACT> ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(SubtractStatement n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <UNSTRING>
     * f1 -> Identifier()
     * f2 -> [ <DELIMITED> [ <BY> ] [ <ALL> ] ( Identifier() | Literal() ) ( <OR> [ <ALL> ] ( Identifier() | Literal() ) )* ]
     * f3 -> <INTO>
     * f4 -> ( Identifier() [ <DELIMITER> [ <IN> ] Identifier() ] [ <COUNT> [ <IN> ] Identifier() ] )+
     * f5 -> [ [ <WITH> ] <POINTER> Identifier() ]
     * f6 -> [ <TALLYING> [ <IN> ] Identifier() ]
     * f7 -> [ [ <ON> ] <OVERFLOW> StatementList() ]
     * f8 -> [ <NOT> [ <ON> ] <OVERFLOW> StatementList() ]
     * f9 -> [ <END_UNSTRING> ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(UnstringStatement n) {

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
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <USE>
     * f1 -> ( [ <FOR> ] <DEBUGGING> [ <ON> ] ( ( ProcedureName() )+ | <ALL> ( <PROCEDURES> | <REFERENCES> <OF> DataName() ) ) | [ <GLOBAL> ] <AFTER> [ <STANDARD> ] ( ( <EXCEPTION> | <ERROR> ) | [ ( <BEGINNING> | <ENDING> ) ] [ ( <FILE> | <REEL> | <UNIT> ) ] <LABEL> ) <PROCEDURE> [ <ON> ] ( ( FileName() )+ | <INPUT> | <OUTPUT> | <I_O> | <EXTEND> ) )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(UseStatement n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <WRITE>
     * f1 -> RecordName()
     * f2 -> [ <FROM> Identifier() ]
     * f3 -> [ AdvancingPhrase() ]
     * f4 -> [ [ <AT> ] ( <END_OF_PAGE> | <EOP> ) StatementList() ]
     * f5 -> [ <NOT> [ <AT> ] ( <END_OF_PAGE> | <EOP> ) StatementList() ]
     * f6 -> [ <INVALID> [ <KEY> ] StatementList() ]
     * f7 -> [ <NOT> <INVALID> [ <KEY> ] StatementList() ]
     * f8 -> [ <END_WRITE> ]
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(WriteStatement n) {

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
        n.f5.accept(this);
        n.f6.accept(this);
        n.f7.accept(this);
        n.f8.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <SERVICE>
     * f1 -> <LABEL>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(ServiceStatement n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( <BEFORE> | <AFTER> )
     * f1 -> [ <ADVANCING> ]
     * f2 -> ( <PAGE> | ( IntegerConstant() | Identifier() | Literal() ) [ ( <LINE> | <LINES> ) ] | MnemonicName() )
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(AdvancingPhrase n) {

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
     * f0 -> ( DataDescriptionEntry() )*
     * f1 -> <EOF>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(DataDescription n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( Sentence() )*
     * f1 -> <EOF>
     *
     * @param n TODO_javadoc.
     *
     */
    public void visit(SentenceList n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

}
