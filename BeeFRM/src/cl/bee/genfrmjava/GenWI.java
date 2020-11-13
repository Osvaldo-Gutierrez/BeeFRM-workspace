/*
 *   Copyright (c) 2019 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.genfrmjava;


import java.io.*;

import java.text.*;

import java.util.*;

import cl.bee.genfrmjava.config.*;
import cl.bee.genfrmjava.config.impl.*;

import cl.bee.genfrmjava.formdef.schema.*;

import cl.bee.genfrmjava.util.*;

import org.apache.xmlbeans.*;

import org.apache.log4j.*;


/**
 * @author  alarrea@bee.cl
 * @version 1.0
 */
public class GenWI {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(GenWI.class);

    /** TODO_javadoc. */
    protected static final String spaces = "                                                                                                                                ";

    /** TODO_javadoc. */
    protected static final String nueves = "99999999999999999999999999999999999999999999999999999999999999999999999999999999";

    /** TODO_javadoc. */
    private static final DecimalFormat form2 = new DecimalFormat("00");

    /** TODO_javadoc. */
    private static final SimpleDateFormat formdate_gen = new SimpleDateFormat("dd-MMM-yy hh:mm aa", new Locale("es", "CL")); //07-Nov-18 09:48 AM

    //

    /** TODO_javadoc. */
    private final static int[] KEY_TYPES = new int[] { FieldDef.IKY, FieldDef.MKY, FieldDef.AKY };

    //

