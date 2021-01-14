/*
 *   Copyright (c) 2021 by BEE S.A. All Rights Reserved.
 *   THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF BEE S.A.
 *   The copyright notice above does not evidence any actual or intended
 *   publication of such source code.
 */
package cl.bee.beebank.cloud.core.gns.gnsppcpm;


import java.io.*;

import java.lang.reflect.*;

import java.util.*;

import org.apache.log4j.*;

import cl.bee.beebank.cloud.core.gns.Util;
import cl.bee.beebank.cloud.core.gns.gnsppcpm.*;


/**
 *
 * TODO_javadoc.
 *
 * @version 1.0 (12/01/2021).
 *
 */
public class Gnsppcpm {

    /** TODO_javadoc. */
    private static Logger logger = Logger.getLogger(Gnsppcpm.class);

    /** TODO_javadoc. */
    private int returnCode = 0;

    //

    /** WSS-TAG-GNSPPCPM. */
    private String wssTagGnsppcpm = "<IDNPGM NOM=$GNSPPCPM$ SKL=$08.04.10$ VSN=$08.04.10$GEN=$10-ABR-08 19:15 PM$ FNC=$MK2TFL$/>                                  ";

    /** TPINFDEF-REC. */
    private TpinfdefRec tpinfdefRec = new TpinfdefRec();

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

    /** USER-DATA-REC. */
    private String userDataRec;

    /** ADR-MNU-REQA. */
    private AdrMnuReqa adrMnuReqa = new AdrMnuReqa();

    /** ADR-RPF-REQA. */
    private AdrRpfReqa adrRpfReqa = new AdrRpfReqa();

    /** ADR-TAB-REQA. */
    private AdrTabReqa adrTabReqa = new AdrTabReqa();

    /** ADR-IDD-REQA. */
    private AdrIddReqa adrIddReqa = new AdrIddReqa();

    /** MNU. */
    private Mnu mnu = new Mnu();

    /** MNU-VARI. */
    private MnuVari mnuVari = new MnuVari();

    /** RPF. */
    private Rpf rpf = new Rpf();

    /** TAB. */
    private Tab tab = new Tab();

    /** TAB-VARI. */
    private TabVari tabVari = new TabVari();

    /** ADR-REQA. */
    private AdrReqa adrReqa = new AdrReqa();

    /** ADR-UIFB. */
    private AdrUifb adrUifb = new AdrUifb();

    /** ADR-ELLS. */
    private AdrElls adrElls = new AdrElls();

    /** IDD. */
    private Idd idd = new Idd();

    /** IDD-VARI. */
    private IddVari iddVari = new IddVari();

    /** FIO-CTTS. */
    private FioCtts fioCtts = new FioCtts();

    /** FIO-ORACLE. */
    private FioOracle fioOracle = new FioOracle();

    /** RECV-STRING-FIO. */
    private String recvStringFio;

    /** SEND-STRING-FIO. */
    private String sendStringFio;

    /** FIO-VARI. */
    private FioVari fioVari = new FioVari();

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

    /** WSS-SWI-CRGA. */
    private String wssSwiCrga = "C";

    /** BUF-ACP. */
    private BufAcp bufAcp = new BufAcp();

    /** WSS-MNU. */
    private WssMnu wssMnu = new WssMnu();

    /** WSS-TOT. */
    private WssTot wssTot = new WssTot();

    /** WSS-RPF. */
    private WssRpf wssRpf = new WssRpf();

    /** WSS-TAB. */
    private WssTab wssTab = new WssTab();

    /** WSS-MEN1. */
    private WssMen1 wssMen1 = new WssMen1();

    /** WSS-MEN2. */
    private WssMen2 wssMen2 = new WssMen2();

    /** WSS-VARI. */
    private WssVari wssVari = new WssVari();

    /** IDD-NUM-ITBL. */
    private int iddNumItbl;

    /** IDD-ITBL. */
    private int iddItbl;

    /** FIO-ITBL. */
    private int fioItbl;

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
            (new Gnsppcpm()).execute();
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

        execute("doTpinit");

        execute("gnsPutTsk");
        logger.debug("DISPLAY 'INICIO GNSPPCPM VERSION : '");

        logger.info("INICIO GNSPPCPM VERSION : ");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssTagGnsppcpm = "                                                                                                                             ";
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("DISPLAY WSS-TAG-GNSPPCPM");

        logger.info(wssTagGnsppcpm);

        logger.debug("wssTagGnsppcpm :" + wssTagGnsppcpm);

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().setIddCidd("            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO IDD-CIDD");

        iddVari.getIddRegi().setIddCidd(Util.spaces(12));

        logger.debug("iddVari.getIddRegi().getIddCidd() :" + iddVari.getIddRegi().getIddCidd());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioCtts.setFioProg("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'GNSPPCPM' TO FIO-PROG");

        fioCtts.setFioProg("GNSPPCPM");

        logger.debug("fioCtts.getFioProg() :" + fioCtts.getFioProg());

        execute("gnsBusIdd");
        logger.debug("DISPLAY ' '");

        logger.info(" ");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssMen1.setValue("                                                                      ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("DISPLAY WSS-MEN1");

        logger.info(wssMen1.getValue());

        logger.debug("wssMen1.getValue() :" + wssMen1.getValue());

        execute("proInp");

        execute("dspStd");

        execute("gnsGetTsk");

        execute("doTpterm");

        execute("gnsProEnd");

        logger.debug("saliendo de 'principal_iniMain()' ...");

        return "principal_finMain";
    }

