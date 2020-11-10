/*
 *   Todos los derechos reservados por Banco de Crédito e Inversiones.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BCI
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.genfrmjava.util;


import java.util.*;


/**
 *
 * TODO_javadoc.
 *
 * Registro de versiones:<ul>
 *
 * <li>1.0 (v21/12/2005, <<autor>>): versión inicial.
 * </ul>
 *
 */
public class PositionDef {

    /** TODO_javadoc. */
    public int row;

    /** TODO_javadoc. */
    public int column;

    /******************************************************************************
     * PositionDef
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * Registro de versiones:<ul>
     *
     * <li>1.0 (v21/12/2005, <<autor>>): versión inicial.
     * </ul>
     *
     * @since 1.0
     *
     */
    public PositionDef() {}

    /******************************************************************************
     * PositionDef
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * Registro de versiones:<ul>
     *
     * <li>1.0 (v21/12/2005, <<autor>>): versión inicial.
     * </ul>
     *
     * @param row TODO_javadoc.
     * @param column TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public PositionDef(int row, int column) {

        this.row    = row;
        this.column = column;
    }

    /******************************************************************************
     * toString
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * Registro de versiones:<ul>
     *
     * <li>1.0 (v21/12/2005, <<autor>>): versión inicial.
     * </ul>
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public String toString() {

        StringBuffer sb = new StringBuffer();

        sb.append("[row : " + Integer.toString(row) + "]");
        sb.append("[column : " + Integer.toString(column) + "]");

        return sb.toString();
    }
}
