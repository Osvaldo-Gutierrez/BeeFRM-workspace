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

import org.apache.log4j.*;


/**
 *
 * TODO_javadoc.
 *
 * @version 1.0 (01/01/2016).
 *
 */
public class PicDesc implements Serializable  {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(PicDesc.class);

    /** TODO_javadoc. */
    public static final String[] typesNames = { "", "INTEGER", "LONG", "DOUBLE", "STRING" };

    /** TODO_javadoc. */
    public static Pattern[] patterns = { Pattern.compile("^[XB]+$",                                     Pattern.CASE_INSENSITIVE),
                                         Pattern.compile("^([S\\-+]?[9X]+)?([\\.V]9+)?$",               Pattern.CASE_INSENSITIVE),
                                         Pattern.compile("^([\\-+])?Z+9*(V[9Z]+)?$",                    Pattern.CASE_INSENSITIVE),
                                         Pattern.compile("^-+9*([\\.,V][\\-9]+)?$",                     Pattern.CASE_INSENSITIVE),
                                         Pattern.compile("^[\\-+$9ZB0*]+([\\.,/][\\-+$9ZB0*]+)*(CR)?$", Pattern.CASE_INSENSITIVE) };

    /** TODO_javadoc. */
    public static final int UNDEF    = -1;

    /** TODO_javadoc. */
    public static final int INTEGER  = 1;

    /** TODO_javadoc. */
    public static final int LONG   = 2;

    /** TODO_javadoc. */
    public static final int DOUBLE  = 3;

    /** TODO_javadoc. */
    public static final int STRING   = 4;

    //

    /** TODO_javadoc. */
    public int type = UNDEF;

    /** TODO_javadoc. */
    public int length = 0;

    /** TODO_javadoc. */
    public int ints = 0;

    /** TODO_javadoc. */
    public int decs = 0;

    /** TODO_javadoc. */
    public boolean sign = false;

    /******************************************************************************
     * PicDesc
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param type TODO_javadoc.
     * @param ints TODO_javadoc.
     * @param decs TODO_javadoc.
     * @param length TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public PicDesc(int type, int ints, int decs, int length, boolean sign) {

        this.type   = type;
        this.ints   = ints;
        this.decs   = decs;
        this.length = length;
        this.sign   = sign;
    }

    /******************************************************************************
     * extendPicture
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param s TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public static String extendPicture(String s) {

        int  stateAnt;
        int  state = 0;
        char rep   = (char) 0;

        //

        StringBuffer sb  = new StringBuffer();
        StringBuffer num = new StringBuffer();

        for (int i = 0; i < s.length(); i++) {

            stateAnt = state;
            state    = nextState_extendPicture(stateAnt, s.charAt(i));

            switch (state) {

            case 0 :

                switch (stateAnt) {

                case 0 : // continuamos agregando

                    sb.append(rep = s.charAt(i)); // puede ser el repetible

                    break;

                case 1 : // volvemos de un \([0-9]+\)

                    for (int j = 0; j < Integer.parseInt(num.toString()) - 1; j++) {
                        sb.append(rep);
                    }

                    break;
                }

                break;

            case 1 :

                switch (stateAnt) {

                case 0 : // pasamos a un \([0-9]+\)

                    num.setLength(0); // preparamos acum numero

                    break;

                case 1 :

                    num.append(s.charAt(i)); // agregamos digito

                    break;
                }

                break;
            }
        }

        return sb.toString();
    }

    /******************************************************************************
     * nextState_extendPicture
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param state TODO_javadoc.
     * @param b TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private static int nextState_extendPicture(int state, char c) {

        switch (state) {

        case 0 :
            return c == '(' ? 1 : 0;
        case 1 :
            return c == ')' ? 0 : 1;
        }

        throw new RuntimeException("nextState:: {" + state + "," + Character.toString(c)+ "} --> ??");
    }

    /******************************************************************************
     * getInfoFromPattern
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param s TODO_javadoc.
     * @param which TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public static PicDesc getInfoFromPattern(String s, int which) {

        int     type    = UNDEF;
        int     ints    = 0;
        int     decs    = 0;
        int     length  = 0;
        boolean sign    = false;
        int     pos;

        //

        Matcher matcher = patterns[which].matcher(s);

        if (!matcher.find()) {
            throw new RuntimeException(s + " no match con " + patterns[which].pattern());
        }

        //

        switch (which) {

        /*-----------------------------------------------------------------------------
         * [XB]+
         -----------------------------------------------------------------------------*/

