      * Modulo FIO para registro CIC en DATACOM,  9-JUL-1990 16:08:49.26
       GNS-FIO-CIC SECTION.                                             
       INI-GNS-FIO-CIC.                                                 
           MOVE ADR-CIC-REQA TO ADR-REQA.                               
           MOVE 'CIC' TO ADR-TABL IN ADR-REQA.                          
      *                                                                 
           MOVE 'GNS'  TO IDD-SAUX.                                     
           MOVE 'C'    TO IDD-GAUX.                                     
           MOVE SPACES TO IDD-RAUX.                                     
           MOVE 1 TO IDD-IAUX.                                          
           SET IDD-ITBL TO 1.                                           
           SEARCH IDD-VSIS VARYING IDD-IAUX                             
             AT END                                                     
               GO TO GRP-GNS-FIO-CIC                                    
             WHEN IDD-DENT( IDD-ITBL ) = IDD-DAUX                       
               MOVE IDD-IENT( IDD-ITBL) TO ADR-DBID IN ADR-REQA         
               GO TO FSR-GNS-FIO-CIC.                                   
       GRP-GNS-FIO-CIC.                                                 
           MOVE SPACES TO IDD-GAUX.                                     
           MOVE 1      TO IDD-IAUX.                                     
           SET IDD-ITBL TO 1.                                           
           SEARCH IDD-VSIS VARYING IDD-IAUX                             
             AT END                                                     
               MOVE 'En GNS-FIO-CIC, NO existe en IDD:' TO FIO-MEN1     
               MOVE IDD-DAUX                            TO FIO-MEN2     
               PERFORM PRG-ABT                                          
             WHEN IDD-DENT( IDD-ITBL ) = IDD-DAUX                       
               MOVE IDD-IENT( IDD-ITBL) TO ADR-DBID IN ADR-REQA.        
       FSR-GNS-FIO-CIC.                                                 
      *                                                                 
           MOVE 'CIC00' TO ADR-ELM1.                                    
           MOVE FIO-PROG TO ADR-PROG.                                   
           IF FIO-KDEF = FIO-KDEF-S                                     
               GO TO CON-GNS-FIO-CIC.                                   
           MOVE FIO-CMND TO FIO-IAKY.                                   
           IF NOT FIO-IAKY-CON AND                                      
              ( FIO-AKEY = 'CIC-CAI-ICIC' OR FIO-AKEY NOT > SPACES )    
               MOVE CIC-CAI-ICIC IN CIC TO ADR-VKEY IN ADR-REQA         
               MOVE 'CIC00' TO ADR-DKEY IN ADR-REQA                     
           ELSE                                                         
               MOVE 'En GNS-FIO-CIC, key' TO FIO-MENS                   
               MOVE FIO-AKEY   TO FIO-MENS-KEY                          
               MOVE 'Invalida' TO FIO-MENS-FIL                          
               PERFORM PRG-ABT.                                         
       CON-GNS-FIO-CIC.                                                 
           MOVE CIC TO FIO-DFLD.                                        
           PERFORM GNS-FIO-DTC.                                         
           IF FIO-STAT-OKS                                              
               MOVE FIO-DFLD TO CIC                                     
           ELSE                                                         
               MOVE 'GNSCIC' TO FIO-MEN2                                
               IF FIO-STAT-FTL                                          
                   PERFORM PRG-ABT.                                     
           MOVE SPACES   TO FIO-AKEY.                                   
           MOVE FIO-KDEF-N TO FIO-KDEF.                                 
           MOVE ADR-REQA TO ADR-CIC-REQA.                               
       FIN-GNS-FIO-CIC.                                                 
           EXIT.                                                        
