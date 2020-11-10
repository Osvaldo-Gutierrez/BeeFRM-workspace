/*
 * An XML document type.
 * Localname: ranges
 * Namespace: http://cl/bee/genfrmjava/rangedef/schema
 * Java type: cl.bee.genfrmjava.rangedef.schema.RangesDocument
 *
 * Automatically generated - do not modify.
 */
package cl.bee.genfrmjava.rangedef.schema.impl;
/**
 * A document containing one ranges(@http://cl/bee/genfrmjava/rangedef/schema) element.
 *
 * This is a complex type.
 */
public class RangesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.rangedef.schema.RangesDocument
{
    private static final long serialVersionUID = 1L;
    
    public RangesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RANGES$0 = 
        new javax.xml.namespace.QName("http://cl/bee/genfrmjava/rangedef/schema", "ranges");
    
    
    /**
     * Gets the "ranges" element
     */
    public cl.bee.genfrmjava.rangedef.schema.RangesDocument.Ranges getRanges()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.rangedef.schema.RangesDocument.Ranges target = null;
            target = (cl.bee.genfrmjava.rangedef.schema.RangesDocument.Ranges)get_store().find_element_user(RANGES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "ranges" element
     */
    public void setRanges(cl.bee.genfrmjava.rangedef.schema.RangesDocument.Ranges ranges)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.rangedef.schema.RangesDocument.Ranges target = null;
            target = (cl.bee.genfrmjava.rangedef.schema.RangesDocument.Ranges)get_store().find_element_user(RANGES$0, 0);
            if (target == null)
            {
                target = (cl.bee.genfrmjava.rangedef.schema.RangesDocument.Ranges)get_store().add_element_user(RANGES$0);
            }
            target.set(ranges);
        }
    }
    
    /**
     * Appends and returns a new empty "ranges" element
     */
    public cl.bee.genfrmjava.rangedef.schema.RangesDocument.Ranges addNewRanges()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.rangedef.schema.RangesDocument.Ranges target = null;
            target = (cl.bee.genfrmjava.rangedef.schema.RangesDocument.Ranges)get_store().add_element_user(RANGES$0);
            return target;
        }
    }
    /**
     * An XML ranges(@http://cl/bee/genfrmjava/rangedef/schema).
     *
     * This is a complex type.
     */
    public static class RangesImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.rangedef.schema.RangesDocument.Ranges
    {
        private static final long serialVersionUID = 1L;
        
        public RangesImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName FIELD$0 = 
            new javax.xml.namespace.QName("http://cl/bee/genfrmjava/rangedef/schema", "field");
        
        
        /**
         * Gets array of all "field" elements
         */
        public cl.bee.genfrmjava.rangedef.schema.FieldDocument.Field[] getFieldArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(FIELD$0, targetList);
                cl.bee.genfrmjava.rangedef.schema.FieldDocument.Field[] result = new cl.bee.genfrmjava.rangedef.schema.FieldDocument.Field[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "field" element
         */
        public cl.bee.genfrmjava.rangedef.schema.FieldDocument.Field getFieldArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.rangedef.schema.FieldDocument.Field target = null;
                target = (cl.bee.genfrmjava.rangedef.schema.FieldDocument.Field)get_store().find_element_user(FIELD$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "field" element
         */
        public int sizeOfFieldArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(FIELD$0);
            }
        }
        
        /**
         * Sets array of all "field" element
         */
        public void setFieldArray(cl.bee.genfrmjava.rangedef.schema.FieldDocument.Field[] fieldArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(fieldArray, FIELD$0);
            }
        }
        
        /**
         * Sets ith "field" element
         */
        public void setFieldArray(int i, cl.bee.genfrmjava.rangedef.schema.FieldDocument.Field field)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.rangedef.schema.FieldDocument.Field target = null;
                target = (cl.bee.genfrmjava.rangedef.schema.FieldDocument.Field)get_store().find_element_user(FIELD$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(field);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "field" element
         */
        public cl.bee.genfrmjava.rangedef.schema.FieldDocument.Field insertNewField(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.rangedef.schema.FieldDocument.Field target = null;
                target = (cl.bee.genfrmjava.rangedef.schema.FieldDocument.Field)get_store().insert_element_user(FIELD$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "field" element
         */
        public cl.bee.genfrmjava.rangedef.schema.FieldDocument.Field addNewField()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.rangedef.schema.FieldDocument.Field target = null;
                target = (cl.bee.genfrmjava.rangedef.schema.FieldDocument.Field)get_store().add_element_user(FIELD$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "field" element
         */
        public void removeField(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(FIELD$0, i);
            }
        }
    }
}
