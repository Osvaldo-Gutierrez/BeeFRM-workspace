/*
 *   Copyright (c) 2019 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.preptex.util;


import java.io.*;

import java.util.*;
import java.util.regex.*;

import org.apache.log4j.*;


/**
 *
 * TODO_javadoc.
 *
 * @version 1.0 (01/01/2013).
 *
 */
public class PrepTexStream extends FileInputStream {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(PrepTexStream.class);

    /** TODO_javadoc. */
    private ByteArrayInputStream bais = null;

    /** TODO_javadoc. */
    private static Pattern endpattern = Pattern.compile("^[ ]*END", Pattern.CASE_INSENSITIVE);
    
    //OGB, obtiene definicion de variable
    private static Pattern defpattern = Pattern.compile("^[\\*]*%[ ]*\\w+[ ]*={1}[ ]*[\\\"]?[A-Z0-9]+[\\\"]?", Pattern.CASE_INSENSITIVE);
    

    /******************************************************************************
     * PrepTexStream
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param name TODO_javadoc.
     * @param ctrl TODO_javadoc.
     *
     * @throws FileNotFoundException TODO_javadoc.
     *
     * @since 1.0
     *
     */ 
    public PrepTexStream(String name, String ctrl, HashMap<String, Object> symbolsTable, Boolean onlyVars) throws FileNotFoundException {

        super(name);

      logger.debug("entrando a '<init>(" + name + " <<" +symbolsTable + ">>)' ...");

        try {

            String                control  = ctrl;
            int                   ctrl_len = control.length();
            String                ls       = System.getProperty("line.separator");
            String                text     = null;
            String                line     = null;
            BufferedReader        fp_in    = new BufferedReader(new InputStreamReader(new FileInputStream(name)));
            ByteArrayOutputStream baos     = new ByteArrayOutputStream();
            PrintStream           fp_out   = new PrintStream(baos);

            while ((line = fp_in.readLine()) != null) {

              //logger.debug("[" + line + "]");
            	            		
            		if (!onlyVars) {
            		
	                    if (line.startsWith(control)) {
	
	                        if (text != null) {
	
	                            fp_out.println("TEXT[:" + rtrim(text));
	                            fp_out.println(":]");
	
	                            text = null;
	                        }
	
	                        if (endpattern.matcher(line.substring(ctrl_len)).find()) {
	                            fp_out.println("END");
	                        }
	                        else {
	                        fp_out.println(replace(line.substring(ctrl_len), symbolsTable));
	                        }
	                    }
	                    else {
	                        text = text != null ? text += (ls + line) : line;
	                    }
            		}
            		else {
	                    if (line.startsWith(control)) {
	                        if (defpattern.matcher(line).find()) {
		                        fp_out.println(replace(line.substring(ctrl_len), symbolsTable));
	                        }
	                    }
            		}
            		

            }

            if (text != null) {
                fp_out.println("TEXT[:" + rtrim(text));
                fp_out.println(":]");
            }

            fp_in.close();
            fp_out.close();

            /*
            FileOutputStream fpTmp = new FileOutputStream(name + ".ext");

            fpTmp.write(baos.toByteArray());
            fpTmp.close();
            */

            bais = new ByteArrayInputStream(baos.toByteArray());
        }
        catch (Exception e) {
            throw new FileNotFoundException(printStackTrace(e));
        }
    }

    /******************************************************************************
     * listIds
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param symbolsTable TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private String listIds(HashMap<String, Object> symbolsTable) {

        StringBuffer sb    = new StringBuffer();
        boolean      first = true;

        for (Iterator<String> iter = symbolsTable.keySet().iterator(); iter.hasNext(); ) {

            if (first) {
                first = false;
            }
            else {
                sb.append(",");
            }

            sb.append(iter.next());
        }

        return sb.toString();

    }

    /******************************************************************************
     * rtrim
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private String rtrim(String s) {

        if (s == null) {
            return null;
        }

        int i = s.length() - 1;

        for (; i >= 0; i--) {

            if (s.charAt(i) != ' ') {
                break;
            }
        }

        return s.substring(0, i + 1);
    }

    /******************************************************************************
     * replace
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param text TODO_javadoc.
     * @param symbolsTable TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @throws Exception TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private String replace(String text, HashMap<String, Object> symbolsTable) throws Exception {

        StringBuffer sb    = new StringBuffer();
        Object       value = null;
        int          act   = 0;
        int          ini;
        int          fin;

        do {

            if ((ini = text.indexOf("{", act)) > -1) {

                if (ini > act) {
                    sb.append(text.substring(act, ini));
                }

                if ((fin = text.indexOf("}", ini + 1)) == -1) {
                    throw new Exception("error de formato: '" + text + "'.");
                }

                String ident = text.substring(ini + 1, fin);

                if ((value = symbolsTable.get(ident.toUpperCase())) == null) {
                  //value = "{" + ident + "}";
                    throw new Exception("variable '" + ident + "' no encontrada en symbolsTable.");
                }
                else {
                    value = symbolsTable.get(ident.toUpperCase());
                }

                /*
                if (!(value instanceof String)) {
                    throw new RuntimeException("tipo de '" + value + "' debe ser String (" + value.getClass().getSimpleName() + ").");
                }
                */

                sb.append(value.toString());

                act = fin + 1;
            }
        }
        while (ini >= 0);

        if (act < text.length()) {
            sb.append(text.substring(act));
        }

        return sb.toString();
    }

    /******************************************************************************
     * read
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @throws IOException TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public int read() throws IOException {
        return bais.read();
    }

    /******************************************************************************
     * read
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param b TODO_javadoc.
     * @param offset TODO_javadoc.
     * @param len TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @throws IOException TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public int read(byte b[], int offset, int len) throws IOException {
        return bais.read(b, offset, len);
    }

    /******************************************************************************
     * read
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param b TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @throws IOException TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public int read(byte b[]) throws IOException {
        return bais.read(b, 0, b.length);
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
     */
    private String printStackTrace(Throwable e) {

        CharArrayWriter caw = new CharArrayWriter();

        e.printStackTrace(new PrintWriter(caw));

        return caw.toString();
    }
}
