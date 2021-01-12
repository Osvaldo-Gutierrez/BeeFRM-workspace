
package cl.bee.perseus.cobolparser.util;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.log4j.Logger;


/**
 *
 * Clase que extiende <code>FileInputStream</code> utilizada para unir
 * string con saltos de línea.
 *
 * Registro de versiones:<ul>
 *
 * <li>1.0 (01/01/2016, Agustin Larrea A. (BEE S.A.)): versión inicial.
 * </ul>
 *
 * <b>Todos los derechos reservados por Banco de Crédito e Inversiones.</b>
 *
 */
public class LineFeedInQuotedStream extends FileInputStream {

    /** Logger de LOG4J asociado a la clase. */
    private static Logger logger = Logger.getLogger(LineFeedInQuotedStream.class);

    /** <code>ByteArrayInputStream</code> intermedio para acumular fuente. */
    private ByteArrayInputStream bais = null;

    /******************************************************************************
     * LineFeedInQuotedStream
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
    public LineFeedInQuotedStream(String name) throws FileNotFoundException {

        super(name);

        // logger.debug("entrando a '<init>(" + name + ")' ...");

        try {

            InputStreamReader     fpIn = new InputStreamReader(new DeleteRemarksStream(name));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int                   n;
            int                   stateAnt;
            int                   state  = 0;
            ArrayList<Byte>       buffer = null;

            n = fpIn.read();

            while (n != -1) {

                stateAnt = state;
                state    = nextState(stateAnt, (byte) n);

                //

                switch (state) {

                case 0 :

                    switch (stateAnt) {

                    case 9 :     // termino un string
                    case 0 :     // esta fuera de un string
                    case 1 :     // saliendo de un string

                        baos.write(n);

                        break;
                    }

                    break;

                case 1 :

                    switch (stateAnt) {

                    case 10 :    // asumiremos que - en la 7ma pos no es un valor binario

                        for (int i = 0; i < buffer.size(); i++) {

                            byte b = buffer.get(i).byteValue();

                            // logger.debug("write from BUFFER stateAnt: " + stateAnt
                            // + " state: " + state + " " + toHex(b) + " (" + (char) b + ")");

                            baos.write(b);
                        }

                    // break;

                    case 0 :    // entro a un string
                    case 1 :    // dentro de string (sin linefeed)
                        baos.write(n);

                        break;
                    }

                    break;

                case 2 :

                    if (buffer == null || buffer.size() != 1 || buffer.get(0).byteValue() != 0x0D) {
                        buffer = new ArrayList<Byte>();
                    }

                // break;

                case 3 :
                case 4 :
                case 5 :
                case 6 :
                case 7 :
                case 8 :

                    // logger.debug("AGREGADO al BUFFER " + toHex((byte) n) + " (" + (char) n + ")");

                    buffer.add(new Byte((byte) n));

                    break;

                case 9 :

                    switch (stateAnt) {

                    case 8 :
                        buffer.add(new Byte((byte) n));

                    // break;

                    case 10 :    // asumimos binarios

                        for (int i = 0; i < buffer.size(); i++) {

                            byte b = buffer.get(i).byteValue() == 0x0D || buffer.get(i).byteValue() == 0x0A ? (byte) 0x20 : buffer.get(i).byteValue();

                            // logger.debug("write from BUFFER stateAnt: " + stateAnt
                            //              + " state: " + state + " " + toHex(b) + " (" + (char) b + ")");

                            baos.write(b);
                        }

                        break;

                    case 9 :

                        byte b = (byte) (n == 0x0D || n == 0x0A ? (byte) 0x20 : n);

                        // logger.debug("WRITE stateAnt: " + stateAnt + " state: "
                        //               + state + " " + toHex(b) + " (" + (char) b + ")");

                        baos.write(b);

                        break;

                    case 18 :

                        throw new FileNotFoundException("no deberia llegar desde el estado 18 al 9. [" + new String(baos.toByteArray()) + "]");
                    }

                    break;

                case 10 :

                    switch (stateAnt) {

                    case 8 :     // viene de encontrar '-'
                    case 10 :    // '\t' y blancos despues de '-'

                        // logger.debug("AGREGADO al BUFFER " + toHex((byte) n) + " (" + (char) n + ")");

                        buffer.add(new Byte((byte) n));

                        break;

                    case 18 :
                        break;
                    }

                    break;

                case 11 :
                case 12 :
                case 13 :
                case 14 :
                case 15 :
                case 16 :
                case 17 :
                case 18 :
                    break;
                }

                n = fpIn.read();
            }

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

    /******************************************************************************
     * nextState
     ******************************************************************************/
    /**
     *
     * Método que permite navegar por el AFD para determinar el siguiente
     * estado del autómata dada una entrada.
     *
     * @param state Estado enterior.
     * @param b Entrada (caracter).
     *
     * @return Próximo estado al cual saltar.
     *
     * @since 1.0
     *
     */
    private static int nextState(int state, byte b) {

        switch (state) {

        case 0 :

            switch (b) {

            case 0x27 :    // '
                return 1;

            default :
                return 0;
            }

        case 1 : // INSTRING

            switch (b) {

            case 0x0D :    // \n
            case 0x0A :    // \n

                return 2;

            case 0x27 :    // '
                return 0;

            default :
                return 1;
            }

        case 2 : // NEWLINE

            switch (b) {

            case 0x0D :    // \n
            case 0x0A :    // \n

                return 2;

            default :
                return 3;
            }

        case 3 :
        case 4 :
        case 5 :
        case 6 :
        case 7 :

            return state + 1;

        case 8 :

            switch (b) {

            case 0x2D :    // -

                return 10;

            case 0x2A :    // *

                return 11;

            default :

                return 9;
            }

        case 9 :

            switch (b) {

            case 0x27 :    // '
                return 0;

            default :
                return 9;
            }

        case 10 :

            switch (b) {

            case 0x09 :    // \t
            case 0x20 :    // [ ]
                return 10;

            case 0x27 :    // '

                return 1;

            default :
                return 9;
            }

        case 11 :

            switch (b) {

            case 0x0D :    // \n
            case 0x0A :    // \n

                return 12;

            default :
                return 11;
            }

        case 12 :

            switch (b) {

            case 0x0D :    // \n
            case 0x0A :    // \n

                return 12;

            default :
                return 13;
            }

        case 13 :
        case 14 :
        case 15 :
        case 16 :
        case 17 :

            return state + 1;

        case 18 :

            switch (b) {

            case 0x2D :    // -
                return 10;

            case 0x2A :    // *
                return 11;

            default :
                return 9;
            }

        default :
            return 0;
        }
    }

    /******************************************************************************
     * toHex
     ******************************************************************************/
    /**
     *
     * Permite escribir un <code>byte</code> en formato hexadecimal para hacer
     * debuging.
     *
     * @param b <code>byte</code> a considerar.
     *
     * @return String con el Hexadecimal.
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
