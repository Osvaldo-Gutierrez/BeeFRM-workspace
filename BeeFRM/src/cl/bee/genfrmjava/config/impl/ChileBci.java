/*
 *   Copyright (c) 2019 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.genfrmjava.config.impl;


import java.io.*;

import java.util.*;

import cl.bee.genfrmjava.config.*;

import cl.bee.genfrmjava.formdef.schema.*;

import cl.bee.genfrmjava.util.*;

import org.apache.xmlbeans.*;

import org.apache.log4j.*;


/**
 *
 * TODO_javadoc.
 *
 * @version 1.0 (01/01/2013).
 *
 */
public class ChileBci implements Config {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(ChileBci.class);

    /** TODO_javadoc. */
    private final static int NUM_LEN = 8;

    /** TODO_javadoc. */
    private final static int IND_LEN = 1;

    /******************************************************************************
     * getInfoFromXML
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param filename TODO_javadoc.
     * @param fields TODO_javadoc.
     * @param texts TODO_javadoc.
     *
     * @throws Exception TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public void getInfoFromXML(String filename, ArrayList<Object> fields, ArrayList<TextDef> texts, FormDef forms) throws Exception {

        ArrayList  errors = new ArrayList();
        XmlOptions opts   = new XmlOptions();

        opts.setErrorListener(errors);

        FormDocument root = FormDocument.Factory.parse(new File(filename), opts);

        if (root.validate(opts)) {

            FormDocument.Form form = root.getForm();
            
            forms.setName(form.getName());
            forms.setAreaX(form.getPosX());
            forms.setAreaY(form.getPosY());
            forms.setWidth(form.getWidth());
            //

            String              varName = null;
            FieldDef            re      = null;
            ArrayDocument.Array a       = null;

            for (Object obj : form.selectPath("./*")) {

                if      (obj instanceof FieldDocument.Field) {

                    FieldDef fd = getFieldDef((FieldDocument.Field) obj);

                    switch (fd.special) {

                    case FieldDef.VRF :

                        if (fd.replaced == null) {
                            fd.replaced = new ArrayList<FieldDef>();
                        }

                        //

                        varName = fd.name.substring(0, 3) + "-NUM-" + fd.name.substring(8);

                                        //name     special                                      modifier        type              size     integers decimals sign   fmsname  picture     xdefault attributes     row     column
                      //re = new FieldDef(varName, null,                                        FieldDef.UNDEF, FieldDef.INTEGER, NUM_LEN, NUM_LEN, 0,       false, varName, "99999999", null,    fd.attributes, fd.row, fd.column);
                        re = new FieldDef(varName, FieldDef.getSpecialString(fd.special),       fd.modifier,    FieldDef.INTEGER, NUM_LEN, NUM_LEN, 0,       false, varName, "99999999", null,    fd.attributes, fd.row, fd.column);

                        fd.replaced.add(re);

                        //

                        varName = fd.name.substring(0, 3) + "-VRF-" + fd.name.substring(8);

                                        //name     special                                      modifier        type              size integers decimals sign   fmsname  picture     xdefault attributes     row     column
                      //re = new FieldDef(varName, null,                                        FieldDef.UNDEF, FieldDef.STRING,  1,   0,       0,       false, varName, "X",        null,    fd.attributes, fd.row, fd.column + NUM_LEN + 3);
                        re = new FieldDef(varName, FieldDef.getSpecialString(fd.special),       fd.modifier,    FieldDef.STRING,  1,   0,       0,       false, varName, "X",        null,    fd.attributes, fd.row, fd.column + NUM_LEN + 3);

                        fd.replaced.add(re);

                        break;

                    case FieldDef.IDC :

                        if (fd.replaced == null) {
                            fd.replaced = new ArrayList<FieldDef>();
                        }

                        //

                        varName = fd.name.substring(0, 3) + "-IND-" + fd.name.substring(8);

                                        //name     special                                      modifier        type              size     integers decimals sign   fmsname  picture     xdefault attributes     row     column
                      //re = new FieldDef(varName, null,                                        FieldDef.UNDEF, FieldDef.STRING,  IND_LEN, 0,       0,       false, varName, "X",        null,    fd.attributes, fd.row, fd.column);
                        re = new FieldDef(varName, FieldDef.getSpecialString(fd.special),       fd.modifier,    FieldDef.STRING,  IND_LEN, 0,       0,       false, varName, "X",        null,    fd.attributes, fd.row, fd.column);

                        fd.replaced.add(re);

                        //

                        varName = fd.name.substring(0, 3) + "-GLS-" + fd.name.substring(8);

                                        //name     special                                      modifier        type              size integers decimals sign   fmsname  picture     xdefault attributes     row     column
                      //re = new FieldDef(varName, FieldDef.getSpecialString(FieldDef.GLS_IDC), FieldDef.UNDEF, FieldDef.STRING,  3,   0,       0,       false, varName, "XXX",      null,    fd.attributes, fd.row, fd.column + IND_LEN + 3);
                        re = new FieldDef(varName, FieldDef.getSpecialString(FieldDef.GLS_IDC), fd.modifier,    FieldDef.STRING,  3,   0,       0,       false, varName, "XXX",      null,    fd.attributes, fd.row, fd.column + IND_LEN + 3);

                        fd.replaced.add(re);

                        break;

                    case FieldDef.FEC :

                        if (fd.replaced == null) {
                            fd.replaced = new ArrayList<FieldDef>();
                        }

                        for (int i = 0; i < FieldDef.date_initials.length; i++) { // 012345678901
                                                                                  // abc_fec_vxyz
                            varName = fd.name.substring(0, 3) + "-NUM-" + FieldDef.date_initials[i] + fd.name.substring(9);

                                            //name     special modifier        type              size integers decimals sign   fmsname  picture     xdefault attributes     row     column
                          //re = new FieldDef(varName, null,   FieldDef.UNDEF, FieldDef.INTEGER, 2,   2,       0,       false, varName, "99",       null,    fd.attributes, fd.row, fd.column);
                            re = new FieldDef(varName, null,   fd.modifier,    FieldDef.INTEGER, 2,   2,       0,       false, varName, "99",       null,    fd.attributes, fd.row, fd.column);

                            fd.replaced.add(re);
                        }

                        break;
                    }

                    fields.add(fd);
                }
                else if (obj instanceof ArrayDocument.Array) {

                    a = (ArrayDocument.Array) obj;

                    ArrayList<ElementDef> arr = new ArrayList<ElementDef>();

                    for (FieldDocument.Field f : a.getFieldArray()) {

                        ElementDef ed = getElementDef(f);

                      //logger.debug(ed);

                        arr.add(ed);
                    }

                    fields.add(arr);
                }
            }

            // primary

            if (form.getPrimaryArray().length > 1) {
                throw new RuntimeException("form' debe tener a lo mas un elemento 'primary'.");
            }
            else if (form.getPrimaryArray().length == 1) {

                /*
                PrimaryDocument.Primary primary = form.getPrimaryArray()[0];

                for (FieldDocument.Field field : primary.getFieldArray()) {
                    logger.debug(field.getName());
                }
                */
            }

            // foreign

            for (int i = 0; i < form.getForeignArray().length; i++) {

                /*
                ForeignDocument.Foreign foreign = form.getForeignArray()[i];

                logger.debug("= " + foreign.getEntity() + " ==================================");

                for (FieldDocument.Field field : foreign.getFieldArray()) {
                    logger.debug(field.getName());
                }

                logger.debug("===========================================");
                */
            }

            //

            for (TextDocument.Text text : form.getTextArray()) {

                TextDef tx = getTextDef(text);

                texts.add(tx);
            }

        } else {

            for (Object error : errors) {
                logger.fatal(error);
            }

            throw new XmlException(filename + " es invalido.");
        }
    }

    /******************************************************************************
     * getFieldDef
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param field TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private FieldDef getFieldDef(FieldDocument.Field field) {

        if (field.getTypeArray().length != 1) {
            throw new RuntimeException("field '" + field.getName() + "' debe tener un unico elemento 'type'.");
        }

        TypeDocument.Type type = field.getTypeArray()[0];

        //

        if (field.getFmsArray().length != 1) {
            throw new RuntimeException("field '" + field.getName() + "' debe tener un unico elemento 'fms'.");
        }

        FmsDocument.Fms fms = field.getFmsArray()[0];

        //

        DefaultDocument.Default xdefault = null;

        if (field.getDefaultArray().length > 1) {
            throw new RuntimeException("field '" + field.getName() + "' debe tener a lo mas un elemento 'default'.");
        }
        else if (field.getDefaultArray().length == 1) {
            xdefault = field.getDefaultArray()[0];
        }

        //

        return new FieldDef(field.getName(),                                                         // name
                            field.getSpecial(),                                                      // special
                            fms.getModifier().intValue(),                                            // modifier
                            type.getName().intValue(),                                               // type
                            (int) type.getSize(),                                                    // size
                            type.isSetIntegers() ? (int) type.getIntegers() : 0,                     // integers
                            type.isSetDecimals() ? (int) type.getDecimals() : 0,                     // decimals
                            type.isSetSign()     ? type.getSign().intValue() == 1 /* yes */ : false, // sign
                            fms.getName(),                                                           // fmsname
                            fms.getPicture(),                                                        // picture
                            xdefault != null ? xdefault.getValue() : null,                           // xdefault
                            (int) fms.getAttributes(),                                               // attributes
                            (int) fms.getRow(),                                                      // row
                            (int) fms.getColumn());                                                  // column
    }

    /******************************************************************************
     * getElementDef
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param field TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private ElementDef getElementDef(FieldDocument.Field field) {

        FieldDef fd = getFieldDef(field);

        if (field.getIndexArray().length != 1) {
            throw new RuntimeException("field '" + field.getName() + "' debe tener un unico elemento 'index'.");
        }

        ArrayList<PositionDef> arr = new ArrayList<PositionDef>();

        for (PosDocument.Pos pos : field.getIndexArray()[0].getPosArray()) {
            arr.add(new PositionDef((int) pos.getRow(), (int) pos.getColumn()));
        }

        return new ElementDef(fd, arr);
    }

    /******************************************************************************
     * getTextDef
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param text TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private TextDef getTextDef(TextDocument.Text text) {

        return new TextDef(text.getCaption(),       // caption
                           (int) text.getRow(),     // row
                           (int) text.getColumn()); // column
    }
}
