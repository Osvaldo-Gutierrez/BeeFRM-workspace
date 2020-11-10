/*
 * An XML document type.
 * Localname: section
 * Namespace: http://cl/bee/genfrmjava/adddef/schema
 * Java type: cl.bee.genfrmjava.adddef.schema.SectionDocument
 *
 * Automatically generated - do not modify.
 */
package cl.bee.genfrmjava.adddef.schema.impl;
/**
 * A document containing one section(@http://cl/bee/genfrmjava/adddef/schema) element.
 *
 * This is a complex type.
 */
public class SectionDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.adddef.schema.SectionDocument
{
    private static final long serialVersionUID = 1L;
    
    public SectionDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName SECTION$0 = 
        new javax.xml.namespace.QName("http://cl/bee/genfrmjava/adddef/schema", "section");
    
    
    /**
     * Gets the "section" element
     */
    public cl.bee.genfrmjava.adddef.schema.SectionDocument.Section getSection()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.adddef.schema.SectionDocument.Section target = null;
            target = (cl.bee.genfrmjava.adddef.schema.SectionDocument.Section)get_store().find_element_user(SECTION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "section" element
     */
    public void setSection(cl.bee.genfrmjava.adddef.schema.SectionDocument.Section section)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.adddef.schema.SectionDocument.Section target = null;
            target = (cl.bee.genfrmjava.adddef.schema.SectionDocument.Section)get_store().find_element_user(SECTION$0, 0);
            if (target == null)
            {
                target = (cl.bee.genfrmjava.adddef.schema.SectionDocument.Section)get_store().add_element_user(SECTION$0);
            }
            target.set(section);
        }
    }
    
    /**
     * Appends and returns a new empty "section" element
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
     * An XML section(@http://cl/bee/genfrmjava/adddef/schema).
     *
     * This is a complex type.
     */
    public static class SectionImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.adddef.schema.SectionDocument.Section
    {
        private static final long serialVersionUID = 1L;
        
        public SectionImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName CODE$0 = 
            new javax.xml.namespace.QName("http://cl/bee/genfrmjava/adddef/schema", "code");
        private static final javax.xml.namespace.QName NAME$2 = 
            new javax.xml.namespace.QName("", "name");
        
        
        /**
         * Gets the "code" element
         */
        public java.lang.String getCode()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CODE$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "code" element
         */
        public org.apache.xmlbeans.XmlString xgetCode()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CODE$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "code" element
         */
        public void setCode(java.lang.String code)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CODE$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CODE$0);
                }
                target.setStringValue(code);
            }
        }
        
        /**
         * Sets (as xml) the "code" element
         */
        public void xsetCode(org.apache.xmlbeans.XmlString code)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CODE$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CODE$0);
                }
                target.set(code);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$2);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$2);
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
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(NAME$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(NAME$2);
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
                target = (org.apache.xmlbeans.XmlString)get_store().find_attribute_user(NAME$2);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_attribute_user(NAME$2);
                }
                target.set(name);
            }
        }
    }
}
