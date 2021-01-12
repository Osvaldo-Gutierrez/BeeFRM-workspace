/*
 *   Copyright (c) 2021 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */
package cl.bee.beebank.cloud.core.gns.gnsppidd;


import java.io.*;

import java.lang.reflect.*;

import java.util.*;

import org.apache.log4j.*;

import cl.bee.beebank.cloud.core.gns.Util;
import cl.bee.beebank.cloud.core.gns.gnsppidd.*;


/**
 *
 * TODO_javadoc.
 *
 * @version 1.0 (11/01/2021).
 *
 */
public class Gnsppidd {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(Gnsppidd.class);

    /** TODO_javadoc. */
    private int returnCode = 0;

    //

    /** SCR-VARI. */
    private ScrVari scrVari = new ScrVari();

    /** TPSVCRET-REC. */
    private TpsvcretRec tpsvcretRec = new TpsvcretRec();

    /** TPTYPE-REC. */
    private TptypeRec tptypeRec = new TptypeRec();

    /** TPSTATUS-REC. */
    private TpstatusRec tpstatusRec = new TpstatusRec();

    /** TPSVCDEF-REC. */
    private TpsvcdefRec tpsvcdefRec = new TpsvcdefRec();

    /** LOGMSG. */
    private Logmsg logmsg = new Logmsg();

    /** LOGMSG-LEN. */
    private int logmsgLen;

    /** FRM-VARI. */
    private FrmVari frmVari = new FrmVari();

    /** FRM-CTTS. */
    private FrmCtts frmCtts = new FrmCtts();

    /** SYS-VARI. */
    private SysVari sysVari = new SysVari();

    /** EIBTRMID. */
    private String eibtrmid = "    ";

    /** EIBTRNID. */
    private String eibtrnid = "    ";

    /** EIBTASKN. */
    private String eibtaskn = "    ";

    /** EIBCALEN. */
    private int eibcalen = 1;

    /** EIBAID. */
    private String eibaid = "'";

    /** EIBRESP. */
    private int eibresp = 0;

    /** EIBTASKN-1. */
    private Eibtaskn1 eibtaskn1 = new Eibtaskn1();

    /** FYH-VARI. */
    private FyhVari fyhVari = new FyhVari();

    /** SYS-CTTS. */
    private SysCtts sysCtts = new SysCtts();

    /** ADR-ELLS. */
    private AdrElls adrElls = new AdrElls();

    /** QUE-VARI. */
    private QueVari queVari = new QueVari();

    /** QUE-NUM-STAT. */
    private int queNumStat;

    /** QUE-GLS-STAT. */
    private int queGlsStat;

    /** QUE-CTTS. */
    private QueCtts queCtts = new QueCtts();

    /** QUE-SEND. */
    private QueSend queSend = new QueSend();

    /** QUE-RECV. */
    private QueRecv queRecv = new QueRecv();

    /** QUE-TPTYPE-REC-SEND. */
    private QueTptypeRecSend queTptypeRecSend = new QueTptypeRecSend();

    /** QUE-TPTYPE-REC-RECV. */
    private QueTptypeRecRecv queTptypeRecRecv = new QueTptypeRecRecv();

    /** QUE-TPSVCDEF-REC. */
    private QueTpsvcdefRec queTpsvcdefRec = new QueTpsvcdefRec();

    /** KEY-VARI. */
    private KeyVari keyVari = new KeyVari();

    /** TSK-TX-RETURN-STATUS. */
    private TskTxReturnStatus tskTxReturnStatus = new TskTxReturnStatus();

    /** TSK-TX-INFO-AREA. */
    private TskTxInfoArea tskTxInfoArea = new TskTxInfoArea();

    /** TPTRXLEV-REC. */
    private TptrxlevRec tptrxlevRec = new TptrxlevRec();

    /** TPTRXDEF-REC. */
    private TptrxdefRec tptrxdefRec = new TptrxdefRec();

    /** TSK-VARI. */
    private TskVari tskVari = new TskVari();

    /** HEADER-VARI. */
    private HeaderVari headerVari = new HeaderVari();

    /** HEADER-MENS. */
    private HeaderMens headerMens = new HeaderMens();

    /** MULMSG-VARI. */
    private MulmsgVari mulmsgVari = new MulmsgVari();

    /** MULMSG-MENS. */
    private MulmsgMens mulmsgMens = new MulmsgMens();

    /** ADR-UIFB. */
    private AdrUifb adrUifb = new AdrUifb();

    /** FIO-VARI. */
    private FioVari fioVari = new FioVari();

    /** FIO-CTTS. */
    private FioCtts fioCtts = new FioCtts();

    /** FIO-ORACLE. */
    private FioOracle fioOracle = new FioOracle();

    /** RECV-STRING-FIO. */
    private String recvStringFio;

    /** SEND-STRING-FIO. */
    private String sendStringFio;

    /** IDD-VARI. */
    private IddVari iddVari = new IddVari();

    /** IDD. */
    private Idd idd = new Idd();

    /** ADR-REQA. */
    private AdrReqa adrReqa = new AdrReqa();

    /** ADR-IDD-REQA. */
    private AdrIddReqa adrIddReqa = new AdrIddReqa();

    /** DFHCOMMAREA. */
    private Dfhcommarea dfhcommarea = new Dfhcommarea();

    /** FIO-BUF0. */
    private FioBuf0 fioBuf0 = new FioBuf0();

    /** FIO-ITBL. */
    private int fioItbl;

    /** IDD-ITBL. */
    private int iddItbl;

    /** IDD-NUM-ITBL. */
    private int iddNumItbl;

    /******************************************************************************
     * main
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param args TODO_javadoc.
     *
     */
    public static void main(String args[]) {

        try {
            (new Gnsppidd()).execute();
        }
        catch (Throwable e) {
            logger.error("Throwable: " + printStackTrace(e));
        }
    }

    /******************************************************************************
     * execute
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     */
    public void execute() {

        logger.debug("entrando a 'execute()' ...");

        execute("principal");

        logger.debug("saliendo de 'execute()' ...");
    }

    /******************************************************************************
     * execute
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @param methodName TODO_javadoc.
     *
     */
    public void execute(String methodName) {

        logger.debug("entrando a 'execute(" + methodName + ")' ...");

        String name = methodName;

        do {

            try {

                Method mth = this.getClass().getMethod(name, (Class<?>[]) null);

                name = (String) mth.invoke(this);
            }
            catch(Throwable e) {
                throw new RuntimeException(e);
            }

        } while (name != null);

        logger.debug("saliendo de 'execute(" + methodName + ")' ...");
    }

