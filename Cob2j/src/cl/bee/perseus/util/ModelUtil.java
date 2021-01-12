/*
 *   Copyright (c) 2020 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */


package cl.bee.perseus.util;


import java.io.*;

import java.text.*;

import java.util.*;

import cl.bee.perseus.cobolparser.*;

import cl.bee.perseus.cobolparser.syntaxtree.*;

import cl.bee.perseus.cobolparser.util.*;

import cl.bee.perseus.cobolparser.visitor.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.apache.log4j.*;


/**
 * @author  alarrea@bee.cl
 * @version 1.0
 */
public class ModelUtil {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(ModelUtil.class);

    /** TODO_javadoc. */
    private static final String AUTHOR = "BEE S.A.";

    /** TODO_javadoc. */
    private static final String COPYRIGHT = "Copyright (c) " + (new SimpleDateFormat("yyyy")).format(new java.util.Date()) + " by " + AUTHOR + " All Rights Reserved.";
    /** TODO_javadoc. */
    private static final String spaces = "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ";

    /** TODO_javadoc. */
    private static int indent = 0;

    /** TODO_javadoc. */
    protected static JsonNode params = null;

    /******************************************************************************
     * ModelUtil
     ******************************************************************************/
    /**
     *
     */
    public ModelUtil() {
    }

