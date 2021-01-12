
package cl.bee.perseus.cobolparser.util;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;


/**
 *
 * Clase que extiende <code>FileInputStream</code> que cambia en las l�neas de comentarios
 * las comillas simples por dobles.
 *
 * Registro de versiones:<ul>
 *
 * <li>1.0 (01/01/2016, Agustin Larrea A. (BEE S.A.)): versi�n inicial.
 * </ul>
 *
 * <b>Todos los derechos reservados por Banco de Cr�dito e Inversiones.</b>
 *
 */
public class QuoteInCommentStream extends FileInputStream {

    /** Espacios en blanco para formatear fuente. */
    private static final String SPACES = "                                                                      "
        + "                                                                                                     "
        + "                                                                                                     "
        + "                                                                                                     ";

    /** Logger de LOG4J asociado a la clase. */
    private static Logger logger = Logger.getLogger(QuoteInCommentStream.class);

    /** Patron regex reconoce comentarios Cobol. */
    private static Pattern pcomment = null;

    /** Largo area sangr�a fuente Cobol. */
    private static final int AREASIZE = 6;

    /** <code>ByteArrayInputStream</code> intermedio para acumular fuente. */
    private ByteArrayInputStream bais = null;

    /******************************************************************************
     * QuoteInCommentStream
     ******************************************************************************/
    /**
     *
     * Constructor que lee el archivo de origen y prepara el <code>ByteArrayInputStream</code>
     * para ser leido en la cadena de Streams por el siguiente <code>FileInputStream</code>.
     *
     * @param name Nombre del archivo.
     *
     * @throws FileNotFoundException En el caso de no encontrar archivo de origen.
     *
     * @since 1.0
     *
     */
    public QuoteInCommentStream(String name) throws FileNotFoundException {

        super(name);

        // logger.debug("entrando a '<init>(" + name + ")' ...");

        pcomment = Pattern.compile("^.{" + AREASIZE + "}\\*");

        try {

            BufferedReader        fpIn    = new BufferedReader(new InputStreamReader(new FileInputStream(name)));
            ByteArrayOutputStream baos    = new ByteArrayOutputStream();
            PrintStream           fpOut   = new PrintStream(baos);
            String                line    = null;
            Matcher               matcher = null;
            StringBuffer          sb      = null;

            line = fpIn.readLine();

            while (line != null) {

                matcher = pcomment.matcher(line);

                if (matcher.find()) {

                    sb = new StringBuffer();

                    for (int i = 0; i < line.length(); i++) {
                        sb.append(line.charAt(i) == '\'' ? '"' : line.charAt(i));
                    }

                    fpOut.println(sb.toString());

                    // logger.debug("[" + sb.toString() + "]");
                }
                else {

                    fpOut.println(line);

                    // logger.debug("[" + line + "]");
                }

                line = fpIn.readLine();
            }

            fpIn.close();
            fpOut.close();

            bais = new ByteArrayInputStream(baos.toByteArray());

            // logger.debug("saliendo de '<init>(" + name + ")' ...");

        }
        catch (Exception e) {
            throw new FileNotFoundException(e.toString());
        }
    }

    /******************************************************************************
     * read
     ******************************************************************************/
    /**
     *
     * Reads a byte of data from this input stream. This method blocks
     * if no input is yet available.
     *
     * @return     the next byte of data, or <code>-1</code> if the end of the
     *             file is reached.
     *
     * @throws IOException if an I/O error occurs.
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
     * Reads a subarray as a sequence of bytes.
     *
     * @param b the data to be written.
     * @param offset the start offset in the data.
     * @param len the number of bytes that are written.
     *
     * @return     the total number of bytes read into the buffer, or
     *             <code>-1</code> if there is no more data because the end of
     *             the file has been reached.
     *
     * @throws IOException If an I/O error has occurred.
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
     * Reads up to <code>b.length</code> bytes of data from this input
     * stream into an array of bytes. This method blocks until some input
     * is available.
     *
     * @param      b   the buffer into which the data is read.
     *
     * @return     the total number of bytes read into the buffer, or
     *             <code>-1</code> if there is no more data because the end of
     *             the file has been reached.
     *
     * @throws IOException  if an I/O error occurs.
     *
     * @since 1.0
     *
     */
    public int read(byte[] b) throws IOException {
        return bais.read(b, 0, b.length);
    }
}