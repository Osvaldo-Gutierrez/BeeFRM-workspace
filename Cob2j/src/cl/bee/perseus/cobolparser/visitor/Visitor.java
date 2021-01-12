/*
 *   Copyright (c) 20XX by XXXXXXXX All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF XXXXXXXX
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.perseus.cobolparser.visitor;
import cl.bee.perseus.cobolparser.syntaxtree.*;
import java.util.*;

/**
 * All void visitors must implement this interface.
 */

public interface Visitor {

   //
   // void Auto class visitors
   //

   public void visit(NodeList n);
   public void visit(NodeListOptional n);
   public void visit(NodeOptional n);
   public void visit(NodeSequence n);
   public void visit(NodeToken n);

    //
    // User-generated visitor methods below
    //

    /**
     * f0 -> <COBOL_WORD>
     */
    public void visit(CobolWord n);

    /**
     * f0 -> ( IterableQuotedText() )+
     */
    public void visit(QuotedText n);

    /**
     * f0 -> <QUOTEDSTRING>
     *       | <DOUBLEDQUOTECHAR>
     *       | <DOUBLEDAPOSTROPHE>
     */
    public void visit(IterableQuotedText n);

    /**
     * f0 -> <LEVEL_66>
     *       | <LEVEL_77>
     *       | <LEVEL_88>
     *       | <INTEGER>
     */
    public void visit(IntegerConstant n);

    /**
     * f0 -> [ <PLUSCHAR> | <MINUSCHAR> ]
     * f1 -> ( IntegerConstant() | <REAL> )
     */
    public void visit(NumericConstant n);

    /**
     * f0 -> <INTEGER>
     */
    public void visit(LevelNumber n);

    /**
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
     */
    public void visit(FigurativeConstant n);

    /**
     * f0 -> ( QuotedText() | <HEXNUMBER> )
     */
    public void visit(NonNumericConstant n);

    /**
     * f0 -> ( IterableQuotedText() | <HEXNUMBER> )
     */
    public void visit(IterableNonNumericConstant n);

    /**
     * f0 -> [ <ALL> ]
     * f1 -> ( NonNumericConstant() | NumericConstant() | FigurativeConstant() )
     */
    public void visit(Literal n);

    /**
     * f0 -> [ <ALL> ]
     * f1 -> ( IterableNonNumericConstant() | NumericConstant() | FigurativeConstant() )
     */
    public void visit(IterableLiteral n);

    /**
     * f0 -> ArithmeticExpression()
     *       | <LPARENCHAR> Condition() <RPARENCHAR>
     */
    public void visit(IterableCondition n);

    /**
     * f0 -> CombinableCondition()
     * f1 -> ( ( <AND> | <OR> ) ( CombinableCondition() | AbbreviationRest() ) )*
     */
    public void visit(Condition n);

    /**
     * f0 -> [ <NOT> ]
     * f1 -> SimpleCondition()
     */
    public void visit(CombinableCondition n);

    /**
     * f0 -> RelationCondition()
     *       | ArithmeticExpression()
     *       | <LPARENCHAR> Condition() <RPARENCHAR>
     */
    public void visit(SimpleCondition n);

    /**
     * f0 -> [ <IS> ]
     * f1 -> [ <NOT> ]
     * f2 -> ( <NUMERIC> | <ALPHABETIC> | <ALPHABETIC_LOWER> | <ALPHABETIC_UPPER> | ClassName() | <DBCS> | <KANJI> )
     */
    public void visit(ClassCondition n);

    /**
     * f0 -> ArithmeticExpression()
     * f1 -> ( AbbreviationRest() | SignCondition() | ClassCondition() )
     */
    public void visit(RelationCondition n);

    /**
     * f0 -> [ <IS> ]
     * f1 -> [ <NOT> ]
     * f2 -> ( <POSITIVE> | <NEGATIVE> | <ZERO> | <ZEROS> | <ZEROES> )
     */
    public void visit(SignCondition n);

    /**
     * f0 -> [ <IS> ]
     * f1 -> [ <NOT> ]
     * f2 -> ( <GREATER> [ <THAN> ] [ <OR> <EQUAL> [ <TO> ] ] | <MORETHANCHAR> | <LESS> [ <THAN> ] [ <OR> <EQUAL> [ <TO> ] ] | <LESSTHANCHAR> | <EQUAL> [ <TO> ] | <EQUALCHAR> | <NOTEQUAL> | <MORETHANOREQUAL> | <LESSTHANOREQUAL> )
     */
    public void visit(RelationalOperator n);

    /**
     * f0 -> ArithmeticExpression()
     *       | <LPARENCHAR> AbbreviationLeaf() ( ( <AND> | <OR> ) AbbreviationLeaf() )+ <RPARENCHAR>
     */
    public void visit(AbbreviationLeaf n);

    /**
     * f0 -> RelationalOperator()
     * f1 -> AbbreviationLeaf()
     */
    public void visit(AbbreviationRest n);

    /**
     * f0 -> ( ParagraphName() [ ( <IN> | <OF> ) SectionName() ] | SectionName() )
     */
    public void visit(ProcedureName n);

    /**
     * f0 -> <LPARENCHAR>
     * f1 -> ArithmeticExpression()
     * f2 -> ( [ <COMMACHAR> ] ArithmeticExpression() )*
     * f3 -> <RPARENCHAR>
     */
    public void visit(Subscript n);

    /**
     * f0 -> <FUNCTION>
     * f1 -> FunctionName()
     * f2 -> [ Subscript() ]
     * f3 -> [ <LPARENCHAR> LeftmostCharacterPosition() <COLONCHAR> [ Length() ] <RPARENCHAR> ]
     */
    public void visit(FunctionClause n);

    /**
     * f0 -> ( QualifiedDataName() ( Subscript() )* [ <LPARENCHAR> LeftmostCharacterPosition() <COLONCHAR> [ Length() ] <RPARENCHAR> ] | <LINAGE_COUNTER> [ ( <IN> | <OF> ) FileName() ] | <PROGRAM_STATUS> )
     */
    public void visit(Identifier n);

    /**
     * f0 -> ( DataName() ( ( <IN> | <OF> ) DataName() )* [ ( <IN> | <OF> ) FileName() ] | SpecialRegister() )
     */
    public void visit(QualifiedDataName n);

    /**
     * f0 -> ArithmeticExpression()
     */
    public void visit(Length n);

    /**
     * f0 -> ArithmeticExpression()
     */
    public void visit(LeftmostCharacterPosition n);

    /**
     * f0 -> CobolWord()
     */
    public void visit(Mode n);

    /**
     * f0 -> CobolWord()
     */
    public void visit(AlphabetName n);

    /**
     * f0 -> CobolWord()
     */
    public void visit(ClassName n);

    /**
     * f0 -> CobolWord()
     */
    public void visit(ConditionName n);

    /**
     * f0 -> CobolWord()
     */
    public void visit(DataName n);

    /**
     * f0 -> CobolWord()
     */
    public void visit(FileName n);

    /**
     * f0 -> CobolWord()
     */
    public void visit(IndexName n);

    /**
     * f0 -> CobolWord()
     */
    public void visit(MnemonicName n);

    /**
     * f0 -> Identifier()
     */
    public void visit(RecordName n);

    /**
     * f0 -> CobolWord()
     */
    public void visit(RoutineName n);

    /**
     * f0 -> CobolWord()
     */
    public void visit(SymbolicCharacter n);

    /**
     * f0 -> CobolWord()
     */
    public void visit(LibraryName n);

    /**
     * f0 -> CobolWord()
     */
    public void visit(ProgramName n);

    /**
     * f0 -> IntegerConstant()
     *       | CobolWord()
     */
    public void visit(SectionName n);

