/*
 *   Copyright (c) 20XX by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.perseus.cobolparser.visitor;


import java.io.*;

import java.util.*;

import cl.bee.perseus.cobolparser.syntaxtree.*;
import cl.bee.perseus.cobolparser.util.*;

import cl.bee.perseus.util.*;

import org.apache.log4j.*;


/**
 *
 * TODO_javadoc.
 *
 * @version 1.0 (01/01/2020).
 *
 */
public class ModelVisitor extends BaseVisitor implements GJVisitor<TypedCode, HashMap<String, Object>> {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(ModelVisitor.class);

    /** TODO_javadoc. */
    private static final String FILLER = "FILLER";

    /** TODO_javadoc. */
    private static final String FIGURATIVE_VALUE = "figurative_value";

    /** TODO_javadoc. */
    private static final int LEVEL_88 = 88;

    /** TODO_javadoc. */
    private static final int LEVEL_77 = 77;

    /** TODO_javadoc. */
    private static final int MAX_LENGTH = 4 * 1024; ///////////////////////////////////////////////////////////////

    //

    /** TODO_javadoc. */
    private ArrayList<DataEntryDesc> entryArray = null;

    //

    /** TODO_javadoc. */
    private int idx;

    /** TODO_javadoc. */
    private ArrayList<DataDescriptionEntry> dataDescriptionEntryArray = new ArrayList<DataDescriptionEntry>();

