/*
 *   Copyright (c) 2019 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.genfrmjava.util;


import java.util.*;
import java.util.regex.*;

import org.apache.log4j.*;


/**
 *
 * TODO_javadoc.
 *
 * @version 1.0 (01/01/2013).
 *
 */
public class FieldDef {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(FieldDef.class);

    /** TODO_javadoc. */
    public static final int UNDEF = -1;

    //

    /** TODO_javadoc. */
    public static final int INTEGER = 1;

    /** TODO_javadoc. */
    public static final int LONG = 2;

    /** TODO_javadoc. */
    public static final int DOUBLE = 3;

    /** TODO_javadoc. */
    public static final int CHAR = 4;

    /** TODO_javadoc. */
    public static final int BOOLEAN = 5;

    /** TODO_javadoc. */
    public static final int STRING = 6;

    /** TODO_javadoc. */
    public static final int DATE = 7;

    //

    /** TODO_javadoc. */
    public static final int IKY = 1;

    /** TODO_javadoc. */
    public static final int MKY = 2;

    /** TODO_javadoc. */
    public static final int AKY = 3;

    /** TODO_javadoc. */
    public static final int FLD = 4;

    /** TODO_javadoc. */
    private static final String modifier_names[] = { "", "IKY", "MKY", "AKY", "FLD" };

    //

    /** TODO_javadoc. */
    public static final int FEC     = 1;
    
    /** TODO_javadoc. */
    public static final int GLS_IDC = 2;

    /** TODO_javadoc. */
    public static final int IDC     = 3;

    /** TODO_javadoc. */
    public static final int IDG     = 4;

    /** TODO_javadoc. */
    public static final int OFI     = 5;

    /** TODO_javadoc. */
    public static final int SGV     = 6;
    
    /** TODO_javadoc. */
    public static final int VRF     = 7;

    //

    /** TODO_javadoc. */
    public static final int BLANK_FILL_ATTR        = 0x00000001;

    /** TODO_javadoc. */
    public static final int DISPLAY_ONLY_ATTR      = 0x00000002;

    /** TODO_javadoc. */
    public static final int ECHO_ATTR              = 0x00000004;

    /** TODO_javadoc. */
    public static final int FIXED_DECIMAL_ATTR     = 0x00000008;

    /** TODO_javadoc. */
    public static final int LEFT_JUSTIFIED_ATTR    = 0x00000010;

    /** TODO_javadoc. */
    public static final int NOAUTOTAB_ATTR         = 0x00000020;

    /** TODO_javadoc. */
    public static final int NOBLINKING_ATTR        = 0x00000040;

    /** TODO_javadoc. */
    public static final int NOBOLD_ATTR            = 0x00000080;

    /** TODO_javadoc. */
    public static final int NODISPLAY_ONLY_ATTR    = 0x00000100;

    /** TODO_javadoc. */
    public static final int NOECHO_ATTR            = 0x00000200;

    /** TODO_javadoc. */
    public static final int NOFIXED_DECIMAL_ATTR   = 0x00000400;

    /** TODO_javadoc. */
    public static final int NOREVERSE_ATTR         = 0x00000800;

    /** TODO_javadoc. */
    public static final int NOSUPERVISOR_ONLY_ATTR = 0x00001000;

    /** TODO_javadoc. */
    public static final int NOSUPPRESS_ATTR        = 0x00002000;

    /** TODO_javadoc. */
    public static final int NOUNDERLINE_ATTR       = 0x00004000;

    /** TODO_javadoc. */
    public static final int NOUPPERCASE_ATTR       = 0x00008000;

    /** TODO_javadoc. */
    public static final int RESPONSE_REQUIRED_ATTR = 0x00010000;

    /** TODO_javadoc. */
    public static final int REVERSE_ATTR           = 0x00020000;

    /** TODO_javadoc. */
    public static final int RIGHT_JUSTIFIED_ATTR   = 0x00040000;

    /** TODO_javadoc. */
    public static final int SUPPRESS_ATTR          = 0x00080000;

