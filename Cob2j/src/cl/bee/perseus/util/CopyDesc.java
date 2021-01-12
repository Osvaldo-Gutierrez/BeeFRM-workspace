/*
 *   Copyright (c) 2017 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.perseus.util;


import org.apache.commons.lang.builder.*;


/**
 *
 * TODO_javadoc.
 *
 * @version 1.0 (01/01/2016).
 *
 */
public class CopyDesc {

    /** TODO_javadoc. */
    private String procesoStamp = null;

    /** TODO_javadoc. */
    private String claveCopy = null;

    /** TODO_javadoc. */
    private String descripcion = null;

    /** TODO_javadoc. */
    private String fechaIngreso = null;

    /** TODO_javadoc. */
    private String fechaModificacion = null;

    /** TODO_javadoc. */
    private String autor = null;

    /** TODO_javadoc. */
    private String tipoModulo = null;

    /** TODO_javadoc. */
    private String estado;

    /******************************************************************************
     * CopyDesc
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public CopyDesc() {}

    /******************************************************************************
     * CopyDesc
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param claveCopy TODO_javadoc.
     * @param descripcion TODO_javadoc.
     * @param fechaIngreso TODO_javadoc.
     * @param fechaModificacion TODO_javadoc.
     * @param autor TODO_javadoc.
     * @param tipoModulo TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public CopyDesc(String claveCopy, String descripcion, String fechaIngreso, String fechaModificacion, String autor, String tipoModulo) {

        this.claveCopy         = claveCopy;
        this.descripcion       = descripcion;
        this.fechaIngreso      = fechaIngreso;
        this.fechaModificacion = fechaModificacion;
        this.autor             = autor;
        this.tipoModulo        = tipoModulo;
    }

    /******************************************************************************
     * getProcesoStamp
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
    public String getProcesoStamp() {
        return procesoStamp;
    }

    /******************************************************************************
     * getClaveCopy
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
    public String getClaveCopy() {
        return claveCopy;
    }

    /******************************************************************************
     * getDescripcion
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
    public String getDescripcion() {
        return descripcion;
    }

    /******************************************************************************
     * getFechaIngreso
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
    public String getFechaIngreso() {
        return fechaIngreso;
    }

    /******************************************************************************
     * getFechaModificacion
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
    public String getFechaModificacion() {
        return fechaModificacion;
    }

    /******************************************************************************
     * getAutor
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
    public String getAutor() {
        return autor;
    }

    /******************************************************************************
     * getTipoModulo
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
    public String getTipoModulo() {
        return tipoModulo;
    }

    /******************************************************************************
     * getEstado
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
    public String getEstado() {
        return estado;
    }

    /******************************************************************************
     * setProcesoStamp
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param procesoStamp TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public void setProcesoStamp(String procesoStamp) {
        this.procesoStamp = procesoStamp;
    }

    /******************************************************************************
     * setClaveCopy
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param claveCopy TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public void setClaveCopy(String claveCopy) {
        this.claveCopy = claveCopy;
    }

    /******************************************************************************
     * setDescripcion
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param descripcion TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /******************************************************************************
     * setFechaIngreso
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param fechaIngreso TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /******************************************************************************
     * setFechaModificacion
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param fechaModificacion TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    /******************************************************************************
     * setAutor
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param autor TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /******************************************************************************
     * setTipoModulo
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param tipoModulo TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public void setTipoModulo(String tipoModulo) {
        this.tipoModulo = tipoModulo;
    }

    /******************************************************************************
     * setEstado
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param estado TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public void setEstado(String estado) {
        this.estado = estado;
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
     * @since 1.0
     *
     */
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    /******************************************************************************
     * equals
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param o TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    /******************************************************************************
     * hashCode
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
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
