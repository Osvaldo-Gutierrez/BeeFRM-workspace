      ********************* ERR *********************                   
       GNS-HDL-SYS SECTION.                                             
       INI-GNS-HDL-SYS.                                                 
      *EXEC CICS HANDLE CONDITION                                       
      *          INVREQ   (OPE-GNS-ERR-SYS)                             
      *          LENGERR  (IFI-GNS-ERR-SYS)                             
      *          PGMIDERR (PGM-GNS-ERR-SYS)                             
      *END-EXEC.                                                        
       FIN-GNS-HDL-SYS.                                                 
           EXIT.                                                        
       GNS-ERR-SYS SECTION.                                             
       OPE-GNS-ERR-SYS.                                                 
           MOVE 'ERROR PERMANENTE' TO SYS-MENS.                         
           GO TO ABT-GNS-ERR-SYS.                                       
       IFI-GNS-ERR-SYS.                                                 
           MOVE 'ERROR DE LARGO'   TO SYS-MENS.                         
           GO TO ABT-GNS-ERR-SYS.                                       
       PGM-GNS-ERR-SYS.                                                 
           MOVE 'PROGRAM ID ERROR' TO SYS-MENS.                         
           GO TO RET-GNS-ERR-SYS.                                       
       RET-GNS-ERR-SYS.                                                 
           GO TO FIN-GNS-PRO-SYS.                                       
       ABT-GNS-ERR-SYS.                                                 
      *EXEC CICS XCTL                                                   
      *          PROGRAM('GNSPPABT')                                    
      *          COMMAREA(SYS-MENS)                                     
      *          LENGTH(+79)                                            
      *END-EXEC.                                                        
           MOVE +79        TO LEN.
           MOVE "CARRAY"   TO REC-TYPE.
           MOVE 'GNSPPABT' TO SERVICE-NAME.
           CALL "TPFORWARD" USING TPSVCDEF-REC
                                 TPTYPE-REC
                                 SYS-MENS
                                 TPSTATUS-REC.
       FIN-GNS-ERR-SYS.                                                 
           EXIT.                                                        
