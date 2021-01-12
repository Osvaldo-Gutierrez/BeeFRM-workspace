      * Modulo FIO para registro MSC en DATACOM                         
       GNS-FIO-MSC SECTION.                                             
       INI-GNS-FIO-MSC.                                                 
      *JSS                                                              
           MOVE 'MSC' TO MSC-COD-TTAB IN MSC                            
                         MSC-CIC-TTAB IN MSC                            
                         MSC-EXT-TTAB IN MSC                            
                         MSC-SNX-TTAB IN MSC.                           
      *                                                                 
           MOVE ADR-MSC-REQA TO ADR-REQA.                               
           MOVE 'TAB' TO ADR-TABL IN ADR-REQA.                          
      *                                                                 
           MOVE FIO-SIST TO IDD-SAUX.                                   
           MOVE 'C'      TO IDD-GAUX.                                   
           MOVE SPACES   TO IDD-RAUX.                                   
           MOVE 1 TO IDD-IAUX.                                          
           SET IDD-ITBL TO 1.                                           
           SEARCH IDD-VSIS VARYING IDD-IAUX                             
             WHEN IDD-DENT( IDD-ITBL ) = IDD-DAUX                       
               GO TO FSR-GNS-FIO-MSC.                                   
       GRP-GNS-FIO-MSC.                                                 
           MOVE SPACES TO IDD-GAUX.                                     
           MOVE 1      TO IDD-IAUX.                                     
           SET IDD-ITBL TO 1.                                           
           SEARCH IDD-VSIS VARYING IDD-IAUX                             
               AT END                                                   
                   MOVE 'En GNS-FIO-MSC, NO existe en IDD:' TO FIO-MEN1 
                   MOVE IDD-DAUX                            TO FIO-MEN2 
                   PERFORM PRG-ABT                                      
               WHEN IDD-DENT( IDD-ITBL ) = IDD-DAUX                     
                   NEXT SENTENCE.                                       
       FSR-GNS-FIO-MSC.                                                 
           MOVE IDD-IENT( IDD-ITBL ) TO ADR-DBID IN ADR-REQA.           
      *                                                                 
           MOVE 'TAB00' TO ADR-ELM1.                                    
           MOVE FIO-PROG TO ADR-PROG.                                   
           MOVE FIO-CMND TO FIO-IAKY.                                   
           IF NOT FIO-IAKY-CON AND                                      
              ( FIO-AKEY = 'MSC-COD-TABL' OR FIO-AKEY NOT > SPACES )    
               MOVE MSC-COD-TABL IN MSC TO ADR-VKEY IN ADR-REQA         
               MOVE 'TAB00' TO ADR-DKEY IN ADR-REQA                     
           ELSE                                                         
           IF FIO-AKEY = 'MSC-STP-ITRN'                                 
               MOVE MSC-STP-ITRN IN MSC TO ADR-VKEY IN ADR-REQA         
               MOVE 'TAB01' TO ADR-DKEY IN ADR-REQA                     
           ELSE                                                         
           IF FIO-AKEY = 'MSC-CIC-TABL'                                 
               MOVE MSC-CIC-TABL IN MSC TO ADR-VKEY IN ADR-REQA         
               MOVE 'TAB02' TO ADR-DKEY IN ADR-REQA                     
           ELSE                                                         
           IF FIO-AKEY = 'MSC-EXT-TABL'                                 
               MOVE MSC-EXT-TABL IN MSC TO ADR-VKEY IN ADR-REQA         
               MOVE 'TAB03' TO ADR-DKEY IN ADR-REQA                     
           ELSE                                                         
               MOVE 'En GNS-FIO-MSC, key' TO FIO-MENS                   
               MOVE FIO-AKEY   TO FIO-MENS-KEY                          
               MOVE 'Invalida' TO FIO-MENS-FIL                          
               PERFORM PRG-ABT.                                         
      *JSS                                                              
           IF FIO-CMND = FIO-PUT OR FIO-MOD                             
               MOVE MSC-COD-TTAB IN MSC TO MSC-CIC-TTAB IN MSC          
                                           MSC-EXT-TTAB IN MSC          
                                           MSC-SNX-TTAB IN MSC.         
      *                                                                 
           MOVE MSC TO FIO-DFLD.                                        
           PERFORM GNS-FIO-DTC.                                         
           IF FIO-STAT-OKS                                              
               MOVE FIO-DFLD TO MSC                                     
           ELSE                                                         
      *JSS     MOVE 'GNSMSC' TO FIO-MEN2                                
               MOVE FIO-SIST TO FIO-MENS-SIS                            
               MOVE 'TAB'    TO FIO-MENS-REG                            
      *                                                                 
               IF FIO-STAT-FTL                                          
                   PERFORM PRG-ABT.                                     
                              
           MOVE SPACES   TO FIO-AKEY.                                   
           MOVE ADR-REQA TO ADR-MSC-REQA.                               
       FIN-GNS-FIO-MSC.                                                 
           EXIT.                                                        
