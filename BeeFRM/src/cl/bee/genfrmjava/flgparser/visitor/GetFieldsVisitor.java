/*
 *   Todos los derechos reservados por Banco de Cr�dito e Inversiones.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BCI
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.genfrmjava.flgparser.visitor;


import java.io.*;

import java.text.*;

import java.util.*;

import cl.bee.genfrmjava.util.*;

import cl.bee.genfrmjava.flgparser.syntaxtree.*;

import org.apache.log4j.*;


/**
 *
 * TODO_javadoc.
 *
 * Registro de versiones:<ul>
 *
 * <li>1.0 (v21/12/2005, <<autor>>): versi�n inicial.
 * </ul>
 *
 */
public class GetFieldsVisitor extends DepthFirstVisitor implements Visitor {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(GetFieldsVisitor.class);

    //

    /** TODO_javadoc. */
    private String name = null;

    /** TODO_javadoc. */
    private String clearCharacter = null;

    /** TODO_javadoc. */
    private String def = null;

    /** TODO_javadoc. */
    private String help = null;

    /** TODO_javadoc. */
    private int picture_num;

    /** TODO_javadoc. */
    private String picture = null;

    /** TODO_javadoc. */
    private int row = FieldDef.UNDEF;

    /** TODO_javadoc. */
    private int column = FieldDef.UNDEF;

    /** TODO_javadoc. */
    private int attributes = 0x00000000;

    /** TODO_javadoc. */
    private int default_attrs = 0x00000000;

    //

    /** TODO_javadoc. */
    private ArrayList<PositionDef> index = null;

    /** TODO_javadoc. */
    private ArrayList<Object> fields = null;

    /** TODO_javadoc. */
    private ArrayList<TextDef> texts = null;
    
    /** TODO_javadoc. */
    private FormDef forms = null;

