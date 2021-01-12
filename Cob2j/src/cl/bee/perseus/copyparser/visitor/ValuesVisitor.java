
package cl.bee.perseus.copyparser.visitor;


import java.util.ArrayList;
import java.util.Enumeration;
import java.util.regex.Pattern;

import cl.bee.perseus.cobolparser.util.ReplaceDesc;
import cl.bee.perseus.copyparser.syntaxtree.CopyOperand;
import cl.bee.perseus.copyparser.syntaxtree.CopyStatement;
import cl.bee.perseus.copyparser.syntaxtree.FigurativeConstant;
import cl.bee.perseus.copyparser.syntaxtree.IntegerConstant;
import cl.bee.perseus.copyparser.syntaxtree.Literal;
import cl.bee.perseus.copyparser.syntaxtree.Node;
import cl.bee.perseus.copyparser.syntaxtree.NodeChoice;
import cl.bee.perseus.copyparser.syntaxtree.NodeList;
import cl.bee.perseus.copyparser.syntaxtree.NodeListOptional;
import cl.bee.perseus.copyparser.syntaxtree.NodeOptional;
import cl.bee.perseus.copyparser.syntaxtree.NodeSequence;
import cl.bee.perseus.copyparser.syntaxtree.NodeToken;
import cl.bee.perseus.copyparser.syntaxtree.NonNumericConstant;
import cl.bee.perseus.copyparser.syntaxtree.NumericConstant;


/**
 *
 * Visitor que recorre una instrucción COPY para identificar el nombre del archivo llamado.
 *
 * Registro de versiones:<ul>
 *
 * <li>1.0 (01/01/2016, Agustin Larrea A. (BEE S.A.)): versión inicial.
 * </ul>
 *
 * <b>Todos los derechos reservados por Banco de Crédito e Inversiones.</b>
 *
 */
public class ValuesVisitor implements Visitor {

    /** Constante 2. */
    private static final int CTE2 = 2;

    /** Variable que mantiene el archivo identificado. */
    private String filename = null;

    /** Arreglo que tiene las tuplas remplazables en la instrucción COPY. */
    private ArrayList replaceArray = new ArrayList();

    /******************************************************************************
     * getFilename
     ******************************************************************************/

    public String getFilename() {
        return filename;
    }

    /******************************************************************************
     * getReplaceArray
     ******************************************************************************/

