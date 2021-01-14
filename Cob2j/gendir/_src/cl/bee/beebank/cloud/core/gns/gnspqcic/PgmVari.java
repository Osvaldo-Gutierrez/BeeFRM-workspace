/*
 *   Copyright (c) 2021 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */

package cl.bee.beebank.cloud.core.gns.gnspqcic;


import java.text.DecimalFormat;

import java.util.Arrays;

import cl.bee.beebank.cloud.core.gns.Root;

//import org.apache.log4j.Logger;

/**
 *
 * TODO_javadoc.
 *
 * @author  BEE S.A.
 * @version 1.0
 *
 */
public class PgmVari extends Root {

    /** TODO_javadoc. */
    //private static Logger logger = Logger.getLogger(PgmVari.class);

    /** TODO_javadoc. */
    private PgmStat pgmStat = new PgmStat();

    /*******************************************************************************************************
     *
     *******************************************************************************************************/
    /**
     *
     */
    public PgmVari() {

        initBuffer(40);

        replaceValue(0, 40, "                                        "); // PGM-VARI
        replaceValue(0, 1, " "); // PGM-ICLR
        replaceValue(1, 2, " "); // PGM-LIMPIAR-TODO
        replaceValue(2, 3, "K"); // PGM-LIMPIAR-LLAVES
        replaceValue(3, 4, "F"); // PGM-LIMPIAR-CAMPOS
        replaceValue(4, 5, "N"); // PGM-NO-LIMPIAR-NADA
        replaceValue(17, 18, "2"); // PGM-STT1-CIC
        replaceValue(18, 19, "3"); // PGM-STT2-CIC
        replaceValue(19, 21, "23"); // PGM-SRNF
        replaceValue(21, 23, "00"); // PGM-SOKS
        replaceValue(23, 25, "  "); // PGM-SNUL
        replaceValue(25, 40, "               "); // PGM-SUAR
    }

    //
    //
    //

    /*******************************************************************************************************
     * setValue
     *******************************************************************************************************/
    /**
     *
     * @param value TODO_javadoc.
     *
     */
    public void setValue(String value) {
        replaceValue(0, 40, value);
    }

    /*******************************************************************************************************
     * getValue
     *******************************************************************************************************/
    /**
     *
     * @return value TODO_javadoc.
     *
     */
    public String getValue() {
        return subValue(0, 40);
    }

    //
    //
    //

    /*******************************************************************************************************
     * setPgmIclr
     *******************************************************************************************************/
    /**
     *
     * @param pgmIclr TODO_javadoc.
     *
     */
    public void setPgmIclr(String pgmIclr) {
        replaceValue(0, 1, pgmIclr);
    }

    /*******************************************************************************************************
     * setPgmLimpiarTodo
     *******************************************************************************************************/
    /**
     *
     * @param pgmLimpiarTodo TODO_javadoc.
     *
     */
    public void setPgmLimpiarTodo(String pgmLimpiarTodo) {
        replaceValue(1, 2, pgmLimpiarTodo);
    }

    /*******************************************************************************************************
     * setPgmLimpiarLlaves
     *******************************************************************************************************/
    /**
     *
     * @param pgmLimpiarLlaves TODO_javadoc.
     *
     */
    public void setPgmLimpiarLlaves(String pgmLimpiarLlaves) {
        replaceValue(2, 3, pgmLimpiarLlaves);
    }

    /*******************************************************************************************************
     * setPgmLimpiarCampos
     *******************************************************************************************************/
    /**
     *
     * @param pgmLimpiarCampos TODO_javadoc.
     *
     */
    public void setPgmLimpiarCampos(String pgmLimpiarCampos) {
        replaceValue(3, 4, pgmLimpiarCampos);
    }

    /*******************************************************************************************************
     * setPgmNoLimpiarNada
     *******************************************************************************************************/
    /**
     *
     * @param pgmNoLimpiarNada TODO_javadoc.
     *
     */
    public void setPgmNoLimpiarNada(String pgmNoLimpiarNada) {
        replaceValue(4, 5, pgmNoLimpiarNada);
    }

    /*******************************************************************************************************
     * setPgmProg
     *******************************************************************************************************/
    /**
     *
     * @param pgmProg TODO_javadoc.
     *
     */
    public void setPgmProg(String pgmProg) {
        replaceValue(5, 13, pgmProg);
    }

