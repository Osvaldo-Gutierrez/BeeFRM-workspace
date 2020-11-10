/*
 * An XML document type.
 * Localname: pos
 * Namespace: http://cl/bee/genfrmjava/formdef/schema
 * Java type: cl.bee.genfrmjava.formdef.schema.PosDocument
 *
 * Automatically generated - do not modify.
 */
package cl.bee.genfrmjava.formdef.schema.impl;
/**
 * A document containing one pos(@http://cl/bee/genfrmjava/formdef/schema) element.
 *
 * This is a complex type.
 */
public class PosDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.formdef.schema.PosDocument
{
    private static final long serialVersionUID = 1L;
    
    public PosDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName POS$0 = 
        new javax.xml.namespace.QName("http://cl/bee/genfrmjava/formdef/schema", "pos");
    
    
    /**
     * Gets the "pos" element
     */
    public cl.bee.genfrmjava.formdef.schema.PosDocument.Pos getPos()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.formdef.schema.PosDocument.Pos target = null;
            target = (cl.bee.genfrmjava.formdef.schema.PosDocument.Pos)get_store().find_element_user(POS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "pos" element
     */
    public void setPos(cl.bee.genfrmjava.formdef.schema.PosDocument.Pos pos)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.formdef.schema.PosDocument.Pos target = null;
            target = (cl.bee.genfrmjava.formdef.schema.PosDocument.Pos)get_store().find_element_user(POS$0, 0);
            if (target == null)
            {
                target = (cl.bee.genfrmjava.formdef.schema.PosDocument.Pos)get_store().add_element_user(POS$0);
            }
            target.set(pos);
        }
    }
    
    /**
     * Appends and returns a new empty "pos" element
     */
    public cl.bee.genfrmjava.formdef.schema.PosDocument.Pos addNewPos()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.formdef.schema.PosDocument.Pos target = null;
            target = (cl.bee.genfrmjava.formdef.schema.PosDocument.Pos)get_store().add_element_user(POS$0);
            return target;
        }
    }
    /**
     * An XML pos(@http://cl/bee/genfrmjava/formdef/schema).
     *
     * This is a complex type.
     */
    public static class PosImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.formdef.schema.PosDocument.Pos
    {
        private static final long serialVersionUID = 1L;
        
        public PosImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName ROW$0 = 
            new javax.xml.namespace.QName("", "row");
        private static final javax.xml.namespace.QName COLUMN$2 = 
            new javax.xml.namespace.QName("", "column");
        
        
        /**
         * Gets the "row" attribute
         */
        public long getRow()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ROW$0);
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
                target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().find_attribute_user(ROW$0);
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
                return get_store().find_attribute_user(ROW$0) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ROW$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ROW$0);
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
                target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().find_attribute_user(ROW$0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().add_attribute_user(ROW$0);
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
                get_store().remove_attribute(ROW$0);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(COLUMN$2);
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
                target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().find_attribute_user(COLUMN$2);
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
                return get_store().find_attribute_user(COLUMN$2) != null;
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(COLUMN$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(COLUMN$2);
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
                target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().find_attribute_user(COLUMN$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().add_attribute_user(COLUMN$2);
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
                get_store().remove_attribute(COLUMN$2);
            }
        }
    }
}
