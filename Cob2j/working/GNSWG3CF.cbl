        01  TPSVCRET-REC.
      *
      * Copyright (c) 1992 USL
      * All rights reserved
      *
      * THIS IS UNPUBLISHED PROPRIETARY
      * SOURCE CODE OF USL
      * The copyright notice above does not
      * evidence any actual or intended
      * publication of such source code.
      *
      * #ident  "@(#) cobol/cobatmi/TPSVCRET.cbl        $Revision: 1.4 $"
      * static  char    sccsid[] = "@(#) cobol/cobatmi/TPSVCRET.cbl     $Revisio
      *
      *  TPSVCRET.cbl
      *
        05 TP-RETURN-VAL PIC S9(9) COMP-5.
                88 TPSUCCESS  VALUE 0.
                88 TPFAIL     VALUE 1.
                88 TPEXIT     VALUE 2.
                88 TPLONGJUMP VALUE 3.
                88 TPBREAK    VALUE 4.
        05 APPL-CODE          PIC S9(9) COMP-5.
      
      *
        01  TPTYPE-REC.
      *
      * Copyright (c) 1992 USL
      * All rights reserved
      *
      * THIS IS UNPUBLISHED PROPRIETARY
      * SOURCE CODE OF USL
      * The copyright notice above does not
      * evidence any actual or intended
      * publication of such source code.
      *
      *   Copyright:   (c) 1991, 1992, by BULL HN Information Systems Ltd
      * This Source Code has been provided by Bull Information Systems Ltd.
      * under a License Agreement containing restrictions on its disclosure.
      * This software contains proprietary information constituting valuable
      * Bull trade secrets and is also protected by copyright law as an
      * unpublished work.
      *
      * #ident  "@(#) cobol/cobatmi/TPTYPE.cbl  $Revision: 1.4 $"
      * static  char    sccsid[] = "@(#) cobol/cobatmi/TPTYPE.cbl       $Revisio
      *
      *  TPTYPE.cbl
      *
        05 REC-TYPE         PIC X(8).
                88 X-OCTET   VALUE "X_OCTET".
                88 X-COMMON  VALUE "X_COMMON".
        05 SUB-TYPE         PIC X(16).
        05 LEN              PIC S9(9) COMP-5.
                88 NO-LENGTH VALUE 0.
        05 TPTYPE-STATUS    PIC S9(9) COMP-5.
                88 TPTYPEOK     VALUE 0.
                88 TPTRUNCATE   VALUE 1.
      *
      *
        01 TPSTATUS-REC.
      *
      * Copyright (c) 1992 USL
      * All rights reserved
      *
      * THIS IS UNPUBLISHED PROPRIETARY
      * SOURCE CODE OF USL
      * The copyright notice above does not
      * evidence any actual or intended
      * publication of such source code.
      *
      *   Copyright:   (c) 1991, 1992, by BULL HN Information Systems Ltd
      * This Source Code has been provided by Bull Information Systems Ltd.
      * under a License Agreement containing restrictions on its disclosure.
      * This software contains proprietary information constituting valuable
      * Bull trade secrets and is also protected by copyright law as an
      * unpublished work.
      *
      * #ident  "@(#) cobol/cobatmi/TPSTATUS.cbl        $Revision: 1.4 $"
      * static  char    sccsid[] = "@(#) cobol/cobatmi/TPSTATUS.cbl     $Revisio
      *
      *  TPSTATUS.cbl
      *
        05 TP-STATUS  PIC S9(9) COMP-5.
                88 TPOK                 VALUE 0.
                88 TPEABORT             VALUE 1.
                88 TPEBADDESC           VALUE 2.
                88 TPEBLOCK             VALUE 3.
                88 TPEINVAL             VALUE 4.
                88 TPELIMIT             VALUE 5.
                88 TPENOENT             VALUE 6.
                88 TPEOS                VALUE 7.
                88 TPEPERM              VALUE 8.
                88 TPEPROTO             VALUE 9.
                88 TPESVCERR            VALUE 10.
                88 TPESVCFAIL           VALUE 11.
                88 TPESYSTEM            VALUE 12.
                88 TPETIME              VALUE 13.
                88 TPETRAN              VALUE 14.
                88 TPEGOTSIG            VALUE 15.
                88 TPERMERR             VALUE 16.
                88 TPEITYPE             VALUE 17.
                88 TPEOTYPE             VALUE 18.
                88 TPERELEASE           VALUE 19.
                88 TPEHAZARD            VALUE 20.
                88 TPEHEURISTIC         VALUE 21.
                88 TPEEVENT             VALUE 22.
                88 TPEMATCH             VALUE 23.
                88 TPEDIAGNOSTIC        VALUE 24.
                88 TPEMIB               VALUE 25.
                88 TPEMAXVAL            VALUE 26.
      *
        05 TPEVENT                PIC S9(9) COMP-5.
                88 TPEV-NOEVENT         VALUE 0.
                88 TPEV-DISCONIMM       VALUE 1.
                88 TPEV-SENDONLY        VALUE 2.
                88 TPEV-SVCERR          VALUE 3.
                88 TPEV-SVCFAIL         VALUE 4.
                88 TPEV-SVCSUCC         VALUE 5.
      *
        05 APPL-RETURN-CODE       PIC S9(9) COMP-5.
      *
        01  TPSVCDEF-REC.
      *
      * Copyright (c) 1992 USL
      * All rights reserved
      *
      * THIS IS UNPUBLISHED PROPRIETARY
      * SOURCE CODE OF USL
      * The copyright notice above does not
      * evidence any actual or intended
      * publication of such source code.
      *
      *   Copyright:   (c) 1991, 1992, by BULL HN Information Systems Ltd
      * This Source Code has been provided by Bull Information Systems Ltd.
      * under a License Agreement containing restrictions on its disclosure.
      * This software contains proprietary information constituting valuable
      * Bull trade secrets and is also protected by copyright law as an
      * unpublished work.
      *
      * #ident  "@(#) cobol/cobatmi/TPSVCDEF.cbl        $Revision: 1.5 $"
      * static  char    sccsid[] = "@(#) cobol/cobatmi/TPSVCDEF.cbl     $Revisio
      *
      *  TPSVCDEF.cbl
      *
        05 COMM-HANDLE          PIC S9(9) COMP-5.
        05 TPBLOCK-FLAG         PIC S9(9) COMP-5.
                88 TPBLOCK         VALUE 0.
                88 TPNOBLOCK       VALUE 1.
        05 TPTRAN-FLAG          PIC S9(9) COMP-5.
                88 TPTRAN          VALUE 0.
                88 TPNOTRAN        VALUE 1.
        05 TPREPLY-FLAG         PIC S9(9) COMP-5.
                88 TPREPLY         VALUE 0.
                88 TPNOREPLY       VALUE 1.
        05 TPACK-FLAG         REDEFINES TPREPLY-FLAG.
           10 FILLER PIC S9(9) COMP-5.
                88 TPNOACK         VALUE 0.
                88 TPACK           VALUE 1.
        05 TPTIME-FLAG          PIC S9(9) COMP-5.
                88 TPTIME          VALUE 0.
                88 TPNOTIME        VALUE 1.
        05 TPSIGRSTRT-FLAG      PIC S9(9) COMP-5.
                88 TPNOSIGRSTRT    VALUE 0.
                88 TPSIGRSTRT      VALUE 1.
        05 TPGETANY-FLAG        PIC S9(9) COMP-5.
                88 TPGETHANDLE     VALUE 0.
                88 TPGETANY        VALUE 1.
        05 TPSENDRECV-FLAG      PIC S9(9) COMP-5.
                88 TPSENDONLY      VALUE 0.
                88 TPRECVONLY      VALUE 1.
        05 TPNOCHANGE-FLAG      PIC S9(9) COMP-5.
                88 TPCHANGE        VALUE 0.
                88 TPNOCHANGE      VALUE 1.
        05 TPSERVICETYPE-FLAG   PIC S9(9) COMP-5.
                88  TPREQRSP       VALUE IS 0.
                88  TPCONV         VALUE IS 1.
      *
        05 APPKEY               PIC S9(9) COMP-5.
        05 CLIENTID OCCURS 4 TIMES PIC S9(9) COMP-5.
        05 SERVICE-NAME            PIC X(127).

      ******************************************************
      * Log message definitions 
      ******************************************************
        01  LOGMSG.
                05  LOGMSG-PROG  VALUE 'GNSPQTAB :' PIC X(10) .
                05  LOGMSG-NUMB  VALUE '00'         PIC X(02).
                05  LOGMSG-TIME  VALUE '00000000'   PIC X(08).
                05  LOGMSG-TEXT.
                    07  LOGMSG-TEXT-1               PIC X(04).
                    07  LOGMSG-TEXT-2               PIC X(06).
                    07  LOGMSG-TEXT-3               PIC X(40).
                
        01  LOGMSG-LEN            PIC S9(9)  COMP-5.

      * VARIABLES FRM                                                   
      * PROCESA INTERFACES BMS Y PTC V31                                
      *                                                                 
       01  FRM-VARI.                                                    
           03 FRM-TCMA  COMP          PIC S9(4).                        
           03 FRM-CMMA.                                                 
              05 FRM-SCR-MENS         PIC X(79).                        
              05 FRM-SCR-VARI         PIC X(3421).                      
           03 FRM-STAT                PIC X(03).                        
              88 FRM-STAT-OKS   VALUE 'OKS'.                            
              88 FRM-STAT-ABT   VALUE 'ABT'.                            
           03 FRM-NAME                PIC X(007).                       
           03 FRM-NLIB                PIC X(007).                       
           03 FRM-PLIN       VALUE 1  PIC 9(02).                        
           03 FRM-NLIN       VALUE 0  PIC 9(02).                        
           03 FRM-PCUR  COMP          PIC S9(04).                       
           03 FRM-UCUR  VALUE SPACES  PIC  X(01).                       
           03 FRM-TFLD  COMP          PIC S9(04).                       
           03 FRM-AUXI                PIC X(2000).                      
           03 FRM-DFLD.                                                 
              05 FRM-COD-MENS         PIC X(12).                        
              05 FRM-GLS-MENS         PIC X(79).                        
              05 FRM-DATA.                                              
                 07 FRM-NAME-IDEN     PIC X(12).                        
                 07 FRM-NAME-CMPL     PIC X(1988).                      
           03 FRM-LFLD  COMP          PIC S9(04).                       
           03 FRM-IFLD  COMP          PIC  9(09).                       
           03 FRM-MENS                PIC X(79).                        
           03 FRM-MENS-RED REDEFINES  FRM-MENS.                         
              05 FRM-MEN1             PIC X(40).                        
              05 FRM-MEN2             PIC X(39).                        
           03 FRM-ABRV                PIC X(05).                        
           03 FRM-FFLD                PIC X.                            
           03 FRM-SUAR                PIC X(03).                        
           03 FRM-SINI                PIC 9(01).                        
           03 FRM-CMND                PIC 9(02).                        
           03 FRM-IHDL   VALUE SPACES PIC X(01).                        
      * PTC: VARIABLES NECESARIAS AMBIENTE PLATAFORMA COMERCIAL         
      * PTC: COLA                                                       
           03 FRM-COLA.                                                 
      * PTC: TERMINAL PARA CONFORMAR COLAS LECTURA/ESCRITURA            
              05 FRM-TERM             PIC X(04).                        
      * PTC: IDENTIFICAR COLAS LECTURA/ESCRITURA                        
              05 FRM-TYPE             PIC X(03).                        
      * PTC: LARGO ITEM DE COLA                                         
           03 FRM-LITM  COMP          PIC S9(4).                        
                                                                        
       01  FRM-CTTS.                                                    
           03 FRM-INI                 PIC 9(02) VALUE 1.                
           03 FRM-GET-ALL             PIC 9(02) VALUE 2.                
           03 FRM-PUT-ALL             PIC 9(02) VALUE 3.                
           03 FRM-CLR-ALL             PIC 9(02) VALUE 4.                
           03 FRM-MSG                 PIC 9(02) VALUE 5.                
           03 FRM-RCV                 PIC 9(02) VALUE 6.                
      * MHM-INI 28-FEB-2011 MODERNIZACION MIGRACION DB2
           03 FRM-ABT                 PIC 9(02) VALUE 10.               
      * MHM-FIN 28-FEB-2011 MODERNIZACION MIGRACION DB2
           03 FRM-CLR-FRM             PIC 9(02) VALUE 7.                
           03 FRM-SINI-DB1F           PIC 9(01) VALUE 0.                
           03 FRM-SINI-DBNF           PIC 9(01) VALUE 1.                
           03 FRM-SINI-DBLF           PIC 9(01) VALUE 2.                
           03 FRM-SINI-MB1F           PIC 9(01) VALUE 3.                
           03 FRM-SINI-MBNF           PIC 9(01) VALUE 4.                
           03 FRM-SINI-MBLF           PIC 9(05) VALUE 5.                
           03 FRM-FFLD-PA1            PIC X VALUE '%'.                  
           03 FRM-FFLD-PA2            PIC X VALUE '>'.                  
           03 FRM-FFLD-PA3            PIC X VALUE ','.                  
           03 FRM-FFLD-RET            PIC X VALUE ''''.                 
           03 FRM-FFLD-TAB            PIC X VALUE '3'.                  
           03 FRM-FFLD-PF1            PIC X VALUE '1'.                  
           03 FRM-FFLD-PF2            PIC X VALUE '2'.                  
           03 FRM-FFLD-PF3            PIC X VALUE '3'.                  
           03 FRM-FFLD-PF4            PIC X VALUE '4'.                  
           03 FRM-FFLD-PF5            PIC X VALUE '5'.                  
           03 FRM-FFLD-PF6            PIC X VALUE '6'.                  
           03 FRM-FFLD-PF7            PIC X VALUE '7'.                  
           03 FRM-FFLD-PF8            PIC X VALUE '8'.                  
           03 FRM-FFLD-PF9            PIC X VALUE '9'.                  
           03 FRM-FFLD-PF10           PIC X VALUE ':'.                  
           03 FRM-FFLD-PF11           PIC X VALUE '#'.                  
           03 FRM-FFLD-PF12           PIC X VALUE '@'.                  
           03 FRM-FFLD-PFA            PIC X VALUE 'A'.                  
           03 FRM-FFLD-PFB            PIC X VALUE 'B'.                  
           03 FRM-FFLD-PFC            PIC X VALUE 'C'.                  
           03 FRM-FFLD-PFD            PIC X VALUE 'D'.                  
           03 FRM-FFLD-PFE            PIC X VALUE 'E'.                  
           03 FRM-FFLD-PFF            PIC X VALUE 'F'.                  
           03 FRM-FFLD-PFG            PIC X VALUE 'G'.                  
           03 FRM-FFLD-PFH            PIC X VALUE 'H'.                  
           03 FRM-FFLD-PFI            PIC X VALUE 'I'.                  
           03 FRM-FFLD-PFJ            PIC X VALUE ''.                  
           03 FRM-FFLD-PFK            PIC X VALUE '.'.                  
           03 FRM-FFLD-PFL            PIC X VALUE '<'.                  
           03 FRM-SUAR-MAL            PIC X(3) VALUE 'MAL'.             
           03 FRM-SUAR-WRN            PIC X(3) VALUE 'WRN'.             
           03 FRM-SUAR-CLR            PIC X(3) VALUE 'CLR'.             
           03 FRM-SUAR-OKS            PIC X(3) VALUE 'OKS'.             
           03 FRM-CPIM.                                                 
      * AEY = Protegido, normal                                         
              05 FRM-CPIM-AEY         PIC X(01) VALUE '1'.              
      * UBY = Desprotegido, brillante                                   
              05 FRM-CPIM-UBY         PIC X(01) VALUE 'I'.              
      * ANY = Protegido, non-display                                    
              05 FRM-CPIM-ANY         PIC X(01) VALUE '_'.              
      * UNY = Desprotegido, non-display                                 
              05 FRM-CPIM-UNY         PIC X(01) VALUE '('.              
      * ANY = Protegido, normal                                         
              05 FRM-CPSF-AEY         PIC X(01) VALUE '-'.              
      * ABY = Protegido, brillante                                      
              05 FRM-CPIM-ABY         PIC X(01) VALUE '9'.              
      * UST = Virtual para BMS, pues es campo STOPPER en UNISYS         
              05 FRM-CPIM-UST         PIC X(01) VALUE SPACES.           
           03 FRM-POS-CURS COMP   PIC S9(04) VALUE -1.                  
           03 FRM-IND-ERRO COMP   PIC S9(04) VALUE -1.                  
           03 FRM-ERR-NUME COMP   PIC S9(04) VALUE -9.                  
           03 FRM-RST-PCUR COMP   PIC S9(04) VALUE ZEROES.              
