/*
 * An XML document type.
 * Localname: additional
 * Namespace: http://cl/bee/genfrmjava/adddef/schema
 * Java type: cl.bee.genfrmjava.adddef.schema.AdditionalDocument
 *
 * Automatically generated - do not modify.
 */
package cl.bee.genfrmjava.adddef.schema.impl;
/**
 * A document containing one additional(@http://cl/bee/genfrmjava/adddef/schema) element.
 *
 * This is a complex type.
 */
public class AdditionalDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.adddef.schema.AdditionalDocument
{
    private static final long serialVersionUID = 1L;
    
    public AdditionalDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ADDITIONAL$0 = 
        new javax.xml.namespace.QName("http://cl/bee/genfrmjava/adddef/schema", "additional");
    
    
    /**
     * Gets the "additional" element
     */
    public cl.bee.genfrmjava.adddef.schema.AdditionalDocument.Additional getAdditional()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.adddef.schema.AdditionalDocument.Additional target = null;
            target = (cl.bee.genfrmjava.adddef.schema.AdditionalDocument.Additional)get_store().find_element_user(ADDITIONAL$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "additional" element
     */
    public void setAdditional(cl.bee.genfrmjava.adddef.schema.AdditionalDocument.Additional additional)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.adddef.schema.AdditionalDocument.Additional target = null;
            target = (cl.bee.genfrmjava.adddef.schema.AdditionalDocument.Additional)get_store().find_element_user(ADDITIONAL$0, 0);
            if (target == null)
            {
                target = (cl.bee.genfrmjava.adddef.schema.AdditionalDocument.Additional)get_store().add_element_user(ADDITIONAL$0);
            }
            target.set(additional);
        }
    }
    
    /**
     * Appends and returns a new empty "additional" element
     */
    public cl.bee.genfrmjava.adddef.schema.AdditionalDocument.Additional addNewAdditional()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.adddef.schema.AdditionalDocument.Additional target = null;
            target = (cl.bee.genfrmjava.adddef.schema.AdditionalDocument.Additional)get_store().add_element_user(ADDITIONAL$0);
            return target;
        }
    }
    /**
     * An XML additional(@http://cl/bee/genfrmjava/adddef/schema).
     *
     * This is a complex type.
     */
    public static class AdditionalImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.adddef.schema.AdditionalDocument.Additional
    {
        private static final long serialVersionUID = 1L;
        
        public AdditionalImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName SECTION$0 = 
            new javax.xml.namespace.QName("http://cl/bee/genfrmjava/adddef/schema", "section");
        private static final javax.xml.namespace.QName SYSTEM$2 = 
            new javax.xml.namespace.QName("", "system");
        private static final javax.xml.namespace.QName FORM$4 = 
            new javax.xml.namespace.QName("", "form");
        
        
        /**
         * Gets array of all "section" elements
         */
        public cl.bee.genfrmjava.adddef.schema.SectionDocument.Section[] getSectionArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(SECTION$0, targetList);
                cl.bee.genfrmjava.adddef.schema.SectionDocument.Section[] result = new cl.bee.genfrmjava.adddef.schema.SectionDocument.Section[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "section" element
         */
        public cl.bee.genfrmjava.adddef.schema.SectionDocument.Section getSectionArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.adddef.schema.SectionDocument.Section target = null;
                target = (cl.bee.genfrmjava.adddef.schema.SectionDocument.Section)get_store().find_element_user(SECTION$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "section" element
         */
        public int sizeOfSectionArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(SECTION$0);
            }
        }
        
        /**
         * Sets array of all "section" element
         */
        public void setSectionArray(cl.bee.genfrmjava.adddef.schema.SectionDocument.Section[] sectionArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(sectionArray, SECTION$0);
            }
        }
        
        /**
         * Sets ith "section" element
         */
        public void setSectionArray(int i, cl.bee.genfrmjava.adddef.schema.SectionDocument.Section section)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.adddef.schema.SectionDocument.Section target = null;
                target = (cl.bee.genfrmjava.adddef.schema.SectionDocument.Section)get_store().find_element_user(SECTION$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(section);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "section" element
         */
        public cl.bee.genfrmjava.adddef.schema.SectionDocument.Section insertNewSection(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.adddef.schema.SectionDocument.Section target = null;
                target = (cl.bee.genfrmjava.adddef.schema.SectionDocument.Section)get_store().insert_element_user(SECTION$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "section" element
         */
        public cl.bee.genfrmjava.adddef.schema.SectionDocument.Section addNewSection()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.adddef.schema.SectionDocument.Section target = null;
                target = (cl.bee.genfrmjava.adddef.schema.SectionDocument.Section)get_store().add_element_user(SECTION$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "section" element
         */
        public void removeSection(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(SECTION$0, i);
            }
        }
        
        /**
         * Gets the "system" attribute
         */
        public java.lang.String getSystem()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SYSTEM$2);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "system" attribute
         */
        public org.apache.xmlbeans.XmlString xgetSystem()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(SYSTEM$2);
                return target;
            }
        }
        
        /**
         * Sets the "system" attribute
         */
        public void setSystem(java.lang.String system)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(SYSTEM$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(SYSTEM$2);
                }
                target.setStringValue(system);
            }
        }
        
        /**
         * Sets (as xml) the "system" attribute
         */
        public void xsetSystem(org.apache.xmlbeans.XmlString system)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(SYSTEM$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(SYSTEM$2);
                }
                target.set(system);
            }
        }
        
        /**
         * Gets the "form" attribute
         */
        public java.lang.String getForm()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(FORM$4);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "form" attribute
         */
        public org.apache.xmlbeans.XmlString xgetForm()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(FORM$4);
                return target;
            }
        }
        
        /**
         * Sets the "form" attribute
         */
        public void setForm(java.lang.String form)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(FORM$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(FORM$4);
                }
                target.setStringValue(form);
            }
        }
        
        /**
         * Sets (as xml) the "form" attribute
         */
        public void xsetForm(org.apache.xmlbeans.XmlString form)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(FORM$4);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(FORM$4);
                }
                target.set(form);
            }
        }
    }
}
