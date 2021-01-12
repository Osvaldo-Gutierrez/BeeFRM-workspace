      *    Variables para VRF                                           
       01  VRF-VARI.                                                    
      *    Numero + Digito Verificador                                  
           03 VRF-NUDV          JUST RIGHT              PIC X(13).      
           03 VRF-NUDV-RED REDEFINES VRF-NUDV.                          
      *       Numero                                                    
              05 VRF-NUME                               PIC 9(12).      
              05 VRF-NUME-RED REDEFINES VRF-NUME.                       
                 07 VRF-DIGI OCCURS 12                  PIC 9(01).      
      *       Digito Verificador                                        
              05 VRF-DVRF                               PIC X(01).      
      *    Switch para Verificador 'K' o '0'                            
           03 VRF-SVRF                                  PIC 9(01).      
      *    Status de Retorno                                            
           03 VRF-STAT                                  PIC 9(01).      
              88 VRF-STAT-OKS           VALUE 0.                        
              88 VRF-STAT-MAL           VALUE 1 THRU 9.                 
              88 VRF-STAT-NUM           VALUE 1.                        
              88 VRF-STAT-BLK           VALUE 2.                        
              88 VRF-STAT-VRF           VALUE 3.                        
      *    Switch para que acepte o no numero en cero                   
           03 VRF-ZERO                  VALUE 0         PIC 9(01).      
      *    Mensaje de Retorno                                           
           03 VRF-CMSG                  VALUE SPACES    PIC X(12).      
      *    Comando                                                      
           03 VRF-CMND          COMP                    PIC 9(04).      
      *    Limite superior                                              
           03 VRF-LMAX          COMP                    PIC 9(04).      
      *    INDICADOR SI D.V. VIENE EN ULTIMO DIGITO DEL NUMERO
           03 VRF-SFDV                                  PIC X(01).
           