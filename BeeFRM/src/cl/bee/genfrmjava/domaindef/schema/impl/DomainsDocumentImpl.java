/*
 * An XML document type.
 * Localname: domains
 * Namespace: http://cl/bee/genfrmjava/domaindef/schema
 * Java type: cl.bee.genfrmjava.domaindef.schema.DomainsDocument
 *
 * Automatically generated - do not modify.
 */
package cl.bee.genfrmjava.domaindef.schema.impl;
/**
 * A document containing one domains(@http://cl/bee/genfrmjava/domaindef/schema) element.
 *
 * This is a complex type.
 */
public class DomainsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.domaindef.schema.DomainsDocument
{
    private static final long serialVersionUID = 1L;
    
    public DomainsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName DOMAINS$0 = 
        new javax.xml.namespace.QName("http://cl/bee/genfrmjava/domaindef/schema", "domains");
    
    
    /**
     * Gets the "domains" element
     */
    public cl.bee.genfrmjava.domaindef.schema.DomainsDocument.Domains getDomains()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.domaindef.schema.DomainsDocument.Domains target = null;
            target = (cl.bee.genfrmjava.domaindef.schema.DomainsDocument.Domains)get_store().find_element_user(DOMAINS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "domains" element
     */
    public void setDomains(cl.bee.genfrmjava.domaindef.schema.DomainsDocument.Domains domains)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.domaindef.schema.DomainsDocument.Domains target = null;
            target = (cl.bee.genfrmjava.domaindef.schema.DomainsDocument.Domains)get_store().find_element_user(DOMAINS$0, 0);
            if (target == null)
            {
                target = (cl.bee.genfrmjava.domaindef.schema.DomainsDocument.Domains)get_store().add_element_user(DOMAINS$0);
            }
            target.set(domains);
        }
    }
    
    /**
     * Appends and returns a new empty "domains" element
     */
    public cl.bee.genfrmjava.domaindef.schema.DomainsDocument.Domains addNewDomains()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.domaindef.schema.DomainsDocument.Domains target = null;
            target = (cl.bee.genfrmjava.domaindef.schema.DomainsDocument.Domains)get_store().add_element_user(DOMAINS$0);
            return target;
        }
    }
    /**
     * An XML domains(@http://cl/bee/genfrmjava/domaindef/schema).
     *
     * This is a complex type.
     */
    public static class DomainsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.domaindef.schema.DomainsDocument.Domains
    {
        private static final long serialVersionUID = 1L;
        
        public DomainsImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName DOMAIN$0 = 
            new javax.xml.namespace.QName("http://cl/bee/genfrmjava/domaindef/schema", "domain");
        
        
        /**
         * Gets array of all "domain" elements
         */
        public cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain[] getDomainArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(DOMAIN$0, targetList);
                cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain[] result = new cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "domain" element
         */
        public cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain getDomainArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain target = null;
                target = (cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain)get_store().find_element_user(DOMAIN$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "domain" element
         */
        public int sizeOfDomainArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(DOMAIN$0);
            }
        }
        
        /**
         * Sets array of all "domain" element
         */
        public void setDomainArray(cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain[] domainArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(domainArray, DOMAIN$0);
            }
        }
        
        /**
         * Sets ith "domain" element
         */
        public void setDomainArray(int i, cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain domain)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain target = null;
                target = (cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain)get_store().find_element_user(DOMAIN$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(domain);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "domain" element
         */
        public cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain insertNewDomain(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain target = null;
                target = (cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain)get_store().insert_element_user(DOMAIN$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "domain" element
         */
        public cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain addNewDomain()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain target = null;
                target = (cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain)get_store().add_element_user(DOMAIN$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "domain" element
         */
        public void removeDomain(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(DOMAIN$0, i);
            }
        }
    }
}
