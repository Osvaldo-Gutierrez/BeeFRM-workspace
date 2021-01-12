
package cl.bee.perseus.cobolparser.util;


import java.util.regex.Pattern;


/**
 *
 * Clase que representa el remplazo de cierto patron por otro (copies).
 *
 * Registro de versiones:<ul>
 *
 * <li>1.0 (01/01/2016, Agustin Larrea A. (BEE S.A.)): versión inicial.
 * </ul>
 *
 * <b>Todos los derechos reservados por Banco de Crédito e Inversiones.</b>
 *
 */
public class ReplaceDesc {

    /** Patron a buscar. */
    private String find = null;

    /** Remplazo. */
    private String replace = null;

    /** <code>Pattern</code> compilado del patron. */
    private Pattern pattern = null;

    /******************************************************************************
     * ReplaceDesc
     ******************************************************************************/
    /**
     *
     * Constructor con todos los campos.
     *
     * @param find Patron a buscar.
     * @param replace Remplazo.
     * @param pattern <code>Pattern</code> compilado del patron.
     *
     * @since 1.0
     *
     */
    public ReplaceDesc(String find, String replace, Pattern pattern) {

        this.find    = find;
        this.replace = replace;
        this.pattern = pattern;
    }

    /******************************************************************************
     * getFind
     ******************************************************************************/

    public String getFind() {
        return find;
    }

    /******************************************************************************
     * getReplace
     ******************************************************************************/

    public String getReplace() {
        return replace;
    }

    /******************************************************************************
     * getPattern
     ******************************************************************************/

   public Pattern getPattern() {
        return pattern;
    }

}