    /******************************************************************************
     * ModelVisitor
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param entryArray TODO_javadoc.
     * @param filename TODO_javadoc.
     * @param jsonparams TODO_javadoc.
     *
     */
    public ModelVisitor(ArrayList<DataEntryDesc> entryArray, String filename, String jsonparams) {

        this.entryArray = entryArray;
        this.filename   = filename;

        setJsonParams(jsonparams);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> FileSection()
     *       | WorkingStorageSection()
     *       | LinkageSection()
     *       | CommunicationSection()
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(DataDivisionSection n, HashMap<String, Object> argu) {

        n.f0.accept(this, argu);

        //

        ArrayList<DataEntryDesc> autom = new ArrayList<DataEntryDesc>();

        for (idx = 0; idx < dataDescriptionEntryArray.size(); ) {

            DataEntryDesc ded = makeEntryTree(autom); // modifica el idx

            if (ded != null) {
                entryArray.add(ded);
            }
        }

        // offsets & value

        Result res = null;

        for (int i = 0; i < entryArray.size(); i++) {

            entryArray.get(i).offset = 0;

            res = setArrayOffsets(entryArray.get(i), null, entryArray.get(i).offset);

            if (res.size != 0) {
                entryArray.get(i).totalLen = res.size;
            }
            else {
                entryArray.get(i).totalLen = MAX_LENGTH; // TODO_ALA:
            }
        }

        verifyUndefinedTypes     (entryArray);
        verifyStructsStringValues( entryArray);
        verifyFigurativesValues  (entryArray);

        //

        for (int i = 0; i < autom.size(); i++) {

          //logger.debug("[" + filename + "] " + autom.get(i).name);

            entryArray.add(autom.get(i));
        }

        //

        return null;
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> <WORKING_STORAGE>
     * f1 -> <SECTION>
     * f2 -> <DOT>
     * f3 -> ( DataDescriptionEntry() )*
     *
     * @param n TODO_javadoc.
     *
     */
    public TypedCode visit(WorkingStorageSection n, HashMap<String, Object> argu) {

        for (int i = 0; i < n.f3.size(); i++) {
            dataDescriptionEntryArray.add((DataDescriptionEntry) n.f3.elementAt(i));
        }

        return null;
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( DataDescriptionEntry() )*
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(LinkageSectionEntry n, HashMap<String, Object> argu) {

        for (int i = 0; i < n.f0.size(); i++) {
            dataDescriptionEntryArray.add((DataDescriptionEntry) n.f0.elementAt(i));
        }

        return null;
    }

    //
    //
    //

    /******************************************************************************
     * setArrayOffsets
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param entry TODO_javadoc.
     * @param siblings TODO_javadoc.
     * @param offset TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private Result setArrayOffsets(DataEntryDesc entry, ArrayList<DataEntryDesc> siblings, int offset) {

      //logger.debug("[" + filename + "] >>>> entrando a 'setArrayOffsets(" + entry.name + ", offset: " + offset + ")' ...");

        int size = 0;

        if (entry.mode == DataEntryDesc.CONDITION) {
            return new Result(offset, size);
        }

        int entry_totalLen = entry.totalLen;

      //logger.debug("[" + filename + "] " + entry.level + "-" + entry.name + (entry.redefining != null ? " (" + entry.redefining + ")": "") + ", offset " + offset + ", totalLen " + entry_totalLen + ", occurs " + entry.occurs + (entry.value != null ? " (" + entry.value + ")" : ""));

        DataEntryDesc redefined = null;

        if (entry.childs != null) {

          //logger.debug("[" + filename + "] inicio hijos de " + entry.name + " ...");
          //logger.debug("[" + filename + "] ============================================================");

            DataEntryDesc hijo          = null;
            int           hijo_totalLen = 0;

            for (int i = 0; i < entry.childs.size(); i++) {

                hijo          = entry.childs.get(i);
                hijo_totalLen = hijo.totalLen;

              //logger.debug("[" + filename + "] hijo: " + hijo.level + "-" + hijo.name);

                if (hijo.mode == DataEntryDesc.CONDITION) {
                    continue;
                }

                if (hijo.redefining != null) {

                    ////////////////////////////////////////////////////////////
                    // REDEFINE
                    ////////////////////////////////////////////////////////////

                    redefined = findEntry(entry.childs, hijo.redefining);

                    if (redefined == null) {
                        logger.error("[" + filename + "] no se encontro definicion de '" + hijo.redefining + "'.");
                    }
                    else {

                        if (hijo.totalLen != redefined.totalLen && hijo.totalLen != 0) {

                            if (params.path("alert_diff_length_redefined").asBoolean(true)) {

                                logger.warn("[" + filename + "] largo de '" + redefined.name + "' (" + redefined.totalLen + ") redefinido por '" + hijo.name + "' (" + hijo.totalLen + ") son distintos.");
                            }

                            hijo_totalLen = redefined.totalLen;
                        }

                      //logger.debug("[" + filename + "] " + hijo.name + " es redefinicion de " + redefined.name + ", offset queda en " + redefined.offset);

                        offset = redefined.offset;
                    }
                }

              //logger.debug("[" + filename + "] asignado offset " + offset + " a " + hijo.name);

                hijo.offset = offset;

                if (hijo.childs != null) {

                    Result res = setArrayOffsets(hijo, entry.childs, offset);

                  //logger.debug("[" + filename + "] hijos de " + hijo.name + " --> res.offset: " + res.offset + ", res.size: " + res.size);

                    if (res.offset == offset && res.size == 0) {

                        ////////////////////////////////////////////////////////////
                        // struct solo con <LEVEL_88>
                        ////////////////////////////////////////////////////////////

                      //logger.debug("[" + filename + "] " + hijo.name + " son solo <LEVEL_88>, se le suma a offset y size " + hijo_totalLen);

                        if (hijo_totalLen == 0) {
                            logger.warn("[" + filename + "] " + hijo.name + " no tiene largo definido y sus childs son solo <LEVEL_88>.");
                        }

                        offset += hijo_totalLen;
                        size   += hijo_totalLen;

                      //logger.debug("[" + filename + "] sumando a size: " + hijo_totalLen + " (" + hijo.name + ")");
                    }
                    else {

                        ////////////////////////////////////////////////////////////
                        // struct normal
                        ////////////////////////////////////////////////////////////

                      //logger.debug("[" + filename + "] " + hijo.name + " struct normal, se suma al offset " + (res.size * hijo.occurs));

                        offset += res.size * hijo.occurs;

                        if (hijo.redefining == null) {

                          //logger.debug("[" + filename + "] " + hijo.name + " struct normal (no redefine), se suma al size " + (res.size * hijo.occurs));
                        
                        	//OGB-ini
                        	//size += res.size * hijo.occurs; 
                            hijo.totalLen = res.size * hijo.occurs;
                            
                            size += res.size * hijo.occurs; 
                        	//OGB-fin
                        }
                    }

                    ////////////////////////////////////////////////////////////
                    // struct sin definicion de largo.
                    ////////////////////////////////////////////////////////////

                    if (hijo_totalLen == 0) {

                      //logger.debug("[" + filename + "] " + hijo.name + " sin definicion de largo, se asigna " + (res.size * hijo.occurs));

                        hijo.totalLen = res.size * hijo.occurs;
                        hijo_totalLen = hijo.totalLen;
                    }
                    
                }
                else {

                    offset += hijo_totalLen;

                    if (hijo.redefining == null) {
                        size += hijo_totalLen;
                    }

                  //logger.debug("[" + filename + "] sumando a size " + hijo_totalLen + " (" + hijo.name + ")");
                }
            }

          //logger.debug("[" + filename + "] ============================================================");
          //logger.debug("[" + filename + "] fin hijos de " + entry.name + ", offset: " + offset + "...");
        }
        else {

            if (entry.redefining != null) {

                ////////////////////////////////////////////////////////////
                // REDEFINE
                ////////////////////////////////////////////////////////////

                redefined = findEntry(siblings, entry.redefining);

                if (redefined == null) {
                    logger.error("[" + filename + "] no se encontro definicion de '" + entry.redefining + "'.");
                }
                else {

                  //logger.debug("[" + filename + "] " + entry.name + " es redefinicion de " + redefined.name);

                    if (entry.totalLen != redefined.totalLen && entry.totalLen != 0) {

                        if (params.path("alert_diff_length_redefined").asBoolean(true)) {

                            logger.warn("[" + filename + "] largo de '" + redefined.name + "' (" + redefined.totalLen + ") redefinido por '" + entry.name + "' (" + entry_totalLen + ") son distintos.");
                        }

                        entry_totalLen = redefined.totalLen;
                    }

                  //logger.debug("[" + filename + "] " + entry.name + " es redefinicion de " + redefined.name + ", offset queda en " + redefined.offset);

                    offset = redefined.offset;
                }
            }

            entry.offset = offset;

            offset += entry_totalLen;

            if (entry.redefining == null) {

                size += entry_totalLen;

              //logger.debug("[" + filename + "] sumando a size: " + entry_totalLen + " (" + entry.name + ")");
            }
        }

      //logger.debug("[" + filename + "] <<<< saliendo 'setArrayOffsets(" + entry.name + ", offset: " + offset + ", size: " + size + ")' ...");

        return new Result(offset, size);
    }

    /******************************************************************************
     * verifyStructsStringValues
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param entryArray TODO_javadoc.
     *
     */
    private void verifyStructsStringValues(ArrayList<DataEntryDesc> entryArray) {

      //logger.debug("[" + filename + "] entrando a 'verifyStructsStringValues()' ...");

        DataEntryDesc entry = null;

        for (int i = 0; i < entryArray.size(); i++) {

            entry = entryArray.get(i);

            if (entry.mode == DataEntryDesc.CONDITION) {
                continue;
            }

            if (entry.value != null && entry.value instanceof String) {

              //logger.debug("[" + filename + "] " + entry.name + ", totalLen: " + entry.totalLen + (entry.value != null ? ", value: " + entry.value + " (" + entry.value.getClass().getSimpleName() + ")" : ""));

                String str = (String) entry.value;

                if (entry.totalLen > str.length() - 2) {
                    entry.value = "\"" + str.substring(1, str.length() - 1) + genSpaces(entry.totalLen - str.length() + 2) + "\"";
                }
                //OGB-ini
                else if (entry.totalLen < str.length() - 2) {
                	
                	entry.value = "\"" + str.substring(1, entry.totalLen + 1) + "\"";
                	
                }
                //OGB-fin
                  
                
            }

            if (entry.childs != null) {
                verifyStructsStringValues(entry.childs);
            }
        }

      //logger.debug("[" + filename + "] saliendo 'verifyStructsStringValues()' ...");
    }

    /******************************************************************************
     * verifyFigurativesValues
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param entryArray TODO_javadoc.
     *
     */
    private void verifyFigurativesValues(ArrayList<DataEntryDesc> entryArray) {

      //logger.debug("[" + filename + "] entrando a 'verifyFigurativesValues()' ...");

        DataEntryDesc entry = null;

        for (int i = 0; i < entryArray.size(); i++) {

            entry = entryArray.get(i);

            if (entry.mode == DataEntryDesc.CONDITION) {
                continue;
            }

            if (entry.get(FIGURATIVE_VALUE) != null) {

                String value = (String) entry.get(FIGURATIVE_VALUE);

                /******************************************************************************
                 *
                 ******************************************************************************/

                if      (value.equals("LOW_VALUE")) {

                    switch (entry.type) {

                    case DataEntryDesc.INTEGER :

                        entry.value = new Integer(Integer.MIN_VALUE);

                        break;

                    case DataEntryDesc.LONG :

                        entry.value = new Long(Long.MIN_VALUE);

                        break;

                    case DataEntryDesc.DOUBLE :

                        entry.value = new Double(Double.MIN_VALUE);

                        break;

                    case DataEntryDesc.STRING :

                        entry.value = "\"" + repeatChar((char) 0x01, entry.totalLen) + "\""; ///////////////////////////////// revisar entry.totalLen ///////////////////////////////// 0x01

                        break;

                    case DataEntryDesc.UNDEF :

                        if (params.path("alert_low_high_value_undefined_type").asBoolean(true)) {
                            logger.warn("[" + filename + "] FigurativeConstant LOW_VALUE para tipo UNDEF.");
                        }

                        entry.value = "\"" + repeatChar((char) 0x00, entry.totalLen) + "\""; ///////////////////////////////// revisar entry.totalLen

                        break;
                    }
                }

                /******************************************************************************
                 *
                 ******************************************************************************/

                else if (value.equals("HIGH_VALUE")) {

                    switch (entry.type) {

                    case DataEntryDesc.INTEGER :

                        entry.value = new Integer(Integer.MAX_VALUE);

                        break;

                    case DataEntryDesc.LONG :

                        entry.value = new Long(Long.MAX_VALUE);

                        break;

                    case DataEntryDesc.DOUBLE :

                        entry.value = new Double(Double.MAX_VALUE);

                        break;

                    case DataEntryDesc.STRING :

                        entry.value = "\"" + repeatChar((char) 0xFF, entry.totalLen) + "\""; ///////////////////////////////// revisar entry.totalLen

                        break;

                    case DataEntryDesc.UNDEF :

                        if (params.path("alert_low_high_value_undefined_type").asBoolean(true)) {
                            logger.warn("[" + filename + "] FigurativeConstant HIGH_VALUE para tipo UNDEF.");
                        }

                        entry.value = "\"" + repeatChar((char) 0xFF, entry.totalLen) + "\""; ///////////////////////////////// revisar entry.totalLen

                        break;
                    }
                }

                /******************************************************************************
                 *
                 ******************************************************************************/

                else if (value.equals("NULL")) {

                    switch (entry.type) {
                    case DataEntryDesc.INTEGER :
                    case DataEntryDesc.LONG :
                    case DataEntryDesc.DOUBLE :

                        throw new RuntimeException("[" + filename + "] FigurativeConstant NULL para tipo " + DataEntryDesc.typesNames[entry.type] + ".");

                    case DataEntryDesc.STRING :

                        entry.value = "null";

                        break;

                    case DataEntryDesc.UNDEF :

                        if (params.path("alert_low_high_value_undefined_type").asBoolean(true)) {
                            logger.warn("[" + filename + "] FigurativeConstant NULL para tipo UNDEF.");
                        }

                        entry.value = "null";

                        break;
                    }
                }
            }

            if (entry.childs != null) {
                verifyFigurativesValues(entry.childs);
            }
        }

      //logger.debug("[" + filename + "] saliendo 'verifyFigurativesValues()' ...");
    }

    /******************************************************************************
     * verifyUndefinedTypes
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param entryArray TODO_javadoc.
     *
     */
    private void verifyUndefinedTypes(ArrayList<DataEntryDesc> entryArray) {

      //logger.debug("[" + filename + "] entrando a 'verifyUndefinedTypes()' ...");

        if (entryArray == null) {
            return;
        }

        DataEntryDesc entry = null;

      //logger.debug("[" + filename + "] =========================================================");

        for (int i = 0; i < entryArray.size(); i++) {

            entry = entryArray.get(i);

          //logger.debug("[" + filename + "] entry: " + entry.name + " (" + (entry.type != DataEntryDesc.UNDEF ? DataEntryDesc.typesNames[entry.type] : "UNDEF") + ")");

            if (entry.name.equals(FILLER)) {
                continue;
            }

            if (entry.type == DataEntryDesc.UNDEF) {

                int type = DataEntryDesc.STRING; /* TODO_ALA: getTypeFromChilds(entry);*/
                int len  = getLengthFromChilds(entry.childs);

              //logger.debug("[" + filename + "] " + entry.name + " nuevo tipo:" + (type == DataEntryDesc.UNDEF ? "UNDEF" : DataEntryDesc.javaNames[type]));
              //logger.debug("[" + filename + "] " + entry.name + " largo     :" + len);

                /* TODO_ALA:
                if (type == DataEntryDesc.INTEGER && len >= 10) {
                    type = DataEntryDesc.LONG;
                }

                if (type == DataEntryDesc.LONG && len > 19) {

                    if (params.path("alert_type_change").asBoolean(true)) {

                        logger.warn("[" + filename + "] " + entry.name + ":: cambio de tipo LONG a STRING por largo total hijos validos {" + len + "}");
                    }

                    type = DataEntryDesc.STRING;
                }

                //

                switch (type) {
                    case DataEntryDesc.INTEGER:
                    case DataEntryDesc.LONG:
                        entry.ints = len;
                }

                if (params.path("alert_type_change").asBoolean(true)) {

                    logger.warn("[" + filename + "] " + entry.name + "{" + entry.totalLen + "} tiene type indefinido, segun hijos (si los tiene) sera " + DataEntryDesc.typesNames[type]);
                }
                */
                entry.type = type;
            }

          //logger.debug("[" + filename + "] =========================================================");

            if (entry.childs != null) {
                verifyUndefinedTypes(entry.childs);
            }
        }

      //logger.debug("[" + filename + "] saliendo 'verifyUndefinedTypes()' ...");
    }

    /******************************************************************************
     * getTypeFromChilds
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param entry TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    /* TODO_ALA:
    private int getTypeFromChilds(DataEntryDesc entry) {

      //logger.debug("[" + filename + "] entrando a 'getTypeFromChilds(" + entry.name + ", " + (entry.type != DataEntryDesc.UNDEF ? DataEntryDesc.typesNames[entry.type] : "UNDEF") + ")' ...");

        DataEntryDesc hijo   = null;
        int           result = DataEntryDesc.UNDEF;
        int           type;

        if (entry.childs == null) {
            return result;
        }

        for (int i = 0; i < entry.childs.size(); i++) {

            hijo = entry.childs.get(i);
            type = hijo.type;

          //logger.debug("[" + filename + "] hijo: " + hijo.name + ", (result: " + (result != DataEntryDesc.UNDEF ? DataEntryDesc.typesNames[result] : "UNDEF") + ", type: " + (type != DataEntryDesc.UNDEF ? DataEntryDesc.typesNames[type] : "UNDEF") + ")");

            if (type == DataEntryDesc.UNDEF && hijo.childs != null) {
                type = getTypeFromChilds(hijo);
            }

            switch (result) {

                case DataEntryDesc.UNDEF :

                    result = type;

                    break;

                case DataEntryDesc.INTEGER :

                    switch (type) {

                    case DataEntryDesc.INTEGER :
                    case DataEntryDesc.LONG :

                        result = type;

                        break;

                    case DataEntryDesc.DOUBLE :
                    case DataEntryDesc.STRING :

                      //logger.debug("[" + filename + "] saliendo 'getTypeFromChilds(" + DataEntryDesc.typesNames[DataEntryDesc.STRING] + ")' ...");

                        return DataEntryDesc.STRING; ////////////////
                    }

                    break;

                case DataEntryDesc.LONG :

                    switch (type) {

                    case DataEntryDesc.INTEGER :
                    case DataEntryDesc.LONG :

                        result = DataEntryDesc.LONG;

                        break;

                    case DataEntryDesc.DOUBLE :
                    case DataEntryDesc.STRING :

                      //logger.debug("[" + filename + "] saliendo 'getTypeFromChilds(" + DataEntryDesc.typesNames[DataEntryDesc.STRING] + ")' ...");

                        return DataEntryDesc.STRING; ////////////////
                    }

                    break;

                case DataEntryDesc.DOUBLE :
                case DataEntryDesc.STRING :

                  //logger.debug("[" + filename + "] saliendo 'getTypeFromChilds(" + DataEntryDesc.typesNames[DataEntryDesc.STRING] + ")' ...");

                    return DataEntryDesc.STRING; ////////////////
            }
        }

      //logger.debug("[" + filename + "] saliendo 'getTypeFromChilds(" + (result != DataEntryDesc.UNDEF ? DataEntryDesc.typesNames[result] : "UNDEF") + ")' ...");

        return result;
    }
    */

    /******************************************************************************
     * getLengthFromChilds
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param childs TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private int getLengthFromChilds(ArrayList<DataEntryDesc> childs) {

        DataEntryDesc hijo   = null;
        int           result = 0;
        int           len;

        if (childs == null) {
            return result;
        }

        for (int i = 0; i < childs.size(); i++) {

            hijo = childs.get(i);

            if (/*hijo.name.equals(FILLER) || */hijo.redefining != null) {
                continue;
            }

            len = hijo.totalLen;

            if (hijo.type == DataEntryDesc.UNDEF && hijo.childs != null) {
                len = getLengthFromChilds(hijo.childs);
            }

            result += len;
        }

        return result;
    }

