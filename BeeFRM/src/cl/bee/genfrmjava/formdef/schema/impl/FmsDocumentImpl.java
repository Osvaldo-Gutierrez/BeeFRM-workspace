/*
 * An XML document type.
 * Localname: fms
 * Namespace: http://cl/bee/genfrmjava/formdef/schema
 * Java type: cl.bee.genfrmjava.formdef.schema.FmsDocument
 *
 * Automatically generated - do not modify.
 */
package cl.bee.genfrmjava.formdef.schema.impl;
/**
 * A document containing one fms(@http://cl/bee/genfrmjava/formdef/schema) element.
 *
 * This is a complex type.
 */
public class FmsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.formdef.schema.FmsDocument
{
    private static final long serialVersionUID = 1L;
    
    public FmsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FMS$0 = 
        new javax.xml.namespace.QName("http://cl/bee/genfrmjava/formdef/schema", "fms");
    
    
    /**
     * Gets the "fms" element
     */
    public cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms getFms()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms target = null;
            target = (cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms)get_store().find_element_user(FMS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "fms" element
     */
    public void setFms(cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms fms)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms target = null;
            target = (cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms)get_store().find_element_user(FMS$0, 0);
            if (target == null)
            {
                target = (cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms)get_store().add_element_user(FMS$0);
            }
            target.set(fms);
        }
    }
    
    /**
     * Appends and returns a new empty "fms" element
     */
    public cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms addNewFms()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms target = null;
            target = (cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms)get_store().add_element_user(FMS$0);
            return target;
        }
    }
    /**
     * An XML fms(@http://cl/bee/genfrmjava/formdef/schema).
     *
     * This is a complex type.
     */
    public static class FmsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms
    {
        private static final long serialVersionUID = 1L;
        
        public FmsImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName NAME$0 = 
            new javax.xml.namespace.QName("", "name");
        private static final javax.xml.namespace.QName MODIFIER$2 = 
            new javax.xml.namespace.QName("", "modifier");
        private static final javax.xml.namespace.QName ROW$4 = 
            new javax.xml.namespace.QName("", "row");
        private static final javax.xml.namespace.QName COLUMN$6 = 
            new javax.xml.namespace.QName("", "column");
        private static final javax.xml.namespace.QName PICTURE$8 = 
            new javax.xml.namespace.QName("", "picture");
        private static final javax.xml.namespace.QName ATTRIBUTES$10 = 
            new javax.xml.namespace.QName("", "attributes");
        
        
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
         * Gets the "modifier" attribute
         */
        public cl.bee.genfrmjava.formdef.schema.ModifierType.Enum getModifier()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(MODIFIER$2);
                if (target == null)
                {
                    return null;
                }
                return (cl.bee.genfrmjava.formdef.schema.ModifierType.Enum)target.getEnumValue();
            }
        }
        
        /**
         * Gets (as xml) the "modifier" attribute
         */
        public cl.bee.genfrmjava.formdef.schema.ModifierType xgetModifier()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.ModifierType target = null;
                target = (cl.bee.genfrmjava.formdef.schema.ModifierType)get_store().find_attribute_user(MODIFIER$2);
                return target;
            }
        }
        
        /**
         * Sets the "modifier" attribute
         */
        public void setModifier(cl.bee.genfrmjava.formdef.schema.ModifierType.Enum modifier)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(MODIFIER$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(MODIFIER$2);
                }
                target.setEnumValue(modifier);
            }
        }
        
        /**
         * Sets (as xml) the "modifier" attribute
         */
        public void xsetModifier(cl.bee.genfrmjava.formdef.schema.ModifierType modifier)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.ModifierType target = null;
                target = (cl.bee.genfrmjava.formdef.schema.ModifierType)get_store().find_attribute_user(MODIFIER$2);
                if (target == null)
                {
                    target = (cl.bee.genfrmjava.formdef.schema.ModifierType)get_store().add_attribute_user(MODIFIER$2);
                }
                target.set(modifier);
            }
        }
        
        /**
         * Gets the "row" attribute
         */
        public long getRow()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ROW$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(ROW$4);
                }
                if (target == null)
                {
                    return 0L;
                }
                return target.getLongValue();
            }
        }
        
        /**
         * Gets (as xml) the "row" attribute
         */
        public org.apache.xmlbeans.XmlUnsignedInt xgetRow()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlUnsignedInt target = null;
                target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().find_attribute_user(ROW$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlUnsignedInt)get_default_attribute_value(ROW$4);
                }
                return target;
            }
        }
        
        /**
         * True if has "row" attribute
         */
        public boolean isSetRow()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(ROW$4) != null;
            }
        }
        
        /**
         * Sets the "row" attribute
         */
        public void setRow(long row)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ROW$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ROW$4);
                }
                target.setLongValue(row);
            }
        }
        
        /**
         * Sets (as xml) the "row" attribute
         */
        public void xsetRow(org.apache.xmlbeans.XmlUnsignedInt row)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlUnsignedInt target = null;
                target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().find_attribute_user(ROW$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().add_attribute_user(ROW$4);
                }
                target.set(row);
            }
        }
        
        /**
         * Unsets the "row" attribute
         */
        public void unsetRow()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(ROW$4);
            }
        }
        
        /**
         * Gets the "column" attribute
         */
        public long getColumn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(COLUMN$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(COLUMN$6);
                }
                if (target == null)
                {
                    return 0L;
                }
                return target.getLongValue();
            }
        }
        
        /**
         * Gets (as xml) the "column" attribute
         */
        public org.apache.xmlbeans.XmlUnsignedInt xgetColumn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlUnsignedInt target = null;
                target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().find_attribute_user(COLUMN$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlUnsignedInt)get_default_attribute_value(COLUMN$6);
                }
                return target;
            }
        }
        
        /**
         * True if has "column" attribute
         */
        public boolean isSetColumn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(COLUMN$6) != null;
            }
        }
        
        /**
         * Sets the "column" attribute
         */
        public void setColumn(long column)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(COLUMN$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(COLUMN$6);
                }
                target.setLongValue(column);
            }
        }
        
        /**
         * Sets (as xml) the "column" attribute
         */
        public void xsetColumn(org.apache.xmlbeans.XmlUnsignedInt column)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlUnsignedInt target = null;
                target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().find_attribute_user(COLUMN$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().add_attribute_user(COLUMN$6);
                }
                target.set(column);
            }
        }
        
        /**
         * Unsets the "column" attribute
         */
        public void unsetColumn()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(COLUMN$6);
            }
        }
        
        /**
         * Gets the "picture" attribute
         */
        public java.lang.String getPicture()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PICTURE$8);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "picture" attribute
         */
        public org.apache.xmlbeans.XmlString xgetPicture()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PICTURE$8);
                return target;
            }
        }
        
        /**
         * Sets the "picture" attribute
         */
        public void setPicture(java.lang.String picture)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(PICTURE$8);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(PICTURE$8);
                }
                target.setStringValue(picture);
            }
        }
        
        /**
         * Sets (as xml) the "picture" attribute
         */
        public void xsetPicture(org.apache.xmlbeans.XmlString picture)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(PICTURE$8);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(PICTURE$8);
                }
                target.set(picture);
            }
        }
        
        /**
         * Gets the "attributes" attribute
         */
        public long getAttributes()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ATTRIBUTES$10);
                if (target == null)
                {
                    return 0L;
                }
                return target.getLongValue();
            }
        }
        
        /**
         * Gets (as xml) the "attributes" attribute
         */
        public org.apache.xmlbeans.XmlUnsignedInt xgetAttributes()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlUnsignedInt target = null;
                target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().find_attribute_user(ATTRIBUTES$10);
                return target;
            }
        }
        
        /**
         * Sets the "attributes" attribute
         */
        public void setAttributes(long attributes)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ATTRIBUTES$10);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ATTRIBUTES$10);
                }
                target.setLongValue(attributes);
            }
        }
        
        /**
         * Sets (as xml) the "attributes" attribute
         */
        public void xsetAttributes(org.apache.xmlbeans.XmlUnsignedInt attributes)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlUnsignedInt target = null;
                target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().find_attribute_user(ATTRIBUTES$10);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().add_attribute_user(ATTRIBUTES$10);
                }
                target.set(attributes);
            }
        }
    }
}
