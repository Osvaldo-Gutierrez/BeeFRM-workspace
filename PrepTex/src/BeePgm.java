/*
 *   Copyright (c) 2019 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.*;

import java.util.*;

import cl.bee.preptex.*;
import cl.bee.preptex.syntaxtree.*;
import cl.bee.preptex.util.*;
import cl.bee.preptex.visitor.*;

import org.apache.log4j.*;


/**
 * @author  alarrea@bee.cl
 * @version 1.0
 */
public class BeePgm {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(BeePgm.class);

    /** TODO_javadoc. */
    private static final SimpleDateFormat formdate_gen = new SimpleDateFormat("dd-MMM-yy hh:mm aa", new Locale("es", "CL"));

    /** TODO_javadoc. */
    public static final int UNDEF = -1;

    /** TODO_javadoc. */
    private static final int PQ_ACTION = 1;

    /** TODO_javadoc. */
    private static final int PU_ACTION = 2;

    /** TODO_javadoc. */
    private static final String action_names[] = { "", "PQ", "PU" };

    //

    /** TODO_javadoc. */
    private static String country = null;

    /** TODO_javadoc. */
    private static String client = null;

    /** TODO_javadoc. */
    private static String system = null;

    /** TODO_javadoc. */
    private static String entity = null;

    /** TODO_javadoc. */
    private static String command = null;

    /** TODO_javadoc. */
    private static String pq_skeleton = "skeleton/CST/DES/GNS/FTE/SRC/DOS/GNSPQFRM190415.SRCSOP_1";

    /** TODO_javadoc. */
    private static String pu_skeleton = "skeleton/CST/DES/GNS/FTE/SRC/DOS/GNSPUFRM190415.SRCSOP_1";

    //

    /** TODO_javadoc. */
    private int action = UNDEF;

