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

import cl.bee.genfrmjava.config.*;
import cl.bee.genfrmjava.config.impl.*;

import cl.bee.genfrmjava.adddef.schema.*;
import cl.bee.genfrmjava.rangedef.schema.*;
import cl.bee.genfrmjava.domaindef.schema.*;

import cl.bee.genfrmjava.util.*;

import org.apache.log4j.*;

import org.apache.xmlbeans.*;


/**
 * @author  alarrayea@bee.cl
 * @version 1.0
 */
public class GenFrm {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(GenFrm.class);

    /** TODO_javadoc. */
    private final static int[] KEY_TYPES = new int[] { FieldDef.IKY, FieldDef.MKY, FieldDef.AKY };

    /** TODO_javadoc. */
    private static final SimpleDateFormat formdate_gen = new SimpleDateFormat("dd-MMM-yy hh:mm aa", new Locale("es", "CL")); //07-Nov-18 09:48 AM

    //

    /** TODO_javadoc. */
    public static final int UNDEF = -1;

    /** TODO_javadoc. */
    private static final int BA_ACTION = 1;

    /** TODO_javadoc. */
    private static final int BQ_ACTION = 2;

    /** TODO_javadoc. */
    private static final int BU_ACTION = 3;

    /** TODO_javadoc. */
    private static final String action_names[] = { "", "BA", "BQ", "BU" };

    //
    
    /** TODO_javadoc. */
    private static final String[] cond_extras = {"PGM_BQ", "PGM_BU"};
    
    
    //Variables de VAX/Compilacion
    private static final Boolean PGM_PTC = true;
    private static final Boolean PGM_PER = false;
    private static final Boolean PGM_ARG = false;

    /** TODO_javadoc. */
    private static PrintStream gen = null;

    /** TODO_javadoc. */
    private static HashMap<String, Boolean> environment_hash = null;
    
    /** TODO_javadoc. */
    private static HashMap<String, SectionDef> addit_hash = null;

    /** TODO_javadoc. */
    private static HashMap<String, DomainRangeDef> ranges_hash = null;

    /** TODO_javadoc. */
    private static HashMap<String, DomainRangeDef> domains_hash = null;

    /** TODO_javadoc. */
    private static String systemName = null;

    /** TODO_javadoc. */
    private static String entityName = null;

    //

    /** TODO_javadoc. */
    private static int action = UNDEF;

    /******************************************************************************
     * main
     ******************************************************************************/
    /**
     *
     * @param args TODO_javadoc.
     *
     */
    public static void main(String args[]) {

    	BasicConfigurator.configure();
        logger.info("Inicio GenFrm.java ");
        try {

            String configClass = null;

            for (int idx = 0; idx < args.length - 1; idx++) {

                if (args[idx].equalsIgnoreCase("-system")) {
                    systemName = args[++idx].toUpperCase();
                }

                if (args[idx].equalsIgnoreCase("-entity")) {
                    entityName = args[++idx].toUpperCase();
                }

                if (args[idx].equalsIgnoreCase("-action")) {

                    String s = args[++idx].toUpperCase();

                    for (int i = 1; i < action_names.length; i++) {

                        if (s.equals(action_names[i])) {

                            action = i;

                            break;
                        }
                    }
                }

                if (args[idx].equalsIgnoreCase("-configClass")) {
                    configClass = args[++idx];
                }
            }
            
            //archivo de parametros de ambiente
            String linea;
            String envFile = "data/environment/config.txt";
            BufferedReader bufferreader = new BufferedReader(new FileReader(envFile));
            
            environment_hash = new HashMap<String, Boolean>();
            
            while ((linea = bufferreader.readLine()) != null) {     
                
            	if (!linea.startsWith("//")) {
            		
	            	String[] parts = linea.split("=");

		            	if ((parts[0] == null || parts[1] == null) ) 
		            		throw new RuntimeException("archivo de parametros config.txt invalido.");

	            	environment_hash.put(parts[0].trim(),Boolean.parseBoolean(parts[1].trim().toLowerCase()));
	            	environment_hash.put("NOT " + parts[0].trim(), (Boolean.parseBoolean(parts[1].trim().toLowerCase()) ? false : true));
            	}
              }
            

            logger.debug("systemName: " + systemName);
            logger.debug("entityName: " + entityName);
            logger.debug("action:     " + action_names[action]);

            if (configClass == null) {
                throw new RuntimeException("configClass debe estar definido.");
            }

            //

            ArrayList<Object>  fields = new ArrayList<Object>();
            ArrayList<TextDef> texts  = new ArrayList<TextDef>();
            FormDef            forms = new FormDef();

            //

            Config config = (Config) (Class.forName(configClass).newInstance());

            config.getInfoFromXML("data/form/form_" +   systemName.toLowerCase() + "_" + entityName.toLowerCase() + ".xml", fields, texts, forms);

            //

            addit_hash = new HashMap<String, SectionDef>();

            getAdditFromXML(       "data/addit/addit_" + systemName.toLowerCase() + "_" + entityName.toLowerCase() + "_" + action_names[action].toLowerCase() + ".xml");

            //

            ranges_hash  = new HashMap<String, DomainRangeDef>();
            domains_hash = new HashMap<String, DomainRangeDef>();

            getRangesFromXML ("data/domain-range/range_"  + systemName.toLowerCase() + ".xml");
            getDomainsFromXML("data/domain-range/domain_" + systemName.toLowerCase() + ".xml");

            //

            ArrayList<String> subsystems = getSubsystemsFromFields(fields);

            //

            gen = new PrintStream(new FileOutputStream("data/gen/" + systemName + action_names[action] + entityName + ".SRCAIU"));

            gen.println("      *");
            gen.println("      * " + systemName + action_names[action] + entityName);
            gen.println("      * " + Utils.NOMBRE_GENEDADOR + " " + Utils.VERSION_GENEDADOR);
            gen.println("      * " + formdate_gen.format(new Date()).toUpperCase());
            gen.println("      *");
            
            printGen("SETTAG", "PGM_" + action_names[action]);
            
            
            gen.println("       SET-TAG-" + systemName + action_names[action] + entityName + " SECTION.");
            gen.println("       INI-SET-TAG-" + systemName + action_names[action] + entityName + ".");
            gen.println("           MOVE");

          //gen.println("           '<IDNMOD NOM=$" + systemName + action_names[action] + entityName + "$ VSN=${VSN" + action_names[action] + "}$ VGM=$3.0.1$");
            gen.println("           '<IDNMOD NOM=$" + systemName + action_names[action] + entityName + "$ VSN=$09.08.27$ VGM=$3.0.1$");

          //gen.println("      -    'GEN=$07-Nov-18 09:48 AM$ FNC=${FNC" + action_names[action] + "}$/>'");
            gen.println("      -    'GEN=$07-Nov-18 09:48 AM$ FNC=$090802$/>'");

            gen.println("               TO WSS-CVT-ITEM.");
            gen.println("       FIN-SET-TAG-" + systemName + action_names[action] + entityName + ".");
            gen.println("           EXIT.");
            gen.println();

            /////////////////////////////////////////////////////////////////////////////////////
            
            //ogb glosas
            HashMap<String, Integer>  gls  = getGlsFromFields(fields);
           //ogb
            

            if (action == BQ_ACTION) {

                genPUT_ALL_entity(entityName, subsystems);

                for (String subsys : subsystems) {

                    if (!subsys.equals(FieldDef.FRM)) {
                        genPUT_subsys_entity(subsys, entityName, fields, gls);
                    }
                }

                genKEY_ALL_entity(entityName, subsystems);

                for (String subsys : subsystems) {

                    if (!subsys.equals(FieldDef.FRM)) {
                        genKEY_subsys_entity(subsys, entityName, fields);
                    }
                }

                genSCR_CLRA_entity(entityName, fields, subsystems);

                for (String subsys : subsystems) {

                    if (!subsys.equals(FieldDef.FRM)) {
                        genCLR_subsys_entity(subsys, entityName, fields);
                    }
                }

                genFST_KEY_entity(entityName, fields);

                genFST_FLD_entity(entityName, fields);

                genPRO_KEY_entity(entityName, fields);

                genUNP_KEY_entity(entityName, fields);

                genUNP_FLD_entity(entityName, fields, subsystems);

                for (String subsys : subsystems) {

                    if (!subsys.equals(FieldDef.FRM)) {
                        genUNP_subsys_entity(subsys, entityName, fields);
                    }
                }

                genVAL_KEY_entity(entityName, fields, gls);

                genVAL_CON_KEY_entity(entityName, fields);

                genVAL_CON_IKY_entity(entityName, fields);

                genVAL_NUM_KEY_entity(entityName, fields);

                genVAL_NUM_FLD_entity(entityName, fields);

                genEDT_KEY_entity(entityName, fields);

                genEDT_FLD_entity(entityName, fields);
            }

            /////////////////////////////////////////////////////////////////////////////////////

            if (action == BU_ACTION) {

                genRET_ALL_entity(entityName, subsystems);

                for (String subsys : subsystems) {

                    if (!subsys.equals(FieldDef.FRM)) {
                        genRET_subsys_entity(subsys, entityName, fields);
                    }
                }

                genKEY_ALL_entity(entityName, subsystems);

                for (String subsys : subsystems) {

                    if (!subsys.equals(FieldDef.FRM)) {
                        genKEY_subsys_entity(subsys, entityName, fields);
                    }
                }

                genSCR_CLRA_entity(entityName, fields, subsystems);

                for (String subsys : subsystems) {

                    if (!subsys.equals(FieldDef.FRM)) {
                        genCLR_subsys_entity(subsys, entityName, fields);
                    }
                }

                genFST_KEY_entity(entityName, fields);

                genFST_FLD_entity(entityName, fields);

                genPRO_KEY_entity(entityName, fields);

                genPRO_FLD_entity(entityName, fields, subsystems);

                for (String subsys : subsystems) {

                    if (!subsys.equals(FieldDef.FRM)) {
                        genPRO_subsys_entity(subsys, entityName, fields);
                    }
                }

                genUNP_KEY_entity(entityName, fields);

                genUNP_FLD_entity(entityName, fields, subsystems);

                for (String subsys : subsystems) {

                    if (!subsys.equals(FieldDef.FRM)) {
                        genUNP_subsys_entity(subsys, entityName, fields);
                    }
                }

                genVAL_MKY_entity(entityName, fields);

                genVAL_FLD_entity( entityName, fields, gls);

                ///////////////

                iniSection("VAL-CON-FLD-" + entityName, "VAL_CON_FLD_" + entityName);
                finSection("VAL-CON-FLD-" + entityName);

                iniSection("VAL-CON-" + entityName); // TODO_ALA: revisar
                finSection("VAL-CON-" + entityName);

                genVAL_NUM_KEY_entity(entityName, fields);

                genVAL_NUM_FLD_entity(entityName, fields);

                genEDT_KEY_entity(entityName, fields);

                genEDT_FLD_entity(entityName, fields);
            }

            //

            String ident = "EOF_" + action_names[action];
            /*
            int z = 0;
            while(addit_hash.containsKey    (ident)) {
            	            	
                gen.println(((SectionDef)addit_hash.get(ident)).getCode());
                z++;
                ident = ident + "$" + z;
            }
            */
            printGen(ident, "PGM_" + action_names[action]);
            


            ident = "EOF";
            
            /*
            z = 0;
            while(addit_hash.containsKey    (ident)) {
                gen.println(addit_hash.get(ident));
                z++;
                ident = ident + "$" + z;
            }
            */
            
            printGen(ident, "PGM_" + action_names[action]);

            //

            gen.close();

        } catch (Throwable e) {
            logger.fatal(Utils.printStackTrace(e));
        }
    }

    /******************************************************************************
     * genPUT_ALL_entity
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param entityName TODO_javadoc.
     * @param subsystems TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void genPUT_ALL_entity(String entityName, ArrayList<String> subsystems) {

        iniSection("PUT-ALL-" + entityName);

        for (String subsys : subsystems) {

            if (!subsys.equals(FieldDef.FRM)) {
                gen.println("           PERFORM PUT-" + subsys + "-" + entityName + ".");
            }
        }

        finSection("PUT-ALL-" + entityName);
    }

    /******************************************************************************
     * genPUT_subsys_entity
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param subsys TODO_javadoc.
     * @param entityName TODO_javadoc.
     * @param fields TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void genPUT_subsys_entity(String subsys, String entityName, ArrayList<Object> fields,  HashMap<String, Integer> gls) {

        iniSection("PUT-" + subsys + "-" + entityName);

        gen.println("           IF PGM-STAT-" + subsys + "-NUL");
        gen.println("               GO TO FIN-PUT-" + subsys + "-" + entityName + ".");

        //

        gen.println("           IF NOT PGM-STAT-" + subsys + "-OKS");
        gen.println("               PERFORM CLR-" + subsys + "-" + entityName);

        /*
        if (subsys.equals(entityName)) { // TODO_ALA: revisar
            gen.println("               PERFORM CLR-FRM-" + entityName);
        }
        */

