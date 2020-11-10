/*
 *   Copyright (c) 2007 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.genfrmjava;


import java.io.*;

import java.text.*;

import java.util.*;

import cl.bee.genfrmjava.flgparser.*;
import cl.bee.genfrmjava.flgparser.syntaxtree.*;
import cl.bee.genfrmjava.flgparser.visitor.*;

import cl.bee.genfrmjava.util.*;

import org.apache.log4j.*;


/**
 * @author  alarrea@bee.cl
 * @version 1.0
 */
public class GenFormXML {

    private static Logger logger = Logger.getLogger(GenFormXML.class);

    /** TODO_javadoc. */
    protected static final String spaces  = "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ";

    //

    /** TODO_javadoc. */
    private static String systemName = null;

    /** TODO_javadoc. */
    private static String entityName = null;

    /******************************************************************************
     * main
     ******************************************************************************/
    /**
     *
     * @param args TODO_javadoc
     *
     */
    public static void main(String args[]) {

    	BasicConfigurator.configure();
        logger.info("Inicio GenFormXML.java ");
        try {

            for (int idx = 0; idx < args.length - 1; idx++) {

                if (args[idx].equalsIgnoreCase("-system")) {
                    systemName = args[++idx];
                }

                if (args[idx].equalsIgnoreCase("-entity")) {
                    entityName = args[++idx];
                }
            }

            logger.debug("systemName: " + systemName);
            logger.debug("entityName: " + entityName);

            //

            FLGParser parser = new FLGParser(new FileInputStream("data/flg/" + entityName + ".flg"));
            Node      root   = parser.specification();

            ArrayList<Object>                fields = new ArrayList<Object>();
            ArrayList<TextDef>               texts  = new ArrayList<TextDef>();
            FormDef                          form  = new FormDef();
            
            root.accept(new GetFieldsVisitor(fields, texts, form));
            logger.debug("ROOT: " + fields.toString());
            logger.debug("OGB: " + texts.toString()); 
            logger.debug("FORM: " + form.toString());  
            //

            String working_dir = "data/form"; // TODO_ALA:

            try {
                (new File(working_dir)).mkdirs();
            }
            catch (SecurityException e) {

                logger.fatal("SecurityException: " + Utils.printStackTrace(e));

                return;
            }

            //

            String      filename = working_dir + File.separator + "form_" + systemName.toLowerCase() + "_" + entityName.toLowerCase() + ".xml";
            PrintStream gen      = null;

            try {
                gen = new PrintStream(new FileOutputStream(filename));
            }
            catch (FileNotFoundException e1) {

                logger.fatal("FileNotFoundException: " + Utils.printStackTrace(e1));

                return;
            }

            //

            gen.println("<?xml version = \"1.0\" encoding = \"ISO-8859-1\" ?>");
            gen.println();
            gen.println("<form xmlns              = \"http://cl/bee/genfrmjava/formdef/schema\"");
            gen.println("      xmlns:xsi          = \"http://www.w3.org/2001/XMLSchema-instance\"");
            gen.println("      xsi:schemaLocation = \"http://cl/bee/genfrmjava/formdef/schema formdef.xsd\"");
            gen.println("      entity             = \"" + systemName + "_" + entityName + "\"");
            gen.println("      name               = \"" + form.getName()  + "\"");
            gen.println("      posx               = \"" + form.getAreaX() + "\"");
            gen.println("      posy               = \"" + form.getAreaY() + "\"");
            gen.println("      width              = \"" + form.getWidth() + "\">");
            gen.println();

            for (int i = 0; i < fields.size(); i++) {

                if      (fields.get(i) instanceof FieldDef) {
                    printField(gen, "  ", (FieldDef) fields.get(i), null);
                }
                else if (fields.get(i) instanceof ArrayList) {

                    ArrayList<ElementDef> array = (ArrayList<ElementDef>) fields.get(i);

                    if (array.size() == 0) {
                        throw new Exception("arreglo deberia tener al menos un elemento.");
                    }

                    gen.println("  <array size=\"" + array.get(0).index.size() + "\">");
                    gen.println();

                    for (int j = 0; j < array.size(); j++) {
                        printField(gen, "    ", array.get(j).field, array.get(j).index);
                    }

                    gen.println("  </array>");
                    gen.println();
                }
            }

            // primary

            int count_pk_fields = countFields(fields, new int[] { FieldDef.IKY });

            if (count_pk_fields > 0) {

                gen.println("  <primary>");

                for (int i = 0; i < fields.size(); i++) {

                    if      (fields.get(i) instanceof FieldDef) {

                        FieldDef fd = (FieldDef) fields.get(i);

                        if (fd.modifier == FieldDef.IKY) {
                            gen.println("    <field name=\"" + fd.name.replace('_', '-') + "\"/>");
                        }
                    }
                    /*
                    else if (fields.get(i) instanceof ArrayList) {
                    }
                    */
                }

                gen.println("  </primary>");
                gen.println();
            }

            // foreign

            for (int i = 0; i < fields.size(); i++) {

                if      (fields.get(i) instanceof FieldDef) {

                    FieldDef fd = (FieldDef) fields.get(i);

                    if (fd.modifier == FieldDef.AKY || fd.modifier == FieldDef.MKY) {

                        gen.println("  <foreign entity=\"{{{TODO_foreign_entity}}}\">");
                        gen.println("    <field name=\"" + fd.name.replace('_', '-') + "\"/>");
                        gen.println("  </foreign>");
                        gen.println();
                    }
                }
                /*
                else if (fields.get(i) instanceof ArrayList) {
                }
                */
            }

            //

            for (TextDef tx : texts) {
                printText(gen, "  ", tx);
            }

            if (texts.size() > 0) {
                gen.println();
            }

            gen.println("</form>");

            gen.close();

        }
        catch (Exception e) {
            logger.error("Exception: " + Utils.printStackTrace(e));
        }
    }

