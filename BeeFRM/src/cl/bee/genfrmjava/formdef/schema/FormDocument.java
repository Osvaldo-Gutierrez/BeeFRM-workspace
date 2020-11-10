/*
 * An XML document type.
 * Localname: form
 * Namespace: http://cl/bee/genfrmjava/formdef/schema
 * Java type: cl.bee.genfrmjava.formdef.schema.FormDocument
 *
 * Automatically generated - do not modify.
 */
package cl.bee.genfrmjava.formdef.schema;


/**
 * A document containing one form(@http://cl/bee/genfrmjava/formdef/schema) element.
 *
 * This is a complex type.
 */
public interface FormDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(FormDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s86FB8B51BF8A1799A84DF6E21106E5B4").resolveHandle("form0de7doctype");
    
    /**
     * Gets the "form" element
     */
    cl.bee.genfrmjava.formdef.schema.FormDocument.Form getForm();
    
    /**
     * Sets the "form" element
     */
    void setForm(cl.bee.genfrmjava.formdef.schema.FormDocument.Form form);
    
    /**
     * Appends and returns a new empty "form" element
     */
    cl.bee.genfrmjava.formdef.schema.FormDocument.Form addNewForm();
    
    /**
     * An XML form(@http://cl/bee/genfrmjava/formdef/schema).
     *
     * This is a complex type.
     */
    public interface Form extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Form.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s86FB8B51BF8A1799A84DF6E21106E5B4").resolveHandle("form9887elemtype");
        
        /**
         * Gets array of all "field" elements
         */
        cl.bee.genfrmjava.formdef.schema.FieldDocument.Field[] getFieldArray();
        
        /**
         * Gets ith "field" element
         */
        cl.bee.genfrmjava.formdef.schema.FieldDocument.Field getFieldArray(int i);
        
        /**
         * Returns number of "field" element
         */
        int sizeOfFieldArray();
        
        /**
         * Sets array of all "field" element
         */
        void setFieldArray(cl.bee.genfrmjava.formdef.schema.FieldDocument.Field[] fieldArray);
        
        /**
         * Sets ith "field" element
         */
        void setFieldArray(int i, cl.bee.genfrmjava.formdef.schema.FieldDocument.Field field);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "field" element
         */
        cl.bee.genfrmjava.formdef.schema.FieldDocument.Field insertNewField(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "field" element
         */
        cl.bee.genfrmjava.formdef.schema.FieldDocument.Field addNewField();
        
        /**
         * Removes the ith "field" element
         */
        void removeField(int i);
        
        /**
         * Gets array of all "array" elements
         */
        cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array[] getArrayArray();
        
        /**
         * Gets ith "array" element
         */
        cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array getArrayArray(int i);
        
        /**
         * Returns number of "array" element
         */
        int sizeOfArrayArray();
        
        /**
         * Sets array of all "array" element
         */
        void setArrayArray(cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array[] arrayArray);
        
        /**
         * Sets ith "array" element
         */
        void setArrayArray(int i, cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array array);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "array" element
         */
        cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array insertNewArray(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "array" element
         */
        cl.bee.genfrmjava.formdef.schema.ArrayDocument.Array addNewArray();
        
        /**
         * Removes the ith "array" element
         */
        void removeArray(int i);
        
        /**
         * Gets array of all "primary" elements
         */
        cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary[] getPrimaryArray();
        
        /**
         * Gets ith "primary" element
         */
        cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary getPrimaryArray(int i);
        
        /**
         * Returns number of "primary" element
         */
        int sizeOfPrimaryArray();
        
        /**
         * Sets array of all "primary" element
         */
        void setPrimaryArray(cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary[] primaryArray);
        
        /**
         * Sets ith "primary" element
         */
        void setPrimaryArray(int i, cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary primary);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "primary" element
         */
        cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary insertNewPrimary(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "primary" element
         */
        cl.bee.genfrmjava.formdef.schema.PrimaryDocument.Primary addNewPrimary();
        
        /**
         * Removes the ith "primary" element
         */
        void removePrimary(int i);
        
        /**
         * Gets array of all "foreign" elements
         */
        cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign[] getForeignArray();
        
        /**
         * Gets ith "foreign" element
         */
        cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign getForeignArray(int i);
        
        /**
         * Returns number of "foreign" element
         */
        int sizeOfForeignArray();
        
        /**
         * Sets array of all "foreign" element
         */
        void setForeignArray(cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign[] foreignArray);
        
        /**
         * Sets ith "foreign" element
         */
        void setForeignArray(int i, cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign foreign);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "foreign" element
         */
        cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign insertNewForeign(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "foreign" element
         */
        cl.bee.genfrmjava.formdef.schema.ForeignDocument.Foreign addNewForeign();
        
        /**
         * Removes the ith "foreign" element
         */
        void removeForeign(int i);
        
        /**
         * Gets array of all "text" elements
         */
        cl.bee.genfrmjava.formdef.schema.TextDocument.Text[] getTextArray();
        
        /**
         * Gets ith "text" element
         */
        cl.bee.genfrmjava.formdef.schema.TextDocument.Text getTextArray(int i);
        
        /**
         * Returns number of "text" element
         */
        int sizeOfTextArray();
        
        /**
         * Sets array of all "text" element
         */
        void setTextArray(cl.bee.genfrmjava.formdef.schema.TextDocument.Text[] textArray);
        
        /**
         * Sets ith "text" element
         */
        void setTextArray(int i, cl.bee.genfrmjava.formdef.schema.TextDocument.Text text);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "text" element
         */
        cl.bee.genfrmjava.formdef.schema.TextDocument.Text insertNewText(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "text" element
         */
        cl.bee.genfrmjava.formdef.schema.TextDocument.Text addNewText();
        
        /**
         * Removes the ith "text" element
         */
        void removeText(int i);
        
        /**
         * Gets the "entity" attribute
         */
        java.lang.String getEntity();
        
        /**
         * Gets (as xml) the "entity" attribute
         */
        org.apache.xmlbeans.XmlString xgetEntity();
        
        /**
         * Sets the "entity" attribute
         */
        void setEntity(java.lang.String entity);
        
        /**
         * Sets (as xml) the "entity" attribute
         */
        void xsetEntity(org.apache.xmlbeans.XmlString entity);
        
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
         * Gets the "posx" attribute
         */
        long getPosX();
        
        /**
         * Gets (as xml) the "posx" attribute
         */
        org.apache.xmlbeans.XmlUnsignedInt xgetPosX();
        
        /**
         * Sets the "posx" attribute
         */
        void setPosX(long posx);
        
        /**
         * Sets (as xml) the "posx" attribute
         */
        void xsetPosX(org.apache.xmlbeans.XmlUnsignedInt posx);
        
        /**
         * Gets the "posy" attribute
         */
        long getPosY();
        
        /**
         * Gets (as xml) the "posy" attribute
         */
        org.apache.xmlbeans.XmlUnsignedInt xgetPosY();
        
        /**
         * Sets the "posy" attribute
         */
        void setPosY(long posy);
        
        /**
         * Sets (as xml) the "posy" attribute
         */
        void xsetPosY(org.apache.xmlbeans.XmlUnsignedInt posy);
        
        /**
         * Gets the "width" attribute
         */
        long getWidth();
        
        /**
         * Gets (as xml) the "width" attribute
         */
        org.apache.xmlbeans.XmlUnsignedInt xgetWidth();
        
        /**
         * Sets the "width" attribute
         */
        void setWidth(long width);
        
        /**
         * Sets (as xml) the "width" attribute
         */
        void xsetWidth(org.apache.xmlbeans.XmlUnsignedInt width);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static cl.bee.genfrmjava.formdef.schema.FormDocument.Form newInstance() {
              return (cl.bee.genfrmjava.formdef.schema.FormDocument.Form) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static cl.bee.genfrmjava.formdef.schema.FormDocument.Form newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (cl.bee.genfrmjava.formdef.schema.FormDocument.Form) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static cl.bee.genfrmjava.formdef.schema.FormDocument newInstance() {
          return (cl.bee.genfrmjava.formdef.schema.FormDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static cl.bee.genfrmjava.formdef.schema.FormDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (cl.bee.genfrmjava.formdef.schema.FormDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static cl.bee.genfrmjava.formdef.schema.FormDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.formdef.schema.FormDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static cl.bee.genfrmjava.formdef.schema.FormDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.formdef.schema.FormDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static cl.bee.genfrmjava.formdef.schema.FormDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.formdef.schema.FormDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static cl.bee.genfrmjava.formdef.schema.FormDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.formdef.schema.FormDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static cl.bee.genfrmjava.formdef.schema.FormDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.formdef.schema.FormDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static cl.bee.genfrmjava.formdef.schema.FormDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.formdef.schema.FormDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static cl.bee.genfrmjava.formdef.schema.FormDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.formdef.schema.FormDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static cl.bee.genfrmjava.formdef.schema.FormDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.formdef.schema.FormDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static cl.bee.genfrmjava.formdef.schema.FormDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.formdef.schema.FormDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static cl.bee.genfrmjava.formdef.schema.FormDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.formdef.schema.FormDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static cl.bee.genfrmjava.formdef.schema.FormDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.formdef.schema.FormDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static cl.bee.genfrmjava.formdef.schema.FormDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.formdef.schema.FormDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static cl.bee.genfrmjava.formdef.schema.FormDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.formdef.schema.FormDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static cl.bee.genfrmjava.formdef.schema.FormDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.formdef.schema.FormDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cl.bee.genfrmjava.formdef.schema.FormDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cl.bee.genfrmjava.formdef.schema.FormDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cl.bee.genfrmjava.formdef.schema.FormDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cl.bee.genfrmjava.formdef.schema.FormDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
