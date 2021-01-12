/*
 *   Copyright (c) 2020 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.perseus.cobolparser.visitor;


import java.io.*;

import java.text.*;

import java.util.*;

import cl.bee.perseus.cobolparser.*;

import cl.bee.perseus.cobolparser.syntaxtree.*;

import cl.bee.perseus.cobolparser.util.*;

import cl.bee.perseus.util.*;

import com.rits.cloning.*;

import org.apache.log4j.*;


/**
 *
 * TODO_javadoc.
 *
 * @version 1.0 (01/01/2020).
 *
 */
public class ConvertVisitor extends BaseVisitor implements GJVisitor<TypedCode, HashMap<String, Object>> {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(ConvertVisitor.class);

    //

    /** TODO_javadoc. */
    private ArrayList<String> sections = null;

    /** TODO_javadoc. */
    private ArrayList<String> paragraphs = null;

    /** TODO_javadoc. */
    private HashMap<String, String> nextParagraph = null;

    /** TODO_javadoc. */
    private String package_name = null;

    //

    /** TODO_javadoc. */
    private PrintStream gen = null;

    /** TODO_javadoc. */
    private int indent = 0;

    /** TODO_javadoc. */
    private boolean at_end_defined = false;

    //

    /** TODO_javadoc. */
    private Cloner cloner = new Cloner();

    /******************************************************************************
     * ConvertVisitor
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param filename TODO_javadoc.
     * @param entryArray TODO_javadoc.
     * @param varspaths TODO_javadoc.
     * @param usedBases TODO_javadoc.
     * @param sections TODO_javadoc.
     * @param paragraphs TODO_javadoc.
     * @param nextParagraph TODO_javadoc.
     * @param package_name TODO_javadoc.
     * @param jsonparams TODO_javadoc.
     *
     */
    public ConvertVisitor(String filename, ArrayList<DataEntryDesc> entryArray, ArrayList<String> varspaths, ArrayList<DataEntryDesc> usedBases, ArrayList<String> sections, ArrayList<String> paragraphs, HashMap<String, String> nextParagraph, String package_name, String jsonparams) {

        this.filename      = filename;
        this.entryArray    = entryArray;
        this.varspaths     = varspaths;
        this.usedBases     = usedBases;
        this.sections      = sections;
        this.paragraphs    = paragraphs;
        this.nextParagraph = nextParagraph;
        this.package_name  = package_name;
        this.jsonparams    = jsonparams;

        setJsonParams(jsonparams);

        indent = params.path("indent").asInt(0);
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <COBOL_WORD>
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(CobolWord n, HashMap<String, Object> argu) {
        return new TypedCode(TypedCode.UNDEF, n.f0.tokenImage, TypedCode.SIMPLE);
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( IterableQuotedText() )+
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(QuotedText n, HashMap<String, Object> argu) {

        StringBuffer sb = new StringBuffer();

        sb.append("\"");

        String s = null;

        for (int i = 0; i < n.f0.size(); i++) {

            s = ((IterableQuotedText) n.f0.elementAt(i)).accept(this, argu).code;

            sb.append(s.substring(1, s.length() - 1));
        }

        sb.append("\"");

        return new TypedCode(TypedCode.STRING, sb.toString(), TypedCode.SIMPLE);
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 ->   <QUOTEDSTRING>
     *       | <DOUBLEDQUOTECHAR>
     *       | <DOUBLEDAPOSTROPHE>
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(IterableQuotedText n, HashMap<String, Object> argu) {

        switch (n.f0.which) {

        case 0 : // <QUOTEDSTRING>

            return new TypedCode(TypedCode.STRING, "\"" + getIterableQuotedText(((NodeToken) n.f0.choice).tokenImage) + "\"", TypedCode.SIMPLE);

        case 1 : // <DOUBLEDQUOTECHAR>

            return new TypedCode(TypedCode.STRING, "'", TypedCode.SIMPLE);

        case 2 : // <DOUBLEDAPOSTROPHE>

            return new TypedCode(TypedCode.STRING, "\\\"", TypedCode.SIMPLE);
        }

        return null;
    }

    /******************************************************************************
     *
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
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(IntegerConstant n, HashMap<String, Object> argu) {

        String str  = trimLeftZeroes(((NodeToken) n.f0.choice).tokenImage);
        int    type = Long.parseLong(str) > Integer.MAX_VALUE ? TypedCode.LONG : TypedCode.INTEGER;

        return new TypedCode(type, str + (type == TypedCode.LONG ? "L": ""), TypedCode.SIMPLE);
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> [ <PLUSCHAR> | <MINUSCHAR> ]
     * f1 -> ( IntegerConstant() | <REAL> )
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(NumericConstant n, HashMap<String, Object> argu) {

        String sign = n.f0.present() ? ((NodeToken) ((NodeChoice) n.f0.node).choice).tokenImage : "";

        switch (n.f1.which) {

        case 0 : // IntegerConstant()

            TypedCode ic = n.f1.choice.accept(this, argu);

            return new TypedCode(ic.type, sign + ic.code, TypedCode.SIMPLE);

        case 1 : // <REAL>

            return new TypedCode(TypedCode.DOUBLE, sign + trimLeftZeroes(((NodeToken) n.f1.choice).tokenImage.replace(',', '.')) + "D", TypedCode.SIMPLE);
        }

        return null;
    }

    /******************************************************************************
     *
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
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(FigurativeConstant n, HashMap<String, Object> argu) {

        switch (n.f0.which) {

        case  0 : // <ZERO>
        case  1 : // <ZEROS>
        case  2 : // <ZEROES>

            return new TypedCode(TypedCode.INTEGER, "0", TypedCode.SIMPLE);

        case  9 : // <QUOTE>
        case 10 : // <QUOTES>

            return new TypedCode(TypedCode.STRING, "\"", TypedCode.SIMPLE);

        case  3 : // <SPACE>
        case  4 : // <SPACES>

            return new TypedCode(TypedCode.STRING, "Util.spaces(${size})", TypedCode.SIMPLE);

        case  5 : // <HIGH_VALUE>
        case  6 : // <HIGH_VALUES>

            if (!argu.containsKey(TypedCode.TYPE_EXPECTED)) {
                throw new RuntimeException("[" + filename + "/" + sectionName + "] FigurativeConstant:: expresion deberia tener TYPE_EXPECTED.");
            }

            switch (((Integer) argu.get(TypedCode.TYPE_EXPECTED)).intValue()) {

            case TypedCode.INTEGER :

                return new TypedCode(TypedCode.INTEGER, "Integer.MAX_VALUE", TypedCode.SIMPLE);

            case TypedCode.LONG :

                return new TypedCode(TypedCode.LONG,    "Long.MAX_VALUE",    TypedCode.SIMPLE);

            case TypedCode.DOUBLE :

                return new TypedCode(TypedCode.DOUBLE,  "Double.MAX_VALUE", TypedCode.SIMPLE);

            case TypedCode.STRING :

                return new TypedCode(TypedCode.STRING, "Util.highValueString(${size})", TypedCode.SIMPLE);

            case TypedCode.UNDEF :

                if (params.path("alert_low_high_value_undefined_type").asBoolean(true)) {

                    logger.warn("[" + filename + "/" + sectionName + "] FigurativeConstant HIGH_VALUE para tipo UNDEF.");
                }

                return new TypedCode(TypedCode.STRING, "Util.highValueString(${size})", TypedCode.SIMPLE);
            }

            break;

        case  7 : // <LOW_VALUE>
        case  8 : // <LOW_VALUES>

            if (!argu.containsKey(TypedCode.TYPE_EXPECTED)) {
                throw new RuntimeException("[" + filename + "/" + sectionName + "] FigurativeConstant:: expresion deberia tener TYPE_EXPECTED.");
            }

            switch (((Integer) argu.get(TypedCode.TYPE_EXPECTED)).intValue()) {

            case TypedCode.INTEGER :

                return new TypedCode(TypedCode.INTEGER, "Integer.MIN_VALUE", TypedCode.SIMPLE);

            case TypedCode.LONG :

                return new TypedCode(TypedCode.LONG,    "Long.MIN_VALUE",    TypedCode.SIMPLE);

            case TypedCode.DOUBLE :

                return new TypedCode(TypedCode.DOUBLE,  "Double.MMIN_VALUE", TypedCode.SIMPLE);

            case TypedCode.STRING :

                return new TypedCode(TypedCode.STRING, "Util.lowValueString(${size})", TypedCode.SIMPLE);

            case TypedCode.UNDEF :

                if (params.path("alert_low_high_value_undefined_type").asBoolean(true)) {

                    logger.warn("[" + filename + "/" + sectionName + "] FigurativeConstant LOW_VALUE para tipo UNDEF.");
                }

                return new TypedCode(TypedCode.STRING, "Util.highValueString(${size})", TypedCode.SIMPLE);
            }

            break;

        case 11 : // <NULL>

            return new TypedCode(TypedCode.UNDEF, "null", TypedCode.SIMPLE);
        }

        return null;
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( QuotedText() | <HEXNUMBER> )
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(NonNumericConstant n, HashMap<String, Object> argu) {

        switch (n.f0.which) {

        case 0 : // QuotedText()

            return n.f0.accept(this, argu);

        case 1 : // <HEXNUMBER>

           return getHexNumber(((NodeToken) n.f0.choice).tokenImage);
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
     * f0 -> ( IterableQuotedText() | <HEXNUMBER> )
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     */
    public TypedCode visit(IterableNonNumericConstant n, HashMap<String, Object> argu) {

        switch (n.f0.which) {

        case 0 : // IterableQuotedText()

            return n.f0.choice.accept(this, argu);

        case 1 : // <HEXNUMBER>

           return getHexNumber(((NodeToken) n.f0.choice).tokenImage);
        }

        return null;
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> [ <ALL> ]
     * f1 -> ( NonNumericConstant() | NumericConstant() | FigurativeConstant() )
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(Literal n, HashMap<String, Object> argu) {

        if (n.f0.present()) {
            throw new RuntimeException("[" + filename + "/" + sectionName + "] Literal:: [ <ALL> ] no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");
        }

        return n.f1.accept(this, argu);
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
     * @param argu TODO_javadoc.
     *
     */
    public TypedCode visit(IterableLiteral n, HashMap<String, Object> argu) {

        if (!argu.containsKey(TypedCode.TYPE_EXPECTED)) {
            throw new RuntimeException("[" + filename + "/" + sectionName + "] IterableLiteral:: expresion deberia tener TYPE_EXPECTED.");
        }

        if (n.f0.present()) {
            throw new RuntimeException("[" + filename + "/" + sectionName + "] IterableLiteral:: [ <ALL> ] no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");
        }

        return n.f1.accept(this, argu);
    }

    //
    //
    //

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> CombinableCondition()
     * f1 -> ( ( <AND> | <OR> ) ( CombinableCondition() | AbbreviationRest() ) )*
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(Condition n, HashMap<String, Object> argu) {

        TypedCode subject_ant  = null;
        int       oper_ant     = TypedCode.UNDEF;
        String    hilativo     = null;
        String    hilativo_ant = null;
        boolean   abbrev       = false;
        boolean   abbrev_ant   = false;
        TypedCode str          = genCombinableCondition(subject_ant, oper_ant, n.f0, argu);

        ////////////////////////////////////////////////
      //if (argu.get("subject_ant") != null) {
      //    logger.debug("genCombinableCondition puso en 'subject_ant': " + (TypedCode) argu.get("subject_ant"));
      //}
      //
      //if (argu.get("oper_ant") != null) {
      //    logger.debug("genCombinableCondition puso en 'oper_ant': " + argu.get("subject_ant"));
      //}
      //////////////////////////////////////////////////

        if (n.f1.size() == 0) {
            return str;
        }

        ////////////////////////////////////////////////
      //logger.debug("[" + filename + "/" + sectionName + "] ---------------------------------------------------------------------------------------------------------------------------------------");
      //logger.debug("[" + filename + "/" + sectionName + "] " + n.accept(tokenVisitor).toString().trim());
      //logger.debug("[" + filename + "/" + sectionName + "] " + str);
      //logger.debug("[" + filename + "/" + sectionName + "] ---------------------------------------------------------------------------------------------------------------------------------------");
        ////////////////////////////////////////////////

        StringBuffer sb = new StringBuffer();

        sb.append(str.code);

        subject_ant = getSubjectFromRelationCondition(n.f0, argu);
        oper_ant    = getRelationalOperatorFromRelationCondition(n.f0);

        //

        NodeSequence ns = null;

      //logger.debug("[" + filename + "/" + sectionName + "] ======================================================================================");

        for (int i = 0; i < n.f1.size(); i++) {

            ns           = (NodeSequence) n.f1.elementAt(i); // ( <AND> | <OR> ) ( CombinableCondition() | AbbreviationRest() )
            hilativo_ant = hilativo;
            hilativo     = getAndOr((NodeChoice) ns.elementAt(0));

            if (i < n.f1.size() - 1) {

                abbrev_ant = abbrev;
                abbrev     = isAbbreviationRest((NodeSequence) n.f1.elementAt(i + 1));

                ////////////////////////////////////////////////
              //logger.debug("[" + filename + "/" + sectionName + "] abbrev_ant  : " + abbrev_ant);
              //logger.debug("[" + filename + "/" + sectionName + "] abbrev      : " + abbrev);
                ////////////////////////////////////////////////
            }

            NodeChoice nch = (NodeChoice) ns.elementAt(1);

            ////////////////////////////////////////////////
          //logger.debug("[" + filename + "/" + sectionName + "] " + nch.accept(tokenVisitor).toString().trim()); //  + " (which: " + nch.which + ")"
          //logger.debug("[" + filename + "/" + sectionName + "] hilativo_ant: " + hilativo_ant);
          //logger.debug("[" + filename + "/" + sectionName + "] hilativo    : " + hilativo);
          //logger.debug("[" + filename + "/" + sectionName + "] subject_ant : " + (subject_ant != null ? subject_ant.code : "NULL"));
          //logger.debug("[" + filename + "/" + sectionName + "] oper_ant    : " + (oper_ant != TypedCode.UNDEF ? TypedCode.relationalOper[oper_ant] : "UNDEF"));
            ////////////////////////////////////////////////

            switch (nch.which) {

            case 0 : // CombinableCondition()

                CombinableCondition cc = (CombinableCondition) nch.choice;

              //logger.debug("(nch.choice == CombinableCondition)");

                if ((str = genCombinableCondition(subject_ant, oper_ant, cc, argu)) != null) {

                    if (argu.get("subject_ant") != null) {
                        subject_ant = (TypedCode) argu.get("subject_ant");
                    }

                    if (argu.get("oper_ant") != null) {
                        oper_ant = ((Integer) argu.get("oper_ant")).intValue();
                    }

                    ////////////////////////////////////////////////
                  //logger.debug("[" + filename + "/" + sectionName + "] --------------------------------------------------------------------------------------");
                  //logger.debug("[" + filename + "/" + sectionName + "] " + cc.accept(tokenVisitor).toString().trim());
                  //logger.debug("[" + filename + "/" + sectionName + "] " + str.code);
                  //logger.debug("[" + filename + "/" + sectionName + "] --------------------------------------------------------------------------------------");
                    ////////////////////////////////////////////////
                }

                sb.append(" " + hilativo + " ");

                sb.append(str.code);

                TypedCode s = getSubjectFromRelationCondition(n.f0, argu);

                if (s != null) {

                    ////////////////////////////////////////////////
                  //logger.debug("[" + filename + "/" + sectionName + "] aparecio un getSubjectFromRelationCondition() ...");
                    ////////////////////////////////////////////////

                    subject_ant = s;
                }

                int op = getRelationalOperatorFromRelationCondition(n.f0);

                if (op != TypedCode.UNDEF) {

                    ////////////////////////////////////////////////
                  //logger.debug("[" + filename + "/" + sectionName + "] aparecio un getRelationalOperatorFromRelationCondition() ...");
                    ////////////////////////////////////////////////

                    oper_ant = op;
                }

                break;

            case 1 : // AbbreviationRest()

              //logger.debug("(nch.choice == AbbreviationRest)");

                sb.append(" " + hilativo + " ");

              //logger.debug("subject_ant: " + subject_ant.code);
              //logger.debug("oper_ant   : " + (oper_ant != TypedCode.UNDEF ? TypedCode.relationalOper[oper_ant] : "UNDEF"));

                if (subject_ant == null /*|| oper_ant == TypedCode.UNDEF*/) {
                    throw new RuntimeException("[" + filename + "/" + sectionName + "] subject_ant u oper_ant es nulo");
                }

                str = processAbbreviationRest(""/*prefix*/, subject_ant, (AbbreviationRest) nch.choice, argu);

                ////////////////////////////////////////////////
              //logger.debug("[" + filename + "/" + sectionName + "] ----------------------------------------------------------------------------------------------");
              //logger.debug("[" + filename + "/" + sectionName + "] " + str.code);
              //logger.debug("[" + filename + "/" + sectionName + "] ----------------------------------------------------------------------------------------------");
                ////////////////////////////////////////////////

                sb.append(str.code);

                break;
            }
        }

      //logger.debug("[" + filename + "/" + sectionName + "] ======================================================================================");

        //

        return new TypedCode(TypedCode.BOOLEAN, sb.toString(), TypedCode.SIMPLE);
    }

    /******************************************************************************
     *
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
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(SimpleCondition n, HashMap<String, Object> argu) {

        ////////////////////////////////////////////////
        // logger.debug("[" + filename + "/" + sectionName + "] SimpleCondition:: " + n.accept(tokenVisitor).toString().trim());
        ////////////////////////////////////////////////

        switch (n.f0.which) {

        case 0 : // RelationCondition()

            return n.f0.choice.accept(this, argu);

        case 1 : // ArithmeticExpression()

            argu.put(TypedCode.TYPE_EXPECTED, new Integer(TypedCode.UNDEF));

            return n.f0.choice.accept(this, argu);

        case 2 : // <LPARENCHAR> Condition() <RPARENCHAR>

            TypedCode cond = ((Condition) ((NodeSequence) n.f0.choice).elementAt(1)).accept(this, argu);

            return new TypedCode(cond.type, "(" + cond.code + ")", TypedCode.SIMPLE);
        }

        return null;
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> [ <IS> ]
     * f1 -> [ <NOT> ]
     * f2 -> ( <NUMERIC>
     *       | <ALPHABETIC>
     *       | <ALPHABETIC_LOWER>
     *       | <ALPHABETIC_UPPER>
     *       | ClassName()
     *       | <DBCS>
     *       | <KANJI>
     *       )
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(ClassCondition n, HashMap<String, Object> argu) {

        ////////////////////////////////////////////////
        //logger.debug("[" + filename + "/" + sectionName + "] ClassCondition:: " + n.accept(tokenVisitor).toString().trim());
        ////////////////////////////////////////////////

      //return null;
        throw new RuntimeException("[" + filename + "/" + sectionName + "] no se debe visit(ClassCondition)");
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ArithmeticExpression()
     * f1 -> ( AbbreviationRest()
     *       | SignCondition()
     *       | ClassCondition()
     *       )
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(RelationCondition n, HashMap<String, Object> argu) {
        throw new RuntimeException("[" + filename + "/" + sectionName + "] no se debe visit(RelationCondition)");
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> [ <IS> ]
     * f1 -> [ <NOT> ]
     * f2 -> ( <POSITIVE>
     *       | <NEGATIVE>
     *       | <ZERO>
     *       | <ZEROS>
     *       | <ZEROES>
     *       )
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(SignCondition n, HashMap<String, Object> argu) {
        throw new RuntimeException("[" + filename + "/" + sectionName + "] no se debe visit(SignCondition)");
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> [ <IS> ]
     * f1 -> [ <NOT> ]
     * f2 -> ( <GREATER> [ <THAN> ] [ <OR> <EQUAL> [ <TO> ] ]
     *       | <MORETHANCHAR>
     *       | <LESS>    [ <THAN> ] [ <OR> <EQUAL> [ <TO> ] ]
     *       | <LESSTHANCHAR>
     *       | <EQUAL> [ <TO> ]
     *       | <EQUALCHAR>
     *       | <NOTEQUAL>
     *       | <MORETHANOREQUAL>
     *       | <LESSTHANOREQUAL>
     *       )
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(RelationalOperator n, HashMap<String, Object> argu) {
        throw new RuntimeException("[" + filename + "/" + sectionName + "] no se debe visit(RelationalOperator)");
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ArithmeticExpression()
     *       | <LPARENCHAR> AbbreviationLeaf() ( ( <AND> | <OR> ) AbbreviationLeaf() )+ <RPARENCHAR>
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(AbbreviationLeaf n, HashMap<String, Object> argu) {

      //logger.debug("[" + filename + "/" + sectionName + "] AbbreviationLeaf:: " + n.accept(tokenVisitor).toString().trim());

        switch (n.f0.which) {

        /******************************************************************************
         *
         ******************************************************************************/

        case 0 : // ArithmeticExpression()

            argu.put(TypedCode.TYPE_EXPECTED, new Integer(TypedCode.UNDEF));

            return ((ArithmeticExpression) n.f0.choice).accept(this, argu);

        /******************************************************************************
         *
         ******************************************************************************/

        case 1 : // <LPARENCHAR> AbbreviationLeaf() ( ( <AND> | <OR> ) AbbreviationLeaf() )+ <RPARENCHAR>

            NodeSequence ns = (NodeSequence) n.f0.choice;
            StringBuffer sb = new StringBuffer();

            sb.append("(");

            sb.append(((AbbreviationLeaf) ns.elementAt(1)).accept(this, argu).code);

            NodeListOptional nlo = (NodeListOptional) ns.elementAt(2);

            for (int i = 0; i < nlo.size(); i++) {

                NodeSequence ns1 = (NodeSequence) nlo.elementAt(i);

                sb.append(" " + getAndOr((NodeChoice) nlo.elementAt(0)) + " ");
                sb.append(((AbbreviationLeaf) nlo.elementAt(1)).accept(this, argu).code);
            }

            sb.append(")");

            return new TypedCode(TypedCode.UNDEF, sb.toString(), TypedCode.COMPLEX);
        }

        return null;
    }

    //
    //
    //

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> RelationalOperator()
     * f1 -> AbbreviationLeaf()
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(AbbreviationRest n, HashMap<String, Object> argu) {
        throw new RuntimeException("[" + filename + "/" + sectionName + "] no se debe visit(AbbreviationRest)");
    }

    /******************************************************************************
     *
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
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(Subscript n, HashMap<String, Object> argu) {

        argu.put(TypedCode.TYPE_EXPECTED, new Integer(TypedCode.INTEGER));

        TypedCode typedCode = n.f1.accept(this, argu); // ArithmeticExpression()

        StringBuffer sb = new StringBuffer();

        sb.append(genParentesisCode(typedCode) + " - 1");

        if (n.f2.size() > 0) {

            throw new RuntimeException("[" + filename + "/" + sectionName + "] Subscript:: multidimensionalidad no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

            /*
            NodeSequence ns = null;

            for (int i = 0; i < n.f2.size(); i++) {

                ns = (NodeSequence) n.f2.elementAt(i);

                sb.append(", " + ((ArithmeticExpression) ns.elementAt(1)).accept(this, argu).code);
            }
            */
        }

        return new TypedCode(TypedCode.UNDEF, sb.toString(), TypedCode.SIMPLE);
    }

    /******************************************************************************
     *
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
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(FunctionClause n, HashMap<String, Object> argu) {
        throw new RuntimeException("[" + filename + "/" + sectionName + "] FunctionClause:: no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( QualifiedDataName() ( Subscript() )* [ <LPARENCHAR> LeftmostCharacterPosition() <COLONCHAR> [ Length() ] <RPARENCHAR> ]
     *       | <LINAGE_COUNTER> [ ( <IN> | <OF> ) FileName() ]
     *       | <PROGRAM_STATUS>
     *       )
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(Identifier n, HashMap<String, Object> argu) {
        throw new RuntimeException("[" + filename + "/" + sectionName + "] no se debe visit(Identifier)");
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( DataName() ( ( <IN> | <OF> ) DataName() )* [ ( <IN> | <OF> ) FileName() ]
     *       | SpecialRegister()
     *       )
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(QualifiedDataName n, HashMap<String, Object> argu) {
        throw new RuntimeException("[" + filename + "/" + sectionName + "] no se debe visit(QualifiedDataName)");
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ArithmeticExpression()
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(Length n, HashMap<String, Object> argu) {

        argu.put(TypedCode.TYPE_EXPECTED, new Integer(TypedCode.INTEGER));

        return n.f0.accept(this, argu);
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ArithmeticExpression()
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(LeftmostCharacterPosition n, HashMap<String, Object> argu) {

        argu.put(TypedCode.TYPE_EXPECTED, new Integer(TypedCode.INTEGER));

        return n.f0.accept(this, argu);
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> CobolWord()
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(ClassName n, HashMap<String, Object> argu) {
        return n.f0.accept(this, argu);
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> CobolWord()
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(DataName n, HashMap<String, Object> argu) {
        return n.f0.accept(this, argu);
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> CobolWord()
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(FileName n, HashMap<String, Object> argu) {
        return n.f0.accept(this, argu);
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( CobolWord()
     *       | <LENGTH>
     *       | <WHEN_COMPILED>
     *       | <SUM>
     *       | <RANDOM>
     *       )
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(FunctionName n, HashMap<String, Object> argu) {
        throw new RuntimeException("[" + filename + "/" + sectionName + "] FunctionName:: no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( <ADDRESS> <OF> DataName()
     *       | <DEBUG_ITEM>
     *       | <LENGTH> <OF> Identifier()
     *       | <RETURN_CODE>
     *       | <SHIFT_OUT>
     *       | <SHIFT_IN>
     *       | <SORT_CONTROL>
     *       | <SORT_CORE_SIZE>
     *       | <SORT_FILE_SIZE>
     *       | <SORT_MESSAGE>
     *       | <SORT_MODE_SIZE>
     *       | <SORT_RETURN>
     *       | <TALLY>
     *       | <WHEN_COMPILED>
     *       )
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(SpecialRegister n, HashMap<String, Object> argu) {
        throw new RuntimeException("[" + filename + "/" + sectionName + "] no se debe visit(SpecialRegister)");
    }

    //
    //
    //

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> TimesDiv()
     * f1 -> ( ( <PLUSCHAR> | <MINUSCHAR> ) TimesDiv() )*
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(ArithmeticExpression n, HashMap<String, Object> argu) {

        if (!argu.containsKey(TypedCode.TYPE_EXPECTED)) {
            throw new RuntimeException("[" + filename + "/" + sectionName + "] ArithmeticExpression:: expresion deberia tener TYPE_EXPECTED.");
        }

        int       type_expected = ((Integer) argu.get(TypedCode.TYPE_EXPECTED)).intValue();
        TypedCode typedCode     = n.f0.accept(this, argu); // TimesDiv()

        if (n.f1.size() == 0) {

          //logger.debug("type_expected: " + type_expected);
          //logger.debug("typedCode    : " + typedCode);

            return typedCode;
        }
        else {

            StringBuffer sb     = new StringBuffer();
            boolean      marked = false;

            if (type_expected != TypedCode.UNDEF && !marked && typedCode.isNumeric() && typedCode.type != type_expected) {

                sb.append("(" + TypedCode.javaNames[type_expected] + ") ");

                marked = true;
            }

            sb.append(typedCode.code);

            NodeSequence ns = null;

            for (int i = 0; i < n.f1.size(); i++) {

                ns = (NodeSequence) n.f1.elementAt(i); // ( <PLUSCHAR> | <MINUSCHAR> ) TimesDiv()

                sb.append(" " + ((NodeToken) ((NodeChoice) ns.elementAt(0)).choice).tokenImage); // <PLUSCHAR> | <MINUSCHAR>

                typedCode = ((TimesDiv) ns.elementAt(1)).accept(this, argu); // TimesDiv()

                if (!marked && typedCode.isNumeric() && typedCode.type != type_expected) {

                    sb.append(" (" + TypedCode.javaNames[type_expected] + ")");

                    marked = true;
                }

                sb.append(" " + typedCode.code);
            }

            return new TypedCode(type_expected, sb.toString(), TypedCode.COMPLEX);
        }
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> Power()
     * f1 -> ( ( <ASTERISKCHAR> | <SLASHCHAR> ) Power() )*
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(TimesDiv n, HashMap<String, Object> argu) {

        int       type_expected = ((Integer) argu.get(TypedCode.TYPE_EXPECTED)).intValue();
        TypedCode typedCode     = n.f0.accept(this, argu); // Power()

        if (n.f1.size() == 0) {

          //logger.debug("type_expected: " + type_expected);
          //logger.debug("typecode     :" + typedCode);

            return typedCode;
        }
        else {

            StringBuffer sb     = new StringBuffer();
            boolean      marked = false;

            if (!marked && typedCode.isNumeric() && typedCode.type != type_expected) {

                sb.append("(" + TypedCode.javaNames[type_expected] + ") ");

                marked = true;
            }

            sb.append(typedCode.code);

            NodeSequence ns = null;

            for (int i = 0; i < n.f1.size(); i++) {

                ns = (NodeSequence) n.f1.elementAt(i); // ( <ASTERISKCHAR> | <SLASHCHAR> ) Power()

                sb.append(" " + ((NodeToken) ((NodeChoice) ns.elementAt(0)).choice).tokenImage); // <ASTERISKCHAR> | <SLASHCHAR>

                typedCode = ((Power) ns.elementAt(1)).accept(this, argu); // Power()

                if (!marked && typedCode.isNumeric() && typedCode.type != type_expected) {

                    sb.append(" (" + TypedCode.javaNames[type_expected] + ")");

                    marked = true;
                }

                sb.append(" " + typedCode.code);
            }

            return new TypedCode(type_expected, sb.toString(), TypedCode.COMPLEX);
        }
    }

    /******************************************************************************
     *
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
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(Power n, HashMap<String, Object> argu) {

        TypedCode typedCode = n.f1.accept(this, argu); // Basis()

        if (!n.f0.present() && n.f2.size() == 0) {
            return typedCode;
        }

        //

        StringBuffer sb     = new StringBuffer();
        int          typmax = typedCode.type;

        if (n.f0.present()) { // [ ( <PLUSCHAR> | <MINUSCHAR> ) ]

            if (!typedCode.isNumeric()) {
                throw new RuntimeException("[" + filename + "/" + sectionName + "] Power:: [ ( <PLUSCHAR> | <MINUSCHAR> ) ] no se puede utilizar en tipo " + TypedCode.typesNames[typedCode.type] + " (" + typedCode.code + ")");
            }

            sb.append(((NodeToken) ((NodeChoice) n.f0.node).choice).tokenImage);
        }

        //

        if (n.f2.size() == 0) { // ( <POWEROF> Basis() )*
            sb.append(typedCode.code);
        }
        else {

            sb.append("Math.pow(");

            sb.append(typedCode.code);

            for (int i = 0; i < n.f2.size(); i++) {

                sb.append(", ");

                if (i < n.f2.size() - 1) {
                    sb.append("Math.pow(");
                }

                typedCode = ((Basis) ((NodeSequence) n.f2.elementAt(i)).elementAt(1)).accept(this, argu);

                sb.append(typedCode.code);

                /*
                if (typedCode.type > typmax) {
                    typmax = typedCode.type;
                }
                */
            }

