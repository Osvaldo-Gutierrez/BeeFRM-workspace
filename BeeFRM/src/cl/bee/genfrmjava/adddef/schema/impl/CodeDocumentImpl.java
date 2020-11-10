/*
 * An XML document type.
 * Localname: code
 * Namespace: http://cl/bee/genfrmjava/adddef/schema
 * Java type: cl.bee.genfrmjava.adddef.schema.CodeDocument
 *
 * Automatically generated - do not modify.
 */
package cl.bee.genfrmjava.adddef.schema.impl;
/**
 * A document containing one code(@http://cl/bee/genfrmjava/adddef/schema) element.
 *
 * This is a complex type.
 */
public class CodeDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.adddef.schema.CodeDocument
{
    private static final long serialVersionUID = 1L;
    
    public CodeDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CODE$0 = 
        new javax.xml.namespace.QName("http://cl/bee/genfrmjava/adddef/schema", "code");
    
    
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
}
