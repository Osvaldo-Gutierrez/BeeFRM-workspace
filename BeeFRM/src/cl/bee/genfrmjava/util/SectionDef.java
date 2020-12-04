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
    private ArrayList<String> operatorSpecials = null;
    /** TODO_javadoc. */

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
		this.operatorSpecials = new ArrayList<String>();
		
		ArrayList<String>  nameKeys = new ArrayList<String>();
		
		for( String txtOr : nameUniOr ) {
		
			List<String> fixedLenghtList = Arrays.asList(txtOr.split(" AND "));
			ArrayList<String>  nameUni = new ArrayList<String>(fixedLenghtList);

			int nSpecials = 0;
			int pos = 0;
			
			for( String txt : nameUni ) {
				
				txt = txt.trim();
				
				//remueve caracter $ y se le asigna al nombre
				if (txt.contains("$")) {
					pos =  Integer. parseInt(txt.substring(txt.indexOf("$") + 1));
					txt = txt.substring(0, txt.indexOf("$"));
				}
				
				if (txt.startsWith(envString) || txt.startsWith(notenvString + envString)) {
					
					pos++;
					
					this.nameSpecials.add(txt);
					
					
					if (pos > 1)
						this.operatorSpecials.add("AND");
					else
						this.operatorSpecials.add("OR");
					
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
	
	public int getPosSpecial(String label) {
		
		if (nameSpecials.contains(label.trim()))
			return nameSpecials.indexOf(label);
		else
			return -1;
	}
	
	public ArrayList<String> getSpecial() {
		
		return this.nameSpecials;
	}
	
	public String getOperatorSpecials(int index) {
		
		return this.operatorSpecials.get(index);
	}
	
	
	public int numSpecial() {
		
		return this.nameSpecials.size();
		
	}
	
	
	
}
