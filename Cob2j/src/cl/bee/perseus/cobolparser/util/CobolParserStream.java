/*
 *   Copyright (c) 2017 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.perseus.cobolparser.util;


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
public class CobolParserStream extends FileInputStream {

    /** TODO_javadoc. */
    private static final String SPACES = "                                                                                                                                                                                                                                                                ";

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(CobolParserStream.class);

    /** TODO_javadoc. */
    private static Pattern pcomment = null;

    /** TODO_javadoc. */
    private static final int AREASIZE = 6;

    /** TODO_javadoc. */
    private ByteArrayInputStream bais = null;

    /** TODO_javadoc. */
    private ArrayList<Integer> linesExt = new ArrayList<Integer>();

    /******************************************************************************
     * CobolParserStream
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
    public CobolParserStream(String name) throws FileNotFoundException {

        super(name);

      //logger.debug("entrando a '<init>(" + name + ")' ...");

        pcomment = Pattern.compile("^.{" + AREASIZE + "}\\*");

        try {

            BufferedReader fp_in = null;

            QuotedLineFeedStream qlfs = new QuotedLineFeedStream(name);

            linesExt = qlfs.getLinesExt();

            fp_in = new BufferedReader(new InputStreamReader(qlfs));

            ByteArrayOutputStream baos    = new ByteArrayOutputStream();
            PrintStream           fp_out   = new PrintStream(baos);
            String                line    = null;
            String                aux     = null;
            Matcher               matcher = null;

            line = fp_in.readLine();

            while (line != null) {

              //logger.debug("[" + line + "]");

                matcher = pcomment.matcher(line);

                if (matcher.find()) {

                    if (matcher.end() == line.length()) {
                        aux = line.substring(0, matcher.end()) + ">";
                    }
                    else {
                        aux = line.substring(0, matcher.end()) + ">" + line.substring(matcher.end());
                    }

                    fp_out.println(aux);

                  //logger.debug("[" + aux + "]");
                }
                else {

                    fp_out.println(line);

                  //logger.debug("[" + line + "]");
                }

                line = fp_in.readLine();
            }

            fp_in.close();
            fp_out.close();

            /*
            FileOutputStream fos = new FileOutputStream(name + ".ext");
            fos.write(baos.toByteArray());
            fos.close();
            */

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
}