    /******************************************************************************
     * genClazz
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param gen TODO_javadoc.
     * @param entry TODO_javadoc.
     * @param iniCompUnit TODO_javadoc.
     * @param ancestorOccurs TODO_javadoc.
     * @param package_name TODO_javadoc.
     * @param jsonparams TODO_javadoc.
     * @param filename TODO_javadoc.
     *
     */
    public static void genClazz(PrintStream gen, DataEntryDesc entry, boolean iniCompUnit, Stack<String> ancestorOccurs, String package_name, String jsonparams, String filename) {

      //logger.debug("[" + filename + "] entrando a 'genClazz(" + entry.name + ")' ...");

        if (params == null) {

            try {
                params = (new ObjectMapper()).readTree(new StringReader(jsonparams.replace('\'', '"')));
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        if (iniCompUnit) {

            gen.println(indent() + "/*");
            gen.println(indent() + " *   " + COPYRIGHT);
            gen.println(indent() + " *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF " + AUTHOR);
            gen.println(indent() + " *   The copyright notice above does not evidence any actual or intended");
            gen.println(indent() + " *   publication of such source code.");
            gen.println(indent() + " */");
            gen.println();

            if (package_name != null) {
                gen.println(indent() + "package " + package_name + ";");
                gen.println();
                gen.println();
            }

            gen.println(indent() + "import java.text.DecimalFormat;");
            gen.println();
            gen.println(indent() + "import java.util.Arrays;");
            gen.println();

            int pos = package_name.lastIndexOf('.');

            gen.println(indent() + "import " + (pos > -1 ? package_name.substring(0, pos) + "." : "") + "Root;");
            gen.println();
            gen.println(indent() + "//import org.apache.log4j.Logger;");
            gen.println();
        }

        if (entry.occurs > 1) {
            ancestorOccurs.push(camelCase(entry.name));
        }

        //

        String clazzName = camelCase(entry.name);

        gen.println(indent() + "/**");
        gen.println(indent() + " *");
        gen.println(indent() + " * TODO_javadoc.");
        gen.println(indent() + " *");
        gen.println(indent() + " * @author  " + AUTHOR);
        gen.println(indent() + " * @version 1.0");
        gen.println(indent() + " *");
        gen.println(indent() + " */");
        gen.println(indent() + "public class " + clazzName + " " + (iniCompUnit ? "extends Root " : "") + "{");
        gen.println();

        indent++;

        /////////////////////////////////////////////////
        //
        /////////////////////////////////////////////////

        if (iniCompUnit) {

            gen.println(indent() + "/** TODO_javadoc. */");
            gen.println(indent() + "//private static Logger logger = Logger.getLogger(" + clazzName + ".class);");
            gen.println();

            genDecimalFormats(gen, entry, filename);
        }

        if (entry.occurs > 1) {

            gen.println(indent() + "/** TODO_javadoc. */");
            gen.println(indent() + "private final int length_" + clazzName.toLowerCase() + " = " + (entry.totalLen / entry.occurs) + ";");
            gen.println();
            gen.println(indent() + "/** TODO_javadoc. */");
            gen.println(indent() + "private int idx_" + clazzName.toLowerCase() + ";");
            gen.println();
        }

        /////////////////////////////////////////////////
        //
        /////////////////////////////////////////////////

        if (entry.childs != null) {

            DataEntryDesc hijo = null;

            for (int i = 0; i < entry.childs.size(); i++) {

                hijo = entry.childs.get(i);

                if (hijo.childs != null && !isConditionalStruct(hijo.childs)) {

                    String hijoTypeName = camelCase(hijo.name);

                    gen.println(indent() + "/** TODO_javadoc. */");
                    gen.println(indent() + "private " + hijoTypeName + (hijo.occurs > 1 ? "[]" : "") + " " + lowering(hijoTypeName) + " = new " + hijoTypeName + (hijo.occurs > 1 ? "[" + hijo.occurs + "]" : "()") + ";");
                    gen.println();
                }
            }
        }

        /////////////////////////////////////////////////
        // constructor
        /////////////////////////////////////////////////

        gen.println(indent() + "/*******************************************************************************************************");
        gen.println(indent() + " *");
        gen.println(indent() + " *******************************************************************************************************/");
        gen.println(indent() + "/**");

        if (entry.occurs > 1) {

            gen.println(indent() + " *");
            gen.println(indent() + " * @param idx TODO_javadoc.");
        }

        gen.println(indent() + " *");
        gen.println(indent() + " */");
        gen.println(indent() + "public " + clazzName + "(" + (entry.occurs > 1 ? "int idx" : "") + ") {");

        if (iniCompUnit) {

            /////////////////////////////////////////////////
            // valores iniciales
            /////////////////////////////////////////////////

            gen.println();
            gen.println(indent() + "    initBuffer(" + entry.totalLen + ");");
            gen.println();

            if (entry.value == null) {

                ArrayList<DataEntryDesc> array = new ArrayList<DataEntryDesc>();

                array.add(entry);

                String str = initValue(array, filename);

                if (str.length() != entry.totalLen * (entry.redefining == null ? entry.occurs : 1)) {
                    logger.debug("[" + filename + "] largo (" + str.length() + ") de valor default de " + entry.name + " es distinto al actual (" + entry.totalLen + (entry.redefining == null ? " * " + entry.occurs : "") + ")");
                }

                gen.println(indent() + "    replaceValue(" + entry.offset + ", " + (entry.offset + entry.totalLen) + ", \"" + str + "\"); // " + entry.name);
            }

            printInitialValues(gen, entry, filename);
        }

        //

        if (entry.childs != null) {

            DataEntryDesc hijo = null;

            for (int i = 0; i < entry.childs.size(); i++) {

                hijo = entry.childs.get(i);

                if (hijo.childs != null && hijo.occurs > 1 && !isConditionalStruct(hijo.childs)) {

                    String hijoTypeName = camelCase(hijo.name);

                    gen.println();
                    gen.println(indent() + "    for (int i = 0; i < " + hijo.occurs + "; i++) {");
                    gen.println(indent() + "        " + lowering(hijoTypeName) + "[i] = new " + hijoTypeName + "(i);");
                    gen.println(indent() + "    }");
                }
            }
        }

        if (entry.occurs > 1) {
            gen.println();
            gen.println(indent() + "    this.idx_" + clazzName.toLowerCase() + " = idx;");
        }

        gen.println(indent() + "}");
        gen.println();

        //

        boolean ics = isConditionalStruct(entry.childs) || entry.childs == null;

        gen.println(indent() + "//");
        gen.println(indent() + "//");
        gen.println(indent() + "//");
        gen.println();
        gen.println(indent() + "/*******************************************************************************************************");
        gen.println(indent() + " * setValue");
        gen.println(indent() + " *******************************************************************************************************/");
        gen.println(indent() + "/**");
        gen.println(indent() + " *");
        gen.println(indent() + " * @param value TODO_javadoc.");
        gen.println(indent() + " *");
        gen.println(indent() + " */");

      //logger.debug("[" + filename + "] " + entry);

      //gen.println(indent() + "public void setValue(" + (ics                               ? DataEntryDesc.javaNames[entry.type] : "String") + " value) {");
        gen.println(indent() + "public void setValue(" + (entry.type != DataEntryDesc.UNDEF ? DataEntryDesc.javaNames[entry.type] : "String") + " value) {");

        if (entry.type != DataEntryDesc.UNDEF) {

            if (entry.childs != null) {

                switch (entry.type) {

                case DataEntryDesc.INTEGER :
                case DataEntryDesc.LONG :

                    gen.println(indent() + "    replaceValue(" + genAbsolutePosition(ancestorOccurs, 0) + entry.offset + ", " + genAbsolutePosition(ancestorOccurs, 0) + (entry.offset + entry.totalLen / entry.occurs) + ", " + getStringValue(entry, "value", false, filename) + ");");

                    break;

                case DataEntryDesc.STRING :

                    gen.println(indent() + "    replaceValue(" + genAbsolutePosition(ancestorOccurs, 0) + entry.offset + ", " + genAbsolutePosition(ancestorOccurs, 0) + (entry.offset + entry.totalLen / entry.occurs) + ", " + getStringValue(entry, "value", false, filename) + ");");

                    break;
                }
            }
            else {
                gen.println(indent() + "    replaceValue(" + genAbsolutePosition(ancestorOccurs, 0) + entry.offset + ", " + genAbsolutePosition(ancestorOccurs, 0) + (entry.offset + entry.totalLen / entry.occurs) + ", " + getStringValue(entry, "value", false, filename) + ");");
            }

        } else {
            gen.println(indent() +     "    replaceValue(" + genAbsolutePosition(ancestorOccurs, 0) + entry.offset + ", " + genAbsolutePosition(ancestorOccurs, 0) + (entry.offset + entry.totalLen / entry.occurs) + ", value);");
        }

        gen.println(indent() + "}");
        gen.println();

        //
        //
        //

        gen.println(indent() + "/*******************************************************************************************************");
        gen.println(indent() + " * getValue");
        gen.println(indent() + " *******************************************************************************************************/");
        gen.println(indent() + "/**");
        gen.println(indent() + " *");
        gen.println(indent() + " * @return value TODO_javadoc.");
        gen.println(indent() + " *");
        gen.println(indent() + " */");

      //gen.println(indent() + "public " + (ics                               ? DataEntryDesc.javaNames[entry.type] : "String") + " getValue() {");
        gen.println(indent() + "public " + (entry.type != DataEntryDesc.UNDEF ? DataEntryDesc.javaNames[entry.type] : "String") + " getValue() {");

        if (entry.type != DataEntryDesc.UNDEF) {

          //logger.debug("[" + filename + "] name: " + entry.name + ", offset: " + entry.offset + ", totalLen: " + entry.totalLen + ", occurs: " + entry.occurs + ", type: " + DataEntryDesc.javaNames[entry.type]);

            gen.println(indent() + "    return " +  getTypeValue(entry, entry, ancestorOccurs, true, filename) + ";");

        } else {
            gen.println(indent() + "    return subValue(" + genAbsolutePosition(ancestorOccurs, 0) + entry.offset + ", " + genAbsolutePosition(ancestorOccurs, 1) + (entry.offset + entry.totalLen / entry.occurs) + ");");
        }

        gen.println(indent() + "}");
        gen.println();
        gen.println(indent() + "//");
        gen.println(indent() + "//");
        gen.println(indent() + "//");
        gen.println();

        /////////////////////////////////////////////////
        // setters
        /////////////////////////////////////////////////

        genSetters(gen, entry, ancestorOccurs, filename);

        /////////////////////////////////////////////////
        // getters
        /////////////////////////////////////////////////

        genGetters(gen, entry, ancestorOccurs, filename);

        /////////////////////////////////////////////////
        //
        /////////////////////////////////////////////////

        genConditions(gen, entry, true/*direct*/, filename);

        if (entry.childs != null) {

            DataEntryDesc hijo = null;

            for (int i = 0; i < entry.childs.size(); i++) {

                hijo = entry.childs.get(i);

                if (hijo.childs != null && isConditionalStruct(hijo.childs)) {
                    genConditions(gen, hijo, false/*direct*/, filename);
                }
            }
        }

        /////////////////////////////////////////////////
        // inner classes
        /////////////////////////////////////////////////

        if (entry.childs != null) {

            DataEntryDesc hijo = null;

            for (int i = 0; i < entry.childs.size(); i++) {

                hijo = entry.childs.get(i);

                if (hijo.childs != null && !isConditionalStruct(hijo.childs)) {
                    genClazz(gen, hijo, false/*iniCompUnit*/, ancestorOccurs, package_name, jsonparams, filename);
                }
            }
        }

        /////////////////////////////////////////////////
        //
        /////////////////////////////////////////////////

        indent--;

        gen.println(indent() + "}");
        gen.println();

        //

        if (entry.occurs > 1) {
            ancestorOccurs.pop();
        }
    }

    /******************************************************************************
     * getStringInitial
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param entry TODO_javadoc.
     * @param filename TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public static String getStringInitial(DataEntryDesc entry, String filename) {

      //logger.debug("[" + filename + "] entrando a 'getStringInitial(" + entry + ")' ...");

        String value = null;

        if      (entry.value instanceof Integer) {
            value = ((Integer) entry.value).toString();
        }
        else if (entry.value instanceof Long) {
            value = ((Long) entry.value).toString();
        }
        else if (entry.value instanceof Double) {
            value = ((Double) entry.value).toString();
        }
        else  { // if (entry.value instanceof String)
            value = (String) entry.value;
        }

        //

        switch (entry.type) {

        case DataEntryDesc.INTEGER :
        case DataEntryDesc.LONG :

            if (entry.sign) {
                return "setCompNumber(" + value + ", form" + (entry.ints) + "z)";
            }
            else {
                return "form" + (entry.ints) + "z.format(" + value + ")";
            }

        case DataEntryDesc.DOUBLE :

            if (entry.ints + entry.decs > 18) {
                logger.warn("[" + filename + "] cantidad digitos significativos de " + entry.name + " excede maximo.");
            }

            if (entry.sign) {
                return "setCompNumber((long) (" + value + " * Math.pow(10, " + entry.decs + ")), form" + (entry.ints + entry.decs) + "z)";
            }
            else {
                return "form" + (entry.ints + entry.decs) + "z.format((long) (" + value + " * Math.pow(10, " + entry.decs + ")))";
            }

        case DataEntryDesc.STRING :

             return value;

        case DataEntryDesc.UNDEF :

            throw new RuntimeException(entry.name + " tienen tipo UNDEF");
        }

        return null;
    }

    /******************************************************************************
     * isConditionalStruct
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param array TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public static boolean isConditionalStruct(ArrayList<DataEntryDesc> array) {

        if (array == null) {
            return false;
        }

        for (int i = 0; i < array.size(); i++) {

            if (array.get(i).mode != DataEntryDesc.CONDITION) {
                return false;
            }
        }

        return true;
    }

    //
    //
    //

    /******************************************************************************
     * initValue
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param entryArray TODO_javadoc.
     * @param filename TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private static String initValue(ArrayList<DataEntryDesc> entryArray, String filename) {

      //logger.debug("[" + filename + "] entrando a 'initValue()' ...");

        StringBuffer  sb    = new StringBuffer();
        DataEntryDesc entry = null;

        for (int i = 0; i < entryArray.size(); i++) {

            entry = entryArray.get(i);

          //logger.debug("[" + filename + "] entry " + entry.name);

            if (entry.mode == DataEntryDesc.CONDITION) {
                continue;
            }

            if (entry.redefining != null && entryArray.size() > 1) {
                continue;
            }

            String str = null;

            if        (isConditionalStruct(entry.childs)) {

                str = initValue(entry, filename);

              //logger.debug("[" + filename + "] (1) agregando valor default de largo " + str.length() + " (" + entry.name + ")");

                sb.append(str);

            } else if (entry.childs != null) {

                str = initValue(entry.childs, filename);

                for (int j = 0; j < entry.occurs; j++) {
                    sb.append(str);
                }

              //logger.debug("[" + filename + "] (2) agregando " + entry.occurs + " ve(z)(ces) valor default de largo " + str.length() + " (" + entry.name + ")");
            }
            else {

                str = initValue(entry, filename);

              //logger.debug("[" + filename + "] (3) agregando valor default de largo " + str.length() + " (" + entry.name + ")");

                sb.append(str);
            }
        }

      //logger.debug("[" + filename + "] saliendo 'initValue()' ...");

        return sb.toString();
    }

    /******************************************************************************
     * initValue
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param entry TODO_javadoc.
     * @param filename TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private static String initValue(DataEntryDesc entry, String filename) {

        String       str = null;
        StringBuffer sb  = new StringBuffer();

        switch (entry.type) {

        case DataEntryDesc.INTEGER :
        case DataEntryDesc.LONG :

            str = entry.sign ? genZeroes(entry.ints              - 1) + "{" : genZeroes(entry.ints);

          //logger.debug("[" + filename + "] agregando " + entry.ints + " cero(s) (" + DataEntryDesc.typesNames[entry.type] + ")");

            break;

        case DataEntryDesc.DOUBLE :

            str = entry.sign ? genZeroes(entry.ints + entry.decs - 1) + "{" : genZeroes(entry.ints + entry.decs);

          //logger.debug("[" + filename + "] agregando " + (entry.ints + entry.decs) + " cero(s) (" + DataEntryDesc.typesNames[entry.type] + ")");

            break;

        case DataEntryDesc.STRING :

            str = genSpaces(entry.totalLen / entry.occurs); // entry.occurs se usa abajo

          //logger.debug("[" + filename + "] agregando " + entry.totalLen + " espacio(s) (" + DataEntryDesc.typesNames[entry.type] + ")");

            break;

        case DataEntryDesc.UNDEF :

            throw new RuntimeException(entry.name + " tienen tipo " + entry.type);
        }

        if (entry.occurs > 1) {
          //logger.debug("[" + filename + "] agregando " + entry.occurs + " ve(z)(ces) valor default de largo " + str.length());
        }

        for (int j = 0; j < entry.occurs; j++) {
            sb.append(str);
        }

        return sb.toString();
    }

    /******************************************************************************
     * genSpaces
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param len TODO_javadoc.
     *
     */
    private static String genSpaces(int len) {

        char[] arr = new char[len];

        Arrays.fill(arr, ' ');

        return new String(arr);
    }

    /******************************************************************************
     * genZeroes
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param len TODO_javadoc.
     *
     */
    private static String genZeroes(int len) {

        char[] arr = new char[len];

        Arrays.fill(arr, '0');

        return new String(arr);
    }

    /******************************************************************************
     * genConditions
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param gen TODO_javadoc.
     * @param entry TODO_javadoc.
     * @param direct TODO_javadoc.
     * @param filename TODO_javadoc.
     *
     */
    private static void genConditions(PrintStream gen, DataEntryDesc entry, boolean direct, String filename) {

      //logger.debug("[" + filename + "] entrando a 'genConditions(" + entry.name + "," + direct + ")' ...");

        if (entry.childs != null) {

            String  methodName = null;
          //boolean ics        = isConditionalStruct(entry.childs);

          //logger.debug("[" + filename + "] ics: " + ics);

            for (int j = 0; j < entry.childs.size(); j++) {

                if (entry.childs.get(j).mode == DataEntryDesc.CONDITION) {

                    gen.println(indent() + "/*******************************************************************************************************");
                    gen.println(indent() + " * set" + camelCase(entry.childs.get(j).name));
                    gen.println(indent() + " *******************************************************************************************************/");
                    gen.println(indent() + "/**");
                    gen.println(indent() + " *");
                    gen.println(indent() + " * @param " + lowerCamelCase(entry.childs.get(j).name) + " TODO_javadoc.");
                    gen.println(indent() + " *");
                    gen.println(indent() + " */");
                    gen.println(indent() + "public void set" + camelCase(entry.childs.get(j).name) + "(boolean " + lowerCamelCase(entry.childs.get(j).name) + ") {");
                    gen.println();
                    gen.println(indent() + "    if (!" + lowerCamelCase(entry.childs.get(j).name) + ") {");
                    gen.println(indent() + "        throw new RuntimeException(\"Se intento setear " + lowerCamelCase(entry.childs.get(j).name) + " con false.\");");
                    gen.println(indent() + "    }");
                    gen.println();

                    if (direct) {
                        methodName = /*ics ?*/ "Value"               /*: camelCase(entry.name)*/;
                    }
                    else {
                        methodName = /*ics ?*/ camelCase(entry.name) /*: "Value"*/;
                    }

                  //logger.debug([" + filename + "] entry.childs.get(j).name + " --> " + methodName);

                    if (entry.childs.get(j).value instanceof TreeSet) {
                        gen.print(indent() + "        throw new RuntimeException(\"Se intento setear " + lowerCamelCase(entry.childs.get(j).name) + " (multivaluada).\");");
                    }
                    else {
                        gen.println(indent() + "    set" + methodName + "(" + entry.childs.get(j).value + ");"); // idx
                    }

                    gen.println(indent() + "}");
                    gen.println();
                    gen.println(indent() + "/*******************************************************************************************************");
                    gen.println(indent() + " * is" + camelCase(entry.childs.get(j).name));
                    gen.println(indent() + " *******************************************************************************************************/");
                    gen.println(indent() + "/**");
                    gen.println(indent() + " *");
                    gen.println(indent() + " * @return " + lowerCamelCase(entry.childs.get(j).name) + " TODO_javadoc.");
                    gen.println(indent() + " *");
                    gen.println(indent() + " */");
                    gen.println(indent() + "public boolean is" + camelCase(entry.childs.get(j).name) + "() {");

                    if (direct) {
                        methodName = /*ics ?*/ "Value"               /*: camelCase(entry.name)*/;
                    }
                    else {
                        methodName = /*ics ?*/ camelCase(entry.name) /*: "Value"*/;
                    }

                  //logger.debug([" + filename + "] entry.childs.get(j).name + " --> " + methodName);

                    if (entry.childs.get(j).value instanceof TreeSet) {

                        gen.print  (indent() + "    return Arrays.binarySearch(new Object[] { ");

                        TreeSet tree  = (TreeSet) entry.childs.get(j).value;
                        boolean first = true;

                        for (Iterator iter = tree.iterator(); iter.hasNext(); ) {

                            if (first) {
                                first = false;
                            }
                            else {
                                gen.print(", ");
                            }

                            gen.print(iter.next());
                        }

                        gen.println(" }, get" + methodName + "()) >= 0;"); // idx
                    }
                    else {

                        if (entry.type == DataEntryDesc.UNDEF || DataEntryDesc.javaObjects[entry.type]) {
                            gen.println(indent() + "    return get" + methodName + "().equals(" + entry.childs.get(j).value + ");"); // idx
                        }
                        else {
                            gen.println(indent() + "    return get" + methodName + "() == " + entry.childs.get(j).value + ";"); // idx
                        }
                    }

                    gen.println(indent() + "}");
                    gen.println();
                }
            }
        }
    }

    /******************************************************************************
     * printInitialValues
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param gen TODO_javadoc.
     * @param entry TODO_javadoc.
     * @param filename TODO_javadoc.
     *
     */
    private static void printInitialValues(PrintStream gen, DataEntryDesc entry, String filename) {

        if (entry.value != null) {
            gen.println(indent() + "    replaceValue(" + entry.offset + ", " + (entry.offset + entry.totalLen) + ", " + getStringInitial(entry, filename) + "); // " + entry.name);
        }

        if (entry.childs != null) {

            DataEntryDesc hijo = null;

            for (int i = 0; i < entry.childs.size(); i++) {

                hijo = entry.childs.get(i);

                if (hijo.mode == DataEntryDesc.CONDITION) {
                    continue;
                }

                printInitialValues(gen, hijo, filename);
            }
        }
    }

    /******************************************************************************
     * genDecimalFormats
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param gen TODO_javadoc.
     * @param entry TODO_javadoc.
     * @param filename TODO_javadoc.
     *
     */
    private static void genDecimalFormats(PrintStream gen, DataEntryDesc entry, String filename) {

      //logger.debug("[" + filename + "] entrando a 'genDecimalFormats(" + entry.name + ")' ...");

        /////////////////////////////////////////////////
        // form<n>z
        /////////////////////////////////////////////////

        TreeSet<Integer> set = new TreeSet<Integer>();

        getDecimalSizes(entry, set, filename);

        for (Iterator<Integer> iter = set.iterator(); iter.hasNext(); ) {

            Integer n = iter.next();

            gen.println(indent() + "/** TODO_javadoc. */");
            gen.println(indent() + "private static DecimalFormat form" + n + "z = new DecimalFormat(\"" + genZeroes(n.intValue()) + "\");");
            gen.println();
        }
    }

    /******************************************************************************
     * getDecimalSizes
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param entry TODO_javadoc.
     * @param set TODO_javadoc.
     * @param filename TODO_javadoc.
     *
     */
    private static void getDecimalSizes(DataEntryDesc entry, TreeSet<Integer> set, String filename) {

      //logger.debug("[" + filename + "] entrando a 'getDecimalSizes(" + entry.name + ")' ...");

        if (isNumeric(entry.type)) {

            Integer n = new Integer(entry.ints + entry.decs);

            if (!set.contains(n)) {
                set.add(n);
            }
        }

        if (entry.childs != null) {

            DataEntryDesc hijo = null;

            for (int i = 0; i < entry.childs.size(); i++) {

                hijo = entry.childs.get(i);

                if (hijo.mode == DataEntryDesc.CONDITION) {
                    continue;
                }

                if (isNumeric(hijo.type)) {

                    Integer n = new Integer(hijo.ints + hijo.decs);

                    if (!set.contains(n)) {
                        set.add(n);
                    }
                }

                if (hijo.childs != null) {
                    getDecimalSizes(hijo, set, filename);
                }
            }
        }
    }

    /******************************************************************************
     * isNumeric
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param type TODO_javadoc.
     *
     */
    private static boolean isNumeric(int type) {

        switch (type) {

        case DataEntryDesc.INTEGER :
        case DataEntryDesc.LONG :
        case DataEntryDesc.DOUBLE :
            return true;
        case DataEntryDesc.STRING :
        case DataEntryDesc.UNDEF :
        }

        return false;
    }

    /******************************************************************************
     * genSetters
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param gen TODO_javadoc.
     * @param entry TODO_javadoc.
     * @param ancestorOccurs TODO_javadoc.
     * @param filename TODO_javadoc.
     *
     */
    private static void genSetters(PrintStream gen, DataEntryDesc entry, Stack<String> ancestorOccurs, String filename) {

        if (entry.childs == null) {

          //logger.debug("[" + filename + "] entry: " + entry.name);

            return;
        }

        String clazzName = camelCase(entry.name);

        DataEntryDesc hijo = null;

        for (int i = 0; i < entry.childs.size(); i++) {

            hijo = entry.childs.get(i);

            if (hijo.mode == DataEntryDesc.CONDITION) {
                continue;
            }

            if (hijo.childs != null) { // struct

                if (isConditionalStruct(hijo.childs)) {

                    String hijoTypeName = camelCase(hijo.name);

                    if (hijo.type == DataEntryDesc.DOUBLE) {

                        gen.println(indent() + "/*******************************************************************************************************");
                        gen.println(indent() + " * set" + hijoTypeName);
                        gen.println(indent() + " *******************************************************************************************************/");
                        gen.println(indent() + "/**");
                        gen.println(indent() + " *");
                        gen.println(indent() + " * @param " + lowering(hijoTypeName) + " TODO_javadoc.");
                        gen.println(indent() + " *");
                        gen.println(indent() + " */");
                        gen.println(indent() + "public void set" + hijoTypeName + "(" +  DataEntryDesc.javaNames[hijo.type] + " " + lowering(hijoTypeName) + ") {");
                        gen.println(indent() + "    set" + hijoTypeName + "(" + lowering(hijoTypeName) + ", TRUNCATED);");
                        gen.println(indent() + "}");
                        gen.println();
                        gen.println(indent() + "/*******************************************************************************************************");
                        gen.println(indent() + " * set" + hijoTypeName);
                        gen.println(indent() + " *******************************************************************************************************/");
                        gen.println(indent() + "/**");
                        gen.println(indent() + " *");
                        gen.println(indent() + " * @param " + lowering(hijoTypeName) + " TODO_javadoc.");
                        gen.println(indent() + " * @param rounded TODO_javadoc.");
                        gen.println(indent() + " *");
                        gen.println(indent() + " */");
                        gen.println(indent() + "public void set" + hijoTypeName + "(" +  DataEntryDesc.javaNames[hijo.type] + " " + lowering(hijoTypeName) + ", boolean rounded) {");
                        gen.println(indent() + "    replaceValue(" + (entry.occurs > 1 || ancestorOccurs.size() > 0 ? "idx_" + clazzName.toLowerCase() + " * length_" + hijoTypeName.toLowerCase() + " + " : "") + hijo.offset + ", " + (entry.occurs > 1 || ancestorOccurs.size() > 0 ? "idx_" + clazzName.toLowerCase() + " * length_" + hijoTypeName.toLowerCase() + " + " : "") + (hijo.offset + hijo.totalLen / hijo.occurs) + ", " + getStringValue(hijo, null, false, filename) + ");");
                        gen.println(indent() + "}");
                        gen.println();
                    }
                    else {

                        gen.println(indent() + "/*******************************************************************************************************");
                        gen.println(indent() + " * set" + hijoTypeName);
                        gen.println(indent() + " *******************************************************************************************************/");
                        gen.println(indent() + "/**");
                        gen.println(indent() + " *");
                        gen.println(indent() + " * @param " + lowering(hijoTypeName) + " TODO_javadoc.");
                        gen.println(indent() + " *");
                        gen.println(indent() + " */");
                        gen.println(indent() + "public void set" + hijoTypeName + "(" +  DataEntryDesc.javaNames[hijo.type] + " " + lowering(hijoTypeName) + ") {");
                        gen.println(indent() + "    replaceValue(" + (entry.occurs > 1 || ancestorOccurs.size() > 0 ? "idx_" + clazzName.toLowerCase() + " * length_" + hijoTypeName.toLowerCase() + " + " : "") + hijo.offset + ", " + (entry.occurs > 1 || ancestorOccurs.size() > 0 ? "idx_" + clazzName.toLowerCase() + " * length_" + hijoTypeName.toLowerCase() + " + " : "") + (hijo.offset + hijo.totalLen / hijo.occurs) + ", " + getStringValue(hijo, null, false, filename) + ");");
                        gen.println(indent() + "}");
                        gen.println();
                    }
                }
            }
            else { // simple

                if (hijo.type == DataEntryDesc.DOUBLE) {

                    gen.println(indent() + "/*******************************************************************************************************");
                    gen.println(indent() + " * set" + camelCase(hijo.name));
                    gen.println(indent() + " *******************************************************************************************************/");
                    gen.println(indent() + "/**");
                    gen.println(indent() + " *");
                    gen.println(indent() + " * @param " + lowerCamelCase(hijo.name) + " TODO_javadoc.");
                    gen.println(indent() + " *");
                    gen.println(indent() + " */");
                    gen.println(indent() + "public void set" + camelCase(hijo.name) + "(" + DataEntryDesc.javaNames[hijo.type] + (hijo.occurs > 1 ? "[]" : "") +  " " + lowerCamelCase(hijo.name) + ") {");
                    gen.println(indent() + "    set" + camelCase(hijo.name) + "(" + lowerCamelCase(hijo.name) + ", TRUNCATED);");
                    gen.println(indent() + "}");
                    gen.println();
                    gen.println(indent() + "/*******************************************************************************************************");
                    gen.println(indent() + " * set" + camelCase(hijo.name));
                    gen.println(indent() + " *******************************************************************************************************/");
                    gen.println(indent() + "/**");
                    gen.println(indent() + " *");
                    gen.println(indent() + " * @param " + lowerCamelCase(hijo.name) + " TODO_javadoc.");
                    gen.println(indent() + " * @param rounded TODO_javadoc.");
                    gen.println(indent() + " *");
                    gen.println(indent() + " */");
                    gen.println(indent() + "public void set" + camelCase(hijo.name) + "(" + DataEntryDesc.javaNames[hijo.type] + (hijo.occurs > 1 ? "[]" : "") +  " " + lowerCamelCase(hijo.name) + ", boolean rounded) {");

                    if (hijo.occurs > 1) {

                        gen.println();
                        gen.println(indent() + "    if (" + lowerCamelCase(hijo.name) + " == null || " + lowerCamelCase(hijo.name) + ".length != " + hijo.occurs + ") {");
                        gen.println(indent() + "        throw new IllegalArgumentException(\"" + lowerCamelCase(hijo.name) + "[]: no debe ser nulo y largo debe ser " + hijo.occurs + "\");");
                        gen.println(indent() + "    }");
                        gen.println();
                        gen.println(indent() + "    for (int i = 0; i < " + hijo.occurs + "; i++) {");
                        gen.println(indent() + "        replaceValue(" + genAbsolutePosition(ancestorOccurs, 0) + hijo.offset + " + " + (hijo.totalLen / hijo.occurs) + " * i, " + genAbsolutePosition(ancestorOccurs, 0) +  hijo.offset + " + " + (hijo.totalLen / hijo.occurs) + " * (i + 1), " + getStringValue(hijo, null, true, filename) +  ");");
                        gen.println(indent() + "    }");
                    }
                    else {
                        gen.println(indent() +     "    replaceValue(" + genAbsolutePosition(ancestorOccurs, 0) + hijo.offset +                                             ", " + genAbsolutePosition(ancestorOccurs, 0) + (hijo.offset +          hijo.totalLen) +                         ", " + getStringValue(hijo, null, false, filename) + ");");
                    }

                    gen.println(indent() + "}");
                    gen.println();

                    if (hijo.occurs > 1) {

                        gen.println(indent() + "/*******************************************************************************************************");
                        gen.println(indent() + " * set" + camelCase(hijo.name));
                        gen.println(indent() + " *******************************************************************************************************/");
                        gen.println(indent() + "/**");
                        gen.println(indent() + " *");
                        gen.println(indent() + " * @param i TODO_javadoc.");
                        gen.println(indent() + " * @param " + lowerCamelCase(hijo.name) + " TODO_javadoc.");
                        gen.println(indent() + " *");
                        gen.println(indent() + " */");
                        gen.println(indent() + "public void set" + camelCase(hijo.name) + "(int i, " + DataEntryDesc.javaNames[hijo.type] +  " " + lowerCamelCase(hijo.name) + ") {");
                        gen.println(indent() + "    set" + camelCase(hijo.name) + "(" + lowerCamelCase(hijo.name) + ", i, TRUNCATED);");
                        gen.println(indent() + "}");
                        gen.println();
                        gen.println(indent() + "/*******************************************************************************************************");
                        gen.println(indent() + " * set" + camelCase(hijo.name));
                        gen.println(indent() + " *******************************************************************************************************/");
                        gen.println(indent() + "/**");
                        gen.println(indent() + " *");
                        gen.println(indent() + " * @param i TODO_javadoc.");
                        gen.println(indent() + " * @param " + lowerCamelCase(hijo.name) + " TODO_javadoc.");
                        gen.println(indent() + " * @param rounded TODO_javadoc.");
                        gen.println(indent() + " *");
                        gen.println(indent() + " */");
                        gen.println(indent() + "public void set" + camelCase(hijo.name) + "(int i, " + DataEntryDesc.javaNames[hijo.type] +  " " + lowerCamelCase(hijo.name) + ", boolean rounded) {");
                        gen.println();
                        gen.println(indent() + "    if (i < 0 || i >= " + hijo.occurs + ") {");
                        gen.println(indent() + "        throw new ArrayIndexOutOfBoundsException(\"" + lowerCamelCase(hijo.name) + "[]: indice debe estar en rango [0.." + (hijo.occurs - 1) + "]\");");
                        gen.println(indent() + "    }");
                        gen.println();
                        gen.println(indent() + "    replaceValue(" + genAbsolutePosition(ancestorOccurs, 0) + hijo.offset + " + " + (hijo.totalLen / hijo.occurs) + " * i, " + genAbsolutePosition(ancestorOccurs, 0) + hijo.offset + " + " + (hijo.totalLen / hijo.occurs) + " * (i + 1), " + getStringValue(hijo, null, false, filename) + ");");
                        gen.println(indent() + "}");
                        gen.println();
                    }
                }
                else {

                    gen.println(indent() + "/*******************************************************************************************************");
                    gen.println(indent() + " * set" + camelCase(hijo.name));
                    gen.println(indent() + " *******************************************************************************************************/");
                    gen.println(indent() + "/**");
                    gen.println(indent() + " *");
                    gen.println(indent() + " * @param " + lowerCamelCase(hijo.name) + " TODO_javadoc.");
                    gen.println(indent() + " *");
                    gen.println(indent() + " */");
                    gen.println(indent() + "public void set" + camelCase(hijo.name) + "(" + DataEntryDesc.javaNames[hijo.type] + (hijo.occurs > 1 ? "[]" : "") +  " " + lowerCamelCase(hijo.name) + ") {");

                    if (hijo.occurs > 1) {

                        gen.println();
                        gen.println(indent() + "    if (" + lowerCamelCase(hijo.name) + " == null || " + lowerCamelCase(hijo.name) + ".length != " + hijo.occurs + ") {");
                        gen.println(indent() + "        throw new IllegalArgumentException(\"" + lowerCamelCase(hijo.name) + "[]: no debe ser nulo y largo debe ser " + hijo.occurs + "\");");
                        gen.println(indent() + "    }");
                        gen.println();
                        gen.println(indent() + "    for (int i = 0; i < " + hijo.occurs + "; i++) {");
                        gen.println(indent() + "        replaceValue(" + genAbsolutePosition(ancestorOccurs, 0) + hijo.offset + " + " + (hijo.totalLen / hijo.occurs) + " * i, " + genAbsolutePosition(ancestorOccurs, 0) +  hijo.offset + " + " + (hijo.totalLen / hijo.occurs) + " * (i + 1), " + getStringValue(hijo, null, true, filename) +  ");");
                        gen.println(indent() + "    }");
                    }
                    else {
                        gen.println(indent() +     "    replaceValue(" + genAbsolutePosition(ancestorOccurs, 0) + hijo.offset +                                             ", " + genAbsolutePosition(ancestorOccurs, 0) + (hijo.offset +          hijo.totalLen) +                         ", " + getStringValue(hijo, null, false, filename) + ");");
                    }

                    gen.println(indent() + "}");
                    gen.println();

                    if (hijo.occurs > 1) {

                        gen.println(indent() + "/*******************************************************************************************************");
                        gen.println(indent() + " * set" + camelCase(hijo.name));
                        gen.println(indent() + " *******************************************************************************************************/");
                        gen.println(indent() + "/**");
                        gen.println(indent() + " *");
                        gen.println(indent() + " * @param i TODO_javadoc.");
                        gen.println(indent() + " * @param " + lowerCamelCase(hijo.name) + " TODO_javadoc.");
                        gen.println(indent() + " *");
                        gen.println(indent() + " */");
                        gen.println(indent() + "public void set" + camelCase(hijo.name) + "(int i, " + DataEntryDesc.javaNames[hijo.type] +  " " + lowerCamelCase(hijo.name) + ") {");
                        gen.println();
                        gen.println(indent() + "    if (i < 0 || i >= " + hijo.occurs + ") {");
                        gen.println(indent() + "        throw new ArrayIndexOutOfBoundsException(\"" + lowerCamelCase(hijo.name) + "[]: indice debe estar en rango [0.." + (hijo.occurs - 1) + "]\");");
                        gen.println(indent() + "    }");
                        gen.println();
                        gen.println(indent() + "    replaceValue(" + genAbsolutePosition(ancestorOccurs, 0) + hijo.offset + " + " + (hijo.totalLen / hijo.occurs) + " * i, " + genAbsolutePosition(ancestorOccurs, 0) + hijo.offset + " + " + (hijo.totalLen / hijo.occurs) + " * (i + 1), " + getStringValue(hijo, null, false, filename) + ");");
                        gen.println(indent() + "}");
                        gen.println();
                    }
                }
            }
        }
    }

    /******************************************************************************
     * genGetters
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param gen TODO_javadoc.
     * @param entry TODO_javadoc.
     * @param ancestorOccurs TODO_javadoc.
     * @param filename TODO_javadoc.
     *
     */
    private static void genGetters(PrintStream gen, DataEntryDesc entry, Stack<String> ancestorOccurs, String filename) {

        if (entry.childs == null) {

          //logger.debug("[" + filename + "] entry: " + entry.name);

            return;
        }

        DataEntryDesc hijo = null;

        for (int i = 0; i < entry.childs.size(); i++) {

            hijo = entry.childs.get(i);

            if (hijo.mode == DataEntryDesc.CONDITION) {
                continue;
            }

            if (hijo.childs != null) { // struct

                String hijoTypeName = camelCase(hijo.name);

                gen.println(indent() + "/*******************************************************************************************************");
                gen.println(indent() + " * get" + hijoTypeName);
                gen.println(indent() + " *******************************************************************************************************/");
                gen.println(indent() + "/**");
                gen.println(indent() + " *");

                if (hijo.occurs > 1) {

                    gen.println(indent() + " * @param i TODO_javadoc.");
                    gen.println(indent() + " *");
                }

                gen.println(indent() + " * @return " + lowering(hijoTypeName) + " TODO_javadoc.");
                gen.println(indent() + " *");
                gen.println(indent() + " */");

                if (isConditionalStruct(hijo.childs)) {
                    gen.println(indent() + "public " + DataEntryDesc.javaNames[hijo.type] + " get" + hijoTypeName + "() {");
                    gen.println(indent() + "    return " + getTypeValue(entry, hijo, ancestorOccurs, false, filename) + ";");
                }
                else {

                    gen.println(indent() + "public " + hijoTypeName + " get" + hijoTypeName + "(" + (hijo.occurs > 1 ? "int i" : "") + ") {");

                    if (hijo.occurs > 1) {

                        gen.println();
                        gen.println(indent() + "    if (i < 0 || i >= " + hijo.occurs + ") {");
                        gen.println(indent() + "        throw new ArrayIndexOutOfBoundsException(\"" + lowerCamelCase(hijo.name) + "[]: indice debe estar en rango [0.." + (hijo.occurs - 1) + "]\");");
                        gen.println(indent() + "    }");
                        gen.println();
                    }

                    gen.println(indent() + "    return " + lowering(hijoTypeName) + (hijo.occurs > 1 ? "[i]" : "") + ";");
                }

                gen.println(indent() + "}");
                gen.println();

                //

                if (hijo.occurs > 1) {

                    gen.println(indent() + "/*******************************************************************************************************");
                    gen.println(indent() + " * get" + hijoTypeName + "Size");
                    gen.println(indent() + " *******************************************************************************************************/");
                    gen.println(indent() + "/**");
                    gen.println(indent() + " *");
                    gen.println(indent() + " * @return TODO_javadoc.");
                    gen.println(indent() + " *");
                    gen.println(indent() + " */");
                    gen.println(indent() + "public final int get" + hijoTypeName + "Size() {");
                    gen.println(indent() + "    return " +  hijo.occurs + ";");
                    gen.println(indent() + "}");
                    gen.println();
                }

            }
            else { // simple

                if (hijo.occurs == 1) {

                    gen.println(indent() + "/*******************************************************************************************************");
                    gen.println(indent() + " * get" + camelCase(hijo.name));
                    gen.println(indent() + " *******************************************************************************************************/");
                    gen.println(indent() + "/**");
                    gen.println(indent() + " *");
                    gen.println(indent() + " * @return " + lowerCamelCase(hijo.name) + " TODO_javadoc.");
                    gen.println(indent() + " *");
                    gen.println(indent() + " */");
                    gen.println(indent() + "public " + DataEntryDesc.javaNames[hijo.type] + " get" + camelCase(hijo.name) + "() {");
                    gen.println(indent() +     "    return " +  getTypeValue(entry, hijo, ancestorOccurs, false, filename) + ";");
                    gen.println(indent() + "}");
                    gen.println();
                }
                else {

                    gen.println(indent() + "/*******************************************************************************************************");
                    gen.println(indent() + " * get" + camelCase(hijo.name));
                    gen.println(indent() + " *******************************************************************************************************/");
                    gen.println(indent() + "/**");
                    gen.println(indent() + " *");
                    gen.println(indent() + " * @param i TODO_javadoc.");
                    gen.println(indent() + " *");
                    gen.println(indent() + " * @return " + lowerCamelCase(hijo.name) + " TODO_javadoc.");
                    gen.println(indent() + " *");
                    gen.println(indent() + " */");
                    gen.println(indent() + "public " + DataEntryDesc.javaNames[hijo.type] + " get" + camelCase(hijo.name) + "(int i) {");
                    gen.println();
                    gen.println(indent() + "    if (i < 0 || i >= " + hijo.occurs + ") {");
                    gen.println(indent() + "        throw new ArrayIndexOutOfBoundsException(\"" + lowerCamelCase(hijo.name) + "[]: indice debe estar en rango [0.." + (hijo.occurs - 1) + "]\");");
                    gen.println(indent() + "    }");
                    gen.println();
                    gen.println(indent() + "    return " +  getTypeValue(entry, hijo, ancestorOccurs, false, filename) + ";");
                    gen.println(indent() + "}");
                    gen.println();
                    gen.println(indent() + "/*******************************************************************************************************");
                    gen.println(indent() + " * get" + camelCase(hijo.name) + "Size");
                    gen.println(indent() + " *******************************************************************************************************/");
                    gen.println(indent() + "/**");
                    gen.println(indent() + " *");
                    gen.println(indent() + " * @return TODO_javadoc.");
                    gen.println(indent() + " *");
                    gen.println(indent() + " */");
                    gen.println(indent() + "public final int get" + camelCase(hijo.name) + "Size() {");
                    gen.println(indent() + "    return " +  hijo.occurs + ";");
                    gen.println(indent() + "}");
                    gen.println();
                }
            }
        }
    }

    /******************************************************************************
     * getStringValue
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param entry TODO_javadoc.
     * @param var TODO_javadoc.
     * @param subindex TODO_javadoc.
     * @param filename TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private static String getStringValue(DataEntryDesc entry, String var, boolean subindex, String filename) {

      //logger.debug("[" + filename + "] entrando a 'getStringValue(" + entry + ")' ...");

        String name = var == null ? lowerCamelCase(entry.name) + (subindex ? "[i]" : "") : var;

        switch (entry.type) {

        case DataEntryDesc.INTEGER :
        case DataEntryDesc.LONG :

            if (entry.sign) {
                return "setCompNumber(" + name + ", form" + (entry.ints) + "z)";
            }
            else {
                return "form" + (entry.ints) + "z.format(" + name + ")";
            }

        case DataEntryDesc.DOUBLE :

            if (entry.ints + entry.decs > 18) {

                if (params.path("alert_max_digits_exceeded").asBoolean(true)) {

                    logger.warn("[" + filename + "] cantidad digitos significativos de " + entry.name + " excede maximo.");
                }
            }

            if (entry.sign) {
              //return "setCompNumber((long)             (" + name + " * Math.pow(10, " + entry.decs + ")), form" + (entry.ints + entry.decs) + "z)";
                return "setCompNumber((long) (rounded ? Math.round(" + name + " * Math.pow(10, " + entry.decs + ")) : " +
                                                                       name + " * Math.pow(10, " + entry.decs + ")), form" + (entry.ints + entry.decs) + "z)";
            }
            else {
                return "form" + (entry.ints + entry.decs) + "z.format((long) (" + name + " * Math.pow(10, " + entry.decs + ")))";
            }

        case DataEntryDesc.STRING :

            return name;

        case DataEntryDesc.UNDEF :
            throw new RuntimeException(entry.name + " tienen tipo " + entry.type);
        }

        return null;
    }

    /******************************************************************************
     * getTypeValue
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param entry TODO_javadoc.
     * @param hijo TODO_javadoc.
     * @param ancestorOccurs TODO_javadoc.
     * @param is_getvalue TODO_javadoc.
     * @param filename TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private static String getTypeValue(DataEntryDesc entry, DataEntryDesc hijo, Stack<String> ancestorOccurs, boolean is_getvalue, String filename) {

      //logger.debug("[" + filename + "] -----------------------------------------------------------------------");
      //logger.debug("[" + filename + "] entrando a 'getTypeValue()' ...");

        String clazzName = camelCase(entry.name);
        String str       = null;
        String gap       = genAbsolutePosition(ancestorOccurs, 0);

        if (is_getvalue) {

            if (ancestorOccurs.size() > 0) {

                String gap1 = genAbsolutePosition(ancestorOccurs, 1);

              //logger.debug("[" + filename + "] gap : '" + gap  + "'");
              //logger.debug("[" + filename + "] gap1: '" + gap1 + "'");

                str = "subValue(" + gap + hijo.offset + ", " + gap1 +   hijo.offset                                                                   + ")";
            }
            else {
                str = "subValue(" + gap + hijo.offset + ", " + gap  + ((hijo.offset > 0 ? hijo.offset + " + " : "" ) + (hijo.totalLen / hijo.occurs)) + ")";
            }
        }
        else if (hijo.occurs > 1) {

          //logger.debug("[" + filename + "] " + hijo.name + ", totalLen: " + hijo.totalLen + ", occurs: " + hijo.occurs);

            str = "subValue(" + gap + hijo.offset + " + " + (hijo.totalLen / hijo.occurs) + " * i, " + gap + (hijo.offset + " + " + (hijo.totalLen / hijo.occurs)) + " * (i + 1))";
        }
        else {
            str = "subValue(" + gap + hijo.offset +                                             ", " + gap + (hijo.offset +          hijo.totalLen) +                          ")";
        }

        //

        switch (hijo.type) {

        case DataEntryDesc.INTEGER :

            if (hijo.sign) {
                return "(int) getCompNumber(" + str + ")";
            }
            else {
                return "Integer.parseInt(" +    str + ")";
            }

        case DataEntryDesc.LONG :

            if (hijo.sign) {
                return "getCompNumber(" +  str + ")";
            }
            else {
                return "Long.parseLong(" + str + ")";
            }

        case DataEntryDesc.DOUBLE :

            if (hijo.ints + hijo.decs > 18) {

                if (params.path("alert_max_digits_exceeded").asBoolean(true)) {

                    logger.warn("[" + filename + "] cantidad digitos significativos de " + hijo.name + " excede maximo.");
                }
            }

            if (hijo.sign) {
                return "getCompNumber(" +  str + ") / Math.pow(10, " + hijo.decs + ")";
            }
            else {
                return "Long.parseLong(" + str + ") / Math.pow(10, " + hijo.decs + ")";
            }

        case DataEntryDesc.STRING :

            return str;

        case DataEntryDesc.UNDEF :
            throw new RuntimeException(hijo.name + " tienen tipo " + hijo.type);
        }

        return null;
    }

    /******************************************************************************
     * genAbsolutePosition
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param ancestorOccurs TODO_javadoc.
     * @param delta TODO_javadoc.
     *
     */
    private static String genAbsolutePosition(Stack<String> ancestorOccurs, int delta) {

        StringBuffer sb = new StringBuffer();

        if (ancestorOccurs.size() > 0) {

            for (int i = 0; i < ancestorOccurs.size() - 1; i++) {
                sb.append  ("idx_" + ancestorOccurs.elementAt(i).toLowerCase() + " * length_" + ancestorOccurs.elementAt(i).toLowerCase() + " + ");
            }

            if (delta > 0) {
                sb.append("(idx_" + ancestorOccurs.elementAt(ancestorOccurs.size() - 1).toLowerCase()  + " + " + delta + ") * length_" + ancestorOccurs.elementAt(ancestorOccurs.size() - 1).toLowerCase() + " + ");
            }
            else {
                sb.append( "idx_" + ancestorOccurs.elementAt(ancestorOccurs.size() - 1).toLowerCase() +                   " * length_" + ancestorOccurs.elementAt(ancestorOccurs.size() - 1).toLowerCase() + " + ");
            }
        }

        return sb.toString();
    }

    /******************************************************************************
     * indent
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     */
    private static String indent() {
        return spaces.substring(0, 4 * indent);
    }

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
    public static String camelCase(String s) {

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
     * capitalize
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
    private static String capitalize(String s) {

        if (s != null && !s.equals("")) {
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
    private static String lowering(String s) {

        if (s != null && !s.equals("")) {
            return s.substring(0, 1).toLowerCase() + s.substring(1);
        }

        return s;
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
    public static String lowerCamelCase(String s) {
        return lowering(camelCase(s));
    }

    /******************************************************************************
     * getPathFromPackage
     ******************************************************************************/
    /**
     *
     * @param package_name TODO_javadoc
     *
     * @return TODO_javadoc
     *
     */
    public static String getPathFromPackage(String package_name) {

        if (package_name == null || package_name.trim().equals("")) {
            return "";
        }

        return package_name.replace('.', '/');
    }

    /******************************************************************************
     * printStackTrace
     ******************************************************************************/
    /**
     *
     * @param e TODO_javadoc
     *
     * @return TODO_javadoc
     */
    private static String printStackTrace(Throwable e) {

        CharArrayWriter caw = new CharArrayWriter();
        e.printStackTrace(new PrintWriter(caw));

        return caw.toString();
    }

}
