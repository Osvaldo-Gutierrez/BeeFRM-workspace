      * Modulo FIO para registro TAB en DATACOM                         
       GNS-FIO-TAB SECTION.                                             
       INI-GNS-FIO-TAB.              
           MOVE ADR-TAB-REQA       TO ADR-REQA.                               
           MOVE 'TAB'              TO ADR-TABL IN ADR-REQA. 
           
      *                                                                 
           MOVE FIO-SIST TO IDD-SAUX.                                   
           MOVE 'C'      TO IDD-GAUX.                                   
           MOVE SPACES   TO IDD-RAUX.                                   
           MOVE 1 TO IDD-IAUX.                                          
           SET IDD-ITBL TO 1.                                           
           SEARCH IDD-VSIS VARYING IDD-IAUX                             
             WHEN IDD-DENT( IDD-ITBL ) = IDD-DAUX                       
               GO TO FSR-GNS-FIO-TAB.                                   
       GRP-GNS-FIO-TAB.                                                 
           MOVE SPACES TO IDD-GAUX.                                     
           MOVE 1      TO IDD-IAUX.                                     
           SET IDD-ITBL TO 1.                                           
           SEARCH IDD-VSIS VARYING IDD-IAUX                             
               AT END                                                   
                   MOVE 'En GNS-FIO-TAB, NO existe en IDD:' TO FIO-MEN1 
                   MOVE IDD-DAUX                            TO FIO-MEN2 
                   PERFORM PRG-ABT                                      
               WHEN IDD-DENT( IDD-ITBL ) = IDD-DAUX                     
                   NEXT SENTENCE.                                       
       FSR-GNS-FIO-TAB.                                                 
           MOVE IDD-IENT( IDD-ITBL ) TO ADR-DBID IN ADR-REQA.           
      *                                                                 
           MOVE 'TAB00' TO ADR-ELM1.                                    
           MOVE FIO-PROG TO ADR-PROG.                                   
           MOVE FIO-CMND TO FIO-IAKY.                                   
           IF NOT FIO-IAKY-CON AND                                      
              ( FIO-AKEY = 'TAB-COD-TABL' OR FIO-AKEY NOT > SPACES )    
               MOVE TAB-COD-TABL IN TAB TO ADR-VKEY IN ADR-REQA         
               MOVE 'TAB00' TO ADR-DKEY IN ADR-REQA                     
           ELSE                                                         
           IF FIO-AKEY = 'TAB-STP-ITRN'                                 
               MOVE TAB-STP-ITRN IN TAB TO ADR-VKEY IN ADR-REQA         
               MOVE 'TAB01' TO ADR-DKEY IN ADR-REQA                     
           ELSE                                                         
           IF FIO-AKEY = 'TAB-CIC-TABL'                                 
               MOVE TAB-CIC-TABL IN TAB TO ADR-VKEY IN ADR-REQA         
               MOVE 'TAB02' TO ADR-DKEY IN ADR-REQA                     
           ELSE                                                         
           IF FIO-AKEY = 'TAB-EXT-TABL'                                 
               MOVE TAB-EXT-TABL IN TAB TO ADR-VKEY IN ADR-REQA         
               MOVE 'TAB03' TO ADR-DKEY IN ADR-REQA                     
           ELSE                                                         
               MOVE 'En GNS-FIO-TAB, key' TO FIO-MENS                   
               MOVE FIO-AKEY   TO FIO-MENS-KEY                          
               MOVE 'Invalida' TO FIO-MENS-FIL                          
               PERFORM PRG-ABT.                                         
      *JSS                                                              
           IF FIO-CMND = FIO-PUT OR FIO-MOD                             
               MOVE TAB-COD-TTAB IN TAB TO TAB-CIC-TTAB IN TAB          
                                           TAB-EXT-TTAB IN TAB          
                                           TAB-SNX-TTAB IN TAB.         
      *                                                                 
           MOVE TAB TO FIO-DFLD. 
           PERFORM GNS-FIO-DTC.                                         
           IF FIO-STAT-OKS                                              
               MOVE FIO-DFLD TO TAB                                     
           ELSE                                                         
      *JSS     MOVE 'GNSTAB' TO FIO-MEN2                                
               MOVE FIO-SIST TO FIO-MENS-SIS                            
               MOVE 'TAB'    TO FIO-MENS-REG                            
      *                                                                 
               IF FIO-STAT-FTL                                          
                   PERFORM PRG-ABT.                                     
           MOVE SPACES   TO FIO-AKEY.                                   
           MOVE ADR-REQA TO ADR-TAB-REQA.                               
       FIN-GNS-FIO-TAB.                                                 
           EXIT.                                                        