    /**
     * f0 -> IntegerConstant()
     *       | CobolWord()
     */
    public void visit(ParagraphName n);

    /**
     * f0 -> CobolWord()
     */
    public void visit(SystemName n);

    /**
     * f0 -> SystemName()
     */
    public void visit(ComputerName n);

    /**
     * f0 -> SystemName()
     */
    public void visit(LanguageName n);

    /**
     * f0 -> SystemName()
     */
    public void visit(EnvironmentName n);

    /**
     * f0 -> SystemName()
     */
    public void visit(AssignmentName n);

    /**
     * f0 -> ProgramName()
     */
    public void visit(BasisName n);

    /**
     * f0 -> ( CobolWord() | <LENGTH> | <WHEN_COMPILED> | <SUM> | <RANDOM> )
     */
    public void visit(FunctionName n);

    /**
     * f0 -> ( <ADDRESS> <OF> DataName() | <DEBUG_ITEM> | <LENGTH> <OF> Identifier() | <RETURN_CODE> | <SHIFT_OUT> | <SHIFT_IN> | <SORT_CONTROL> | <SORT_CORE_SIZE> | <SORT_FILE_SIZE> | <SORT_MESSAGE> | <SORT_MODE_SIZE> | <SORT_RETURN> | <TALLY> | <WHEN_COMPILED> )
     */
    public void visit(SpecialRegister n);

    /**
     * f0 -> CobolWord()
     */
    public void visit(CdName n);

    /**
     * f0 -> CobolWord()
     */
    public void visit(ConventionName n);

    /**
     * f0 -> CobolWord()
     */
    public void visit(HandleComponent n);

    /**
     * f0 -> QuotedText()
     */
    public void visit(ImplicitTitle n);

    /**
     * f0 -> DataName()
     */
    public void visit(LevelName66 n);

    /**
     * f0 -> DataName()
     */
    public void visit(LevelName77 n);

    /**
     * f0 -> ConditionName()
     */
    public void visit(LevelName88 n);

    /**
     * f0 -> [ DataName() | <FILLER> | <REPLY> | <PROGRAM_STATUS> ]
     */
    public void visit(LevelName n);

    /**
     * f0 -> TimesDiv()
     * f1 -> ( ( <PLUSCHAR> | <MINUSCHAR> ) TimesDiv() )*
     */
    public void visit(ArithmeticExpression n);

    /**
     * f0 -> Power()
     * f1 -> ( ( <ASTERISKCHAR> | <SLASHCHAR> ) Power() )*
     */
    public void visit(TimesDiv n);

    /**
     * f0 -> [ ( <PLUSCHAR> | <MINUSCHAR> ) ]
     * f1 -> Basis()
     * f2 -> ( <POWEROF> Basis() )*
     */
    public void visit(Power n);

    /**
     * f0 -> ( FunctionClause() | Identifier() | Literal() | <ALL> | <LPARENCHAR> ArithmeticExpression() <RPARENCHAR> )
     */
    public void visit(Basis n);

    /**
     * f0 -> ( ( NonDotChars() | Literal() )+ [ <DOT> ] )+
     */
    public void visit(CommentLine n);

    /**
     * f0 -> ProgramUnit()
     * f1 -> ( NestedProgramUnit() EndProgramStatement() )*
     * f2 -> [ EndProgramStatement() ( CompilationUnit() )* ]
     * f3 -> <EOF>
     */
    public void visit(CompilationUnit n);

    /**
     * f0 -> IdentificationDivision()
     * f1 -> [ EnvironmentDivision() ]
     * f2 -> [ DataDivision() ]
     * f3 -> [ ProcedureDivision() ]
     */
    public void visit(ProgramUnit n);

    /**
     * f0 -> NestedIdentificationDivision()
     * f1 -> [ EnvironmentDivision() ]
     * f2 -> [ DataDivision() ]
     * f3 -> [ ProcedureDivision() ]
     */
    public void visit(NestedProgramUnit n);

    /**
     * f0 -> <END>
     * f1 -> <PROGRAM>
     * f2 -> ProgramName()
     * f3 -> <DOT>
     */
    public void visit(EndProgramStatement n);

    /**
     * f0 -> LinkageSectionEntry()
     * f1 -> <EOF>
     */
    public void visit(CopyBookUnit n);

    /**
     * f0 -> ( <IDENTIFICATION> | <ID> )
     * f1 -> <DIVISION>
     * f2 -> <DOT>
     * f3 -> ProgramIdParagraph()
     * f4 -> ( IdentificationDivisionParagraph() )*
     */
    public void visit(IdentificationDivision n);

    /**
     * f0 -> ( <IDENTIFICATION> | <ID> )
     * f1 -> <DIVISION>
     * f2 -> <DOT>
     * f3 -> NestedProgramIdParagraph()
     * f4 -> ( IdentificationDivisionParagraph() )*
     */
    public void visit(NestedIdentificationDivision n);

    /**
     * f0 -> InstallationParagraph()
     *       | SecurityParagraph()
     */
    public void visit(IdentificationDivisionParagraph n);

    /**
     * f0 -> <PROGRAM_ID>
     * f1 -> <DOT>
     * f2 -> ProgramName()
     * f3 -> [ [ <IS> ] <INITIAL> [ <PROGRAM> ] ]
     * f4 -> <DOT>
     */
    public void visit(ProgramIdParagraph n);

    /**
     * f0 -> <PROGRAM_ID>
     * f1 -> <DOT>
     * f2 -> ProgramName()
     * f3 -> [ [ <IS> ] InitialOrCommon() [ <PROGRAM> ] ]
     * f4 -> <DOT>
     */
    public void visit(NestedProgramIdParagraph n);

    /**
     * f0 -> ( <INITIAL> [ <COMMON> ] | <COMMON> [ <INITIAL> ] )
     */
    public void visit(InitialOrCommon n);

    /**
     * f0 -> <INSTALLATION>
     * f1 -> <DOT>
     * f2 -> [ CommentLine() ]
     */
    public void visit(InstallationParagraph n);

    /**
     * f0 -> <SECURITY>
     * f1 -> <DOT>
     * f2 -> [ CommentLine() ]
     */
    public void visit(SecurityParagraph n);

    /**
     * f0 -> <ENVIRONMENT>
     * f1 -> <DIVISION>
     * f2 -> <DOT>
     * f3 -> ( EnvironmentSection() )*
     */
    public void visit(EnvironmentDivision n);

    /**
     * f0 -> ConfigurationSection()
     *       | InputOutputSection()
     */
    public void visit(EnvironmentSection n);

    /**
     * f0 -> <CONFIGURATION>
     * f1 -> <SECTION>
     * f2 -> <DOT>
     * f3 -> ( ConfigurationSectionParagraph() )*
     */
    public void visit(ConfigurationSection n);

    /**
     * f0 -> SourceComputerParagraph()
     *       | ObjectComputerParagraph()
     *       | SpecialNamesParagraph()
     */
    public void visit(ConfigurationSectionParagraph n);

    /**
     * f0 -> <SOURCE_COMPUTER>
     * f1 -> <DOT>
     * f2 -> ComputerName()
     * f3 -> [ [ <WITH> ] <DEBUGGING> <MODE> ]
     * f4 -> <DOT>
     */
    public void visit(SourceComputerParagraph n);

    /**
     * f0 -> <OBJECT_COMPUTER>
     * f1 -> <DOT>
     * f2 -> ComputerName()
     * f3 -> ( ObjectComputerClause() )*
     * f4 -> <DOT>
     */
    public void visit(ObjectComputerParagraph n);

    /**
     * f0 -> MemorySizeClause()
     *       | CollatingSequenceClause()
     *       | SegmentLimitClause()
     *       | CharacterSetClause()
     */
    public void visit(ObjectComputerClause n);

