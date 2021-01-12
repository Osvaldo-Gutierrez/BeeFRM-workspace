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
 * All GJ visitors with no argument must implement this interface.
 */

public interface GJNoArguVisitor<R> {

   //
   // GJ Auto class visitors with no argument
   //

   public R visit(NodeList n);
   public R visit(NodeListOptional n);
   public R visit(NodeOptional n);
   public R visit(NodeSequence n);
   public R visit(NodeToken n);

    //
    // User-generated visitor methods below
    //

    /**
     * f0 -> <COBOL_WORD>
     */
    public R visit(CobolWord n);

    /**
     * f0 -> ( IterableQuotedText() )+
     */
    public R visit(QuotedText n);

    /**
     * f0 -> <QUOTEDSTRING>
     *       | <DOUBLEDQUOTECHAR>
     *       | <DOUBLEDAPOSTROPHE>
     */
    public R visit(IterableQuotedText n);

    /**
     * f0 -> <LEVEL_66>
     *       | <LEVEL_77>
     *       | <LEVEL_88>
     *       | <INTEGER>
     */
    public R visit(IntegerConstant n);

    /**
     * f0 -> [ <PLUSCHAR> | <MINUSCHAR> ]
     * f1 -> ( IntegerConstant() | <REAL> )
     */
    public R visit(NumericConstant n);

    /**
     * f0 -> <INTEGER>
     */
    public R visit(LevelNumber n);

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
    public R visit(FigurativeConstant n);

    /**
     * f0 -> ( QuotedText() | <HEXNUMBER> )
     */
    public R visit(NonNumericConstant n);

    /**
     * f0 -> ( IterableQuotedText() | <HEXNUMBER> )
     */
    public R visit(IterableNonNumericConstant n);

    /**
     * f0 -> [ <ALL> ]
     * f1 -> ( NonNumericConstant() | NumericConstant() | FigurativeConstant() )
     */
    public R visit(Literal n);

    /**
     * f0 -> [ <ALL> ]
     * f1 -> ( IterableNonNumericConstant() | NumericConstant() | FigurativeConstant() )
     */
    public R visit(IterableLiteral n);

    /**
     * f0 -> ArithmeticExpression()
     *       | <LPARENCHAR> Condition() <RPARENCHAR>
     */
    public R visit(IterableCondition n);

    /**
     * f0 -> CombinableCondition()
     * f1 -> ( ( <AND> | <OR> ) ( CombinableCondition() | AbbreviationRest() ) )*
     */
    public R visit(Condition n);

    /**
     * f0 -> [ <NOT> ]
     * f1 -> SimpleCondition()
     */
    public R visit(CombinableCondition n);

    /**
     * f0 -> RelationCondition()
     *       | ArithmeticExpression()
     *       | <LPARENCHAR> Condition() <RPARENCHAR>
     */
    public R visit(SimpleCondition n);

    /**
     * f0 -> [ <IS> ]
     * f1 -> [ <NOT> ]
     * f2 -> ( <NUMERIC> | <ALPHABETIC> | <ALPHABETIC_LOWER> | <ALPHABETIC_UPPER> | ClassName() | <DBCS> | <KANJI> )
     */
    public R visit(ClassCondition n);

    /**
     * f0 -> ArithmeticExpression()
     * f1 -> ( AbbreviationRest() | SignCondition() | ClassCondition() )
     */
    public R visit(RelationCondition n);

    /**
     * f0 -> [ <IS> ]
     * f1 -> [ <NOT> ]
     * f2 -> ( <POSITIVE> | <NEGATIVE> | <ZERO> | <ZEROS> | <ZEROES> )
     */
    public R visit(SignCondition n);

    /**
     * f0 -> [ <IS> ]
     * f1 -> [ <NOT> ]
     * f2 -> ( <GREATER> [ <THAN> ] [ <OR> <EQUAL> [ <TO> ] ] | <MORETHANCHAR> | <LESS> [ <THAN> ] [ <OR> <EQUAL> [ <TO> ] ] | <LESSTHANCHAR> | <EQUAL> [ <TO> ] | <EQUALCHAR> | <NOTEQUAL> | <MORETHANOREQUAL> | <LESSTHANOREQUAL> )
     */
    public R visit(RelationalOperator n);

    /**
     * f0 -> ArithmeticExpression()
     *       | <LPARENCHAR> AbbreviationLeaf() ( ( <AND> | <OR> ) AbbreviationLeaf() )+ <RPARENCHAR>
     */
    public R visit(AbbreviationLeaf n);

    /**
     * f0 -> RelationalOperator()
     * f1 -> AbbreviationLeaf()
     */
    public R visit(AbbreviationRest n);

    /**
     * f0 -> ( ParagraphName() [ ( <IN> | <OF> ) SectionName() ] | SectionName() )
     */
    public R visit(ProcedureName n);

    /**
     * f0 -> <LPARENCHAR>
     * f1 -> ArithmeticExpression()
     * f2 -> ( [ <COMMACHAR> ] ArithmeticExpression() )*
     * f3 -> <RPARENCHAR>
     */
    public R visit(Subscript n);

    /**
     * f0 -> <FUNCTION>
     * f1 -> FunctionName()
     * f2 -> [ Subscript() ]
     * f3 -> [ <LPARENCHAR> LeftmostCharacterPosition() <COLONCHAR> [ Length() ] <RPARENCHAR> ]
     */
    public R visit(FunctionClause n);

    /**
     * f0 -> ( QualifiedDataName() ( Subscript() )* [ <LPARENCHAR> LeftmostCharacterPosition() <COLONCHAR> [ Length() ] <RPARENCHAR> ] | <LINAGE_COUNTER> [ ( <IN> | <OF> ) FileName() ] | <PROGRAM_STATUS> )
     */
    public R visit(Identifier n);

    /**
     * f0 -> ( DataName() ( ( <IN> | <OF> ) DataName() )* [ ( <IN> | <OF> ) FileName() ] | SpecialRegister() )
     */
    public R visit(QualifiedDataName n);

    /**
     * f0 -> ArithmeticExpression()
     */
    public R visit(Length n);

    /**
     * f0 -> ArithmeticExpression()
     */
    public R visit(LeftmostCharacterPosition n);

    /**
     * f0 -> CobolWord()
     */
    public R visit(Mode n);

    /**
     * f0 -> CobolWord()
     */
    public R visit(AlphabetName n);

    /**
     * f0 -> CobolWord()
     */
    public R visit(ClassName n);

    /**
     * f0 -> CobolWord()
     */
    public R visit(ConditionName n);

    /**
     * f0 -> CobolWord()
     */
    public R visit(DataName n);

    /**
     * f0 -> CobolWord()
     */
    public R visit(FileName n);

    /**
     * f0 -> CobolWord()
     */
    public R visit(IndexName n);

    /**
     * f0 -> CobolWord()
     */
    public R visit(MnemonicName n);

    /**
     * f0 -> Identifier()
     */
    public R visit(RecordName n);

    /**
     * f0 -> CobolWord()
     */
    public R visit(RoutineName n);

    /**
     * f0 -> CobolWord()
     */
    public R visit(SymbolicCharacter n);

    /**
     * f0 -> CobolWord()
     */
    public R visit(LibraryName n);

    /**
     * f0 -> CobolWord()
     */
    public R visit(ProgramName n);

