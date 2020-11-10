/*
 * An XML document type.
 * Localname: foreign
 * Namespace: http://cl/bee/genfrmjava/formdef/schema
 * Java type: cl.bee.genfrmjava.formdef.schema.ForeignDocument
 *
 * Automatically generated - do not modify.
 */
package cl.bee.genfrmjava.formdef.schema.impl;
/**
 * A document containing one foreign(@http://cl/bee/genfrmjava/formdef/schema) element.
 *
 * This is a complex type.
 */
public class ForeignDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.formdef.schema.ForeignDocument
{
    private static final long serialVersionUID = 1L;
    
    public ForeignDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FOREIGN$0 = 
        new javax.xml.namespace.QName("http://cl/bee/genfrmjava/formdef/schema", "foreign");
    
    
    /**
     * Gets the "foreign" element
     */
    public cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign getForeign()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign target = null;
            target = (cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign)get_store().find_element_user(FOREIGN$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "foreign" element
     */
    public void setForeign(cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign foreign)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign target = null;
            target = (cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign)get_store().find_element_user(FOREIGN$0, 0);
            if (target == null)
            {
                target = (cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign)get_store().add_element_user(FOREIGN$0);
            }
            target.set(foreign);
        }
    }
    
    /**
     * Appends and returns a new empty "foreign" element
     */
    public cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign addNewForeign()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign target = null;
            target = (cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign)get_store().add_element_user(FOREIGN$0);
            return target;
        }
    }
    /**
     * An XML foreign(@http://cl/bee/genfrmjava/formdef/schema).
     *
     * This is a complex type.
     */
    public static class ForeignImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign
    {
        private static final long serialVersionUID = 1L;
        
        public ForeignImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName FIELD$0 = 
            new javax.xml.namespace.QName("http://cl/bee/genfrmjava/formdef/schema", "field");
        private static final javax.xml.namespace.QName ENTITY$2 = 
            new javax.xml.namespace.QName("", "entity");
        
        
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
         * Gets the "entity" attribute
         */
        public java.lang.String getEntity()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ENTITY$2);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "entity" attribute
         */
        public org.apache.xmlbeans.XmlString xgetEntity()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ENTITY$2);
                return target;
            }
        }
        
        /**
         * Sets the "entity" attribute
         */
        public void setEntity(java.lang.String entity)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ENTITY$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ENTITY$2);
                }
                target.setStringValue(entity);
            }
        }
        
        /**
         * Sets (as xml) the "entity" attribute
         */
        public void xsetEntity(org.apache.xmlbeans.XmlString entity)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ENTITY$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(ENTITY$2);
                }
                target.set(entity);
            }
        }
    }
}