    /**
     * f0 -> <MEMORY>
     * f1 -> [ <SIZE> ]
     * f2 -> IntegerConstant()
     * f3 -> [ <WORDS> | <CHARACTERS> | <MODULES> ]
     */
    public void visit(MemorySizeClause n);

    /**
     * f0 -> [ <PROGRAM> ]
     * f1 -> [ <COLLATING> ]
     * f2 -> <SEQUENCE>
     * f3 -> [ <IS> ]
     * f4 -> AlphabetName()
     */
    public void visit(CollatingSequenceClause n);

    /**
     * f0 -> ( <SEGMENT_LIMIT> | <SEGMENT> <LIMIT> )
     * f1 -> [ <IS> ]
     * f2 -> IntegerConstant()
     */
    public void visit(SegmentLimitClause n);

    /**
     * f0 -> <CHARACTER>
     * f1 -> <SET>
     * f2 -> [ CommentLine() ]
     */
    public void visit(CharacterSetClause n);

    /**
     * f0 -> <SPECIAL_NAMES>
     * f1 -> <DOT>
     * f2 -> [ ( SpecialNameClause() )+ <DOT> ]
     */
    public void visit(SpecialNamesParagraph n);

    /**
     * f0 -> AlphabetClause()
     *       | ClassClause()
     *       | CurrencySignClause()
     *       | DecimalPointClause()
     *       | SymbolicCharactersClause()
     *       | CallConventionClause()
     *       | EnvironmentNameIsMnemonicNameClause()
     */
    public void visit(SpecialNameClause n);

    /**
     * f0 -> ( <THROUGH> | <THRU> ) IterableLiteral()
     *       | ( <ALSO> IterableLiteral() )+
     */
    public void visit(IterableAlphabetPhrase n);

    /**
     * f0 -> <ALPHABET>
     * f1 -> AlphabetName()
     * f2 -> [ <IS> ]
     * f3 -> ( <STANDARD_1> | <STANDARD_2> | <NATIVE> | CobolWord() | ( IterableLiteral() [ IterableAlphabetPhrase() ] )+ )
     */
    public void visit(AlphabetClause n);

    /**
     * f0 -> <CLASS>
     * f1 -> ClassName()
     * f2 -> [ <IS> ]
     * f3 -> ( ( Identifier() | IterableLiteral() ) [ ( <THROUGH> | <THRU> ) ( Identifier() | IterableLiteral() ) ] )+
     */
    public void visit(ClassClause n);

    /**
     * f0 -> <CURRENCY>
     * f1 -> [ <SIGN> ]
     * f2 -> [ <IS> ]
     * f3 -> Literal()
     */
    public void visit(CurrencySignClause n);

    /**
     * f0 -> <DECIMAL_POINT>
     * f1 -> [ <IS> ]
     * f2 -> <COMMA>
     */
    public void visit(DecimalPointClause n);

    /**
     * f0 -> <SYMBOLIC>
     * f1 -> [ <CHARACTERS> ]
     * f2 -> ( ( SymbolicCharacter() )+ [ ( <ARE> | <IS> ) ] ( NumericConstant() | <HEXNUMBER> )+ )+
     * f3 -> [ <IN> AlphabetName() ]
     */
    public void visit(SymbolicCharactersClause n);

    /**
     * f0 -> <CALL_CONVENTION>
     * f1 -> IntegerConstant()
     * f2 -> [ <IS> ]
     * f3 -> ConventionName()
     */
    public void visit(CallConventionClause n);

    /**
     * f0 -> EnvironmentName()
     * f1 -> ( [ <IS> ] MnemonicName() [ SpecialNamesParagraphStatusPhrase() ] | SpecialNamesParagraphStatusPhrase() )
     */
    public void visit(EnvironmentNameIsMnemonicNameClause n);

    /**
     * f0 -> ( <ON> [ <STATUS> ] [ <IS> ] IterableCondition() [ <OFF> [ <STATUS> ] [ <IS> ] IterableCondition() ] | <OFF> [ <STATUS> ] [ <IS> ] IterableCondition() [ <ON> [ <STATUS> ] [ <IS> ] IterableCondition() ] )
     */
    public void visit(SpecialNamesParagraphStatusPhrase n);

    /**
     * f0 -> <INPUT_OUTPUT>
     * f1 -> <SECTION>
     * f2 -> <DOT>
     * f3 -> ( InputOutputSectionParagraph() )*
     */
    public void visit(InputOutputSection n);

    /**
     * f0 -> FileControlParagraph()
     *       | IOControlParagraph()
     */
    public void visit(InputOutputSectionParagraph n);

    /**
     * f0 -> <FILE_CONTROL>
     * f1 -> ( [ <DOT> ] FileControlEntry() )*
     * f2 -> <DOT>
     */
    public void visit(FileControlParagraph n);

    /**
     * f0 -> SelectClause()
     * f1 -> ( FileControlClause() )*
     */
    public void visit(FileControlEntry n);

    /**
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
     */
    public void visit(FileControlClause n);

    /**
     * f0 -> <SELECT>
     * f1 -> [ <OPTIONAL> ]
     * f2 -> FileName()
     */
    public void visit(SelectClause n);

    /**
     * f0 -> <ASSIGN>
     * f1 -> [ <TO> ]
     * f2 -> ( AssignmentName() | Literal() )
     * f3 -> [ <USING> ( AssignmentName() | Literal() ) ]
     */
    public void visit(AssignClause n);

    /**
     * f0 -> <RESERVE>
     * f1 -> IntegerConstant()
     * f2 -> [ <AREA> | <AREAS> ]
     */
    public void visit(ReserveClause n);

    /**
     * f0 -> [ <ORGANIZATION> [ <IS> ] ]
     * f1 -> ( SequentialOrganizationClause() | LineSequentialOrganizationClause() | RelativeOrganizationClause() | IndexedOrganizationClause() )
     */
    public void visit(OrganizationClause n);

    /**
     * f0 -> <SEQUENTIAL>
     */
    public void visit(SequentialOrganizationClause n);

    /**
     * f0 -> <LINE>
     * f1 -> <SEQUENTIAL>
     */
    public void visit(LineSequentialOrganizationClause n);

    /**
     * f0 -> <RELATIVE>
     * f1 -> [ Identifier() ]
     */
    public void visit(RelativeOrganizationClause n);

    /**
     * f0 -> <INDEXED>
     */
    public void visit(IndexedOrganizationClause n);

    /**
     * f0 -> <PADDING>
     * f1 -> [ <CHARACTER> ]
     * f2 -> [ <IS> ]
     * f3 -> ( Identifier() | Literal() )
     */
    public void visit(PaddingCharacterClause n);

    /**
     * f0 -> <RECORD>
     * f1 -> <DELIMITER>
     * f2 -> [ <IS> ]
     * f3 -> ( <STANDARD_1> | <IMPLICIT> | AssignmentName() )
     */
    public void visit(RecordDelimiterClause n);

    /**
     * f0 -> <ACCESS>
     * f1 -> [ <MODE> ]
     * f2 -> [ <IS> ]
     * f3 -> ( SequentialAccessMode() | RandomAccessMode() | DynamicAccessMode() )
     */
    public void visit(AccessModeClause n);

    /**
     * f0 -> <SEQUENTIAL>
     * f1 -> [ RelativeKeyClause() ]
     */
    public void visit(SequentialAccessMode n);

    /**
     * f0 -> <RANDOM>
     * f1 -> [ RelativeKeyClause() ]
     */
    public void visit(RandomAccessMode n);

    /**
     * f0 -> <DYNAMIC>
     * f1 -> [ RelativeKeyClause() ]
     */
    public void visit(DynamicAccessMode n);

