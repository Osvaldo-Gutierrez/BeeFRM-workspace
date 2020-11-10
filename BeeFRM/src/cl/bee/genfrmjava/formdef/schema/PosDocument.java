/*
 * An XML document type.
 * Localname: pos
 * Namespace: http://cl/bee/genfrmjava/formdef/schema
 * Java type: cl.bee.genfrmjava.formdef.schema.PosDocument
 *
 * Automatically generated - do not modify.
 */
package cl.bee.genfrmjava.formdef.schema;


/**
 * A document containing one pos(@http://cl/bee/genfrmjava/formdef/schema) element.
 *
 * This is a complex type.
 */
public interface PosDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(PosDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s86FB8B51BF8A1799A84DF6E21106E5B4").resolveHandle("posb265doctype");
    
    /**
     * Gets the "pos" element
     */
    cl.bee.genfrmjava.formdef.schema.PosDocument.Pos getPos();
    
    /**
     * Sets the "pos" element
     */
    void setPos(cl.bee.genfrmjava.formdef.schema.PosDocument.Pos pos);
    
    /**
     * Appends and returns a new empty "pos" element
     */
    cl.bee.genfrmjava.formdef.schema.PosDocument.Pos addNewPos();
    
    /**
     * An XML pos(@http://cl/bee/genfrmjava/formdef/schema).
     *
     * This is a complex type.
     */
    public interface Pos extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Pos.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s86FB8B51BF8A1799A84DF6E21106E5B4").resolveHandle("posa525elemtype");
        
        /**
         * Gets the "row" attribute
         */
        long getRow();
        
        /**
         * Gets (as xml) the "row" attribute
         */
        org.apache.xmlbeans.XmlUnsignedInt xgetRow();
        
        /**
         * True if has "row" attribute
         */
        boolean isSetRow();
        
        /**
         * Sets the "row" attribute
         */
        void setRow(long row);
        
        /**
         * Sets (as xml) the "row" attribute
         */
        void xsetRow(org.apache.xmlbeans.XmlUnsignedInt row);
        
        /**
         * Unsets the "row" attribute
         */
        void unsetRow();
        
        /**
         * Gets the "column" attribute
         */
        long getColumn();
        
        /**
         * Gets (as xml) the "column" attribute
         */
        org.apache.xmlbeans.XmlUnsignedInt xgetColumn();
        
        /**
         * True if has "column" attribute
         */
        boolean isSetColumn();
        
        /**
         * Sets the "column" attribute
         */
        void setColumn(long column);
        
        /**
         * Sets (as xml) the "column" attribute
         */
        void xsetColumn(org.apache.xmlbeans.XmlUnsignedInt column);
        
        /**
         * Unsets the "column" attribute
         */
        void unsetColumn();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static cl.bee.genfrmjava.formdef.schema.PosDocument.Pos newInstance() {
              return (cl.bee.genfrmjava.formdef.schema.PosDocument.Pos) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static cl.bee.genfrmjava.formdef.schema.PosDocument.Pos newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (cl.bee.genfrmjava.formdef.schema.PosDocument.Pos) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static cl.bee.genfrmjava.formdef.schema.PosDocument newInstance() {
          return (cl.bee.genfrmjava.formdef.schema.PosDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static cl.bee.genfrmjava.formdef.schema.PosDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (cl.bee.genfrmjava.formdef.schema.PosDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static cl.bee.genfrmjava.formdef.schema.PosDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.formdef.schema.PosDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static cl.bee.genfrmjava.formdef.schema.PosDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.formdef.schema.PosDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static cl.bee.genfrmjava.formdef.schema.PosDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.formdef.schema.PosDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static cl.bee.genfrmjava.formdef.schema.PosDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.formdef.schema.PosDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static cl.bee.genfrmjava.formdef.schema.PosDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.formdef.schema.PosDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static cl.bee.genfrmjava.formdef.schema.PosDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.formdef.schema.PosDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static cl.bee.genfrmjava.formdef.schema.PosDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.formdef.schema.PosDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static cl.bee.genfrmjava.formdef.schema.PosDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.formdef.schema.PosDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static cl.bee.genfrmjava.formdef.schema.PosDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.formdef.schema.PosDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static cl.bee.genfrmjava.formdef.schema.PosDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.formdef.schema.PosDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static cl.bee.genfrmjava.formdef.schema.PosDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.formdef.schema.PosDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static cl.bee.genfrmjava.formdef.schema.PosDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.formdef.schema.PosDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static cl.bee.genfrmjava.formdef.schema.PosDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.formdef.schema.PosDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static cl.bee.genfrmjava.formdef.schema.PosDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.formdef.schema.PosDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cl.bee.genfrmjava.formdef.schema.PosDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cl.bee.genfrmjava.formdef.schema.PosDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cl.bee.genfrmjava.formdef.schema.PosDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cl.bee.genfrmjava.formdef.schema.PosDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