    /** TODO_javadoc. */
    public static final int ZERO_FILL_ATTR         = 0x00100000;

    /** TODO_javadoc. */
    public static final int BOLD_FIELD_ATTR        = 0x00200000;

    /** TODO_javadoc. */
    public static final int UNDERLINE_ATTR         = 0x00400000;

    //

    /** TODO_javadoc. */
    private static final String type_names[]        = { "",    "integer", "long", "double", "char",      "boolean", "string", "date" };

    /** TODO_javadoc. */
    private static final String javatype_names[]    = { "",    "int",     "long", "double", "char",      "boolean", "String", "Date" };

    /** TODO_javadoc. */
    private static final String javaobjtype_names[] = { "",    "Integer", "Long", "Double", "Character", "Boolean", "String", "Date" };

    /** TODO_javadoc. */
    private static final boolean type_object[]      = { false, false,     false,  false,    false,       false,     true,     true };

    //

    /** TODO_javadoc. */
    private static final String special_names[] = { "", "FEC", "GLS_IDC", "IDC", "IDG", "OFI" , "SGV", "VRF" /* ordenados */};

    /** TODO_javadoc. */
    public static final String[] date_initials = { "D", "M", "S", "A" };

    /** TODO_javadoc. */
    public static final String FRM = "FRM";

    //

    /** TODO_javadoc. */
    private static final Pattern pdigits     = Pattern.compile("^" +          "[N]+"                                                     + "(,[N]+)?" + "$", Pattern.CASE_INSENSITIVE);

    /** TODO_javadoc. */
    private static final Pattern pdigitsSign = Pattern.compile("^" + "[N]?" + "[9]+"                                                     + "(,[9]+)?" + "$", Pattern.CASE_INSENSITIVE);

    /** TODO_javadoc. */
    private static final Pattern pnumSm      = Pattern.compile("^" + "([N]{1,3})?" + "(\\.[N]{3})*"                                      + "(,[N]+)?" + "$", Pattern.CASE_INSENSITIVE);

    /** TODO_javadoc. */
    private static final Pattern pdigitsSm   = Pattern.compile("^" + "([9]{1,3})?" + "(\\.[9]{3})*"                                      + "(,[9]+)?" + "$", Pattern.CASE_INSENSITIVE);

    /** TODO_javadoc. */
    private static final Pattern pmixSm      = Pattern.compile("^" + "([N]{1,3})?" + "(\\.[N]{3})*" + "(\\.(N99|NN9))?" + "(\\.[9]{3})*" + "(,[9]+)?" + "$", Pattern.CASE_INSENSITIVE);

    /** TODO_javadoc. */
    private static final Pattern pnumDigits  = Pattern.compile("^" + "[9N\\.,]+"                                                                      + "$", Pattern.CASE_INSENSITIVE);

    /** TODO_javadoc. */
    private static final Pattern pdate       = Pattern.compile("^" + "((99[-/B]){2}9999)|(9999([-/B]99){2})"                                          + "$", Pattern.CASE_INSENSITIVE);

    //

    /** TODO_javadoc. */
    public String name = null;

    /** TODO_javadoc. */
    public int special = UNDEF;

    /** TODO_javadoc. */
    public int modifier = UNDEF;

    /** TODO_javadoc. */
    public int type = UNDEF;

    /** TODO_javadoc. */
    public int size = 0;

    /** TODO_javadoc. */
    public int integers = 0;

    /** TODO_javadoc. */
    public int decimals = 0;

    /** TODO_javadoc. */
    public boolean sign = false;

    /** TODO_javadoc. */
    public String fmsname = null;

    /** TODO_javadoc. */
    public String picture = null;

    /** TODO_javadoc. */
    public String xdefault = null;

    /** TODO_javadoc. */
    public int attributes = 0x00000000;

    /** TODO_javadoc. */
    public int row = UNDEF;

    /** TODO_javadoc. */
    public int column = UNDEF;

    /** TODO_javadoc. */
    public int map_index = UNDEF;

    //

    /** TODO_javadoc. */
    public ArrayList<FieldDef> replaced = null;

