      * Obtencion de Mensaje                                            
       GET-MSG SECTION.                                                 
       INI-GET-MSG.                                                     
           MOVE SCR-SIST TO FIO-SIST.                                   
           MOVE FIO-GET-KEY TO FIO-CMND.                                
           PERFORM GNS-FIO-MSG.                                         
           IF FIO-STAT-OKS AND MSG-IND-VIGE NOT = 'N'                   
               GO TO FIN-GET-MSG.                                       
           IF MSG-COD-SIST NOT = SCR-SIST                               
               MOVE MSG-COD-SIST TO FIO-SIST                            
               MOVE FIO-GET-KEY TO FIO-CMND                             
               PERFORM GNS-FIO-MSG.                                     
           IF NOT FIO-STAT-OKS                                          
               MOVE MSG-COD-MENS           TO MSG-GLS-DES1              
               MOVE ' MENSAJE INEXISTENTE' TO MSG-GLS-DES2              
           ELSE                                                         
               IF MSG-IND-VIGE = 'N'                                    
                   MOVE MSG-COD-MENS          TO MSG-GLS-DES1           
                   MOVE ' MENSAJE NO VIGENTE' TO MSG-GLS-DES2.          
       FIN-GET-MSG.                                                     
           EXIT.                                                        