    /******************************************************************************
     * findEntry
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param array TODO_javadoc.
     * @param name TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private DataEntryDesc findEntry(ArrayList<DataEntryDesc> array, String name) {

        if (array == null || name == null) {
            return null;
        }

        for (int i = 0; i < array.size(); i++) {

            if (array.get(i).name.equals(name)) {
                return array.get(i);
            }
        }

        return null;
    }

    /******************************************************************************
     * makeEntryTree
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param autom TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private DataEntryDesc makeEntryTree(ArrayList<DataEntryDesc> autom) {

        if (idx >= dataDescriptionEntryArray.size()) {
            return null;
        }

        DataDescriptionEntry dataDescriptionEntry = dataDescriptionEntryArray.get(idx);
        NodeSequence         ns         = null;
        NodeListOptional     nlo        = null;
        String               name       = null;
        int                  level      = 0;
        int                  occurs     = 1;
        PicDesc              picDesc    = null;
        Object               obj        = null;
        String               redefining = null;
        String               indexer    = null;
        int                  childLevel = DataEntryDesc.UNDEF;
        DataEntryDesc        entry      = null;

        switch (dataDescriptionEntry.f0.which) {

        ///////////////////////////////////////////////////////////////////////////////////////////
        //
        ///////////////////////////////////////////////////////////////////////////////////////////

        case 3 : // LevelNumber() LevelName()   ( DataDescriptionEntryClause() )* <DOT>

            ns         = (NodeSequence) dataDescriptionEntry.f0.choice;
            level      = Integer.parseInt(((LevelNumber) ns.elementAt(0)).f0.tokenImage);
            name       = getLevelName((LevelName)        ns.elementAt(1));

            nlo        = (NodeListOptional) ns.elementAt(2); // ( DataDescriptionEntryClause() )*
            occurs     =   getOccursFromDataDescriptionEntryClauseList(nlo, autom);
            redefining = getRedefineFromDataDescriptionEntryClauseList(nlo);
            indexer    =  getIndexerFromDataDescriptionEntryClauseList(nlo);
            picDesc    =     getTypeFromDataDescriptionEntryClauseList(nlo);
            obj        =    getValueFromDataDescriptionEntryClauseList(nlo, picDesc);

          //logger.debug("[" + filename + "] name: " + name + ", pic.length; " + picDesc.length + (obj != null ? ", obj: '" + obj + "'" : ""));

            if (obj != null && obj instanceof DataEntryDesc && ((DataEntryDesc) obj).type == DataEntryDesc.STRING) {

                picDesc.type = PicDesc.STRING;

                String str = (String) ((DataEntryDesc) obj).value;

                if (picDesc.length == 0) {
                    picDesc.length = str.length() - 2;
                }

                if (picDesc.length > (str.length() - 2)) {
                    ((DataEntryDesc) obj).value = "\"" + str.substring(1, str.length() - 1) + genSpaces(picDesc.length - str.length() + 2) + "\"";
                }
                else if (picDesc.length < (str.length() - 2)) {
                    logger.warn("[" + filename + "] VALUE {" + str + "} de '" + name + "' es mayor al largo en PICTURE (" + picDesc.length + ").");
                }
            }

            entry = new DataEntryDesc(level, name, occurs, obj instanceof DataEntryDesc ? ((DataEntryDesc) obj).value : obj, redefining, indexer, picDesc.type, picDesc.ints, picDesc.decs, occurs * picDesc.length, picDesc.sign, DataEntryDesc.VARIABLE, DataEntryDesc.UNDEF);

            if (obj instanceof DataEntryDesc && ((DataEntryDesc) obj).mode == DataEntryDesc.SPECIAL) {
                entry.set(FIGURATIVE_VALUE, (String) ((DataEntryDesc) obj).value);
            }

          //logger.debug("[" + filename + "] {" + idx + "} entry: " + entry.name);

            childLevel = getChildLevel(idx, level, dataDescriptionEntryArray.size());

            if (childLevel != DataEntryDesc.UNDEF) {

              //logger.debug("[" + filename + "] v " + childLevel + " vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");

                ArrayList<DataEntryDesc> childs     = new ArrayList<DataEntryDesc>();
                int                      filler_num = 0;

                idx++;

                do {

                    if (idx >= dataDescriptionEntryArray.size()) {
                        break;
                    }

                    int nivel = getLevelFromDataDescriptionEntry(idx, dataDescriptionEntryArray.size());

                  //logger.debug("[" + filename + "] nivel: " + nivel + ", childLevel: " + childLevel);

                    if (nivel == DataEntryDesc.UNDEF || (nivel != childLevel && nivel != LEVEL_88)) {
                        break;
                    }

                    DataEntryDesc hijo = makeEntryTree(autom);

                  //logger.debug("[" + filename + "] hijo: " + hijo.name + " (" + hijo.type + ")");

                    if (hijo != null) {

                        if (hijo.name.equals(FILLER)) {

                            if (filler_num > 0) {
                                hijo.name += "-" + Integer.toString(filler_num);
                            }

                            filler_num++;
                        }

                        childs.add(hijo);
                    }

                } while (true);

                entry.childs = childs;

              //logger.debug("[" + filename + "] ^ " + childLevel + " ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            }
            else {
                idx++;
            }

            break;

        ///////////////////////////////////////////////////////////////////////////////////////////
        //
        ///////////////////////////////////////////////////////////////////////////////////////////

        case 1 : // <LEVEL_77>    LevelName77() ( DataDescriptionEntryClause() )* <DOT>

            ns         = (NodeSequence) dataDescriptionEntry.f0.choice;
            level      = Integer.parseInt(((NodeToken) ns.elementAt(0)).tokenImage);
            name       = ((LevelName77)                ns.elementAt(1)).f0.f0.f0.tokenImage;
            nlo        = (NodeListOptional) ns.elementAt(2); // ( DataDescriptionEntryClause() )*
            occurs     =   getOccursFromDataDescriptionEntryClauseList(nlo, autom);
            redefining = getRedefineFromDataDescriptionEntryClauseList(nlo);
            indexer    =  getIndexerFromDataDescriptionEntryClauseList(nlo);
            picDesc    =     getTypeFromDataDescriptionEntryClauseList(nlo);
            obj        =    getValueFromDataDescriptionEntryClauseList(nlo, picDesc);

          //logger.debug("[" + filename + "] name: " + name + ", pic.length; " + picDesc.length + (obj != null ? ", obj: '" + obj + "'" : ""));

            if (obj != null && obj instanceof DataEntryDesc && ((DataEntryDesc) obj).type == DataEntryDesc.STRING) {

                picDesc.type = PicDesc.STRING;

                String str = (String) ((DataEntryDesc) obj).value;

                if (picDesc.length == 0) {
                    picDesc.length = str.length() - 2;
                }

                if (picDesc.length > (str.length() - 2)) {
                    ((DataEntryDesc) obj).value = "\"" + str.substring(1, str.length() - 1) + genSpaces(picDesc.length - str.length() + 2) + "\"";
                }
                else if (picDesc.length < (str.length() - 2)) {
                    logger.warn("[" + filename + "] VALUE {" + str + "} de '" + name + "' es mayor al largo en PICTURE (" + picDesc.length + ").");
                }
            }

            entry = new DataEntryDesc(level, name, occurs, obj instanceof DataEntryDesc ? ((DataEntryDesc) obj).value : obj, redefining, indexer, picDesc.type, picDesc.ints, picDesc.decs, occurs * picDesc.length, picDesc.sign, DataEntryDesc.VARIABLE, DataEntryDesc.UNDEF);

            if (obj instanceof DataEntryDesc && ((DataEntryDesc) obj).mode == DataEntryDesc.SPECIAL) {
                entry.set(FIGURATIVE_VALUE, (String) ((DataEntryDesc) obj).value);
            }

          //logger.debug("[" + filename + "] {" + idx + "} entry: " + entry.name);

            childLevel = getChildLevel(idx, level, dataDescriptionEntryArray.size());

            if (childLevel != DataEntryDesc.UNDEF) {

              //logger.debug("[" + filename + "] v " + childLevel + " vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");

                ArrayList<DataEntryDesc> childs     = new ArrayList<DataEntryDesc>();
                int                      filler_num = 0;

                idx++;

                do {

                    if (idx >= dataDescriptionEntryArray.size()) {
                        break;
                    }

                    int nivel = getLevelFromDataDescriptionEntry(idx, dataDescriptionEntryArray.size());

                    if (nivel == DataEntryDesc.UNDEF || (nivel != childLevel && nivel != LEVEL_88)) {
                        break;
                    }

                    DataEntryDesc hijo = makeEntryTree(autom);

                    if (hijo != null) {

                        if (hijo.name.equals(FILLER)) {

                            if (filler_num > 0) {
                                hijo.name += "-" + Integer.toString(filler_num);
                            }

                            filler_num++;
                        }

                        childs.add(hijo);
                    }

                } while (true);

                entry.childs = childs;

              //logger.debug("[" + filename + "] ^ " + childLevel + " ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            }
            else {
                idx++;
            }

            break;

        ///////////////////////////////////////////////////////////////////////////////////////////
        //
        ///////////////////////////////////////////////////////////////////////////////////////////

        case 2 : // <LEVEL_88> LevelName88() ConditionValueClause() <DOT>

            ns         = (NodeSequence) dataDescriptionEntry.f0.choice;
            level      = Integer.parseInt(((NodeToken) ns.elementAt(0)).tokenImage);
            name       = ((LevelName88)                ns.elementAt(1)).f0.f0.f0.tokenImage;
            occurs     = 1;
            redefining = null;
            indexer    = null;                                                                              //type                  ints  decs  length      sign
            obj        = getValueFromDataValueClause(((ConditionValueClause) ns.elementAt(2)).f0, new PicDesc(DataEntryDesc.STRING, 0,    0,    MAX_LENGTH, false));

            if (obj != null && obj instanceof DataEntryDesc && ((DataEntryDesc) obj).type == DataEntryDesc.STRING) {

                String str = (String) ((DataEntryDesc) obj).value;

                                        //level, name, occurs, value, redefining, indexer  type,                 ints, decs, length,                                 sign,  mode,                    offset
                entry = new DataEntryDesc(level, name, occurs, str,   redefining, indexer, DataEntryDesc.STRING, 0,    0,    occurs * (str.length() - 2), false, DataEntryDesc.CONDITION, DataEntryDesc.UNDEF);
            }
            else {
                                        //level, name, occurs, value,                                                            redefining, indexer  type,                ints, decs, length,          sign,  mode,                    offset
                entry = new DataEntryDesc(level, name, occurs, obj instanceof DataEntryDesc ? ((DataEntryDesc) obj).value : obj, redefining, indexer, DataEntryDesc.UNDEF, 0,    0,    0,               false, DataEntryDesc.CONDITION, DataEntryDesc.UNDEF);
            }

          //logger.debug("[" + filename + "] {" + idx + "} entry: " + entry.name + " (" + level + ")");

            idx++;

            break;

        ///////////////////////////////////////////////////////////////////////////////////////////
        //
        ///////////////////////////////////////////////////////////////////////////////////////////

        case 0 : // <LEVEL_66> LevelName66() RenamesClause() <DOT>

            logger.warn("[" + filename + "] DataDescriptionEntry() tiene '<LEVEL_66> LevelName66() RenamesClause() <DOT>'");

            idx++;

            break;

        ///////////////////////////////////////////////////////////////////////////////////////////
        //
        ///////////////////////////////////////////////////////////////////////////////////////////

        case 4 : // ExecStatement() <DOT>

          //logger.warn("[" + filename + "] DataDescriptionEntry() tiene 'ExecStatement() <DOT> {" + dataDescriptionEntry.f0.choice.accept(tokenVisitor).toString().trim() + "}'");

            idx++;

            break;
        }

        //

        return entry;
    }

    /******************************************************************************
     * getOccursFromDataDescriptionEntryClauseList
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param nlo TODO_javadoc.
     * @param autom TODO_javadoc.
     *
     */
    private int getOccursFromDataDescriptionEntryClauseList(NodeListOptional nlo, ArrayList<DataEntryDesc> autom) {

        for (int i = 0; i < nlo.size(); i++) {

            DataDescriptionEntryClause dataDescriptionEntryClause = (DataDescriptionEntryClause) nlo.elementAt(i);

            if (dataDescriptionEntryClause.f0.which == 8) { // DataOccursClause

                DataOccursClause dataOccursClause = (DataOccursClause) dataDescriptionEntryClause.f0.choice;

                /* DataOccursClause::
                 *
                 * f0 -> <OCCURS>
                 * f1 -> IntegerConstant()
                 * f2 -> [ <TO> IntegerConstant() ]
                 * f3 -> [ <TIMES> ]
                 * f4 -> [ <DEPENDING> [ <ON> ] Identifier() ]
                 * f5 -> ( ( <ASCENDING> | <DESCENDING> ) [ <KEY> ] [ <IS> ] ( Identifier() )+ )*
                 * f6 -> [ <INDEXED> [ <BY> ] IndexName() ( [ <COMMACHAR> ] IndexName() )* ]
                */

                if (dataOccursClause.f2.present()) {
                    logger.warn("[" + filename + "] DataOccursClause:: OCCURS tiene <TO> IntegerConstant() no implementada aun {" + dataOccursClause.accept(tokenVisitor).toString().trim() + "}");
                }

                if (dataOccursClause.f4.present()) {
                    logger.warn("[" + filename + "] DataOccursClause:: OCCURS tiene <DEPENDING> [ <ON> ] Identifier() no implementada aun {" + dataOccursClause.accept(tokenVisitor).toString().trim() + "}");
                }

                /*
                if (dataOccursClause.f5.size() > 0) {
                    logger.warn("[" + filename + "] DataOccursClause:: OCCURS tiene ( <ASCENDING> | <DESCENDING> ) [ <KEY> ] [ <IS> ] ( Identifier() )+ no implementada aun {" + dataOccursClause.accept(tokenVisitor).toString().trim() + "}");
                }
                */

                if (dataOccursClause.f6.present()) {

                    NodeSequence ns = (NodeSequence) dataOccursClause.f6.node; // [ <INDEXED> [ <BY> ] IndexName() ( [ <COMMACHAR> ] IndexName() )* ]
                    IndexName    in = (IndexName) ns.elementAt(2);

                                //DataEntryDesc(level, name,                occurs, value, redefining, indexer, type,                    ints, decs, length, sign,  mode,                  offset
                    autom.add(new DataEntryDesc(1,     in.f0.f0.tokenImage, 1,      null,  null,       null,    DataEntryDesc.INTEGER,   6,    0,    6,      false, DataEntryDesc.INDEXER, DataEntryDesc.UNDEF));

                    NodeListOptional nlo1 = (NodeListOptional) ns.elementAt(3);

                    for (int j = 0; j < nlo1.size(); j++) { // ( [ <COMMACHAR> ] IndexName() )*

                        NodeSequence ns1 = (NodeSequence) nlo1.elementAt(j);

                        in = (IndexName) ns1.elementAt(1);

                                    //DataEntryDesc(level, name,            occurs, value, redefining, indexer, type,                    ints, decs, length, sign,  mode,                  offset
                        autom.add(new DataEntryDesc(1, in.f0.f0.tokenImage, 1,      null,  null,       null, DataEntryDesc.INTEGER,   6,    0,    6,      false, DataEntryDesc.INDEXER, DataEntryDesc.UNDEF));
                    }
                }

                int num = Integer.parseInt(((NodeToken) dataOccursClause.f1.f0.choice).tokenImage);

                return num;
            }
        }

        return 1;
    }

