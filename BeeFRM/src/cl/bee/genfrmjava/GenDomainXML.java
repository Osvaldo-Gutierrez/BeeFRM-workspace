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
public class GenDomainXML {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(GenDomainXML.class);

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

            String filename = "data/dump/" + systemName + "DMN.TXT";

            if (!(new File(filename)).exists()) {

                logger.warn("archivo '" + filename + "' no encontrado.");

                return;
            }

            //

            PrintStream gen = new PrintStream(new FileOutputStream("data/domain-range/domain_" + systemName.toLowerCase() + ".xml"));

            gen.println("<?xml version = \"1.0\" encoding = \"ISO-8859-1\" ?>");
            gen.println();
            gen.println("<domains xmlns              = \"http://cl/bee/genfrmjava/domaindef/schema\"");
            gen.println("         xmlns:xsi          = \"http://www.w3.org/2001/XMLSchema-instance\"");
            gen.println("         xsi:schemaLocation = \"http://cl/bee/genfrmjava/domaindef/schema domaindef.xsd\">");
            gen.println();

            BufferedReader    fp_in   = new BufferedReader(new FileReader(filename));
            String            line    = null;
            ArrayList<String> domains = new ArrayList<String>();

            while ((line = fp_in.readLine()) != null) {

                if (line.trim().equals("")) {
                    continue;
                }

                if (!domains.contains(line.substring(0, 32).trim())) {

                    gen.print  ("  <domain"                                   + " name=\""       + line.substring( 0, 32).trim() + "\"");
                    gen.print  (                                                " system=\""     + line.substring(32, 35)        + "\"");
                    gen.print  (line.substring(35, 38).trim().equals("") ? "" : " registry=\""   + line.substring(35, 38)        + "\"");
                    gen.print  (                                                " table=\""      + line.substring(38, 42)        + "\"");
                    gen.print  (line.substring(67, 83).trim().equals("") ? "" : " validation=\"" + line.substring(67, 83).trim() + "\"");
                    gen.print  (line.substring(83)    .trim().equals("") ? "" : " search=\""     + line.substring(83)    .trim() + "\"");
                    gen.println(" />");

                    domains.add(line.substring(0, 32).trim());
                }
            }

            gen.println("</domains>");

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
