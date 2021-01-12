      *Modulo Generico Manejo de Colas
       GNS-CHK-QUEU SECTION.
       INI-GNS-CHK-QUEU.
           MOVE 1 TO QUE-NITM.
           MOVE QUE-GET TO QUE-CMND.
           PERFORM GNS-PRO-QUE.
       FIN-GNS-CHK-QUEU.
           EXIT.

       GNS-QUE-EOQ SECTION.
       INI-GNS-QUE-EOQ.
           MOVE QUE-STAT-EOQ TO QUE-STAT.
           GO TO FIN-GNS-PRO-QUE.
       FIN-GNS-QUE-EOQ.
           EXIT.

       GNS-QUE-NEX SECTION.
       INI-GNS-QUE-NEX.
           MOVE QUE-STAT-NEX TO QUE-STAT.
           GO TO FIN-GNS-PRO-QUE.
       FIN-GNS-QUE-NEX.
           EXIT.

       GNS-ERR-QUE SECTION.
       INI-GNS-ERR-QUE.

      *     EXEC CICS HANDLE CONDITION
      *               QIDERR (GNS-QUE-NEX)
      *               ITEMERR(GNS-QUE-EOQ)
      *               LENGERR(GNS-QUE-NEX)
      *     END-EXEC.

       FIN-GNS-ERR-QUE.
           EXIT.

       GNS-PRO-QUE SECTION.
       INI-GNS-PRO-QUE.

           MOVE QUE-STAT-OKS TO QUE-STAT.

           IF QUE-CMND = QUE-PUT
               GO TO GNS-PUT-QUE
           ELSE
           IF QUE-CMND = QUE-GET
               GO TO GNS-GET-QUE
           ELSE
           IF QUE-CMND = QUE-MOD
               GO TO GNS-MOD-QUE
           ELSE
           IF QUE-CMND = QUE-DEL
               GO TO GNS-DEL-QUE.



           MOVE 'Comando invalido :' TO QUE-MEN1.
           MOVE QUE-CMND             TO QUE-MEN2.
           MOVE QUE-MENS             TO FIO-MENS.

      *     EXEC CICS XCTL
      *               PROGRAM('GNSPPABT')
      *               COMMAREA(QUE-MENS)
      *               LENGTH(+79)
      *     END-EXEC.

           MOVE +79                  TO LEN.
           MOVE "CARRAY"             TO REC-TYPE.
           MOVE 'GNSPPABT'           TO SERVICE-NAME.
           CALL "TPFORWARD" USING TPSVCDEF-REC
                                  TPTYPE-REC
                                  QUE-MENS
                                  TPSTATUS-REC.

           GOBACK.




       GNS-PUT-QUE.

      *     EXEC CICS WRITEQ TS
      *               QUEUE(QUE-COLA)
      *               FROM(QUE-ITEM)
      *               LENGTH(QUE-LITM)
      *               AUXILIARY
      *     END-EXEC.

           MOVE QUE-CMND TO QUE-COM-SEND.
           MOVE SPACES   TO QUE-NAM-SEND.
           MOVE QUE-COLA TO QUE-NAM-SEND.
           MOVE ZEROES   TO QUE-NUM-SEND.
           MOVE QUE-LITM TO QUE-LAR-SEND.
           MOVE SPACES   TO QUE-TRX-SEND.
           MOVE TSK-TERM-ALF TO QUE-TRX-SEND.
           MOVE QUE-ITEM TO QUE-DAT-SEND.
           PERFORM GNS-MSJ-QUE.


       FIN-GNS-PUT-QUE.
           GO TO FIN-GNS-PRO-QUE.
       GNS-GET-QUE.

      *     EXEC CICS READQ TS
      *               QUEUE(QUE-COLA)
      *               INTO(QUE-ITEM)
      *               LENGTH(QUE-LITM)
      *               ITEM(QUE-NITM)
      *     END-EXEC.

           MOVE QUE-CMND TO QUE-COM-SEND.
           MOVE SPACES   TO QUE-NAM-SEND.
           MOVE QUE-COLA TO QUE-NAM-SEND.
           MOVE QUE-NITM TO QUE-NUM-SEND.
           MOVE QUE-LITM TO QUE-LAR-SEND.
           MOVE SPACES   TO QUE-TRX-SEND.
           MOVE TSK-TERM-ALF TO QUE-TRX-SEND.
           MOVE SPACES   TO QUE-DAT-SEND.
           PERFORM GNS-MSJ-QUE.

       FIN-GNS-GET-QUE.
           GO TO FIN-GNS-PRO-QUE.
       GNS-MOD-QUE.

      *     EXEC CICS WRITEQ TS
      *               QUEUE(QUE-COLA)
      *               FROM(QUE-ITEM)
      *               LENGTH(QUE-LITM)
      *               ITEM(QUE-NITM)
      *               REWRITE
      *     END-EXEC.

           MOVE QUE-CMND TO QUE-COM-SEND.
           MOVE SPACES   TO QUE-NAM-SEND.
           MOVE QUE-COLA TO QUE-NAM-SEND.
           MOVE QUE-NITM TO QUE-NUM-SEND.
           MOVE QUE-LITM TO QUE-LAR-SEND.
           MOVE SPACES   TO QUE-TRX-SEND.
           MOVE TSK-TERM-ALF TO QUE-TRX-SEND.
           MOVE QUE-ITEM TO QUE-DAT-SEND.
           PERFORM GNS-MSJ-QUE.

       FIN-GNS-MOD-QUE.
           GO TO FIN-GNS-PRO-QUE.

       GNS-DEL-QUE.

      *     EXEC CICS DELETEQ TS
      *               QUEUE(QUE-COLA)
      *     END-EXEC.

           MOVE QUE-CMND TO QUE-COM-SEND.
           MOVE SPACES   TO QUE-NAM-SEND.
           MOVE QUE-COLA TO QUE-NAM-SEND.
      *    MOVE QUE-NITM TO QUE-NUM-SEND.
           MOVE ZEROES   TO QUE-NUM-SEND.
           MOVE ZEROES   TO QUE-LAR-SEND.
           MOVE SPACES   TO QUE-TRX-SEND.
           MOVE TSK-TERM-ALF TO QUE-TRX-SEND.
           MOVE SPACES   TO QUE-DAT-SEND.
           PERFORM GNS-MSJ-QUE.


       FIN-GNS-DEL-QUE.
           GO TO FIN-GNS-PRO-QUE.
       FIN-GNS-PRO-QUE.
           EXIT.

       GNS-MSJ-QUE SECTION.
       INI-GNS-MSJ-QUE.

      *     SET QUE-TPNOTRAN    TO TRUE.
           SET QUE-TPTRAN      TO TRUE.
           SET QUE-TPBLOCK     TO TRUE.
           SET QUE-TPNOTIME    TO TRUE.
           SET QUE-TPSIGRSTRT  TO TRUE.
           SET QUE-TPCHANGE    TO TRUE.
          
           MOVE SPACES TO QUE-RECV.

      *    MOVE '00'         TO LOGMSG-NUMB.
      *    MOVE QUE-COM-SEND TO LOGMSG-TEXT.
      *    PERFORM DO-USERLOG.

           CALL "TPCALL" USING QUE-TPSVCDEF-REC
                QUE-TPTYPE-REC-SEND
                QUE-SEND
                QUE-TPTYPE-REC-RECV
                QUE-RECV
                TPSTATUS-REC.

      *    MOVE '01'         TO LOGMSG-NUMB.
      *    MOVE QUE-COM-SEND TO LOGMSG-TEXT.
      *    PERFORM DO-USERLOG.

           IF NOT TPOK
              MOVE QUE-STAT-NEX TO QUE-STAT
              DISPLAY 'TEMPORAL STORAGE :' TP-STATUS
              MOVE TP-STATUS    TO QUE-NUM-STAT
              MOVE QUE-NUM-STAT TO QUE-GLS-STAT
           ELSE
              IF QUE-STA-RECV = ZEROES
                 MOVE QUE-STAT-OKS TO QUE-STAT
                 MOVE QUE-DAT-RECV TO QUE-ITEM
              ELSE
                 MOVE QUE-STAT-NEX TO QUE-STAT.

       FIN-GNS-MSJ-QUE.
           EXIT.