    /*******************************************************************************************************
     * setPgmNtrn
     *******************************************************************************************************/
    /**
     *
     * @param pgmNtrn TODO_javadoc.
     *
     */
    public void setPgmNtrn(String pgmNtrn) {
        replaceValue(13, 17, pgmNtrn);
    }

    /*******************************************************************************************************
     * setPgmSrnf
     *******************************************************************************************************/
    /**
     *
     * @param pgmSrnf TODO_javadoc.
     *
     */
    public void setPgmSrnf(String pgmSrnf) {
        replaceValue(19, 21, pgmSrnf);
    }

    /*******************************************************************************************************
     * setPgmSoks
     *******************************************************************************************************/
    /**
     *
     * @param pgmSoks TODO_javadoc.
     *
     */
    public void setPgmSoks(String pgmSoks) {
        replaceValue(21, 23, pgmSoks);
    }

    /*******************************************************************************************************
     * setPgmSnul
     *******************************************************************************************************/
    /**
     *
     * @param pgmSnul TODO_javadoc.
     *
     */
    public void setPgmSnul(String pgmSnul) {
        replaceValue(23, 25, pgmSnul);
    }

    /*******************************************************************************************************
     * setPgmSuar
     *******************************************************************************************************/
    /**
     *
     * @param pgmSuar TODO_javadoc.
     *
     */
    public void setPgmSuar(String pgmSuar) {
        replaceValue(25, 40, pgmSuar);
    }

    /*******************************************************************************************************
     * getPgmIclr
     *******************************************************************************************************/
    /**
     *
     * @return pgmIclr TODO_javadoc.
     *
     */
    public String getPgmIclr() {
        return subValue(0, 1);
    }

    /*******************************************************************************************************
     * getPgmLimpiarTodo
     *******************************************************************************************************/
    /**
     *
     * @return pgmLimpiarTodo TODO_javadoc.
     *
     */
    public String getPgmLimpiarTodo() {
        return subValue(1, 2);
    }

    /*******************************************************************************************************
     * getPgmLimpiarLlaves
     *******************************************************************************************************/
    /**
     *
     * @return pgmLimpiarLlaves TODO_javadoc.
     *
     */
    public String getPgmLimpiarLlaves() {
        return subValue(2, 3);
    }

    /*******************************************************************************************************
     * getPgmLimpiarCampos
     *******************************************************************************************************/
    /**
     *
     * @return pgmLimpiarCampos TODO_javadoc.
     *
     */
    public String getPgmLimpiarCampos() {
        return subValue(3, 4);
    }

    /*******************************************************************************************************
     * getPgmNoLimpiarNada
     *******************************************************************************************************/
    /**
     *
     * @return pgmNoLimpiarNada TODO_javadoc.
     *
     */
    public String getPgmNoLimpiarNada() {
        return subValue(4, 5);
    }

    /*******************************************************************************************************
     * getPgmProg
     *******************************************************************************************************/
    /**
     *
     * @return pgmProg TODO_javadoc.
     *
     */
    public String getPgmProg() {
        return subValue(5, 13);
    }

    /*******************************************************************************************************
     * getPgmNtrn
     *******************************************************************************************************/
    /**
     *
     * @return pgmNtrn TODO_javadoc.
     *
     */
    public String getPgmNtrn() {
        return subValue(13, 17);
    }

    /*******************************************************************************************************
     * getPgmStat
     *******************************************************************************************************/
    /**
     *
     * @return pgmStat TODO_javadoc.
     *
     */
    public PgmStat getPgmStat() {
        return pgmStat;
    }

    /*******************************************************************************************************
     * getPgmSrnf
     *******************************************************************************************************/
    /**
     *
     * @return pgmSrnf TODO_javadoc.
     *
     */
    public String getPgmSrnf() {
        return subValue(19, 21);
    }

    /*******************************************************************************************************
     * getPgmSoks
     *******************************************************************************************************/
    /**
     *
     * @return pgmSoks TODO_javadoc.
     *
     */
    public String getPgmSoks() {
        return subValue(21, 23);
    }

    /*******************************************************************************************************
     * getPgmSnul
     *******************************************************************************************************/
    /**
     *
     * @return pgmSnul TODO_javadoc.
     *
     */
    public String getPgmSnul() {
        return subValue(23, 25);
    }

    /*******************************************************************************************************
     * getPgmSuar
     *******************************************************************************************************/
    /**
     *
     * @return pgmSuar TODO_javadoc.
     *
     */
    public String getPgmSuar() {
        return subValue(25, 40);
    }

