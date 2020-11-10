/*
 * An XML document type.
 * Localname: index
 * Namespace: http://cl/bee/genfrmjava/formdef/schema
 * Java type: cl.bee.genfrmjava.formdef.schema.IndexDocument
 *
 * Automatically generated - do not modify.
 */
package cl.bee.genfrmjava.formdef.schema.impl;
/**
 * A document containing one index(@http://cl/bee/genfrmjava/formdef/schema) element.
 *
 * This is a complex type.
 */
public class IndexDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.formdef.schema.IndexDocument
{
    private static final long serialVersionUID = 1L;
    
    public IndexDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName INDEX$0 = 
        new javax.xml.namespace.QName("http://cl/bee/genfrmjava/formdef/schema", "index");
    
    
    /**
     * Gets the "index" element
     */
    public cl.bee.genfrmjava.formdef.schema.IndexDocument.Index getIndex()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.formdef.schema.IndexDocument.Index target = null;
            target = (cl.bee.genfrmjava.formdef.schema.IndexDocument.Index)get_store().find_element_user(INDEX$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "index" element
     */
    public void setIndex(cl.bee.genfrmjava.formdef.schema.IndexDocument.Index index)
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.formdef.schema.IndexDocument.Index target = null;
            target = (cl.bee.genfrmjava.formdef.schema.IndexDocument.Index)get_store().find_element_user(INDEX$0, 0);
            if (target == null)
            {
                target = (cl.bee.genfrmjava.formdef.schema.IndexDocument.Index)get_store().add_element_user(INDEX$0);
            }
            target.set(index);
        }
    }
    
    /**
     * Appends and returns a new empty "index" element
     */
    public cl.bee.genfrmjava.formdef.schema.IndexDocument.Index addNewIndex()
    {
        synchronized (monitor())
        {
            check_orphaned();
            cl.bee.genfrmjava.formdef.schema.IndexDocument.Index target = null;
            target = (cl.bee.genfrmjava.formdef.schema.IndexDocument.Index)get_store().add_element_user(INDEX$0);
            return target;
        }
    }
    /**
     * An XML index(@http://cl/bee/genfrmjava/formdef/schema).
     *
     * This is a complex type.
     */
    public static class IndexImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements cl.bee.genfrmjava.formdef.schema.IndexDocument.Index
    {
        private static final long serialVersionUID = 1L;
        
        public IndexImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName POS$0 = 
            new javax.xml.namespace.QName("http://cl/bee/genfrmjava/formdef/schema", "pos");
        
        
        /**
         * Gets array of all "pos" elements
         */
        public cl.bee.genfrmjava.formdef.schema.PosDocument.Pos[] getPosArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(POS$0, targetList);
                cl.bee.genfrmjava.formdef.schema.PosDocument.Pos[] result = new cl.bee.genfrmjava.formdef.schema.PosDocument.Pos[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets ith "pos" element
         */
        public cl.bee.genfrmjava.formdef.schema.PosDocument.Pos getPosArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.PosDocument.Pos target = null;
                target = (cl.bee.genfrmjava.formdef.schema.PosDocument.Pos)get_store().find_element_user(POS$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target;
            }
        }
        
        /**
         * Returns number of "pos" element
         */
        public int sizeOfPosArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(POS$0);
            }
        }
        
        /**
         * Sets array of all "pos" element
         */
        public void setPosArray(cl.bee.genfrmjava.formdef.schema.PosDocument.Pos[] posArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(posArray, POS$0);
            }
        }
        
        /**
         * Sets ith "pos" element
         */
        public void setPosArray(int i, cl.bee.genfrmjava.formdef.schema.PosDocument.Pos pos)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.PosDocument.Pos target = null;
                target = (cl.bee.genfrmjava.formdef.schema.PosDocument.Pos)get_store().find_element_user(POS$0, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(pos);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "pos" element
         */
        public cl.bee.genfrmjava.formdef.schema.PosDocument.Pos insertNewPos(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.PosDocument.Pos target = null;
                target = (cl.bee.genfrmjava.formdef.schema.PosDocument.Pos)get_store().insert_element_user(POS$0, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "pos" element
         */
        public cl.bee.genfrmjava.formdef.schema.PosDocument.Pos addNewPos()
        {
            synchronized (monitor())
            {
                check_orphaned();
                cl.bee.genfrmjava.formdef.schema.PosDocument.Pos target = null;
                target = (cl.bee.genfrmjava.formdef.schema.PosDocument.Pos)get_store().add_element_user(POS$0);
                return target;
            }
        }
        
        /**
         * Removes the ith "pos" element
         */
        public void removePos(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(POS$0, i);
            }
        }
    }
}