    public ArrayList getReplaceArray() {
        return replaceArray;
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * Metodo visitador para el nodo especifico.
     *
     * @param n <code>Node</code> que se debe visitar.
     *
     * @since 1.0
     *
     */
    public void visit(NodeList n) {

        for (Enumeration e = n.elements(); e.hasMoreElements(); ) {
            ((Node) e.nextElement()).accept(this);
        }
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * Metodo visitador para el nodo especifico.
     *
     * @param n <code>Node</code> que se debe visitar.
     *
     * @since 1.0
     *
     */
    public void visit(NodeListOptional n) {

        if (n.present()) {

            for (Enumeration e = n.elements(); e.hasMoreElements(); ) {
                ((Node) e.nextElement()).accept(this);
            }
        }
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * Metodo visitador para el nodo especifico.
     *
     * @param n <code>Node</code> que se debe visitar.
     *
     * @since 1.0
     *
     */
    public void visit(NodeOptional n) {

        if (n.present()) {
            n.node.accept(this);
        }
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * Metodo visitador para el nodo especifico.
     *
     * @param n <code>Node</code> que se debe visitar.
     *
     * @since 1.0
     *
     */
    public void visit(NodeSequence n) {

        for (Enumeration e = n.elements(); e.hasMoreElements(); ) {
            ((Node) e.nextElement()).accept(this);
        }
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * Metodo visitador para el nodo especifico.
     *
     * @param n <code>Node</code> que se debe visitar.
     *
     * @since 1.0
     *
     */
    public void visit(NodeToken n) {}

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * Metodo visitador para el nodo especifico.
     *
     * @param n <code>Node</code> que se debe visitar.
     *
     * @since 1.0
     *
     */
    public void visit(CopyStatement n) {

        switch (n.f1.which) {

        case 0 :            // <IDENTIFIER>
            filename = ((NodeToken) (n.f1.choice)).tokenImage;

            break;

        case 1 :            // Literal()
            NodeChoice   nch = (NodeChoice) n.f1.choice;
            StringBuffer sb  = null;

            switch (nch.which) {

            case 0 :        // NonNumericConstant()
                NonNumericConstant nnc = (NonNumericConstant) nch.choice;

                switch (nnc.f0.which) {

                case 0 :    // ( <QUOTEDSTRING> )+
                    NodeList nl = (NodeList) nnc.f0.choice;

                    sb = new StringBuffer();

                    for (int i = 0; i < nl.size(); i++) {
                        sb.append(((NodeToken) nl.elementAt(i)).tokenImage);
                    }

                    filename = sb.toString();

                    break;

                case 1 :    // <HEXNUMBER>
                    filename = ((NodeToken) nnc.f0.choice).tokenImage;

                    break;
                }

                break;

            case 1 :        // NumericConstant()
                NumericConstant nc = (NumericConstant) nch.choice;

                sb = new StringBuffer();

                if (nc.f0.present()) {
                    sb.append(((NodeToken) nc.f0.node).tokenImage);
                }

                switch (nc.f1.which) {

                case 0 :    // IntegerConstant()
                    sb.append(((IntegerConstant) nc.f1.choice).f0.tokenImage);

                    break;

                case 1 :    // <REAL>
                    sb.append(((NodeToken) nc.f1.choice).tokenImage);

                    break;
                }

                filename = sb.toString();

                break;

            case CTE2 :        // FigurativeConstant()
                FigurativeConstant fc = (FigurativeConstant) nch.choice;

                filename = ((NodeToken) fc.f0.choice).tokenImage;

                break;
            }
        }

        //

        if (n.f4.present()) {

            NodeSequence ns = (NodeSequence) n.f4.node;
            NodeList     nl = (NodeList) ns.elementAt(1);    // ( CopyOperand() <BY> CopyOperand() )+

            for (int i = 0; i < nl.size(); i++) {

                NodeSequence ns1     = (NodeSequence) nl.elementAt(i);
                String       find    = ((NodeToken) ((CopyOperand) ns1.elementAt(0)).f0.choice).tokenImage;
                String       replace = ((NodeToken) ((CopyOperand) ns1.elementAt(CTE2)).f0.choice).tokenImage;

                if (find.startsWith("==")) {
                    find = find.substring(CTE2, find.length() - CTE2);
                }

                if (replace.startsWith("==")) {
                    replace = replace.substring(CTE2, replace.length() - CTE2);
                }

                find = patternScape(find);

                replaceArray.add(new ReplaceDesc(find, replace,
                                                 Pattern.compile( /* "\\b" + */find /* + "\\b" */,
                                                     Pattern.CASE_INSENSITIVE)));
            }
        }
    }

    /******************************************************************************
     * patternScape
     ******************************************************************************/
    /**
     *
     * Método que permite escapar los puntos en un patrón.
     *
     * @param s Patrón a procesar.
     *
     * @return Patrón escapado.
     *
     * @since 1.0
     *
     */
    public String patternScape(String s) {

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < s.length(); i++) {

            switch (s.charAt(i)) {

            case '.' :
                sb.append("\\.");

                break;

            default :
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * Metodo visitador para el nodo especifico.
     *
     * @param n <code>Node</code> que se debe visitar.
     *
     * @since 1.0
     *
     */
    public void visit(Literal n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * Metodo visitador para el nodo especifico.
     *
     * @param n <code>Node</code> que se debe visitar.
     *
     * @since 1.0
     *
     */
    public void visit(NonNumericConstant n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * Metodo visitador para el nodo especifico.
     *
     * @param n <code>Node</code> que se debe visitar.
     *
     * @since 1.0
     *
     */
    public void visit(NumericConstant n) {

        n.f0.accept(this);
        n.f1.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * Metodo visitador para el nodo especifico.
     *
     * @param n <code>Node</code> que se debe visitar.
     *
     * @since 1.0
     *
     */
    public void visit(FigurativeConstant n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * Metodo visitador para el nodo especifico.
     *
     * @param n <code>Node</code> que se debe visitar.
     *
     * @since 1.0
     *
     */
    public void visit(IntegerConstant n) {
        n.f0.accept(this);
    }

    /******************************************************************************
     * visit
     ******************************************************************************/
    /**
     *
     * Metodo visitador para el nodo especifico.
     *
     * @param n <code>Node</code> que se debe visitar.
     *
     * @since 1.0
     *
     */
    public void visit(CopyOperand n) {
        n.f0.accept(this);
    }
}
