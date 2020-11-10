/*
 * An XML document type.
 * Localname: primary
 * Namespace: http://cl/bee/genfrmjava/formdef/schema
 * Java type: cl.bee.genfrmjava.formdef.schema.PrimaryDocument
 *
 * Automatically generated - do not modify.
 */
package cl.bee.genfrmjava.formdef.schema.impl;
/**
 * A document containing one primary(@http://cl/bee/genfrmjava/formdef/schema) element.
 *
 * This is a complex type.
 */
public class PrimaryDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.formdef.schema.PrimaryDocument
{
    private static final long serialVersionUID = 1L;
    
    public PrimaryDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PRIMARY$0 = 
        new javax.xml.namespace.QName("http://cl/bee/genfrmjava/formdef/schema", "primary");
    
    
    /**
     * Gets the "primary" element
     */
    public cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary getPrimary()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary target = null;
            target = (cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary)get_store().find_element_user(PRIMARY$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "primary" element
     */
    public void setPrimary(cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary primary)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary target = null;
            target = (cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary)get_store().find_element_user(PRIMARY$0, 0);
            if (target == null)
            {
                target = (cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary)get_store().add_element_user(PRIMARY$0);
            }
            target.set(primary);
        }
    }
    
    /**
     * Appends and returns a new empty "primary" element
     */
    public cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary addNewPrimary()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary target = null;
            target = (cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary)get_store().add_element_user(PRIMARY$0);
            return target;
        }
    }
    /**
     * An XML primary(@http://cl/bee/genfrmjava/formdef/schema).
     *
     * This is a complex type.
     */
    public static class PrimaryImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary
    {
        private static final long serialVersionUID = 1L;
        
        public PrimaryImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName FIELD$0 = 
            new javax.xml.namespace.QName("http://cl/bee/genfrmjava/formdef/schema", "field");
        
        
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
    }
}
