       GET-TSK-TERM SECTION.                                            
       INI-GET-TSK-TERM.                                                

           IF TSK-TERM-ORIGEN = 'S'
              GO TO FIN-GET-TSK-TERM.                                                

           CALL "TPGETLEV" USING TPTRXLEV-REC
                                 TPSTATUS-REC. 
           IF NOT TPOK
              DISPLAY 'ERROR  TPGETLEV :' TP-STATUS
           ELSE
              IF TP-NOT-IN-TRAN
                 DISPLAY 'TPGETLEV TP-NOT-IN-TRAN:' TP-STATUS.

           CALL "TPSUSPEND" USING TPTRXDEF-REC
                                 TPSTATUS-REC.                           
           IF NOT TPOK
              DISPLAY 'ERROR  TPSUSPEND :' TP-STATUS.

           
           CALL "TPRESUME" USING TPTRXDEF-REC
                                 TPSTATUS-REC.             
           IF NOT TPOK
              DISPLAY 'ERROR  TPSUSPEND :' TP-STATUS.

           MOVE TRANID(1) TO TSK-TRANID-1.
           MOVE TRANID(2) TO TSK-TRANID-2.
           MOVE TRANID(3) TO TSK-TRANID-3.
           MOVE TRANID(4) TO TSK-TRANID-4.
           MOVE TRANID(5) TO TSK-TRANID-5.
           MOVE TRANID(6) TO TSK-TRANID-6.

           MOVE SPACES         TO TSK-TERM-TUX.
           MOVE TSK-TRANID-ALF TO TSK-TERM-TUX.

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
              GO TO FIN-GET-TSK-TERM.                                                
           
           
           MOVE QUE-DAT-RECV        TO QUE-ITEM.           
           MOVE QUE-DATA            TO TSK-TERM-NUM-TUX-ALF.
           MOVE TSK-TERM-NUM-TUX    TO TSK-TERM-NUM.
           MOVE TSK-TERM-ALF        TO EIBTASKN.
           MOVE TSK-TERM-ALF        TO EIBTRMID.
           
      *     DISPLAY 'SI ENCONTRO COLA ASUME ' TSK-TERM-NUM-TUX ' :' 
      *                                       TSK-TERM-TUX ' :'
      *                                       TSK-TERM-ALF ' :'  
      *                                       EIBTASKN.

       FIN-GET-TSK-TERM.                                                
           EXIT.                                                        
