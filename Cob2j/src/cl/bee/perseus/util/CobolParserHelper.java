/*
 *   Copyright (c) 2017 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.perseus.util;


import java.io.*;

import java.util.*;
import java.util.regex.*;

import java.time.*;

import cl.bee.perseus.cobolparser.*;
import cl.bee.perseus.cobolparser.syntaxtree.*;
import cl.bee.perseus.cobolparser.util.*;
import cl.bee.perseus.cobolparser.visitor.*;

import cl.bee.perseus.copyparser.*;
import cl.bee.perseus.copyparser.visitor.*;

import cl.bee.perseus.util.*;

import org.apache.log4j.*;


/**
 *
 * TODO_javadoc.
 *
 * @version 1.0 (01/01/2016).
 *
 */
public class CobolParserHelper {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(CobolParserHelper.class);

    /** TODO_javadoc. */
    private static final String spaces = "                                                                                                                                                                                                                                                                ";

    /** TODO_javadoc. */
    private static final int MAXLEN = 80;

    /** TODO_javadoc. */
    private static final int AREASIZE = 6;

    /** TODO_javadoc. */
    public static int globalNum;

    /** TODO_javadoc. */
    public static int programNum;

    /** TODO_javadoc. */
  //private static int copyLineNum;

    /** TODO_javadoc. */
  //private static ArrayList<Integer> linesExt = null;

    /** TODO_javadoc. */
    public static final int UNDEF_TYPE = -1;

    /** TODO_javadoc. */
    public static final int BATCH_TYPE = 1;

    /** TODO_javadoc. */
    public static final int ONLINE_TYPE = 2;

    /** TODO_javadoc. */
    private static String[] batchTypes = { "PB", "PG", "PL" /* ordenado */ };

    /** TODO_javadoc. */
    private static String[] onlineTypes = { "PO", "PP", "PQ", "PS", "PU" /* ordenado */ };

    /******************************************************************************
     * copiesExtension
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param name TODO_javadoc.
     * @param excludecopies TODO_javadoc.
     * @param programsDir TODO_javadoc.
     * @param copiesDir TODO_javadoc.
     * @param prgext TODO_javadoc.
     * @param cpyext TODO_javadoc.
     * @param lines TODO_javadoc.
     * @param workingDir TODO_javadoc.
     * @param notfoundcopies TODO_javadoc.
     * @param alert TODO_javadoc.
     * @param firstorder TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @throws Exception TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public static ArrayList<CopyDesc> copiesExtension(String name, Properties excludecopies, String programsDir, String copiesDir, String prgext, String cpyext, ArrayList<LineDesc> lines, String workingDir, ArrayList<String> notfoundcopies, boolean alert, boolean firstorder) throws Exception {

      //logger.debug("[" + name + "] entrando a copiesExtension(" + programsDir + "/" + name + prgext + ", firstorder=" + firstorder + ") ...");

        ArrayList<CopyDesc> copyArray = new ArrayList<CopyDesc>();
        File                source    = new File(programsDir + "/" + name + prgext);

        if (source != null && source.exists()) {

            CobolParserStream fp_in = new CobolParserStream(source.getAbsolutePath());

            ArrayList<Integer> linesExt = fp_in.getLinesExt();

            /*
            for (int i = 0; i < linesExt.size(); i++) {
                logger.debug("[" + name + "] extension en linea: " + linesExt.get(i));
            }
            */

          //logger.debug("[" + name + "] extendido: " + workingDir + "/" + name + prgext + ".ext");

            PrintStream  fp_out = new PrintStream(new FileOutputStream(workingDir + "/" + name + prgext + ".ext"));
            char         ch;
            int          n;
            int          stateCpy      = 1;
            int          stateAntCpy   = -1;
            StringBuffer sb         = new StringBuffer();

            n = fp_in.read();

            /*
            if (n != 0x0A && n != 0x0D && (n < 0x21 || n > 0x7E)) {
                n = (byte) '?';
            }
            */