    /******************************************************************************
     * getIndexerFromDataDescriptionEntryClauseList
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param nlo TODO_javadoc.
     * @param autom TODO_javadoc.
     *
     */
    private String getIndexerFromDataDescriptionEntryClauseList(NodeListOptional nlo) {

        for (int i = 0; i < nlo.size(); i++) {

            DataDescriptionEntryClause dataDescriptionEntryClause = (DataDescriptionEntryClause) nlo.elementAt(i);

            if (dataDescriptionEntryClause.f0.which == 8) { // DataOccursClause

                DataOccursClause dataOccursClause = (DataOccursClause) dataDescriptionEntryClause.f0.choice;

                if (dataOccursClause.f6.present()) {

                    NodeSequence ns = (NodeSequence) dataOccursClause.f6.node; // [ <INDEXED> [ <BY> ] IndexName() ( [ <COMMACHAR> ] IndexName() )* ]
                    IndexName    in = (IndexName) ns.elementAt(2);

                    NodeListOptional nlo1 = (NodeListOptional) ns.elementAt(3);

                    if (nlo1.size() > 0) {
                        new RuntimeException("DataOccursClause:: ( [ <COMMACHAR> ] IndexName() )* aun no implementado {" + nlo1.accept(tokenVisitor).toString().trim() + "}.");
                    }

                    return in.f0.f0.tokenImage;
                }
            }
        }

        return null;
    }

