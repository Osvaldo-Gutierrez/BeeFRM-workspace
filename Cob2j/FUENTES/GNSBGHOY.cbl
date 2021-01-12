      * Obtiene Fecha y Hora Actual                                     
       GET-FHOY SECTION.                                                
       INI-GET-FHOY.                                                    
           MOVE SYS-GET-DATE TO SYS-CMND.                               
           PERFORM GNS-PRO-SYS.                                         
           MOVE SYS-DHOY TO HOY-DHOY.                                   
           MOVE SYS-MHOY TO HOY-MHOY.                                   
           MOVE SYS-SHOY TO HOY-SHOY.                                   
           MOVE SYS-AHOY TO HOY-AHOY.                                   
           MOVE SYS-HHHY TO HOY-HHHY.                                   
           MOVE SYS-MMHY TO HOY-MMHY.                                   
           MOVE SYS-SSHY TO HOY-SSHY.                                   
       FIN-GET-FHOY.                                                    
           EXIT.                                                        
