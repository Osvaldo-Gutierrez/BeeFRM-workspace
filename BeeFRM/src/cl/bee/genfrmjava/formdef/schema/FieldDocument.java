/*
 * An XML document type.
 * Localname: field
 * Namespace: http://cl/bee/genfrmjava/formdef/schema
 * Java type: cl.bee.genfrmjava.formdef.schema.FieldDocument
 *
 * Automatically generated - do not modify.
 */
package cl.bee.genfrmjava.formdef.schema;


/**
 * A document containing one field(@http://cl/bee/genfrmjava/formdef/schema) element.
 *
 * This is a complex type.
 */
public interface FieldDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(FieldDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s86FB8B51BF8A1799A84DF6E21106E5B4").resolveHandle("fielda54bdoctype");
    
    /**
     * Gets the "field" element
     */
    cl.bee.genfrmjava.formdef.schema.FieldDocument.Field getField();
    
    /**
     * Sets the "field" element
     */
    void setField(cl.bee.genfrmjava.formdef.schema.FieldDocument.Field field);
    
    /**
     * Appends and returns a new empty "field" element
     */
    cl.bee.genfrmjava.formdef.schema.FieldDocument.Field addNewField();
    
    /**
     * An XML field(@http://cl/bee/genfrmjava/formdef/schema).
     *
     * This is a complex type.
     */
    public interface Field extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Field.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s86FB8B51BF8A1799A84DF6E21106E5B4").resolveHandle("field38b1elemtype");
        
        /**
         * Gets array of all "type" elements
         */
        cl.bee.genfrmjava.formdef.schema.TypeDocument.Type[] getTypeArray();
        
        /**
         * Gets ith "type" element
         */
        cl.bee.genfrmjava.formdef.schema.TypeDocument.Type getTypeArray(int i);
        
        /**
         * Returns number of "type" element
         */
        int sizeOfTypeArray();
        
        /**
         * Sets array of all "type" element
         */
        void setTypeArray(cl.bee.genfrmjava.formdef.schema.TypeDocument.Type[] typeArray);
        
        /**
         * Sets ith "type" element
         */
        void setTypeArray(int i, cl.bee.genfrmjava.formdef.schema.TypeDocument.Type type);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "type" element
         */
        cl.bee.genfrmjava.formdef.schema.TypeDocument.Type insertNewType(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "type" element
         */
        cl.bee.genfrmjava.formdef.schema.TypeDocument.Type addNewType();
        
        /**
         * Removes the ith "type" element
         */
        void removeType(int i);
        
        /**
         * Gets array of all "fms" elements
         */
        cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms[] getFmsArray();
        
        /**
         * Gets ith "fms" element
         */
        cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms getFmsArray(int i);
        
        /**
         * Returns number of "fms" element
         */
        int sizeOfFmsArray();
        
        /**
         * Sets array of all "fms" element
         */
        void setFmsArray(cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms[] fmsArray);
        
        /**
         * Sets ith "fms" element
         */
        void setFmsArray(int i, cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms fms);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "fms" element
         */
        cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms insertNewFms(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "fms" element
         */
        cl.bee.genfrmjava.formdef.schema.FmsDocument.Fms addNewFms();
        
        /**
         * Removes the ith "fms" element
         */
        void removeFms(int i);
        
        /**
         * Gets array of all "default" elements
         */
        cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default[] getDefaultArray();
        
        /**
         * Gets ith "default" element
         */
        cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default getDefaultArray(int i);
        
        /**
         * Returns number of "default" element
         */
        int sizeOfDefaultArray();
        
        /**
         * Sets array of all "default" element
         */
        void setDefaultArray(cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default[] xdefaultArray);
        
        /**
         * Sets ith "default" element
         */
        void setDefaultArray(int i, cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default xdefault);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "default" element
         */
        cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default insertNewDefault(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "default" element
         */
        cl.bee.genfrmjava.formdef.schema.DefaultDocument.Default addNewDefault();
        
        /**
         * Removes the ith "default" element
         */
        void removeDefault(int i);
        
        /**
         * Gets array of all "index" elements
         */
        cl.bee.genfrmjava.formdef.schema.IndexDocument.Index[] getIndexArray();
        
        /**
         * Gets ith "index" element
         */
        cl.bee.genfrmjava.formdef.schema.IndexDocument.Index getIndexArray(int i);
        
        /**
         * Returns number of "index" element
         */
        int sizeOfIndexArray();
        
        /**
         * Sets array of all "index" element
         */
        void setIndexArray(cl.bee.genfrmjava.formdef.schema.IndexDocument.Index[] indexArray);
        
        /**
         * Sets ith "index" element
         */
        void setIndexArray(int i, cl.bee.genfrmjava.formdef.schema.IndexDocument.Index index);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "index" element
         */
        cl.bee.genfrmjava.formdef.schema.IndexDocument.Index insertNewIndex(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "index" element
         */
        cl.bee.genfrmjava.formdef.schema.IndexDocument.Index addNewIndex();
        
        /**
         * Removes the ith "index" element
         */
        void removeIndex(int i);
        
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
         * Gets the "special" attribute
         */
        java.lang.String getSpecial();
        
        /**
         * Gets (as xml) the "special" attribute
         */
        org.apache.xmlbeans.XmlString xgetSpecial();
        
        /**
         * True if has "special" attribute
         */
        boolean isSetSpecial();
        
        /**
         * Sets the "special" attribute
         */
        void setSpecial(java.lang.String special);
        
        /**
         * Sets (as xml) the "special" attribute
         */
        void xsetSpecial(org.apache.xmlbeans.XmlString special);
        
        /**
         * Unsets the "special" attribute
         */
        void unsetSpecial();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static cl.bee.genfrmjava.formdef.schema.FieldDocument.Field newInstance() {
              return (cl.bee.genfrmjava.formdef.schema.FieldDocument.Field) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static cl.bee.genfrmjava.formdef.schema.FieldDocument.Field newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (cl.bee.genfrmjava.formdef.schema.FieldDocument.Field) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static cl.bee.genfrmjava.formdef.schema.FieldDocument newInstance() {
          return (cl.bee.genfrmjava.formdef.schema.FieldDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static cl.bee.genfrmjava.formdef.schema.FieldDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (cl.bee.genfrmjava.formdef.schema.FieldDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static cl.bee.genfrmjava.formdef.schema.FieldDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.formdef.schema.FieldDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static cl.bee.genfrmjava.formdef.schema.FieldDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.formdef.schema.FieldDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static cl.bee.genfrmjava.formdef.schema.FieldDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.formdef.schema.FieldDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static cl.bee.genfrmjava.formdef.schema.FieldDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.formdef.schema.FieldDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static cl.bee.genfrmjava.formdef.schema.FieldDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.formdef.schema.FieldDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static cl.bee.genfrmjava.formdef.schema.FieldDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.formdef.schema.FieldDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static cl.bee.genfrmjava.formdef.schema.FieldDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.formdef.schema.FieldDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static cl.bee.genfrmjava.formdef.schema.FieldDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.formdef.schema.FieldDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static cl.bee.genfrmjava.formdef.schema.FieldDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.formdef.schema.FieldDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static cl.bee.genfrmjava.formdef.schema.FieldDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.formdef.schema.FieldDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static cl.bee.genfrmjava.formdef.schema.FieldDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.formdef.schema.FieldDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static cl.bee.genfrmjava.formdef.schema.FieldDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.formdef.schema.FieldDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static cl.bee.genfrmjava.formdef.schema.FieldDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.formdef.schema.FieldDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static cl.bee.genfrmjava.formdef.schema.FieldDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.formdef.schema.FieldDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cl.bee.genfrmjava.formdef.schema.FieldDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cl.bee.genfrmjava.formdef.schema.FieldDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cl.bee.genfrmjava.formdef.schema.FieldDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cl.bee.genfrmjava.formdef.schema.FieldDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