    /******************************************************************************
     * getValueFromDataDescriptionEntryClauseList
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param nlo TODO_javadoc.
     * @param picDesc TODO_javadoc.
     *
     * @return DataEntryDesc TreeSet.
     *
     */
    private Object getValueFromDataDescriptionEntryClauseList(NodeListOptional nlo, PicDesc picDesc) {

        for (int i = 0; i < nlo.size(); i++) {

            DataDescriptionEntryClause dataDescriptionEntryClause = (DataDescriptionEntryClause) nlo.elementAt(i);

            if (dataDescriptionEntryClause.f0.which == 1) { // DataValueClause
                return getValueFromDataValueClause((DataValueClause) dataDescriptionEntryClause.f0.choice, picDesc);
            }
        }

        return null;
    }

    /******************************************************************************
     * getValueFromDataValueClause
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param dataValueClause TODO_javadoc.
     * @param picDesc TODO_javadoc.
     *
     * @return DataEntryDesc TreeSet.
     *
     */
    private Object getValueFromDataValueClause(DataValueClause dataValueClause, PicDesc picDesc) {

        // DataValueClause::
        //
        // f0 -> ( <VALUE> [ <IS> ] | <VALUES> [ <ARE> ] )
        // f1 -> Through()
        // f2 -> ( [ <COMMACHAR> ] Through() )*

        // Through::
        //
        // f0 -> IterableLiteral()
        // f1 -> [ ( <THROUGH> | <THRU> ) IterableLiteral() ]
        //

        // IterableLiteral::
        //
        // f0 -> [ <ALL> ]
        // f1 -> ( IterableNonNumericConstant() | NumericConstant() | FigurativeConstant() )
        //

        Through       thru = dataValueClause.f1;
        DataEntryDesc obj  = getIterableLiteral(thru.f0, picDesc);

        TreeSet seq  = null;

        if (thru.f1.present()) {

            NodeSequence  ns   = (NodeSequence) thru.f1.node;
            DataEntryDesc obj2 = getIterableLiteral((IterableLiteral) ns.elementAt(1), picDesc);

            if ((obj. type == DataEntryDesc.INTEGER || obj. type == DataEntryDesc.LONG) &&
                (obj2.type == DataEntryDesc.INTEGER || obj2.type == DataEntryDesc.LONG)) {

                seq = new TreeSet();

                for (long i = ((Number) obj.value).longValue(); i <= ((Number) obj2.value).longValue(); i++) {
                    seq.add(new Long(i));
                }

                obj.value = seq;
            }
            else {
                throw new RuntimeException("getValueFromDataValueClause:: IterableLiteral() [ ( <THROUGH> | <THRU> ) IterableLiteral() ] no implementado aun para tipo " + obj.getClass().getSimpleName() + " {" + dataValueClause.accept(tokenVisitor)+ "}");
            }
        }

        //

        if (dataValueClause.f2.present()) {

            TreeSet tree = new TreeSet();

            if (obj.value instanceof TreeSet) {
                tree.addAll(seq);
            }
            else if (obj.type == DataEntryDesc.INTEGER || obj.type == DataEntryDesc.LONG) { // INTEGER LONG
                tree.add(new Long(((Number) obj.value).longValue()));
            }
            else if (obj.type == DataEntryDesc.DOUBLE) { // DOUBLE
                tree.add(((Double) obj.value).doubleValue());
            }
            else if (obj.type == DataEntryDesc.DOUBLE) { // STRING
                tree.add((String) obj.value);
            }

            for (int j = 0; j < dataValueClause.f2.size(); j++) { // [ <COMMACHAR> ] Through()

                thru = (Through) ((NodeSequence) dataValueClause.f2.elementAt(j)).elementAt(1);

                //

                obj = getIterableLiteral(thru.f0, picDesc);

                if (thru.f1.present()) {

                    NodeSequence  ns   = (NodeSequence) thru.f1.node;
                    DataEntryDesc obj2 = getIterableLiteral((IterableLiteral) ns.elementAt(1), picDesc);

                    if ((obj. type == DataEntryDesc.INTEGER || obj. type == DataEntryDesc.LONG) &&
                        (obj2.type == DataEntryDesc.INTEGER || obj2.type == DataEntryDesc.LONG)) {

                        seq = new TreeSet();

                        for (long i = ((Number) obj.value).longValue(); i <= ((Number) obj2.value).longValue(); i++) {
                            seq.add(new Long(i));
                        }

                        obj.value = seq;
                    }
                    else {
                        throw new RuntimeException("getValueFromDataValueClause:: IterableLiteral() [ ( <THROUGH> | <THRU> ) IterableLiteral() ] no implementado aun para tipo " + obj.getClass().getSimpleName() + " {" + dataValueClause.accept(tokenVisitor)+ "}");
                    }
                }

                if (obj.value instanceof TreeSet) {
                    tree.addAll(seq);
                }
                else if (obj.type == DataEntryDesc.INTEGER || obj.type == DataEntryDesc.LONG) { // INTEGER LONG
                    tree.add(new Long(((Number) obj.value).longValue()));
                }
                else if (obj.type == DataEntryDesc.DOUBLE) { // DOUBLE
                    tree.add(((Double) obj.value).doubleValue());
                }
                else if (obj.type == DataEntryDesc.DOUBLE) { // STRING
                    tree.add((String) obj.value);
                }
            }

            return tree;
        }
        else {

          //logger.debug("[" + filename + "] retornando [" + obj + "]");

            return obj;
        }
    }

