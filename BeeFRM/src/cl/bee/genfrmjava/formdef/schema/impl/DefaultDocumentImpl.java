/*
 * An XML document type.
 * Localname: default
 * Namespace: http://cl/bee/genfrmjava/formdef/schema
 * Java type: cl.bee.genfrmjava.formdef.schema.DefaultDocument
 *
 * Automatically generated - do not modify.
 */
package cl.bee.genfrmjava.formdef.schema.impl;
/**
 * A document containing one default(@http://cl/bee/genfrmjava/formdef/schema) element.
 *
 * This is a complex type.
 */
public class DefaultDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.formdef.schema.DefaultDocument
{
    private static final long serialVersionUID = 1L;
    
    public DefaultDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DEFAULT$0 = 
        new javax.xml.namespace.QName("http://cl/bee/genfrmjava/formdef/schema", "default");
    
    
    /**
     * Gets the "default" element
     */
    public cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default getDefault()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default target = null;
            target = (cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default)get_store().find_element_user(DEFAULT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "default" element
     */
    public void setDefault(cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default xdefault)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default target = null;
            target = (cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default)get_store().find_element_user(DEFAULT$0, 0);
            if (target == null)
            {
                target = (cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default)get_store().add_element_user(DEFAULT$0);
            }
            target.set(xdefault);
        }
    }
    
    /**
     * Appends and returns a new empty "default" element
     */
    public cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default addNewDefault()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default target = null;
            target = (cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default)get_store().add_element_user(DEFAULT$0);
            return target;
        }
    }
    /**
     * An XML default(@http://cl/bee/genfrmjava/formdef/schema).
     *
     * This is a complex type.
     */
    public static class DefaultImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default
    {
        private static final long serialVersionUID = 1L;
        
        public DefaultImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName VALUE$0 = 
            new javax.xml.namespace.QName("", "value");
        
        
        /**
         * Gets the "value" attribute
         */
        public java.lang.String getValue()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VALUE$0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "value" attribute
         */
        public org.apache.xmlbeans.XmlString xgetValue()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(VALUE$0);
                return target;
            }
        }
        
        /**
         * True if has "value" attribute
         */
        public boolean isSetValue()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(VALUE$0) != null;
            }
        }
        
        /**
         * Sets the "value" attribute
         */
        public void setValue(java.lang.String value)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(VALUE$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(VALUE$0);
                }
                target.setStringValue(value);
            }
        }
        
        /**
         * Sets (as xml) the "value" attribute
         */
        public void xsetValue(org.apache.xmlbeans.XmlString value)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(VALUE$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(VALUE$0);
                }
                target.set(value);
            }
        }
        
        /**
         * Unsets the "value" attribute
         */
        public void unsetValue()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(VALUE$0);
            }
        }
    }
}
