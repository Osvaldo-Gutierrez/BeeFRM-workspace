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

import com.rits.cloning.*;

import org.apache.xmlbeans.*;

import org.apache.log4j.*;


/**
 * @author  alarrea@bee.cl
 * @version 1.0
 */
public class GenMap {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(GenMap.class);

    /** TODO_javadoc. */
    protected static final String spaces = "                                                                                                                                ";

    /** TODO_javadoc. */
    private static final DecimalFormat form2 = new DecimalFormat("00");

    /** TODO_javadoc. */
    private static final DecimalFormat form3 = new DecimalFormat("000");

    /** TODO_javadoc. */
    private static final DecimalFormat form4 = new DecimalFormat("0000");

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

    //

    /** TODO_javadoc. */
    private static ArrayList<String> names = null;

    /** TODO_javadoc. */
    private static int special_num = 1;

    /** TODO_javadoc. */
    private static int normal_num = 714;
       

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

            FieldDef              fd  = null;
            ArrayList<ElementDef> arr = null;

            for (int i = 0; i < fields.size(); i++) {

                if        (fields.get(i) instanceof FieldDef) {

                    fd = (FieldDef) fields.get(i);

                    tree.put(fd.row * 100 + fd.column, fd);

                } else if (fields.get(i) instanceof ArrayList) {

                    arr = (ArrayList<ElementDef>) fields.get(i);

                    int size = arr.get(0).index.size(); // asume que al menos tiene un elemento

                    Cloner cloner = new Cloner();

                    int offset = -arr.size() + 1;

                    for (int j = 0; j < size; j++) {

                        for (int k = 0; k < arr.size(); k++) {

                            FieldDef f = cloner.deepClone(arr.get(k).field);

                            f.row       = arr.get(k).index.get(j).row;
                            f.column    = arr.get(k).index.get(j).column;
                            
                            if (f.replaced != null && f.type != FieldDef.DATE) {

                                for (FieldDef fr : f.replaced) {
                                    fr.row = f.row;
                                }
                            }
                            

                            f.map_index = k * (size - 1) + j - offset;

                            offset++;

                            tree.put(f.row * 100 + f.column, f);
                        }
                    }
                }
            }

            for (int i = 0; i < texts.size(); i++) {
                tree.put(texts.get(i).row * 100 + texts.get(i).column, texts.get(i));
            }

            gen = new PrintStream(new FileOutputStream("data/gen/" + systemName + "A" + entityName + ".MAP"));
            
            
            int posY = (int)forms.getAreaY() + 1;
            int posX = (int)forms.getAreaX() - 1;

            gen.println("*");
            gen.println("* " + systemName + "A" + entityName + "");
            gen.println("* " + Utils.NOMBRE_GENEDADOR + " " + Utils.VERSION_GENEDADOR);
            gen.println("* " + formdate_gen.format(new Date()).toUpperCase());
            gen.println("*");
            gen.println("         PRINT NOGEN");
            gen.println(systemName + "A" + entityName + "  DFHMSD TYPE=&SYSPARM,TERM=3270,MODE=INOUT,LANG=COBOL,         X");
            gen.println("               TIOAPFX=YES");
            gen.println(systemName + "F" + entityName + "  DFHMDI SIZE=("+ posY +"," + forms.getWidth() +"),LINE="+ forms.getAreaX() +",COLUMN=1,CTRL=(FREEKB)");

            TextDef tx = null;

            names  = new ArrayList<String>();

            for (Iterator iter = tree.entrySet().iterator(); iter.hasNext(); ) {

                Map.Entry mentry = (Map.Entry) iter.next();

                Object obj = mentry.getValue();

                if      (obj instanceof FieldDef) {

                    fd = (FieldDef) obj;

                    printDFHMDF(fd, FieldDef.UNDEF, 0x04 | 0x01, posX);
                }
                else if (obj instanceof ArrayList) {
                    ////////////////////////////////////
                }
                else if (obj instanceof TextDef) {

                    tx = (TextDef) obj;

                    String lenSt = Integer.toString(tx.caption.length());

                    gen.println("         DFHMDF POS=(" + form2.format(tx.row - posX) + "," + form2.format(tx.column - 1) + "),ATTRB=(ASKIP,NORM),LENGTH=" + lenSt + "," + spaces.substring(0,  16 - lenSt.length()) + "X");

                    if (tx.caption.length() > 47) {
                        gen.println("               INITIAL='" + tx.caption.substring(0, 47) + "X");
                        gen.println("               " + tx.caption.substring(47) + "'");
                    }
                    else {
                        gen.println("               INITIAL='" + tx.caption + "'");
                    }
                }
            }