    /**
     * f0 -> <RELATIVE>
     * f1 -> [ <KEY> ]
     * f2 -> [ <IS> ]
     * f3 -> Identifier()
     */
    public void visit(RelativeKeyClause n);

    /**
     * f0 -> <RECORD>
     * f1 -> [ <KEY> ]
     * f2 -> [ <IS> ]
     * f3 -> Identifier()
     * f4 -> [ PasswordClause() ]
     * f5 -> [ [ <WITH> ] <DUPLICATES> ]
     */
    public void visit(RecordKeyClause n);

    /**
     * f0 -> <ALTERNATE>
     * f1 -> RecordKeyClause()
     */
    public void visit(AlternateRecordKeyClause n);

    /**
     * f0 -> <PASSWORD>
     * f1 -> [ <IS> ]
     * f2 -> DataName()
     */
    public void visit(PasswordClause n);

    /**
     * f0 -> [ <FILE> ]
     * f1 -> <STATUS>
     * f2 -> [ <IS> ]
     * f3 -> Identifier()
     * f4 -> [ Identifier() ]
     */
    public void visit(FileStatusClause n);

    /**
     * f0 -> <I_O_CONTROL>
     * f1 -> ( [ <DOT> ] IOControlClause() )*
     * f2 -> <DOT>
     */
    public void visit(IOControlParagraph n);

    /**
     * f0 -> RerunClause()
     *       | SameAreaClause()
     *       | MultipleFileClause()
     */
    public void visit(IOControlClause n);

    /**
     * f0 -> <RERUN>
     * f1 -> [ <ON> ( AssignmentName() | FileName() ) ]
     * f2 -> <EVERY>
     * f3 -> ( Rerun2() | IntegerConstant() [ <CLOCK_UNITS> ] )
     */
    public void visit(RerunClause n);

    /**
     * f0 -> IntegerConstant() <RECORDS>
     *       | [ <END> ] [ <OF> ] ( <REEL> | <UNIT> ) <OF> FileName()
     */
    public void visit(Rerun2 n);

    /**
     * f0 -> <SAME>
     * f1 -> [ <RECORD> | <SORT> | <SORT_MERGE> ]
     * f2 -> [ <AREA> ]
     * f3 -> [ <FOR> ]
     * f4 -> ( FileName() )+
     */
    public void visit(SameAreaClause n);

    /**
     * f0 -> <MULTIPLE>
     * f1 -> <FILE>
     * f2 -> [ <TAPE> ]
     * f3 -> [ <CONTAINS> ]
     * f4 -> ( FileName() [ [ <POSITION> ] IntegerConstant() ] )+
     */
    public void visit(MultipleFileClause n);

    /**
     * f0 -> <DATA>
     * f1 -> <DIVISION>
     * f2 -> <DOT>
     * f3 -> ( DataDivisionSection() )*
     */
    public void visit(DataDivision n);

    /**
     * f0 -> FileSection()
     *       | WorkingStorageSection()
     *       | LinkageSection()
     *       | CommunicationSection()
     */
    public void visit(DataDivisionSection n);

    /**
     * f0 -> <FILE>
     * f1 -> <SECTION>
     * f2 -> <DOT>
     * f3 -> ( FileAndSortDescriptionEntry() ( DataDescriptionEntry() )* )*
     */
    public void visit(FileSection n);

    /**
     * f0 -> ( <FD> | <SD> )
     * f1 -> FileName()
     * f2 -> ( [ <DOT> ] FileAndSortDescriptionEntryClause() )*
     * f3 -> <DOT>
     */
    public void visit(FileAndSortDescriptionEntry n);

    /**
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
     */
    public void visit(FileAndSortDescriptionEntryClause n);

    /**
     * f0 -> [ <IS> ]
     * f1 -> <EXTERNAL>
     */
    public void visit(ExternalClause n);

    /**
     * f0 -> [ <IS> ]
     * f1 -> <GLOBAL>
     */
    public void visit(GlobalClause n);

    /**
     * f0 -> <BLOCK>
     * f1 -> [ <CONTAINS> ]
     * f2 -> IntegerConstant()
     * f3 -> [ <TO> IntegerConstant() ]
     * f4 -> [ <RECORDS> | <CHARACTERS> ]
     */
    public void visit(BlockContainsClause n);

    /**
     * f0 -> <RECORD>
     * f1 -> [ <CONTAINS> ]
     * f2 -> ( IntegerConstant() [ <TO> IntegerConstant() ] [ <CHARACTERS> ] | [ <IS> ] <VARYING> [ <IN> ] [ <SIZE> ] [ [ <FROM> ] IntegerConstant() [ <TO> IntegerConstant() ] [ <CHARACTERS> ] ] [ <DEPENDING> [ <ON> ] Identifier() ] )
     */
    public void visit(RecordContainsClause n);

    /**
     * f0 -> <LABEL>
     * f1 -> ( <RECORD> [ ( <IS> | <ARE> ) ] | <RECORDS> [ ( <IS> | <ARE> ) ] )
     * f2 -> ( <OMITTED> | <STANDARD> | ( DataName() )+ )
     */
    public void visit(LabelRecordsClause n);

    /**
     * f0 -> <VALUE>
     * f1 -> <OF>
     * f2 -> ( SystemName() <IS> ( Identifier() | Literal() ) )+
     */
    public void visit(ValueOfClause n);

    /**
     * f0 -> <DATA>
     * f1 -> ( <RECORD> [ <IS> ] | <RECORDS> [ <ARE> ] )
     * f2 -> ( DataName() )+
     */
    public void visit(DataRecordClause n);

    /**
     * f0 -> <LINAGE>
     * f1 -> [ <IS> ]
     * f2 -> ( DataName() | IntegerConstant() )
     * f3 -> [ <LINES> ]
     * f4 -> ( [ <WITH> ] <FOOTING> [ <AT> ] ( DataName() | IntegerConstant() ) | [ <LINES> ] [ <AT> ] ( <TOP> | <BOTTOM> ) ( DataName() | IntegerConstant() ) )*
     */
    public void visit(LinageClause n);

    /**
     * f0 -> <RECORDING>
     * f1 -> [ <MODE> ]
     * f2 -> [ <IS> ]
     * f3 -> Mode()
     */
    public void visit(RecordingModeClause n);

    /**
     * f0 -> <CODE_SET>
     * f1 -> [ <IS> ]
     * f2 -> AlphabetName()
     */
    public void visit(CodeSetClause n);

    /**
     * f0 -> ( <REPORT> [ <IS> ] | <REPORTS> [ <ARE> ] )
     * f1 -> ( Identifier() )+
     */
    public void visit(ReportClause n);

    /**
     * f0 -> ( <LEVEL_66> LevelName66() RenamesClause() <DOT> | <LEVEL_77> LevelName77() ( DataDescriptionEntryClause() )* <DOT> | <LEVEL_88> LevelName88() ConditionValueClause() <DOT> | LevelNumber() LevelName() ( DataDescriptionEntryClause() )* <DOT> | ExecStatement() <DOT> )
     */
    public void visit(DataDescriptionEntry n);

    /**
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
     */
    public void visit(DataDescriptionEntryClause n);

    /**
     * f0 -> <REDEFINES>
     * f1 -> DataName()
     * f2 -> [ DataPictureClause() ]
     */
    public void visit(DataRedefinesClause n);

    /**
     * f0 -> <BLANK>
     * f1 -> [ <WHEN> ]
     * f2 -> ( <ZERO> | <ZEROS> | <ZEROES> )
     */
    public void visit(DataBlankWhenZeroClause n);

    /**
     * f0 -> ( <JUSTIFIED> | <JUST> )
     * f1 -> [ <RIGHT> ]
     */
    public void visit(DataJustifiedClause n);

