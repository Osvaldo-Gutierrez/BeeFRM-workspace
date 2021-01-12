/*
 *   Copyright (c) 2017 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.perseus.cobolparser.util;


import java.io.*;

import java.util.*;

import org.apache.log4j.*;


/**
 *
 * TODO_javadoc.
 *
 * @version 1.0 (01/01/2016).
 *
 */
public class QuotedLineFeedStream extends FileInputStream {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(QuotedLineFeedStream.class);

    /** TODO_javadoc. */
    private ByteArrayInputStream bais = null;

    /** TODO_javadoc. */
    private int lineNum = 0;

    /** TODO_javadoc. */
    private ArrayList<Integer> linesExt = new ArrayList<Integer>();

    /******************************************************************************
     * QuotedLineFeedStream
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param name TODO_javadoc.
     *
     * @throws FileNotFoundException TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public QuotedLineFeedStream(String name) throws FileNotFoundException {

        super(name);

        // logger.debug("entrando a '<init>(" + name + ")' ...");

        try {

            InputStreamReader     fp_in = new InputStreamReader(new ValidLineStream(name));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int                   n;
            int                   stateAnt;
            int                   state = 0;

            n = fp_in.read();

            while (n != -1) {

                stateAnt = state;
                state    = nextState(stateAnt, (byte) n);

                if (n == 0x0A) {
                    lineNum++;
                }

                //

                switch (state) {

                /******************************************************************************
                 *
                 ******************************************************************************/

                case 0 :

                    switch (stateAnt) {

                    case 9 :     // termino un string
                    case 0 :     // esta fuera de un string
                    case 1 :     // saliendo de un string

                        baos.write(n);

                        break;
                    }

                    break;

                /******************************************************************************
                 *
                 ******************************************************************************/

                case 1 :

                    switch (stateAnt) {

                    case 10 :    // asumiremos que - en la 7ma pos no es un valor binario
                        break;

                    case 0 :     // entro a un string
                    case 1 :     // dentro de string (sin linefeed)

                        baos.write(n);

                        break;
                    }

                    break;

                /******************************************************************************
                 *
                 ******************************************************************************/

                case 2 :
                case 3 :
                case 4 :
                case 5 :
                case 6 :
                case 7 :
                case 8 :
                    break;

                /******************************************************************************
                 *
                 ******************************************************************************/

                case 9 :

                    switch (stateAnt) {

                    case 8 :
                    case 10 :
                    case 9 :

                        byte b = (byte) n;

                        // logger.debug("WRITE stateAnt: " + stateAnt + " state: " + state + " " + toHex(b) + " (" + (char) b + ")");

                        baos.write(b);

                        break;
                    }

                    break;

                /******************************************************************************
                 *
                 ******************************************************************************/

                case 10 :

                    if (stateAnt == 8) {

                        linesExt.add(new Integer(lineNum));

                        lineNum++;

                      //logger.debug("un string extendido en linea " + lineNum);
                    }

                    break;
                }

                n = fp_in.read();
            }

            bais = new ByteArrayInputStream(baos.toByteArray());

            // logger.debug("saliendo de '<init>(" + name + ")' ...");
        }
        catch (Exception e) {
            throw new FileNotFoundException(e.toString());
        }
    }

    /******************************************************************************
     * getLinesExt
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
    public ArrayList<Integer> getLinesExt() {
        return linesExt;
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
    public int read(byte[] b, int offset, int len) throws IOException {
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
    public int read(byte[] b) throws IOException {
        return bais.read(b, 0, b.length);
    }

    /******************************************************************************
     * nextState
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
     * @since 1.0
     *
     */
    private static int nextState(int state, byte b) {

        switch (state) {

        /******************************************************************************
         *
         ******************************************************************************/

        case 0 :

            switch (b) {

            case (byte) '\'' :
                return 1;

            default :
                return 0;
            }

        /******************************************************************************
         *
         ******************************************************************************/

        case 1 :

            switch (b) {

            case 0x0D : case 0x0A :
                return 2;

            case (byte) '\'' :
                return 0;

            default :
                return 1;
            }

        /******************************************************************************
         *
         ******************************************************************************/

        case 2 :

            switch (b) {

            case 0x0D : case 0x0A :
                return 2;

            default :
                return 3;
            }

        /******************************************************************************
         *
         ******************************************************************************/

        case 3 :
        case 4 :
        case 5 :
        case 6 :
        case 7 :
            return state + 1;

        /******************************************************************************
         *
         ******************************************************************************/

        case 8 :

            switch (b) {

            case (byte) '-' :
                return 10;

            default :
                return 9;
            }

        /******************************************************************************
         *
         ******************************************************************************/

        case 9 :

            switch (b) {

            case (byte) '\'' :
                return 0;

            default :
                return 9;
            }

        /******************************************************************************
         *
         ******************************************************************************/

        case 10 :

            switch (b) {

            case (byte) '\t' :
            case (byte) ' ' :
                return 10;

            case (byte) '\'' :
                return 1;

            default :
                return 9;
            }

        /******************************************************************************
         *
         ******************************************************************************/

        default :
            return 0;
        }
    }

    /******************************************************************************
     * toHex
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param b TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public static String toHex(byte b) {

        StringBuffer sb = new StringBuffer();

        sb.append(Character.forDigit((char) (b >> 4) & 0x000F, 16));
        sb.append(Character.forDigit((char) (b & 0x000F), 16));

        return "0x" + sb.toString().toUpperCase();
    }
}
