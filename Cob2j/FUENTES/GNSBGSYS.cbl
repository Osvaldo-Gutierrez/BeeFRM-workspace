      * Rutina de Servicios del Sistema
       GNS-PRO-SYS SECTION.
       INI-GNS-PRO-SYS.


           MOVE SYS-STAT-OKS TO SYS-STAT.
           IF SYS-IHDL NOT > SPACES
               MOVE 'N' TO SYS-IHDL.

           GO TO DAT-GNS-PRO-SYS TIM-GNS-PRO-SYS EXT-GNS-PRO-SYS
                 XCT-GNS-PRO-SYS LNK-GNS-PRO-SYS ABT-GNS-PRO-SYS
           DEPENDING ON SYS-CMND.
           MOVE 'ABORTO, comando invalido en GNS-PRO-SYS:' TO SYS-MEN1.
           MOVE SYS-CMND                                   TO SYS-MEN2.
           GO TO ABT-GNS-PRO-SYS.

       DAT-GNS-PRO-SYS.


           IF SYS-HORA-HABI = 'S' AND SYS-HORA-FLAG = 'S'
              MOVE 0 TO TP-STATUS
              GO TO FIN-GNS-PRO-SYS.

           ACCEPT SYS-FHOY-2B FROM DATE.

           MOVE SYS-DHOY-2B TO SYS-DHOY.
           MOVE '/'         TO SYS-SLH1.
           MOVE SYS-MHOY-2B TO SYS-MHOY.
           MOVE '/'         TO SYS-SLH2.
           MOVE SYS-AHOY-2B TO SYS-AHOY.

           ACCEPT SYS-HHOY-2B FROM TIME.

           MOVE   SYS-HHHY-2B TO SYS-HHHY.
           MOVE   SYS-MMHY-2B TO SYS-MMHY.
           MOVE   SYS-SSHY-2B TO SYS-SSHY.

           MOVE SYS-AHOY TO SYS-AATS IN SYS-FSTP.
           MOVE SYS-MHOY TO SYS-MMTS IN SYS-FSTP.
           MOVE SYS-DHOY TO SYS-DDTS IN SYS-FSTP.
           IF SYS-AHOY < 60
               MOVE 20 TO SYS-SHOY SYS-SSTP
           ELSE
               MOVE 19 TO SYS-SHOY SYS-SSTP.
           MOVE SYS-HHHY TO SYS-HHTS IN SYS-HSTP-RED.
           MOVE SYS-MMHY TO SYS-MMTS IN SYS-HSTP-RED.
           MOVE SYS-SSHY TO SYS-SSTS IN SYS-HSTP-RED.


           MOVE FYH-TCMA       TO LEN.
           MOVE "CARRAY"       TO REC-TYPE.
           MOVE FYH-PROG       TO SERVICE-NAME.
           CALL "TPCALL" USING TPSVCDEF-REC
                               TPTYPE-REC
                               FYH-CMMA
                               TPTYPE-REC
                               FYH-CMMA
                               TPSTATUS-REC.

           IF NOT TPOK
              DISPLAY 'DAT-GNS-PRO-SYS    :' FYH-PROG
                                       ' '   TP-STATUS
              MOVE 0 TO TP-STATUS
              GO TO FIN-GNS-PRO-SYS.


           MOVE FYH-NUM-DHOY IN FYH-CMMA TO SYS-DHOY.
           MOVE '/'                      TO SYS-SLH1.
           MOVE FYH-NUM-MHOY IN FYH-CMMA TO SYS-MHOY.
           MOVE '/'                      TO SYS-SLH2.
           MOVE FYH-NUM-AHOY IN FYH-CMMA TO SYS-AHOY.

           MOVE FYH-NUM-HHHY IN FYH-CMMA TO SYS-HHHY.
           MOVE FYH-NUM-MMHY IN FYH-CMMA TO SYS-MMHY.
           MOVE FYH-NUM-SSHY IN FYH-CMMA TO SYS-SSHY.

           MOVE SYS-AHOY TO SYS-AATS IN SYS-FSTP.
           MOVE SYS-MHOY TO SYS-MMTS IN SYS-FSTP.
           MOVE SYS-DHOY TO SYS-DDTS IN SYS-FSTP.
           IF SYS-AHOY < 60
               MOVE 20 TO SYS-SHOY SYS-SSTP
           ELSE
               MOVE 19 TO SYS-SHOY SYS-SSTP.
           MOVE SYS-HHHY TO SYS-HHTS IN SYS-HSTP-RED.
           MOVE SYS-MMHY TO SYS-MMTS IN SYS-HSTP-RED.
           MOVE SYS-SSHY TO SYS-SSTS IN SYS-HSTP-RED.

           IF SYS-HORA-HABI = 'S' 
              MOVE 'S' TO SYS-HORA-FLAG
           ELSE   
              MOVE 'N' TO SYS-HORA-FLAG.

           GO TO FIN-GNS-PRO-SYS.
       TIM-GNS-PRO-SYS.

           ACCEPT SYS-HHOY-2B FROM TIME.
           MOVE   SYS-HHHY-2B TO SYS-HHHY.
           MOVE   SYS-MMHY-2B TO SYS-MMHY.
           MOVE   SYS-SSHY-2B TO SYS-SSHY.


           MOVE FYH-TCMA       TO LEN.
           MOVE "CARRAY"       TO REC-TYPE.
           MOVE FYH-PROG       TO SERVICE-NAME.
           CALL "TPCALL" USING TPSVCDEF-REC
                               TPTYPE-REC
                               FYH-CMMA
                               TPTYPE-REC
                               FYH-CMMA
                               TPSTATUS-REC.
           IF NOT TPOK
              DISPLAY 'TIM-GNS-PRO-SYS    :' FYH-PROG
                                       ' '   TP-STATUS
              MOVE 0 TO TP-STATUS
              GO TO FIN-GNS-PRO-SYS.

           MOVE FYH-NUM-HHHY IN FYH-CMMA TO SYS-HHHY.
           MOVE FYH-NUM-MMHY IN FYH-CMMA TO SYS-MMHY.
           MOVE FYH-NUM-SSHY IN FYH-CMMA TO SYS-SSHY.
           MOVE SYS-HHHY TO SYS-HHTS IN SYS-HSTP-RED.
           MOVE SYS-MMHY TO SYS-MMTS IN SYS-HSTP-RED.
           MOVE SYS-SSHY TO SYS-SSTS IN SYS-HSTP-RED.
           GO TO FIN-GNS-PRO-SYS.

       EXT-GNS-PRO-SYS.


           MOVE SPACES   TO SYS-SCR-NTRN.
           MOVE SYS-NTRN TO SYS-SCR-NTRN.
           MOVE +3500 TO LEN.

           SET TPSUCCESS TO TRUE.
           CALL "TPRETURN" USING TPSVCRET-REC
                                 TPTYPE-REC
                                 SYS-CMMA
                                 TPSTATUS-REC.

           GOBACK.
           GO TO STT-GNS-PRO-SYS.
       XCT-GNS-PRO-SYS.

           MOVE SPACES   TO SYS-SCR-NTRN.
           MOVE SYS-TCMA   TO LEN.
           DISPLAY 'GNS SYS-CMMA:'SYS-CMMA.
           MOVE "CARRAY"   TO REC-TYPE.
           MOVE SYS-PROG   TO SERVICE-NAME.
           CALL "TPFORWARD" USING TPSVCDEF-REC
                                  TPTYPE-REC
                                  SYS-CMMA
                                  TPSTATUS-REC.
           IF NOT TPOK
           DISPLAY 'XCT-GNS-PRO-SYS    :' SYS-PROG
                                    ' '   TP-STATUS.

           GOBACK.
           GO TO STT-GNS-PRO-SYS.
       LNK-GNS-PRO-SYS.

           MOVE SPACES   TO SYS-SCR-NTRN.
           MOVE SYS-TCMA   TO LEN.
           MOVE "CARRAY"   TO REC-TYPE.
           MOVE SYS-PROG   TO SERVICE-NAME.

           DISPLAY 'SYS-CMMA :' SYS-CMMA.

           CALL "TPCALL" USING TPSVCDEF-REC
                               TPTYPE-REC
                               SYS-CMMA
                               TPTYPE-REC
                               SYS-CMMA
                               TPSTATUS-REC.

           IF NOT TPOK
           DISPLAY 'LNK-GNS-PRO-SYS    :' SYS-PROG
                                    ' '   TP-STATUS.


           GO TO STT-GNS-PRO-SYS.

       ABT-GNS-PRO-SYS.

           MOVE 'GNSPPABT' TO SYS-PROG.
           MOVE +79        TO SYS-TCMA.
           MOVE SYS-TCMA   TO LEN.
           MOVE "CARRAY"   TO REC-TYPE.
           MOVE SYS-PROG   TO SERVICE-NAME.
           CALL "TPFORWARD" USING TPSVCDEF-REC
                                  TPTYPE-REC
                                  SYS-MENS
                                  TPSTATUS-REC.
           IF NOT TPOK
           DISPLAY 'ABT-GNS-PRO-SYS    :' SYS-PROG
                                    ' '   TP-STATUS.

           GOBACK.

       STT-GNS-PRO-SYS.
           IF TPOK
               MOVE '00' TO SYS-STAT
               GO TO FIN-GNS-PRO-SYS.

           MOVE TP-STATUS                         TO SYS-STAT-NUM.
           MOVE 'Aborto, EN GNS-PRO-SYS , CMD : ' TO SYS-MEN1.
           MOVE SYS-CMND                          TO SYS-MEN2.
           MOVE SYS-STAT-NUM TO SYS-STAT.
           GO TO ABT-GNS-PRO-SYS.

       FIN-GNS-PRO-SYS.
           EXIT.

      ******************************************************
      * Write out a log err messages
      ******************************************************
       DO-USERLOG SECTION.
       INI-DO-USERLOG.

           MOVE LENGTH OF LOGMSG TO LOGMSG-LEN.
           ACCEPT SYS-HHOY-2B  FROM TIME.
           MOVE  SYS-HHOY-2B     TO LOGMSG-TIME.
           CALL "USERLOG" USING LOGMSG
                LOGMSG-LEN
                TPSTATUS-REC.

       FIN-DO-USERLOG.
           EXIT.
