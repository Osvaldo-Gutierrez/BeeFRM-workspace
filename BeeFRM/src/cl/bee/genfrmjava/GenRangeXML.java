/*
 *   Copyright (c) 2013 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.genfrmjava;


import java.io.*;

import java.util.*;

import org.apache.log4j.*;


/**
 *
 * TODO_javadoc.
 *
 * @version 1.0 (01/01/2013).
 *
 */
public class GenRangeXML {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(GenRangeXML.class);

    //

    /** TODO_javadoc. */
    private static String systemName = null;

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
        logger.info("Inicio GenFrm.java ");
        try {

            for (int idx = 0; idx < args.length - 1; idx++) {

                if (args[idx].equalsIgnoreCase("-system")) {
                    systemName = args[++idx];
                }
            }

            logger.debug("systemName: " + systemName);

            //

            String filename = "data/dump/" + systemName + "RCR.TXT";

            if (!(new File(filename)).exists()) {

                logger.warn("archivo '" + filename + "' no encontrado.");

                return;
            }

            //

            PrintStream gen = new PrintStream(new FileOutputStream("data/domain-range/range_" + systemName.toLowerCase() + ".xml"));

            gen.println("<?xml version = \"1.0\" encoding = \"ISO-8859-1\" ?>");
            gen.println();
            gen.println("<ranges xmlns              = \"http://cl/bee/genfrmjava/rangedef/schema\"");
            gen.println("        xmlns:xsi          = \"http://www.w3.org/2001/XMLSchema-instance\"");
            gen.println("        xsi:schemaLocation = \"http://cl/bee/genfrmjava/rangedef/schema rangedef.xsd\">");
            gen.println();

            BufferedReader    fp_in  = new BufferedReader(new FileReader(filename));
            String            line   = null;
            ArrayList<String> fields = new ArrayList<String>();

            while ((line = fp_in.readLine()) != null) {

                if (line.trim().equals("")) {
                    continue;
                }

                if (!fields.contains(line.substring(0, 32).trim())) {

                    gen.print  ("  <field"                                      + " name=\""       + line.substring(  0,  32).trim() + "\"");
                    gen.print  (                                                  " domain=\""     + line.substring( 32,  64).trim() + "\"");
                    gen.print  (line.substring( 64,  67).trim().equals("") ? "" : " system=\""     + line.substring( 64,  67)        + "\"");
                    gen.print  (line.substring( 67,  70).trim().equals("") ? "" : " registry=\""   + line.substring( 67,  70)        + "\"");
                    gen.print  (line.substring( 90, 106).trim().equals("") ? "" : " validation=\"" + line.substring( 90, 106).trim() + "\"");
                    gen.print  (line.substring(106)     .trim().equals("") ? "" : " search=\""     + line.substring(106)     .trim() + "\"");
                    gen.println(" />");

                    fields.add(line.substring(0, 32).trim());
                }
            }

            gen.println("</ranges>");

            fp_in.close();
            gen.close();
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
