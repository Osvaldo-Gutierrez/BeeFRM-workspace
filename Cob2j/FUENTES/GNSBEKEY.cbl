      * Error de Llave en programa interactivo                          
       ERR-KEY SECTION.                                                 
       INI-ERR-KEY.                                                     
           MOVE 'KEY    BLK' TO MSG-COD-MENS.                           
           MOVE 'GNS' TO MSG-COD-SIST.                                  
           PERFORM GET-MSG.                                             
           MOVE MSG-GLS-DESC TO FRM-MENS.                               
           MOVE FRM-SUAR-MAL TO FRM-SUAR.                               
       FIN-ERR-KEY.                                                     
           EXIT.                                                        
