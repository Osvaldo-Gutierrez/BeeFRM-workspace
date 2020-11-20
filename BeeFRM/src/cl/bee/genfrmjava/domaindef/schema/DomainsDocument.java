/*
 * An XML document type.
 * Localname: domains
 * Namespace: http://cl/bee/genfrmjava/domaindef/schema
 * Java type: cl.bee.genfrmjava.domaindef.schema.DomainsDocument
 *
 * Automatically generated - do not modify.
 */
package cl.bee.genfrmjava.domaindef.schema;


/**
 * A document containing one domains(@http://cl/bee/genfrmjava/domaindef/schema) element.
 *
 * This is a complex type.
 */
public interface DomainsDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(DomainsDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s225DE17AEEF28B18B251CA4F5F9AA65C").resolveHandle("domains8980doctype");
    
    /**
     * Gets the "domains" element
     */
    cl.bee.genfrmjava.domaindef.schema.DomainsDocument.Domains getDomains();
    
    /**
     * Sets the "domains" element
     */
    void setDomains(cl.bee.genfrmjava.domaindef.schema.DomainsDocument.Domains domains);
    
    /**
     * Appends and returns a new empty "domains" element
     */
    cl.bee.genfrmjava.domaindef.schema.DomainsDocument.Domains addNewDomains();
    
    /**
     * An XML domains(@http://cl/bee/genfrmjava/domaindef/schema).
     *
     * This is a complex type.
     */
    public interface Domains extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Domains.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s225DE17AEEF28B18B251CA4F5F9AA65C").resolveHandle("domains629belemtype");
        
        /**
         * Gets array of all "domain" elements
         */
        cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain[] getDomainArray();
        
        /**
         * Gets ith "domain" element
         */
        cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain getDomainArray(int i);
        
        /**
         * Returns number of "domain" element
         */
        int sizeOfDomainArray();
        
        /**
         * Sets array of all "domain" element
         */
        void setDomainArray(cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain[] domainArray);
        
        /**
         * Sets ith "domain" element
         */
        void setDomainArray(int i, cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain domain);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "domain" element
         */
        cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain insertNewDomain(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "domain" element
         */
        cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain addNewDomain();
        
        /**
         * Removes the ith "domain" element
         */
        void removeDomain(int i);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static cl.bee.genfrmjava.domaindef.schema.DomainsDocument.Domains newInstance() {
              return (cl.bee.genfrmjava.domaindef.schema.DomainsDocument.Domains) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static cl.bee.genfrmjava.domaindef.schema.DomainsDocument.Domains newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (cl.bee.genfrmjava.domaindef.schema.DomainsDocument.Domains) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static cl.bee.genfrmjava.domaindef.schema.DomainsDocument newInstance() {
          return (cl.bee.genfrmjava.domaindef.schema.DomainsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static cl.bee.genfrmjava.domaindef.schema.DomainsDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (cl.bee.genfrmjava.domaindef.schema.DomainsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static cl.bee.genfrmjava.domaindef.schema.DomainsDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.domaindef.schema.DomainsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static cl.bee.genfrmjava.domaindef.schema.DomainsDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.domaindef.schema.DomainsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static cl.bee.genfrmjava.domaindef.schema.DomainsDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.domaindef.schema.DomainsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static cl.bee.genfrmjava.domaindef.schema.DomainsDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.domaindef.schema.DomainsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static cl.bee.genfrmjava.domaindef.schema.DomainsDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.domaindef.schema.DomainsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static cl.bee.genfrmjava.domaindef.schema.DomainsDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.domaindef.schema.DomainsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static cl.bee.genfrmjava.domaindef.schema.DomainsDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.domaindef.schema.DomainsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static cl.bee.genfrmjava.domaindef.schema.DomainsDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.domaindef.schema.DomainsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static cl.bee.genfrmjava.domaindef.schema.DomainsDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.domaindef.schema.DomainsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static cl.bee.genfrmjava.domaindef.schema.DomainsDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.domaindef.schema.DomainsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static cl.bee.genfrmjava.domaindef.schema.DomainsDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.domaindef.schema.DomainsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static cl.bee.genfrmjava.domaindef.schema.DomainsDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.domaindef.schema.DomainsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static cl.bee.genfrmjava.domaindef.schema.DomainsDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.domaindef.schema.DomainsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static cl.bee.genfrmjava.domaindef.schema.DomainsDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.domaindef.schema.DomainsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cl.bee.genfrmjava.domaindef.schema.DomainsDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cl.bee.genfrmjava.domaindef.schema.DomainsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cl.bee.genfrmjava.domaindef.schema.DomainsDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cl.bee.genfrmjava.domaindef.schema.DomainsDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
