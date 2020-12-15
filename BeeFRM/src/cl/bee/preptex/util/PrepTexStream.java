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

import cl.bee.genfrmjava.util.Utils;


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
    
    private int numConca = 0;

    /** TODO_javadoc. */
    private static Pattern endpattern = Pattern.compile("^[ ]*END", Pattern.CASE_INSENSITIVE);
    
    /** TODO_javadoc. */
    private static Pattern elsepattern = Pattern.compile("^[ ]*ELSE", Pattern.CASE_INSENSITIVE);
    
    private static final String type_special_names[] = { "NOT PGM_BQ", "NOT PGM_BU", "NOT PGM_PER","NOT PGM_PTC", "PGM_BQ", "PGM_BU", "PGM_PER", "PGM_PTC" }; //ordenado
    

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
    public PrepTexStream(String name, String ctrl, HashMap<String, Object> symbolsTable, HashMap<String, Integer> concatenatedOrder ) throws FileNotFoundException {

        super(name);

      //logger.debug("entrando a '<init>(" + name + " <<" +symbolsTable + ">>)' ...");

        try {

            String                control  = ctrl;
            int                   ctrl_len = control.length();
            String                ls       = System.getProperty("line.separator");
            String                text     = null;
            String                line     = null;
            BufferedReader        fp_in    = new BufferedReader(new InputStreamReader(new FileInputStream(name)));
            ByteArrayOutputStream baos     = new ByteArrayOutputStream();
            PrintStream           fp_out   = new PrintStream(baos);
            
            
            //ogb
            String label = null;
            List<String> usedLabel = new ArrayList<String>();
            Map<String, Integer> codeLabel = new HashMap<>();
            
            
            Boolean concatenated = false;
            String  prevKey = null;
            Boolean outConca = false;
            numConca = 0;
            //ogb

            while ((line = fp_in.readLine()) != null) {

              //logger.debug("[" + line + "]");

                if (line.startsWith(control)) {

                	label = rtrim(line.substring(ctrl_len));

                	
                    if (text != null) {

                        fp_out.println("TEXT[:" + rtrim(text));
                        fp_out.println(":]");

                        text = null;
                    }

                    if (endpattern.matcher(line.substring(ctrl_len)).find()) {
                        fp_out.println("END");
                        concatenated = false;
                        
                        //si es de tipo BQ o BU no se pone como concatenated ya que no se tomara en cuenta despues
                        if (outConca)
	            			if (Arrays.binarySearch(type_special_names, ((prevKey.contains("$")) ? prevKey.substring(0, prevKey.indexOf("$")) : prevKey).substring(prevKey.indexOf("IF ") + 3)) < 0) {
	            				numConca++;
	            				String txxt = prevKey.substring(prevKey.indexOf("IF ") + 3);
	                            concatenatedOrder.put(txxt, numConca);
	            			}

                        
                    }
                    else {
                    	if (!label.startsWith("!") && label.contains("IF "))
                    	{
                    		
                        	String textBr = (label.contains("IF ")) ? label.substring(label.indexOf("IF ") + 3) : label;
                        	String prIni = (label.contains("IF ")) ? label.substring(0, label.indexOf("IF ") + 3) : "";
                        	label = prIni + splitBrackets(textBr);
                        	
                    		outConca = false;
	                    	if (concatenated) {
	                            fp_out.println("END");

	                            //si es de tipo BQ o BU no se pone como concatenated ya que no se tomara en cuenta despues
	                			if (Arrays.binarySearch(type_special_names, ((prevKey.contains("$")) ? prevKey.substring(0, prevKey.indexOf("$")) : prevKey).substring(prevKey.indexOf("IF ") + 3)) < 0) {

	                				numConca = searchMaxConcatenated(concatenatedOrder, prevKey.substring(prevKey.indexOf("IF ") + 3) );
	                				numConca++;
	                                concatenatedOrder.put(prevKey.substring(prevKey.indexOf("IF ") + 3), numConca);
	                			}
	                            
	                			prevKey = ReadConcatenatedCode(ctrl, symbolsTable, fp_in, fp_out, line, prevKey, label, codeLabel, concatenatedOrder);
	                			
	                			
	                			String sdsd = ((prevKey.contains("$")) ? prevKey.substring(0, prevKey.indexOf("$")) : prevKey).substring(prevKey.indexOf("IF ") + 3);
	                			if (Arrays.binarySearch(type_special_names, sdsd) > -1) {
	                				numConca = 0;
	                			}
	                			
	                			outConca = true;
	                            label = prevKey;
	                            
	                    	}
	                    	else {
	                            numConca = 0;
		                        if(codeLabel.containsKey(label.trim())) {
		                            int nitm = codeLabel.get(label.trim());
		                            nitm++;
		                            codeLabel.put(label.trim(), nitm);
		                            label = label.trim() + "$" +nitm;
		                            fp_out.println(replace(label, symbolsTable));
		
		                        }
		                        else {
		                        	codeLabel.put(label.trim(), 0);
		                            fp_out.println(replace(label, symbolsTable));
		                        }
	
		                        
	                    	}
	                    	concatenated = true;
	                        prevKey = label;
                    	}

                    }
                }
                else {
                    text = text != null ? text += (ls + line) : line;
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
    
    private String splitBrackets(String iniText) {

        if (!iniText.contains("(") || !iniText.contains(")"))
        	return iniText;
        
        Pattern pattern = Pattern.compile("\\((?:[^)(]+|\\((?:[^)(]+|\\([^)(]*\\))*\\))*\\)", Pattern.CASE_INSENSITIVE);
        
        Matcher matcher = pattern.matcher(iniText);
        
        String proText = null;
        String prvText = null;
        String nxtText = null;
        
        String operatorOut = null;
        String operatorIn = null;
        
        String finalText = null;
        String proCond = null;
        
        String position = null;
        
        int indexAND = -1;
        int indexOR = -1;
        int indexPro = -1;
        		
        int count = 0;
        
        while( matcher.find() ) {
            count++;
            
           
            proText = iniText.substring(matcher.start() + 1, matcher.end() - 1);
            
            //recursividad para parentesis dentro de parentesis
            if (proText.contains("(") && proText.contains(")"))
            	proText = splitBrackets(proText);
            
            
            prvText = iniText.substring(0, matcher.start());
            nxtText = iniText.substring(matcher.end());
            
            
            if (prvText.contains(" AND ") || prvText.contains(" OR ")) {
            
            	indexAND = prvText.lastIndexOf(" AND ");
            	indexOR  = prvText.lastIndexOf(" OR ");      	
                position = "prv";
            	
            }
            else if (nxtText.contains(" AND ") || nxtText.contains(" OR ")) {
            	
            	indexAND = nxtText.indexOf(" AND ");
            	indexOR  = nxtText.indexOf(" OR ");
            	position = "nxt";
            }
            else {
            	
            	//es solo el IF ( ), se remueven los parentesis y se retorna
            	
            	iniText = iniText.replaceAll("(", "").replaceAll(")", "");
            	return iniText;
            }
            	
            
            operatorOut = (indexAND > indexOR) ? " AND ":" OR ";
            indexPro = (indexAND > indexOR) ? indexAND:indexOR;
            
            operatorIn = (operatorOut.equals(" AND ")) ? " OR ":" AND ";
            
            if (position.equals("prv")) {
            	proCond = prvText.substring(0 ,	indexPro).trim();
            	proCond = (proCond.lastIndexOf(" ") >= 0) ? proCond.substring(proCond.lastIndexOf(" ")).trim() : proCond;
            	
            }
            else {
            	proCond = nxtText.substring(indexPro).trim();
            	proCond = proCond.substring(proCond.indexOf(" ")).trim();
            }
            
            finalText = "";
        	for (String innerText : proText.split(operatorIn)){
        		
        		finalText += proCond;
        		finalText += operatorOut + innerText;
        		finalText += operatorIn;

        	}
        
        	finalText = finalText.substring( 0, finalText.length() - operatorIn.length());
            
            
            if (position.equals("prv")) {
	        	if (nxtText.length() > 0) {
	        		
	        		finalText = "(" + finalText + ") " + nxtText;
	        		finalText = splitBrackets(finalText);
	        		
	        	}
            }
            else {
	        	if (prvText.length() > 0) {
	        		
	        		finalText = prvText + " (" + finalText + ")";
	        		finalText = splitBrackets(finalText);
	        		
	        	}
            }
            
        }

        
        return finalText;
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
    
    public String ReadConcatenatedCode(String ctrl,HashMap<String, Object> symbolsTable, BufferedReader fp_in, PrintStream fp_out,
    		String line, String prevKey, String label, Map<String, Integer> codeLabel, HashMap<String, Integer> concatenatedOrder) 
    		throws FileNotFoundException{
        
        try {
	        String                control  = ctrl;
	        int                   ctrl_len = control.length();
	        String                ls       = System.getProperty("line.separator");
	        String                text     = null;
	        String                newPrv   = null;
	        String                currLabel = null;
	        Boolean concatenated = false;

	        prevKey = (prevKey.contains("$")) ? prevKey.substring(0, prevKey.indexOf("$")) : prevKey;

	        currLabel = label.substring(label.indexOf("IF ") + 3).trim();
	        label = prevKey + " AND " + label.substring(label.indexOf("IF ") + 3).trim();

	        newPrv = label;
	        
	        if(codeLabel.containsKey(label.trim())) {
	            int nitm = codeLabel.get(label.trim());
	            nitm++;
	            codeLabel.put(label.trim(), nitm);
	            label = label + "$" +nitm;
	            fp_out.println(replace(label, symbolsTable));
	
	        }
	        else {
	        	codeLabel.put(label.trim(), 0);
	        	fp_out.println(replace(label, symbolsTable));
	        }
	        
	        concatenated = true;
	        numConca++;
	        concatenatedOrder.put(label.substring(label.indexOf("IF ") + 3), numConca);
	        
	
	        while ((line = fp_in.readLine()) != null) {
	
	            if (line.startsWith(control)) {
	
	            	label = line.substring(ctrl_len);
	            	
	                if (text != null) {
	
	                    fp_out.println("TEXT[:" + rtrim(text));
	                    fp_out.println(":]");
	
	                    text = null;
	                                            
	                }
	
	                if (endpattern.matcher(line.substring(ctrl_len)).find() || elsepattern.matcher(line.substring(ctrl_len)).find()) {
	                    fp_out.println("END");
	                    concatenated = false;
	                    
	                    label = (prevKey.contains("$")) ? prevKey.substring(0, prevKey.indexOf("$")) : prevKey;
	                    
	                    
	                    if(endpattern.matcher(line.substring(ctrl_len)).find()) {
	                        if(codeLabel.containsKey(label.trim())) {
	                            int nitm = codeLabel.get(label.trim());
	                            nitm++;
	                            codeLabel.put(label.trim(), nitm);
	                            label = label + "$" +nitm;
	                            fp_out.println(replace(label, symbolsTable));

	                        }
	                        else {
	                        	codeLabel.put(label.trim(), 0);
	                            fp_out.println(replace(label, symbolsTable));
	                        }	
	                    }
	                    else if (elsepattern.matcher(line.substring(ctrl_len)).find()) {
	                    	String auxLabel = label;
	                    	
	                    	auxLabel = "IF NOT " + currLabel;
	                        label = ReadConcatenatedCode(ctrl, symbolsTable, fp_in, fp_out, line, label, auxLabel, codeLabel, concatenatedOrder);
	                    	
	                    	
	                    }


                        
            	        //numConca++;
            	        //concatenatedOrder.put(label.substring(label.indexOf("IF ") + 3), numConca);
	                    return label;

	                }
	                else {
	                    
	                    if (concatenated){
	                        fp_out.println("END");
	                        label = ReadConcatenatedCode(ctrl, symbolsTable, fp_in, fp_out, line, newPrv, label, codeLabel, concatenatedOrder);
	                    }
	                    concatenated = true;

	                }
	            }
	            else {
	                text = text != null ? text += (ls + line) : line;
	            }
	        }
        
	    }
	    catch (Exception e) {
	        throw new FileNotFoundException(printStackTrace(e));
	    }
        
        return label;
        
    }
    
    
    public int searchMaxConcatenated(HashMap<String, Integer> concatenatedOrder, String key_b) throws IOException {
    	
    	int max_conca = 0;
    	key_b = (key_b.contains("$"))? key_b.substring(0, key_b.indexOf("$")) : key_b;
    	
    	for(Map.Entry<String, Integer> entry : concatenatedOrder.entrySet()) {
    	    String key = entry.getKey();
    	    int value = entry.getValue();

    	    
    	    String[] parts = key.split(" ");
    	    for (String part : parts) {
    	        
    	    	part = (part.contains("$"))? part.substring(0, part.indexOf("$")) : part;
    	    	if (part.equals(key_b)) {
    	    		max_conca = (value > max_conca) ? value : max_conca;
    	    		break;
    	    	}
    	    	
    	    }
    	    
    	}
    	
    	
        return max_conca;
    }
    
}