    /** TODO_javadoc. */
    private static PrintStream gen = null;

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
        logger.info("Inicio GenWI.java ");    	
        try {

            String configClass = null;

            for (int idx = 0; idx < args.length - 1; idx++) {

                if (args[idx].equalsIgnoreCase("-system")) {
                    systemName = args[++idx];
                }

                if (args[idx].equalsIgnoreCase("-entity")) {
                    entityName = args[++idx];
                }

                if (args[idx].equalsIgnoreCase("-configClass")) {
                    configClass = args[++idx];
                }
            }

            if (configClass == null) {
                throw new RuntimeException("configClass debe estar definido.");
            }

            //

            ArrayList<Object>  fields = new ArrayList<Object>();
            ArrayList<TextDef> texts  = new ArrayList<TextDef>();
            FormDef            forms = new FormDef();
            
            //

            Config config = (Config) (Class.forName(configClass).newInstance());

            config.getInfoFromXML("data/form/form_" + systemName.toLowerCase() + "_" + entityName.toLowerCase() + ".xml", fields, texts, forms);

            //

            TreeMap<Integer, Object> tree = new TreeMap<Integer, Object>();

            FieldDef fd = null;

            for (int i = 0; i < fields.size(); i++) {

                if        (fields.get(i) instanceof FieldDef) {

                    fd = (FieldDef) fields.get(i);

                    tree.put(fd.row * 100 + fd.column, fd);

                } else if (fields.get(i) instanceof ArrayList) {

                    ArrayList<ElementDef> array = (ArrayList<ElementDef>) fields.get(i);

                    if (array.size() == 0) {
                        throw new Exception("arreglo deberia tener al menos un elemento.");
                    }

                    if (array.get(0).index.size() == 0) {
                        throw new Exception("arreglo deberia tener al menos una posicion.");
                    }

                    tree.put(array.get(0).index.get(0).row * 100 + array.get(0).index.get(0).column, array);
                }
            }

            for (int i = 0; i < texts.size(); i++) {
                tree.put(texts.get(i).row * 100 + texts.get(i).column, texts.get(i));
            }

            gen = new PrintStream(new FileOutputStream("data/gen/" + systemName + "WI" + entityName + ".AIU"));

            gen.println("      *");
            gen.println("      * " + systemName + "WI" + entityName );
            gen.println("      * " + Utils.NOMBRE_GENEDADOR + " " + Utils.VERSION_GENEDADOR);
            gen.println("      * " + formdate_gen.format(new Date()).toUpperCase());
            gen.println("      *");
            gen.println("      *");
            gen.println("       77  WSS-TAG-" + systemName + "WI" + entityName + " PIC X(125) VALUE");
            gen.println("           '<IDNMOD NOM=$" + systemName + "WI" + entityName + "$ VSN=${VSNWI}$ VGM=$3.0.1$");
            gen.println("      -    'GEN=$07-Nov-18 09:48 AM$ FNC=${FNCWI}$/>'.");
            gen.println("       01  " + entityName + "-FLD.");
            gen.println("           05 FILLER-" + entityName + "                    PIC  X(12).");
            gen.println("      *");

            TextDef  tx = null;

            for (Iterator iter = tree.entrySet().iterator(); iter.hasNext(); ) {

                Map.Entry mentry = (Map.Entry) iter.next();

                Object obj = mentry.getValue();

                if      (obj instanceof FieldDef) {

                    fd = (FieldDef) obj;

                    printField(fd, FieldDef.UNDEF, "           ", 5);

                } else if (obj instanceof ArrayList) {

                    ArrayList<ElementDef> array = (ArrayList<ElementDef>) obj;

                    if (array.size() == 0) {
                        throw new Exception("arreglo deberia tener al menos un elemento.");
                    }

                    if (array.get(0).index.size() == 0) {
                        throw new Exception("arreglo deberia tener al menos una posicion.");
                    }

                    fd = array.get(0).field;

                    gen.println("      * ( F / C - " + form2.format(array.get(0).index.get(0).row) + " / " + form2.format(array.get(0).index.get(0).column - 1) + " ) ( " +  FieldDef.getModifierString(array.get(0).field.modifier) + " ) ( " + (FieldDef.hasAttribute(array.get(0).field.attributes, FieldDef.DISPLAY_ONLY_ATTR) ? "SI" : "NO") + " D.O. ) ( " + (FieldDef.hasAttribute(array.get(0).field.attributes, FieldDef.RESPONSE_REQUIRED_ATTR) ? "SI" : "NO") + " OBL )");

                    gen.println("           05 " + fd.name + "-IDX  OCCURS " + array.get(0).index.size() + " TIMES.");

                    for (int j = 0; j < array.size(); j++) {

                        array.get(j).field.row    = array.get(j).index.get(0).row;
                        array.get(j).field.column = array.get(j).index.get(0).column;

                        printField(array.get(j).field, j == 0 ? 999/*cualquier valor*/ : FieldDef.UNDEF, "              ", 7);
                    }

                } else if (obj instanceof TextDef) {

                    tx = (TextDef) obj;

                    gen.println("      * ( F / C - " + form2.format(tx.row) + " / " + form2.format(tx.column) + " )");
                    if (tx.caption.length() > 47) {
                        gen.println("      * \"" + tx.caption.substring(0, 47) + "\"");
                        gen.println("      * \"" + tx.caption.substring(47) + "\"");
                    }
                    else
                    	gen.println("      * \"" + tx.caption + "\"");
                    gen.println("      *");
                }
            }

            //

            gen.println("      * Linea de Mensajes");
            gen.println("           05 " + entityName + "-GLS-MENS-LEN       COMP   PIC S9(04).");
            gen.println("           05 " + entityName + "-GLS-MENS-ATR              PIC  X(01).");
            gen.println("           05 " + entityName + "-GLS-MENS.");
            gen.println("              07 " + entityName + "-GLS-MEN1               PIC  X(40).");
            gen.println("              07 " + entityName + "-GLS-MEN2               PIC  X(39).");
            gen.println("      *");
            gen.println("      * REGISTRO IMAGEN PARA EDICION DE MAPA " + entityName);
            gen.println("       01  " + entityName + "-STP.");

            for (int i = 0; i < fields.size(); i++) {

                if        (fields.get(i) instanceof FieldDef) {

                    fd = (FieldDef) fields.get(i);

                    if (fd.replaced != null && fd.type != FieldDef.DATE) {

                        for (FieldDef fr : fd.replaced) {
                            gen.println("           05 " + fr.name + "-STP              PIC  X(01).");
                        }
                    }
                    else {
                        gen.println("           05 " + fd.name + "-STP              PIC  X(01).");
                    }

                } else if (fields.get(i) instanceof ArrayList) {

                    ArrayList<ElementDef> array = (ArrayList<ElementDef>) fields.get(i);

                    if (array.size() == 0) {
                        throw new Exception("arreglo deberia tener al menos un elemento.");
                    }

                    gen.println("           05 " + array.get(0).field.name + "-STP-IDX  OCCURS " + array.get(0).index.size() + " TIMES.");

                    for (int j = 0; j < array.size(); j++) {
                        gen.println("              07 " + array.get(j).field.name + "-STP           PIC  X(01).");
                    }
                }
            }

            //

            if (hasNumeric(fields)) {

                gen.println("      *");
                gen.println("      * REGISTRO IMAGEN PARA EDICION DE MAPA " + entityName);
                gen.println("       01  " + entityName + "-EDT.");

                //

                for (int i = 0; i < fields.size(); i++) {

                    if        (fields.get(i) instanceof FieldDef) {

                        fd = (FieldDef) fields.get(i);

                        if (fd.replaced != null && fd.type != FieldDef.DATE) {

                            for (FieldDef fr : fd.replaced) {

                                switch(fr.type) {

                                case FieldDef.INTEGER :
                                case FieldDef.LONG :
                                case FieldDef.DOUBLE :
                                    gen.println("           05 " + fr.name + "-EDT  PIC  " + getEditPicture(fr.picture, FieldDef.hasAttribute(fr.attributes, FieldDef.DISPLAY_ONLY_ATTR), fr.special) + ".");
                                    break;
                                }
                            }
                        }
                        else {

                            switch(fd.type) {

                            case FieldDef.INTEGER :
                            case FieldDef.LONG :
                            case FieldDef.DOUBLE :
                                gen.println("           05 " + fd.name + "-EDT  PIC  " +     getEditPicture(fd.picture, FieldDef.hasAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR), fd.special) + ".");
                                break;
                            }
                        }

                    } else if (fields.get(i) instanceof ArrayList) {
                        ////////////////////////////////////
                    	
                        	ArrayList<ElementDef> array = null;
                        	array = (ArrayList<ElementDef>) fields.get(i);

                            ArrayList<ElementDef> valid = new ArrayList<ElementDef>();

                            for (int j = 0; j < array.size(); j++) {

                                switch(array.get(j).field.type) {

                                case FieldDef.INTEGER :
                                case FieldDef.LONG :
                                case FieldDef.DOUBLE :
                                    gen.println("           05 " + array.get(j).field.name + "-EDT  PIC  " + 
                                    			getEditPicture(array.get(j).field.picture, FieldDef.hasAttribute(array.get(j).field.attributes, FieldDef.DISPLAY_ONLY_ATTR), array.get(j).field.special) + ".");
                                    break;
                                }
                            }
                    }
                }
            }

