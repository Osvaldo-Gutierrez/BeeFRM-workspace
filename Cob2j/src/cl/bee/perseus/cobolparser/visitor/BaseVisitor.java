/*
 *   Copyright (c) 2020 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.perseus.cobolparser.visitor;


import java.io.*;

import java.nio.charset.*;

import java.text.*;

import java.util.*;
import java.util.regex.*;

import cl.bee.perseus.util.*;

import cl.bee.perseus.cobolparser.syntaxtree.*;
import cl.bee.perseus.cobolparser.util.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.apache.log4j.*;

import org.apache.commons.lang.*;


/**
 *
 * TODO_javadoc.
 *
 * @version 1.0 (01/01/2020).
 *
 */
public class BaseVisitor extends GJDepthFirst<TypedCode, HashMap<String, Object>> implements GJVisitor<TypedCode, HashMap<String, Object>> {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(BaseVisitor.class);

    /** TODO_javadoc. */
    protected static final String spaces = "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " +
                                           "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " +
                                           "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                " +
                                           "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ";
                                       //          ----------
  ///** TODO_javadoc. */               //01234567890123456789
  //private static final String SIGNS = "{ABCDEFGHI}JKLMNOPQR";

    //

    /** TODO_javadoc. */
    public static String AUTHOR = System.getProperty("PROPRIETARY") != null ? System.getProperty("PROPRIETARY") : "BEE S.A.";;

    /** TODO_javadoc. */
    public static String COPYRIGHT = "Copyright (c) " + (new SimpleDateFormat("yyyy")).format(new java.util.Date()) + " by " + AUTHOR + " All Rights Reserved.";

    /** TODO_javadoc. */
    public static String DIAHOY = (new SimpleDateFormat("dd/MM/yyyy")).format(new java.util.Date());

    /** TODO_javadoc. */
    public static String VERSION = "1.0";

    /** TODO_javadoc. */
    public static String target_dir = "gendir";

    /** TODO_javadoc. */
    protected final static String SETTER_VARIABLES = "setterVariables";

    /** TODO_javadoc. */
    protected final static String GETTER_VARIABLES = "getterVariables";

    //

    /** TODO_javadoc. */
    protected final static int SETTER = 0;

    /** TODO_javadoc. */
    protected final static int GETTER = 1;

    /** TODO_javadoc. */
    protected final static int SIZER = 2;


    /** TODO_javadoc. */
    protected TokenVisitor tokenVisitor = new TokenVisitor();

    //

    /** TODO_javadoc. */
    protected String filename = null;

    /** TODO_javadoc. */
    protected ArrayList<DataEntryDesc> entryArray = null;

    /** TODO_javadoc. */
    protected ArrayList<DataEntryDesc> usedBases = null;

    /** TODO_javadoc. */
    protected ArrayList<String> varspaths = null;

    /** TODO_javadoc. */
    protected String jsonparams = null;

    //

    /** TODO_javadoc. */
    protected String sectionName = null;

    /** TODO_javadoc. */
    protected String paragraphName = null;

    /** TODO_javadoc. */
    protected JsonNode params = null;

    /******************************************************************************
     * genSpaces
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param size TODO_javadoc.
     *
     */
    protected String genSpaces(int size) {
        return repeatChar(' ', size);
    }

