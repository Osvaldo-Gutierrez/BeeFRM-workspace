      ********************* ERR *********************                   
       GNS-HDL-FRM SECTION.                                             
       INI-GNS-HDL-FRM.                                                 
      *EXEC CICS HANDLE AID                                             
      *          CLEAR    (ACL-GNS-ERR-FRM)                             
      *          PA1      (PA1-GNS-ERR-FRM)                             
      *          PA2      (PA2-GNS-ERR-FRM)                             
      *END-EXEC.                                                        
      *EXEC CICS HANDLE CONDITION                                       
      *          MAPFAIL  (MFA-GNS-ERR-FRM)                             
      *END-EXEC.                                                        
       FIN-GNS-HDL-FRM.                                                 
           EXIT.                                                        
       GNS-ERR-FRM SECTION.                                             
       ACL-GNS-ERR-FRM.                                                 
      *EXEC CICS XCTL                                                   
      *          PROGRAM('GNSPPCLR')                                    
      *END-EXEC.                                                        
           MOVE +79        TO LEN.
           MOVE "CARRAY"   TO REC-TYPE.
           MOVE 'GNSPPCLR' TO SERVICE-NAME.
           CALL "TPFORWARD" USING TPSVCDEF-REC
                                  TPTYPE-REC
                                  FRM-MENS
                                  TPSTATUS-REC.
       PA1-GNS-ERR-FRM.                                                 
           MOVE FRM-FFLD-PA1 TO FRM-FFLD.                               
           GO TO RET-GNS-ERR-FRM.                                       
       PA2-GNS-ERR-FRM.                                                 
           MOVE FRM-FFLD-PA2 TO FRM-FFLD.                               
           GO TO RET-GNS-ERR-FRM.                                       
       MFA-GNS-ERR-FRM.                                                 
           MOVE 'ABORTO : MAP FAIL' TO FRM-MENS.                        
           GO TO ABT-GNS-ERR-FRM.                                       
       RET-GNS-ERR-FRM.                                                 
           GO TO FIN-GNS-PRO-FRM.                                       
       ABT-GNS-ERR-FRM.                                                 
      *EXEC CICS XCTL                                                   
      *          PROGRAM('GNSPPABT')                                    
      *          COMMAREA(FRM-MENS)                                     
      *          LENGTH(+79)                                            
      *END-EXEC.                                                        
           MOVE +79        TO LEN.
           MOVE "CARRAY"   TO REC-TYPE.
           MOVE 'GNSPPABT' TO SERVICE-NAME.
           CALL "TPFORWARD" USING TPSVCDEF-REC
                                  TPTYPE-REC
                                  FRM-MENS
                                  TPSTATUS-REC.
       FIN-GNS-ERR-FRM.                                                 
           EXIT.                                                        