    /******************************************************************************
     * getIterableLiteral
     ******************************************************************************/
    /**
     *
     * f0 -> [ <ALL> ]
     * f1 -> ( IterableNonNumericConstant()
     *       | NumericConstant()
     *       | FigurativeConstant()
     *       )
     *
     * @param n TODO_javadoc.
     * @param picDesc TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private DataEntryDesc getIterableLiteral(IterableLiteral n, PicDesc picDesc) {

      //logger.debug("[" + filename + "] entrando a 'getIterableLiteral(" +  n.accept(tokenVisitor).toString().trim() + "," + picDesc + ")' ...");

        boolean all_flag = n.f0.present();
        String  s        = null;

        switch (n.f1.which) {

        ///////////////////////////////////////////////////////////////////////////////////////////
        //
        ///////////////////////////////////////////////////////////////////////////////////////////

        case 0 : // IterableNonNumericConstant()

            // IterableNonNumericConstant::
            //
            // f0 -> ( IterableQuotedText() | <HEXNUMBER> )
            //

            IterableNonNumericConstant innc = (IterableNonNumericConstant) n.f1.choice;

            switch (innc.f0.which) {

            case 0 : // IterableQuotedText()

                // IterableQuotedText::
                //
                // f0 -> <QUOTEDSTRING> | <DOUBLEDQUOTECHAR> | <DOUBLEDAPOSTROPHE>
                //

                IterableQuotedText iqt = (IterableQuotedText) innc.f0.choice;

                switch (iqt.f0.which) {

                case 0 : // <QUOTEDSTRING>

                    // ( <QUOTECHAR>  (~["\""] | <DOUBLEDQUOTECHAR>  )* <QUOTECHAR>
                    // | <APOSTROPHE> (~["'"]  | <DOUBLEDAPOSTROPHE> )* <APOSTROPHE>
                    // ) >

                    s = ((NodeToken) iqt.f0.choice).tokenImage;
                    s = s.substring(1, s.length() - 1);

                    if        (s.equals("''")) {
                        return new DataEntryDesc("\"'\"",                                                           DataEntryDesc.STRING, DataEntryDesc.VARIABLE);
                    } else if (s.equals("\"\"")) {
                        return new DataEntryDesc("\"\\\"\"",                                                        DataEntryDesc.STRING, DataEntryDesc.VARIABLE);
                    }
                    else {
                        return new DataEntryDesc("\"" + scape(all_flag ? repeatChar(s, picDesc.length) : s) + "\"", DataEntryDesc.STRING, DataEntryDesc.VARIABLE);
                    }

                case 1 : // <DOUBLEDQUOTECHAR>
                      return new DataEntryDesc("'",                                                                 DataEntryDesc.STRING, DataEntryDesc.VARIABLE);
                case 2 : // <DOUBLEDAPOSTROPHE>
                    return new DataEntryDesc("\"\"",                                                                DataEntryDesc.STRING, DataEntryDesc.VARIABLE);
                }

                break;

            case 1 : // <HEXNUMBER>

                // ["h","x"] ( ( <QUOTECHAR>  ( ["0"-"9","a"-"f"] )+ <QUOTECHAR> )
                //           | ( <APOSTROPHE> ( ["0"-"9","a"-"f"] )+ <APOSTROPHE> )
                //           ) >

                s = ((NodeToken) innc.f0.choice).tokenImage;

                if (all_flag) {
                    throw new RuntimeException("getIterableLiteral:: <ALL> no implementada aun para <HEXNUMBER> {" + n.accept(tokenVisitor).toString().trim() + "}");
                }

                return new DataEntryDesc(new Long(Long.parseLong(s.substring(2, s.length() - 1), 16)), DataEntryDesc.LONG, DataEntryDesc.VARIABLE);
            }

            break;

        ///////////////////////////////////////////////////////////////////////////////////////////
        //
        ///////////////////////////////////////////////////////////////////////////////////////////

        case 1 : // NumericConstant()

            // NumericConstant::
            //
            // f0 -> [ <PLUSCHAR> | <MINUSCHAR> ]
            // f1 -> ( IntegerConstant() | <REAL> )
            //

            // IntegerConstant::
            //
            // f0 -> <LEVEL_66> | <LEVEL_77> | <LEVEL_88> | <LEVEL_NUMBER> | <INTEGER>
            //

            NumericConstant nc   = (NumericConstant) n.f1.choice;
            String          sign = nc.f0.present() ? ((NodeToken) ((NodeChoice) nc.f0.node).choice).tokenImage : "";

            switch (nc.f1.which) {

            case 0 : // IntegerConstant()

                IntegerConstant ic = (IntegerConstant) nc.f1.choice;

                switch (ic.f0.which) {

                case 0 : // <LEVEL_66>
                case 1 : // <LEVEL_77>
                case 2 : // <LEVEL_88>

                    s = ((NodeToken) ic.f0.choice).tokenImage;

                    return new DataEntryDesc(new Integer(sign + s),              DataEntryDesc.INTEGER, DataEntryDesc.VARIABLE);

                case 3 : // <LEVEL_NUMBER>
                case 4 : // <INTEGER>

                    s = ((NodeToken) ic.f0.choice).tokenImage;

                    return new DataEntryDesc(new Long(sign + s),                 DataEntryDesc.LONG,    DataEntryDesc.VARIABLE);
                }

                break;

            case 1 : // <REAL>

                s = ((NodeToken) nc.f1.choice).tokenImage;

                return new DataEntryDesc(new Double(sign + s.replace(',', '.')), DataEntryDesc.DOUBLE,  DataEntryDesc.VARIABLE);
            }

            break;

        ///////////////////////////////////////////////////////////////////////////////////////////
        //
        ///////////////////////////////////////////////////////////////////////////////////////////

        case 2 : // FigurativeConstant()

            // FigurativeConstant::
            //
            // f0 -> <ZERO> | <ZEROS> | <ZEROES> | <SPACE> | <SPACES> | <HIGH_VALUE> | <HIGH_VALUES> | <LOW_VALUE> | <LOW_VALUES> | <QUOTE> | <QUOTES> | <NULL> | <NULLS>
            //

            FigurativeConstant fc = (FigurativeConstant) n.f1.choice;

            switch (fc.f0.which) {
            case  0 : // <ZERO>
            case  1 : // <ZEROS>
            case  2 : // <ZEROES>

                return new DataEntryDesc(new Long(0L),                                                         DataEntryDesc.LONG,    DataEntryDesc.VARIABLE);

            case  3 : // <SPACE>
            case  4 : // <SPACES>

                return new DataEntryDesc("\"" + (picDesc.length == 0 ? "" : genSpaces(picDesc.length)) + "\"", DataEntryDesc.STRING,  DataEntryDesc.VARIABLE);

            case  5 : // <HIGH_VALUE>
            case  6 : // <HIGH_VALUES>

                return new DataEntryDesc("HIGH_VALUE",                                                         DataEntryDesc.UNDEF,   DataEntryDesc.SPECIAL);

            case  7 : // <LOW_VALUE>
            case  8 : // <LOW_VALUES>

                return new DataEntryDesc("LOW_VALUE",                                                          DataEntryDesc.UNDEF,   DataEntryDesc.SPECIAL);

            case  9 : // <QUOTE>
            case 10 : // <QUOTES>

                return new DataEntryDesc("\"\\\"\"",                                                           DataEntryDesc.STRING,  DataEntryDesc.VARIABLE);

            case 11 : // <NULL>
            case 12 : // <NULLS>

                return new DataEntryDesc("NULL",                                                               DataEntryDesc.UNDEF,   DataEntryDesc.SPECIAL);
            }
        }

        return null;
    }

    /******************************************************************************
     * getRedefineFromDataDescriptionEntryClauseList
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param nlo TODO_javadoc.
     *
     */
    private String getRedefineFromDataDescriptionEntryClauseList(NodeListOptional nlo) {

        for (int i = 0; i < nlo.size(); i++) {

            DataDescriptionEntryClause dataDescriptionEntryClause = (DataDescriptionEntryClause) nlo.elementAt(i);

            if (dataDescriptionEntryClause.f0.which == 3) { // DataRedefinesClause

                DataRedefinesClause drc = (DataRedefinesClause) dataDescriptionEntryClause.f0.choice;

                return drc.f1.f0.f0.tokenImage;
            }
        }

        return null;
    }

