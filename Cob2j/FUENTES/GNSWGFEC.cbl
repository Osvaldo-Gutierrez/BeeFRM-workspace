      *    Variables para manejo de Fechas.                             
      *    11-OCT-1989 14:10                                            
       01  FEC-VARI.                                                    
      *    Fecha                                                        
           03 FEC-FECH.                                                 
              05 FEC-ITM1                                 PIC 9(02).    
              05 FEC-ITM2                                 PIC 9(02).    
              05 FEC-ITM3                                 PIC 9(02).    
              05 FEC-ITM4                                 PIC 9(02).    
              05 FILLER                                   PIC X(02).    
           03 FEC-FECH-RED REDEFINES FEC-FECH.                          
              05 FEC-ITM1-RED                             PIC X(02).    
              05 FEC-ITM2-RED                             PIC X(02).    
              05 FEC-ITM3-RED                             PIC X(02).    
              05 FEC-ITM4-RED                             PIC X(02).    
           03 FEC-FECH-RED2 REDEFINES FEC-FECH.                         
              05 FEC-FECH-FDM                             PIC X(04).    
              05 FILLER                                   PIC X(04).    
           03 FEC-FECH-RED3 REDEFINES FEC-FECH.                         
              05 FEC-FECH-CHR                    OCCURS 8 PIC X(01).    
      *    Fecha de validacion Siglo-Ano-Mes-Dia                        
           03 FEC-FVLD.                                                 
              05 FEC-SVLD                                 PIC 9(02).    
              05 FEC-AVLD                                 PIC 9(02).    
              05 FEC-MVLD                                 PIC 9(02).    
              05 FEC-DVLD                                 PIC 9(02).    
           03 FEC-FVLD-RED REDEFINES FEC-FVLD.                          
              05 FEC-SVLD-RED                             PIC X(02).    
              05 FEC-AVLD-RED                             PIC X(02).    
              05 FEC-MVLD-RED                             PIC X(02).    
              05 FEC-DVLD-RED                             PIC X(02).    
           03 FEC-FVLD-NUM REDEFINES FEC-FVLD.                          
              05 FEC-FANO                                 PIC 9(04).    
              05 FEC-FMES                                 PIC 9(02).    
              05 FEC-FDIA                                 PIC 9(02).    
      *    Fecha 1                                                      
           03 FEC-FEC1.                                                 
              05 FEC-DEC1                                 PIC 9(02).    
              05 FEC-MEC1                                 PIC 9(02).    
              05 FEC-SEC1                                 PIC 9(02).    
              05 FEC-AEC1                                 PIC 9(02).    
              05 FILLER                                   PIC X(02).    
           03 FEC-FEC1-RED REDEFINES FEC-FEC1.                          
              05 FILLER                                   PIC X(04).    
              05 FEC-FSA1                                 PIC 9(04).    
      *    Fecha 2                                                      
           03 FEC-FEC2.                                                 
              05 FEC-DEC2                                 PIC 9(02).    
              05 FEC-MEC2                                 PIC 9(02).    
              05 FEC-SEC2                                 PIC 9(02).    
              05 FEC-AEC2                                 PIC 9(02).    
              05 FILLER                                   PIC X(02).    
           03 FEC-FEC2-RED REDEFINES FEC-FEC2.                          
              05 FILLER                                   PIC X(04).    
              05 FEC-FSA2                                 PIC 9(04).    
           03 FEC-FSLH.                                                 
              05 FEC-FSLH-IT1                             PIC X(02).    
              05 FEC-FSLH-SL1                             PIC X(01).    
              05 FEC-FSLH-IT2                             PIC X(02).    
              05 FEC-FSLH-SL2                             PIC X(01).    
              05 FEC-FSLH-IT3                             PIC X(02).    
              05 FEC-FSLH-IT4                             PIC X(02).    
           03 FEC-FSLH-RED REDEFINES FEC-FSLH.                          
              05 FILLER                                   PIC X(05).    
              05 FEC-FSLH-IT5                             PIC X(02).    
              05 FEC-FSLH-IT6                             PIC X(02).    
           03 FEC-IEDT                       VALUE SPACES PIC X(01).    
      *    Fecha Juliana                                                
           03 FEC-FJUL                           VALUE 0  PIC 9(06).    
      *    Fecha Juliana auxiliar                                       
           03 FEC-XJUL                           VALUE 0  PIC 9(06).    
      *    Numero de Anos                                               
           03 FEC-NANO                           VALUE 0  PIC 9(06).    
      *    Numero de Meses                                              
           03 FEC-NMES                           VALUE 0  PIC 9(06).    
      *    Numero de Dias                                               
           03 FEC-NDIA                           VALUE 0  PIC 9(06).    
      *    Numero de Bisiestos                                          
           03 FEC-NABI                           VALUE 0  PIC 9(03).    
      *    Auxiliar                                                     
           03 FEC-AUXI                           VALUE 0  PIC 9(01).    
      *    Variables para Current-Date                                  
           03 FEC-SHOY                                    PIC 9(02).    
           03 FEC-FHOY.                                                 
              05 FEC-DHOY                                 PIC 9(02).    
              05 FILLER                                   PIC X(01).    
              05 FEC-MHOY                                 PIC 9(02).    
              05 FILLER                                   PIC X(01).    
              05 FEC-AHOY                                 PIC 9(02).    
           03 FEC-JHOY                                    PIC 9(05).    
           03 FEC-JHOY-RED REDEFINES FEC-JHOY.                          
              05 FEC-AAHY                                 PIC 9(02).    
              05 FEC-DDHY                                 PIC 9(03).    
           03 FEC-HHOY                                    PIC 9(06).    
           03 FEC-HHOY-RED REDEFINES FEC-HHOY.                          
              05 FEC-HHHY                                 PIC 9(02).    
              05 FEC-MMHY                                 PIC 9(02).    
              05 FEC-SSHY                                 PIC 9(02).    
      *    Mensaje                                                      
           03 FEC-MENS                                    PIC X(79).    
      *    Resto                                                        
           03 FEC-REST                                    PIC 9(02).    
      *    Indice                                                       
           03 FEC-SIND                                    PIC 9(02).    
      *    Formato                                                      
           03 FEC-FORM.                                                 
              05 FEC-FORM-DIA                 VALUE ' '   PIC X(01).    
                 88 FEC-TIENE-DIA             VALUE 'D'.                
              05 FEC-FORM-MES                 VALUE ' '   PIC X(01).    
                 88 FEC-TIENE-MES             VALUE 'M'.                
              05 FEC-FORM-SGL                 VALUE ' '   PIC X(01).    
                 88 FEC-TIENE-SIGLO           VALUE 'S'.                
              05 FEC-FORM-ANO                 VALUE ' '   PIC X(01).    
                 88 FEC-TIENE-ANO             VALUE 'A' 'Q'.            
                 88 FEC-TIENE-QUIEBRE         VALUE 'A'.                
                 88 FEC-NO-TIENE-QUIEBRE      VALUE 'Q'.                
      *    Para aceptar fecha en blanco o zeroes                        
           03 FEC-FBLK                         VALUE 0    PIC 9(01).    
      *    Para validar dia habil                                       
           03 FEC-VHBL                         VALUE 0    PIC 9(01).    
      *    Para comparar con HOY                                        
           03 FEC-CHOY                         VALUE 0    PIC 9(01).    
      *    Comando                                                      
           03 FEC-CMND                                    PIC X(07).    
      *    Status                                                       
           03 FEC-STAT.                                                 
              88 FEC-STAT-HBL        VALUE '01'.                        
              88 FEC-STAT-LES        VALUE '03'.                        
              88 FEC-STAT-EQL        VALUE '04'.                        
      *JSS    88 FEC-STAT-LEQ        VALUE '03' '04'.                   
              88 FEC-STAT-GRT        VALUE '05'.                        
              88 FEC-STAT-BLK        VALUE '06'.                        
      *JSS    88 FEC-STAT-GEQ        VALUE '04' '05'.                   
              88 FEC-STAT-OBL        VALUE '70'.                        
              88 FEC-STAT-NN1        VALUE '80'.                        
              88 FEC-STAT-NN2        VALUE '81'.                        
              88 FEC-STAT-SIG        VALUE '91'.                        
              88 FEC-STAT-ANO        VALUE '92'.                        
              88 FEC-STAT-MES        VALUE '93'.                        
              88 FEC-STAT-DIA        VALUE '94'.                        
              88 FEC-STAT-FER        VALUE '95'.                        
              05 FEC-STT1                                 PIC 9(01).    
                 88 FEC-STAT-OKS     VALUE 0.                           
                 88 FEC-STAT-NNU     VALUE 8.                           
                 88 FEC-STAT-ERR     VALUE 9.                           
              05 FEC-STT2                                 PIC 9(01).    
      *    Constantes para manejo de Fechas.                            
       01  FEC-CTTS.                                                    
      *    Cantidad de Dias de cada Mes                                 
           03 FEC-VMES VALUE             '312931303130313130313031'.    
              05 FEC-DMES       OCCURS 12                 PIC 9(02).    
      *    Cantidad de Dias Acumulados en cada Mes                      
           03 FEC-VACU VALUE '031060091121152182213244274305335366'.    
              05 FEC-DACU       OCCURS 12                 PIC 9(03).    
      *    Dias de la Semana                                            
           03 FEC-VDIA           VALUE                                  
           '  LUNES   MARTES  MIERCOLES JUEVES   VIERNES   SABADO  DOMIN
      -    'GO '.                                                       
              05 FEC-DDIA       OCCURS 7                  PIC X(09).    
      *    Ano 1                                                        
           03 FEC-ANO1                         VALUE 1800 PIC 9(04).    
      *    Dia 1 ( Segun L M M J V S D )                                
           03 FEC-DIA1                         VALUE    1 PIC 9(01).    
      *    Bisiesto 1                                                   
           03 FEC-BST1                         VALUE 1800 PIC 9(04).    
      *    Constantes de Status                                         
           03 FEC-SOKS                         VALUE  0   PIC 9(01).    
           03 FEC-SHBL                         VALUE '01' PIC X(02).    
           03 FEC-SLES                         VALUE '03' PIC X(02).    
           03 FEC-SEQL                         VALUE '04' PIC X(02).    
           03 FEC-SGRT                         VALUE '05' PIC X(02).    
           03 FEC-SBLK                         VALUE '06' PIC X(02).    
           03 FEC-SOBL                         VALUE '70' PIC X(02).    
           03 FEC-SMAL                         VALUE  9   PIC 9(01).    
           03 FEC-SSIG                         VALUE '91' PIC X(02).    
           03 FEC-SANO                         VALUE '92' PIC X(02).    
           03 FEC-SMES                         VALUE '93' PIC X(02).    
           03 FEC-SDIA                         VALUE '94' PIC X(02).    
           03 FEC-SFER                         VALUE '95' PIC X(02).    
           03 FEC-SNN1                         VALUE '80' PIC X(02).    
           03 FEC-SNN2                         VALUE '81' PIC X(02).    
      *    Para aceptar fecha en blanco o zeroes                        
           03 FEC-FBLK-S                       VALUE 1    PIC 9(01).    
           03 FEC-FBLK-N                       VALUE 0    PIC 9(01).    
      *    Para validar dia habil                                       
           03 FEC-VHBL-S                       VALUE 0    PIC 9(01).    
           03 FEC-VHBL-N                       VALUE 1    PIC 9(01).    
      *    Para comparar con HOY                                        
           03 FEC-CHOY-L                       VALUE 1    PIC 9(01).    
           03 FEC-CHOY-E                       VALUE 2    PIC 9(01).    
           03 FEC-CHOY-G                       VALUE 3    PIC 9(01).    
           03 FEC-CHOY-LE                      VALUE 0    PIC 9(01).    
           03 FEC-CHOY-GE                      VALUE 4    PIC 9(01).    
           03 FEC-CHOY-LG                      VALUE 5    PIC 9(01).    
           03 FEC-CHOY-N                       VALUE 6    PIC 9(01).    
      *    Formatos de Fechas                                           
           03 FEC-FORM-FEC                    VALUE 'DMSA' PIC X(04).   
           03 FEC-FORM-DMA                    VALUE 'DM A' PIC X(04).   
           03 FEC-FORM-DMQ                    VALUE 'DM Q' PIC X(04).   
           03 FEC-FORM-MSA                    VALUE ' MSA' PIC X(04).   
           03 FEC-FORM-FMA                    VALUE ' M A' PIC X(04).   
           03 FEC-FORM-FMQ                    VALUE ' M Q' PIC X(04).   
           03 FEC-FORM-FSA                    VALUE '  SA' PIC X(04).   
           03 FEC-FORM-FFA                    VALUE '   A' PIC X(04).   
           03 FEC-FORM-FFQ                    VALUE '   Q' PIC X(04).   
      *    Comandos                                                     
           03 FEC-VAL-FEC       VALUE   'VAL-FEC'         PIC X(07).    
           03 FEC-CMP-FEC       VALUE   'CMP-FEC'         PIC X(07).    
           03 FEC-CMP-HOY       VALUE   'CMP-HOY'         PIC X(07).    
           03 FEC-RET-JUL       VALUE   'RET-JUL'         PIC X(07).    
           03 FEC-RET-FEC       VALUE   'RET-FEC'         PIC X(07).    
           03 FEC-SIG-HBL       VALUE   'SIG-HBL'         PIC X(07).    
      *MHM INI 24-0CT-2011 PENTA
           03 FEC-ANT-HBL       VALUE   'ANT-HBL'         PIC X(07).    
      *MHM INI 24-0CT-2011 PENTA
           03 FEC-SUM-DIA       VALUE   'SUM-DIA'         PIC X(07).    
           03 FEC-SUM-MES       VALUE   'SUM-MES'         PIC X(07).    
           03 FEC-SUM-ANO       VALUE   'SUM-ANO'         PIC X(07).    
           03 FEC-RST-DIA       VALUE   'RST-DIA'         PIC X(07).    
           03 FEC-RST-MES       VALUE   'RST-MES'         PIC X(07).    
           03 FEC-RST-ANO       VALUE   'RST-ANO'         PIC X(07).    
           03 FEC-DIF-DIA       VALUE   'DIF-DIA'         PIC X(07).    
           03 FEC-DIF-MES       VALUE   'DIF-MES'         PIC X(07).    
           03 FEC-DIF-ANO       VALUE   'DIF-ANO'         PIC X(07).    