        case 0 :

            type   = STRING;
            length = s.length();

            return new PicDesc(type, ints, decs, length, sign);

        /*-----------------------------------------------------------------------------
         * ([S\-+]?[9X]+)?([\.V]9+)?
         -----------------------------------------------------------------------------*/

        case 1 :

            if      (matcher.group(1) != null && matcher.group(2) == null) { // no existe ([\.V]9+)?

                if (matcher.group(1).indexOf('X') > -1) {

                    type   = STRING;
                    length = s.length();
                }
                else {

                    ints = s.length();

                    if (s.charAt(0) == 'S' || s.charAt(0) == '-' ||s.charAt(0) == '+') {

                        sign = true;
                        ints--;
                    }

                    if (ints < 10) {
                        type = INTEGER;
                    }
                    else {
                        type = LONG;
                    }

                    length = ints;
                }
            }
            else if (matcher.group(1) == null && matcher.group(2) != null) { // no existe ([S\-+]?[9X]+)?

                type   = DOUBLE;
                ints   = 0;
                decs   = matcher.end(2) - matcher.start(2) - 1;
                length = ints + decs;
            }
            else {

                if (s.indexOf('X') > -1) {

                    type   = STRING;
                    length = s.length();
                }
                else {

                    ints = matcher.end(1) - matcher.start(1);
                    decs = matcher.end(2) - matcher.start(2) - 1;

                    if (s.charAt(0) == 'S' || s.charAt(0) == '-' ||s.charAt(0) == '+') {

                        sign = true;
                        ints--;
                    }

                    type = DOUBLE;

                    length = ints + decs;
                }
            }

            return new PicDesc(type, ints, decs, length, sign);

        /*-----------------------------------------------------------------------------
         * ([\-+])?Z+9*(V[9Z]+)?
         -----------------------------------------------------------------------------*/

        case 2 :

            if (matcher.group(2) == null) { // no existe (V[9Z]+)?

                ints = s.length();

                if (s.charAt(0) == '-' ||s.charAt(0) == '+') {

                    sign = true;
                    ints--;
                }

                if (ints < 10) {
                    type = INTEGER;
                }
                else {
                    type = LONG;
                }
            }
            else {

                type = DOUBLE;

                ints = s.length();

                if (s.charAt(0) == '-' ||s.charAt(0) == '+') {

                    sign = true;
                    ints--;
                }

                decs = matcher.end(1) - matcher.start(1) - 1;
            }

            length = ints + decs;

            return new PicDesc(type, ints, decs, length, sign);

        /*-----------------------------------------------------------------------------
         * -+9*([\.,V][\-9]+)?
         -----------------------------------------------------------------------------*/

        case 3 :

            if (matcher.group(1) == null) { // no existe ([\.,V][\-9]+)?

                ints = s.length();

                if (ints < 10) {
                    type = INTEGER;
                }
                else {
                    type = LONG;
                }
            }
            else {

                type = DOUBLE;
                ints = matcher.start(1);
                decs = matcher.end(1) - matcher.start(1) - 1;
            }

            length = ints + decs;

            return new PicDesc(type, ints, decs, length, sign);

        /*-----------------------------------------------------------------------------
         * [\-+$9ZB0*]+([\.,/][\-+$9ZB0*]+)*(CR)?
         -----------------------------------------------------------------------------*/

