      * Modulo FIO para registro MSG en DATACOM                         
       GNS-FIO-MSG SECTION.                                             
       INI-GNS-FIO-MSG.                                                 
      *JSS          
           MOVE 'MSG' TO MSG-COD-TTAB IN MSG                            
                         MSG-CIC-TTAB IN MSG                            
                         MSG-EXT-TTAB IN MSG                            
                         MSG-SNX-TTAB IN MSG.                           
      *                                                                 
           MOVE ADR-MSG-REQA TO ADR-REQA.                               
           MOVE 'TAB' TO ADR-TABL IN ADR-REQA.                          
      *                                                                 
           MOVE FIO-SIST TO IDD-SAUX.                                   
           MOVE 'C'      TO IDD-GAUX.                                   
           MOVE SPACES   TO IDD-RAUX.                                   
           MOVE 1 TO IDD-IAUX.                                          
           SET IDD-ITBL TO 1.                                           
           SEARCH IDD-VSIS VARYING IDD-IAUX                             
             WHEN IDD-DENT( IDD-ITBL ) = IDD-DAUX                       
               GO TO FSR-GNS-FIO-MSG.                                   
       GRP-GNS-FIO-MSG.                                                 
           MOVE SPACES TO IDD-GAUX.                                     
           MOVE 1      TO IDD-IAUX.                                     
           SET IDD-ITBL TO 1.                                           
           SEARCH IDD-VSIS VARYING IDD-IAUX                             
               AT END                                                   
                   MOVE 'En GNS-FIO-MSG, NO existe en IDD:' TO FIO-MEN1 
                   MOVE IDD-DAUX                            TO FIO-MEN2 
                   PERFORM PRG-ABT                                      
               WHEN IDD-DENT( IDD-ITBL ) = IDD-DAUX                     
                   NEXT SENTENCE.                                       
       FSR-GNS-FIO-MSG.                                                 
           MOVE IDD-IENT( IDD-ITBL ) TO ADR-DBID IN ADR-REQA.           
      *                                                                 
           MOVE 'TAB00' TO ADR-ELM1.                                    
           MOVE FIO-PROG TO ADR-PROG.                                   
           MOVE FIO-CMND TO FIO-IAKY.                                   
           IF NOT FIO-IAKY-CON AND                                      
              ( FIO-AKEY = 'MSG-COD-TABL' OR FIO-AKEY NOT > SPACES )    
               MOVE MSG-COD-TABL IN MSG TO ADR-VKEY IN ADR-REQA         
               MOVE 'TAB00' TO ADR-DKEY IN ADR-REQA                     
           ELSE                                                         
           IF FIO-AKEY = 'MSG-STP-ITRN'                                 
               MOVE MSG-STP-ITRN IN MSG TO ADR-VKEY IN ADR-REQA         
               MOVE 'TAB01' TO ADR-DKEY IN ADR-REQA                     
           ELSE                                                         
           IF FIO-AKEY = 'MSG-CIC-TABL'                                 
               MOVE MSG-CIC-TABL IN MSG TO ADR-VKEY IN ADR-REQA         
               MOVE 'TAB02' TO ADR-DKEY IN ADR-REQA                     
           ELSE                                                         
           IF FIO-AKEY = 'MSG-EXT-TABL'                                 
               MOVE MSG-EXT-TABL IN MSG TO ADR-VKEY IN ADR-REQA         
               MOVE 'TAB03' TO ADR-DKEY IN ADR-REQA                     
           ELSE                                                         
               MOVE 'En GNS-FIO-MSG, key' TO FIO-MENS                   
               MOVE FIO-AKEY   TO FIO-MENS-KEY                          
               MOVE 'Invalida' TO FIO-MENS-FIL                          
               PERFORM PRG-ABT.                                         
      *JSS                                                              
           IF FIO-CMND = FIO-PUT OR FIO-MOD                             
               MOVE MSG-COD-TTAB IN MSG TO MSG-CIC-TTAB IN MSG          
                                           MSG-EXT-TTAB IN MSG          
                                           MSG-SNX-TTAB IN MSG.         
      *                                                                 
           MOVE MSG TO FIO-DFLD.                                        
           PERFORM GNS-FIO-DTC.                                         
           IF FIO-STAT-OKS                                              
               MOVE FIO-DFLD TO MSG                                     
           ELSE                                                         
      *JSS     MOVE 'GNSMSG' TO FIO-MEN2                                
               MOVE FIO-SIST TO FIO-MENS-SIS                            
               MOVE 'TAB'    TO FIO-MENS-REG                            
               IF FIO-STAT-FTL                                          
               DISPLAY 'RGDABT 002'
                   PERFORM PRG-ABT.                                     

           MOVE SPACES   TO FIO-AKEY.                                   
           MOVE ADR-REQA TO ADR-MSG-REQA.                               
       FIN-GNS-FIO-MSG.                                                 
           EXIT.                                                        
