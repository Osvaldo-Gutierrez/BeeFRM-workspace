/*
 * An XML document type.
 * Localname: form
 * Namespace: http://cl/bee/genfrmjava/formdef/schema
 * Java type: cl.bee.genfrmjava.formdef.schema.FormDocument
 *
 * Automatically generated - do not modify.
 */
package cl.bee.genfrmjava.formdef.schema.impl;
/**
 * A document containing one form(@http://cl/bee/genfrmjava/formdef/schema) element.
 *
 * This is a complex type.
 */
public class FormDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.formdef.schema.FormDocument
{
    private static final long serialVersionUID = 1L;
    
    public FormDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName FORM$0 = 
        new javax.xml.namespace.QName("http://cl/bee/genfrmjava/formdef/schema", "form");
    
    
    /**
     * Gets the "form" element
     */
    public cl.bee.genfrmjava.formdef.schema.FormDocument.Form getForm()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.formdef.schema.FormDocument.Form target = null;
            target = (cl.bee.genfrmjava.formdef.schema.FormDocument.Form)get_store().find_element_user(FORM$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "form" element
     */
    public void setForm(cl.bee.genfrmjava.formdef.schema.FormDocument.Form form)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.formdef.schema.FormDocument.Form target = null;
            target = (cl.bee.genfrmjava.formdef.schema.FormDocument.Form)get_store().find_element_user(FORM$0, 0);
            if (target == null)
            {
                target = (cl.bee.genfrmjava.formdef.schema.FormDocument.Form)get_store().add_element_user(FORM$0);
            }
            target.set(form);
        }
    }
    
    /**
     * Appends and returns a new empty "form" element
     */
    public cl.bee.genfrmjava.formdef.schema.FormDocument.Form addNewForm()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.formdef.schema.FormDocument.Form target = null;
            target = (cl.bee.genfrmjava.formdef.schema.FormDocument.Form)get_store().add_element_user(FORM$0);
            return target;
        }
    }
    /**
     * An XML form(@http://cl/bee/genfrmjava/formdef/schema).
     *
     * This is a complex type.
     */
    public static class FormImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.formdef.schema.FormDocument.Form
    {
        private static final long serialVersionUID = 1L;
        
        public FormImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName FIELD$0 = 
            new javax.xml.namespace.QName("http://cl/bee/genfrmjava/formdef/schema", "field");
        private static final javax.xml.namespace.QName ARRAY$2 = 
            new javax.xml.namespace.QName("http://cl/bee/genfrmjava/formdef/schema", "array");
        private static final javax.xml.namespace.QName PRIMARY$4 = 
            new javax.xml.namespace.QName("http://cl/bee/genfrmjava/formdef/schema", "primary");
        private static final javax.xml.namespace.QName FOREIGN$6 = 
            new javax.xml.namespace.QName("http://cl/bee/genfrmjava/formdef/schema", "foreign");
        private static final javax.xml.namespace.QName TEXT$8 = 
            new javax.xml.namespace.QName("http://cl/bee/genfrmjava/formdef/schema", "text");
        private static final javax.xml.namespace.QName ENTITY$10 = 
            new javax.xml.namespace.QName("", "entity");
        private static final javax.xml.namespace.QName NAME$11 = 
                new javax.xml.namespace.QName("", "name");
        private static final javax.xml.namespace.QName POSX$12 = 
                new javax.xml.namespace.QName("", "posx");
        private static final javax.xml.namespace.QName POSY$13 = 
                new javax.xml.namespace.QName("", "posy");
        private static final javax.xml.namespace.QName WIDTH$14 = 
                new javax.xml.namespace.QName("", "width");
        
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
         * Gets array of all "array" elements
         */
        public cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array[] getArrayArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(ARRAY$2, targetList);
                cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array[] result = new cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "array" element
         */
        public cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array getArrayArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array target = null;
                target = (cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array)get_store().find_element_user(ARRAY$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "array" element
         */
        public int sizeOfArrayArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(ARRAY$2);
            }
        }
        
        /**
         * Sets array of all "array" element
         */
        public void setArrayArray(cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array[] arrayArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(arrayArray, ARRAY$2);
            }
        }
        
        /**
         * Sets ith "array" element
         */
        public void setArrayArray(int i, cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array array)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array target = null;
                target = (cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array)get_store().find_element_user(ARRAY$2, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(array);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "array" element
         */
        public cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array insertNewArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array target = null;
                target = (cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array)get_store().insert_element_user(ARRAY$2, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "array" element
         */
        public cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array addNewArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array target = null;
                target = (cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array)get_store().add_element_user(ARRAY$2);
                return target;
            }
        }
        
        /**
         * Removes the ith "array" element
         */
        public void removeArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(ARRAY$2, i);
            }
        }
        
        /**
         * Gets array of all "primary" elements
         */
        public cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary[] getPrimaryArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(PRIMARY$4, targetList);
                cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary[] result = new cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "primary" element
         */
        public cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary getPrimaryArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary target = null;
                target = (cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary)get_store().find_element_user(PRIMARY$4, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "primary" element
         */
        public int sizeOfPrimaryArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(PRIMARY$4);
            }
        }
        
        /**
         * Sets array of all "primary" element
         */
        public void setPrimaryArray(cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary[] primaryArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(primaryArray, PRIMARY$4);
            }
        }
        
        /**
         * Sets ith "primary" element
         */
        public void setPrimaryArray(int i, cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary primary)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary target = null;
                target = (cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary)get_store().find_element_user(PRIMARY$4, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(primary);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "primary" element
         */
        public cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary insertNewPrimary(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary target = null;
                target = (cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary)get_store().insert_element_user(PRIMARY$4, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "primary" element
         */
        public cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary addNewPrimary()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary target = null;
                target = (cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary)get_store().add_element_user(PRIMARY$4);
                return target;
            }
        }
        
        /**
         * Removes the ith "primary" element
         */
        public void removePrimary(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(PRIMARY$4, i);
            }
        }
        
        /**
         * Gets array of all "foreign" elements
         */
        public cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign[] getForeignArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(FOREIGN$6, targetList);
                cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign[] result = new cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "foreign" element
         */
        public cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign getForeignArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign target = null;
                target = (cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign)get_store().find_element_user(FOREIGN$6, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "foreign" element
         */
        public int sizeOfForeignArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(FOREIGN$6);
            }
        }
        
        /**
         * Sets array of all "foreign" element
         */
        public void setForeignArray(cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign[] foreignArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(foreignArray, FOREIGN$6);
            }
        }
        
        /**
         * Sets ith "foreign" element
         */
        public void setForeignArray(int i, cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign foreign)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign target = null;
                target = (cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign)get_store().find_element_user(FOREIGN$6, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(foreign);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "foreign" element
         */
        public cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign insertNewForeign(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign target = null;
                target = (cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign)get_store().insert_element_user(FOREIGN$6, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "foreign" element
         */
        public cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign addNewForeign()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign target = null;
                target = (cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign)get_store().add_element_user(FOREIGN$6);
                return target;
            }
        }
        
        /**
         * Removes the ith "foreign" element
         */
        public void removeForeign(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(FOREIGN$6, i);
            }
        }
        
        /**
         * Gets array of all "text" elements
         */
        public cl.bee.genfrmjava.formdef.schema.TextDocument.Text[] getTextArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(TEXT$8, targetList);
                cl.bee.genfrmjava.formdef.schema.TextDocument.Text[] result = new cl.bee.genfrmjava.formdef.schema.TextDocument.Text[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "text" element
         */
        public cl.bee.genfrmjava.formdef.schema.TextDocument.Text getTextArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.TextDocument.Text target = null;
                target = (cl.bee.genfrmjava.formdef.schema.TextDocument.Text)get_store().find_element_user(TEXT$8, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "text" element
         */
        public int sizeOfTextArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(TEXT$8);
            }
        }
        
        /**
         * Sets array of all "text" element
         */
        public void setTextArray(cl.bee.genfrmjava.formdef.schema.TextDocument.Text[] textArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(textArray, TEXT$8);
            }
        }
        
        /**
         * Sets ith "text" element
         */
        public void setTextArray(int i, cl.bee.genfrmjava.formdef.schema.TextDocument.Text text)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.TextDocument.Text target = null;
                target = (cl.bee.genfrmjava.formdef.schema.TextDocument.Text)get_store().find_element_user(TEXT$8, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(text);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "text" element
         */
        public cl.bee.genfrmjava.formdef.schema.TextDocument.Text insertNewText(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.TextDocument.Text target = null;
                target = (cl.bee.genfrmjava.formdef.schema.TextDocument.Text)get_store().insert_element_user(TEXT$8, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "text" element
         */
        public cl.bee.genfrmjava.formdef.schema.TextDocument.Text addNewText()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.TextDocument.Text target = null;
                target = (cl.bee.genfrmjava.formdef.schema.TextDocument.Text)get_store().add_element_user(TEXT$8);
                return target;
            }
        }
        
        /**
         * Removes the ith "text" element
         */
        public void removeText(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(TEXT$8, i);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ENTITY$10);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ENTITY$10);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ENTITY$10);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ENTITY$10);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(ENTITY$10);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(ENTITY$10);
                }
                target.set(entity);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$11);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$11);
                return target;
            }
        }
        
        /**
         * Sets the "name" attribute
         */
        public void setName(java.lang.String entity)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$11);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(NAME$11);
                }
                target.setStringValue(entity);
            }
        }
        
        /**
         * Sets (as xml) the "name" attribute
         */
        public void xsetName(org.apache.xmlbeans.XmlString entity)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$11);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(NAME$11);
                }
                target.set(entity);
            }
        }
        
        /**
         * Gets the "posX" attribute
         */
        public long getPosX()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(POSX$12);
                if (target == null)
                {
                	return 0L;
                }
                return target.getLongValue();
            }
        }
        
        /**
         * Gets (as xml) the "posX" attribute
         */
        public org.apache.xmlbeans.XmlUnsignedInt xgetPosX()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlUnsignedInt target = null;
                target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().find_attribute_user(POSX$12);
                return target;
            }
        }
        
        /**
         * Sets the "posX" attribute
         */
        public void setPosX(long entity)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(POSX$12);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(POSX$12);
                }
                target.setLongValue(entity);
            }
        }
        
        /**
         * Sets (as xml) the "posX" attribute
         */
        public void xsetPosX(org.apache.xmlbeans.XmlUnsignedInt entity)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlUnsignedInt target = null;
                target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().find_attribute_user(POSX$12);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().add_attribute_user(POSX$12);
                }
                target.set(entity);
            }
        }
        
        /**
         * Gets the "posY" attribute
         */
        public long getPosY()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(POSY$13);
                if (target == null)
                {
                	return 0L;
                }
                return target.getLongValue();
            }
        }
        
        /**
         * Gets (as xml) the "posY" attribute
         */
        public org.apache.xmlbeans.XmlUnsignedInt xgetPosY()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlUnsignedInt target = null;
                target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().find_attribute_user(POSY$13);
                return target;
            }
        }
        
        /**
         * Sets the "posY" attribute
         */
        public void setPosY(long entity)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(POSY$13);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(POSY$13);
                }
                target.setLongValue(entity);
            }
        }
        
        /**
         * Sets (as xml) the "posY" attribute
         */
        public void xsetPosY(org.apache.xmlbeans.XmlUnsignedInt entity)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlUnsignedInt target = null;
                target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().find_attribute_user(POSY$13);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().add_attribute_user(POSY$13);
                }
                target.set(entity);
            }
        }
        
        /**
         * Gets the "width" attribute
         */
        public long getWidth()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(WIDTH$14);
                if (target == null)
                {
                	return 0L;
                }
                return target.getLongValue();
            }
        }
        
        /**
         * Gets (as xml) the "width" attribute
         */
        public org.apache.xmlbeans.XmlUnsignedInt xgetWidth()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlUnsignedInt target = null;
                target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().find_attribute_user(WIDTH$14);
                return target;
            }
        }
        
        /**
         * Sets the "width" attribute
         */
        public void setWidth(long entity)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(WIDTH$14);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(WIDTH$14);
                }
                target.setLongValue(entity);
            }
        }
        
        /**
         * Sets (as xml) the "width" attribute
         */
        public void xsetWidth(org.apache.xmlbeans.XmlUnsignedInt entity)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlUnsignedInt target = null;
                target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().find_attribute_user(WIDTH$14);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlUnsignedInt)get_store().add_attribute_user(WIDTH$14);
                }
                target.set(entity);
            }
        }
    }
}