    /******************************************************************************
     * principal_finMain
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String principal_finMain() {

        logger.debug("entrando a 'principal_finMain()' ...");

        logger.debug("saliendo de 'principal_finMain()' ...");

        return null;
    }

    /******************************************************************************
     * proInp
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String proInp() {

        logger.debug("entrando a 'proInp()' ...");

        execute("proInp_iniProInp");

        logger.debug("saliendo de 'proInp()' ...");

        return null;
    }

    /******************************************************************************
     * proInp_iniProInp
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String proInp_iniProInp() {

        logger.debug("entrando a 'proInp_iniProInp()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO BUF-ACP");

        bufAcp.setValue(Util.spaces(60));

        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("ACCEPT BUF-ACP");

        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        if (bufAcp.getBufAcp1().equals("REGMNU")) {

            execute("proActMnu");
        }
        else {

            if (bufAcp.getBufAcp1().equals("REGRPF")) {

                execute("proActRpf");
            }
            else {

                if (bufAcp.getBufAcp1().equals("REGTAB")) {

                    execute("proActTab");
                }
                else {

                    if (bufAcp.getValue().equals("      *    OPC = D")) {

                        //// setters /////////////////////////////////////////////////////////////////////////////////
                        //wssSwiCrga = " ";
                        //////////////////////////////////////////////////////////////////////////////////////////////
                        logger.debug("MOVE 'D' TO WSS-SWI-CRGA");

                        wssSwiCrga = "D";

                        logger.debug("wssSwiCrga :" + wssSwiCrga);
                        logger.debug("DISPLAY 'PROGRAMA DESCARGARA PARAMETROS'");

                        logger.info("PROGRAMA DESCARGARA PARAMETROS");
                    }
                    else {

                        if (bufAcp.getValue().equals("      *SOLOTAB")) {

                            //// setters /////////////////////////////////////////////////////////////////////////////////
                            //wssVari.setWssSoloTab(" ");
                            //////////////////////////////////////////////////////////////////////////////////////////////
                            logger.debug("MOVE 'S' TO WSS-SOLO-TAB");

                            wssVari.setWssSoloTab("S");

                            logger.debug("wssVari.getWssSoloTab() :" + wssVari.getWssSoloTab());
                            logger.debug("DISPLAY '---------------------------------'");

                            logger.info("---------------------------------");
                            logger.debug("DISPLAY '|PROGRAMA DESCARGARA SOLO TABLAS|'");

                            logger.info("|PROGRAMA DESCARGARA SOLO TABLAS|");
                            logger.debug("DISPLAY '---------------------------------'");

                            logger.info("---------------------------------");
                        }
                        else {

                            if (!bufAcp.getBufAcp1().equals("FINPI1")) {

                                //// setters /////////////////////////////////////////////////////////////////////////////////
                                //wssMen2.setMen2Area("                                                           ");
                                //bufAcp.setValue("                                                            ");
                                //////////////////////////////////////////////////////////////////////////////////////////////
                                logger.debug("MOVE BUF-ACP TO MEN2-AREA");

                                wssMen2.setMen2Area(bufAcp.getValue());

                                logger.debug("wssMen2.getMen2Area() :" + wssMen2.getMen2Area());
                                logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

                                //// setters /////////////////////////////////////////////////////////////////////////////////
                                //wssMen2.setValue("                                                                      ");
                                //////////////////////////////////////////////////////////////////////////////////////////////
                                logger.debug("DISPLAY WSS-MEN2");

                                logger.info(wssMen2.getValue());

                                logger.debug("wssMen2.getValue() :" + wssMen2.getValue());
                            }
                            else {
                                logger.debug("GO TO FIN-PRO-INP");


                                logger.debug("saliendo de 'proInp_iniProInp()' ...");
                                return "proInp_finProInp";
                            }
                        }
                    }
                }
            }
        }
        logger.debug("GO TO INI-PRO-INP");


        logger.debug("saliendo de 'proInp_iniProInp()' ...");
        return "proInp_iniProInp";
    }

    /******************************************************************************
     * proInp_finProInp
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String proInp_finProInp() {

        logger.debug("entrando a 'proInp_finProInp()' ...");

        logger.debug("saliendo de 'proInp_finProInp()' ...");

        return null;
    }

    /******************************************************************************
     * proActMnu
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String proActMnu() {

        logger.debug("entrando a 'proActMnu()' ...");

        execute("proActMnu_iniProActMnu");

        logger.debug("saliendo de 'proActMnu()' ...");

        return null;
    }

    /******************************************************************************
     * proActMnu_iniProActMnu
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String proActMnu_iniProActMnu() {

        logger.debug("entrando a 'proActMnu_iniProActMnu()' ...");

        if (bufAcp.getBufAcp2().compareTo(Util.spaces(3)) <= 0) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //bufAcp.setValue("                                                            ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("DISPLAY 'NO SE INDICA SISTEMA DE MNU : ' BUF-ACP");

            logger.info("NO SE INDICA SISTEMA DE MNU : " + bufAcp.getValue());

            logger.debug("bufAcp.getValue() :" + bufAcp.getValue());
            logger.debug("GO TO FIN-PRO-ACT-MNU");


            logger.debug("saliendo de 'proActMnu_iniProActMnu()' ...");
            return "proActMnu_finProActMnu";
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO BUF-ACP");

        bufAcp.setValue(Util.spaces(60));

        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("ACCEPT BUF-ACP");

        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssMnu.setWssMnu1("                                                            ");
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE BUF-ACP TO WSS-MNU1");

        wssMnu.setWssMnu1(bufAcp.getValue());

        logger.debug("wssMnu.getWssMnu1() :" + wssMnu.getWssMnu1());
        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO BUF-ACP");

        bufAcp.setValue(Util.spaces(60));

        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("ACCEPT BUF-ACP");

        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssMnu.setWssMnu2("                                                            ");
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE BUF-ACP TO WSS-MNU2");

        wssMnu.setWssMnu2(bufAcp.getValue());

        logger.debug("wssMnu.getWssMnu2() :" + wssMnu.getWssMnu2());
        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO BUF-ACP");

        bufAcp.setValue(Util.spaces(60));

        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("ACCEPT BUF-ACP");

        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssMnu.setWssMnu3("                                                            ");
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE BUF-ACP TO WSS-MNU3");

        wssMnu.setWssMnu3(bufAcp.getValue());

        logger.debug("wssMnu.getWssMnu3() :" + wssMnu.getWssMnu3());
        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO BUF-ACP");

        bufAcp.setValue(Util.spaces(60));

        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("ACCEPT BUF-ACP");

        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssMnu.setWssMnu4("                                                            ");
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE BUF-ACP TO WSS-MNU4");

        wssMnu.setWssMnu4(bufAcp.getValue());

        logger.debug("wssMnu.getWssMnu4() :" + wssMnu.getWssMnu4());
        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO BUF-ACP");

        bufAcp.setValue(Util.spaces(60));

        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("ACCEPT BUF-ACP");

        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssMnu.setWssMnu5("                                                            ");
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE BUF-ACP TO WSS-MNU5");

        wssMnu.setWssMnu5(bufAcp.getValue());

        logger.debug("wssMnu.getWssMnu5() :" + wssMnu.getWssMnu5());
        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO BUF-ACP");

        bufAcp.setValue(Util.spaces(60));

        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("ACCEPT BUF-ACP");

        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssMnu.setWssMnu6("                                                            ");
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE BUF-ACP TO WSS-MNU6");

        wssMnu.setWssMnu6(bufAcp.getValue());

        logger.debug("wssMnu.getWssMnu6() :" + wssMnu.getWssMnu6());
        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO BUF-ACP");

        bufAcp.setValue(Util.spaces(60));

        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("ACCEPT BUF-ACP");

        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssMnu.setWssMnu7("                                                            ");
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE BUF-ACP TO WSS-MNU7");

        wssMnu.setWssMnu7(bufAcp.getValue());

        logger.debug("wssMnu.getWssMnu7() :" + wssMnu.getWssMnu7());
        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO BUF-ACP");

        bufAcp.setValue(Util.spaces(60));

        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("ACCEPT BUF-ACP");

        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssMnu.setWssMnu8("                                                            ");
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE BUF-ACP TO WSS-MNU8");

        wssMnu.setWssMnu8(bufAcp.getValue());

        logger.debug("wssMnu.getWssMnu8() :" + wssMnu.getWssMnu8());
        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO BUF-ACP");

        bufAcp.setValue(Util.spaces(60));

        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("ACCEPT BUF-ACP");

        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssMnu.setWssMnu9("                                                            ");
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE BUF-ACP TO WSS-MNU9");

        wssMnu.setWssMnu9(bufAcp.getValue());

        logger.debug("wssMnu.getWssMnu9() :" + wssMnu.getWssMnu9());
        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //mnu.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                 ");
        //wssMnu.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE WSS-MNU TO MNU");

        mnu.setValue(wssMnu.getValue());

        logger.debug("mnu.getValue() :" + mnu.getValue());
        logger.debug("wssMnu.getValue() :" + wssMnu.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioVari.setFioCmnd(0);
        //fioCtts.getFioVcmn().setFioGetKey(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE FIO-GET-KEY TO FIO-CMND");

        fioVari.setFioCmnd(fioCtts.getFioVcmn().getFioGetKey());

        logger.debug("fioVari.getFioCmnd() :" + fioVari.getFioCmnd());
        logger.debug("fioCtts.getFioVcmn().getFioGetKey() :" + fioCtts.getFioVcmn().getFioGetKey());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioVari.getFioVoid().setFioSist("   ");
        //wssVari.setWssSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE WSS-SIST TO FIO-SIST");

        fioVari.getFioVoid().setFioSist(wssVari.getWssSist());

        logger.debug("fioVari.getFioVoid().getFioSist() :" + fioVari.getFioVoid().getFioSist());
        logger.debug("wssVari.getWssSist() :" + wssVari.getWssSist());

        execute("gnsFioMnu");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioVari.getFioStat().setValue("  ");
        //mnu.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                 ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("DISPLAY 'MNU 1:' FIO-STAT MNU");

        logger.info("MNU 1:" + fioVari.getFioStat().getValue() + mnu.getValue());

        logger.debug("fioVari.getFioStat().getValue() :" + fioVari.getFioStat().getValue());
        logger.debug("mnu.getValue() :" + mnu.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioVari.getFioStat().setValue("  ");
        //wssMnu.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("DISPLAY 'MNU 2:' FIO-STAT WSS-MNU");

        logger.info("MNU 2:" + fioVari.getFioStat().getValue() + wssMnu.getValue());

        logger.debug("fioVari.getFioStat().getValue() :" + fioVari.getFioStat().getValue());
        logger.debug("wssMnu.getValue() :" + wssMnu.getValue());

        if (fioVari.getFioStat().isFioStatOks()) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //mnu.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                 ");
            //wssMnu.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE WSS-MNU TO MNU");

            mnu.setValue(wssMnu.getValue());

            logger.debug("mnu.getValue() :" + mnu.getValue());
            logger.debug("wssMnu.getValue() :" + wssMnu.getValue());

            if (wssSwiCrga.equals("C")) {

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //fioVari.setFioCmnd(0);
                //fioCtts.getFioVcmn().setFioMod(0);
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("MOVE FIO-MOD TO FIO-CMND");

                fioVari.setFioCmnd(fioCtts.getFioVcmn().getFioMod());

                logger.debug("fioVari.getFioCmnd() :" + fioVari.getFioCmnd());
                logger.debug("fioCtts.getFioVcmn().getFioMod() :" + fioCtts.getFioVcmn().getFioMod());
            }
            else {

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //fioVari.setFioCmnd(0);
                //fioCtts.getFioVcmn().setFioDel(0);
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("MOVE FIO-DEL TO FIO-CMND");

                fioVari.setFioCmnd(fioCtts.getFioVcmn().getFioDel());

                logger.debug("fioVari.getFioCmnd() :" + fioVari.getFioCmnd());
                logger.debug("fioCtts.getFioVcmn().getFioDel() :" + fioCtts.getFioVcmn().getFioDel());
            }
        }
        else {

            if (wssSwiCrga.equals("C")) {

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //mnu.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                 ");
                //wssMnu.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            ");
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("MOVE WSS-MNU TO MNU");

                mnu.setValue(wssMnu.getValue());

                logger.debug("mnu.getValue() :" + mnu.getValue());
                logger.debug("wssMnu.getValue() :" + wssMnu.getValue());

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //fioVari.setFioCmnd(0);
                //fioCtts.getFioVcmn().setFioPut(0);
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("MOVE FIO-PUT TO FIO-CMND");

                fioVari.setFioCmnd(fioCtts.getFioVcmn().getFioPut());

                logger.debug("fioVari.getFioCmnd() :" + fioVari.getFioCmnd());
                logger.debug("fioCtts.getFioVcmn().getFioPut() :" + fioCtts.getFioVcmn().getFioPut());
            }
            else {
                logger.debug("GO TO FIN-PRO-ACT-MNU");


                logger.debug("saliendo de 'proActMnu_iniProActMnu()' ...");
                return "proActMnu_finProActMnu";
            }
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioVari.getFioVoid().setFioSist("   ");
        //wssVari.setWssSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE WSS-SIST TO FIO-SIST");

        fioVari.getFioVoid().setFioSist(wssVari.getWssSist());

        logger.debug("fioVari.getFioVoid().getFioSist() :" + fioVari.getFioVoid().getFioSist());
        logger.debug("wssVari.getWssSist() :" + wssVari.getWssSist());

        if (wssVari.getWssSoloTab().equals("S")) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioVari.getFioStat().setValue("  ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE '00' TO FIO-STAT");

            fioVari.getFioStat().setValue("00");

            logger.debug("fioVari.getFioStat().getValue() :" + fioVari.getFioStat().getValue());

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioVari.getFioStat().setValue("  ");
            //mnu.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                 ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("DISPLAY 'MNU 3:' FIO-STAT MNU");

            logger.info("MNU 3:" + fioVari.getFioStat().getValue() + mnu.getValue());

            logger.debug("fioVari.getFioStat().getValue() :" + fioVari.getFioStat().getValue());
            logger.debug("mnu.getValue() :" + mnu.getValue());
        }
        else {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioVari.getFioStat().setValue("  ");
            //mnu.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                 ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("DISPLAY 'MNU 4:' FIO-STAT MNU");

            logger.info("MNU 4:" + fioVari.getFioStat().getValue() + mnu.getValue());

            logger.debug("fioVari.getFioStat().getValue() :" + fioVari.getFioStat().getValue());
            logger.debug("mnu.getValue() :" + mnu.getValue());

            execute("gnsFioMnu");
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioVari.getFioStat().setValue("  ");
        //mnu.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                 ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("DISPLAY 'MNU 5:' FIO-STAT MNU");

        logger.info("MNU 5:" + fioVari.getFioStat().getValue() + mnu.getValue());

        logger.debug("fioVari.getFioStat().getValue() :" + fioVari.getFioStat().getValue());
        logger.debug("mnu.getValue() :" + mnu.getValue());

        if (!fioVari.getFioStat().isFioStatOks()) {

            if (fioVari.getFioCmnd() == fioCtts.getFioVcmn().getFioPut()) {

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //wssTot.setWssMnuErp(0);
                //wssTot.setWssMnuErp(0);
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("ADD 1 TO WSS-MNU-ERP");

                wssTot.setWssMnuErp(1 + wssTot.getWssMnuErp());

                logger.debug("wssTot.getWssMnuErp() :" + wssTot.getWssMnuErp());
                logger.debug("wssTot.getWssMnuErp() :" + wssTot.getWssMnuErp());
                logger.debug("DISPLAY 'ERROR AL GRABAR MNU '");

                logger.info("ERROR AL GRABAR MNU ");

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //fioVari.getFioStat().setValue("  ");
                //mnu.getMnuCodNems().getMnuCodNemo().setValue("            ");
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("DISPLAY 'FIO-STAT MNU-COD-NEMO : ' FIO-STAT ' ' MNU-COD-NEMO IN MNU");

                logger.info("FIO-STAT MNU-COD-NEMO : " + fioVari.getFioStat().getValue() + " " + mnu.getMnuCodNems().getMnuCodNemo().getValue());

                logger.debug("fioVari.getFioStat().getValue() :" + fioVari.getFioStat().getValue());
                logger.debug("mnu.getMnuCodNems().getMnuCodNemo().getValue() :" + mnu.getMnuCodNems().getMnuCodNemo().getValue());
            }
            else {

                if (fioVari.getFioCmnd() == fioCtts.getFioVcmn().getFioDel()) {

                    //// setters /////////////////////////////////////////////////////////////////////////////////
                    //wssTot.setWssMnuEre(0);
                    //wssTot.setWssMnuEre(0);
                    //////////////////////////////////////////////////////////////////////////////////////////////
                    logger.debug("ADD 1 TO WSS-MNU-ERE");

                    wssTot.setWssMnuEre(1 + wssTot.getWssMnuEre());

                    logger.debug("wssTot.getWssMnuEre() :" + wssTot.getWssMnuEre());
                    logger.debug("wssTot.getWssMnuEre() :" + wssTot.getWssMnuEre());
                    logger.debug("DISPLAY 'ERROR AL ELIMINAR  MNU '");

                    logger.info("ERROR AL ELIMINAR  MNU ");

                    //// setters /////////////////////////////////////////////////////////////////////////////////
                    //fioVari.getFioStat().setValue("  ");
                    //mnu.getMnuCodNems().getMnuCodNemo().setValue("            ");
                    //////////////////////////////////////////////////////////////////////////////////////////////
                    logger.debug("DISPLAY 'FIO-STAT MNU-COD-NEMO : ' FIO-STAT ' ' MNU-COD-NEMO IN MNU");

                    logger.info("FIO-STAT MNU-COD-NEMO : " + fioVari.getFioStat().getValue() + " " + mnu.getMnuCodNems().getMnuCodNemo().getValue());

                    logger.debug("fioVari.getFioStat().getValue() :" + fioVari.getFioStat().getValue());
                    logger.debug("mnu.getMnuCodNems().getMnuCodNemo().getValue() :" + mnu.getMnuCodNems().getMnuCodNemo().getValue());
                }
                else {

                    //// setters /////////////////////////////////////////////////////////////////////////////////
                    //wssTot.setWssMnuErm(0);
                    //wssTot.setWssMnuErm(0);
                    //////////////////////////////////////////////////////////////////////////////////////////////
                    logger.debug("ADD 1 TO WSS-MNU-ERM");

                    wssTot.setWssMnuErm(1 + wssTot.getWssMnuErm());

                    logger.debug("wssTot.getWssMnuErm() :" + wssTot.getWssMnuErm());
                    logger.debug("wssTot.getWssMnuErm() :" + wssTot.getWssMnuErm());
                    logger.debug("DISPLAY 'ERROR AL MODIFICAR MNU '");

                    logger.info("ERROR AL MODIFICAR MNU ");

                    //// setters /////////////////////////////////////////////////////////////////////////////////
                    //fioVari.getFioStat().setValue("  ");
                    //mnu.getMnuCodNems().getMnuCodNemo().setValue("            ");
                    //////////////////////////////////////////////////////////////////////////////////////////////
                    logger.debug("DISPLAY 'FIO-STAT MNU-COD-NEMO : ' FIO-STAT ' ' MNU-COD-NEMO IN MNU");

                    logger.info("FIO-STAT MNU-COD-NEMO : " + fioVari.getFioStat().getValue() + " " + mnu.getMnuCodNems().getMnuCodNemo().getValue());

                    logger.debug("fioVari.getFioStat().getValue() :" + fioVari.getFioStat().getValue());
                    logger.debug("mnu.getMnuCodNems().getMnuCodNemo().getValue() :" + mnu.getMnuCodNems().getMnuCodNemo().getValue());
                }
            }
        }
        else {

            if (fioVari.getFioCmnd() == fioCtts.getFioVcmn().getFioPut()) {

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //mnu.getMnuCodNems().getMnuCodNemo().setValue("            ");
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("DISPLAY MNU-COD-NEMO '           : MNU INGRESADO'");

                logger.info(mnu.getMnuCodNems().getMnuCodNemo().getValue() + "           : MNU INGRESADO");

                logger.debug("mnu.getMnuCodNems().getMnuCodNemo().getValue() :" + mnu.getMnuCodNems().getMnuCodNemo().getValue());

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //wssTot.setWssMnuPut(0);
                //wssTot.setWssMnuPut(0);
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("ADD 1 TO WSS-MNU-PUT");

                wssTot.setWssMnuPut(1 + wssTot.getWssMnuPut());

                logger.debug("wssTot.getWssMnuPut() :" + wssTot.getWssMnuPut());
                logger.debug("wssTot.getWssMnuPut() :" + wssTot.getWssMnuPut());
            }
            else {

                if (fioVari.getFioCmnd() == fioCtts.getFioVcmn().getFioDel()) {

                    //// setters /////////////////////////////////////////////////////////////////////////////////
                    //mnu.getMnuCodNems().getMnuCodNemo().setValue("            ");
                    //////////////////////////////////////////////////////////////////////////////////////////////
                    logger.debug("DISPLAY MNU-COD-NEMO '           : MNU ELIMINADO'");

                    logger.info(mnu.getMnuCodNems().getMnuCodNemo().getValue() + "           : MNU ELIMINADO");

                    logger.debug("mnu.getMnuCodNems().getMnuCodNemo().getValue() :" + mnu.getMnuCodNems().getMnuCodNemo().getValue());

                    //// setters /////////////////////////////////////////////////////////////////////////////////
                    //wssTot.setWssMnuEli(0);
                    //wssTot.setWssMnuEli(0);
                    //////////////////////////////////////////////////////////////////////////////////////////////
                    logger.debug("ADD 1 TO WSS-MNU-ELI");

                    wssTot.setWssMnuEli(1 + wssTot.getWssMnuEli());

                    logger.debug("wssTot.getWssMnuEli() :" + wssTot.getWssMnuEli());
                    logger.debug("wssTot.getWssMnuEli() :" + wssTot.getWssMnuEli());
                }
                else {

                    //// setters /////////////////////////////////////////////////////////////////////////////////
                    //mnu.getMnuCodNems().getMnuCodNemo().setValue("            ");
                    //////////////////////////////////////////////////////////////////////////////////////////////
                    logger.debug("DISPLAY MNU-COD-NEMO '           : MNU MODIFICADO'");

                    logger.info(mnu.getMnuCodNems().getMnuCodNemo().getValue() + "           : MNU MODIFICADO");

                    logger.debug("mnu.getMnuCodNems().getMnuCodNemo().getValue() :" + mnu.getMnuCodNems().getMnuCodNemo().getValue());

                    //// setters /////////////////////////////////////////////////////////////////////////////////
                    //wssTot.setWssMnuMod(0);
                    //wssTot.setWssMnuMod(0);
                    //////////////////////////////////////////////////////////////////////////////////////////////
                    logger.debug("ADD 1 TO WSS-MNU-MOD");

                    wssTot.setWssMnuMod(1 + wssTot.getWssMnuMod());

                    logger.debug("wssTot.getWssMnuMod() :" + wssTot.getWssMnuMod());
                    logger.debug("wssTot.getWssMnuMod() :" + wssTot.getWssMnuMod());
                }
            }
        }

        logger.debug("saliendo de 'proActMnu_iniProActMnu()' ...");

        return "proActMnu_finProActMnu";
    }

    /******************************************************************************
     * proActMnu_finProActMnu
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String proActMnu_finProActMnu() {

        logger.debug("entrando a 'proActMnu_finProActMnu()' ...");

        logger.debug("saliendo de 'proActMnu_finProActMnu()' ...");

        return null;
    }

    /******************************************************************************
     * proActRpf
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String proActRpf() {

        logger.debug("entrando a 'proActRpf()' ...");

        execute("proActRpf_iniProActRpf");

        logger.debug("saliendo de 'proActRpf()' ...");

        return null;
    }

    /******************************************************************************
     * proActRpf_iniProActRpf
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String proActRpf_iniProActRpf() {

        logger.debug("entrando a 'proActRpf_iniProActRpf()' ...");

        if (bufAcp.getBufAcp2().compareTo(Util.spaces(3)) <= 0) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //bufAcp.setValue("                                                            ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("DISPLAY 'NO SE INDICA SISTEMA DE RPF : ' BUF-ACP");

            logger.info("NO SE INDICA SISTEMA DE RPF : " + bufAcp.getValue());

            logger.debug("bufAcp.getValue() :" + bufAcp.getValue());
            logger.debug("GO TO FIN-PRO-ACT-RPF");


            logger.debug("saliendo de 'proActRpf_iniProActRpf()' ...");
            return "proActRpf_finProActRpf";
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO BUF-ACP");

        bufAcp.setValue(Util.spaces(60));

        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("ACCEPT BUF-ACP");

        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssRpf.setWssRpf1("                                                            ");
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE BUF-ACP TO WSS-RPF1");

        wssRpf.setWssRpf1(bufAcp.getValue());

        logger.debug("wssRpf.getWssRpf1() :" + wssRpf.getWssRpf1());
        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO BUF-ACP");

        bufAcp.setValue(Util.spaces(60));

        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("ACCEPT BUF-ACP");

        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssRpf.setWssRpf2("                                                            ");
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE BUF-ACP TO WSS-RPF2");

        wssRpf.setWssRpf2(bufAcp.getValue());

        logger.debug("wssRpf.getWssRpf2() :" + wssRpf.getWssRpf2());
        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //rpf.setValue("                                                                                            ");
        //wssRpf.setValue("                                                                                                                        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE WSS-RPF TO RPF");

        rpf.setValue(wssRpf.getValue());

        logger.debug("rpf.getValue() :" + rpf.getValue());
        logger.debug("wssRpf.getValue() :" + wssRpf.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioVari.setFioCmnd(0);
        //fioCtts.getFioVcmn().setFioGetKey(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE FIO-GET-KEY TO FIO-CMND");

        fioVari.setFioCmnd(fioCtts.getFioVcmn().getFioGetKey());

        logger.debug("fioVari.getFioCmnd() :" + fioVari.getFioCmnd());
        logger.debug("fioCtts.getFioVcmn().getFioGetKey() :" + fioCtts.getFioVcmn().getFioGetKey());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioVari.getFioVoid().setFioSist("   ");
        //wssVari.setWssSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE WSS-SIST TO FIO-SIST");

        fioVari.getFioVoid().setFioSist(wssVari.getWssSist());

        logger.debug("fioVari.getFioVoid().getFioSist() :" + fioVari.getFioVoid().getFioSist());
        logger.debug("wssVari.getWssSist() :" + wssVari.getWssSist());

        execute("gnsFioRpf");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //rpf.setValue("                                                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("DISPLAY 'RPF :' RPF");

        logger.info("RPF :" + rpf.getValue());

        logger.debug("rpf.getValue() :" + rpf.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssRpf.setValue("                                                                                                                        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("DISPLAY 'RPF :' WSS-RPF");

        logger.info("RPF :" + wssRpf.getValue());

        logger.debug("wssRpf.getValue() :" + wssRpf.getValue());

        if (fioVari.getFioStat().isFioStatOks()) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //rpf.setValue("                                                                                            ");
            //wssRpf.setValue("                                                                                                                        ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE WSS-RPF TO RPF");

            rpf.setValue(wssRpf.getValue());

            logger.debug("rpf.getValue() :" + rpf.getValue());
            logger.debug("wssRpf.getValue() :" + wssRpf.getValue());

            if (wssSwiCrga.equals("C")) {

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //fioVari.setFioCmnd(0);
                //fioCtts.getFioVcmn().setFioMod(0);
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("MOVE FIO-MOD TO FIO-CMND");

                fioVari.setFioCmnd(fioCtts.getFioVcmn().getFioMod());

                logger.debug("fioVari.getFioCmnd() :" + fioVari.getFioCmnd());
                logger.debug("fioCtts.getFioVcmn().getFioMod() :" + fioCtts.getFioVcmn().getFioMod());
            }
            else {

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //fioVari.setFioCmnd(0);
                //fioCtts.getFioVcmn().setFioDel(0);
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("MOVE FIO-DEL TO FIO-CMND");

                fioVari.setFioCmnd(fioCtts.getFioVcmn().getFioDel());

                logger.debug("fioVari.getFioCmnd() :" + fioVari.getFioCmnd());
                logger.debug("fioCtts.getFioVcmn().getFioDel() :" + fioCtts.getFioVcmn().getFioDel());
            }
        }
        else {

            if (wssSwiCrga.equals("C")) {

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //rpf.setValue("                                                                                            ");
                //wssRpf.setValue("                                                                                                                        ");
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("MOVE WSS-RPF TO RPF");

                rpf.setValue(wssRpf.getValue());

                logger.debug("rpf.getValue() :" + rpf.getValue());
                logger.debug("wssRpf.getValue() :" + wssRpf.getValue());

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //fioVari.setFioCmnd(0);
                //fioCtts.getFioVcmn().setFioPut(0);
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("MOVE FIO-PUT TO FIO-CMND");

                fioVari.setFioCmnd(fioCtts.getFioVcmn().getFioPut());

                logger.debug("fioVari.getFioCmnd() :" + fioVari.getFioCmnd());
                logger.debug("fioCtts.getFioVcmn().getFioPut() :" + fioCtts.getFioVcmn().getFioPut());
            }
            else {
                logger.debug("GO TO FIN-PRO-ACT-RPF");


                logger.debug("saliendo de 'proActRpf_iniProActRpf()' ...");
                return "proActRpf_finProActRpf";
            }
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioVari.getFioVoid().setFioSist("   ");
        //wssVari.setWssSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE WSS-SIST TO FIO-SIST");

        fioVari.getFioVoid().setFioSist(wssVari.getWssSist());

        logger.debug("fioVari.getFioVoid().getFioSist() :" + fioVari.getFioVoid().getFioSist());
        logger.debug("wssVari.getWssSist() :" + wssVari.getWssSist());

        if (wssVari.getWssSoloTab().equals("S")) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioVari.getFioStat().setValue("  ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE '00' TO FIO-STAT");

            fioVari.getFioStat().setValue("00");

            logger.debug("fioVari.getFioStat().getValue() :" + fioVari.getFioStat().getValue());
        }
        else {

            execute("gnsFioRpf");
        }

        if (!fioVari.getFioStat().isFioStatOks()) {

            if (fioVari.getFioCmnd() == fioCtts.getFioVcmn().getFioPut()) {

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //wssTot.setWssRpfErp(0);
                //wssTot.setWssRpfErp(0);
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("ADD 1 TO WSS-RPF-ERP");

                wssTot.setWssRpfErp(1 + wssTot.getWssRpfErp());

                logger.debug("wssTot.getWssRpfErp() :" + wssTot.getWssRpfErp());
                logger.debug("wssTot.getWssRpfErp() :" + wssTot.getWssRpfErp());
                logger.debug("DISPLAY 'ERROR AL GRABAR RPF '");

                logger.info("ERROR AL GRABAR RPF ");

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //fioVari.getFioStat().setValue("  ");
                //rpf.getRpfCodDpts().getRpfCodDptr().setValue("                      ");
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("DISPLAY 'FIO-STAT RPF-COD-DPTR : ' FIO-STAT ' ' RPF-COD-DPTR IN RPF");

                logger.info("FIO-STAT RPF-COD-DPTR : " + fioVari.getFioStat().getValue() + " " + rpf.getRpfCodDpts().getRpfCodDptr().getValue());

                logger.debug("fioVari.getFioStat().getValue() :" + fioVari.getFioStat().getValue());
                logger.debug("rpf.getRpfCodDpts().getRpfCodDptr().getValue() :" + rpf.getRpfCodDpts().getRpfCodDptr().getValue());
            }
            else {

                if (fioVari.getFioCmnd() == fioCtts.getFioVcmn().getFioDel()) {

                    //// setters /////////////////////////////////////////////////////////////////////////////////
                    //wssTot.setWssRpfEre(0);
                    //wssTot.setWssRpfEre(0);
                    //////////////////////////////////////////////////////////////////////////////////////////////
                    logger.debug("ADD 1 TO WSS-RPF-ERE");

                    wssTot.setWssRpfEre(1 + wssTot.getWssRpfEre());

                    logger.debug("wssTot.getWssRpfEre() :" + wssTot.getWssRpfEre());
                    logger.debug("wssTot.getWssRpfEre() :" + wssTot.getWssRpfEre());
                    logger.debug("DISPLAY 'ERROR AL ELIMINAR RPF '");

                    logger.info("ERROR AL ELIMINAR RPF ");

                    //// setters /////////////////////////////////////////////////////////////////////////////////
                    //fioVari.getFioStat().setValue("  ");
                    //rpf.getRpfCodDpts().getRpfCodDptr().setValue("                      ");
                    //////////////////////////////////////////////////////////////////////////////////////////////
                    logger.debug("DISPLAY 'FIO-STAT RPF-COD-DPTR : ' FIO-STAT ' ' RPF-COD-DPTR IN RPF");

                    logger.info("FIO-STAT RPF-COD-DPTR : " + fioVari.getFioStat().getValue() + " " + rpf.getRpfCodDpts().getRpfCodDptr().getValue());

                    logger.debug("fioVari.getFioStat().getValue() :" + fioVari.getFioStat().getValue());
                    logger.debug("rpf.getRpfCodDpts().getRpfCodDptr().getValue() :" + rpf.getRpfCodDpts().getRpfCodDptr().getValue());
                }
                else {

                    //// setters /////////////////////////////////////////////////////////////////////////////////
                    //wssTot.setWssRpfErm(0);
                    //wssTot.setWssRpfErm(0);
                    //////////////////////////////////////////////////////////////////////////////////////////////
                    logger.debug("ADD 1 TO WSS-RPF-ERM");

                    wssTot.setWssRpfErm(1 + wssTot.getWssRpfErm());

                    logger.debug("wssTot.getWssRpfErm() :" + wssTot.getWssRpfErm());
                    logger.debug("wssTot.getWssRpfErm() :" + wssTot.getWssRpfErm());
                    logger.debug("DISPLAY 'ERROR AL MODIFICAR RPF '");

                    logger.info("ERROR AL MODIFICAR RPF ");

                    //// setters /////////////////////////////////////////////////////////////////////////////////
                    //fioVari.getFioStat().setValue("  ");
                    //rpf.getRpfCodDpts().getRpfCodDptr().setValue("                      ");
                    //////////////////////////////////////////////////////////////////////////////////////////////
                    logger.debug("DISPLAY 'FIO-STAT RPF-COD-DPTR : ' FIO-STAT ' ' RPF-COD-DPTR IN RPF");

                    logger.info("FIO-STAT RPF-COD-DPTR : " + fioVari.getFioStat().getValue() + " " + rpf.getRpfCodDpts().getRpfCodDptr().getValue());

                    logger.debug("fioVari.getFioStat().getValue() :" + fioVari.getFioStat().getValue());
                    logger.debug("rpf.getRpfCodDpts().getRpfCodDptr().getValue() :" + rpf.getRpfCodDpts().getRpfCodDptr().getValue());
                }
            }
        }
        else {

            if (fioVari.getFioCmnd() == fioCtts.getFioVcmn().getFioPut()) {

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //rpf.getRpfCodDpts().getRpfCodDptr().setValue("                      ");
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("DISPLAY RPF-COD-DPTR ' : RPF INGRESADO'");

                logger.info(rpf.getRpfCodDpts().getRpfCodDptr().getValue() + " : RPF INGRESADO");

                logger.debug("rpf.getRpfCodDpts().getRpfCodDptr().getValue() :" + rpf.getRpfCodDpts().getRpfCodDptr().getValue());

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //wssTot.setWssRpfPut(0);
                //wssTot.setWssRpfPut(0);
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("ADD 1 TO WSS-RPF-PUT");

                wssTot.setWssRpfPut(1 + wssTot.getWssRpfPut());

                logger.debug("wssTot.getWssRpfPut() :" + wssTot.getWssRpfPut());
                logger.debug("wssTot.getWssRpfPut() :" + wssTot.getWssRpfPut());
            }
            else {

                if (fioVari.getFioCmnd() == fioCtts.getFioVcmn().getFioDel()) {

                    //// setters /////////////////////////////////////////////////////////////////////////////////
                    //rpf.getRpfCodDpts().getRpfCodDptr().setValue("                      ");
                    //////////////////////////////////////////////////////////////////////////////////////////////
                    logger.debug("DISPLAY RPF-COD-DPTR ' : RPF ELIMINADO'");

                    logger.info(rpf.getRpfCodDpts().getRpfCodDptr().getValue() + " : RPF ELIMINADO");

                    logger.debug("rpf.getRpfCodDpts().getRpfCodDptr().getValue() :" + rpf.getRpfCodDpts().getRpfCodDptr().getValue());

                    //// setters /////////////////////////////////////////////////////////////////////////////////
                    //wssTot.setWssRpfEli(0);
                    //wssTot.setWssRpfEli(0);
                    //////////////////////////////////////////////////////////////////////////////////////////////
                    logger.debug("ADD 1 TO WSS-RPF-ELI");

                    wssTot.setWssRpfEli(1 + wssTot.getWssRpfEli());

                    logger.debug("wssTot.getWssRpfEli() :" + wssTot.getWssRpfEli());
                    logger.debug("wssTot.getWssRpfEli() :" + wssTot.getWssRpfEli());
                }
                else {

                    //// setters /////////////////////////////////////////////////////////////////////////////////
                    //rpf.getRpfCodDpts().getRpfCodDptr().setValue("                      ");
                    //////////////////////////////////////////////////////////////////////////////////////////////
                    logger.debug("DISPLAY RPF-COD-DPTR ' : RPF MODIFICADO'");

                    logger.info(rpf.getRpfCodDpts().getRpfCodDptr().getValue() + " : RPF MODIFICADO");

                    logger.debug("rpf.getRpfCodDpts().getRpfCodDptr().getValue() :" + rpf.getRpfCodDpts().getRpfCodDptr().getValue());

                    //// setters /////////////////////////////////////////////////////////////////////////////////
                    //wssTot.setWssRpfMod(0);
                    //wssTot.setWssRpfMod(0);
                    //////////////////////////////////////////////////////////////////////////////////////////////
                    logger.debug("ADD 1 TO WSS-RPF-MOD");

                    wssTot.setWssRpfMod(1 + wssTot.getWssRpfMod());

                    logger.debug("wssTot.getWssRpfMod() :" + wssTot.getWssRpfMod());
                    logger.debug("wssTot.getWssRpfMod() :" + wssTot.getWssRpfMod());
                }
            }
        }

        logger.debug("saliendo de 'proActRpf_iniProActRpf()' ...");

        return "proActRpf_finProActRpf";
    }

    /******************************************************************************
     * proActRpf_finProActRpf
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String proActRpf_finProActRpf() {

        logger.debug("entrando a 'proActRpf_finProActRpf()' ...");

        logger.debug("saliendo de 'proActRpf_finProActRpf()' ...");

        return null;
    }

    /******************************************************************************
     * proActTab
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String proActTab() {

        logger.debug("entrando a 'proActTab()' ...");

        execute("proActTab_iniProActTab");

        logger.debug("saliendo de 'proActTab()' ...");

        return null;
    }

    /******************************************************************************
     * proActTab_iniProActTab
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String proActTab_iniProActTab() {

        logger.debug("entrando a 'proActTab_iniProActTab()' ...");

        if (bufAcp.getBufAcp2().compareTo(Util.spaces(3)) <= 0) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //bufAcp.setValue("                                                            ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("DISPLAY 'NO SE INDICA SISTEMA DE TAB : ' BUF-ACP");

            logger.info("NO SE INDICA SISTEMA DE TAB : " + bufAcp.getValue());

            logger.debug("bufAcp.getValue() :" + bufAcp.getValue());
            logger.debug("GO TO FIN-PRO-ACT-TAB");


            logger.debug("saliendo de 'proActTab_iniProActTab()' ...");
            return "proActTab_finProActTab";
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioVari.getFioVoid().setFioSist("   ");
        //bufAcp.setBufAcp2("   ");
        //wssVari.setWssSist("   ");
        //bufAcp.setBufAcp2("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE BUF-ACP2 TO FIO-SIST WSS-SIST");

        fioVari.getFioVoid().setFioSist(bufAcp.getBufAcp2());

        wssVari.setWssSist(bufAcp.getBufAcp2());

        logger.debug("fioVari.getFioVoid().getFioSist() :" + fioVari.getFioVoid().getFioSist());
        logger.debug("bufAcp.getBufAcp2() :" + bufAcp.getBufAcp2());
        logger.debug("wssVari.getWssSist() :" + wssVari.getWssSist());
        logger.debug("bufAcp.getBufAcp2() :" + bufAcp.getBufAcp2());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO BUF-ACP");

        bufAcp.setValue(Util.spaces(60));

        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("ACCEPT BUF-ACP");

        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssTab.setWssTab1("                                                            ");
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE BUF-ACP TO WSS-TAB1");

        wssTab.setWssTab1(bufAcp.getValue());

        logger.debug("wssTab.getWssTab1() :" + wssTab.getWssTab1());
        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO BUF-ACP");

        bufAcp.setValue(Util.spaces(60));

        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("ACCEPT BUF-ACP");

        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssTab.setWssTab2("                                                            ");
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE BUF-ACP TO WSS-TAB2");

        wssTab.setWssTab2(bufAcp.getValue());

        logger.debug("wssTab.getWssTab2() :" + wssTab.getWssTab2());
        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO BUF-ACP");

        bufAcp.setValue(Util.spaces(60));

        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("ACCEPT BUF-ACP");

        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssTab.setWssTab3("                                                            ");
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE BUF-ACP TO WSS-TAB3");

        wssTab.setWssTab3(bufAcp.getValue());

        logger.debug("wssTab.getWssTab3() :" + wssTab.getWssTab3());
        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO BUF-ACP");

        bufAcp.setValue(Util.spaces(60));

        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("ACCEPT BUF-ACP");

        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssTab.setWssTab4("                                                            ");
        //bufAcp.setValue("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE BUF-ACP TO WSS-TAB4");

        wssTab.setWssTab4(bufAcp.getValue());

        logger.debug("wssTab.getWssTab4() :" + wssTab.getWssTab4());
        logger.debug("bufAcp.getValue() :" + bufAcp.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tab.setValue("                                                                                                                                                                                                  ");
        //wssTab.setValue("                                                                                                                                                                                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE WSS-TAB TO TAB");

        tab.setValue(wssTab.getValue());

        logger.debug("tab.getValue() :" + tab.getValue());
        logger.debug("wssTab.getValue() :" + wssTab.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioVari.setFioCmnd(0);
        //fioCtts.getFioVcmn().setFioGetKeyUpd(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE FIO-GET-KEY-UPD TO FIO-CMND");

        fioVari.setFioCmnd(fioCtts.getFioVcmn().getFioGetKeyUpd());

        logger.debug("fioVari.getFioCmnd() :" + fioVari.getFioCmnd());
        logger.debug("fioCtts.getFioVcmn().getFioGetKeyUpd() :" + fioCtts.getFioVcmn().getFioGetKeyUpd());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioVari.getFioVoid().setFioSist("   ");
        //wssVari.setWssSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE WSS-SIST TO FIO-SIST");

        fioVari.getFioVoid().setFioSist(wssVari.getWssSist());

        logger.debug("fioVari.getFioVoid().getFioSist() :" + fioVari.getFioVoid().getFioSist());
        logger.debug("wssVari.getWssSist() :" + wssVari.getWssSist());

        execute("gnsFioTab");

        if (fioVari.getFioStat().isFioStatOks()) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //tab.setValue("                                                                                                                                                                                                  ");
            //wssTab.setValue("                                                                                                                                                                                                                                                ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE WSS-TAB TO TAB");

            tab.setValue(wssTab.getValue());

            logger.debug("tab.getValue() :" + tab.getValue());
            logger.debug("wssTab.getValue() :" + wssTab.getValue());

            if (wssSwiCrga.equals("C")) {
                logger.debug("DISPLAY 'MODIFICA  TAB'");

                logger.info("MODIFICA  TAB");

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //fioVari.setFioCmnd(0);
                //fioCtts.getFioVcmn().setFioMod(0);
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("MOVE FIO-MOD TO FIO-CMND");

                fioVari.setFioCmnd(fioCtts.getFioVcmn().getFioMod());

                logger.debug("fioVari.getFioCmnd() :" + fioVari.getFioCmnd());
                logger.debug("fioCtts.getFioVcmn().getFioMod() :" + fioCtts.getFioVcmn().getFioMod());
            }
            else {
                logger.debug("DISPLAY 'ELIMINARA TAB'");

                logger.info("ELIMINARA TAB");

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //fioVari.setFioCmnd(0);
                //fioCtts.getFioVcmn().setFioDel(0);
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("MOVE FIO-DEL TO FIO-CMND");

                fioVari.setFioCmnd(fioCtts.getFioVcmn().getFioDel());

                logger.debug("fioVari.getFioCmnd() :" + fioVari.getFioCmnd());
                logger.debug("fioCtts.getFioVcmn().getFioDel() :" + fioCtts.getFioVcmn().getFioDel());
            }
        }
        else {

            if (wssSwiCrga.equals("C")) {

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //tab.setValue("                                                                                                                                                                                                  ");
                //wssTab.setValue("                                                                                                                                                                                                                                                ");
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("MOVE WSS-TAB TO TAB");

                tab.setValue(wssTab.getValue());

                logger.debug("tab.getValue() :" + tab.getValue());
                logger.debug("wssTab.getValue() :" + wssTab.getValue());

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //fioVari.setFioCmnd(0);
                //fioCtts.getFioVcmn().setFioPut(0);
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("MOVE FIO-PUT TO FIO-CMND");

                fioVari.setFioCmnd(fioCtts.getFioVcmn().getFioPut());

                logger.debug("fioVari.getFioCmnd() :" + fioVari.getFioCmnd());
                logger.debug("fioCtts.getFioVcmn().getFioPut() :" + fioCtts.getFioVcmn().getFioPut());
            }
            else {
                logger.debug("GO TO FIN-PRO-ACT-TAB");


                logger.debug("saliendo de 'proActTab_iniProActTab()' ...");
                return "proActTab_finProActTab";
            }
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioVari.getFioVoid().setFioSist("   ");
        //wssVari.setWssSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE WSS-SIST TO FIO-SIST");

        fioVari.getFioVoid().setFioSist(wssVari.getWssSist());

        logger.debug("fioVari.getFioVoid().getFioSist() :" + fioVari.getFioVoid().getFioSist());
        logger.debug("wssVari.getWssSist() :" + wssVari.getWssSist());

        execute("gnsFioTab");

        if (!fioVari.getFioStat().isFioStatOks()) {

            if (fioVari.getFioCmnd() == fioCtts.getFioVcmn().getFioPut()) {

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //wssTot.setWssTabErp(0);
                //wssTot.setWssTabErp(0);
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("ADD 1 TO WSS-TAB-ERP");

                wssTot.setWssTabErp(1 + wssTot.getWssTabErp());

                logger.debug("wssTot.getWssTabErp() :" + wssTot.getWssTabErp());
                logger.debug("wssTot.getWssTabErp() :" + wssTot.getWssTabErp());
                logger.debug("DISPLAY 'ERROR AL GRABAR TAB '");

                logger.info("ERROR AL GRABAR TAB ");

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //fioVari.getFioStat().setValue("  ");
                //tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().setTabCodCtab("            ");
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("DISPLAY 'FIO-STAT TAB          : ' FIO-STAT ' ' TAB-COD-CTAB IN TAB");

                logger.info("FIO-STAT TAB          : " + fioVari.getFioStat().getValue() + " " + tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getTabCodCtab());

                logger.debug("fioVari.getFioStat().getValue() :" + fioVari.getFioStat().getValue());
                logger.debug("tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getTabCodCtab() :" + tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getTabCodCtab());
            }
            else {

                if (fioVari.getFioCmnd() == fioCtts.getFioVcmn().getFioDel()) {

                    //// setters /////////////////////////////////////////////////////////////////////////////////
                    //wssTot.setWssTabEre(0);
                    //wssTot.setWssTabEre(0);
                    //////////////////////////////////////////////////////////////////////////////////////////////
                    logger.debug("ADD 1 TO WSS-TAB-ERE");

                    wssTot.setWssTabEre(1 + wssTot.getWssTabEre());

                    logger.debug("wssTot.getWssTabEre() :" + wssTot.getWssTabEre());
                    logger.debug("wssTot.getWssTabEre() :" + wssTot.getWssTabEre());
                    logger.debug("DISPLAY 'ERROR AL ELIMINAR   '");

                    logger.info("ERROR AL ELIMINAR   ");

                    //// setters /////////////////////////////////////////////////////////////////////////////////
                    //fioVari.getFioStat().setValue("  ");
                    //tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().setTabCodCtab("            ");
                    //////////////////////////////////////////////////////////////////////////////////////////////
                    logger.debug("DISPLAY 'FIO-STAT TAB-COD-CTAB : ' FIO-STAT ' ' TAB-COD-CTAB IN TAB");

                    logger.info("FIO-STAT TAB-COD-CTAB : " + fioVari.getFioStat().getValue() + " " + tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getTabCodCtab());

                    logger.debug("fioVari.getFioStat().getValue() :" + fioVari.getFioStat().getValue());
                    logger.debug("tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getTabCodCtab() :" + tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getTabCodCtab());
                }
                else {

                    if (wssSwiCrga.equals("D")) {

                        //// setters /////////////////////////////////////////////////////////////////////////////////
                        //wssTot.setWssTabEre(0);
                        //wssTot.setWssTabEre(0);
                        //////////////////////////////////////////////////////////////////////////////////////////////
                        logger.debug("ADD 1 TO WSS-TAB-ERE");

                        wssTot.setWssTabEre(1 + wssTot.getWssTabEre());

                        logger.debug("wssTot.getWssTabEre() :" + wssTot.getWssTabEre());
                        logger.debug("wssTot.getWssTabEre() :" + wssTot.getWssTabEre());
                        logger.debug("DISPLAY 'ERROR AL ELIMINAR TAB '");

                        logger.info("ERROR AL ELIMINAR TAB ");

                        //// setters /////////////////////////////////////////////////////////////////////////////////
                        //fioVari.getFioStat().setValue("  ");
                        //tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().setTabCodCtab("            ");
                        //////////////////////////////////////////////////////////////////////////////////////////////
                        logger.debug("DISPLAY 'FIO-STAT TAB-COD-CTAB : ' FIO-STAT ' ' TAB-COD-CTAB IN TAB");

                        logger.info("FIO-STAT TAB-COD-CTAB : " + fioVari.getFioStat().getValue() + " " + tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getTabCodCtab());

                        logger.debug("fioVari.getFioStat().getValue() :" + fioVari.getFioStat().getValue());
                        logger.debug("tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getTabCodCtab() :" + tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getTabCodCtab());
                    }
                    else {

                        //// setters /////////////////////////////////////////////////////////////////////////////////
                        //wssTot.setWssTabErm(0);
                        //wssTot.setWssTabErm(0);
                        //////////////////////////////////////////////////////////////////////////////////////////////
                        logger.debug("ADD 1 TO WSS-TAB-ERM");

                        wssTot.setWssTabErm(1 + wssTot.getWssTabErm());

                        logger.debug("wssTot.getWssTabErm() :" + wssTot.getWssTabErm());
                        logger.debug("wssTot.getWssTabErm() :" + wssTot.getWssTabErm());
                        logger.debug("DISPLAY 'ERROR AL MODIFICAR TAB '");

                        logger.info("ERROR AL MODIFICAR TAB ");

                        //// setters /////////////////////////////////////////////////////////////////////////////////
                        //fioVari.getFioStat().setValue("  ");
                        //tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().setTabCodCtab("            ");
                        //////////////////////////////////////////////////////////////////////////////////////////////
                        logger.debug("DISPLAY 'FIO-STAT TAB-COD-CTAB : ' FIO-STAT ' ' TAB-COD-CTAB IN TAB");

                        logger.info("FIO-STAT TAB-COD-CTAB : " + fioVari.getFioStat().getValue() + " " + tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getTabCodCtab());

                        logger.debug("fioVari.getFioStat().getValue() :" + fioVari.getFioStat().getValue());
                        logger.debug("tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getTabCodCtab() :" + tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getTabCodCtab());
                    }
                }
            }
        }
        else {

            if (fioVari.getFioCmnd() == fioCtts.getFioVcmn().getFioPut()) {

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().setTabCodCtab("            ");
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("DISPLAY TAB-COD-CTAB '           : TAB INGRESADO'");

                logger.info(tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getTabCodCtab() + "           : TAB INGRESADO");

                logger.debug("tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getTabCodCtab() :" + tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getTabCodCtab());

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //wssTot.setWssTabPut(0);
                //wssTot.setWssTabPut(0);
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("ADD 1 TO WSS-TAB-PUT");

                wssTot.setWssTabPut(1 + wssTot.getWssTabPut());

                logger.debug("wssTot.getWssTabPut() :" + wssTot.getWssTabPut());
                logger.debug("wssTot.getWssTabPut() :" + wssTot.getWssTabPut());
            }
            else {

                if (fioVari.getFioCmnd() == fioCtts.getFioVcmn().getFioDel()) {

                    //// setters /////////////////////////////////////////////////////////////////////////////////
                    //tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().setTabCodCtab("            ");
                    //////////////////////////////////////////////////////////////////////////////////////////////
                    logger.debug("DISPLAY TAB-COD-CTAB '           : TAB ELIMINADO'");

                    logger.info(tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getTabCodCtab() + "           : TAB ELIMINADO");

                    logger.debug("tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getTabCodCtab() :" + tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getTabCodCtab());

                    //// setters /////////////////////////////////////////////////////////////////////////////////
                    //wssTot.setWssTabEli(0);
                    //wssTot.setWssTabEli(0);
                    //////////////////////////////////////////////////////////////////////////////////////////////
                    logger.debug("ADD 1 TO WSS-TAB-ELI");

                    wssTot.setWssTabEli(1 + wssTot.getWssTabEli());

                    logger.debug("wssTot.getWssTabEli() :" + wssTot.getWssTabEli());
                    logger.debug("wssTot.getWssTabEli() :" + wssTot.getWssTabEli());
                }
                else {

                    //// setters /////////////////////////////////////////////////////////////////////////////////
                    //tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().setTabCodCtab("            ");
                    //////////////////////////////////////////////////////////////////////////////////////////////
                    logger.debug("DISPLAY TAB-COD-CTAB '           : TAB MODIFICADO'");

                    logger.info(tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getTabCodCtab() + "           : TAB MODIFICADO");

                    logger.debug("tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getTabCodCtab() :" + tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getTabCodCtab());

                    //// setters /////////////////////////////////////////////////////////////////////////////////
                    //wssTot.setWssTabMod(0);
                    //wssTot.setWssTabMod(0);
                    //////////////////////////////////////////////////////////////////////////////////////////////
                    logger.debug("ADD 1 TO WSS-TAB-MOD");

                    wssTot.setWssTabMod(1 + wssTot.getWssTabMod());

                    logger.debug("wssTot.getWssTabMod() :" + wssTot.getWssTabMod());
                    logger.debug("wssTot.getWssTabMod() :" + wssTot.getWssTabMod());
                }
            }
        }

        logger.debug("saliendo de 'proActTab_iniProActTab()' ...");

        return "proActTab_finProActTab";
    }

    /******************************************************************************
     * proActTab_finProActTab
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String proActTab_finProActTab() {

        logger.debug("entrando a 'proActTab_finProActTab()' ...");

        logger.debug("saliendo de 'proActTab_finProActTab()' ...");

        return null;
    }

    /******************************************************************************
     * dspStd
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String dspStd() {

        logger.debug("entrando a 'dspStd()' ...");

        execute("dspStd_iniDspStd");

        logger.debug("saliendo de 'dspStd()' ...");

        return null;
    }

    /******************************************************************************
     * dspStd_iniDspStd
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String dspStd_iniDspStd() {

        logger.debug("entrando a 'dspStd_iniDspStd()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioVari.setFioCmnd(0);
        //fioCtts.getFioVcmn().setFioClo(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE FIO-CLO TO FIO-CMND");

        fioVari.setFioCmnd(fioCtts.getFioVcmn().getFioClo());

        logger.debug("fioVari.getFioCmnd() :" + fioVari.getFioCmnd());
        logger.debug("fioCtts.getFioVcmn().getFioClo() :" + fioCtts.getFioVcmn().getFioClo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioVari.getFioVoid().setFioSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'GNS' TO FIO-SIST");

        fioVari.getFioVoid().setFioSist("GNS");

        logger.debug("fioVari.getFioVoid().getFioSist() :" + fioVari.getFioVoid().getFioSist());

        execute("gnsFioMnu");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioVari.setFioCmnd(0);
        //fioCtts.getFioVcmn().setFioClo(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE FIO-CLO TO FIO-CMND");

        fioVari.setFioCmnd(fioCtts.getFioVcmn().getFioClo());

        logger.debug("fioVari.getFioCmnd() :" + fioVari.getFioCmnd());
        logger.debug("fioCtts.getFioVcmn().getFioClo() :" + fioCtts.getFioVcmn().getFioClo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioVari.getFioVoid().setFioSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'GNS' TO FIO-SIST");

        fioVari.getFioVoid().setFioSist("GNS");

        logger.debug("fioVari.getFioVoid().getFioSist() :" + fioVari.getFioVoid().getFioSist());

        execute("gnsFioRpf");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssTot.setWssMnuErpEdt(0);
        //wssTot.setWssMnuErp(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE WSS-MNU-ERP TO WSS-MNU-ERP-EDT");

        wssTot.setWssMnuErpEdt(wssTot.getWssMnuErp());

        logger.debug("wssTot.getWssMnuErpEdt() :" + wssTot.getWssMnuErpEdt());
        logger.debug("wssTot.getWssMnuErp() :" + wssTot.getWssMnuErp());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssTot.setWssMnuErmEdt(0);
        //wssTot.setWssMnuErm(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE WSS-MNU-ERM TO WSS-MNU-ERM-EDT");

        wssTot.setWssMnuErmEdt(wssTot.getWssMnuErm());

        logger.debug("wssTot.getWssMnuErmEdt() :" + wssTot.getWssMnuErmEdt());
        logger.debug("wssTot.getWssMnuErm() :" + wssTot.getWssMnuErm());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssTot.setWssMnuEreEdt(0);
        //wssTot.setWssMnuEre(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE WSS-MNU-ERE TO WSS-MNU-ERE-EDT");

        wssTot.setWssMnuEreEdt(wssTot.getWssMnuEre());

        logger.debug("wssTot.getWssMnuEreEdt() :" + wssTot.getWssMnuEreEdt());
        logger.debug("wssTot.getWssMnuEre() :" + wssTot.getWssMnuEre());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssTot.setWssMnuPutEdt(0);
        //wssTot.setWssMnuPut(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE WSS-MNU-PUT TO WSS-MNU-PUT-EDT");

        wssTot.setWssMnuPutEdt(wssTot.getWssMnuPut());

        logger.debug("wssTot.getWssMnuPutEdt() :" + wssTot.getWssMnuPutEdt());
        logger.debug("wssTot.getWssMnuPut() :" + wssTot.getWssMnuPut());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssTot.setWssMnuModEdt(0);
        //wssTot.setWssMnuMod(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE WSS-MNU-MOD TO WSS-MNU-MOD-EDT");

        wssTot.setWssMnuModEdt(wssTot.getWssMnuMod());

        logger.debug("wssTot.getWssMnuModEdt() :" + wssTot.getWssMnuModEdt());
        logger.debug("wssTot.getWssMnuMod() :" + wssTot.getWssMnuMod());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssTot.setWssMnuEliEdt(0);
        //wssTot.setWssMnuEli(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE WSS-MNU-ELI TO WSS-MNU-ELI-EDT");

        wssTot.setWssMnuEliEdt(wssTot.getWssMnuEli());

        logger.debug("wssTot.getWssMnuEliEdt() :" + wssTot.getWssMnuEliEdt());
        logger.debug("wssTot.getWssMnuEli() :" + wssTot.getWssMnuEli());
        logger.debug("DISPLAY '===== ESTADISTICAS MNU ====='");

        logger.info("===== ESTADISTICAS MNU =====");
        logger.debug("DISPLAY 'PUT OK      MOD OK      ELI OK      PUT ERR' '      MOD ERR      ELI ERR'");

        logger.info("PUT OK      MOD OK      ELI OK      PUT ERR      MOD ERR      ELI ERR");
        logger.debug("DISPLAY '======      ======      ======      =======' '      =======      ======='");

        logger.info("======      ======      ======      =======      =======      =======");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssTot.setWssMnuPutEdt(0);
        //wssTot.setWssMnuModEdt(0);
        //wssTot.setWssMnuEliEdt(0);
        //wssTot.setWssMnuErpEdt(0);
        //wssTot.setWssMnuErmEdt(0);
        //wssTot.setWssMnuEreEdt(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("DISPLAY ' ' WSS-MNU-PUT-EDT '       ' WSS-MNU-MOD-EDT '       ' WSS-MNU-ELI-EDT '        ' WSS-MNU-ERP-EDT '        ' WSS-MNU-ERM-EDT '        ' WSS-MNU-ERE-EDT");

        logger.info(" " + wssTot.getWssMnuPutEdt() + "       " + wssTot.getWssMnuModEdt() + "       " + wssTot.getWssMnuEliEdt() + "        " + wssTot.getWssMnuErpEdt() + "        " + wssTot.getWssMnuErmEdt() + "        " + wssTot.getWssMnuEreEdt());

        logger.debug("wssTot.getWssMnuPutEdt() :" + wssTot.getWssMnuPutEdt());
        logger.debug("wssTot.getWssMnuModEdt() :" + wssTot.getWssMnuModEdt());
        logger.debug("wssTot.getWssMnuEliEdt() :" + wssTot.getWssMnuEliEdt());
        logger.debug("wssTot.getWssMnuErpEdt() :" + wssTot.getWssMnuErpEdt());
        logger.debug("wssTot.getWssMnuErmEdt() :" + wssTot.getWssMnuErmEdt());
        logger.debug("wssTot.getWssMnuEreEdt() :" + wssTot.getWssMnuEreEdt());
        logger.debug("DISPLAY ' '");

        logger.info(" ");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssTot.setWssRpfErpEdt(0);
        //wssTot.setWssRpfErp(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE WSS-RPF-ERP TO WSS-RPF-ERP-EDT");

        wssTot.setWssRpfErpEdt(wssTot.getWssRpfErp());

        logger.debug("wssTot.getWssRpfErpEdt() :" + wssTot.getWssRpfErpEdt());
        logger.debug("wssTot.getWssRpfErp() :" + wssTot.getWssRpfErp());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssTot.setWssRpfErmEdt(0);
        //wssTot.setWssRpfErm(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE WSS-RPF-ERM TO WSS-RPF-ERM-EDT");

        wssTot.setWssRpfErmEdt(wssTot.getWssRpfErm());

        logger.debug("wssTot.getWssRpfErmEdt() :" + wssTot.getWssRpfErmEdt());
        logger.debug("wssTot.getWssRpfErm() :" + wssTot.getWssRpfErm());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssTot.setWssRpfEreEdt(0);
        //wssTot.setWssRpfEre(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE WSS-RPF-ERE TO WSS-RPF-ERE-EDT");

        wssTot.setWssRpfEreEdt(wssTot.getWssRpfEre());

        logger.debug("wssTot.getWssRpfEreEdt() :" + wssTot.getWssRpfEreEdt());
        logger.debug("wssTot.getWssRpfEre() :" + wssTot.getWssRpfEre());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssTot.setWssRpfPutEdt(0);
        //wssTot.setWssRpfPut(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE WSS-RPF-PUT TO WSS-RPF-PUT-EDT");

        wssTot.setWssRpfPutEdt(wssTot.getWssRpfPut());

        logger.debug("wssTot.getWssRpfPutEdt() :" + wssTot.getWssRpfPutEdt());
        logger.debug("wssTot.getWssRpfPut() :" + wssTot.getWssRpfPut());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssTot.setWssRpfModEdt(0);
        //wssTot.setWssRpfMod(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE WSS-RPF-MOD TO WSS-RPF-MOD-EDT");

        wssTot.setWssRpfModEdt(wssTot.getWssRpfMod());

        logger.debug("wssTot.getWssRpfModEdt() :" + wssTot.getWssRpfModEdt());
        logger.debug("wssTot.getWssRpfMod() :" + wssTot.getWssRpfMod());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssTot.setWssRpfEliEdt(0);
        //wssTot.setWssRpfEli(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE WSS-RPF-ELI TO WSS-RPF-ELI-EDT");

        wssTot.setWssRpfEliEdt(wssTot.getWssRpfEli());

        logger.debug("wssTot.getWssRpfEliEdt() :" + wssTot.getWssRpfEliEdt());
        logger.debug("wssTot.getWssRpfEli() :" + wssTot.getWssRpfEli());
        logger.debug("DISPLAY '===== ESTADISTICAS RPF ====='");

        logger.info("===== ESTADISTICAS RPF =====");
        logger.debug("DISPLAY 'PUT OK      MOD OK      ELI OK      PUT ERR' '      MOD ERR      ELI ERR'");

        logger.info("PUT OK      MOD OK      ELI OK      PUT ERR      MOD ERR      ELI ERR");
        logger.debug("DISPLAY '======      ======      ======      =======' '      =======      ======='");

        logger.info("======      ======      ======      =======      =======      =======");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssTot.setWssRpfPutEdt(0);
        //wssTot.setWssRpfModEdt(0);
        //wssTot.setWssRpfEliEdt(0);
        //wssTot.setWssRpfErpEdt(0);
        //wssTot.setWssRpfErmEdt(0);
        //wssTot.setWssRpfEreEdt(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("DISPLAY ' ' WSS-RPF-PUT-EDT '       ' WSS-RPF-MOD-EDT '       ' WSS-RPF-ELI-EDT '        ' WSS-RPF-ERP-EDT '        ' WSS-RPF-ERM-EDT '        ' WSS-RPF-ERE-EDT");

        logger.info(" " + wssTot.getWssRpfPutEdt() + "       " + wssTot.getWssRpfModEdt() + "       " + wssTot.getWssRpfEliEdt() + "        " + wssTot.getWssRpfErpEdt() + "        " + wssTot.getWssRpfErmEdt() + "        " + wssTot.getWssRpfEreEdt());

        logger.debug("wssTot.getWssRpfPutEdt() :" + wssTot.getWssRpfPutEdt());
        logger.debug("wssTot.getWssRpfModEdt() :" + wssTot.getWssRpfModEdt());
        logger.debug("wssTot.getWssRpfEliEdt() :" + wssTot.getWssRpfEliEdt());
        logger.debug("wssTot.getWssRpfErpEdt() :" + wssTot.getWssRpfErpEdt());
        logger.debug("wssTot.getWssRpfErmEdt() :" + wssTot.getWssRpfErmEdt());
        logger.debug("wssTot.getWssRpfEreEdt() :" + wssTot.getWssRpfEreEdt());
        logger.debug("DISPLAY ' '");

        logger.info(" ");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssTot.setWssTabErpEdt(0);
        //wssTot.setWssTabErp(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE WSS-TAB-ERP TO WSS-TAB-ERP-EDT");

        wssTot.setWssTabErpEdt(wssTot.getWssTabErp());

        logger.debug("wssTot.getWssTabErpEdt() :" + wssTot.getWssTabErpEdt());
        logger.debug("wssTot.getWssTabErp() :" + wssTot.getWssTabErp());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssTot.setWssTabErmEdt(0);
        //wssTot.setWssTabErm(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE WSS-TAB-ERM TO WSS-TAB-ERM-EDT");

        wssTot.setWssTabErmEdt(wssTot.getWssTabErm());

        logger.debug("wssTot.getWssTabErmEdt() :" + wssTot.getWssTabErmEdt());
        logger.debug("wssTot.getWssTabErm() :" + wssTot.getWssTabErm());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssTot.setWssTabEreEdt(0);
        //wssTot.setWssTabEre(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE WSS-TAB-ERE TO WSS-TAB-ERE-EDT");

        wssTot.setWssTabEreEdt(wssTot.getWssTabEre());

        logger.debug("wssTot.getWssTabEreEdt() :" + wssTot.getWssTabEreEdt());
        logger.debug("wssTot.getWssTabEre() :" + wssTot.getWssTabEre());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssTot.setWssTabPutEdt(0);
        //wssTot.setWssTabPut(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE WSS-TAB-PUT TO WSS-TAB-PUT-EDT");

        wssTot.setWssTabPutEdt(wssTot.getWssTabPut());

        logger.debug("wssTot.getWssTabPutEdt() :" + wssTot.getWssTabPutEdt());
        logger.debug("wssTot.getWssTabPut() :" + wssTot.getWssTabPut());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssTot.setWssTabModEdt(0);
        //wssTot.setWssTabMod(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE WSS-TAB-MOD TO WSS-TAB-MOD-EDT");

        wssTot.setWssTabModEdt(wssTot.getWssTabMod());

        logger.debug("wssTot.getWssTabModEdt() :" + wssTot.getWssTabModEdt());
        logger.debug("wssTot.getWssTabMod() :" + wssTot.getWssTabMod());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssTot.setWssTabEliEdt(0);
        //wssTot.setWssTabEli(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE WSS-TAB-ELI TO WSS-TAB-ELI-EDT");

        wssTot.setWssTabEliEdt(wssTot.getWssTabEli());

        logger.debug("wssTot.getWssTabEliEdt() :" + wssTot.getWssTabEliEdt());
        logger.debug("wssTot.getWssTabEli() :" + wssTot.getWssTabEli());
        logger.debug("DISPLAY '===== ESTADISTICAS TAB ====='");

        logger.info("===== ESTADISTICAS TAB =====");
        logger.debug("DISPLAY 'PUT OK      MOD OK      ELI OK      PUT ERR' '      MOD ERR      ELI ERR'");

        logger.info("PUT OK      MOD OK      ELI OK      PUT ERR      MOD ERR      ELI ERR");
        logger.debug("DISPLAY '======      ======      ======      =======' '      =======      ======='");

        logger.info("======      ======      ======      =======      =======      =======");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //wssTot.setWssTabPutEdt(0);
        //wssTot.setWssTabModEdt(0);
        //wssTot.setWssTabEliEdt(0);
        //wssTot.setWssTabErpEdt(0);
        //wssTot.setWssTabErmEdt(0);
        //wssTot.setWssTabEreEdt(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("DISPLAY ' ' WSS-TAB-PUT-EDT '       ' WSS-TAB-MOD-EDT '       ' WSS-TAB-ELI-EDT '        ' WSS-TAB-ERP-EDT '        ' WSS-TAB-ERM-EDT '        ' WSS-TAB-ERE-EDT");

        logger.info(" " + wssTot.getWssTabPutEdt() + "       " + wssTot.getWssTabModEdt() + "       " + wssTot.getWssTabEliEdt() + "        " + wssTot.getWssTabErpEdt() + "        " + wssTot.getWssTabErmEdt() + "        " + wssTot.getWssTabEreEdt());

        logger.debug("wssTot.getWssTabPutEdt() :" + wssTot.getWssTabPutEdt());
        logger.debug("wssTot.getWssTabModEdt() :" + wssTot.getWssTabModEdt());
        logger.debug("wssTot.getWssTabEliEdt() :" + wssTot.getWssTabEliEdt());
        logger.debug("wssTot.getWssTabErpEdt() :" + wssTot.getWssTabErpEdt());
        logger.debug("wssTot.getWssTabErmEdt() :" + wssTot.getWssTabErmEdt());
        logger.debug("wssTot.getWssTabEreEdt() :" + wssTot.getWssTabEreEdt());
        logger.debug("DISPLAY ' '");

        logger.info(" ");

        logger.debug("saliendo de 'dspStd_iniDspStd()' ...");

        return "dspStd_finDspStd";
    }

    /******************************************************************************
     * dspStd_finDspStd
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String dspStd_finDspStd() {

        logger.debug("entrando a 'dspStd_finDspStd()' ...");

        logger.debug("saliendo de 'dspStd_finDspStd()' ...");

        return null;
    }

    /******************************************************************************
     * gnsFioMnu
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsFioMnu() {

        logger.debug("entrando a 'gnsFioMnu()' ...");

        execute("gnsFioMnu_iniGnsFioMnu");

        logger.debug("saliendo de 'gnsFioMnu()' ...");

        return null;
    }

    /******************************************************************************
     * gnsFioMnu_iniGnsFioMnu
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsFioMnu_iniGnsFioMnu() {

        logger.debug("entrando a 'gnsFioMnu_iniGnsFioMnu()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //adrReqa.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ");
        //adrMnuReqa.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE ADR-MNU-REQA TO ADR-REQA");

        adrReqa.setValue(adrMnuReqa.getValue());

        logger.debug("adrReqa.getValue() :" + adrReqa.getValue());
        logger.debug("adrMnuReqa.getValue() :" + adrMnuReqa.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //adrReqa.setAdrTabl("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'MNU' TO ADR-TABL IN ADR-REQA");

        adrReqa.setAdrTabl("MNU");

        logger.debug("adrReqa.getAdrTabl() :" + adrReqa.getAdrTabl());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddDaux().setIddSaux("   ");
        //fioVari.getFioVoid().setFioSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE FIO-SIST TO IDD-SAUX");

        iddVari.getIddDaux().setIddSaux(fioVari.getFioVoid().getFioSist());

        logger.debug("iddVari.getIddDaux().getIddSaux() :" + iddVari.getIddDaux().getIddSaux());
        logger.debug("fioVari.getFioVoid().getFioSist() :" + fioVari.getFioVoid().getFioSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddDaux().setIddGaux(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'C' TO IDD-GAUX");

        iddVari.getIddDaux().setIddGaux("C");

        logger.debug("iddVari.getIddDaux().getIddGaux() :" + iddVari.getIddDaux().getIddGaux());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddDaux().setIddRaux("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO IDD-RAUX");

        iddVari.getIddDaux().setIddRaux(Util.spaces(3));

        logger.debug("iddVari.getIddDaux().getIddRaux() :" + iddVari.getIddDaux().getIddRaux());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.setIddIaux(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 1 TO IDD-IAUX");

        iddVari.setIddIaux(1);

        logger.debug("iddVari.getIddIaux() :" + iddVari.getIddIaux());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddItbl = 0;
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("SET IDD-ITBL TO 1");

        iddItbl = 1;

        logger.debug("iddItbl :" + iddItbl);

        for ( ; iddVari.getIddIaux() <= iddVari.getIddRegi().getIddFsis().getIddVsisSize(); iddVari.setIddIaux(iddVari.getIddIaux() + 1)) {

            if (iddVari.getIddRegi().getIddFsis().getIddVsis(iddItbl - 1).getIddDent().getValue().equals(iddVari.getIddDaux().getValue())) {
                logger.debug("GO TO FSR-GNS-FIO-MNU");


                logger.debug("saliendo de 'gnsFioMnu_iniGnsFioMnu()' ...");
                return "gnsFioMnu_fsrGnsFioMnu";
            }
        }

        logger.debug("saliendo de 'gnsFioMnu_iniGnsFioMnu()' ...");

        return "gnsFioMnu_grpGnsFioMnu";
    }

    /******************************************************************************
     * gnsFioMnu_grpGnsFioMnu
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsFioMnu_grpGnsFioMnu() {

        logger.debug("entrando a 'gnsFioMnu_grpGnsFioMnu()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddDaux().setIddGaux(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO IDD-GAUX");

        iddVari.getIddDaux().setIddGaux(Util.spaces(1));

        logger.debug("iddVari.getIddDaux().getIddGaux() :" + iddVari.getIddDaux().getIddGaux());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.setIddIaux(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 1 TO IDD-IAUX");

        iddVari.setIddIaux(1);

        logger.debug("iddVari.getIddIaux() :" + iddVari.getIddIaux());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddItbl = 0;
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("SET IDD-ITBL TO 1");

        iddItbl = 1;

        logger.debug("iddItbl :" + iddItbl);

        boolean at_end = true;

        for ( ; iddVari.getIddIaux() <= iddVari.getIddRegi().getIddFsis().getIddVsisSize(); iddVari.setIddIaux(iddVari.getIddIaux() + 1)) {

            if (iddVari.getIddRegi().getIddFsis().getIddVsis(iddItbl - 1).getIddDent().getValue().equals(iddVari.getIddDaux().getValue())) {

                at_end = false;

                break;
            }
        }

        if (at_end) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioCtts.getFioMens().setFioMen1("                                                                       ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE 'En GNS-FIO-MNU, NO existe en IDD:' TO FIO-MEN1");

            fioCtts.getFioMens().setFioMen1("En GNS-FIO-MNU, NO existe en IDD:");

            logger.debug("fioCtts.getFioMens().getFioMen1() :" + fioCtts.getFioMens().getFioMen1());

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioCtts.getFioMens().setFioMen2("         ");
            //iddVari.getIddDaux().setValue("       ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE IDD-DAUX TO FIO-MEN2");

            fioCtts.getFioMens().setFioMen2(iddVari.getIddDaux().getValue());

            logger.debug("fioCtts.getFioMens().getFioMen2() :" + fioCtts.getFioMens().getFioMen2());
            logger.debug("iddVari.getIddDaux().getValue() :" + iddVari.getIddDaux().getValue());
            logger.debug("DISPLAY 'ABORTO NO ENCONTRO IDD'");

            logger.info("ABORTO NO ENCONTRO IDD");

            execute("prgAbt");
        }

        logger.debug("saliendo de 'gnsFioMnu_grpGnsFioMnu()' ...");

        return "gnsFioMnu_fsrGnsFioMnu";
    }

    /******************************************************************************
     * gnsFioMnu_fsrGnsFioMnu
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsFioMnu_fsrGnsFioMnu() {

        logger.debug("entrando a 'gnsFioMnu_fsrGnsFioMnu()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //adrReqa.setAdrDbid(0);
        //iddItbl = 0;
        //iddVari.getIddRegi().getIddFsis().getIddVsis(iddItbl - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE IDD-IENT( IDD-ITBL) TO ADR-DBID IN ADR-REQA");

        adrReqa.setAdrDbid(Integer.parseInt(iddVari.getIddRegi().getIddFsis().getIddVsis(iddItbl - 1).getIddIent()));

        logger.debug("adrReqa.getAdrDbid() :" + adrReqa.getAdrDbid());
        logger.debug("iddItbl :" + iddItbl);
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(iddItbl - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(iddItbl - 1).getIddIent());

        if (fioVari.getFioAkey().compareTo(Util.spaces(32)) <= 0) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioVari.setFioAkey("                                ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE 'MNU-COD-NEMO' TO FIO-AKEY");

            fioVari.setFioAkey("MNU-COD-NEMO");

            logger.debug("fioVari.getFioAkey() :" + fioVari.getFioAkey());
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //adrElls.setAdrElm1("     ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'MNU00' TO ADR-ELM1");

        adrElls.setAdrElm1("MNU00");

        logger.debug("adrElls.getAdrElm1() :" + adrElls.getAdrElm1());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //adrUifb.setAdrProg("        ");
        //fioCtts.setFioProg("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE FIO-PROG TO ADR-PROG");

        adrUifb.setAdrProg(fioCtts.getFioProg());

        logger.debug("adrUifb.getAdrProg() :" + adrUifb.getAdrProg());
        logger.debug("fioCtts.getFioProg() :" + fioCtts.getFioProg());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioCtts.setFioIaky(0);
        //fioVari.setFioCmnd(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE FIO-CMND TO FIO-IAKY");

        fioCtts.setFioIaky(fioVari.getFioCmnd());

        logger.debug("fioCtts.getFioIaky() :" + fioCtts.getFioIaky());
        logger.debug("fioVari.getFioCmnd() :" + fioVari.getFioCmnd());

        if (!fioCtts.isFioIakyCon() && (fioVari.getFioAkey().equals("MNU-COD-NEMO") || fioVari.getFioAkey().compareTo(Util.spaces(32)) <= 0)) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //adrReqa.setAdrVkey("                                                                                                                                                                                    ");
            //mnu.getMnuCodNems().getMnuCodNemo().setValue("            ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE MNU-COD-NEMO IN MNU TO ADR-VKEY IN ADR-REQA");

            adrReqa.setAdrVkey(mnu.getMnuCodNems().getMnuCodNemo().getValue());

            logger.debug("adrReqa.getAdrVkey() :" + adrReqa.getAdrVkey());
            logger.debug("mnu.getMnuCodNems().getMnuCodNemo().getValue() :" + mnu.getMnuCodNems().getMnuCodNemo().getValue());

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //adrReqa.setAdrDkey("     ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE 'MNU00' TO ADR-DKEY IN ADR-REQA");

            adrReqa.setAdrDkey("MNU00");

            logger.debug("adrReqa.getAdrDkey() :" + adrReqa.getAdrDkey());
        }
        else {

            if (fioVari.getFioAkey().equals("MNU-COD-OPCI")) {

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //adrReqa.setAdrVkey("                                                                                                                                                                                    ");
                //mnu.getMnuCodOpcs().getMnuCodIpcn().setMnuCodOpci("   ");
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("MOVE MNU-COD-OPCI IN MNU TO ADR-VKEY IN ADR-REQA");

                adrReqa.setAdrVkey(mnu.getMnuCodOpcs().getMnuCodIpcn().getMnuCodOpci());

                logger.debug("adrReqa.getAdrVkey() :" + adrReqa.getAdrVkey());
                logger.debug("mnu.getMnuCodOpcs().getMnuCodIpcn().getMnuCodOpci() :" + mnu.getMnuCodOpcs().getMnuCodIpcn().getMnuCodOpci());

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //adrReqa.setAdrDkey("     ");
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("MOVE 'MNU01' TO ADR-DKEY IN ADR-REQA");

                adrReqa.setAdrDkey("MNU01");

                logger.debug("adrReqa.getAdrDkey() :" + adrReqa.getAdrDkey());
            }
            else {

                if (fioVari.getFioAkey().equals("MNU-COD-IMEN")) {

                    //// setters /////////////////////////////////////////////////////////////////////////////////
                    //adrReqa.setAdrVkey("                                                                                                                                                                                    ");
                    //mnu.getMnuCodImes().setValue("      ");
                    //////////////////////////////////////////////////////////////////////////////////////////////
                    logger.debug("MOVE MNU-COD-IMES IN MNU TO ADR-VKEY IN ADR-REQA");

                    adrReqa.setAdrVkey(mnu.getMnuCodImes().getValue());

                    logger.debug("adrReqa.getAdrVkey() :" + adrReqa.getAdrVkey());
                    logger.debug("mnu.getMnuCodImes().getValue() :" + mnu.getMnuCodImes().getValue());

                    //// setters /////////////////////////////////////////////////////////////////////////////////
                    //adrReqa.setAdrDkey("     ");
                    //////////////////////////////////////////////////////////////////////////////////////////////
                    logger.debug("MOVE 'MNU02' TO ADR-DKEY IN ADR-REQA");

                    adrReqa.setAdrDkey("MNU02");

                    logger.debug("adrReqa.getAdrDkey() :" + adrReqa.getAdrDkey());
                }
                else {

                    if (fioVari.getFioAkey().equals("MNU-COD-SYST")) {

                        //// setters /////////////////////////////////////////////////////////////////////////////////
                        //adrReqa.setAdrVkey("                                                                                                                                                                                    ");
                        //mnu.getMnuCodImes().setValue("      ");
                        //////////////////////////////////////////////////////////////////////////////////////////////
                        logger.debug("MOVE MNU-COD-IMES IN MNU TO ADR-VKEY IN ADR-REQA");

                        adrReqa.setAdrVkey(mnu.getMnuCodImes().getValue());

                        logger.debug("adrReqa.getAdrVkey() :" + adrReqa.getAdrVkey());
                        logger.debug("mnu.getMnuCodImes().getValue() :" + mnu.getMnuCodImes().getValue());

                        //// setters /////////////////////////////////////////////////////////////////////////////////
                        //adrReqa.setAdrDkey("     ");
                        //////////////////////////////////////////////////////////////////////////////////////////////
                        logger.debug("MOVE 'MNU03' TO ADR-DKEY IN ADR-REQA");

                        adrReqa.setAdrDkey("MNU03");

                        logger.debug("adrReqa.getAdrDkey() :" + adrReqa.getAdrDkey());
                    }
                    else {

                        //// setters /////////////////////////////////////////////////////////////////////////////////
                        //fioCtts.getFioMens().setValue("                                                                                ");
                        //////////////////////////////////////////////////////////////////////////////////////////////
                        logger.debug("MOVE 'En GNS-FIO-MNU, key' TO FIO-MENS");

                        fioCtts.getFioMens().setValue("En GNS-FIO-MNU, key");

                        logger.debug("fioCtts.getFioMens().getValue() :" + fioCtts.getFioMens().getValue());

                        //// setters /////////////////////////////////////////////////////////////////////////////////
                        //fioCtts.getFioMensRed().setFioMensKey("                                ");
                        //fioVari.setFioAkey("                                ");
                        //////////////////////////////////////////////////////////////////////////////////////////////
                        logger.debug("MOVE FIO-AKEY TO FIO-MENS-KEY");

                        fioCtts.getFioMensRed().setFioMensKey(fioVari.getFioAkey());

                        logger.debug("fioCtts.getFioMensRed().getFioMensKey() :" + fioCtts.getFioMensRed().getFioMensKey());
                        logger.debug("fioVari.getFioAkey() :" + fioVari.getFioAkey());

                        //// setters /////////////////////////////////////////////////////////////////////////////////
                        //fioCtts.getFioMensRed().setFioMensFil("         ");
                        //////////////////////////////////////////////////////////////////////////////////////////////
                        logger.debug("MOVE 'Invalida' TO FIO-MENS-FIL");

                        fioCtts.getFioMensRed().setFioMensFil("Invalida");

                        logger.debug("fioCtts.getFioMensRed().getFioMensFil() :" + fioCtts.getFioMensRed().getFioMensFil());

                        execute("prgAbt");
                    }
                }
            }
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioCtts.setFioDfld("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ");
        //mnu.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                 ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE MNU TO FIO-DFLD");

        fioCtts.setFioDfld(mnu.getValue());

        logger.debug("fioCtts.getFioDfld() :" + fioCtts.getFioDfld());
        logger.debug("mnu.getValue() :" + mnu.getValue());

        execute("gnsFioDtc");

        if (fioVari.getFioStat().isFioStatOks()) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //mnu.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                 ");
            //fioCtts.setFioDfld("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE FIO-DFLD TO MNU");

            mnu.setValue(fioCtts.getFioDfld());

            logger.debug("mnu.getValue() :" + mnu.getValue());
            logger.debug("fioCtts.getFioDfld() :" + fioCtts.getFioDfld());
        }
        else {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioCtts.getFioMensRed().getFioMensFilRed().setFioMensSis("   ");
            //fioVari.getFioVoid().setFioSist("   ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE FIO-SIST TO FIO-MENS-SIS");

            fioCtts.getFioMensRed().getFioMensFilRed().setFioMensSis(fioVari.getFioVoid().getFioSist());

            logger.debug("fioCtts.getFioMensRed().getFioMensFilRed().getFioMensSis() :" + fioCtts.getFioMensRed().getFioMensFilRed().getFioMensSis());
            logger.debug("fioVari.getFioVoid().getFioSist() :" + fioVari.getFioVoid().getFioSist());

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioCtts.getFioMensRed().getFioMensFilRed().setFioMensReg("      ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE 'MNU' TO FIO-MENS-REG");

            fioCtts.getFioMensRed().getFioMensFilRed().setFioMensReg("MNU");

            logger.debug("fioCtts.getFioMensRed().getFioMensFilRed().getFioMensReg() :" + fioCtts.getFioMensRed().getFioMensFilRed().getFioMensReg());

            if (fioVari.getFioStat().isFioStatFtl()) {

                execute("prgAbt");
            }
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioVari.setFioAkey("                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO FIO-AKEY");

        fioVari.setFioAkey(Util.spaces(32));

        logger.debug("fioVari.getFioAkey() :" + fioVari.getFioAkey());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //adrMnuReqa.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ");
        //adrReqa.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE ADR-REQA TO ADR-MNU-REQA");

        adrMnuReqa.setValue(adrReqa.getValue());

        logger.debug("adrMnuReqa.getValue() :" + adrMnuReqa.getValue());
        logger.debug("adrReqa.getValue() :" + adrReqa.getValue());

        logger.debug("saliendo de 'gnsFioMnu_fsrGnsFioMnu()' ...");

        return "gnsFioMnu_finGnsFioMnu";
    }

    /******************************************************************************
     * gnsFioMnu_finGnsFioMnu
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsFioMnu_finGnsFioMnu() {

        logger.debug("entrando a 'gnsFioMnu_finGnsFioMnu()' ...");

        logger.debug("saliendo de 'gnsFioMnu_finGnsFioMnu()' ...");

        return null;
    }

    /******************************************************************************
     * gnsFioRpf
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsFioRpf() {

        logger.debug("entrando a 'gnsFioRpf()' ...");

        execute("gnsFioRpf_iniGnsFioRpf");

        logger.debug("saliendo de 'gnsFioRpf()' ...");

        return null;
    }

    /******************************************************************************
     * gnsFioRpf_iniGnsFioRpf
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsFioRpf_iniGnsFioRpf() {

        logger.debug("entrando a 'gnsFioRpf_iniGnsFioRpf()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //adrReqa.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ");
        //adrRpfReqa.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE ADR-RPF-REQA TO ADR-REQA");

        adrReqa.setValue(adrRpfReqa.getValue());

        logger.debug("adrReqa.getValue() :" + adrReqa.getValue());
        logger.debug("adrRpfReqa.getValue() :" + adrRpfReqa.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //adrReqa.setAdrTabl("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'RPF' TO ADR-TABL IN ADR-REQA");

        adrReqa.setAdrTabl("RPF");

        logger.debug("adrReqa.getAdrTabl() :" + adrReqa.getAdrTabl());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddDaux().setIddSaux("   ");
        //fioVari.getFioVoid().setFioSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE FIO-SIST TO IDD-SAUX");

        iddVari.getIddDaux().setIddSaux(fioVari.getFioVoid().getFioSist());

        logger.debug("iddVari.getIddDaux().getIddSaux() :" + iddVari.getIddDaux().getIddSaux());
        logger.debug("fioVari.getFioVoid().getFioSist() :" + fioVari.getFioVoid().getFioSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddDaux().setIddGaux(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'C' TO IDD-GAUX");

        iddVari.getIddDaux().setIddGaux("C");

        logger.debug("iddVari.getIddDaux().getIddGaux() :" + iddVari.getIddDaux().getIddGaux());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddDaux().setIddRaux("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO IDD-RAUX");

        iddVari.getIddDaux().setIddRaux(Util.spaces(3));

        logger.debug("iddVari.getIddDaux().getIddRaux() :" + iddVari.getIddDaux().getIddRaux());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.setIddIaux(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 1 TO IDD-IAUX");

        iddVari.setIddIaux(1);

        logger.debug("iddVari.getIddIaux() :" + iddVari.getIddIaux());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddItbl = 0;
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("SET IDD-ITBL TO 1");

        iddItbl = 1;

        logger.debug("iddItbl :" + iddItbl);

        for ( ; iddVari.getIddIaux() <= iddVari.getIddRegi().getIddFsis().getIddVsisSize(); iddVari.setIddIaux(iddVari.getIddIaux() + 1)) {

            if (iddVari.getIddRegi().getIddFsis().getIddVsis(iddItbl - 1).getIddDent().getValue().equals(iddVari.getIddDaux().getValue())) {
                logger.debug("GO TO FSR-GNS-FIO-RPF");


                logger.debug("saliendo de 'gnsFioRpf_iniGnsFioRpf()' ...");
                return "gnsFioRpf_fsrGnsFioRpf";
            }
        }

        logger.debug("saliendo de 'gnsFioRpf_iniGnsFioRpf()' ...");

        return "gnsFioRpf_grpGnsFioRpf";
    }

    /******************************************************************************
     * gnsFioRpf_grpGnsFioRpf
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsFioRpf_grpGnsFioRpf() {

        logger.debug("entrando a 'gnsFioRpf_grpGnsFioRpf()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddDaux().setIddGaux(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO IDD-GAUX");

        iddVari.getIddDaux().setIddGaux(Util.spaces(1));

        logger.debug("iddVari.getIddDaux().getIddGaux() :" + iddVari.getIddDaux().getIddGaux());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.setIddIaux(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 1 TO IDD-IAUX");

        iddVari.setIddIaux(1);

        logger.debug("iddVari.getIddIaux() :" + iddVari.getIddIaux());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddItbl = 0;
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("SET IDD-ITBL TO 1");

        iddItbl = 1;

        logger.debug("iddItbl :" + iddItbl);

        boolean at_end = true;

        for ( ; iddVari.getIddIaux() <= iddVari.getIddRegi().getIddFsis().getIddVsisSize(); iddVari.setIddIaux(iddVari.getIddIaux() + 1)) {

            if (iddVari.getIddRegi().getIddFsis().getIddVsis(iddItbl - 1).getIddDent().getValue().equals(iddVari.getIddDaux().getValue())) {

                at_end = false;

                break;
            }
        }

        if (at_end) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioCtts.getFioMens().setFioMen1("                                                                       ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE 'En GNS-FIO-RPF, NO existe en IDD:' TO FIO-MEN1");

            fioCtts.getFioMens().setFioMen1("En GNS-FIO-RPF, NO existe en IDD:");

            logger.debug("fioCtts.getFioMens().getFioMen1() :" + fioCtts.getFioMens().getFioMen1());

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioCtts.getFioMens().setFioMen2("         ");
            //iddVari.getIddDaux().setValue("       ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE IDD-DAUX TO FIO-MEN2");

            fioCtts.getFioMens().setFioMen2(iddVari.getIddDaux().getValue());

            logger.debug("fioCtts.getFioMens().getFioMen2() :" + fioCtts.getFioMens().getFioMen2());
            logger.debug("iddVari.getIddDaux().getValue() :" + iddVari.getIddDaux().getValue());

            execute("prgAbt");
        }

        logger.debug("saliendo de 'gnsFioRpf_grpGnsFioRpf()' ...");

        return "gnsFioRpf_fsrGnsFioRpf";
    }

    /******************************************************************************
     * gnsFioRpf_fsrGnsFioRpf
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsFioRpf_fsrGnsFioRpf() {

        logger.debug("entrando a 'gnsFioRpf_fsrGnsFioRpf()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //adrReqa.setAdrDbid(0);
        //iddItbl = 0;
        //iddVari.getIddRegi().getIddFsis().getIddVsis(iddItbl - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE IDD-IENT( IDD-ITBL) TO ADR-DBID IN ADR-REQA");

        adrReqa.setAdrDbid(Integer.parseInt(iddVari.getIddRegi().getIddFsis().getIddVsis(iddItbl - 1).getIddIent()));

        logger.debug("adrReqa.getAdrDbid() :" + adrReqa.getAdrDbid());
        logger.debug("iddItbl :" + iddItbl);
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(iddItbl - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(iddItbl - 1).getIddIent());

        if (fioVari.getFioAkey().compareTo(Util.spaces(32)) <= 0) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioVari.setFioAkey("                                ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE 'RPF-COD-DPTR' TO FIO-AKEY");

            fioVari.setFioAkey("RPF-COD-DPTR");

            logger.debug("fioVari.getFioAkey() :" + fioVari.getFioAkey());
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //adrElls.setAdrElm1("     ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'RPF00' TO ADR-ELM1");

        adrElls.setAdrElm1("RPF00");

        logger.debug("adrElls.getAdrElm1() :" + adrElls.getAdrElm1());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //adrUifb.setAdrProg("        ");
        //fioCtts.setFioProg("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE FIO-PROG TO ADR-PROG");

        adrUifb.setAdrProg(fioCtts.getFioProg());

        logger.debug("adrUifb.getAdrProg() :" + adrUifb.getAdrProg());
        logger.debug("fioCtts.getFioProg() :" + fioCtts.getFioProg());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioCtts.setFioIaky(0);
        //fioVari.setFioCmnd(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE FIO-CMND TO FIO-IAKY");

        fioCtts.setFioIaky(fioVari.getFioCmnd());

        logger.debug("fioCtts.getFioIaky() :" + fioCtts.getFioIaky());
        logger.debug("fioVari.getFioCmnd() :" + fioVari.getFioCmnd());

        if (!fioCtts.isFioIakyCon() && (fioVari.getFioAkey().equals("RPF-COD-DPTR") || fioVari.getFioAkey().compareTo(Util.spaces(32)) <= 0)) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //adrReqa.setAdrVkey("                                                                                                                                                                                    ");
            //rpf.getRpfCodDpts().getRpfCodDptr().setValue("                      ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE RPF-COD-DPTR IN RPF TO ADR-VKEY IN ADR-REQA");

            adrReqa.setAdrVkey(rpf.getRpfCodDpts().getRpfCodDptr().getValue());

            logger.debug("adrReqa.getAdrVkey() :" + adrReqa.getAdrVkey());
            logger.debug("rpf.getRpfCodDpts().getRpfCodDptr().getValue() :" + rpf.getRpfCodDpts().getRpfCodDptr().getValue());

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //adrReqa.setAdrDkey("     ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE 'RPF00' TO ADR-DKEY IN ADR-REQA");

            adrReqa.setAdrDkey("RPF00");

            logger.debug("adrReqa.getAdrDkey() :" + adrReqa.getAdrDkey());
        }
        else {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioCtts.getFioMens().setValue("                                                                                ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE 'En GNS-FIO-RPF, key' TO FIO-MENS");

            fioCtts.getFioMens().setValue("En GNS-FIO-RPF, key");

            logger.debug("fioCtts.getFioMens().getValue() :" + fioCtts.getFioMens().getValue());

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioCtts.getFioMensRed().setFioMensKey("                                ");
            //fioVari.setFioAkey("                                ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE FIO-AKEY TO FIO-MENS-KEY");

            fioCtts.getFioMensRed().setFioMensKey(fioVari.getFioAkey());

            logger.debug("fioCtts.getFioMensRed().getFioMensKey() :" + fioCtts.getFioMensRed().getFioMensKey());
            logger.debug("fioVari.getFioAkey() :" + fioVari.getFioAkey());

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioCtts.getFioMensRed().setFioMensFil("         ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE 'Invalida' TO FIO-MENS-FIL");

            fioCtts.getFioMensRed().setFioMensFil("Invalida");

            logger.debug("fioCtts.getFioMensRed().getFioMensFil() :" + fioCtts.getFioMensRed().getFioMensFil());

            execute("prgAbt");
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioCtts.setFioDfld("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ");
        //rpf.setValue("                                                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE RPF TO FIO-DFLD");

        fioCtts.setFioDfld(rpf.getValue());

        logger.debug("fioCtts.getFioDfld() :" + fioCtts.getFioDfld());
        logger.debug("rpf.getValue() :" + rpf.getValue());

        execute("gnsFioDtc");

        if (fioVari.getFioStat().isFioStatOks()) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //rpf.setValue("                                                                                            ");
            //fioCtts.setFioDfld("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE FIO-DFLD TO RPF");

            rpf.setValue(fioCtts.getFioDfld());

            logger.debug("rpf.getValue() :" + rpf.getValue());
            logger.debug("fioCtts.getFioDfld() :" + fioCtts.getFioDfld());
        }
        else {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioCtts.getFioMensRed().getFioMensFilRed().setFioMensSis("   ");
            //fioVari.getFioVoid().setFioSist("   ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE FIO-SIST TO FIO-MENS-SIS");

            fioCtts.getFioMensRed().getFioMensFilRed().setFioMensSis(fioVari.getFioVoid().getFioSist());

            logger.debug("fioCtts.getFioMensRed().getFioMensFilRed().getFioMensSis() :" + fioCtts.getFioMensRed().getFioMensFilRed().getFioMensSis());
            logger.debug("fioVari.getFioVoid().getFioSist() :" + fioVari.getFioVoid().getFioSist());

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioCtts.getFioMensRed().getFioMensFilRed().setFioMensReg("      ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE 'RPF' TO FIO-MENS-REG");

            fioCtts.getFioMensRed().getFioMensFilRed().setFioMensReg("RPF");

            logger.debug("fioCtts.getFioMensRed().getFioMensFilRed().getFioMensReg() :" + fioCtts.getFioMensRed().getFioMensFilRed().getFioMensReg());

            if (fioVari.getFioStat().isFioStatFtl()) {

                execute("prgAbt");
            }
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioVari.setFioAkey("                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO FIO-AKEY");

        fioVari.setFioAkey(Util.spaces(32));

        logger.debug("fioVari.getFioAkey() :" + fioVari.getFioAkey());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //adrRpfReqa.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ");
        //adrReqa.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE ADR-REQA TO ADR-RPF-REQA");

        adrRpfReqa.setValue(adrReqa.getValue());

        logger.debug("adrRpfReqa.getValue() :" + adrRpfReqa.getValue());
        logger.debug("adrReqa.getValue() :" + adrReqa.getValue());

        logger.debug("saliendo de 'gnsFioRpf_fsrGnsFioRpf()' ...");

        return "gnsFioRpf_finGnsFioRpf";
    }

    /******************************************************************************
     * gnsFioRpf_finGnsFioRpf
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsFioRpf_finGnsFioRpf() {

        logger.debug("entrando a 'gnsFioRpf_finGnsFioRpf()' ...");

        logger.debug("saliendo de 'gnsFioRpf_finGnsFioRpf()' ...");

        return null;
    }

    /******************************************************************************
     * gnsFioTab
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsFioTab() {

        logger.debug("entrando a 'gnsFioTab()' ...");

        execute("gnsFioTab_iniGnsFioTab");

        logger.debug("saliendo de 'gnsFioTab()' ...");

        return null;
    }

    /******************************************************************************
     * gnsFioTab_iniGnsFioTab
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsFioTab_iniGnsFioTab() {

        logger.debug("entrando a 'gnsFioTab_iniGnsFioTab()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //adrReqa.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ");
        //adrTabReqa.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE ADR-TAB-REQA TO ADR-REQA");

        adrReqa.setValue(adrTabReqa.getValue());

        logger.debug("adrReqa.getValue() :" + adrReqa.getValue());
        logger.debug("adrTabReqa.getValue() :" + adrTabReqa.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //adrReqa.setAdrTabl("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'TAB' TO ADR-TABL IN ADR-REQA");

        adrReqa.setAdrTabl("TAB");

        logger.debug("adrReqa.getAdrTabl() :" + adrReqa.getAdrTabl());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddDaux().setIddSaux("   ");
        //fioVari.getFioVoid().setFioSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE FIO-SIST TO IDD-SAUX");

        iddVari.getIddDaux().setIddSaux(fioVari.getFioVoid().getFioSist());

        logger.debug("iddVari.getIddDaux().getIddSaux() :" + iddVari.getIddDaux().getIddSaux());
        logger.debug("fioVari.getFioVoid().getFioSist() :" + fioVari.getFioVoid().getFioSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddDaux().setIddGaux(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'C' TO IDD-GAUX");

        iddVari.getIddDaux().setIddGaux("C");

        logger.debug("iddVari.getIddDaux().getIddGaux() :" + iddVari.getIddDaux().getIddGaux());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddDaux().setIddRaux("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO IDD-RAUX");

        iddVari.getIddDaux().setIddRaux(Util.spaces(3));

        logger.debug("iddVari.getIddDaux().getIddRaux() :" + iddVari.getIddDaux().getIddRaux());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.setIddIaux(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 1 TO IDD-IAUX");

        iddVari.setIddIaux(1);

        logger.debug("iddVari.getIddIaux() :" + iddVari.getIddIaux());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddItbl = 0;
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("SET IDD-ITBL TO 1");

        iddItbl = 1;

        logger.debug("iddItbl :" + iddItbl);

        for ( ; iddVari.getIddIaux() <= iddVari.getIddRegi().getIddFsis().getIddVsisSize(); iddVari.setIddIaux(iddVari.getIddIaux() + 1)) {

            if (iddVari.getIddRegi().getIddFsis().getIddVsis(iddItbl - 1).getIddDent().getValue().equals(iddVari.getIddDaux().getValue())) {
                logger.debug("GO TO FSR-GNS-FIO-TAB");


                logger.debug("saliendo de 'gnsFioTab_iniGnsFioTab()' ...");
                return "gnsFioTab_fsrGnsFioTab";
            }
        }

        logger.debug("saliendo de 'gnsFioTab_iniGnsFioTab()' ...");

        return "gnsFioTab_grpGnsFioTab";
    }

    /******************************************************************************
     * gnsFioTab_grpGnsFioTab
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsFioTab_grpGnsFioTab() {

        logger.debug("entrando a 'gnsFioTab_grpGnsFioTab()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddDaux().setIddGaux(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO IDD-GAUX");

        iddVari.getIddDaux().setIddGaux(Util.spaces(1));

        logger.debug("iddVari.getIddDaux().getIddGaux() :" + iddVari.getIddDaux().getIddGaux());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.setIddIaux(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 1 TO IDD-IAUX");

        iddVari.setIddIaux(1);

        logger.debug("iddVari.getIddIaux() :" + iddVari.getIddIaux());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddItbl = 0;
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("SET IDD-ITBL TO 1");

        iddItbl = 1;

        logger.debug("iddItbl :" + iddItbl);

        boolean at_end = true;

        for ( ; iddVari.getIddIaux() <= iddVari.getIddRegi().getIddFsis().getIddVsisSize(); iddVari.setIddIaux(iddVari.getIddIaux() + 1)) {

            if (iddVari.getIddRegi().getIddFsis().getIddVsis(iddItbl - 1).getIddDent().getValue().equals(iddVari.getIddDaux().getValue())) {

                at_end = false;

                break;
            }
        }

        if (at_end) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioCtts.getFioMens().setFioMen1("                                                                       ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE 'En GNS-FIO-TAB, NO existe en IDD:' TO FIO-MEN1");

            fioCtts.getFioMens().setFioMen1("En GNS-FIO-TAB, NO existe en IDD:");

            logger.debug("fioCtts.getFioMens().getFioMen1() :" + fioCtts.getFioMens().getFioMen1());

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioCtts.getFioMens().setFioMen2("         ");
            //iddVari.getIddDaux().setValue("       ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE IDD-DAUX TO FIO-MEN2");

            fioCtts.getFioMens().setFioMen2(iddVari.getIddDaux().getValue());

            logger.debug("fioCtts.getFioMens().getFioMen2() :" + fioCtts.getFioMens().getFioMen2());
            logger.debug("iddVari.getIddDaux().getValue() :" + iddVari.getIddDaux().getValue());

            execute("prgAbt");
        }

        logger.debug("saliendo de 'gnsFioTab_grpGnsFioTab()' ...");

        return "gnsFioTab_fsrGnsFioTab";
    }

    /******************************************************************************
     * gnsFioTab_fsrGnsFioTab
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsFioTab_fsrGnsFioTab() {

        logger.debug("entrando a 'gnsFioTab_fsrGnsFioTab()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //adrReqa.setAdrDbid(0);
        //iddItbl = 0;
        //iddVari.getIddRegi().getIddFsis().getIddVsis(iddItbl - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE IDD-IENT( IDD-ITBL) TO ADR-DBID IN ADR-REQA");

        adrReqa.setAdrDbid(Integer.parseInt(iddVari.getIddRegi().getIddFsis().getIddVsis(iddItbl - 1).getIddIent()));

        logger.debug("adrReqa.getAdrDbid() :" + adrReqa.getAdrDbid());
        logger.debug("iddItbl :" + iddItbl);
        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(iddItbl - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(iddItbl - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //adrElls.setAdrElm1("     ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'TAB00' TO ADR-ELM1");

        adrElls.setAdrElm1("TAB00");

        logger.debug("adrElls.getAdrElm1() :" + adrElls.getAdrElm1());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //adrUifb.setAdrProg("        ");
        //fioCtts.setFioProg("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE FIO-PROG TO ADR-PROG");

        adrUifb.setAdrProg(fioCtts.getFioProg());

        logger.debug("adrUifb.getAdrProg() :" + adrUifb.getAdrProg());
        logger.debug("fioCtts.getFioProg() :" + fioCtts.getFioProg());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioCtts.setFioIaky(0);
        //fioVari.setFioCmnd(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE FIO-CMND TO FIO-IAKY");

        fioCtts.setFioIaky(fioVari.getFioCmnd());

        logger.debug("fioCtts.getFioIaky() :" + fioCtts.getFioIaky());
        logger.debug("fioVari.getFioCmnd() :" + fioVari.getFioCmnd());

        if (!fioCtts.isFioIakyCon() && (fioVari.getFioAkey().equals("TAB-COD-TABL") || fioVari.getFioAkey().compareTo(Util.spaces(32)) <= 0)) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //adrReqa.setAdrVkey("                                                                                                                                                                                    ");
            //tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().setValue("               ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE TAB-COD-TABL IN TAB TO ADR-VKEY IN ADR-REQA");

            adrReqa.setAdrVkey(tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getValue());

            logger.debug("adrReqa.getAdrVkey() :" + adrReqa.getAdrVkey());
            logger.debug("tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getValue() :" + tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getValue());

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //adrReqa.setAdrDkey("     ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE 'TAB00' TO ADR-DKEY IN ADR-REQA");

            adrReqa.setAdrDkey("TAB00");

            logger.debug("adrReqa.getAdrDkey() :" + adrReqa.getAdrDkey());
        }
        else {

            if (fioVari.getFioAkey().equals("TAB-STP-ITRN")) {

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //adrReqa.setAdrVkey("                                                                                                                                                                                    ");
                //tab.getTabKeyIreg().getTabCodItrs().getTabStpItrn().setValue("              ");
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("MOVE TAB-STP-ITRN IN TAB TO ADR-VKEY IN ADR-REQA");

                adrReqa.setAdrVkey(tab.getTabKeyIreg().getTabCodItrs().getTabStpItrn().getValue());

                logger.debug("adrReqa.getAdrVkey() :" + adrReqa.getAdrVkey());
                logger.debug("tab.getTabKeyIreg().getTabCodItrs().getTabStpItrn().getValue() :" + tab.getTabKeyIreg().getTabCodItrs().getTabStpItrn().getValue());

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //adrReqa.setAdrDkey("     ");
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("MOVE 'TAB01' TO ADR-DKEY IN ADR-REQA");

                adrReqa.setAdrDkey("TAB01");

                logger.debug("adrReqa.getAdrDkey() :" + adrReqa.getAdrDkey());
            }
            else {

                if (fioVari.getFioAkey().equals("TAB-CIC-TABL")) {

                    //// setters /////////////////////////////////////////////////////////////////////////////////
                    //adrReqa.setAdrVkey("                                                                                                                                                                                    ");
                    //tab.getTabKy1Tabs().getTabCicTabl().setValue("               ");
                    //////////////////////////////////////////////////////////////////////////////////////////////
                    logger.debug("MOVE TAB-CIC-TABL IN TAB TO ADR-VKEY IN ADR-REQA");

                    adrReqa.setAdrVkey(tab.getTabKy1Tabs().getTabCicTabl().getValue());

                    logger.debug("adrReqa.getAdrVkey() :" + adrReqa.getAdrVkey());
                    logger.debug("tab.getTabKy1Tabs().getTabCicTabl().getValue() :" + tab.getTabKy1Tabs().getTabCicTabl().getValue());

                    //// setters /////////////////////////////////////////////////////////////////////////////////
                    //adrReqa.setAdrDkey("     ");
                    //////////////////////////////////////////////////////////////////////////////////////////////
                    logger.debug("MOVE 'TAB02' TO ADR-DKEY IN ADR-REQA");

                    adrReqa.setAdrDkey("TAB02");

                    logger.debug("adrReqa.getAdrDkey() :" + adrReqa.getAdrDkey());
                }
                else {

                    if (fioVari.getFioAkey().equals("TAB-EXT-TABL")) {

                        //// setters /////////////////////////////////////////////////////////////////////////////////
                        //adrReqa.setAdrVkey("                                                                                                                                                                                    ");
                        //tab.getTabKy2Tabs().getTabExtTabl().setValue("        ");
                        //////////////////////////////////////////////////////////////////////////////////////////////
                        logger.debug("MOVE TAB-EXT-TABL IN TAB TO ADR-VKEY IN ADR-REQA");

                        adrReqa.setAdrVkey(tab.getTabKy2Tabs().getTabExtTabl().getValue());

                        logger.debug("adrReqa.getAdrVkey() :" + adrReqa.getAdrVkey());
                        logger.debug("tab.getTabKy2Tabs().getTabExtTabl().getValue() :" + tab.getTabKy2Tabs().getTabExtTabl().getValue());

                        //// setters /////////////////////////////////////////////////////////////////////////////////
                        //adrReqa.setAdrDkey("     ");
                        //////////////////////////////////////////////////////////////////////////////////////////////
                        logger.debug("MOVE 'TAB03' TO ADR-DKEY IN ADR-REQA");

                        adrReqa.setAdrDkey("TAB03");

                        logger.debug("adrReqa.getAdrDkey() :" + adrReqa.getAdrDkey());
                    }
                    else {

                        //// setters /////////////////////////////////////////////////////////////////////////////////
                        //fioCtts.getFioMens().setValue("                                                                                ");
                        //////////////////////////////////////////////////////////////////////////////////////////////
                        logger.debug("MOVE 'En GNS-FIO-TAB, key' TO FIO-MENS");

                        fioCtts.getFioMens().setValue("En GNS-FIO-TAB, key");

                        logger.debug("fioCtts.getFioMens().getValue() :" + fioCtts.getFioMens().getValue());

                        //// setters /////////////////////////////////////////////////////////////////////////////////
                        //fioCtts.getFioMensRed().setFioMensKey("                                ");
                        //fioVari.setFioAkey("                                ");
                        //////////////////////////////////////////////////////////////////////////////////////////////
                        logger.debug("MOVE FIO-AKEY TO FIO-MENS-KEY");

                        fioCtts.getFioMensRed().setFioMensKey(fioVari.getFioAkey());

                        logger.debug("fioCtts.getFioMensRed().getFioMensKey() :" + fioCtts.getFioMensRed().getFioMensKey());
                        logger.debug("fioVari.getFioAkey() :" + fioVari.getFioAkey());

                        //// setters /////////////////////////////////////////////////////////////////////////////////
                        //fioCtts.getFioMensRed().setFioMensFil("         ");
                        //////////////////////////////////////////////////////////////////////////////////////////////
                        logger.debug("MOVE 'Invalida' TO FIO-MENS-FIL");

                        fioCtts.getFioMensRed().setFioMensFil("Invalida");

                        logger.debug("fioCtts.getFioMensRed().getFioMensFil() :" + fioCtts.getFioMensRed().getFioMensFil());

                        execute("prgAbt");
                    }
                }
            }
        }

        if (fioVari.getFioCmnd() == fioCtts.getFioVcmn().getFioPut() || fioVari.getFioCmnd() == fioCtts.getFioVcmn().getFioMod()) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //tab.getTabKy1Tabs().getTabCicTabl().setTabCicTtab("   ");
            //tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().setTabCodTtab("   ");
            //tab.getTabKy2Tabs().getTabExtTabl().setTabExtTtab("   ");
            //tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().setTabCodTtab("   ");
            //tab.getTabSnxTabl().setTabSnxTtab("   ");
            //tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().setTabCodTtab("   ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE TAB-COD-TTAB IN TAB TO TAB-CIC-TTAB IN TAB TAB-EXT-TTAB IN TAB TAB-SNX-TTAB IN TAB");

            tab.getTabKy1Tabs().getTabCicTabl().setTabCicTtab(tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getTabCodTtab());

            tab.getTabKy2Tabs().getTabExtTabl().setTabExtTtab(tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getTabCodTtab());

            tab.getTabSnxTabl().setTabSnxTtab(tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getTabCodTtab());

            logger.debug("tab.getTabKy1Tabs().getTabCicTabl().getTabCicTtab() :" + tab.getTabKy1Tabs().getTabCicTabl().getTabCicTtab());
            logger.debug("tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getTabCodTtab() :" + tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getTabCodTtab());
            logger.debug("tab.getTabKy2Tabs().getTabExtTabl().getTabExtTtab() :" + tab.getTabKy2Tabs().getTabExtTabl().getTabExtTtab());
            logger.debug("tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getTabCodTtab() :" + tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getTabCodTtab());
            logger.debug("tab.getTabSnxTabl().getTabSnxTtab() :" + tab.getTabSnxTabl().getTabSnxTtab());
            logger.debug("tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getTabCodTtab() :" + tab.getTabKeyIreg().getTabKy0Tabs().getTabCodTabl().getTabCodTtab());
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioCtts.setFioDfld("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ");
        //tab.setValue("                                                                                                                                                                                                  ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TAB TO FIO-DFLD");

        fioCtts.setFioDfld(tab.getValue());

        logger.debug("fioCtts.getFioDfld() :" + fioCtts.getFioDfld());
        logger.debug("tab.getValue() :" + tab.getValue());

        execute("gnsFioDtc");

        if (fioVari.getFioStat().isFioStatOks()) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //tab.setValue("                                                                                                                                                                                                  ");
            //fioCtts.setFioDfld("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE FIO-DFLD TO TAB");

            tab.setValue(fioCtts.getFioDfld());

            logger.debug("tab.getValue() :" + tab.getValue());
            logger.debug("fioCtts.getFioDfld() :" + fioCtts.getFioDfld());
        }
        else {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioCtts.getFioMensRed().getFioMensFilRed().setFioMensSis("   ");
            //fioVari.getFioVoid().setFioSist("   ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE FIO-SIST TO FIO-MENS-SIS");

            fioCtts.getFioMensRed().getFioMensFilRed().setFioMensSis(fioVari.getFioVoid().getFioSist());

            logger.debug("fioCtts.getFioMensRed().getFioMensFilRed().getFioMensSis() :" + fioCtts.getFioMensRed().getFioMensFilRed().getFioMensSis());
            logger.debug("fioVari.getFioVoid().getFioSist() :" + fioVari.getFioVoid().getFioSist());

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioCtts.getFioMensRed().getFioMensFilRed().setFioMensReg("      ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE 'TAB' TO FIO-MENS-REG");

            fioCtts.getFioMensRed().getFioMensFilRed().setFioMensReg("TAB");

            logger.debug("fioCtts.getFioMensRed().getFioMensFilRed().getFioMensReg() :" + fioCtts.getFioMensRed().getFioMensFilRed().getFioMensReg());

            if (fioVari.getFioStat().isFioStatFtl()) {

                execute("prgAbt");
            }
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioVari.setFioAkey("                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO FIO-AKEY");

        fioVari.setFioAkey(Util.spaces(32));

        logger.debug("fioVari.getFioAkey() :" + fioVari.getFioAkey());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //adrTabReqa.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ");
        //adrReqa.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE ADR-REQA TO ADR-TAB-REQA");

        adrTabReqa.setValue(adrReqa.getValue());

        logger.debug("adrTabReqa.getValue() :" + adrTabReqa.getValue());
        logger.debug("adrReqa.getValue() :" + adrReqa.getValue());

        logger.debug("saliendo de 'gnsFioTab_fsrGnsFioTab()' ...");

        return "gnsFioTab_finGnsFioTab";
    }

    /******************************************************************************
     * gnsFioTab_finGnsFioTab
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsFioTab_finGnsFioTab() {

        logger.debug("entrando a 'gnsFioTab_finGnsFioTab()' ...");

        logger.debug("saliendo de 'gnsFioTab_finGnsFioTab()' ...");

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
        logger.debug("MOVE ADR-REQA TO FIO-ORACLE-RQA");

        fioOracle.setFioOracleRqa(adrReqa.getValue());

        logger.debug("fioOracle.getFioOracleRqa() :" + fioOracle.getFioOracleRqa());
        logger.debug("adrReqa.getValue() :" + adrReqa.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioOracle.setFioOracleDfld("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ");
        //fioCtts.setFioDfld("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE FIO-DFLD TO FIO-ORACLE-DFLD");

        fioOracle.setFioOracleDfld(fioCtts.getFioDfld());

        logger.debug("fioOracle.getFioOracleDfld() :" + fioOracle.getFioOracleDfld());
        logger.debug("fioCtts.getFioDfld() :" + fioCtts.getFioDfld());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioOracle.setFioOracleMens("                                                                                ");
        //fioCtts.getFioMens().setValue("                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE FIO-MENS TO FIO-ORACLE-MENS");

        fioOracle.setFioOracleMens(fioCtts.getFioMens().getValue());

        logger.debug("fioOracle.getFioOracleMens() :" + fioOracle.getFioOracleMens());
        logger.debug("fioCtts.getFioMens().getValue() :" + fioCtts.getFioMens().getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioOracle.setFioOracleVari("                                                                                ");
        //fioVari.setValue("                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE FIO-VARI TO FIO-ORACLE-VARI");

        fioOracle.setFioOracleVari(fioVari.getValue());

        logger.debug("fioOracle.getFioOracleVari() :" + fioOracle.getFioOracleVari());
        logger.debug("fioVari.getValue() :" + fioVari.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioOracle.getFioOracleProg().setFioOracleProgTab("   ");
        //adrReqa.setAdrTabl("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE ADR-TABL IN ADR-REQA TO FIO-ORACLE-PROG-TAB");

        fioOracle.getFioOracleProg().setFioOracleProgTab(adrReqa.getAdrTabl());

        logger.debug("fioOracle.getFioOracleProg().getFioOracleProgTab() :" + fioOracle.getFioOracleProg().getFioOracleProgTab());
        logger.debug("adrReqa.getAdrTabl() :" + adrReqa.getAdrTabl());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioOracle.getFioOracleProg().setFioOracleProgNum(0);
        //adrReqa.setAdrDbid(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE ADR-DBID IN ADR-REQA TO FIO-ORACLE-PROG-NUM");

        fioOracle.getFioOracleProg().setFioOracleProgNum(adrReqa.getAdrDbid());

        logger.debug("fioOracle.getFioOracleProg().getFioOracleProgNum() :" + fioOracle.getFioOracleProg().getFioOracleProgNum());
        logger.debug("adrReqa.getAdrDbid() :" + adrReqa.getAdrDbid());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //sendStringFio = "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ";
        //fioOracle.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE FIO-ORACLE TO SEND-STRING-FIO");

        sendStringFio = fioOracle.getValue();

        logger.debug("sendStringFio :" + sendStringFio);
        logger.debug("fioOracle.getValue() :" + fioOracle.getValue());

        if (fioVari.getFioCmnd() == 38) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioVari.getFioStat().setValue("  ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE ZEROES TO FIO-STAT");

            fioVari.getFioStat().setValue(Util.intToString(0, 2));

            logger.debug("fioVari.getFioStat().getValue() :" + fioVari.getFioStat().getValue());

            execute("tuxBackOut");
            logger.debug("GO TO FIN-GNS-FIO-DTC");


            logger.debug("saliendo de 'gnsFioDtc_iniGnsFioDtc()' ...");
            return "gnsFioDtc_finGnsFioDtc";
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tptypeRec.setLen(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 3000 TO LEN");

        tptypeRec.setLen(3000);

        logger.debug("tptypeRec.getLen() :" + tptypeRec.getLen());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tptypeRec.setRecType("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE \"CARRAY\" TO REC-TYPE");

        tptypeRec.setRecType("CARRAY");

        logger.debug("tptypeRec.getRecType() :" + tptypeRec.getRecType());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tpsvcdefRec.setServiceName("                                                                                                                               ");
        //fioOracle.getFioOracleProg().setValue("      ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE FIO-ORACLE-PROG TO SERVICE-NAME");

        tpsvcdefRec.setServiceName(fioOracle.getFioOracleProg().getValue());

        logger.debug("tpsvcdefRec.getServiceName() :" + tpsvcdefRec.getServiceName());
        logger.debug("fioOracle.getFioOracleProg().getValue() :" + fioOracle.getFioOracleProg().getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tpsvcdefRec.setTpblock(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("SET TPBLOCK IN TPSVCDEF-REC TO TRUE");

        tpsvcdefRec.setTpblock(true);

        logger.debug("tpsvcdefRec.isTpblock() :" + tpsvcdefRec.isTpblock());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tpsvcdefRec.setTptran(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("SET TPTRAN IN TPSVCDEF-REC TO TRUE");

        tpsvcdefRec.setTptran(true);

        logger.debug("tpsvcdefRec.isTptran() :" + tpsvcdefRec.isTptran());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tpsvcdefRec.setTpnotime(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("SET TPNOTIME IN TPSVCDEF-REC TO TRUE");

        tpsvcdefRec.setTpnotime(true);

        logger.debug("tpsvcdefRec.isTpnotime() :" + tpsvcdefRec.isTpnotime());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tpsvcdefRec.setTpsigrstrt(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("SET TPSIGRSTRT IN TPSVCDEF-REC TO TRUE");

        tpsvcdefRec.setTpsigrstrt(true);

        logger.debug("tpsvcdefRec.isTpsigrstrt() :" + tpsvcdefRec.isTpsigrstrt());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tpsvcdefRec.setTpchange(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("SET TPCHANGE IN TPSVCDEF-REC TO TRUE");

        tpsvcdefRec.setTpchange(true);

        logger.debug("tpsvcdefRec.isTpchange() :" + tpsvcdefRec.isTpchange());
        logger.debug("CALL \"TPCALL\" USING TPSVCDEF-REC TPTYPE-REC SEND-STRING-FIO TPTYPE-REC RECV-STRING-FIO TPSTATUS-REC");

        if (!tpstatusRec.isTpok()) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioOracle.getFioOracleProg().setValue("      ");
            //tpstatusRec.setTpStatus(0);
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("DISPLAY 'GNSBGDTC :' FIO-ORACLE-PROG ' ' TP-STATUS");

            logger.info("GNSBGDTC :" + fioOracle.getFioOracleProg().getValue() + " " + tpstatusRec.getTpStatus());

            logger.debug("fioOracle.getFioOracleProg().getValue() :" + fioOracle.getFioOracleProg().getValue());
            logger.debug("tpstatusRec.getTpStatus() :" + tpstatusRec.getTpStatus());

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioCtts.getFioMens().setValue("                                                                                ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE \"TPCALL Failed\" TO FIO-MENS");

            fioCtts.getFioMens().setValue("TPCALL Failed");

            logger.debug("fioCtts.getFioMens().getValue() :" + fioCtts.getFioMens().getValue());

            execute("prgAbt");
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioOracle.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ");
        //recvStringFio = "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ";
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE RECV-STRING-FIO TO FIO-ORACLE");

        fioOracle.setValue(recvStringFio);

        logger.debug("fioOracle.getValue() :" + fioOracle.getValue());
        logger.debug("recvStringFio :" + recvStringFio);

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //adrReqa.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ");
        //fioOracle.setFioOracleRqa("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE FIO-ORACLE-RQA TO ADR-REQA");

        adrReqa.setValue(fioOracle.getFioOracleRqa());

        logger.debug("adrReqa.getValue() :" + adrReqa.getValue());
        logger.debug("fioOracle.getFioOracleRqa() :" + fioOracle.getFioOracleRqa());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioCtts.setFioDfld("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ");
        //fioOracle.setFioOracleDfld("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE FIO-ORACLE-DFLD TO FIO-DFLD");

        fioCtts.setFioDfld(fioOracle.getFioOracleDfld());

        logger.debug("fioCtts.getFioDfld() :" + fioCtts.getFioDfld());
        logger.debug("fioOracle.getFioOracleDfld() :" + fioOracle.getFioOracleDfld());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioCtts.getFioMens().setValue("                                                                                ");
        //fioOracle.setFioOracleMens("                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE FIO-ORACLE-MENS TO FIO-MENS");

        fioCtts.getFioMens().setValue(fioOracle.getFioOracleMens());

        logger.debug("fioCtts.getFioMens().getValue() :" + fioCtts.getFioMens().getValue());
        logger.debug("fioOracle.getFioOracleMens() :" + fioOracle.getFioOracleMens());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioVari.setValue("                                                                                ");
        //fioOracle.setFioOracleVari("                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE FIO-ORACLE-VARI TO FIO-VARI");

        fioVari.setValue(fioOracle.getFioOracleVari());

        logger.debug("fioVari.getValue() :" + fioVari.getValue());
        logger.debug("fioOracle.getFioOracleVari() :" + fioOracle.getFioOracleVari());

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
        logger.debug("CALL \"TPGETLEV\" USING TPTRXLEV-REC TPSTATUS-REC");

        if (!tpstatusRec.isTpok()) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //tpstatusRec.setTpStatus(0);
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("DISPLAY 'GNSBGDTC TUX-BACK-OUT TPGETLEV:' TP-STATUS");

            logger.info("GNSBGDTC TUX-BACK-OUT TPGETLEV:" + tpstatusRec.getTpStatus());

            logger.debug("tpstatusRec.getTpStatus() :" + tpstatusRec.getTpStatus());
            logger.debug("GO TO FIN-TUX-BACK-OUT");


            logger.debug("saliendo de 'tuxBackOut_iniTuxBackOut()' ...");
            return "tuxBackOut_finTuxBackOut";
        }
        else {

            if (tptrxlevRec.isTpNotInTran()) {

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //tpstatusRec.setTpStatus(0);
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("DISPLAY 'GNSBGDTC TUX-BACK-OUT TP-NOT-IN-TRAN:' TP-STATUS");

                logger.info("GNSBGDTC TUX-BACK-OUT TP-NOT-IN-TRAN:" + tpstatusRec.getTpStatus());

                logger.debug("tpstatusRec.getTpStatus() :" + tpstatusRec.getTpStatus());
                logger.debug("GO TO FIN-TUX-BACK-OUT");


                logger.debug("saliendo de 'tuxBackOut_iniTuxBackOut()' ...");
                return "tuxBackOut_finTuxBackOut";
            }
        }
        logger.debug("CALL \"TPSUSPEND\" USING TPTRXDEF-REC TPSTATUS-REC");

        if (!tpstatusRec.isTpok()) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //tpstatusRec.setTpStatus(0);
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("DISPLAY 'GNSBGDTC TUX-BACK-OUT TPSUSPEND:' TP-STATUS");

            logger.info("GNSBGDTC TUX-BACK-OUT TPSUSPEND:" + tpstatusRec.getTpStatus());

            logger.debug("tpstatusRec.getTpStatus() :" + tpstatusRec.getTpStatus());
            logger.debug("GO TO FIN-TUX-BACK-OUT");


            logger.debug("saliendo de 'tuxBackOut_iniTuxBackOut()' ...");
            return "tuxBackOut_finTuxBackOut";
        }
        logger.debug("CALL \"TPRESUME\" USING TPTRXDEF-REC TPSTATUS-REC");

        if (!tpstatusRec.isTpok()) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //tpstatusRec.setTpStatus(0);
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("DISPLAY 'GNSBGDTC TUX-BACK-OUT TPRESUME:' TP-STATUS");

            logger.info("GNSBGDTC TUX-BACK-OUT TPRESUME:" + tpstatusRec.getTpStatus());

            logger.debug("tpstatusRec.getTpStatus() :" + tpstatusRec.getTpStatus());
            logger.debug("GO TO FIN-TUX-BACK-OUT");


            logger.debug("saliendo de 'tuxBackOut_iniTuxBackOut()' ...");
            return "tuxBackOut_finTuxBackOut";
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.getTskTranid().setTskTranid1(0L);
        //tptrxdefRec.setTranid(1 - 1, 0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TRANID( 1) TO TSK-TRANID-1");

        tskVari.getTskTranid().setTskTranid1(tptrxdefRec.getTranid(1 - 1));

        logger.debug("tskVari.getTskTranid().getTskTranid1() :" + tskVari.getTskTranid().getTskTranid1());
        logger.debug("tptrxdefRec.getTranid(1 - 1) :" + tptrxdefRec.getTranid(1 - 1));

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.getTskTranid().setTskTranid2(0L);
        //tptrxdefRec.setTranid(2 - 1, 0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TRANID( 2) TO TSK-TRANID-2");

        tskVari.getTskTranid().setTskTranid2(tptrxdefRec.getTranid(2 - 1));

        logger.debug("tskVari.getTskTranid().getTskTranid2() :" + tskVari.getTskTranid().getTskTranid2());
        logger.debug("tptrxdefRec.getTranid(2 - 1) :" + tptrxdefRec.getTranid(2 - 1));

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.getTskTranid().setTskTranid3(0L);
        //tptrxdefRec.setTranid(3 - 1, 0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TRANID( 3) TO TSK-TRANID-3");

        tskVari.getTskTranid().setTskTranid3(tptrxdefRec.getTranid(3 - 1));

        logger.debug("tskVari.getTskTranid().getTskTranid3() :" + tskVari.getTskTranid().getTskTranid3());
        logger.debug("tptrxdefRec.getTranid(3 - 1) :" + tptrxdefRec.getTranid(3 - 1));

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.getTskTranid().setTskTranid4(0L);
        //tptrxdefRec.setTranid(4 - 1, 0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TRANID( 4) TO TSK-TRANID-4");

        tskVari.getTskTranid().setTskTranid4(tptrxdefRec.getTranid(4 - 1));

        logger.debug("tskVari.getTskTranid().getTskTranid4() :" + tskVari.getTskTranid().getTskTranid4());
        logger.debug("tptrxdefRec.getTranid(4 - 1) :" + tptrxdefRec.getTranid(4 - 1));

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.getTskTranid().setTskTranid5(0L);
        //tptrxdefRec.setTranid(5 - 1, 0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TRANID( 5) TO TSK-TRANID-5");

        tskVari.getTskTranid().setTskTranid5(tptrxdefRec.getTranid(5 - 1));

        logger.debug("tskVari.getTskTranid().getTskTranid5() :" + tskVari.getTskTranid().getTskTranid5());
        logger.debug("tptrxdefRec.getTranid(5 - 1) :" + tptrxdefRec.getTranid(5 - 1));

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.getTskTranid().setTskTranid6(0L);
        //tptrxdefRec.setTranid(6 - 1, 0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TRANID( 6) TO TSK-TRANID-6");

        tskVari.getTskTranid().setTskTranid6(tptrxdefRec.getTranid(6 - 1));

        logger.debug("tskVari.getTskTranid().getTskTranid6() :" + tskVari.getTskTranid().getTskTranid6());
        logger.debug("tptrxdefRec.getTranid(6 - 1) :" + tptrxdefRec.getTranid(6 - 1));

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.setTskTermTux("                                                                                                                                                                                                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO TSK-TERM-TUX");

        tskVari.setTskTermTux(Util.spaces(256));

        logger.debug("tskVari.getTskTermTux() :" + tskVari.getTskTermTux());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.setTskTermTux("                                                                                                                                                                                                                                                                ");
        //tskVari.setTskTranidAlf("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TSK-TRANID-ALF TO TSK-TERM-TUX");

        tskVari.setTskTermTux(tskVari.getTskTranidAlf());

        logger.debug("tskVari.getTskTermTux() :" + tskVari.getTskTermTux());
        logger.debug("tskVari.getTskTranidAlf() :" + tskVari.getTskTranidAlf());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueComSend("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'GET' TO QUE-COM-SEND");

        queSend.setQueComSend("GET");

        logger.debug("queSend.getQueComSend() :" + queSend.getQueComSend());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNamSend("                                                                                                                                                                                                                                                                                                            ");
        //tskVari.setTskTermTux("                                                                                                                                                                                                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TSK-TERM-TUX TO QUE-NAM-SEND");

        queSend.setQueNamSend(tskVari.getTskTermTux());

        logger.debug("queSend.getQueNamSend() :" + queSend.getQueNamSend());
        logger.debug("tskVari.getTskTermTux() :" + tskVari.getTskTermTux());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNumSend(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 1 TO QUE-NUM-SEND");

        queSend.setQueNumSend(1);

        logger.debug("queSend.getQueNumSend() :" + queSend.getQueNumSend());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueLarSend(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 4 TO QUE-LAR-SEND");

        queSend.setQueLarSend(4);

        logger.debug("queSend.getQueLarSend() :" + queSend.getQueLarSend());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueTrxSend("                                                                                                                                                                                                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO QUE-TRX-SEND");

        queSend.setQueTrxSend(Util.spaces(256));

        logger.debug("queSend.getQueTrxSend() :" + queSend.getQueTrxSend());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueDatSend("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO QUE-DAT-SEND");

        queSend.setQueDatSend(Util.spaces(9000));

        logger.debug("queSend.getQueDatSend() :" + queSend.getQueDatSend());

        execute("gnsMsjQue");

        if (!queVari.getQueStat().equals(queVari.getQueStatOks())) {
            logger.debug("GO TO FIN-TUX-BACK-OUT");


            logger.debug("saliendo de 'tuxBackOut_iniTuxBackOut()' ...");
            return "tuxBackOut_finTuxBackOut";
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queVari.getQueItem().setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   ");
        //queRecv.setQueDatRecv("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE QUE-DAT-RECV TO QUE-ITEM");

        queVari.getQueItem().setValue(queRecv.getQueDatRecv());

        logger.debug("queVari.getQueItem().getValue() :" + queVari.getQueItem().getValue());
        logger.debug("queRecv.getQueDatRecv() :" + queRecv.getQueDatRecv());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.getTskInfoTran().setValue("        ");
        //queVari.getQueItem().setQueData("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE QUE-DATA TO TSK-INFO-TRAN");

        tskVari.getTskInfoTran().setValue(queVari.getQueItem().getQueData());

        logger.debug("tskVari.getTskInfoTran().getValue() :" + tskVari.getTskInfoTran().getValue());
        logger.debug("queVari.getQueItem().getQueData() :" + queVari.getQueItem().getQueData());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.getTskInfoTran().setTskInfoCommit(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 1 TO TSK-INFO-COMMIT");

        tskVari.getTskInfoTran().setTskInfoCommit(1);

        logger.debug("tskVari.getTskInfoTran().getTskInfoCommit() :" + tskVari.getTskInfoTran().getTskInfoCommit());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueComSend("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'MOD' TO QUE-COM-SEND");

        queSend.setQueComSend("MOD");

        logger.debug("queSend.getQueComSend() :" + queSend.getQueComSend());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNamSend("                                                                                                                                                                                                                                                                                                            ");
        //tskVari.setTskTermTux("                                                                                                                                                                                                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TSK-TERM-TUX TO QUE-NAM-SEND");

        queSend.setQueNamSend(tskVari.getTskTermTux());

        logger.debug("queSend.getQueNamSend() :" + queSend.getQueNamSend());
        logger.debug("tskVari.getTskTermTux() :" + tskVari.getTskTermTux());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNumSend(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 1 TO QUE-NUM-SEND");

        queSend.setQueNumSend(1);

        logger.debug("queSend.getQueNumSend() :" + queSend.getQueNumSend());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueLarSend(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 4 TO QUE-LAR-SEND");

        queSend.setQueLarSend(4);

        logger.debug("queSend.getQueLarSend() :" + queSend.getQueLarSend());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueTrxSend("                                                                                                                                                                                                                                                                ");
        //tskVari.getTskInfoTran().setTskInfoTranidAlf("       ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TSK-INFO-TRANID-ALF TO QUE-TRX-SEND");

        queSend.setQueTrxSend(tskVari.getTskInfoTran().getTskInfoTranidAlf());

        logger.debug("queSend.getQueTrxSend() :" + queSend.getQueTrxSend());
        logger.debug("tskVari.getTskInfoTran().getTskInfoTranidAlf() :" + tskVari.getTskInfoTran().getTskInfoTranidAlf());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queVari.getQueItem().setQueData("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ");
        //tskVari.getTskInfoTran().setValue("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TSK-INFO-TRAN TO QUE-DATA");

        queVari.getQueItem().setQueData(tskVari.getTskInfoTran().getValue());

        logger.debug("queVari.getQueItem().getQueData() :" + queVari.getQueItem().getQueData());
        logger.debug("tskVari.getTskInfoTran().getValue() :" + tskVari.getTskInfoTran().getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueDatSend("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ");
        //queVari.getQueItem().setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE QUE-ITEM TO QUE-DAT-SEND");

        queSend.setQueDatSend(queVari.getQueItem().getValue());

        logger.debug("queSend.getQueDatSend() :" + queSend.getQueDatSend());
        logger.debug("queVari.getQueItem().getValue() :" + queVari.getQueItem().getValue());

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
     * gnsBusIdd
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsBusIdd() {

        logger.debug("entrando a 'gnsBusIdd()' ...");

        execute("gnsBusIdd_iniGnsBusIdd");

        logger.debug("saliendo de 'gnsBusIdd()' ...");

        return null;
    }

    /******************************************************************************
     * gnsBusIdd_iniGnsBusIdd
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsBusIdd_iniGnsBusIdd() {

        logger.debug("entrando a 'gnsBusIdd_iniGnsBusIdd()' ...");

        if (iddVari.getIddRegi().getIddCidd().compareTo(Util.spaces(12)) <= 0) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //idd.setIddCodCidd("            ");
            //fioCtts.setFioProg("        ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE FIO-PROG TO IDD-COD-CIDD IN IDD");

            idd.setIddCodCidd(fioCtts.getFioProg());

            logger.debug("idd.getIddCodCidd() :" + idd.getIddCodCidd());
            logger.debug("fioCtts.getFioProg() :" + fioCtts.getFioProg());
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioVari.setFioCmnd(0);
        //fioCtts.getFioVcmn().setFioGetKey(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE FIO-GET-KEY TO FIO-CMND");

        fioVari.setFioCmnd(fioCtts.getFioVcmn().getFioGetKey());

        logger.debug("fioVari.getFioCmnd() :" + fioVari.getFioCmnd());
        logger.debug("fioCtts.getFioVcmn().getFioGetKey() :" + fioCtts.getFioVcmn().getFioGetKey());

        execute("gnsFioIdd");

        if (!fioVari.getFioStat().isFioStatOks()) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //iddVari.getIddRegi().setIddCidd("            ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("DISPLAY 'NO EXISTE IDENTIFICACION INDEPENDENCIA DE DATOS: ' IDD-CIDD IN IDD-REGI");

            logger.info("NO EXISTE IDENTIFICACION INDEPENDENCIA DE DATOS: " + iddVari.getIddRegi().getIddCidd());

            logger.debug("iddVari.getIddRegi().getIddCidd() :" + iddVari.getIddRegi().getIddCidd());

            if (!iddVari.getIddRegi().getIddCidd().equals("DEFAULT")) {

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //idd.setIddCodCidd("            ");
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("MOVE 'DEFAULT' TO IDD-COD-CIDD IN IDD");

                idd.setIddCodCidd("DEFAULT");

                logger.debug("idd.getIddCodCidd() :" + idd.getIddCodCidd());

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //fioVari.setFioCmnd(0);
                //fioCtts.getFioVcmn().setFioGetKey(0);
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("MOVE FIO-GET-KEY TO FIO-CMND");

                fioVari.setFioCmnd(fioCtts.getFioVcmn().getFioGetKey());

                logger.debug("fioVari.getFioCmnd() :" + fioVari.getFioCmnd());
                logger.debug("fioCtts.getFioVcmn().getFioGetKey() :" + fioCtts.getFioVcmn().getFioGetKey());

                execute("gnsFioIdd");

                if (!fioVari.getFioStat().isFioStatOks()) {
                    logger.debug("DISPLAY 'NO EXISTE EL DEFAULT' 'COMO IDENTIFICACION INDEPENDENCIA DATOS'");

                    logger.info("NO EXISTE EL DEFAULTCOMO IDENTIFICACION INDEPENDENCIA DATOS");
                }
                else {

                    //// setters /////////////////////////////////////////////////////////////////////////////////
                    //iddVari.getIddRegi().setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          ");
                    //idd.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          ");
                    //////////////////////////////////////////////////////////////////////////////////////////////
                    logger.debug("MOVE IDD TO IDD-REGI");

                    iddVari.getIddRegi().setValue(idd.getValue());

                    logger.debug("iddVari.getIddRegi().getValue() :" + iddVari.getIddRegi().getValue());
                    logger.debug("idd.getValue() :" + idd.getValue());
                    logger.debug("GO TO EXT-GNS-BUS-IDD");


                    logger.debug("saliendo de 'gnsBusIdd_iniGnsBusIdd()' ...");
                    return "gnsBusIdd_extGnsBusIdd";
                }
            }
            else {
              // NEXT SENTENCE
            }
        }
        else {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //iddVari.getIddRegi().setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          ");
            //idd.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE IDD TO IDD-REGI");

            iddVari.getIddRegi().setValue(idd.getValue());

            logger.debug("iddVari.getIddRegi().getValue() :" + iddVari.getIddRegi().getValue());
            logger.debug("idd.getValue() :" + idd.getValue());
            logger.debug("GO TO EXT-GNS-BUS-IDD");


            logger.debug("saliendo de 'gnsBusIdd_iniGnsBusIdd()' ...");
            return "gnsBusIdd_extGnsBusIdd";
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO IDD-REGI");

        iddVari.getIddRegi().setValue(Util.spaces(490));

        logger.debug("iddVari.getIddRegi().getValue() :" + iddVari.getIddRegi().getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().setIddCidd("            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'DEFECTO' TO IDD-CIDD");

        iddVari.getIddRegi().setIddCidd("DEFECTO");

        logger.debug("iddVari.getIddRegi().getIddCidd() :" + iddVari.getIddRegi().getIddCidd());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(1 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'GNS' TO IDD-SIST( 01)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(1 - 1).getIddDent().setIddSist("GNS");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(1 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(1 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(1 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'C' TO IDD-GRPO( 01)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(1 - 1).getIddDent().setIddGrpo("C");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(1 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(1 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(1 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 01)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(1 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(1 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(1 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(1 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '180' TO IDD-IENT( 01)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(1 - 1).setIddIent("180");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(1 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(1 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(2 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'TAB' TO IDD-SIST( 02)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(2 - 1).getIddDent().setIddSist("TAB");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(2 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(2 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(2 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'C' TO IDD-GRPO( 02)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(2 - 1).getIddDent().setIddGrpo("C");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(2 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(2 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(2 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 02)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(2 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(2 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(2 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(2 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '150' TO IDD-IENT( 02)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(2 - 1).setIddIent("150");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(2 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(2 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(3 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'GES' TO IDD-SIST( 03)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(3 - 1).getIddDent().setIddSist("GES");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(3 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(3 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(3 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'M' TO IDD-GRPO( 03)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(3 - 1).getIddDent().setIddGrpo("M");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(3 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(3 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(3 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 03)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(3 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(3 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(3 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(3 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '360' TO IDD-IENT( 03)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(3 - 1).setIddIent("360");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(3 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(3 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(4 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'SGC' TO IDD-SIST( 04)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(4 - 1).getIddDent().setIddSist("SGC");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(4 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(4 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(4 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'M' TO IDD-GRPO( 04)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(4 - 1).getIddDent().setIddGrpo("M");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(4 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(4 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(4 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 04)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(4 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(4 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(4 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(4 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '100' TO IDD-IENT( 04)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(4 - 1).setIddIent("100");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(4 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(4 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(5 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'SGC' TO IDD-SIST( 05)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(5 - 1).getIddDent().setIddSist("SGC");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(5 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(5 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(5 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'C' TO IDD-GRPO( 05)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(5 - 1).getIddDent().setIddGrpo("C");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(5 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(5 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(5 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 05)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(5 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(5 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(5 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(5 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '190' TO IDD-IENT( 05)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(5 - 1).setIddIent("190");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(5 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(5 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(6 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'SGC' TO IDD-SIST( 06)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(6 - 1).getIddDent().setIddSist("SGC");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(6 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(6 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(6 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'T' TO IDD-GRPO( 06)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(6 - 1).getIddDent().setIddGrpo("T");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(6 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(6 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(6 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 06)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(6 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(6 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(6 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(6 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '100' TO IDD-IENT( 06)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(6 - 1).setIddIent("100");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(6 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(6 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(7 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'DEU' TO IDD-SIST( 07)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(7 - 1).getIddDent().setIddSist("DEU");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(7 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(7 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(7 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'M' TO IDD-GRPO( 07)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(7 - 1).getIddDent().setIddGrpo("M");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(7 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(7 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(7 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 07)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(7 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(7 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(7 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(7 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '140' TO IDD-IENT( 07)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(7 - 1).setIddIent("140");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(7 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(7 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(8 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'GNS' TO IDD-SIST( 08)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(8 - 1).getIddDent().setIddSist("GNS");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(8 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(8 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(8 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'M' TO IDD-GRPO( 08)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(8 - 1).getIddDent().setIddGrpo("M");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(8 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(8 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(8 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 08)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(8 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(8 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(8 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(8 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '180' TO IDD-IENT( 08)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(8 - 1).setIddIent("180");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(8 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(8 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(9 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'DEU' TO IDD-SIST( 09)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(9 - 1).getIddDent().setIddSist("DEU");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(9 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(9 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(9 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'C' TO IDD-GRPO( 09)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(9 - 1).getIddDent().setIddGrpo("C");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(9 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(9 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(9 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 09)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(9 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(9 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(9 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(9 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '200' TO IDD-IENT( 09)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(9 - 1).setIddIent("200");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(9 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(9 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(10 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'MC2' TO IDD-SIST( 10)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(10 - 1).getIddDent().setIddSist("MC2");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(10 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(10 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(10 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'C' TO IDD-GRPO( 10)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(10 - 1).getIddDent().setIddGrpo("C");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(10 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(10 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(10 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 10)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(10 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(10 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(10 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(10 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '501' TO IDD-IENT( 10)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(10 - 1).setIddIent("501");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(10 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(10 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(11 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'GES' TO IDD-SIST( 11)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(11 - 1).getIddDent().setIddSist("GES");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(11 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(11 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(11 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'T' TO IDD-GRPO( 11)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(11 - 1).getIddDent().setIddGrpo("T");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(11 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(11 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(11 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 11)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(11 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(11 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(11 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(11 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '362' TO IDD-IENT( 11)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(11 - 1).setIddIent("362");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(11 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(11 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(12 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'GES' TO IDD-SIST( 12)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(12 - 1).getIddDent().setIddSist("GES");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(12 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(12 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(12 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'C' TO IDD-GRPO( 12)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(12 - 1).getIddDent().setIddGrpo("C");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(12 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(12 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(12 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 12)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(12 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(12 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(12 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(12 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '354' TO IDD-IENT( 12)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(12 - 1).setIddIent("354");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(12 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(12 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(13 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'COL' TO IDD-SIST( 13)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(13 - 1).getIddDent().setIddSist("COL");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(13 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(13 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(13 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'M' TO IDD-GRPO( 13)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(13 - 1).getIddDent().setIddGrpo("M");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(13 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(13 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(13 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 13)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(13 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(13 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(13 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(13 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '160' TO IDD-IENT( 13)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(13 - 1).setIddIent("160");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(13 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(13 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(14 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'COL' TO IDD-SIST( 14)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(14 - 1).getIddDent().setIddSist("COL");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(14 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(14 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(14 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'T' TO IDD-GRPO( 14)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(14 - 1).getIddDent().setIddGrpo("T");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(14 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(14 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(14 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 14)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(14 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(14 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(14 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(14 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '170' TO IDD-IENT( 14)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(14 - 1).setIddIent("170");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(14 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(14 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(15 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'COL' TO IDD-SIST( 15)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(15 - 1).getIddDent().setIddSist("COL");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(15 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(15 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(15 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'C' TO IDD-GRPO( 15)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(15 - 1).getIddDent().setIddGrpo("C");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(15 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(15 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(15 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 15)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(15 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(15 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(15 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(15 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '210' TO IDD-IENT( 15)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(15 - 1).setIddIent("210");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(15 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(15 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(16 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'BGL' TO IDD-SIST( 16)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(16 - 1).getIddDent().setIddSist("BGL");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(16 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(16 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(16 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'M' TO IDD-GRPO( 16)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(16 - 1).getIddDent().setIddGrpo("M");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(16 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(16 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(16 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 16)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(16 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(16 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(16 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(16 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '209' TO IDD-IENT( 16)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(16 - 1).setIddIent("209");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(16 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(16 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(17 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'GAR' TO IDD-SIST( 17)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(17 - 1).getIddDent().setIddSist("GAR");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(17 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(17 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(17 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'T' TO IDD-GRPO( 17)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(17 - 1).getIddDent().setIddGrpo("T");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(17 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(17 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(17 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 17)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(17 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(17 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(17 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(17 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '130' TO IDD-IENT( 17)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(17 - 1).setIddIent("130");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(17 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(17 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(18 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'DAP' TO IDD-SIST( 18)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(18 - 1).getIddDent().setIddSist("DAP");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(18 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(18 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(18 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'M' TO IDD-GRPO( 18)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(18 - 1).getIddDent().setIddGrpo("M");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(18 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(18 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(18 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 18)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(18 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(18 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(18 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(18 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '370' TO IDD-IENT( 18)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(18 - 1).setIddIent("370");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(18 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(18 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(19 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'SIN' TO IDD-SIST( 19)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(19 - 1).getIddDent().setIddSist("SIN");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(19 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(19 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(19 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'C' TO IDD-GRPO( 19)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(19 - 1).getIddDent().setIddGrpo("C");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(19 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(19 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(19 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 19)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(19 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(19 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(19 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(19 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '190' TO IDD-IENT( 19)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(19 - 1).setIddIent("190");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(19 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(19 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(20 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'SPA' TO IDD-SIST( 20)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(20 - 1).getIddDent().setIddSist("SPA");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(20 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(20 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(20 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'C' TO IDD-GRPO( 20)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(20 - 1).getIddDent().setIddGrpo("C");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(20 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(20 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(20 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 20)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(20 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(20 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(20 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(20 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '355' TO IDD-IENT( 20)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(20 - 1).setIddIent("355");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(20 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(20 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(21 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'SGC' TO IDD-SIST( 21)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(21 - 1).getIddDent().setIddSist("SGC");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(21 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(21 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(21 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'S' TO IDD-GRPO( 21)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(21 - 1).getIddDent().setIddGrpo("S");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(21 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(21 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(21 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 21)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(21 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(21 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(21 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(21 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '101' TO IDD-IENT( 21)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(21 - 1).setIddIent("101");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(21 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(21 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(22 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'SPA' TO IDD-SIST( 22)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(22 - 1).getIddDent().setIddSist("SPA");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(22 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(22 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(22 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'M' TO IDD-GRPO( 22)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(22 - 1).getIddDent().setIddGrpo("M");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(22 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(22 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(22 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 22)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(22 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(22 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(22 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(22 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '355' TO IDD-IENT( 22)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(22 - 1).setIddIent("355");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(22 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(22 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(23 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'GES' TO IDD-SIST( 23)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(23 - 1).getIddDent().setIddSist("GES");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(23 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(23 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(23 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'C' TO IDD-GRPO( 23)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(23 - 1).getIddDent().setIddGrpo("C");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(23 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(23 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(23 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 23)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(23 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(23 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(23 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(23 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '354' TO IDD-IENT( 23)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(23 - 1).setIddIent("354");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(23 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(23 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(24 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'CCT' TO IDD-SIST( 24)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(24 - 1).getIddDent().setIddSist("CCT");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(24 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(24 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(24 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'C' TO IDD-GRPO( 24)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(24 - 1).getIddDent().setIddGrpo("C");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(24 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(24 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(24 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 24)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(24 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(24 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(24 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(24 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '381' TO IDD-IENT( 24)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(24 - 1).setIddIent("381");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(24 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(24 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(25 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'DAP' TO IDD-SIST( 25)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(25 - 1).getIddDent().setIddSist("DAP");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(25 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(25 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(25 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'C' TO IDD-GRPO( 25)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(25 - 1).getIddDent().setIddGrpo("C");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(25 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(25 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(25 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 25)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(25 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(25 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(25 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(25 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '371' TO IDD-IENT( 25)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(25 - 1).setIddIent("371");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(25 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(25 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(26 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'DAP' TO IDD-SIST( 26)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(26 - 1).getIddDent().setIddSist("DAP");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(26 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(26 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(26 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'T' TO IDD-GRPO( 26)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(26 - 1).getIddDent().setIddGrpo("T");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(26 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(26 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(26 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 26)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(26 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(26 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(26 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(26 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '372' TO IDD-IENT( 26)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(26 - 1).setIddIent("372");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(26 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(26 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(27 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'SEC' TO IDD-SIST( 27)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(27 - 1).getIddDent().setIddSist("SEC");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(27 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(27 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(27 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'C' TO IDD-GRPO( 27)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(27 - 1).getIddDent().setIddGrpo("C");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(27 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(27 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(27 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 27)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(27 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(27 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(27 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(27 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '341' TO IDD-IENT( 27)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(27 - 1).setIddIent("341");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(27 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(27 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(28 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'SUP' TO IDD-SIST( 28)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(28 - 1).getIddDent().setIddSist("SUP");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(28 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(28 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(28 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'M' TO IDD-GRPO( 28)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(28 - 1).getIddDent().setIddGrpo("M");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(28 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(28 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(28 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 28)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(28 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(28 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(28 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(28 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '230' TO IDD-IENT( 28)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(28 - 1).setIddIent("230");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(28 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(28 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(29 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'SUP' TO IDD-SIST( 29)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(29 - 1).getIddDent().setIddSist("SUP");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(29 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(29 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(29 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'C' TO IDD-GRPO( 29)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(29 - 1).getIddDent().setIddGrpo("C");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(29 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(29 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(29 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 29)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(29 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(29 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(29 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(29 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '230' TO IDD-IENT( 29)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(29 - 1).setIddIent("230");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(29 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(29 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(30 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'LDC' TO IDD-SIST( 30)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(30 - 1).getIddDent().setIddSist("LDC");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(30 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(30 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(30 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'M' TO IDD-GRPO( 30)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(30 - 1).getIddDent().setIddGrpo("M");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(30 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(30 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(30 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 30)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(30 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(30 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(30 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(30 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '260' TO IDD-IENT( 30)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(30 - 1).setIddIent("260");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(30 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(30 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(31 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'SEC' TO IDD-SIST( 31)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(31 - 1).getIddDent().setIddSist("SEC");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(31 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(31 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(31 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'M' TO IDD-GRPO( 31)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(31 - 1).getIddDent().setIddGrpo("M");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(31 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(31 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(31 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 31)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(31 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(31 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(31 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(31 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '341' TO IDD-IENT( 31)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(31 - 1).setIddIent("341");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(31 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(31 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(32 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'LDC' TO IDD-SIST( 32)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(32 - 1).getIddDent().setIddSist("LDC");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(32 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(32 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(32 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'C' TO IDD-GRPO( 32)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(32 - 1).getIddDent().setIddGrpo("C");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(32 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(32 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(32 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 32)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(32 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(32 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(32 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(32 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '261' TO IDD-IENT( 32)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(32 - 1).setIddIent("261");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(32 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(32 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(33 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'CCT' TO IDD-SIST( 33)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(33 - 1).getIddDent().setIddSist("CCT");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(33 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(33 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(33 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'M' TO IDD-GRPO( 33)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(33 - 1).getIddDent().setIddGrpo("M");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(33 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(33 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(33 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 33)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(33 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(33 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(33 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(33 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '380' TO IDD-IENT( 33)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(33 - 1).setIddIent("380");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(33 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(33 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(34 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'BGL' TO IDD-SIST( 34)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(34 - 1).getIddDent().setIddSist("BGL");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(34 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(34 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(34 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'C' TO IDD-GRPO( 34)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(34 - 1).getIddDent().setIddGrpo("C");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(34 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(34 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(34 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 34)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(34 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(34 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(34 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(34 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '211' TO IDD-IENT( 34)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(34 - 1).setIddIent("211");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(34 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(34 - 1).getIddIent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(35 - 1).getIddDent().setIddSist("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'MC2' TO IDD-SIST( 35)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(35 - 1).getIddDent().setIddSist("MC2");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(35 - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(35 - 1).getIddDent().getIddSist());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(35 - 1).getIddDent().setIddGrpo(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'M' TO IDD-GRPO( 35)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(35 - 1).getIddDent().setIddGrpo("M");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(35 - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(35 - 1).getIddDent().getIddGrpo());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(35 - 1).setIddTent(" ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'D' TO IDD-TENT( 35)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(35 - 1).setIddTent("D");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(35 - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(35 - 1).getIddTent());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().getIddFsis().getIddVsis(35 - 1).setIddIent("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE '500' TO IDD-IENT( 35)");

        iddVari.getIddRegi().getIddFsis().getIddVsis(35 - 1).setIddIent("500");

        logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(35 - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(35 - 1).getIddIent());

        logger.debug("saliendo de 'gnsBusIdd_iniGnsBusIdd()' ...");

        return "gnsBusIdd_extGnsBusIdd";
    }

    /******************************************************************************
     * gnsBusIdd_extGnsBusIdd
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsBusIdd_extGnsBusIdd() {

        logger.debug("entrando a 'gnsBusIdd_extGnsBusIdd()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.getIddRegi().setIddCidd("            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("DISPLAY 'PROGRAMA USARA : ' IDD-CIDD IN IDD-REGI ' COMO IDENTIFICACION INDEPENDENCIA DE DATOS : '");

        logger.info("PROGRAMA USARA : " + iddVari.getIddRegi().getIddCidd() + " COMO IDENTIFICACION INDEPENDENCIA DE DATOS : ");

        logger.debug("iddVari.getIddRegi().getIddCidd() :" + iddVari.getIddRegi().getIddCidd());
        logger.debug("DISPLAY 'SISTEMA GRUPO TABLA TIPO IDENTIFICACION'");

        logger.info("SISTEMA GRUPO TABLA TIPO IDENTIFICACION");
        logger.debug("DISPLAY '======================================='");

        logger.info("=======================================");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.setIddIaux(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 1 TO IDD-IAUX");

        iddVari.setIddIaux(1);

        logger.debug("iddVari.getIddIaux() :" + iddVari.getIddIaux());

        logger.debug("saliendo de 'gnsBusIdd_extGnsBusIdd()' ...");

        return "gnsBusIdd_lupGnsBusIdd";
    }

    /******************************************************************************
     * gnsBusIdd_lupGnsBusIdd
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsBusIdd_lupGnsBusIdd() {

        logger.debug("entrando a 'gnsBusIdd_lupGnsBusIdd()' ...");

        if (iddVari.getIddRegi().getIddFsis().getIddVsis(iddVari.getIddIaux() - 1).getIddDent().getIddSist().compareTo(Util.spaces(3)) > 0) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //iddVari.setIddIaux(0);
            //iddVari.getIddRegi().getIddFsis().getIddVsis(iddVari.getIddIaux() - 1).getIddDent().setIddSist("   ");
            //iddVari.setIddIaux(0);
            //iddVari.getIddRegi().getIddFsis().getIddVsis(iddVari.getIddIaux() - 1).getIddDent().setIddGrpo(" ");
            //iddVari.setIddIaux(0);
            //iddVari.getIddRegi().getIddFsis().getIddVsis(iddVari.getIddIaux() - 1).getIddDent().setIddRgst("   ");
            //iddVari.setIddIaux(0);
            //iddVari.getIddRegi().getIddFsis().getIddVsis(iddVari.getIddIaux() - 1).setIddTent(" ");
            //iddVari.setIddIaux(0);
            //iddVari.getIddRegi().getIddFsis().getIddVsis(iddVari.getIddIaux() - 1).setIddIent("   ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("DISPLAY '| ' IDD-SIST IN IDD-VARI( IDD-IAUX) '     ' IDD-GRPO IN IDD-VARI( IDD-IAUX) '    ' IDD-RGST IN IDD-VARI( IDD-IAUX) '   ' IDD-TENT IN IDD-VARI( IDD-IAUX) '        ' IDD-IENT IN IDD-VARI( IDD-IAUX) '     |'");

            logger.info("| " + iddVari.getIddRegi().getIddFsis().getIddVsis(iddVari.getIddIaux() - 1).getIddDent().getIddSist() + "     " + iddVari.getIddRegi().getIddFsis().getIddVsis(iddVari.getIddIaux() - 1).getIddDent().getIddGrpo() + "    " + iddVari.getIddRegi().getIddFsis().getIddVsis(iddVari.getIddIaux() - 1).getIddDent().getIddRgst() + "   " + iddVari.getIddRegi().getIddFsis().getIddVsis(iddVari.getIddIaux() - 1).getIddTent() + "        " + iddVari.getIddRegi().getIddFsis().getIddVsis(iddVari.getIddIaux() - 1).getIddIent() + "     |");

            logger.debug("iddVari.getIddIaux() :" + iddVari.getIddIaux());
            logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(iddVari.getIddIaux() - 1).getIddDent().getIddSist() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(iddVari.getIddIaux() - 1).getIddDent().getIddSist());
            logger.debug("iddVari.getIddIaux() :" + iddVari.getIddIaux());
            logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(iddVari.getIddIaux() - 1).getIddDent().getIddGrpo() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(iddVari.getIddIaux() - 1).getIddDent().getIddGrpo());
            logger.debug("iddVari.getIddIaux() :" + iddVari.getIddIaux());
            logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(iddVari.getIddIaux() - 1).getIddDent().getIddRgst() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(iddVari.getIddIaux() - 1).getIddDent().getIddRgst());
            logger.debug("iddVari.getIddIaux() :" + iddVari.getIddIaux());
            logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(iddVari.getIddIaux() - 1).getIddTent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(iddVari.getIddIaux() - 1).getIddTent());
            logger.debug("iddVari.getIddIaux() :" + iddVari.getIddIaux());
            logger.debug("iddVari.getIddRegi().getIddFsis().getIddVsis(iddVari.getIddIaux() - 1).getIddIent() :" + iddVari.getIddRegi().getIddFsis().getIddVsis(iddVari.getIddIaux() - 1).getIddIent());
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //iddVari.setIddIaux(0);
        //iddVari.setIddIaux(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("ADD 1 TO IDD-IAUX");

        iddVari.setIddIaux(1 + iddVari.getIddIaux());

        logger.debug("iddVari.getIddIaux() :" + iddVari.getIddIaux());
        logger.debug("iddVari.getIddIaux() :" + iddVari.getIddIaux());

        if (iddVari.getIddIaux() <= 30) {
            logger.debug("GO TO LUP-GNS-BUS-IDD");


            logger.debug("saliendo de 'gnsBusIdd_lupGnsBusIdd()' ...");
            return "gnsBusIdd_lupGnsBusIdd";
        }
        logger.debug("DISPLAY '======================================='");

        logger.info("=======================================");

        logger.debug("saliendo de 'gnsBusIdd_lupGnsBusIdd()' ...");

        return "gnsBusIdd_finGnsBusIdd";
    }

    /******************************************************************************
     * gnsBusIdd_finGnsBusIdd
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsBusIdd_finGnsBusIdd() {

        logger.debug("entrando a 'gnsBusIdd_finGnsBusIdd()' ...");

        logger.debug("saliendo de 'gnsBusIdd_finGnsBusIdd()' ...");

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
        logger.debug("MOVE ADR-IDD-REQA TO ADR-REQA");

        adrReqa.setValue(adrIddReqa.getValue());

        logger.debug("adrReqa.getValue() :" + adrReqa.getValue());
        logger.debug("adrIddReqa.getValue() :" + adrIddReqa.getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //adrReqa.setAdrTabl("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'IDD' TO ADR-TABL IN ADR-REQA");

        adrReqa.setAdrTabl("IDD");

        logger.debug("adrReqa.getAdrTabl() :" + adrReqa.getAdrTabl());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //adrReqa.setAdrDbid(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 999 TO ADR-DBID IN ADR-REQA");

        adrReqa.setAdrDbid(999);

        logger.debug("adrReqa.getAdrDbid() :" + adrReqa.getAdrDbid());

        if (fioVari.getFioAkey().compareTo(Util.spaces(32)) <= 0) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioVari.setFioAkey("                                ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE 'IDD-COD-CIDD' TO FIO-AKEY");

            fioVari.setFioAkey("IDD-COD-CIDD");

            logger.debug("fioVari.getFioAkey() :" + fioVari.getFioAkey());
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //adrElls.setAdrElm1("     ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'IDD00' TO ADR-ELM1");

        adrElls.setAdrElm1("IDD00");

        logger.debug("adrElls.getAdrElm1() :" + adrElls.getAdrElm1());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //adrUifb.setAdrProg("        ");
        //fioCtts.setFioProg("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE FIO-PROG TO ADR-PROG");

        adrUifb.setAdrProg(fioCtts.getFioProg());

        logger.debug("adrUifb.getAdrProg() :" + adrUifb.getAdrProg());
        logger.debug("fioCtts.getFioProg() :" + fioCtts.getFioProg());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioCtts.setFioIaky(0);
        //fioVari.setFioCmnd(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE FIO-CMND TO FIO-IAKY");

        fioCtts.setFioIaky(fioVari.getFioCmnd());

        logger.debug("fioCtts.getFioIaky() :" + fioCtts.getFioIaky());
        logger.debug("fioVari.getFioCmnd() :" + fioVari.getFioCmnd());

        if (!fioCtts.isFioIakyCon() && (fioVari.getFioAkey().equals("IDD-COD-CIDD") || fioVari.getFioAkey().compareTo(Util.spaces(32)) <= 0)) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //adrReqa.setAdrVkey("                                                                                                                                                                                    ");
            //idd.setIddCodCidd("            ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE IDD-COD-CIDD IN IDD TO ADR-VKEY IN ADR-REQA");

            adrReqa.setAdrVkey(idd.getIddCodCidd());

            logger.debug("adrReqa.getAdrVkey() :" + adrReqa.getAdrVkey());
            logger.debug("idd.getIddCodCidd() :" + idd.getIddCodCidd());

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //adrReqa.setAdrDkey("     ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE 'IDD00' TO ADR-DKEY IN ADR-REQA");

            adrReqa.setAdrDkey("IDD00");

            logger.debug("adrReqa.getAdrDkey() :" + adrReqa.getAdrDkey());
        }
        else {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioCtts.getFioMens().setValue("                                                                                ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE 'En GNS-FIO-IDD, key' TO FIO-MENS");

            fioCtts.getFioMens().setValue("En GNS-FIO-IDD, key");

            logger.debug("fioCtts.getFioMens().getValue() :" + fioCtts.getFioMens().getValue());

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioCtts.getFioMensRed().setFioMensKey("                                ");
            //fioVari.setFioAkey("                                ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE FIO-AKEY TO FIO-MENS-KEY");

            fioCtts.getFioMensRed().setFioMensKey(fioVari.getFioAkey());

            logger.debug("fioCtts.getFioMensRed().getFioMensKey() :" + fioCtts.getFioMensRed().getFioMensKey());
            logger.debug("fioVari.getFioAkey() :" + fioVari.getFioAkey());

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioCtts.getFioMensRed().setFioMensFil("         ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE 'Invalida' TO FIO-MENS-FIL");

            fioCtts.getFioMensRed().setFioMensFil("Invalida");

            logger.debug("fioCtts.getFioMensRed().getFioMensFil() :" + fioCtts.getFioMensRed().getFioMensFil());

            execute("prgAbt");
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioCtts.setFioDfld("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ");
        //idd.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE IDD TO FIO-DFLD");

        fioCtts.setFioDfld(idd.getValue());

        logger.debug("fioCtts.getFioDfld() :" + fioCtts.getFioDfld());
        logger.debug("idd.getValue() :" + idd.getValue());

        execute("gnsFioDtc");

        if (fioVari.getFioStat().isFioStatOks()) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //idd.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          ");
            //fioCtts.setFioDfld("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE FIO-DFLD TO IDD");

            idd.setValue(fioCtts.getFioDfld());

            logger.debug("idd.getValue() :" + idd.getValue());
            logger.debug("fioCtts.getFioDfld() :" + fioCtts.getFioDfld());
        }
        else {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioCtts.getFioMensRed().getFioMensFilRed().setFioMensSis("   ");
            //fioVari.getFioVoid().setFioSist("   ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE FIO-SIST TO FIO-MENS-SIS");

            fioCtts.getFioMensRed().getFioMensFilRed().setFioMensSis(fioVari.getFioVoid().getFioSist());

            logger.debug("fioCtts.getFioMensRed().getFioMensFilRed().getFioMensSis() :" + fioCtts.getFioMensRed().getFioMensFilRed().getFioMensSis());
            logger.debug("fioVari.getFioVoid().getFioSist() :" + fioVari.getFioVoid().getFioSist());

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //fioCtts.getFioMensRed().getFioMensFilRed().setFioMensReg("      ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE 'IDD' TO FIO-MENS-REG");

            fioCtts.getFioMensRed().getFioMensFilRed().setFioMensReg("IDD");

            logger.debug("fioCtts.getFioMensRed().getFioMensFilRed().getFioMensReg() :" + fioCtts.getFioMensRed().getFioMensFilRed().getFioMensReg());

            if (fioVari.getFioStat().isFioStatFtl()) {

                execute("prgAbt");
            }
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioVari.setFioAkey("                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO FIO-AKEY");

        fioVari.setFioAkey(Util.spaces(32));

        logger.debug("fioVari.getFioAkey() :" + fioVari.getFioAkey());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //adrIddReqa.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ");
        //adrReqa.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE ADR-REQA TO ADR-IDD-REQA");

        adrIddReqa.setValue(adrReqa.getValue());

        logger.debug("adrIddReqa.getValue() :" + adrIddReqa.getValue());
        logger.debug("adrReqa.getValue() :" + adrReqa.getValue());

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
     * gnsProEnd
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsProEnd() {

        logger.debug("entrando a 'gnsProEnd()' ...");

        execute("gnsProEnd_iniGnsProEnd");

        logger.debug("saliendo de 'gnsProEnd()' ...");

        return null;
    }

    /******************************************************************************
     * gnsProEnd_iniGnsProEnd
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsProEnd_iniGnsProEnd() {

        logger.debug("entrando a 'gnsProEnd_iniGnsProEnd()' ...");

        System.exit(returnCode);

        logger.debug("saliendo de 'gnsProEnd_iniGnsProEnd()' ...");

        return null;
    }

    /******************************************************************************
     * gnsProEnd_finGnsProEnd
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsProEnd_finGnsProEnd() {

        logger.debug("entrando a 'gnsProEnd_finGnsProEnd()' ...");

        System.exit(returnCode);

        logger.debug("saliendo de 'gnsProEnd_finGnsProEnd()' ...");

        return null;
    }

    /******************************************************************************
     * doTpinit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String doTpinit() {

        logger.debug("entrando a 'doTpinit()' ...");

        execute("doTpinit_iniDoTpinit");

        logger.debug("saliendo de 'doTpinit()' ...");

        return null;
    }

    /******************************************************************************
     * doTpinit_iniDoTpinit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String doTpinit_iniDoTpinit() {

        logger.debug("entrando a 'doTpinit_iniDoTpinit()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tpinfdefRec.setUsrname("                              ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO USRNAME");

        tpinfdefRec.setUsrname(Util.spaces(30));

        logger.debug("tpinfdefRec.getUsrname() :" + tpinfdefRec.getUsrname());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tpinfdefRec.setCltname("                              ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO CLTNAME");

        tpinfdefRec.setCltname(Util.spaces(30));

        logger.debug("tpinfdefRec.getCltname() :" + tpinfdefRec.getCltname());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tpinfdefRec.setPasswd("                              ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO PASSWD");

        tpinfdefRec.setPasswd(Util.spaces(30));

        logger.debug("tpinfdefRec.getPasswd() :" + tpinfdefRec.getPasswd());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tpinfdefRec.setGrpname("                              ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO GRPNAME");

        tpinfdefRec.setGrpname(Util.spaces(30));

        logger.debug("tpinfdefRec.getGrpname() :" + tpinfdefRec.getGrpname());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tpinfdefRec.setDatalen(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE ZERO TO DATALEN");

        tpinfdefRec.setDatalen(0);

        logger.debug("tpinfdefRec.getDatalen() :" + tpinfdefRec.getDatalen());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tpinfdefRec.setTpuDip(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("SET TPU-DIP TO TRUE");

        tpinfdefRec.setTpuDip(true);

        logger.debug("tpinfdefRec.isTpuDip() :" + tpinfdefRec.isTpuDip());
        logger.debug("CALL \"TPINITIALIZE\" USING TPINFDEF-REC USER-DATA-REC TPSTATUS-REC");

        if (!tpstatusRec.isTpok()) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //logmsg.getLogmsgText().setValue("                                                  ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE \"TPINITIALIZE Failed\" TO LOGMSG-TEXT");

            logmsg.getLogmsgText().setValue("TPINITIALIZE Failed");

            logger.debug("logmsg.getLogmsgText().getValue() :" + logmsg.getLogmsgText().getValue());

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //logmsg.setValue("                                                                      ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("DISPLAY 'LOGMSG :' LOGMSG");

            logger.info("LOGMSG :" + logmsg.getValue());

            logger.debug("logmsg.getValue() :" + logmsg.getValue());

            execute("exitProgram");
        }

        logger.debug("saliendo de 'doTpinit_iniDoTpinit()' ...");

        return "doTpinit_finDoTpinit";
    }

    /******************************************************************************
     * doTpinit_finDoTpinit
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String doTpinit_finDoTpinit() {

        logger.debug("entrando a 'doTpinit_finDoTpinit()' ...");

        logger.debug("saliendo de 'doTpinit_finDoTpinit()' ...");

        return null;
    }

    /******************************************************************************
     * doTpterm
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String doTpterm() {

        logger.debug("entrando a 'doTpterm()' ...");

        execute("doTpterm_iniDoTpterm");

        logger.debug("saliendo de 'doTpterm()' ...");

        return null;
    }

    /******************************************************************************
     * doTpterm_iniDoTpterm
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String doTpterm_iniDoTpterm() {

        logger.debug("entrando a 'doTpterm_iniDoTpterm()' ...");
        logger.debug("DISPLAY 'PERFORM DO-TPTERM'");

        logger.info("PERFORM DO-TPTERM");
        logger.debug("CALL \"TPTERM\" USING TPSTATUS-REC");

        if (!tpstatusRec.isTpok()) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //logmsg.getLogmsgText().setValue("                                                  ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE \"TPTERM Failed\" TO LOGMSG-TEXT");

            logmsg.getLogmsgText().setValue("TPTERM Failed");

            logger.debug("logmsg.getLogmsgText().getValue() :" + logmsg.getLogmsgText().getValue());

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //logmsg.setValue("                                                                      ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("DISPLAY 'LOGMSG :' LOGMSG");

            logger.info("LOGMSG :" + logmsg.getValue());

            logger.debug("logmsg.getValue() :" + logmsg.getValue());
        }

        logger.debug("saliendo de 'doTpterm_iniDoTpterm()' ...");

        return "doTpterm_finDoTpterm";
    }

    /******************************************************************************
     * doTpterm_finDoTpterm
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String doTpterm_finDoTpterm() {

        logger.debug("entrando a 'doTpterm_finDoTpterm()' ...");

        logger.debug("saliendo de 'doTpterm_finDoTpterm()' ...");

        return null;
    }

    /******************************************************************************
     * exitProgram
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String exitProgram() {

        logger.debug("entrando a 'exitProgram()' ...");

        execute("exitProgram_iniExitProgram");

        logger.debug("saliendo de 'exitProgram()' ...");

        return null;
    }

    /******************************************************************************
     * exitProgram_iniExitProgram
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String exitProgram_iniExitProgram() {

        logger.debug("entrando a 'exitProgram_iniExitProgram()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //logmsg.getLogmsgText().setValue("                                                  ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE \"Ended\" TO LOGMSG-TEXT");

        logmsg.getLogmsgText().setValue("Ended");

        logger.debug("logmsg.getLogmsgText().getValue() :" + logmsg.getLogmsgText().getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //logmsg.setValue("                                                                      ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("DISPLAY 'LOGMSG :' LOGMSG");

        logger.info("LOGMSG :" + logmsg.getValue());

        logger.debug("logmsg.getValue() :" + logmsg.getValue());
        logger.debug("STOP RUN");

        System.exit(returnCode);

        logger.debug("saliendo de 'exitProgram_iniExitProgram()' ...");

        return null;
    }

    /******************************************************************************
     * exitProgram_finExitProgram
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String exitProgram_finExitProgram() {

        logger.debug("entrando a 'exitProgram_finExitProgram()' ...");

        logger.debug("saliendo de 'exitProgram_finExitProgram()' ...");

        return null;
    }

    /******************************************************************************
     * gnsPutTsk
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsPutTsk() {

        logger.debug("entrando a 'gnsPutTsk()' ...");

        execute("gnsPutTsk_iniGnsPutTsk");

        logger.debug("saliendo de 'gnsPutTsk()' ...");

        return null;
    }

    /******************************************************************************
     * gnsPutTsk_iniGnsPutTsk
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsPutTsk_iniGnsPutTsk() {

        logger.debug("entrando a 'gnsPutTsk_iniGnsPutTsk()' ...");
        logger.debug("CALL \"TPBEGIN\" USING TPTRXDEF-REC TPSTATUS-REC");

        if (!tpstatusRec.isTpok()) {

            execute("prgAbt");
        }
        else {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //tpstatusRec.setTpStatus(0);
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("DISPLAY 'TPGETLEV TP-IN-TRAN    :' TP-STATUS");

            logger.info("TPGETLEV TP-IN-TRAN    :" + tpstatusRec.getTpStatus());

            logger.debug("tpstatusRec.getTpStatus() :" + tpstatusRec.getTpStatus());
        }
        logger.debug("CALL \"TPSUSPEND\" USING TPTRXDEF-REC TPSTATUS-REC");

        if (!tpstatusRec.isTpok()) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //tpstatusRec.setTpStatus(0);
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("DISPLAY 'ERROR  TPSUSPEND :' TP-STATUS");

            logger.info("ERROR  TPSUSPEND :" + tpstatusRec.getTpStatus());

            logger.debug("tpstatusRec.getTpStatus() :" + tpstatusRec.getTpStatus());
        }
        logger.debug("CALL \"TPRESUME\" USING TPTRXDEF-REC TPSTATUS-REC");

        if (!tpstatusRec.isTpok()) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //tpstatusRec.setTpStatus(0);
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("DISPLAY 'ERROR  TPRESUME  :' TP-STATUS");

            logger.info("ERROR  TPRESUME  :" + tpstatusRec.getTpStatus());

            logger.debug("tpstatusRec.getTpStatus() :" + tpstatusRec.getTpStatus());
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.getTskTranid().setTskTranid1(0L);
        //tptrxdefRec.setTranid(1 - 1, 0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TRANID( 1) TO TSK-TRANID-1");

        tskVari.getTskTranid().setTskTranid1(tptrxdefRec.getTranid(1 - 1));

        logger.debug("tskVari.getTskTranid().getTskTranid1() :" + tskVari.getTskTranid().getTskTranid1());
        logger.debug("tptrxdefRec.getTranid(1 - 1) :" + tptrxdefRec.getTranid(1 - 1));

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.getTskTranid().setTskTranid2(0L);
        //tptrxdefRec.setTranid(2 - 1, 0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TRANID( 2) TO TSK-TRANID-2");

        tskVari.getTskTranid().setTskTranid2(tptrxdefRec.getTranid(2 - 1));

        logger.debug("tskVari.getTskTranid().getTskTranid2() :" + tskVari.getTskTranid().getTskTranid2());
        logger.debug("tptrxdefRec.getTranid(2 - 1) :" + tptrxdefRec.getTranid(2 - 1));

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.getTskTranid().setTskTranid3(0L);
        //tptrxdefRec.setTranid(3 - 1, 0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TRANID( 3) TO TSK-TRANID-3");

        tskVari.getTskTranid().setTskTranid3(tptrxdefRec.getTranid(3 - 1));

        logger.debug("tskVari.getTskTranid().getTskTranid3() :" + tskVari.getTskTranid().getTskTranid3());
        logger.debug("tptrxdefRec.getTranid(3 - 1) :" + tptrxdefRec.getTranid(3 - 1));

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.getTskTranid().setTskTranid4(0L);
        //tptrxdefRec.setTranid(4 - 1, 0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TRANID( 4) TO TSK-TRANID-4");

        tskVari.getTskTranid().setTskTranid4(tptrxdefRec.getTranid(4 - 1));

        logger.debug("tskVari.getTskTranid().getTskTranid4() :" + tskVari.getTskTranid().getTskTranid4());
        logger.debug("tptrxdefRec.getTranid(4 - 1) :" + tptrxdefRec.getTranid(4 - 1));

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.getTskTranid().setTskTranid5(0L);
        //tptrxdefRec.setTranid(5 - 1, 0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TRANID( 5) TO TSK-TRANID-5");

        tskVari.getTskTranid().setTskTranid5(tptrxdefRec.getTranid(5 - 1));

        logger.debug("tskVari.getTskTranid().getTskTranid5() :" + tskVari.getTskTranid().getTskTranid5());
        logger.debug("tptrxdefRec.getTranid(5 - 1) :" + tptrxdefRec.getTranid(5 - 1));

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.getTskTranid().setTskTranid6(0L);
        //tptrxdefRec.setTranid(6 - 1, 0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TRANID( 6) TO TSK-TRANID-6");

        tskVari.getTskTranid().setTskTranid6(tptrxdefRec.getTranid(6 - 1));

        logger.debug("tskVari.getTskTranid().getTskTranid6() :" + tskVari.getTskTranid().getTskTranid6());
        logger.debug("tptrxdefRec.getTranid(6 - 1) :" + tptrxdefRec.getTranid(6 - 1));

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.setTskTermTux("                                                                                                                                                                                                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO TSK-TERM-TUX");

        tskVari.setTskTermTux(Util.spaces(256));

        logger.debug("tskVari.getTskTermTux() :" + tskVari.getTskTermTux());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.setTskTermTux("                                                                                                                                                                                                                                                                ");
        //tskVari.setTskTranidAlf("                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TSK-TRANID-ALF TO TSK-TERM-TUX");

        tskVari.setTskTermTux(tskVari.getTskTranidAlf());

        logger.debug("tskVari.getTskTermTux() :" + tskVari.getTskTermTux());
        logger.debug("tskVari.getTskTranidAlf() :" + tskVari.getTskTranidAlf());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.setTskTermTux("                                                                                                                                                                                                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("DISPLAY 'NO VIENE NUMERO  ASUME 1111111' ':' TSK-TERM-TUX");

        logger.info("NO VIENE NUMERO  ASUME 1111111:" + tskVari.getTskTermTux());

        logger.debug("tskVari.getTskTermTux() :" + tskVari.getTskTermTux());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.setTskTermNumTux(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 1111111 TO TSK-TERM-NUM-TUX");

        tskVari.setTskTermNumTux(1111111);

        logger.debug("tskVari.getTskTermNumTux() :" + tskVari.getTskTermNumTux());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.setTskTermNum(0);
        //tskVari.setTskTermNumTux(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TSK-TERM-NUM-TUX TO TSK-TERM-NUM");

        tskVari.setTskTermNum(tskVari.getTskTermNumTux());

        logger.debug("tskVari.getTskTermNum() :" + tskVari.getTskTermNum());
        logger.debug("tskVari.getTskTermNumTux() :" + tskVari.getTskTermNumTux());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //eibtaskn = "    ";
        //tskVari.setTskTermNum(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TSK-TERM-NUM TO EIBTASKN");

        eibtaskn = Util.intToString(tskVari.getTskTermNum(), 4);

        logger.debug("eibtaskn :" + eibtaskn);
        logger.debug("tskVari.getTskTermNum() :" + tskVari.getTskTermNum());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueComSend("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'DEL' TO QUE-COM-SEND");

        queSend.setQueComSend("DEL");

        logger.debug("queSend.getQueComSend() :" + queSend.getQueComSend());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNamSend("                                                                                                                                                                                                                                                                                                            ");
        //tskVari.setTskTermTux("                                                                                                                                                                                                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TSK-TERM-TUX TO QUE-NAM-SEND");

        queSend.setQueNamSend(tskVari.getTskTermTux());

        logger.debug("queSend.getQueNamSend() :" + queSend.getQueNamSend());
        logger.debug("tskVari.getTskTermTux() :" + tskVari.getTskTermTux());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNumSend(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE ZEROES TO QUE-NUM-SEND");

        queSend.setQueNumSend(0);

        logger.debug("queSend.getQueNumSend() :" + queSend.getQueNumSend());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueLarSend(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 7 TO QUE-LAR-SEND");

        queSend.setQueLarSend(7);

        logger.debug("queSend.getQueLarSend() :" + queSend.getQueLarSend());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueTrxSend("                                                                                                                                                                                                                                                                ");
        //tskVari.setTskTermNumTux(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TSK-TERM-NUM-TUX TO QUE-TRX-SEND");

        queSend.setQueTrxSend(Util.intToString(tskVari.getTskTermNumTux(), 256));

        logger.debug("queSend.getQueTrxSend() :" + queSend.getQueTrxSend());
        logger.debug("tskVari.getTskTermNumTux() :" + tskVari.getTskTermNumTux());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueDatSend("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO QUE-DAT-SEND");

        queSend.setQueDatSend(Util.spaces(9000));

        logger.debug("queSend.getQueDatSend() :" + queSend.getQueDatSend());

        execute("gnsMsjQue");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueComSend("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'PUT' TO QUE-COM-SEND");

        queSend.setQueComSend("PUT");

        logger.debug("queSend.getQueComSend() :" + queSend.getQueComSend());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNamSend("                                                                                                                                                                                                                                                                                                            ");
        //tskVari.setTskTermTux("                                                                                                                                                                                                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TSK-TERM-TUX TO QUE-NAM-SEND");

        queSend.setQueNamSend(tskVari.getTskTermTux());

        logger.debug("queSend.getQueNamSend() :" + queSend.getQueNamSend());
        logger.debug("tskVari.getTskTermTux() :" + tskVari.getTskTermTux());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNumSend(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 1 TO QUE-NUM-SEND");

        queSend.setQueNumSend(1);

        logger.debug("queSend.getQueNumSend() :" + queSend.getQueNumSend());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueLarSend(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 8 TO QUE-LAR-SEND");

        queSend.setQueLarSend(8);

        logger.debug("queSend.getQueLarSend() :" + queSend.getQueLarSend());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueTrxSend("                                                                                                                                                                                                                                                                ");
        //tskVari.setTskTermNumTux(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TSK-TERM-NUM-TUX TO QUE-TRX-SEND");

        queSend.setQueTrxSend(Util.intToString(tskVari.getTskTermNumTux(), 256));

        logger.debug("queSend.getQueTrxSend() :" + queSend.getQueTrxSend());
        logger.debug("tskVari.getTskTermNumTux() :" + tskVari.getTskTermNumTux());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.getTskInfoTran().setTskInfoTranid(0);
        //tskVari.setTskTermNumTux(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TSK-TERM-NUM-TUX TO TSK-INFO-TRANID");

        tskVari.getTskInfoTran().setTskInfoTranid(tskVari.getTskTermNumTux());

        logger.debug("tskVari.getTskInfoTran().getTskInfoTranid() :" + tskVari.getTskInfoTran().getTskInfoTranid());
        logger.debug("tskVari.getTskTermNumTux() :" + tskVari.getTskTermNumTux());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.getTskInfoTran().setTskInfoCommit(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 0 TO TSK-INFO-COMMIT");

        tskVari.getTskInfoTran().setTskInfoCommit(0);

        logger.debug("tskVari.getTskInfoTran().getTskInfoCommit() :" + tskVari.getTskInfoTran().getTskInfoCommit());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queVari.getQueItem().setQueData("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ");
        //tskVari.getTskInfoTran().setValue("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TSK-INFO-TRAN TO QUE-DATA");

        queVari.getQueItem().setQueData(tskVari.getTskInfoTran().getValue());

        logger.debug("queVari.getQueItem().getQueData() :" + queVari.getQueItem().getQueData());
        logger.debug("tskVari.getTskInfoTran().getValue() :" + tskVari.getTskInfoTran().getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueDatSend("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ");
        //queVari.getQueItem().setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE QUE-ITEM TO QUE-DAT-SEND");

        queSend.setQueDatSend(queVari.getQueItem().getValue());

        logger.debug("queSend.getQueDatSend() :" + queSend.getQueDatSend());
        logger.debug("queVari.getQueItem().getValue() :" + queVari.getQueItem().getValue());

        execute("gnsMsjQue");

        logger.debug("saliendo de 'gnsPutTsk_iniGnsPutTsk()' ...");

        return "gnsPutTsk_finGnsPutTsk";
    }

    /******************************************************************************
     * gnsPutTsk_finGnsPutTsk
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsPutTsk_finGnsPutTsk() {

        logger.debug("entrando a 'gnsPutTsk_finGnsPutTsk()' ...");

        logger.debug("saliendo de 'gnsPutTsk_finGnsPutTsk()' ...");

        return null;
    }

    /******************************************************************************
     * gnsGetTsk
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsGetTsk() {

        logger.debug("entrando a 'gnsGetTsk()' ...");

        execute("gnsGetTsk_iniGnsGetTsk");

        logger.debug("saliendo de 'gnsGetTsk()' ...");

        return null;
    }

    /******************************************************************************
     * gnsGetTsk_iniGnsGetTsk
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsGetTsk_iniGnsGetTsk() {

        logger.debug("entrando a 'gnsGetTsk_iniGnsGetTsk()' ...");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.getTskInfoTran().setTskInfoCommit(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 0 TO TSK-INFO-COMMIT");

        tskVari.getTskInfoTran().setTskInfoCommit(0);

        logger.debug("tskVari.getTskInfoTran().getTskInfoCommit() :" + tskVari.getTskInfoTran().getTskInfoCommit());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueComSend("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'GET' TO QUE-COM-SEND");

        queSend.setQueComSend("GET");

        logger.debug("queSend.getQueComSend() :" + queSend.getQueComSend());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNamSend("                                                                                                                                                                                                                                                                                                            ");
        //tskVari.setTskTermTux("                                                                                                                                                                                                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TSK-TERM-TUX TO QUE-NAM-SEND");

        queSend.setQueNamSend(tskVari.getTskTermTux());

        logger.debug("queSend.getQueNamSend() :" + queSend.getQueNamSend());
        logger.debug("tskVari.getTskTermTux() :" + tskVari.getTskTermTux());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNumSend(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 1 TO QUE-NUM-SEND");

        queSend.setQueNumSend(1);

        logger.debug("queSend.getQueNumSend() :" + queSend.getQueNumSend());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueLarSend(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 8 TO QUE-LAR-SEND");

        queSend.setQueLarSend(8);

        logger.debug("queSend.getQueLarSend() :" + queSend.getQueLarSend());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueTrxSend("                                                                                                                                                                                                                                                                ");
        //tskVari.setTskTermNumTux(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TSK-TERM-NUM-TUX TO QUE-TRX-SEND");

        queSend.setQueTrxSend(Util.intToString(tskVari.getTskTermNumTux(), 256));

        logger.debug("queSend.getQueTrxSend() :" + queSend.getQueTrxSend());
        logger.debug("tskVari.getTskTermNumTux() :" + tskVari.getTskTermNumTux());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueDatSend("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO QUE-DAT-SEND");

        queSend.setQueDatSend(Util.spaces(9000));

        logger.debug("queSend.getQueDatSend() :" + queSend.getQueDatSend());

        execute("gnsMsjQue");

        if (!queVari.getQueStat().equals(queVari.getQueStatOks())) {
            logger.debug("GO TO FIN-GNS-GET-TSK");


            logger.debug("saliendo de 'gnsGetTsk_iniGnsGetTsk()' ...");
            return "gnsGetTsk_finGnsGetTsk";
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tskVari.getTskInfoTran().setValue("        ");
        //queVari.getQueItem().setQueData("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE QUE-DATA TO TSK-INFO-TRAN");

        tskVari.getTskInfoTran().setValue(queVari.getQueItem().getQueData());

        logger.debug("tskVari.getTskInfoTran().getValue() :" + tskVari.getTskInfoTran().getValue());
        logger.debug("queVari.getQueItem().getQueData() :" + queVari.getQueItem().getQueData());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueComSend("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'DEL' TO QUE-COM-SEND");

        queSend.setQueComSend("DEL");

        logger.debug("queSend.getQueComSend() :" + queSend.getQueComSend());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNamSend("                                                                                                                                                                                                                                                                                                            ");
        //tskVari.setTskTermTux("                                                                                                                                                                                                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TSK-TERM-TUX TO QUE-NAM-SEND");

        queSend.setQueNamSend(tskVari.getTskTermTux());

        logger.debug("queSend.getQueNamSend() :" + queSend.getQueNamSend());
        logger.debug("tskVari.getTskTermTux() :" + tskVari.getTskTermTux());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNumSend(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE ZEROES TO QUE-NUM-SEND");

        queSend.setQueNumSend(0);

        logger.debug("queSend.getQueNumSend() :" + queSend.getQueNumSend());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueLarSend(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 7 TO QUE-LAR-SEND");

        queSend.setQueLarSend(7);

        logger.debug("queSend.getQueLarSend() :" + queSend.getQueLarSend());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueTrxSend("                                                                                                                                                                                                                                                                ");
        //tskVari.setTskTermNumTux(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TSK-TERM-NUM-TUX TO QUE-TRX-SEND");

        queSend.setQueTrxSend(Util.intToString(tskVari.getTskTermNumTux(), 256));

        logger.debug("queSend.getQueTrxSend() :" + queSend.getQueTrxSend());
        logger.debug("tskVari.getTskTermNumTux() :" + tskVari.getTskTermNumTux());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueDatSend("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO QUE-DAT-SEND");

        queSend.setQueDatSend(Util.spaces(9000));

        logger.debug("queSend.getQueDatSend() :" + queSend.getQueDatSend());

        execute("gnsMsjQue");

        if (tskVari.getTskInfoTran().getTskInfoCommit() == 1) {
            logger.debug("CALL \"TPABORT\" USING TPTRXDEF-REC TPSTATUS-REC");

            if (!tpstatusRec.isTpok()) {

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //tpstatusRec.setTpStatus(0);
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("DISPLAY 'TPABORT TP-STATUS :' TP-STATUS");

                logger.info("TPABORT TP-STATUS :" + tpstatusRec.getTpStatus());

                logger.debug("tpstatusRec.getTpStatus() :" + tpstatusRec.getTpStatus());

                execute("prgAbt");
            }
            else {

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //tpstatusRec.setTpStatus(0);
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("DISPLAY 'TPABORT TP-STATUS :' TP-STATUS");

                logger.info("TPABORT TP-STATUS :" + tpstatusRec.getTpStatus());

                logger.debug("tpstatusRec.getTpStatus() :" + tpstatusRec.getTpStatus());

                execute("prgAbt");
            }
        }
        else {
            logger.debug("CALL \"TPCOMMIT\" USING TPTRXDEF-REC TPSTATUS-REC");

            if (!tpstatusRec.isTpok()) {

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //tpstatusRec.setTpStatus(0);
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("DISPLAY 'TPCOMMIT TP-STATUS :' TP-STATUS");

                logger.info("TPCOMMIT TP-STATUS :" + tpstatusRec.getTpStatus());

                logger.debug("tpstatusRec.getTpStatus() :" + tpstatusRec.getTpStatus());

                execute("prgAbt");
            }
        }

        logger.debug("saliendo de 'gnsGetTsk_iniGnsGetTsk()' ...");

        return "gnsGetTsk_finGnsGetTsk";
    }

    /******************************************************************************
     * gnsGetTsk_finGnsGetTsk
     ******************************************************************************/
    /**
     *
     * TODO_javadoc.
     *
     * @return TODO_javadoc.
     *
     */
    public String gnsGetTsk_finGnsGetTsk() {

        logger.debug("entrando a 'gnsGetTsk_finGnsGetTsk()' ...");

        logger.debug("saliendo de 'gnsGetTsk_finGnsGetTsk()' ...");

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
        logger.debug("DISPLAY 'ABORTANDO EN PRG-ABT '");

        logger.info("ABORTANDO EN PRG-ABT ");

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioCtts.getFioMens().setValue("                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("DISPLAY 'FIO-MENS : ' FIO-MENS");

        logger.info("FIO-MENS : " + fioCtts.getFioMens().getValue());

        logger.debug("fioCtts.getFioMens().getValue() :" + fioCtts.getFioMens().getValue());
        logger.debug("MOVE 100 TO RETURN-CODE");

        returnCode = 100;

        System.exit(returnCode);

        logger.debug("saliendo de 'prgAbt_iniPrgAbt()' ...");

        return null;
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
        logger.debug("MOVE 1 TO QUE-NITM");

        queVari.setQueNitm(1);

        logger.debug("queVari.getQueNitm() :" + queVari.getQueNitm());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queVari.setQueCmnd("   ");
        //queCtts.setQueGet("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE QUE-GET TO QUE-CMND");

        queVari.setQueCmnd(queCtts.getQueGet());

        logger.debug("queVari.getQueCmnd() :" + queVari.getQueCmnd());
        logger.debug("queCtts.getQueGet() :" + queCtts.getQueGet());

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
        logger.debug("MOVE QUE-STAT-EOQ TO QUE-STAT");

        queVari.setQueStat(queVari.getQueStatEoq());

        logger.debug("queVari.getQueStat() :" + queVari.getQueStat());
        logger.debug("queVari.getQueStatEoq() :" + queVari.getQueStatEoq());
        logger.debug("GO TO FIN-GNS-PRO-QUE");


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
        logger.debug("MOVE QUE-STAT-NEX TO QUE-STAT");

        queVari.setQueStat(queVari.getQueStatNex());

        logger.debug("queVari.getQueStat() :" + queVari.getQueStat());
        logger.debug("queVari.getQueStatNex() :" + queVari.getQueStatNex());
        logger.debug("GO TO FIN-GNS-PRO-QUE");


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
        logger.debug("MOVE QUE-STAT-OKS TO QUE-STAT");

        queVari.setQueStat(queVari.getQueStatOks());

        logger.debug("queVari.getQueStat() :" + queVari.getQueStat());
        logger.debug("queVari.getQueStatOks() :" + queVari.getQueStatOks());

        if (queVari.getQueCmnd().equals(queCtts.getQuePut())) {
            logger.debug("GO TO GNS-PUT-QUE");


            logger.debug("saliendo de 'gnsProQue_iniGnsProQue()' ...");
            return "gnsProQue_gnsPutQue";
        }
        else {

            if (queVari.getQueCmnd().equals(queCtts.getQueGet())) {
                logger.debug("GO TO GNS-GET-QUE");


                logger.debug("saliendo de 'gnsProQue_iniGnsProQue()' ...");
                return "gnsProQue_gnsGetQue";
            }
            else {

                if (queVari.getQueCmnd().equals(queCtts.getQueMod())) {
                    logger.debug("GO TO GNS-MOD-QUE");


                    logger.debug("saliendo de 'gnsProQue_iniGnsProQue()' ...");
                    return "gnsProQue_gnsModQue";
                }
                else {

                    if (queVari.getQueCmnd().equals(queCtts.getQueDel())) {
                        logger.debug("GO TO GNS-DEL-QUE");


                        logger.debug("saliendo de 'gnsProQue_iniGnsProQue()' ...");
                        return "gnsProQue_gnsDelQue";
                    }
                }
            }
        }

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queVari.getQueMens().setQueMen1("                                        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'Comando invalido :' TO QUE-MEN1");

        queVari.getQueMens().setQueMen1("Comando invalido :");

        logger.debug("queVari.getQueMens().getQueMen1() :" + queVari.getQueMens().getQueMen1());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queVari.getQueMens().setQueMen2("                                       ");
        //queVari.setQueCmnd("   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE QUE-CMND TO QUE-MEN2");

        queVari.getQueMens().setQueMen2(queVari.getQueCmnd());

        logger.debug("queVari.getQueMens().getQueMen2() :" + queVari.getQueMens().getQueMen2());
        logger.debug("queVari.getQueCmnd() :" + queVari.getQueCmnd());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //fioCtts.getFioMens().setValue("                                                                                ");
        //queVari.getQueMens().setValue("                                                                               ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE QUE-MENS TO FIO-MENS");

        fioCtts.getFioMens().setValue(queVari.getQueMens().getValue());

        logger.debug("fioCtts.getFioMens().getValue() :" + fioCtts.getFioMens().getValue());
        logger.debug("queVari.getQueMens().getValue() :" + queVari.getQueMens().getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tptypeRec.setLen(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE + 79 TO LEN");

        tptypeRec.setLen(+79);

        logger.debug("tptypeRec.getLen() :" + tptypeRec.getLen());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tptypeRec.setRecType("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE \"CARRAY\" TO REC-TYPE");

        tptypeRec.setRecType("CARRAY");

        logger.debug("tptypeRec.getRecType() :" + tptypeRec.getRecType());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //tpsvcdefRec.setServiceName("                                                                                                                               ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE 'GNSPPABT' TO SERVICE-NAME");

        tpsvcdefRec.setServiceName("GNSPPABT");

        logger.debug("tpsvcdefRec.getServiceName() :" + tpsvcdefRec.getServiceName());
        logger.debug("CALL \"TPFORWARD\" USING TPSVCDEF-REC TPTYPE-REC QUE-MENS TPSTATUS-REC");

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
        logger.debug("MOVE QUE-CMND TO QUE-COM-SEND");

        queSend.setQueComSend(queVari.getQueCmnd());

        logger.debug("queSend.getQueComSend() :" + queSend.getQueComSend());
        logger.debug("queVari.getQueCmnd() :" + queVari.getQueCmnd());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNamSend("                                                                                                                                                                                                                                                                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO QUE-NAM-SEND");

        queSend.setQueNamSend(Util.spaces(300));

        logger.debug("queSend.getQueNamSend() :" + queSend.getQueNamSend());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNamSend("                                                                                                                                                                                                                                                                                                            ");
        //queVari.getQueCola().setValue("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE QUE-COLA TO QUE-NAM-SEND");

        queSend.setQueNamSend(queVari.getQueCola().getValue());

        logger.debug("queSend.getQueNamSend() :" + queSend.getQueNamSend());
        logger.debug("queVari.getQueCola().getValue() :" + queVari.getQueCola().getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNumSend(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE ZEROES TO QUE-NUM-SEND");

        queSend.setQueNumSend(0);

        logger.debug("queSend.getQueNumSend() :" + queSend.getQueNumSend());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueLarSend(0);
        //queVari.setQueLitm(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE QUE-LITM TO QUE-LAR-SEND");

        queSend.setQueLarSend(queVari.getQueLitm());

        logger.debug("queSend.getQueLarSend() :" + queSend.getQueLarSend());
        logger.debug("queVari.getQueLitm() :" + queVari.getQueLitm());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueTrxSend("                                                                                                                                                                                                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO QUE-TRX-SEND");

        queSend.setQueTrxSend(Util.spaces(256));

        logger.debug("queSend.getQueTrxSend() :" + queSend.getQueTrxSend());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueTrxSend("                                                                                                                                                                                                                                                                ");
        //tskVari.setTskTermAlf("    ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TSK-TERM-ALF TO QUE-TRX-SEND");

        queSend.setQueTrxSend(tskVari.getTskTermAlf());

        logger.debug("queSend.getQueTrxSend() :" + queSend.getQueTrxSend());
        logger.debug("tskVari.getTskTermAlf() :" + tskVari.getTskTermAlf());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueDatSend("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ");
        //queVari.getQueItem().setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE QUE-ITEM TO QUE-DAT-SEND");

        queSend.setQueDatSend(queVari.getQueItem().getValue());

        logger.debug("queSend.getQueDatSend() :" + queSend.getQueDatSend());
        logger.debug("queVari.getQueItem().getValue() :" + queVari.getQueItem().getValue());

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
        logger.debug("GO TO FIN-GNS-PRO-QUE");


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
        logger.debug("MOVE QUE-CMND TO QUE-COM-SEND");

        queSend.setQueComSend(queVari.getQueCmnd());

        logger.debug("queSend.getQueComSend() :" + queSend.getQueComSend());
        logger.debug("queVari.getQueCmnd() :" + queVari.getQueCmnd());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNamSend("                                                                                                                                                                                                                                                                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO QUE-NAM-SEND");

        queSend.setQueNamSend(Util.spaces(300));

        logger.debug("queSend.getQueNamSend() :" + queSend.getQueNamSend());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNamSend("                                                                                                                                                                                                                                                                                                            ");
        //queVari.getQueCola().setValue("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE QUE-COLA TO QUE-NAM-SEND");

        queSend.setQueNamSend(queVari.getQueCola().getValue());

        logger.debug("queSend.getQueNamSend() :" + queSend.getQueNamSend());
        logger.debug("queVari.getQueCola().getValue() :" + queVari.getQueCola().getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNumSend(0);
        //queVari.setQueNitm(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE QUE-NITM TO QUE-NUM-SEND");

        queSend.setQueNumSend(queVari.getQueNitm());

        logger.debug("queSend.getQueNumSend() :" + queSend.getQueNumSend());
        logger.debug("queVari.getQueNitm() :" + queVari.getQueNitm());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueLarSend(0);
        //queVari.setQueLitm(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE QUE-LITM TO QUE-LAR-SEND");

        queSend.setQueLarSend(queVari.getQueLitm());

        logger.debug("queSend.getQueLarSend() :" + queSend.getQueLarSend());
        logger.debug("queVari.getQueLitm() :" + queVari.getQueLitm());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueTrxSend("                                                                                                                                                                                                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO QUE-TRX-SEND");

        queSend.setQueTrxSend(Util.spaces(256));

        logger.debug("queSend.getQueTrxSend() :" + queSend.getQueTrxSend());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueTrxSend("                                                                                                                                                                                                                                                                ");
        //tskVari.setTskTermAlf("    ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TSK-TERM-ALF TO QUE-TRX-SEND");

        queSend.setQueTrxSend(tskVari.getTskTermAlf());

        logger.debug("queSend.getQueTrxSend() :" + queSend.getQueTrxSend());
        logger.debug("tskVari.getTskTermAlf() :" + tskVari.getTskTermAlf());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueDatSend("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO QUE-DAT-SEND");

        queSend.setQueDatSend(Util.spaces(9000));

        logger.debug("queSend.getQueDatSend() :" + queSend.getQueDatSend());

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
        logger.debug("GO TO FIN-GNS-PRO-QUE");


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
        logger.debug("MOVE QUE-CMND TO QUE-COM-SEND");

        queSend.setQueComSend(queVari.getQueCmnd());

        logger.debug("queSend.getQueComSend() :" + queSend.getQueComSend());
        logger.debug("queVari.getQueCmnd() :" + queVari.getQueCmnd());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNamSend("                                                                                                                                                                                                                                                                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO QUE-NAM-SEND");

        queSend.setQueNamSend(Util.spaces(300));

        logger.debug("queSend.getQueNamSend() :" + queSend.getQueNamSend());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNamSend("                                                                                                                                                                                                                                                                                                            ");
        //queVari.getQueCola().setValue("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE QUE-COLA TO QUE-NAM-SEND");

        queSend.setQueNamSend(queVari.getQueCola().getValue());

        logger.debug("queSend.getQueNamSend() :" + queSend.getQueNamSend());
        logger.debug("queVari.getQueCola().getValue() :" + queVari.getQueCola().getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNumSend(0);
        //queVari.setQueNitm(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE QUE-NITM TO QUE-NUM-SEND");

        queSend.setQueNumSend(queVari.getQueNitm());

        logger.debug("queSend.getQueNumSend() :" + queSend.getQueNumSend());
        logger.debug("queVari.getQueNitm() :" + queVari.getQueNitm());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueLarSend(0);
        //queVari.setQueLitm(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE QUE-LITM TO QUE-LAR-SEND");

        queSend.setQueLarSend(queVari.getQueLitm());

        logger.debug("queSend.getQueLarSend() :" + queSend.getQueLarSend());
        logger.debug("queVari.getQueLitm() :" + queVari.getQueLitm());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueTrxSend("                                                                                                                                                                                                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO QUE-TRX-SEND");

        queSend.setQueTrxSend(Util.spaces(256));

        logger.debug("queSend.getQueTrxSend() :" + queSend.getQueTrxSend());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueTrxSend("                                                                                                                                                                                                                                                                ");
        //tskVari.setTskTermAlf("    ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TSK-TERM-ALF TO QUE-TRX-SEND");

        queSend.setQueTrxSend(tskVari.getTskTermAlf());

        logger.debug("queSend.getQueTrxSend() :" + queSend.getQueTrxSend());
        logger.debug("tskVari.getTskTermAlf() :" + tskVari.getTskTermAlf());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueDatSend("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ");
        //queVari.getQueItem().setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE QUE-ITEM TO QUE-DAT-SEND");

        queSend.setQueDatSend(queVari.getQueItem().getValue());

        logger.debug("queSend.getQueDatSend() :" + queSend.getQueDatSend());
        logger.debug("queVari.getQueItem().getValue() :" + queVari.getQueItem().getValue());

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
        logger.debug("GO TO FIN-GNS-PRO-QUE");


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
        logger.debug("MOVE QUE-CMND TO QUE-COM-SEND");

        queSend.setQueComSend(queVari.getQueCmnd());

        logger.debug("queSend.getQueComSend() :" + queSend.getQueComSend());
        logger.debug("queVari.getQueCmnd() :" + queVari.getQueCmnd());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNamSend("                                                                                                                                                                                                                                                                                                            ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO QUE-NAM-SEND");

        queSend.setQueNamSend(Util.spaces(300));

        logger.debug("queSend.getQueNamSend() :" + queSend.getQueNamSend());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNamSend("                                                                                                                                                                                                                                                                                                            ");
        //queVari.getQueCola().setValue("        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE QUE-COLA TO QUE-NAM-SEND");

        queSend.setQueNamSend(queVari.getQueCola().getValue());

        logger.debug("queSend.getQueNamSend() :" + queSend.getQueNamSend());
        logger.debug("queVari.getQueCola().getValue() :" + queVari.getQueCola().getValue());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueNumSend(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE ZEROES TO QUE-NUM-SEND");

        queSend.setQueNumSend(0);

        logger.debug("queSend.getQueNumSend() :" + queSend.getQueNumSend());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueLarSend(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE ZEROES TO QUE-LAR-SEND");

        queSend.setQueLarSend(0);

        logger.debug("queSend.getQueLarSend() :" + queSend.getQueLarSend());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueTrxSend("                                                                                                                                                                                                                                                                ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO QUE-TRX-SEND");

        queSend.setQueTrxSend(Util.spaces(256));

        logger.debug("queSend.getQueTrxSend() :" + queSend.getQueTrxSend());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueTrxSend("                                                                                                                                                                                                                                                                ");
        //tskVari.setTskTermAlf("    ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE TSK-TERM-ALF TO QUE-TRX-SEND");

        queSend.setQueTrxSend(tskVari.getTskTermAlf());

        logger.debug("queSend.getQueTrxSend() :" + queSend.getQueTrxSend());
        logger.debug("tskVari.getTskTermAlf() :" + tskVari.getTskTermAlf());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queSend.setQueDatSend("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO QUE-DAT-SEND");

        queSend.setQueDatSend(Util.spaces(9000));

        logger.debug("queSend.getQueDatSend() :" + queSend.getQueDatSend());

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
        logger.debug("GO TO FIN-GNS-PRO-QUE");


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
        logger.debug("SET QUE-TPTRAN TO TRUE");

        queTpsvcdefRec.setQueTptran(true);

        logger.debug("queTpsvcdefRec.isQueTptran() :" + queTpsvcdefRec.isQueTptran());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queTpsvcdefRec.setQueTpblock(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("SET QUE-TPBLOCK TO TRUE");

        queTpsvcdefRec.setQueTpblock(true);

        logger.debug("queTpsvcdefRec.isQueTpblock() :" + queTpsvcdefRec.isQueTpblock());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queTpsvcdefRec.setQueTpnotime(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("SET QUE-TPNOTIME TO TRUE");

        queTpsvcdefRec.setQueTpnotime(true);

        logger.debug("queTpsvcdefRec.isQueTpnotime() :" + queTpsvcdefRec.isQueTpnotime());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queTpsvcdefRec.setQueTpsigrstrt(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("SET QUE-TPSIGRSTRT TO TRUE");

        queTpsvcdefRec.setQueTpsigrstrt(true);

        logger.debug("queTpsvcdefRec.isQueTpsigrstrt() :" + queTpsvcdefRec.isQueTpsigrstrt());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queTpsvcdefRec.setQueTpchange(0);
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("SET QUE-TPCHANGE TO TRUE");

        queTpsvcdefRec.setQueTpchange(true);

        logger.debug("queTpsvcdefRec.isQueTpchange() :" + queTpsvcdefRec.isQueTpchange());

        //// setters /////////////////////////////////////////////////////////////////////////////////
        //queRecv.setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    ");
        //////////////////////////////////////////////////////////////////////////////////////////////
        logger.debug("MOVE SPACES TO QUE-RECV");

        queRecv.setValue(Util.spaces(9284));

        logger.debug("queRecv.getValue() :" + queRecv.getValue());
        logger.debug("CALL \"TPCALL\" USING QUE-TPSVCDEF-REC QUE-TPTYPE-REC-SEND QUE-SEND QUE-TPTYPE-REC-RECV QUE-RECV TPSTATUS-REC");

        if (!tpstatusRec.isTpok()) {

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //queVari.setQueStat("   ");
            //queVari.setQueStatNex("   ");
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE QUE-STAT-NEX TO QUE-STAT");

            queVari.setQueStat(queVari.getQueStatNex());

            logger.debug("queVari.getQueStat() :" + queVari.getQueStat());
            logger.debug("queVari.getQueStatNex() :" + queVari.getQueStatNex());

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //tpstatusRec.setTpStatus(0);
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("DISPLAY 'TEMPORAL STORAGE :' TP-STATUS");

            logger.info("TEMPORAL STORAGE :" + tpstatusRec.getTpStatus());

            logger.debug("tpstatusRec.getTpStatus() :" + tpstatusRec.getTpStatus());

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //queNumStat = 0;
            //tpstatusRec.setTpStatus(0);
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE TP-STATUS TO QUE-NUM-STAT");

            queNumStat = tpstatusRec.getTpStatus();

            logger.debug("queNumStat :" + queNumStat);
            logger.debug("tpstatusRec.getTpStatus() :" + tpstatusRec.getTpStatus());

            //// setters /////////////////////////////////////////////////////////////////////////////////
            //queGlsStat = 0;
            //queNumStat = 0;
            //////////////////////////////////////////////////////////////////////////////////////////////
            logger.debug("MOVE QUE-NUM-STAT TO QUE-GLS-STAT");

            queGlsStat = queNumStat;

            logger.debug("queGlsStat :" + queGlsStat);
            logger.debug("queNumStat :" + queNumStat);
        }
        else {

            if (queRecv.getQueStaRecv() == 0) {

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //queVari.setQueStat("   ");
                //queVari.setQueStatOks("   ");
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("MOVE QUE-STAT-OKS TO QUE-STAT");

                queVari.setQueStat(queVari.getQueStatOks());

                logger.debug("queVari.getQueStat() :" + queVari.getQueStat());
                logger.debug("queVari.getQueStatOks() :" + queVari.getQueStatOks());

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //queVari.getQueItem().setValue("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   ");
                //queRecv.setQueDatRecv("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ");
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("MOVE QUE-DAT-RECV TO QUE-ITEM");

                queVari.getQueItem().setValue(queRecv.getQueDatRecv());

                logger.debug("queVari.getQueItem().getValue() :" + queVari.getQueItem().getValue());
                logger.debug("queRecv.getQueDatRecv() :" + queRecv.getQueDatRecv());
            }
            else {

                //// setters /////////////////////////////////////////////////////////////////////////////////
                //queVari.setQueStat("   ");
                //queVari.setQueStatNex("   ");
                //////////////////////////////////////////////////////////////////////////////////////////////
                logger.debug("MOVE QUE-STAT-NEX TO QUE-STAT");

                queVari.setQueStat(queVari.getQueStatNex());

                logger.debug("queVari.getQueStat() :" + queVari.getQueStat());
                logger.debug("queVari.getQueStatNex() :" + queVari.getQueStatNex());
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