    /**
     * f0 -> <OCCURS>
     * f1 -> IntegerConstant()
     * f2 -> [ <TO> IntegerConstant() ]
     * f3 -> [ <TIMES> ]
     * f4 -> [ <DEPENDING> [ <ON> ] Identifier() ]
     * f5 -> ( ( <ASCENDING> | <DESCENDING> ) [ <KEY> ] [ <IS> ] ( Identifier() )+ )*
     * f6 -> [ <INDEXED> [ <BY> ] IndexName() ( [ <COMMACHAR> ] IndexName() )* ]
     */
    public void visit(DataOccursClause n);

    /**
     * f0 -> ( <PICTURE> | <PIC> )
     * f1 -> [ <IS> ]
     * f2 -> <PICTURE_STRING>
     */
    public void visit(DataPictureClause n);

    /**
     * f0 -> <DOLLARCHAR>
     */
    public void visit(PictureCurrency n);

    /**
     * f0 -> IntegerConstant()
     *       | CobolWord()
     *       | PictureCurrency()
     */
    public void visit(NonDotChars n);

    /**
     * f0 -> [ <IS> ]
     * f1 -> <EXTERNAL>
     * f2 -> [ <BY> Literal() ]
     */
    public void visit(DataExternalClause n);

    /**
     * f0 -> [ <IS> ]
     * f1 -> <GLOBAL>
     */
    public void visit(DataGlobalClause n);

    /**
     * f0 -> [ <IS> ]
     * f1 -> <IDENTIFIED>
     * f2 -> <BY>
     * f3 -> Literal()
     */
    public void visit(DataIdentifiedClause n);

    /**
     * f0 -> [ <USAGE> [ <IS> ] ]
     * f1 -> ( MemoryUsage() | ExternalUsage() | PropertyObjectModifier() )
     */
    public void visit(DataUsageClause n);

    /**
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
     */
    public void visit(MemoryUsage n);

    /**
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
     */
    public void visit(ExternalUsage n);

    /**
     * f0 -> <CHARACTER>
     *       | <BINARY_BYTE>
     *       | <BINARY_SHORT>
     *       | <BINARY>
     *       | <BINARY_LONG>
     *       | <BINARY_DOUBLE>
     *       | <FLOAT_SHORT>
     *       | <FLOAT_LONG>
     *       | <BIT>
     */
    public void visit(PropertyObjectModifier n);

    /**
     * f0 -> [ <SIGN> [ <IS> ] ]
     * f1 -> ( <LEADING> | <TRAILING> )
     * f2 -> [ <SEPARATE> [ <CHARACTER> ] ]
     */
    public void visit(DataSignClause n);

    /**
     * f0 -> ( <SYNCHRONIZED> | <SYNC> )
     * f1 -> [ ( <LEFT> | <RIGHT> ) ]
     */
    public void visit(DataSynchronizedClause n);

    /**
     * f0 -> ( <VALUE> [ <IS> ] | <VALUES> [ <ARE> ] )
     * f1 -> Through()
     * f2 -> ( [ <COMMACHAR> ] Through() )*
     */
    public void visit(DataValueClause n);

    /**
     * f0 -> IterableLiteral()
     * f1 -> [ ( <THROUGH> | <THRU> ) IterableLiteral() ]
     */
    public void visit(Through n);

    /**
     * f0 -> DataValueClause()
     */
    public void visit(ConditionValueClause n);

    /**
     * f0 -> <RENAMES>
     * f1 -> Identifier()
     * f2 -> [ ( <THROUGH> | <THRU> ) Identifier() ]
     */
    public void visit(RenamesClause n);

    /**
     * f0 -> ( CommunicationInputEntry() | CommunicationOutputEntry() | CommunicationIOEntry() )
     * f1 -> <DOT>
     */
    public void visit(CommunicationDescriptionEntry n);

    /**
     * f0 -> <CD>
     * f1 -> CdName()
     * f2 -> [ <FOR> ]
     * f3 -> [ <INITIAL> ]
     * f4 -> <INPUT>
     * f5 -> ( CommunicationInputClause() )*
     * f6 -> ( DataName() )*
     */
    public void visit(CommunicationInputEntry n);

    /**
     * f0 -> <CD>
     * f1 -> CdName()
     * f2 -> [ <FOR> ]
     * f3 -> <OUTPUT>
     * f4 -> ( CommunicationOutputClause() )*
     */
    public void visit(CommunicationOutputEntry n);

    /**
     * f0 -> <CD>
     * f1 -> CdName()
     * f2 -> [ <FOR> ]
     * f3 -> [ <INITIAL> ]
     * f4 -> <I_O>
     * f5 -> ( CommunicationIOClause() )*
     * f6 -> ( DataName() )*
     */
    public void visit(CommunicationIOEntry n);

    /**
     * f0 -> <MESSAGE> ( <DATE> | <TIME> | <COUNT> ) [ <IS> ] DataName()
     *       | <TEXT> <LENGTH> [ <IS> ] DataName()
     *       | <END> <KEY> [ <IS> ] DataName()
     *       | <STATUS> <KEY> [ <IS> ] DataName()
     *       | <COUNT> [ <IS> ] DataName()
     *       | [ <SYMBOLIC> ] ( <QUEUE> | <SUB_QUEUE_1> | <SUB_QUEUE_2> | <SUB_QUEUE_3> | <SOURCE> ) [ <IS> ] DataName()
     */
    public void visit(CommunicationInputClause n);

    /**
     * f0 -> <DESTINATION> <COUNT> [ <IS> ] DataName()
     *       | <TEXT> <LENGTH> [ <IS> ] DataName()
     *       | <STATUS> <KEY> [ <IS> ] DataName()
     *       | [ <SYMBOLIC> ] <DESTINATION> [ <IS> ] DataName()
     *       | <DESTINATION> <TABLE> <OCCURS> IntegerConstant() [ <TIMES> ] [ <INDEXED> [ <BY> ] ( IndexName() )+ ]
     *       | <ERROR> <KEY> [ <IS> ] DataName()
     */
    public void visit(CommunicationOutputClause n);

    /**
     * f0 -> <MESSAGE> ( <DATE> | <TIME> ) [ <IS> ] DataName()
     *       | <TEXT> <LENGTH> [ <IS> ] DataName()
     *       | <END> <KEY> [ <IS> ] DataName()
     *       | <STATUS> <KEY> [ <IS> ] DataName()
     *       | [ <SYMBOLIC> ] <TERMINAL> [ <IS> ] DataName()
     */
    public void visit(CommunicationIOClause n);

    /**
     * f0 -> <WORKING_STORAGE>
     * f1 -> <SECTION>
     * f2 -> <DOT>
     * f3 -> ( DataDescriptionEntry() )*
     */
    public void visit(WorkingStorageSection n);

    /**
     * f0 -> ( DataDescriptionEntry() )*
     */
    public void visit(LinkageSectionEntry n);

    /**
     * f0 -> <LINKAGE>
     * f1 -> <SECTION>
     * f2 -> <DOT>
     * f3 -> LinkageSectionEntry()
     */
    public void visit(LinkageSection n);

    /**
     * f0 -> <COMMUNICATION>
     * f1 -> <SECTION>
     * f2 -> <DOT>
     * f3 -> ( CommunicationDescriptionEntry() ( DataDescriptionEntry() )* )*
     */
    public void visit(CommunicationSection n);

    /**
     * f0 -> <PROCEDURE>
     * f1 -> <DIVISION>
     * f2 -> [ ConventionName() ]
     * f3 -> [ <USING> ( DataName() )+ ]
     * f4 -> <DOT>
     * f5 -> [ Declaratives() ]
     * f6 -> ProcedureBody()
     */
    public void visit(ProcedureDivision n);