        gen.println("               GO TO FIN-PUT-" + subsys + "-" + entityName + ".");

        //

        ArrayList<Object>     vars  = getSubsysVarsFromFields(subsys, fields);
        ArrayList<ElementDef> array = null;
        


        for (int i = 0; i < vars.size(); i++) {

            if (vars.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) vars.get(i);

                get_put_field(subsys, entityName, fd, -1);
            }
            else if (vars.get(i) instanceof ArrayList) {

                array = (ArrayList<ElementDef>) vars.get(i);

                for (int j = 0; j < array.size(); j++) {

                    gen.println("      *");
                    gen.println("      *    CAMPO INDEXADO   " + array.get(j).field.name);

                    for (int k = 0; k < array.get(j).index.size(); k++) {

                        get_put_field(subsys, entityName, array.get(j).field, k + 1);
                    }
                }
            }
        }

        for (int i = 0; i < vars.size(); i++) {

            if (vars.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) vars.get(i);

                if (fd.name.substring(3, 8).equals("-IND-") || fd.name.substring(3, 8).equals("-MSC-")
                		|| fd.name.substring(3, 8).equals("-COD-")) { 
                    domain_range_validation_search(entityName, fd, -1, gls, "PUT");
                }
            }
            else {
                //////////////
            }
        }

        finSection("PUT-" + subsys + "-" + entityName);
    }

    /******************************************************************************
     * get_put_field
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param subsys TODO_javadoc.
     * @param entityName TODO_javadoc.
     * @param fd TODO_javadoc.
     * @param idx TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void get_put_field(String subsys, String entityName, FieldDef fd, int idx) {

        if (fd.replaced != null) {

            for (FieldDef fr : fd.replaced) {
            	
            	if (fd.special == FieldDef.FEC && fd.name.length() > 6) {
            		String kindFec = fd.name.substring(4,7);
            		
            		if(!kindFec.equals("FEC")) {
            			
                		String compFec = fr.name.split("-")[2].substring(0,1);
                		
                		if (kindFec.contains(compFec))
                			get_put_field(subsys, entityName, fr, idx);
            		}
                	else
                	{
                	
                		get_put_field(subsys, entityName, fr, idx);
                	}

            	}
            	else
            	{
            	
            		get_put_field(subsys, entityName, fr, idx);
            	}
            }
        }
        else {
            gen.println("           MOVE " + fd.name + " IN " + subsys + (idx != -1 ? "(" + idx + ")" : "") + " TO " + fd.name + " IN " + entityName + "-FLD" + (idx != -1 ? "(" + idx + ")" : "") + ".");
        }
    }

    /******************************************************************************
     * genKEY_ALL_entity
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param entityName TODO_javadoc.
     * @param subsystems TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void genKEY_ALL_entity(String entityName, ArrayList<String> subsystems) {

        iniSection("KEY-ALL-" + entityName);

        for (String subsys : subsystems) {

            if (!subsys.equals(FieldDef.FRM)) {
                gen.println("           PERFORM KEY-" + subsys + "-" + entityName + "."); // solo aquellos que tengan KEY ???
            }
        }

        finSection("KEY-ALL-" + entityName);
    }

    /******************************************************************************
     * genKEY_subsys_entity
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param subsys TODO_javadoc.
     * @param entityName TODO_javadoc.
     * @param fields TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void genKEY_subsys_entity(String subsys, String entityName, ArrayList<Object> fields) {

        iniSection("KEY-" + subsys + "-" + entityName);

        ArrayList<Object> vars = getSubsysVarsFromFields(subsys, fields);

        for (int i = 0; i < vars.size(); i++) {

            if (vars.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) vars.get(i);

                if (Utils.searchIntInArray(fd.modifier, KEY_TYPES) >= 0) {
                    get_ret_field(subsys, entityName, fd, -1);
                }
            }
            else {
                //////////////
            }
        }

        finSection("KEY-" + subsys + "-" + entityName);
    }

    /******************************************************************************
     * get_ret_field
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param subsys TODO_javadoc.
     * @param entityName TODO_javadoc.
     * @param fd TODO_javadoc.
     * @param idx TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void get_ret_field(String subsys, String entityName, FieldDef fd, int idx) {

        if (fd.replaced != null) {

            for (FieldDef fr : fd.replaced) {

	        	if (fd.special == FieldDef.FEC && fd.name.length() > 6) {
	        		String kindFec = fd.name.substring(4,7);
	        		
	        		if(!kindFec.equals("FEC")) {
	        			
	            		String compFec = fr.name.split("-")[2].substring(0,1);
	            		
	            		if (kindFec.contains(compFec))
	            			get_ret_field(subsys, entityName, fr, idx);
	        		}
	            	else
	            	{
	            	
	            		get_ret_field(subsys, entityName, fr, idx);
	            	}
	
	        	}
	        	else
	        	{
	        	
	        		get_ret_field(subsys, entityName, fr, idx);
	        	}
            
            }
            
            
            
        }
        else {
            gen.println("           MOVE " + fd.name + " IN " + entityName + "-FLD" + (idx != -1 ? "(" + idx + ")" : "") + " TO " + fd.name + " IN " + subsys + (idx != -1 ? "(" + idx + ")" : "") + ".");
        }
    }

    /******************************************************************************
     * genSCR_CLRA_entity
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param entityName TODO_javadoc.
     * @param fields TODO_javadoc.
     * @param subsystems TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void genSCR_CLRA_entity(String entityName, ArrayList<Object> fields, ArrayList<String> subsystems) {

        iniSection("SCR-CLRA-" + entityName);

        gen.println("           PERFORM CLR-KEY-" + entityName + ".");
        gen.println("           PERFORM CLR-FLD-" + entityName + ".");

        finSection("SCR-CLRA-" + entityName);

        //

        iniSection("CLR-KEY-" + entityName);

        for (int i = 0; i < fields.size(); i++) {

            if (fields.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) fields.get(i);

                if (Utils.searchIntInArray(fd.modifier, KEY_TYPES) >= 0) {
                    get_clear_field(entityName, fd, -1);
                }
            }
            else {
                //////////////
            }
        }

        finSection("CLR-KEY-" + entityName);

        //

        iniSection("CLR-FLD-" + entityName);

        ArrayList<ElementDef> array = null;

        for (int i = 0; i < fields.size(); i++) {

            if (fields.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) fields.get(i);

                if (fd.fmsname.substring(0, 3).equals(FieldDef.FRM)) {
                	if (fd.modifier != FieldDef.AKY && fd.modifier != FieldDef.IKY && fd.modifier != FieldDef.MKY) {
                		get_clear_field(entityName, fd, -1);
                	}
                }
            }
            else if (fields.get(i) instanceof ArrayList) {

                array = (ArrayList<ElementDef>) fields.get(i);

                for (int j = 0; j < array.size(); j++) {

                    if (array.get(j).field.name.substring(0, 3).equals(FieldDef.FRM)) {

                        for (int k = 0; k < array.get(j).index.size(); k++) {
                            get_clear_field(entityName, array.get(j).field, k + 1);
                        }
                    }
                }
            }
        }

        for (String subsys : subsystems) {

            if (!subsys.equals(FieldDef.FRM)) {
                gen.println("           PERFORM CLR-" + subsys + "-" + entityName + ".");
            }
        }

        finSection("CLR-FLD-" + entityName);
    }

    /******************************************************************************
     * get_clear_field
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param entityName TODO_javadoc.
     * @param fd TODO_javadoc.
     * @param idx TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void get_clear_field(String entityName, FieldDef fd, int idx) {

        if (fd.replaced != null && fd.type != FieldDef.DATE) {

            for (FieldDef fr : fd.replaced) {
                get_clear_field(entityName, fr, idx);
            }
        }
        else {

            switch (fd.type) {

            case FieldDef.INTEGER :
            case FieldDef.LONG :
            case FieldDef.DOUBLE :
            case FieldDef.DATE :
                gen.println("           MOVE ZEROES TO " + fd.name + " IN " + entityName + "-FLD" + (idx != -1 ? "(" + idx + ")" : "") + ".");
                break;
            case FieldDef.CHAR :
            case FieldDef.BOOLEAN :
            case FieldDef.STRING :
                gen.println("           MOVE SPACES TO " + fd.name + " IN " + entityName + "-FLD" + (idx != -1 ? "(" + idx + ")" : "") + ".");
                break;
            }
        }
    }

    /******************************************************************************
     * genCLR_subsys_entity
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param subsys TODO_javadoc.
     * @param entityName TODO_javadoc.
     * @param fields TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void genCLR_subsys_entity(String subsys, String entityName, ArrayList<Object> fields) {

        iniSection("CLR-" + subsys + "-" + entityName);

        ArrayList<Object>     vars  = getSubsysVarsFromFields(subsys, fields);
        ArrayList<ElementDef> array = null;

        for (int i = 0; i < vars.size(); i++) {

            if (vars.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) vars.get(i);

                if (Utils.searchIntInArray(fd.modifier, KEY_TYPES) < 0) {
                    get_clear_field(entityName, fd, -1);
                }
            }
            else if (vars.get(i) instanceof ArrayList) {

                array = (ArrayList<ElementDef>) vars.get(i);

                for (int j = 0; j < array.size(); j++) {

                    for (int k = 0; k < array.get(j).index.size(); k++) {

                        if (Utils.searchIntInArray(array.get(j).field.modifier, KEY_TYPES) < 0) {
                            get_clear_field(entityName, array.get(j).field, k + 1);
                        }
                    }
                }
            }
       }

        finSection("CLR-" + subsys + "-" + entityName);
    }

    /******************************************************************************
     * genFST_KEY_entity
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param entityName TODO_javadoc.
     * @param fields TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void genFST_KEY_entity(String entityName, ArrayList<Object> fields) {

        iniSection("FST-KEY-" + entityName);

        chkField:
        for (int i = 0; i < fields.size(); i++) {

            if (fields.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) fields.get(i);

                if (fd.replaced != null && fd.type != FieldDef.DATE) {

                    for (FieldDef fr : fd.replaced) {
                        if (Utils.searchIntInArray(fr.modifier, new int[] { FieldDef.IKY }) >= 0 && FieldDef.absenceAttribute(fr.attributes, FieldDef.DISPLAY_ONLY_ATTR)) {

                             gen_pos_cursor(entityName, fr, -1);

                             break chkField;
                        }
                    }
                }
                else {
                    if (Utils.searchIntInArray(fd.modifier, new int[] { FieldDef.IKY }) >= 0 && FieldDef.absenceAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR)) {

                        gen_pos_cursor(entityName, fd, -1);

                        break chkField;
                   }
                }
                

            }
            else {
                //////////////
            }
        }

        finSection("FST-KEY-" + entityName);
    }

    /******************************************************************************
     * gen_pos_cursor
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param entityName TODO_javadoc.
     * @param fd TODO_javadoc.
     * @param size TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void gen_pos_cursor(String entityName, FieldDef fd, int size) {
        gen.println("           MOVE -1 TO " + fd.name + "-LEN IN " + entityName + "-FLD" + (size != -1 ? "(1)": "") + ".");
    }

    /******************************************************************************
     * genFST_KEY_entity
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param entityName TODO_javadoc.
     * @param fields TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void genFST_FLD_entity(String entityName, ArrayList<Object> fields) {

        iniSection("FST-FLD-" + entityName);

        ArrayList<ElementDef> array = null;

        for (int i = 0; i < fields.size(); i++) {

            if (fields.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) fields.get(i);

                if (fd.modifier == FieldDef.FLD && FieldDef.absenceAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR)) {

                    gen_pos_cursor(entityName, fd, -1);

                    break;
                }
                
                if (fd.modifier == FieldDef.MKY && FieldDef.absenceAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR)) {

                    gen_pos_cursor(entityName, fd, -1);

                    break;
                } 
            }
            else if (fields.get(i) instanceof ArrayList) {

                array = (ArrayList<ElementDef>) fields.get(i);

                for (int j = 0; j < array.size(); j++) {

                    if (array.get(j).field.modifier == FieldDef.FLD && FieldDef.absenceAttribute(array.get(j).field.attributes, FieldDef.DISPLAY_ONLY_ATTR)) {

                        gen_pos_cursor(entityName, array.get(j).field, array.get(j).index.size());

                        break;
                    }
                }
            }
        }

        finSection("FST-FLD-" + entityName);
    }

    /******************************************************************************
     * genPRO_KEY_entity
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param entityName TODO_javadoc.
     * @param fields TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void genPRO_KEY_entity(String entityName, ArrayList<Object> fields) {

        iniSection("PRO-KEY-" + entityName);

        ArrayList<ElementDef> array = null;

        for (int i = 0; i < fields.size(); i++) {

            if (fields.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) fields.get(i);

                if (fd.fmsname.substring(0, 3).equals(FieldDef.FRM) && FieldDef.absenceAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR)) {
                	if (fd.modifier == FieldDef.AKY || fd.modifier == FieldDef.IKY || fd.modifier == FieldDef.MKY) {
                		gen_set_field_attr(entityName, fd, "FRM-CPIM-AEY", false, -1);
                	}
                }
            }
            else if (fields.get(i) instanceof ArrayList) {

                array = (ArrayList<ElementDef>) fields.get(i);

                for (int j = 0; j < array.size(); j++) {

                    if (array.get(j).field.name.substring(0, 3).equals(FieldDef.FRM) && FieldDef.absenceAttribute(array.get(j).field.attributes, FieldDef.DISPLAY_ONLY_ATTR)) {

                    	if (array.get(j).field.modifier == FieldDef.AKY || array.get(j).field.modifier == FieldDef.IKY) {
                            for (int k = 0; k < array.get(j).index.size(); k++) {
                            	gen_set_field_attr(entityName, array.get(j).field, "FRM-CPIM-AEY", false, -1);
                            }
                    	}
                    }
                }
            }
        }
        
        
        if (action == BQ_ACTION) {
            gen.println("           PERFORM PRO-IKY-" + entityName + ".");
            gen.println("           PERFORM PRO-AKY-" + entityName + ".");
        }

        gen.println("           PERFORM PRO-MKY-" + entityName + ".");

        finSection("PRO-KEY-" + entityName);

        //

        if (action == BQ_ACTION) {

            iniSection("PRO-IKY-" + entityName);

            for (int i = 0; i < fields.size(); i++) {

                if (fields.get(i) instanceof FieldDef) {

                    FieldDef fd = (FieldDef) fields.get(i);

                    if (fd.modifier == FieldDef.IKY && FieldDef.absenceAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR)) {
                    	if (!fd.fmsname.substring(0, 3).equals(FieldDef.FRM)) {
                        	gen_set_field_attr(entityName, fd, "FRM-CPIM-AEY", false, -1);
                        }
                    }
                }
                else {
                    //////////////
                }
            }

            finSection("PRO-IKY-" + entityName);

            //

            iniSection("PRO-MKY-" + entityName);

            for (int i = 0; i < fields.size(); i++) {

                if (fields.get(i) instanceof FieldDef) {

                    FieldDef fd = (FieldDef) fields.get(i);

                    if (fd.modifier == FieldDef.MKY && FieldDef.absenceAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR)) {
                    	if (!fd.fmsname.substring(0, 3).equals(FieldDef.FRM)) {
                    		gen_set_field_attr(entityName, fd, "FRM-CPIM-AEY", false, -1);
                    	}
                    }
                }
                else {
                    //////////////
                }
            }

            finSection("PRO-MKY-" + entityName);

            //

            iniSection("PRO-AKY-" + entityName);

            for (int i = 0; i < fields.size(); i++) {

                if (fields.get(i) instanceof FieldDef) {

                    FieldDef fd = (FieldDef) fields.get(i);

                    if (fd.modifier == FieldDef.AKY && FieldDef.absenceAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR)) {
                    		gen_set_field_attr(entityName, fd, "FRM-CPIM-AEY", false, -1);
                    }
                }
                else {
                    //////////////
                }
            }

            finSection("PRO-AKY-" + entityName);
        }
        else {

            iniSection("PRO-MKY-" + entityName);

            for (int i = 0; i < fields.size(); i++) {

                if (fields.get(i) instanceof FieldDef) {

                    FieldDef fd = (FieldDef) fields.get(i);

                    if (fd.modifier == FieldDef.MKY) {
                    	if (!fd.fmsname.substring(0, 3).equals(FieldDef.FRM)) {
                    		gen_set_field_attr(entityName, fd, "FRM-CPIM-AEY", false, -1);
                    	}
                    }
                }
                else {
                    //////////////
                }
            }

            finSection("PRO-MKY-" + entityName);
        }
    }

    /******************************************************************************
     * gen_set_field_attr
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param entityName TODO_javadoc.
     * @param fd TODO_javadoc.
     * @param attr TODO_javadoc.
     * @param withRecord TODO_javadoc.
     * @param idx TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void gen_set_field_attr(String entityName, FieldDef fd, String attr, boolean withoutRecord, int idx) { // TODO_ALA:

        if (fd.replaced != null && fd.type != FieldDef.DATE) {

            for (FieldDef fr : fd.replaced) {
                gen_set_field_attr(entityName, fr, attr, withoutRecord, idx);
            }
        }
        else {
            gen.println("           MOVE " + attr + " TO " + fd.name + "-ATR" + (withoutRecord ? "" : " IN " + entityName + "-FLD") + (idx != -1 ? "(" + idx + ")" : "") + ".");
        }
    }

    /******************************************************************************
     * genUNP_KEY_entity
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param entityName TODO_javadoc.
     * @param fields TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void genUNP_KEY_entity(String entityName, ArrayList<Object> fields) {

        iniSection("UNP-KEY-" + entityName);

        
        ArrayList<ElementDef> array = null;

        for (int i = 0; i < fields.size(); i++) {

            if (fields.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) fields.get(i);

                if (fd.fmsname.substring(0, 3).equals(FieldDef.FRM) && FieldDef.absenceAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR)) {
                	if (fd.modifier == FieldDef.AKY || fd.modifier == FieldDef.IKY || fd.modifier == FieldDef.MKY) {
                		gen_set_field_attr(entityName, fd, "FRM-CPIM-UBY", false, -1);
                	}
                }
            }
            else if (fields.get(i) instanceof ArrayList) {

                array = (ArrayList<ElementDef>) fields.get(i);

                for (int j = 0; j < array.size(); j++) {

                    if (array.get(j).field.name.substring(0, 3).equals(FieldDef.FRM) && FieldDef.absenceAttribute(array.get(j).field.attributes, FieldDef.DISPLAY_ONLY_ATTR)) {
                    	if (array.get(j).field.modifier == FieldDef.AKY || array.get(j).field.modifier == FieldDef.IKY) {
	                        for (int k = 0; k < array.get(j).index.size(); k++) {
	                        	gen_set_field_attr(entityName, array.get(j).field, "FRM-CPIM-UBY", false, -1);
	                        }
                    	}
                    }
                }
            }
        }
        
        gen.println("           PERFORM UNP-IKY-" + entityName + ".");
        gen.println("           PERFORM UNP-AKY-" + entityName + ".");
        gen.println("           PERFORM UNP-MKY-" + entityName + ".");

        finSection("UNP-KEY-" + entityName);

        //

        iniSection("UNP-IKY-" + entityName);

        for (int i = 0; i < fields.size(); i++) {

            if (fields.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) fields.get(i);

                if (fd.modifier == FieldDef.IKY && FieldDef.absenceAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR) ) {
                    gen_set_field_attr(entityName, fd, "FRM-CPIM-UBY", false, -1); ///// verificar con B?
                }
            }
            else {
                //////////////
            }
        }

        finSection("UNP-IKY-" + entityName);

        //

        iniSection("UNP-MKY-" + entityName);

        for (int i = 0; i < fields.size(); i++) {

            if (fields.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) fields.get(i);

                if (fd.modifier == FieldDef.MKY && FieldDef.absenceAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR)) {
                    gen_set_field_attr(entityName, fd, "FRM-CPIM-UBY", false, -1);
                }
            }
            else {
                //////////////
            }
        }

        finSection("UNP-MKY-" + entityName);

        //

        iniSection("UNP-AKY-" + entityName);

        for (int i = 0; i < fields.size(); i++) {

            if (fields.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) fields.get(i);

                if (fd.modifier == FieldDef.AKY && FieldDef.absenceAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR)) {
                    gen_set_field_attr(entityName, fd, "FRM-CPIM-UBY", true, -1);
                }
            }
            else {
                //////////////
            }
        }

        finSection("UNP-AKY-" + entityName);
    }

    /******************************************************************************
     * genPRO_FLD_entity
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param entityName TODO_javadoc.
     * @param fields TODO_javadoc.
     * @param subsystems TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void genPRO_FLD_entity(String entityName, ArrayList<Object> fields, ArrayList<String> subsystems) {

        iniSection("PRO-FLD-" + entityName);

        for (int i = 0; i < fields.size(); i++) {

            if (fields.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) fields.get(i);

                if (fd.fmsname.substring(0, 3).equals(FieldDef.FRM) && FieldDef.absenceAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR)) {
                	if (fd.modifier == FieldDef.FLD)
                		gen_set_field_attr(entityName, fd, "FRM-CPIM-AEY", false, -1);
                }
            }
            else {
                //////////////
            }
        }

        for (String subsys : subsystems) {

            if (!subsys.equals(FieldDef.FRM)) {
                gen.println("           PERFORM PRO-" + subsys + "-" + entityName + ".");
            }
        }

        finSection("PRO-FLD-" + entityName);
    }

    /******************************************************************************
     * genPRO_subsys_entity
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param subsys TODO_javadoc.
     * @param entityName TODO_javadoc.
     * @param fields TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void genPRO_subsys_entity(String subsys, String entityName, ArrayList<Object> fields) {

        iniSection("PRO-" + subsys + "-" + entityName);

        ArrayList<Object>     vars  = getSubsysVarsFromFields(subsys, fields);
        ArrayList<ElementDef> array = null;

        for (int i = 0; i < vars.size(); i++) {

            if (vars.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) vars.get(i);

                if (Utils.searchIntInArray(fd.modifier, KEY_TYPES) < 0 && FieldDef.absenceAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR)) {
                    gen_set_field_attr(entityName, fd, "FRM-CPIM-AEY", false, -1);
                }
            }
            else if (vars.get(i) instanceof ArrayList) {

                array = (ArrayList<ElementDef>) vars.get(i);

                for (int j = 0; j < array.size(); j++) {

                    for (int k = 0; k < array.get(j).index.size(); k++) {

                        if (Utils.searchIntInArray(array.get(j).field.modifier, KEY_TYPES) < 0 && FieldDef.absenceAttribute(array.get(j).field.attributes, FieldDef.DISPLAY_ONLY_ATTR)) {
                            gen_set_field_attr(entityName, array.get(j).field, "FRM-CPIM-AEY", false, k + 1);
                        }
                    }
                }
            }
       }

        finSection("PRO-" + subsys + "-" + entityName);
    }

    /******************************************************************************
     * genUNP_FLD_entity
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param entityName TODO_javadoc.
     * @param fields TODO_javadoc.
     * @param subsystems TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void genUNP_FLD_entity(String entityName, ArrayList<Object> fields, ArrayList<String> subsystems) {

        iniSection("UNP-FLD-" + entityName);

        for (int i = 0; i < fields.size(); i++) {

            if (fields.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) fields.get(i);

                if (fd.fmsname.substring(0, 3).equals(FieldDef.FRM) && FieldDef.absenceAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR)) {
                	if (fd.modifier == FieldDef.FLD)
                		gen_set_field_attr(entityName, fd, "FRM-CPIM-UBY", false, -1);
                }
            }
            else {
                //////////////
            }
        }

        for (String subsys : subsystems) {

            if (!subsys.equals(FieldDef.FRM)) {
                gen.println("           PERFORM UNP-" + subsys + "-" + entityName + ".");
            }
        }

        finSection("UNP-FLD-" + entityName);
    }

    /******************************************************************************
     * genUNP_subsys_entity
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param subsys TODO_javadoc.
     * @param entityName TODO_javadoc.
     * @param fields TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void genUNP_subsys_entity(String subsys, String entityName, ArrayList<Object> fields) {

        iniSection("UNP-" + subsys + "-" + entityName);

        ArrayList<Object>     vars  = getSubsysVarsFromFields(subsys, fields);
        ArrayList<ElementDef> array = null;

        for (int i = 0; i < vars.size(); i++) {

            if (vars.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) vars.get(i);

                if (Utils.searchIntInArray(fd.modifier, KEY_TYPES) < 0 && FieldDef.absenceAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR)) {
                    gen_set_field_attr(entityName, fd, "FRM-CPIM-UBY", false, -1);
                }
            }
            else if (vars.get(i) instanceof ArrayList) {

                array = (ArrayList<ElementDef>) vars.get(i);

                for (int j = 0; j < array.size(); j++) {

                    for (int k = 0; k < array.get(j).index.size(); k++) {

                        if (Utils.searchIntInArray(array.get(j).field.modifier, KEY_TYPES) < 0 && FieldDef.absenceAttribute(array.get(j).field.attributes, FieldDef.DISPLAY_ONLY_ATTR)) {
                            gen_set_field_attr(entityName, array.get(j).field, "FRM-CPIM-UBY", false, k + 1);
                        }
                    }
                }
            }
       }

        finSection("UNP-" + subsys + "-" + entityName);
    }

    /******************************************************************************
     * genVAL_KEY_entity
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param entityName TODO_javadoc.
     * @param fields TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void genVAL_KEY_entity(String entityName, ArrayList<Object> fields,HashMap<String, Integer> gls ) {

        iniSection("VAL-KEY-" + entityName);

        gen.println("           PERFORM VAL-IKY-" + entityName + ".");
        gen.println("           PERFORM VAL-MKY-" + entityName + ".");
        gen.println("           PERFORM VAL-AKY-" + entityName + ".");

        finSection("VAL-KEY-" + entityName);

        //

        iniSection("VAL-IKY-" + entityName);

        for (int i = 0; i < fields.size(); i++) {

            if (fields.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) fields.get(i);

                if (fd.modifier == FieldDef.IKY) {
                    perform_and_validation(entityName, fd, "VAL-IKY", true, -1);
                }
            }
            else {
                //////////////
            }
        }

        finSection("VAL-IKY-" + entityName);

        //

        genVAL_MKY_entity(entityName, fields);

        //

        iniSection("VAL-AKY-" + entityName);

        for (int i = 0; i < fields.size(); i++) {

            if (fields.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) fields.get(i);

                if (fd.modifier == FieldDef.AKY) {
                    perform_and_validation(entityName, fd, "VAL-AKY", false, -1);
                }
            }
            else {
                //////////////
            }
        }

        finSection("VAL-AKY-" + entityName);

        //

        for (int i = 0; i < fields.size(); i++) {

            if (fields.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) fields.get(i);

                if (Utils.searchIntInArray(fd.modifier, KEY_TYPES) >= 0) {
                    genVAL_field(entityName, fd, -1, gls);
                }
            }
            else {
                //////////////
            }
        }
    }

    /******************************************************************************
     * perform_and_validation
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param entityName TODO_javadoc.
     * @param fd TODO_javadoc.
     * @param sectionName TODO_javadoc.
     * @param size TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void perform_and_validation(String entityName, FieldDef fd, String sectionName, boolean withLineFeed, int size) {

        if (fd.replaced != null && fd.type != FieldDef.DATE) {

            for (FieldDef fr : fd.replaced) {
                perform_and_validation(entityName, fr, sectionName, true, size); /// verificar 'true'
            }
        }
        else {

            gen.print  ("           PERFORM VAL-" + fd.name);

            if (size != -1) {

                gen.println();
                gen.println("            VARYING FRM-IFLD FROM 1 BY 1 UNTIL FRM-IFLD > " + size);
                gen.println("                OR FRM-SUAR = FRM-SUAR-MAL");
                gen.println("                OR FRM-SUAR = FRM-SUAR-CLR.");
            }
            else {
                gen.println(".");
            }

            gen.println("           IF FRM-SUAR = FRM-SUAR-MAL OR FRM-SUAR = FRM-SUAR-CLR");

            if (size != -1) {
                gen.println("                SUBTRACT 1 FROM FRM-IFLD");
            }

          //if (withLineFeed) {
          //    gen.println("                MOVE FRM-IND-ERRO TO " + fd.name + "-LEN IN " + entityName + "-FLD" + (size != -1 ? "(FRM-IFLD)" : ""));
          //}
          //else {
                gen.println("                MOVE FRM-IND-ERRO TO " + fd.name + "-LEN IN " + entityName + "-FLD" + (size != -1 ? "(FRM-IFLD)" : ""));
          //}

            gen.println("                GO TO FIN-" + sectionName + "-" + entityName + ".");
        }
    }

    /******************************************************************************
     * genVAL_field
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param entityName TODO_javadoc.
     * @param fd TODO_javadoc.
     * @param size TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void genVAL_field(String entityName, FieldDef fd, int size, HashMap<String, Integer> gls) {

        if (fd.replaced != null && fd.type != FieldDef.DATE) {

            for (FieldDef fr : fd.replaced) {
                genVAL_field(entityName, fr, size, gls);
            }
        }
        else {

            gen.println("       VAL-" + fd.name + " SECTION.");
            gen.println("       INI-VAL-" + fd.name + ".");

            //

            if (fd.type == FieldDef.DATE) {

                validation_response_required(entityName, fd, size);

                if (FieldDef.absenceAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR)) {

                    gen.println("           MOVE " + fd.name + " IN " + entityName + "-FLD TO FEC-FECH.");
                    gen.println("           MOVE FEC-FORM-FEC TO FEC-FORM.");
                    gen.println("           MOVE FEC-FBLK-S  TO FEC-FBLK.");
                    gen.println("           MOVE FEC-CHOY-LE TO FEC-CHOY.");
                    gen.println("           MOVE FEC-VHBL-S TO FEC-VHBL.");
                }
            }

            String ident = "INI_" + fd.name.replace('-', '_');

            
            printGen(ident, "PGM_" + action_names[action]);
            

            //

            if (FieldDef.absenceAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR) && fd.special != FieldDef.GLS_IDC && fd.type != FieldDef.DATE) { //  &&
                validation_response_required(entityName, fd, size);
            }

            if (fd.special == FieldDef.GLS_IDC) {

                String glosaField = fd.name.substring(0, 3) + "-GLS-" + fd.name.substring(8);

                gen.println("           IF " + glosaField + " IN " + entityName + "-FLD NOT > IDC-INIC-GLS");
                gen.println("              MOVE IDC-INIC-GLS TO " + glosaField + " IN " + entityName + "-FLD.");
                gen.println("      *VAL-GLS para IDC valida glosa ( extension ) de identificador");
                gen.println("           MOVE " + glosaField + " IN " + entityName + "-FLD TO IDC-GLS-RUTV.");
                gen.println("           PERFORM VAL-GLS.");
                gen.println("           MOVE IDC-GLS-RUTV TO " + glosaField + " IN " + entityName + "-FLD.");
            }
            else if (fd.type == FieldDef.STRING && fd.special == FieldDef.VRF) {
           //     validation_response_required(entityName, fd, size);
           //OGB , se agrega validacion de VAL-RUT 	
 
                if (FieldDef.hasAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR))
                    validation_response_required(entityName, fd, size);
                else {
                    gen.println("      *VAL-RUT Valida Rut para campo IDC");
                    gen.println("           MOVE IDC-ZERO-S TO IDC-ZERO.");
                    gen.println("           MOVE " + fd.name.substring(0, 3) + "-NUM-" + fd.name.substring(8) + " IN " + entityName + "-FLD TO IDC-NUM-RUTV.");
                    gen.println("           MOVE " + fd.name + " IN " + entityName + "-FLD TO IDC-VRF-RUTV.");
                    gen.println("           PERFORM VAL-RUT.");	
                }
                
            }
            else if (fd.type == FieldDef.STRING && fd.special == FieldDef.IDC) {
            	
                if (FieldDef.hasAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR))
                    validation_response_required(entityName, fd, size);
                else {
	                gen.println("      *VAL-IDC Valida identificador");
	                gen.println("           MOVE "+ fd.name +" IN " + entityName + "-FLD TO IDC-IND-RUTV.");
	                gen.println("           PERFORM VAL-IDC.");
	                gen.println("           MOVE IDC-IND-RUTV TO "+ fd.name +" IN " + entityName + "-FLD.");
                }
            }
            	
            // probando ...

            //String ident = "INI_" + fd.name.replace('-', '_');
            //
            //if (addit_hash.containsKey    (ident)) {
            //    gen.println(addit_hash.get(ident));
            //}

            //

            if (fd.type == FieldDef.DATE) {

                if (FieldDef.absenceAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR)) {

                    gen.println("           MOVE FEC-VAL-FEC TO FEC-CMND.");
                    gen.println("           PERFORM PRO-FEC.");
                    gen.println("           IF FEC-STAT-OKS");
                    gen.println("               MOVE FEC-FECH TO " + fd.name + " IN " + entityName + "-FLD");
                    gen.println("           ELSE");
                    gen.println("               MOVE FRM-SUAR-MAL TO FRM-SUAR");
                    gen.println("               MOVE FEC-MENS     TO FRM-MENS");
                    gen.println("               GO TO FIN-VAL-" + fd.name + ".");
                }
            }

            //

            ident = fd.name.replace('-', '_');

            printGen(ident, "PGM_" + action_names[action]);
            
            //

            if (FieldDef.absenceAttribute(fd.attributes, FieldDef.DISPLAY_ONLY_ATTR) && fd.special != FieldDef.GLS_IDC) {
                domain_range_validation_search(entityName, fd, size, gls, "VAL");
            }

            //

            //if (fd.fmsname.substring(3, 8).equals("_COD_")) { ///////// validar
            //    domain_range_validation_search(entityName, fd, -1, gls, "VAL");
           // }

            //

            finSection("VAL-" + fd.name, "FIN_" + fd.name.replace('-', '_'));
        }
    }

    /******************************************************************************
     * domain_range_validation_search
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param entityName TODO_javadoc.
     * @param fd TODO_javadoc.
     * @param size TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void domain_range_validation_search(String entityName, FieldDef fd, int size, HashMap<String, Integer> gls,  String sectionType) {


        //ogb-ini
        
        if ( ranges_hash.containsKey(fd.name)) {

            DomainRangeDef range = ranges_hash.get(fd.name);

            //logger.debug("range (" + fd.name + ") --> domain : '" + range.getDomain() + "'");

            if (domains_hash.containsKey(range.getDomain())) {

                DomainRangeDef domain = domains_hash.get(range.getDomain());

              //logger.debug("domain (" + range.getDomain() + ") --> validation : '" + domain.getValidation() + "'");

                if (range.getSearch().equals("") && domain.getSearch().equals(""))
                {
                	String nameD = domain.getName();
                	
                	if (nameD.substring(0, 3).equals("IND") && domain.getRegistry().equals("MSC")) {
                		domain.setSearch("BUSMSC");
                		domain.setValidation("VALIND");
                	}
                	else 
                		if (nameD.substring(0, 3).equals("COD") && domain.getRegistry().equals("TAB")) {
                		domain.setSearch("BUSTAB");
                		domain.setValidation("VALCOD");
                	}
                	
                }
                
                ////////////////////////////////////////////////
                //si esta formando secciones PUT y el campo posee glosa tipo FRM-GLS-
                if (sectionType.equals("PUT") && gls.containsKey(fd.name.substring(8,12))) {
                
	                if (range.getSearch().equals("BUSTAB") /*&&*/|| domain.getSearch().equals("BUSTAB")) {
	
                        gen.println("      *BUS-TAB busca glosa de codigo en tabla");
	                	
	                    switch (fd.type) {
	
	                    case FieldDef.INTEGER :
	                    case FieldDef.LONG :
	                    case FieldDef.DOUBLE :
	                    case FieldDef.DATE :
	
	                        gen.println("           IF " + fd.name + " IN " + entityName + "-FLD > ZEROES");
	
	                        break;
	
	                    case FieldDef.CHAR :
	                    case FieldDef.BOOLEAN :
	                    case FieldDef.STRING :
	
	                        gen.println("           IF " + fd.name + " IN " + entityName + "-FLD > SPACES");
	
	                        break;
	                    }
	
	                    gen.println("               MOVE '" + domain.getSystem() + "' TO TAB-COD-SIST");
	                    gen.println("               MOVE '" + domain.getTable()  + "' TO TAB-COD-TTAB IN TAB");
	                    gen.println("               MOVE " + fd.name + " IN " + entityName + "-FLD TO TAB-COD-CTAB IN TAB");
	                    gen.println("               PERFORM BUS-TAB");
	                    
	                    int glsSize = gls.get(fd.name.substring(8,12));
	                    
	                    if (glsSize == 0 || glsSize > 12)
		                    gen.println("               MOVE TAB-GLS-DESC IN TAB TO");
	                    else if(glsSize > 5)
		                    gen.println("               MOVE TAB-GLS-DCOR IN TAB TO");
	                    else 
		                    gen.println("               MOVE TAB-GLS-ABRV IN TAB TO");
	                    
	                    gen.println("                    FRM-GLS-" + fd.name.substring(8) + " IN " + entityName + "-FLD");            // revisar que exista el campo FRM-GLS-" + fd.name.substring(8) //  && existField("FRM-GLS-" + fd.name.substring(8))
	                    gen.println("           ELSE");
	                    gen.println("               MOVE SPACES TO FRM-GLS-" + fd.name.substring(8) + " IN " + entityName + "-FLD."); // revisar que exista el campo FRM-GLS-" + fd.name.substring(8) //  && existField("FRM-GLS-" + fd.name.substring(8))
	                }
	                
	                if (range.getSearch().equals("BUSMSC") /*&&*/|| domain.getSearch().equals("BUSMSC")) { ///// verificar
	                	
                        gen.println("      *BUS-MSC busca glosa de miscelaneo en tabla");
	                    gen.println("           IF " + fd.name + " IN " + entityName + "-FLD > SPACES");
		                gen.println("               MOVE '" + domain.getSystem() + "' TO MSC-COD-SIST");
	                    gen.println("               MOVE '" + domain.getTable()  + "' TO MSC-COD-TMSC IN MSC");
	                    gen.println("               MOVE " + fd.name + " IN " + entityName + "-FLD TO MSC-COD-CMSC IN MSC");
	                    gen.println("               PERFORM BUS-MSC");
	                    
	                    int glsSize = gls.get(fd.name.substring(8,12));
	                    
	                    if (glsSize == 0 || glsSize > 12)
		                    gen.println("               MOVE MSC-GLS-DESC IN MSC TO");
	                    else if(glsSize > 5)
		                    gen.println("               MOVE MSC-GLS-DCOR IN MSC TO");
	                    else 
		                    gen.println("               MOVE MSC-GLS-ABRV IN MSC TO");
	                    
	                    gen.println("                    FRM-GLS-" + fd.name.substring(8) + " IN " + entityName + "-FLD"); 
	                    gen.println("           ELSE");
	                    gen.println("               MOVE SPACES TO"); 
	                    gen.println("                    FRM-GLS-" + fd.name.substring(8) + " IN " + entityName + "-FLD.");

	                }
	                if (range.getSearch().equals("BUSOFI") /*&&*/|| domain.getSearch().equals("BUSOFI")) {
	                	
                        gen.println("      *BUS-OFI busca oficina en tablas");
	                    gen.println("           IF " + fd.name + " IN " + entityName + "-FLD > SPACES");
	                    gen.println("               MOVE " + fd.name + " IN " + entityName + "-FLD TO OFI-COD-OFIC IN OFI");
	                    gen.println("               PERFORM BUS-OFI");
	                    
	                    int glsSize = gls.get(fd.name.substring(8,12));
	                    
	                    if (glsSize == 0 || glsSize > 5)
		                    gen.println("               MOVE OFI-GLS-DESC IN OFI TO FRM-GLS-" + fd.name.substring(8) + " IN " + entityName + "-FLD");
	                    else 
		                    gen.println("               MOVE OFI-GLS-ABRV IN OFI TO FRM-GLS-" + fd.name.substring(8) + " IN " + entityName + "-FLD");
	                    gen.println("           ELSE");
	                    gen.println("               MOVE SPACES TO FRM-GLS-" + fd.name.substring(8) + " IN " + entityName + "-FLD."); 

	                }
	                if (range.getSearch().equals("BUSUSR") /*&&*/|| domain.getSearch().equals("BUSUSR")) {
	                	
                        gen.println("      *BUS-USR busca usuario en tablas");
	                    gen.println("           IF " + fd.name + " IN " + entityName + "-FLD > SPACES");
	                    gen.println("               MOVE " + fd.name + " IN " + entityName + "-FLD TO USR-COD-USER IN USR");
	                    gen.println("               PERFORM BUS-USR");
	                    
	                    int glsSize = gls.get(fd.name.substring(8,12));
	                    
	                    if (glsSize == 0 || glsSize > 12)
		                    gen.println("               MOVE USR-GLS-DESC IN USR TO FRM-GLS-" + fd.name.substring(8) + " IN " + entityName + "-FLD");
	                    else if(glsSize > 5)
		                    gen.println("               MOVE USR-GLS-DCOR IN USR TO FRM-GLS-" + fd.name.substring(8) + " IN " + entityName + "-FLD");
	                    else 
		                    gen.println("               MOVE USR-GLS-ABRV IN USR TO FRM-GLS-" + fd.name.substring(8) + " IN " + entityName + "-FLD");
	                    gen.println("           ELSE");
	                    gen.println("               MOVE SPACES TO FRM-GLS-" + fd.name.substring(8) + " IN " + entityName + "-FLD."); 

	                }
                }
                else if (sectionType.equals("VAL")) {
                	if (domain.getValidation().equals("VALCOD")) {
                		
                        gen.println("      *VAL-COD Valida codigo de tabla");
                        gen.println("           MOVE '" + domain.getSystem() + "' TO TAB-COD-SIST.");
                        gen.println("           MOVE '" + domain.getTable() +  "' TO TAB-COD-TTAB IN TAB.");
                        gen.println("           MOVE " + fd.name + " IN " + entityName + "-FLD" + (size != -1 ? "(FRM-IFLD)" : "") + " TO TAB-COD-CTAB IN TAB.");
                        gen.println("           PERFORM VAL-COD.");
                        
                        if(gls.containsKey(fd.name.substring(8,12))) {
                        	
    	                    int glsSize = gls.get(fd.name.substring(8,12));
                        	
                            gen.println("           IF MSG-COD-MENS = 'COD    NEX' OR");
    	                    gen.println("             " + fd.name + " IN " + entityName + "-FLD NOT > SPACES");
    	                    gen.println("               MOVE SPACES TO FRM-GLS-" + fd.name.substring(8) + " IN " + entityName + "-FLD");
    	                    gen.println("           ELSE");
    	                    if (glsSize == 0 || glsSize > 12) 
    	                    	gen.println("               MOVE TAB-GLS-DESC IN TAB TO");
    	                    else if (glsSize > 5)
    	                    	gen.println("               MOVE TAB-GLS-DCOR IN TAB TO");
    	                    else
    	                    	gen.println("               MOVE TAB-GLS-ABRV IN TAB TO");
    	                    
	                    	gen.println("                   FRM-GLS-"+ fd.name.substring(8) + " IN " + entityName + "-FLD.");
    	                    
                        }
                	}
                	if (domain.getValidation().equals("VALIND")) {

                        gen.println("      *VAL-IND Valida miscelaneo de tabla");
                        gen.println("           MOVE '" + domain.getSystem() + "' TO MSC-COD-SIST.");
                        gen.println("           MOVE '" + domain.getTable() +  "' TO MSC-COD-TMSC IN MSC.");
                        gen.println("           MOVE " + fd.name + " IN " + entityName + "-FLD" + (size != -1 ? "(FRM-IFLD)" : "") + " TO MSC-COD-CMSC IN MSC.");
                        gen.println("           PERFORM VAL-IND.");
                        
                        if(gls.containsKey(fd.name.substring(8,12))) {
                        	
    	                    int glsSize = gls.get(fd.name.substring(8,12));
                        	
                            gen.println("           IF MSG-COD-MENS = 'COD    NEX' OR");
    	                    gen.println("             " + fd.name + " IN " + entityName + "-FLD NOT > SPACES");
    	                    gen.println("               MOVE SPACES TO FRM-GLS-" + fd.name.substring(8) + " IN " + entityName + "-FLD");
    	                    gen.println("           ELSE");
    	                    if (glsSize == 0 || glsSize > 12) 
    	                    	gen.println("               MOVE MSC-GLS-DESC IN MSC TO");
    	                    else if (glsSize > 5)
    	                    	gen.println("               MOVE MSC-GLS-DCOR IN MSC TO");
    	                    else
    	                    	gen.println("               MOVE MSC-GLS-ABRV IN MSC TO");
    	                    
	                    	gen.println("                   FRM-GLS-"+ fd.name.substring(8) + " IN " + entityName + "-FLD.");
                        
                        }
                	}
                	if (domain.getValidation().equals("VALOFI")) {
                        gen.println("      *VAL-OFI Valida codigo de Oficina en TABLAS");
                        gen.println("           MOVE " + fd.name + " IN " + entityName + "-FLD" + (size != -1 ? "(FRM-IFLD)" : "") + " TO OFI-COD-OFIC IN OFI.");
                        gen.println("           PERFORM VAL-OFI.");
                        gen.println("           IF MSG-COD-MENS NOT = SPACES");
                        gen.println("               MOVE MSG-GLS-DESC TO FRM-MENS");
                        gen.println("               MOVE FRM-SUAR-MAL TO FRM-SUAR.");
                        if(gls.containsKey(fd.name.substring(8,12))) {
    	                    int glsSize = gls.get(fd.name.substring(8,12));
                        	
                            gen.println("           IF MSG-COD-MENS = 'COD    NEX'");
    	                    gen.println("               MOVE SPACES TO FRM-GLS-" + fd.name.substring(8) + " IN " + entityName + "-FLD");
    	                    gen.println("           ELSE");
    	                    if (glsSize == 0 || glsSize > 5)
    	                    	gen.println("           MOVE OFI-GLS-DESC IN OFI TO FRM-GLS-"+ fd.name.substring(8) + " IN " + entityName + "-FLD.");
    	                    else
    	                    	gen.println("           MOVE OFI-GLS-ABRV IN OFI TO FRM-GLS-"+ fd.name.substring(8) + " IN " + entityName + "-FLD.");
                        }
                        
                	}
                	if (domain.getValidation().equals("VALUSR")) {
                        gen.println("      *VAL-USR Valida Usuario");
                        gen.println("           MOVE " + fd.name + " IN " + entityName + "-FLD" + (size != -1 ? "(FRM-IFLD)" : "") + " TO USR-COD-USER IN USR.");
                        gen.println("           PERFORM VAL-USR.");
                        gen.println("           IF MSG-COD-MENS > SPACES");
                        gen.println("               MOVE MSG-GLS-DESC TO FRM-MENS");
                        gen.println("               MOVE FRM-SUAR-MAL TO FRM-SUAR.");
                        if(gls.containsKey(fd.name.substring(8,12))) {
    	                    int glsSize = gls.get(fd.name.substring(8,12));
                        	
                            gen.println("           IF MSG-COD-MENS = 'COD    NEX'");
    	                    if (glsSize == 0 || glsSize > 12)
    	                    	gen.println("           MOVE USR-GLS-DESC IN USR TO FRM-GLS-"+ fd.name.substring(8) + " IN " + entityName + "-FLD.");
    	                    else if (glsSize > 5)
    	                    	gen.println("           MOVE USR-GLS-DCOR IN USR TO FRM-GLS-"+ fd.name.substring(8) + " IN " + entityName + "-FLD.");
    	                    else
    	                    	gen.println("           MOVE USR-GLS-ABRV IN USR TO FRM-GLS-"+ fd.name.substring(8) + " IN " + entityName + "-FLD.");
                            gen.println("           ELSE");
    	                    gen.println("               MOVE SPACES TO FRM-GLS-" + fd.name.substring(8) + " IN " + entityName + "-FLD");

                        }
                	}
                	if (domain.getValidation().equals("VALTDU")) {
                        gen.println("      *VAL-TDU Valida Tipo de Usuario");
                        gen.println("           MOVE '" + domain.getTable() +  "'        TO USR-COD-TTAB IN USR.");
                        gen.println("           MOVE " + fd.name + " IN " + entityName + "-FLD" + (size != -1 ? "(FRM-IFLD)" : "") + " TO USR-COD-USER IN USR.");
                        gen.println("           PERFORM VAL-TDU.");
                        gen.println("           IF MSG-COD-MENS > SPACES");
                        gen.println("               MOVE MSG-GLS-DESC TO FRM-MENS");
                        gen.println("               MOVE FRM-SUAR-MAL TO FRM-SUAR.");
                        if(gls.containsKey(fd.name.substring(8,12))) {
    	                    int glsSize = gls.get(fd.name.substring(8,12));
                            gen.println("           IF MSG-COD-MENS NOT = 'COD    NEX' AND");
    	                    gen.println("             " + fd.name + " IN " + entityName + "-FLD > SPACES");
    	                    if (glsSize == 0 || glsSize > 12)
    	                    	gen.println("           MOVE USR-GLS-DESC IN USR TO FRM-GLS-"+ fd.name.substring(8) + " IN " + entityName + "-FLD");
    	                    else if (glsSize > 5)
    	                    	gen.println("           MOVE USR-GLS-DCOR IN USR TO FRM-GLS-"+ fd.name.substring(8) + " IN " + entityName + "-FLD");
    	                    else
    	                    	gen.println("           MOVE USR-GLS-ABRV IN USR TO FRM-GLS-"+ fd.name.substring(8) + " IN " + entityName + "-FLD");
                            gen.println("           ELSE");
    	                    gen.println("               MOVE SPACES TO FRM-GLS-" + fd.name.substring(8) + " IN " + entityName + "-FLD.");
                        }
                        
                	}
                	
                
                }
                
            }

        	
        }
        //ogb-fin
        
        
        //


    }

    /******************************************************************************
     * validation_response_required
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param entityName TODO_javadoc.
     * @param fd TODO_javadoc.
     * @param size TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void validation_response_required(String entityName, FieldDef fd, int size) {

        switch (fd.type) {

        case FieldDef.INTEGER :
        case FieldDef.LONG :
        case FieldDef.DOUBLE :
        case FieldDef.DATE :

            if (FieldDef.hasAttribute(fd.attributes, FieldDef.RESPONSE_REQUIRED_ATTR)) {

                gen.println("           IF " + fd.name + " IN " + entityName + "-FLD" + (size != -1 ? "(FRM-IFLD)" : "") + " = ZEROES");
                gen.println("                PERFORM ERR-GLS");
                gen.println("                GO TO FIN-VAL-" + fd.name + ".");
            }
            else {

                gen.println("           IF " + fd.name + " IN " + entityName + "-FLD" + (size != -1 ? "(FRM-IFLD)" : "") + " NOT > ZEROES");
                gen.println("              MOVE ZEROES TO " + fd.name + " IN " + entityName + "-FLD" + (size != -1 ? "(FRM-IFLD)" : "") + ".");
            }

            break;

        case FieldDef.CHAR :
        case FieldDef.BOOLEAN :
        case FieldDef.STRING :

            if (FieldDef.hasAttribute(fd.attributes, FieldDef.RESPONSE_REQUIRED_ATTR)) {

                gen.println("           IF " + fd.name + " IN " + entityName + "-FLD" + (size != -1 ? "(FRM-IFLD)" : "") + " NOT > SPACES"); // 1902_06 02 07 diff liq.docx (mail 03-09-2019 18:49)
                gen.println("                PERFORM ERR-GLS");
                gen.println("                GO TO FIN-VAL-" + fd.name + ".");
            }
            else {

                gen.println("           IF " + fd.name + " IN " + entityName + "-FLD" + (size != -1 ? "(FRM-IFLD)" : "") + " NOT > SPACES");
                gen.println("              MOVE SPACES TO " + fd.name + " IN " + entityName + "-FLD" + (size != -1 ? "(FRM-IFLD)" : "") + ".");
            }

            break;
        }
    }

    /******************************************************************************
     * genVAL_MKY_entity
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param entityName TODO_javadoc.
     * @param fields TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void genVAL_MKY_entity(String entityName, ArrayList<Object> fields) {

        iniSection("VAL-MKY-" + entityName);

        for (int i = 0; i < fields.size(); i++) {

            if (fields.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) fields.get(i);

                if (fd.modifier == FieldDef.MKY && action == BQ_ACTION) {
                    perform_and_validation(entityName, fd, "VAL-MKY", true, -1);
                }
            }
            else {
                //////////////
            }
        }

        finSection("VAL-MKY-" + entityName);
    }

    /******************************************************************************
     * genVAL_CON_KEY_entity
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param entityName TODO_javadoc.
     * @param fields TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void genVAL_CON_KEY_entity(String entityName, ArrayList<Object> fields) {

        iniSection("VAL-CON-KEY-" + entityName);

        boolean first = true;

        for (int i = 0; i < fields.size(); i++) {

            if (fields.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) fields.get(i);

                first = gen_cond_val_key(entityName, fd, first, KEY_TYPES);
            }
            else {
                //////////////
            }
        }

        gen.println("                PERFORM ERR-KEY");
        gen.println("                PERFORM FST-KEY-" + entityName + ".");

        finSection("VAL-CON-KEY-" + entityName);
    }

    /******************************************************************************
     * gen_cond_val_key
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param entityName TODO_javadoc.
     * @param fd TODO_javadoc.
     * @param first TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static boolean gen_cond_val_key(String entityName, FieldDef fd, boolean first, int[] keys) {

        if (fd.replaced != null) {

            for (FieldDef fr : fd.replaced) {
                first = gen_cond_val_key(entityName, fr, first, keys);
            }
        }
        else {

            if (Utils.searchIntInArray(fd.modifier, keys) >= 0) {

                if (first) {

                    gen.print  ("           IF    ");

                    first = false;
                }
                else {
                    gen.print  ("              AND");
                }

                //

                switch (fd.type) {

                case FieldDef.INTEGER :
                case FieldDef.LONG :
                case FieldDef.DOUBLE :
                case FieldDef.DATE :

                    gen.println(" " + fd.name + " IN " + entityName + "-FLD NOT > ZEROES");

                    break;

                case FieldDef.CHAR :
                case FieldDef.BOOLEAN :
                case FieldDef.STRING :

                    if (fd.special == FieldDef.GLS_IDC) {
                        gen.println(" " + fd.name + " IN " + entityName + "-FLD NOT > IDC-INIC-GLS");
                    }
                    else {
                        gen.println(" " + fd.name + " IN " + entityName + "-FLD NOT > SPACES");
                    }

                    break;
                }
            }
        }

        return first;
    }

    /******************************************************************************
     * genVAL_CON_IKY_entity
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param entityName TODO_javadoc.
     * @param fields TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void genVAL_CON_IKY_entity(String entityName, ArrayList<Object> fields) {

        iniSection("VAL-CON-IKY-" + entityName);

        boolean first = true;

        for (int i = 0; i < fields.size(); i++) {

            if (fields.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) fields.get(i);

                first = gen_cond_val_key(entityName, fd, first, new int[] { FieldDef.IKY });
            }
            else {
                //////////////
            }
        }

        gen.println("                PERFORM ERR-KEY");
        gen.println("                PERFORM FST-KEY-" + entityName + ".");

        finSection("VAL-CON-IKY-" + entityName);
    }

    /******************************************************************************
     * genVAL_NUM_KEY_entity
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param entityName TODO_javadoc.
     * @param fields TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void genVAL_NUM_KEY_entity(String entityName, ArrayList<Object> fields) {

        iniSection("VAL-NUM-KEY-" + entityName);

        gen.println("           PERFORM VAL-NUM-IKY-" + entityName + ".");
        gen.println("           PERFORM VAL-NUM-MKY-" + entityName + ".");
        gen.println("           PERFORM VAL-NUM-AKY-" + entityName + ".");

        finSection("VAL-NUM-KEY-" + entityName);

        //

        iniSection("VAL-NUM-IKY-" + entityName);

        for (int i = 0; i < fields.size(); i++) {

            if (fields.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) fields.get(i);

                if (fd.modifier == FieldDef.IKY) {

                    switch (fd.type) {

                    case FieldDef.INTEGER :
                    case FieldDef.LONG :
                    case FieldDef.DOUBLE :
                  //case FieldDef.DATE : // TODO_ALA: revisar

                        gen_num_validation(entityName, fd, "VAL-NUM-IKY", -1);

                        break;
                    }
                    
                    if (fd.replaced != null && fd.special == FieldDef.VRF) {
                        for (FieldDef fr : fd.replaced) {
                        	
                            switch (fr.type) {

                            case FieldDef.INTEGER :
                            case FieldDef.LONG :
                            case FieldDef.DOUBLE :

                                gen_num_validation(entityName, fr, "VAL-NUM-IKY", -1);

                                break;
                            }
                        }
                    }
                }
            }
            else {
                //////////////
            }
        }

        finSection("VAL-NUM-IKY-" + entityName);

        //

        iniSection("VAL-NUM-MKY-" + entityName);

        for (int i = 0; i < fields.size(); i++) {

            if (fields.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) fields.get(i);

                if (fd.modifier == FieldDef.MKY) {

                    switch (fd.type) {

                    case FieldDef.INTEGER :
                    case FieldDef.LONG :
                    case FieldDef.DOUBLE :
                  //case FieldDef.DATE : // TODO_ALA: revisar

                        gen_num_validation(entityName, fd, "VAL-NUM-MKY", -1);

                        break;
                    }
                    
                    if (fd.replaced != null && fd.special == FieldDef.VRF) {
                        for (FieldDef fr : fd.replaced) {
                        	
                            switch (fr.type) {

                            case FieldDef.INTEGER :
                            case FieldDef.LONG :
                            case FieldDef.DOUBLE :

                                gen_num_validation(entityName, fr, "VAL-NUM-MKY", -1);

                                break;
                            }
                        }
                    }
                    
                }
                
            }
            else {
                //////////////
            }
        }
        
        finSection("VAL-NUM-MKY-" + entityName);

        //

        iniSection("VAL-NUM-AKY-" + entityName);

        for (int i = 0; i < fields.size(); i++) {

            if (fields.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) fields.get(i);

                if (fd.modifier == FieldDef.AKY) {

                    switch (fd.type) {

                    case FieldDef.INTEGER :
                    case FieldDef.LONG :
                    case FieldDef.DOUBLE :
                  //case FieldDef.DATE : // TODO_ALA: revisar

                        gen_num_validation(entityName, fd, "VAL-NUM-AKY", -1);

                        break;
                    }
                    
                    if (fd.replaced != null && fd.special == FieldDef.VRF) {
                        for (FieldDef fr : fd.replaced) {
                        	
                            switch (fr.type) {

                            case FieldDef.INTEGER :
                            case FieldDef.LONG :
                            case FieldDef.DOUBLE :

                                gen_num_validation(entityName, fr, "VAL-NUM-AKY", -1);

                                break;
                            }
                        }
                    }
                }
            }
            else {
                //////////////
            }
        }

        finSection("VAL-NUM-AKY-" + entityName);

    }

    /******************************************************************************
     * gen_num_validation
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param entityName TODO_javadoc.
     * @param fd TODO_javadoc.
     * @param sectionName TODO_javadoc.
     * @param idx TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void gen_num_validation(String entityName, FieldDef fd, String sectionName, int idx) {

        gen.println("       VAL-NUM-" + fd.name + (idx != -1 ? "-" + idx : "") + ".");
        gen.println("           MOVE " + fd.name + "-ALF IN " + entityName + "-FLD" + (idx != -1 ? "(" + idx + ")" : "") + " TO NUM-NUME.");
        gen.println("           MOVE NUM-ZERO-S TO NUM-ZERO."); // TODO_ALA: revisar
        gen.println("           MOVE NUM-SGNO-" + (fd.sign ? "S" : "N") + " TO NUM-SGNO.");
        gen.println("           MOVE " + (fd.sign ? fd.integers - 1 : fd.integers) + " TO NUM-NENT.");
        gen.println("           MOVE " + fd.decimals +                               " TO NUM-NDCM.");
        gen.println("           PERFORM VAL-NUM.");
        gen.println("           IF NUM-STAT-OKS");
        gen.println("                MOVE NUM-N" + (fd.sign ? "S" : "N") + "9" + (fd.decimals == 0 ? "N" : "V") + " TO " + fd.name + " IN " + entityName + "-FLD" + (idx != -1 ? "(" + idx + ")" : ""));
        gen.println("           ELSE");
        gen.println("                MOVE NUM-MENS     TO FRM-MENS");
        gen.println("                MOVE FRM-SUAR-MAL TO FRM-SUAR");
        gen.println("                MOVE -9 TO " + fd.name + "-LEN IN " + entityName + "-FLD" + (idx != -1 ? "(" + idx + ")" : ""));
        gen.println("                GO TO FIN-" + sectionName + "-" + entityName + ".");
    }

    /******************************************************************************
     * genVAL_NUM_FLD_entity
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param entityName TODO_javadoc.
     * @param fields TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void genVAL_NUM_FLD_entity(String entityName, ArrayList<Object> fields) {

        iniSection("VAL-NUM-FLD-" + entityName);

        ArrayList<ElementDef> array = null;

        for (int i = 0; i < fields.size(); i++) {

            if (fields.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) fields.get(i);

                val_numerica(entityName, fd, -1);
            }
            else if (fields.get(i) instanceof ArrayList) {

                array = (ArrayList<ElementDef>) fields.get(i);

                for (int j = 0; j < array.size(); j++) {

                    if (array.get(j).field.name.substring(0, 3).equals(FieldDef.FRM)) {

                        if (array.get(j).field.special != FieldDef.FEC) {

                            for (int k = 0; k < array.get(j).index.size(); k++) {
                                val_numerica(entityName, array.get(j).field, k + 1);
                            }
                        }
                    }
                }
            }
        }

        finSection("VAL-NUM-FLD-" + entityName);
    }

    /******************************************************************************
     * val_numerica
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param entityName TODO_javadoc.
     * @param fd TODO_javadoc.
     * @param idx TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void val_numerica(String entityName, FieldDef fd, int idx) {

        if (fd.replaced != null && fd.type != FieldDef.DATE) {

            for (FieldDef fr : fd.replaced) {
                val_numerica(entityName, fr, idx);
            }
        }
        else {

            if (Utils.searchIntInArray(fd.modifier, KEY_TYPES) < 0) {

                switch (fd.type) {

                case FieldDef.INTEGER :
                case FieldDef.LONG :
                case FieldDef.DOUBLE :
              //case FieldDef.DATE : // TODO_ALA: revisar

                    gen_num_validation(entityName, fd, "VAL-NUM-FLD", idx);

                    break;
                }
            }
        }
    }

    /******************************************************************************
     * genEDT_KEY_entity
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param entityName TODO_javadoc.
     * @param fields TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void genEDT_KEY_entity(String entityName, ArrayList<Object> fields) {

        iniSection("EDT-KEY-" + entityName);

        gen.println("           PERFORM EDT-IKY-" + entityName + ".");
        gen.println("           PERFORM EDT-MKY-" + entityName + ".");
        gen.println("           PERFORM EDT-AKY-" + entityName + ".");

        finSection("EDT-KEY-" + entityName);

        //

        iniSection("EDT-IKY-" + entityName);

        String ident = "EDT_IKY_" + entityName;

        printGen(ident, "PGM_" + action_names[action]);
        
        
        for (int i = 0; i < fields.size(); i++) {

            if (fields.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) fields.get(i);

                if (fd.modifier == FieldDef.IKY) {

                    switch (fd.type) {

                    case FieldDef.INTEGER :
                    case FieldDef.LONG :
                    case FieldDef.DOUBLE :
                  //case FieldDef.DATE : // TODO_ALA: revisar

                        prepare_num_edition(entityName, fd, "EDT-IKY", -1);

                        break;
                    }
                    
                    if (fd.replaced != null && fd.special == FieldDef.VRF) {
                        for (FieldDef fr : fd.replaced) {
                        	
                            switch (fr.type) {

                            case FieldDef.INTEGER :
                            case FieldDef.LONG :
                            case FieldDef.DOUBLE :

                            	prepare_num_edition(entityName, fr, "EDT-IKY", -1);

                                break;
                            }
                        }
                    }
                }
            }
            else {
                //////////////
            }
        }

        finSection("EDT-IKY-" + entityName);

        //

        iniSection("EDT-MKY-" + entityName);

        for (int i = 0; i < fields.size(); i++) {

            if (fields.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) fields.get(i);

                if (fd.modifier == FieldDef.MKY) {

                    switch (fd.type) {

                    case FieldDef.INTEGER :
                    case FieldDef.LONG :
                    case FieldDef.DOUBLE :
                  //case FieldDef.DATE : // TODO_ALA: revisar

                        prepare_num_edition(entityName, fd, "EDT-MKY", -1);

                        break;
                    }
                    
                    if (fd.replaced != null && fd.special == FieldDef.VRF) {
                        for (FieldDef fr : fd.replaced) {
                        	
                            switch (fr.type) {

                            case FieldDef.INTEGER :
                            case FieldDef.LONG :
                            case FieldDef.DOUBLE :

                            	prepare_num_edition(entityName, fr, "EDT-MKY", -1);

                                break;
                            }
                        }
                    }
                    
                    
                }
            }
            else {
                //////////////
            }
        }

        finSection("EDT-MKY-" + entityName);

        //

        iniSection("EDT-AKY-" + entityName);

        for (int i = 0; i < fields.size(); i++) {

            if (fields.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) fields.get(i);

                if (fd.modifier == FieldDef.AKY) {

                    switch (fd.type) {

                    case FieldDef.INTEGER :
                    case FieldDef.LONG :
                    case FieldDef.DOUBLE :
                  //case FieldDef.DATE : // TODO_ALA: revisar

                        prepare_num_edition(entityName, fd, "EDT-AKY", -1);

                        break;
                    }
                    
                    if (fd.replaced != null && fd.special == FieldDef.VRF) {
                        for (FieldDef fr : fd.replaced) {
                        	
                            switch (fr.type) {

                            case FieldDef.INTEGER :
                            case FieldDef.LONG :
                            case FieldDef.DOUBLE :

                            	prepare_num_edition(entityName, fr, "EDT-AKY", -1);

                                break;
                            }
                        }
                    }
                }
            }
            else {
                //////////////
            }
        }

        finSection("EDT-AKY-" + entityName);

    }

    /******************************************************************************
     * prepare_num_edition
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param entityName TODO_javadoc.
     * @param fd TODO_javadoc.
     * @param sectionName TODO_javadoc.
     * @param idx TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void prepare_num_edition(String entityName, FieldDef fd, String sectionName, int idx) {

        gen.println("           IF " + fd.name + "-LEN IN " + entityName + "-FLD" + (idx != -1 ? "(" + idx + ")" : "") + " = FRM-ERR-NUME");
        gen.println("                MOVE FRM-IND-ERRO TO " + fd.name + "-LEN IN " + entityName + "-FLD" + (idx != -1 ? "(" + idx + ")" : ""));
        gen.println("                GO TO FIN-" + sectionName + "-" + entityName + ".");

      //gen.println("           MOVE " + fd.name + " IN " + entityName + "-FLD" + (idx != -1 ? "(" + idx + ")" : "") + " TO " + fd.name + "-EDT IN " + entityName + "-EDT.");
        gen.println("           MOVE " + fd.name + " IN " + entityName + "-FLD" + (idx != -1 ? "(" + idx + ")" : "") + " TO");
        gen.println("                " + fd.name + "-EDT IN " + entityName + "-EDT.");

        gen.println("           MOVE " + fd.name + "-EDT IN " + entityName + "-EDT TO");
        gen.println("                " + fd.name + "-ALF IN " + entityName + "-FLD" + (idx != -1 ? "(" + idx + ")" : "") + ".");
    }

    /******************************************************************************
     * genEDT_FLD_entity
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param entityName TODO_javadoc.
     * @param fields TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void genEDT_FLD_entity(String entityName, ArrayList<Object> fields) {

        iniSection("EDT-FLD-" + entityName);

        ArrayList<ElementDef> array = null;

        for (int i = 0; i < fields.size(); i++) {

            if (fields.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) fields.get(i);

                field_prepare_num_edition(entityName, fd, -1);
            }
            else if (fields.get(i) instanceof ArrayList) {

                array = (ArrayList<ElementDef>) fields.get(i);

                for (int j = 0; j < array.size(); j++) {

                    if (array.get(j).field.special != FieldDef.FEC) {

                        for (int k = 0; k < array.get(j).index.size(); k++) {
                            field_prepare_num_edition(entityName, array.get(j).field, k + 1);
                        }
                    }
                }
            }
        }

        finSection("EDT-FLD-" + entityName);
    }

    /******************************************************************************
     * field_prepare_num_edition
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param entityName TODO_javadoc.
     * @param fd TODO_javadoc.
     * @param idx TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void field_prepare_num_edition(String entityName, FieldDef fd, int idx) {

      //logger.debug("entrando a 'field_prepare_num_edition(" + fd.name + "," + FieldDef.getTypeString(fd.type) + "," + FieldDef.getSpecialString(fd.special) + "," + idx + ")' ...");

        if (fd.replaced != null && fd.type != FieldDef.DATE) {

            for (FieldDef fr : fd.replaced) {
                field_prepare_num_edition(entityName, fr, idx);
            }
        }
        else {

            if (Utils.searchIntInArray(fd.modifier, KEY_TYPES) < 0) {

                switch (fd.type) {

                case FieldDef.INTEGER :
                case FieldDef.LONG :
                case FieldDef.DOUBLE :
              //case FieldDef.DATE : // TODO_ALA: revisar

                    prepare_num_edition(entityName, fd, "EDT-FLD", idx);

                    break;
                }
            }
        }
    }

    /******************************************************************************
     * genRET_ALL_entity
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param entityName TODO_javadoc.
     * @param subsystems TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void genRET_ALL_entity(String entityName, ArrayList<String> subsystems) {

        iniSection("RET-ALL-" + entityName);

        gen.println("           PERFORM KEY-ALL-" + entityName + ".");

        for (String subsys : subsystems) {

            if (!subsys.equals(FieldDef.FRM)) {
                gen.println("           PERFORM RET-" + subsys + "-" + entityName + ".");
            }
        }

        finSection("RET-ALL-" + entityName);
    }

    /******************************************************************************
     * genRET_subsys_entity
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param subsys TODO_javadoc.
     * @param entityName TODO_javadoc.
     * @param fields TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void genRET_subsys_entity(String subsys, String entityName, ArrayList<Object> fields) {

        iniSection("RET-" + subsys + "-" + entityName);

        ArrayList<Object>     vars  = getSubsysVarsFromFields(subsys, fields);
        ArrayList<ElementDef> array = null;

        for (int i = 0; i < vars.size(); i++) {

            if (vars.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) vars.get(i);

                if (Utils.searchIntInArray(fd.modifier, KEY_TYPES) < 0) {
                    get_ret_field(subsys, entityName, fd, -1);
                }
            }
            else if (vars.get(i) instanceof ArrayList) {

                array = (ArrayList<ElementDef>) vars.get(i);

                for (int j = 0; j < array.size(); j++) {

                    gen.println("      *");
                    gen.println("      *    CAMPO INDEXADO   " + array.get(j).field.name);

                    for (int k = 0; k < array.get(j).index.size(); k++) {

                        if (Utils.searchIntInArray(array.get(j).field.modifier, KEY_TYPES) < 0) {
                            get_ret_field(subsys, entityName, array.get(j).field, k + 1);
                        }
                    }
                }
            }
        }

        finSection("RET-" + subsys + "-" + entityName);
    }

    /******************************************************************************
     * genVAL_FLD_entity
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param entityName TODO_javadoc.
     * @param fields TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void genVAL_FLD_entity(String entityName, ArrayList<Object> fields, HashMap<String, Integer> gls) {

        iniSection("VAL-FLD-" + entityName);

        ArrayList<ElementDef> array = null;

        for (int i = 0; i < fields.size(); i++) {

            if (fields.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) fields.get(i);

                if ((Utils.searchIntInArray(fd.modifier, KEY_TYPES) < 0) || fd.modifier == FieldDef.MKY) {
                    perform_and_validation(entityName, fd, "VAL-FLD", false, -1); ///// verificar
                }
            }
            else if (fields.get(i) instanceof ArrayList) {

                array = (ArrayList<ElementDef>) fields.get(i);

                for (int j = 0; j < array.size(); j++) {

                    if (Utils.searchIntInArray(array.get(j).field.modifier, KEY_TYPES) < 0) {
                        perform_and_validation(entityName, array.get(j).field, "VAL-FLD", false, array.get(j).index.size());
                    }
                }
            }
        }

        finSection("VAL-FLD-" + entityName);

        //

        for (int i = 0; i < fields.size(); i++) {

            if (fields.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) fields.get(i);

                if ((Utils.searchIntInArray(fd.modifier, KEY_TYPES) < 0) || fd.modifier == FieldDef.MKY) {
                    genVAL_field(entityName, fd, -1, gls);
                }
            }
            else if (fields.get(i) instanceof ArrayList) {

                array = (ArrayList<ElementDef>) fields.get(i);

                for (int j = 0; j < array.size(); j++) {

                    if (Utils.searchIntInArray(array.get(j).field.modifier, KEY_TYPES) < 0) {
                        genVAL_field(entityName, array.get(j).field, array.get(j).index.size(), gls);
                    }
                }
            }
        }
    }

    /******************************************************************************
     * iniSection
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param sectionName TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void iniSection(String sectionName) {
        iniSection(sectionName, null);
    }

    /******************************************************************************
     * iniSection
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param sectionName TODO_javadoc.
     * @param additName TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void iniSection(String sectionName, String additName) {

        gen.println("       " + sectionName + " SECTION.");
        gen.println("       INI-" + sectionName + ".");

        String ident = additName != null ? additName : "INI_" + sectionName.replace('-', '_');

      //logger.debug("seccion '" + sectionName + "', ident '" + ident + "' (" + (addit_hash.containsKey(ident) ? "OK" : "NO") + ")");
        
        printGen(ident, "PGM_" + action_names[action]);
        
    }

    /******************************************************************************
     * finSection
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param sectionName TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void finSection(String sectionName) {
        finSection(sectionName, null);
    }

    /******************************************************************************
     * finSection
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param sectionName TODO_javadoc.
     * @param additName TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void finSection(String sectionName, String additName) {

        String ident = additName != null ? additName : "FIN_" + sectionName.replace('-', '_');

        printGen(ident, "PGM_" + action_names[action]);

        gen.println("       FIN-" + sectionName + ".");
        gen.println("           EXIT.");
        gen.println();
    }

    /******************************************************************************
     * getAdditFromXML
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param filename TODO_javadoc.
     *
     * @throws Exception TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void getAdditFromXML(String filename) throws Exception {

        ArrayList  errors = new ArrayList();
        XmlOptions opts   = new XmlOptions();
        
        SectionDef additSection; 

        opts.setErrorListener(errors);

        AdditionalDocument root = AdditionalDocument.Factory.parse(new File(filename), opts);

        if (root.validate(opts)) {

            AdditionalDocument.Additional addit = root.getAdditional();

            for (SectionDocument.Section section : addit.getSectionArray()) {
            	
            	additSection = new SectionDef(section.getName(), section.getCode(), environment_hash);
            	if (section.isSetConcatenate())
            		additSection.setConcatenate((int)section.getConcatenate());
            	
        		String name = additSection.getName();
        		ArrayList<String> subNames;
        		
        		//si es OR se separa en 2 items diferentes
        		if (name != null) {
            		if (name.contains(" OR ")) {
            			
            			subNames = new  ArrayList<String>(Arrays.asList(name.split(" OR ")));
            			
                		for (String itmName : subNames)
                		{
                			putSection(itmName, additSection);
                		}
            			
            		}
            		else
            			putSection(name, additSection);

        		}

            }

        } else {

            for (Object error : errors) {
                logger.fatal(error);
            }

            throw new XmlException(filename + " es invalido.");
        }
    }
    
    
    private static void putSection(String name, SectionDef additSection ) {
    	
    	
    	if(addit_hash.containsKey(name))
    	{
			if(name.contains("$"))  {
	
				int pos =  Integer. parseInt(name.substring(name.indexOf("$") + 1));
				while(addit_hash.containsKey(name))
				{
					name = name.substring(0, name.indexOf("$"));
					pos++;
					name = name + "$" + pos;
				}
	        	addit_hash.put(name, additSection);
			}
			else {
				int cnt1 = 0;
				while(addit_hash.containsKey(name))
				{
					cnt1++;
					name = (name.contains("$")) ? name.substring(0, name.indexOf("$")) : name;
					name = name + "$" + cnt1;
				}
				if (cnt1 > 0)
	            	addit_hash.put(name, additSection);
				else
					addit_hash.put(name + "$" + 1, additSection);
			}
		
    	}
    	else
    		addit_hash.put(name, additSection);
    	
    }

    /******************************************************************************
     * getRangesFromXML
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param filename TODO_javadoc.
     *
     * @throws Exception TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void getRangesFromXML(String filename) throws Exception {

        ArrayList  errors = new ArrayList();
        XmlOptions opts   = new XmlOptions();

        opts.setErrorListener(errors);

        RangesDocument root = RangesDocument.Factory.parse(new File(filename), opts);

        if (root.validate(opts)) {

            RangesDocument.Ranges ranges = root.getRanges();

            for (FieldDocument.Field field : ranges.getFieldArray()) {
                                                     // name,            domain,            system,            registry,            table, validation,            search
                DomainRangeDef drd = new DomainRangeDef(field.getName(), field.getDomain(), field.getSystem(), field.getRegistry(), "",    field.getValidation(), field.getSearch());

              //logger.debug(drd);

                ranges_hash.put(field.getName(), drd);
            }

        } else {

            for (Object error : errors) {
                logger.fatal(error);
            }

            throw new XmlException(filename + " es invalido.");
        }
    }

    /******************************************************************************
     * getDomainsFromXML
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param filename TODO_javadoc.
     *
     * @throws Exception TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void getDomainsFromXML(String filename) throws Exception {

        ArrayList  errors = new ArrayList();
        XmlOptions opts   = new XmlOptions();

        opts.setErrorListener(errors);

        DomainsDocument root = DomainsDocument.Factory.parse(new File(filename), opts);

        if (root.validate(opts)) {

            DomainsDocument.Domains domains = root.getDomains();

            for (DomainDocument.Domain domain : domains.getDomainArray()) {
                                                     // name,             domain, system,             registry,             table,             validation,             search
                DomainRangeDef drd = new DomainRangeDef(domain.getName(), "",     domain.getSystem(), domain.getRegistry(), domain.getTable(), domain.getValidation(), domain.getSearch());

              //logger.debug(drd);

                domains_hash.put(domain.getName(), drd);
            }

        } else {

            for (Object error : errors) {
                logger.fatal(error);
            }

            throw new XmlException(filename + " es invalido.");
        }
    }

    /******************************************************************************
     * getSubsystemsFromFields
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param fields TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static ArrayList<String> getSubsystemsFromFields(ArrayList<Object> fields) {

        ArrayList<String> subsystems = new ArrayList<String>();

        String subsys = null;

        for (int i = 0; i < fields.size(); i++) {

            if (fields.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) fields.get(i);

                subsys = fd.fmsname.substring(0, 3);

                if (!subsystems.contains(subsys)) { // !subsys.equals(FieldDef.FRM) &&
                    subsystems.add(subsys);
                }
            }
            else {
                //////////////
            }
        }

        return subsystems;
    }

    /******************************************************************************
     * getSubsysVarsFromFields
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param subsys TODO_javadoc.
     * @param fields TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static ArrayList<Object> getSubsysVarsFromFields(String subsys, ArrayList<Object> fields) {

        ArrayList<Object>     vars  = new ArrayList<Object>();
        ArrayList<ElementDef> array = null;

        for (int i = 0; i < fields.size(); i++) {

            if (fields.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) fields.get(i);

                if (fd.fmsname.substring(0, 3).equals(subsys)) {
                    vars.add(fd);
                }
            }
            else if (fields.get(i) instanceof ArrayList) {

                array = (ArrayList<ElementDef>) fields.get(i);

                ArrayList<ElementDef> valid = new ArrayList<ElementDef>();

                for (int j = 0; j < array.size(); j++) {

                    if (array.get(j).field.name.substring(0, 3).equals(subsys)) {
                        valid.add(array.get(j));
                    }
                }

                vars.add(valid);
            }
        }

        return vars;
    }
    
    /******************************************************************************
     * getGlsFromFields
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param fields TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static HashMap<String, Integer> getGlsFromFields(ArrayList<Object> fields) {

    	HashMap<String, Integer> gls = new HashMap<String, Integer>();

        String glosa = null;

        for (int i = 0; i < fields.size(); i++) {

            if (fields.get(i) instanceof FieldDef) {

                FieldDef fd = (FieldDef) fields.get(i);

                glosa = fd.name.substring(0, 7);

                if (!gls.containsKey(fd.name) && glosa.equals("FRM-GLS")) { // !subsys.equals(FieldDef.FRM) &&
                	
                	String subname = (fd.name.length() < 12) ? fd.name.substring(8,fd.name.length()):fd.name.substring(8, 12);
                	
                	gls.put((subname),fd.size);
                }
            }
        }

        return gls;
    }
    
    private static void printGen(String ident, String labelSpecial) {
    	
	    int z = 0;
	    int numCon = 0;
	    String bkpIdent = null;
	    
	    while(addit_hash.containsKey(ident)) {
	    	
	    	SectionDef sectionCode = (SectionDef)addit_hash.get(ident);
	    	
	    	if(sectionCode.getConcatenate() > 0)
	    	{
	    		numCon = 1;
	    		bkpIdent = ident;
	    		
	    	    while(addit_hash.containsKey(ident)) {

	    	    	sectionCode = (SectionDef)addit_hash.get(ident);
	    	    	if (sectionCode.getConcatenate() == numCon) {
		    	    	numCon++;
		    	    	
			    		if (sectionCode.numSpecial() > 0) {
			    			if (sectionCode.hasSpecial(labelSpecial))
					    		gen.println(((SectionDef)addit_hash.get(ident)).getCode());

			    			String negLabel = null;
			    			//negacion de PGM_
			    			if (action == BQ_ACTION)
			    				negLabel = "NOT PGM_BU";
			    			else if (action == BU_ACTION)
			    				negLabel = "NOT PGM_BQ";
			    			
			    			if (sectionCode.hasSpecial(negLabel))
			    				gen.println(((SectionDef)addit_hash.get(ident)).getCode());
			    			
			    			//se revisan variables de ambiente
			    			for ( String pgmStrg: sectionCode.getSpecial()) {
			    				
			    				Boolean cumple = true;
			    				if (environment_hash.containsKey(pgmStrg)) {
			    					
			    					if (sectionCode.numSpecial() > 1) {
			    						//si es mayor a uno se revisan las demas specials para buscar si hay uno con AND,
			    						//en ese caso ese specials tambien debe estar en environment_hash
			    						int x = 0;
			    						for (String ot_special : sectionCode.getSpecial()) {
			    							
		    								String op_special = sectionCode.getOperatorSpecials(x);
		    								if (op_special.equals("OR")) { 
		    									cumple = true;
		    								}
		    								
			    							if (!ot_special.equals(pgmStrg)) {

			    								if (op_special.equals("AND")) { 
								    				if (!environment_hash.get(ot_special)) {
								    					cumple = false;
								    				}
			    								}
								    					
			    							}
			    							
			    							x++;
			    							
			    						}
			    						
					    				if (environment_hash.get(pgmStrg) && cumple)
								    		gen.println(((SectionDef)addit_hash.get(ident)).getCode());
			    						
			    					}
			    					else
			    					{
					    				if (environment_hash.get(pgmStrg))
								    		gen.println(((SectionDef)addit_hash.get(ident)).getCode());
			    					}
			    					
			    				}

			    			}
			    			//
			    		}
			    		else
				    		gen.println(((SectionDef)addit_hash.get(ident)).getCode());
			    		
			    		ident = bkpIdent;
			    		z = 0;
	    	    	}
	    	    	else {
	    	    		
	    	    		proNoConcatenated( sectionCode, ident, labelSpecial );
	    	    		
		    	        z++;
		    	        ident = ((ident.contains("$")) ? ident.substring(0, ident.indexOf("$")) : ident) + "$" + z;	
	    	    	}

	    	    }
	
	    	}
	    	else {
	    		
	    		proNoConcatenated( sectionCode, ident, labelSpecial );
	    		
		        z++;
		        ident = ident + "$" + z;
	    	}
	    }
	    
    }
    
    private static void proNoConcatenated(SectionDef sectionCode, String ident, String labelSpecial) {
    	
    	if(sectionCode.getConcatenate() > 0)
    		return;
    	
    	if (labelSpecial == null)
    		gen.println(sectionCode.getCode());
    	else {
    		if (sectionCode.numSpecial() > 0) {
    			if (sectionCode.hasSpecial(labelSpecial))
		    		gen.println(((SectionDef)addit_hash.get(ident)).getCode());

    			String negLabel = null;
    			//negacion de PGM_
    			if (action == BQ_ACTION)
    				negLabel = "NOT PGM_BU";
    			else if (action == BU_ACTION)
    				negLabel = "NOT PGM_BQ";
    			
    			if (sectionCode.hasSpecial(negLabel))
    				gen.println(((SectionDef)addit_hash.get(ident)).getCode());
    			
    			//se revisan variables de ambiente
    			for ( String pgmStrg: sectionCode.getSpecial()) {
    				
    				if (environment_hash.containsKey(pgmStrg))
	    				if (environment_hash.get(pgmStrg))
				    		gen.println(((SectionDef)addit_hash.get(ident)).getCode());
    				
    			}
    			//
    			
    		}
    		else
	    		gen.println(((SectionDef)addit_hash.get(ident)).getCode());
    	}
    
    }

}


