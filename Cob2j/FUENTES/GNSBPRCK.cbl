       GNS-PRO-RCK SECTION.                                             
       INI-GNS-PRO-RCK.                                                 

      *INI TUXEDO
           MOVE TSK-TERM-ALF     TO QUE-TERM.
           MOVE 'TPF'            TO QUE-TYPE.
           MOVE 1                TO QUE-NITM                                
           MOVE +1               TO QUE-LITM.                                
           MOVE QUE-GET          TO QUE-CMND.                                 
           PERFORM GNS-PRO-QUE.                                      
           IF QUE-STAT = QUE-STAT-OKS   
               MOVE QUE-DATA     TO EIBAID
           ELSE  
               MOVE FRM-FFLD-RET TO EIBAID.                       
      *FIN TUXEDO


           MOVE EIBAID    TO FRM-FFLD.  
           MOVE 'GNSPPPK' TO SYS-PROG.                                  
           IF FRM-FFLD = FRM-FFLD-PFA   
               MOVE FRM-FFLD-PF1 TO FRM-FFLD                            
           ELSE                                                         
           IF FRM-FFLD = FRM-FFLD-PFB                                   
               MOVE FRM-FFLD-PF2 TO FRM-FFLD                            
           ELSE                                                         
           IF FRM-FFLD = FRM-FFLD-PFC                                   
               MOVE FRM-FFLD-PF3 TO FRM-FFLD                            
               MOVE 'ABT' TO FRM-STAT                                   
               GO TO FIN-GNS-PRO-RCK                                    
           ELSE                                                         
           IF FRM-FFLD = FRM-FFLD-PFD                                   
               MOVE FRM-FFLD-PF4 TO FRM-FFLD                            
               GO TO FIN-GNS-PRO-RCK                                    
           ELSE                                                         
           IF FRM-FFLD = FRM-FFLD-PFE                                   
               MOVE FRM-FFLD-PF5 TO FRM-FFLD                            
               GO TO FIN-GNS-PRO-RCK                                    
           ELSE                                                         
           IF FRM-FFLD = FRM-FFLD-PFF                                   
               MOVE FRM-FFLD-PF6 TO FRM-FFLD                            
               GO TO FIN-GNS-PRO-RCK                                    
           ELSE                                                         
           IF FRM-FFLD = FRM-FFLD-PFG                                   
               MOVE FRM-FFLD-PF7 TO FRM-FFLD                            
               GO TO FIN-GNS-PRO-RCK                                    
           ELSE                                                         
           IF FRM-FFLD = FRM-FFLD-PFH                                   
               MOVE FRM-FFLD-PF8 TO FRM-FFLD                            
               GO TO FIN-GNS-PRO-RCK                                    
           ELSE                                                         
           IF FRM-FFLD = FRM-FFLD-PFI                                   
               MOVE FRM-FFLD-PF9 TO FRM-FFLD                            
           ELSE                                                         
           IF FRM-FFLD = FRM-FFLD-PFJ                                   
               MOVE FRM-FFLD-PF10 TO FRM-FFLD                           
               GO TO FIN-GNS-PRO-RCK                                    
           ELSE                                                         
           IF FRM-FFLD = FRM-FFLD-PFK                                   
               MOVE FRM-FFLD-PF11 TO FRM-FFLD                           
           ELSE                                                         
           IF FRM-FFLD = FRM-FFLD-PFL                                   
               MOVE FRM-FFLD-PF12 TO FRM-FFLD                           
               MOVE 'ABT' TO FRM-STAT                                   
               GO TO FIN-GNS-PRO-RCK.                                   
      *                                                                 
           IF ( FRM-FFLD NOT < FRM-FFLD-PF1 ) AND                       
              ( FRM-FFLD NOT > FRM-FFLD-PF9 )                           
               MOVE FRM-FFLD TO SYS-PROG-RED(8)                         
           ELSE                                                         
           IF FRM-FFLD = FRM-FFLD-PF11                                  
               MOVE 'B' TO SYS-PROG-RED(8)                              
           ELSE                                                         
           IF FRM-FFLD = FRM-FFLD-PA1                                   
               MOVE 'D' TO SYS-PROG-RED(8)                              
           ELSE                                                         
           IF FRM-FFLD = FRM-FFLD-PA2                                   
               MOVE 'E' TO SYS-PROG-RED(8)                              
           ELSE                                                         
           IF FRM-FFLD = FRM-FFLD-PA3                                   
               MOVE 'F' TO SYS-PROG-RED(8)                              
           ELSE                                                         
               GO TO FIN-GNS-PRO-RCK.                                   
      *EXEC CICS HANDLE CONDITION                                       
      *          PGMIDERR (FIN-GNS-PRO-RCK)                             
      *END-EXEC.                                                        
           MOVE DFHCOMMAREA(1:EIBCALEN) TO SYS-CMMA.                    
           MOVE EIBCALEN    TO SYS-TCMA.                                
           MOVE SYS-XCTL    TO SYS-CMND.                                
           PERFORM GNS-PRO-SYS.                                         
       FIN-GNS-PRO-RCK.                                                 
           EXIT.                                                        
