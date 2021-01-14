/*
 *   Copyright (c) 2020 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.beebank.cloud.core.gns;


import java.util.Arrays;

//import org.apache.log4j.Logger;


/**
 *
 * TODO_javadoc.
 *
 * @version 1.0 (01/01/2016).
 *
 */
public class Util {

    /** TODO_javadoc. */
  //private static Logger logger = Logger.getLogger(Util.class);

    /*******************************************************************************************************
     * spaces
     *******************************************************************************************************/
    /**
     *
     * @param size TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public static String spaces(int size) {

        char[] arr = new char[size];

        Arrays.fill(arr, ' ');

        return new String(arr);
    }
    
    /*******************************************************************************************************
     * repeat
     *******************************************************************************************************/
    /**
     *
     * @param txt TODO_javadoc.
     * @param size TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    /*OGB-ini*/
    public static String repeat(String txt, int size) {

        char[] arr = new char[size];

        int i = 0;
        int j = 0;
        while (i  < size) {

        	arr[i] = txt.charAt(j); 
			
        	i++;
        	j++;
        	
        	if(j == txt.length())
        		j=0;

        }
               
        return new String(arr);
    }
    /*OGB-fin*/
    /*******************************************************************************************************
     * intToString
     *******************************************************************************************************/
    /**
     *
     * @param i TODO_javadoc.
     * @param size TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public static String intToString(int i, int size) {
    	
        /*OGB-ini*/
        char[] arr = new char[size];
    	
        int r = 0;
        while (r  < size) {

        	arr[r] = String.valueOf(i).charAt(r); 
        	r++;

        }
		
        return new String(arr);

        //  throw new RuntimeException("intToString:: implementar.");
        /*OGB-fin*/
    }

    /*******************************************************************************************************
     * longToString
     *******************************************************************************************************/
    /**
     *
     * @param l TODO_javadoc.
     * @param size TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public static String longToString(long l, int size) {
    	
        /*OGB-ini*/
        char[] arr = new char[size];
    	
        int r = 0;
        while (r  < size) {

        	arr[r] = Long.toString(l).charAt(r); 
        	r++;

        }
		
        return new String(arr);

        // throw new RuntimeException("longToString:: implementar.");
        /*OGB-fin*/
    }

    /*******************************************************************************************************
     * doubleToString
     *******************************************************************************************************/
    /**
     *
     * @param d TODO_javadoc.
     * @param size TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public static String doubleToString(double d, int size) {
        /*OGB-ini*/
        char[] arr = new char[size];
    	
        int r = 0;
	while (r  < size) {

		arr[r] = String.valueOf(d).charAt(r); 
                r++;

        }
		
		
        return new String(arr);
    	
        // throw new RuntimeException("doubleToString:: implementar.");
        /*OGB-fin*/
    }
    
    /*******************************************************************************************************
     * lowValueString
     *******************************************************************************************************/
    /**
     *
     * @param d TODO_javadoc.
     * @param size TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public static String lowValueString(int size) {
        /*OGB-ini*/
        char[] arr = new char[size];
    	
        int i = 0;
	while (i  < size) {

		arr[i] = (char) 00; 
        	i++;

        }
        	
	return new String(arr);
        // throw new RuntimeException("lowValueString:: implementar.");
        /*OGB-fin*/
    }

}
