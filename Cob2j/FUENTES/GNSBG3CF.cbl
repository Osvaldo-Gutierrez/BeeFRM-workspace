      * MODULO FRM                                                      
      * PROCESA INTERFACES BMS Y PTC V31                                
      *                                                                 
       GNS-PRO-FRM SECTION.                                             
       INI-GNS-PRO-FRM.                                                 
           IF FRM-IHDL NOT > SPACES                                     
               MOVE 'N' TO FRM-IHDL.                                     
      *         EXEC CICS HANDLE AID                                     
      *               CLEAR    (ACL-GNS-PRO-FRM)                         
      *               PA1      (PA1-GNS-PRO-FRM)                         
      *               PA2      (PA2-GNS-PRO-FRM)                         
      *         END-EXEC.                             
           GO TO IFR-GNS-PRO-FRM GTA-GNS-PRO-FRM PTA-GNS-PRO-FRM        
                 CLA-GNS-PRO-FRM MSG-GNS-PRO-FRM RCV-GNS-PRO-FRM        
                 CLF-GNS-PRO-FRM                                        
           DEPENDING ON FRM-CMND.                                       
           MOVE 'ABORTO, comando invalido en GNS-PRO-FRM:' TO SYS-MEN1. 
           MOVE FRM-CMND                                   TO SYS-MEN2. 
           GO TO ABT-GNS-PRO-SYS.                                       
      *Inicializa Formulario                                            
       IFR-GNS-PRO-FRM.                                                 
           IF SCR-OFRM-SRV AND FRM-SUAR = FRM-SUAR-MAL                  
               MOVE 'S' TO SCR-IERR.                                    


           IF NOT SCR-OFRM-SRV
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
              MOVE FRM-DFLD         TO FRM-AUXI                                
              MOVE MSG-COD-MENS     TO FRM-COD-MENS                        
              MOVE FRM-MENS         TO FRM-GLS-MENS                        
              MOVE FRM-AUXI         TO FRM-DATA                            
              MOVE FRM-NAME         TO FRM-NAME-IDEN                           
              MOVE FRM-DFLD         TO QUE-DATA                                
              MOVE QUE-PUT          TO QUE-CMND                                
              PERFORM GNS-PRO-QUE                                      
              MOVE SCR-OTRN         TO QUE-TERM                                
              MOVE SCR-VARI         TO DFHCOMMAREA                                                                                                 
              MOVE 'TSO'            TO QUE-TYPE                                
              MOVE QUE-PUT          TO QUE-CMND                                
              PERFORM GNS-PRO-QUE                                      
              MOVE SPACES           TO SYS-SCR-NTRN
              MOVE SYS-NTRN         TO SYS-SCR-NTRN 
              MOVE SYS-TCMA         TO LEN
              SET TPSUCCESS         TO TRUE
              CALL "TPRETURN" USING TPSVCRET-REC
                                 TPTYPE-REC
                                 DFHCOMMAREA
                                 TPSTATUS-REC                                                                                                         
              GOBACK.                                                             

       FIN-IFR-GNS-PRO-FRM.                                             
           GO TO FIN-GNS-PRO-FRM.                                       
      *Recibe todos ( all ) los campos del formulario y unifica teclas  
       GTA-GNS-PRO-FRM.                                                 

           MOVE TSK-TERM-ALF     TO QUE-TERM.                                
           MOVE 'TSI'            TO QUE-TYPE.                                
           MOVE 1                TO QUE-NITM                                
           MOVE +2014            TO QUE-LITM.                                
           MOVE QUE-GET          TO QUE-CMND.                                 
           PERFORM GNS-PRO-QUE.                                      
           IF QUE-STAT = QUE-STAT-OKS                               
               MOVE QUE-DATA     TO FRM-DFLD                            
           ELSE                                                     
               MOVE SPACES       TO FRM-DFLD.                              

           IF SCR-OFRM-SRV
              MOVE TSK-TERM-ALF     TO QUE-TERM
              MOVE 'TPF'            TO QUE-TYPE
              MOVE 1                TO QUE-NITM                                
              MOVE +1               TO QUE-LITM                                
              MOVE QUE-GET          TO QUE-CMND                                 
              PERFORM GNS-PRO-QUE                                      
              IF QUE-STAT = QUE-STAT-OKS                               
                 MOVE QUE-DATA     TO EIBAID
                 MOVE QUE-DATA     TO FRM-FFLD                        
              ELSE                                                     
                 MOVE FRM-FFLD-RET TO EIBAID                       
                 MOVE FRM-FFLD-RET TO FRM-FFLD.                       

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
       FIN-GTA-GNS-PRO-FRM.                                             
           GO TO FIN-GNS-PRO-FRM.                                       
      *Despliega todos los campos de un formulario                      
       PTA-GNS-PRO-FRM. 

           IF NOT SCR-OFRM-SRV
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
              MOVE FRM-DFLD         TO FRM-AUXI                                
              MOVE MSG-COD-MENS     TO FRM-COD-MENS                        
              MOVE FRM-MENS         TO FRM-GLS-MENS                        
              MOVE FRM-AUXI         TO FRM-DATA                            
              MOVE FRM-NAME         TO FRM-NAME-IDEN                           
              MOVE FRM-DFLD         TO QUE-DATA                           
              MOVE QUE-PUT          TO QUE-CMND                           
              PERFORM GNS-PRO-QUE                                      
              MOVE SCR-VARI         TO DFHCOMMAREA
              MOVE 'TSO'            TO QUE-TYPE
              MOVE QUE-PUT          TO QUE-CMND
              PERFORM GNS-PRO-QUE  
              SET TPSUCCESS         TO TRUE
              MOVE +3500            TO LEN              
              CALL "TPRETURN" USING TPSVCRET-REC
                                 TPTYPE-REC
                                 DFHCOMMAREA
      *                           SYS-CMMA
                                 TPSTATUS-REC                                                                                                         
              GOBACK.                                                             
              
           
       FIN-PTA-GNS-PRO-FRM.                                             
           GO TO FIN-GNS-PRO-FRM.                                       
      *Limpia todos los campos de un formulario                         
       CLA-GNS-PRO-FRM.                                                 
           IF NOT SCR-OFRM-SRV
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

       FIN-CLA-GNS-PRO-FRM.                                             
           GO TO FIN-GNS-PRO-FRM.                                       
      *Despliega un mensaje en pantalla                                 
       MSG-GNS-PRO-FRM.                                                 
      *     EXEC CICS SEND                                               
      *               FROM(FRM-MENS)                                     
      *               LENGTH(79)                                         
      *     END-EXEC.                                                    
       FIN-MSG-GNS-PRO-FRM.                                             
           GO TO FIN-GNS-PRO-FRM.                                       
      *Recibe toda la pantalla                                          
       RCV-GNS-PRO-FRM.                                                 
           IF SCR-OFRM-SRV
              GO TO FIN-RCV-GNS-PRO-FRM.                                             

           MOVE TSK-TERM-ALF     TO QUE-TERM                                
           MOVE 'TSI'            TO QUE-TYPE                                
           MOVE 1                TO QUE-NITM                               
           MOVE +2014            TO QUE-LITM                                
           MOVE QUE-GET          TO QUE-CMND                                 
           PERFORM GNS-PRO-QUE                                      
           IF QUE-STAT = QUE-STAT-OKS                               
              MOVE QUE-DATA      TO FRM-DFLD                            
           ELSE                                                     
              MOVE SPACES        TO FRM-DFLD.                              

           MOVE TSK-TERM-ALF     TO QUE-TERM.
           MOVE 'TPF'            TO QUE-TYPE.
           MOVE 1                TO QUE-NITM                                
           MOVE +1               TO QUE-LITM.                                
           MOVE QUE-GET          TO QUE-CMND.                                 
           PERFORM GNS-PRO-QUE.                                      
           IF QUE-STAT = QUE-STAT-OKS 
               MOVE QUE-DATA     TO EIBAID
               MOVE QUE-DATA     TO FRM-FFLD                        
           ELSE                                                     
               MOVE FRM-FFLD-RET TO EIBAID                       
               MOVE FRM-FFLD-RET TO FRM-FFLD.                       

       FIN-RCV-GNS-PRO-FRM.                                             
           GO TO FIN-GNS-PRO-FRM.                                       
      *Limpia pantalla desde linea de inicio ( PLIN ) n lineas ( NLIN ) 
       CLF-GNS-PRO-FRM.                                                 
      *ISP-PTC-PTC                                                      
      *     IF NOT SCR-OFRM-SRV                                          
      *     IF FRM-PLIN = 1 AND ( FRM-NLIN = 24 OR FRM-NLIN = 0 )        
      *         EXEC CICS SEND                                           
      *                   CONTROL ERASE                                  
      *         END-EXEC                                                 
      *     ELSE                                                         
      *         COMPUTE FRM-PCUR = 80 * ( FRM-PLIN - 1 )                 
      *         COMPUTE FRM-TFLD = 80 * FRM-NLIN                         
      *         MOVE LOW-VALUES TO FRM-DFLD                              
      *         EXEC CICS SEND                                           
      *                   CONTROL CURSOR(FRM-PCUR)                       
      *         END-EXEC                                                 
      *         EXEC CICS SEND                                           
      *                   FROM(FRM-DFLD)                                 
      *                   LENGTH(FRM-TFLD)                               
      *         END-EXEC.                                                
       FIN-CLF-GNS-PRO-FRM.                                             
           GO TO FIN-GNS-PRO-FRM.                                       
                                                                        
       ACL-GNS-PRO-FRM.                                                 
      *     EXEC CICS XCTL                                               
      *               PROGRAM('GNSPPCLR')                                
      *     END-EXEC.                                                    
      *     EXEC CICS RETURN END-EXEC.                                   
       PA1-GNS-PRO-FRM.                                                 
           MOVE FRM-FFLD-PA1 TO FRM-FFLD.                               
           GO TO FIN-GNS-PRO-FRM.                                       
       PA2-GNS-PRO-FRM.                                                 
           MOVE FRM-FFLD-PA2 TO FRM-FFLD.                               
           GO TO FIN-GNS-PRO-FRM.                                       
       FIN-GNS-PRO-FRM.                                                 
           EXIT.                                                        