    /**
     * f0 -> IntegerConstant()
     *       | CobolWord()
     */
    public R visit(SectionName n);

    /**
     * f0 -> IntegerConstant()
     *       | CobolWord()
     */
    public R visit(ParagraphName n);

    /**
     * f0 -> CobolWord()
     */
    public R visit(SystemName n);

    /**
     * f0 -> SystemName()
     */
    public R visit(ComputerName n);

    /**
     * f0 -> SystemName()
     */
    public R visit(LanguageName n);

    /**
     * f0 -> SystemName()
     */
    public R visit(EnvironmentName n);

    /**
     * f0 -> SystemName()
     */
    public R visit(AssignmentName n);

    /**
     * f0 -> ProgramName()
     */
    public R visit(BasisName n);

    /**
     * f0 -> ( CobolWord() | <LENGTH> | <WHEN_COMPILED> | <SUM> | <RANDOM> )
     */
    public R visit(FunctionName n);

    /**
     * f0 -> ( <ADDRESS> <OF> DataName() | <DEBUG_ITEM> | <LENGTH> <OF> Identifier() | <RETURN_CODE> | <SHIFT_OUT> | <SHIFT_IN> | <SORT_CONTROL> | <SORT_CORE_SIZE> | <SORT_FILE_SIZE> | <SORT_MESSAGE> | <SORT_MODE_SIZE> | <SORT_RETURN> | <TALLY> | <WHEN_COMPILED> )
     */
    public R visit(SpecialRegister n);

    /**
     * f0 -> CobolWord()
     */
    public R visit(CdName n);

    /**
     * f0 -> CobolWord()
     */
    public R visit(ConventionName n);

    /**
     * f0 -> CobolWord()
     */
    public R visit(HandleComponent n);

    /**
     * f0 -> QuotedText()
     */
    public R visit(ImplicitTitle n);

    /**
     * f0 -> DataName()
     */
    public R visit(LevelName66 n);

    /**
     * f0 -> DataName()
     */
    public R visit(LevelName77 n);

    /**
     * f0 -> ConditionName()
     */
    public R visit(LevelName88 n);

    /**
     * f0 -> [ DataName() | <FILLER> | <REPLY> | <PROGRAM_STATUS> ]
     */
    public R visit(LevelName n);

    /**
     * f0 -> TimesDiv()
     * f1 -> ( ( <PLUSCHAR> | <MINUSCHAR> ) TimesDiv() )*
     */
    public R visit(ArithmeticExpression n);

    /**
     * f0 -> Power()
     * f1 -> ( ( <ASTERISKCHAR> | <SLASHCHAR> ) Power() )*
     */
    public R visit(TimesDiv n);

    /**
     * f0 -> [ ( <PLUSCHAR> | <MINUSCHAR> ) ]
     * f1 -> Basis()
     * f2 -> ( <POWEROF> Basis() )*
     */
    public R visit(Power n);

    /**
     * f0 -> ( FunctionClause() | Identifier() | Literal() | <ALL> | <LPARENCHAR> ArithmeticExpression() <RPARENCHAR> )
     */
    public R visit(Basis n);

    /**
     * f0 -> ( ( NonDotChars() | Literal() )+ [ <DOT> ] )+
     */
    public R visit(CommentLine n);

    /**
     * f0 -> ProgramUnit()
     * f1 -> ( NestedProgramUnit() EndProgramStatement() )*
     * f2 -> [ EndProgramStatement() ( CompilationUnit() )* ]
     * f3 -> <EOF>
     */
    public R visit(CompilationUnit n);

    /**
     * f0 -> IdentificationDivision()
     * f1 -> [ EnvironmentDivision() ]
     * f2 -> [ DataDivision() ]
     * f3 -> [ ProcedureDivision() ]
     */
    public R visit(ProgramUnit n);

    /**
     * f0 -> NestedIdentificationDivision()
     * f1 -> [ EnvironmentDivision() ]
     * f2 -> [ DataDivision() ]
     * f3 -> [ ProcedureDivision() ]
     */
    public R visit(NestedProgramUnit n);

    /**
     * f0 -> <END>
     * f1 -> <PROGRAM>
     * f2 -> ProgramName()
     * f3 -> <DOT>
     */
    public R visit(EndProgramStatement n);

    /**
     * f0 -> LinkageSectionEntry()
     * f1 -> <EOF>
     */
    public R visit(CopyBookUnit n);

    /**
     * f0 -> ( <IDENTIFICATION> | <ID> )
     * f1 -> <DIVISION>
     * f2 -> <DOT>
     * f3 -> ProgramIdParagraph()
     * f4 -> ( IdentificationDivisionParagraph() )*
     */
    public R visit(IdentificationDivision n);

    /**
     * f0 -> ( <IDENTIFICATION> | <ID> )
     * f1 -> <DIVISION>
     * f2 -> <DOT>
     * f3 -> NestedProgramIdParagraph()
     * f4 -> ( IdentificationDivisionParagraph() )*
     */
    public R visit(NestedIdentificationDivision n);

    /**
     * f0 -> InstallationParagraph()
     *       | SecurityParagraph()
     */
    public R visit(IdentificationDivisionParagraph n);

    /**
     * f0 -> <PROGRAM_ID>
     * f1 -> <DOT>
     * f2 -> ProgramName()
     * f3 -> [ [ <IS> ] <INITIAL> [ <PROGRAM> ] ]
     * f4 -> <DOT>
     */
    public R visit(ProgramIdParagraph n);

    /**
     * f0 -> <PROGRAM_ID>
     * f1 -> <DOT>
     * f2 -> ProgramName()
     * f3 -> [ [ <IS> ] InitialOrCommon() [ <PROGRAM> ] ]
     * f4 -> <DOT>
     */
    public R visit(NestedProgramIdParagraph n);

    /**
     * f0 -> ( <INITIAL> [ <COMMON> ] | <COMMON> [ <INITIAL> ] )
     */
    public R visit(InitialOrCommon n);

    /**
     * f0 -> <INSTALLATION>
     * f1 -> <DOT>
     * f2 -> [ CommentLine() ]
     */
    public R visit(InstallationParagraph n);

    /**
     * f0 -> <SECURITY>
     * f1 -> <DOT>
     * f2 -> [ CommentLine() ]
     */
    public R visit(SecurityParagraph n);

    /**
     * f0 -> <ENVIRONMENT>
     * f1 -> <DIVISION>
     * f2 -> <DOT>
     * f3 -> ( EnvironmentSection() )*
     */
    public R visit(EnvironmentDivision n);

    /**
     * f0 -> ConfigurationSection()
     *       | InputOutputSection()
     */
    public R visit(EnvironmentSection n);

    /**
     * f0 -> <CONFIGURATION>
     * f1 -> <SECTION>
     * f2 -> <DOT>
     * f3 -> ( ConfigurationSectionParagraph() )*
     */
    public R visit(ConfigurationSection n);

    /**
     * f0 -> SourceComputerParagraph()
     *       | ObjectComputerParagraph()
     *       | SpecialNamesParagraph()
     */
    public R visit(ConfigurationSectionParagraph n);

    /**
     * f0 -> <SOURCE_COMPUTER>
     * f1 -> <DOT>
     * f2 -> ComputerName()
     * f3 -> [ [ <WITH> ] <DEBUGGING> <MODE> ]
     * f4 -> <DOT>
     */
    public R visit(SourceComputerParagraph n);

