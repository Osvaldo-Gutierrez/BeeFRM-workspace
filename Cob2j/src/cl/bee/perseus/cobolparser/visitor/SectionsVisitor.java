/*
 *   Copyright (c) 2020 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.perseus.cobolparser.visitor;


import java.util.*;

import cl.bee.perseus.cobolparser.syntaxtree.*;

import cl.bee.perseus.util.*;

import org.apache.log4j.*;


/**
 *
 * TODO_javadoc.
 *
 * @version 1.0 (01/01/2020).
 *
 */
public class SectionsVisitor extends BaseVisitor implements GJVisitor<TypedCode, HashMap<String, Object>> {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(SectionsVisitor.class);

    //

    /** TODO_javadoc. */
    private ArrayList<String> sections = null;

    /** TODO_javadoc. */
    private ArrayList<String> paragraphs = null;

    /** TODO_javadoc. */
    private HashMap<String, String> nextParagraph = null;

    //

    /** TODO_javadoc. */
    private String sectionName = null;

    /******************************************************************************
     *
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param filename TODO_javadoc.
     * @param sections TODO_javadoc.
     * @param paragraphs TODO_javadoc.
     * @param nextParagraph TODO_javadoc.
     *
     */
    public SectionsVisitor(String filename, ArrayList<String> sections, ArrayList<String> paragraphs, HashMap<String, String> nextParagraph) {

        this.filename      = filename;
        this.sections      = sections;
        this.paragraphs    = paragraphs;
        this.nextParagraph = nextParagraph;
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ProgramUnit()
     * f1 -> ( NestedProgramUnit() EndProgramStatement() )*
     * f2 -> [ EndProgramStatement() ( CompilationUnit() )* ]
     * f3 -> <EOF>
     *
     * @param n TODO_javadoc.
     * @param argu TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(CompilationUnit n, HashMap<String, Object> argu) {

        sectionName = "INITIAL";

        n.f0.accept(this, argu);
        n.f1.accept(this, argu);
        n.f2.accept(this, argu);
        n.f3.accept(this, argu);

        return null;
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> SectionHeader()
     * f1 -> <DOT>
     * f2 -> Paragraphs()
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(ProcedureSection n, HashMap<String, Object> argu) {

        sectionName = getName(((SectionName) n.f0.f0).f0);

        if (sectionName.equalsIgnoreCase("MAIN")) {
            sectionName = "PRINCIPAL";
        }

        if (!sections.contains(sectionName)) {

          //logger.debug("[" + filename + "] agregando section '" + sectionName + "' ...");

            sections.add(sectionName);
        }
        else {
            logger.warn("[" + filename + "] section '" + sectionName + "' ya existe.");
        }

        n.f0.accept(this, argu);
        n.f1.accept(this, argu);
        n.f2.accept(this, argu);

        return null;
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ( Sentence() )*
     * f1 -> ( Paragraph() )*
     *
     * @param n TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public TypedCode visit(Paragraphs n, HashMap<String, Object> argu) {

        if (sectionName != null && n.f1.size() > 0) {

            for (int i = 0; i < n.f1.size() - 1; i++) {
                nextParagraph.put(getName(((Paragraph) n.f1.elementAt(i)).f0.f0) + "/" + sectionName, getName(((Paragraph) n.f1.elementAt(i + 1)).f0.f0));
            }
        }

        n.f0.accept(this, argu);
        n.f1.accept(this, argu);

        return null;
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * f0 -> ParagraphName()
     * f1 -> <DOT>
     * f2 -> ( ExitStatement() | AlteredGoto() | Sentence() )*
     *
     * @param n TODO_javadoc.
     *
     */
    public TypedCode visit(Paragraph n, HashMap<String, Object> argu) {

        String paragraphName = getName(n.f0.f0);

        if (!paragraphs.contains(paragraphName + "/" + sectionName)) {
            paragraphs.add(paragraphName + "/" + sectionName);
        }
        else {
            logger.warn("[" + filename + "] paragraph '" + paragraphName + "' ya existe en la seccion '" + sectionName + "'.");
        }

        n.f0.accept(this, argu);
        n.f1.accept(this, argu);
        n.f2.accept(this, argu);

        return null;
    }
}
