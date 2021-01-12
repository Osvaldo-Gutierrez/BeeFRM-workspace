/*
 *   Copyright (c) 2019 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */


import java.io.*;

import java.text.*;

import java.util.*;
import java.util.regex.*;

import cl.bee.perseus.cobolparser.*;
import cl.bee.perseus.cobolparser.syntaxtree.*;
import cl.bee.perseus.cobolparser.util.*;
import cl.bee.perseus.cobolparser.visitor.*;

import cl.bee.perseus.util.*;

//import com.rits.cloning.*;

import org.apache.log4j.*;


/**
 * @author  alarrea@bee.cl
 * @version 1.0
 */
public class BEEcob2j {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(BEEcob2j.class);

    /** TODO_javadoc. */
    private static final String spaces = "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ";

    /** TODO_javadoc. */
    private static final int MAXLEN = 72;

    /** TODO_javadoc. */
    private static final int AREASIZE = 6;

    /** TODO_javadoc. */
    private static PrintStream failed_fp = null;

    //

    /** TODO_javadoc. */
    private static String sources = "FUENTES";

    //

    /** TODO_javadoc. */
    private static String working_dir = "working";

    /** TODO_javadoc. */
    private static String prgext = ".pco";

    /** TODO_javadoc. */
    private static String cpyext = ".cbl";

    //

    /** TODO_javadoc. */
    private static String package_name = null;

    /** TODO_javadoc. */
    private static String jsonparams = "{}";

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

            for (int idx = 0; idx < args.length; idx++) {

                if (args[idx].equalsIgnoreCase("-package_name")) {
                    package_name = args[++idx];
                }

                if (args[idx].equalsIgnoreCase("-jsonparams")) {
                    jsonparams = args[++idx];
                }

            }

            logger.info("package    : " + package_name);
            logger.info("jsonparams : " + jsonparams);

            //

            final long total_time_ini = System.currentTimeMillis();

            failed_fp = new PrintStream(new FileOutputStream("failed_files.txt"));

            allDirectories(new File(sources));

            logger.debug("tiempo: " + ((System.currentTimeMillis() - total_time_ini) / 1000D) + " segs.");

