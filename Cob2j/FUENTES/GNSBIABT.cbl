      * Modulo de Aborto Program  Interactivo                           
       PRG-ABT SECTION.                                                 
       INI-PRG-ABT.                                                     
           IF FRM-MENS > SPACES AND FIO-MENS NOT > SPACES               
               MOVE FRM-MENS TO FIO-MENS.                               
           MOVE FIO-MENS TO SYS-MENS.                                   
           MOVE SYS-ABOR TO SYS-CMND.                                   
           PERFORM GNS-PRO-SYS.                                         
       FIN-PRG-ABT.                                                     
           EXIT.                                                        