    /** TODO_javadoc. */
  //public int struct_size;

    /** TODO_javadoc. */
  //public ArrayList<FLGPositionDef> index = null;

    /******************************************************************************
     * FieldDef
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public FieldDef() {}

    /******************************************************************************
     * FieldDef
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param name TODO_javadoc.
     * @param special TODO_javadoc.
     * @param modifier TODO_javadoc.
     * @param type TODO_javadoc.
     * @param size TODO_javadoc.
     * @param integers TODO_javadoc.
     * @param decimals TODO_javadoc.
     * @param sign TODO_javadoc.
     * @param fmsname TODO_javadoc.
     * @param picture TODO_javadoc.
     * @param xdefault TODO_javadoc.
     * @param attributes TODO_javadoc.
     * @param row TODO_javadoc.
     * @param column TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public FieldDef(String name, String special, int modifier, int type, int size, int integers, int decimals, boolean sign, String fmsname, String picture, String xdefault, int attributes, int row, int column) {

        this.name = name;

        if (special == null || special.equals("")) {
            this.special = UNDEF;
        }
        else {
            this.special = Arrays.binarySearch(special_names, special);
        }

        this.modifier   = modifier;
        this.type       = type;
        this.size       = size;
        this.integers   = integers;
        this.decimals   = decimals;
        this.sign       = sign;
        this.fmsname    = fmsname;
        this.picture    = picture;
        this.xdefault   = xdefault;
        this.attributes = attributes;
        this.row        = row;
        this.column     = column;
    }

    /******************************************************************************
     * FieldDef
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param name TODO_javadoc.
     * @param modifier TODO_javadoc.
     * @param type TODO_javadoc.
     * @param size TODO_javadoc.
     * @param integers TODO_javadoc.
     * @param decimals TODO_javadoc.
     * @param sign TODO_javadoc.
     * @param fmsname TODO_javadoc.
     * @param picture TODO_javadoc.
     * @param xdefault TODO_javadoc.
     * @param attributes TODO_javadoc.
     * @param row TODO_javadoc.
     * @param column TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public FieldDef(String name, int modifier, int type, int size, int integers, int decimals, boolean sign, String fmsname, String picture, String xdefault, int attributes, int row, int column) {

        this.name       = name;
        this.special    = getSpecial(fmsname);
        this.modifier   = modifier;
        this.type       = type;
        this.size       = size;
        this.integers   = integers;
        this.decimals   = decimals;
        this.sign       = sign;
        this.fmsname    = fmsname;
        this.picture    = picture;
        this.xdefault   = xdefault;
        this.attributes = attributes;
        this.row        = row;
        this.column     = column;
    }

    /******************************************************************************
     * FieldDef
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param fmsname TODO_javadoc.
     * @param picture TODO_javadoc.
     * @param xdefault TODO_javadoc.
     * @param attributes TODO_javadoc.
     * @param row TODO_javadoc.
     * @param column TODO_javadoc.
     *
     * @throws Exception TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public FieldDef(String fmsname, String picture, String xdefault, int attributes, int row, int column) {

        this.fmsname    = fmsname;
        this.picture    = picture;
        this.xdefault   = xdefault;
        this.attributes = attributes;
        this.row        = row;
        this.column     = column;

        if (fmsname.substring(0, 2).equals("F$")) { // F$0001
            name = "GNS-GLS-CFLD";
        }
        else if (!getAdditType(fmsname).equals("")) {                                                       // 0123456789012345
            name = fmsname.substring(0, fmsname.length() - 5).replace('_', '-');                            // GDG_COD_OFIC_OFI --> GDG-COD-OFIC
        }
        else if (fmsname.indexOf('$') > -1) {                                                               // 0123456789012345678901234
            name = fmsname.substring(fmsname.indexOf('$', fmsname.indexOf('$') + 1) + 1).replace('_', '-'); // GLE$COD$GLE_IKY_CAI_GTIA --> GLE-IKY-CAI-GTIA
        }
        else {
            name = fmsname.replace('_', '-');
        }

        // 01234567890123456
        // GLE-IKY_CAI_GTIA

        modifier = getModifierFromFMS(fmsname);

        if (modifier == UNDEF) {

            name = fmsname.replace('_', '-');

          //if ((attributes & RESPONSE_REQUIRED_ATTR) == RESPONSE_REQUIRED_ATTR) {
                modifier = FLD;
          //}
        }
        else {
            name = (fmsname.substring(0, 4) + fmsname.substring(8)).replace('_', '-'); // GLE-IKY-CAI-GTIA --> GLE-CAI-GTIA
        }

        //

        type = getTypeFromPicture(picture);

        //

        switch(type) {

        case INTEGER :
        case LONG :

            integers = getIntegers(picture);
            decimals = 0;
            sign     = picture.charAt(0) == 'N';

            if (integers > 9) {
                type = LONG;
            }

            break;

        case DOUBLE :

            integers = getIntegers(picture);
            decimals = getDecimals(picture);
            sign     = picture.charAt(0) == 'N';

            break;
        }

        //

        validateDateType();

        //

        switch(type) {

        case INTEGER :
        case LONG :
        case DOUBLE :

            if (pdigits.matcher(picture).find() || pdigitsSign.matcher(picture).find() ) {
                size = getEDTFormat(integers, decimals, sign).length();
            }

            size = picture.length();

            break;

        default:

        	//OGB - cuando string comienza con guiones estos no se toman en cuenta en el tamaño
            //size = picture.length();
            size = (picture.startsWith("-")) ? picture.substring(picture.indexOf("X")).length() : picture.length();
            
        }

        //

        special = getSpecial(fmsname);

        /*
        struct_size = 0;
        index       = null;
        */
    }

    /******************************************************************************
     * getEDTFormat
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param integers TODO_javadoc.
     * @param decimals TODO_javadoc.
     * @param sign TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public static String getEDTFormat(int integers, int decimals, boolean sign) {

        StringBuffer sb = new StringBuffer();

        char dig = sign ? '-' : 'Z';

        if (decimals > 0) {

            for (int i = 0; i < decimals; i++) {
                sb.append(dig);
            }

            sb.append(',');
        }

        for (int i = 0; i < integers; i++) {

            sb.append(dig);

            if (i != integers - 1 && i % 3 == 2) {
                sb.append('.');
            }
        }

        return sb.reverse().toString();
    }

    /******************************************************************************
     * validateDateType
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public void validateDateType() {

        String secGru = secordGroup(fmsname);

        if (type == DATE) {

            if (!secGru.equals("FEC") &&
                !secGru.equals("DMA") /*&& !secGru.equals("ADM") &&
                !secGru.equals("MSA") && !secGru.equals("SAM") &&
                !secGru.equals("FMA") && !secGru.equals("FAM") &&
                !secGru.equals("FSA") && !secGru.equals("FAS") &&
                !secGru.equals("FDM") && !secGru.equals("FMD") &&
                !secGru.equals("FFA")*/) {

                logger.warn("'" + name + "': secGru de variable 'date' (" + secGru + ") no es conocido.");
            }

            if (name.charAt(8) != 'F') {
                logger.warn("'" + name + "': variable DATE tiene un codigo de campo que no comienza con 'F'.");
            }
        }
        else {

            if (secGru.equals("FEC") ||
                secGru.equals("DMA") /*|| secGru.equals("ADM") ||
                secGru.equals("MSA") || secGru.equals("SAM") ||
                secGru.equals("FMA") || secGru.equals("FAM") ||
                secGru.equals("FSA") || secGru.equals("FAS") ||
                secGru.equals("FDM") || secGru.equals("FMD") ||
                secGru.equals("FFA")*/) {

                logger.warn("'" + name + "': variable tipo '" + getTypeString(type) + "' pasara a tener tipo 'date' (" + picture + ").");

                type = DATE;
            }
        }

        /*
        if (type == DATE && size != 8) {

            size = 8;

            logger.warn("'" + name + "': variable tipo '" + getTypeString(type) + "' ajustado largo a " + size + ".");
        }
        */
    }

    /******************************************************************************
     * getModifierFromFMS
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param fmsname TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static int getModifierFromFMS(String fmsname) {

        String key = fmsname.substring(3, 8);

        if        (key.equals("_IKY_")) {
            return IKY;
        } else if (key.equals("_MKY_")) {
            return MKY;
        } else if (key.equals("_AKY_")) {
            return AKY;
        } else {
            return UNDEF;
        }
    }

    /******************************************************************************
     * getTypeString
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param type TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public static String getTypeString(int type) {

        if (type > 0 && type < type_names.length) {
            return type_names[type];
        }

        return "";
    }

    /******************************************************************************
     * getJavaTypeString
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param type TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public static String getJavaTypeString(int type) {

        if (type > 0 && type < javatype_names.length) {
            return javatype_names[type];
        }

        return "";
    }

    /******************************************************************************
     * getJavaObjectTypeString
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param type TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public static String getJavaObjectTypeString(int type) {

        if (type > 0 && type < javaobjtype_names.length) {
            return javaobjtype_names[type];
        }

        return "";
    }

    /******************************************************************************
     * isJavaTypeObject
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param type TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public static boolean isJavaTypeObject(int type) {

        if (type > 0 && type < type_object.length) {
            return type_object[type];
        }

        return false;
    }

    /******************************************************************************
     * getModifierString
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param type TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public static String getModifierString(int modifier) {

        if (modifier > 0 && modifier < modifier_names.length) {
            return modifier_names[modifier];
        }

        return "";
    }

    /******************************************************************************
     * getSpecialString
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param special TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public static String getSpecialString(int special) {

        if (special > 0 && special < special_names.length) {
            return special_names[special];
        }

        return "";
    }

    /******************************************************************************
     * haveOnly
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param s TODO_javadoc.
     * @param arr TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static boolean haveOnly(String s, char[] arr) {

        for (int i = 0; i < s.length(); i++) {

            if (!contains(arr, s.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /******************************************************************************
     * contains
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param arr TODO_javadoc.
     * @param c TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private static boolean contains(char[] arr, char c) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == c) {
                return true;
            }
        }

        return false;
    }

    /******************************************************************************
     * getTypeFromPicture
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param picture TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private int getTypeFromPicture(String picture) {

      //logger.debug("entrando en 'getTypeFromPicture(" + picture + ")' ...");

        if (pdigits.matcher(picture).find() || pdigitsSign.matcher(picture).find() || pnumSm.matcher(picture).find() || pdigitsSm.matcher(picture).find() || pmixSm.matcher(picture).find()) {

            return picture.indexOf(',') != -1 ? DOUBLE : INTEGER;

        } else if (pdate.matcher(picture).find()) {

            return DATE;

        } else if (haveOnly(picture, new char[] { 'X' })) {

            return picture.length() > 1 ? STRING : CHAR;
        }
        else {

            // formaciones ad-hoc

            if (pnumDigits.matcher(picture).find()) {

                 logger.debug("picture '" + picture + "' considerado numerico ...");

                 return picture.indexOf(',') != -1 ? DOUBLE : INTEGER;
            }
            else {

                logger.debug("picture '" + picture + "' considerado 'string' ...");

                return STRING;
            }
        }
    }

    /******************************************************************************
     * getIntegers
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param picture TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private int getIntegers(String picture) {

        int     cant = 0;
        boolean flag = true;

        for (int i = 0; i < picture.length(); i++) {

            switch (picture.charAt(i)) {

            case ',' :

                flag = false;

                break;

            case '9' :
            case 'N' :

                if (flag) {
                    cant++;
                }

                break;
            }
        }

        return cant;
    }

    /******************************************************************************
     * getDecimals
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param picture TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private int getDecimals(String picture) {

        int     cant = 0;
        boolean flag = false;

        for (int i = 0; i < picture.length(); i++) {

            switch (picture.charAt(i)) {

            case ',' :

                flag = true;

                break;

            case '9' :
            case 'N' :

                if (flag) {
                    cant++;
                }

                break;
            }
        }

        return cant;
    }

    /******************************************************************************
     * getSpecial
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param fmsname TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private int getSpecial(String fmsname) {

        String secGru    = secordGroup (fmsname);
        String additType = getAdditType(fmsname);

        if (secGru.equals("FEC") ||
            secGru.equals("DMA") /*|| secGru.equals("ADM") ||
            secGru.equals("MSA") || secGru.equals("SAM") ||
            secGru.equals("FMA") || secGru.equals("FAM") ||
            secGru.equals("FSA") || secGru.equals("FAS") ||
            secGru.equals("FDM") || secGru.equals("FMD") ||
            secGru.equals("FFA")*/) {

            return FEC;
        }
        else if (secGru.equals("IDC")) {
            return IDC;
        }
        else if (additType.equals("IDG")) { // $IDG
            return IDG;
        }
        else if (additType.equals("OFI")) { // $OFI
            return OFI;
        }
        else if (secGru.equals("VRF")) {
            return VRF;
        }
        else if (secGru.equals("SGV")) {
            return SGV;
        }
        else {
            return UNDEF;
        }
    }

    /******************************************************************************
     * secordGroup
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param fmsname TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private String secordGroup(String fmsname) {

      //logger.debug("entrando a 'secordGroup(" + fmsname + ")' ...");

        int pos, pos1;

        String token = null;

        if ((pos = fmsname.indexOf('$')) > -1) {

           if ((pos1 = fmsname.indexOf('$', pos + 1)) > -1) { // 012345678901234567890123
               token = fmsname.substring(pos + 1, pos1);      // GLE$COD$GLE_IKY_CAI_GTIA --> COD
           }
           else {                             // 01234567890123456
               token = getAdditType(fmsname); // GDG_COD_OFIC_$OFI  --> OFI
           }
        }
        else if (getModifierFromFMS(fmsname) != UNDEF) { // 0123456789012345678901234
           token = fmsname.substring(8, 11);             // ABC_IKY_COD_VXYZ --> COD
        }
        else {                              // 012345678901
           token = fmsname.substring(4, 7); // ABC_COD_VXYZ --> COD
        }

      //logger.debug("saliendo de 'secordGroup('" + fmsname + "'-->'" + token + "')' ...");

        return token;
    }

    /******************************************************************************
     * getAdditType
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param fmsname TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    private String getAdditType(String fmsname) {

        if (fmsname.endsWith("$OFI") || fmsname.endsWith("$IDG")) { // 01234567890123456
            return fmsname.substring(fmsname.length() - 3);         // GDG_COD_OFIC_$OFI
        }
        else {
            return "";
        }
    }

    /******************************************************************************
     * hasAttribute
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param attributes TODO_javadoc.
     * @param attribute TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public static boolean hasAttribute(int attributes, int attribute) {
        return (attributes & attribute) == attribute;
    }

    /******************************************************************************
     * absenceAttribute
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     *
     * @param attributes TODO_javadoc.
     * @param attribute TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public static boolean absenceAttribute(int attributes, int attribute) {
        return (attributes & attribute) == 0x00000000;
    }

    /******************************************************************************
     * toString
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     * @since 1.0
     *
     */
    public String toString() {

        StringBuffer sb = new StringBuffer();

        sb.append("[name : " + name + "]");
        sb.append("[special : "  + getSpecialString(special) + "]");
        sb.append("[modifier : " + getModifierString(modifier) + "]");
        sb.append("[type : "     + getTypeString(type) + "]");

        sb.append("[size : " + size + "]");
        sb.append("[integers : " + integers + "]");
        sb.append("[decimals : " + decimals + "]");
        sb.append("[sign : " + sign + "]");
        sb.append("[picture : " + picture + "]");
        sb.append("[xdefault : " + (xdefault == null ? "(NULL)" : xdefault) + "]");
        sb.append("[row : " + row + "]");
        sb.append("[column : " + column + "]");

        return sb.toString();
    }
}