    /**
     * f0 -> <OBJECT_COMPUTER>
     * f1 -> <DOT>
     * f2 -> ComputerName()
     * f3 -> ( ObjectComputerClause() )*
     * f4 -> <DOT>
     */
    public R visit(ObjectComputerParagraph n);

    /**
     * f0 -> MemorySizeClause()
     *       | CollatingSequenceClause()
     *       | SegmentLimitClause()
     *       | CharacterSetClause()
     */
    public R visit(ObjectComputerClause n);

    /**
     * f0 -> <MEMORY>
     * f1 -> [ <SIZE> ]
     * f2 -> IntegerConstant()
     * f3 -> [ <WORDS> | <CHARACTERS> | <MODULES> ]
     */
    public R visit(MemorySizeClause n);

    /**
     * f0 -> [ <PROGRAM> ]
     * f1 -> [ <COLLATING> ]
     * f2 -> <SEQUENCE>
     * f3 -> [ <IS> ]
     * f4 -> AlphabetName()
     */
    public R visit(CollatingSequenceClause n);

    /**
     * f0 -> ( <SEGMENT_LIMIT> | <SEGMENT> <LIMIT> )
     * f1 -> [ <IS> ]
     * f2 -> IntegerConstant()
     */
    public R visit(SegmentLimitClause n);

    /**
     * f0 -> <CHARACTER>
     * f1 -> <SET>
     * f2 -> [ CommentLine() ]
     */
    public R visit(CharacterSetClause n);

    /**
     * f0 -> <SPECIAL_NAMES>
     * f1 -> <DOT>
     * f2 -> [ ( SpecialNameClause() )+ <DOT> ]
     */
    public R visit(SpecialNamesParagraph n);

    /**
     * f0 -> AlphabetClause()
     *       | ClassClause()
     *       | CurrencySignClause()
     *       | DecimalPointClause()
     *       | SymbolicCharactersClause()
     *       | CallConventionClause()
     *       | EnvironmentNameIsMnemonicNameClause()
     */
    public R visit(SpecialNameClause n);

    /**
     * f0 -> ( <THROUGH> | <THRU> ) IterableLiteral()
     *       | ( <ALSO> IterableLiteral() )+
     */
    public R visit(IterableAlphabetPhrase n);

    /**
     * f0 -> <ALPHABET>
     * f1 -> AlphabetName()
     * f2 -> [ <IS> ]
     * f3 -> ( <STANDARD_1> | <STANDARD_2> | <NATIVE> | CobolWord() | ( IterableLiteral() [ IterableAlphabetPhrase() ] )+ )
     */
    public R visit(AlphabetClause n);

    /**
     * f0 -> <CLASS>
     * f1 -> ClassName()
     * f2 -> [ <IS> ]
     * f3 -> ( ( Identifier() | IterableLiteral() ) [ ( <THROUGH> | <THRU> ) ( Identifier() | IterableLiteral() ) ] )+
     */
    public R visit(ClassClause n);

    /**
     * f0 -> <CURRENCY>
     * f1 -> [ <SIGN> ]
     * f2 -> [ <IS> ]
     * f3 -> Literal()
     */
    public R visit(CurrencySignClause n);

    /**
     * f0 -> <DECIMAL_POINT>
     * f1 -> [ <IS> ]
     * f2 -> <COMMA>
     */
    public R visit(DecimalPointClause n);

    /**
     * f0 -> <SYMBOLIC>
     * f1 -> [ <CHARACTERS> ]
     * f2 -> ( ( SymbolicCharacter() )+ [ ( <ARE> | <IS> ) ] ( NumericConstant() | <HEXNUMBER> )+ )+
     * f3 -> [ <IN> AlphabetName() ]
     */
    public R visit(SymbolicCharactersClause n);

    /**
     * f0 -> <CALL_CONVENTION>
     * f1 -> IntegerConstant()
     * f2 -> [ <IS> ]
     * f3 -> ConventionName()
     */
    public R visit(CallConventionClause n);

    /**
     * f0 -> EnvironmentName()
     * f1 -> ( [ <IS> ] MnemonicName() [ SpecialNamesParagraphStatusPhrase() ] | SpecialNamesParagraphStatusPhrase() )
     */
    public R visit(EnvironmentNameIsMnemonicNameClause n);

    /**
     * f0 -> ( <ON> [ <STATUS> ] [ <IS> ] IterableCondition() [ <OFF> [ <STATUS> ] [ <IS> ] IterableCondition() ] | <OFF> [ <STATUS> ] [ <IS> ] IterableCondition() [ <ON> [ <STATUS> ] [ <IS> ] IterableCondition() ] )
     */
    public R visit(SpecialNamesParagraphStatusPhrase n);

    /**
     * f0 -> <INPUT_OUTPUT>
     * f1 -> <SECTION>
     * f2 -> <DOT>
     * f3 -> ( InputOutputSectionParagraph() )*
     */
    public R visit(InputOutputSection n);

    /**
     * f0 -> FileControlParagraph()
     *       | IOControlParagraph()
     */
    public R visit(InputOutputSectionParagraph n);

    /**
     * f0 -> <FILE_CONTROL>
     * f1 -> ( [ <DOT> ] FileControlEntry() )*
     * f2 -> <DOT>
     */
    public R visit(FileControlParagraph n);

    /**
     * f0 -> SelectClause()
     * f1 -> ( FileControlClause() )*
     */
    public R visit(FileControlEntry n);

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
    public R visit(FileControlClause n);

    /**
     * f0 -> <SELECT>
     * f1 -> [ <OPTIONAL> ]
     * f2 -> FileName()
     */
    public R visit(SelectClause n);

    /**
     * f0 -> <ASSIGN>
     * f1 -> [ <TO> ]
     * f2 -> ( AssignmentName() | Literal() )
     * f3 -> [ <USING> ( AssignmentName() | Literal() ) ]
     */
    public R visit(AssignClause n);

    /**
     * f0 -> <RESERVE>
     * f1 -> IntegerConstant()
     * f2 -> [ <AREA> | <AREAS> ]
     */
    public R visit(ReserveClause n);

    /**
     * f0 -> [ <ORGANIZATION> [ <IS> ] ]
     * f1 -> ( SequentialOrganizationClause() | LineSequentialOrganizationClause() | RelativeOrganizationClause() | IndexedOrganizationClause() )
     */
    public R visit(OrganizationClause n);

    /**
     * f0 -> <SEQUENTIAL>
     */
    public R visit(SequentialOrganizationClause n);

    /**
     * f0 -> <LINE>
     * f1 -> <SEQUENTIAL>
     */
    public R visit(LineSequentialOrganizationClause n);

    /**
     * f0 -> <RELATIVE>
     * f1 -> [ Identifier() ]
     */
    public R visit(RelativeOrganizationClause n);

    /**
     * f0 -> <INDEXED>
     */
    public R visit(IndexedOrganizationClause n);

    /**
     * f0 -> <PADDING>
     * f1 -> [ <CHARACTER> ]
     * f2 -> [ <IS> ]
     * f3 -> ( Identifier() | Literal() )
     */
    public R visit(PaddingCharacterClause n);

