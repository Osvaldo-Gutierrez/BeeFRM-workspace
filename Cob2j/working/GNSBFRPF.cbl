      * Modulo FIO para registro RPF en DATACOM                         
       GNS-FIO-RPF SECTION.                                             
       INI-GNS-FIO-RPF.              
       
           MOVE ADR-RPF-REQA       TO ADR-REQA.                               
           MOVE 'RPF'              TO ADR-TABL IN ADR-REQA.   
      *                                                                 
           MOVE FIO-SIST TO IDD-SAUX.                                   
           MOVE 'C'      TO IDD-GAUX.                                   
           MOVE SPACES   TO IDD-RAUX.                                   
           MOVE 1 TO IDD-IAUX.                                          
           SET IDD-ITBL TO 1.                                           
           SEARCH IDD-VSIS VARYING IDD-IAUX                             
             WHEN IDD-DENT( IDD-ITBL ) = IDD-DAUX                       
               GO TO FSR-GNS-FIO-RPF.                                   
       GRP-GNS-FIO-RPF.                                                 
           MOVE SPACES TO IDD-GAUX.                                     
           MOVE 1      TO IDD-IAUX.                                     
           SET IDD-ITBL TO 1.                                           
           SEARCH IDD-VSIS VARYING IDD-IAUX                             
               AT END                                                   
                   MOVE 'En GNS-FIO-RPF, NO existe en IDD:' TO FIO-MEN1 
                   MOVE IDD-DAUX                            TO FIO-MEN2 
                   PERFORM PRG-ABT                                      
               WHEN IDD-DENT( IDD-ITBL ) = IDD-DAUX                     
                   NEXT SENTENCE.                                       
       FSR-GNS-FIO-RPF.                                                 
           MOVE IDD-IENT( IDD-ITBL ) TO ADR-DBID IN ADR-REQA.           

           IF FIO-AKEY NOT > SPACES
              MOVE 'RPF-COD-DPTR' TO FIO-AKEY.

           MOVE 'RPF00' TO ADR-ELM1.                                    
           MOVE FIO-PROG TO ADR-PROG.                                   
           MOVE FIO-CMND TO FIO-IAKY.                                   
           IF NOT FIO-IAKY-CON AND                                      
              ( FIO-AKEY = 'RPF-COD-DPTR' OR FIO-AKEY NOT > SPACES )    
               MOVE RPF-COD-DPTR IN RPF TO ADR-VKEY IN ADR-REQA         
               MOVE 'RPF00' TO ADR-DKEY IN ADR-REQA                     
           ELSE                                                         
               MOVE 'En GNS-FIO-RPF, key' TO FIO-MENS                   
               MOVE FIO-AKEY   TO FIO-MENS-KEY                          
               MOVE 'Invalida' TO FIO-MENS-FIL                          
               PERFORM PRG-ABT.                                         

           MOVE RPF TO FIO-DFLD. 
           PERFORM GNS-FIO-DTC.                                         
           IF FIO-STAT-OKS                                              
               MOVE FIO-DFLD TO RPF                                     
           ELSE                                                         
               MOVE FIO-SIST TO FIO-MENS-SIS                            
               MOVE 'RPF'    TO FIO-MENS-REG                            
               IF FIO-STAT-FTL                                          
                   PERFORM PRG-ABT.                                     

           MOVE SPACES   TO FIO-AKEY.                                   
           MOVE ADR-REQA TO ADR-RPF-REQA.                               

       FIN-GNS-FIO-RPF.                                                 
           EXIT.                                                        