    /******************************************************************************
     * setJsonParams
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param jsonparams TODO_javadoc.
     *
     */
    protected void setJsonParams(String jsonparams) {

        try {
            params = (new ObjectMapper()).readTree(new StringReader(jsonparams.replace('\'', '"')));
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /******************************************************************************
     * indent
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param ind TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    protected String indent(int ind) {
        return spaces.substring(0, ind * 4);
    }

    /******************************************************************************
     * capitalize
     ******************************************************************************/
    /**
     *
     * @param s TODO_javadoc
     *
     * @return TODO_javadoc
     *
     */
    protected String capitalize(String s) {

        if (s != null && s.equals("") == false) {
            return s.substring(0, 1).toUpperCase() + s.substring(1);
        }

        return s;
    }

    /******************************************************************************
     * lowering
     ******************************************************************************/
    /**
     *
     * @param s TODO_javadoc
     *
     * @return TODO_javadoc
     *
     */
    protected String lowering(String s) {

        if (s != null && s.equals("") == false) {
            return s.substring(0, 1).toLowerCase() + s.substring(1);
        }

        return s;
    }

    /******************************************************************************
     * camelCase
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
    protected String camelCase(String s) {

        if (s == null) {
            return null;
        }

        StringBuffer sb = new StringBuffer();
        char         c;

        s = s.trim();

        boolean inWord           = false;
        boolean firstLetterWord  = true;
        boolean firstLetterIdent = true;

        for (int i = 0; i < s.length(); i++) {

            c = validLetter(s.charAt(i));

            if (firstLetterIdent && !Character.isJavaIdentifierStart(c)) {
                continue;
            }
            else {
                firstLetterIdent = false;
            }

            if (!Character.isJavaIdentifierPart(c) || c == '_') {

                inWord = false;

                firstLetterWord = true;

            } else if (!inWord) {

                if (firstLetterWord) {
                    sb.append(Character.toUpperCase(c));
                    firstLetterWord = false;
                } else {
                    sb.append(Character.toLowerCase(c));
                }

                inWord = true;

            } else {
                sb.append(Character.toLowerCase(c));
            }
        }

        return capitalize(sb.toString());
    }

    /******************************************************************************
     * lowerCamelCase
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
    protected String lowerCamelCase(String s) {
        return lowering(camelCase(s));
    }

    /******************************************************************************
     * getIterableQuotedText
     ******************************************************************************/
    /**
     *
     * @param s TODO_javadoc
     *
     * @return TODO_javadoc
     */
    protected String getIterableQuotedText(String s) {

        StringBuffer sb = new StringBuffer();

        // se salta el primero y el ultimo (pueden ser " o ')

        for (int i = 1; i < s.length() - 1; i++) {

            if      (s.charAt(i) == '"' && s.charAt(i + 1) == '"') {

                sb.append('\\');
                sb.append(s.charAt(i));

                i++;
            }
            else if (s.charAt(i) == '\'' && s.charAt(i + 1) == '\'') {

                sb.append(s.charAt(i));

                i++;
            }
            else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    /******************************************************************************
     * getName
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * SectionName::
     * ParagraphName::
     * NonDotChars::
     *
     * f0 -> IntegerConstant()
     *       | CobolWord()
     *       | PictureCurrency()
     *
     * @param nch TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    protected String getName(NodeChoice nch) {

      //logger.debug("[" + filename + "] entrando a 'getName(" + nch.which + "," + nch.getParent().getClass().getName() +  ")' ...");

        switch (nch.which) {

        case 0: // IntegerConstant()

            return ((NodeToken) ((IntegerConstant) nch.choice).f0.choice).tokenImage;

        case 1: // CobolWord()

            return ((CobolWord) nch.choice).f0.tokenImage;

        case 2: // PictureCurrency()

            return ((PictureCurrency) nch.choice).f0.tokenImage;
        }

        return null;
    }

    /******************************************************************************
     * trimLeftZeroes
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
    protected String trimLeftZeroes(String s) {

        StringBuffer sb = new StringBuffer();

        int i;

        for (i = 0; i < s.length() - 1; i++) { // el ultimo puede ser '0'

            if (s.charAt(i) != '0') {
                break;
            }
        }

        return s.substring(i);
    }

    /******************************************************************************
     * getParagraphOrSectionName
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( ParagraphName() [ ( <IN> | <OF> ) SectionName() ] | SectionName() )
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    protected String getParagraphOrSectionName(ProcedureName n) {

        switch (n.f0.which) {

        case 0: // ParagraphName() [ ( <IN> | <OF> ) SectionName() ]

            NodeSequence ns = (NodeSequence) n.f0.choice;
            NodeOptional no = (NodeOptional) ns.elementAt(1);

            if (no.present()) {

                NodeSequence ns1 = (NodeSequence) no.node;

                return getName(((ParagraphName) ns.elementAt(0)).f0) + "/" + getName(((SectionName) ns1.elementAt(1)).f0);
            }
            else {
                return getName(((ParagraphName) ns.elementAt(0)).f0);
            }

        case 1: // SectionName()

            return getName(((SectionName) n.f0.choice).f0);
        }

        return null;
    }

    /******************************************************************************
     * getHexNumber
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
    protected TypedCode getHexNumber(String s) {

        if (s == null) {
            throw new IllegalArgumentException("argumento nulo.");
        }

        String hex = s.substring(2, s.length() - 1);

        return new TypedCode(Long.parseLong(hex, 16) > Integer.MAX_VALUE ? TypedCode.LONG : TypedCode.INTEGER, "0x" + hex, TypedCode.SIMPLE);
    }

    /******************************************************************************
     * getLevelName
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
     * @return TODO_javadoc.
     *
     */
    protected String getLevelName(LevelName n) {

        if (n.f0.present()) {

            NodeChoice nch = (NodeChoice) n.f0.node;

            switch (nch.which) {

            case  0: // DataName()

                return ((DataName) nch.choice).f0.f0.tokenImage;

            default: // FILLER> // <REPLY> // <PROGRAM_STATUS>

                return ((NodeToken) nch.choice).tokenImage;
            }
        }
        else {
            return "";
        }
    }

    /******************************************************************************
     * scape
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param s TODO_javadoc.
     *
     */
    protected static String scape(String s) {

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < s.length(); i++) {

            switch (s.charAt(i)) {

            case '"' :

                sb.append('\\');
                sb.append(s.charAt(i));

                break;

            case (char) 0x0D :

                sb.append(' ');

                break;

            case (char) 0x0A :
                break;

            default :

                sb.append(s.charAt(i));
            }

        }

        return sb.toString();
    }

    /******************************************************************************
     * addVariablePath
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param entry TODO_javadoc.
     * @param path TODO_javadoc.
     * @param varspaths TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public static void addVariablePath(DataEntryDesc entry, String path, ArrayList<String> varspaths) {

      //logger.debug("[" + filename + "] entrando a 'addVariablePath(" + entry.name + "," + path + ")' ...");

        if (entry == null) {
            return;
        }

        path += "/" + entry.name;

        varspaths.add(path + (entry.childs != null ? "/@" : ""));

      //logger.debug("[" + filename + "] " + path + (entry.childs != null ? "/@" : ""));

        if (entry.childs != null) {

            for (int i = 0; i < entry.childs.size(); i++) {
                addVariablePath(entry.childs.get(i), path, varspaths);
            }
        }
    }

    /******************************************************************************
     * getDataEntryByIdentifier
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
     * @param varspaths TODO_javadoc.
     * @param entryArray TODO_javadoc.
     * @param usedBases TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    protected DataEntryDesc getDataEntryByIdentifier(Identifier n, ArrayList<String> varspaths, ArrayList<DataEntryDesc> entryArray, ArrayList<DataEntryDesc> usedBases, HashMap<String, Object> argu) {

        switch (n.f0.which) {

        /******************************************************************************
         *
         ******************************************************************************/

        case 0 : // QualifiedDataName() ( Subscript() )* [ <LPARENCHAR> LeftmostCharacterPosition() <COLONCHAR> [ Length() ] <RPARENCHAR> ]

            Stack<DataEntryDesc> stack        = getIdentifierStackDataEntryDesc(n, varspaths, entryArray, usedBases, argu);
            DataEntryDesc        entry        = stack.elementAt(stack.size() - 1);
            String               subscript    = getIdentifierSubscript(n, argu);
            boolean              is_base      = stack.size() == 1;
            boolean              is_primitive = (stack.size() == 1 && (entry.childs == null || ModelUtil.isConditionalStruct(entry.childs))) || entry.mode == DataEntryDesc.INDEXER;

            /*
            logger.debug("[" + filename + "] ============================================================================================");

            for (int i = 0; i < stack.size(); i++) {
                logger.debug("[" + filename + "] " + stack.elementAt(i).name + ", childs: " + (stack.elementAt(i).childs != null)  + ", indexer: " + stack.elementAt(i).indexer + ", ocurrs: " + stack.elementAt(i).occurs + " (" + DataEntryDesc.modesNames[stack.elementAt(i).mode] + ")");
            }

            logger.debug("[" + filename + "] ============================================================================================");
            */

            //

            entry.addendum = getGetterSetterSequence(stack, subscript, GETTER, is_base, is_primitive, null);

            entry.set("is_base",      new Boolean(is_base));
            entry.set("is_primitive", new Boolean(is_primitive));

            return entry;

        /******************************************************************************
         *
         ******************************************************************************/

        case 1 : // <LINAGE_COUNTER> [ ( <IN> | <OF> ) FileName() ]

            throw new RuntimeException("getDataEntryByIdentifier:: <LINAGE_COUNTER> [ ( <IN> | <OF> ) FileName() ] no implementada aun {" + n.accept(tokenVisitor) + "}");

        /******************************************************************************
         *
         ******************************************************************************/

        case 2 : // <PROGRAM_STATUS>

            throw new RuntimeException("getDataEntryByIdentifier:: <PROGRAM_STATUS> no implementada aun {" + n.accept(tokenVisitor) + "}");
        }

        return null;
    }

    /******************************************************************************
     * getPathFromPackage
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param package_name TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    protected String getPathFromPackage(String package_name) {

        if (package_name == null || package_name.trim().equals("")) {
            return "";
        }

        return package_name.replace('.', '/');
    }

    /******************************************************************************
     * getIdentifier
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
     * @param mode TODO_javadoc.
     * @param varspaths TODO_javadoc.
     * @param entryArray TODO_javadoc.
     * @param usedBases TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    protected TypedCode getIdentifier(Identifier n, int mode, ArrayList<String> varspaths, ArrayList<DataEntryDesc> entryArray, ArrayList<DataEntryDesc> usedBases, HashMap<String, Object> argu) {

        switch (n.f0.which) {

        /******************************************************************************
         *
         ******************************************************************************/

        case 0 : // QualifiedDataName() ( Subscript() )* [ <LPARENCHAR> LeftmostCharacterPosition() <COLONCHAR> [ Length() ] <RPARENCHAR> ]

            Stack<DataEntryDesc>    stack            = getIdentifierStackDataEntryDesc(n, varspaths, entryArray, usedBases, argu);
            String                  substring_suffix = getIdentifierSubstring         (n, varspaths, entryArray, usedBases, argu);
            String                  subscript        = getIdentifierSubscript         (n,                                   argu);

            DataEntryDesc           entry            = stack.elementAt(stack.size() - 1);
            HashMap<String, Object> hash             = new HashMap<String, Object>();

            boolean is_base;
            boolean is_primitive;

            switch (entry.mode) {

            case DataEntryDesc.VARIABLE :
            case DataEntryDesc.CONDITION :
            case DataEntryDesc.INDEXER :

                is_base      =  stack.size() == 1;
                is_primitive = (stack.size() == 1 && (entry.childs == null || ModelUtil.isConditionalStruct(entry.childs))) || entry.mode == DataEntryDesc.INDEXER;

                hash.put("is_base",      new Boolean(is_base));
                hash.put("is_primitive", new Boolean(is_primitive));
                hash.put("with_child",   new Boolean(entry.childs != null));
                hash.put("is_index",     new Boolean(entry.mode   == DataEntryDesc.INDEXER));

                /*
                logger.debug("[" + filename + "] ============================================================================================");

                for (int i = 0; i < stack.size(); i++) {
                    logger.debug("[" + filename + "] " + stack.elementAt(i).name + ", childs: " + (stack.elementAt(i).childs != null)  + ", indexer: " + stack.elementAt(i).indexer + ", ocurrs: " + stack.elementAt(i).occurs + " (" + DataEntryDesc.modesNames[stack.elementAt(i).mode] + ")");
                }

                logger.debug("[" + filename + "] --------------------------------------------------------------------------------------------");
                logger.debug("[" + filename + "] subscript: " + subscript);
                logger.debug("[" + filename + "] hash     : " + hash);
                logger.debug("[" + filename + "] ============================================================================================");
                */


                if (argu.containsKey(SETTER_VARIABLES)) {

                    ArrayList<TypedCode> list   = (ArrayList<TypedCode>) argu.get(SETTER_VARIABLES);
                    TypedCode            result = new TypedCode(entry.mode == DataEntryDesc.CONDITION ? TypedCode.BOOLEAN : entry.type, getGetterSetterSequence(stack, subscript, SETTER, is_base, is_primitive, substring_suffix), TypedCode.SIMPLE, entry.totalLen, hash);

                    result.sign = entry.sign;

                    if (!list.contains(result)) {
                        list.add(result);
                    }
                }

                if (argu.containsKey(GETTER_VARIABLES)) {

                    ArrayList<TypedCode> list   = (ArrayList<TypedCode>) argu.get(GETTER_VARIABLES);
                    TypedCode            result = new TypedCode(entry.mode == DataEntryDesc.CONDITION ? TypedCode.BOOLEAN : entry.type, getGetterSetterSequence(stack, subscript, GETTER, is_base, is_primitive, substring_suffix), TypedCode.SIMPLE, entry.totalLen, hash);

                    result.sign = entry.sign;

                    if (!list.contains(result)) {
                        list.add(result);
                    }
                }

                //

                TypedCode result = new TypedCode(entry.mode == DataEntryDesc.CONDITION ? TypedCode.BOOLEAN : entry.type, getGetterSetterSequence(stack, subscript, mode, is_base, is_primitive, substring_suffix), TypedCode.SIMPLE, entry.totalLen, hash);

                result.sign = entry.sign;

                return result;

            case DataEntryDesc.SPECIAL :

                hash.put("is_base",      new Boolean(is_base      = true));
                hash.put("is_primitive", new Boolean(is_primitive = true));
                hash.put("with_child",   new Boolean(false));
                hash.put("is_index",     new Boolean(false));

                /*
                logger.debug("[" + filename + "] ============================================================================================");

                for (int i = 0; i < stack.size(); i++) {
                    logger.debug("[" + filename + "] " + stack.elementAt(i).name + ", childs: " + (stack.elementAt(i).childs != null)  + ", indexer: " + stack.elementAt(i).indexer + ", ocurrs: " + stack.elementAt(i).occurs + " (" + DataEntryDesc.modesNames[stack.elementAt(i).mode] + ")");
                }

                logger.debug("[" + filename + "] --------------------------------------------------------------------------------------------");
                logger.debug("[" + filename + "] subscript: " + subscript);
                logger.debug("[" + filename + "] hash     : " + hash);
                logger.debug("[" + filename + "] ============================================================================================");
                */

                return new TypedCode(entry.type, getGetterSetterSequence(stack, subscript, mode, is_base, is_primitive, substring_suffix), TypedCode.SIMPLE, entry.totalLen, hash);
            }

            break;

        /******************************************************************************
         *
         ******************************************************************************/

        case 1 : // <LINAGE_COUNTER> [ ( <IN> | <OF> ) FileName() ]

            throw new RuntimeException("getIdentifier:: <LINAGE_COUNTER> [ ( <IN> | <OF> ) FileName() ] no implementada aun {" + n.accept(tokenVisitor) + "}");

        /******************************************************************************
         *
         ******************************************************************************/

        case 2 : // <PROGRAM_STATUS>

            throw new RuntimeException("getIdentifier:: <PROGRAM_STATUS> no implementada aun {" + n.accept(tokenVisitor) + "}");
        }

