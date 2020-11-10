/*
 * An XML document type.
 * Localname: domain
 * Namespace: http://cl/bee/genfrmjava/domaindef/schema
 * Java type: cl.bee.genfrmjava.domaindef.schema.DomainDocument
 *
 * Automatically generated - do not modify.
 */
package cl.bee.genfrmjava.domaindef.schema.impl;
/**
 * A document containing one domain(@http://cl/bee/genfrmjava/domaindef/schema) element.
 *
 * This is a complex type.
 */
public class DomainDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.domaindef.schema.DomainDocument
{
    private static final long serialVersionUID = 1L;
    
    public DomainDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DOMAIN$0 = 
        new javax.xml.namespace.QName("http://cl/bee/genfrmjava/domaindef/schema", "domain");
    
    
    /**
     * Gets the "domain" element
     */
    public cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain getDomain()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain target = null;
            target = (cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain)get_store().find_element_user(DOMAIN$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "domain" element
     */
    public void setDomain(cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain domain)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain target = null;
            target = (cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain)get_store().find_element_user(DOMAIN$0, 0);
            if (target == null)
            {
                target = (cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain)get_store().add_element_user(DOMAIN$0);
            }
            target.set(domain);
        }
    }
    
    /**
     * Appends and returns a new empty "domain" element
     */
    public cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain addNewDomain()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain target = null;
            target = (cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain)get_store().add_element_user(DOMAIN$0);
            return target;
        }
    }
    /**
     * An XML domain(@http://cl/bee/genfrmjava/domaindef/schema).
     *
     * This is a complex type.
     */
    public static class DomainImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain
    {
        private static final long serialVersionUID = 1L;
        
        public DomainImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName NAME$0 = 
            new javax.xml.namespace.QName("", "name");
        private static final javax.xml.namespace.QName SYSTEM$2 = 
            new javax.xml.namespace.QName("", "system");
        private static final javax.xml.namespace.QName REGISTRY$4 = 
            new javax.xml.namespace.QName("", "registry");
        private static final javax.xml.namespace.QName TABLE$6 = 
            new javax.xml.namespace.QName("", "table");
        private static final javax.xml.namespace.QName VALIDATION$8 = 
            new javax.xml.namespace.QName("", "validation");
        private static final javax.xml.namespace.QName SEARCH$10 = 
            new javax.xml.namespace.QName("", "search");
        
        
        /**
         * Gets the "name" attribute
         */
        public java.lang.String getName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "name" attribute
         */
        public org.apache.xmlbeans.XmlString xgetName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$0);
                return target;
            }
        }
        
        /**
         * Sets the "name" attribute
         */
        public void setName(java.lang.String name)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(NAME$0);
                }
                target.setStringValue(name);
            }
        }
        
        /**
         * Sets (as xml) the "name" attribute
         */
        public void xsetName(org.apache.xmlbeans.XmlString name)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(NAME$0);
                }
                target.set(name);
            }
        }
        
        /**
         * Gets the "system" attribute
         */
        public java.lang.String getSystem()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SYSTEM$2);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "system" attribute
         */
        public org.apache.xmlbeans.XmlString xgetSystem()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(SYSTEM$2);
                return target;
            }
        }
        
        /**
         * Sets the "system" attribute
         */
        public void setSystem(java.lang.String system)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SYSTEM$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(SYSTEM$2);
                }
                target.setStringValue(system);
            }
        }
        
        /**
         * Sets (as xml) the "system" attribute
         */
        public void xsetSystem(org.apache.xmlbeans.XmlString system)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(SYSTEM$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(SYSTEM$2);
                }
                target.set(system);
            }
        }
        
        /**
         * Gets the "registry" attribute
         */
        public java.lang.String getRegistry()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(REGISTRY$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(REGISTRY$4);
                }
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "registry" attribute
         */
        public org.apache.xmlbeans.XmlString xgetRegistry()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(REGISTRY$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_default_attribute_value(REGISTRY$4);
                }
                return target;
            }
        }
        
        /**
         * True if has "registry" attribute
         */
        public boolean isSetRegistry()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(REGISTRY$4) != null;
            }
        }
        
        /**
         * Sets the "registry" attribute
         */
        public void setRegistry(java.lang.String registry)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(REGISTRY$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(REGISTRY$4);
                }
                target.setStringValue(registry);
            }
        }
        
        /**
         * Sets (as xml) the "registry" attribute
         */
        public void xsetRegistry(org.apache.xmlbeans.XmlString registry)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(REGISTRY$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(REGISTRY$4);
                }
                target.set(registry);
            }
        }
        
        /**
         * Unsets the "registry" attribute
         */
        public void unsetRegistry()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(REGISTRY$4);
            }
        }
        
        /**
         * Gets the "table" attribute
         */
        public java.lang.String getTable()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TABLE$6);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "table" attribute
         */
        public org.apache.xmlbeans.XmlString xgetTable()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TABLE$6);
                return target;
            }
        }
        
        /**
         * Sets the "table" attribute
         */
        public void setTable(java.lang.String table)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TABLE$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TABLE$6);
                }
                target.setStringValue(table);
            }
        }
        
        /**
         * Sets (as xml) the "table" attribute
         */
        public void xsetTable(org.apache.xmlbeans.XmlString table)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(TABLE$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(TABLE$6);
                }
                target.set(table);
            }
        }
        
        /**
         * Gets the "validation" attribute
         */
        public java.lang.String getValidation()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VALIDATION$8);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(VALIDATION$8);
                }
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "validation" attribute
         */
        public org.apache.xmlbeans.XmlString xgetValidation()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(VALIDATION$8);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_default_attribute_value(VALIDATION$8);
                }
                return target;
            }
        }
        
        /**
         * True if has "validation" attribute
         */
        public boolean isSetValidation()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(VALIDATION$8) != null;
            }
        }
        
        /**
         * Sets the "validation" attribute
         */
        public void setValidation(java.lang.String validation)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VALIDATION$8);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(VALIDATION$8);
                }
                target.setStringValue(validation);
            }
        }
        
        /**
         * Sets (as xml) the "validation" attribute
         */
        public void xsetValidation(org.apache.xmlbeans.XmlString validation)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(VALIDATION$8);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(VALIDATION$8);
                }
                target.set(validation);
            }
        }
        
        /**
         * Unsets the "validation" attribute
         */
        public void unsetValidation()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(VALIDATION$8);
            }
        }
        
        /**
         * Gets the "search" attribute
         */
        public java.lang.String getSearch()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SEARCH$10);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(SEARCH$10);
                }
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "search" attribute
         */
        public org.apache.xmlbeans.XmlString xgetSearch()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(SEARCH$10);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_default_attribute_value(SEARCH$10);
                }
                return target;
            }
        }
        
        /**
         * True if has "search" attribute
         */
        public boolean isSetSearch()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(SEARCH$10) != null;
            }
        }
        
        /**
         * Sets the "search" attribute
         */
        public void setSearch(java.lang.String search)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SEARCH$10);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(SEARCH$10);
                }
                target.setStringValue(search);
            }
        }
        
        /**
         * Sets (as xml) the "search" attribute
         */
        public void xsetSearch(org.apache.xmlbeans.XmlString search)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(SEARCH$10);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(SEARCH$10);
                }
                target.set(search);
            }
        }
        
        /**
         * Unsets the "search" attribute
         */
        public void unsetSearch()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(SEARCH$10);
            }
        }
    }
}