            //

            gen.close();

        }
        catch (Exception e) {
            logger.error("Exception: " + Utils.printStackTrace(e));
        }
    }

    /******************************************************************************
     * hasNumeric
     ******************************************************************************/
    /**
     *
     * @param fields TODO_javadoc
     *
     */
    private static boolean hasNumeric(ArrayList<Object> fields) {

        FieldDef fd = null;

        for (int i = 0; i < fields.size(); i++) {

            if        (fields.get(i) instanceof FieldDef) {

                fd = (FieldDef) fields.get(i);

                if (fd.replaced != null && fd.type != FieldDef.DATE) {

                    for (FieldDef fr : fd.replaced) {

                        switch(fr.type) {

                        case FieldDef.INTEGER :
                        case FieldDef.LONG :
                        case FieldDef.DOUBLE :
                           return true;
                        }
                    }
                }
                else {

                    switch(fd.type) {

                    case FieldDef.INTEGER :
                    case FieldDef.LONG :
                    case FieldDef.DOUBLE :
                           return true;
                    }
                }

            } else if (fields.get(i) instanceof ArrayList) {
                ////////////////////////////////////
            	
            	ArrayList<ElementDef> array = null;
            	array = (ArrayList<ElementDef>) fields.get(i);

                ArrayList<ElementDef> valid = new ArrayList<ElementDef>();

                for (int j = 0; j < array.size(); j++) {

                    switch(array.get(j).field.type) {

                    case FieldDef.INTEGER :
                    case FieldDef.LONG :
                    case FieldDef.DOUBLE :
                    	 return true;
                    }
                }
            	
            	
            }
        }

        return false;
    }

    /******************************************************************************
     * printField
     ******************************************************************************/
    /**
     *
     * @param fd TODO_javadoc
     * @param special TODO_javadoc
     * @param indent TODO_javadoc
     * @param l TODO_javadoc
     *
     */
    private static void printField(FieldDef fd, int special, String indent, int level) {

      //logger.debug(fd);

        if (fd.replaced != null && fd.type != FieldDef.DATE) {

            gen.println("      * ( F / C - " + form2.format(fd.row) + " / " + form2.format(fd.column - 1) + " ) ( " +  FieldDef.getModifierString(fd.modifier) + " ) ( " + (FieldDef.hasAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR) ? "SI" : "NO") + " D.O. ) ( " + (FieldDef.hasAttribute(fd.attributes, FieldDef.RESPONSE_REQUIRED_ATTR) ? "SI" : "NO") + " OBL )");

            for (FieldDef fr : fd.replaced) {
                printField(fr, fd.special, indent, level);
            }
        }
        else {

            if (special == FieldDef.UNDEF) {
                gen.println("      * ( F / C - " + form2.format(fd.row) + " / " + form2.format(fd.column - 1) + " ) ( " +  FieldDef.getModifierString(fd.modifier) + " ) ( " + (FieldDef.hasAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR) ? "SI" : "NO") + " D.O. ) ( " + (FieldDef.hasAttribute(fd.attributes, FieldDef.RESPONSE_REQUIRED_ATTR) ? "SI" : "NO") + " OBL )");
            }

            gen.println(indent +     form2.format(level    ) + " " + fd.name + "-LEN " + spaces.substring(0, 17 - indent.length()) + "COMP   PIC S9(04).");
            gen.println(indent +     form2.format(level    ) + " " + fd.name + "-ATR " + spaces.substring(0, 17 - indent.length()) + "       PIC  X(01).");

            switch(fd.type) {

            case FieldDef.INTEGER :
            case FieldDef.LONG :

                gen.println(indent + form2.format(level    ) + " " + fd.name + "-ALF " + spaces.substring(0, 17 - indent.length()) + "       PIC  X(" + fd.picture.length() + ").");
                gen.println(indent + form2.format(level    ) + " " + fd.name + "      REDEFINES");
                gen.println(indent +                         "   " + fd.name + "-ALF " + spaces.substring(0, 17 - indent.length()) + "       PIC  " + (fd.sign ? "S" : "") + nueves.substring(0, fd.sign ? fd.integers - 1 : fd.integers) + ".");

                break;

            case FieldDef.DOUBLE :

                gen.println(indent + form2.format(level    ) + " " + fd.name + "-ALF " + spaces.substring(0, 17 - indent.length()) + "       PIC  X(" + fd.picture.length() + ").");
                gen.println(indent + form2.format(level    ) + " " + fd.name + "      REDEFINES");
                gen.println(indent +                         "   " + fd.name + "-ALF " + spaces.substring(0, 17 - indent.length()) + "       PIC  " + (fd.sign ? "S" : "") + nueves.substring(0, fd.sign ? fd.integers - 1 : fd.integers) + "V" + nueves.substring(0, fd.decimals) + ".");

                break;

            case FieldDef.STRING :

                gen.println(indent + form2.format(level    ) + " " + fd.name + "     " + spaces.substring(0, 17 - indent.length()) + "       PIC  X(" + fd.size + ").");

                break;

            case FieldDef.CHAR :

                gen.println(indent + form2.format(level    ) + " " + fd.name + "     " + spaces.substring(0, 17 - indent.length()) + "       PIC  X.");

                break;

            case FieldDef.DATE :

                gen.println(indent + form2.format(level    ) + " " + fd.name + ".");

                for (int i = 0; i < FieldDef.date_initials.length; i++) {
                    gen.println(indent + "   " +
                                     form2.format(level + 2) + " " + fd.name.substring(0, 3) + "-NUM-" + FieldDef.date_initials[i] + fd.name.substring(9) +
                                                                               "    " + (indent.length() > 11 ? " " : spaces.substring(0, 17 - 6 - indent.length())) +
                                                                                                                                     "       PIC 9(02)."); // si level == 9
                }

                gen.println();

                break;

            case FieldDef.BOOLEAN : // TODO_ALA: posiblemente no se usara este tipo

                break;
            }

            gen.println("      *");
        }
    }

    /******************************************************************************
     * getEditPicture
     ******************************************************************************/
    /**
     *
     * @param fd TODO_javadoc
     * @param special TODO_javadoc
     *
     */
    private static String getEditPicture(String picture, boolean isDisplayOnly, int type) {

        String s = picture.replaceAll("9", "Z").replaceAll("N", "-");

        if (isDisplayOnly) {
        	
          	if (type == FieldDef.VRF) {
          		s = picture.replaceAll("9", "Z");
          		return s;
          	}
        	
            int pos = s.indexOf(',');

            switch (s.charAt(s.length() - 1)) {

            case 'Z' :

                if        (pos < 0) {
                    return s.substring(0, s.length() - 1) + "9";
                } else {
                    return s.substring(0, pos - 1) + s.substring(pos - 1).replaceAll("Z", "9");
                }

            case '-' :

                if        (pos < 0) {
                    return s.substring(0, s.length() - 1) + "9";
                } else {
                    return s.substring(0, pos - 1) + s.substring(pos - 1).replaceAll("-", "9");
                }
            }
        }

        return s;
    }
}