    /******************************************************************************
     * getTypeFromDataDescriptionEntryClauseList
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param nlo ( DataDescriptionEntryClause() )*.
     *
     * @return TODO_javadoc.
     *
     */
    private PicDesc getTypeFromDataDescriptionEntryClauseList(NodeListOptional nlo) {

      //logger.debug("[" + filename + "] entrando a 'getTypeFromDataDescriptionEntryClauseList(" + nlo.accept(tokenVisitor).toString().trim() + ")' ...");

        DataPictureClause dataPictureClause = null;

        PicDesc pd = null;

        for (Enumeration e = nlo.elements(); e.hasMoreElements(); ) {

            DataDescriptionEntryClause dataDescriptionEntryClause = (DataDescriptionEntryClause) e.nextElement();

            String extended = null;

            switch (dataDescriptionEntryClause.f0.which) {

            case 0 : // DataPictureClause()

                dataPictureClause = (DataPictureClause) dataDescriptionEntryClause.f0.choice;
                extended          = PicDesc.extendPicture(dataPictureClause.f2.tokenImage.toUpperCase());

                for (int i = 0; i < PicDesc.patterns.length; i++) {

                    if (PicDesc.patterns[i].matcher(extended).find()) {

                        pd = PicDesc.getInfoFromPattern(extended, i);

                      //logger.debug("[" + filename + "] " + dataPictureClause.f2.tokenImage + " --> " + pd);

                        return pd;
                    }
                }

                throw new RuntimeException("no se encontro picture para " + dataPictureClause.f2.tokenImage);

            case 3 : // DataRedefinesClause

                DataRedefinesClause dataRedefinesClause = (DataRedefinesClause) dataDescriptionEntryClause.f0.choice;

                if (dataRedefinesClause.f2.present()) {

                    dataPictureClause = (DataPictureClause) dataRedefinesClause.f2.node;
                    extended          = PicDesc.extendPicture(dataPictureClause.f2.tokenImage.toUpperCase());

                    for (int i = 0; i < PicDesc.patterns.length; i++) {

                        if (PicDesc.patterns[i].matcher(extended).find()) {

                            pd = PicDesc.getInfoFromPattern(extended, i);

                          //logger.debug("[" + filename + "] " + dataPictureClause.f2.tokenImage + " --> " + pd);

                            return pd;
                        }
                    }

                    throw new RuntimeException("no se encontro picture para " + dataPictureClause.f2.tokenImage);
                }

                break;
            }
        }
                         //type                  ints  decs  length      sign
        return new PicDesc(DataEntryDesc.STRING, 0,    0,    MAX_LENGTH, false);
    }

