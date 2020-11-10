/*
 *   Copyright (c) 2013 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.genfrmjava;


import java.io.*;

import java.util.*;

import cl.bee.preptex.*;
import cl.bee.preptex.syntaxtree.*;
import cl.bee.preptex.util.*;
import cl.bee.preptex.visitor.*;

import org.apache.log4j.*;


/**
 *
 * TODO_javadoc.
 *
 * @version 1.0 (01/01/2013).
 *
 */
public class GenAdditXML {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(GenAdditXML.class);

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
    private static String country = null;

    /** TODO_javadoc. */
    private static String client = null;

    /** TODO_javadoc. */
    private static String systemName = null;

    /** TODO_javadoc. */
    private static String entityName = null;

    /******************************************************************************
     * main
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param args TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public static void main(String args[]) {

    	BasicConfigurator.configure();
        logger.info("Inicio GenAdditXML.java ");
    	
        for (int idx = 0; idx < args.length - 1; idx++) {

            if (args[idx].equalsIgnoreCase("-country")) {
                country = args[++idx].toUpperCase();
            }

            if (args[idx].equalsIgnoreCase("-client")) {
                client = args[++idx].toUpperCase();
            }

            if (args[idx].equalsIgnoreCase("-system")) {
                systemName = args[++idx];
            }

            if (args[idx].equalsIgnoreCase("-entity")) {
                entityName = args[++idx];
            }
        }

        logger.debug("country:    " + country);
        logger.debug("client:     " + client);
        logger.debug("systemName: " + systemName);
        logger.debug("entityName: " + entityName);

        try {

            String filename = "data/text/" + systemName + "BM" + entityName + ".TXT";

            if (!(new File(filename)).exists()) {

                logger.warn("archivo '" + filename + "' no encontrado.");

                return;
            }

            PrepTex parser  = new PrepTex(new PrepTexStream(filename, "*%", new HashMap<String, Object>()));
            Node    root    = parser.specification();

            //

            ////////////////////////////////////////////////////////////////////////
            // BQ BU
            ////////////////////////////////////////////////////////////////////////

            for (int action = 2; action < 4; action++) {

                PrintStream gen = new PrintStream(new FileOutputStream("data/addit/addit_" + systemName.toLowerCase() + "_" + entityName.toLowerCase() + "_" + action_names[action].toLowerCase() + ".xml"));

                gen.println("<?xml version = \"1.0\" encoding = \"ISO-8859-1\" ?>");
                gen.println();
                gen.println("<additional xmlns        = \"http://cl/bee/genfrmjava/adddef/schema\"");
                gen.println("      xmlns:xsi          = \"http://www.w3.org/2001/XMLSchema-instance\"");
                gen.println("      xsi:schemaLocation = \"http://cl/bee/genfrmjava/adddef/schema adddef.xsd\"");
                gen.println("      system             = \"" + systemName +"\"");
                gen.println("      form               = \"" + entityName +"\">");
                gen.println();

                TreeMap<String, String> tree         = new TreeMap<String, String>();
                HashMap<String, String> used         = new HashMap<String, String>();
                HashMap<String, Object> symbolsTable = new HashMap<String, Object>();

                for (int i = 2; i < 4; i++) {
                    symbolsTable.put("pgm_" + action_names[i].toLowerCase(), new Boolean(action == i));
                }

                root.accept(new AdditCodeVisitor(systemName + "BM" + entityName + ".TXT", symbolsTable, country, client, systemName, false/*logging*/, tree, false/*cond_mode*/));

                //

                for (Iterator<String> iter = tree.keySet().iterator(); iter.hasNext(); ) {

                    String preptex_id = iter.next();

                    if (!used.containsKey(preptex_id)) {

                        gen.println("  <!-- ========================================================================================== ==");
                        gen.println("    == " + preptex_id);
                        gen.println("    == ========================================================================================== -->");
                        gen.println();
                        gen.println("  <section name=\"" + preptex_id + "\">");
                        gen.println();
                        gen.println("    <code><![CDATA[" + tree.get(preptex_id) + "]]></code>");
                        gen.println();

                        used.put(preptex_id, "OK");

                        gen.println("  </section>");
                        gen.println();
                    }
                }

                gen.println("  <!-- ========================================================================================== ==");
                gen.println("    ==");
                gen.println("    == ========================================================================================== -->");
                gen.println();
                gen.println("</additional>");

                gen.close();
            }
        }
        catch (Exception e) {
            logger.fatal("Exception " + printStackTrace(e));
        }
    }

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
     * @since 1.0
     *
     */
    protected static String printStackTrace(Throwable e) {

        CharArrayWriter caw = new CharArrayWriter();

        e.printStackTrace(new PrintWriter(caw));

        return caw.toString();
    }
}