        return null;
    }

    /******************************************************************************
     * repeatChar
     ******************************************************************************/
    /**
     *
     * @param c TODO_javadoc.
     * @param size TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    protected String repeatChar(char c, int size) {

        byte[] arr = new byte[size];

        Arrays.fill(arr, (byte) c);

        return new String(arr);
    }

    /******************************************************************************
     * repeatChar
     ******************************************************************************/
    /**
     *
     * @param s TODO_javadoc.
     * @param size TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    protected String repeatChar(String s, int size) {

        if (s == null) {
            throw new RuntimeException("repeatChar:: parametro no puede ser nulo.");
        }

        if (s.length() != 1) {
            throw new RuntimeException("repeatChar:: parametro con mas de un caracter aun no implementado.");
        }

        return repeatChar(s.charAt(0), size);
    }

    /*******************************************************************************************************
     * setCompNumber
     *******************************************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param l TODO_javadoc.
     * @param length TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    /*
    protected String setCompNumber(long l, int length) {

        DecimalFormat formz = new DecimalFormat(repeatChar('0', length));

        String s = formz.format(Math.abs(l));

        return s.substring(0, s.length() - 1) + Character.toString(l < 0 ? SIGNS.charAt(10 - (int) l % 10) :
                                                                           SIGNS.charAt(     (int) l % 10));
    }
    */

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

    //
    //
    //

    /******************************************************************************
     * validLetter
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param c TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private static char validLetter(char c) {

        switch (c) {
        case 'À' : case 'Á' : case 'Â' : case 'Ã' : case 'Ä' : case 'Å' :
            return 'A';
        case 'à' : case 'á' : case 'â' : case 'ã' : case 'ä' : case 'å' :
            return 'a';
        case 'è' : case 'é' : case 'ê' : case 'ë' :
            return 'e';
        case 'Ë' : case 'É' : case 'Ê' : case 'È' :
            return 'E';
        case 'Ì' : case 'Í' : case 'Î' : case 'Ï' :
            return 'I';
        case 'ì' : case 'í' : case 'î' : case 'ï' :
            return 'i';
        case 'Ò' : case 'Ô' : case 'Ó' : case 'Õ' : case 'Ö' :
            return 'O';
        case 'ò' : case 'ó' : case 'ô' : case 'õ' : case 'ö' :
            return 'o';
        case 'Ù' : case 'Ú' : case 'Û' : case 'Ü' :
            return 'U';
        case 'ù' : case 'ú' : case 'û' : case 'ü' :
            return 'u';
        case 'Ñ' :
            return 'N';
        case 'ñ' :
            return 'n';
        case 'Ý' :
            return 'Y';
        case 'ý' : case 'ÿ' :
            return 'y';
        default :
            return c;
        }
    }

    /******************************************************************************
     * getGetterSetterSequence
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param stack TODO_javadoc.
     * @param subscript TODO_javadoc.
     * @param mode TODO_javadoc.
     * @param is_base TODO_javadoc.
     * @param is_primitive TODO_javadoc.
     * @param substring_suffix TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private String getGetterSetterSequence(Stack<DataEntryDesc> stack, String subscript, int mode, boolean is_base, boolean is_primitive, String substring_suffix) {

      //logger.debug("entrando a 'getGetterSetterSequence(subscript:" + subscript + ", is_base:" + is_base + ", is_primitive:" +  is_primitive+ ", substring_suffix:" + substring_suffix + ")' ...");

        StringBuffer  sb   = new StringBuffer();
        DataEntryDesc elem = stack.elementAt(0);

      //logger.debug(elem.name);

        if (is_base) {

            sb.append(lowering(camelCase(elem.name)));

            switch (mode) {

            case SETTER :

                if (is_primitive) {
                    sb.append((elem.occurs > 1 ? "[ " + subscript + "] " : "") + " = ");
                }
                else {
                    sb.append(".setValue(" + (elem.occurs > 1 ? subscript + ", " : ""));
                }

                if (substring_suffix != null) {
                    new RuntimeException("variable " + elem.name + " en modo SETTER con substring_suffix.");
                }

                break;

            case GETTER :

                if (elem.childs != null && !ModelUtil.isConditionalStruct(elem.childs)) {
                    sb.append(".getValue()");
                }

                if (substring_suffix != null) {

                    if (elem.type != DataEntryDesc.STRING) {
                        throw new RuntimeException("substring_suffix se estan aplicando solo a variables STRING.");
                    }

                    sb.append(substring_suffix);
                }

                break;
            }
        }
        else {

          //logger.debug("");
          //logger.debug("[" + filename + "] ============================================================================================");
          //logger.debug("[" + filename + "] " + elem.name + ", childs: " + (elem.childs != null) + ", indexer: " + elem.indexer + ", subscript: " + subscript + ", ocurrs: " + elem.occurs + " (" + DataEntryDesc.modesNames[elem.mode] + ")");
          //logger.debug("[" + filename + "] -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

            sb.append(lowering(camelCase(elem.name)));

            for (int i = 1; i < stack.size() - 1; i++) {

                elem = stack.elementAt(i);

              //logger.debug("[" + filename + "] " + elem.name + ", childs: " + (elem.childs != null) + ", indexer: " + elem.indexer + ", subscript: " + subscript + ", ocurrs: " + elem.occurs + " (" + DataEntryDesc.modesNames[elem.mode] + ")");

                sb.append(".get" + camelCase(elem.name) + "(" + (elem.indexer != null || elem.occurs > 1 ? subscript : "") + ")");

                if ((elem.indexer != null || elem.occurs > 1) && subscript == null) {
                    logger.error("[" + filename + "] ******* stack.elementAt(" + i + ").indexer es " + elem.indexer + " y subscript es nulo ******");
                }
            }

            elem = stack.elementAt(stack.size() - 1);

          //logger.debug("[" + filename + "] -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
          //logger.debug("[" + filename + "] " + elem.name + ", childs: " + (elem.childs != null) + ", indexer: " + elem.indexer + ", subscript: " + subscript + ", ocurrs: " + elem.occurs + " (" + DataEntryDesc.modesNames[elem.mode] + ")");
          //logger.debug("[" + filename + "] ============================================================================================");
          //logger.debug("");

            //
            //

            switch (mode) {

            case GETTER :

                sb.append("." + (elem.mode == DataEntryDesc.VARIABLE ? "get" : "is" /* CONDITION */) + camelCase(elem.name) + "(" + (elem.occurs > 1 ? subscript : "") + ")");

                if (elem.childs != null && !ModelUtil.isConditionalStruct(elem.childs)) {
                    sb.append(".getValue()");
                }

                if (substring_suffix != null) {

                    if (elem.type != DataEntryDesc.STRING) {
                        throw new RuntimeException("substring_suffix se estan aplicando solo a variables STRING.");
                    }

                    sb.append(substring_suffix);
                }

                break;

            case SIZER :

                sb.append(".get" + camelCase(elem.name) + "Size()");

                if (substring_suffix != null) {
                    new RuntimeException("variable " + elem.name + " en modo SIZER con substring_suffix.");
                }

                break;

            case SETTER :

                if (elem.childs != null && !ModelUtil.isConditionalStruct(elem.childs)) {
                    sb.append(".get" + camelCase(elem.name) + "().setValue(");
                }
                else {
                    sb.append(".set" + camelCase(elem.name) + "(" + (elem.occurs > 1 ? subscript + ", " : ""));
                }

                if (substring_suffix != null) {
                    new RuntimeException("variable " + elem.name + " en modo SETTER con substring_suffix.");
                }

                break;
            }
        }

      //logger.debug("saliendo de 'getGetterSetterSequence(" + sb.toString() + ")' ...");

        return sb.toString();
    }

    /******************************************************************************
     * getIdentifierSubscript
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
    private String getIdentifierSubscript(Identifier n, HashMap<String, Object> argu) {

        switch (n.f0.which) {

        /******************************************************************************
         *
         ******************************************************************************/

        case 0 : // QualifiedDataName() ( Subscript() )* [ <LPARENCHAR> LeftmostCharacterPosition() <COLONCHAR> [ Length() ] <RPARENCHAR> ]

            NodeSequence     ns        = (NodeSequence) n.f0.choice;
            NodeListOptional nlo       = (NodeListOptional) ns.elementAt(1); // ( Subscript() )*
            String           subscript = null;

            if (nlo.size() > 0) {

                if (nlo.size() > 1) {
                    throw new RuntimeException("getIdentifierSubscript:: multi-indices no implementadas aun {" + n.accept(tokenVisitor) + "}");
                }

                subscript = ((Subscript) nlo.elementAt(0)).accept(this, argu).code;
            }

            return subscript;

        /******************************************************************************
         *
         ******************************************************************************/

        case 1 : // <LINAGE_COUNTER> [ ( <IN> | <OF> ) FileName() ]

            throw new RuntimeException("getIdentifierSubscript:: <LINAGE_COUNTER> [ ( <IN> | <OF> ) FileName() ] no implementada aun {" + n.accept(tokenVisitor) + "}");

        /******************************************************************************
         *
         ******************************************************************************/

        case 2 : // <PROGRAM_STATUS>

            throw new RuntimeException("getIdentifierSubscript:: <PROGRAM_STATUS> no implementada aun {" + n.accept(tokenVisitor) + "}");
        }

        return null;
    }

    /******************************************************************************
     * getIdentifierSubstring
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
     * @param varspaths TODO_javadoc.
     * @param entryArray TODO_javadoc.
     * @param usedBases TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private String getIdentifierSubstring(Identifier n, ArrayList<String> varspaths, ArrayList<DataEntryDesc> entryArray, ArrayList<DataEntryDesc> usedBases, HashMap<String, Object> argu) {

        switch (n.f0.which) {

        /******************************************************************************
         *
         ******************************************************************************/

        case 0 : // QualifiedDataName() ( Subscript() )* [ <LPARENCHAR> LeftmostCharacterPosition() <COLONCHAR> [ Length() ] <RPARENCHAR> ]

            NodeSequence ns = (NodeSequence) n.f0.choice;
            NodeOptional no = (NodeOptional) ns.elementAt(2); // [ <LPARENCHAR> LeftmostCharacterPosition() <COLONCHAR> [ Length() ] <RPARENCHAR> ]

            if (no.present()) {

                NodeSequence              ns1 = (NodeSequence) no.node;
                LeftmostCharacterPosition lcp = (LeftmostCharacterPosition) ns1.elementAt(1);
                NodeOptional              no1 = (NodeOptional) ns1.elementAt(3);

                argu.put(TypedCode.TYPE_EXPECTED, new Integer(TypedCode.INTEGER));

                TypedCode pos_ini = lcp.f0.accept(this, argu);
                TypedCode len     = no1.present() ? ((Length) no1.node).f0.accept(this, argu) : null;

                if (len == null) {
                    logger.info("[" + filename + "] aparecio un <LPARENCHAR> LeftmostCharacterPosition() <COLONCHAR> <RPARENCHAR> ...");
                }

                return ".substring(" + pos_ini.code + " - 1" + (len != null ? ", " + pos_ini.code + " + " + len.code + " - 1" : "") + ")";
            }
            else {
                return null;
            }

        /******************************************************************************
         *
         ******************************************************************************/

        case 1 : // <LINAGE_COUNTER> [ ( <IN> | <OF> ) FileName() ]

            throw new RuntimeException("getIdentifierSubstring:: <LINAGE_COUNTER> [ ( <IN> | <OF> ) FileName() ] no implementada aun {" + n.accept(tokenVisitor) + "}");

        /******************************************************************************
         *
         ******************************************************************************/

        case 2 : // <PROGRAM_STATUS>

            throw new RuntimeException("getIdentifierSubstring:: <PROGRAM_STATUS> no implementada aun {" + n.accept(tokenVisitor) + "}");
        }

        return null;
    }

    /******************************************************************************
     * getIdentifierStackDataEntryDesc
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
     * @param varspaths TODO_javadoc.
     * @param entryArray TODO_javadoc.
     * @param usedBases TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private Stack<DataEntryDesc> getIdentifierStackDataEntryDesc(Identifier n, ArrayList<String> varspaths, ArrayList<DataEntryDesc> entryArray, ArrayList<DataEntryDesc> usedBases, HashMap<String, Object> argu) {

        switch (n.f0.which) {

        /******************************************************************************
         *
         ******************************************************************************/

        case 0 : // QualifiedDataName() ( Subscript() )* [ <LPARENCHAR> LeftmostCharacterPosition() <COLONCHAR> [ Length() ] <RPARENCHAR> ]

            NodeSequence ns = (NodeSequence) n.f0.choice;
            NodeOptional no = (NodeOptional) ns.elementAt(2); // [ <LPARENCHAR> LeftmostCharacterPosition() <COLONCHAR> [ Length() ] <RPARENCHAR> ]

            Stack<DataEntryDesc> stack = getQualifiedDataName((QualifiedDataName) ns.elementAt(0), varspaths, entryArray, usedBases, argu);

            /*
            logger.debug("[" + filename + "] ============================================================================================");

            for (int i = 0; i < stack.size(); i++) {
                logger.debug("[" + filename + "] " + stack.elementAt(i).name + ", totalLen: " + stack.elementAt(i).totalLen);
            }

            logger.debug("[" + filename + "] ============================================================================================");
            */

            if (stack.size() == 0) {
                throw new RuntimeException("identificador no encontrado. {" + ns.accept(tokenVisitor) + "}");
            }

            return stack;

        /******************************************************************************
         *
         ******************************************************************************/

        case 1 : // <LINAGE_COUNTER> [ ( <IN> | <OF> ) FileName() ]

            throw new RuntimeException("getIdentifierStackDataEntryDesc:: <LINAGE_COUNTER> [ ( <IN> | <OF> ) FileName() ] no implementada aun {" + n.accept(tokenVisitor) + "}");

        /******************************************************************************
         *
         ******************************************************************************/

        case 2 : // <PROGRAM_STATUS>

            throw new RuntimeException("getIdentifierStackDataEntryDesc:: <PROGRAM_STATUS> no implementada aun {" + n.accept(tokenVisitor) + "}");
        }

        return null;
    }

    /******************************************************************************
     * getQualifiedDataName
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
     * @param varspaths TODO_javadoc.
     * @param entryArray TODO_javadoc.
     * @param usedBases TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private Stack<DataEntryDesc> getQualifiedDataName(QualifiedDataName n, ArrayList<String> varspaths, ArrayList<DataEntryDesc> entryArray, ArrayList<DataEntryDesc> usedBases, HashMap<String, Object> argu) {

        NodeSequence         ns    = null;
        Stack<DataEntryDesc> stack = null;

        switch (n.f0.which) {

            /******************************************************************************
             *
             ******************************************************************************/

            case 0 : // DataName() ( ( <IN> | <OF> ) DataName() )* [ ( <IN> | <OF> ) FileName() ]

                ns = (NodeSequence) n.f0.choice;

              //logger.debug("[" + filename + "] {" + n.accept(tokenVisitor) + "}");

                if (((NodeOptional) ns.elementAt(2)).present()) {
                    throw new RuntimeException("getQualifiedDataName:: [ ( <IN> | <OF> ) FileName() ] no implementada aun {" + n.accept(tokenVisitor) + "}");
                }

                String chain = "/";

                NodeListOptional nlo = (NodeListOptional) ns.elementAt(1);

                for (int i = nlo.size() - 1; i >= 0 ; i--) {

                    ns    =  (NodeSequence) nlo.elementAt(i); // ( <IN> | <OF> ) DataName()
                    chain += ((DataName) ns.elementAt(1)).f0.f0.tokenImage + "(/[^/]*)+";
                }

                chain += ((DataName) ((NodeSequence) n.f0.choice).elementAt(0)).f0.f0.tokenImage + "(/@|$)";

              //logger.debug("[" + filename + "] buscando '" + chain + "'");

                stack = getQualifiedNameFromChain(chain, varspaths, entryArray, usedBases);

                /*
                logger.debug("[" + filename + "] ============================================================================================");

                for (int i = 0; i < stack.size(); i++) {
                    logger.debug("[" + filename + "] " + stack.elementAt(i).name + ", totalLen: " + stack.elementAt(i).totalLen);
                }

                logger.debug("[" + filename + "] ============================================================================================");
                */

                return stack;

            /******************************************************************************
             *
             ******************************************************************************/

            case 1 : // SpecialRegister()

                SpecialRegister      sr     = (SpecialRegister) n.f0.choice;
                Stack<DataEntryDesc> result = null;

                switch (sr.f0.which) {

                case  0 : // <ADDRESS> <OF> DataName()
                case  1 : // <DEBUG_ITEM>
                case  4 : // <SHIFT_OUT>
                case  5 : // <SHIFT_IN>
                case  6 : // <SORT_CONTROL>
                case  7 : // <SORT_CORE_SIZE>
                case  8 : // <SORT_FILE_SIZE>
                case  9 : // <SORT_MESSAGE>
                case 10 : // <SORT_MODE_SIZE>
                case 11 : // <SORT_RETURN>
                case 12 : // <TALLY>
                case 13 : // <WHEN_COMPILED>

                       throw new RuntimeException("getQualifiedDataName:: SpecialRegister no implementada aun {" + sr.f0.choice.accept(tokenVisitor) + "}");

                case  3 : // <RETURN_CODE>

                    result = new Stack<DataEntryDesc>();

                                               // level,               name,          occurs, value, redefining, indexer, type,                  ints, decs, totalLen, sign,  mode,                           offset
                    result.push(new DataEntryDesc(DataEntryDesc.UNDEF, "RETURN-CODE", 1,      null,  null,       null,    DataEntryDesc.INTEGER, 0,    0,    0,        false, DataEntryDesc.SPECIAL, DataEntryDesc.UNDEF));

                    return result;


                case  2 : // <LENGTH> <OF> Identifier()

                    ns    = (NodeSequence) sr.f0.choice;
                    stack = getIdentifierStackDataEntryDesc((Identifier) ns.elementAt(2), varspaths, entryArray, usedBases, argu);

                    /*
                    logger.debug("[" + filename + "] ============================================================================================");

                    for (int i = 0; i < stack.size(); i++) {
                        logger.debug("[" + filename + "] " + stack.elementAt(i).name + ", totalLen: " + stack.elementAt(i).totalLen);
                    }

                    logger.debug("[" + filename + "] ============================================================================================");
                    */

                    result = new Stack<DataEntryDesc>();

                    DataEntryDesc entry  = stack.elementAt(stack.size() - 1);

                                               // level,               name, occurs, value,                            redefining, indexer, type,                  ints, decs, totalLen, sign,  mode,                           offset
                    result.push(new DataEntryDesc(DataEntryDesc.UNDEF, null, 1,      Integer.toString(entry.totalLen), null,       null,    DataEntryDesc.INTEGER, 0,    0,    0,        false, DataEntryDesc.SPECIAL, DataEntryDesc.UNDEF));

                    return result;
                }
        }

        return null;
    }

    /******************************************************************************
     * getQualifiedNameFromChain
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param chain TODO_javadoc.
     * @param varspaths TODO_javadoc.
     * @param entryArray TODO_javadoc.
     * @param usedBases TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private Stack<DataEntryDesc> getQualifiedNameFromChain(String chain, ArrayList<String> varspaths, ArrayList<DataEntryDesc> entryArray, ArrayList<DataEntryDesc> usedBases) {

      //logger.debug("[" + filename + "] entrando a 'getQualifiedNameFromChain(" + chain + ")' ...");

        Stack<DataEntryDesc> result = new Stack<DataEntryDesc>();

        String  path    = null;
        Pattern pattern = Pattern.compile(chain, Pattern.CASE_INSENSITIVE);

        for (int i = 0; i < varspaths.size(); i++) {

            if (pattern.matcher(varspaths.get(i)).find()) {

                path = varspaths.get(i);

                break;
            }
        }

        if (path == null) {
            throw new RuntimeException("getQualifiedNameFromChain:: no se encontro definicion para '" + chain + "'");
        }

        int pos_ini = 1;

        /////////////////////////////////////////////////////////////
        // root
        /////////////////////////////////////////////////////////////

      //logger.debug("[" + filename + "] path: [" + path + "]");

        boolean with_child = path.endsWith("/@");
        int     length     = with_child ? path.length() - 2 : path.length();
        int     pos_fin    = path.indexOf('/', pos_ini);

        if (pos_fin == -1) {
            pos_fin = length;
        }

        String name = path.substring(pos_ini, pos_fin);

      //logger.debug("[" + filename + "] name: [" + name + "]"); // {" + pos_ini + "," + pos_fin + "}

        DataEntryDesc entry = null;

        for (int i = 0; i < entryArray.size(); i++) {

            if (entryArray.get(i).name.equals(name)) {

                entry = entryArray.get(i);

              //logger.debug("[" + filename + "] agregando a stack " + entry.name);

                result.push(entry);

                //

                if (!usedBases.contains(entry)) {

                  //logger.debug("[" + filename + "] agregando " + entry.name + " a usedBases ...");

                    usedBases.add(entry);
                }

                break;
            }
        }

        /////////////////////////////////////////////////////////////
        //
        /////////////////////////////////////////////////////////////

        while (pos_fin < length) {

          //logger.debug("[" + filename + "] pos_fin: " + pos_fin + ", length: " + length);

            pos_ini = pos_fin + 1;
            pos_fin = path.indexOf('/', pos_ini);

            if (pos_fin == -1) {
                pos_fin = length;
            }

            name = path.substring(pos_ini, pos_fin);

          //logger.debug("[" + filename + "] name: [" + name + "]{" + pos_ini + "," + pos_fin + ",length:" + length + "}");

            for (int i = 0; i < entry.childs.size(); i++) {

              //logger.debug("[" + filename + "] entry.childs.get(" + i + "): " + entry.childs.get(i).name);

                if (entry.childs.get(i).name.equals(name)) {

                    entry = entry.childs.get(i);

                    if (!ModelUtil.isConditionalStruct(entry.childs) || pos_fin == length) {

                      //logger.debug("[" + filename + "] agregando a stack " + entry.name);

                        result.push(entry);
                    }

                    break;
                }
            }
        }

        return result;
    }

}