    /**
     * f0 -> <RECORD>
     * f1 -> <DELIMITER>
     * f2 -> [ <IS> ]
     * f3 -> ( <STANDARD_1> | <IMPLICIT> | AssignmentName() )
     */
    public R visit(RecordDelimiterClause n);

    /**
     * f0 -> <ACCESS>
     * f1 -> [ <MODE> ]
     * f2 -> [ <IS> ]
     * f3 -> ( SequentialAccessMode() | RandomAccessMode() | DynamicAccessMode() )
     */
    public R visit(AccessModeClause n);

    /**
     * f0 -> <SEQUENTIAL>
     * f1 -> [ RelativeKeyClause() ]
     */
    public R visit(SequentialAccessMode n);

    /**
     * f0 -> <RANDOM>
     * f1 -> [ RelativeKeyClause() ]
     */
    public R visit(RandomAccessMode n);

    /**
     * f0 -> <DYNAMIC>
     * f1 -> [ RelativeKeyClause() ]
     */
    public R visit(DynamicAccessMode n);

    /**
     * f0 -> <RELATIVE>
     * f1 -> [ <KEY> ]
     * f2 -> [ <IS> ]
     * f3 -> Identifier()
     */
    public R visit(RelativeKeyClause n);

    /**
     * f0 -> <RECORD>
     * f1 -> [ <KEY> ]
     * f2 -> [ <IS> ]
     * f3 -> Identifier()
     * f4 -> [ PasswordClause() ]
     * f5 -> [ [ <WITH> ] <DUPLICATES> ]
     */
    public R visit(RecordKeyClause n);

    /**
     * f0 -> <ALTERNATE>
     * f1 -> RecordKeyClause()
     */
    public R visit(AlternateRecordKeyClause n);

    /**
     * f0 -> <PASSWORD>
     * f1 -> [ <IS> ]
     * f2 -> DataName()
     */
    public R visit(PasswordClause n);

    /**
     * f0 -> [ <FILE> ]
     * f1 -> <STATUS>
     * f2 -> [ <IS> ]
     * f3 -> Identifier()
     * f4 -> [ Identifier() ]
     */
    public R visit(FileStatusClause n);

    /**
     * f0 -> <I_O_CONTROL>
     * f1 -> ( [ <DOT> ] IOControlClause() )*
     * f2 -> <DOT>
     */
    public R visit(IOControlParagraph n);

    /**
     * f0 -> RerunClause()
     *       | SameAreaClause()
     *       | MultipleFileClause()
     */
    public R visit(IOControlClause n);

    /**
     * f0 -> <RERUN>
     * f1 -> [ <ON> ( AssignmentName() | FileName() ) ]
     * f2 -> <EVERY>
     * f3 -> ( Rerun2() | IntegerConstant() [ <CLOCK_UNITS> ] )
     */
    public R visit(RerunClause n);

    /**
     * f0 -> IntegerConstant() <RECORDS>
     *       | [ <END> ] [ <OF> ] ( <REEL> | <UNIT> ) <OF> FileName()
     */
    public R visit(Rerun2 n);

    /**
     * f0 -> <SAME>
     * f1 -> [ <RECORD> | <SORT> | <SORT_MERGE> ]
     * f2 -> [ <AREA> ]
     * f3 -> [ <FOR> ]
     * f4 -> ( FileName() )+
     */
    public R visit(SameAreaClause n);

    /**
     * f0 -> <MULTIPLE>
     * f1 -> <FILE>
     * f2 -> [ <TAPE> ]
     * f3 -> [ <CONTAINS> ]
     * f4 -> ( FileName() [ [ <POSITION> ] IntegerConstant() ] )+
     */
    public R visit(MultipleFileClause n);

    /**
     * f0 -> <DATA>
     * f1 -> <DIVISION>
     * f2 -> <DOT>
     * f3 -> ( DataDivisionSection() )*
     */
    public R visit(DataDivision n);

    /**
     * f0 -> FileSection()
     *       | WorkingStorageSection()
     *       | LinkageSection()
     *       | CommunicationSection()
     */
    public R visit(DataDivisionSection n);

    /**
     * f0 -> <FILE>
     * f1 -> <SECTION>
     * f2 -> <DOT>
     * f3 -> ( FileAndSortDescriptionEntry() ( DataDescriptionEntry() )* )*
     */
    public R visit(FileSection n);

    /**
     * f0 -> ( <FD> | <SD> )
     * f1 -> FileName()
     * f2 -> ( [ <DOT> ] FileAndSortDescriptionEntryClause() )*
     * f3 -> <DOT>
     */
    public R visit(FileAndSortDescriptionEntry n);

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
    public R visit(FileAndSortDescriptionEntryClause n);

    /**
     * f0 -> [ <IS> ]
     * f1 -> <EXTERNAL>
     */
    public R visit(ExternalClause n);

    /**
     * f0 -> [ <IS> ]
     * f1 -> <GLOBAL>
     */
    public R visit(GlobalClause n);

    /**
     * f0 -> <BLOCK>
     * f1 -> [ <CONTAINS> ]
     * f2 -> IntegerConstant()
     * f3 -> [ <TO> IntegerConstant() ]
     * f4 -> [ <RECORDS> | <CHARACTERS> ]
     */
    public R visit(BlockContainsClause n);

    /**
     * f0 -> <RECORD>
     * f1 -> [ <CONTAINS> ]
     * f2 -> ( IntegerConstant() [ <TO> IntegerConstant() ] [ <CHARACTERS> ] | [ <IS> ] <VARYING> [ <IN> ] [ <SIZE> ] [ [ <FROM> ] IntegerConstant() [ <TO> IntegerConstant() ] [ <CHARACTERS> ] ] [ <DEPENDING> [ <ON> ] Identifier() ] )
     */
    public R visit(RecordContainsClause n);

    /**
     * f0 -> <LABEL>
     * f1 -> ( <RECORD> [ ( <IS> | <ARE> ) ] | <RECORDS> [ ( <IS> | <ARE> ) ] )
     * f2 -> ( <OMITTED> | <STANDARD> | ( DataName() )+ )
     */
    public R visit(LabelRecordsClause n);

    /**
     * f0 -> <VALUE>
     * f1 -> <OF>
     * f2 -> ( SystemName() <IS> ( Identifier() | Literal() ) )+
     */
    public R visit(ValueOfClause n);

    /**
     * f0 -> <DATA>
     * f1 -> ( <RECORD> [ <IS> ] | <RECORDS> [ <ARE> ] )
     * f2 -> ( DataName() )+
     */
    public R visit(DataRecordClause n);

    /**
     * f0 -> <LINAGE>
     * f1 -> [ <IS> ]
     * f2 -> ( DataName() | IntegerConstant() )
     * f3 -> [ <LINES> ]
     * f4 -> ( [ <WITH> ] <FOOTING> [ <AT> ] ( DataName() | IntegerConstant() ) | [ <LINES> ] [ <AT> ] ( <TOP> | <BOTTOM> ) ( DataName() | IntegerConstant() ) )*
     */
    public R visit(LinageClause n);

    /**
     * f0 -> <RECORDING>
     * f1 -> [ <MODE> ]
     * f2 -> [ <IS> ]
     * f3 -> Mode()
     */
    public R visit(RecordingModeClause n);

    /**
     * f0 -> <CODE_SET>
     * f1 -> [ <IS> ]
     * f2 -> AlphabetName()
     */
    public R visit(CodeSetClause n);