            failed_fp.close();

        } catch (Throwable e) {
            logger.error("Throwable: " + printStackTrace(e));
        }
    }

    /******************************************************************************
     * allDirectories
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param folder TODO_javadoc.
     *
     * @throws Exception TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static void allDirectories(File folder) throws Exception {

        if (folder == null) {
            return;
        }

        File[] list = folder.listFiles();

        if (list == null) {
            return;
        }

        for (int i = 0; i < list.length; i++) {

            if (list[i] == null) {
                continue;
            }

            if (list[i].isFile() && isExtension(list[i].getAbsolutePath(), prgext)) {

                ArrayList<String> notfoundcopies = new ArrayList<String>();
                Properties        excludecopies  = new Properties();

              /*ArrayList<CopyDesc> copyArray = */visitProgram(list[i].getName(), excludecopies, sources, sources, prgext, cpyext, working_dir, notfoundcopies);
            }
        }
    }

    /******************************************************************************
     * visitProgram
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param filename TODO_javadoc.
     * @param excludecopies TODO_javadoc.
     * @param programsDir TODO_javadoc.
     * @param copiesDir TODO_javadoc.
     * @param prgext TODO_javadoc.
     * @param cpyext TODO_javadoc.
     * @param workingDir TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @throws Exception TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static ArrayList<CopyDesc> visitProgram(String filename, Properties excludecopies, String programsDir, String copiesDir, String prgext, String cpyext, String workingDir, ArrayList<String> notfoundcopies) throws Exception {

      //logger.debug("entrando a 'visitProgram(" + programsDir + "/" + filename + ")' ...");

        File source = new File(programsDir + "/" + filename);

        try {

            if (!source.exists()) {

                source = findSource(new File(programsDir), filename);

                if (source != null) {
                    logger.warn("source '" + filename + "' no encontrado en '" + programsDir + "', usado '" + source.getAbsolutePath() + "'");
                }
            }

            if (source != null && source.exists()) {

                if (!isProgram(programsDir + "/" + filename)) {
                    return null;
                }

                ArrayList<CopyDesc> copyArray = CobolParserHelper.copiesExtension(filename, excludecopies, programsDir, copiesDir, "", cpyext, new ArrayList<LineDesc>(), workingDir, notfoundcopies, true, true); // penultimo true para logger.error("copy '...' no encontrado.");

                /*
                if (notfoundcopies.size() > 0) {

                    logger.debug("= copies faltantes ==========================================================");

                    for (String s : notfoundcopies) {
                        logger.warn(s);
                    }

                    logger.debug("=============================================================================");
                }
                */

                /******************************************************************************
                 *
                 ******************************************************************************/

              //logger.debug("antes de CobolParser() ...");

                //

                CobolParser parser = new CobolParser(new FileInputStream(workingDir + "/" + filename + ".ext"));

                parser.disable_tracing();

                Node root = parser.CompilationUnit();

                //

                HashMap<String, Object> argu = new HashMap<String, Object>();

                //

                ArrayList<DataEntryDesc> entryArray = new ArrayList<DataEntryDesc>();

                root.accept(new ModelVisitor(entryArray, filename, jsonparams), argu);

                int    pos  = filename.indexOf('.');
                String name = (pos > -1 ? filename.substring(0, pos): filename).toLowerCase();

                (new File(BaseVisitor.target_dir + "/_src/" + ModelUtil.getPathFromPackage(package_name + "." + name.toLowerCase()))).mkdirs();

                //

                PrintStream       fp       = null;
                ArrayList<String> names    = new ArrayList<String>();
                ArrayList<String> repeated = new ArrayList<String>();

                for (int i = 0; i < entryArray.size(); i++) {

                  //logger.debug("[" + filename + "] entry: " + entryArray.get(i).name);

                    if (names.contains(entryArray.get(i).name)) {

                        if (!repeated.contains(entryArray.get(i).name)) {
                            repeated.add(entryArray.get(i).name);
                        }
                    }
                    else {
                        names.add(entryArray.get(i).name);
                    }

                    //

                    boolean is_primitive = entryArray.get(i).childs == null || ModelUtil.isConditionalStruct(entryArray.get(i).childs) || entryArray.get(i).mode == DataEntryDesc.INDEXER;

                    if (!is_primitive) {

                        fp = new PrintStream(new FileOutputStream(BaseVisitor.target_dir + "/_src/" + ModelUtil.getPathFromPackage(package_name + "." + name.toLowerCase()) + "/" + ModelUtil.camelCase(entryArray.get(i).name) + ".java"));

                        Stack<String> ancestorOccurs = new Stack<String>();

                        ModelUtil.genClazz(fp, entryArray.get(i), true/*iniCompUnit*/, ancestorOccurs, package_name + "." + name.toLowerCase(), jsonparams, filename);

                        fp.close();
                    }
                }

                if (repeated.size() > 0) {

                    StringBuffer sb = new StringBuffer();

                    for (int i = 0; i < repeated.size(); i++) {
                        sb.append(repeated.get(i) + " ");
                    }

                    throw new RuntimeException("variable(s) " + sb.toString() + "ya esta(n) definida(s).");
                }

                //

                ArrayList<DataEntryDesc> usedBases     = new ArrayList<DataEntryDesc>();
                ArrayList<String>        sections      = new ArrayList<String>();
                ArrayList<String>        paragraphs    = new ArrayList<String>();
                HashMap<String, String>  nextParagraph = new HashMap<String, String>();
                ArrayList<String>        varspaths     = new ArrayList<String>();

                for (int i = 0; i < entryArray.size(); i++) {
                    BaseVisitor.addVariablePath(entryArray.get(i), "", varspaths);
                }

                /*
                logger.debug("[" + filename + "] -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

                for (int i = 0; i < varspaths.size(); i++) {
                    logger.debug("[" + filename + "] '" + varspaths.get(i) + "'");
                }

                logger.debug("[" + filename + "] -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                */

                root.accept(new SectionsVisitor(filename,                                   sections, paragraphs, nextParagraph                                                     ), argu);
                root.accept(new ConvertVisitor (filename, entryArray, varspaths, usedBases, sections, paragraphs, nextParagraph, package_name + "." + name.toLowerCase(), jsonparams), argu);

                return copyArray;
            }
            else {
                logger.warn("[" + filename + "] source '" + filename + "' no encontrado en '" + programsDir + "'" + (source != null ? ", usado '" + source.getAbsolutePath() + "'" : ""));
            }
        }
        catch (cl.bee.perseus.cobolparser.ParseException e) {

            logger.error("[" + filename + "] ParseException: " + e);

            failed_fp.println("[" + filename + "] " + "ParseException: " + e);
        }
        catch (cl.bee.perseus.cobolparser.TokenMgrError e) {

            logger.error("[" + filename + "] TokenMgrError: " + e);

            failed_fp.println("[" + filename + "] " + "TokenMgrError: " + printStackTrace(e));
        }
        catch (Exception e) {

          //logger.error("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
          //logger.error("[" + filename + "] " + e);
            logger.error("[" + filename + "] " + printStackTrace(e));
          //logger.error("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");

          //failed_fp.println("[" + filename + "] " + "Exception: " + printStackTrace(e));
        }

      //logger.debug("saliendo de 'visitProgram()' ...");

        return null;
    }

    /******************************************************************************
     * findSource
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param dir TODO_javadoc.
     * @param filename TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @throws Exception TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static File findSource(File dir, String filename) throws Exception {

      //logger.debug("entrando en 'findSource(" + dir.getAbsolutePath() + "," + filename + ")' ...");

        if (dir == null) {
            return null;
        }

        File[] list = dir.listFiles();

        if (list == null) {
            return null;
        }

        File file = null;

        for (int i = 0; i < list.length; i++) {

            if (list[i] == null) {
                continue;
            }

            if (list[i].isFile() && list[i].getName().equalsIgnoreCase(filename)) {
                return list[i];
            }
            else if (list[i].isDirectory()) {

                file = findSource(list[i], filename);

                if (file != null) {
                    return file;
                }
            }
        }

        return null;
    }

    /******************************************************************************
     * isExtension
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param fullname TODO_javadoc.
     * @param prgext TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static boolean isExtension(String fullname, String prgext) {

        if (prgext.equals("")) {
            return fullname.lastIndexOf(".") == -1;
        }
        else {
            return fullname.toUpperCase().endsWith(prgext.toUpperCase());
        }
    }

    /******************************************************************************
     * isProgram
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param fullname TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @throws Exception TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static boolean isProgram(String fullname) throws Exception {

      //logger.debug("entrando a 'isProgram(" + fullname + ")' ...");

        Pattern idDivision = Pattern.compile("^[ \\t\\f]*" + "(ID|IDENTIFICATION)" + "[ \\t\\f]+" + "DIVISION\\.", Pattern.CASE_INSENSITIVE);

        BufferedReader fp_in   = new BufferedReader(new InputStreamReader(new FileInputStream(fullname)));
        String         line    = null;
        Matcher        matcher = null;

        line = validLine(fp_in.readLine());

        while (line != null) {

            if (idDivision.matcher(line).find()) {

                fp_in.close();

                return true;
            }

            line = validLine(fp_in.readLine());
        }

        fp_in.close();

        return false;
    }

    /******************************************************************************
     * validLine
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param line TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static String validLine(String line) {

        if (line == null) {
            return null;
        }

        line = line.length() <= MAXLEN ? line : line.substring(0, MAXLEN);

        if (line.length() < AREASIZE) {
            line = spaces.substring(0, line.length());
        }
        else {
            line = spaces.substring(0, AREASIZE) + line.substring(AREASIZE);
        }

      //logger.debug("[validLine] {" + line + "}");

        return line;
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