    /******************************************************************************
     * GetFieldsVisitor
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * Registro de versiones:<ul>
     *
     * <li>1.0 (v21/12/2005, <<autor>>): versi�n inicial.
     * </ul>
     *
     * @since 1.0
     *
     */
    public GetFieldsVisitor(ArrayList<Object> fields, ArrayList<TextDef> texts, FormDef forms) {

        this.fields = fields;
        this.texts  = texts;
        this.forms	= forms;
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /** 
     *
     * f0 -> form()
     * f1 -> ( text() )+
     * f2 -> adef()
     * f3 -> ( field() )+
     * f4 -> order()
     * f5 -> [ ndata() ]
     * f6 -> eofrm()
     * f7 -> <EOF>
     *
     * TODO_javadoc.
     *
     * Registro de versiones:<ul>
     *
     * <li>1.0 (v21/12/2005, <<autor>>): versi�n inicial.
     * </ul>
     *
     * @param n TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public void visit(specification n) {

        // ATTRIBUTE_DEFAULTS FIELD

        setDefaults(n.f2);
        
        
        //OGB INICIO
        String   nameForm  = null;
        int      posX = 0;
        int      posY = 0;
        int      width = 0;
        
        NodeList xs = n.f0.f1;
        for (Enumeration e = xs.elements(); e.hasMoreElements(); ) { 
        	
        	NodeChoice ch = (NodeChoice)e.nextElement();
            NodeSequence ns = (NodeSequence) ch.choice;
            
        	if(ns.nodes.get(2) instanceof NodeToken)
        	{
        		NodeToken nk = (NodeToken)ns.nodes.get(2);
        		if(((NodeToken)ns.nodes.get(0)).tokenImage.equals("NAME") )
        		{
        			nameForm = unquote(((NodeToken)ns.nodes.get(2)).tokenImage);
        		}
        		else if(((NodeToken)ns.nodes.get(0)).tokenImage.equals("AREA_TO_CLEAR") )
        		{
        			posX =  Integer.parseInt(((NodeToken)ns.nodes.get(2)).tokenImage);
        			posY =  Integer.parseInt(((NodeToken)ns.nodes.get(4)).tokenImage);
        		}
        			
        	}
            if(ns.nodes.get(2) instanceof NodeChoice) 
            {
            	NodeChoice  cs2 = (NodeChoice) ns.nodes.get(2);
            	NodeToken   ns2 = (NodeToken) cs2.choice;

            	NodeToken   nn2 = (NodeToken) ns.elementAt(0);
                
        		if(nn2.tokenImage.equals("WIDTH"))
        		{
        			width =  Integer.parseInt(ns2.tokenImage);
        		}
            }	
        } 
        
        forms.setName(nameForm); 
        forms.setAreaX(posX);
        forms.setAreaY(posY);
        forms.setWidth(width);        
        //OGB FIN
        
        logger.debug("name: "+nameForm);
        logger.debug("posX: "+posX);
        logger.debug("posY: "+posY);
        logger.debug("width: "+width);
        
        
        
        // TEXT
        /*
         * f0 -> <TEXT>
         * f1 -> <LPAR_ST_TEXT>
         * f2 -> <INTEGER_ST_TEXT>
         * f3 -> <COMMA_ST_TEXT>
         * f4 -> <INTEGER_ST_TEXT>
         * f5 -> <RPAR_ST_TEXT>
         * f6 -> [ <INTEGER_ST_TEXT> ]
         * f7 -> <STRING_ST_TEXT>
         * f8 -> [ <AMPERSAND> <STRING_ST_TEXT> ]
         * f9 -> ( <BOLD_TEXT> | <BLINK> )*
         * f10 -> <SEMICOLON_ST_TEXT>
         */

        for (Enumeration e = n.f1.elements(); e.hasMoreElements(); ) { // ( text() )+

            text t = (text) e.nextElement();

            boolean blink = false;

            for (int i = 0; i < t.f9.size(); i++) {

                if (((NodeChoice) t.f9.elementAt(i)).which == 1 /*<BLINK>*/) {
                    blink = true;
                    break;
                }
            }

            if (!blink) {

                StringBuffer sb = new StringBuffer();

                sb.append(unquote(t.f7.tokenImage));

                if (t.f8.present()) {

                    NodeSequence ns = (NodeSequence) t.f8.node;

                    sb.append(unquote(((NodeToken) ns.elementAt(1)).tokenImage));
                }

                int rep = t.f6.present() ? Integer.parseInt(((NodeToken) t.f6.node).tokenImage) : 1;

                if (rep > 1) {

                    String s = sb.toString();

                    for (int i = 1; i < rep; i++) {
                        sb.append(s);
                    }
                }

                texts.add(new TextDef(sb.toString(), Integer.parseInt(t.f2.tokenImage), Integer.parseInt(t.f4.tokenImage)));
            }
        }

        // FIELD (aux_simples / aux_indexados / all_indexes)

        HashMap<String, FieldDef>               aux_simples   = new HashMap<String, FieldDef>();
        HashMap<String, FieldDef>               aux_indexados = new HashMap<String, FieldDef>();
        HashMap<String, ArrayList<PositionDef>> all_indexes   = new HashMap<String, ArrayList<PositionDef>>();

        for (Enumeration e = n.f3.elements(); e.hasMoreElements(); ) { // ( field() )+

            field f = (field) e.nextElement();

            attributes = default_attrs;
            index      = null; // lo instancia processAssignAttribute()

            //

            for (Enumeration e1 = f.f1.elements(); e1.hasMoreElements(); ) { // ( field_assign() | field_attribute() )+
                processAssignAttribute((NodeChoice) e1.nextElement());
            }

            //

            try {

                // picture

                StringBuffer sb = new StringBuffer();

                for (int i = 0 ; i < picture_num; i++) {
                    sb.append(picture);
                }

                //

                FieldDef fd = new FieldDef(name, sb.toString(), def, attributes, row, column);

                //

                if (index == null) {

                  //logger.debug("agregando '" + name + "' a aux_simples");

                    aux_simples.put(name, fd);
                }
                else {

                    fd.row    = FieldDef.UNDEF;
                    fd.column = FieldDef.UNDEF;

                    aux_indexados.put(name, fd);
                    all_indexes.  put(name, index);

                  //logger.debug("agregando '" + name + "' a aux_indexados y all_indexes");
                }
            }
            catch (Exception e1) {
                logger.fatal("Exception: " + printStackTrace(e1));
            }
        }

        // ORDER

        ArrayList<ArrayList<ElementDef>> arrays = new ArrayList<ArrayList<ElementDef>>();
        ArrayList<ElementDef>            array  = null;
        NodeSequence                     ns     = null;
        int                              actual = Integer.MAX_VALUE;
        String                           campo  = null;
        int                              idx;
        int                              pos_abr;
        int                              pos_cie;

        /*
         * f0 -> <ORDER>
         * f1 -> <BEGIN_WITH>
         * f2 -> <EQUAL_ST_ORDER>
         * f3 -> <INTEGER_ST_ORDER>
         * f4 -> ( <NAME_ST_ORDER> <EQUAL_ST_ORDER> <STRING_ST_ORDER> )+
         * f5 -> <SEMICOLON_ST_ORDER>
         */

        for (int i = 0; i < n.f4.f4.size(); i++) { // ( <NAME_ST_ORDER> <EQUAL_ST_ORDER> <STRING_ST_ORDER> )+

            ns      = (NodeSequence) n.f4.f4.elementAt(i);
            campo   = unquote(((NodeToken) ns.elementAt(2)).tokenImage);
            pos_abr = campo.indexOf('(');
            pos_cie = campo.indexOf(')');

            if (pos_abr > 0 && pos_cie > 0) {

                idx = Integer.parseInt(campo.substring(pos_abr + 1, pos_cie));

              //logger.debug(campo.substring(0, pos_abr) + ", idx: " + idx + " (actual: " + actual + ")");

                if (idx < actual) {

                    if (array != null) {

                      //logger.debug("agregando array actual (" + array.size() + ") a arrays");

                        arrays.add(array);
                    }

                  //logger.debug("inicializando array");

                    array = new ArrayList<ElementDef>();
                }

                actual = idx;

                if (idx == 1) {

                    ElementDef ed = new ElementDef(aux_indexados.get(campo.substring(0, pos_abr)), all_indexes.get(campo.substring(0, pos_abr)));

                  //logger.debug("agregando a array: " + ed.field.name + " (" + ed.index.size() + ")");

                    array.add(ed);
                }
            }
        }

        if (array != null && array.size() > 0) {

          //logger.debug("agregando array actual (" + array.size() + ") a arrays");

            arrays.add(array);
        }

        /////////////////////////////////////////////////////////////
        //
        /////////////////////////////////////////////////////////////

        // FIELD

        ArrayList<String> considered = new ArrayList<String>();

        for (Enumeration e = n.f3.elements(); e.hasMoreElements(); ) { // ( field() )+

            field f = (field) e.nextElement();

            String name = null;

            for (Enumeration e1 = f.f1.elements(); e1.hasMoreElements(); ) { // ( field_assign() | field_attribute() )+

                NodeChoice nch = (NodeChoice) e1.nextElement();

                if (nch.choice instanceof field_assign) {

                    field_assign fa = (field_assign) nch.choice;

                    switch (fa.f0.which) {

                    case 3 :    // <NAME_ST_FIELD> <EQUAL_ST_FIELD> <STRING_ST_FIELD> <LPAR_ST_FIELD> <INTEGER_ST_FIELD> <COMMA_ST_FIELD> <INTEGER_ST_FIELD> <RPAR_ST_FIELD>

                        name = unquote(((NodeToken) ((NodeSequence) fa.f0.choice).elementAt(2)).tokenImage);

                        if      (aux_simples.containsKey(name)) {
                            fields.add(aux_simples.get(name));
                        }
                        else if (aux_indexados.containsKey(name) && !considered.contains(name.replace('_', '-'))) {

                            int cant = howArraysFinded(name.replace('_', '-'), arrays);

                          //logger.debug("aux_indexados '" + name + "' (" + name.replace('_', '-') + ") --> howArraysFinded(): " + cant);

                            if (cant != 1) {
                                throw new RuntimeException("campo '" + name + "' deberia salir en un solo arreglo.");
                            }

                            ArrayList<ElementDef> arr = getArrayContainingField(name.replace('_', '-'), arrays);

                            for (ElementDef elem : arr) {

                              //logger.debug("agregando a '" + elem.field.name + "' a considered");

                                considered.add(elem.field.name);
                            }

                            fields.add(arr);
                        }

                        break;
                    }
                }
            }
        }

        n.f0.accept(this);
        n.f1.accept(this);
        n.f2.accept(this);
        n.f3.accept(this);
        n.f4.accept(this);
        n.f5.accept(this);
        n.f6.accept(this);
        n.f7.accept(this);
    }