    /**
     * f0 -> ( <REPORT> [ <IS> ] | <REPORTS> [ <ARE> ] )
     * f1 -> ( Identifier() )+
     */
    public R visit(ReportClause n);

    /**
     * f0 -> ( <LEVEL_66> LevelName66() RenamesClause() <DOT> | <LEVEL_77> LevelName77() ( DataDescriptionEntryClause() )* <DOT> | <LEVEL_88> LevelName88() ConditionValueClause() <DOT> | LevelNumber() LevelName() ( DataDescriptionEntryClause() )* <DOT> | ExecStatement() <DOT> )
     */
    public R visit(DataDescriptionEntry n);

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
    public R visit(DataDescriptionEntryClause n);

    /**
     * f0 -> <REDEFINES>
     * f1 -> DataName()
     * f2 -> [ DataPictureClause() ]
     */
    public R visit(DataRedefinesClause n);

    /**
     * f0 -> <BLANK>
     * f1 -> [ <WHEN> ]
     * f2 -> ( <ZERO> | <ZEROS> | <ZEROES> )
     */
    public R visit(DataBlankWhenZeroClause n);

    /**
     * f0 -> ( <JUSTIFIED> | <JUST> )
     * f1 -> [ <RIGHT> ]
     */
    public R visit(DataJustifiedClause n);

    /**
     * f0 -> <OCCURS>
     * f1 -> IntegerConstant()
     * f2 -> [ <TO> IntegerConstant() ]
     * f3 -> [ <TIMES> ]
     * f4 -> [ <DEPENDING> [ <ON> ] Identifier() ]
     * f5 -> ( ( <ASCENDING> | <DESCENDING> ) [ <KEY> ] [ <IS> ] ( Identifier() )+ )*
     * f6 -> [ <INDEXED> [ <BY> ] IndexName() ( [ <COMMACHAR> ] IndexName() )* ]
     */
    public R visit(DataOccursClause n);

    /**
     * f0 -> ( <PICTURE> | <PIC> )
     * f1 -> [ <IS> ]
     * f2 -> <PICTURE_STRING>
     */
    public R visit(DataPictureClause n);

    /**
     * f0 -> <DOLLARCHAR>
     */
    public R visit(PictureCurrency n);

    /**
     * f0 -> IntegerConstant()
     *       | CobolWord()
     *       | PictureCurrency()
     */
    public R visit(NonDotChars n);

    /**
     * f0 -> [ <IS> ]
     * f1 -> <EXTERNAL>
     * f2 -> [ <BY> Literal() ]
     */
    public R visit(DataExternalClause n);

    /**
     * f0 -> [ <IS> ]
     * f1 -> <GLOBAL>
     */
    public R visit(DataGlobalClause n);

    /**
     * f0 -> [ <IS> ]
     * f1 -> <IDENTIFIED>
     * f2 -> <BY>
     * f3 -> Literal()
     */
    public R visit(DataIdentifiedClause n);

    /**
     * f0 -> [ <USAGE> [ <IS> ] ]
     * f1 -> ( MemoryUsage() | ExternalUsage() | PropertyObjectModifier() )
     */
    public R visit(DataUsageClause n);

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
    public R visit(MemoryUsage n);

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
    public R visit(ExternalUsage n);

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
    public R visit(PropertyObjectModifier n);

    /**
     * f0 -> [ <SIGN> [ <IS> ] ]
     * f1 -> ( <LEADING> | <TRAILING> )
     * f2 -> [ <SEPARATE> [ <CHARACTER> ] ]
     */
    public R visit(DataSignClause n);

    /**
     * f0 -> ( <SYNCHRONIZED> | <SYNC> )
     * f1 -> [ ( <LEFT> | <RIGHT> ) ]
     */
    public R visit(DataSynchronizedClause n);

    /**
     * f0 -> ( <VALUE> [ <IS> ] | <VALUES> [ <ARE> ] )
     * f1 -> Through()
     * f2 -> ( [ <COMMACHAR> ] Through() )*
     */
    public R visit(DataValueClause n);

    /**
     * f0 -> IterableLiteral()
     * f1 -> [ ( <THROUGH> | <THRU> ) IterableLiteral() ]
     */
    public R visit(Through n);

    /**
     * f0 -> DataValueClause()
     */
    public R visit(ConditionValueClause n);

    /**
     * f0 -> <RENAMES>
     * f1 -> Identifier()
     * f2 -> [ ( <THROUGH> | <THRU> ) Identifier() ]
     */
    public R visit(RenamesClause n);

    /**
     * f0 -> ( CommunicationInputEntry() | CommunicationOutputEntry() | CommunicationIOEntry() )
     * f1 -> <DOT>
     */
    public R visit(CommunicationDescriptionEntry n);

    /**
     * f0 -> <CD>
     * f1 -> CdName()
     * f2 -> [ <FOR> ]
     * f3 -> [ <INITIAL> ]
     * f4 -> <INPUT>
     * f5 -> ( CommunicationInputClause() )*
     * f6 -> ( DataName() )*
     */
    public R visit(CommunicationInputEntry n);

    /**
     * f0 -> <CD>
     * f1 -> CdName()
     * f2 -> [ <FOR> ]
     * f3 -> <OUTPUT>
     * f4 -> ( CommunicationOutputClause() )*
     */
    public R visit(CommunicationOutputEntry n);

    /**
     * f0 -> <CD>
     * f1 -> CdName()
     * f2 -> [ <FOR> ]
     * f3 -> [ <INITIAL> ]
     * f4 -> <I_O>
     * f5 -> ( CommunicationIOClause() )*
     * f6 -> ( DataName() )*
     */
    public R visit(CommunicationIOEntry n);

    /**
     * f0 -> <MESSAGE> ( <DATE> | <TIME> | <COUNT> ) [ <IS> ] DataName()
     *       | <TEXT> <LENGTH> [ <IS> ] DataName()
     *       | <END> <KEY> [ <IS> ] DataName()
     *       | <STATUS> <KEY> [ <IS> ] DataName()
     *       | <COUNT> [ <IS> ] DataName()
     *       | [ <SYMBOLIC> ] ( <QUEUE> | <SUB_QUEUE_1> | <SUB_QUEUE_2> | <SUB_QUEUE_3> | <SOURCE> ) [ <IS> ] DataName()
     */
    public R visit(CommunicationInputClause n);

    /**
     * f0 -> <DESTINATION> <COUNT> [ <IS> ] DataName()
     *       | <TEXT> <LENGTH> [ <IS> ] DataName()
     *       | <STATUS> <KEY> [ <IS> ] DataName()
     *       | [ <SYMBOLIC> ] <DESTINATION> [ <IS> ] DataName()
     *       | <DESTINATION> <TABLE> <OCCURS> IntegerConstant() [ <TIMES> ] [ <INDEXED> [ <BY> ] ( IndexName() )+ ]
     *       | <ERROR> <KEY> [ <IS> ] DataName()
     */
    public R visit(CommunicationOutputClause n);

    /**
     * f0 -> <MESSAGE> ( <DATE> | <TIME> ) [ <IS> ] DataName()
     *       | <TEXT> <LENGTH> [ <IS> ] DataName()
     *       | <END> <KEY> [ <IS> ] DataName()
     *       | <STATUS> <KEY> [ <IS> ] DataName()
     *       | [ <SYMBOLIC> ] <TERMINAL> [ <IS> ] DataName()
     */
    public R visit(CommunicationIOClause n);