            gen.println("SCRMENS  DFHMDF POS=(" + (24 - posX) + ",01),ATTRB=(ASKIP,BRT),LENGTH=79,               X");
            gen.println("               INITIAL=' '");
            gen.println("         DFHMSD TYPE=FINAL");
            gen.println("         END");

            gen.close();

        }
        catch (Exception e) {
            logger.error("Exception: " + Utils.printStackTrace(e));
        }
    }

    /******************************************************************************
     * printDFHMDF
     ******************************************************************************/
    /**
     *
     * @param fd TODO_javadoc
     * @param special TODO_javadoc
     * @param inner TODO_javadoc
     *
     */
    private static void printDFHMDF(FieldDef fd, int special, int mask, int posX) {

      //logger.debug("entrando a 'printDFHMDF(" + fd.name + "," + FieldDef.getSpecialString(special) + "," + toBinBytes((byte) mask) + ")' ...");

        if (fd.replaced != null && fd.type != FieldDef.DATE) {

          //logger.debug(" == vvvvvv replaced ========================================");

            mask = 0x00;

            for (int i = 0; i < fd.replaced.size(); i++) {

                FieldDef fr = fd.replaced.get(i);

                if (i == 0) {                              //  +---+---+---+
                                                           //  | 1 | 0 | 0 |
                  //logger.debug("es el primero ...");     //  +---+---+---+

                    mask = 0x4;
                }

                if (i == fd.replaced.size() - 1) {         //  +---+---+---+
                                                           //  | 0 | 0 | 1 |
                  //logger.debug("es el ultimo ...");      //  +---+---+---+

                    mask = 0x1;
                }

                if (i > 0 && i < fd.replaced.size() - 1) { //  +---+---+---+
                                                           //  | 0 | 1 | 0 |
                  //logger.debug("esta al medio ...");     //  +---+---+---+

                    mask = 0x02;
                }

                printDFHMDF(fr, fd.special, mask, posX);

                if (i < fd.replaced.size() - 1) {

                    switch (fd.special) {

                    case FieldDef.VRF :
                        gen.println("         DFHMDF POS=(" + form2.format(fr.row - posX) + "," + form2.format(fr.column + fr.size) + "),ATTRB=(PROT,BRT),LENGTH=1,INITIAL='-'");
                        break;
                    case FieldDef.IDC :
                        gen.println("         DFHMDF POS=(" + form2.format(fr.row - posX) + "," + form2.format(fr.column + fr.size) + "),ATTRB=(PROT),LENGTH=1,INITIAL='-'"); // ,BRT
                        break;
                    }
                }
            }

          //logger.debug(" == ^^^^^^ replaced ========================================");

            special_num++;
        }
        else {
        	
            String name     = fd.name.substring(4, 7) + fd.name.substring(8, 12);
            int    size     = fd.size;            	               	   
            int    gen_size = fd.size;
            int    offset   = 0;

            switch (special) {

            case FieldDef.VRF :
            case FieldDef.IDC :
                name = fd.name.substring(4, 7) + form4.format(special_num);
                break;
            }

            //

            while (names.contains(name)) {

                if (fd.map_index != FieldDef.UNDEF) {
                    name = name.substring(0, 4) + form3.format(normal_num + fd.map_index);
                }
                else {
                    name = name.substring(0, 4) + form3.format(normal_num);
                }

                normal_num++;
            }

            names.add(name);

            //

            if (fd.special == FieldDef.FEC) {
                gen_size = countDigit(fd.picture);
                size     = 8;
                offset   = 2;
            }
            else        
            	offset = (fd.picture.startsWith("-")) ? fd.picture.length() - fd.size : 0;

            if (FieldDef.absenceAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR) && (mask & 0x04) == 0x04) {
                gen.println("         DFHMDF POS=(" + form2.format(fd.row - posX) + "," + form2.format(fd.column - 3                            ) + "),ATTRB=(ASKIP,NORM),LENGTH=1,INITIAL='" + (Utils.searchIntInArray(fd.modifier, KEY_TYPES) >= 0 ? "{" : "<") + "'");
            }

          //logger.debug("escribiendo " + fd.name + " (" + name + ") ...");

            gen.println(name +     "  DFHMDF POS=(" + form2.format(fd.row - posX) + "," + form2.format(fd.column - 1 + /*size - gen_size*/  + offset) + "),ATTRB=(" + getAttrb(fd) + "),LENGTH=" + gen_size);

            if (FieldDef.absenceAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR) && (mask & 0x01) == 0x01) {
                gen.println("         DFHMDF POS=(" + form2.format(fd.row - posX) + "," + form2.format(fd.column     + size             + offset) + "),ATTRB=(PROT),LENGTH=1,INITIAL='" +       (Utils.searchIntInArray(fd.modifier, KEY_TYPES) >= 0 ? "}" : ">") + "'");
            }
        }

      //logger.debug("saliendo de 'printDFHMDF(" + fd.name + ")' ...");
      //logger.debug("");
    }

    /******************************************************************************
     * countDigit
     ******************************************************************************/
    /**
     *
     * @param picture TODO_javadoc
     *
     */
    private static int countDigit(String picture) {

        int count = 0;

        for (int i = 0; i < picture.length(); i++) {

            if (Character.isDigit(picture.charAt(i))) {
                count++;
            }
            else {
            	
            	Character  charD = picture.charAt(i);
            	if (charD.equals('X'))
            		count++;
            }
        }

        return count;
    }

    /******************************************************************************
     * getAttrb
     ******************************************************************************/
    /**
     *
     * @param fd TODO_javadoc
     *
     */
    private static String getAttrb(FieldDef fd) {

        ArrayList<String> attrbs = new ArrayList<String>();

        addAttrb(attrbs, "ASKIP");

        /*
        if (FieldDef.hasAttribute(fd.attributes, FieldDef.NOECHO_ATTR)) {
        	addAttrb(attrbs, "DRK");
        	addAttrb(attrbs, "FSET");
        }
        if (FieldDef.absenceAttribute(fd.attributes, FieldDef.NOECHO_ATTR)) {
        	
        	if (FieldDef.absenceAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR))
        		addAttrb(attrbs, "NORM");

        }
        
        
        if (FieldDef.absenceAttribute(fd.attributes, FieldDef.NOECHO_ATTR)) {
            if (FieldDef.hasAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR)) {
            	addAttrb(attrbs, "BRT");
            	
            	if (fd.special != FieldDef.GLS)
            	{
                	addAttrb(attrbs, "FSET");
            	}
            }  
        }
        
        if (fd.special == FieldDef.IDC || fd.special == FieldDef.GLS_IDC  ) {

        	if (fd.modifier == FieldDef.AKY || fd.modifier == FieldDef.IKY || fd.modifier == FieldDef.MKY)
        	{
            	addAttrb(attrbs, "FSET");
        	}
        }
        if (fd.special == FieldDef.FEC ||
               (fd.type == FieldDef.INTEGER && fd.special != FieldDef.VRF) || fd.type == FieldDef.LONG || (fd.type == FieldDef.DOUBLE)) {
                 addAttrb(attrbs, "FSET");
             }
        
        if (fd.special == FieldDef.VRF) {
        	if (fd.modifier == FieldDef.AKY || fd.modifier == FieldDef.IKY || fd.modifier == FieldDef.MKY)
        	{
            	addAttrb(attrbs, "FSET");
        	}
        }
        */
        
        
        
        if (FieldDef.absenceAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR) || fd.special == FieldDef.FEC ) {
            addAttrb(attrbs, "NORM");
            if (FieldDef.hasAttribute(fd.attributes, FieldDef.NOECHO_ATTR)) {
            	addAttrb(attrbs, "BRT");
            }
            else
	            if (FieldDef.hasAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR)) {
	            	addAttrb(attrbs, "BRT");
	            }

            if (fd.modifier == FieldDef.FLD && fd.special == FieldDef.VRF ){
            	addAttrb(attrbs, "FSET");
            }
            
            
            
        }
	        else if (fd.special == FieldDef.IDC || fd.special == FieldDef.VRF || fd.special == FieldDef.GLS_IDC ) {
	            addAttrb(attrbs, "NORM");
	            
	        }        
		        else if (FieldDef.hasAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR)) {
		            if (FieldDef.hasAttribute(fd.attributes, FieldDef.NOECHO_ATTR)) {
		                addAttrb(attrbs, "DRK");
		            }
		            else {
		            	addAttrb(attrbs, "BRT"); 
		            }
		        }


        if ((fd.modifier == FieldDef.AKY || fd.modifier == FieldDef.IKY || fd.modifier == FieldDef.MKY)  ){
            addAttrb(attrbs, "FSET");
            
            if (FieldDef.hasAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR) && fd.fmsname.indexOf("_GLS_") == -1 && fd.special == -1) {
                addAttrb(attrbs, "FSET");
            }
        }
        else {
        	
	        if (fd.modifier == FieldDef.FLD && FieldDef.hasAttribute(fd.attributes, FieldDef.SUPPRESS_ATTR)) {
	            addAttrb(attrbs, "FSET");
	            
	            //ultimo, quizas hay que restringir solo a numericos *OJO
	            if (FieldDef.hasAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR))
	            	addAttrb(attrbs, "FSET");
	            else if (FieldDef.hasAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR) && fd.fmsname.indexOf("_GLS_") == -1 && fd.special == -1) {
	                    addAttrb(attrbs, "FSET");
	                }
	                
	        }
	        else {
	            if (FieldDef.hasAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR) && fd.fmsname.indexOf("_GLS_") == -1 && fd.special == -1) {
	                addAttrb(attrbs, "FSET");
	            }
	            
		        if (fd.special == FieldDef.FEC ||
		           (fd.type == FieldDef.INTEGER ) || fd.type == FieldDef.LONG || (fd.type == FieldDef.DOUBLE)) {
		            addAttrb(attrbs, "FSET");
		        }
		        else
		        	if (fd.special == FieldDef.VRF || fd.special == FieldDef.IDC || fd.special == FieldDef.GLS_IDC) {
		        		addAttrb(attrbs, "FSET");
		        	}
	        }
        }
        //

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < attrbs.size(); i++) {
            sb.append((i > 0 ? "," : "") + attrbs.get(i));
        }

        return sb.toString();
    }

    /******************************************************************************
     * addAttrb
     ******************************************************************************/
    /**
     *
     * @param fd TODO_javadoc
     *
     */
    private static void addAttrb(ArrayList<String> attrbs, String attrb) {

      //  if (!attrbs.contains(attrb)) {
            attrbs.add(attrb);
      //  }
    }

    /******************************************************************************
     * getAttrb
     ******************************************************************************/
    /**
     *
     * @param fd TODO_javadoc
     *
     */
    /*
    private static String getAttrbSpecial(FieldDef fd) {

        ArrayList<String> attrbs = new ArrayList<String>();

        if (fd.special == FieldDef.IDC || fd.special == FieldDef.VRF) {
            addAttrb(attrbs, "PROT");
            addAttrb(attrbs, "BRT");
        }

        //

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < attrbs.size(); i++) {
            sb.append((i > 0 ? "," : "") + attrbs.get(i));
        }

        return sb.toString();
    }
    */

    /*******************************************************************************************************
     * toBinBytes
     *******************************************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param b TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public static String toBinBytes(byte b) {

        byte[] aux = new byte[8];

        for (int i = 7; i >= 0; i--) {

            aux[i] = (b & 0x01) == 0 ? (byte) '0' : (byte) '1';
            b      = (byte) (b >> 1);
        }

        return new String(aux);
    }

}
