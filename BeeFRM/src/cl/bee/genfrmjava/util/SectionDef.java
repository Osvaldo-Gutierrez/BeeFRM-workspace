package cl.bee.genfrmjava.util;

import java.util.*;

import org.apache.log4j.*;

/**
*
* TODO_javadoc.
*
* @version 1.0 (01/01/2013).
*
*/
public class SectionDef {
    
	//
	/** TODO_javadoc. */
    private String name = null;
    
    /** TODO_javadoc. */
    private String code = null;
    
    /** TODO_javadoc. */
    private int concatenate = 0;
    
    /** TODO_javadoc. */
    private ArrayList<String> nameSpecials = null;
    
    /** TODO_javadoc. */
    //variables que no son consideradas para asignar el nombre a la clase
    //private static final String type_special_names[]  = { "NOT PGM_BQ", "NOT PGM_BU", "NOT_PGM_PER","NOT_PGM_PTC", "PGM_BQ", "PGM_BU", "PGM_PER", "PGM_PTC" }; //ordenado
   //private static final String type_special_names[]  = { "NOT PGM_BQ", "NOT PGM_BU", "NOT PGM_PER","NOT PGM_PTC", "PGM_BQ", "PGM_BU", "PGM_PER", "PGM_PTC" }; //ordenado
    private static final String type_special_names[]  = { "NOT PGM_ARG", "NOT PGM_BQ", "NOT PGM_BU", "NOT PGM_DOS", "NOT PGM_DTC", "NOT PGM_MVS", "NOT PGM_PER", 
    		                                              "NOT PGM_PTC", "PGM_ARG", "PGM_BQ", "PGM_BU", "PGM_DOS", "PGM_DTC", "PGM_MVS", "PGM_PER", "PGM_PTC" }; //ordenado
    private static final String envString = "PGM_";
    
    private static final String notenvString = "NOT ";
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getConcatenate() {
		return concatenate;
	}

	public void setConcatenate(int concatenate) {
		this.concatenate = concatenate;
	}


	public SectionDef(String name, String code, HashMap<String, Boolean> environment_hash) {
		super();
		this.code = code;
		
		
		List<String> listOr = Arrays.asList(name.split(" OR "));
		ArrayList<String>  nameUniOr = new ArrayList<String>(listOr);
		this.nameSpecials = new ArrayList<String>();
		
		for( String txtOr : nameUniOr ) {
		
			List<String> fixedLenghtList = Arrays.asList(txtOr.split(" AND "));
			ArrayList<String>  nameUni = new ArrayList<String>(fixedLenghtList);

			

			for( String txt : nameUni ) {
				
				txt = txt.trim();
				
				int pos = 0;
				
				//remueve caracter $ y se le asigna al nombre
				if (txt.contains("$")) {
					pos =  Integer. parseInt(txt.substring(txt.indexOf("$") + 1));
					txt = txt.substring(0, txt.indexOf("$"));
				}
				
				if (txt.startsWith(envString) || txt.startsWith(notenvString + envString)) {
					
					this.nameSpecials.add(txt);
					
					if(!environment_hash.containsKey(txt)) {
						
						txt = (txt.startsWith(notenvString))? txt.substring(notenvString.length()) : txt;
						
						environment_hash.put(txt, false);
						environment_hash.put(notenvString + txt, true);
					}

					
				}
				else
				{	
					this.name = pos > 0 ? txt + "$" + pos : txt	;
				}
				
			}
			
		}
		

		
	}
	
	
	public boolean hasSpecial(String label) {
		
		if (nameSpecials.contains(label.trim()))
			return true;
		else
			return false;
	}
	
	public ArrayList<String> getSpecial() {
		
		return this.nameSpecials;
	}
	
	
	public int numSpecial() {
		
		return this.nameSpecials.size();
		
	}
	
	
	
}