    /**
     * f0 -> <DECLARATIVES>
     * f1 -> <DOT>
     * f2 -> ( SectionHeader() <DOT> UseStatement() <DOT> Paragraphs() )+
     * f3 -> <END>
     * f4 -> <DECLARATIVES>
     * f5 -> <DOT>
     */
    public void visit(Declaratives n);

    /**
     * f0 -> Paragraphs()
     * f1 -> ( ProcedureSection() )*
     */
    public void visit(ProcedureBody n);

    /**
     * f0 -> SectionHeader()
     * f1 -> <DOT>
     * f2 -> Paragraphs()
     */
    public void visit(ProcedureSection n);

    /**
     * f0 -> SectionName()
     * f1 -> <SECTION>
     * f2 -> [ IntegerConstant() ]
     */
    public void visit(SectionHeader n);

    /**
     * f0 -> ( Sentence() )*
     * f1 -> ( Paragraph() )*
     */
    public void visit(Paragraphs n);

    /**
     * f0 -> ParagraphName()
     * f1 -> <DOT>
     * f2 -> ( ExitStatement() | AlteredGoto() | Sentence() )*
     */
    public void visit(Paragraph n);

    /**
     * f0 -> StatementList()
     * f1 -> <DOT>
     */
    public void visit(Sentence n);

    /**
     * f0 -> ( Statement() )+
     */
    public void visit(StatementList n);

    /**
     * f0 -> ( AcceptStatement() | AddStatement() | AlterStatement() | CallStatement() | CancelStatement() | CloseStatement() | ComputeStatement() | ContinueStatement() | DeleteStatement() | DisplayStatement() | DivideStatement() | EntryStatement() | EvaluateStatement() | ExecStatement() | ExitProgramStatement() | GobackStatement() | GotoStatement() | IfStatement() | InitializeStatement() | InspectStatement() | MergeStatement() | MoveStatement() | MultiplyStatement() | OpenStatement() | PerformStatement() | ReadStatement() | ReleaseStatement() | ReturnStatement() | RewriteStatement() | SearchStatement() | SetStatement() | SortStatement() | StartStatement() | StopStatement() | StringStatement() | SubtractStatement() | UnstringStatement() | WriteStatement() | ServiceStatement() )
     */
    public void visit(Statement n);

    /**
     * f0 -> <ACCEPT>
     * f1 -> ( <REPLY> | <OMITTED> | Identifier() )
     * f2 -> [ <FROM> ( MnemonicName() | EnvironmentName() | <DATE> [ <YYYYMMDD> ] | <DAY> [ <YYYYDDD> ] | <DAY_OF_WEEK> | <TIME> ) ]
     */
    public void visit(AcceptStatement n);

    /**
     * f0 -> <ADD>
     * f1 -> ( ( <CORRESPONDING> | <CORR> ) Identifier() <TO> Identifier() [ <ROUNDED> ] | ( Identifier() | Literal() ) ( [ <COMMACHAR> ] ( Identifier() | Literal() ) )* [ <TO> ( Identifier() [ <ROUNDED> ] )+ ] [ <GIVING> ( Identifier() [ <ROUNDED> ] )+ ] )
     * f2 -> [ [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f3 -> [ <NOT> [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f4 -> [ <END_ADD> ]
     */
    public void visit(AddStatement n);

    /**
     * f0 -> <GO>
     * f1 -> [ <TO> ]
     * f2 -> <DOT>
     */
    public void visit(AlteredGoto n);

    /**
     * f0 -> <ALTER>
     * f1 -> ( ProcedureName() <TO> [ <PROCEED> <TO> ] ProcedureName() )+
     */
    public void visit(AlterStatement n);

    /**
     * f0 -> [ <BY> ]
     * f1 -> <CONTENT>
     * f2 -> ( <ADDRESS> <OF> Identifier() | [ <LENGTH> <OF> ] Identifier() | Literal() | <OMITTED> )
     * f3 -> ( [ <COMMACHAR> ] ( <ADDRESS> <OF> Identifier() | [ <LENGTH> <OF> ] Identifier() | Literal() | <OMITTED> ) )*
     */
    public void visit(CallByContent n);

    /**
     * f0 -> [ [ <BY> ] <REFERENCE> ]
     * f1 -> ( <ADDRESS> <OF> Identifier() | Identifier() | FileName() | <OMITTED> )
     * f2 -> ( [ <COMMACHAR> ] ( <ADDRESS> <OF> Identifier() | Identifier() | FileName() | <OMITTED> ) )*
     */
    public void visit(CallByReference n);

    /**
     * f0 -> [ <BY> ]
     * f1 -> <DESCRIPTOR>
     * f2 -> ( <ADDRESS> <OF> Identifier() | Identifier() | FileName() | <OMITTED> )+
     */
    public void visit(CallByDescriptor n);

    /**
     * f0 -> [ <BY> ]
     * f1 -> <VALUE>
     * f2 -> ( <ADDRESS> <OF> Identifier() | [ <LENGTH> <OF> ] Identifier() | Literal() | <OMITTED> )+
     */
    public void visit(CallByValue n);

    /**
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
     */
    public void visit(CallStatement n);

    /**
     * f0 -> <CANCEL>
     * f1 -> ( Identifier() | Literal() )+
     */
    public void visit(CancelStatement n);

    /**
     * f0 -> <CLOSE>
     * f1 -> ( FileName() [ ( ( <REEL> | <UNIT> ) [ ( [ <FOR> ] <REMOVAL> | [ <WITH> ] <NO> <REWIND> ) ] | [ <WITH> ] ( <NO> <REWIND> | <LOCK> ) ) ] )+
     */
    public void visit(CloseStatement n);

    /**
     * f0 -> <COMPUTE>
     * f1 -> ( Identifier() [ <ROUNDED> ] )+
     * f2 -> ( <EQUALCHAR> | <EQUAL> )
     * f3 -> ArithmeticExpression()
     * f4 -> [ [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f5 -> [ <NOT> [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f6 -> [ <END_COMPUTE> ]
     */
    public void visit(ComputeStatement n);

    /**
     * f0 -> <CONTINUE>
     */
    public void visit(ContinueStatement n);

    /**
     * f0 -> <DELETE>
     * f1 -> FileName()
     * f2 -> [ <RECORD> ]
     * f3 -> [ <INVALID> [ <KEY> ] StatementList() ]
     * f4 -> [ <NOT> <INVALID> [ <KEY> ] StatementList() ]
     * f5 -> [ <END_DELETE> ]
     */
    public void visit(DeleteStatement n);

    /**
     * f0 -> <DISPLAY>
     * f1 -> ( Identifier() | Literal() )
     * f2 -> ( [ <COMMACHAR> ] ( Identifier() | Literal() ) )*
     * f3 -> [ <UPON> ( MnemonicName() | EnvironmentName() ) ]
     * f4 -> [ [ <WITH> ] <NO> <ADVANCING> ]
     */
    public void visit(DisplayStatement n);

    /**
     * f0 -> <DIVIDE>
     * f1 -> ( Identifier() | Literal() )
     * f2 -> ( <INTO> ( Identifier() | Literal() ) [ <ROUNDED> ] ( <GIVING> ( Identifier() [ <ROUNDED> ] )+ | ( ( Identifier() | Literal() ) [ <ROUNDED> ] )* ) | <BY> ( Identifier() | Literal() ) [ <GIVING> ( Identifier() [ <ROUNDED> ] )+ ] )
     * f3 -> [ <REMAINDER> Identifier() ]
     * f4 -> [ [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f5 -> [ <NOT> [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f6 -> [ <END_DIVIDE> ]
     */
    public void visit(DivideStatement n);

    /**
     * f0 -> <ENTRY>
     * f1 -> Literal()
     * f2 -> [ <USING> ( Identifier() )+ ]
     */
    public void visit(EntryStatement n);