    /**
     *
     * TODO_javadoc.
     *
     * @author  BEE S.A.
     * @version 1.0
     *
     */
    public class PgmStat {

        /** TODO_javadoc. */
        private PgmStatCic pgmStatCic = new PgmStatCic();

        /*******************************************************************************************************
         *
         *******************************************************************************************************/
        /**
         *
         */
        public PgmStat() {
        }

        //
        //
        //

        /*******************************************************************************************************
         * setValue
         *******************************************************************************************************/
        /**
         *
         * @param value TODO_javadoc.
         *
         */
        public void setValue(String value) {
            replaceValue(17, 19, value);
        }

        /*******************************************************************************************************
         * getValue
         *******************************************************************************************************/
        /**
         *
         * @return value TODO_javadoc.
         *
         */
        public String getValue() {
            return subValue(17, 17 + 2);
        }

        //
        //
        //

        /*******************************************************************************************************
         * getPgmStatCic
         *******************************************************************************************************/
        /**
         *
         * @return pgmStatCic TODO_javadoc.
         *
         */
        public PgmStatCic getPgmStatCic() {
            return pgmStatCic;
        }

        /**
         *
         * TODO_javadoc.
         *
         * @author  BEE S.A.
         * @version 1.0
         *
         */
        public class PgmStatCic {

            /*******************************************************************************************************
             *
             *******************************************************************************************************/
            /**
             *
             */
            public PgmStatCic() {
            }

            //
            //
            //

            /*******************************************************************************************************
             * setValue
             *******************************************************************************************************/
            /**
             *
             * @param value TODO_javadoc.
             *
             */
            public void setValue(String value) {
                replaceValue(17, 19, value);
            }

            /*******************************************************************************************************
             * getValue
             *******************************************************************************************************/
            /**
             *
             * @return value TODO_javadoc.
             *
             */
            public String getValue() {
                return subValue(17, 17 + 2);
            }

            //
            //
            //

            /*******************************************************************************************************
             * setPgmStt1Cic
             *******************************************************************************************************/
            /**
             *
             * @param pgmStt1Cic TODO_javadoc.
             *
             */
            public void setPgmStt1Cic(String pgmStt1Cic) {
                replaceValue(17, 18, pgmStt1Cic);
            }

            /*******************************************************************************************************
             * setPgmStt2Cic
             *******************************************************************************************************/
            /**
             *
             * @param pgmStt2Cic TODO_javadoc.
             *
             */
            public void setPgmStt2Cic(String pgmStt2Cic) {
                replaceValue(18, 19, pgmStt2Cic);
            }

            /*******************************************************************************************************
             * getPgmStt1Cic
             *******************************************************************************************************/
            /**
             *
             * @return pgmStt1Cic TODO_javadoc.
             *
             */
            public String getPgmStt1Cic() {
                return subValue(17, 18);
            }

            /*******************************************************************************************************
             * getPgmStt2Cic
             *******************************************************************************************************/
            /**
             *
             * @return pgmStt2Cic TODO_javadoc.
             *
             */
            public String getPgmStt2Cic() {
                return subValue(18, 19);
            }

            /*******************************************************************************************************
             * setPgmStatCicNul
             *******************************************************************************************************/
            /**
             *
             * @param pgmStatCicNul TODO_javadoc.
             *
             */
            public void setPgmStatCicNul(boolean pgmStatCicNul) {

                if (!pgmStatCicNul) {
                    throw new RuntimeException("Se intento setear pgmStatCicNul con false.");
                }

                setValue("  ");
            }

            /*******************************************************************************************************
             * isPgmStatCicNul
             *******************************************************************************************************/
            /**
             *
             * @return pgmStatCicNul TODO_javadoc.
             *
             */
            public boolean isPgmStatCicNul() {
                return getValue().equals("  ");
            }

            /*******************************************************************************************************
             * setPgmStatCicOks
             *******************************************************************************************************/
            /**
             *
             * @param pgmStatCicOks TODO_javadoc.
             *
             */
            public void setPgmStatCicOks(boolean pgmStatCicOks) {

                if (!pgmStatCicOks) {
                    throw new RuntimeException("Se intento setear pgmStatCicOks con false.");
                }

                setPgmStt1Cic("0");
            }

            /*******************************************************************************************************
             * isPgmStatCicOks
             *******************************************************************************************************/
            /**
             *
             * @return pgmStatCicOks TODO_javadoc.
             *
             */
            public boolean isPgmStatCicOks() {
                return getPgmStt1Cic().equals("0");
            }

        }

    }

}