    /**
     * f0 -> <WORKING_STORAGE>
     * f1 -> <SECTION>
     * f2 -> <DOT>
     * f3 -> ( DataDescriptionEntry() )*
     */
    public R visit(WorkingStorageSection n);

    /**
     * f0 -> ( DataDescriptionEntry() )*
     */
    public R visit(LinkageSectionEntry n);

    /**
     * f0 -> <LINKAGE>
     * f1 -> <SECTION>
     * f2 -> <DOT>
     * f3 -> LinkageSectionEntry()
     */
    public R visit(LinkageSection n);

    /**
     * f0 -> <COMMUNICATION>
     * f1 -> <SECTION>
     * f2 -> <DOT>
     * f3 -> ( CommunicationDescriptionEntry() ( DataDescriptionEntry() )* )*
     */
    public R visit(CommunicationSection n);

    /**
     * f0 -> <PROCEDURE>
     * f1 -> <DIVISION>
     * f2 -> [ ConventionName() ]
     * f3 -> [ <USING> ( DataName() )+ ]
     * f4 -> <DOT>
     * f5 -> [ Declaratives() ]
     * f6 -> ProcedureBody()
     */
    public R visit(ProcedureDivision n);

    /**
     * f0 -> <DECLARATIVES>
     * f1 -> <DOT>
     * f2 -> ( SectionHeader() <DOT> UseStatement() <DOT> Paragraphs() )+
     * f3 -> <END>
     * f4 -> <DECLARATIVES>
     * f5 -> <DOT>
     */
    public R visit(Declaratives n);

    /**
     * f0 -> Paragraphs()
     * f1 -> ( ProcedureSection() )*
     */
    public R visit(ProcedureBody n);

    /**
     * f0 -> SectionHeader()
     * f1 -> <DOT>
     * f2 -> Paragraphs()
     */
    public R visit(ProcedureSection n);

    /**
     * f0 -> SectionName()
     * f1 -> <SECTION>
     * f2 -> [ IntegerConstant() ]
     */
    public R visit(SectionHeader n);

    /**
     * f0 -> ( Sentence() )*
     * f1 -> ( Paragraph() )*
     */
    public R visit(Paragraphs n);

    /**
     * f0 -> ParagraphName()
     * f1 -> <DOT>
     * f2 -> ( ExitStatement() | AlteredGoto() | Sentence() )*
     */
    public R visit(Paragraph n);

    /**
     * f0 -> StatementList()
     * f1 -> <DOT>
     */
    public R visit(Sentence n);

    /**
     * f0 -> ( Statement() )+
     */
    public R visit(StatementList n);

    /**
     * f0 -> ( AcceptStatement() | AddStatement() | AlterStatement() | CallStatement() | CancelStatement() | CloseStatement() | ComputeStatement() | ContinueStatement() | DeleteStatement() | DisplayStatement() | DivideStatement() | EntryStatement() | EvaluateStatement() | ExecStatement() | ExitProgramStatement() | GobackStatement() | GotoStatement() | IfStatement() | InitializeStatement() | InspectStatement() | MergeStatement() | MoveStatement() | MultiplyStatement() | OpenStatement() | PerformStatement() | ReadStatement() | ReleaseStatement() | ReturnStatement() | RewriteStatement() | SearchStatement() | SetStatement() | SortStatement() | StartStatement() | StopStatement() | StringStatement() | SubtractStatement() | UnstringStatement() | WriteStatement() | ServiceStatement() )
     */
    public R visit(Statement n);

    /**
     * f0 -> <ACCEPT>
     * f1 -> ( <REPLY> | <OMITTED> | Identifier() )
     * f2 -> [ <FROM> ( MnemonicName() | EnvironmentName() | <DATE> [ <YYYYMMDD> ] | <DAY> [ <YYYYDDD> ] | <DAY_OF_WEEK> | <TIME> ) ]
     */
    public R visit(AcceptStatement n);

    /**
     * f0 -> <ADD>
     * f1 -> ( ( <CORRESPONDING> | <CORR> ) Identifier() <TO> Identifier() [ <ROUNDED> ] | ( Identifier() | Literal() ) ( [ <COMMACHAR> ] ( Identifier() | Literal() ) )* [ <TO> ( Identifier() [ <ROUNDED> ] )+ ] [ <GIVING> ( Identifier() [ <ROUNDED> ] )+ ] )
     * f2 -> [ [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f3 -> [ <NOT> [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f4 -> [ <END_ADD> ]
     */
    public R visit(AddStatement n);

    /**
     * f0 -> <GO>
     * f1 -> [ <TO> ]
     * f2 -> <DOT>
     */
    public R visit(AlteredGoto n);

    /**
     * f0 -> <ALTER>
     * f1 -> ( ProcedureName() <TO> [ <PROCEED> <TO> ] ProcedureName() )+
     */
    public R visit(AlterStatement n);

    /**
     * f0 -> [ <BY> ]
     * f1 -> <CONTENT>
     * f2 -> ( <ADDRESS> <OF> Identifier() | [ <LENGTH> <OF> ] Identifier() | Literal() | <OMITTED> )
     * f3 -> ( [ <COMMACHAR> ] ( <ADDRESS> <OF> Identifier() | [ <LENGTH> <OF> ] Identifier() | Literal() | <OMITTED> ) )*
     */
    public R visit(CallByContent n);

    /**
     * f0 -> [ [ <BY> ] <REFERENCE> ]
     * f1 -> ( <ADDRESS> <OF> Identifier() | Identifier() | FileName() | <OMITTED> )
     * f2 -> ( [ <COMMACHAR> ] ( <ADDRESS> <OF> Identifier() | Identifier() | FileName() | <OMITTED> ) )*
     */
    public R visit(CallByReference n);

    /**
     * f0 -> [ <BY> ]
     * f1 -> <DESCRIPTOR>
     * f2 -> ( <ADDRESS> <OF> Identifier() | Identifier() | FileName() | <OMITTED> )+
     */
    public R visit(CallByDescriptor n);

    /**
     * f0 -> [ <BY> ]
     * f1 -> <VALUE>
     * f2 -> ( <ADDRESS> <OF> Identifier() | [ <LENGTH> <OF> ] Identifier() | Literal() | <OMITTED> )+
     */
    public R visit(CallByValue n);

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
    public R visit(CallStatement n);

    /**
     * f0 -> <CANCEL>
     * f1 -> ( Identifier() | Literal() )+
     */
    public R visit(CancelStatement n);

    /**
     * f0 -> <CLOSE>
     * f1 -> ( FileName() [ ( ( <REEL> | <UNIT> ) [ ( [ <FOR> ] <REMOVAL> | [ <WITH> ] <NO> <REWIND> ) ] | [ <WITH> ] ( <NO> <REWIND> | <LOCK> ) ) ] )+
     */
    public R visit(CloseStatement n);

    /**
     * f0 -> <COMPUTE>
     * f1 -> ( Identifier() [ <ROUNDED> ] )+
     * f2 -> ( <EQUALCHAR> | <EQUAL> )
     * f3 -> ArithmeticExpression()
     * f4 -> [ [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f5 -> [ <NOT> [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f6 -> [ <END_COMPUTE> ]
     */
    public R visit(ComputeStatement n);