    /******************************************************************************
     * getChildLevel
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param idx TODO_javadoc.
     * @param level TODO_javadoc.
     * @param size TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private int getChildLevel(int idx, int level, int size) {

      //logger.debug("[" + filename + "] entrando en 'getChildLevel(idx:" + idx + ", level:" + level + ")' ...");

        int     num      = DataEntryDesc.UNDEF;
        boolean exist_88 = false;

        ciclo :

        for (int i = idx + 1; i < size; i++) {

            DataDescriptionEntry dataDescriptionEntry = dataDescriptionEntryArray.get(i);

            NodeSequence ns  = (NodeSequence) dataDescriptionEntry.f0.choice;

            switch (dataDescriptionEntry.f0.which) {

            case 3 : // LevelNumber() LevelName()   ( DataDescriptionEntryClause() )* <DOT>

                num = Integer.parseInt(((LevelNumber) ns.elementAt(0)).f0.tokenImage);

                break;

            case 1 : // <LEVEL_77>    LevelName77() ( DataDescriptionEntryClause() )* <DOT>

                break ciclo;

            case 0 : // <LEVEL_66>    LevelName66()   RenamesClause()                 <DOT>

                num = Integer.parseInt(((NodeToken)   ns.elementAt(0)).tokenImage);

                break;

            case 2 : // <LEVEL_88>    LevelName88()   ConditionValueClause()          <DOT>

                exist_88 = true;

                break;

            case 4 : //                               ExecStatement()                 <DOT>
                break;
            }

            //

            if (num != DataEntryDesc.UNDEF) {
                break;
            }
        }

        int result;

        if      (num == DataEntryDesc.UNDEF) {
            result = exist_88 ? LEVEL_88 : DataEntryDesc.UNDEF;
        }
        else if (num == LEVEL_77) {
            result = DataEntryDesc.UNDEF;
        }
        else if (num > level) {
            result = num;
        }
        else {
            result = exist_88 ? LEVEL_88 : DataEntryDesc.UNDEF;
        }

      //logger.debug("[" + filename + "] childLevel: " + result + " (num: " + num + ")");

        return result;
    }

    /******************************************************************************
     * getLevelFromDataDescriptionEntry
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param idx TODO_javadoc.
     * @param size TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    private int getLevelFromDataDescriptionEntry(int idx, int size) {

        if (idx >= size) {
            return DataEntryDesc.UNDEF;
        }

        DataDescriptionEntry dataDescriptionEntry = dataDescriptionEntryArray.get(idx);

        NodeSequence ns = (NodeSequence) dataDescriptionEntry.f0.choice;

        switch (dataDescriptionEntry.f0.which) {

        case 3 : // LevelNumber() LevelName()   ( DataDescriptionEntryClause() )* <DOT>

            return Integer.parseInt(((LevelNumber) ns.elementAt(0)).f0.tokenImage);

        case 1 : // <LEVEL_77>    LevelName77() ( DataDescriptionEntryClause() )* <DOT>
        case 0 : // <LEVEL_66>    LevelName66()   RenamesClause()                 <DOT>
        case 2 : // <LEVEL_88>    LevelName88()   ConditionValueClause()          <DOT>

            return Integer.parseInt(((NodeToken)   ns.elementAt(0)).tokenImage);

        case 4 : //                               ExecStatement()                 <DOT>
            break;
        }

        return DataEntryDesc.UNDEF;
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    private class Result {

        /** TODO_javadoc. */
        public int offset;

        /** TODO_javadoc. */
        public int size;

        /*******************************************************************************************************
         * Result
         *******************************************************************************************************/
        /**
         *
         * @param offset TODO_javadoc.
         * @param size TODO_javadoc.
         *
         */
        public Result(int offset, int size) {
            this.offset = offset;
            this.size   = size;
        }
    }

}