        case 4 :

            int limit = s.length();

            if (matcher.group(2) != null) {

                 limit = matcher.start(2);
                 sign  = true;
             }

            int  count_dots   = countChar(s, '.');
            int  count_commas = countChar(s, ',');
            char last         = whichLast(s, new char[] { ','/*44*/, '.'/*46*/} /* ordenado */);

            switch (last) {

            case '.' :

                if        (count_commas == 0 && count_dots == 1) { // Z.ZZZ

                    pos  = s.indexOf(last);
                    ints = pos;
                    decs = limit - pos - 1;

                    type = DOUBLE;

                } else if (count_commas == 0 && count_dots >  1) { // 99.999.999

                    ints = countDiffChars(s, new char[] { '.' });

                    if (ints < 10) {
                        type = INTEGER;
                    }
                    else {
                        type = LONG;
                    }

                } else if (count_commas >  0 && count_dots == 1) { // ZZ,ZZZ,ZZZ,ZZ9.9999

                    pos  = s.indexOf(last);
                    ints = countDiffChars(s.substring(0, pos), new char[] { ',' });
                    decs = limit - pos - 1;

                    type = DOUBLE;

                } else {
                    throw new RuntimeException("getInfoFromPattern:: verificar [" + s + "] --> count_dots: " + count_dots + ", count_commas: " + count_commas + ", last: " + Character.toString(last));
                }

                break;

            case ',' :

                if        (count_dots == 0 && count_commas == 1) { // Z9,99

                    pos  = s.indexOf(last);
                    ints = pos;
                    decs = limit - pos - 1;

                    type = DOUBLE;

                } else if (count_dots == 0 && count_commas >  1) { // ZZ,ZZZ,ZZ9

                    ints = countDiffChars(s, new char[] { ',' });

                    if (ints < 10) {
                        type = INTEGER;
                    }
                    else {
                        type = LONG;
                    }

                } else if (count_dots >  0 && count_commas == 1) { // ZZ.ZZZ.ZZZ.ZZ9,99

                    pos  = s.indexOf(last);
                    ints = countDiffChars(s.substring(0, pos), new char[] { '.' });
                    decs = limit - pos - 1;

                    type = DOUBLE;

                } else {
                    throw new RuntimeException("getInfoFromPattern:: verificar [" + s + "] --> count_dots: " + count_dots + ", count_commas: " + count_commas + ", last: " + Character.toString(last));
                }

                break;
            }

            length = ints + decs;

            return new PicDesc(type, ints, decs, length, sign);
        }

        throw new RuntimeException("getInfoFromPattern:: case " + which + " no encontrado.");
    }

    /******************************************************************************
     * countChar
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param s TODO_javadoc.
     * @param c TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private static int countChar(String s, char c) {

        int cant = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == c) {
                cant++;
            }
        }

        return cant;
    }

    /******************************************************************************
     * whichLast
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param s TODO_javadoc.
     * @param chars TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private static char whichLast(String s, char[] chars) {

        char last = (char) 0;

        for (int i = 0; i < s.length(); i++) {

            if (Arrays.binarySearch(chars, s.charAt(i)) >= 0) {
                last = s.charAt(i);
            }
        }

        return last;
    }

    /******************************************************************************
     * countDiffChars
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param s TODO_javadoc.
     * @param chars TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private static int countDiffChars(String s, char[] chars) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            if (Arrays.binarySearch(chars, s.charAt(i)) < 0) {
                count++;
            }
        }

        return count;
    }

    /******************************************************************************
     * toString
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String toString() {

        String s = "";

        s += "[type : " + (type == UNDEF ? "UNDEF" : typesNames[type]) + "]";
        s += "[length : " + length + "]";
        s += "[ints : " + ints + "]";
        s += "[decs : " + decs + "]";
        s += "[sign : " + sign + "]";

        return s;
    }

}