            while (n != -1) {

                ch          = (char) n;
                stateAntCpy = stateCpy;
                stateCpy    = nextStateCpy(stateAntCpy, Character.toUpperCase(ch));

              //logger.debug("[" + name + "] ch: [" + ch + "] (" + n + ") stateCpy: " + stateCpy + " stateAntCpy: " + stateAntCpy);

                switch (stateCpy) {

                /******************************************************************************
                 *
                 ******************************************************************************/

                case 0 :

                    sb.append(ch);

                    break;

                /******************************************************************************
                 *
                 ******************************************************************************/

                case 1 :

                    if (ch == 0x0A) { // '\n'

                        globalNum++;

                        programNum = incProgramNum(linesExt, programNum);

                        lines.add(new LineDesc(globalNum, name, sb.toString(), programNum, 0));

                        fp_out.println(                         sb.toString());

                        sb.setLength(0);
                    }

                    break;

                /******************************************************************************
                 *
                 ******************************************************************************/

                case 13 :

                    int stateInStmt    = 1;
                    int stateAntInStmt = -1;

                    while (n != -1) {

                        ch             = (char) n;
                        stateAntInStmt = stateInStmt;
                        stateInStmt    = nextStateInStmt(stateAntInStmt, Character.toUpperCase(ch));

                      //logger.debug("[" + name + "] ch: [" + ch + "] (" + n + ") stateInStmt: " + stateInStmt + " stateAntInStmt: " + stateAntInStmt);

                        sb.append(ch);

                        if (ch == 0x0A) { // '\n'

                            globalNum++;

                            programNum = incProgramNum(linesExt, programNum);

                            lines.add(new LineDesc(globalNum, name, "", programNum, 0));

                            fp_out.println();
                        }

                        //

                        if (stateInStmt == 0 && ch == '.') {
                            break;
                        }

                        n = fp_in.read();

                        /*
                        if (n != 0x0A && n != 0x0D && (n < 0x21 || n > 0x7E)) {
                            n = (byte) '?';
                        }
                        */
                    }

                    //

                    String copyname = getNameFromCopyStmt(sb.toString().substring(6).trim(), name);

                    CopyDesc cd = new CopyDesc(copyname, "", "", "", "", "");

                    if (!copyArray.contains(cd)) {
                        copyArray.add(cd);
                    }

                    ArrayList<CopyDesc> copies = processCopy(fp_out, name, programNum, sb.toString().substring(AREASIZE), excludecopies, copiesDir, cpyext, lines, workingDir, notfoundcopies, alert, firstorder);

                    copyArray.addAll(copies);

                    //

                    sb.setLength(0);

                    stateCpy = 14;

                    break;

                /******************************************************************************
                 *
                 ******************************************************************************/

                default :

                    sb.append(ch);

                    break;
                }

                n = fp_in.read();

                /*
                if (n != 0x0A && n != 0x0D && (n < 0x21 || n > 0x7E)) {
                    n = (byte) '?';
                }
                */
            }

