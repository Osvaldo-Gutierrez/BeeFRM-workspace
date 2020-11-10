/*
 * XML Type:  TipoType
 * Namespace: http://cl/bee/genfrmjava/formdef/schema
 * Java type: cl.bee.genfrmjava.formdef.schema.TipoType
 *
 * Automatically generated - do not modify.
 */
package cl.bee.genfrmjava.formdef.schema;


/**
 * An XML TipoType(@http://cl/bee/genfrmjava/formdef/schema).
 *
 * This is an atomic type that is a restriction of cl.bee.genfrmjava.formdef.schema.TipoType.
 */
public interface TipoType extends org.apache.xmlbeans.XmlString
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(TipoType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s86FB8B51BF8A1799A84DF6E21106E5B4").resolveHandle("tipotype8d41type");
    
    org.apache.xmlbeans.StringEnumAbstractBase enumValue();
    void set(org.apache.xmlbeans.StringEnumAbstractBase e);
    
    static final Enum INTEGER = Enum.forString("integer");
    static final Enum LONG = Enum.forString("long");
    static final Enum DOUBLE = Enum.forString("double");
    static final Enum CHAR = Enum.forString("char");
    static final Enum BOOLEAN = Enum.forString("boolean");
    static final Enum STRING = Enum.forString("string");
    static final Enum DATE = Enum.forString("date");
    
    static final int INT_INTEGER = Enum.INT_INTEGER;
    static final int INT_LONG = Enum.INT_LONG;
    static final int INT_DOUBLE = Enum.INT_DOUBLE;
    static final int INT_CHAR = Enum.INT_CHAR;
    static final int INT_BOOLEAN = Enum.INT_BOOLEAN;
    static final int INT_STRING = Enum.INT_STRING;
    static final int INT_DATE = Enum.INT_DATE;
    
    /**
     * Enumeration value class for cl.bee.genfrmjava.formdef.schema.TipoType.
     * These enum values can be used as follows:
     * <pre>
     * enum.toString(); // returns the string value of the enum
     * enum.intValue(); // returns an int value, useful for switches
     * // e.g., case Enum.INT_INTEGER
     * Enum.forString(s); // returns the enum value for a string
     * Enum.forInt(i); // returns the enum value for an int
     * </pre>
     * Enumeration objects are immutable singleton objects that
     * can be compared using == object equality. They have no
     * public constructor. See the constants defined within this
     * class for all the valid values.
     */
    static final class Enum extends org.apache.xmlbeans.StringEnumAbstractBase
    {
        /**
         * Returns the enum value for a string, or null if none.
         */
        public static Enum forString(java.lang.String s)
            { return (Enum)table.forString(s); }
        /**
         * Returns the enum value corresponding to an int, or null if none.
         */
        public static Enum forInt(int i)
            { return (Enum)table.forInt(i); }
        
        private Enum(java.lang.String s, int i)
            { super(s, i); }
        
        static final int INT_INTEGER = 1;
        static final int INT_LONG = 2;
        static final int INT_DOUBLE = 3;
        static final int INT_CHAR = 4;
        static final int INT_BOOLEAN = 5;
        static final int INT_STRING = 6;
        static final int INT_DATE = 7;
        
        public static final org.apache.xmlbeans.StringEnumAbstractBase.Table table =
            new org.apache.xmlbeans.StringEnumAbstractBase.Table
        (
            new Enum[]
            {
                new Enum("integer", INT_INTEGER),
                new Enum("long", INT_LONG),
                new Enum("double", INT_DOUBLE),
                new Enum("char", INT_CHAR),
                new Enum("boolean", INT_BOOLEAN),
                new Enum("string", INT_STRING),
                new Enum("date", INT_DATE),
            }
        );
        private static final long serialVersionUID = 1L;
        private java.lang.Object readResolve() { return forInt(intValue()); } 
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static cl.bee.genfrmjava.formdef.schema.TipoType newValue(java.lang.Object obj) {
          return (cl.bee.genfrmjava.formdef.schema.TipoType) type.newValue( obj ); }
        
        public static cl.bee.genfrmjava.formdef.schema.TipoType newInstance() {
          return (cl.bee.genfrmjava.formdef.schema.TipoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static cl.bee.genfrmjava.formdef.schema.TipoType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (cl.bee.genfrmjava.formdef.schema.TipoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static cl.bee.genfrmjava.formdef.schema.TipoType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.formdef.schema.TipoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static cl.bee.genfrmjava.formdef.schema.TipoType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.formdef.schema.TipoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static cl.bee.genfrmjava.formdef.schema.TipoType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.formdef.schema.TipoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static cl.bee.genfrmjava.formdef.schema.TipoType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.formdef.schema.TipoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static cl.bee.genfrmjava.formdef.schema.TipoType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.formdef.schema.TipoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static cl.bee.genfrmjava.formdef.schema.TipoType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.formdef.schema.TipoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static cl.bee.genfrmjava.formdef.schema.TipoType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.formdef.schema.TipoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static cl.bee.genfrmjava.formdef.schema.TipoType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.formdef.schema.TipoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static cl.bee.genfrmjava.formdef.schema.TipoType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.formdef.schema.TipoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static cl.bee.genfrmjava.formdef.schema.TipoType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (cl.bee.genfrmjava.formdef.schema.TipoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static cl.bee.genfrmjava.formdef.schema.TipoType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.formdef.schema.TipoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static cl.bee.genfrmjava.formdef.schema.TipoType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.formdef.schema.TipoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static cl.bee.genfrmjava.formdef.schema.TipoType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.formdef.schema.TipoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static cl.bee.genfrmjava.formdef.schema.TipoType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (cl.bee.genfrmjava.formdef.schema.TipoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cl.bee.genfrmjava.formdef.schema.TipoType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cl.bee.genfrmjava.formdef.schema.TipoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static cl.bee.genfrmjava.formdef.schema.TipoType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (cl.bee.genfrmjava.formdef.schema.TipoType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