    /******************************************************************************
     * main
     ******************************************************************************/
    /**
     *
     * @param args TODO_javadoc
     *
     */
    public static void main(String args[]) {

        try {
        	BasicConfigurator.configure();

        	System.out.println("Working Directory = " + System.getProperty("user.dir"));
            for (int idx = 0; idx < args.length - 1; idx++) {

                if (args[idx].equalsIgnoreCase("-country")) {
                    country = args[++idx].toUpperCase();
                }

                if (args[idx].equalsIgnoreCase("-client")) {
                    client = args[++idx].toUpperCase();
                }

                if (args[idx].equalsIgnoreCase("-system")) {
                    system = args[++idx].toUpperCase();
                }

                if (args[idx].equalsIgnoreCase("-entity")) {
                    entity = args[++idx].toUpperCase();
                }

                if (args[idx].equalsIgnoreCase("-command")) {
                    command = args[++idx].toUpperCase();
                }

                if (args[idx].equalsIgnoreCase("-pq_skeleton")) {
                    command = args[++idx];
                }
                if (args[idx].equalsIgnoreCase("-pu_skeleton")) {
                    command = args[++idx];
                }
            }

            logger.debug("country: '" + country + "', client: '" + client + "', system: '" + system + "', entity: '" + entity + "', pq_skeleton: '" + pq_skeleton + "', pu_skeleton: '" + pu_skeleton + "'");

            if (command != null) {
                logger.debug("command:    " + command);
            }

            //

            Properties rpf = new Properties();

            rpf.loadFromXML(new FileInputStream("RPF.xml"));

            //

            HashMap<String, String> argu = getPairs(command);

            ////////////////////////////////////////////////////////////////////////
            // PQ PU
            ////////////////////////////////////////////////////////////////////////

            String      control  = null;
            PrintStream gen      = null;
            String      filename = null;

            for (int action = 1; action < 3; action++) {

                logger.debug("================================================================================================");
                logger.debug("generando 'working/" + system + action_names[action] + entity + ".TEM' ...");
                logger.debug("================================================================================================");

                HashMap<String, Object> symbolsTable = new HashMap<String, Object>();

                String rpf_name = system + "PA" + entity;
                String value    = null;

                //

                symbolsTable.put("SIS", system);
                symbolsTable.put("PGM", system + action_names[action] + entity);
                symbolsTable.put("CDA", system + "PA" + entity);

                symbolsTable.put("AUT", (value = rpf.getProperty(rpf_name + "/A"))  != null ? value.substring(0, 53).trim() : "BEE");

                symbolsTable.put("SIO", (value = rpf.getProperty(rpf_name + "/B"))  != null ? value.substring(0,  3)        : system);
                symbolsTable.put("REG", (value = rpf.getProperty(rpf_name + "/B"))  != null ? value.substring(3,  6)        : system);

                symbolsTable.put("BIF", (value = rpf.getProperty(rpf_name + "/P0")) != null ? value.substring(0,  9)        : system);
                symbolsTable.put("SFR", (value = rpf.getProperty(rpf_name + "/P0")) != null ? value.substring(0,  3)        : system);
                symbolsTable.put("LFR", (value = rpf.getProperty(rpf_name + "/P0")) != null ? value.substring(0,  6)        : entity);
                symbolsTable.put("FRM", (value = rpf.getProperty(rpf_name + "/P0")) != null ? value.substring(6,  9)        : entity);
                symbolsTable.put("UAR", (value = rpf.getProperty(rpf_name + "/C"))  != null ? value.substring(53).trim()    : "GNSPPCMN");

                symbolsTable.put("FEC", formdate_gen.format(new Date()));

                for (int i = 1; i < 3; i++) {

                    symbolsTable.put("PGM_" + action_names[i], new Boolean(i == action));

                  //logger.debug("agregando PGM_" + action_names[i] + " (" + (i == action) + ") a symbolsTable.");
                }

                setDefaultsToSymbolsTable(symbolsTable);

                switch (action) {
                case PQ_ACTION:
                    symbolsTable.put("CLRMFC", system + "ZQ" + entity);
                    break;
                case PU_ACTION:
                    symbolsTable.put("CLRMFC", system + "ZU" + entity);
                    break;
                }

                //

                for (Iterator<String> iter = argu.keySet().iterator(); iter.hasNext(); ) {

                    String key = iter.next().trim();

                    value = argu.get(key).trim();

                    if (value.toUpperCase().equals("TRUE") || value.toUpperCase().equals("FALSE")) {
                        symbolsTable.put(key.toUpperCase(), new Boolean(value));
                    }
                    else {

                        try {
                            symbolsTable.put(key.toUpperCase(), new Long(value));
                        } catch (NumberFormatException ignored) {
                            symbolsTable.put(key.toUpperCase(), value);
                        }
                    }
                }

                // =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
                // .SRCSOP --> .TEM
                // =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

                control = "%";

                logger.debug("control: " + control);

                gen = new PrintStream(new FileOutputStream("working/" + system + action_names[action] + entity + ".TEM"));

                try {

                    String skeleton_filename = null;

                    switch (action) {
                    case PQ_ACTION :
                        skeleton_filename = pq_skeleton;
                        break;
                    case PU_ACTION :
                        skeleton_filename = pu_skeleton;
                        break;
                    }

                    PrepTex parser = new PrepTex(new PrepTexStream(skeleton_filename, control, symbolsTable));
                    
                    logger.debug("====================================");
                    logger.debug("Salio PrepTexStream");
                    logger.debug("====================================");
                  //parser.disable_tracing();

                    Node root = parser.specification();
 
                    PrintVisitor vis = new PrintVisitor(skeleton_filename, symbolsTable, control, country, client, system, false/*logging*/, gen);

                    root.accept(vis);
                    
                  //ogb-ini
                    final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    final String utf8 = StandardCharsets.UTF_8.name();
                    String data = baos.toString(utf8);
                  //ogb-fin
                    
                    gen.close();
 
                } catch (cl.bee.preptex.ParseException e) {

                    logger.fatal("ParseException: " + printStackTrace(e));

                } catch (Exception e) {

                    logger.fatal("Exception: " + printStackTrace(e));
                }

                gen.close();

                // =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
                // .TMP --> .PGD
                // =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

                control = "*%";
                gen     = new PrintStream(new FileOutputStream("working/" + system + action_names[action] + entity + ".PGD"));

                logger.debug("================================================================================================");
                logger.debug("generando 'working/" + system + action_names[action] + entity + ".PGD' ...");
                logger.debug("================================================================================================");

                try {

                    filename = "working/" + system + action_names[action] + entity + ".TEM";

                    PrepTex parser = new PrepTex(new PrepTexStream(filename, control, symbolsTable));

                  //parser.disable_tracing();

                    Node root = parser.specification();

                    PrintVisitor vis = new PrintVisitor(filename, symbolsTable, control, country, client, system, false/*logging*/, gen);

                    root.accept(vis);

                    gen.close();

                } catch (cl.bee.preptex.ParseException e) {

                    logger.fatal("ParseException: " + printStackTrace(e));

                } catch (Exception e) {

                    logger.fatal("Exception: " + printStackTrace(e));
                }

                gen.close();

                //

              //(new File("working/" + system + action_names[action] + entity + ".TEM")).delete();
            }
        }
        catch (Throwable e) {
            logger.error(printStackTrace(e));
        }

    }

    /*******************************************************************************************************
     * getPairs
     *******************************************************************************************************/
    /**
     *
     * @param s
     *
     * @return
     *
     */
    private static HashMap<String, String> getPairs(String s) {

        HashMap<String, String> hash = new HashMap<String, String>();
        String                  aux  = null;
        int                     ini  = 0;
        int                     pos1 = 0;
        int                     pos2 = 0;

        if (s == null) {
            return hash;
        }

        while (ini < s.length()) {

            pos1 = s.substring(ini).indexOf(',');

            if (pos1 == 0) {
                aux      = "";
                ini += 1;
            } else if (pos1 > 0) {
                aux      = s.substring(ini, ini + pos1);
                ini += (pos1 + 1);
            } else {
                aux      = s.substring(ini);
                ini += (aux.length() + 1);
            }

            if (aux.length() > 0) {
                if ((pos2 = aux.indexOf('=')) > 0) {
                    hash.put(aux.substring(0, pos2), aux.substring(pos2 + 1));
                } else if (pos2 < 0) {
                    hash.put(aux, "");
                }
            }
        }

        return hash;
    }

    /******************************************************************************
     * setDefaultsToSymbolsTable
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param symbolsTable TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public static void setDefaultsToSymbolsTable(HashMap<String, Object> symbolsTable) {

        symbolsTable.put("CPY",                  ""); // OK
        symbolsTable.put("FRS",                  ""); // OK

        symbolsTable.put("LARGO_MI_COMMAREA",    new Long(0L));
        symbolsTable.put("LARGO_TOTAL_COMMAREA", new Long(0L));
    }

    /*******************************************************************************************************
     * printStackTrace
     *******************************************************************************************************/
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
