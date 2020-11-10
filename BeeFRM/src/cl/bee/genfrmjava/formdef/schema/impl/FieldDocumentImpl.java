/*
 * An XML document type.
 * Localname: field
 * Namespace: http://cl/bee/genfrmjava/formdef/schema
 * Java type: cl.bee.genfrmjava.formdef.schema.FieldDocument
 *
 * Automatically generated - do not modify.
 */
package cl.bee.genfrmjava.formdef.schema.impl;
/**
 * A document containing one field(@http://cl/bee/genfrmjava/formdef/schema) element.
 *
 * This is a complex type.
 */
public class FieldDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.formdef.schema.FieldDocument
{
    private static final long serialVersionUID = 1L;
    
    public FieldDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FIELD$0 = 
        new javax.xml.namespace.QName("http://cl/bee/genfrmjava/formdef/schema", "field");
    
    
    /**
     * Gets the "field" element
     */
    public cl.bee.genfrmjava.formdef.schema.FieldDocument.Field getField()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.formdef.schema.FieldDocument.Field target = null;
            target = (cl.bee.genfrmjava.formdef.schema.FieldDocument.Field)get_store().find_element_user(FIELD$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "field" element
     */
    public void setField(cl.bee.genfrmjava.formdef.schema.FieldDocument.Field field)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.formdef.schema.FieldDocument.Field target = null;
            target = (cl.bee.genfrmjava.formdef.schema.FieldDocument.Field)get_store().find_element_user(FIELD$0, 0);
            if (target == null)
            {
                target = (cl.bee.genfrmjava.formdef.schema.FieldDocument.Field)get_store().add_element_user(FIELD$0);
            }
            target.set(field);
        }
    }
    
    /**
     * Appends and returns a new empty "field" element
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
     * An XML field(@http://cl/bee/genfrmjava/formdef/schema).
     *
     * This is a complex type.
     */
    public static class FieldImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.formdef.schema.FieldDocument.Field
    {
        private static final long serialVersionUID = 1L;
        
        public FieldImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName TYPE$0 = 
            new javax.xml.namespace.QName("http://cl/bee/genfrmjava/formdef/schema", "type");
        private static final javax.xml.namespace.QName FMS$2 = 
            new javax.xml.namespace.QName("http://cl/bee/genfrmjava/formdef/schema", "fms");
        private static final javax.xml.namespace.QName DEFAULT$4 = 
            new javax.xml.namespace.QName("http://cl/bee/genfrmjava/formdef/schema", "default");
        private static final javax.xml.namespace.QName INDEX$6 = 
            new javax.xml.namespace.QName("http://cl/bee/genfrmjava/formdef/schema", "index");
        private static final javax.xml.namespace.QName NAME$8 = 
            new javax.xml.namespace.QName("", "name");
        private static final javax.xml.namespace.QName SPECIAL$10 = 
            new javax.xml.namespace.QName("", "special");
        
        
        /**
         * Gets array of all "type" elements
         */
        public cl.bee.genfrmjava.formdef.schema.TypeDocument.Type[] getTypeArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(TYPE$0, targetList);
                cl.bee.genfrmjava.formdef.schema.TypeDocument.Type[] result = new cl.bee.genfrmjava.formdef.schema.TypeDocument.Type[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "type" element
         */
        public cl.bee.genfrmjava.formdef.schema.TypeDocument.Type getTypeArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.TypeDocument.Type target = null;
                target = (cl.bee.genfrmjava.formdef.schema.TypeDocument.Type)get_store().find_element_user(TYPE$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "type" element
         */
        public int sizeOfTypeArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(TYPE$0);
            }
        }
        
        /**
         * Sets array of all "type" element
         */
        public void setTypeArray(cl.bee.genfrmjava.formdef.schema.TypeDocument.Type[] typeArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(typeArray, TYPE$0);
            }
        }
        
        /**
         * Sets ith "type" element
         */
        public void setTypeArray(int i, cl.bee.genfrmjava.formdef.schema.TypeDocument.Type type)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.TypeDocument.Type target = null;
                target = (cl.bee.genfrmjava.formdef.schema.TypeDocument.Type)get_store().find_element_user(TYPE$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(type);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "type" element
         */
        public cl.bee.genfrmjava.formdef.schema.TypeDocument.Type insertNewType(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.TypeDocument.Type target = null;
                target = (cl.bee.genfrmjava.formdef.schema.TypeDocument.Type)get_store().insert_element_user(TYPE$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "type" element
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
         * Removes the ith "type" element
         */
        public void removeType(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(TYPE$0, i);
            }
        }
        
        /**
         * Gets array of all "fms" elements
         */
        public cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms[] getFmsArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(FMS$2, targetList);
                cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms[] result = new cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "fms" element
         */
        public cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms getFmsArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms target = null;
                target = (cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms)get_store().find_element_user(FMS$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "fms" element
         */
        public int sizeOfFmsArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(FMS$2);
            }
        }
        
        /**
         * Sets array of all "fms" element
         */
        public void setFmsArray(cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms[] fmsArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(fmsArray, FMS$2);
            }
        }
        
        /**
         * Sets ith "fms" element
         */
        public void setFmsArray(int i, cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms fms)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms target = null;
                target = (cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms)get_store().find_element_user(FMS$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(fms);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "fms" element
         */
        public cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms insertNewFms(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms target = null;
                target = (cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms)get_store().insert_element_user(FMS$2, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "fms" element
         */
        public cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms addNewFms()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms target = null;
                target = (cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms)get_store().add_element_user(FMS$2);
                return target;
            }
        }
        
        /**
         * Removes the ith "fms" element
         */
        public void removeFms(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(FMS$2, i);
            }
        }
        
        /**
         * Gets array of all "default" elements
         */
        public cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default[] getDefaultArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(DEFAULT$4, targetList);
                cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default[] result = new cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "default" element
         */
        public cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default getDefaultArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default target = null;
                target = (cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default)get_store().find_element_user(DEFAULT$4, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "default" element
         */
        public int sizeOfDefaultArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(DEFAULT$4);
            }
        }
        
        /**
         * Sets array of all "default" element
         */
        public void setDefaultArray(cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default[] xdefaultArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(xdefaultArray, DEFAULT$4);
            }
        }
        
        /**
         * Sets ith "default" element
         */
        public void setDefaultArray(int i, cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default xdefault)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default target = null;
                target = (cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default)get_store().find_element_user(DEFAULT$4, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(xdefault);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "default" element
         */
        public cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default insertNewDefault(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default target = null;
                target = (cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default)get_store().insert_element_user(DEFAULT$4, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "default" element
         */
        public cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default addNewDefault()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default target = null;
                target = (cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default)get_store().add_element_user(DEFAULT$4);
                return target;
            }
        }
        
        /**
         * Removes the ith "default" element
         */
        public void removeDefault(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(DEFAULT$4, i);
            }
        }
        
        /**
         * Gets array of all "index" elements
         */
        public cl.bee.genfrmjava.formdef.schema.IndexDocument.Index[] getIndexArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(INDEX$6, targetList);
                cl.bee.genfrmjava.formdef.schema.IndexDocument.Index[] result = new cl.bee.genfrmjava.formdef.schema.IndexDocument.Index[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "index" element
         */
        public cl.bee.genfrmjava.formdef.schema.IndexDocument.Index getIndexArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.IndexDocument.Index target = null;
                target = (cl.bee.genfrmjava.formdef.schema.IndexDocument.Index)get_store().find_element_user(INDEX$6, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "index" element
         */
        public int sizeOfIndexArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(INDEX$6);
            }
        }
        
        /**
         * Sets array of all "index" element
         */
        public void setIndexArray(cl.bee.genfrmjava.formdef.schema.IndexDocument.Index[] indexArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(indexArray, INDEX$6);
            }
        }
        
        /**
         * Sets ith "index" element
         */
        public void setIndexArray(int i, cl.bee.genfrmjava.formdef.schema.IndexDocument.Index index)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.IndexDocument.Index target = null;
                target = (cl.bee.genfrmjava.formdef.schema.IndexDocument.Index)get_store().find_element_user(INDEX$6, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(index);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "index" element
         */
        public cl.bee.genfrmjava.formdef.schema.IndexDocument.Index insertNewIndex(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.IndexDocument.Index target = null;
                target = (cl.bee.genfrmjava.formdef.schema.IndexDocument.Index)get_store().insert_element_user(INDEX$6, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "index" element
         */
        public cl.bee.genfrmjava.formdef.schema.IndexDocument.Index addNewIndex()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.IndexDocument.Index target = null;
                target = (cl.bee.genfrmjava.formdef.schema.IndexDocument.Index)get_store().add_element_user(INDEX$6);
                return target;
            }
        }
        
        /**
         * Removes the ith "index" element
         */
        public void removeIndex(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(INDEX$6, i);
            }
        }
        
        /**
         * Gets the "name" attribute
         */
        public java.lang.String getName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$8);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$8);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$8);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(NAME$8);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$8);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(NAME$8);
                }
                target.set(name);
            }
        }
        
        /**
         * Gets the "special" attribute
         */
        public java.lang.String getSpecial()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SPECIAL$10);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_default_attribute_value(SPECIAL$10);
                }
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "special" attribute
         */
        public org.apache.xmlbeans.XmlString xgetSpecial()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(SPECIAL$10);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_default_attribute_value(SPECIAL$10);
                }
                return target;
            }
        }
        
        /**
         * True if has "special" attribute
         */
        public boolean isSetSpecial()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().find_attribute_user(SPECIAL$10) != null;
            }
        }
        
        /**
         * Sets the "special" attribute
         */
        public void setSpecial(java.lang.String special)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SPECIAL$10);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(SPECIAL$10);
                }
                target.setStringValue(special);
            }
        }
        
        /**
         * Sets (as xml) the "special" attribute
         */
        public void xsetSpecial(org.apache.xmlbeans.XmlString special)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(SPECIAL$10);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(SPECIAL$10);
                }
                target.set(special);
            }
        }
        
        /**
         * Unsets the "special" attribute
         */
        public void unsetSpecial()
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_attribute(SPECIAL$10);
            }
        }
    }
}
