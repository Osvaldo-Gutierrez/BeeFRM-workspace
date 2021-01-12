      * Procesa Digito Verificador                                      
       PRO-VRF SECTION.                                                 
       INI-PRO-VRF.                                                     
           MOVE SPACES TO MSG-COD-MENS.                                 
           MOVE ZEROES TO VRF-STAT.                                     
      *JSS                                                              
           IF VRF-NUME = ZEROES                                         
               IF VRF-ZERO = VRF-ZERO-N                                 
                   MOVE VRF-SBLK     TO VRF-STAT                        
                   MOVE 'NUM    BLK' TO MSG-COD-MENS                    
                   GO TO ERR-PRO-VRF                                    
               ELSE                                                     
               IF VRF-DVRF > SPACES                                     
                   MOVE VRF-SBLK       TO VRF-STAT                      
                   MOVE 'VRF    SNNUM' TO MSG-COD-MENS                  
                   GO TO ERR-PRO-VRF                                    
               ELSE                                                     
                   GO TO FIN-PRO-VRF.                                   
      *                                                                 
AIX   *    CALL 'GNSPKVRF' USING DFHEIBLK DFHCOMMAREA VRF-VARI.         
AIX        PERFORM VAL-VRF.
           IF VRF-STAT-OKS                                              
               GO TO FIN-PRO-VRF.                                       
           IF VRF-CMSG > SPACES                                         
               MOVE VRF-CMSG TO MSG-COD-MENS                            
           ELSE                                                         
               MOVE 'VRF    NOT' TO MSG-COD-MENS.                       
       ERR-PRO-VRF.                                                     
           MOVE 'GNS' TO MSG-COD-SIST.                                  
           PERFORM GET-MSG.                                             
           MOVE MSG-GLS-DESC TO FRM-MENS.                               
           MOVE FRM-SUAR-MAL TO FRM-SUAR.                               
       FIN-PRO-VRF.                                                     
           EXIT.                                                        
       VAL-VRF SECTION.
       INI-VAL-VRF.
           CALL 'GNSPKVRF' USING VRF-VARI.
      *     MOVE VRF-VARI            TO SYS-CMMA.
      *     MOVE +37                 TO SYS-TCMA.
      *     MOVE SYS-LINK            TO SYS-CMND.
      *     MOVE 'GNSPPVRF'          TO SYS-PROG.
      *     PERFORM GNS-PRO-SYS.
      *     MOVE SYS-CMMA            TO VRF-VARI. 
       FIN-VAL-VRF.
           EXIT.