    /**
     * f0 -> <EVALUATE>
     * f1 -> EvaluateValue()
     * f2 -> ( <ALSO> EvaluateValue() )*
     * f3 -> ( ( EvaluateWhenClause() )+ [ <THEN> ] StatementList() )+
     * f4 -> [ <END_EVALUATE> ]
     */
    public void visit(EvaluateStatement n);

    /**
     * f0 -> ( Condition() | <TRUE> | <FALSE> )
     */
    public void visit(EvaluateValue n);

    /**
     * f0 -> ( <WHEN> <OTHER> | <WHEN> EvaluatePhrase() ( <ALSO> EvaluatePhrase() )* )
     */
    public void visit(EvaluateWhenClause n);

    /**
     * f0 -> [ <NOT> ]
     * f1 -> ArithmeticExpression()
     * f2 -> ( <THROUGH> | <THRU> )
     * f3 -> ArithmeticExpression()
     */
    public void visit(EvaluateThruPhrase n);

    /**
     * f0 -> ( EvaluateThruPhrase() | Condition() | <ANY> | <TRUE> | <FALSE> )
     */
    public void visit(EvaluatePhrase n);

    /**
     * f0 -> <EXEC>
     */
    public void visit(ExecStatement n);

    /**
     * f0 -> <EXIT>
     * f1 -> <DOT>
     */
    public void visit(ExitStatement n);

    /**
     * f0 -> <EXIT>
     * f1 -> <PROGRAM>
     */
    public void visit(ExitProgramStatement n);

    /**
     * f0 -> <GOBACK>
     */
    public void visit(GobackStatement n);

    /**
     * f0 -> <GO>
     * f1 -> [ <TO> ]
     * f2 -> ( ( ProcedureName() )+ [ <DEPENDING> [ <ON> ] Identifier() ] | <MORE_LABELS> )
     */
    public void visit(GotoStatement n);

    /**
     * f0 -> <IF>
     * f1 -> Condition()
     * f2 -> [ <THEN> ]
     * f3 -> ( StatementList() | <NEXT> <SENTENCE> )
     * f4 -> [ <ELSE> ( StatementList() | <NEXT> <SENTENCE> ) ]
     * f5 -> [ <END_IF> ]
     */
    public void visit(IfStatement n);

    /**
     * f0 -> <INITIALIZE>
     * f1 -> ( Identifier() )+
     * f2 -> [ <REPLACING> ( ( <ALPHABETIC> | <ALPHANUMERIC> | <NUMERIC> | <ALPHANUMERIC_EDITED> | <NUMERIC_EDITED> | <DBCS> | <EGCS> ) [ <DATA> ] <BY> ( Identifier() | Literal() ) )+ ]
     */
    public void visit(InitializeStatement n);

    /**
     * f0 -> <INSPECT>
     * f1 -> Identifier()
     * f2 -> ( TallyingPhrase() | ConvertingPhrase() | ReplacingPhrase() )
     */
    public void visit(InspectStatement n);

    /**
     * f0 -> <CHARACTERS>
     * f1 -> ( IterableBeforeAfterPhrase() )*
     */
    public void visit(IterableTallyingClause n);

    /**
     * f0 -> ( <ALL> | <LEADING> )
     * f1 -> IterableBeforeAfterClause()
     * f2 -> ( ( Identifier() <FOR> ( RecursiveTallyingClause() | IterableTallyingClause() )+ )+ | IterableBeforeAfterClause() )*
     */
    public void visit(RecursiveTallyingClause n);

    /**
     * f0 -> <TALLYING>
     * f1 -> ( Identifier() <FOR> ( RecursiveTallyingClause() | IterableTallyingClause() )+ )+
     * f2 -> [ ReplacingPhrase() ]
     */
    public void visit(TallyingPhrase n);

    /**
     * f0 -> <CONVERTING>
     * f1 -> ( Identifier() | Literal() )
     * f2 -> <TO>
     * f3 -> IterableBeforeAfterClause()
     */
    public void visit(ConvertingPhrase n);

    /**
     * f0 -> <REPLACING>
     * f1 -> ( <CHARACTERS> <BY> IterableBeforeAfterClause() | ( <ALL> | <LEADING> | <FIRST> ) ( ( Identifier() | Literal() ) <BY> IterableBeforeAfterClause() )+ )+
     */
    public void visit(ReplacingPhrase n);

    /**
     * f0 -> ( Identifier() | IterableLiteral() )
     * f1 -> ( IterableBeforeAfterPhrase() )*
     */
    public void visit(IterableBeforeAfterClause n);

    /**
     * f0 -> ( <BEFORE> | <AFTER> )
     * f1 -> [ <INITIAL> ]
     * f2 -> ( Identifier() | IterableLiteral() )
     */
    public void visit(IterableBeforeAfterPhrase n);

    /**
     * f0 -> <MERGE>
     * f1 -> FileName()
     * f2 -> ( [ <ON> ] ( <ASCENDING> | <DESCENDING> ) [ <KEY> ] ( Identifier() )+ )+
     * f3 -> [ [ <COLLATING> ] <SEQUENCE> [ <IS> ] AlphabetName() ]
     * f4 -> <USING>
     * f5 -> FileName()
     * f6 -> ( FileName() )+
     * f7 -> ( <OUTPUT> <PROCEDURE> [ <IS> ] ProcedureName() [ ( <THROUGH> | <THRU> ) ProcedureName() ] | <GIVING> ( FileName() )+ )
     */
    public void visit(MergeStatement n);

    /**
     * f0 -> <MOVE>
     * f1 -> ( ArithmeticExpression() <TO> Identifier() ( [ <COMMACHAR> ] Identifier() )* | ( <CORRESPONDING> | <CORR> ) Identifier() <TO> ( Identifier() )+ )
     */
    public void visit(MoveStatement n);

    /**
     * f0 -> <MULTIPLY>
     * f1 -> ( Identifier() | Literal() )
     * f2 -> <BY>
     * f3 -> ( ( Identifier() | Literal() ) [ <ROUNDED> ] )+
     * f4 -> [ <GIVING> ( Identifier() [ <ROUNDED> ] )+ ]
     * f5 -> [ [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f6 -> [ <NOT> [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f7 -> [ <END_MULTIPLY> ]
     */
    public void visit(MultiplyStatement n);

    /**
     * f0 -> <OPEN>
     * f1 -> ( <INPUT> ( FileName() [ ( <REVERSED> | [ <WITH> ] <NO> <REWIND> ) ] )+ | <OUTPUT> ( FileName() [ [ <WITH> ] <NO> <REWIND> ] )+ | <I_O> ( FileName() )+ | <EXTEND> ( FileName() )+ )+
     */
    public void visit(OpenStatement n);

    /**
     * f0 -> <PERFORM>
     * f1 -> ( PerformFlavour() StatementList() <END_PERFORM> | PerformProcedureScopeClause() PerformFlavour() | StatementList() <END_PERFORM> | PerformProcedureScopeClause() )
     */
    public void visit(PerformStatement n);

    /**
     * f0 -> PerformTimeClause()
     *       | [ PerformTestPositionClause() ] ( PerformUntilClause() | PerformVaryingWithAfterClause() )
     */
    public void visit(PerformFlavour n);

    /**
     * f0 -> <VARYING>
     * f1 -> PerformVaryingPhrase()
     * f2 -> ( <AFTER> PerformVaryingPhrase() )*
     */
    public void visit(PerformVaryingWithAfterClause n);

    /**
     * f0 -> Identifier()
     * f1 -> <FROM>
     * f2 -> ( Identifier() | Literal() )
     * f3 -> <BY>
     * f4 -> ( Identifier() | Literal() )
     * f5 -> PerformUntilClause()
     */
    public void visit(PerformVaryingPhrase n);