    /******************************************************************************
     * howArraysFinded
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param n TODO_javadoc.
     *
     */
    private int howArraysFinded(String name, ArrayList<ArrayList<ElementDef>> arrays) {

        int cant = 0;

        for (ArrayList<ElementDef> array : arrays) {

            for (ElementDef elem : array) {

              //logger.debug(elem);

                if (elem.field.name.equals(name)) {
                    cant++;
                }
            }
        }

        return cant;
    }

    /******************************************************************************
     * getArrayContainingField
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param n TODO_javadoc.
     *
     */
    private ArrayList<ElementDef> getArrayContainingField(String name, ArrayList<ArrayList<ElementDef>> arrays) {

        for (ArrayList<ElementDef> array : arrays) {

            for (ElementDef elem : array) {

                if (elem.field.name.equals(name)) {
                    return array;
                }
            }
        }

        return null;
    }

    /******************************************************************************
     * setDefaults
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * Registro de versiones:<ul>
     *
     * <li>1.0 (v21/12/2005, <<autor>>): versi�n inicial.
     * </ul>
     *
     * @param n TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private void setDefaults(adef n) {
        logger.info("-setDefaults-");
        name           = "";

        clearCharacter = "";
        def            = "";
        help           = "";
        picture_num    = FieldDef.UNDEF;
        picture        = "";

        row            = FieldDef.UNDEF;
        column         = FieldDef.UNDEF;

        attributes     = 0x00000000;

        for (Enumeration e = n.f2.elements(); e.hasMoreElements(); ) {
            processAssignAttribute((NodeChoice) e.nextElement());
        }

        default_attrs = attributes;
    }

    /******************************************************************************
     * processAssignAttribute
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * Registro de versiones:<ul>
     *
     * <li>1.0 (v21/12/2005, <<autor>>): versi�n inicial.
     * </ul>
     *
     * @param nch TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private void processAssignAttribute(NodeChoice nch) {

        NodeSequence ns = null;

        if (nch.choice instanceof field_assign) {

            field_assign fa = (field_assign) nch.choice;

            switch (fa.f0.which) {

            case 0 :    // <CLEAR_CHARACTER> <EQUAL_ST_FIELD> <STRING_ST_FIELD>
                
                clearCharacter = unquote(((NodeToken) ((NodeSequence) fa.f0.choice).elementAt(2)).tokenImage);

                break;

            case 1 :    // <DEF> <EQUAL_ST_FIELD> <STRING_ST_FIELD>

                def = unquote(((NodeToken) ((NodeSequence) fa.f0.choice).elementAt(2)).tokenImage);

                break;

            case 2 :    // <HELP> <EQUAL_ST_FIELD> <STRING_ST_FIELD>

                help = unquote(((NodeToken) ((NodeSequence) fa.f0.choice).elementAt(2)).tokenImage);

                break;

            case 3 :    // <NAME_ST_FIELD> <EQUAL_ST_FIELD> <STRING_ST_FIELD> <LPAR_ST_FIELD> <INTEGER_ST_FIELD> <COMMA_ST_FIELD> <INTEGER_ST_FIELD> <RPAR_ST_FIELD>

                name = unquote(((NodeToken) ((NodeSequence) fa.f0.choice).elementAt(2)).tokenImage);

                row    = Integer.parseInt(((NodeToken) ((NodeSequence) fa.f0.choice).elementAt(4)).tokenImage);
                column = Integer.parseInt(((NodeToken) ((NodeSequence) fa.f0.choice).elementAt(6)).tokenImage);

                break;

            case 4 :    // <PICTURE> <EQUAL_ST_FIELD> [ <INTEGER_ST_FIELD> ] <STRING_ST_FIELD>

                NodeOptional no  =       (NodeOptional) ((NodeSequence) fa.f0.choice).elementAt(2);

                String       aux = unquote(((NodeToken) ((NodeSequence) fa.f0.choice).elementAt(3)).tokenImage);

                if (no.present()) {

                    picture_num = Integer.parseInt(((NodeToken) no.node).tokenImage);
                    picture     = aux;

                    if (aux.length() != 1) {
                        logger.fatal("largo de picture repetible de '" + name + "' es distinto a uno.");
                    }
                }
                else {

                    picture_num = 1;
                    picture     = aux;
                }

                break;

            case 5 :    // <INDEX_ST_FIELD> <EQUAL_ST_FIELD> <LPAR_ST_FIELD> <INTEGER_ST_FIELD> <COMMA_ST_FIELD> <INTEGER_ST_FIELD> <RPAR_ST_FIELD> ( <COLON_ST_FIELD> <LPAR_ST_FIELD> <INTEGER_ST_FIELD> <COMMA_ST_FIELD> <INTEGER_ST_FIELD> <RPAR_ST_FIELD> )*

                index = new ArrayList<PositionDef>();

                index.add(new PositionDef(row, column)); // se asume que row, column tienen valores anteriores del nombre.

                row    = Integer.parseInt(((NodeToken) ((NodeSequence) fa.f0.choice).elementAt(3)).tokenImage);
                column = Integer.parseInt(((NodeToken) ((NodeSequence) fa.f0.choice).elementAt(5)).tokenImage);

                index.add(new PositionDef(row, column)); // primer elemento lista

                NodeListOptional nlo = (NodeListOptional) ((NodeSequence) fa.f0.choice).elementAt(7); // <COLON_ST_FIELD> <LPAR_ST_FIELD> <INTEGER_ST_FIELD> <COMMA_ST_FIELD> <INTEGER_ST_FIELD> <RPAR_ST_FIELD>

                for (Enumeration e = nlo.elements(); e.hasMoreElements(); ) {

                    NodeSequence ns1 = (NodeSequence) e.nextElement();

                    row    = Integer.parseInt(((NodeToken) ns1.elementAt(2)).tokenImage);
                    column = Integer.parseInt(((NodeToken) ns1.elementAt(4)).tokenImage);

                    index.add(new PositionDef(row, column));
                }

                break;
            }
        }
        else if (nch.choice instanceof field_attribute) {

            field_attribute fa = (field_attribute) nch.choice;

            switch (fa.f0.which) {

            case 0 : // <BLANK_FILL>

                attributes |=  FieldDef.BLANK_FILL_ATTR;
                attributes &= ~FieldDef. ZERO_FILL_ATTR;

                break;

            case 1 : // <DISPLAY_ONLY>

                attributes |=  FieldDef.  DISPLAY_ONLY_ATTR;
                attributes &= ~FieldDef.NODISPLAY_ONLY_ATTR;

                break;

            case 2 : // <ECHO>

                attributes |=  FieldDef.  ECHO_ATTR;
                attributes &= ~FieldDef.NOECHO_ATTR;

                break;

            case 3 : // <FIXED_DECIMAL>

                attributes |=  FieldDef.  FIXED_DECIMAL_ATTR;
                attributes &= ~FieldDef.NOFIXED_DECIMAL_ATTR;

                break;

            case 4 : // <LEFT_JUSTIFIED>

                attributes |=  FieldDef. LEFT_JUSTIFIED_ATTR;
                attributes &= ~FieldDef.RIGHT_JUSTIFIED_ATTR;

                break;

            case 5 : // <NOAUTOTAB>

                attributes |= FieldDef.NOAUTOTAB_ATTR;

                break;

            case 6 : // <NOBLINKING>

                attributes |= FieldDef.NOBLINKING_ATTR;

                break;

            case 7 : // <NOBOLD>

                attributes |=  FieldDef.NOBOLD_ATTR;
              //attributes &= ~FieldDef.  BOLD_FIELD_ATTR;

                break;

            case 8 : // <NODISPLAY_ONLY>

                attributes |=  FieldDef.NODISPLAY_ONLY_ATTR;
                attributes &= ~FieldDef.  DISPLAY_ONLY_ATTR;

                break;

            case 9 : // <NOECHO>

                attributes |=  FieldDef.NOECHO_ATTR;
                attributes &= ~FieldDef.  ECHO_ATTR;

                break;

            case 10 : // <NOFIXED_DECIMAL>

                attributes |=  FieldDef.NOFIXED_DECIMAL_ATTR;
                attributes &= ~FieldDef.  FIXED_DECIMAL_ATTR;

                break;

            case 11 : // <NOREVERSE>

                attributes |=  FieldDef.NOREVERSE_ATTR;
                attributes &= ~FieldDef.  REVERSE_ATTR;

                break;

            case 12 : // <NOSUPERVISOR_ONLY>

                attributes |= FieldDef.NOSUPERVISOR_ONLY_ATTR;

                break;

            case 13 : // <NOSUPPRESS>

                attributes |=  FieldDef.NOSUPPRESS_ATTR;
                attributes &= ~FieldDef.  SUPPRESS_ATTR;

                break;

            case 14 : // <NOUNDERLINE>

                attributes |=  FieldDef.NOUNDERLINE_ATTR;
                attributes &= ~FieldDef.  UNDERLINE_ATTR;

                break;

            case 15 : // <NOUPPERCASE>

                attributes |= FieldDef.NOUPPERCASE_ATTR;

                break;

            case 16 : // <RESPONSE_REQUIRED>

                attributes |= FieldDef.RESPONSE_REQUIRED_ATTR;

                break;

            case 17 : // <REVERSE>

                attributes |=  FieldDef.  REVERSE_ATTR;
                attributes &= ~FieldDef.NOREVERSE_ATTR;

                break;

            case 18 : // <RIGHT_JUSTIFIED>

                attributes |=  FieldDef.RIGHT_JUSTIFIED_ATTR;
                attributes &= ~FieldDef. LEFT_JUSTIFIED_ATTR;

                break;

            case 19 : // <SUPPRESS>

                attributes |=  FieldDef.  SUPPRESS_ATTR;
                attributes &= ~FieldDef.NOSUPPRESS_ATTR;

                break;

            case 20 : // <ZERO_FILL>

                attributes |=  FieldDef. ZERO_FILL_ATTR;
                attributes &= ~FieldDef.BLANK_FILL_ATTR;

                break;

            case 21 : // <BOLD_FIELD>

                attributes |=  FieldDef.  BOLD_FIELD_ATTR;
              //attributes &= ~FieldDef.NOBOLD      _ATTR;

                break;

            case 22 : // <UNDERLINE>

                attributes |=  FieldDef.  UNDERLINE_ATTR;
                attributes &= ~FieldDef.NOUNDERLINE_ATTR;

                break;
            }
        }
    }

    /******************************************************************************
     * trimBS
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * Registro de versiones:<ul>
     *
     * <li>1.0 (v21/12/2005, <<autor>>): versi�n inicial.
     * </ul>
     *
     * @param s TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private String trimBS(String s) {

        StringBuffer sb = new StringBuffer();

        sb.append(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i - 1) != '\'' || s.charAt(i) != '\'') {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    /******************************************************************************
     * unquote
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * Registro de versiones:<ul>
     *
     * <li>1.0 (v21/12/2005, <<autor>>): versi�n inicial.
     * </ul>
     *
     * @param s TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    protected String unquote(String s) {

        s = trimBS(s);

        return s.substring(1, s.length() - 1);
    }

    /******************************************************************************
     * printStackTrace
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param e TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    protected static String printStackTrace(Throwable e) {

        CharArrayWriter caw = new CharArrayWriter();

        e.printStackTrace(new PrintWriter(caw));

        return caw.toString();
    }
}