            typmax = TypedCode.DOUBLE;

            for (int i = 0; i < n.f2.size(); i++) {
                sb.append(")");
            }
        }

        return new TypedCode(typmax, sb.toString(), TypedCode.COMPLEX);
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( FunctionClause()
     *       | Identifier()
     *       | Literal()
     *       | <ALL>
     *       | <LPARENCHAR> ArithmeticExpression() <RPARENCHAR>
     *       )
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(Basis n, HashMap<String, Object> argu) {

        TypedCode typedCode = null;

        switch (n.f0.which) {

        case 0 : // FunctionClause()

            throw new RuntimeException("[" + filename + "/" + sectionName + "] Basis:: FunctionClause no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

        case 1 : //  Identifier()

            typedCode = getIdentifier((Identifier) n.f0.choice, GETTER, varspaths, entryArray, usedBases, argu);

            return typedCode;

        case 2 : //  Literal()

            if (!argu.containsKey(TypedCode.TYPE_EXPECTED)) {
                throw new RuntimeException("[" + filename + "/" + sectionName + "] Basis:: expresion deberia tener TYPE_EXPECTED.");
            }

            typedCode = getLiteral((Literal) n.f0.choice, ((Integer) argu.get(TypedCode.TYPE_EXPECTED)).intValue());

          //logger.debug("typedCode: " + typedCode);

            return typedCode;

        case 3 : //  <ALL>

            throw new RuntimeException("[" + filename + "/" + sectionName + "] Basis:: <ALL> no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

        case 4 : //  <LPARENCHAR> ArithmeticExpression() <RPARENCHAR>

            typedCode = ((ArithmeticExpression) ((NodeSequence) n.f0.choice).elementAt(1)).accept(this, argu);

            return new TypedCode(typedCode.type, "(" + typedCode.code + ")", TypedCode.SIMPLE);
        }

        return null;
    }

    //
    //
    //

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
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(CompilationUnit n, HashMap<String, Object> argu) {

        int    pos       = filename.indexOf('.');
        String className = camelCase(pos > -1 ? filename.substring(0, pos) : filename);

        /******************************************************************************
         *
         ******************************************************************************/

        String name      = (pos > -1 ? filename.substring(0, pos): filename).toLowerCase();
        String genfilename = target_dir + "/_src/" + ModelUtil.getPathFromPackage(package_name) + "/" + className + ".java";

        try {
            gen = new PrintStream(new FileOutputStream(genfilename));
        } catch (FileNotFoundException e) {

            logger.fatal("[" + filename + "/" + sectionName + "] " + e.toString());

            return null;
        }

        /******************************************************************************
         *
         ******************************************************************************/

        gen.println("/*");
        gen.println(" *   " + COPYRIGHT);
        gen.println(" *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF " + AUTHOR);
        gen.println(" *   The copyright notice above does not evidence any actual or intended");
        gen.println(" *   publication of such source code.");
        gen.println(" */");

        if (package_name != null) {
            gen.println("package " + package_name + ";");
            gen.println();
            gen.println();
        }

        gen.println("import java.io.*;");
        gen.println();
        gen.println("import java.lang.reflect.*;");
        gen.println();
        gen.println("import java.util.*;");
        gen.println();
        gen.println("import org.apache.log4j.*;");
        gen.println();
        gen.println("import " + ((pos = package_name.lastIndexOf('.')) > -1 ? package_name.substring(0, pos) + "." : "") + "Util;");
        gen.println("import " + package_name + ".*;");
        gen.println();
        gen.println();
        gen.println("/**");
        gen.println(" *");
        gen.println(" * TODO_javadoc.");
        gen.println(" *");
        gen.println(" * @version " + VERSION + " (" + DIAHOY + ").");
        gen.println(" *");
        gen.println(" */");
        gen.println("public class " + className + " {");

        indent++;

        gen.println();
        gen.println(indent(indent) + "/** TODO_javadoc. */");
        gen.println(indent(indent) + "private static Logger logger = Logger.getLogger(" + className + ".class);");
        gen.println();
        gen.println(indent(indent) + "/** TODO_javadoc. */");
        gen.println(indent(indent) + "private int returnCode = 0;");
        gen.println();
        gen.println(indent(indent) + "//");

        //

        for (int i = 0; i < entryArray.size(); i++) {

          //logger.debug("[" + filename + "] variable " + entryArray.get(i).name + " ...");

            gen.println();
            gen.println("    /** " + entryArray.get(i).name + ". */");

            String  var          = camelCase(entryArray.get(i).name);
            boolean is_primitive = entryArray.get(i).childs == null || ModelUtil.isConditionalStruct(entryArray.get(i).childs) || entryArray.get(i).mode == DataEntryDesc.INDEXER;

            if (is_primitive) {
                gen.println("    private " + DataEntryDesc.javaNames[entryArray.get(i).type] + (entryArray.get(i).occurs > 1 ? "[]" : "") + " " + lowering(var) + (entryArray.get(i).value != null ? " = " + entryArray.get(i).value : "") + ";");
            }
            else {
                gen.println("    private " + var +                                             (entryArray.get(i).occurs > 1 ? "[]" : "") + " " + lowering(var) + " = new " + var + (entryArray.get(i).occurs > 1 ? "[" + entryArray.get(i).occurs + "]" : "()") + ";");
            }
        }

        //

        gen.println();
        gen.println(indent(indent) + "/******************************************************************************");
        gen.println(indent(indent) + " * main");
        gen.println(indent(indent) + " ******************************************************************************/");
        gen.println(indent(indent) + "/**");
        gen.println(indent(indent) + " *");
        gen.println(indent(indent) + " * TODO_javadoc.");
        gen.println(indent(indent) + " *");
        gen.println(indent(indent) + " * @param args TODO_javadoc.");
        gen.println(indent(indent) + " *");
        gen.println(indent(indent) + " */");
        gen.println(indent(indent) + "public static void main(String args[]) {");

        indent++;

        gen.println();
        gen.println(indent(indent) + "try {");

        indent++;

      //gen.println();
        gen.println(indent(indent) + "(new " + className + "()).execute();");

        /* ProgramUnit::
         *
         * f0 -> IdentificationDivision()
         * f1 -> [ EnvironmentDivision() ]
         * f2 -> [ DataDivision() ]
         * f3 -> [ ProcedureDivision() ]
         */

      //n.f0.f0.accept(this, argu); // IdentificationDivision()
      //n.f0.f1.accept(this, argu); // [ EnvironmentDivision() ]
      //n.f0.f2.accept(this, argu); // [ DataDivision() ]

        indent--;

        gen.println(indent(indent) + "}");
        gen.println(indent(indent) + "catch (Throwable e) {");
        gen.println(indent(indent) + "    logger.error(\"Throwable: \" + printStackTrace(e));");
        gen.println(indent(indent) + "}");

        indent--;

        gen.println(indent(indent) + "}");
        gen.println();

        //
        //

        gen.println(indent(indent) + "/******************************************************************************");
        gen.println(indent(indent) + " * execute");
        gen.println(indent(indent) + " ******************************************************************************/");
        gen.println(indent(indent) + "/**");
        gen.println(indent(indent) + " *");
        gen.println(indent(indent) + " * TODO_javadoc.");
        gen.println(indent(indent) + " *");
        gen.println(indent(indent) + " */");
        gen.println(indent(indent) + "public void execute() {");

        indent++;

        if (params.path("logger_in_out_methods").asBoolean(false)) {

            gen.println();
            gen.println(indent(indent) + "logger.debug(\"entrando a 'execute()' ...\");");
        }

        if (n.f0.f3.present()) { // [ ProcedureDivision() ]

            ProcedureDivision pd = (ProcedureDivision) n.f0.f3.node;

            /* ProcedureDivision::
             *
             * f0 -> <PROCEDURE>
             * f1 -> <DIVISION>
             * f2 -> [ ConventionName() ]
             * f3 -> [ <USING> ( DataName() )+ ]
             * f4 -> <DOT>
             * f5 -> [ Declaratives() ]
             * f6 -> ProcedureBody()
             */

            /* ProcedureBody::
             *
             * f0 -> Paragraphs()
             * f1 -> ( ProcedureSection() )*
             */

            /* Paragraphs::
             *
             * f0 -> ( Sentence() )*
             * f1 -> ( Paragraph() )*
             */

            sectionName = "INITIAL";

            if (pd.f6.f0.f0.size() > 0) { // ( Sentence() )*
                pd.f6.f0.f0.accept(this, argu);
            }

            //

            if (pd.f6.f0.f1.size() > 0) {   // ( Paragraph() )*

                gen.println();
                gen.println(indent(indent) + "execute(\"" + lowerCamelCase(sectionName) + "_" + lowerCamelCase(getName(((Paragraph) pd.f6.f0.f1.elementAt(0)).f0.f0)) + "\");");
            }
            else if (pd.f6.f1.size() > 0) { // ( ProcedureSection() )*

                String s = getName(((SectionName) ((ProcedureSection) pd.f6.f1.elementAt(0)).f0.f0).f0);

                if (s.equalsIgnoreCase("MAIN")) {
                    s = "PRINCIPAL";
                }

                gen.println();
                gen.println(indent(indent) + "execute(\"" + lowerCamelCase(s) + "\");");
            }
        }

        if (params.path("logger_in_out_methods").asBoolean(false)) {

            gen.println();
            gen.println(indent(indent) + "logger.debug(\"saliendo de 'execute()' ...\");");
        }

        indent--;

        gen.println(indent(indent) + "}");
        gen.println();

        //
        //

        gen.println(indent(indent) + "/******************************************************************************");
        gen.println(indent(indent) + " * execute");
        gen.println(indent(indent) + " ******************************************************************************/");
        gen.println(indent(indent) + "/**");
        gen.println(indent(indent) + " *");
        gen.println(indent(indent) + " * TODO_javadoc.");
        gen.println(indent(indent) + " *");
        gen.println(indent(indent) + " * @param methodName TODO_javadoc.");
        gen.println(indent(indent) + " *");
        gen.println(indent(indent) + " */");
        gen.println(indent(indent) + "public void execute(String methodName) {");

        indent++;

        if (params.path("logger_in_out_methods").asBoolean(false)) {

            gen.println();
            gen.println(indent(indent) + "logger.debug(\"entrando a 'execute(\" + methodName + \")' ...\");");
        }

        gen.println();
        gen.println(indent(indent) + "String name = methodName;");
        gen.println();
        gen.println(indent(indent) + "do {");

        indent++;

        gen.println();
        gen.println(indent(indent) + "try {");

        indent++;

        gen.println();
        gen.println(indent(indent) + "Method mth = this.getClass().getMethod(name, (Class<?>[]) null);");
        gen.println();
        gen.println(indent(indent) + "name = (String) mth.invoke(this);");

        indent--;

        gen.println(indent(indent) + "}");
        gen.println(indent(indent) + "catch(Throwable e) {");
        indent++;

        gen.println(indent(indent) + "throw new RuntimeException(e);");

        indent--;

        gen.println(indent(indent) + "}");

        indent--;

        gen.println();
        gen.println(indent(indent) + "} while (name != null);");

        if (params.path("logger_in_out_methods").asBoolean(false)) {

            gen.println();
            gen.println(indent(indent) + "logger.debug(\"saliendo de 'execute(\" + methodName + \")' ...\");");
        }

        indent--;

        gen.println(indent(indent) + "}");

        //
        //

        if (n.f0.f3.present()) { // [ ProcedureDivision() ]

            ProcedureDivision pd = (ProcedureDivision) n.f0.f3.node;

            /* ProcedureDivision::
             *
             * f0 -> <PROCEDURE>
             * f1 -> <DIVISION>
             * f2 -> [ ConventionName() ]
             * f3 -> [ <USING> ( DataName() )+ ]
             * f4 -> <DOT>
             * f5 -> [ Declaratives() ]
             * f6 -> ProcedureBody()
             */

            /* ProcedureBody::
             *
             * f0 -> Paragraphs()
             * f1 -> ( ProcedureSection() )*
             */

            /* Paragraphs::
             *
             * f0 -> ( Sentence() )*
             * f1 -> ( Paragraph() )*
             */

            sectionName = "INITIAL";

            pd.f6.f0.f1.accept(this, argu); // ( Paragraph() )*

            pd.f6.f1.accept(this, argu); // ( ProcedureSection() )*
        }

        //

        n.f1.accept(this, argu); // ( NestedProgramUnit() EndProgramStatement() )*
        n.f2.accept(this, argu); // [ EndProgramStatement() ( CompilationUnit() )* ]
        n.f3.accept(this, argu); // <EOF>

        //

        gen.println();
        gen.println(indent(indent) + "/******************************************************************************");
        gen.println(indent(indent) + " * printStackTrace");
        gen.println(indent(indent) + " ******************************************************************************/");
        gen.println(indent(indent) + "/**");
        gen.println(indent(indent) + " *");
        gen.println(indent(indent) + " * @param e TODO_javadoc");
        gen.println(indent(indent) + " *");
        gen.println(indent(indent) + " * @return TODO_javadoc");
        gen.println(indent(indent) + " */");
        gen.println(indent(indent) + "private static String printStackTrace(Throwable e) {");
        gen.println();
        gen.println(indent(indent) + "    CharArrayWriter caw = new CharArrayWriter();");
        gen.println(indent(indent) + "    e.printStackTrace(new PrintWriter(caw));");
        gen.println();
        gen.println(indent(indent) + "    return caw.toString();");
        gen.println(indent(indent) + "}");
        gen.println("}");

        gen.close();

        return null;
    }

    /******************************************************************************
     *
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
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(ProcedureSection n, HashMap<String, Object> argu) {

        at_end_defined = false;

        sectionName   = getName(((SectionName) n.f0.f0).f0);
        paragraphName = null;

        if (sectionName.equalsIgnoreCase("MAIN")) {
            sectionName = "PRINCIPAL";
        }

        gen.println();
        gen.println(indent(indent) + "/******************************************************************************");
        gen.println(indent(indent) + " * " + lowerCamelCase(sectionName));
        gen.println(indent(indent) + " ******************************************************************************/");
        gen.println(indent(indent) + "/**");
        gen.println(indent(indent) + " *");
        gen.println(indent(indent) + " * TODO_javadoc.");
        gen.println(indent(indent) + " *");
        gen.println(indent(indent) + " * @return TODO_javadoc.");
        gen.println(indent(indent) + " *");
        gen.println(indent(indent) + " */");
        gen.println(indent(indent) + "public String " + lowerCamelCase(sectionName) + "() {");

        indent++;

        if (params.path("logger_in_out_methods").asBoolean(false)) {

            gen.println();
            gen.println(indent(indent) + "logger.debug(\"entrando a '" + lowerCamelCase(sectionName) + "()' ...\");");
        }

        /* Paragraphs::
         *
         * f0 -> ( Sentence() )*
         * f1 -> ( Paragraph() )*
         */

        if (n.f2.f0.size() > 0) {
            n.f2.f0.accept(this, argu); // ( Sentence() )*
        }

        if (n.f2.f1.size() > 0) { // ( Paragraph() )*

            gen.println();
            gen.println(indent(indent) + "execute(\"" + lowerCamelCase(sectionName) + "_" + lowerCamelCase(getName(((Paragraph) n.f2.f1.elementAt(0)).f0.f0)) + "\");");
        }

        if (params.path("logger_in_out_methods").asBoolean(false)) {

            gen.println();
            gen.println(indent(indent) + "logger.debug(\"saliendo de '" + lowerCamelCase(sectionName) + "()' ...\");");
        }

        gen.println();
        gen.println(indent(indent) + "return null;");

        indent--;

        gen.println(indent(indent) + "}");

        //

        n.f2.f1.accept(this, argu); // ( Paragraph() )*

        return null;
    }

    /******************************************************************************
     *
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
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(Paragraph n, HashMap<String, Object> argu) {

        paragraphName = getName(n.f0.f0);

        gen.println();
        gen.println(indent(indent) + "/******************************************************************************");
        gen.println(indent(indent) + " * " + lowerCamelCase(sectionName) + "_" + lowerCamelCase(paragraphName));
        gen.println(indent(indent) + " ******************************************************************************/");
        gen.println(indent(indent) + "/**");
        gen.println(indent(indent) + " *");
        gen.println(indent(indent) + " * TODO_javadoc.");
        gen.println(indent(indent) + " *");
        gen.println(indent(indent) + " * @return TODO_javadoc.");
        gen.println(indent(indent) + " *");
        gen.println(indent(indent) + " */");
        gen.println(indent(indent) + "public String " + lowerCamelCase(sectionName) + "_" + lowerCamelCase(paragraphName) + "() {");

        indent++;

        if (params.path("logger_in_out_methods").asBoolean(false)) {

            gen.println();
            gen.println(indent(indent) + "logger.debug(\"entrando a '" + lowerCamelCase(sectionName) + "_" + lowerCamelCase(paragraphName) + "()' ...\");");
        }

        boolean    gen_exit = false;
        NodeChoice nch      = null;

        for (int i = 0; i < n.f2.size(); i++) {

            nch = (NodeChoice) n.f2.elementAt(i);

            switch (nch.which) {

            case 0 : // ExitStatement()

                if (!gen_exit) {

                    if (params.path("logger_in_out_methods").asBoolean(false)) {

                        gen.println();
                        gen.println(indent(indent) + "logger.debug(\"saliendo de '" + lowerCamelCase(sectionName) + "_" + lowerCamelCase(paragraphName) + "()' ...\");");
                    }

                    gen.println();
                    gen.println(indent(indent) + "return null;");

                    gen_exit = true;
                }

                break;

            case 1 : // AlteredGoto()

                gen.println();
                gen.println(indent(indent) + "// " + nch.choice.accept(tokenVisitor).toString().trim());

                logger.warn("[" + filename + "/" + sectionName + "] implementar AlteredGoto()");

                break;

            case 2 : // Sentence()

                nch.accept(this, argu);
            }
        }

        if (!gen_exit && !flowInterruption(n) && nextParagraph.containsKey(paragraphName + "/" + sectionName)) {

            if (params.path("logger_in_out_methods").asBoolean(false)) {

                gen.println();
                gen.println(indent(indent) + "logger.debug(\"saliendo de '" + lowerCamelCase(sectionName) + "_" + lowerCamelCase(paragraphName) + "()' ...\");");
            }

            gen.println();
            gen.println(indent(indent) + "return \"" + lowerCamelCase(sectionName) + "_" + lowerCamelCase(nextParagraph.get(paragraphName + "/" + sectionName)) + "\";");
        }

        if (!gen_exit && systemExit(n)) {

            if (params.path("logger_in_out_methods").asBoolean(false)) {

                gen.println();
                gen.println(indent(indent) + "logger.debug(\"saliendo de '" + lowerCamelCase(sectionName) + "_" + lowerCamelCase(paragraphName) + "()' ...\");");
            }

            gen.println();
            gen.println(indent(indent) + "return null;");
        }

        indent--;

        gen.println(indent(indent) + "}");

        paragraphName = null;

        return null;
    }

    //
    //
    //

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
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(Sentence n, HashMap<String, Object> argu) {

        if (n.f0.f0.size() > 1) {

            for (int i = 0; i < n.f0.f0.size(); i++) {

                Statement stmt = (Statement) n.f0.f0.elementAt(i);

                if (stmt.f0.which == 17) { // IfStatement()

                    if (ifStatementWithNextSentence((IfStatement) stmt.f0.choice) && i != n.f0.f0.size() - 1) {
                        throw new RuntimeException("[" + filename + "/" + sectionName + "] Sentence:: IfStatement que no sea ultima Statement en Sentence no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");
                    }
                }
            }
        }

        n.f0.accept(this, argu);
        n.f1.accept(this, argu);

        return null;
    }

    //
    //
    //

    /******************************************************************************
     *
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
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(AcceptStatement n, HashMap<String, Object> argu) {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        TypedCode ident = null;

        switch (n.f1.which) {

        case 0 : // <REPLY>

            throw new RuntimeException("[" + filename + "/" + sectionName + "] AcceptStatement:: <REPLY> no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

        case 1 : // <OMITTED>

            throw new RuntimeException("[" + filename + "/" + sectionName + "] AcceptStatement:: <OMITTED> no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

        case 2 : // Identifier()

            ident = getIdentifier((Identifier) n.f1.choice, SETTER, varspaths, entryArray, usedBases, argu);

            break;
        }

        //

        if (n.f2.present()) {

            NodeSequence ns  = (NodeSequence) n.f2.node;
            NodeChoice   nch = (NodeChoice) ns.elementAt(1);

            switch (nch.which) {

            case 0 : // MnemonicName()

                throw new RuntimeException("[" + filename + "/" + sectionName + "] AcceptStatement:: MnemonicName() no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

            case 1 : // EnvironmentName()

                throw new RuntimeException("[" + filename + "/" + sectionName + "] AcceptStatement:: EnvironmentName() no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

            case 2 : // <DATE> [ <YYYYMMDD> ]

                NodeSequence ns1 = (NodeSequence) nch.choice;

                block.println();
                block.println(indent(indent) + ident.code + setterCasting(ident, new TypedCode(TypedCode.STRING, "(new java.text.SimpleDateFormat(\"" + (((NodeOptional) ns1.elementAt(1)).present() ? "yyyyMMdd" : "yyMMdd") + "\")).format(new java.util.Date())", TypedCode.SIMPLE)) + (ident.getBool("is_primitive") ? "" : ")") + ";");

                break;

            case 3 : // <DAY> [ <YYYYDDD> ]

                throw new RuntimeException("[" + filename + "/" + sectionName + "] AcceptStatement:: <DAY> no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

            case 4 : // <DAY_OF_WEEK>

                throw new RuntimeException("[" + filename + "/" + sectionName + "] AcceptStatement:: <DAY_OF_WEEK> no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

            case 5 : // <TIME>

                block.println();
                block.println(indent(indent) + ident.code + setterCasting(ident, new TypedCode(TypedCode.STRING, "(new java.text.SimpleDateFormat(\"HHmmssSSS\")).format(new java.util.Date()).substring(0, 8)", TypedCode.SIMPLE)) + (ident.getBool("is_primitive") ? "" : ")") + ";");

                break;
            }
        }

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
        }

        return null;
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <ADD>
     * f1 -> ( ( <CORRESPONDING> | <CORR> ) Identifier() <TO> Identifier() [ <ROUNDED> ]
     *       | ( Identifier() | Literal() ) ( [ <COMMACHAR> ] ( Identifier() | Literal() ) )* [ <TO> ( Identifier() [ <ROUNDED> ] )+ ] [ <GIVING> ( Identifier() [ <ROUNDED> ] )+ ]
     *       )
     * f2 -> [ [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f3 -> [ <NOT> [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f4 -> [ <END_ADD> ]
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(AddStatement n, HashMap<String, Object> argu) {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        block.println();

        NodeSequence ns  = (NodeSequence) n.f1.choice;
        NodeChoice   nch = null;
        boolean      rounded;

        switch (n.f1.which) {

        /******************************************************************************
         *
         ******************************************************************************/

        case 0 : // ( <CORRESPONDING> | <CORR> ) Identifier() <TO> Identifier() [ <ROUNDED> ]

            DataEntryDesc source = getDataEntryByIdentifier((Identifier) ns.elementAt(1), varspaths, entryArray, usedBases, argu);
            DataEntryDesc target = getDataEntryByIdentifier((Identifier) ns.elementAt(3), varspaths, entryArray, usedBases, argu);

            rounded = ((NodeOptional) ns.elementAt(4)).present();

            if (source.childs != null && target.childs != null) {

                TypedCode ident  = null;
                TypedCode value  = null;
                int       idx    = -1;
                String    code   = null;

                for (int i = 0; i < target.childs.size(); i++) {

                    if ((idx = existInArray(source.childs, target.childs.get(i).name)) != -1) {

                        ident = new TypedCode(target.childs.get(i).type, target.addendum + ".set" + camelCase(target.childs.get(i)  .name) + "(", TypedCode.SIMPLE,  target.childs.get(i).totalLen, new HashMap<String, Object>());

                        //
                        //

                        code = target.addendum + ".get" + camelCase(target.childs.get(i).name) + "()" + " + ";

                        switch (target.childs.get(i).type) {

                        ////////////////////////////////////////////////////////////////
                        //
                        ////////////////////////////////////////////////////////////////

                        case DataEntryDesc.INTEGER :
                        case DataEntryDesc.LONG :

                            switch (source.childs.get(idx).type) {

                            case DataEntryDesc.INTEGER :
                            case DataEntryDesc.LONG :

                                code += (source.childs.get(idx).type > target.childs.get(i).type ? "(" + DataEntryDesc.javaNames[target.childs.get(i).type] + ") " : "")  + source.addendum + ".get" + camelCase(source.childs.get(idx).name) + "()";

                                break;

                            case DataEntryDesc.DOUBLE :

                                if (rounded) {
                                    code += "(" + DataEntryDesc.javaNames[target.childs.get(i).type] + ") Math.round(" + source.addendum + ".get" + camelCase(source.childs.get(idx).name) + "())";
                                }
                                else {
                                    code += "(" + DataEntryDesc.javaNames[target.childs.get(i).type] + ") "            + source.addendum + ".get" + camelCase(source.childs.get(idx).name) + "()";
                                }

                                break;
                            }

                            value = new TypedCode(target.childs.get(i).type, code, TypedCode.COMPLEX, target.childs.get(i).totalLen, new HashMap<String, Object>());

                            block.println(indent(indent) + ident.code + setterCasting(ident, value) + (ident.getBool("is_primitive") ? "" : ")") + ";");

                            break;

                        ////////////////////////////////////////////////////////////////
                        //
                        ////////////////////////////////////////////////////////////////

                        case DataEntryDesc.DOUBLE :

                            code += source.addendum + ".get" + camelCase(source.childs.get(idx).name) + "()";

                            value = new TypedCode(target.childs.get(i).type, code, TypedCode.COMPLEX, target.childs.get(i).totalLen, new HashMap<String, Object>());

                            block.println(indent(indent) + ident.code + setterCasting(ident, value) + (rounded ? ", Root.ROUNDED" : "") + (ident.getBool("is_primitive") ? "" : ")") + ";");

                            break;
                        }
                    }
                }
            }

            break;

        /******************************************************************************
         *
         ******************************************************************************/

        case 1 : // ( Identifier() | Literal() ) ( [ <COMMACHAR> ] ( Identifier() | Literal() ) )* [ <TO> ( Identifier() [ <ROUNDED> ] )+ ] [ <GIVING> ( Identifier() [ <ROUNDED> ] )+ ]

            StringBuffer sb = new StringBuffer();

            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            //
            // ( Identifier() | Literal() )
            //

            nch = (NodeChoice) ns.elementAt(0);

            TypedCode value = null;

            switch (nch.which) {

            case 0 : // Identifier()

                value = getIdentifier((Identifier) nch.choice, GETTER, varspaths, entryArray, usedBases, argu);

                break;

            case 1 : // Literal()

                value = getLiteral((Literal) nch.choice, TypedCode.UNDEF);

                break;
            }

            int typmax = value.type;
            int aggreg = TypedCode.SIMPLE;

            sb.append(value.code);

            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            //
            // ( [ <COMMACHAR> ] ( Identifier() | Literal() ) )*
            //

            NodeListOptional nlo = (NodeListOptional) ns.elementAt(1);

            for (int i = 0; i < nlo.size(); i++) {

                NodeSequence ns1 = (NodeSequence) nlo.elementAt(i); // [ <COMMACHAR> ] ( Identifier() | Literal() )

                sb.append(" + ");

                nch = (NodeChoice) ns1.elementAt(1); // ( Identifier() | Literal() )

                switch (nch.which) {

                case 0 : // Identifier()

                    value = getIdentifier((Identifier) nch.choice, GETTER, varspaths, entryArray, usedBases, argu);

                    break;

                case 1 : // Literal()

                    value = getLiteral((Literal) nch.choice, TypedCode.UNDEF);

                    break;
                }

                sb.append(value.code);

                if (value.type > typmax) {
                    typmax = value.type;
                }

                aggreg = TypedCode.COMPLEX;
            }

            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            //
            // [ <TO> ( Identifier() [ <ROUNDED> ] )+ ]
            //

            NodeOptional no  = (NodeOptional) ns.elementAt(2);
            NodeOptional no1 = (NodeOptional) ns.elementAt(3); // [ <GIVING> ( Identifier() [ <ROUNDED> ] )+ ]

            TypedCode ident  = null;
            TypedCode getter = null;

            if (no.present()) {

                NodeList nl = (NodeList) ((NodeSequence) no.node).elementAt(1);

                for (int i = 0; i < nl.size(); i++) {

                    NodeSequence ns1 = (NodeSequence) nl.elementAt(i); // Identifier() [ <ROUNDED> ]

                    ident   = getIdentifier((Identifier) ns1.elementAt(0), SETTER, varspaths, entryArray, usedBases, argu);
                    rounded = ((NodeOptional) ns1.elementAt(1)).present();
                    getter  = getIdentifier((Identifier) ns1.elementAt(0), GETTER, varspaths, entryArray, usedBases, argu);

                    sb.append(" + " + getter.code);

                    if (!no1.present()) {
                        block.println(indent(indent) + ident.code + setterCasting(ident, new TypedCode(ident.type > typmax ? ident.type : typmax, sb.toString(), TypedCode.COMPLEX)) + (rounded ? ", Root.ROUNDED" : "") + (ident.getBool("is_primitive") ? "" : ")") + ";");
                    }
                }
            }

            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            //
            // [ <GIVING> ( Identifier() [ <ROUNDED> ] )+ ]
            //

            if (no1.present()) {

                NodeList nl = (NodeList) ((NodeSequence) no1.node).elementAt(1);

                for (int i = 0; i < nl.size(); i++) { // ( Identifier() [ <ROUNDED> ] )+

                    NodeSequence ns1 = (NodeSequence) nl.elementAt(i);

                    ident   = getIdentifier((Identifier) ns1.elementAt(0), SETTER, varspaths, entryArray, usedBases, argu);
                    rounded = ((NodeOptional) ns1.elementAt(1)).present();

                    block.println(indent(indent) + ident.code + setterCasting(ident, new TypedCode(typmax, sb.toString(), aggreg)) + (rounded ? ", Root.ROUNDED" : "") + (ident.getBool("is_primitive") ? "" : ")") + ";");
                }
            }

            break;
        }

        if (n.f2.present()) {
            throw new RuntimeException("[" + filename + "/" + sectionName + "] AddStatement:: [ [ <ON> ] <SIZE> <ERROR> StatementList() ] no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");
        }

        if (n.f3.present()) {
            throw new RuntimeException("[" + filename + "/" + sectionName + "] AddStatement:: [ <NOT> [ <ON> ] <SIZE> <ERROR> StatementList() ] no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");
        }

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
        }

        return null;
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <ALTER>
     * f1 -> ( ProcedureName() <TO> [ <PROCEED> <TO> ] ProcedureName() )+
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(AlterStatement n, HashMap<String, Object> argu) {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        logger.debug("[" + filename + "/" + sectionName + "] " + n.getClass().getSimpleName() + ":: no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
        }

        return null;
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <CALL>
     * f1 -> ( ConventionName() ( Identifier() | Literal() )
     *       | ( Identifier() | Literal() )
     *       )
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
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(CallStatement n, HashMap<String, Object> argu) {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        logger.debug("[" + filename + "/" + sectionName + "] " + n.getClass().getSimpleName() + ":: no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

        /*
        NodeChoice nch = null;

        switch (n.f1.which) {

        case 0 : // ConventionName() ( Identifier() | Literal() )

            NodeSequence ns = (NodeSequence) n.f1.choice;

            nch = (NodeChoice) ns.elementAt(1);

            switch (nch.which) {

            case 0 : // Identifier()

                value = getIdentifier((Identifier) nch.choice, GETTER, varspaths, entryArray, usedBases, argu);

                break;

            case 1 : // Literal()

                value = getLiteral((Literal) nch.choice, TypedCode.UNDEF);

                break;
            }

            break;

        case 1 : // ( Identifier() | Literal() )

            nch = (NodeChoice) n.f1.choice;

            switch (nch.which) {

            case 0 : // Identifier()

                value = getIdentifier((Identifier) nch.choice, GETTER, varspaths, entryArray, usedBases, argu);

                break;

            case 1 : // Literal()

                value = getLiteral((Literal) nch.choice, TypedCode.UNDEF);

                break;
            }

            break;
        }
        */

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
        }

        return null;
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <CANCEL>
     * f1 -> ( Identifier() | Literal() )+
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(CancelStatement n, HashMap<String, Object> argu) {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        logger.debug("[" + filename + "/" + sectionName + "] " + n.getClass().getSimpleName() + ":: no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
        }

        return null;
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <CLOSE>
     * f1 -> ( FileName() [ ( ( <REEL> | <UNIT> ) [ ( [ <FOR> ] <REMOVAL> | [ <WITH> ] <NO> <REWIND> ) ] | [ <WITH> ] ( <NO> <REWIND> | <LOCK> ) ) ] )+
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(CloseStatement n, HashMap<String, Object> argu) {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        logger.debug("[" + filename + "/" + sectionName + "] " + n.getClass().getSimpleName() + ":: no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
        }

        return null;
    }

    /******************************************************************************
     *
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
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(ComputeStatement n, HashMap<String, Object> argu) {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        block.println();

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        TypedCode    value   = null;
        TypedCode    ident   = null;
        NodeSequence ns      = null;
        boolean      rounded;

        for (int i = 0; i < n.f1.size(); i++) {

            ns      = (NodeSequence) n.f1.elementAt(i); // Identifier() [ <ROUNDED> ]
            ident   = getIdentifier((Identifier) ns.elementAt(0), SETTER, varspaths, entryArray, usedBases, argu);
            rounded = ((NodeOptional) ns.elementAt(1)).present();

            argu.put(TypedCode.TYPE_EXPECTED, new Integer(ident.type));

            value = n.f3.accept(this, argu);

            block.println(indent(indent) + ident.code + setterCasting(ident, value) + (rounded ? ", Root.ROUNDED" : "") + (ident.getBool("is_primitive") ? "" : ")") + ";");
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        if (n.f4.present()) {
            throw new RuntimeException("[" + filename + "/" + sectionName + "] ComputeStatement:: [ [ <ON> ] <SIZE> <ERROR> StatementList() ] no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");
        }

        if (n.f5.present()) {
            throw new RuntimeException("[" + filename + "/" + sectionName + "] ComputeStatement:: [ <NOT> [ <ON> ] <SIZE> <ERROR> StatementList() ] no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");
        }

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
        }

        return null;
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <CONTINUE>
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(ContinueStatement n, HashMap<String, Object> argu) {

        TypedCode _ret = null;

        n.f0.accept(this, argu);

        return _ret;
    }

    /******************************************************************************
     *
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
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(DeleteStatement n, HashMap<String, Object> argu) {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        logger.debug("[" + filename + "/" + sectionName + "] " + n.getClass().getSimpleName() + ":: no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
        }

        return null;
    }

    /******************************************************************************
     *
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
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(DisplayStatement n, HashMap<String, Object> argu) {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        block.println();
        block.print  (indent(indent) + "logger.info(");

        // f1 -> ( Identifier() | Literal() )

        TypedCode value = null;

        switch (n.f1.which) {

        case 0 : // Identifier()

            value = getIdentifier((Identifier) n.f1.choice, GETTER, varspaths, entryArray, usedBases, argu);

            break;

        case 1 : // Literal()

            value = getLiteral((Literal) n.f1.choice, TypedCode.UNDEF);

            break;
        }

        block.print  (value.code);

        NodeChoice nch = null;

        for (int i = 0; i < n.f2.size(); i++) { // ( [ <COMMACHAR> ] ( Identifier() | Literal() ) )*

            nch = (NodeChoice) ((NodeSequence) n.f2.elementAt(i)).elementAt(1);

            block.print  (" + ");

            switch (nch.which) {

            case 0 : // Identifier()

                value = getIdentifier((Identifier) nch.choice, GETTER, varspaths, entryArray, usedBases, argu);

                break;

            case 1 : // Literal()

                value = getLiteral((Literal) nch.choice, TypedCode.UNDEF);

                break;
            }

            block.print  (value.code);
        }

        block.println(");");

        //

        if (n.f3.present()) {
            throw new RuntimeException("[" + filename + "/" + sectionName + "] DisplayStatement:: [ <UPON> ( MnemonicName() | EnvironmentName() ) ] no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");
        }

        if (n.f4.present()) {
            throw new RuntimeException("[" + filename + "/" + sectionName + "] DisplayStatement:: [ [ <WITH> ] <NO> <ADVANCING> ] no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");
        }

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
        }

        return null;
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <DIVIDE>
     * f1 -> ( Identifier() | Literal() )
     * f2 -> ( <INTO> ( Identifier() | Literal() ) [ <ROUNDED> ] ( <GIVING> ( Identifier() [ <ROUNDED> ] )+ | ( ( Identifier() | Literal() ) [ <ROUNDED> ] )* )
     *       | <BY>   ( Identifier() | Literal() )               [ <GIVING> ( Identifier() [ <ROUNDED> ] )+ ]
     *       )
     * f3 -> [ <REMAINDER> Identifier() ]
     * f4 -> [ [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f5 -> [ <NOT> [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f6 -> [ <END_DIVIDE> ]
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(DivideStatement n, HashMap<String, Object> argu) {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        block.println();

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //
        // ( Identifier() | Literal() )
        //

        TypedCode dividendo = null;
        TypedCode divisor   = null;
        TypedCode ident     = null;
        boolean   rounded;

        switch (n.f1.which) {

        case 0 : // Identifier()

            dividendo = getIdentifier((Identifier) n.f1.choice, GETTER, varspaths, entryArray, usedBases, argu);

            break;

        case 1 : // Literal()

            dividendo = getLiteral((Literal) n.f1.choice, TypedCode.UNDEF);

            break;
        }

        int typmax = dividendo.type;

        switch (n.f2.which) {

        /******************************************************************************
         *
         ******************************************************************************/

        case 0 : // <INTO> ( Identifier() | Literal() ) [ <ROUNDED> ] ( <GIVING> ( Identifier() [ <ROUNDED> ] )+

            throw new RuntimeException("[" + filename + "/" + sectionName + "] DivideStatement:: <INTO> ( Identifier() | Literal() ) [ <ROUNDED> ] ( <GIVING> ( Identifier() [ <ROUNDED> ] )+ | ( ( Identifier() | Literal() ) [ <ROUNDED> ] )* )  no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

        /******************************************************************************
         *
         ******************************************************************************/

        case 1 : // <BY> ( Identifier() | Literal() )                 [ <GIVING> ( Identifier() [ <ROUNDED> ] )+ ]

            NodeSequence ns  = (NodeSequence) n.f2.choice;
            NodeChoice   nch = (NodeChoice) ns.elementAt(1);

            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //
            // ( Identifier() | Literal() )
            //

            switch (nch.which) {

            case 0 : // Identifier()

                divisor = getIdentifier((Identifier) nch.choice, GETTER, varspaths, entryArray, usedBases, argu);

                break;

            case 1 : // Literal()

                divisor = getLiteral((Literal) nch.choice, TypedCode.UNDEF);

                break;
            }

            if (divisor.type > typmax) {
                typmax = divisor.type;
            }

            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            //
            // [ <GIVING> ( Identifier() [ <ROUNDED> ] )+ ]
            //

            NodeOptional no = (NodeOptional) ns.elementAt(2);

            if (no.present()) {

                NodeSequence ns1   = (NodeSequence) no.node;
                NodeList     nl    = (NodeList) ns1.elementAt(1); // ( Identifier() [ <ROUNDED> ] )+
                NodeSequence ns2   = null;

                for (int i = 0; i < nl.size(); i++) {

                    ns2     = (NodeSequence) nl.elementAt(i); // Identifier() [ <ROUNDED> ]
                    ident   = getIdentifier((Identifier) ns2.elementAt(0), SETTER, varspaths, entryArray, usedBases, argu);
                    rounded = ((NodeOptional) ns2.elementAt(1)).present();

                    if (!ident.isNumeric()) {
                        throw new RuntimeException("[" + filename + "/" + sectionName + "] DivideStatement:: tipo " + TypedCode.typesNames[ident.type] + " no es numerico {" + ns2.elementAt(0).accept(tokenVisitor).toString().trim() + "}");
                    }

                    block.println(indent(indent) + ident.code + setterCasting(ident, new TypedCode(ident.type > typmax ? ident.type : typmax, dividendo.code + " / " + divisor.code, TypedCode.COMPLEX)) + (rounded ? ", Root.ROUNDED" : "") + (ident.getBool("is_primitive") ? "" : ")") + ";");
                }
            }
            else {

                throw new RuntimeException("[" + filename + "/" + sectionName + "] DivideStatement:: [ <GIVING> ( Identifier() [ <ROUNDED> ] )+ ] debe estar presente {" + ns.elementAt(0).accept(tokenVisitor).toString().trim() + "}");
                /*
                ident = getIdentifier((Identifier) n.f1.choice, SETTER, varspaths, entryArray, usedBases, argu);

                if (!ident.isNumeric()) {
                    throw new RuntimeException("[" + filename + "/" + sectionName + "] DivideStatement:: tipo " + TypedCode.typesNames[ident.type] + " no es numerico {" + n.f1.accept(tokenVisitor).toString().trim() + "}");
                }

                block.println(indent(indent) + ident.code + setterCasting(ident, new TypedCode(ident.type > typmax ? ident.type : typmax, dividendo.code + " / " + divisor.code, TypedCode.COMPLEX)) + (ident.getBool("is_primitive") ? "" : ")") + ";");
                */
            }

            break;
        }

        // [ <REMAINDER> Identifier() ]

        if (n.f3.present() && divisor != null) {

            NodeSequence ns3 = (NodeSequence) n.f3.node;

            ident = getIdentifier((Identifier) ns3.elementAt(1), SETTER, varspaths, entryArray, usedBases, argu);

            if (!ident.isNumeric()) {
                throw new RuntimeException("[" + filename + "/" + sectionName + "] DivideStatement:: tipo " + TypedCode.typesNames[ident.type] + " no es numerico {" + ns3.elementAt(1).accept(tokenVisitor).toString().trim() + "}");
            }

            block.println(indent(indent) + ident.code + setterCasting(ident, new TypedCode(ident.type > typmax ? ident.type : typmax, dividendo.code + " % " + divisor.code, TypedCode.COMPLEX)) + (ident.getBool("is_primitive") ? "" : ")") + ";");
        }

        //

        if (n.f4.present()) {
            throw new RuntimeException("[" + filename + "/" + sectionName + "] DivideStatement:: [ [ <ON> ] <SIZE> <ERROR> StatementList() ] no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");
        }

        if (n.f5.present()) {
            throw new RuntimeException("[" + filename + "/" + sectionName + "] DivideStatement:: [ <NOT> [ <ON> ] <SIZE> <ERROR> StatementList() ] no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");
        }

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
        }

        return null;
    }

    /******************************************************************************
     *
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
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(EntryStatement n, HashMap<String, Object> argu) {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        logger.debug("[" + filename + "/" + sectionName + "] " + n.getClass().getSimpleName() + ":: no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
        }

        return null;
    }

    /******************************************************************************
     *
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
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(EvaluateStatement n, HashMap<String, Object> argu) {

        TypedCode value = n.f1.accept(this, argu);

        if (n.f2.size() > 0) {
            throw new RuntimeException("[" + filename + "/" + sectionName + "] EvaluateStatement:: ( <ALSO> EvaluateValue() )* no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");
        }

        //

        gen.println();

        NodeSequence ns         = null;
        NodeSequence ns1        = null;
        NodeList     nl         = null;
        boolean      first      = true;
        boolean      when_other = false;

        for (int i = 0; i < n.f3.size(); i++) {

            ns = (NodeSequence) n.f3.elementAt(i); // ( EvaluateWhenClause() )+ [ <THEN> ] StatementList()
            nl = (NodeList)       ns.elementAt(0); // ( EvaluateWhenClause() )+

            if (nl.size() > 1) {
                throw new RuntimeException("[" + filename + "/" + sectionName + "] EvaluateStatement::  ( EvaluateWhenClause() )+ no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");
            }

            //

            EvaluateWhenClause ewc = (EvaluateWhenClause) nl.elementAt(0); // ver <WHEN> <OTHER> ultima opcion

            switch (ewc.f0.which) {

            case 0 : // <WHEN> <OTHER>

                if (when_other) {
                    throw new RuntimeException("[" + filename + "/" + sectionName + "] EvaluateStatement:: <WHEN> <OTHER> no debe estar mas de una vez {" + n.accept(tokenVisitor).toString().trim() + "}");
                }

                if (i < n.f3.size() - 1) {
                    throw new RuntimeException("[" + filename + "/" + sectionName + "] EvaluateStatement:: <WHEN> <OTHER> debe ser la ultima opcion {" + n.accept(tokenVisitor).toString().trim() + "}");
                }

                gen.println(indent(indent) + "}");
                gen.println(indent(indent) + "else {");

                indent++;

                ((StatementList) ns.elementAt(2)).accept(this, argu);

                indent--;

                when_other = true;

                break;

            case 1 : // <WHEN> EvaluatePhrase() ( <ALSO> EvaluatePhrase() )*

                ns1 = (NodeSequence) ewc.f0.choice;

                if (((NodeListOptional) ns1.elementAt(2)).size() > 0) {
                    throw new RuntimeException("[" + filename + "/" + sectionName + "] EvaluateStatement:: ( <ALSO> EvaluatePhrase() )* no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");
                }

                //

                EvaluatePhrase ep     = (EvaluatePhrase) ns1.elementAt(1);
                TypedCode      phrase = null;

                switch (ep.f0.which) {

                case 0: // EvaluateThruPhrase()

                    throw new RuntimeException("[" + filename + "/" + sectionName + "] EvaluateStatement:: EvaluateThruPhrase() no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

                case 2: // <ANY>

                    throw new RuntimeException("[" + filename + "/" + sectionName + "] EvaluateStatement:: <ANY> no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

                case 1: // Condition()

                    phrase = ((Condition) ep.f0.choice).accept(this, argu);

                    break;


                case 3: // <TRUE>

                    phrase = new TypedCode(TypedCode.BOOLEAN, "true", TypedCode.SIMPLE);

                    break;

                case 4: // <FALSE>

                    phrase = new TypedCode(TypedCode.BOOLEAN, "false", TypedCode.SIMPLE);

                    break;
                }

                TypedCode typedCode = getRelationalCode("", value, TypedCode.EQ, phrase);

                if (first) {

                    first = false;

                    gen.println(indent(indent) + "if      (" + typedCode.code + ") {");
                }
                else {
                    gen.println(indent(indent) + "}");
                    gen.println(indent(indent) + "else if (" + typedCode.code + ") {");
                }

                indent++;

                ((StatementList) ns.elementAt(2)).accept(this, argu);

                indent--;

                break;
            }
        }

        gen.println(indent(indent) + "}");

        //

        return null;
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
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(EvaluateValue n, HashMap<String, Object> argu) {
        return n.f0.accept(this, argu);
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <EXEC>
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(ExecStatement n, HashMap<String, Object> argu) {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        logger.debug("[" + filename + "/" + sectionName + "] " + n.getClass().getSimpleName() + ":: no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
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
     * f0 -> <EXIT>
     * f1 -> <DOT>
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(ExitStatement n, HashMap<String, Object> argu) {

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        block.println();
        block.println(indent(indent) + "return null;");

        //

        block.close();

        gen.print(new String(baos.toByteArray()));

        return null;
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <EXIT>
     * f1 -> <PROGRAM>
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(ExitProgramStatement n, HashMap<String, Object> argu) {

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        block.println();
        block.println(indent(indent) + "System.exit(returnCode);");

        //

        block.close();

        gen.print(new String(baos.toByteArray()));

        return null;
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <GOBACK>
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(GobackStatement n, HashMap<String, Object> argu) {

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        block.println();
        block.println(indent(indent) + "System.exit(returnCode);");

        //

        block.close();

        gen.print(new String(baos.toByteArray()));

        return null;
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <GO>
     * f1 -> [ <TO> ]
     * f2 -> ( ( ProcedureName() )+ [ <DEPENDING> [ <ON> ] Identifier() ]
     *       | <MORE_LABELS>
     *       )
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(GotoStatement n, HashMap<String, Object> argu) {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        block.println();

        switch (n.f2.which) {

        case 0: // ( ProcedureName() )+ [ <DEPENDING> [ <ON> ] Identifier() ]

            NodeSequence ns = (NodeSequence) n.f2.choice;
            NodeList     nl = (NodeList)     ns.elementAt(0); // ( ProcedureName() )+
            NodeOptional no = (NodeOptional) ns.elementAt(1);

            if (no.present()) { // [ <DEPENDING> [ <ON> ] Identifier() ]

                if (nl.size() <= 2) {
                    throw new RuntimeException("[" + filename + "/" + sectionName + "] GotoStatement:: <DEPENDING> [ <ON> ] Identifier() sin ( ProcedureName() )+ {" + n.accept(tokenVisitor).toString().trim() + "}");
                }

                TypedCode ident = getIdentifier((Identifier) ((NodeSequence) no.node).elementAt(2), GETTER, varspaths, entryArray, usedBases, argu);

                block.println(indent(indent) + "switch(" + ident.code + ") {");

                ////////////////////////////////////  verificar que Identifier() es entero.

                for (int j = 0; j < nl.size(); j++) {

                    block.println(indent(indent) + "case " + (j + 1) + " : ");

                    indent++;

                    //

                    if (params.path("logger_in_out_methods").asBoolean(false)) {

                        block.println();
                        block.println(indent(indent) + "logger.debug(\"saliendo de '" + lowerCamelCase(sectionName) + (paragraphName != null ? "_" + lowerCamelCase(paragraphName) : "") + "()' ...\");");
                    }

                    block.println(indent(indent) + "return \"" + methodStyle(getParagraphSection(getParagraphOrSectionName((ProcedureName) nl.elementAt(j)), sectionName, sections, paragraphs)) + "\";");

                    indent--;
                }

                block.println(indent(indent) + "}");
            }
            else {

                if (nl.size() != 1) {
                    throw new RuntimeException("[" + filename + "/" + sectionName + "] GotoStatement:: ( ProcedureName() )+ sin <DEPENDING> [ <ON> ] Identifier() {" + n.accept(tokenVisitor).toString().trim() + "}");
                }

                if (params.path("logger_in_out_methods").asBoolean(false)) {

                    block.println();
                    block.println(indent(indent) + "logger.debug(\"saliendo de '" + lowerCamelCase(sectionName) + (paragraphName != null ? "_" + lowerCamelCase(paragraphName) : "") + "()' ...\");");
                }

                block.println(indent(indent) + "return \"" + methodStyle(getParagraphSection(getParagraphOrSectionName((ProcedureName) nl.elementAt(0)), sectionName, sections, paragraphs)) + "\";");
            }

            break;

        case 1 : // <MORE_LABELS>

            throw new RuntimeException("[" + filename + "/" + sectionName + "] GotoStatement:: <MORE_LABELS> no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");
        }

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
        }

        return null;
    }

    /******************************************************************************
     *
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
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(IfStatement n, HashMap<String, Object> argu) {

        gen.println();

        TypedCode cond = n.f1.accept(this, argu);

        //

        gen.println(indent(indent) + "if (" + cond.code + ") {");

        indent++;

        //

        if (n.f3.which == 1) { // <NEXT> <SENTENCE>
            gen.println(indent(indent - 1) + "  // NEXT SENTENCE");
        }
        else {
            n.f3.accept(this, argu);
        }

        indent--;

        if (n.f4.present()) {

            gen.println(indent(indent) + "}");
            gen.println(indent(indent) + "else {");

            indent++;

            if (((NodeChoice) ((NodeSequence) n.f4.node).elementAt(1)).which == 1) { // <NEXT> <SENTENCE>
                gen.println(indent(indent - 1) + "  // NEXT SENTENCE");
            }
            else {
                n.f4.accept(this, argu);
            }

            indent--;
        }

        gen.println(indent(indent) + "}");

        //

        if (n.f5.present()) {

            if (n.f3.which == 1) { // <NEXT> <SENTENCE>
                gen.println(indent(indent - 1) + "  // TODO: analisis accion NEXT SENTENCE / END-IF");
            }

            if (n.f4.present()) {

                if (((NodeChoice) ((NodeSequence) n.f4.node).elementAt(1)).which == 1) { // <NEXT> <SENTENCE>
                    gen.println(indent(indent - 1) + "  // TODO: analisis accion NEXT SENTENCE / END-IF");
                }
            }
        }

        //

        return null;
    }

    /******************************************************************************
     *
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
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(InitializeStatement n, HashMap<String, Object> argu) {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        logger.debug("[" + filename + "/" + sectionName + "] " + n.getClass().getSimpleName() + ":: no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
        }

        return null;
    }

    /******************************************************************************
     *
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
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(InspectStatement n, HashMap<String, Object> argu) {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        logger.debug("[" + filename + "/" + sectionName + "] " + n.getClass().getSimpleName() + ":: no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
        }

        return null;
    }

    /******************************************************************************
     *
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
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(MergeStatement n, HashMap<String, Object> argu) {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        logger.debug("[" + filename + "/" + sectionName + "] " + n.getClass().getSimpleName() + ":: no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
        }

        return null;
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <MOVE>
     * f1 -> ( ArithmeticExpression() <TO> Identifier() ( [ <COMMACHAR> ] Identifier() )*
     *       | ( <CORRESPONDING> | <CORR> ) Identifier() <TO> ( Identifier() )+
     *       )
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(MoveStatement n, HashMap<String, Object> argu) {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        block.println();

        NodeSequence ns = (NodeSequence) n.f1.choice;

        switch (n.f1.which) {

        case 0 : // ArithmeticExpression() <TO> Identifier() ( [ <COMMACHAR> ] Identifier() )*

            TypedCode ident = getIdentifier((Identifier) ns.elementAt(2), SETTER, varspaths, entryArray, usedBases, argu);

          //logger.debug("ident: " + ident);

            argu.put(TypedCode.TYPE_EXPECTED, new Integer(ident.type));

            TypedCode value = ((ArithmeticExpression) ns.elementAt(0)).accept(this, argu); // ArithmeticExpression()

          //logger.debug("value: " + value);

            block.println(indent(indent) + ident.code + setterCasting(ident, value) + (ident.getBool("is_primitive") ? "" : ")") + ";");

            //

            NodeListOptional nlo = (NodeListOptional) ns.elementAt(3);

            for (int i = 0; i < nlo.size(); i++) { // ( [ <COMMACHAR> ] Identifier() )*

                ident = getIdentifier((Identifier) ((NodeSequence) nlo.elementAt(i)).elementAt(1), SETTER, varspaths, entryArray, usedBases, argu);

                argu.put(TypedCode.TYPE_EXPECTED, new Integer(ident.type));

                value = ((ArithmeticExpression) ns.elementAt(0)).accept(this, argu); // ArithmeticExpression()

                block.println();
                block.println(indent(indent) + ident.code + setterCasting(ident, value) + (ident.getBool("is_primitive") ? "" : ")") + ";");
            }

            break;

        case 1 : // ( <CORRESPONDING> | <CORR> ) Identifier() <TO> ( Identifier() )+

            NodeList nl = (NodeList) ns.elementAt(3);

            if (nl.size() != 1) {
                throw new RuntimeException("[" + filename + "/" + sectionName + "] MoveStatement:: <CORRESPONDING> <TO> deberia ser un unico grupo  {" + nl.accept(tokenVisitor).toString().trim() + "}");
            }

            DataEntryDesc source = getDataEntryByIdentifier((Identifier) ns.elementAt(1), varspaths, entryArray, usedBases, argu);
            DataEntryDesc target = getDataEntryByIdentifier((Identifier) nl.elementAt(0), varspaths, entryArray, usedBases, argu);

            if (source.childs != null && target.childs != null) {

                int idx = -1;

                block.println();

                for (int i = 0; i < target.childs.size(); i++) {

                    if ((idx = existInArray(source.childs, target.childs.get(i).name)) != -1) {

                        ident = new TypedCode(target.childs.get(i)  .type, target.addendum + ".set" + camelCase(target.childs.get(i)  .name) + "(",  TypedCode.SIMPLE, target.childs.get(i)  .totalLen, new HashMap<String, Object>());
                        value = new TypedCode(source.childs.get(idx).type, source.addendum + ".get" + camelCase(source.childs.get(idx).name) + "()", TypedCode.SIMPLE, source.childs.get(idx).totalLen, new HashMap<String, Object>());

                        block.println(indent(indent) + ident.code + setterCasting(ident, value) + (ident.getBool("is_primitive") ? "" : ")") + ";");
                    }
                }
            }

            break;
        }

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
        }

        return null;
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <MULTIPLY>
     * f1 ->   ( Identifier() | Literal() )
     * f2 -> <BY>
     * f3 -> ( ( Identifier() | Literal() ) [ <ROUNDED> ] )+
     * f4 -> [ <GIVING> ( Identifier() [ <ROUNDED> ] )+ ]
     * f5 -> [ [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f6 -> [ <NOT> [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f7 -> [ <END_MULTIPLY> ]
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(MultiplyStatement n, HashMap<String, Object> argu) {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        block.println();

        StringBuffer sb = new StringBuffer();

        NodeSequence ns = null;
        NodeChoice   nch = null;

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // f1 -> ( Identifier() | Literal() )

        TypedCode value = null;
        TypedCode ident = null;
        boolean   rounded;

        switch (n.f1.which) {

        case 0 : // Identifier()

            value = getIdentifier((Identifier) n.f1.choice, GETTER, varspaths, entryArray, usedBases, argu);

            break;

        case 1 : // Literal()

            value = getLiteral((Literal) n.f1.choice, TypedCode.UNDEF);

            break;
        }

        int typmax = value.type;

        sb.append(value.code);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // f3 -> ( ( Identifier() | Literal() ) [ <ROUNDED> ] )+

        for (int i = 0; i < n.f3.size(); i++) {

            ns      = (NodeSequence) n.f3.elementAt(i); // ( Identifier() | Literal() ) [ <ROUNDED> ]
            nch     = (NodeChoice)    ns.elementAt(0);  // ( Identifier() | Literal() )
            rounded = ((NodeOptional) ns.elementAt(1)).present();

            switch (nch.which) {

            case 0 : // Identifier()

                value = getIdentifier((Identifier) nch.choice, GETTER, varspaths, entryArray, usedBases, argu);
                ident = getIdentifier((Identifier) nch.choice, SETTER, varspaths, entryArray, usedBases, argu);

                break;

            case 1 : // Literal()

                value = getLiteral((Literal) nch.choice, TypedCode.UNDEF);

                if (!n.f4.present()) { // [ <GIVING> ( Identifier() [ <ROUNDED> ] )+ ]
                    throw new RuntimeException("[" + filename + "/" + sectionName + "] MultiplyStatement:: Literal() no es l-value. {" + nch.accept(tokenVisitor).toString().trim() + "}");
                }

                break;
            }

            if (!n.f4.present()) { // [ <GIVING> ( Identifier() [ <ROUNDED> ] )+ ]

                rounded = ((NodeOptional) ns.elementAt(1)).present();

                block.println(indent(indent) + ident.code + setterCasting(ident, new TypedCode(ident.type > typmax ? ident.type : typmax, sb.toString() + " * " + value.code, TypedCode.COMPLEX)) + (rounded ? ", Root.ROUNDED" : "") + (ident.getBool("is_primitive") ? "" : ")") + ";");
            }
            else {

                sb.append(" * " + value.code);

                if (value.type > typmax) {
                    typmax = value.type;
                }
            }
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // f4 -> [ <GIVING> ( Identifier() [ <ROUNDED> ] )+ ]

        if (n.f4.present()) {

            ns = (NodeSequence) n.f4.node;

            NodeList     nl  = (NodeList) ns.elementAt(1);
            NodeSequence ns1 = null;

            for (int i = 0; i < nl.size(); i++) { // ( Identifier() [ <ROUNDED> ] )+

                ns1     = (NodeSequence) nl.elementAt(i);
                ident   = getIdentifier((Identifier) ns1.elementAt(0), SETTER, varspaths, entryArray, usedBases, argu);
                rounded = ((NodeOptional) ns1.elementAt(1)).present();

                block.println(indent(indent) + ident.code + setterCasting(ident, new TypedCode(ident.type > typmax ? ident.type : typmax, sb.toString(), TypedCode.COMPLEX)) + (rounded ? ", Root.ROUNDED" : "") + (ident.getBool("is_primitive") ? "" : ")") + ";");
            }
        }

        //

        if (n.f5.present()) {
            throw new RuntimeException("[" + filename + "/" + sectionName + "] MultiplyStatement:: [ [ <ON> ] <SIZE> <ERROR> StatementList() ] no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");
        }

        if (n.f6.present()) {
            throw new RuntimeException("[" + filename + "/" + sectionName + "] MultiplyStatement:: [ <NOT> [ <ON> ] <SIZE> <ERROR> StatementList() ] no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");
        }

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
        }

        return null;
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <OPEN>
     * f1 -> ( <INPUT> ( FileName() [ ( <REVERSED> | [ <WITH> ] <NO> <REWIND> ) ] )+ | <OUTPUT> ( FileName() [ [ <WITH> ] <NO> <REWIND> ] )+ | <I_O> ( FileName() )+ | <EXTEND> ( FileName() )+ )+
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(OpenStatement n, HashMap<String, Object> argu) {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        logger.debug("[" + filename + "/" + sectionName + "] " + n.getClass().getSimpleName() + ":: no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
        }

        return null;
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <PERFORM>
     * f1 -> ( PerformFlavour() StatementList() <END_PERFORM>
     *       | PerformProcedureScopeClause() PerformFlavour()
     *       |                StatementList() <END_PERFORM>
     *       | PerformProcedureScopeClause()
     *       )
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(PerformStatement n, HashMap<String, Object> argu) {

        gen.println();

        switch (n.f1.which) {

        case 0 : // PerformFlavour() StatementList() <END_PERFORM>

            /* PerformFlavour::
             *
             * f0 -> PerformTimeClause()
             *       | [ PerformTestPositionClause() ] ( PerformUntilClause() | PerformVaryingWithAfterClause() )
             */

            /* PerformTimeClause::
             *
             * f0 -> ( Identifier() | IntegerConstant() )
             * f1 -> <TIMES>
             */

            /* PerformTestPositionClause ::
             *
             * f0 -> [ <WITH> ]
             * f1 -> <TEST>
             * f2 -> ( <BEFORE> | <AFTER> )
             */

            /* PerformUntilClause::
             *
             * f0 -> <UNTIL>
             * f1 -> Condition()
             */

            /* PerformVaryingWithAfterClause::
             *
             * f0 -> <VARYING>
             * f1 -> PerformVaryingPhrase()
             * f2 -> ( <AFTER> PerformVaryingPhrase() )*
             */

            /* PerformVaryingPhrase::
             *
             * f0 -> Identifier()
             * f1 -> <FROM>
             * f2 -> ( Identifier() | Literal() )
             * f3 -> <BY>
             * f4 -> ( Identifier() | Literal() )
             * f5 -> PerformUntilClause()
             */

            throw new RuntimeException("[" + filename + "/" + sectionName + "] PerformStatement:: PerformFlavour() StatementList() <END_PERFORM> no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

          //break;

        case 2 : // StatementList() <END_PERFORM>

            logger.debug("[" + filename + "/" + sectionName + "] PerformStatement:: aparecio un StatementList() <END_PERFORM>");

            ((StatementList) ((NodeSequence) n.f1.choice).elementAt(0)).accept(this, argu);

            break;

        case 1 : // PerformProcedureScopeClause() PerformFlavour()

            PerformProcedureScopeClause ppsc = (PerformProcedureScopeClause) ((NodeSequence) n.f1.choice).elementAt(0);
            PerformFlavour              pf   = (PerformFlavour)              ((NodeSequence) n.f1.choice).elementAt(1);

            /* PerformFlavour::
             *
             * f0 -> PerformTimeClause()
             *       | [ PerformTestPositionClause() ] ( PerformUntilClause() | PerformVaryingWithAfterClause() )
             */

            switch (pf.f0.which) {

            case 0 : // PerformTimeClause()

                logger.debug("[" + filename + "/" + sectionName + "] PerformStatement:: aparecio un PerformTimeClause() <END_PERFORM>");

                PerformTimeClause ptc = (PerformTimeClause) pf.f0.choice;

                /* PerformTimeClause::
                 *
                 * f0 -> ( Identifier() | IntegerConstant() )
                 * f1 -> <TIMES>
                 */

                TypedCode value = null;

                switch (ptc.f0.which) {

                case 0 : // Identifier()

                    value = getIdentifier((Identifier) ptc.f0.choice, GETTER, varspaths, entryArray, usedBases, argu);

                    break;

                case 1 : // IntegerConstant()

                    value = ptc.f0.choice.accept(this, argu);

                    break;
                }

                //

                gen.println(indent(indent) + "for (int p = 1; p <= " + value.code + "; p++) {");

                indent++;

                genPerformProcedureScopeClause(gen, ppsc);

                indent--;

                gen.println(indent(indent) + "}");

                break;

            case 1 : // [ PerformTestPositionClause() ] ( PerformUntilClause() | PerformVaryingWithAfterClause() )

                NodeSequence ns  = (NodeSequence) pf.f0.choice;
                NodeOptional no  = (NodeOptional) ns.elementAt(0);
                NodeChoice   nch = (NodeChoice)   ns.elementAt(1);

                if (no.present()) { // [ PerformTestPositionClause() ]

                    /* PerformTestPositionClause ::
                     *
                     * f0 -> [ <WITH> ]
                     * f1 -> <TEST>
                     * f2 -> ( <BEFORE> | <AFTER> )
                     */
                    throw new RuntimeException("[" + filename + "/" + sectionName + "] PerformStatement:: [ PerformTestPositionClause() ] no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");
                }

                switch (nch.which) {

                case 0 : // PerformUntilClause()

                    /* PerformUntilClause::
                     *
                     * f0 -> <UNTIL>
                     * f1 -> Condition()
                     */

                    gen.println(indent(indent) + "do {");

                    indent++;

                    genPerformProcedureScopeClause(gen, ppsc);

                    indent--;

                    TypedCode cond = ((PerformUntilClause) nch.choice).f1.accept(this, argu);

                    gen.println(indent(indent) + "} while (" + cond.code + ");");

                    break;

                case 1 : // PerformVaryingWithAfterClause()

                    /* PerformVaryingWithAfterClause::
                     *
                     * f0 -> <VARYING>
                     * f1 -> PerformVaryingPhrase()
                     * f2 -> ( <AFTER> PerformVaryingPhrase() )*
                     */

                    PerformVaryingWithAfterClause pvwac = (PerformVaryingWithAfterClause) nch.choice;

                    if (pvwac.f2.size() > 0) {
                        throw new RuntimeException("[" + filename + "/" + sectionName + "] PerformStatement:: ( <AFTER> PerformVaryingPhrase() )* no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");
                    }

                    /* PerformVaryingPhrase::
                     *
                     * f0 -> Identifier()
                     * f1 -> <FROM>
                     * f2 -> ( Identifier() | Literal() )
                     * f3 -> <BY>
                     * f4 -> ( Identifier() | Literal() )
                     * f5 -> PerformUntilClause()
                     */

                    /* PerformUntilClause::
                     *
                     * f0 -> <UNTIL>
                     * f1 -> Condition()
                     */

                    TypedCode ident_s = getIdentifier(pvwac.f1.f0, SETTER, varspaths, entryArray, usedBases, argu);
                    TypedCode ident_g = getIdentifier(pvwac.f1.f0, GETTER, varspaths, entryArray, usedBases, argu);

                  //logger.debug("[" + filename + "/" + sectionName + "] ident_s: " + ident_s + "(" + pvwac.f1.f0.accept(tokenVisitor).toString().trim() + ")");

                    //

                    TypedCode from = null;

                    switch (pvwac.f1.f2.which) {

                    case 0 : // Identifier()

                        from = getIdentifier((Identifier) pvwac.f1.f2.choice, GETTER, varspaths, entryArray, usedBases, argu);

                        break;

                    case 1 : // Literal()

                        from = getLiteral((Literal) pvwac.f1.f2.choice, ident_s.type);

                        break;
                    }

                    //

                    TypedCode by = null;

                    switch (pvwac.f1.f4.which) {

                    case 0 : // Identifier()

                        by = getIdentifier((Identifier) pvwac.f1.f4.choice, GETTER, varspaths, entryArray, usedBases, argu);

                        break;

                    case 1 : // Literal()

                        by = getLiteral((Literal) pvwac.f1.f4.choice, ident_s.type);

                        break;
                    }

                    //

                    gen.println(indent(indent) + ident_s.code + setterCasting(ident_s, from) + (ident_s.getBool("is_primitive") ? "" : ")") + ";");
                    gen.println();

                    cond = pvwac.f1.f5.f1.accept(this, argu);

                    gen.println(indent(indent) + "do {");
                    gen.println();

                    indent++;

                    genPerformProcedureScopeClause(gen, ppsc);

                    gen.println();
                    gen.println(indent(indent) + ident_s.code + ident_g.code + " + " + by.code + (ident_s.getBool("is_primitive") ? "" : ")") + ";");
                    gen.println();
                    gen.println(indent(indent) + "if (" + cond.code + ") {");

                    indent++;

                    gen.println(indent(indent) + "break;");

                    indent--;

                    gen.println(indent(indent) + "}");
                    gen.println();

                    indent--;

                    gen.println(indent(indent) + "} while (true);");

                    break;
                }

                break;
            }

            break;

        case 3 : // PerformProcedureScopeClause()

            genPerformProcedureScopeClause(gen, (PerformProcedureScopeClause) n.f1.choice);

            break;
        }

        //

        return null;
    }

    /******************************************************************************
     *
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
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(ReadStatement n, HashMap<String, Object> argu) {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        logger.debug("[" + filename + "/" + sectionName + "] " + n.getClass().getSimpleName() + ":: no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
        }

        return null;
    }

    /******************************************************************************
     *
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
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(ReleaseStatement n, HashMap<String, Object> argu) {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        logger.debug("[" + filename + "/" + sectionName + "] " + n.getClass().getSimpleName() + ":: no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
        }

        return null;
    }

    /******************************************************************************
     *
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
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(ReturnStatement n, HashMap<String, Object> argu) {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        logger.debug("[" + filename + "/" + sectionName + "] " + n.getClass().getSimpleName() + ":: no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
        }

        return null;
    }

    /******************************************************************************
     *
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
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(RewriteStatement n, HashMap<String, Object> argu) {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        logger.debug("[" + filename + "/" + sectionName + "] " + n.getClass().getSimpleName() + ":: no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
        }

        return null;
    }

    /******************************************************************************
     *
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
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(SearchStatement n, HashMap<String, Object> argu) {

        if (n.f1.present()) { // [ <ALL> ]
            throw new RuntimeException("[" + filename + "/" + sectionName + "] SearchStatement:: [ <ALL> ] no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");
        }

        gen.println();

        TypedCode table_sz   = getIdentifier(n.f2, SIZER,  varspaths, entryArray, usedBases, argu);
        TypedCode iterator_g = null;
        TypedCode iterator_s = null;

        if (n.f3.present()) { // [ <VARYING> Identifier() ]

            NodeSequence ns = (NodeSequence) n.f3.node;

            iterator_g = getIdentifier((Identifier) ns.elementAt(1), GETTER, varspaths, entryArray, usedBases, argu);
            iterator_s = getIdentifier((Identifier) ns.elementAt(1), SETTER, varspaths, entryArray, usedBases, argu);
        }
        else {

            DataEntryDesc entry = getDataEntryByIdentifier(n.f2, varspaths, entryArray, usedBases, argu);

          //logger.debug("[" + filename + "/" + sectionName + "] entry:" + entry.indexer);

            iterator_g = new TypedCode(TypedCode.INTEGER, lowerCamelCase(entry.indexer),         TypedCode.SIMPLE, 6, new HashMap<String, Object>());
            iterator_s = new TypedCode(TypedCode.INTEGER, lowerCamelCase(entry.indexer) + " = ", TypedCode.SIMPLE, 6, new HashMap<String, Object>());
        }

        //

        boolean next_sentence = false;

        for (int i = 0; i < n.f5.size(); i++) {

            if (((NodeChoice) (NodeChoice) ((NodeSequence) n.f5.elementAt(i)).elementAt(2)).which == 1 /*<NEXT> <SENTENCE>*/) {

                next_sentence = true;

                break;
            }
        }

        //

        if (next_sentence) {

            gen.println(indent(indent) + (!at_end_defined ? "boolean " : "") + "at_end = true;");

            if (!at_end_defined) {
                at_end_defined = true;
            }

            gen.println();
        }

        gen.println(indent(indent) + "for ( ; " + iterator_g.code + " <= " + table_sz.code + "; " + iterator_s.code + iterator_g.code + " + 1)) {");

        indent++;

        for (int i = 0; i < n.f5.size(); i++) {

            NodeSequence ns   = (NodeSequence) n.f5.elementAt(i); // <WHEN> Condition() ( StatementList() | <NEXT> <SENTENCE> )
            TypedCode    cond = ((Condition) ns.elementAt(1)).accept(this, argu);

            gen.println();
            gen.println(indent(indent) + "if (" + cond.code + ") {");

            indent++;

            NodeChoice nch = (NodeChoice) ns.elementAt(2);

            switch (nch.which) {

            case 0 : // StatementList()

                ((StatementList) nch.choice).accept(this, argu);

                break;

            case 1 : // <NEXT> <SENTENCE>

                if (next_sentence) {
                    gen.println();
                    gen.println(indent(indent) + "at_end = false;");
                }

                gen.println();
                gen.println(indent(indent) + "break;");

                break;
            }

            indent--;

            gen.println(indent(indent) + "}");
        }

        indent--;

        gen.println(indent(indent) + "}");

        //

        if (n.f4.present()) { // [ [ <AT> ] <END> StatementList() ]

            if (next_sentence) {

                gen.println();
                gen.println(indent(indent) + "if (at_end) {");

                indent++;
            }

            NodeSequence  ns = (NodeSequence) n.f4.node;
            StatementList sl = (StatementList) ns.elementAt(2);

            sl.accept(this, argu);

            if (next_sentence) {

                indent--;

                gen.println(indent(indent) + "}");
            }
        }

        //

        return null;
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <SET>
     * f1 -> [ <CONFIGURATION> ]
     * f2 -> ( Identifier() | Literal() )
     * f3 -> ( [ <COMMACHAR> ] Identifier() | Literal() )*
     * f4 -> ( <TO> [ <CONFIGURATION> ] ( Identifier()
     *                                  | <TRUE>
     *                                  | <FALSE>
     *                                  | <ON>
     *                                  | <OFF>
     *                                  | [ <ENTRY> ] Literal()
     *                                  )
     *       | ( <UP> | <DOWN> ) [ <BY> ] ( Identifier() | Literal() )
     *       )
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(SetStatement n, HashMap<String, Object> argu) {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        block.println();

        if (n.f1.present()) {
            throw new RuntimeException("[" + filename + "/" + sectionName + "] SetStatement:: [ <CONFIGURATION> ] no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");
        }

        TypedCode ident = null;
        TypedCode value = null;

        NodeSequence ns = (NodeSequence) n.f4.choice;

        switch (n.f4.which) {

        /******************************************************************************
         *
         ******************************************************************************/

        case 0 : // <TO> [ <CONFIGURATION> ] ( Identifier() | <TRUE> | <FALSE> | <ON> | <OFF> | [ <ENTRY> ] Literal() )

            if (((NodeOptional) ns.elementAt(1)).present()) {
                throw new RuntimeException("[" + filename + "/" + sectionName + "] SetStatement:: [ <CONFIGURATION> ] no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");
            }

            NodeChoice nch = (NodeChoice) ns.elementAt(2); // ( Identifier() | <TRUE> | <FALSE> | <ON> | <OFF> | [ <ENTRY> ] Literal() )

            switch (nch.which) {

            case 0 : // Identifier()

                value = getIdentifier((Identifier) nch.choice, GETTER, varspaths, entryArray, usedBases, argu);

                break;

            case 1 : // <TRUE>
            case 3 : // <ON>

                value = new TypedCode(TypedCode.BOOLEAN, "true", TypedCode.SIMPLE);

                break;

            case 2 : // <FALSE>
            case 4 : // <OFF>

                value = new TypedCode(TypedCode.BOOLEAN, "false", TypedCode.SIMPLE);

                break;

            case 5 : // [ <ENTRY> ] Literal()

                NodeSequence ns1 = (NodeSequence) nch.choice;

                if (((NodeOptional) ns1.elementAt(0)).present()) { // [ <ENTRY> ]
                    throw new RuntimeException("[" + filename + "/" + sectionName + "] SetStatement:: [ <ENTRY> ] no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");
                }

                value = getLiteral((Literal) ns1.elementAt(1), TypedCode.UNDEF);

                break;
            }

            //
            // f2 -> ( Identifier() | Literal() )
            //

            switch (n.f2.which) {

            case 0 : // Identifier()

                ident = getIdentifier((Identifier) n.f2.choice, SETTER, varspaths, entryArray, new ArrayList<DataEntryDesc>(), argu);

                break;

            case 1 : // Literal()

                throw new RuntimeException("[" + filename + "/" + sectionName + "] SetStatement:: Literal() no deberia ser setter {" + n.accept(tokenVisitor).toString().trim() + "}");
            }

            //

            block.println(indent(indent) + ident.code + setterCasting(ident, value) + (ident.getBool("is_primitive") ? "" : ")") + ";");

            for (int i = 0; i < n.f3.size(); i++) {

                nch = (NodeChoice) n.f3.elementAt(i); // [ <COMMACHAR> ] Identifier() | Literal()

                switch (nch.which) {

                case 0: // [ <COMMACHAR> ] Identifier()

                    NodeSequence ns2 = (NodeSequence) nch.choice;

                    ident = getIdentifier((Identifier) ns2.elementAt(1), SETTER, varspaths, entryArray, usedBases, argu);

                    if (nch.which == 5) { // [ <ENTRY> ] Literal()
                        value = getLiteral((Literal) ((NodeSequence) nch.choice).elementAt(1), ident.type);
                    }

                    block.println(indent(indent) + ident.code + setterCasting(ident, value) + (ident.getBool("is_primitive") ? "" : ")") + ";");

                    break;

                case 1: // Literal()

                    throw new RuntimeException("[" + filename + "/" + sectionName + "] SetStatement:: Literal() no deberia ser setter {" + n.accept(tokenVisitor).toString().trim() + "}");
                }
            }

            break;

        /******************************************************************************
         *
         ******************************************************************************/

        case 1 : // ( <UP> | <DOWN> ) [ <BY> ] ( Identifier() | Literal() )

            //
            // f2 -> ( Identifier() | Literal() )
            //

            TypedCode getter = null;

            switch (n.f2.which) {

            case 0 : // Identifier()

                ident  = getIdentifier((Identifier) n.f2.choice, SETTER, varspaths, entryArray, usedBases, argu);
                getter = getIdentifier((Identifier) n.f2.choice, GETTER, varspaths, entryArray, usedBases, argu);

                break;

            case 1 : // Literal()

                throw new RuntimeException("[" + filename + "/" + sectionName + "] SetStatement:: Literal() no puede ser l-value {" + n.accept(tokenVisitor).toString().trim() + "}");
            }

            //

            nch = (NodeChoice) ns.elementAt(0);

            String op = null;

            switch (nch.which) {
            case 0 : // <UP>
                op = " + ";
                break;
            case 1 : // <DOWN>
                op = " - ";
                break;
            }

            //

            nch = (NodeChoice) ns.elementAt(2);

            switch (nch.which) {

            case 0 : // Identifier()

                value = getIdentifier((Identifier) nch.choice, GETTER, varspaths, entryArray, usedBases, argu);

                break;

            case 1 : // Literal()

                value = getLiteral((Literal) nch.choice, ident.type);

                break;
            }

            //

            block.println(indent(indent) + ident.code + setterCasting(ident, new TypedCode(ident.type > value.type ? ident.type : value.type, getter.code + op + value.code, TypedCode.COMPLEX)) + (ident.getBool("is_primitive") ? "" : ")") + ";");

            for (int i = 0; i < n.f3.size(); i++) {

                NodeChoice nch1 = (NodeChoice) n.f3.elementAt(i); // [ <COMMACHAR> ] Identifier() | Literal()

                switch (nch1.which) {

                case 0: // [ <COMMACHAR> ] Identifier()

                    NodeSequence ns1 = (NodeSequence) nch1.choice;

                    ident  = getIdentifier((Identifier) ns1.elementAt(1), SETTER, varspaths, entryArray, usedBases, argu);
                    getter = getIdentifier((Identifier) ns1.elementAt(1), GETTER, varspaths, entryArray, usedBases, argu);

                    if (nch.which == 1) { // Literal()
                        value = getLiteral((Literal) nch.choice, ident.type);
                    }

                    block.println(indent(indent) + ident.code + setterCasting(ident, new TypedCode(ident.type > value.type ? ident.type : value.type, getter.code + op + value.code, TypedCode.COMPLEX)) + (ident.getBool("is_primitive") ? "" : ")") + ";");

                    break;

                case 1: // Literal()

                    throw new RuntimeException("[" + filename + "/" + sectionName + "] SetStatement:: Literal() no puede ser l-value {" + n.accept(tokenVisitor).toString().trim() + "}");
                }
            }

            break;
        }

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
        }

        return null;
    }

    /******************************************************************************
     *
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
     * f5 -> ( <USING>  ( FileName() )+ | <INPUT>  <PROCEDURE> [ <IS> ] ProcedureName() [ ( <THROUGH> | <THRU> ) ProcedureName() ] )
     * f6 -> ( <GIVING> ( FileName() )+ | <OUTPUT> <PROCEDURE> [ <IS> ] ProcedureName() [ ( <THROUGH> | <THRU> ) ProcedureName() ] )
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(SortStatement n, HashMap<String, Object> argu) {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        logger.debug("[" + filename + "/" + sectionName + "] " + n.getClass().getSimpleName() + ":: no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
        }

        return null;
    }

    /******************************************************************************
     *
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
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(StartStatement n, HashMap<String, Object> argu) {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        logger.debug("[" + filename + "/" + sectionName + "] " + n.getClass().getSimpleName() + ":: no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
        }

        return null;
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <STOP>
     * f1 -> ( <RUN> | Literal() )
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(StopStatement n, HashMap<String, Object> argu) {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        block.println();

        if (n.f1.which == 1) { // Literal()
            throw new RuntimeException("[" + filename + "/" + sectionName + "] StopStatement:: Literal() no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");
        }

        block.println(indent(indent) + "System.exit(returnCode);");

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
        }

        return null;
    }

    /******************************************************************************
     *
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
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(StringStatement n, HashMap<String, Object> argu) {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        logger.debug("[" + filename + "/" + sectionName + "] " + n.getClass().getSimpleName() + ":: no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

      //argu.put(TypedCode.TYPE_EXPECTED, new Integer(TypedCode.UNDEF));

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
        }

        return null;
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <SUBTRACT>
     * f1 -> ( ( Identifier() | Literal() )+ <FROM> ( ( Identifier() | Literal() ) [ <ROUNDED> ] )+ [ <GIVING> ( Identifier() [ <ROUNDED> ] )+ ]
     *       | ( <CORRESPONDING> | <CORR> ) Identifier() <FROM> Identifier() [ <ROUNDED> ]
     *       )
     * f2 -> [       [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f3 -> [ <NOT> [ <ON> ] <SIZE> <ERROR> StatementList() ]
     * f4 -> [ <END_SUBTRACT> ]
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(SubtractStatement n, HashMap<String, Object> argu)  {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        block.println();

        NodeSequence ns    = (NodeSequence) n.f1.choice;
        NodeChoice   nch   = null;
        TypedCode    ident = null;
        boolean      rounded;

        switch (n.f1.which) {

        /******************************************************************************
         *
         ******************************************************************************/

        case 0 : // ( Identifier() | Literal() )+ <FROM> ( ( Identifier() | Literal() ) [ <ROUNDED> ] )+ [ <GIVING> ( Identifier() [ <ROUNDED> ] )+ ]

            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            //
            // ( Identifier() | Literal() )+
            //

            StringBuffer sb         = new StringBuffer();
            NodeList     nl         = (NodeList) ns.elementAt(0);
            TypedCode    sustraendo = null;
            int          typmax     = TypedCode.INTEGER;

            for (int i = 0; i < nl.size(); i++) { // ( Identifier() | Literal() )+

                if (i > 0) {
                    sb.append(" - ");
                }

                nch = (NodeChoice) nl.elementAt(i); // ( Identifier() | Literal() )

                switch (nch.which) {

                case 0 : // Identifier()

                    sustraendo = getIdentifier((Identifier) nch.choice, GETTER, varspaths, entryArray, usedBases, argu);

                    break;

                case 1 : // Literal()

                    sustraendo = getLiteral((Literal) nch.choice, TypedCode.UNDEF);

                    break;
                }

                sb.append(sustraendo.code);

                if (sustraendo.type > typmax) {
                    typmax = sustraendo.type;
                }
            }

            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            //
            // [ <GIVING> ( Identifier() [ <ROUNDED> ] )+ ]
            //

            NodeList     nl1      = (NodeList)     ns.elementAt(2);
            NodeOptional no       = (NodeOptional) ns.elementAt(3);
            TypedCode    minuendo = null;
            TypedCode    getter   = null;

            if (no.present()) {

                if (nl1.size() > 1) {
                    throw new RuntimeException("[" + filename + "/" + sectionName + "] SubtractStatement:: en formato con <GIVING>, lista <FROM> debe tener solo un elemento {" + nl1.accept(tokenVisitor).toString().trim() + "}");
                }

                NodeSequence ns1 = (NodeSequence) nl1.elementAt(0); // ( Identifier() | Literal() ) [ <ROUNDED> ];

                nch = (NodeChoice) ns1.elementAt(0); // ( Identifier() | Literal() )

                switch (nch.which) {

                case 0 : // Identifier()

                    minuendo = getIdentifier((Identifier) nch.choice, GETTER, varspaths, entryArray, usedBases, argu);

                    break;

                case 1 : // Literal()

                    minuendo = getLiteral((Literal) nch.choice, TypedCode.UNDEF);

                    break;
                }

                //

                NodeList     nl2 = (NodeList) ((NodeSequence) no.node).elementAt(1); // ( Identifier() [ <ROUNDED> ] )+
                NodeSequence ns2 = null;

                for (int i = 0; i < nl2.size(); i++) {

                    ns2     = (NodeSequence)  nl2.elementAt(i); //   Identifier() [ <ROUNDED> ]
                    rounded = ((NodeOptional) ns2.elementAt(1)).present();
                    ident   = getIdentifier((Identifier) ns2.elementAt(0), SETTER, varspaths, entryArray, usedBases, argu);

                    block.println(indent(indent) + ident.code + setterCasting(ident, new TypedCode(ident.type > typmax ? ident.type : typmax, minuendo.code + " - " + sb.toString(), TypedCode.COMPLEX)) + (rounded ? ", Root.ROUNDED" : "") + (ident.getBool("is_primitive") ? "" : ")") + ";");
                  //block.println();
                }
            }
            else {

                /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                // ( ( Identifier() | Literal() ) [ <ROUNDED> ] )+

                for (int i = 0; i < nl1.size(); i++) {

                    NodeSequence ns1 = (NodeSequence) nl1.elementAt(i); // ( Identifier() | Literal() ) [ <ROUNDED> ]

                    rounded = ((NodeOptional) ns1.elementAt(1)).present();
                    nch     = (NodeChoice) ns1.elementAt(0); // ( Identifier() | Literal() )

                    switch (nch.which) {

                    case 0 : // Identifier()

                        ident  = getIdentifier((Identifier) nch.choice, SETTER, varspaths, entryArray, usedBases, argu);
                        getter = getIdentifier((Identifier) nch.choice, GETTER, varspaths, entryArray, usedBases, argu);

                        block.println(indent(indent) + ident.code + setterCasting(ident, new TypedCode(ident.type > typmax ? ident.type : typmax, getter.code + " - " + sb.toString(), TypedCode.COMPLEX)) + (rounded ? ", Root.ROUNDED" : "") + (ident.getBool("is_primitive") ? "" : ")") + ";");
                      //block.println();

                        break;

                    case 1 : // Literal()

                        throw new RuntimeException("[" + filename + "/" + sectionName + "] SubtractStatement:: minuendo no puede ser literal {" + n.accept(tokenVisitor).toString().trim() + "}");
                    }
                }
            }

            break;

        /******************************************************************************
         *
         ******************************************************************************/

        case 1 : // ( <CORRESPONDING> | <CORR> ) Identifier() <FROM> Identifier() [ <ROUNDED> ]

            DataEntryDesc source = getDataEntryByIdentifier((Identifier) ns.elementAt(1), varspaths, entryArray, usedBases, argu);
            DataEntryDesc target = getDataEntryByIdentifier((Identifier) ns.elementAt(3), varspaths, entryArray, usedBases, argu);

            rounded = ((NodeOptional) ns.elementAt(4)).present();

            if (source.childs != null && target.childs != null) {

                TypedCode value  = null;
                int       idx    = -1;
                String    code   = null;

                for (int i = 0; i < target.childs.size(); i++) {

                    if ((idx = existInArray(source.childs, target.childs.get(i).name)) != -1) {

                        ident = new TypedCode(target.childs.get(i).type, target.addendum + ".set" + camelCase(target.childs.get(i)  .name) + "(", TypedCode.SIMPLE,  target.childs.get(i).totalLen, new HashMap<String, Object>());

                        //

                        code = target.addendum + ".get" + camelCase(target.childs.get(i).name) + "()" + " - ";

                        switch (target.childs.get(i).type) {

                        ////////////////////////////////////////////////////////////////
                        //
                        ////////////////////////////////////////////////////////////////

                        case DataEntryDesc.INTEGER :
                        case DataEntryDesc.LONG :

                            switch (source.childs.get(idx).type) {

                            case DataEntryDesc.INTEGER :
                            case DataEntryDesc.LONG :

                                code += (source.childs.get(idx).type > target.childs.get(i).type ? "(" + DataEntryDesc.javaNames[target.childs.get(i).type] + ") " : "")  + source.addendum + ".get" + camelCase(source.childs.get(idx).name) + "()";

                                break;

                            case DataEntryDesc.DOUBLE :

                                if (rounded) {
                                    code += "(" + DataEntryDesc.javaNames[target.childs.get(i).type] + ") Math.round(" + source.addendum + ".get" + camelCase(source.childs.get(idx).name) + "())";
                                }
                                else {
                                    code += "(" + DataEntryDesc.javaNames[target.childs.get(i).type] + ") "            + source.addendum + ".get" + camelCase(source.childs.get(idx).name) + "()";
                                }

                                break;
                            }

                            value = new TypedCode(target.childs.get(i).type, code, TypedCode.COMPLEX, target.childs.get(i).totalLen, new HashMap<String, Object>());

                            block.println(indent(indent) + ident.code + setterCasting(ident, value) + (ident.getBool("is_primitive") ? "" : ")") + ";");

                            break;

                        ////////////////////////////////////////////////////////////////
                        //
                        ////////////////////////////////////////////////////////////////

                        case DataEntryDesc.DOUBLE :

                            code += source.addendum + ".get" + camelCase(source.childs.get(idx).name) + "()";

                            value = new TypedCode(target.childs.get(i).type, code, TypedCode.COMPLEX, target.childs.get(i).totalLen, new HashMap<String, Object>());

                            block.println(indent(indent) + ident.code + setterCasting(ident, value) + (rounded ? ", Root.ROUNDED" : "") + (ident.getBool("is_primitive") ? "" : ")") + ";");

                            break;
                        }
                    }
                }

              //block.println();
            }

            break;
        }

        //

        if (n.f2.present()) {
            throw new RuntimeException("[" + filename + "/" + sectionName + "] SubtractStatement:: [ [ <ON> ] <SIZE> <ERROR> StatementList() ] no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");
        }

        if (n.f3.present()) {
            throw new RuntimeException("[" + filename + "/" + sectionName + "] SubtractStatement:: [ <NOT> [ <ON> ] <SIZE> <ERROR> StatementList() ] no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");
        }

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
        }

        return null;
    }

    /******************************************************************************
     *
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
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(UnstringStatement n, HashMap<String, Object> argu) {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        logger.debug("[" + filename + "/" + sectionName + "] " + n.getClass().getSimpleName() + ":: no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
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
     * f0 -> <USE>
     * f1 -> ( [ <FOR> ] <DEBUGGING> [ <ON> ] ( ( ProcedureName() )+ | <ALL> ( <PROCEDURES> | <REFERENCES> <OF> DataName() ) ) | [ <GLOBAL> ] <AFTER> [ <STANDARD> ] ( ( <EXCEPTION> | <ERROR> ) | [ ( <BEGINNING> | <ENDING> ) ] [ ( <FILE> | <REEL> | <UNIT> ) ] <LABEL> ) <PROCEDURE> [ <ON> ] ( ( FileName() )+ | <INPUT> | <OUTPUT> | <I_O> | <EXTEND> ) )
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(UseStatement n, HashMap<String, Object> argu) {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        logger.debug("[" + filename + "/" + sectionName + "] " + n.getClass().getSimpleName() + ":: no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
        }

        return null;
    }

    /******************************************************************************
     *
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
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(WriteStatement n, HashMap<String, Object> argu) {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        logger.debug("[" + filename + "/" + sectionName + "] " + n.getClass().getSimpleName() + ":: no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
        }

        return null;
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <SERVICE>
     * f1 -> <LABEL>
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(ServiceStatement n, HashMap<String, Object> argu) {

        settingSetterVariables(argu);

        ByteArrayOutputStream baos  = new ByteArrayOutputStream();
        PrintStream           block = new PrintStream(baos);

        //
        //

        logger.debug("[" + filename + "/" + sectionName + "] " + n.getClass().getSimpleName() + ":: no implementada aun {" + n.accept(tokenVisitor).toString().trim() + "}");

        //

        block.close();

        if (params.path("testing_values").asBoolean(false)) {
            printSetterVariables(gen, (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES), new Node[] { n });
        }

        gen.print(new String(baos.toByteArray()));

        if (params.path("testing_values").asBoolean(false)) {
            printGetterVariables(gen, (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES));
        }

        return null;
    }

    //
    //
    //

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param argu TODO_javadoc.
     *
     */
    private void settingSetterVariables(HashMap<String, Object> argu) {

        if (params.path("testing_values").asBoolean(false)) {

            argu.put(SETTER_VARIABLES, new ArrayList<TypedCode>());
            argu.put(GETTER_VARIABLES, new ArrayList<TypedCode>());
        }
        else {

            argu.remove(SETTER_VARIABLES);
            argu.remove(GETTER_VARIABLES);
        }
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param gen TODO_javadoc.
     * @param setterVariables TODO_javadoc.
     * @param nodes TODO_javadoc.
     *
     */
    private void printSetterVariables(PrintStream gen, ArrayList<TypedCode> setterVariables, Node[] nodes) {

      //logger.debug("entrando a 'printSetterVariables(" + setterVariables.size() + ")' ...");

        if (setterVariables.size() > 0) {

            gen.println();
            gen.println(indent(indent) + "//// setters /////////////////////////////////////////////////////////////////////////////////");

            TypedCode ident = null;
            TypedCode value = null;

            for (int i = 0; i < setterVariables.size(); i++) {

                ident = setterVariables.get(i);
                value = getDefaultValue(ident.type, ident.size);

                gen.println(indent(indent) + "//" + ident.code + setterCasting(ident, value) + (ident.getBool("is_primitive") ? "" : ")") + ";");
            }

            gen.println(indent(indent) + "//////////////////////////////////////////////////////////////////////////////////////////////");
        }
        else {
        }

        gen.println(indent(indent) + "logger.debug(\"%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\");");
        gen.println(indent(indent) + "logger.debug(\"%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\");");

        StringBuffer sb = new StringBuffer();

        for (Node node : nodes) {
            sb.append(node.accept(tokenVisitor));
        }

        gen.println(indent(indent) + "logger.debug(\"" + scape(sb.toString().trim()) + "\");");
        gen.println(indent(indent) + "logger.debug(\"%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\");");
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param gen TODO_javadoc.
     * @param getterVariables TODO_javadoc.
     *
     */
    private void printGetterVariables(PrintStream gen, ArrayList<TypedCode> getterVariables) {

      //logger.debug("entrando a 'printGetterVariables(" + getterVariables.size() + ")' ...");

        if (getterVariables.size() > 0) {

            gen.println();
            gen.println(indent(indent) + "logger.debug(\"%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\");");
            gen.println(indent(indent) + "logger.debug(\"%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\");");

            TypedCode ident = null;

            for (int i = 0; i < getterVariables.size(); i++) {

                ident = getterVariables.get(i);

                gen.println(indent(indent) + "logger.debug(\"" + ident.code + " :\" + " + ident.code + ");");
            }

            gen.println(indent(indent) + "logger.debug(\"%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\");");
        }
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * ns -> ( <AND> | <OR> ) ( CombinableCondition() | AbbreviationRest() )
     *
     * @param ns TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private boolean isAbbreviationRest(NodeSequence ns) {

        NodeChoice nch = (NodeChoice) ns.elementAt(1);

        return nch.which == 1;
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param type TODO_javadoc.
     * @param length TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private TypedCode getDefaultValue(int type, int length) {

        switch (type) {
        case TypedCode.INTEGER :
            return new TypedCode(type, "0", TypedCode.SIMPLE);
        case TypedCode.LONG :
            return new TypedCode(type, "0L", TypedCode.SIMPLE);
        case TypedCode.DOUBLE :
            return new TypedCode(type, "0D", TypedCode.SIMPLE);
        case TypedCode.STRING :
            return new TypedCode(type, "\"" + genSpaces(length)+ "\"", TypedCode.SIMPLE);
        case TypedCode.BOOLEAN :
            return new TypedCode(type, "0", TypedCode.SIMPLE);
        case TypedCode.UNDEF :
            throw new RuntimeException("getDefaultValue:: se intento obtener valor default para tipo UNDEF.");
        }

        return null;
    }

    /******************************************************************************
     *
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
     * @return TODO_javadoc.
     *
     */
    private boolean flowOnlyExits(Paragraph n) {

        boolean only_exits = true;

        for (int i = 0; i < n.f2.size(); i++) { // ExitStatement() | AlteredGoto() | Sentence()

            switch (((NodeChoice) n.f2.elementAt(i)).which) {

            case 1: // AlteredGoto()
            case 2: // Sentence

                only_exits = false;

                break;
            }
        }

        return only_exits;
    }

    /******************************************************************************
     *
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
     * @return TODO_javadoc.
     *
     */
    private boolean flowInterruption(Paragraph n) {

        NodeChoice nch = null;

        for (int i = 0; i < n.f2.size(); i++) { // ExitStatement() | AlteredGoto() | Sentence()

            nch = (NodeChoice) n.f2.elementAt(i);

            switch (nch.which) {
            case 0: // ExitStatement()
            case 1: // AlteredGoto()
                return true;
            case 2: // Sentence

                if (flowInterruption((Sentence) nch.choice)) {
                    return true;
                }
            }
        }

        return false;
    }

    /******************************************************************************
     *
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
     * @return TODO_javadoc.
     *
     */
    private boolean flowInterruption(Sentence n) {

        for (int i = 0; i < n.f0.f0.size(); i++) { // ( Statement() )+

            Statement stmt = (Statement) n.f0.f0.elementAt(i);

            switch (((NodeChoice) stmt.f0).which) {
            case 14 : // ExitProgramStatement()  // return null;
            case 15 : // GobackStatement()       // return null;
            case 33 : // StopStatement()         // return null;

            case 16 : // GotoStatement()
                return true;
            /*
            case  0 : // AcceptStatement()
            case  1 : // AddStatement()
            case  2 : // AlterStatement()
            case  3 : // CallStatement()
            case  4 : // CancelStatement() ??????
            case  5 : // CloseStatement()
            case  6 : // ComputeStatement()
            case  7 : // ContinueStatement()
            case  8 : // DeleteStatement()
            case  9 : // DisplayStatement()
            case 10 : // DivideStatement()
            case 11 : // EntryStatement()
            case 12 : // EvaluateStatement()
            case 13 : // ExecStatement()
            case 17 : // IfStatement()
            case 18 : // InitializeStatement()
            case 19 : // InspectStatement()
            case 20 : // MergeStatement()
            case 21 : // MoveStatement()
            case 22 : // MultiplyStatement()
            case 23 : // OpenStatement()
            case 24 : // PerformStatement()
            case 25 : // ReadStatement()
            case 26 : // ReleaseStatement()
            case 27 : // ReturnStatement()
            case 28 : // RewriteStatement()
            case 29 : // SearchStatement()
            case 30 : // SetStatement()
            case 31 : // SortStatement()
            case 32 : // StartStatement()
            case 34 : // StringStatement()
            case 35 : // SubtractStatement()
            case 36 : // UnstringStatement()
            case 37 : // WriteStatement()
            case 38 : // ServiceStatement()
            */
            }
        }

        return false;
    }

    /******************************************************************************
     *
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
     * @return TODO_javadoc.
     *
     */
    private boolean systemExit(Paragraph n) {

        NodeChoice nch = null;

        for (int i = 0; i < n.f2.size(); i++) { // ExitStatement() | AlteredGoto() | Sentence()

            nch = (NodeChoice) n.f2.elementAt(i);

            switch (nch.which) {

            case 2: // Sentence

                if (systemExit((Sentence) nch.choice)) {
                    return true;
                }
            }
        }

        return false;
    }

    /******************************************************************************
     *
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
     * @return TODO_javadoc.
     *
     */
    private boolean systemExit(Sentence n) {

        for (int i = 0; i < n.f0.f0.size(); i++) { // ( Statement() )+

            Statement stmt = (Statement) n.f0.f0.elementAt(i);

            switch (((NodeChoice) stmt.f0).which) {
            case 14 : // ExitProgramStatement()
            case 15 : // GobackStatement()
            case 33 : // StopStatement()
                return true;
            /*
            case  0 : // AcceptStatement()
            case  1 : // AddStatement()
            case  2 : // AlterStatement()
            case  3 : // CallStatement()
            case  4 : // CancelStatement() ??????
            case  5 : // CloseStatement()
            case  6 : // ComputeStatement()
            case  7 : // ContinueStatement()
            case  8 : // DeleteStatement()
            case  9 : // DisplayStatement()
            case 10 : // DivideStatement()
            case 11 : // EntryStatement()
            case 12 : // EvaluateStatement()
            case 13 : // ExecStatement()
            case 16 : // GotoStatement()
            case 17 : // IfStatement()
            case 18 : // InitializeStatement()
            case 19 : // InspectStatement()
            case 20 : // MergeStatement()
            case 21 : // MoveStatement()
            case 22 : // MultiplyStatement()
            case 23 : // OpenStatement()
            case 24 : // PerformStatement()
            case 25 : // ReadStatement()
            case 26 : // ReleaseStatement()
            case 27 : // ReturnStatement()
            case 28 : // RewriteStatement()
            case 29 : // SearchStatement()
            case 30 : // SetStatement()
            case 31 : // SortStatement()
            case 32 : // StartStatement()
            case 34 : // StringStatement()
            case 35 : // SubtractStatement()
            case 36 : // UnstringStatement()
            case 37 : // WriteStatement()
            case 38 : // ServiceStatement()
            */
            }
        }

        return false;
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param n TODO_javadoc.
     * @param type_expected TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private TypedCode getLiteral(Literal n, int type_expected) {

        HashMap<String, Object> argu = new HashMap<String, Object>();

        argu.put(TypedCode.TYPE_EXPECTED, new Integer(type_expected));

        return n.accept(this, argu);
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param array TODO_javadoc.
     * @param name TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private int existInArray(ArrayList<DataEntryDesc> array, String name) {

        if (array == null || name == null) {
            return -1;
        }

        for (int i = 0; i < array.size(); i++) {

            if (array.get(i) != null && array.get(i).name != null && array.get(i).name.equals(name)) {
                return i;
            }
        }

        return -1;
    }

    /******************************************************************************
     * ifStatementWithNextSentence
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
    private boolean ifStatementWithNextSentence(IfStatement n) {

        if (n.f3.which == 1) { // <NEXT> <SENTENCE>
            return true;
        }

        if (n.f4.present()) {

            if (((NodeChoice) ((NodeSequence) n.f4.node).elementAt(1)).which == 1) { // <NEXT> <SENTENCE>
                return true;
            }
        }

        return false;
    }

    /******************************************************************************
     * setterCasting
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param ident TODO_javadoc.
     * @param value TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private String setterCasting(TypedCode ident, TypedCode value) {

      //logger.debug("[" + filename + "/" + sectionName + "] entrando a 'setterCasting(ident.type: " + TypedCode.typesNames[ident.type] + ", value.type: " + TypedCode.typesNames[value.type] + ")' ...");

        if (ident.isNumeric() != value.isNumeric()) {

            switch (ident.type) {

            case TypedCode.INTEGER :

                switch (value.type) {

                case TypedCode.BOOLEAN :

                    if (value.aggregation == TypedCode.COMPLEX) {
                        return "(" + value.code + ") ? 1 : 0";
                    }
                    else {
                        return       value.code +  " ? 1 : 0";
                    }

                case TypedCode.STRING  :
                    return "Integer.parseInt(" + value.code + ")";
                }

            case TypedCode.LONG :

                switch (value.type) {

                case TypedCode.BOOLEAN :

                    if (value.aggregation == TypedCode.COMPLEX) {
                        return "(" + value.code + ") ? 1L : 0L";
                    }
                    else {
                        return       value.code +  " ? 1L : 0L";
                    }

                case TypedCode.STRING  :
                    return "Long.parseLong(" + value.code + ")";
                }

            case TypedCode.DOUBLE :

                switch (value.type) {

                case TypedCode.BOOLEAN :

                    if (value.aggregation == TypedCode.COMPLEX) {
                        return "(" + value.code + ") ? 1.0D : 0.0D";
                    }
                    else {
                        return       value.code +  " ? 1.0D : 0.0D";
                    }

                case TypedCode.STRING  :
                    return "(" + value.code + ")";
                }

            case TypedCode.BOOLEAN :

                switch (value.type) {

                case TypedCode.INTEGER :

                    if (value.aggregation == TypedCode.COMPLEX) {
                        return "(" + value.code + ") != 0";
                    }
                    else {
                        return       value.code +  " != 0";
                    }

                case TypedCode.LONG :

                    if (value.aggregation == TypedCode.COMPLEX) {
                        return "(" + value.code + ") != 0L";
                    }
                    else {
                        return       value.code +  " != 0L";
                    }

                case TypedCode.DOUBLE :

                    if (value.aggregation == TypedCode.COMPLEX) {
                        return "(" + value.code + ") != 0.0D";
                    }
                    else {
                        return       value.code +  " != 0.0D";
                    }

                case TypedCode.STRING  :

                    if (value.aggregation == TypedCode.COMPLEX) {
                        return "(" + value.code + ").trim().compareToIgnoreCase(\"true\")";
                    }
                    else {
                        return       value.code +  ".trim().compareToIgnoreCase(\"true\")";
                    }
                }

            case TypedCode.STRING  :

                switch (value.type) {

                case TypedCode.INTEGER :

                    return "Util.intToString("    + value.code + ", " + ident.size + ")";

                case TypedCode.LONG :

                    return "Util.longToString("   + value.code + ", " + ident.size + ")";

                case TypedCode.DOUBLE :

                    return "Util.doubleToString(" + value.code + ", " + ident.size + ")";

                case TypedCode.BOOLEAN :

                    throw new RuntimeException("implementar setterCasting(STRING, DOUBLE)");

                case TypedCode.STRING :

                    return value.code;
                }
            }
        }

        //

        if (ident.type < value.type) {

            if (value.aggregation == TypedCode.COMPLEX) {
                return "(" + TypedCode.javaNames[ident.type] + ") (" + value.code + ")";
            }
            else {
                return "(" + TypedCode.javaNames[ident.type] + ") "  + value.code;
            }
        }
        else {

            if (ident.size != TypedCode.UNDEF) {
                value.code = value.code.replace("${size}", Integer.toString(ident.size));
            }

            return value.code;
        }
    }

    /******************************************************************************
     * getSignCondition
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param sc TODO_javadoc.
     * @param value TODO_javadoc.
     * @param not TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private TypedCode getSignCondition(SignCondition sc, TypedCode value, boolean not) {

      //logger.debug("[" + filename + "/" + sectionName + "] entrando a 'getSignCondition()' ...");

        if (!value.isNumeric()) {
            throw new RuntimeException("[" + filename + "/" + sectionName + "] getSignCondition:: '" + value + "' debe ser numerico.");
        }

        boolean bool = not ? sc.f1.present() : !sc.f1.present();

        switch (sc.f2.which) {

        case 0: // <POSITIVE>
            return new TypedCode(TypedCode.BOOLEAN, value.code + (bool ? " <= 0" : " > 0"), TypedCode.COMPLEX);
        case 1: // <NEGATIVE>
            return new TypedCode(TypedCode.BOOLEAN, value.code + (bool ? " >= 0" : " < 0"), TypedCode.COMPLEX);
        case 2: // <ZERO>
        case 3: // <ZEROS>
        case 4: // <ZEROES>
            return new TypedCode(TypedCode.BOOLEAN, value.code + (bool ? " != 0" : " == 0"), TypedCode.COMPLEX);
        }

        return null;
    }

    /******************************************************************************
     * getClassCondition
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param cc TODO_javadoc.
     * @param value TODO_javadoc.
     * @param not TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private TypedCode getClassCondition(ClassCondition cc, TypedCode value, boolean not) {

      //logger.debug("[" + filename + "/" + sectionName + "] entrando a 'getClassCondition()' ...");

        String prefix = not ? (cc.f1.present() ? "" : "!") : (cc.f1.present() ? "!" : "");

        switch (cc.f2.which) {

        case 0: // <NUMERIC>
            return new TypedCode(TypedCode.BOOLEAN, prefix + "Util.isNumeric(" +         value.code + ")", TypedCode.SIMPLE); // BOOLEAN --> SIMPLE
        case 1: // <ALPHABETIC>
            return new TypedCode(TypedCode.BOOLEAN, prefix + "Util.isAlphabetic(" +      value.code + ")", TypedCode.SIMPLE); // BOOLEAN --> SIMPLE
        case 2: // <ALPHABETIC_LOWER>
            return new TypedCode(TypedCode.BOOLEAN, prefix + "Util.isAlphabeticLower(" + value.code + ")", TypedCode.SIMPLE); // BOOLEAN --> SIMPLE
        case 3: // <ALPHABETIC_UPPER>
            return new TypedCode(TypedCode.BOOLEAN, prefix + "Util.isAlphabeticUpper(" + value.code + ")", TypedCode.SIMPLE); // BOOLEAN --> SIMPLE
        case 4: // ClassName()
            throw new RuntimeException("[" + filename + "/" + sectionName + "] getClassCondition:: ClassName() no implementada aun");
        case 5: // <DBCS>
            throw new RuntimeException("[" + filename + "/" + sectionName + "] getClassCondition:: <DBCS> no implementada aun");
        case 6: // <KANJI>
            throw new RuntimeException("[" + filename + "/" + sectionName + "] getClassCondition:: <KANJI> no implementada aun");
        }

        return null;
    }

    /******************************************************************************
     * genCombinableCondition
     ******************************************************************************/
    /**
     *
     * f0 -> [ <NOT> ]
     * f1 -> SimpleCondition()
     *
     * @param subject_ant TODO_javadoc.
     * @param oper_ant TODO_javadoc.
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private TypedCode genCombinableCondition(TypedCode subject_ant, int oper_ant, CombinableCondition n, HashMap<String, Object> argu) {

      //logger.debug("[" + filename + "/" + sectionName + "] entrando a 'genCombinableCondition(" + (subject_ant == null ? "(NULL)" : subject_ant.code) + "," + (oper_ant == TypedCode.UNDEF ? "(NULL)" : TypedCode.relationalOper[oper_ant]) + "," + n.accept(tokenVisitor).toString().trim() + ")' ...");

        argu.remove("subject_ant");
        argu.remove("oper_ant");

        //
        // n.f0 -> [ <NOT> ]
        //
        String prefix = n.f0.present() ? "!" : "";

        //

        SimpleCondition sc = n.f1;

        /* SimpleCondition::
         *
         * f0 -> RelationCondition()
         *       | ArithmeticExpression()
         *       | <LPARENCHAR> Condition() <RPARENCHAR>
         */

        switch (sc.f0.which) {

        /******************************************************************************
         *
         ******************************************************************************/

        case 0 : // RelationCondition()

          //logger.debug("(sc.f0.choice == RelationCondition)");

            RelationCondition rc = (RelationCondition) sc.f0.choice;

            /* RelationCondition::
             *
             * f0 -> ArithmeticExpression()
             * f1 -> ( AbbreviationRest() | SignCondition() | ClassCondition() )
             */

            argu.put(TypedCode.TYPE_EXPECTED, new Integer(TypedCode.UNDEF));

            TypedCode subject = rc.f0.accept(this, argu); // ArithmeticExpression()

            argu.put("subject_ant", subject);

          //logger.debug("[" + filename + "/" + sectionName + "] subject: " + subject.code);

            //

            switch (rc.f1.which) {

            /*=============================================================================
             *
             =============================================================================*/

            case 0 : // AbbreviationRest()

                return processAbbreviationRest(prefix, subject, (AbbreviationRest) rc.f1.choice, argu);

            /*=============================================================================
             *
             =============================================================================*/

            case 1 : //  SignCondition()

                return getSignCondition((SignCondition) rc.f1.choice, subject, n.f0.present());

            /*=============================================================================
             *
             =============================================================================*/

            case 2 : // ClassCondition()

                return getClassCondition((ClassCondition) rc.f1.choice, subject, n.f0.present());
            }

            break;

        /******************************************************************************
         *
         ******************************************************************************/

        case 1 : // ArithmeticExpression()

            argu.put(TypedCode.TYPE_EXPECTED, new Integer(TypedCode.UNDEF));

            TypedCode ae = sc.f0.accept(this, argu); // ArithmeticExpression()

          //logger.debug("[" + filename + "/" + sectionName + "] (f0 == ArithmeticExpression) ae: " + ae.code);

            if (ae.type != TypedCode.BOOLEAN) {

                if        (subject_ant == null && oper_ant == TypedCode.UNDEF) {

                    return ae;

                } else if (subject_ant == null || oper_ant == TypedCode.UNDEF) {
                    throw new RuntimeException("[" + filename + "/" + sectionName + "] subject_ant u oper_ant es nulo");
                }

                return getRelationalCode(prefix, subject_ant, oper_ant, ae);
            }
            else { // TypedCode.BOOLEAN

                if (prefix.equals("")) {

                  //logger.debug("[" + filename + "/" + sectionName + "] saliendo de 'genCombinableCondition(" + ae.code + ")' ...");

                    return ae;
                }
                else {
                    return new TypedCode(TypedCode.BOOLEAN, ae.aggregation == TypedCode.COMPLEX ? prefix + "(" + ae.code + ")" : prefix + ae.code, TypedCode.SIMPLE); // BOOLEAN --> SIMPLE
                }
            }

        /******************************************************************************
         *
         ******************************************************************************/

        case 2 : // <LPARENCHAR> Condition() <RPARENCHAR>

            NodeSequence ns   = (NodeSequence) sc.f0.choice;
            TypedCode    cond = ns.elementAt(1).accept(this, argu);

            return new TypedCode(TypedCode.BOOLEAN, prefix + "(" + cond.code + ")", TypedCode.SIMPLE);
        }

        return null;
    }

    /******************************************************************************
     * processAbbreviationRest
     ******************************************************************************/
    /**
     *
     * f0 -> RelationalOperator()
     * f1 -> AbbreviationLeaf()
     *
     * @param subject TODO_javadoc.
     * @param ar TODO_javadoc.
     * @param prefix TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private TypedCode processAbbreviationRest(String prefix, TypedCode subject, AbbreviationRest ar, HashMap<String, Object> argu) {

      //logger.debug("[" + filename + "/" + sectionName + "] entrando a 'processAbbreviationRest(" + ar.accept(tokenVisitor).toString().trim() + ")' ...");

        int oper = getRelationalOper(ar.f0);

        argu.put("oper_ant", new Integer(oper));

      //logger.debug("[" + filename + "/" + sectionName + "] oper: " + TypedCode.relationalOper[oper]);

        /* AbbreviationLeaf::
         *
         * f0 -> ArithmeticExpression()
         *       | <LPARENCHAR> AbbreviationLeaf() ( ( <AND> | <OR> ) AbbreviationLeaf() )+ <RPARENCHAR>
         */

        switch (ar.f1.f0.which) {

        /*-----------------------------------------------------------------------------
         *
         -----------------------------------------------------------------------------*/

        case 0 : // ArithmeticExpression()

          //logger.debug("(ar.f1.f0.choice == ArithmeticExpression)");

            argu.put(TypedCode.TYPE_EXPECTED, new Integer(TypedCode.UNDEF));

            TypedCode ae = ar.f1.f0.accept(this, argu); // ArithmeticExpression()

          //logger.debug("[" + filename + "/" + sectionName + "] ae: " + ae.code);

            TypedCode result = getRelationalCode(prefix, subject, oper, ae);

          //logger.debug("[" + filename + "/" + sectionName + "] saliendo de 'processAbbreviationRest(" + result.code + ")' ...");

            return result;

        /*-----------------------------------------------------------------------------
         *
         -----------------------------------------------------------------------------*/

        case 1 : // <LPARENCHAR> AbbreviationLeaf() ( ( <AND> | <OR> ) AbbreviationLeaf() )+ <RPARENCHAR>

          //logger.debug("(ar.f1.f0.choice == <LPARENCHAR> AbbreviationLeaf() ( ( <AND> | <OR> ) AbbreviationLeaf() )+ <RPARENCHAR>)");

            NodeSequence ns = (NodeSequence) ar.f1.f0.choice;
            NodeList     nl = (NodeList)     ns.elementAt(2); // ( ( <AND> | <OR> ) AbbreviationLeaf() )+

            StringBuffer sb = new StringBuffer();

            sb.append(nl.size() > 0 ? "(" : "");

            TypedCode al = ns.elementAt(1).accept(this, argu);

            sb.append(getRelationalCode(prefix, subject, oper, al).code + (nl.size() > 0 ? " " : ""));

            for (int i = 0; i < nl.size(); i++) {

                NodeSequence ns1 = (NodeSequence) nl.elementAt(i); // ( <AND> | <OR> ) AbbreviationLeaf()

                sb.append(getAndOr((NodeChoice) ns1.elementAt(0)) + " ");

                al = ns1.elementAt(1).accept(this, argu);

                sb.append(getRelationalCode(""/*prefix*/, subject, oper, al).code + (i < nl.size() - 1 ? " " : ""));
            }

            sb.append(nl.size() > 0 ? ")" : "");

            return new TypedCode(TypedCode.BOOLEAN, sb.toString(), nl.size() > 0 ? TypedCode.SIMPLE : TypedCode.COMPLEX);
        }

        return null;
    }

    /******************************************************************************
     * getRelationalOperatorFromRelationCondition
     ******************************************************************************/
    /**
     *
     * f0 -> [ <NOT> ]
     * f1 -> SimpleCondition()
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private int getRelationalOperatorFromRelationCondition(CombinableCondition n) {

        SimpleCondition sc = n.f1;

        if (sc.f0.which == 0/*RelationCondition*/) {

            RelationCondition rc = (RelationCondition) n.f1.f0.choice;

            if (rc.f1.which == 0/*AbbreviationRest*/) {

                AbbreviationRest ar = (AbbreviationRest) rc.f1.choice;

                return getRelationalOper(ar.f0);
            }
        }

        return TypedCode.UNDEF;
    }

    /******************************************************************************
     * getSubjectFromRelationCondition
     ******************************************************************************/
    /**
     *
     * f0 -> [ <NOT> ]
     * f1 -> SimpleCondition()
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private TypedCode getSubjectFromRelationCondition(CombinableCondition n, HashMap<String, Object> argu) {

      //logger.debug("[" + filename + "/" + sectionName + "] entrando a 'getSubjectFromRelationCondition(" + n.accept(tokenVisitor).toString().trim() + ")' ...");

        SimpleCondition sc = n.f1;

        /* SimpleCondition::
         *
         * f0 -> RelationCondition()
         *       | ArithmeticExpression()
         *       | <LPARENCHAR> Condition() <RPARENCHAR>
         */
        if (sc.f0.which == 0) { // RelationCondition

            RelationCondition rc = (RelationCondition) sc.f0.choice;

            argu.put(TypedCode.TYPE_EXPECTED, new Integer(TypedCode.UNDEF));

            TypedCode ae = rc.f0.accept(this, argu); // ArithmeticExpression()

          //logger.debug("[" + filename + "/" + sectionName + "] saliendo de 'getSubjectFromRelationCondition(" + ae.code + ")' ...");

            return ae;
        }

      //logger.debug("[" + filename + "/" + sectionName + "] saliendo de 'getSubjectFromRelationCondition(null)' ...");

        return null;
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> [ <IS> ]
     * f1 -> [ <NOT> ]
     * f2 -> ( <GREATER> [ <THAN> ] [ <OR> <EQUAL> [ <TO> ] ]
     *       | <MORETHANCHAR>
     *       | <LESS>    [ <THAN> ] [ <OR> <EQUAL> [ <TO> ] ]
     *       | <LESSTHANCHAR>
     *       | <EQUAL> [ <TO> ]
     *       | <EQUALCHAR>
     *       | <NOTEQUAL>
     *       | <MORETHANOREQUAL>
     *       | <LESSTHANOREQUAL>
     *       )
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private int getRelationalOper(RelationalOperator n) {

        NodeSequence ns = null;

        switch (n.f2.which) {

        /******************************************************************************
         *
         ******************************************************************************/

        case 0 : // <GREATER> [ <THAN> ] [ <OR> <EQUAL> [ <TO> ] ]

            ns = (NodeSequence) n.f2.choice;

            if (((NodeOptional) ns.elementAt(2)).present()) { // [ <OR> <EQUAL> [ <TO> ] ]

                if (n.f1.present()) {
                    return TypedCode.LT; // <NOT> <GREATER> [ <THAN> ] [ <OR> <EQUAL> [ <TO> ] ]
                }
                else {
                    return TypedCode.GE; //       <GREATER> [ <THAN> ] [ <OR> <EQUAL> [ <TO> ] ]
                }
            }
            else {

                if (n.f1.present()) {
                    return TypedCode.LE; // <NOT> <GREATER> [ <THAN> ]
                }
                else {
                    return TypedCode.GT; //       <GREATER> [ <THAN> ]
                }
            }

        /******************************************************************************
         *
         ******************************************************************************/

        case 1 : // <MORETHANCHAR>

            if (n.f1.present()) {
                return TypedCode.LE; // <NOT> <MORETHANCHAR>
            }
            else {
                return TypedCode.GT; //       <MORETHANCHAR>
            }

        /******************************************************************************
         *
         ******************************************************************************/

        case 2 : // <LESS> [ <THAN> ] [ <OR> <EQUAL> [ <TO> ] ]

            ns = (NodeSequence) n.f2.choice;

            if (((NodeOptional) ns.elementAt(2)).present()) { // [ <OR> <EQUAL> [ <TO> ] ]

                if (n.f1.present()) {
                    return TypedCode.GT; // <NOT> <LESS> [ <THAN> ] [ <OR> <EQUAL> [ <TO> ] ]
                }
                else {
                    return TypedCode.LE; //       <LESS> [ <THAN> ] [ <OR> <EQUAL> [ <TO> ] ]
                }
            }
            else {

                if (n.f1.present()) {
                    return TypedCode.GE; // <NOT> <LESS> [ <THAN> ]
                }
                else {
                    return TypedCode.LT; //      <LESS> [ <THAN> ]
                }
            }

        /******************************************************************************
         *
         ******************************************************************************/

        case 3 : // <LESSTHANCHAR>

            if (n.f1.present()) {
                return TypedCode.GE; // <NOT> <LESSTHANCHAR>
            }
            else {
                return TypedCode.LT; //       <LESSTHANCHAR>
            }

        /******************************************************************************
         *
         ******************************************************************************/

        case 4 : // <EQUAL> [ <TO> ]
        case 5 : // <EQUALCHAR>

            if (n.f1.present()) {
                return TypedCode.NE; // <NOT> <EQUAL> [ <TO> ]
            }
            else {
                return TypedCode.EQ; //       <EQUAL> [ <TO> ]
            }

        /******************************************************************************
         *
         ******************************************************************************/

        case 6 : // <NOTEQUAL>

            if (n.f1.present()) {
                return TypedCode.EQ; // <NOT> <NOTEQUAL>
            }
            else {
                return TypedCode.NE; //       <NOTEQUAL>
            }

        /******************************************************************************
         *
         ******************************************************************************/

        case 7 : // <MORETHANOREQUAL>

            if (n.f1.present()) {
                return TypedCode.LT; // <NOT> <MORETHANOREQUAL>
            }
            else {
                return TypedCode.GE; //       <MORETHANOREQUAL>
            }

        /******************************************************************************
         *
         ******************************************************************************/

        case 8 : // <LESSTHANOREQUAL>

            if (n.f1.present()) {
                return TypedCode.GT; // <NOT> <LESSTHANOREQUAL>
            }
            else {
                return TypedCode.LE; //       <LESSTHANOREQUAL>
            }
        }

        return TypedCode.UNDEF;
    }

    /******************************************************************************
     * negateRelationalOperator
     ******************************************************************************/
    /**
     *
     * @param oper TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private int negateRelationalOperator(int oper) {

        switch (oper) {
        case TypedCode.NE :
            return TypedCode.EQ;
        case TypedCode.LT :
            return TypedCode.GE;
        case TypedCode.LE :
            return TypedCode.GT;
        case TypedCode.EQ :
            return TypedCode.NE;
        case TypedCode.GT :
            return TypedCode.LE;
        case TypedCode.GE :
            return TypedCode.LT;
        }

        return TypedCode.UNDEF;
    }

    /******************************************************************************
     * getAndOr
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * n -> (<AND> | <OR> )
     *
     * @param n TODO_javadoc.
     *
     */
    private String getAndOr(NodeChoice n) {

        switch (n.which) {

        case 0 : // <AND>
            return "&&";
        case 1 : // <OR>
            return "||";
        }

        return null;
    }

    /******************************************************************************
     * genParentesisCode
     ******************************************************************************/
    /**
     *
     * @param expr TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private String genParentesisCode(TypedCode expr) {
        return expr.aggregation == TypedCode.COMPLEX ? "(" + expr.code + ")" : expr.code;
    }

    /******************************************************************************
     * getRelationalCode
     ******************************************************************************/
    /**
     *
     * @param prefix TODO_javadoc.
     * @param subject TODO_javadoc.
     * @param oper TODO_javadoc.
     * @param expr TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private TypedCode getRelationalCode(String prefix, TypedCode subject, int oper, TypedCode expr) {

      //logger.debug("[" + filename + "/" + sectionName + "] entrando a 'getRelationalCode(" + prefix + "," + subject + "," +  TypedCode.relationalOper[oper] + "," + expr + ")' ...");

        if   (subject.size != TypedCode.UNDEF) {
            expr.code    = expr.code.   replace("${size}", Integer.toString(subject.size));
        } if (expr.size    != TypedCode.UNDEF) {
            subject.code = subject.code.replace("${size}", Integer.toString(expr.size));
        }

        //

      //logger.debug("subject: " + subject);
      //logger.debug("expr   : " + expr);

        if (subject.isNumeric() && expr.isNumeric()) {

            if (prefix.equals(""))  {
                return new TypedCode(TypedCode.BOOLEAN, genParentesisCode(subject) + " " + TypedCode.relationalOper[oper] +                           " " + genParentesisCode(expr), TypedCode.COMPLEX);
            }
            else {
                return new TypedCode(TypedCode.BOOLEAN, genParentesisCode(subject) + " " + TypedCode.relationalOper[negateRelationalOperator(oper)] + " " + genParentesisCode(expr), TypedCode.COMPLEX);
            }
        }
        else if (subject.type == TypedCode.STRING && expr.type == TypedCode.STRING) {

            return getRelationalCodeStrings(prefix, subject, oper, expr);
        }
        else if (subject.isNumeric() && expr.type == TypedCode.STRING || subject.type == TypedCode.STRING && expr.isNumeric()) {

            TypedCode s = cloner.deepClone(subject);
            TypedCode e = cloner.deepClone(expr);

            if (s.isNumeric()) {
                s.code = s.toStringCode();
            }
            else {
                e.code = e.toStringCode();
            }

            return getRelationalCodeStrings(prefix, s, oper, e);
        }
        else if (subject.type == TypedCode.BOOLEAN && expr.type == TypedCode.BOOLEAN) {

            switch (oper) {

            case TypedCode.NE :
            case TypedCode.EQ :
                return new TypedCode(TypedCode.BOOLEAN, genParentesisCode(subject) + " " + TypedCode.relationalOper[oper] + " " + genParentesisCode(expr), TypedCode.COMPLEX);
            }
        }

        throw new RuntimeException("[" + filename + "/" + sectionName + "] operador {" + TypedCode.relationalOper[oper] + "} no implementado aun para {" + subject.code + "} de tipo " + TypedCode.javaNames[subject.type] + " y {" + expr.code + "} de tipo " + TypedCode.javaNames[expr.type]);
    }

    /******************************************************************************
     * getRelationalCodeStrings
     ******************************************************************************/
    /**
     *
     * @param prefix TODO_javadoc.
     * @param subject TODO_javadoc.
     * @param oper TODO_javadoc.
     * @param expr TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private TypedCode getRelationalCodeStrings(String prefix, TypedCode subject, int oper, TypedCode expr) {

      //logger.debug("[" + filename + "/" + sectionName + "] entrando a 'getRelationalCodeStrings(" + prefix + "," + subject + "," +  TypedCode.relationalOper[oper] + "," + expr + ")' ...");

        switch (oper) {

        /******************************************************************************
         *
         ******************************************************************************/

        case TypedCode.NE :

            if (prefix.equals("")) {
                return new TypedCode(TypedCode.BOOLEAN, "!" + genParentesisCode(subject) + ".equals(" + expr.code + ")", TypedCode.SIMPLE);
            }
            else {
                return new TypedCode(TypedCode.BOOLEAN,       genParentesisCode(subject) + ".equals(" + expr.code + ")", TypedCode.SIMPLE);
            }

        /******************************************************************************
         *
         ******************************************************************************/

        case TypedCode.LT :
        case TypedCode.LE :
        case TypedCode.GT :
        case TypedCode.GE :

            if (prefix.equals("")) {
                return new TypedCode(TypedCode.BOOLEAN, genParentesisCode(subject) + ".compareTo(" + expr.code + ") " + TypedCode.relationalOper[oper] +                           " 0", TypedCode.COMPLEX);
            }
            else {
                return new TypedCode(TypedCode.BOOLEAN, genParentesisCode(subject) + ".compareTo(" + expr.code + ") " + TypedCode.relationalOper[negateRelationalOperator(oper)] + " 0", TypedCode.COMPLEX);
            }

        /******************************************************************************
         *
         ******************************************************************************/

        case TypedCode.EQ :

            if (prefix.equals("")) {
                return new TypedCode(TypedCode.BOOLEAN,       genParentesisCode(subject) + ".equals(" + expr.code + ")", TypedCode.SIMPLE);
            }
            else {
                return new TypedCode(TypedCode.BOOLEAN, "!" + genParentesisCode(subject) + ".equals(" + expr.code + ")", TypedCode.SIMPLE);
            }
        }

        return null;
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ProcedureName()
     * f1 -> [ ( <THROUGH> | <THRU> ) ProcedureName() ]
     *
     * @param gen TODO_javadoc.
     * @param ppsc TODO_javadoc.
     *
     */
    private void genPerformProcedureScopeClause(PrintStream gen,  PerformProcedureScopeClause ppsc) {

        String name = getParagraphOrSectionName(ppsc.f0);

        if (ppsc.f1.present()) { // [ ( <THROUGH> | <THRU> ) ProcedureName() ]

            ProcedureName pn       = (ProcedureName) ((NodeSequence) ppsc.f1.node).elementAt(1);
            String        name_fin = getParagraphOrSectionName(pn);

            String desde = getParagraphSection(name,     sectionName, sections, paragraphs);
            String hasta = getParagraphSection(name_fin, sectionName, sections, paragraphs);

            int pos;
            int index_ini;
            int index_fin;

            if ((pos = desde.indexOf('/')) == 0) { /* '/section' */
                throw new RuntimeException("[" + filename + "/" + sectionName + "] PerformStatement:: <THROUGH> con section inicial.");
            }

            if ((index_ini = paragraphs.indexOf(desde)) == -1) {
                throw new RuntimeException("[" + filename + "/" + sectionName + "] PerformStatement:: no se encontro paragraph inicial (" + desde + ") para el <THROUGH>.");
            }

            //

            if ((pos = hasta.indexOf('/')) == 0) { /* '/section' */
                throw new RuntimeException("[" + filename + "/" + sectionName + "] PerformStatement:: <THROUGH> con section final.");
            }

            if ((index_fin = paragraphs.indexOf(hasta)) == -1) {
                throw new RuntimeException("[" + filename + "/" + sectionName + "] PerformStatement:: no se encontro paragraph final (" + hasta + ") para el <THROUGH>.");
            }

            //

            for (int i = index_ini; i <= index_fin; i++) {
                gen.println(indent(indent) + "execute(\"" + methodStyle(paragraphs.get(i)) + "\");");
            }
        }
        else {
            gen.println(indent(indent) + "execute(\"" + methodStyle(getParagraphSection(name,     sectionName, sections, paragraphs)) + "\");");
        }
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param name TODO_javadoc.
     * @param sectionName TODO_javadoc.
     * @param sections TODO_javadoc.
     * @param paragraphs TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private String getParagraphSection(String name, String sectionName, ArrayList<String> sections, ArrayList<String> paragraphs) {

      //logger.debug("[" + filename + "/" + sectionName + "] entrando a 'getParagraphSection([" + filename + "/" + sectionName + "] " + name + "," + sectionName + ")' ...");

        String pname = null;
        String sname = null;
        String s     = null;
        int    pos;

        if ((pos = name.indexOf('/')) > -1) {
            return name;
        }
        else if (sections.contains(name)) {
            return "/" + name;
        }
        else if (paragraphs.contains(name + "/" + sectionName)) {
            return name + "/" + sectionName;
        }
        else if ((s = paragraphStartsWith(name, paragraphs)) != null) {
            return s;
        }
        else {
            throw new RuntimeException("[" + filename + "/" + sectionName + "] no se encontro section o paragraph con nombre '" + name + "'.");
        }
    }

    /******************************************************************************
     *
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
    private String methodStyle(String name) {

        if (name == null) {
            return null;
        }

        int pos = name.indexOf('/');

        return pos == 0 /* '/section' */ ? lowerCamelCase(name.substring(1)) : lowerCamelCase(name.substring(pos + 1)) + "_" + lowerCamelCase(name.substring(0, pos));
    }

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param name TODO_javadoc.
     * @param paragraphs TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private String paragraphStartsWith(String name, ArrayList<String> paragraphs) {

      //logger.debug("[" + filename + "/" + sectionName + "] entrando a 'paragraphStartsWith(" + name + ")' ...");

        if (name == null) {
            return null;
        }

        for (int i = 0; i < paragraphs.size(); i++) {

            if (paragraphs.get(i).startsWith(name + "/")) {
                return paragraphs.get(i);
            }
        }

        return null;
    }

}