            fp_in.close();
            fp_out.close();
        }
        else {
            throw new Exception("archivo '" + programsDir + "/" + name + prgext + "' no encontrado.");
        }

        return copyArray;
    }

    /******************************************************************************
     * processCopy
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param fp_out TODO_javadoc.
     * @param name TODO_javadoc.
     * @param programNum TODO_javadoc.
     * @param copystmt TODO_javadoc.
     * @param excludecopies TODO_javadoc.
     * @param copiesDir TODO_javadoc.
     * @param cpyext TODO_javadoc.
     * @param lines TODO_javadoc.
     * @param workingDir TODO_javadoc.
     * @param notfoundcopies TODO_javadoc.
     * @param alert TODO_javadoc.
     * @param firstorder TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @throws Exception TODO_javadoc.
     *
     * @since 1.0
     *
     */

    private static ArrayList<CopyDesc> processCopy(PrintStream fp_out, String name, final int programNum, String copystmt, Properties excludecopies, String copiesDir, String cpyext, ArrayList<LineDesc> lines, String workingDir, ArrayList<String> notfoundcopies, boolean alert, boolean firstorder) throws Exception {

      //logger.debug("[" + name + "] entrando en 'processCopy(" + copystmt + ")' ...");

        ArrayList<CopyDesc> copies = new ArrayList<CopyDesc>();

        try {

            cl.bee.perseus.copyparser.CopyParser            parser = new cl.bee.perseus.copyparser.CopyParser(new StringReader(copystmt));
            cl.bee.perseus.copyparser.syntaxtree.Node       root   = parser.CopyStatement();

            cl.bee.perseus.copyparser.visitor.ValuesVisitor values = new cl.bee.perseus.copyparser.visitor.ValuesVisitor();

            root.accept(values);

          //logger.debug("[" + name + "] despues de root.accept(ValuesVisitor())");

            String copyname = values.getFilename().toUpperCase();

            if (excludecopies.get(copyname) == null) {

                File copy = new File(copiesDir + "/" + copyname + cpyext);

              //logger.debug("[" + name + "] copy buscado '" + copiesDir + "/" + copyname + cpyext + "'");

                if (!copy.exists()) {

                    if (alert) {

                        logger.error      ("[" + name + "] copy '" + copyname + cpyext + "' no encontrado.");
                        notfoundcopies.add("[" + name + "] copy '" + copyname + cpyext + "' no encontrado.");
                    }
                }
                else {

                    ArrayList<CopyDesc> subcopies = copiesExtension(copyname, excludecopies, copiesDir, copiesDir, cpyext, cpyext, new ArrayList<LineDesc>(), workingDir, notfoundcopies, alert, false);

                    copies.addAll(subcopies);

                  //logger.debug("[" + name + "] cant copies extendidos en '" + copyname + "' : " + subcopies.size());

                    //

                    ArrayList replaceArray = values.getReplaceArray();

                    try {

                        copy = new File(workingDir + "/" + copyname + cpyext + ".ext");

                        BufferedReader fp_in = new BufferedReader(new InputStreamReader(new FileInputStream(copy.getAbsolutePath())));

                        String line = null;

                        int copyLineNum = 0;

                      //logger.debug("[" + name + "] antes del ciclo lectura lineas ...");

                        while ((line = fp_in.readLine()) != null) {

                            if (replaceArray.size() == 0) {

                                if (firstorder) {

                                    globalNum++;

                                    copyLineNum++; // = incCopyLineNum(localLinesExt, copyLineNum);

                                    lines.add(new LineDesc(globalNum, copyname, line, 0, copyLineNum));
                                }

                                fp_out.println(line);
                            }
                            else {

                                for (Iterator iter = replaceArray.iterator(); iter.hasNext(); ) {

                                    ReplaceDesc pair    = (ReplaceDesc) iter.next();
                                    Matcher     matcher = pair.getPattern().matcher(line);

                                    if (matcher.find()) {
                                        line = matcher.replaceAll(pair.getReplace());
                                    }
                                }

                                if (firstorder) {

                                    globalNum++;

                                    copyLineNum++; // = incCopyLineNum(localLinesExt, copyLineNum);

                                    lines.add(new LineDesc(globalNum, copyname, line, 0, copyLineNum));
                                }

                                fp_out.println(line);
                            }
                        }

                      //logger.debug("[" + name + "] despues del ciclo lectura lineas ...");

                        fp_in.close();
                    }
                    catch (FileNotFoundException e) {
                        logger.fatal("[" + name + "] FileNotFoundException: " + e.toString());
                    }
                }
            }

            fp_out.print(spaces.substring(0, AREASIZE + copystmt.length() > MAXLEN ? MAXLEN : AREASIZE + copystmt.length()));
        }
        catch (cl.bee.perseus.copyparser.ParseException | cl.bee.perseus.copyparser.TokenMgrError e) {
            logger.fatal("[" + name + "] No se pudo parser el copy statement: '" + copystmt + " '" + printStackTrace(e));
        }
        catch (Exception e) {
            throw e;
        }

        return copies;
    }

    /******************************************************************************
     * getNameFromCopyStmt
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param copystmt TODO_javadoc.
     * @param name TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @throws Exception TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static String getNameFromCopyStmt(String copystmt, String name) throws Exception {

      //logger.debug("[" + name + "] entrando en 'getNameFromCopyStmt(" + copystmt + ")' ...");

        try {

            CopyParser                                parser = new CopyParser(new StringReader(copystmt));
            cl.bee.perseus.copyparser.syntaxtree.Node root   = parser.CopyStatement();
            ValuesVisitor                             values = new ValuesVisitor();

            root.accept(values);

          //logger.debug("[" + name + "] saliendo de 'getNameFromCopyStmt()' ...");

            return values.getFilename().toUpperCase();
        }
        catch (cl.bee.perseus.copyparser.ParseException | cl.bee.perseus.copyparser.TokenMgrError e) {

            logger.fatal("[" + name + "] No se pudo parser el copy statement: '" + copystmt + " '" + printStackTrace(e));

            throw new Exception(e.getMessage());
        }
        catch (Exception e) {
            throw e;
        }
    }

    /******************************************************************************
     * nextStateCpy
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param stateAntCpy TODO_javadoc.
     * @param ch TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static int nextStateCpy(int stateAntCpy, char ch) {

        switch (stateAntCpy) {

        /******************************************************************************
         *
         ******************************************************************************/

        case 0 :

            switch ((byte) ch) {

            case 0x0D : case 0x0A :
                return 1;

            default :
                return 0;
            }

        /******************************************************************************
         *
         ******************************************************************************/

        case 1 :

            switch ((byte) ch) {

            case 0x0D : case 0x0A :
                return 1;

            default :
                return 2;
            }

        /******************************************************************************
         *
         ******************************************************************************/

        case 2 :
        case 3 :
        case 4 :
        case 5 :
        case 6 :

            return stateAntCpy + 1;

        /******************************************************************************
         *
         ******************************************************************************/

        case 7 :

            switch ((byte) ch) {

            case 0x0D :  case 0x0A :
                return 1;

            default :
                return 8;
            }

        /******************************************************************************
         *
         ******************************************************************************/

        case 8 :

            switch ((byte) ch) {

            case (byte) 'C' :
                return 9;

            case 0x0D : case 0x0A :
                return 1;

            case (byte) ' ' :
            case (byte) '\t' :
                return 8;

            default :
                return 0;
            }

        /******************************************************************************
         *
         ******************************************************************************/

        case 9 :

            switch ((byte) ch) {

            case (byte) 'O' :

                return 10;

            case 0x0D : case 0x0A :
                return 1;

            default :
                return 0;
            }

        /******************************************************************************
         *
         ******************************************************************************/

        case 10 :

            switch ((byte) ch) {

            case (byte) 'P' :

                return 11;

            case 0x0D : case 0x0A :
                return 1;

            default :
                return 0;
            }

        /******************************************************************************
         *
         ******************************************************************************/

        case 11 :

            switch ((byte) ch) {

            case (byte) 'Y' :

                return 12;

            case 0x0D : case 0x0A :
                return 1;

            default :
                return 0;
            }

        /******************************************************************************
         *
         ******************************************************************************/

        case 12 :

            switch ((byte) ch) {

            case (byte) ' ' :
            case (byte) '\t' :
            case 0x0D : case 0x0A :
                return 13;

            default :
                return 0;
            }

        /******************************************************************************
         * INSTMT
         ******************************************************************************/

        case 13 :

            switch ((byte) ch) {

            case 0x0D : case 0x0A :
                return 1;

            default :
                return 13;
            }

        /******************************************************************************
         *
         ******************************************************************************/

        case 14 :

            switch ((byte) ch) {

            case 0x0D : case 0x0A :
                return 1;

            default :
                return 14;
            }
        }

        return 0;
    }

    /******************************************************************************
     * nextStateInStmt
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param stateAntInStmt TODO_javadoc.
     * @param ch TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static int nextStateInStmt(int stateAntInStmt, char ch) {

        switch (stateAntInStmt) {

        /******************************************************************************
         *
         ******************************************************************************/

        case 0 :

            switch ((byte) ch) {

            case '=' :
                return 1;

            default :
                return 0;
            }

        /******************************************************************************
         *
         ******************************************************************************/

        case 1 :

            switch ((byte) ch) {

            case '=' :
                return 2;

            default :
                return 0;
            }

        /******************************************************************************
         *
         ******************************************************************************/

        case 2 :

            switch ((byte) ch) {

            case '=' :
                return 3;

            default :
                return 2;
            }

        /******************************************************************************
         *
         ******************************************************************************/

        case 3 :

            switch ((byte) ch) {

            case '=' :
                return 4;

            default :
                return 0;
            }

        /******************************************************************************
         *
         ******************************************************************************/

        case 4 :

            return 0;
        }

        return 0;
    }

    /******************************************************************************
     * incProgramNum
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param linesExt TODO_javadoc.
     * @param programNum TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static int incProgramNum(ArrayList<Integer> linesExt, int programNum) {

        if (linesExt != null && linesExt.size() > 0 && programNum >= linesExt.get(0).intValue()) {

            programNum++;

            linesExt.remove(0);
        }

        programNum++;

        return programNum;
    }

    /******************************************************************************
     * incCopyLineNum
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param linesExt TODO_javadoc.
     * @param copyLineNum TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    /*
    private static int incCopyLineNum(ArrayList<Integer> linesExt, int copyLineNum) {

        if (linesExt != null && linesExt.size() > 0 && copyLineNum >= linesExt.get(0).intValue()) {

            copyLineNum++;

            linesExt.remove(0);
        }

        copyLineNum++;

        return copyLineNum;
    }
    */

    /******************************************************************************
     * getProgramType
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param name TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public static int getProgramType(String name) {

        String type = name.substring(3, 5).toUpperCase();

        if        (Arrays.binarySearch(batchTypes, type) >= 0) {
            return BATCH_TYPE;
        } else if (Arrays.binarySearch(onlineTypes, type) >= 0) {
            return ONLINE_TYPE;
        }

        return UNDEF_TYPE;
    }

    /******************************************************************************
     * getCannonicalDate
     ******************************************************************************/
    /**
     *
     * @param date TODO_javadoc.
     * @param artifact TODO_javadoc.
     * @param lineNum TODO_javadoc.
     * @param errors TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public static String getCannonicalDate(String date, String artifact, int lineNum, ArrayList<String> errors) {

        LocalDate ldate = null;

        int pos1 = date.indexOf("-");
        int pos2 = date.lastIndexOf("-");

        int mes = findMonth(date.substring(pos1 + 1, pos2));

        if (mes < 1) {

          //logger.debug("[" + artifact + "] mes no reconocido en etiqueta '" + date + "'");
            errors.add  ("[" + artifact + "] mes no reconocido en etiqueta '" + date + "'");

            return null;
        }
        else {

            int dia = Integer.parseInt(date.substring(0,  pos1).trim());
            int ano = Integer.parseInt(date.substring(pos2 + 1).trim());

            ldate = LocalDate.of(ano, mes, dia);

            return ldate.toString();
        }
    }

    /******************************************************************************
     * findMonth
     ******************************************************************************/
    /**
     *
     * @param m TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static int findMonth(String m) {

        final String monthsAbrSp[] = { "", "ENE", "FEB", "MAR", "ABR", "MAY", "JUN", "JUL", "AGO", "SEP", "OCT", "NOV", "DIC" };
        final String monthsAbrEn[] = { "", "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };
        final String monthsNum[]   = { "", "01",  "02",  "03",  "04",  "05",  "06",  "07",  "08",  "09",  "10",  "11",  "12" };

        if (m == null) {
            return -1;
        }

        for (int i = 1; i <= 12; i++) {

            if (m.equals(monthsAbrSp[i])) {
                return i;
            }
        }

        for (int i = 1; i <= 12; i++) {

            if (m.equals(monthsAbrEn[i])) {
                return i;
            }
        }

        for (int i = 1; i <= 12; i++) {

            if (m.equals(monthsNum[i])) {
                return i;
            }
        }

        return -1;
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