    /******************************************************************************
     * principal
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String principal() {

        logger.debug("entrando a 'principal()' ...");

        execute("principal_iniMain");

        logger.debug("saliendo de 'principal()' ...");

        return null;
    }

    /******************************************************************************
     * principal_iniMain
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String principal_iniMain() {

        logger.debug("entrando a 'principal_iniMain()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           ");
        //eibcalen = 0;
        //dfhcommarea.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE DFHCOMMAREA( 1 : EIBCALEN) TO IDD-VARI");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.setValue(dfhcommarea.getValue().substring(1 - 1, 1 + eibcalen - 1));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getValue() :" + iddVari.getValue());
        logger.debug("eibcalen :" + eibcalen);
        logger.debug("dfhcommarea.getValue().substring(1 - 1, 1 + eibcalen - 1) :" + dfhcommarea.getValue().substring(1 - 1, 1 + eibcalen - 1));
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        execute("gnsHdlVsm");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //idd.setIddCodCidd("            ");
        //iddVari.setIddProg("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE IDD-PROG TO IDD-COD-CIDD IN IDD");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        idd.setIddCodCidd(iddVari.getIddProg());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("idd.getIddCodCidd() :" + idd.getIddCodCidd());
        logger.debug("iddVari.getIddProg() :" + iddVari.getIddProg());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioVari.setFioCmnd(0);
        //fioCtts.getFioVcmn().setFioGetKey(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE FIO-GET-KEY TO FIO-CMND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        fioVari.setFioCmnd(fioCtts.getFioVcmn().getFioGetKey());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("fioVari.getFioCmnd() :" + fioVari.getFioCmnd());
        logger.debug("fioCtts.getFioVcmn().getFioGetKey() :" + fioCtts.getFioVcmn().getFioGetKey());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        execute("gnsFioIdd");

        if (!fioVari.getFioStat().isFioStatOks()) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //idd.setIddCodCidd("            ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("MOVE 'DEFAULT' TO IDD-COD-CIDD IN IDD");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            idd.setIddCodCidd("DEFAULT");

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("idd.getIddCodCidd() :" + idd.getIddCodCidd());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioVari.setFioCmnd(0);
            //fioCtts.getFioVcmn().setFioGetKey(0);
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("MOVE FIO-GET-KEY TO FIO-CMND");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            fioVari.setFioCmnd(fioCtts.getFioVcmn().getFioGetKey());

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("fioVari.getFioCmnd() :" + fioVari.getFioCmnd());
            logger.debug("fioCtts.getFioVcmn().getFioGetKey() :" + fioCtts.getFioVcmn().getFioGetKey());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            execute("gnsFioIdd");

            if (!fioVari.getFioStat().isFioStatOks()) {

                execute("cargaDefecto");
            }
            else {

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //iddVari.getIddRegi().setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          ");
                //idd.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          ");
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                logger.debug("MOVE IDD TO IDD-REGI");
                logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

                iddVari.getIddRegi().setValue(idd.getValue());

                logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                logger.debug("iddVari.getIddRegi().getValue() :" + iddVari.getIddRegi().getValue());
                logger.debug("idd.getValue() :" + idd.getValue());
                logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            }
        }
        else {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //iddVari.getIddRegi().setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          ");
            //idd.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("MOVE IDD TO IDD-REGI");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            iddVari.getIddRegi().setValue(idd.getValue());

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("iddVari.getIddRegi().getValue() :" + iddVari.getIddRegi().getValue());
            logger.debug("idd.getValue() :" + idd.getValue());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //dfhcommarea.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           ");
        //iddVari.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE IDD-VARI TO DFHCOMMAREA");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        dfhcommarea.setValue(iddVari.getValue());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("dfhcommarea.getValue() :" + dfhcommarea.getValue());
        logger.debug("iddVari.getValue() :" + iddVari.getValue());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tptypeRec.setLen(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE LENGTH OF DFHCOMMAREA TO LEN");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tptypeRec.setLen(0);

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tptypeRec.getLen() :" + tptypeRec.getLen());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tpsvcretRec.setTpsuccess(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("SET TPSUCCESS TO TRUE");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tpsvcretRec.setTpsuccess(true);

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tpsvcretRec.isTpsuccess() :" + tpsvcretRec.isTpsuccess());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("CALL \"TPRETURN\" USING TPSVCRET-REC TPTYPE-REC DFHCOMMAREA TPSTATUS-REC");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        if (!tpstatusRec.isTpok()) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //tpstatusRec.setTpStatus(0);
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("DISPLAY 'TPCALL TP-STATUS :' TP-STATUS");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            logger.info("TPCALL TP-STATUS :" + tpstatusRec.getTpStatus());

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("tpstatusRec.getTpStatus() :" + tpstatusRec.getTpStatus());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            System.exit(returnCode);
        }
        else {

            System.exit(returnCode);
        }
		return null;
    }

    /******************************************************************************
     * cargaDefecto
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String cargaDefecto() {

        logger.debug("entrando a 'cargaDefecto()' ...");

        execute("cargaDefecto_iniCargaDefecto");

        logger.debug("saliendo de 'cargaDefecto()' ...");

        return null;
    }

    /******************************************************************************
     * cargaDefecto_iniCargaDefecto
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String cargaDefecto_iniCargaDefecto() {

        logger.debug("entrando a 'cargaDefecto_iniCargaDefecto()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SPACES TO IDD-REGI");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().setValue(Util.spaces(490));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getValue() :" + iddVari.getIddRegi().getValue());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().setIddCidd("            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'DEFAULT' TO IDD-CIDD");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().setIddCidd("DEFAULT");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddCidd() :" + iddVari.getIddRegi().getIddCidd());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(1 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'GNS' TO IDD-SIST( 01)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(1 - 1).getIddDent().setIddSist("GNS");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(1 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(1 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(1 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'C' TO IDD-GRPO( 01)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(1 - 1).getIddDent().setIddGrpo("C");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(1 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(1 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(1 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 01)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(1 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(1 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(1 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(1 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '180' TO IDD-IENT( 01)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(1 - 1).setIddIent("180");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(1 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(1 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(2 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'TAB' TO IDD-SIST( 02)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(2 - 1).getIddDent().setIddSist("TAB");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(2 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(2 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(2 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'C' TO IDD-GRPO( 02)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(2 - 1).getIddDent().setIddGrpo("C");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(2 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(2 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(2 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 02)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(2 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(2 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(2 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(2 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '150' TO IDD-IENT( 02)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(2 - 1).setIddIent("150");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(2 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(2 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(3 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'GES' TO IDD-SIST( 03)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(3 - 1).getIddDent().setIddSist("GES");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(3 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(3 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(3 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'M' TO IDD-GRPO( 03)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(3 - 1).getIddDent().setIddGrpo("M");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(3 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(3 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(3 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 03)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(3 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(3 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(3 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(3 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '360' TO IDD-IENT( 03)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(3 - 1).setIddIent("360");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(3 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(3 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(4 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'SGC' TO IDD-SIST( 04)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(4 - 1).getIddDent().setIddSist("SGC");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(4 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(4 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(4 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'M' TO IDD-GRPO( 04)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(4 - 1).getIddDent().setIddGrpo("M");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(4 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(4 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(4 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 04)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(4 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(4 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(4 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(4 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '100' TO IDD-IENT( 04)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(4 - 1).setIddIent("100");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(4 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(4 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(5 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'SGC' TO IDD-SIST( 05)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(5 - 1).getIddDent().setIddSist("SGC");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(5 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(5 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(5 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'C' TO IDD-GRPO( 05)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(5 - 1).getIddDent().setIddGrpo("C");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(5 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(5 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(5 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 05)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(5 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(5 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(5 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(5 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '190' TO IDD-IENT( 05)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(5 - 1).setIddIent("190");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(5 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(5 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(6 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'SGC' TO IDD-SIST( 06)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(6 - 1).getIddDent().setIddSist("SGC");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(6 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(6 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(6 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'T' TO IDD-GRPO( 06)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(6 - 1).getIddDent().setIddGrpo("T");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(6 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(6 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(6 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 06)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(6 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(6 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(6 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(6 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '100' TO IDD-IENT( 06)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(6 - 1).setIddIent("100");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(6 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(6 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(7 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'DEU' TO IDD-SIST( 07)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(7 - 1).getIddDent().setIddSist("DEU");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(7 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(7 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(7 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'M' TO IDD-GRPO( 07)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(7 - 1).getIddDent().setIddGrpo("M");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(7 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(7 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(7 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 07)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(7 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(7 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(7 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(7 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '140' TO IDD-IENT( 07)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(7 - 1).setIddIent("140");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(7 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(7 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(8 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'GNS' TO IDD-SIST( 08)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(8 - 1).getIddDent().setIddSist("GNS");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(8 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(8 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(8 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'M' TO IDD-GRPO( 08)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(8 - 1).getIddDent().setIddGrpo("M");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(8 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(8 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(8 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 08)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(8 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(8 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(8 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(8 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '180' TO IDD-IENT( 08)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(8 - 1).setIddIent("180");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(8 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(8 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(9 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'DEU' TO IDD-SIST( 09)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(9 - 1).getIddDent().setIddSist("DEU");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(9 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(9 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(9 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'C' TO IDD-GRPO( 09)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(9 - 1).getIddDent().setIddGrpo("C");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(9 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(9 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(9 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 09)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(9 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(9 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(9 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(9 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '200' TO IDD-IENT( 09)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(9 - 1).setIddIent("200");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(9 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(9 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(10 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'MC2' TO IDD-SIST( 10)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(10 - 1).getIddDent().setIddSist("MC2");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(10 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(10 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(10 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'C' TO IDD-GRPO( 10)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(10 - 1).getIddDent().setIddGrpo("C");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(10 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(10 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(10 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 10)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(10 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(10 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(10 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(10 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '501' TO IDD-IENT( 10)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(10 - 1).setIddIent("501");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(10 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(10 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(11 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'GES' TO IDD-SIST( 11)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(11 - 1).getIddDent().setIddSist("GES");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(11 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(11 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(11 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'T' TO IDD-GRPO( 11)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(11 - 1).getIddDent().setIddGrpo("T");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(11 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(11 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(11 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 11)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(11 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(11 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(11 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(11 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '362' TO IDD-IENT( 11)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(11 - 1).setIddIent("362");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(11 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(11 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(12 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'GES' TO IDD-SIST( 12)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(12 - 1).getIddDent().setIddSist("GES");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(12 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(12 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(12 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'C' TO IDD-GRPO( 12)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(12 - 1).getIddDent().setIddGrpo("C");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(12 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(12 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(12 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 12)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(12 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(12 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(12 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(12 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '354' TO IDD-IENT( 12)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(12 - 1).setIddIent("354");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(12 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(12 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(13 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'COL' TO IDD-SIST( 13)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(13 - 1).getIddDent().setIddSist("COL");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(13 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(13 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(13 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'M' TO IDD-GRPO( 13)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(13 - 1).getIddDent().setIddGrpo("M");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(13 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(13 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(13 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 13)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(13 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(13 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(13 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(13 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '160' TO IDD-IENT( 13)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(13 - 1).setIddIent("160");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(13 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(13 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(14 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'COL' TO IDD-SIST( 14)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(14 - 1).getIddDent().setIddSist("COL");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(14 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(14 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(14 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'T' TO IDD-GRPO( 14)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(14 - 1).getIddDent().setIddGrpo("T");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(14 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(14 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(14 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 14)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(14 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(14 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(14 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(14 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '170' TO IDD-IENT( 14)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(14 - 1).setIddIent("170");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(14 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(14 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(15 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'COL' TO IDD-SIST( 15)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(15 - 1).getIddDent().setIddSist("COL");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(15 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(15 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(15 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'C' TO IDD-GRPO( 15)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(15 - 1).getIddDent().setIddGrpo("C");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(15 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(15 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(15 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 15)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(15 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(15 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(15 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(15 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '210' TO IDD-IENT( 15)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(15 - 1).setIddIent("210");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(15 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(15 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(16 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'BGL' TO IDD-SIST( 16)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(16 - 1).getIddDent().setIddSist("BGL");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(16 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(16 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(16 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'M' TO IDD-GRPO( 16)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(16 - 1).getIddDent().setIddGrpo("M");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(16 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(16 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(16 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 16)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(16 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(16 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(16 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(16 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '209' TO IDD-IENT( 16)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(16 - 1).setIddIent("209");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(16 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(16 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(17 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'MC2' TO IDD-SIST( 17)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(17 - 1).getIddDent().setIddSist("MC2");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(17 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(17 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(17 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'M' TO IDD-GRPO( 17)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(17 - 1).getIddDent().setIddGrpo("M");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(17 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(17 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(17 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 17)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(17 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(17 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(17 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(17 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '500' TO IDD-IENT( 17)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(17 - 1).setIddIent("500");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(17 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(17 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(18 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'DAP' TO IDD-SIST( 18)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(18 - 1).getIddDent().setIddSist("DAP");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(18 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(18 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(18 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'M' TO IDD-GRPO( 18)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(18 - 1).getIddDent().setIddGrpo("M");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(18 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(18 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(18 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 18)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(18 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(18 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(18 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(18 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '370' TO IDD-IENT( 18)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(18 - 1).setIddIent("370");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(18 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(18 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(19 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'SIN' TO IDD-SIST( 19)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(19 - 1).getIddDent().setIddSist("SIN");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(19 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(19 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(19 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'C' TO IDD-GRPO( 19)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(19 - 1).getIddDent().setIddGrpo("C");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(19 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(19 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(19 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 19)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(19 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(19 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(19 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(19 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '190' TO IDD-IENT( 19)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(19 - 1).setIddIent("190");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(19 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(19 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(20 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'SPA' TO IDD-SIST( 20)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(20 - 1).getIddDent().setIddSist("SPA");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(20 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(20 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(20 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'C' TO IDD-GRPO( 20)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(20 - 1).getIddDent().setIddGrpo("C");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(20 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(20 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(20 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 20)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(20 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(20 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(20 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(20 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '355' TO IDD-IENT( 20)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(20 - 1).setIddIent("355");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(20 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(20 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(21 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'SGC' TO IDD-SIST( 21)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(21 - 1).getIddDent().setIddSist("SGC");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(21 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(21 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(21 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'S' TO IDD-GRPO( 21)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(21 - 1).getIddDent().setIddGrpo("S");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(21 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(21 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(21 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 21)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(21 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(21 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(21 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(21 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '100' TO IDD-IENT( 21)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(21 - 1).setIddIent("100");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(21 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(21 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(22 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'SPA' TO IDD-SIST( 22)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(22 - 1).getIddDent().setIddSist("SPA");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(22 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(22 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(22 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'M' TO IDD-GRPO( 22)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(22 - 1).getIddDent().setIddGrpo("M");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(22 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(22 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(22 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 22)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(22 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(22 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(22 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(22 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '355' TO IDD-IENT( 22)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(22 - 1).setIddIent("355");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(22 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(22 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(23 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'GES' TO IDD-SIST( 23)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(23 - 1).getIddDent().setIddSist("GES");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(23 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(23 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(23 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'C' TO IDD-GRPO( 23)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(23 - 1).getIddDent().setIddGrpo("C");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(23 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(23 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(23 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 23)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(23 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(23 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(23 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(23 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '354' TO IDD-IENT( 23)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(23 - 1).setIddIent("354");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(23 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(23 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(24 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'CCT' TO IDD-SIST( 24)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(24 - 1).getIddDent().setIddSist("CCT");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(24 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(24 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(24 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'C' TO IDD-GRPO( 24)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(24 - 1).getIddDent().setIddGrpo("C");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(24 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(24 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(24 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 24)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(24 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(24 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(24 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(24 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '381' TO IDD-IENT( 24)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(24 - 1).setIddIent("381");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(24 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(24 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(25 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'DAP' TO IDD-SIST( 25)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(25 - 1).getIddDent().setIddSist("DAP");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(25 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(25 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(25 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'C' TO IDD-GRPO( 25)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(25 - 1).getIddDent().setIddGrpo("C");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(25 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(25 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(25 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 25)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(25 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(25 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(25 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(25 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '371' TO IDD-IENT( 25)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(25 - 1).setIddIent("371");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(25 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(25 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(26 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'DAP' TO IDD-SIST( 26)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(26 - 1).getIddDent().setIddSist("DAP");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(26 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(26 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(26 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'T' TO IDD-GRPO( 26)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(26 - 1).getIddDent().setIddGrpo("T");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(26 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(26 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(26 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 26)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(26 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(26 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(26 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(26 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '372' TO IDD-IENT( 26)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(26 - 1).setIddIent("372");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(26 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(26 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(27 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'SEC' TO IDD-SIST( 27)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(27 - 1).getIddDent().setIddSist("SEC");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(27 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(27 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(27 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'C' TO IDD-GRPO( 27)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(27 - 1).getIddDent().setIddGrpo("C");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(27 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(27 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(27 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 27)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(27 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(27 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(27 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(27 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '341' TO IDD-IENT( 27)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(27 - 1).setIddIent("341");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(27 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(27 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(28 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'SUP' TO IDD-SIST( 28)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(28 - 1).getIddDent().setIddSist("SUP");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(28 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(28 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(28 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'M' TO IDD-GRPO( 28)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(28 - 1).getIddDent().setIddGrpo("M");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(28 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(28 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(28 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 28)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(28 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(28 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(28 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(28 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '230' TO IDD-IENT( 28)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(28 - 1).setIddIent("230");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(28 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(28 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(29 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'SUP' TO IDD-SIST( 29)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(29 - 1).getIddDent().setIddSist("SUP");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(29 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(29 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(29 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'C' TO IDD-GRPO( 29)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(29 - 1).getIddDent().setIddGrpo("C");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(29 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(29 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(29 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 29)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(29 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(29 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(29 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(29 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '230' TO IDD-IENT( 29)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(29 - 1).setIddIent("230");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(29 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(29 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(30 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'LDC' TO IDD-SIST( 30)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(30 - 1).getIddDent().setIddSist("LDC");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(30 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(30 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(30 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'M' TO IDD-GRPO( 30)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(30 - 1).getIddDent().setIddGrpo("M");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(30 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(30 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(30 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 30)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(30 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(30 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(30 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(30 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '260' TO IDD-IENT( 30)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(30 - 1).setIddIent("260");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(30 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(30 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(31 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'SEC' TO IDD-SIST( 31)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(31 - 1).getIddDent().setIddSist("SEC");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(31 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(31 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(31 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'M' TO IDD-GRPO( 31)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(31 - 1).getIddDent().setIddGrpo("M");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(31 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(31 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(31 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 31)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(31 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(31 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(31 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(31 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '341' TO IDD-IENT( 31)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(31 - 1).setIddIent("341");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(31 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(31 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(32 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'LDC' TO IDD-SIST( 32)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(32 - 1).getIddDent().setIddSist("LDC");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(32 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(32 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(32 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'C' TO IDD-GRPO( 32)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(32 - 1).getIddDent().setIddGrpo("C");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(32 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(32 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(32 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 32)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(32 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(32 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(32 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(32 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '261' TO IDD-IENT( 32)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(32 - 1).setIddIent("261");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(32 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(32 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(33 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'CCT' TO IDD-SIST( 33)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(33 - 1).getIddDent().setIddSist("CCT");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(33 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(33 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(33 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'M' TO IDD-GRPO( 33)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(33 - 1).getIddDent().setIddGrpo("M");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(33 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(33 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(33 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 33)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(33 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(33 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(33 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(33 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '380' TO IDD-IENT( 33)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(33 - 1).setIddIent("380");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(33 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(33 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(34 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'BGL' TO IDD-SIST( 34)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(34 - 1).getIddDent().setIddSist("BGL");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(34 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(34 - 1).getIddDent().getIddSist());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(34 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'C' TO IDD-GRPO( 34)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(34 - 1).getIddDent().setIddGrpo("C");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(34 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(34 - 1).getIddDent().getIddGrpo());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(34 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'D' TO IDD-TENT( 34)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(34 - 1).setIddTent("D");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(34 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(34 - 1).getIddTent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(34 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '211' TO IDD-IENT( 34)");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        iddVari.getIddRegi().getIddFsis().getIddVsis(34 - 1).setIddIent("211");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(34 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(34 - 1).getIddIent());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        logger.debug("saliendo de 'cargaDefecto_iniCargaDefecto()' ...");

        return "cargaDefecto_finCargaDefecto";
    }

    /******************************************************************************
     * cargaDefecto_finCargaDefecto
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String cargaDefecto_finCargaDefecto() {

        logger.debug("entrando a 'cargaDefecto_finCargaDefecto()' ...");

        logger.debug("saliendo de 'cargaDefecto_finCargaDefecto()' ...");

        return null;
    }

    /******************************************************************************
     * gnsFioIdd
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsFioIdd() {

        logger.debug("entrando a 'gnsFioIdd()' ...");

        execute("gnsFioIdd_iniGnsFioIdd");

        logger.debug("saliendo de 'gnsFioIdd()' ...");

        return null;
    }

    /******************************************************************************
     * gnsFioIdd_iniGnsFioIdd
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsFioIdd_iniGnsFioIdd() {

        logger.debug("entrando a 'gnsFioIdd_iniGnsFioIdd()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //adrReqa.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ");
        //adrIddReqa.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE ADR-IDD-REQA TO ADR-REQA");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        adrReqa.setValue(adrIddReqa.getValue());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("adrReqa.getValue() :" + adrReqa.getValue());
        logger.debug("adrIddReqa.getValue() :" + adrIddReqa.getValue());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //adrReqa.setAdrTabl("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'IDD' TO ADR-TABL IN ADR-REQA");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        adrReqa.setAdrTabl("IDD");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("adrReqa.getAdrTabl() :" + adrReqa.getAdrTabl());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //adrReqa.setAdrDbid(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 999 TO ADR-DBID IN ADR-REQA");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        adrReqa.setAdrDbid(999);

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("adrReqa.getAdrDbid() :" + adrReqa.getAdrDbid());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        if (fioVari.getFioAkey().compareTo(Util.spaces(32)) <= 0) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioVari.setFioAkey("                                ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("MOVE 'IDD-COD-CIDD' TO FIO-AKEY");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            fioVari.setFioAkey("IDD-COD-CIDD");

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("fioVari.getFioAkey() :" + fioVari.getFioAkey());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //adrElls.setAdrElm1("     ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'IDD00' TO ADR-ELM1");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        adrElls.setAdrElm1("IDD00");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("adrElls.getAdrElm1() :" + adrElls.getAdrElm1());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //adrUifb.setAdrProg("        ");
        //fioCtts.setFioProg("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE FIO-PROG TO ADR-PROG");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        adrUifb.setAdrProg(fioCtts.getFioProg());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("adrUifb.getAdrProg() :" + adrUifb.getAdrProg());
        logger.debug("fioCtts.getFioProg() :" + fioCtts.getFioProg());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioCtts.setFioIaky(0);
        //fioVari.setFioCmnd(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE FIO-CMND TO FIO-IAKY");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        fioCtts.setFioIaky(fioVari.getFioCmnd());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("fioCtts.getFioIaky() :" + fioCtts.getFioIaky());
        logger.debug("fioVari.getFioCmnd() :" + fioVari.getFioCmnd());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        if (!fioCtts.isFioIakyCon() && (fioVari.getFioAkey().equals("IDD-COD-CIDD") || fioVari.getFioAkey().compareTo(Util.spaces(32)) <= 0)) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //adrReqa.setAdrVkey("                                                                                                                                                                                    ");
            //idd.setIddCodCidd("            ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("MOVE IDD-COD-CIDD IN IDD TO ADR-VKEY IN ADR-REQA");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            adrReqa.setAdrVkey(idd.getIddCodCidd());

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("adrReqa.getAdrVkey() :" + adrReqa.getAdrVkey());
            logger.debug("idd.getIddCodCidd() :" + idd.getIddCodCidd());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //adrReqa.setAdrDkey("     ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("MOVE 'IDD00' TO ADR-DKEY IN ADR-REQA");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            adrReqa.setAdrDkey("IDD00");

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("adrReqa.getAdrDkey() :" + adrReqa.getAdrDkey());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }
        else {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioCtts.getFioMens().setValue("                                                                                ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("MOVE 'En GNS-FIO-IDD, key' TO FIO-MENS");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            fioCtts.getFioMens().setValue("En GNS-FIO-IDD, key");

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("fioCtts.getFioMens().getValue() :" + fioCtts.getFioMens().getValue());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioCtts.getFioMensRed().setFioMensKey("                                ");
            //fioVari.setFioAkey("                                ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("MOVE FIO-AKEY TO FIO-MENS-KEY");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            fioCtts.getFioMensRed().setFioMensKey(fioVari.getFioAkey());

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("fioCtts.getFioMensRed().getFioMensKey() :" + fioCtts.getFioMensRed().getFioMensKey());
            logger.debug("fioVari.getFioAkey() :" + fioVari.getFioAkey());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioCtts.getFioMensRed().setFioMensFil("         ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("MOVE 'Invalida' TO FIO-MENS-FIL");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            fioCtts.getFioMensRed().setFioMensFil("Invalida");

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("fioCtts.getFioMensRed().getFioMensFil() :" + fioCtts.getFioMensRed().getFioMensFil());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            execute("prgAbt");
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioCtts.setFioDfld("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ");
        //idd.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE IDD TO FIO-DFLD");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        fioCtts.setFioDfld(idd.getValue());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("fioCtts.getFioDfld() :" + fioCtts.getFioDfld());
        logger.debug("idd.getValue() :" + idd.getValue());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        execute("gnsFioDtc");

        if (fioVari.getFioStat().isFioStatOks()) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //idd.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          ");
            //fioCtts.setFioDfld("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("MOVE FIO-DFLD TO IDD");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            idd.setValue(fioCtts.getFioDfld());

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("idd.getValue() :" + idd.getValue());
            logger.debug("fioCtts.getFioDfld() :" + fioCtts.getFioDfld());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }
        else {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioCtts.getFioMensRed().getFioMensFilRed().setFioMensSis("   ");
            //fioVari.getFioVoid().setFioSist("   ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("MOVE FIO-SIST TO FIO-MENS-SIS");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            fioCtts.getFioMensRed().getFioMensFilRed().setFioMensSis(fioVari.getFioVoid().getFioSist());

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("fioCtts.getFioMensRed().getFioMensFilRed().getFioMensSis() :" + fioCtts.getFioMensRed().getFioMensFilRed().getFioMensSis());
            logger.debug("fioVari.getFioVoid().getFioSist() :" + fioVari.getFioVoid().getFioSist());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioCtts.getFioMensRed().getFioMensFilRed().setFioMensReg("      ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("MOVE 'IDD' TO FIO-MENS-REG");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            fioCtts.getFioMensRed().getFioMensFilRed().setFioMensReg("IDD");

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("fioCtts.getFioMensRed().getFioMensFilRed().getFioMensReg() :" + fioCtts.getFioMensRed().getFioMensFilRed().getFioMensReg());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            if (fioVari.getFioStat().isFioStatFtl()) {

                execute("prgAbt");
            }
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioVari.setFioAkey("                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SPACES TO FIO-AKEY");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        fioVari.setFioAkey(Util.spaces(32));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("fioVari.getFioAkey() :" + fioVari.getFioAkey());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //adrIddReqa.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ");
        //adrReqa.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE ADR-REQA TO ADR-IDD-REQA");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        adrIddReqa.setValue(adrReqa.getValue());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("adrIddReqa.getValue() :" + adrIddReqa.getValue());
        logger.debug("adrReqa.getValue() :" + adrReqa.getValue());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        logger.debug("saliendo de 'gnsFioIdd_iniGnsFioIdd()' ...");

        return "gnsFioIdd_finGnsFioIdd";
    }

    /******************************************************************************
     * gnsFioIdd_finGnsFioIdd
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsFioIdd_finGnsFioIdd() {

        logger.debug("entrando a 'gnsFioIdd_finGnsFioIdd()' ...");

        logger.debug("saliendo de 'gnsFioIdd_finGnsFioIdd()' ...");

        return null;
    }

    /******************************************************************************
     * gnsHdlVsm
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsHdlVsm() {

        logger.debug("entrando a 'gnsHdlVsm()' ...");

        execute("gnsHdlVsm_iniGnsHdlVsm");

        logger.debug("saliendo de 'gnsHdlVsm()' ...");

        return null;
    }

    /******************************************************************************
     * gnsHdlVsm_iniGnsHdlVsm
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsHdlVsm_iniGnsHdlVsm() {

        logger.debug("entrando a 'gnsHdlVsm_iniGnsHdlVsm()' ...");

        logger.debug("saliendo de 'gnsHdlVsm_iniGnsHdlVsm()' ...");

        return "gnsHdlVsm_finGnsHdlVsm";
    }

    /******************************************************************************
     * gnsHdlVsm_finGnsHdlVsm
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsHdlVsm_finGnsHdlVsm() {

        logger.debug("entrando a 'gnsHdlVsm_finGnsHdlVsm()' ...");

        logger.debug("saliendo de 'gnsHdlVsm_finGnsHdlVsm()' ...");

        return null;
    }

    /******************************************************************************
     * gnsProSys
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsProSys() {

        logger.debug("entrando a 'gnsProSys()' ...");

        execute("gnsProSys_iniGnsProSys");

        logger.debug("saliendo de 'gnsProSys()' ...");

        return null;
    }

    /******************************************************************************
     * gnsProSys_iniGnsProSys
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsProSys_iniGnsProSys() {

        logger.debug("entrando a 'gnsProSys_iniGnsProSys()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.setSysStat("  ");
        //sysVari.setSysStatOks("  ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-STAT-OKS TO SYS-STAT");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.setSysStat(sysVari.getSysStatOks());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysStat() :" + sysVari.getSysStat());
        logger.debug("sysVari.getSysStatOks() :" + sysVari.getSysStatOks());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        if (sysVari.getSysIhdl().compareTo(Util.spaces(1)) <= 0) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //sysVari.setSysIhdl(" ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("MOVE 'N' TO SYS-IHDL");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            sysVari.setSysIhdl("N");

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("sysVari.getSysIhdl() :" + sysVari.getSysIhdl());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.setSysCmnd(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("GO TO DAT-GNS-PRO-SYS TIM-GNS-PRO-SYS EXT-GNS-PRO-SYS XCT-GNS-PRO-SYS LNK-GNS-PRO-SYS ABT-GNS-PRO-SYS DEPENDING ON SYS-CMND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        switch(sysVari.getSysCmnd()) {
        case 1 : 

            logger.debug("saliendo de 'gnsProSys_iniGnsProSys()' ...");
            return "gnsProSys_datGnsProSys";
        case 2 : 

            logger.debug("saliendo de 'gnsProSys_iniGnsProSys()' ...");
            return "gnsProSys_timGnsProSys";
        case 3 : 

            logger.debug("saliendo de 'gnsProSys_iniGnsProSys()' ...");
            return "gnsProSys_extGnsProSys";
        case 4 : 

            logger.debug("saliendo de 'gnsProSys_iniGnsProSys()' ...");
            return "gnsProSys_xctGnsProSys";
        case 5 : 

            logger.debug("saliendo de 'gnsProSys_iniGnsProSys()' ...");
            return "gnsProSys_lnkGnsProSys";
        case 6 : 

            logger.debug("saliendo de 'gnsProSys_iniGnsProSys()' ...");
            return "gnsProSys_abtGnsProSys";
        }

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysCmnd() :" + sysVari.getSysCmnd());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysMens().setSysMen1("                                        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'ABORTO, comando invalido en GNS-PRO-SYS:' TO SYS-MEN1");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysMens().setSysMen1("ABORTO, comando invalido en GNS-PRO-SYS:");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysMens().getSysMen1() :" + sysVari.getSysMens().getSysMen1());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysMens().setSysMen2("                                        ");
        //sysVari.setSysCmnd(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-CMND TO SYS-MEN2");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysMens().setSysMen2(Util.intToString(sysVari.getSysCmnd(), 40));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysMens().getSysMen2() :" + sysVari.getSysMens().getSysMen2());
        logger.debug("sysVari.getSysCmnd() :" + sysVari.getSysCmnd());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("GO TO ABT-GNS-PRO-SYS");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


        logger.debug("saliendo de 'gnsProSys_iniGnsProSys()' ...");
        return "gnsProSys_abtGnsProSys";
    }

    /******************************************************************************
     * gnsProSys_datGnsProSys
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsProSys_datGnsProSys() {

        logger.debug("entrando a 'gnsProSys_datGnsProSys()' ...");

        if (sysVari.getSysHoraHabi().equals("S") && sysVari.getSysHoraFlag().equals("S")) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //tpstatusRec.setTpStatus(0);
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("MOVE 0 TO TP-STATUS");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            tpstatusRec.setTpStatus(0);

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("tpstatusRec.getTpStatus() :" + tpstatusRec.getTpStatus());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("GO TO FIN-GNS-PRO-SYS");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


            logger.debug("saliendo de 'gnsProSys_datGnsProSys()' ...");
            return "gnsProSys_finGnsProSys";
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysFhoy2b().setValue("      ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("ACCEPT SYS-FHOY-2B FROM DATE");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysFhoy2b().setValue((new java.text.SimpleDateFormat("yyMMdd")).format(new java.util.Date()));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysFhoy2b().getValue() :" + sysVari.getSysFhoy2b().getValue());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysFhoy().setSysDhoy(0);
        //sysVari.getSysFhoy2b().setSysDhoy2b(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-DHOY-2B TO SYS-DHOY");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysFhoy().setSysDhoy(sysVari.getSysFhoy2b().getSysDhoy2b());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysFhoy().getSysDhoy() :" + sysVari.getSysFhoy().getSysDhoy());
        logger.debug("sysVari.getSysFhoy2b().getSysDhoy2b() :" + sysVari.getSysFhoy2b().getSysDhoy2b());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysFhoy().setSysSlh1(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '/' TO SYS-SLH1");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysFhoy().setSysSlh1("/");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysFhoy().getSysSlh1() :" + sysVari.getSysFhoy().getSysSlh1());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysFhoy().setSysMhoy(0);
        //sysVari.getSysFhoy2b().setSysMhoy2b(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-MHOY-2B TO SYS-MHOY");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysFhoy().setSysMhoy(sysVari.getSysFhoy2b().getSysMhoy2b());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysFhoy().getSysMhoy() :" + sysVari.getSysFhoy().getSysMhoy());
        logger.debug("sysVari.getSysFhoy2b().getSysMhoy2b() :" + sysVari.getSysFhoy2b().getSysMhoy2b());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysFhoy().setSysSlh2(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '/' TO SYS-SLH2");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysFhoy().setSysSlh2("/");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysFhoy().getSysSlh2() :" + sysVari.getSysFhoy().getSysSlh2());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysFhoy().setSysAhoy(0);
        //sysVari.getSysFhoy2b().setSysAhoy2b(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-AHOY-2B TO SYS-AHOY");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysFhoy().setSysAhoy(sysVari.getSysFhoy2b().getSysAhoy2b());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysFhoy().getSysAhoy() :" + sysVari.getSysFhoy().getSysAhoy());
        logger.debug("sysVari.getSysFhoy2b().getSysAhoy2b() :" + sysVari.getSysFhoy2b().getSysAhoy2b());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.setSysHhoy2b(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("ACCEPT SYS-HHOY-2B FROM TIME");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.setSysHhoy2b(Integer.parseInt((new java.text.SimpleDateFormat("HHmmssSSS")).format(new java.util.Date()).substring(0, 8)));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysHhoy2b() :" + sysVari.getSysHhoy2b());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysHhoyRed().setSysHhhy(0);
        //sysVari.getSysHhoy2bRed().setSysHhhy2b(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-HHHY-2B TO SYS-HHHY");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysHhoyRed().setSysHhhy(sysVari.getSysHhoy2bRed().getSysHhhy2b());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysHhoyRed().getSysHhhy() :" + sysVari.getSysHhoyRed().getSysHhhy());
        logger.debug("sysVari.getSysHhoy2bRed().getSysHhhy2b() :" + sysVari.getSysHhoy2bRed().getSysHhhy2b());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysHhoyRed().setSysMmhy(0);
        //sysVari.getSysHhoy2bRed().setSysMmhy2b(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-MMHY-2B TO SYS-MMHY");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysHhoyRed().setSysMmhy(sysVari.getSysHhoy2bRed().getSysMmhy2b());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysHhoyRed().getSysMmhy() :" + sysVari.getSysHhoyRed().getSysMmhy());
        logger.debug("sysVari.getSysHhoy2bRed().getSysMmhy2b() :" + sysVari.getSysHhoy2bRed().getSysMmhy2b());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysHhoyRed().setSysSshy(0);
        //sysVari.getSysHhoy2bRed().setSysSshy2b(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-SSHY-2B TO SYS-SSHY");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysHhoyRed().setSysSshy(sysVari.getSysHhoy2bRed().getSysSshy2b());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysHhoyRed().getSysSshy() :" + sysVari.getSysHhoyRed().getSysSshy());
        logger.debug("sysVari.getSysHhoy2bRed().getSysSshy2b() :" + sysVari.getSysHhoy2bRed().getSysSshy2b());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysTstp().getSysFstp().setSysAats(0);
        //sysVari.getSysFhoy().setSysAhoy(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-AHOY TO SYS-AATS IN SYS-FSTP");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysTstp().getSysFstp().setSysAats(sysVari.getSysFhoy().getSysAhoy());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysTstp().getSysFstp().getSysAats() :" + sysVari.getSysTstp().getSysFstp().getSysAats());
        logger.debug("sysVari.getSysFhoy().getSysAhoy() :" + sysVari.getSysFhoy().getSysAhoy());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysTstp().getSysFstp().setSysMmts(0);
        //sysVari.getSysFhoy().setSysMhoy(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-MHOY TO SYS-MMTS IN SYS-FSTP");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysTstp().getSysFstp().setSysMmts(sysVari.getSysFhoy().getSysMhoy());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysTstp().getSysFstp().getSysMmts() :" + sysVari.getSysTstp().getSysFstp().getSysMmts());
        logger.debug("sysVari.getSysFhoy().getSysMhoy() :" + sysVari.getSysFhoy().getSysMhoy());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysTstp().getSysFstp().setSysDdts(0);
        //sysVari.getSysFhoy().setSysDhoy(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-DHOY TO SYS-DDTS IN SYS-FSTP");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysTstp().getSysFstp().setSysDdts(sysVari.getSysFhoy().getSysDhoy());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysTstp().getSysFstp().getSysDdts() :" + sysVari.getSysTstp().getSysFstp().getSysDdts());
        logger.debug("sysVari.getSysFhoy().getSysDhoy() :" + sysVari.getSysFhoy().getSysDhoy());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        if (sysVari.getSysFhoy().getSysAhoy() < 60) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //sysVari.setSysShoy(0);
            //sysVari.getSysTstp().setSysSstp(0);
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("MOVE 20 TO SYS-SHOY SYS-SSTP");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            sysVari.setSysShoy(20);

            sysVari.getSysTstp().setSysSstp(20);

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("sysVari.getSysShoy() :" + sysVari.getSysShoy());
            logger.debug("sysVari.getSysTstp().getSysSstp() :" + sysVari.getSysTstp().getSysSstp());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }
        else {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //sysVari.setSysShoy(0);
            //sysVari.getSysTstp().setSysSstp(0);
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("MOVE 19 TO SYS-SHOY SYS-SSTP");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            sysVari.setSysShoy(19);

            sysVari.getSysTstp().setSysSstp(19);

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("sysVari.getSysShoy() :" + sysVari.getSysShoy());
            logger.debug("sysVari.getSysTstp().getSysSstp() :" + sysVari.getSysTstp().getSysSstp());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysTstp().getSysHstpRed().setSysHhts(0);
        //sysVari.getSysHhoyRed().setSysHhhy(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-HHHY TO SYS-HHTS IN SYS-HSTP-RED");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysTstp().getSysHstpRed().setSysHhts(sysVari.getSysHhoyRed().getSysHhhy());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysTstp().getSysHstpRed().getSysHhts() :" + sysVari.getSysTstp().getSysHstpRed().getSysHhts());
        logger.debug("sysVari.getSysHhoyRed().getSysHhhy() :" + sysVari.getSysHhoyRed().getSysHhhy());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysTstp().getSysHstpRed().setSysMmts(0);
        //sysVari.getSysHhoyRed().setSysMmhy(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-MMHY TO SYS-MMTS IN SYS-HSTP-RED");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysTstp().getSysHstpRed().setSysMmts(sysVari.getSysHhoyRed().getSysMmhy());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysTstp().getSysHstpRed().getSysMmts() :" + sysVari.getSysTstp().getSysHstpRed().getSysMmts());
        logger.debug("sysVari.getSysHhoyRed().getSysMmhy() :" + sysVari.getSysHhoyRed().getSysMmhy());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysTstp().getSysHstpRed().setSysSsts(0);
        //sysVari.getSysHhoyRed().setSysSshy(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-SSHY TO SYS-SSTS IN SYS-HSTP-RED");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysTstp().getSysHstpRed().setSysSsts(sysVari.getSysHhoyRed().getSysSshy());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysTstp().getSysHstpRed().getSysSsts() :" + sysVari.getSysTstp().getSysHstpRed().getSysSsts());
        logger.debug("sysVari.getSysHhoyRed().getSysSshy() :" + sysVari.getSysHhoyRed().getSysSshy());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tptypeRec.setLen(0);
        //fyhVari.setFyhTcma(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE FYH-TCMA TO LEN");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tptypeRec.setLen(fyhVari.getFyhTcma());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tptypeRec.getLen() :" + tptypeRec.getLen());
        logger.debug("fyhVari.getFyhTcma() :" + fyhVari.getFyhTcma());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tptypeRec.setRecType("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE \"CARRAY\" TO REC-TYPE");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tptypeRec.setRecType("CARRAY");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tptypeRec.getRecType() :" + tptypeRec.getRecType());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tpsvcdefRec.setServiceName("                                                                                                                               ");
        //fyhVari.setFyhProg("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE FYH-PROG TO SERVICE-NAME");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tpsvcdefRec.setServiceName(fyhVari.getFyhProg());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tpsvcdefRec.getServiceName() :" + tpsvcdefRec.getServiceName());
        logger.debug("fyhVari.getFyhProg() :" + fyhVari.getFyhProg());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("CALL \"TPCALL\" USING TPSVCDEF-REC TPTYPE-REC FYH-CMMA TPTYPE-REC FYH-CMMA TPSTATUS-REC");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        if (!tpstatusRec.isTpok()) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fyhVari.setFyhProg("        ");
            //tpstatusRec.setTpStatus(0);
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("DISPLAY 'DAT-GNS-PRO-SYS    :' FYH-PROG ' ' TP-STATUS");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            logger.info("DAT-GNS-PRO-SYS    :" + fyhVari.getFyhProg() + " " + tpstatusRec.getTpStatus());

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("fyhVari.getFyhProg() :" + fyhVari.getFyhProg());
            logger.debug("tpstatusRec.getTpStatus() :" + tpstatusRec.getTpStatus());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //tpstatusRec.setTpStatus(0);
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("MOVE 0 TO TP-STATUS");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            tpstatusRec.setTpStatus(0);

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("tpstatusRec.getTpStatus() :" + tpstatusRec.getTpStatus());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("GO TO FIN-GNS-PRO-SYS");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


            logger.debug("saliendo de 'gnsProSys_datGnsProSys()' ...");
            return "gnsProSys_finGnsProSys";
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysFhoy().setSysDhoy(0);
        //fyhVari.getFyhCmma().getFyhGlsRspt().getFyhFecFhoy().setFyhNumDhoy(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE FYH-NUM-DHOY IN FYH-CMMA TO SYS-DHOY");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysFhoy().setSysDhoy(fyhVari.getFyhCmma().getFyhGlsRspt().getFyhFecFhoy().getFyhNumDhoy());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysFhoy().getSysDhoy() :" + sysVari.getSysFhoy().getSysDhoy());
        logger.debug("fyhVari.getFyhCmma().getFyhGlsRspt().getFyhFecFhoy().getFyhNumDhoy() :" + fyhVari.getFyhCmma().getFyhGlsRspt().getFyhFecFhoy().getFyhNumDhoy());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysFhoy().setSysSlh1(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '/' TO SYS-SLH1");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysFhoy().setSysSlh1("/");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysFhoy().getSysSlh1() :" + sysVari.getSysFhoy().getSysSlh1());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysFhoy().setSysMhoy(0);
        //fyhVari.getFyhCmma().getFyhGlsRspt().getFyhFecFhoy().setFyhNumMhoy(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE FYH-NUM-MHOY IN FYH-CMMA TO SYS-MHOY");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysFhoy().setSysMhoy(fyhVari.getFyhCmma().getFyhGlsRspt().getFyhFecFhoy().getFyhNumMhoy());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysFhoy().getSysMhoy() :" + sysVari.getSysFhoy().getSysMhoy());
        logger.debug("fyhVari.getFyhCmma().getFyhGlsRspt().getFyhFecFhoy().getFyhNumMhoy() :" + fyhVari.getFyhCmma().getFyhGlsRspt().getFyhFecFhoy().getFyhNumMhoy());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysFhoy().setSysSlh2(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '/' TO SYS-SLH2");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysFhoy().setSysSlh2("/");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysFhoy().getSysSlh2() :" + sysVari.getSysFhoy().getSysSlh2());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysFhoy().setSysAhoy(0);
        //fyhVari.getFyhCmma().getFyhGlsRspt().getFyhFecFhoy().setFyhNumAhoy(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE FYH-NUM-AHOY IN FYH-CMMA TO SYS-AHOY");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysFhoy().setSysAhoy(fyhVari.getFyhCmma().getFyhGlsRspt().getFyhFecFhoy().getFyhNumAhoy());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysFhoy().getSysAhoy() :" + sysVari.getSysFhoy().getSysAhoy());
        logger.debug("fyhVari.getFyhCmma().getFyhGlsRspt().getFyhFecFhoy().getFyhNumAhoy() :" + fyhVari.getFyhCmma().getFyhGlsRspt().getFyhFecFhoy().getFyhNumAhoy());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysHhoyRed().setSysHhhy(0);
        //fyhVari.getFyhCmma().getFyhGlsRspt().getFyhHraHhoy().setFyhNumHhhy(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE FYH-NUM-HHHY IN FYH-CMMA TO SYS-HHHY");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysHhoyRed().setSysHhhy(fyhVari.getFyhCmma().getFyhGlsRspt().getFyhHraHhoy().getFyhNumHhhy());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysHhoyRed().getSysHhhy() :" + sysVari.getSysHhoyRed().getSysHhhy());
        logger.debug("fyhVari.getFyhCmma().getFyhGlsRspt().getFyhHraHhoy().getFyhNumHhhy() :" + fyhVari.getFyhCmma().getFyhGlsRspt().getFyhHraHhoy().getFyhNumHhhy());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysHhoyRed().setSysMmhy(0);
        //fyhVari.getFyhCmma().getFyhGlsRspt().getFyhHraHhoy().setFyhNumMmhy(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE FYH-NUM-MMHY IN FYH-CMMA TO SYS-MMHY");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysHhoyRed().setSysMmhy(fyhVari.getFyhCmma().getFyhGlsRspt().getFyhHraHhoy().getFyhNumMmhy());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysHhoyRed().getSysMmhy() :" + sysVari.getSysHhoyRed().getSysMmhy());
        logger.debug("fyhVari.getFyhCmma().getFyhGlsRspt().getFyhHraHhoy().getFyhNumMmhy() :" + fyhVari.getFyhCmma().getFyhGlsRspt().getFyhHraHhoy().getFyhNumMmhy());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysHhoyRed().setSysSshy(0);
        //fyhVari.getFyhCmma().getFyhGlsRspt().getFyhHraHhoy().setFyhNumSshy(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE FYH-NUM-SSHY IN FYH-CMMA TO SYS-SSHY");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysHhoyRed().setSysSshy(fyhVari.getFyhCmma().getFyhGlsRspt().getFyhHraHhoy().getFyhNumSshy());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysHhoyRed().getSysSshy() :" + sysVari.getSysHhoyRed().getSysSshy());
        logger.debug("fyhVari.getFyhCmma().getFyhGlsRspt().getFyhHraHhoy().getFyhNumSshy() :" + fyhVari.getFyhCmma().getFyhGlsRspt().getFyhHraHhoy().getFyhNumSshy());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysTstp().getSysFstp().setSysAats(0);
        //sysVari.getSysFhoy().setSysAhoy(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-AHOY TO SYS-AATS IN SYS-FSTP");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysTstp().getSysFstp().setSysAats(sysVari.getSysFhoy().getSysAhoy());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysTstp().getSysFstp().getSysAats() :" + sysVari.getSysTstp().getSysFstp().getSysAats());
        logger.debug("sysVari.getSysFhoy().getSysAhoy() :" + sysVari.getSysFhoy().getSysAhoy());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysTstp().getSysFstp().setSysMmts(0);
        //sysVari.getSysFhoy().setSysMhoy(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-MHOY TO SYS-MMTS IN SYS-FSTP");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysTstp().getSysFstp().setSysMmts(sysVari.getSysFhoy().getSysMhoy());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysTstp().getSysFstp().getSysMmts() :" + sysVari.getSysTstp().getSysFstp().getSysMmts());
        logger.debug("sysVari.getSysFhoy().getSysMhoy() :" + sysVari.getSysFhoy().getSysMhoy());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysTstp().getSysFstp().setSysDdts(0);
        //sysVari.getSysFhoy().setSysDhoy(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-DHOY TO SYS-DDTS IN SYS-FSTP");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysTstp().getSysFstp().setSysDdts(sysVari.getSysFhoy().getSysDhoy());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysTstp().getSysFstp().getSysDdts() :" + sysVari.getSysTstp().getSysFstp().getSysDdts());
        logger.debug("sysVari.getSysFhoy().getSysDhoy() :" + sysVari.getSysFhoy().getSysDhoy());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        if (sysVari.getSysFhoy().getSysAhoy() < 60) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //sysVari.setSysShoy(0);
            //sysVari.getSysTstp().setSysSstp(0);
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("MOVE 20 TO SYS-SHOY SYS-SSTP");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            sysVari.setSysShoy(20);

            sysVari.getSysTstp().setSysSstp(20);

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("sysVari.getSysShoy() :" + sysVari.getSysShoy());
            logger.debug("sysVari.getSysTstp().getSysSstp() :" + sysVari.getSysTstp().getSysSstp());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }
        else {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //sysVari.setSysShoy(0);
            //sysVari.getSysTstp().setSysSstp(0);
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("MOVE 19 TO SYS-SHOY SYS-SSTP");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            sysVari.setSysShoy(19);

            sysVari.getSysTstp().setSysSstp(19);

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("sysVari.getSysShoy() :" + sysVari.getSysShoy());
            logger.debug("sysVari.getSysTstp().getSysSstp() :" + sysVari.getSysTstp().getSysSstp());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysTstp().getSysHstpRed().setSysHhts(0);
        //sysVari.getSysHhoyRed().setSysHhhy(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-HHHY TO SYS-HHTS IN SYS-HSTP-RED");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysTstp().getSysHstpRed().setSysHhts(sysVari.getSysHhoyRed().getSysHhhy());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysTstp().getSysHstpRed().getSysHhts() :" + sysVari.getSysTstp().getSysHstpRed().getSysHhts());
        logger.debug("sysVari.getSysHhoyRed().getSysHhhy() :" + sysVari.getSysHhoyRed().getSysHhhy());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysTstp().getSysHstpRed().setSysMmts(0);
        //sysVari.getSysHhoyRed().setSysMmhy(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-MMHY TO SYS-MMTS IN SYS-HSTP-RED");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysTstp().getSysHstpRed().setSysMmts(sysVari.getSysHhoyRed().getSysMmhy());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysTstp().getSysHstpRed().getSysMmts() :" + sysVari.getSysTstp().getSysHstpRed().getSysMmts());
        logger.debug("sysVari.getSysHhoyRed().getSysMmhy() :" + sysVari.getSysHhoyRed().getSysMmhy());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysTstp().getSysHstpRed().setSysSsts(0);
        //sysVari.getSysHhoyRed().setSysSshy(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-SSHY TO SYS-SSTS IN SYS-HSTP-RED");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysTstp().getSysHstpRed().setSysSsts(sysVari.getSysHhoyRed().getSysSshy());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysTstp().getSysHstpRed().getSysSsts() :" + sysVari.getSysTstp().getSysHstpRed().getSysSsts());
        logger.debug("sysVari.getSysHhoyRed().getSysSshy() :" + sysVari.getSysHhoyRed().getSysSshy());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        if (sysVari.getSysHoraHabi().equals("S")) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //sysVari.setSysHoraFlag(" ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("MOVE 'S' TO SYS-HORA-FLAG");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            sysVari.setSysHoraFlag("S");

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("sysVari.getSysHoraFlag() :" + sysVari.getSysHoraFlag());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }
        else {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //sysVari.setSysHoraFlag(" ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("MOVE 'N' TO SYS-HORA-FLAG");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            sysVari.setSysHoraFlag("N");

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("sysVari.getSysHoraFlag() :" + sysVari.getSysHoraFlag());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("GO TO FIN-GNS-PRO-SYS");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


        logger.debug("saliendo de 'gnsProSys_datGnsProSys()' ...");
        return "gnsProSys_finGnsProSys";
    }

    /******************************************************************************
     * gnsProSys_timGnsProSys
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsProSys_timGnsProSys() {

        logger.debug("entrando a 'gnsProSys_timGnsProSys()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.setSysHhoy2b(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("ACCEPT SYS-HHOY-2B FROM TIME");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.setSysHhoy2b(Integer.parseInt((new java.text.SimpleDateFormat("HHmmssSSS")).format(new java.util.Date()).substring(0, 8)));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysHhoy2b() :" + sysVari.getSysHhoy2b());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysHhoyRed().setSysHhhy(0);
        //sysVari.getSysHhoy2bRed().setSysHhhy2b(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-HHHY-2B TO SYS-HHHY");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysHhoyRed().setSysHhhy(sysVari.getSysHhoy2bRed().getSysHhhy2b());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysHhoyRed().getSysHhhy() :" + sysVari.getSysHhoyRed().getSysHhhy());
        logger.debug("sysVari.getSysHhoy2bRed().getSysHhhy2b() :" + sysVari.getSysHhoy2bRed().getSysHhhy2b());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysHhoyRed().setSysMmhy(0);
        //sysVari.getSysHhoy2bRed().setSysMmhy2b(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-MMHY-2B TO SYS-MMHY");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysHhoyRed().setSysMmhy(sysVari.getSysHhoy2bRed().getSysMmhy2b());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysHhoyRed().getSysMmhy() :" + sysVari.getSysHhoyRed().getSysMmhy());
        logger.debug("sysVari.getSysHhoy2bRed().getSysMmhy2b() :" + sysVari.getSysHhoy2bRed().getSysMmhy2b());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysHhoyRed().setSysSshy(0);
        //sysVari.getSysHhoy2bRed().setSysSshy2b(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-SSHY-2B TO SYS-SSHY");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysHhoyRed().setSysSshy(sysVari.getSysHhoy2bRed().getSysSshy2b());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysHhoyRed().getSysSshy() :" + sysVari.getSysHhoyRed().getSysSshy());
        logger.debug("sysVari.getSysHhoy2bRed().getSysSshy2b() :" + sysVari.getSysHhoy2bRed().getSysSshy2b());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tptypeRec.setLen(0);
        //fyhVari.setFyhTcma(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE FYH-TCMA TO LEN");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tptypeRec.setLen(fyhVari.getFyhTcma());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tptypeRec.getLen() :" + tptypeRec.getLen());
        logger.debug("fyhVari.getFyhTcma() :" + fyhVari.getFyhTcma());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tptypeRec.setRecType("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE \"CARRAY\" TO REC-TYPE");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tptypeRec.setRecType("CARRAY");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tptypeRec.getRecType() :" + tptypeRec.getRecType());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tpsvcdefRec.setServiceName("                                                                                                                               ");
        //fyhVari.setFyhProg("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE FYH-PROG TO SERVICE-NAME");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tpsvcdefRec.setServiceName(fyhVari.getFyhProg());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tpsvcdefRec.getServiceName() :" + tpsvcdefRec.getServiceName());
        logger.debug("fyhVari.getFyhProg() :" + fyhVari.getFyhProg());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("CALL \"TPCALL\" USING TPSVCDEF-REC TPTYPE-REC FYH-CMMA TPTYPE-REC FYH-CMMA TPSTATUS-REC");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        if (!tpstatusRec.isTpok()) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fyhVari.setFyhProg("        ");
            //tpstatusRec.setTpStatus(0);
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("DISPLAY 'TIM-GNS-PRO-SYS    :' FYH-PROG ' ' TP-STATUS");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            logger.info("TIM-GNS-PRO-SYS    :" + fyhVari.getFyhProg() + " " + tpstatusRec.getTpStatus());

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("fyhVari.getFyhProg() :" + fyhVari.getFyhProg());
            logger.debug("tpstatusRec.getTpStatus() :" + tpstatusRec.getTpStatus());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //tpstatusRec.setTpStatus(0);
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("MOVE 0 TO TP-STATUS");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            tpstatusRec.setTpStatus(0);

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("tpstatusRec.getTpStatus() :" + tpstatusRec.getTpStatus());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("GO TO FIN-GNS-PRO-SYS");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


            logger.debug("saliendo de 'gnsProSys_timGnsProSys()' ...");
            return "gnsProSys_finGnsProSys";
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysHhoyRed().setSysHhhy(0);
        //fyhVari.getFyhCmma().getFyhGlsRspt().getFyhHraHhoy().setFyhNumHhhy(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE FYH-NUM-HHHY IN FYH-CMMA TO SYS-HHHY");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysHhoyRed().setSysHhhy(fyhVari.getFyhCmma().getFyhGlsRspt().getFyhHraHhoy().getFyhNumHhhy());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysHhoyRed().getSysHhhy() :" + sysVari.getSysHhoyRed().getSysHhhy());
        logger.debug("fyhVari.getFyhCmma().getFyhGlsRspt().getFyhHraHhoy().getFyhNumHhhy() :" + fyhVari.getFyhCmma().getFyhGlsRspt().getFyhHraHhoy().getFyhNumHhhy());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysHhoyRed().setSysMmhy(0);
        //fyhVari.getFyhCmma().getFyhGlsRspt().getFyhHraHhoy().setFyhNumMmhy(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE FYH-NUM-MMHY IN FYH-CMMA TO SYS-MMHY");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysHhoyRed().setSysMmhy(fyhVari.getFyhCmma().getFyhGlsRspt().getFyhHraHhoy().getFyhNumMmhy());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysHhoyRed().getSysMmhy() :" + sysVari.getSysHhoyRed().getSysMmhy());
        logger.debug("fyhVari.getFyhCmma().getFyhGlsRspt().getFyhHraHhoy().getFyhNumMmhy() :" + fyhVari.getFyhCmma().getFyhGlsRspt().getFyhHraHhoy().getFyhNumMmhy());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysHhoyRed().setSysSshy(0);
        //fyhVari.getFyhCmma().getFyhGlsRspt().getFyhHraHhoy().setFyhNumSshy(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE FYH-NUM-SSHY IN FYH-CMMA TO SYS-SSHY");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysHhoyRed().setSysSshy(fyhVari.getFyhCmma().getFyhGlsRspt().getFyhHraHhoy().getFyhNumSshy());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysHhoyRed().getSysSshy() :" + sysVari.getSysHhoyRed().getSysSshy());
        logger.debug("fyhVari.getFyhCmma().getFyhGlsRspt().getFyhHraHhoy().getFyhNumSshy() :" + fyhVari.getFyhCmma().getFyhGlsRspt().getFyhHraHhoy().getFyhNumSshy());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysTstp().getSysHstpRed().setSysHhts(0);
        //sysVari.getSysHhoyRed().setSysHhhy(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-HHHY TO SYS-HHTS IN SYS-HSTP-RED");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysTstp().getSysHstpRed().setSysHhts(sysVari.getSysHhoyRed().getSysHhhy());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysTstp().getSysHstpRed().getSysHhts() :" + sysVari.getSysTstp().getSysHstpRed().getSysHhts());
        logger.debug("sysVari.getSysHhoyRed().getSysHhhy() :" + sysVari.getSysHhoyRed().getSysHhhy());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysTstp().getSysHstpRed().setSysMmts(0);
        //sysVari.getSysHhoyRed().setSysMmhy(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-MMHY TO SYS-MMTS IN SYS-HSTP-RED");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysTstp().getSysHstpRed().setSysMmts(sysVari.getSysHhoyRed().getSysMmhy());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysTstp().getSysHstpRed().getSysMmts() :" + sysVari.getSysTstp().getSysHstpRed().getSysMmts());
        logger.debug("sysVari.getSysHhoyRed().getSysMmhy() :" + sysVari.getSysHhoyRed().getSysMmhy());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysTstp().getSysHstpRed().setSysSsts(0);
        //sysVari.getSysHhoyRed().setSysSshy(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-SSHY TO SYS-SSTS IN SYS-HSTP-RED");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysTstp().getSysHstpRed().setSysSsts(sysVari.getSysHhoyRed().getSysSshy());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysTstp().getSysHstpRed().getSysSsts() :" + sysVari.getSysTstp().getSysHstpRed().getSysSsts());
        logger.debug("sysVari.getSysHhoyRed().getSysSshy() :" + sysVari.getSysHhoyRed().getSysSshy());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("GO TO FIN-GNS-PRO-SYS");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


        logger.debug("saliendo de 'gnsProSys_timGnsProSys()' ...");
        return "gnsProSys_finGnsProSys";
    }

    /******************************************************************************
     * gnsProSys_extGnsProSys
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsProSys_extGnsProSys() {

        logger.debug("entrando a 'gnsProSys_extGnsProSys()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysCmma().setSysScrNtrn("    ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SPACES TO SYS-SCR-NTRN");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysCmma().setSysScrNtrn(Util.spaces(4));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysCmma().getSysScrNtrn() :" + sysVari.getSysCmma().getSysScrNtrn());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysCmma().setSysScrNtrn("    ");
        //sysVari.setSysNtrn("    ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-NTRN TO SYS-SCR-NTRN");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysCmma().setSysScrNtrn(sysVari.getSysNtrn());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysCmma().getSysScrNtrn() :" + sysVari.getSysCmma().getSysScrNtrn());
        logger.debug("sysVari.getSysNtrn() :" + sysVari.getSysNtrn());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tptypeRec.setLen(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE + 3500 TO LEN");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tptypeRec.setLen(+3500);

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tptypeRec.getLen() :" + tptypeRec.getLen());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tpsvcretRec.setTpsuccess(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("SET TPSUCCESS TO TRUE");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tpsvcretRec.setTpsuccess(true);

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tpsvcretRec.isTpsuccess() :" + tpsvcretRec.isTpsuccess());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("CALL \"TPRETURN\" USING TPSVCRET-REC TPTYPE-REC SYS-CMMA TPSTATUS-REC");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        System.exit(returnCode);
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("GO TO STT-GNS-PRO-SYS");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


        logger.debug("saliendo de 'gnsProSys_extGnsProSys()' ...");
        return "gnsProSys_sttGnsProSys";

      //  logger.debug("saliendo de 'gnsProSys_extGnsProSys()' ...");

     //   return null;
    }

    /******************************************************************************
     * gnsProSys_xctGnsProSys
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsProSys_xctGnsProSys() {

        logger.debug("entrando a 'gnsProSys_xctGnsProSys()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysCmma().setSysScrNtrn("    ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SPACES TO SYS-SCR-NTRN");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysCmma().setSysScrNtrn(Util.spaces(4));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysCmma().getSysScrNtrn() :" + sysVari.getSysCmma().getSysScrNtrn());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tptypeRec.setLen(0);
        //sysVari.setSysTcma(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-TCMA TO LEN");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tptypeRec.setLen(sysVari.getSysTcma());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tptypeRec.getLen() :" + tptypeRec.getLen());
        logger.debug("sysVari.getSysTcma() :" + sysVari.getSysTcma());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysCmma().setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("DISPLAY 'GNS SYS-CMMA:' SYS-CMMA");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        logger.info("GNS SYS-CMMA:" + sysVari.getSysCmma().getValue());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysCmma().getValue() :" + sysVari.getSysCmma().getValue());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tptypeRec.setRecType("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE \"CARRAY\" TO REC-TYPE");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tptypeRec.setRecType("CARRAY");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tptypeRec.getRecType() :" + tptypeRec.getRecType());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tpsvcdefRec.setServiceName("                                                                                                                               ");
        //sysVari.setSysProg("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-PROG TO SERVICE-NAME");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tpsvcdefRec.setServiceName(sysVari.getSysProg());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tpsvcdefRec.getServiceName() :" + tpsvcdefRec.getServiceName());
        logger.debug("sysVari.getSysProg() :" + sysVari.getSysProg());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("CALL \"TPFORWARD\" USING TPSVCDEF-REC TPTYPE-REC SYS-CMMA TPSTATUS-REC");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        if (!tpstatusRec.isTpok()) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //sysVari.setSysProg("        ");
            //tpstatusRec.setTpStatus(0);
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("DISPLAY 'XCT-GNS-PRO-SYS    :' SYS-PROG ' ' TP-STATUS");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            logger.info("XCT-GNS-PRO-SYS    :" + sysVari.getSysProg() + " " + tpstatusRec.getTpStatus());

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("sysVari.getSysProg() :" + sysVari.getSysProg());
            logger.debug("tpstatusRec.getTpStatus() :" + tpstatusRec.getTpStatus());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }

        System.exit(returnCode);
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("GO TO STT-GNS-PRO-SYS");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


        logger.debug("saliendo de 'gnsProSys_xctGnsProSys()' ...");
        return "gnsProSys_sttGnsProSys";

       // logger.debug("saliendo de 'gnsProSys_xctGnsProSys()' ...");

      //  return null;
    }

    /******************************************************************************
     * gnsProSys_lnkGnsProSys
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsProSys_lnkGnsProSys() {

        logger.debug("entrando a 'gnsProSys_lnkGnsProSys()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysCmma().setSysScrNtrn("    ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SPACES TO SYS-SCR-NTRN");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysCmma().setSysScrNtrn(Util.spaces(4));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysCmma().getSysScrNtrn() :" + sysVari.getSysCmma().getSysScrNtrn());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tptypeRec.setLen(0);
        //sysVari.setSysTcma(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-TCMA TO LEN");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tptypeRec.setLen(sysVari.getSysTcma());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tptypeRec.getLen() :" + tptypeRec.getLen());
        logger.debug("sysVari.getSysTcma() :" + sysVari.getSysTcma());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tptypeRec.setRecType("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE \"CARRAY\" TO REC-TYPE");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tptypeRec.setRecType("CARRAY");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tptypeRec.getRecType() :" + tptypeRec.getRecType());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tpsvcdefRec.setServiceName("                                                                                                                               ");
        //sysVari.setSysProg("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-PROG TO SERVICE-NAME");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tpsvcdefRec.setServiceName(sysVari.getSysProg());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tpsvcdefRec.getServiceName() :" + tpsvcdefRec.getServiceName());
        logger.debug("sysVari.getSysProg() :" + sysVari.getSysProg());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysCmma().setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("DISPLAY 'SYS-CMMA :' SYS-CMMA");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        logger.info("SYS-CMMA :" + sysVari.getSysCmma().getValue());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysCmma().getValue() :" + sysVari.getSysCmma().getValue());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("CALL \"TPCALL\" USING TPSVCDEF-REC TPTYPE-REC SYS-CMMA TPTYPE-REC SYS-CMMA TPSTATUS-REC");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        if (!tpstatusRec.isTpok()) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //sysVari.setSysProg("        ");
            //tpstatusRec.setTpStatus(0);
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("DISPLAY 'LNK-GNS-PRO-SYS    :' SYS-PROG ' ' TP-STATUS");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            logger.info("LNK-GNS-PRO-SYS    :" + sysVari.getSysProg() + " " + tpstatusRec.getTpStatus());

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("sysVari.getSysProg() :" + sysVari.getSysProg());
            logger.debug("tpstatusRec.getTpStatus() :" + tpstatusRec.getTpStatus());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("GO TO STT-GNS-PRO-SYS");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


        logger.debug("saliendo de 'gnsProSys_lnkGnsProSys()' ...");
        return "gnsProSys_sttGnsProSys";
    }

    /******************************************************************************
     * gnsProSys_abtGnsProSys
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsProSys_abtGnsProSys() {

        logger.debug("entrando a 'gnsProSys_abtGnsProSys()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.setSysProg("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'GNSPPABT' TO SYS-PROG");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.setSysProg("GNSPPABT");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysProg() :" + sysVari.getSysProg());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.setSysTcma(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE + 79 TO SYS-TCMA");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.setSysTcma(+79);

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysTcma() :" + sysVari.getSysTcma());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tptypeRec.setLen(0);
        //sysVari.setSysTcma(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-TCMA TO LEN");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tptypeRec.setLen(sysVari.getSysTcma());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tptypeRec.getLen() :" + tptypeRec.getLen());
        logger.debug("sysVari.getSysTcma() :" + sysVari.getSysTcma());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tptypeRec.setRecType("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE \"CARRAY\" TO REC-TYPE");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tptypeRec.setRecType("CARRAY");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tptypeRec.getRecType() :" + tptypeRec.getRecType());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tpsvcdefRec.setServiceName("                                                                                                                               ");
        //sysVari.setSysProg("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-PROG TO SERVICE-NAME");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tpsvcdefRec.setServiceName(sysVari.getSysProg());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tpsvcdefRec.getServiceName() :" + tpsvcdefRec.getServiceName());
        logger.debug("sysVari.getSysProg() :" + sysVari.getSysProg());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("CALL \"TPFORWARD\" USING TPSVCDEF-REC TPTYPE-REC SYS-MENS TPSTATUS-REC");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        if (!tpstatusRec.isTpok()) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //sysVari.setSysProg("        ");
            //tpstatusRec.setTpStatus(0);
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("DISPLAY 'ABT-GNS-PRO-SYS    :' SYS-PROG ' ' TP-STATUS");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            logger.info("ABT-GNS-PRO-SYS    :" + sysVari.getSysProg() + " " + tpstatusRec.getTpStatus());

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("sysVari.getSysProg() :" + sysVari.getSysProg());
            logger.debug("tpstatusRec.getTpStatus() :" + tpstatusRec.getTpStatus());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }

        System.exit(returnCode);

        logger.debug("saliendo de 'gnsProSys_abtGnsProSys()' ...");

        return null;
    }

    /******************************************************************************
     * gnsProSys_sttGnsProSys
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsProSys_sttGnsProSys() {

        logger.debug("entrando a 'gnsProSys_sttGnsProSys()' ...");

        if (tpstatusRec.isTpok()) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //sysVari.setSysStat("  ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("MOVE '00' TO SYS-STAT");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            sysVari.setSysStat("00");

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("sysVari.getSysStat() :" + sysVari.getSysStat());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("GO TO FIN-GNS-PRO-SYS");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


            logger.debug("saliendo de 'gnsProSys_sttGnsProSys()' ...");
            return "gnsProSys_finGnsProSys";
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.setSysStatNum(0);
        //tpstatusRec.setTpStatus(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE TP-STATUS TO SYS-STAT-NUM");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.setSysStatNum(tpstatusRec.getTpStatus());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysStatNum() :" + sysVari.getSysStatNum());
        logger.debug("tpstatusRec.getTpStatus() :" + tpstatusRec.getTpStatus());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysMens().setSysMen1("                                        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'Aborto, EN GNS-PRO-SYS , CMD : ' TO SYS-MEN1");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysMens().setSysMen1("Aborto, EN GNS-PRO-SYS , CMD : ");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysMens().getSysMen1() :" + sysVari.getSysMens().getSysMen1());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysMens().setSysMen2("                                        ");
        //sysVari.setSysCmnd(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-CMND TO SYS-MEN2");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysMens().setSysMen2(Util.intToString(sysVari.getSysCmnd(), 40));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysMens().getSysMen2() :" + sysVari.getSysMens().getSysMen2());
        logger.debug("sysVari.getSysCmnd() :" + sysVari.getSysCmnd());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.setSysStat("  ");
        //sysVari.setSysStatNum(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-STAT-NUM TO SYS-STAT");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.setSysStat(Util.intToString(sysVari.getSysStatNum(), 2));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysStat() :" + sysVari.getSysStat());
        logger.debug("sysVari.getSysStatNum() :" + sysVari.getSysStatNum());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("GO TO ABT-GNS-PRO-SYS");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


        logger.debug("saliendo de 'gnsProSys_sttGnsProSys()' ...");
        return "gnsProSys_abtGnsProSys";
    }

    /******************************************************************************
     * gnsProSys_finGnsProSys
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsProSys_finGnsProSys() {

        logger.debug("entrando a 'gnsProSys_finGnsProSys()' ...");

        logger.debug("saliendo de 'gnsProSys_finGnsProSys()' ...");

        return null;
    }

    /******************************************************************************
     * doUserlog
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String doUserlog() {

        logger.debug("entrando a 'doUserlog()' ...");

        execute("doUserlog_iniDoUserlog");

        logger.debug("saliendo de 'doUserlog()' ...");

        return null;
    }

    /******************************************************************************
     * doUserlog_iniDoUserlog
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String doUserlog_iniDoUserlog() {

        logger.debug("entrando a 'doUserlog_iniDoUserlog()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //logmsgLen = 0;
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE LENGTH OF LOGMSG TO LOGMSG-LEN");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        logmsgLen = 0;

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("logmsgLen :" + logmsgLen);
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.setSysHhoy2b(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("ACCEPT SYS-HHOY-2B FROM TIME");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.setSysHhoy2b(Integer.parseInt((new java.text.SimpleDateFormat("HHmmssSSS")).format(new java.util.Date()).substring(0, 8)));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysHhoy2b() :" + sysVari.getSysHhoy2b());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //logmsg.setLogmsgTime("        ");
        //sysVari.setSysHhoy2b(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-HHOY-2B TO LOGMSG-TIME");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        logmsg.setLogmsgTime(Util.intToString(sysVari.getSysHhoy2b(), 8));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("logmsg.getLogmsgTime() :" + logmsg.getLogmsgTime());
        logger.debug("sysVari.getSysHhoy2b() :" + sysVari.getSysHhoy2b());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("CALL \"USERLOG\" USING LOGMSG LOGMSG-LEN TPSTATUS-REC");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        logger.debug("saliendo de 'doUserlog_iniDoUserlog()' ...");

        return "doUserlog_finDoUserlog";
    }

    /******************************************************************************
     * doUserlog_finDoUserlog
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String doUserlog_finDoUserlog() {

        logger.debug("entrando a 'doUserlog_finDoUserlog()' ...");

        logger.debug("saliendo de 'doUserlog_finDoUserlog()' ...");

        return null;
    }

    /******************************************************************************
     * gnsFioDtc
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsFioDtc() {

        logger.debug("entrando a 'gnsFioDtc()' ...");

        execute("gnsFioDtc_iniGnsFioDtc");

        logger.debug("saliendo de 'gnsFioDtc()' ...");

        return null;
    }

    /******************************************************************************
     * gnsFioDtc_iniGnsFioDtc
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsFioDtc_iniGnsFioDtc() {

        logger.debug("entrando a 'gnsFioDtc_iniGnsFioDtc()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioOracle.setFioOracleRqa("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      ");
        //adrReqa.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE ADR-REQA TO FIO-ORACLE-RQA");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        fioOracle.setFioOracleRqa(adrReqa.getValue());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("fioOracle.getFioOracleRqa() :" + fioOracle.getFioOracleRqa());
        logger.debug("adrReqa.getValue() :" + adrReqa.getValue());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioOracle.setFioOracleDfld("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ");
        //fioCtts.setFioDfld("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE FIO-DFLD TO FIO-ORACLE-DFLD");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        fioOracle.setFioOracleDfld(fioCtts.getFioDfld());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("fioOracle.getFioOracleDfld() :" + fioOracle.getFioOracleDfld());
        logger.debug("fioCtts.getFioDfld() :" + fioCtts.getFioDfld());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioOracle.setFioOracleMens("                                                                                ");
        //fioCtts.getFioMens().setValue("                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE FIO-MENS TO FIO-ORACLE-MENS");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        fioOracle.setFioOracleMens(fioCtts.getFioMens().getValue());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("fioOracle.getFioOracleMens() :" + fioOracle.getFioOracleMens());
        logger.debug("fioCtts.getFioMens().getValue() :" + fioCtts.getFioMens().getValue());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioOracle.setFioOracleVari("                                                                                ");
        //fioVari.setValue("                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE FIO-VARI TO FIO-ORACLE-VARI");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        fioOracle.setFioOracleVari(fioVari.getValue());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("fioOracle.getFioOracleVari() :" + fioOracle.getFioOracleVari());
        logger.debug("fioVari.getValue() :" + fioVari.getValue());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioOracle.getFioOracleProg().setFioOracleProgTab("   ");
        //adrReqa.setAdrTabl("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE ADR-TABL IN ADR-REQA TO FIO-ORACLE-PROG-TAB");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        fioOracle.getFioOracleProg().setFioOracleProgTab(adrReqa.getAdrTabl());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("fioOracle.getFioOracleProg().getFioOracleProgTab() :" + fioOracle.getFioOracleProg().getFioOracleProgTab());
        logger.debug("adrReqa.getAdrTabl() :" + adrReqa.getAdrTabl());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioOracle.getFioOracleProg().setFioOracleProgNum(0);
        //adrReqa.setAdrDbid(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE ADR-DBID IN ADR-REQA TO FIO-ORACLE-PROG-NUM");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        fioOracle.getFioOracleProg().setFioOracleProgNum(adrReqa.getAdrDbid());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("fioOracle.getFioOracleProg().getFioOracleProgNum() :" + fioOracle.getFioOracleProg().getFioOracleProgNum());
        logger.debug("adrReqa.getAdrDbid() :" + adrReqa.getAdrDbid());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sendStringFio = "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ";
        //fioOracle.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE FIO-ORACLE TO SEND-STRING-FIO");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sendStringFio = fioOracle.getValue();

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sendStringFio :" + sendStringFio);
        logger.debug("fioOracle.getValue() :" + fioOracle.getValue());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        if (fioVari.getFioCmnd() == 38) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioVari.getFioStat().setValue("  ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("MOVE ZEROES TO FIO-STAT");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            fioVari.getFioStat().setValue(Util.intToString(0, 2));

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("fioVari.getFioStat().getValue() :" + fioVari.getFioStat().getValue());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            execute("tuxBackOut");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("GO TO FIN-GNS-FIO-DTC");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


            logger.debug("saliendo de 'gnsFioDtc_iniGnsFioDtc()' ...");
            return "gnsFioDtc_finGnsFioDtc";
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tptypeRec.setLen(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 3000 TO LEN");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tptypeRec.setLen(3000);

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tptypeRec.getLen() :" + tptypeRec.getLen());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tptypeRec.setRecType("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE \"CARRAY\" TO REC-TYPE");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tptypeRec.setRecType("CARRAY");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tptypeRec.getRecType() :" + tptypeRec.getRecType());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tpsvcdefRec.setServiceName("                                                                                                                               ");
        //fioOracle.getFioOracleProg().setValue("      ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE FIO-ORACLE-PROG TO SERVICE-NAME");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tpsvcdefRec.setServiceName(fioOracle.getFioOracleProg().getValue());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tpsvcdefRec.getServiceName() :" + tpsvcdefRec.getServiceName());
        logger.debug("fioOracle.getFioOracleProg().getValue() :" + fioOracle.getFioOracleProg().getValue());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //logmsg.getLogmsgText().setLogmsgText1("    ");
        //fioVari.setFioCmnd(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE FIO-CMND TO LOGMSG-TEXT-1");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        logmsg.getLogmsgText().setLogmsgText1(Util.intToString(fioVari.getFioCmnd(), 4));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("logmsg.getLogmsgText().getLogmsgText1() :" + logmsg.getLogmsgText().getLogmsgText1());
        logger.debug("fioVari.getFioCmnd() :" + fioVari.getFioCmnd());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //logmsg.getLogmsgText().setLogmsgText2("      ");
        //fioOracle.getFioOracleProg().setValue("      ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE FIO-ORACLE-PROG TO LOGMSG-TEXT-2");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        logmsg.getLogmsgText().setLogmsgText2(fioOracle.getFioOracleProg().getValue());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("logmsg.getLogmsgText().getLogmsgText2() :" + logmsg.getLogmsgText().getLogmsgText2());
        logger.debug("fioOracle.getFioOracleProg().getValue() :" + fioOracle.getFioOracleProg().getValue());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //logmsg.getLogmsgText().setLogmsgText3("                                        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SPACES TO LOGMSG-TEXT-3");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        logmsg.getLogmsgText().setLogmsgText3(Util.spaces(40));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("logmsg.getLogmsgText().getLogmsgText3() :" + logmsg.getLogmsgText().getLogmsgText3());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //logmsg.setLogmsgNumb("  ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '40' TO LOGMSG-NUMB");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        logmsg.setLogmsgNumb("40");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("logmsg.getLogmsgNumb() :" + logmsg.getLogmsgNumb());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        execute("doUserlog");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tpsvcdefRec.setTpblock(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("SET TPBLOCK IN TPSVCDEF-REC TO TRUE");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tpsvcdefRec.setTpblock(true);

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tpsvcdefRec.isTpblock() :" + tpsvcdefRec.isTpblock());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tpsvcdefRec.setTptran(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("SET TPTRAN IN TPSVCDEF-REC TO TRUE");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tpsvcdefRec.setTptran(true);

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tpsvcdefRec.isTptran() :" + tpsvcdefRec.isTptran());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tpsvcdefRec.setTpnotime(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("SET TPNOTIME IN TPSVCDEF-REC TO TRUE");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tpsvcdefRec.setTpnotime(true);

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tpsvcdefRec.isTpnotime() :" + tpsvcdefRec.isTpnotime());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tpsvcdefRec.setTpsigrstrt(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("SET TPSIGRSTRT IN TPSVCDEF-REC TO TRUE");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tpsvcdefRec.setTpsigrstrt(true);

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tpsvcdefRec.isTpsigrstrt() :" + tpsvcdefRec.isTpsigrstrt());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tpsvcdefRec.setTpchange(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("SET TPCHANGE IN TPSVCDEF-REC TO TRUE");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tpsvcdefRec.setTpchange(true);

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tpsvcdefRec.isTpchange() :" + tpsvcdefRec.isTpchange());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("CALL \"TPCALL\" USING TPSVCDEF-REC TPTYPE-REC SEND-STRING-FIO TPTYPE-REC RECV-STRING-FIO TPSTATUS-REC");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        if (!tpstatusRec.isTpok()) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioOracle.getFioOracleProg().setValue("      ");
            //tpstatusRec.setTpStatus(0);
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("DISPLAY 'GNSBGDTC :' FIO-ORACLE-PROG ' ' TP-STATUS");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            logger.info("GNSBGDTC :" + fioOracle.getFioOracleProg().getValue() + " " + tpstatusRec.getTpStatus());

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("fioOracle.getFioOracleProg().getValue() :" + fioOracle.getFioOracleProg().getValue());
            logger.debug("tpstatusRec.getTpStatus() :" + tpstatusRec.getTpStatus());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioCtts.getFioMens().setValue("                                                                                ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("MOVE \"TPCALL Failed\" TO FIO-MENS");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            fioCtts.getFioMens().setValue("TPCALL Failed");

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("fioCtts.getFioMens().getValue() :" + fioCtts.getFioMens().getValue());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            execute("prgAbt");
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //logmsg.getLogmsgText().setLogmsgText1("    ");
        //fioVari.setFioCmnd(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE FIO-CMND TO LOGMSG-TEXT-1");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        logmsg.getLogmsgText().setLogmsgText1(Util.intToString(fioVari.getFioCmnd(), 4));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("logmsg.getLogmsgText().getLogmsgText1() :" + logmsg.getLogmsgText().getLogmsgText1());
        logger.debug("fioVari.getFioCmnd() :" + fioVari.getFioCmnd());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //logmsg.getLogmsgText().setLogmsgText2("      ");
        //fioOracle.getFioOracleProg().setValue("      ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE FIO-ORACLE-PROG TO LOGMSG-TEXT-2");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        logmsg.getLogmsgText().setLogmsgText2(fioOracle.getFioOracleProg().getValue());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("logmsg.getLogmsgText().getLogmsgText2() :" + logmsg.getLogmsgText().getLogmsgText2());
        logger.debug("fioOracle.getFioOracleProg().getValue() :" + fioOracle.getFioOracleProg().getValue());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //logmsg.getLogmsgText().setLogmsgText3("                                        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SPACES TO LOGMSG-TEXT-3");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        logmsg.getLogmsgText().setLogmsgText3(Util.spaces(40));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("logmsg.getLogmsgText().getLogmsgText3() :" + logmsg.getLogmsgText().getLogmsgText3());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //logmsg.setLogmsgNumb("  ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE '41' TO LOGMSG-NUMB");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        logmsg.setLogmsgNumb("41");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("logmsg.getLogmsgNumb() :" + logmsg.getLogmsgNumb());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        execute("doUserlog");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioOracle.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ");
        //recvStringFio = "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ";
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE RECV-STRING-FIO TO FIO-ORACLE");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        fioOracle.setValue(recvStringFio);

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("fioOracle.getValue() :" + fioOracle.getValue());
        logger.debug("recvStringFio :" + recvStringFio);
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //adrReqa.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ");
        //fioOracle.setFioOracleRqa("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE FIO-ORACLE-RQA TO ADR-REQA");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        adrReqa.setValue(fioOracle.getFioOracleRqa());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("adrReqa.getValue() :" + adrReqa.getValue());
        logger.debug("fioOracle.getFioOracleRqa() :" + fioOracle.getFioOracleRqa());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioCtts.setFioDfld("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ");
        //fioOracle.setFioOracleDfld("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE FIO-ORACLE-DFLD TO FIO-DFLD");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        fioCtts.setFioDfld(fioOracle.getFioOracleDfld());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("fioCtts.getFioDfld() :" + fioCtts.getFioDfld());
        logger.debug("fioOracle.getFioOracleDfld() :" + fioOracle.getFioOracleDfld());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioCtts.getFioMens().setValue("                                                                                ");
        //fioOracle.setFioOracleMens("                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE FIO-ORACLE-MENS TO FIO-MENS");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        fioCtts.getFioMens().setValue(fioOracle.getFioOracleMens());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("fioCtts.getFioMens().getValue() :" + fioCtts.getFioMens().getValue());
        logger.debug("fioOracle.getFioOracleMens() :" + fioOracle.getFioOracleMens());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioVari.setValue("                                                                                ");
        //fioOracle.setFioOracleVari("                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE FIO-ORACLE-VARI TO FIO-VARI");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        fioVari.setValue(fioOracle.getFioOracleVari());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("fioVari.getValue() :" + fioVari.getValue());
        logger.debug("fioOracle.getFioOracleVari() :" + fioOracle.getFioOracleVari());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        logger.debug("saliendo de 'gnsFioDtc_iniGnsFioDtc()' ...");

        return "gnsFioDtc_finGnsFioDtc";
    }

    /******************************************************************************
     * gnsFioDtc_finGnsFioDtc
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsFioDtc_finGnsFioDtc() {

        logger.debug("entrando a 'gnsFioDtc_finGnsFioDtc()' ...");

        logger.debug("saliendo de 'gnsFioDtc_finGnsFioDtc()' ...");

        return null;
    }

    /******************************************************************************
     * tuxBackOut
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String tuxBackOut() {

        logger.debug("entrando a 'tuxBackOut()' ...");

        execute("tuxBackOut_iniTuxBackOut");

        logger.debug("saliendo de 'tuxBackOut()' ...");

        return null;
    }

    /******************************************************************************
     * tuxBackOut_iniTuxBackOut
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String tuxBackOut_iniTuxBackOut() {

        logger.debug("entrando a 'tuxBackOut_iniTuxBackOut()' ...");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("CALL \"TPGETLEV\" USING TPTRXLEV-REC TPSTATUS-REC");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        if (!tpstatusRec.isTpok()) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //tpstatusRec.setTpStatus(0);
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("DISPLAY 'GNSBGDTC TUX-BACK-OUT TPGETLEV:' TP-STATUS");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            logger.info("GNSBGDTC TUX-BACK-OUT TPGETLEV:" + tpstatusRec.getTpStatus());

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("tpstatusRec.getTpStatus() :" + tpstatusRec.getTpStatus());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("GO TO FIN-TUX-BACK-OUT");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


            logger.debug("saliendo de 'tuxBackOut_iniTuxBackOut()' ...");
            return "tuxBackOut_finTuxBackOut";
        }
        else {

            if (tptrxlevRec.isTpNotInTran()) {

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //tpstatusRec.setTpStatus(0);
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                logger.debug("DISPLAY 'GNSBGDTC TUX-BACK-OUT TP-NOT-IN-TRAN:' TP-STATUS");
                logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

                logger.info("GNSBGDTC TUX-BACK-OUT TP-NOT-IN-TRAN:" + tpstatusRec.getTpStatus());

                logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                logger.debug("tpstatusRec.getTpStatus() :" + tpstatusRec.getTpStatus());
                logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                logger.debug("GO TO FIN-TUX-BACK-OUT");
                logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


                logger.debug("saliendo de 'tuxBackOut_iniTuxBackOut()' ...");
                return "tuxBackOut_finTuxBackOut";
            }
        }
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("CALL \"TPSUSPEND\" USING TPTRXDEF-REC TPSTATUS-REC");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        if (!tpstatusRec.isTpok()) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //tpstatusRec.setTpStatus(0);
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("DISPLAY 'GNSBGDTC TUX-BACK-OUT TPSUSPEND:' TP-STATUS");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            logger.info("GNSBGDTC TUX-BACK-OUT TPSUSPEND:" + tpstatusRec.getTpStatus());

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("tpstatusRec.getTpStatus() :" + tpstatusRec.getTpStatus());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("GO TO FIN-TUX-BACK-OUT");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


            logger.debug("saliendo de 'tuxBackOut_iniTuxBackOut()' ...");
            return "tuxBackOut_finTuxBackOut";
        }
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("CALL \"TPRESUME\" USING TPTRXDEF-REC TPSTATUS-REC");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        if (!tpstatusRec.isTpok()) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //tpstatusRec.setTpStatus(0);
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("DISPLAY 'GNSBGDTC TUX-BACK-OUT TPRESUME:' TP-STATUS");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            logger.info("GNSBGDTC TUX-BACK-OUT TPRESUME:" + tpstatusRec.getTpStatus());

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("tpstatusRec.getTpStatus() :" + tpstatusRec.getTpStatus());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("GO TO FIN-TUX-BACK-OUT");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


            logger.debug("saliendo de 'tuxBackOut_iniTuxBackOut()' ...");
            return "tuxBackOut_finTuxBackOut";
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.getTskTranid().setTskTranid1(0L);
        //tptrxdefRec.setTranid(1 - 1, 0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE TRANID( 1) TO TSK-TRANID-1");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tskVari.getTskTranid().setTskTranid1(tptrxdefRec.getTranid(1 - 1));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tskVari.getTskTranid().getTskTranid1() :" + tskVari.getTskTranid().getTskTranid1());
        logger.debug("tptrxdefRec.getTranid(1 - 1) :" + tptrxdefRec.getTranid(1 - 1));
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.getTskTranid().setTskTranid2(0L);
        //tptrxdefRec.setTranid(2 - 1, 0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE TRANID( 2) TO TSK-TRANID-2");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tskVari.getTskTranid().setTskTranid2(tptrxdefRec.getTranid(2 - 1));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tskVari.getTskTranid().getTskTranid2() :" + tskVari.getTskTranid().getTskTranid2());
        logger.debug("tptrxdefRec.getTranid(2 - 1) :" + tptrxdefRec.getTranid(2 - 1));
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.getTskTranid().setTskTranid3(0L);
        //tptrxdefRec.setTranid(3 - 1, 0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE TRANID( 3) TO TSK-TRANID-3");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tskVari.getTskTranid().setTskTranid3(tptrxdefRec.getTranid(3 - 1));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tskVari.getTskTranid().getTskTranid3() :" + tskVari.getTskTranid().getTskTranid3());
        logger.debug("tptrxdefRec.getTranid(3 - 1) :" + tptrxdefRec.getTranid(3 - 1));
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.getTskTranid().setTskTranid4(0L);
        //tptrxdefRec.setTranid(4 - 1, 0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE TRANID( 4) TO TSK-TRANID-4");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tskVari.getTskTranid().setTskTranid4(tptrxdefRec.getTranid(4 - 1));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tskVari.getTskTranid().getTskTranid4() :" + tskVari.getTskTranid().getTskTranid4());
        logger.debug("tptrxdefRec.getTranid(4 - 1) :" + tptrxdefRec.getTranid(4 - 1));
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.getTskTranid().setTskTranid5(0L);
        //tptrxdefRec.setTranid(5 - 1, 0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE TRANID( 5) TO TSK-TRANID-5");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tskVari.getTskTranid().setTskTranid5(tptrxdefRec.getTranid(5 - 1));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tskVari.getTskTranid().getTskTranid5() :" + tskVari.getTskTranid().getTskTranid5());
        logger.debug("tptrxdefRec.getTranid(5 - 1) :" + tptrxdefRec.getTranid(5 - 1));
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.getTskTranid().setTskTranid6(0L);
        //tptrxdefRec.setTranid(6 - 1, 0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE TRANID( 6) TO TSK-TRANID-6");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tskVari.getTskTranid().setTskTranid6(tptrxdefRec.getTranid(6 - 1));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tskVari.getTskTranid().getTskTranid6() :" + tskVari.getTskTranid().getTskTranid6());
        logger.debug("tptrxdefRec.getTranid(6 - 1) :" + tptrxdefRec.getTranid(6 - 1));
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.setTskTermTux("                                                                                                                                                                                                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SPACES TO TSK-TERM-TUX");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tskVari.setTskTermTux(Util.spaces(256));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tskVari.getTskTermTux() :" + tskVari.getTskTermTux());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.setTskTermTux("                                                                                                                                                                                                                                                                ");
        //tskVari.setTskTranidAlf("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE TSK-TRANID-ALF TO TSK-TERM-TUX");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tskVari.setTskTermTux(tskVari.getTskTranidAlf());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tskVari.getTskTermTux() :" + tskVari.getTskTermTux());
        logger.debug("tskVari.getTskTranidAlf() :" + tskVari.getTskTranidAlf());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueComSend("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'GET' TO QUE-COM-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueComSend("GET");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueComSend() :" + queSend.getQueComSend());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNamSend("                                                                                                                                                                                                                                                                                                            ");
        //tskVari.setTskTermTux("                                                                                                                                                                                                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE TSK-TERM-TUX TO QUE-NAM-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueNamSend(tskVari.getTskTermTux());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueNamSend() :" + queSend.getQueNamSend());
        logger.debug("tskVari.getTskTermTux() :" + tskVari.getTskTermTux());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNumSend(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 1 TO QUE-NUM-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueNumSend(1);

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueNumSend() :" + queSend.getQueNumSend());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueLarSend(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 4 TO QUE-LAR-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueLarSend(4);

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueLarSend() :" + queSend.getQueLarSend());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueTrxSend("                                                                                                                                                                                                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SPACES TO QUE-TRX-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueTrxSend(Util.spaces(256));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueTrxSend() :" + queSend.getQueTrxSend());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueDatSend("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SPACES TO QUE-DAT-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueDatSend(Util.spaces(9000));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueDatSend() :" + queSend.getQueDatSend());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        execute("gnsMsjQue");

        if (!queVari.getQueStat().equals(queVari.getQueStatOks())) {
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("GO TO FIN-TUX-BACK-OUT");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


            logger.debug("saliendo de 'tuxBackOut_iniTuxBackOut()' ...");
            return "tuxBackOut_finTuxBackOut";
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queVari.getQueItem().setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   ");
        //queRecv.setQueDatRecv("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE QUE-DAT-RECV TO QUE-ITEM");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queVari.getQueItem().setValue(queRecv.getQueDatRecv());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queVari.getQueItem().getValue() :" + queVari.getQueItem().getValue());
        logger.debug("queRecv.getQueDatRecv() :" + queRecv.getQueDatRecv());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.getTskInfoTran().setValue("        ");
        //queVari.getQueItem().setQueData("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE QUE-DATA TO TSK-INFO-TRAN");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tskVari.getTskInfoTran().setValue(queVari.getQueItem().getQueData());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tskVari.getTskInfoTran().getValue() :" + tskVari.getTskInfoTran().getValue());
        logger.debug("queVari.getQueItem().getQueData() :" + queVari.getQueItem().getQueData());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.getTskInfoTran().setTskInfoCommit(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 1 TO TSK-INFO-COMMIT");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tskVari.getTskInfoTran().setTskInfoCommit(1);

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tskVari.getTskInfoTran().getTskInfoCommit() :" + tskVari.getTskInfoTran().getTskInfoCommit());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueComSend("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'MOD' TO QUE-COM-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueComSend("MOD");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueComSend() :" + queSend.getQueComSend());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNamSend("                                                                                                                                                                                                                                                                                                            ");
        //tskVari.setTskTermTux("                                                                                                                                                                                                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE TSK-TERM-TUX TO QUE-NAM-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueNamSend(tskVari.getTskTermTux());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueNamSend() :" + queSend.getQueNamSend());
        logger.debug("tskVari.getTskTermTux() :" + tskVari.getTskTermTux());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNumSend(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 1 TO QUE-NUM-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueNumSend(1);

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueNumSend() :" + queSend.getQueNumSend());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueLarSend(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 4 TO QUE-LAR-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueLarSend(4);

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueLarSend() :" + queSend.getQueLarSend());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueTrxSend("                                                                                                                                                                                                                                                                ");
        //tskVari.getTskInfoTran().setTskInfoTranidAlf("       ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE TSK-INFO-TRANID-ALF TO QUE-TRX-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueTrxSend(tskVari.getTskInfoTran().getTskInfoTranidAlf());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueTrxSend() :" + queSend.getQueTrxSend());
        logger.debug("tskVari.getTskInfoTran().getTskInfoTranidAlf() :" + tskVari.getTskInfoTran().getTskInfoTranidAlf());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queVari.getQueItem().setQueData("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ");
        //tskVari.getTskInfoTran().setValue("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE TSK-INFO-TRAN TO QUE-DATA");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queVari.getQueItem().setQueData(tskVari.getTskInfoTran().getValue());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queVari.getQueItem().getQueData() :" + queVari.getQueItem().getQueData());
        logger.debug("tskVari.getTskInfoTran().getValue() :" + tskVari.getTskInfoTran().getValue());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueDatSend("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ");
        //queVari.getQueItem().setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE QUE-ITEM TO QUE-DAT-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueDatSend(queVari.getQueItem().getValue());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueDatSend() :" + queSend.getQueDatSend());
        logger.debug("queVari.getQueItem().getValue() :" + queVari.getQueItem().getValue());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        execute("gnsMsjQue");

        logger.debug("saliendo de 'tuxBackOut_iniTuxBackOut()' ...");

        return "tuxBackOut_finTuxBackOut";
    }

    /******************************************************************************
     * tuxBackOut_finTuxBackOut
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String tuxBackOut_finTuxBackOut() {

        logger.debug("entrando a 'tuxBackOut_finTuxBackOut()' ...");

        logger.debug("saliendo de 'tuxBackOut_finTuxBackOut()' ...");

        return null;
    }

    /******************************************************************************
     * gnsChkQueu
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsChkQueu() {

        logger.debug("entrando a 'gnsChkQueu()' ...");

        execute("gnsChkQueu_iniGnsChkQueu");

        logger.debug("saliendo de 'gnsChkQueu()' ...");

        return null;
    }

    /******************************************************************************
     * gnsChkQueu_iniGnsChkQueu
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsChkQueu_iniGnsChkQueu() {

        logger.debug("entrando a 'gnsChkQueu_iniGnsChkQueu()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queVari.setQueNitm(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 1 TO QUE-NITM");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queVari.setQueNitm(1);

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queVari.getQueNitm() :" + queVari.getQueNitm());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queVari.setQueCmnd("   ");
        //queCtts.setQueGet("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE QUE-GET TO QUE-CMND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queVari.setQueCmnd(queCtts.getQueGet());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queVari.getQueCmnd() :" + queVari.getQueCmnd());
        logger.debug("queCtts.getQueGet() :" + queCtts.getQueGet());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        execute("gnsProQue");

        logger.debug("saliendo de 'gnsChkQueu_iniGnsChkQueu()' ...");

        return "gnsChkQueu_finGnsChkQueu";
    }

    /******************************************************************************
     * gnsChkQueu_finGnsChkQueu
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsChkQueu_finGnsChkQueu() {

        logger.debug("entrando a 'gnsChkQueu_finGnsChkQueu()' ...");

        logger.debug("saliendo de 'gnsChkQueu_finGnsChkQueu()' ...");

        return null;
    }

    /******************************************************************************
     * gnsQueEoq
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsQueEoq() {

        logger.debug("entrando a 'gnsQueEoq()' ...");

        execute("gnsQueEoq_iniGnsQueEoq");

        logger.debug("saliendo de 'gnsQueEoq()' ...");

        return null;
    }

    /******************************************************************************
     * gnsQueEoq_iniGnsQueEoq
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsQueEoq_iniGnsQueEoq() {

        logger.debug("entrando a 'gnsQueEoq_iniGnsQueEoq()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queVari.setQueStat("   ");
        //queVari.setQueStatEoq("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE QUE-STAT-EOQ TO QUE-STAT");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queVari.setQueStat(queVari.getQueStatEoq());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queVari.getQueStat() :" + queVari.getQueStat());
        logger.debug("queVari.getQueStatEoq() :" + queVari.getQueStatEoq());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("GO TO FIN-GNS-PRO-QUE");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


        logger.debug("saliendo de 'gnsQueEoq_iniGnsQueEoq()' ...");
        return "gnsProQue_finGnsProQue";
    }

    /******************************************************************************
     * gnsQueEoq_finGnsQueEoq
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsQueEoq_finGnsQueEoq() {

        logger.debug("entrando a 'gnsQueEoq_finGnsQueEoq()' ...");

        logger.debug("saliendo de 'gnsQueEoq_finGnsQueEoq()' ...");

        return null;
    }

    /******************************************************************************
     * gnsQueNex
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsQueNex() {

        logger.debug("entrando a 'gnsQueNex()' ...");

        execute("gnsQueNex_iniGnsQueNex");

        logger.debug("saliendo de 'gnsQueNex()' ...");

        return null;
    }

    /******************************************************************************
     * gnsQueNex_iniGnsQueNex
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsQueNex_iniGnsQueNex() {

        logger.debug("entrando a 'gnsQueNex_iniGnsQueNex()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queVari.setQueStat("   ");
        //queVari.setQueStatNex("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE QUE-STAT-NEX TO QUE-STAT");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queVari.setQueStat(queVari.getQueStatNex());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queVari.getQueStat() :" + queVari.getQueStat());
        logger.debug("queVari.getQueStatNex() :" + queVari.getQueStatNex());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("GO TO FIN-GNS-PRO-QUE");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


        logger.debug("saliendo de 'gnsQueNex_iniGnsQueNex()' ...");
        return "gnsProQue_finGnsProQue";
    }

    /******************************************************************************
     * gnsQueNex_finGnsQueNex
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsQueNex_finGnsQueNex() {

        logger.debug("entrando a 'gnsQueNex_finGnsQueNex()' ...");

        logger.debug("saliendo de 'gnsQueNex_finGnsQueNex()' ...");

        return null;
    }

    /******************************************************************************
     * gnsErrQue
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsErrQue() {

        logger.debug("entrando a 'gnsErrQue()' ...");

        execute("gnsErrQue_iniGnsErrQue");

        logger.debug("saliendo de 'gnsErrQue()' ...");

        return null;
    }

    /******************************************************************************
     * gnsErrQue_iniGnsErrQue
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsErrQue_iniGnsErrQue() {

        logger.debug("entrando a 'gnsErrQue_iniGnsErrQue()' ...");

        logger.debug("saliendo de 'gnsErrQue_iniGnsErrQue()' ...");

        return "gnsErrQue_finGnsErrQue";
    }

    /******************************************************************************
     * gnsErrQue_finGnsErrQue
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsErrQue_finGnsErrQue() {

        logger.debug("entrando a 'gnsErrQue_finGnsErrQue()' ...");

        logger.debug("saliendo de 'gnsErrQue_finGnsErrQue()' ...");

        return null;
    }

    /******************************************************************************
     * gnsProQue
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsProQue() {

        logger.debug("entrando a 'gnsProQue()' ...");

        execute("gnsProQue_iniGnsProQue");

        logger.debug("saliendo de 'gnsProQue()' ...");

        return null;
    }

    /******************************************************************************
     * gnsProQue_iniGnsProQue
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsProQue_iniGnsProQue() {

        logger.debug("entrando a 'gnsProQue_iniGnsProQue()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queVari.setQueStat("   ");
        //queVari.setQueStatOks("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE QUE-STAT-OKS TO QUE-STAT");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queVari.setQueStat(queVari.getQueStatOks());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queVari.getQueStat() :" + queVari.getQueStat());
        logger.debug("queVari.getQueStatOks() :" + queVari.getQueStatOks());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        if (queVari.getQueCmnd().equals(queCtts.getQuePut())) {
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("GO TO GNS-PUT-QUE");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


            logger.debug("saliendo de 'gnsProQue_iniGnsProQue()' ...");
            return "gnsProQue_gnsPutQue";
        }
        else {

            if (queVari.getQueCmnd().equals(queCtts.getQueGet())) {
                logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                logger.debug("GO TO GNS-GET-QUE");
                logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


                logger.debug("saliendo de 'gnsProQue_iniGnsProQue()' ...");
                return "gnsProQue_gnsGetQue";
            }
            else {

                if (queVari.getQueCmnd().equals(queCtts.getQueMod())) {
                    logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                    logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                    logger.debug("GO TO GNS-MOD-QUE");
                    logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


                    logger.debug("saliendo de 'gnsProQue_iniGnsProQue()' ...");
                    return "gnsProQue_gnsModQue";
                }
                else {

                    if (queVari.getQueCmnd().equals(queCtts.getQueDel())) {
                        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                        logger.debug("GO TO GNS-DEL-QUE");
                        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


                        logger.debug("saliendo de 'gnsProQue_iniGnsProQue()' ...");
                        return "gnsProQue_gnsDelQue";
                    }
                }
            }
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queVari.getQueMens().setQueMen1("                                        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'Comando invalido :' TO QUE-MEN1");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queVari.getQueMens().setQueMen1("Comando invalido :");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queVari.getQueMens().getQueMen1() :" + queVari.getQueMens().getQueMen1());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queVari.getQueMens().setQueMen2("                                       ");
        //queVari.setQueCmnd("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE QUE-CMND TO QUE-MEN2");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queVari.getQueMens().setQueMen2(queVari.getQueCmnd());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queVari.getQueMens().getQueMen2() :" + queVari.getQueMens().getQueMen2());
        logger.debug("queVari.getQueCmnd() :" + queVari.getQueCmnd());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioCtts.getFioMens().setValue("                                                                                ");
        //queVari.getQueMens().setValue("                                                                               ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE QUE-MENS TO FIO-MENS");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        fioCtts.getFioMens().setValue(queVari.getQueMens().getValue());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("fioCtts.getFioMens().getValue() :" + fioCtts.getFioMens().getValue());
        logger.debug("queVari.getQueMens().getValue() :" + queVari.getQueMens().getValue());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tptypeRec.setLen(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE + 79 TO LEN");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tptypeRec.setLen(+79);

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tptypeRec.getLen() :" + tptypeRec.getLen());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tptypeRec.setRecType("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE \"CARRAY\" TO REC-TYPE");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tptypeRec.setRecType("CARRAY");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tptypeRec.getRecType() :" + tptypeRec.getRecType());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tpsvcdefRec.setServiceName("                                                                                                                               ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE 'GNSPPABT' TO SERVICE-NAME");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        tpsvcdefRec.setServiceName("GNSPPABT");

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("tpsvcdefRec.getServiceName() :" + tpsvcdefRec.getServiceName());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("CALL \"TPFORWARD\" USING TPSVCDEF-REC TPTYPE-REC QUE-MENS TPSTATUS-REC");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        System.exit(returnCode);

        logger.debug("saliendo de 'gnsProQue_iniGnsProQue()' ...");

        return null;
    }

    /******************************************************************************
     * gnsProQue_gnsPutQue
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsProQue_gnsPutQue() {

        logger.debug("entrando a 'gnsProQue_gnsPutQue()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueComSend("   ");
        //queVari.setQueCmnd("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE QUE-CMND TO QUE-COM-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueComSend(queVari.getQueCmnd());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueComSend() :" + queSend.getQueComSend());
        logger.debug("queVari.getQueCmnd() :" + queVari.getQueCmnd());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNamSend("                                                                                                                                                                                                                                                                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SPACES TO QUE-NAM-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueNamSend(Util.spaces(300));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueNamSend() :" + queSend.getQueNamSend());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNamSend("                                                                                                                                                                                                                                                                                                            ");
        //queVari.getQueCola().setValue("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE QUE-COLA TO QUE-NAM-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueNamSend(queVari.getQueCola().getValue());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueNamSend() :" + queSend.getQueNamSend());
        logger.debug("queVari.getQueCola().getValue() :" + queVari.getQueCola().getValue());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNumSend(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE ZEROES TO QUE-NUM-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueNumSend(0);

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueNumSend() :" + queSend.getQueNumSend());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueLarSend(0);
        //queVari.setQueLitm(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE QUE-LITM TO QUE-LAR-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueLarSend(queVari.getQueLitm());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueLarSend() :" + queSend.getQueLarSend());
        logger.debug("queVari.getQueLitm() :" + queVari.getQueLitm());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueTrxSend("                                                                                                                                                                                                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SPACES TO QUE-TRX-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueTrxSend(Util.spaces(256));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueTrxSend() :" + queSend.getQueTrxSend());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueTrxSend("                                                                                                                                                                                                                                                                ");
        //tskVari.setTskTermAlf("    ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE TSK-TERM-ALF TO QUE-TRX-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueTrxSend(tskVari.getTskTermAlf());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueTrxSend() :" + queSend.getQueTrxSend());
        logger.debug("tskVari.getTskTermAlf() :" + tskVari.getTskTermAlf());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueDatSend("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ");
        //queVari.getQueItem().setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE QUE-ITEM TO QUE-DAT-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueDatSend(queVari.getQueItem().getValue());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueDatSend() :" + queSend.getQueDatSend());
        logger.debug("queVari.getQueItem().getValue() :" + queVari.getQueItem().getValue());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        execute("gnsMsjQue");

        logger.debug("saliendo de 'gnsProQue_gnsPutQue()' ...");

        return "gnsProQue_finGnsPutQue";
    }

    /******************************************************************************
     * gnsProQue_finGnsPutQue
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsProQue_finGnsPutQue() {

        logger.debug("entrando a 'gnsProQue_finGnsPutQue()' ...");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("GO TO FIN-GNS-PRO-QUE");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


        logger.debug("saliendo de 'gnsProQue_finGnsPutQue()' ...");
        return "gnsProQue_finGnsProQue";
    }

    /******************************************************************************
     * gnsProQue_gnsGetQue
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsProQue_gnsGetQue() {

        logger.debug("entrando a 'gnsProQue_gnsGetQue()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueComSend("   ");
        //queVari.setQueCmnd("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE QUE-CMND TO QUE-COM-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueComSend(queVari.getQueCmnd());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueComSend() :" + queSend.getQueComSend());
        logger.debug("queVari.getQueCmnd() :" + queVari.getQueCmnd());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNamSend("                                                                                                                                                                                                                                                                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SPACES TO QUE-NAM-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueNamSend(Util.spaces(300));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueNamSend() :" + queSend.getQueNamSend());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNamSend("                                                                                                                                                                                                                                                                                                            ");
        //queVari.getQueCola().setValue("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE QUE-COLA TO QUE-NAM-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueNamSend(queVari.getQueCola().getValue());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueNamSend() :" + queSend.getQueNamSend());
        logger.debug("queVari.getQueCola().getValue() :" + queVari.getQueCola().getValue());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNumSend(0);
        //queVari.setQueNitm(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE QUE-NITM TO QUE-NUM-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueNumSend(queVari.getQueNitm());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueNumSend() :" + queSend.getQueNumSend());
        logger.debug("queVari.getQueNitm() :" + queVari.getQueNitm());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueLarSend(0);
        //queVari.setQueLitm(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE QUE-LITM TO QUE-LAR-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueLarSend(queVari.getQueLitm());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueLarSend() :" + queSend.getQueLarSend());
        logger.debug("queVari.getQueLitm() :" + queVari.getQueLitm());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueTrxSend("                                                                                                                                                                                                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SPACES TO QUE-TRX-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueTrxSend(Util.spaces(256));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueTrxSend() :" + queSend.getQueTrxSend());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueTrxSend("                                                                                                                                                                                                                                                                ");
        //tskVari.setTskTermAlf("    ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE TSK-TERM-ALF TO QUE-TRX-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueTrxSend(tskVari.getTskTermAlf());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueTrxSend() :" + queSend.getQueTrxSend());
        logger.debug("tskVari.getTskTermAlf() :" + tskVari.getTskTermAlf());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueDatSend("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SPACES TO QUE-DAT-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueDatSend(Util.spaces(9000));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueDatSend() :" + queSend.getQueDatSend());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        execute("gnsMsjQue");

        logger.debug("saliendo de 'gnsProQue_gnsGetQue()' ...");

        return "gnsProQue_finGnsGetQue";
    }

    /******************************************************************************
     * gnsProQue_finGnsGetQue
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsProQue_finGnsGetQue() {

        logger.debug("entrando a 'gnsProQue_finGnsGetQue()' ...");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("GO TO FIN-GNS-PRO-QUE");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


        logger.debug("saliendo de 'gnsProQue_finGnsGetQue()' ...");
        return "gnsProQue_finGnsProQue";
    }

    /******************************************************************************
     * gnsProQue_gnsModQue
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsProQue_gnsModQue() {

        logger.debug("entrando a 'gnsProQue_gnsModQue()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueComSend("   ");
        //queVari.setQueCmnd("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE QUE-CMND TO QUE-COM-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueComSend(queVari.getQueCmnd());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueComSend() :" + queSend.getQueComSend());
        logger.debug("queVari.getQueCmnd() :" + queVari.getQueCmnd());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNamSend("                                                                                                                                                                                                                                                                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SPACES TO QUE-NAM-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueNamSend(Util.spaces(300));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueNamSend() :" + queSend.getQueNamSend());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNamSend("                                                                                                                                                                                                                                                                                                            ");
        //queVari.getQueCola().setValue("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE QUE-COLA TO QUE-NAM-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueNamSend(queVari.getQueCola().getValue());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueNamSend() :" + queSend.getQueNamSend());
        logger.debug("queVari.getQueCola().getValue() :" + queVari.getQueCola().getValue());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNumSend(0);
        //queVari.setQueNitm(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE QUE-NITM TO QUE-NUM-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueNumSend(queVari.getQueNitm());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueNumSend() :" + queSend.getQueNumSend());
        logger.debug("queVari.getQueNitm() :" + queVari.getQueNitm());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueLarSend(0);
        //queVari.setQueLitm(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE QUE-LITM TO QUE-LAR-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueLarSend(queVari.getQueLitm());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueLarSend() :" + queSend.getQueLarSend());
        logger.debug("queVari.getQueLitm() :" + queVari.getQueLitm());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueTrxSend("                                                                                                                                                                                                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SPACES TO QUE-TRX-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueTrxSend(Util.spaces(256));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueTrxSend() :" + queSend.getQueTrxSend());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueTrxSend("                                                                                                                                                                                                                                                                ");
        //tskVari.setTskTermAlf("    ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE TSK-TERM-ALF TO QUE-TRX-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueTrxSend(tskVari.getTskTermAlf());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueTrxSend() :" + queSend.getQueTrxSend());
        logger.debug("tskVari.getTskTermAlf() :" + tskVari.getTskTermAlf());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueDatSend("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ");
        //queVari.getQueItem().setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE QUE-ITEM TO QUE-DAT-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueDatSend(queVari.getQueItem().getValue());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueDatSend() :" + queSend.getQueDatSend());
        logger.debug("queVari.getQueItem().getValue() :" + queVari.getQueItem().getValue());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        execute("gnsMsjQue");

        logger.debug("saliendo de 'gnsProQue_gnsModQue()' ...");

        return "gnsProQue_finGnsModQue";
    }

    /******************************************************************************
     * gnsProQue_finGnsModQue
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsProQue_finGnsModQue() {

        logger.debug("entrando a 'gnsProQue_finGnsModQue()' ...");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("GO TO FIN-GNS-PRO-QUE");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


        logger.debug("saliendo de 'gnsProQue_finGnsModQue()' ...");
        return "gnsProQue_finGnsProQue";
    }

    /******************************************************************************
     * gnsProQue_gnsDelQue
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsProQue_gnsDelQue() {

        logger.debug("entrando a 'gnsProQue_gnsDelQue()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueComSend("   ");
        //queVari.setQueCmnd("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE QUE-CMND TO QUE-COM-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueComSend(queVari.getQueCmnd());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueComSend() :" + queSend.getQueComSend());
        logger.debug("queVari.getQueCmnd() :" + queVari.getQueCmnd());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNamSend("                                                                                                                                                                                                                                                                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SPACES TO QUE-NAM-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueNamSend(Util.spaces(300));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueNamSend() :" + queSend.getQueNamSend());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNamSend("                                                                                                                                                                                                                                                                                                            ");
        //queVari.getQueCola().setValue("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE QUE-COLA TO QUE-NAM-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueNamSend(queVari.getQueCola().getValue());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueNamSend() :" + queSend.getQueNamSend());
        logger.debug("queVari.getQueCola().getValue() :" + queVari.getQueCola().getValue());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNumSend(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE ZEROES TO QUE-NUM-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueNumSend(0);

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueNumSend() :" + queSend.getQueNumSend());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueLarSend(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE ZEROES TO QUE-LAR-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueLarSend(0);

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueLarSend() :" + queSend.getQueLarSend());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueTrxSend("                                                                                                                                                                                                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SPACES TO QUE-TRX-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueTrxSend(Util.spaces(256));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueTrxSend() :" + queSend.getQueTrxSend());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueTrxSend("                                                                                                                                                                                                                                                                ");
        //tskVari.setTskTermAlf("    ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE TSK-TERM-ALF TO QUE-TRX-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueTrxSend(tskVari.getTskTermAlf());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueTrxSend() :" + queSend.getQueTrxSend());
        logger.debug("tskVari.getTskTermAlf() :" + tskVari.getTskTermAlf());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueDatSend("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SPACES TO QUE-DAT-SEND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queSend.setQueDatSend(Util.spaces(9000));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queSend.getQueDatSend() :" + queSend.getQueDatSend());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        execute("gnsMsjQue");

        logger.debug("saliendo de 'gnsProQue_gnsDelQue()' ...");

        return "gnsProQue_finGnsDelQue";
    }

    /******************************************************************************
     * gnsProQue_finGnsDelQue
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsProQue_finGnsDelQue() {

        logger.debug("entrando a 'gnsProQue_finGnsDelQue()' ...");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("GO TO FIN-GNS-PRO-QUE");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


        logger.debug("saliendo de 'gnsProQue_finGnsDelQue()' ...");
        return "gnsProQue_finGnsProQue";
    }

    /******************************************************************************
     * gnsProQue_finGnsProQue
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsProQue_finGnsProQue() {

        logger.debug("entrando a 'gnsProQue_finGnsProQue()' ...");

        logger.debug("saliendo de 'gnsProQue_finGnsProQue()' ...");

        return null;
    }

    /******************************************************************************
     * gnsMsjQue
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsMsjQue() {

        logger.debug("entrando a 'gnsMsjQue()' ...");

        execute("gnsMsjQue_iniGnsMsjQue");

        logger.debug("saliendo de 'gnsMsjQue()' ...");

        return null;
    }

    /******************************************************************************
     * gnsMsjQue_iniGnsMsjQue
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsMsjQue_iniGnsMsjQue() {

        logger.debug("entrando a 'gnsMsjQue_iniGnsMsjQue()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queTpsvcdefRec.setQueTptran(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("SET QUE-TPTRAN TO TRUE");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queTpsvcdefRec.setQueTptran(true);

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queTpsvcdefRec.isQueTptran() :" + queTpsvcdefRec.isQueTptran());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queTpsvcdefRec.setQueTpblock(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("SET QUE-TPBLOCK TO TRUE");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queTpsvcdefRec.setQueTpblock(true);

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queTpsvcdefRec.isQueTpblock() :" + queTpsvcdefRec.isQueTpblock());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queTpsvcdefRec.setQueTpnotime(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("SET QUE-TPNOTIME TO TRUE");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queTpsvcdefRec.setQueTpnotime(true);

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queTpsvcdefRec.isQueTpnotime() :" + queTpsvcdefRec.isQueTpnotime());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queTpsvcdefRec.setQueTpsigrstrt(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("SET QUE-TPSIGRSTRT TO TRUE");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queTpsvcdefRec.setQueTpsigrstrt(true);

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queTpsvcdefRec.isQueTpsigrstrt() :" + queTpsvcdefRec.isQueTpsigrstrt());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queTpsvcdefRec.setQueTpchange(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("SET QUE-TPCHANGE TO TRUE");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queTpsvcdefRec.setQueTpchange(true);

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queTpsvcdefRec.isQueTpchange() :" + queTpsvcdefRec.isQueTpchange());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queRecv.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SPACES TO QUE-RECV");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        queRecv.setValue(Util.spaces(9284));

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("queRecv.getValue() :" + queRecv.getValue());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("CALL \"TPCALL\" USING QUE-TPSVCDEF-REC QUE-TPTYPE-REC-SEND QUE-SEND QUE-TPTYPE-REC-RECV QUE-RECV TPSTATUS-REC");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        if (!tpstatusRec.isTpok()) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //queVari.setQueStat("   ");
            //queVari.setQueStatNex("   ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("MOVE QUE-STAT-NEX TO QUE-STAT");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            queVari.setQueStat(queVari.getQueStatNex());

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("queVari.getQueStat() :" + queVari.getQueStat());
            logger.debug("queVari.getQueStatNex() :" + queVari.getQueStatNex());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //tpstatusRec.setTpStatus(0);
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("DISPLAY 'TEMPORAL STORAGE :' TP-STATUS");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            logger.info("TEMPORAL STORAGE :" + tpstatusRec.getTpStatus());

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("tpstatusRec.getTpStatus() :" + tpstatusRec.getTpStatus());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //queNumStat = 0;
            //tpstatusRec.setTpStatus(0);
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("MOVE TP-STATUS TO QUE-NUM-STAT");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            queNumStat = tpstatusRec.getTpStatus();

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("queNumStat :" + queNumStat);
            logger.debug("tpstatusRec.getTpStatus() :" + tpstatusRec.getTpStatus());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //queGlsStat = 0;
            //queNumStat = 0;
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("MOVE QUE-NUM-STAT TO QUE-GLS-STAT");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            queGlsStat = queNumStat;

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("queGlsStat :" + queGlsStat);
            logger.debug("queNumStat :" + queNumStat);
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }
        else {

            if (queRecv.getQueStaRecv() == 0) {

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //queVari.setQueStat("   ");
                //queVari.setQueStatOks("   ");
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                logger.debug("MOVE QUE-STAT-OKS TO QUE-STAT");
                logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

                queVari.setQueStat(queVari.getQueStatOks());

                logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                logger.debug("queVari.getQueStat() :" + queVari.getQueStat());
                logger.debug("queVari.getQueStatOks() :" + queVari.getQueStatOks());
                logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //queVari.getQueItem().setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   ");
                //queRecv.setQueDatRecv("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ");
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                logger.debug("MOVE QUE-DAT-RECV TO QUE-ITEM");
                logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

                queVari.getQueItem().setValue(queRecv.getQueDatRecv());

                logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                logger.debug("queVari.getQueItem().getValue() :" + queVari.getQueItem().getValue());
                logger.debug("queRecv.getQueDatRecv() :" + queRecv.getQueDatRecv());
                logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            }
            else {

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //queVari.setQueStat("   ");
                //queVari.setQueStatNex("   ");
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                logger.debug("MOVE QUE-STAT-NEX TO QUE-STAT");
                logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

                queVari.setQueStat(queVari.getQueStatNex());

                logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                logger.debug("queVari.getQueStat() :" + queVari.getQueStat());
                logger.debug("queVari.getQueStatNex() :" + queVari.getQueStatNex());
                logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            }
        }

        logger.debug("saliendo de 'gnsMsjQue_iniGnsMsjQue()' ...");

        return "gnsMsjQue_finGnsMsjQue";
    }

    /******************************************************************************
     * gnsMsjQue_finGnsMsjQue
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsMsjQue_finGnsMsjQue() {

        logger.debug("entrando a 'gnsMsjQue_finGnsMsjQue()' ...");

        logger.debug("saliendo de 'gnsMsjQue_finGnsMsjQue()' ...");

        return null;
    }

    /******************************************************************************
     * prgAbt
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String prgAbt() {

        logger.debug("entrando a 'prgAbt()' ...");

        execute("prgAbt_iniPrgAbt");

        logger.debug("saliendo de 'prgAbt()' ...");

        return null;
    }

    /******************************************************************************
     * prgAbt_iniPrgAbt
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String prgAbt_iniPrgAbt() {

        logger.debug("entrando a 'prgAbt_iniPrgAbt()' ...");

        if (frmVari.getFrmMens().compareTo(Util.spaces(79)) > 0 && fioCtts.getFioMens().getValue().compareTo(Util.spaces(80)) <= 0) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioCtts.getFioMens().setValue("                                                                                ");
            //frmVari.setFrmMens("                                                                               ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("MOVE FRM-MENS TO FIO-MENS");
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

            fioCtts.getFioMens().setValue(frmVari.getFrmMens());

            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            logger.debug("fioCtts.getFioMens().getValue() :" + fioCtts.getFioMens().getValue());
            logger.debug("frmVari.getFrmMens() :" + frmVari.getFrmMens());
            logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.getSysMens().setValue("                                                                                ");
        //fioCtts.getFioMens().setValue("                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE FIO-MENS TO SYS-MENS");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.getSysMens().setValue(fioCtts.getFioMens().getValue());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysMens().getValue() :" + sysVari.getSysMens().getValue());
        logger.debug("fioCtts.getFioMens().getValue() :" + fioCtts.getFioMens().getValue());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sysVari.setSysCmnd(0);
        //sysCtts.setSysAbor(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% cobol %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("MOVE SYS-ABOR TO SYS-CMND");
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        sysVari.setSysCmnd(sysCtts.getSysAbor());

        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("%%%% getter %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        logger.debug("sysVari.getSysCmnd() :" + sysVari.getSysCmnd());
        logger.debug("sysCtts.getSysAbor() :" + sysCtts.getSysAbor());
        logger.debug("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        execute("gnsProSys");

        logger.debug("saliendo de 'prgAbt_iniPrgAbt()' ...");

        return "prgAbt_finPrgAbt";
    }

    /******************************************************************************
     * prgAbt_finPrgAbt
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String prgAbt_finPrgAbt() {

        logger.debug("entrando a 'prgAbt_finPrgAbt()' ...");

        logger.debug("saliendo de 'prgAbt_finPrgAbt()' ...");

        return null;
    }

    /******************************************************************************
     * printStackTrace
     ******************************************************************************/
    /**
     *
     * @param e TODO_javadoc
     *
     * @return TODO_javadoc
     */
    private static String printStackTrace(Throwable e) {

        CharArrayWriter caw = new CharArrayWriter();
        e.printStackTrace(new PrintWriter(caw));

        return caw.toString();
    }
}
