      * Modulo para Proceso de Fechas y Hora                            
      * 24-MAY-1989 20:21:31                                            
       CAL-FEC SECTION.                                                 
       INI-CAL-FEC.                                                     
           MOVE FEC-SOKS TO FEC-STT1                                    
                            FEC-STT2.                                   
           MOVE SPACES TO MSG-COD-MENS IN MSG.                          
           IF FEC-CMND = FEC-CMP-HOY                                    
               PERFORM FEC-COMP-HOY                                     
               GO TO MSG-CAL-FEC.                                       
           IF FEC-CMND = FEC-RET-JUL                                    
               PERFORM FEC-EXT-SLSH                                     
               PERFORM FEC-TRDC-FEC                                     
               PERFORM FEC-RTRN-JUL                                     
               GO TO MSG-CAL-FEC.                                       
           IF FEC-CMND = FEC-RET-FEC                                    
               PERFORM FEC-RTRN-FEC                                     
               GO TO MSG-CAL-FEC.                                       
           IF FEC-CMND = FEC-SIG-HBL                                    
               PERFORM FEC-EXT-SLSH                                     
               PERFORM FEC-TRDC-FEC                                     
               PERFORM FEC-SIGU-HBL                                     
               GO TO MSG-CAL-FEC.                                       
      *MHM INI 24-0CT-2011 PENTA
           IF FEC-CMND = FEC-ANT-HBL                                    
               PERFORM FEC-EXT-SLSH                                     
               PERFORM FEC-TRDC-FEC                                     
               PERFORM FEC-ANTE-HBL                                     
               GO TO MSG-CAL-FEC.                                       
      *MHM FIN 24-0CT-2011 PENTA
           IF FEC-CMND = FEC-SUM-DIA                                    
               PERFORM FEC-EXT-SLSH                                     
               PERFORM FEC-TRDC-FEC                                     
               PERFORM FEC-SUMA-DIA                                     
               GO TO MSG-CAL-FEC.                                       
           IF FEC-CMND = FEC-SUM-MES                                    
               PERFORM FEC-EXT-SLSH                                     
               PERFORM FEC-TRDC-FEC                                     
               PERFORM FEC-SUMA-MES                                     
               GO TO MSG-CAL-FEC.                                       
           IF FEC-CMND = FEC-SUM-ANO                                    
               PERFORM FEC-EXT-SLSH                                     
               PERFORM FEC-TRDC-FEC                                     
               PERFORM FEC-SUMA-ANO                                     
               GO TO MSG-CAL-FEC.                                       
           IF FEC-CMND = FEC-RST-DIA                                    
               PERFORM FEC-EXT-SLSH                                     
               PERFORM FEC-TRDC-FEC                                     
               PERFORM FEC-REST-DIA                                     
               GO TO MSG-CAL-FEC.                                       
           IF FEC-CMND = FEC-RST-MES                                    
               PERFORM FEC-EXT-SLSH                                     
               PERFORM FEC-TRDC-FEC                                     
               PERFORM FEC-REST-MES                                     
               GO TO MSG-CAL-FEC.                                       
           IF FEC-CMND = FEC-RST-ANO                                    
               PERFORM FEC-EXT-SLSH                                     
               PERFORM FEC-TRDC-FEC                                     
               PERFORM FEC-REST-ANO                                     
               GO TO MSG-CAL-FEC.                                       
           IF FEC-CMND = FEC-DIF-DIA                                    
               PERFORM FEC-DIFF-DIA                                     
               GO TO MSG-CAL-FEC.                                       
           IF FEC-CMND = FEC-DIF-MES                                    
               PERFORM FEC-DIFF-MES                                     
               GO TO MSG-CAL-FEC.                                       
           IF FEC-CMND = FEC-DIF-ANO                                    
               PERFORM FEC-DIFF-ANO                                     
               GO TO MSG-CAL-FEC.                                       
       ERR-CAL-FEC.                                                     
           MOVE 'GNS'          TO MSG-COD-SIST.                         
           MOVE 'CALFEC CMDNX' TO MSG-COD-MENS IN MSG.                  
           PERFORM GET-MSG.                                             
           MOVE MSG-GLS-DESC IN MSG TO SYS-MEN1.                        
           MOVE FEC-CMND            TO SYS-MEN2.                        
           MOVE SYS-ABOR            TO SYS-CMND.                        
           PERFORM GNS-PRO-SYS.                                         
       MSG-CAL-FEC.                                                     
           IF MSG-COD-MENS > SPACES                                     
               MOVE 'GNS'     TO MSG-COD-SIST                           
               PERFORM GET-MSG                                          
               MOVE MSG-GLS-DESC IN MSG TO FEC-MENS                     
           ELSE                                                         
           IF NOT FEC-STAT-OKS                                          
               MOVE 'FECSTAT' TO MSG-COD-TMSG IN MSG                    
               MOVE FEC-STAT  TO MSG-COD-CMSG IN MSG                    
               MOVE 'GNS'     TO MSG-COD-SIST                           
               PERFORM GET-MSG                                          
               MOVE MSG-GLS-DESC IN MSG TO FEC-MENS                     
           ELSE                                                         
           IF ( FEC-CMND = FEC-VAL-FEC OR FEC-RET-FEC OR FEC-SIG-HBL OR 
                           FEC-SUM-DIA OR FEC-SUM-MES OR FEC-SUM-ANO OR 
                           FEC-RST-DIA OR FEC-RST-MES OR FEC-RST-ANO )  
              AND FEC-IEDT > SPACES                                     
               PERFORM FEC-PUT-SLSH.                                    
       FIN-CAL-FEC.                                                     
           EXIT.                                                        
                                                                        
       FEC-COMP-HOY SECTION.                                            
       INI-FEC-COMP-HOY.                                                
           PERFORM FEC-EXT-SLSH.                                        
           PERFORM FEC-TRDC-FEC.                                        
           MOVE FEC-DVLD TO FEC-DEC1.                                   
           MOVE FEC-MVLD TO FEC-MEC1.                                   
           MOVE FEC-SVLD TO FEC-SEC1.                                   
           MOVE FEC-AVLD TO FEC-AEC1.                                   
           PERFORM FEC-GDAT.                                            
           MOVE FEC-DHOY TO FEC-DEC2.                                   
           MOVE FEC-MHOY TO FEC-MEC2.                                   
           MOVE FEC-SHOY TO FEC-SEC2.                                   
           MOVE FEC-AHOY TO FEC-AEC2.                                   
           PERFORM CMP-FEC-COMP-FEC THRU FIN-FEC-COMP-FEC.              
       FIN-FEC-COMP-HOY.                                                
           EXIT.                                                        
                                                                        
       FEC-RTRN-FEC SECTION.                                            
       INI-FEC-RTRN-FEC.                                                
           MOVE FEC-FORM-FEC TO FEC-FORM.                               
           MOVE SPACES       TO FEC-FECH.                               
           DIVIDE FEC-FJUL BY 365 GIVING FEC-NANO REMAINDER FEC-NDIA.   
           COMPUTE FEC-NABI = FEC-NANO - ( FEC-BST1 - FEC-ANO1 ) + 3.   
           DIVIDE FEC-NABI BY 4 GIVING FEC-NABI REMAINDER FEC-REST.     
      *    IF FEC-NABI > 24                                             
      *        SUBTRACT 1 FROM FEC-NABI.                                
           IF FEC-NDIA NOT < FEC-NABI                                   
               SUBTRACT FEC-NABI FROM FEC-NDIA GIVING FEC-NDIA          
           ELSE                                                         
               SUBTRACT 1 FROM FEC-NANO                                 
               IF FEC-NANO = 0                                          
                   MOVE 0 TO FEC-NABI                                   
                   IF FEC-REST = 0                                      
                       COMPUTE FEC-NDIA = 366 + FEC-NDIA                
                   ELSE                                                 
                       COMPUTE FEC-NDIA = 365 + FEC-NDIA                
               ELSE                                                     
                   IF FEC-REST = 0                                      
                       COMPUTE FEC-NDIA = 366 - ( FEC-NABI - FEC-NDIA ) 
                   ELSE                                                 
                       COMPUTE FEC-NDIA = 365 - ( FEC-NABI - FEC-NDIA ).
           ADD FEC-ANO1 FEC-NANO GIVING FEC-FANO.                       
           IF FEC-NDIA = 0                                              
               SUBTRACT 1 FROM FEC-FANO                                 
               MOVE 31       TO FEC-ITM1                                
               MOVE 12       TO FEC-ITM2                                
               MOVE FEC-SVLD TO FEC-ITM3                                
               MOVE FEC-AVLD TO FEC-ITM4                                
           ELSE                                                         
               MOVE FEC-SVLD TO FEC-ITM3                                
               MOVE FEC-AVLD TO FEC-ITM4                                
               DIVIDE FEC-FANO BY 4 GIVING FEC-REST REMAINDER FEC-REST  
               MOVE 0 TO FEC-AUXI                                       
               PERFORM FEC-OBT-MES VARYING FEC-ITM2 FROM 1 BY 1         
                       UNTIL FEC-ITM2 > 12 OR FEC-AUXI = 1              
      *JSS    IF FEC-ITM2 < 12                                          
      *            SUBTRACT 1 FROM FEC-ITM2                             
      *        ELSE                                                     
      *            MOVE 12 TO FEC-ITM2.                                 
              IF FEC-ITM2 > 1                                           
                  SUBTRACT 1 FROM FEC-ITM2.                             
       FIN-FEC-RTRN-FEC.                                                
           EXIT.                                                        
                                                                        
       FEC-OBT-MES SECTION.                                             
       INI-FEC-OBT-MES.                                                 
           MOVE FEC-DACU( FEC-ITM2 ) TO FEC-FANO.                       
           IF FEC-REST NOT = 0 AND FEC-ITM2 > 1                         
               SUBTRACT 1 FROM FEC-FANO.                                
           IF FEC-NDIA NOT > FEC-FANO                                   
               MOVE 1 TO FEC-AUXI                                       
               IF FEC-ITM2 > 1                                          
                   SUBTRACT 1 FROM FEC-ITM2 GIVING FEC-SIND             
                   SUBTRACT FEC-DACU( FEC-SIND ) FROM FEC-NDIA          
                            GIVING FEC-ITM1                             
                   IF FEC-REST NOT = 0 AND FEC-ITM2 > 2                 
                       ADD 1 TO FEC-ITM1                                
                   ELSE                                                 
                       NEXT SENTENCE                                    
               ELSE                                                     
                   MOVE FEC-NDIA TO FEC-ITM1.                           
       FIN-FEC-OBT-MES.                                                 
           EXIT.                                                        
                                                                        
       FEC-SIGU-HBL SECTION.                                            
       INI-FEC-SIGU-HBL.                                                
           PERFORM FEC-RTRN-JUL.                                        
       LUP-FEC-SIGU-HBL.                                                
           ADD 1 TO FEC-FJUL.                                           
           PERFORM FEC-RTRN-FEC.                                        
           MOVE FEC-ITM1 TO FEC-DVLD.                                   
           MOVE FEC-ITM2 TO FEC-MVLD.                                   
           MOVE FEC-ITM3 TO FEC-SVLD.                                   
           MOVE FEC-ITM4 TO FEC-AVLD.                                   
           PERFORM FEC-VALD-HBL.                                        
           IF FEC-STAT = FEC-SFER                                       
               GO TO LUP-FEC-SIGU-HBL.                                  
       FIN-FEC-SIGU-HBL.                                                
           EXIT.                                                        
                                                                        
      *MHM INI 24-0CT-2011 PENTA
       FEC-ANTE-HBL SECTION.                                            
       INI-FEC-ANTE-HBL.                                                
           PERFORM FEC-RTRN-JUL.                                        
       LUP-FEC-ANTE-HBL.                                                
           SUBTRACT 1 FROM FEC-FJUL.                                           
           PERFORM FEC-RTRN-FEC.                                        
           MOVE FEC-ITM1 TO FEC-DVLD.                                   
           MOVE FEC-ITM2 TO FEC-MVLD.                                   
           MOVE FEC-ITM3 TO FEC-SVLD.                                   
           MOVE FEC-ITM4 TO FEC-AVLD.                                   
           PERFORM FEC-VALD-HBL.                                        
           IF FEC-STAT = FEC-SFER                                       
               GO TO LUP-FEC-ANTE-HBL.                                  
       FIN-FEC-ANTE-HBL.                                                
           EXIT.                                                        
      *MHM FIN 24-0CT-2011 PENTA

       FEC-SUMA-DIA SECTION.                                            
       INI-FEC-SUMA-DIA.                                                
           IF FEC-NDIA = 1                                              
               IF FEC-MVLD = 3 OR 5 OR 7 OR 8 OR 10 OR 12               
                   IF FEC-DVLD < 31                                     
                       ADD 1 TO FEC-DVLD                                
                       MOVE FEC-DVLD TO FEC-ITM1                        
                       MOVE FEC-MVLD TO FEC-ITM2                        
                       MOVE FEC-SVLD TO FEC-ITM3                        
                       MOVE FEC-AVLD TO FEC-ITM4                        
                       GO TO FIN-FEC-SUMA-DIA                           
                   ELSE                                                 
                       NEXT SENTENCE                                    
               ELSE                                                     
               IF FEC-MVLD = 1 OR 4 OR 6 OR 9 OR 11                     
                   IF FEC-DVLD < 30                                     
                       ADD 1 TO FEC-DVLD                                
                       MOVE FEC-DVLD TO FEC-ITM1                        
                       MOVE FEC-MVLD TO FEC-ITM2                        
                       MOVE FEC-SVLD TO FEC-ITM3                        
                       MOVE FEC-AVLD TO FEC-ITM4                        
                       GO TO FIN-FEC-SUMA-DIA                           
                   ELSE                                                 
                       NEXT SENTENCE                                    
               ELSE                                                     
                   IF FEC-DVLD < 28                                     
                       ADD 1 TO FEC-DVLD                                
                       MOVE FEC-DVLD TO FEC-ITM1                        
                       MOVE FEC-MVLD TO FEC-ITM2                        
                       MOVE FEC-SVLD TO FEC-ITM3                        
                       MOVE FEC-AVLD TO FEC-ITM4                        
                       GO TO FIN-FEC-SUMA-DIA.                          
           PERFORM FEC-RTRN-JUL.                                        
           ADD FEC-NDIA TO FEC-FJUL.                                    
           PERFORM FEC-RTRN-FEC.                                        
       FIN-FEC-SUMA-DIA.                                                
           EXIT.                                                        
                                                                        
       FEC-SUMA-MES SECTION.                                            
       INI-FEC-SUMA-MES.                                                
           DIVIDE FEC-NMES BY 12 GIVING FEC-NANO REMAINDER FEC-REST.    
           MOVE FEC-REST TO FEC-NMES.                                   
           ADD FEC-NANO TO FEC-FANO.                                    
           ADD FEC-REST TO FEC-FMES.                                    
           IF FEC-FMES > 12                                             
               ADD 1 TO FEC-FANO                                        
               SUBTRACT 12 FROM FEC-FMES.                               
           IF FEC-FDIA NOT < FEC-DMES(FEC-FMES)                         
               MOVE FEC-DMES(FEC-FMES) TO FEC-FDIA                      
               IF FEC-FMES = 2                                          
                   DIVIDE FEC-FANO BY 4 GIVING FEC-REST                 
                                        REMAINDER FEC-REST              
                   IF FEC-REST NOT = 0                                  
                       SUBTRACT 1 FROM FEC-FDIA.                        
           MOVE FEC-DVLD TO FEC-ITM1.                                   
           MOVE FEC-MVLD TO FEC-ITM2.                                   
           MOVE FEC-SVLD TO FEC-ITM3.                                   
           MOVE FEC-AVLD TO FEC-ITM4.                                   
       FIN-FEC-SUMA-MES.                                                
           EXIT.                                                        
                                                                        
       FEC-SUMA-ANO SECTION.                                            
       INI-FEC-SUMA-ANO.                                                
           ADD FEC-NANO TO FEC-FANO.                                    
      *JSS-INI 16-DEC-1998                                              
           IF FEC-MVLD = 2                                              
               DIVIDE FEC-FANO BY 4 GIVING FEC-REST REMAINDER FEC-REST  
               IF FEC-DVLD = 29 AND FEC-REST NOT = 0                    
                   MOVE 28 TO FEC-DVLD.                                 
      *JSS-FIN 16-DEC-1998                                              
           MOVE FEC-DVLD TO FEC-ITM1.                                   
           MOVE FEC-MVLD TO FEC-ITM2.                                   
           MOVE FEC-SVLD TO FEC-ITM3.                                   
           MOVE FEC-AVLD TO FEC-ITM4.                                   
       FIN-FEC-SUMA-ANO.                                                
           EXIT.                                                        
                                                                        
       FEC-REST-DIA SECTION.                                            
       INI-FEC-REST-DIA.                                                
           PERFORM FEC-RTRN-JUL.                                        
           SUBTRACT FEC-NDIA FROM FEC-FJUL.                             
           PERFORM FEC-RTRN-FEC.                                        
       FIN-FEC-REST-DIA.                                                
           EXIT.                                                        
                                                                        
       FEC-REST-MES SECTION.                                            
       INI-FEC-REST-MES.                                                
           DIVIDE FEC-NMES BY 12 GIVING FEC-NANO REMAINDER FEC-NMES.    
           SUBTRACT FEC-NANO FROM FEC-FANO.                             
           IF FEC-NMES < FEC-FMES                                       
               SUBTRACT FEC-NMES FROM FEC-FMES                          
           ELSE                                                         
               SUBTRACT 1        FROM FEC-FANO                          
               SUBTRACT FEC-FMES FROM FEC-NMES                          
               SUBTRACT FEC-NMES FROM 12 GIVING FEC-FMES.               
           IF FEC-FDIA > FEC-DMES(FEC-FMES)                             
               MOVE FEC-DMES(FEC-FMES) TO FEC-FDIA.                     
           IF FEC-FDIA = FEC-DMES(2) AND FEC-FMES = 2                   
               DIVIDE FEC-FANO BY 4 GIVING FEC-REST REMAINDER FEC-REST  
               IF FEC-REST NOT = 0                                      
                   SUBTRACT 1 FROM FEC-FDIA.                            
           MOVE FEC-DVLD TO FEC-ITM1.                                   
           MOVE FEC-MVLD TO FEC-ITM2.                                   
           MOVE FEC-SVLD TO FEC-ITM3.                                   
           MOVE FEC-AVLD TO FEC-ITM4.                                   
       FIN-FEC-REST-MES.                                                
           EXIT.                                                        
                                                                        
       FEC-REST-ANO SECTION.                                            
       INI-FEC-REST-ANO.                                                
           SUBTRACT FEC-NANO FROM FEC-FANO.                             
           IF FEC-FDIA = FEC-DMES(2) AND FEC-FMES = 2                   
               DIVIDE FEC-FANO BY 4 GIVING FEC-REST REMAINDER FEC-REST  
               IF FEC-REST NOT = 0                                      
                   SUBTRACT 1 FROM FEC-FDIA.                            
           MOVE FEC-DVLD TO FEC-ITM1.                                   
           MOVE FEC-MVLD TO FEC-ITM2.                                   
           MOVE FEC-SVLD TO FEC-ITM3.                                   
           MOVE FEC-AVLD TO FEC-ITM4.                                   
       FIN-FEC-REST-ANO.                                                
           EXIT.                                                        
                                                                        
       FEC-DIFF-DIA SECTION.                                            
       INI-FEC-DIFF-DIA.                                                
           PERFORM FEC-CMP-F12.                                         
           IF MSG-COD-MENS > SPACES                                     
               GO TO FIN-FEC-DIFF-DIA.                                  
                                                                        
           MOVE FEC-DEC1 TO FEC-DVLD.                                   
           MOVE FEC-MEC1 TO FEC-MVLD.                                   
           MOVE FEC-SEC1 TO FEC-SVLD.                                   
           MOVE FEC-AEC1 TO FEC-AVLD.                                   
           PERFORM FEC-RTRN-JUL.                                        
           MOVE FEC-FJUL TO FEC-XJUL.                                   
                                                                        
           MOVE FEC-DEC2 TO FEC-DVLD.                                   
           MOVE FEC-MEC2 TO FEC-MVLD.                                   
           MOVE FEC-SEC2 TO FEC-SVLD.                                   
           MOVE FEC-AEC2 TO FEC-AVLD.                                   
           PERFORM FEC-RTRN-JUL.                                        
                                                                        
           IF FEC-FJUL NOT < FEC-XJUL                                   
               SUBTRACT FEC-XJUL FROM FEC-FJUL GIVING FEC-NDIA          
           ELSE                                                         
               SUBTRACT FEC-FJUL FROM FEC-XJUL GIVING FEC-NDIA.         
       FIN-FEC-DIFF-DIA.                                                
           EXIT.                                                        
                                                                        
       FEC-DIFF-MES SECTION.                                            
       INI-FEC-DIFF-MES.                                                
           PERFORM FEC-CMP-F12.                                         
           IF MSG-COD-MENS > SPACES                                     
               GO TO FIN-FEC-DIFF-MES.                                  
           MOVE 0 TO FEC-NDIA.                                          
           IF FEC-MEC1 = 2                                              
               DIVIDE FEC-AEC1 BY 4 GIVING FEC-REST REMAINDER FEC-REST  
               IF FEC-REST = 0                                          
                   MOVE FEC-DMES(2) TO FEC-SIND                         
               ELSE                                                     
                   SUBTRACT 1 FROM FEC-DMES(2) GIVING FEC-SIND          
           ELSE                                                         
               MOVE FEC-DMES(FEC-MEC1) TO FEC-SIND.                     
           IF FEC-MEC2 = 2                                              
               DIVIDE FEC-AEC2 BY 4 GIVING FEC-REST REMAINDER FEC-REST  
               IF FEC-REST = 0                                          
                   MOVE FEC-DMES(2) TO FEC-REST                         
               ELSE                                                     
                   SUBTRACT 1 FROM FEC-DMES(2) GIVING FEC-REST          
           ELSE                                                         
               MOVE FEC-DMES(FEC-MEC2) TO FEC-REST.                     
                                                                        
           MOVE 0 TO FEC-NMES.                                          
           SUBTRACT FEC-FSA1 FROM FEC-FSA2 GIVING FEC-NANO.             
           IF FEC-NANO > 0                                              
               IF ( FEC-MEC2 < FEC-MEC1 ) OR                            
                  ( FEC-MEC2 = FEC-MEC1 AND FEC-DEC2 < FEC-DEC1 AND     
                    ( FEC-DEC1 NOT = FEC-SIND OR                        
                      FEC-DEC2 NOT = FEC-REST ) )                       
                   SUBTRACT 1 FROM FEC-NANO GIVING FEC-NANO.            
           IF ( FEC-MEC2 = FEC-MEC1 AND FEC-DEC1 = FEC-DEC2 )           
      *JSS-INI 16-DEC-1998                                              
                OR                                                      
              ( FEC-MEC1 = 2        AND FEC-MEC2 = 2 AND                
                FEC-DEC1 = FEC-SIND AND FEC-DEC2 = FEC-REST )           
      *JSS-FIN 16-DEC-1998                                              
               GO TO CPU-FEC-DIFF-MES.                                  
                                                                        
           IF FEC-MEC2 < FEC-MEC1                                       
               SUBTRACT FEC-MEC1 FROM 12 GIVING FEC-NMES                
               ADD FEC-MEC2 TO FEC-NMES                                 
           ELSE                                                         
           IF FEC-MEC2 > FEC-MEC1                                       
               SUBTRACT FEC-MEC1 FROM FEC-MEC2 GIVING FEC-NMES          
           ELSE                                                         
               IF FEC-DEC2 NOT < FEC-DEC1                               
                   MOVE 0 TO FEC-NMES                                   
               ELSE                                                     
                   IF FEC-FSA1 NOT = FEC-FSA2                           
                       SUBTRACT FEC-MEC1 FROM 12 GIVING FEC-NMES        
                       ADD FEC-MEC2 TO FEC-NMES                         
                   ELSE                                                 
                       MOVE 0 TO FEC-NMES.                              
                                                                        
       CPU-FEC-DIFF-MES.                                                
           COMPUTE FEC-NMES = FEC-NMES + ( FEC-NANO * 12 ).             
           IF FEC-DEC2 < FEC-DEC1 AND FEC-NMES > 0 AND                  
      *       ( FEC-DEC1 NOT = FEC-SIND OR FEC-DEC2 NOT = FEC-REST )    
              ( FEC-DEC2 NOT = FEC-REST )                               
               SUBTRACT 1 FROM FEC-NMES.                                
           IF ( FEC-DEC1 = FEC-SIND AND FEC-DEC2 = FEC-REST ) OR        
              ( FEC-DEC2 < FEC-DEC1 AND FEC-DEC2 = FEC-REST )           
               MOVE 0 TO FEC-NDIA                                       
               GO TO FIN-FEC-DIFF-MES.                                  
           IF FEC-DEC1 < FEC-DEC2                                       
               SUBTRACT FEC-DEC1 FROM FEC-DEC2 GIVING FEC-NDIA          
           ELSE                                                         
           IF FEC-DEC1 > FEC-DEC2                                       
               SUBTRACT FEC-DEC1 FROM FEC-SIND GIVING FEC-NDIA          
               ADD FEC-DEC2 TO FEC-NDIA.                                
       FIN-FEC-DIFF-MES.                                                
           EXIT.                                                        
                                                                        
       FEC-DIFF-ANO SECTION.                                            
       INI-FEC-DIFF-ANO.                                                
           PERFORM FEC-CMP-F12.                                         
           IF MSG-COD-MENS > SPACES                                     
               GO TO FIN-FEC-DIFF-ANO.                                  
      *JSS-INI 16-DEC-1998                                              
           IF FEC-MEC1 = 2                                              
               DIVIDE FEC-AEC1 BY 4 GIVING FEC-REST REMAINDER FEC-REST  
               IF FEC-REST = 0                                          
                   MOVE FEC-DMES(2) TO FEC-SIND                         
               ELSE                                                     
                   SUBTRACT 1 FROM FEC-DMES(2) GIVING FEC-SIND          
           ELSE                                                         
               MOVE FEC-DMES(FEC-MEC1) TO FEC-SIND.                     
           IF FEC-MEC2 = 2                                              
               DIVIDE FEC-AEC2 BY 4 GIVING FEC-REST REMAINDER FEC-REST  
               IF FEC-REST = 0                                          
                   MOVE FEC-DMES(2) TO FEC-REST                         
               ELSE                                                     
                   SUBTRACT 1 FROM FEC-DMES(2) GIVING FEC-REST          
           ELSE                                                         
               MOVE FEC-DMES(FEC-MEC2) TO FEC-REST.                     
      *JSS-FIN 16-DEC-1998                                              
           SUBTRACT FEC-FSA1 FROM FEC-FSA2 GIVING FEC-NANO.             
           IF FEC-NANO > 0                                              
               IF ( FEC-MEC2 < FEC-MEC1 ) OR                            
                  ( FEC-MEC2 = FEC-MEC1 AND FEC-DEC2 < FEC-DEC1         
      *JSS-INI 16-DEC-1998                                              
                  AND NOT                                               
                  ( FEC-MEC1 = 2 AND FEC-MEC2 = 2 AND                   
                    FEC-DEC1 = FEC-SIND AND FEC-DEC2 = FEC-REST ) )     
      *JSS-FIN 16-DEC-1998                                              
                   SUBTRACT 1 FROM FEC-NANO  GIVING FEC-NANO.           
       FIN-FEC-DIFF-ANO.                                                
           EXIT.                                                        
                                                                        
       FEC-CMP-F12 SECTION.                                             
       INI-FEC-CMP-F12.                                                 
           MOVE FEC-FEC1 TO FEC-FECH.                                   
           PERFORM FEC-EXT-SLSH.                                        
           PERFORM FEC-TRDC-FEC.                                        
           MOVE FEC-DVLD TO FEC-DEC1.                                   
           MOVE FEC-MVLD TO FEC-MEC1.                                   
           MOVE FEC-SVLD TO FEC-SEC1.                                   
           MOVE FEC-AVLD TO FEC-AEC1.                                   
                                                                        
           MOVE FEC-FEC2 TO FEC-FECH.                                   
           PERFORM FEC-EXT-SLSH.                                        
           PERFORM FEC-TRDC-FEC.                                        
           MOVE FEC-DVLD TO FEC-DEC2.                                   
           MOVE FEC-MVLD TO FEC-MEC2.                                   
           MOVE FEC-SVLD TO FEC-SEC2.                                   
           MOVE FEC-AVLD TO FEC-AEC2.                                   
                                                                        
           IF ( FEC-SEC1 > FEC-SEC2 )                         OR        
              ( FEC-SEC1 = FEC-SEC2 AND FEC-AEC1 > FEC-AEC2 ) OR        
              ( FEC-SEC1 = FEC-SEC2 AND FEC-AEC1 = FEC-AEC2 AND         
                FEC-MEC1 > FEC-MEC2 )                         OR        
              ( FEC-SEC1 = FEC-SEC2 AND FEC-AEC1 = FEC-AEC2 AND         
                FEC-MEC1 = FEC-MEC2 AND FEC-DEC1 > FEC-DEC2 )           
               MOVE '99' TO FEC-STAT                                    
               MOVE 'FECFEC1FEC2>' TO MSG-COD-MENS.                     
       FIN-FEC-CMP-F12.                                                 
           EXIT.                                                        
