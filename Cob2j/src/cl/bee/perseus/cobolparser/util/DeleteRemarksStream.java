
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
 * Clase que extiende <code>FileInputStream</code> que borra el bloque REMARKS.
 *
 * Registro de versiones:<ul>
 *
 * <li>1.0 (01/01/2016, Agustin Larrea A. (BEE S.A.)): versión inicial.
 * </ul>
 *
 * <b>Todos los derechos reservados por Banco de Crédito e Inversiones.</b>
 *
 */
public class DeleteRemarksStream extends FileInputStream {

    /** Logger de LOG4J asociado a la clase. */
    private static Logger logger = Logger.getLogger(DeleteRemarksStream.class);

    /** <code>ByteArrayInputStream</code> intermedio para acumular fuente. */
    private ByteArrayInputStream bais = null;

    /******************************************************************************
     * DeleteRemarksStream
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
    public DeleteRemarksStream(String name) throws FileNotFoundException {

        super(name);

      //logger.debug("entrando a '<init>(" + name + ")' ...");

        try {

            InputStreamReader     fpIn = new InputStreamReader(new QuoteInCommentStream(name));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int                   n;
            int                   stateAnt;
            int                   state  = 0;
            ArrayList<Byte>       buffer = null;

            n = fpIn.read();

            while (n != -1) {

                stateAnt = state;
                state    = nextState(stateAnt, (byte) n);

              //logger.debug("stateAnt: " + stateAnt + " ch: " + (n < 32 ? toHex((byte) n) : (char) n) + " --> state: " + state);

                switch (state) {

                case 0 :
                    switch (stateAnt) {

                    case 1 :
                    case 2 :
                    case 3 :
                    case 4 :
                    case 5 :
                    case 6 :
                    case 7 :
                        for (int i = 0; i < buffer.size(); i++) {

                            byte b = buffer.get(i).byteValue();

                    //logger.debug("write from BUFFER stateAnt: " + stateAnt + " state: " + state + " " + toHex(b) + " (" + (char) b + ")");

                            baos.write(b);
                        }

                        break;
                    }

                    //

                  //logger.debug("write stateAnt: " + stateAnt + " state: " + state + " " + toHex((byte) n) + " (" + (char) n + ")");

                    baos.write(n);

                    break;

                case 1 :

                    buffer = new ArrayList<Byte>();

                // break;

                case 2 :
                case 3 :
                case 4 :
                case 5 :
                case 6 :
                case 7 :
                case 8 :
                case 9 :
                case 10 :
                case 11 :
                case 12 :
                case 13 :
                case 14 :
                case 15 :

                    buffer.add(new Byte((byte) n));

                    break;

                case 28 :

                  //logger.debug("write stateAnt: " + stateAnt + " state: " + state + " " + "       ENVIRONMENT ");

                    baos.write("       ENVIRONMENT ".getBytes());

                    break;

                default :
                    break;
                }

                n = fpIn.read();
            }

            bais = new ByteArrayInputStream(baos.toByteArray());

          //logger.debug("saliendo de '<init>(" + name + ")' ...");

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
     * @param b Entrada (carar).
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

            case 0x0D :    // \n
            case 0x0A :    // \n
                return 0;

            default :
                return 1;
            }
        case 1 :
        case 2 :
        case 3 :
        case 4 :
        case 5 :
            switch (b) {

            case 0x0D :    // \n
            case 0x0A :    // \n
                return 0;

            default :
                return state + 1;
            }
        case 6 :
            switch (b) {

            case (byte) ' ' :
                return 7;

            default :
                return 0;
            }
        case 7 :
            switch (b) {

            case (byte) 'R' :
                return 8;

            case 0x0D :    // \n
            case 0x0A :    // \n
                return 0;

            default :
                return 7;
            }
        case 8 :
            switch (b) {

            case (byte) 'E' :
                return 9;

            default :
                return 7;
            }
        case 9 :
            switch (b) {

            case (byte) 'M' :
                return 10;

            default :
                return 7;
            }
        case 10 :
            switch (b) {

            case (byte) 'A' :
                return 11;

            default :
                return 7;
            }
        case 11 :
            switch (b) {

            case (byte) 'R' :
                return 12;

            default :
                return 7;
            }
        case 12 :
            switch (b) {

            case (byte) 'K' :
                return 13;

            default :
                return 7;
            }
        case 13 :
            switch (b) {

            case (byte) 'S' :
                return 14;

            default :
                return 7;
            }
        case 14 :
            switch (b) {

            case (byte) '.' :
                return 15;

            default :
                return 7; 
            }
        case 15 :
            switch (b) {

            case (byte) ' ' :
            case (byte) '\t' :
            case 0x0D : // \n
            case 0x0A : // \n
                return 16;

            default :
                return 7;
            }
        case 16 :
            switch (b) {

            case (byte) 'E' :
                return 17;

            default :
                return 16;
            }
        case 17 :
            switch (b) {

            case (byte) 'N' :
                return 18;

            default :
                return 16;
            }
        case 18 :
            switch (b) {

            case (byte) 'V' :
                return 19;

            default :
                return 16;
            }
        case 19 :
            switch (b) {

            case (byte) 'I' :
                return 20;

            default :
                return 16;
            }
        case 20 :
            switch (b) {

            case (byte) 'R' :
                return 21;

            default :
                return 16;
            }
        case 21 :
            switch (b) {

            case (byte) 'O' :
                return 22;

            default :
                return 16;
            }
        case 22 :
            switch (b) {

            case (byte) 'N' :
                return 23;

            default :
                return 16;
            }
        case 23 :
            switch (b) {

            case (byte) 'M' :
                return 24;

            default :
                return 16;
            }
        case 24 :
            switch (b) {

            case (byte) 'E' :
                return 25;

            default :
                return 16;
            }
        case 25 :
            switch (b) {

            case (byte) 'N' :
                return 26;

            default :
                return 16;
            }
        case 26 :
            switch (b) {

            case (byte) 'T' :
                return 27;

            default :
                return 16;
            }
        case 27 :
            switch (b) {

            case (byte) ' ' :
                return 28;

            default :
                return 16;
            }
        case 28 :
            return 0;

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

        sb.append(Character.forDigit((char) (b >> 4) & 0x000F,  16));
        sb.append(Character.forDigit((char) (b       & 0x000F), 16));

        return "0x" + sb.toString().toUpperCase();
    }
}