    /******************************************************************************
     * printField
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param gen TODO_javadoc.
     * @param indent TODO_javadoc.
     * @param fd TODO_javadoc.
     * @param index TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void printField(PrintStream gen, String indent, FieldDef fd, ArrayList<PositionDef> index) {

        gen.print  (indent + "<field name=\"" + fd.name.replace('_', '-') + "\"");

        if (fd.special != FieldDef.UNDEF) {
            gen.print(" special=\"" + FieldDef.getSpecialString(fd.special) + "\"");
        }

        gen.println(">");

        ////////////////////////

        gen.print  (indent + "  <type name=\"" + FieldDef.getTypeString(fd.type) + "\" size=\"" + fd.size + "\"");

        if (fd.integers != 0) {
            gen.print(" integers=\"" + fd.integers + "\"");
        }

        if (fd.decimals != 0) {
            gen.print(" decimals=\"" + fd.decimals + "\"");
        }

        switch (fd.type) {

        case FieldDef.INTEGER:
        case FieldDef.LONG:

            if (fd.sign) {
                gen.print(" sign=\"yes\"");
            }

            break;

        case FieldDef.DOUBLE:

            gen.print(" sign=\"" + (fd.sign ? "yes" + "\"" : "no" + "\" "));

            break;
        }

        gen.println("/>");

        ////////////////////////

        gen.print  (indent + "  <fms name=\"" + fd.fmsname + "\"");

        if (fd.modifier != FieldDef.UNDEF) {
            gen.print(" modifier=\"" + FieldDef.getModifierString(fd.modifier) + "\"");
        }

        if (index == null) {

            gen.print(" row=\"" + fd.row + "\"");
            gen.print(" column=\"" + fd.column + "\"");
        }

        if (!fd.picture.equals("")) {
            gen.print(" picture=\"" + fd.picture + "\"");
        }

        gen.print(" attributes=\"" + fd.attributes + "\"");

        gen.println("/>");

        ////////////////////////

        if (!fd.xdefault.equals("")) {
            gen.println(indent + "  <default value=\"" + fd.xdefault + "\"/>");
        }

        ////////////////////////

        if (index != null) {

            gen.println(indent + "  <index>");

            for (int i = 0; i < index.size(); i++) {
              gen.println(indent + "    <pos row=\"" + index.get(i).row + "\" column=\"" + index.get(i).column + "\"/>");
            }

            gen.println(indent + "  </index>");
        }

        ////////////////////////

        gen.println(indent + "</field>");

        gen.println();
    }

    /******************************************************************************
     * printText
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param gen TODO_javadoc.
     * @param indent TODO_javadoc.
     * @param tx TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void printText(PrintStream gen, String indent, TextDef tx) {

        gen.print  ("  <text caption=\"" + quote(tx.caption) + "\"");

        gen.print(" row=\"" + tx.row + "\"");
        gen.print(" column=\"" + tx.column + "\"");

        gen.println(" />");
    }

    /*******************************************************************************************************
     * trimBS
     *******************************************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param s TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    /*
    private static String trimBS(String s) {

        StringBuffer sb = new StringBuffer();

        sb.append(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i - 1) != '\\' || s.charAt(i) != '\\') {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
    */

    /*******************************************************************************************************
     * change
     *******************************************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param s TODO_javadoc.
     * @param p TODO_javadoc.
     * @param v TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static String change(String s, String p, String v) {

        int          pos;
        int          ini = 0;
        StringBuffer sb  = new StringBuffer();

        do {

            if ((pos = s.indexOf(p, ini)) >= 0) {

                sb.append(s.substring(ini, pos));
                sb.append(v);

                ini = pos + p.length();
            }
        }
        while (pos >= 0);

        sb.append(s.substring(ini));

        return sb.toString();
    }

    /*******************************************************************************************************
     * quote
     *******************************************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param s TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static String quote(String s) {

      //logger.debug("entrando a 'quote(" + s + ")' ...");

      //s = trimBS(s);
        s = change(s, "&",  "&amp;");
        s = change(s, "<",  "&lt;");
        s = change(s, ">",  "&gt;");
        s = change(s, "\"", "&quot;");
        s = change(s, "'",  "&apost;");

        return s;
    }

    /******************************************************************************
     * countFields
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param fields TODO_javadoc.
     * @param type TODO_javadoc.
     *
     * @throws Exception TODO_javadoc.
     *
     */
    private static int countFields(ArrayList<Object> fields, int[] types) throws Exception {

        int count = 0;

        for (int i = 0; i < fields.size(); i++) {

            if      (fields.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) fields.get(i);

                for (int type : types) {

                    if (fd.modifier == type) {

                        count++;

                        break;
                    }
                }
            }
            /*
            else if (fields.get(i) instanceof ArrayList) {
            }
            */
        }

        return count;
    }
}
