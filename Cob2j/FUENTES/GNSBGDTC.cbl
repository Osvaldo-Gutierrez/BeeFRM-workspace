      *****************************************************
      *  Issue a TPCALL
      *****************************************************
       GNS-FIO-DTC SECTION.
       INI-GNS-FIO-DTC.

           MOVE ADR-REQA             TO FIO-ORACLE-RQA.
           MOVE FIO-DFLD             TO FIO-ORACLE-DFLD.
           MOVE FIO-MENS             TO FIO-ORACLE-MENS.
           MOVE FIO-VARI             TO FIO-ORACLE-VARI.
           MOVE ADR-TABL IN ADR-REQA TO FIO-ORACLE-PROG-TAB.
           MOVE ADR-DBID IN ADR-REQA TO FIO-ORACLE-PROG-NUM.
           MOVE FIO-ORACLE           TO SEND-STRING-FIO.

           IF FIO-CMND = 38
              MOVE ZEROES TO FIO-STAT
              PERFORM TUX-BACK-OUT
              GO TO FIN-GNS-FIO-DTC.

           MOVE 3000                 TO LEN.
           MOVE "CARRAY"             TO REC-TYPE.
           MOVE FIO-ORACLE-PROG      TO SERVICE-NAME.


           MOVE FIO-CMND             TO LOGMSG-TEXT-1.
           MOVE FIO-ORACLE-PROG      TO LOGMSG-TEXT-2.
           MOVE SPACES               TO LOGMSG-TEXT-3.
           MOVE '40'                 TO LOGMSG-NUMB.
           PERFORM DO-USERLOG.


           SET TPBLOCK    IN TPSVCDEF-REC TO TRUE.
           SET TPTRAN     IN TPSVCDEF-REC TO TRUE.
           SET TPNOTIME   IN TPSVCDEF-REC TO TRUE.
           SET TPSIGRSTRT IN TPSVCDEF-REC TO TRUE.
           SET TPCHANGE   IN TPSVCDEF-REC TO TRUE.

           CALL "TPCALL" USING TPSVCDEF-REC
                TPTYPE-REC
                SEND-STRING-FIO
                TPTYPE-REC
                RECV-STRING-FIO
                TPSTATUS-REC.


           IF NOT TPOK
                DISPLAY 'GNSBGDTC :' FIO-ORACLE-PROG ' ' TP-STATUS
                MOVE "TPCALL Failed" TO FIO-MENS
                PERFORM PRG-ABT.


           MOVE FIO-CMND             TO LOGMSG-TEXT-1.
           MOVE FIO-ORACLE-PROG      TO LOGMSG-TEXT-2.
           MOVE SPACES               TO LOGMSG-TEXT-3.
           MOVE '41'                 TO LOGMSG-NUMB.
           PERFORM DO-USERLOG.



           MOVE RECV-STRING-FIO     TO FIO-ORACLE.
           MOVE FIO-ORACLE-RQA      TO ADR-REQA.
           MOVE FIO-ORACLE-DFLD     TO FIO-DFLD.
           MOVE FIO-ORACLE-MENS     TO FIO-MENS.
           MOVE FIO-ORACLE-VARI     TO FIO-VARI.

       FIN-GNS-FIO-DTC.
           EXIT.

       TUX-BACK-OUT SECTION.
       INI-TUX-BACK-OUT.

           CALL "TPGETLEV" USING TPTRXLEV-REC TPSTATUS-REC.
           IF NOT TPOK
              DISPLAY 'GNSBGDTC TUX-BACK-OUT TPGETLEV:'
                                             TP-STATUS
              GO TO FIN-TUX-BACK-OUT
           ELSE
              IF TP-NOT-IN-TRAN
                 DISPLAY 'GNSBGDTC TUX-BACK-OUT TP-NOT-IN-TRAN:'
                                                TP-STATUS
                 GO TO FIN-TUX-BACK-OUT.

           CALL "TPSUSPEND" USING TPTRXDEF-REC TPSTATUS-REC.
           IF NOT TPOK
              DISPLAY 'GNSBGDTC TUX-BACK-OUT TPSUSPEND:'
                                             TP-STATUS
              GO TO FIN-TUX-BACK-OUT.

           CALL "TPRESUME" USING TPTRXDEF-REC TPSTATUS-REC.
           IF NOT TPOK
              DISPLAY 'GNSBGDTC TUX-BACK-OUT TPRESUME:'
                                             TP-STATUS
              GO TO FIN-TUX-BACK-OUT.

           MOVE TRANID(1)           TO TSK-TRANID-1.
           MOVE TRANID(2)           TO TSK-TRANID-2.
           MOVE TRANID(3)           TO TSK-TRANID-3.
           MOVE TRANID(4)           TO TSK-TRANID-4.
           MOVE TRANID(5)           TO TSK-TRANID-5.
           MOVE TRANID(6)           TO TSK-TRANID-6.
           MOVE SPACES              TO TSK-TERM-TUX.
           MOVE TSK-TRANID-ALF      TO TSK-TERM-TUX.

           MOVE 'GET'               TO QUE-COM-SEND.
           MOVE TSK-TERM-TUX        TO QUE-NAM-SEND.
           MOVE 1                   TO QUE-NUM-SEND.
           MOVE 4                   TO QUE-LAR-SEND.
           MOVE SPACES              TO QUE-TRX-SEND.
           MOVE SPACES              TO QUE-DAT-SEND.
           PERFORM GNS-MSJ-QUE.
           IF QUE-STAT NOT = QUE-STAT-OKS
              GO TO FIN-TUX-BACK-OUT.

           MOVE QUE-DAT-RECV        TO QUE-ITEM.
           MOVE QUE-DATA            TO TSK-INFO-TRAN.
           MOVE 1                   TO TSK-INFO-COMMIT.

           MOVE 'MOD'               TO QUE-COM-SEND.
           MOVE TSK-TERM-TUX        TO QUE-NAM-SEND.
           MOVE 1                   TO QUE-NUM-SEND.
           MOVE 4                   TO QUE-LAR-SEND.
           MOVE TSK-INFO-TRANID-ALF TO QUE-TRX-SEND.

           MOVE TSK-INFO-TRAN       TO QUE-DATA.
           MOVE QUE-ITEM            TO QUE-DAT-SEND.

           PERFORM GNS-MSJ-QUE.

       FIN-TUX-BACK-OUT.
           EXIT.