    /**
     * f0 -> <CONTINUE>
     */
    public R visit(ContinueStatement n);

    /**
     * f0 -> <DELETE>
     * f1 -> FileName()
     * f2 -> [ <RECORD> ]
     * f3 -> [ <INVALID> [ <KEY> ] StatementList() ]
     * f4 -> [ <NOT> <INVALID> [ <KEY> ] StatementList() ]
     * f5 -> [ <END_DELETE> ]
     */
    public R visit(DeleteStatement n);

    /**
     * f0 -> <DISPLAY>
     * f1 -> ( Identifier() | Literal() )
     * f2 -> ( [ <COMMACHAR> ] ( Identifier() | Literal() ) )*
     * f3 -> [ <UPON> ( MnemonicName() | EnvironmentName() ) ]
     * f4 -> [ [ <WITH> ] <NO> <ADVANCING> ]
     */
    public R visit(DisplayStatement n);

    /**
     * f0 -> <DIVIDE>
     * f1 -> ( Identifier() | Literal() )
     * f2 -> ( <INTO> ( Identifier() | Literal() ) [ <ROUNDED> ] ( <GIVING> ( Identifier() [ <ROUNDED> ] )+ | ( ( Identifier() | Literal() ) [ <ROUNDED> ] )* ) | <BY> ( Identifier() | Literal() ) [ <GIVING> ( Identifier() [ <ROUNDED> ] )+ ] )
     * f3 -> [ <REMAINDER> Identifier() ]
     * f4 -> [ [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f5 -> [ <NOT> [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f6 -> [ <END_DIVIDE> ]
     */
    public R visit(DivideStatement n);

    /**
     * f0 -> <ENTRY>
     * f1 -> Literal()
     * f2 -> [ <USING> ( Identifier() )+ ]
     */
    public R visit(EntryStatement n);

    /**
     * f0 -> <EVALUATE>
     * f1 -> EvaluateValue()
     * f2 -> ( <ALSO> EvaluateValue() )*
     * f3 -> ( ( EvaluateWhenClause() )+ [ <THEN> ] StatementList() )+
     * f4 -> [ <END_EVALUATE> ]
     */
    public R visit(EvaluateStatement n);

    /**
     * f0 -> ( Condition() | <TRUE> | <FALSE> )
     */
    public R visit(EvaluateValue n);

    /**
     * f0 -> ( <WHEN> <OTHER> | <WHEN> EvaluatePhrase() ( <ALSO> EvaluatePhrase() )* )
     */
    public R visit(EvaluateWhenClause n);

    /**
     * f0 -> [ <NOT> ]
     * f1 -> ArithmeticExpression()
     * f2 -> ( <THROUGH> | <THRU> )
     * f3 -> ArithmeticExpression()
     */
    public R visit(EvaluateThruPhrase n);

    /**
     * f0 -> ( EvaluateThruPhrase() | Condition() | <ANY> | <TRUE> | <FALSE> )
     */
    public R visit(EvaluatePhrase n);

    /**
     * f0 -> <EXEC>
     */
    public R visit(ExecStatement n);

    /**
     * f0 -> <EXIT>
     * f1 -> <DOT>
     */
    public R visit(ExitStatement n);

    /**
     * f0 -> <EXIT>
     * f1 -> <PROGRAM>
     */
    public R visit(ExitProgramStatement n);

    /**
     * f0 -> <GOBACK>
     */
    public R visit(GobackStatement n);

    /**
     * f0 -> <GO>
     * f1 -> [ <TO> ]
     * f2 -> ( ( ProcedureName() )+ [ <DEPENDING> [ <ON> ] Identifier() ] | <MORE_LABELS> )
     */
    public R visit(GotoStatement n);

    /**
     * f0 -> <IF>
     * f1 -> Condition()
     * f2 -> [ <THEN> ]
     * f3 -> ( StatementList() | <NEXT> <SENTENCE> )
     * f4 -> [ <ELSE> ( StatementList() | <NEXT> <SENTENCE> ) ]
     * f5 -> [ <END_IF> ]
     */
    public R visit(IfStatement n);

    /**
     * f0 -> <INITIALIZE>
     * f1 -> ( Identifier() )+
     * f2 -> [ <REPLACING> ( ( <ALPHABETIC> | <ALPHANUMERIC> | <NUMERIC> | <ALPHANUMERIC_EDITED> | <NUMERIC_EDITED> | <DBCS> | <EGCS> ) [ <DATA> ] <BY> ( Identifier() | Literal() ) )+ ]
     */
    public R visit(InitializeStatement n);

    /**
     * f0 -> <INSPECT>
     * f1 -> Identifier()
     * f2 -> ( TallyingPhrase() | ConvertingPhrase() | ReplacingPhrase() )
     */
    public R visit(InspectStatement n);

    /**
     * f0 -> <CHARACTERS>
     * f1 -> ( IterableBeforeAfterPhrase() )*
     */
    public R visit(IterableTallyingClause n);

    /**
     * f0 -> ( <ALL> | <LEADING> )
     * f1 -> IterableBeforeAfterClause()
     * f2 -> ( ( Identifier() <FOR> ( RecursiveTallyingClause() | IterableTallyingClause() )+ )+ | IterableBeforeAfterClause() )*
     */
    public R visit(RecursiveTallyingClause n);

    /**
     * f0 -> <TALLYING>
     * f1 -> ( Identifier() <FOR> ( RecursiveTallyingClause() | IterableTallyingClause() )+ )+
     * f2 -> [ ReplacingPhrase() ]
     */
    public R visit(TallyingPhrase n);

    /**
     * f0 -> <CONVERTING>
     * f1 -> ( Identifier() | Literal() )
     * f2 -> <TO>
     * f3 -> IterableBeforeAfterClause()
     */
    public R visit(ConvertingPhrase n);

    /**
     * f0 -> <REPLACING>
     * f1 -> ( <CHARACTERS> <BY> IterableBeforeAfterClause() | ( <ALL> | <LEADING> | <FIRST> ) ( ( Identifier() | Literal() ) <BY> IterableBeforeAfterClause() )+ )+
     */
    public R visit(ReplacingPhrase n);

    /**
     * f0 -> ( Identifier() | IterableLiteral() )
     * f1 -> ( IterableBeforeAfterPhrase() )*
     */
    public R visit(IterableBeforeAfterClause n);

    /**
     * f0 -> ( <BEFORE> | <AFTER> )
     * f1 -> [ <INITIAL> ]
     * f2 -> ( Identifier() | IterableLiteral() )
     */
    public R visit(IterableBeforeAfterPhrase n);

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
    public R visit(MergeStatement n);

    /**
     * f0 -> <MOVE>
     * f1 -> ( ArithmeticExpression() <TO> Identifier() ( [ <COMMACHAR> ] Identifier() )* | ( <CORRESPONDING> | <CORR> ) Identifier() <TO> ( Identifier() )+ )
     */
    public R visit(MoveStatement n);

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
    public R visit(MultiplyStatement n);

