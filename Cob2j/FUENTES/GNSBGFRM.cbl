      ********************* FRM *********************                   
      * V 2.0 SIN PTC                                                   
       GNS-PRO-FRM SECTION.                                             
       INI-GNS-PRO-FRM.                                                 
           GO TO CIC-FRM-INIT CIC-FRM-GETA CIC-FRM-PUTA CIC-FRM-CLRA    
                 CIC-FRM-EXIT CIC-FRM-XCTL CIC-FRM-MSGD CIC-FRM-RCEV    
                 CIC-FRM-FCLR CIC-FRM-FABT CIC-FRM-LINK                 
           DEPENDING ON FRM-CMND.                                       
           MOVE 'ABORTO: COMANDO INVALIDO EN GNS-PRO-FRM ' TO FRM-MEN1. 
           MOVE FRM-CMND                                   TO FRM-MEN2. 
           GO TO CIC-FRM-FABT.                                          
       CIC-FRM-INIT.                                                    
           IF FRM-SINI = FRM-SINI-MB1F OR FRM-SINI-DB1F                 
      *EXEC CICS SEND                                                   
      *          MAP(FRM-NAME)                                          
      *          MAPSET(FRM-NLIB)                                       
      *          FROM(FRM-DFLD) CURSOR                                  
      *          ERASE                                                  
      *END-EXEC                                                         
              MOVE TSK-TERM-ALF     TO QUE-TERM                                
              MOVE 'TSI'            TO QUE-TYPE                                
              MOVE 1                TO QUE-NITM                                
              MOVE +2014            TO QUE-LITM                                
              MOVE QUE-DEL          TO QUE-CMND                                
              PERFORM GNS-PRO-QUE                                      
              MOVE TSK-TERM-ALF     TO QUE-TERM                                
              MOVE 'TSI'            TO QUE-TYPE                                
              MOVE 1                TO QUE-NITM                                
              MOVE +2014            TO QUE-LITM                                
              MOVE FRM-DFLD         TO QUE-DATA                                
              MOVE QUE-PUT          TO QUE-CMND                                
              PERFORM GNS-PRO-QUE                                      
                                                                        
           ELSE                                                         
           IF FRM-SINI = FRM-SINI-MBNF OR FRM-SINI-DBNF                 
      *EXEC CICS SEND                                                   
      *          MAP(FRM-NAME)                                          
      *          MAPSET(FRM-NLIB)                                       
      *          FROM(FRM-DFLD) CURSOR                                  
      *END-EXEC                                                         
              MOVE TSK-TERM-ALF     TO QUE-TERM                                
              MOVE 'TSI'            TO QUE-TYPE                                
              MOVE 1                TO QUE-NITM                                
              MOVE +2014            TO QUE-LITM                                
              MOVE QUE-DEL          TO QUE-CMND                                
              PERFORM GNS-PRO-QUE                                      
              MOVE TSK-TERM-ALF     TO QUE-TERM                                
              MOVE 'TSI'            TO QUE-TYPE                                
              MOVE 1                TO QUE-NITM                                
              MOVE +2014            TO QUE-LITM                                
              MOVE FRM-DFLD         TO QUE-DATA                                
              MOVE QUE-PUT          TO QUE-CMND                                
              PERFORM GNS-PRO-QUE                                      
           ELSE                                                         
      *EXEC CICS SEND                                                   
      *          MAP(FRM-NAME)                                          
      *          MAPSET(FRM-NLIB)                                       
      *          CURSOR                                                 
      *          MAPONLY                                                
      *END-EXEC.                                                        
              MOVE TSK-TERM-ALF     TO QUE-TERM                                
              MOVE 'TSI'            TO QUE-TYPE                                
              MOVE 1                TO QUE-NITM                                
              MOVE +2014            TO QUE-LITM                                
              MOVE QUE-DEL          TO QUE-CMND                                
              PERFORM GNS-PRO-QUE                                      
              MOVE TSK-TERM-ALF     TO QUE-TERM                                
              MOVE 'TSI'            TO QUE-TYPE                                
              MOVE 1                TO QUE-NITM                                
              MOVE +2014            TO QUE-LITM                                
              MOVE FRM-DFLD         TO QUE-DATA                                
              MOVE QUE-PUT          TO QUE-CMND                                
              PERFORM GNS-PRO-QUE.                                      
                                                                        
       FIN-CIC-FRM-INIT.                                                
           GO TO FIN-GNS-PRO-FRM.                                       
       CIC-FRM-GETA.                                                    
      *EXEC CICS RECEIVE                                                
      *          MAP(FRM-NAME)                                          
      *          MAPSET(FRM-NLIB)                                       
      *          INTO(FRM-DFLD)                                         
      *END-EXEC.                                                        
           MOVE TSK-TERM-ALF     TO QUE-TERM.                                
           MOVE 'TSI'            TO QUE-TYPE.                                
           MOVE 1                TO QUE-NITM                                
           MOVE +2014            TO QUE-LITM.                                
           MOVE QUE-GET          TO QUE-CMND.                                 
           PERFORM GNS-PRO-QUE.                                      
           IF QUE-STAT = QUE-STAT-OKS                               
               MOVE QUE-DATA TO FRM-DFLD                            
               MOVE FRM-FFLD-RET TO FRM-FFLD                        
           ELSE                                                     
               MOVE SPACES TO FRM-DFLD                              
               MOVE FRM-FFLD-RET TO FRM-FFLD.                       
                                                                        
                                                                        
           MOVE EIBAID TO FRM-FFLD.                                     
           IF FRM-FFLD = FRM-FFLD-PFA                                   
               MOVE FRM-FFLD-PF1 TO FRM-FFLD                            
           ELSE                                                         
           IF FRM-FFLD = FRM-FFLD-PFB                                   
               MOVE FRM-FFLD-PF2 TO FRM-FFLD                            
           ELSE                                                         
           IF FRM-FFLD = FRM-FFLD-PFC                                   
               MOVE FRM-FFLD-PF3 TO FRM-FFLD                            
           ELSE                                                         
           IF FRM-FFLD = FRM-FFLD-PFD                                   
               MOVE FRM-FFLD-PF4 TO FRM-FFLD                            
           ELSE                                                         
           IF FRM-FFLD = FRM-FFLD-PFE                                   
               MOVE FRM-FFLD-PF5 TO FRM-FFLD                            
           ELSE                                                         
           IF FRM-FFLD = FRM-FFLD-PFF                                   
               MOVE FRM-FFLD-PF6 TO FRM-FFLD                            
           ELSE                                                         
           IF FRM-FFLD = FRM-FFLD-PFG                                   
               MOVE FRM-FFLD-PF7 TO FRM-FFLD                            
           ELSE                                                         
           IF FRM-FFLD = FRM-FFLD-PFH                                   
               MOVE FRM-FFLD-PF8 TO FRM-FFLD                            
           ELSE                                                         
           IF FRM-FFLD = FRM-FFLD-PFI                                   
               MOVE FRM-FFLD-PF9 TO FRM-FFLD                            
           ELSE                                                         
           IF FRM-FFLD = FRM-FFLD-PFJ                                   
               MOVE FRM-FFLD-PF10 TO FRM-FFLD                           
           ELSE                                                         
           IF FRM-FFLD = FRM-FFLD-PFK                                   
               MOVE FRM-FFLD-PF11 TO FRM-FFLD                           
           ELSE                                                         
           IF FRM-FFLD = FRM-FFLD-PFL                                   
               MOVE FRM-FFLD-PF12 TO FRM-FFLD.                          
           IF FRM-FFLD = FRM-FFLD-PF3  OR FRM-FFLD-PF12                 
               MOVE 'ABT' TO FRM-STAT.                                  
       FIN-CIC-FRM-GETA.                                                
           GO TO FIN-GNS-PRO-FRM.                                       
       CIC-FRM-PUTA.                                                    
      *EXEC CICS SEND                                                   
      *          MAP(FRM-NAME)                                          
      *          MAPSET(FRM-NLIB)                                       
      *          FROM(FRM-DFLD) CURSOR                                  
      *          DATAONLY                                               
      *END-EXEC.                                                        
              MOVE TSK-TERM-ALF     TO QUE-TERM                                
              MOVE 'TSI'            TO QUE-TYPE                                
              MOVE 1                TO QUE-NITM                                
              MOVE +2014            TO QUE-LITM                                
              MOVE QUE-DEL          TO QUE-CMND                                
              PERFORM GNS-PRO-QUE                                      
              MOVE TSK-TERM-ALF     TO QUE-TERM                                
              MOVE 'TSI'            TO QUE-TYPE                                
              MOVE 1                TO QUE-NITM                                
              MOVE +2014            TO QUE-LITM                                
              MOVE FRM-DFLD         TO QUE-DATA                                
              MOVE QUE-PUT          TO QUE-CMND                                
              PERFORM GNS-PRO-QUE.                                      
                                                                        
       FIN-CIC-FRM-PUTA.                                                
           GO TO FIN-GNS-PRO-FRM.                                       
       CIC-FRM-CLRA.                                                    
      *EXEC CICS SEND                                                   
      *          MAP(FRM-NAME)                                          
      *          MAPSET(FRM-NLIB)                                       
      *          FROM(FRM-DFLD) CURSOR                                  
      *          DATAONLY                                               
      *          ERASEAUP                                               
      *END-EXEC.                                                        
              MOVE TSK-TERM-ALF     TO QUE-TERM                                
              MOVE 'TSI'            TO QUE-TYPE                                
              MOVE 1                TO QUE-NITM                                
              MOVE +2014            TO QUE-LITM                                
              MOVE QUE-DEL          TO QUE-CMND                                
              PERFORM GNS-PRO-QUE                                      
              MOVE TSK-TERM-ALF     TO QUE-TERM                                
              MOVE 'TSI'            TO QUE-TYPE                                
              MOVE 1                TO QUE-NITM                                
              MOVE +2014            TO QUE-LITM                                
              MOVE FRM-DFLD         TO QUE-DATA                                
              MOVE QUE-PUT          TO QUE-CMND                                
              PERFORM GNS-PRO-QUE.                                      
                                                                        
                                                                        
       FIN-CIC-FRM-CLRA.                                                
           GO TO FIN-GNS-PRO-FRM.                                       
       CIC-FRM-EXIT.                                                    
      *EXEC CICS RETURN                                                 
      *          TRANSID(FRM-NTRN)                                      
      *          COMMAREA(FRM-CMMA)                                     
      *          LENGTH(FRM-TCMA)                                       
      *END-EXEC.                                                        

           MOVE SPACES   TO SYS-SCR-NTRN.
           MOVE FRM-NTRN TO SYS-SCR-NTRN. 
           MOVE FRM-TCMA TO LEN.
           SET TPSUCCESS TO TRUE.
           CALL "TPRETURN" USING TPSVCRET-REC
                                 TPTYPE-REC
                                 FRM-CMMA
                                 TPSTATUS-REC.
           GOBACK.                                                             
                                                                        
       FIN-CIC-FRM-EXIT.                                                
           GO TO FIN-GNS-PRO-FRM.                                       
       CIC-FRM-XCTL.                                                    
      *EXEC CICS XCTL                                                   
      *          PROGRAM(FRM-PROG)                                      
      *          COMMAREA(FRM-CMMA)                                     
      *          LENGTH(FRM-TCMA)                                       
      *END-EXEC.                                                        

           MOVE SPACES   TO SYS-SCR-NTRN.
           MOVE FRM-TCMA   TO LEN.
           MOVE "CARRAY"   TO REC-TYPE.
           MOVE FRM-PROG   TO SERVICE-NAME.
           CALL "TPFORWARD" USING TPSVCDEF-REC
                                  TPTYPE-REC
                                  FRM-CMMA
                                  TPSTATUS-REC.
           GOBACK.                                                             
                                                                                                                                                                                 
       FIN-CIC-FRM-XCTL.                                                
           GO TO FIN-GNS-PRO-FRM.                                       
       CIC-FRM-MSGD.                                                    
      *EXEC CICS SEND                                                   
      *          FROM(FRM-MENS)                                         
      *          LENGTH(79)                                             
      *END-EXEC.                                                        

       FIN-CIC-FRM-MSGD.                                                
           GO TO FIN-GNS-PRO-FRM.                                       
       CIC-FRM-RCEV.                                                    
      *EXEC CICS RECEIVE                                                
      *          INTO(FRM-DFLD)                                         
      *          LENGTH(FRM-LFLD)                                       
      *END-EXEC.                                                        
           MOVE TSK-TERM-ALF     TO QUE-TERM.                                
           MOVE 'TSI'            TO QUE-TYPE.                                
           MOVE 1                TO QUE-NITM                                
           MOVE +2014            TO QUE-LITM.                                
           MOVE QUE-GET          TO QUE-CMND.                                 
           PERFORM GNS-PRO-QUE.                                      
           IF QUE-STAT = QUE-STAT-OKS                               
               MOVE QUE-DATA TO FRM-DFLD                            
               MOVE FRM-FFLD-RET TO FRM-FFLD                        
           ELSE                                                     
               MOVE SPACES TO FRM-DFLD                              
               MOVE FRM-FFLD-RET TO FRM-FFLD.                       
                                                                        
                                                                        
                                                                        
       FIN-CIC-FRM-RCEV.                                                
           GO TO FIN-GNS-PRO-FRM.                                       
       CIC-FRM-FCLR.                                                    
                                                                        
       FIN-CIC-FRM-FCLR.                                                
           GO TO FIN-GNS-PRO-FRM.                                       
       CIC-FRM-FABT.                                                    
           MOVE SYS-PABT TO FRM-PROG.                                   
           MOVE +3500    TO FRM-TCMA.                                   
           MOVE FRM-MENS TO FRM-SCR-MENS.                               
           MOVE SCR-VARI TO FRM-SCR-VARI.                               
      *EXEC CICS XCTL                                                   
      *          PROGRAM(FRM-PROG)                                      
      *          COMMAREA(FRM-CMMA)                                     
      *          LENGTH(FRM-TCMA)                                       
      *END-EXEC.                                                        
           MOVE FRM-TCMA   TO LEN.
           MOVE "CARRAY"   TO REC-TYPE.
           MOVE FRM-PROG   TO SERVICE-NAME.
           CALL "TPFORWARD" USING TPSVCDEF-REC
                                  TPTYPE-REC
                                  FRM-CMMA
                                  TPSTATUS-REC.
                                                                        
                                                                        
                                                                        
       FIN-CIC-FRM-FABT.                                                
           GO TO FIN-GNS-PRO-FRM.                                       
       CIC-FRM-LINK.                                                    
      *EXEC CICS LINK                                                   
      *          PROGRAM(FRM-PROG)                                      
      *          COMMAREA(FRM-CMMA)                                     
      *          LENGTH(FRM-TCMA)                                       
      *END-EXEC.                                                        
           MOVE SPACES   TO SYS-SCR-NTRN.
           MOVE FRM-TCMA   TO LEN.
           MOVE "CARRAY"   TO REC-TYPE.
           MOVE FRM-PROG   TO SERVICE-NAME.
           CALL "TPCALL" USING TPSVCDEF-REC 
                               TPTYPE-REC 
                               FRM-CMMA
                               TPTYPE-REC 
                               FRM-CMMA
                               TPSTATUS-REC. 
                                                                        
                                                                        
                                                                        
       FIN-CIC-FRM-LINK.                                                
           GO TO FIN-GNS-PRO-FRM.                                       
       FIN-GNS-PRO-FRM.                                                 
           EXIT.                                                        