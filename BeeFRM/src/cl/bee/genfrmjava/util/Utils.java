/*
 *   Copyright (c) 2010 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.genfrmjava.util;


import java.io.*;

import java.util.regex.*;

import org.apache.log4j.*;


/**
 *
 * TODO_javadoc.
 *
 * Registro de versiones:<ul>
 *
 * <li>1.0 (00/00/20XX, <<autor>>): version inicial.
 * </ul>
 *
 */
public class Utils {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(Utils.class);

    /** TODO_javadoc. */
    public static final String NOMBRE_GENEDADOR = "GENFRMJAVA";

    /** TODO_javadoc. */
    public static final String VERSION_GENEDADOR = "Version 3.0.1 Nov-2005";

    /*******************************************************************************************************
     * validLetter
     *******************************************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * Registro de versiones:<ul>
     *
     * <li>1.0 (00/00/20XX, <<autor>>): version inicial.
     * </ul>
     *
     * @param c TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public static char validLetter(char c) {

        switch (c) {
        case 'À' : case 'Á' : case 'Â' : case 'Ã' : case 'Ä' : case 'Å' :
            return 'A';
        case 'à' : case 'á' : case 'â' : case 'ã' : case 'ä' : case 'å' :
            return 'a';
        case 'è' : case 'é' : case 'ê' : case 'ë' :
            return 'e';
        case 'Ë' : case 'É' : case 'Ê' : case 'È' :
            return 'E';
        case 'Ì' : case 'Í' : case 'Î' : case 'Ï' :
            return 'I';
        case 'ì' : case 'í' : case 'î' : case 'ï' :
            return 'i';
        case 'Ò' : case 'Ô' : case 'Ó' : case 'Õ' : case 'Ö' :
            return 'O';
        case 'ò' : case 'ó' : case 'ô' : case 'õ' : case 'ö' :
            return 'o';
        case 'Ù' : case 'Ú' : case 'Û' : case 'Ü' :
            return 'U';
        case 'ù' : case 'ú' : case 'û' : case 'ü' :
            return 'u';
        case 'Ñ' :
            return 'N';
        case 'ñ' :
            return 'n';
        case 'Ý' :
            return 'Y';
        case 'ý' : case 'ÿ' :
            return 'y';
        default :
            return c;
        }
    }

    /*******************************************************************************************************
     * lowerCamelCase
     *******************************************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * Registro de versiones:<ul>
     *
     * <li>1.0 (00/00/20XX, <<autor>>): version inicial.
     * </ul>
     *
     * @param s TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public static String lowerCamelCase(String s) {

        // /* ALA
        StringBuffer sb = new StringBuffer();
        char         c;

        s = s.trim();

        boolean inWord           = false;
        boolean firstLetterWord  = true;
        boolean firstLetterIdent = true;

        for (int i = 0; i < s.length(); i++) {

            c = validLetter(s.charAt(i));

            if (firstLetterIdent && !Character.isJavaIdentifierStart(c)) {
                continue;
            }
            else {
                firstLetterIdent = false;
            }

            if (!Character.isJavaIdentifierPart(c) || c == '_') {

                inWord = false;

                firstLetterWord = true;

            } else if (!inWord) {

                if (firstLetterWord) {
                    sb.append(Character.toUpperCase(c));
                    firstLetterWord = false;
                } else {
                    sb.append(Character.toLowerCase(c));
                }

                inWord = true;

            } else {
                sb.append(Character.toLowerCase(c));
            }
        }

        return lowering(sb.toString());
        // ALA

      //return s.toUpperCase();
    }

    /*******************************************************************************************************
     * capitalize
     *******************************************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * Registro de versiones:<ul>
     *
     * <li>1.0 (00/00/20XX, <<autor>>): version inicial.
     * </ul>
     *
     * @param s TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public static String capitalize(String s) {

        // /* ALA
        if (s != null && !s.equals("")) {
            return s.substring(0, 1).toUpperCase() + s.substring(1);
        }
        // */ // ALA

        return s; // .toUpperCase()
    }

    /*******************************************************************************************************
     * lowering
     *******************************************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * Registro de versiones:<ul>
     *
     * <li>1.0 (00/00/20XX, <<autor>>): version inicial.
     * </ul>
     *
     * @param s TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public static String lowering(String s) {

        // /* ALA
        if (s != null && !s.equals("")) {
            return s.substring(0, 1).toLowerCase() + s.substring(1);
        }
        // */ // ALA

        return s; // .toUpperCase()
    }

    /*******************************************************************************************************
     * getPathFromPackage
     *******************************************************************************************************/
    /**
     *
     * @param package_name TODO_javadoc
     *
     * @return TODO_javadoc
     *
     */
    /*
    public static String getPathFromPackage(String package_name) {
        return package_name.replace('.', File.separatorChar);
    }
    */

    /*******************************************************************************************************
     * searchIntInArray
     *******************************************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param elem TODO_javadoc.
     * @param array TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public static int searchIntInArray(int elem, int[] array) {

        for (int i = 0; i < array.length; i++) {

            if (elem == array[i]) {
                return i;
            }
        }

        return -1;
    }

    /*******************************************************************************************************
     * printStackTrace
     *******************************************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * Registro de versiones:<ul>
     *
     * <li>1.0 (00/00/20XX, <<autor>>): version inicial.
     * </ul>
     *
     * @param  TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public static String printStackTrace(Throwable e) {

        CharArrayWriter caw = new CharArrayWriter();
        e.printStackTrace(new PrintWriter(caw));

        return caw.toString();
    }
}
