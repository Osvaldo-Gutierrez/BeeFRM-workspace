/*
 *   Copyright (c) 2019 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.genfrmjava.util;


import org.apache.log4j.*;


/**
 *
 * TODO_javadoc.
 *
 * @version 1.0 (01/01/2013).
 *
 */
public class DomainRangeDef implements Cloneable {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(DomainRangeDef.class);

    /** TODO_javadoc. */
    public String name = null;

    /** TODO_javadoc. */
    public String domain = null;

    /** TODO_javadoc. */
    public String system = null;

    /** TODO_javadoc. */
    public String registry = null;

    /** TODO_javadoc. */
    public String table = null;

    /** TODO_javadoc. */
    public String validation = null;

    /** TODO_javadoc. */
    public String search = null;

    /******************************************************************************
     * DomainRangeDef
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public DomainRangeDef() {}

    /******************************************************************************
     * DomainRangeDef
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param name TODO_javadoc.
     * @param domain TODO_javadoc.
     * @param system TODO_javadoc.
     * @param registry TODO_javadoc.
     * @param table TODO_javadoc.
     * @param validation TODO_javadoc.
     * @param search TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public DomainRangeDef(String name, String domain, String system, String registry, String table, String validation, String search) {

        this.name       = name;
        this.domain     = domain;
        this.system     = system;
        this.registry   = registry;
        this.table      = table;
        this.validation = validation;
        this.search     = search;
    }

    /*******************************************************************************************************
     * getName
     *******************************************************************************************************/
    /**
     *
     * @return name TODO_javadoc
     *
     */
    public String getName() {
        return name;
    }

    /*******************************************************************************************************
     * getDomain
     *******************************************************************************************************/
    /**
     *
     * @return domain TODO_javadoc
     *
     */
    public String getDomain() {
        return domain;
    }

    /*******************************************************************************************************
     * getSystem
     *******************************************************************************************************/
    /**
     *
     * @return system TODO_javadoc
     *
     */
    public String getSystem() {
        return system;
    }

    /*******************************************************************************************************
     * getRegistry
     *******************************************************************************************************/
    /**
     *
     * @return registry TODO_javadoc
     *
     */
    public String getRegistry() {
        return registry;
    }

    /*******************************************************************************************************
     * getTable
     *******************************************************************************************************/
    /**
     *
     * @return table TODO_javadoc
     *
     */
    public String getTable() {
        return table;
    }

    /*******************************************************************************************************
     * getValidation
     *******************************************************************************************************/
    /**
     *
     * @return validation TODO_javadoc
     *
     */
    public String getValidation() {
        return validation;
    }

    /*******************************************************************************************************
     * getSearch
     *******************************************************************************************************/
    /**
     *
     * @return search TODO_javadoc
     *
     */
    public String getSearch() {
        return search;
    }

    /*******************************************************************************************************
     * setName
     *******************************************************************************************************/
    /**
     *
     * @param name TODO_javadoc
     *
     */
    public void setName(String name) {
        this.name = name;
    }

    /*******************************************************************************************************
     * setDomain
     *******************************************************************************************************/
    /**
     *
     * @param domain TODO_javadoc
     *
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /*******************************************************************************************************
     * setSystem
     *******************************************************************************************************/
    /**
     *
     * @param system TODO_javadoc
     *
     */
    public void setSystem(String system) {
        this.system = system;
    }

    /*******************************************************************************************************
     * setRegistry
     *******************************************************************************************************/
    /**
     *
     * @param registry TODO_javadoc
     *
     */
    public void setRegistry(String registry) {
        this.registry = registry;
    }

    /*******************************************************************************************************
     * setTable
     *******************************************************************************************************/
    /**
     *
     * @param table TODO_javadoc
     *
     */
    public void setTable(String table) {
        this.table = table;
    }

    /*******************************************************************************************************
     * setValidation
     *******************************************************************************************************/
    /**
     *
     * @param validation TODO_javadoc
     *
     */
    public void setValidation(String validation) {
        this.validation = validation;
    }

    /*******************************************************************************************************
     * setSearch
     *******************************************************************************************************/
    /**
     *
     * @param search TODO_javadoc
     *
     */
    public void setSearch(String search) {
        this.search = search;
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

        String s = "";

        s += "[name : " + (name == null ? "(NULL)" : name) + "]";
        s += "[domain : " + (domain == null ? "(NULL)" : domain) + "]";
        s += "[system : " + (system == null ? "(NULL)" : system) + "]";
        s += "[registry : " + (registry == null ? "(NULL)" : registry) + "]";
        s += "[table : " + (table == null ? "(NULL)" : table) + "]";
        s += "[validation : " + (validation == null ? "(NULL)" : validation) + "]";
        s += "[search : " + (search == null ? "(NULL)" : search) + "]";

        return s;
    }
}
