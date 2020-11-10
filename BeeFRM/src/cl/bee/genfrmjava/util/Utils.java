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
        case '�' : case '�' : case '�' : case '�' : case '�' : case '�' :
            return 'A';
        case '�' : case '�' : case '�' : case '�' : case '�' : case '�' :
            return 'a';
        case '�' : case '�' : case '�' : case '�' :
            return 'e';
        case '�' : case '�' : case '�' : case '�' :
            return 'E';
        case '�' : case '�' : case '�' : case '�' :
            return 'I';
        case '�' : case '�' : case '�' : case '�' :
            return 'i';
        case '�' : case '�' : case '�' : case '�' : case '�' :
            return 'O';
        case '�' : case '�' : case '�' : case '�' : case '�' :
            return 'o';
        case '�' : case '�' : case '�' : case '�' :
            return 'U';
        case '�' : case '�' : case '�' : case '�' :
            return 'u';
        case '�' :
            return 'N';
        case '�' :
            return 'n';
        case '�' :
            return 'Y';
        case '�' : case '�' :
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
