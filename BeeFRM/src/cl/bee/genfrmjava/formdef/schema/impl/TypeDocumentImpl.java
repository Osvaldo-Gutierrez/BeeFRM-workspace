/*
 * An XML document type.
 * Localname: type
 * Namespace: http://cl/bee/genfrmjava/formdef/schema
 * Java type: cl.bee.genfrmjava.formdef.schema.TypeDocument
 *
 * Automatically generated - do not modify.
 */
package cl.bee.genfrmjava.formdef.schema.impl;
/**
 * A document containing one type(@http://cl/bee/genfrmjava/formdef/schema) element.
 *
 * This is a complex type.
 */
public class TypeDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.formdef.schema.TypeDocument
{
    private static final long serialVersionUID = 1L;
    
    public TypeDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName TYPE$0 = 
        new javax.xml.namespace.QName("http://cl/bee/genfrmjava/formdef/schema", "type");
    
    
    /**
     * Gets the "type" element
     */
    public cl.bee.genfrmjava.formdef.schema.TypeDocument.Type getType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.formdef.schema.TypeDocument.Type target = null;
            target = (cl.bee.genfrmjava.formdef.schema.TypeDocument.Type)get_store().find_element_user(TYPE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "type" element
     */
    public void setType(cl.bee.genfrmjava.formdef.schema.TypeDocument.Type type)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.formdef.schema.TypeDocument.Type target = null;
            target = (cl.bee.genfrmjava.formdef.schema.TypeDocument.Type)get_store().find_element_user(TYPE$0, 0);
            if (target == null)
            {
                target = (cl.bee.genfrmjava.formdef.schema.TypeDocument.Type)get_store().add_element_user(TYPE$0);
            }
            target.set(type);
        }
    }
    
    /**
     * Appends and returns a new empty "type" element
     */
    public cl.bee.genfrmjava.formdef.schema.TypeDocument.Type addNewType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.formdef.schema.TypeDocument.Type target = null;
            target = (cl.bee.genfrmjava.formdef.schema.TypeDocument.Type)get_store().add_element_user(TYPE$0);
            return target;
        }
    }
    /**
     * An XML type(@http://cl/bee/genfrmjava/formdef/schema).
     *
     * This is a complex type.
     */
    public static class TypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.formdef.schema.TypeDocument.Type
    {
        private static final long serialVersionUID = 1L;
        
        public TypeImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName NAME$0 = 
            new javax.xml.namespace.QName("", "name");
        private static final javax.xml.namespace.QName SIZE$2 = 
            new javax.xml.namespace.QName("", "size");
        private static final javax.xml.namespace.QName INTEGERS$4 = 
            new javax.xml.namespace.QName("", "integers");
        private static final javax.xml.namespace.QName DECIMALS$6 = 
            new javax.xml.namespace.QName("", "decimals");
        private static final javax.xml.namespace.QName SIGN$8 = 
            new javax.xml.namespace.QName("", "sign");
        
        
        /**
         * Gets the "name" attribute
         */
        public cl.bee.genfrmjava.formdef.schema.TipoType.Enum getName()
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
                return (cl.bee.genfrmjava.formdef.schema.TipoType.Enum)target.getEnumValue();
            }
        }
        
        /**
         * Gets (as xml) the "name" attribute
         */
        public cl.bee.genfrmjava.formdef.schema.TipoType xgetName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.TipoType target = null;
                target = (cl.bee.genfrmjava.formdef.schema.TipoType)get_store().find_attribute_user(NAME$0);
                return target;
            }
        }
        
        /**
         * Sets the "name" attribute
         */
        public void setName(cl.bee.genfrmjava.formdef.schema.TipoType.Enum name)
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
                target.setEnumValue(name);
            }
        }
        
        /**
         * Sets (as xml) the "name" attribute
         */
        public void xsetName(cl.bee.genfrmjava.formdef.schema.TipoType name)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.TipoType target = null;
                target = (cl.bee.genfrmjava.formdef.schema.TipoType)get_store().find_attribute_user(NAME$0);
                if (target == null)
                {
                    target = (cl.bee.genfrmjava.formdef.schema.TipoType)get_store().add_attribute_user(NAME$0);
                }
                target.set(name);
            }
        }
        
        /**
         * Gets the "size" attribute
         */
        public long getSize()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SIZE$2);
                if (target == null)
                {
                    return 0L;
                }
                return target.getLongValue();
            }
        }
        
        /**
         * Gets (as xml) the "size" attribute
         */
        public org.apache.xmlbeans.XmlUnsignedInt xgetSize()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlUnsignedInt target = null;
                target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().find_attribute_user(SIZE$2);
                return target;
            }
        }
        
        /**
         * Sets the "size" attribute
         */
        public void setSize(long size)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SIZE$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(SIZE$2);
                }
                target.setLongValue(size);
            }
        }
        
        /**
         * Sets (as xml) the "size" attribute
         */
        public void xsetSize(org.apache.xmlbeans.XmlUnsignedInt size)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlUnsignedInt target = null;
                target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().find_attribute_user(SIZE$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().add_attribute_user(SIZE$2);
                }
                target.set(size);
            }
        }
        
        /**
         * Gets the "integers" attribute
         */
        public long getIntegers()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(INTEGERS$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(INTEGERS$4);
                }
                if (target == null)
                {
                    return 0L;
                }
                return target.getLongValue();
            }
        }
        
        /**
         * Gets (as xml) the "integers" attribute
         */
        public org.apache.xmlbeans.XmlUnsignedInt xgetIntegers()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlUnsignedInt target = null;
                target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().find_attribute_user(INTEGERS$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlUnsignedInt)get_default_attribute_value(INTEGERS$4);
                }
                return target;
            }
        }
        
        /**
         * True if has "integers" attribute
         */
        public boolean isSetIntegers()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(INTEGERS$4) != null;
            }
        }
        
        /**
         * Sets the "integers" attribute
         */
        public void setIntegers(long integers)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(INTEGERS$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(INTEGERS$4);
                }
                target.setLongValue(integers);
            }
        }
        
        /**
         * Sets (as xml) the "integers" attribute
         */
        public void xsetIntegers(org.apache.xmlbeans.XmlUnsignedInt integers)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlUnsignedInt target = null;
                target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().find_attribute_user(INTEGERS$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().add_attribute_user(INTEGERS$4);
                }
                target.set(integers);
            }
        }
        
        /**
         * Unsets the "integers" attribute
         */
        public void unsetIntegers()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(INTEGERS$4);
            }
        }
        
        /**
         * Gets the "decimals" attribute
         */
        public long getDecimals()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DECIMALS$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(DECIMALS$6);
                }
                if (target == null)
                {
                    return 0L;
                }
                return target.getLongValue();
            }
        }
        
        /**
         * Gets (as xml) the "decimals" attribute
         */
        public org.apache.xmlbeans.XmlUnsignedInt xgetDecimals()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlUnsignedInt target = null;
                target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().find_attribute_user(DECIMALS$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlUnsignedInt)get_default_attribute_value(DECIMALS$6);
                }
                return target;
            }
        }
        
        /**
         * True if has "decimals" attribute
         */
        public boolean isSetDecimals()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(DECIMALS$6) != null;
            }
        }
        
        /**
         * Sets the "decimals" attribute
         */
        public void setDecimals(long decimals)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(DECIMALS$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(DECIMALS$6);
                }
                target.setLongValue(decimals);
            }
        }
        
        /**
         * Sets (as xml) the "decimals" attribute
         */
        public void xsetDecimals(org.apache.xmlbeans.XmlUnsignedInt decimals)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlUnsignedInt target = null;
                target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().find_attribute_user(DECIMALS$6);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().add_attribute_user(DECIMALS$6);
                }
                target.set(decimals);
            }
        }
        
        /**
         * Unsets the "decimals" attribute
         */
        public void unsetDecimals()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(DECIMALS$6);
            }
        }
        
        /**
         * Gets the "sign" attribute
         */
        public cl.bee.genfrmjava.formdef.schema.YesNoType.Enum getSign()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SIGN$8);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(SIGN$8);
                }
                if (target == null)
                {
                    return null;
                }
                return (cl.bee.genfrmjava.formdef.schema.YesNoType.Enum)target.getEnumValue();
            }
        }
        
        /**
         * Gets (as xml) the "sign" attribute
         */
        public cl.bee.genfrmjava.formdef.schema.YesNoType xgetSign()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.YesNoType target = null;
                target = (cl.bee.genfrmjava.formdef.schema.YesNoType)get_store().find_attribute_user(SIGN$8);
                if (target == null)
                {
                    target = (cl.bee.genfrmjava.formdef.schema.YesNoType)get_default_attribute_value(SIGN$8);
                }
                return target;
            }
        }
        
        /**
         * True if has "sign" attribute
         */
        public boolean isSetSign()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(SIGN$8) != null;
            }
        }
        
        /**
         * Sets the "sign" attribute
         */
        public void setSign(cl.bee.genfrmjava.formdef.schema.YesNoType.Enum sign)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SIGN$8);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(SIGN$8);
                }
                target.setEnumValue(sign);
            }
        }
        
        /**
         * Sets (as xml) the "sign" attribute
         */
        public void xsetSign(cl.bee.genfrmjava.formdef.schema.YesNoType sign)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.YesNoType target = null;
                target = (cl.bee.genfrmjava.formdef.schema.YesNoType)get_store().find_attribute_user(SIGN$8);
                if (target == null)
                {
                    target = (cl.bee.genfrmjava.formdef.schema.YesNoType)get_store().add_attribute_user(SIGN$8);
                }
                target.set(sign);
            }
        }
        
        /**
         * Unsets the "sign" attribute
         */
        public void unsetSign()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(SIGN$8);
            }
        }
    }
}
