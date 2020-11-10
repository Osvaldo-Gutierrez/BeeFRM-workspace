/*
 * An XML document type.
 * Localname: domain
 * Namespace: http://cl/bee/genfrmjava/domaindef/schema
 * Java type: cl.bee.genfrmjava.domaindef.schema.DomainDocument
 *
 * Automatically generated - do not modify.
 */
package cl.bee.genfrmjava.domaindef.schema;


/**
 * A document containing one domain(@http://cl/bee/genfrmjava/domaindef/schema) element.
 *
 * This is a complex type.
 */
public interface DomainDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(DomainDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s86FB8B51BF8A1799A84DF6E21106E5B4").resolveHandle("domain65a7doctype");
    
    /**
     * Gets the "domain" element
     */
    cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain getDomain();
    
    /**
     * Sets the "domain" element
     */
    void setDomain(cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain domain);
    
    /**
     * Appends and returns a new empty "domain" element
     */
    cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain addNewDomain();
    
    /**
     * An XML domain(@http://cl/bee/genfrmjava/domaindef/schema).
     *
     * This is a complex type.
     */
    public interface Domain extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Domain.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s86FB8B51BF8A1799A84DF6E21106E5B4").resolveHandle("domain5e47elemtype");
        
        /**
         * Gets the "name" attribute
         */
        java.lang.String getName();
        
        /**
         * Gets (as xml) the "name" attribute
         */
        org.apache.xmlbeans.XmlString xgetName();
        
        /**
         * Sets the "name" attribute
         */
        void setName(java.lang.String name);
        
        /**
         * Sets (as xml) the "name" attribute
         */
        void xsetName(org.apache.xmlbeans.XmlString name);
        
        /**
         * Gets the "system" attribute
         */
        java.lang.String getSystem();
        
        /**
         * Gets (as xml) the "system" attribute
         */
        org.apache.xmlbeans.XmlString xgetSystem();
        
        /**
         * Sets the "system" attribute
         */
        void setSystem(java.lang.String system);
        
        /**
         * Sets (as xml) the "system" attribute
         */
        void xsetSystem(org.apache.xmlbeans.XmlString system);
        
        /**
         * Gets the "registry" attribute
         */
        java.lang.String getRegistry();
        
        /**
         * Gets (as xml) the "registry" attribute
         */
        org.apache.xmlbeans.XmlString xgetRegistry();
        
        /**
         * True if has "registry" attribute
         */
        boolean isSetRegistry();
        
        /**
         * Sets the "registry" attribute
         */
        void setRegistry(java.lang.String registry);
        
        /**
         * Sets (as xml) the "registry" attribute
         */
        void xsetRegistry(org.apache.xmlbeans.XmlString registry);
        
        /**
         * Unsets the "registry" attribute
         */
        void unsetRegistry();
        
        /**
         * Gets the "table" attribute
         */
        java.lang.String getTable();
        
        /**
         * Gets (as xml) the "table" attribute
         */
        org.apache.xmlbeans.XmlString xgetTable();
        
        /**
         * Sets the "table" attribute
         */
        void setTable(java.lang.String table);
        
        /**
         * Sets (as xml) the "table" attribute
         */
        void xsetTable(org.apache.xmlbeans.XmlString table);
        
        /**
         * Gets the "validation" attribute
         */
        java.lang.String getValidation();
        
        /**
         * Gets (as xml) the "validation" attribute
         */
        org.apache.xmlbeans.XmlString xgetValidation();
        
        /**
         * True if has "validation" attribute
         */
        boolean isSetValidation();
        
        /**
         * Sets the "validation" attribute
         */
        void setValidation(java.lang.String validation);
        
        /**
         * Sets (as xml) the "validation" attribute
         */
        void xsetValidation(org.apache.xmlbeans.XmlString validation);
        
        /**
         * Unsets the "validation" attribute
         */
        void unsetValidation();
        
        /**
         * Gets the "search" attribute
         */
        java.lang.String getSearch();
        
        /**
         * Gets (as xml) the "search" attribute
         */
        org.apache.xmlbeans.XmlString xgetSearch();
        
        /**
         * True if has "search" attribute
         */
        boolean isSetSearch();
        
        /**
         * Sets the "search" attribute
         */
        void setSearch(java.lang.String search);
        
        /**
         * Sets (as xml) the "search" attribute
         */
        void xsetSearch(org.apache.xmlbeans.XmlString search);
        
        /**
         * Unsets the "search" attribute
         */
        void unsetSearch();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain newInstance() {
              return (cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (cl.bee.genfrmjava.domaindef.schema.DomainDocument.Domain) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static cl.bee.genfrmjava.domaindef.schema.DomainDocument newInstance() {
          return (cl.bee.genfrmjava.domaindef.schema.DomainDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static cl.bee.genfrmjava.domaindef.schema.DomainDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (cl.bee.genfrmjava.domaindef.schema.DomainDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static cl.bee.genfrmjava.domaindef.schema.DomainDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.domaindef.schema.DomainDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static cl.bee.genfrmjava.domaindef.schema.DomainDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.domaindef.schema.DomainDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static cl.bee.genfrmjava.domaindef.schema.DomainDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.domaindef.schema.DomainDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static cl.bee.genfrmjava.domaindef.schema.DomainDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.domaindef.schema.DomainDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static cl.bee.genfrmjava.domaindef.schema.DomainDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.domaindef.schema.DomainDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static cl.bee.genfrmjava.domaindef.schema.DomainDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.domaindef.schema.DomainDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static cl.bee.genfrmjava.domaindef.schema.DomainDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.domaindef.schema.DomainDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static cl.bee.genfrmjava.domaindef.schema.DomainDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.domaindef.schema.DomainDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static cl.bee.genfrmjava.domaindef.schema.DomainDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.domaindef.schema.DomainDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static cl.bee.genfrmjava.domaindef.schema.DomainDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.domaindef.schema.DomainDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static cl.bee.genfrmjava.domaindef.schema.DomainDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.domaindef.schema.DomainDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static cl.bee.genfrmjava.domaindef.schema.DomainDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.domaindef.schema.DomainDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static cl.bee.genfrmjava.domaindef.schema.DomainDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.domaindef.schema.DomainDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static cl.bee.genfrmjava.domaindef.schema.DomainDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.domaindef.schema.DomainDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cl.bee.genfrmjava.domaindef.schema.DomainDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cl.bee.genfrmjava.domaindef.schema.DomainDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cl.bee.genfrmjava.domaindef.schema.DomainDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cl.bee.genfrmjava.domaindef.schema.DomainDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
