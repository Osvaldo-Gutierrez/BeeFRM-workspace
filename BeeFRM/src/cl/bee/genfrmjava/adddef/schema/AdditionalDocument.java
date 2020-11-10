/*
 * An XML document type.
 * Localname: additional
 * Namespace: http://cl/bee/genfrmjava/adddef/schema
 * Java type: cl.bee.genfrmjava.adddef.schema.AdditionalDocument
 *
 * Automatically generated - do not modify.
 */
package cl.bee.genfrmjava.adddef.schema;


/**
 * A document containing one additional(@http://cl/bee/genfrmjava/adddef/schema) element.
 *
 * This is a complex type.
 */
public interface AdditionalDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AdditionalDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s86FB8B51BF8A1799A84DF6E21106E5B4").resolveHandle("additionalee11doctype");
    
    /**
     * Gets the "additional" element
     */
    cl.bee.genfrmjava.adddef.schema.AdditionalDocument.Additional getAdditional();
    
    /**
     * Sets the "additional" element
     */
    void setAdditional(cl.bee.genfrmjava.adddef.schema.AdditionalDocument.Additional additional);
    
    /**
     * Appends and returns a new empty "additional" element
     */
    cl.bee.genfrmjava.adddef.schema.AdditionalDocument.Additional addNewAdditional();
    
    /**
     * An XML additional(@http://cl/bee/genfrmjava/adddef/schema).
     *
     * This is a complex type.
     */
    public interface Additional extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Additional.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s86FB8B51BF8A1799A84DF6E21106E5B4").resolveHandle("additional4554elemtype");
        
        /**
         * Gets array of all "section" elements
         */
        cl.bee.genfrmjava.adddef.schema.SectionDocument.Section[] getSectionArray();
        
        /**
         * Gets ith "section" element
         */
        cl.bee.genfrmjava.adddef.schema.SectionDocument.Section getSectionArray(int i);
        
        /**
         * Returns number of "section" element
         */
        int sizeOfSectionArray();
        
        /**
         * Sets array of all "section" element
         */
        void setSectionArray(cl.bee.genfrmjava.adddef.schema.SectionDocument.Section[] sectionArray);
        
        /**
         * Sets ith "section" element
         */
        void setSectionArray(int i, cl.bee.genfrmjava.adddef.schema.SectionDocument.Section section);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "section" element
         */
        cl.bee.genfrmjava.adddef.schema.SectionDocument.Section insertNewSection(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "section" element
         */
        cl.bee.genfrmjava.adddef.schema.SectionDocument.Section addNewSection();
        
        /**
         * Removes the ith "section" element
         */
        void removeSection(int i);
        
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
         * Gets the "form" attribute
         */
        java.lang.String getForm();
        
        /**
         * Gets (as xml) the "form" attribute
         */
        org.apache.xmlbeans.XmlString xgetForm();
        
        /**
         * Sets the "form" attribute
         */
        void setForm(java.lang.String form);
        
        /**
         * Sets (as xml) the "form" attribute
         */
        void xsetForm(org.apache.xmlbeans.XmlString form);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static cl.bee.genfrmjava.adddef.schema.AdditionalDocument.Additional newInstance() {
              return (cl.bee.genfrmjava.adddef.schema.AdditionalDocument.Additional) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static cl.bee.genfrmjava.adddef.schema.AdditionalDocument.Additional newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (cl.bee.genfrmjava.adddef.schema.AdditionalDocument.Additional) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static cl.bee.genfrmjava.adddef.schema.AdditionalDocument newInstance() {
          return (cl.bee.genfrmjava.adddef.schema.AdditionalDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static cl.bee.genfrmjava.adddef.schema.AdditionalDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (cl.bee.genfrmjava.adddef.schema.AdditionalDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static cl.bee.genfrmjava.adddef.schema.AdditionalDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.adddef.schema.AdditionalDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static cl.bee.genfrmjava.adddef.schema.AdditionalDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.adddef.schema.AdditionalDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static cl.bee.genfrmjava.adddef.schema.AdditionalDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.adddef.schema.AdditionalDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static cl.bee.genfrmjava.adddef.schema.AdditionalDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.adddef.schema.AdditionalDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static cl.bee.genfrmjava.adddef.schema.AdditionalDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.adddef.schema.AdditionalDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static cl.bee.genfrmjava.adddef.schema.AdditionalDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.adddef.schema.AdditionalDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static cl.bee.genfrmjava.adddef.schema.AdditionalDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.adddef.schema.AdditionalDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static cl.bee.genfrmjava.adddef.schema.AdditionalDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.adddef.schema.AdditionalDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static cl.bee.genfrmjava.adddef.schema.AdditionalDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.adddef.schema.AdditionalDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static cl.bee.genfrmjava.adddef.schema.AdditionalDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.adddef.schema.AdditionalDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static cl.bee.genfrmjava.adddef.schema.AdditionalDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.adddef.schema.AdditionalDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static cl.bee.genfrmjava.adddef.schema.AdditionalDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.adddef.schema.AdditionalDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static cl.bee.genfrmjava.adddef.schema.AdditionalDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.adddef.schema.AdditionalDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static cl.bee.genfrmjava.adddef.schema.AdditionalDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.adddef.schema.AdditionalDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cl.bee.genfrmjava.adddef.schema.AdditionalDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cl.bee.genfrmjava.adddef.schema.AdditionalDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cl.bee.genfrmjava.adddef.schema.AdditionalDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cl.bee.genfrmjava.adddef.schema.AdditionalDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
