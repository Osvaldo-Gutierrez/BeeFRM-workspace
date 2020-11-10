/*
 * An XML document type.
 * Localname: ranges
 * Namespace: http://cl/bee/genfrmjava/rangedef/schema
 * Java type: cl.bee.genfrmjava.rangedef.schema.RangesDocument
 *
 * Automatically generated - do not modify.
 */
package cl.bee.genfrmjava.rangedef.schema;


/**
 * A document containing one ranges(@http://cl/bee/genfrmjava/rangedef/schema) element.
 *
 * This is a complex type.
 */
public interface RangesDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(RangesDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s86FB8B51BF8A1799A84DF6E21106E5B4").resolveHandle("ranges641edoctype");
    
    /**
     * Gets the "ranges" element
     */
    cl.bee.genfrmjava.rangedef.schema.RangesDocument.Ranges getRanges();
    
    /**
     * Sets the "ranges" element
     */
    void setRanges(cl.bee.genfrmjava.rangedef.schema.RangesDocument.Ranges ranges);
    
    /**
     * Appends and returns a new empty "ranges" element
     */
    cl.bee.genfrmjava.rangedef.schema.RangesDocument.Ranges addNewRanges();
    
    /**
     * An XML ranges(@http://cl/bee/genfrmjava/rangedef/schema).
     *
     * This is a complex type.
     */
    public interface Ranges extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Ranges.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s86FB8B51BF8A1799A84DF6E21106E5B4").resolveHandle("ranges8910elemtype");
        
        /**
         * Gets array of all "field" elements
         */
        cl.bee.genfrmjava.rangedef.schema.FieldDocument.Field[] getFieldArray();
        
        /**
         * Gets ith "field" element
         */
        cl.bee.genfrmjava.rangedef.schema.FieldDocument.Field getFieldArray(int i);
        
        /**
         * Returns number of "field" element
         */
        int sizeOfFieldArray();
        
        /**
         * Sets array of all "field" element
         */
        void setFieldArray(cl.bee.genfrmjava.rangedef.schema.FieldDocument.Field[] fieldArray);
        
        /**
         * Sets ith "field" element
         */
        void setFieldArray(int i, cl.bee.genfrmjava.rangedef.schema.FieldDocument.Field field);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "field" element
         */
        cl.bee.genfrmjava.rangedef.schema.FieldDocument.Field insertNewField(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "field" element
         */
        cl.bee.genfrmjava.rangedef.schema.FieldDocument.Field addNewField();
        
        /**
         * Removes the ith "field" element
         */
        void removeField(int i);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static cl.bee.genfrmjava.rangedef.schema.RangesDocument.Ranges newInstance() {
              return (cl.bee.genfrmjava.rangedef.schema.RangesDocument.Ranges) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static cl.bee.genfrmjava.rangedef.schema.RangesDocument.Ranges newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (cl.bee.genfrmjava.rangedef.schema.RangesDocument.Ranges) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static cl.bee.genfrmjava.rangedef.schema.RangesDocument newInstance() {
          return (cl.bee.genfrmjava.rangedef.schema.RangesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static cl.bee.genfrmjava.rangedef.schema.RangesDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (cl.bee.genfrmjava.rangedef.schema.RangesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static cl.bee.genfrmjava.rangedef.schema.RangesDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.rangedef.schema.RangesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static cl.bee.genfrmjava.rangedef.schema.RangesDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.rangedef.schema.RangesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static cl.bee.genfrmjava.rangedef.schema.RangesDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.rangedef.schema.RangesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static cl.bee.genfrmjava.rangedef.schema.RangesDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.rangedef.schema.RangesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static cl.bee.genfrmjava.rangedef.schema.RangesDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.rangedef.schema.RangesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static cl.bee.genfrmjava.rangedef.schema.RangesDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.rangedef.schema.RangesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static cl.bee.genfrmjava.rangedef.schema.RangesDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.rangedef.schema.RangesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static cl.bee.genfrmjava.rangedef.schema.RangesDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.rangedef.schema.RangesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static cl.bee.genfrmjava.rangedef.schema.RangesDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.rangedef.schema.RangesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static cl.bee.genfrmjava.rangedef.schema.RangesDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.rangedef.schema.RangesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static cl.bee.genfrmjava.rangedef.schema.RangesDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.rangedef.schema.RangesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static cl.bee.genfrmjava.rangedef.schema.RangesDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.rangedef.schema.RangesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static cl.bee.genfrmjava.rangedef.schema.RangesDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.rangedef.schema.RangesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static cl.bee.genfrmjava.rangedef.schema.RangesDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.rangedef.schema.RangesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cl.bee.genfrmjava.rangedef.schema.RangesDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cl.bee.genfrmjava.rangedef.schema.RangesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cl.bee.genfrmjava.rangedef.schema.RangesDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cl.bee.genfrmjava.rangedef.schema.RangesDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
