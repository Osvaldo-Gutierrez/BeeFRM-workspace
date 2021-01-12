       
           MOVE LENGTH OF LOGMSG TO LOGMSG-LEN. 

           MOVE 'TPSVCSTART       '       TO LOGMSG-TEXT.
           MOVE '00'                      TO LOGMSG-NUMB.
           PERFORM DO-USERLOG.

           MOVE LENGTH OF DFHCOMMAREA TO LEN.
           MOVE LENGTH OF DFHCOMMAREA TO EIBCALEN.
           CALL "TPSVCSTART" USING TPSVCDEF-REC 
                        TPTYPE-REC 
                        DFHCOMMAREA
                        TPSTATUS-REC.      

           IF NOT TPOK
                MOVE "TPSVCSTART Failed" TO LOGMSG-TEXT
                    PERFORM DO-USERLOG 
                PERFORM PRG-ABT 
           END-IF.

      *     IF TPTRUNCATE 
      *          MOVE "Data was truncated" TO LOGMSG-TEXT
      *              PERFORM DO-USERLOG 
      *          PERFORM PRG-ABT 
      *     END-IF.

           IF EIBCALEN = 0                                              
                 GOBACK.                                                
                      
           CALL "TPGETLEV" USING TPTRXLEV-REC TPSTATUS-REC. 
           IF NOT TPOK
              DISPLAY 'ERROR  TPGETLEV :' TP-STATUS
           ELSE
              IF TP-NOT-IN-TRAN
                 DISPLAY 'TPGETLEV TP-NOT-IN-TRAN:' TP-STATUS.

           CALL "TPSUSPEND" USING TPTRXDEF-REC TPSTATUS-REC.                           
           IF NOT TPOK
              DISPLAY 'ERROR  TPSUSPEND :' TP-STATUS.
           
           CALL "TPRESUME" USING TPTRXDEF-REC TPSTATUS-REC.             
           IF NOT TPOK
              DISPLAY 'ERROR  TPSUSPEND :' TP-STATUS.

           MOVE TRANID(1)           TO TSK-TRANID-1.
           MOVE TRANID(2)           TO TSK-TRANID-2.
           MOVE TRANID(3)           TO TSK-TRANID-3.
           MOVE TRANID(4)           TO TSK-TRANID-4.
           MOVE TRANID(5)           TO TSK-TRANID-5.
           MOVE TRANID(6)           TO TSK-TRANID-6.
           MOVE 'S'                 TO TSK-TERM-ORIGEN.
           MOVE SPACES              TO TSK-TERM-TUX.
           MOVE TSK-TRANID-ALF      TO TSK-TERM-TUX.
           MOVE TSK-TERM-TUX        TO TSK-TERM-TUX.                                 
           MOVE 'GET'               TO QUE-COM-SEND.                                                 
           MOVE TSK-TERM-TUX        TO QUE-NAM-SEND.      
           MOVE 1                   TO QUE-NUM-SEND.      
           MOVE 4                   TO QUE-LAR-SEND.      
           MOVE SPACES              TO QUE-TRX-SEND.      
           MOVE SPACES              TO QUE-DAT-SEND.                           
           PERFORM GNS-MSJ-QUE.
           IF QUE-STAT NOT = QUE-STAT-OKS
              DISPLAY 'NO ENCONTRO COLA ASUME 1111111 :' TSK-TERM-TUX  
              MOVE 1111111          TO TSK-TERM-NUM-TUX
              MOVE TSK-TERM-NUM-TUX TO TSK-TERM-NUM
              MOVE TSK-TERM-NUM     TO EIBTASKN
              MOVE TSK-TERM-ALF     TO EIBTRMID
           ELSE           
              MOVE QUE-DAT-RECV     TO QUE-ITEM           
              MOVE QUE-DATA         TO TSK-TERM-NUM-TUX-ALF
              MOVE TSK-TERM-NUM-TUX TO TSK-TERM-NUM
              MOVE TSK-TERM-ALF     TO EIBTASKN
              MOVE TSK-TERM-ALF     TO EIBTRMID.