    /**
     * f0 -> <OPEN>
     * f1 -> ( <INPUT> ( FileName() [ ( <REVERSED> | [ <WITH> ] <NO> <REWIND> ) ] )+ | <OUTPUT> ( FileName() [ [ <WITH> ] <NO> <REWIND> ] )+ | <I_O> ( FileName() )+ | <EXTEND> ( FileName() )+ )+
     */
    public R visit(OpenStatement n);

    /**
     * f0 -> <PERFORM>
     * f1 -> ( PerformFlavour() StatementList() <END_PERFORM> | PerformProcedureScopeClause() PerformFlavour() | StatementList() <END_PERFORM> | PerformProcedureScopeClause() )
     */
    public R visit(PerformStatement n);

    /**
     * f0 -> PerformTimeClause()
     *       | [ PerformTestPositionClause() ] ( PerformUntilClause() | PerformVaryingWithAfterClause() )
     */
    public R visit(PerformFlavour n);

    /**
     * f0 -> <VARYING>
     * f1 -> PerformVaryingPhrase()
     * f2 -> ( <AFTER> PerformVaryingPhrase() )*
     */
    public R visit(PerformVaryingWithAfterClause n);

    /**
     * f0 -> Identifier()
     * f1 -> <FROM>
     * f2 -> ( Identifier() | Literal() )
     * f3 -> <BY>
     * f4 -> ( Identifier() | Literal() )
     * f5 -> PerformUntilClause()
     */
    public R visit(PerformVaryingPhrase n);

    /**
     * f0 -> <UNTIL>
     * f1 -> Condition()
     */
    public R visit(PerformUntilClause n);

    /**
     * f0 -> [ <WITH> ]
     * f1 -> <TEST>
     * f2 -> ( <BEFORE> | <AFTER> )
     */
    public R visit(PerformTestPositionClause n);

    /**
     * f0 -> ProcedureName()
     * f1 -> [ ( <THROUGH> | <THRU> ) ProcedureName() ]
     */
    public R visit(PerformProcedureScopeClause n);

    /**
     * f0 -> ( Identifier() | IntegerConstant() )
     * f1 -> <TIMES>
     */
    public R visit(PerformTimeClause n);

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
    public R visit(ReadStatement n);

    /**
     * f0 -> <RELEASE>
     * f1 -> RecordName()
     * f2 -> [ <FROM> Identifier() ]
     */
    public R visit(ReleaseStatement n);

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
    public R visit(ReturnStatement n);

    /**
     * f0 -> <REWRITE>
     * f1 -> RecordName()
     * f2 -> [ <FROM> Identifier() ]
     * f3 -> [ <INVALID> [ <KEY> ] StatementList() ]
     * f4 -> [ <NOT> <INVALID> [ <KEY> ] StatementList() ]
     * f5 -> [ <END_REWRITE> ]
     */
    public R visit(RewriteStatement n);

    /**
     * f0 -> <SEARCH>
     * f1 -> [ <ALL> ]
     * f2 -> Identifier()
     * f3 -> [ <VARYING> Identifier() ]
     * f4 -> [ [ <AT> ] <END> StatementList() ]
     * f5 -> ( <WHEN> Condition() ( StatementList() | <NEXT> <SENTENCE> ) )+
     * f6 -> [ <END_SEARCH> ]
     */
    public R visit(SearchStatement n);

    /**
     * f0 -> <SET>
     * f1 -> [ <CONFIGURATION> ]
     * f2 -> ( Identifier() | Literal() )
     * f3 -> ( [ <COMMACHAR> ] Identifier() | Literal() )*
     * f4 -> ( <TO> [ <CONFIGURATION> ] ( Identifier() | <TRUE> | <FALSE> | <ON> | <OFF> | [ <ENTRY> ] Literal() ) | ( <UP> | <DOWN> ) [ <BY> ] ( Identifier() | Literal() ) )
     */
    public R visit(SetStatement n);

    /**
     * f0 -> <SORT>
     * f1 -> FileName()
     * f2 -> ( [ <ON> ] ( <ASCENDING> | <DESCENDING> ) [ <KEY> ] ( Identifier() )+ )+
     * f3 -> [ [ <WITH> ] <DUPLICATES> [ <IN> ] [ <ORDER> ] ]
     * f4 -> [ [ <COLLATING> ] <SEQUENCE> [ <IS> ] AlphabetName() ]
     * f5 -> ( <USING> ( FileName() )+ | <INPUT> <PROCEDURE> [ <IS> ] ProcedureName() [ ( <THROUGH> | <THRU> ) ProcedureName() ] )
     * f6 -> ( <GIVING> ( FileName() )+ | <OUTPUT> <PROCEDURE> [ <IS> ] ProcedureName() [ ( <THROUGH> | <THRU> ) ProcedureName() ] )
     */
    public R visit(SortStatement n);

    /**
     * f0 -> <START>
     * f1 -> FileName()
     * f2 -> [ <KEY> RelationalOperator() Identifier() ]
     * f3 -> [ <INVALID> [ <KEY> ] StatementList() ]
     * f4 -> [ <NOT> <INVALID> [ <KEY> ] StatementList() ]
     * f5 -> [ <END_START> ]
     */
    public R visit(StartStatement n);

    /**
     * f0 -> <STOP>
     * f1 -> ( <RUN> | Literal() )
     */
    public R visit(StopStatement n);

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
    public R visit(StringStatement n);

    /**
     * f0 -> <SUBTRACT>
     * f1 -> ( ( Identifier() | Literal() )+ <FROM> ( ( Identifier() | Literal() ) [ <ROUNDED> ] )+ [ <GIVING> ( Identifier() [ <ROUNDED> ] )+ ] | ( <CORRESPONDING> | <CORR> ) Identifier() <FROM> Identifier() [ <ROUNDED> ] )
     * f2 -> [ [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f3 -> [ <NOT> [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f4 -> [ <END_SUBTRACT> ]
     */
    public R visit(SubtractStatement n);

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
    public R visit(UnstringStatement n);

    /**
     * f0 -> <USE>
     * f1 -> ( [ <FOR> ] <DEBUGGING> [ <ON> ] ( ( ProcedureName() )+ | <ALL> ( <PROCEDURES> | <REFERENCES> <OF> DataName() ) ) | [ <GLOBAL> ] <AFTER> [ <STANDARD> ] ( ( <EXCEPTION> | <ERROR> ) | [ ( <BEGINNING> | <ENDING> ) ] [ ( <FILE> | <REEL> | <UNIT> ) ] <LABEL> ) <PROCEDURE> [ <ON> ] ( ( FileName() )+ | <INPUT> | <OUTPUT> | <I_O> | <EXTEND> ) )
     */
    public R visit(UseStatement n);

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
    public R visit(WriteStatement n);

    /**
     * f0 -> <SERVICE>
     * f1 -> <LABEL>
     */
    public R visit(ServiceStatement n);

    /**
     * f0 -> ( <BEFORE> | <AFTER> )
     * f1 -> [ <ADVANCING> ]
     * f2 -> ( <PAGE> | ( IntegerConstant() | Identifier() | Literal() ) [ ( <LINE> | <LINES> ) ] | MnemonicName() )
     */
    public R visit(AdvancingPhrase n);

    /**
     * f0 -> ( DataDescriptionEntry() )*
     * f1 -> <EOF>
     */
    public R visit(DataDescription n);

    /**
     * f0 -> ( Sentence() )*
     * f1 -> <EOF>
     */
    public R visit(SentenceList n);

}

