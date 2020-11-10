/*
 * An XML document type.
 * Localname: text
 * Namespace: http://cl/bee/genfrmjava/formdef/schema
 * Java type: cl.bee.genfrmjava.formdef.schema.TextDocument
 *
 * Automatically generated - do not modify.
 */
package cl.bee.genfrmjava.formdef.schema.impl;
/**
 * A document containing one text(@http://cl/bee/genfrmjava/formdef/schema) element.
 *
 * This is a complex type.
 */
public class TextDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.formdef.schema.TextDocument
{
    private static final long serialVersionUID = 1L;
    
    public TextDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName TEXT$0 = 
        new javax.xml.namespace.QName("http://cl/bee/genfrmjava/formdef/schema", "text");
    
    
    /**
     * Gets the "text" element
     */
    public cl.bee.genfrmjava.formdef.schema.TextDocument.Text getText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.formdef.schema.TextDocument.Text target = null;
            target = (cl.bee.genfrmjava.formdef.schema.TextDocument.Text)get_store().find_element_user(TEXT$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "text" element
     */
    public void setText(cl.bee.genfrmjava.formdef.schema.TextDocument.Text text)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.formdef.schema.TextDocument.Text target = null;
            target = (cl.bee.genfrmjava.formdef.schema.TextDocument.Text)get_store().find_element_user(TEXT$0, 0);
            if (target == null)
            {
                target = (cl.bee.genfrmjava.formdef.schema.TextDocument.Text)get_store().add_element_user(TEXT$0);
            }
            target.set(text);
        }
    }
    
    /**
     * Appends and returns a new empty "text" element
     */
    public cl.bee.genfrmjava.formdef.schema.TextDocument.Text addNewText()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.formdef.schema.TextDocument.Text target = null;
            target = (cl.bee.genfrmjava.formdef.schema.TextDocument.Text)get_store().add_element_user(TEXT$0);
            return target;
        }
    }
    /**
     * An XML text(@http://cl/bee/genfrmjava/formdef/schema).
     *
     * This is a complex type.
     */
    public static class TextImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.formdef.schema.TextDocument.Text
    {
        private static final long serialVersionUID = 1L;
        
        public TextImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName CAPTION$0 = 
            new javax.xml.namespace.QName("", "caption");
        private static final javax.xml.namespace.QName ROW$2 = 
            new javax.xml.namespace.QName("", "row");
        private static final javax.xml.namespace.QName COLUMN$4 = 
            new javax.xml.namespace.QName("", "column");
        
        
        /**
         * Gets the "caption" attribute
         */
        public java.lang.String getCaption()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CAPTION$0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "caption" attribute
         */
        public org.apache.xmlbeans.XmlString xgetCaption()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CAPTION$0);
                return target;
            }
        }
        
        /**
         * Sets the "caption" attribute
         */
        public void setCaption(java.lang.String caption)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(CAPTION$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(CAPTION$0);
                }
                target.setStringValue(caption);
            }
        }
        
        /**
         * Sets (as xml) the "caption" attribute
         */
        public void xsetCaption(org.apache.xmlbeans.XmlString caption)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(CAPTION$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(CAPTION$0);
                }
                target.set(caption);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ROW$2);
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
                target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().find_attribute_user(ROW$2);
                return target;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ROW$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ROW$2);
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
                target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().find_attribute_user(ROW$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().add_attribute_user(ROW$2);
                }
                target.set(row);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(COLUMN$4);
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
                target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().find_attribute_user(COLUMN$4);
                return target;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(COLUMN$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(COLUMN$4);
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
                target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().find_attribute_user(COLUMN$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().add_attribute_user(COLUMN$4);
                }
                target.set(column);
            }
        }
    }
}
