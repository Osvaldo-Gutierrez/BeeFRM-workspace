/*
 * An XML document type.
 * Localname: array
 * Namespace: http://cl/bee/genfrmjava/formdef/schema
 * Java type: cl.bee.genfrmjava.formdef.schema.ArrayDocument
 *
 * Automatically generated - do not modify.
 */
package cl.bee.genfrmjava.formdef.schema.impl;
/**
 * A document containing one array(@http://cl/bee/genfrmjava/formdef/schema) element.
 *
 * This is a complex type.
 */
public class ArrayDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.formdef.schema.ArrayDocument
{
    private static final long serialVersionUID = 1L;
    
    public ArrayDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ARRAY$0 = 
        new javax.xml.namespace.QName("http://cl/bee/genfrmjava/formdef/schema", "array");
    
    
    /**
     * Gets the "array" element
     */
    public cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array getArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array target = null;
            target = (cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array)get_store().find_element_user(ARRAY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "array" element
     */
    public void setArray(cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array array)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array target = null;
            target = (cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array)get_store().find_element_user(ARRAY$0, 0);
            if (target == null)
            {
                target = (cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array)get_store().add_element_user(ARRAY$0);
            }
            target.set(array);
        }
    }
    
    /**
     * Appends and returns a new empty "array" element
     */
    public cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array addNewArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array target = null;
            target = (cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array)get_store().add_element_user(ARRAY$0);
            return target;
        }
    }
    /**
     * An XML array(@http://cl/bee/genfrmjava/formdef/schema).
     *
     * This is a complex type.
     */
    public static class ArrayImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array
    {
        private static final long serialVersionUID = 1L;
        
        public ArrayImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName FIELD$0 = 
            new javax.xml.namespace.QName("http://cl/bee/genfrmjava/formdef/schema", "field");
        private static final javax.xml.namespace.QName SIZE$2 = 
            new javax.xml.namespace.QName("", "size");
        
        
        /**
         * Gets array of all "field" elements
         */
        public cl.bee.genfrmjava.formdef.schema.FieldDocument.Field[] getFieldArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(FIELD$0, targetList);
                cl.bee.genfrmjava.formdef.schema.FieldDocument.Field[] result = new cl.bee.genfrmjava.formdef.schema.FieldDocument.Field[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "field" element
         */
        public cl.bee.genfrmjava.formdef.schema.FieldDocument.Field getFieldArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.FieldDocument.Field target = null;
                target = (cl.bee.genfrmjava.formdef.schema.FieldDocument.Field)get_store().find_element_user(FIELD$0, i);
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
        public void setFieldArray(cl.bee.genfrmjava.formdef.schema.FieldDocument.Field[] fieldArray)
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
        public void setFieldArray(int i, cl.bee.genfrmjava.formdef.schema.FieldDocument.Field field)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.FieldDocument.Field target = null;
                target = (cl.bee.genfrmjava.formdef.schema.FieldDocument.Field)get_store().find_element_user(FIELD$0, i);
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
        public cl.bee.genfrmjava.formdef.schema.FieldDocument.Field insertNewField(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.FieldDocument.Field target = null;
                target = (cl.bee.genfrmjava.formdef.schema.FieldDocument.Field)get_store().insert_element_user(FIELD$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "field" element
         */
        public cl.bee.genfrmjava.formdef.schema.FieldDocument.Field addNewField()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.FieldDocument.Field target = null;
                target = (cl.bee.genfrmjava.formdef.schema.FieldDocument.Field)get_store().add_element_user(FIELD$0);
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
    }
}