    /**
     * f0 -> <UNTIL>
     * f1 -> Condition()
     */
    public void visit(PerformUntilClause n);

    /**
     * f0 -> [ <WITH> ]
     * f1 -> <TEST>
     * f2 -> ( <BEFORE> | <AFTER> )
     */
    public void visit(PerformTestPositionClause n);

    /**
     * f0 -> ProcedureName()
     * f1 -> [ ( <THROUGH> | <THRU> ) ProcedureName() ]
     */
    public void visit(PerformProcedureScopeClause n);

    /**
     * f0 -> ( Identifier() | IntegerConstant() )
     * f1 -> <TIMES>
     */
    public void visit(PerformTimeClause n);

    /**
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
     */
    public void visit(ReadStatement n);

    /**
     * f0 -> <RELEASE>
     * f1 -> RecordName()
     * f2 -> [ <FROM> Identifier() ]
     */
    public void visit(ReleaseStatement n);

    /**
     * f0 -> <RETURN>
     * f1 -> FileName()
     * f2 -> [ <RECORD> ]
     * f3 -> [ <INTO> Identifier() ]
     * f4 -> [ <AT> ]
     * f5 -> <END>
     * f6 -> StatementList()
     * f7 -> [ <NOT> [ <AT> ] <END> StatementList() ]
     * f8 -> [ <END_RETURN> ]
     */
    public void visit(ReturnStatement n);

    /**
     * f0 -> <REWRITE>
     * f1 -> RecordName()
     * f2 -> [ <FROM> Identifier() ]
     * f3 -> [ <INVALID> [ <KEY> ] StatementList() ]
     * f4 -> [ <NOT> <INVALID> [ <KEY> ] StatementList() ]
     * f5 -> [ <END_REWRITE> ]
     */
    public void visit(RewriteStatement n);

    /**
     * f0 -> <SEARCH>
     * f1 -> [ <ALL> ]
     * f2 -> Identifier()
     * f3 -> [ <VARYING> Identifier() ]
     * f4 -> [ [ <AT> ] <END> StatementList() ]
     * f5 -> ( <WHEN> Condition() ( StatementList() | <NEXT> <SENTENCE> ) )+
     * f6 -> [ <END_SEARCH> ]
     */
    public void visit(SearchStatement n);

    /**
     * f0 -> <SET>
     * f1 -> [ <CONFIGURATION> ]
     * f2 -> ( Identifier() | Literal() )
     * f3 -> ( [ <COMMACHAR> ] Identifier() | Literal() )*
     * f4 -> ( <TO> [ <CONFIGURATION> ] ( Identifier() | <TRUE> | <FALSE> | <ON> | <OFF> | [ <ENTRY> ] Literal() ) | ( <UP> | <DOWN> ) [ <BY> ] ( Identifier() | Literal() ) )
     */
    public void visit(SetStatement n);

    /**
     * f0 -> <SORT>
     * f1 -> FileName()
     * f2 -> ( [ <ON> ] ( <ASCENDING> | <DESCENDING> ) [ <KEY> ] ( Identifier() )+ )+
     * f3 -> [ [ <WITH> ] <DUPLICATES> [ <IN> ] [ <ORDER> ] ]
     * f4 -> [ [ <COLLATING> ] <SEQUENCE> [ <IS> ] AlphabetName() ]
     * f5 -> ( <USING> ( FileName() )+ | <INPUT> <PROCEDURE> [ <IS> ] ProcedureName() [ ( <THROUGH> | <THRU> ) ProcedureName() ] )
     * f6 -> ( <GIVING> ( FileName() )+ | <OUTPUT> <PROCEDURE> [ <IS> ] ProcedureName() [ ( <THROUGH> | <THRU> ) ProcedureName() ] )
     */
    public void visit(SortStatement n);

    /**
     * f0 -> <START>
     * f1 -> FileName()
     * f2 -> [ <KEY> RelationalOperator() Identifier() ]
     * f3 -> [ <INVALID> [ <KEY> ] StatementList() ]
     * f4 -> [ <NOT> <INVALID> [ <KEY> ] StatementList() ]
     * f5 -> [ <END_START> ]
     */
    public void visit(StartStatement n);

    /**
     * f0 -> <STOP>
     * f1 -> ( <RUN> | Literal() )
     */
    public void visit(StopStatement n);

    /**
     * f0 -> <STRING>
     * f1 -> ( ( Identifier() | IterableLiteral() ) ( [ <COMMACHAR> ] ( Identifier() | IterableLiteral() ) )* <DELIMITED> [ <BY> ] ( Identifier() | IterableLiteral() | <SIZE> ) )+
     * f2 -> <INTO>
     * f3 -> Identifier()
     * f4 -> [ [ <WITH> ] <POINTER> Identifier() ]
     * f5 -> [ [ <ON> ] <OVERFLOW> StatementList() ]
     * f6 -> [ <NOT> [ <ON> ] <OVERFLOW> StatementList() ]
     * f7 -> [ <END_STRING> ]
     */
    public void visit(StringStatement n);

    /**
     * f0 -> <SUBTRACT>
     * f1 -> ( ( Identifier() | Literal() )+ <FROM> ( ( Identifier() | Literal() ) [ <ROUNDED> ] )+ [ <GIVING> ( Identifier() [ <ROUNDED> ] )+ ] | ( <CORRESPONDING> | <CORR> ) Identifier() <FROM> Identifier() [ <ROUNDED> ] )
     * f2 -> [ [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f3 -> [ <NOT> [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f4 -> [ <END_SUBTRACT> ]
     */
    public void visit(SubtractStatement n);

    /**
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
     */
    public void visit(UnstringStatement n);

    /**
     * f0 -> <USE>
     * f1 -> ( [ <FOR> ] <DEBUGGING> [ <ON> ] ( ( ProcedureName() )+ | <ALL> ( <PROCEDURES> | <REFERENCES> <OF> DataName() ) ) | [ <GLOBAL> ] <AFTER> [ <STANDARD> ] ( ( <EXCEPTION> | <ERROR> ) | [ ( <BEGINNING> | <ENDING> ) ] [ ( <FILE> | <REEL> | <UNIT> ) ] <LABEL> ) <PROCEDURE> [ <ON> ] ( ( FileName() )+ | <INPUT> | <OUTPUT> | <I_O> | <EXTEND> ) )
     */
    public void visit(UseStatement n);

    /**
     * f0 -> <WRITE>
     * f1 -> RecordName()
     * f2 -> [ <FROM> Identifier() ]
     * f3 -> [ AdvancingPhrase() ]
     * f4 -> [ [ <AT> ] ( <END_OF_PAGE> | <EOP> ) StatementList() ]
     * f5 -> [ <NOT> [ <AT> ] ( <END_OF_PAGE> | <EOP> ) StatementList() ]
     * f6 -> [ <INVALID> [ <KEY> ] StatementList() ]
     * f7 -> [ <NOT> <INVALID> [ <KEY> ] StatementList() ]
     * f8 -> [ <END_WRITE> ]
     */
    public void visit(WriteStatement n);

    /**
     * f0 -> <SERVICE>
     * f1 -> <LABEL>
     */
    public void visit(ServiceStatement n);

    /**
     * f0 -> ( <BEFORE> | <AFTER> )
     * f1 -> [ <ADVANCING> ]
     * f2 -> ( <PAGE> | ( IntegerConstant() | Identifier() | Literal() ) [ ( <LINE> | <LINES> ) ] | MnemonicName() )
     */
    public void visit(AdvancingPhrase n);

    /**
     * f0 -> ( DataDescriptionEntry() )*
     * f1 -> <EOF>
     */
    public void visit(DataDescription n);

    /**
     * f0 -> ( Sentence() )*
     * f1 -> <EOF>
     */
    public void visit(SentenceList n);

}

