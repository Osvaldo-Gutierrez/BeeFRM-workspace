      *    Constantes para las rutinas FIO's                            
       01  FIO-CTTS.                                                    
      *                                                                 
      *    DEFault access for other users                               
           03 FIO-ACCS-DEF        VALUE 0       PIC 9(01).              
      *                                                                 
      *    NOT     access for other users                               
           03 FIO-ACCS-NOT        VALUE 1       PIC 9(01).              
      *                                                                 
      *    INPut   access for other users                               
           03 FIO-ACCS-INP        VALUE 2       PIC 9(01).              
      *                                                                 
      *    UPDate  access for other users                               
           03 FIO-ACCS-UPD        VALUE 3       PIC 9(01).              
      *                                                                 
      *    FIO     control on record locked                             
           03 FIO-RLCK-FIO        VALUE 0       PIC 9(01).              
      *                                                                 
      *    ProGraM control on record locked                             
           03 FIO-RLCK-PGM        VALUE 1       PIC 9(01).              
      *                                                                 
      *    FIO     control on input file not found                      
           03 FIO-IFNF-FIO        VALUE 0       PIC 9(01).              
      *                                                                 
      *    ProGraM control on input file not found                      
           03 FIO-IFNF-PGM        VALUE 1       PIC 9(01).              
      *                                                                 
      *    Status Registro Inexistente                                  
           03 FIO-STAT-NEX                      PIC X(02) VALUE '39'.   
      *                                                                 
      *    Comandos para las rutinas FIO's                              
           03 FIO-VCMN.                                                 
      *                                                                 
      *       Read Key                                                  
              05 FIO-GET-KEY           VALUE  1 PIC 9(04).              
      *                                                                 
      *       Read Next                                                 
              05 FIO-GET-NXT           VALUE  2 PIC 9(04).              
      *                                                                 
      *       Start First + Read Next                                   
              05 FIO-GET-FST           VALUE  3 PIC 9(04).              
      *                                                                 
      *       Start Not Less + Read Next                                
              05 FIO-GET-NLS           VALUE  4 PIC 9(04).              
      *                                                                 
      *       Start Greater + Read Next                                 
              05 FIO-GET-GRT           VALUE  5 PIC 9(04).              
      *                                                                 
      *       Write                                                     
              05 FIO-PUT               VALUE  6 PIC 9(04).              
      *                                                                 
      *       Rewrite                                                   
              05 FIO-MOD               VALUE  7 PIC 9(04).              
      *                                                                 
      *       Delete                                                    
              05 FIO-DEL               VALUE  8 PIC 9(04).              
      *                                                                 
      *       Change                                                    
              05 FIO-CHG               VALUE  9 PIC 9(04).              
      *                                                                 
      *       Open Input                                                
              05 FIO-INP               VALUE 10 PIC 9(04).              
      *                                                                 
      *       Open Output                                               
              05 FIO-OUT               VALUE 11 PIC 9(04).              
      *                                                                 
      *       Open I-O                                                  
              05 FIO-UPD               VALUE 12 PIC 9(04).              
      *                                                                 
      *       Close                                                     
              05 FIO-CLO               VALUE 13 PIC 9(04).              
      *                                                                 
      *       Start Equal                                               
              05 FIO-FND-EQL           VALUE 14 PIC 9(04).              
      *                                                                 
      *       Start First                                               
              05 FIO-FND-FST           VALUE 15 PIC 9(04).              
      *                                                                 
      *       Start Not Less                                            
              05 FIO-FND-NLS           VALUE 16 PIC 9(04).              
      *                                                                 
      *       Start Greater                                             
              05 FIO-FND-GRT           VALUE 17 PIC 9(04).              
      *                                                                 
      *       Unlock Record                                             
              05 FIO-ULK-REC           VALUE 18 PIC 9(04).              
      *                                                                 
      *       Unlock All                                                
              05 FIO-ULK-ALL           VALUE 19 PIC 9(04).              
      *                                                                 
      *       Value of ID                                               
              05 FIO-VID               VALUE 20 PIC 9(04).              
      *                                                                 
      *       Acceso                                                    
              05 FIO-ACC               VALUE 21 PIC 9(04).              
      *                                                                 
      *       Record Locked                                             
              05 FIO-REC-LCK           VALUE 22 PIC 9(04).              
      *                                                                 
      *       File Not Found                                            
              05 FIO-FNF               VALUE 23 PIC 9(04).              
      *                                                                 
      *       Record Length                                             
              05 FIO-REC-LEN           VALUE 24 PIC 9(04).              
      *                                                                 
      *       Open Extend                                               
              05 FIO-EXT               VALUE 25 PIC 9(04).              
      *                                                                 
      *       Read Key ( Alternate Key )                                
              05 FIO-GET-KEY-ALT       VALUE 26 PIC 9(04).              
      *                                                                 
      *       Start First + Read Next ( Alternate Key )                 
              05 FIO-GET-FST-ALT       VALUE 27 PIC 9(04).              
      *                                                                 
      *       Start Not Less + Read Next ( Alternate Key )              
              05 FIO-GET-NLS-ALT       VALUE 28 PIC 9(04).              
      *                                                                 
      *       Start Greater + Read Next ( Alternate Key )               
              05 FIO-GET-GRT-ALT       VALUE 29 PIC 9(04).              
      *                                                                 
      *       Start Equal ( Alternate Key )                             
              05 FIO-FND-EQL-ALT       VALUE 30 PIC 9(04).              
      *                                                                 
      *       Start First ( Alternate Key )                             
              05 FIO-FND-FST-ALT       VALUE 31 PIC 9(04).              
      *                                                                 
      *       Start Not Less ( Alternate Key )                          
              05 FIO-FND-NLS-ALT       VALUE 32 PIC 9(04).              
      *                                                                 
      *       Start Greater ( Alternate Key )                           
              05 FIO-FND-GRT-ALT       VALUE 33 PIC 9(04).              
      *                                                                 
      *       Get Next con llave Alternativa                            
              05 FIO-GET-NXT-ALT       VALUE 34 PIC 9(04).              
      *                                                                 
      *       Get Key Update con llave Alternativa                      
              05 FIO-GET-KEY-UPD-ALT   VALUE 35 PIC 9(04).              
      *                                                                 
      *       Get Key Update                                            
              05 FIO-GET-KEY-UPD       VALUE 36 PIC 9(04).              
      *                                                                 
      *       End Browse                                                
              05 FIO-END-BRW           VALUE 37 PIC 9(04).              
      *                                                                 
      *       Back Out Transaction                                      
              05 FIO-BCK-OUT           VALUE 38 PIC 9(04).              
      *                                                                 
      *       Get Less or Equal                                         
              05 FIO-GET-LEQ           VALUE 39 PIC 9(04).              
      *                                                                 
      *       Get Previous                                              
              05 FIO-GET-PRV           VALUE 40 PIC 9(04).              
      *                                                                 
      *       Check Point                                               
              05 FIO-CHK-PNT           VALUE 41 PIC 9(04).              
      *                                                                 
      *       Buffer Refresh                                            
              05 FIO-BFR-RFH           VALUE 42 PIC 9(04).              
      *                                                                 
      *       End Browse All                                            
              05 FIO-EBR-ALL           VALUE 43 PIC 9(04).              
      *                                                                 
      *       BEGin TRaNsacction                                        
              05 FIO-BEG-TRN           VALUE 44 PIC 9(04).              
      *                                                                 
           03 FIO-VCMN-RED    REDEFINES FIO-VCMN.                       
              05 FIO-IDX-VCMN OCCURS 44 TIMES   PIC 9(04).              
      *                                                                 
      *    Programa que usa servicio de FIO                             
           03 FIO-PROG                          PIC X(08).              
      *                                                                 
      *    Programa  FIO                             
           03 FIO-GLS-PROG                      PIC X(08).              
      *                                                                 
      *    Valor de Key                                                 
           03 FIO-VKEY                          PIC X(180).             
      *                                                                 
      *    Valor de Key para Comparacion con FIO-VKEY   ( VSI )         
           03 FIO-CKEY                          PIC X(180).             
      *                                                                 
      *    Key Length                                                   
           03 FIO-KLEN  COMP                    PIC S9(4).              
      *                                                                 
      *    Campo Data para FIO                                          
           03 FIO-DFLD                          PIC X(1536).            
      *                                                                 
      *    Mensaje                                                      
           03 FIO-MENS              VALUE SPACES.                       
      *                                                                 
      *       Mensaje 1                                                 
              05 FIO-MEN1                       PIC X(71).              
      *                                                                 
      *       Mensaje 2                                                 
              05 FIO-MEN2                       PIC X(09).              
      *                                                                 
           03 FIO-MENS-RED REDEFINES FIO-MENS.                          
              05 FIO-MENS-DSC                   PIC X(13).              
              05 FILLER                         PIC X(01).              
              05 FIO-MENS-STT                   PIC X(02).              
              05 FIO-MENS-NTT REDEFINES FIO-MENS-STT PIC 9(02).         
              05 FIO-MENS-SST                   PIC X(01).              
              05 FILLER                         PIC X(01).              
              05 FIO-MENS-GKY                   PIC X(03).              
              05 FILLER                         PIC X(01).              
              05 FIO-MENS-KEY                   PIC X(32).              
              05 FIO-MENS-KEY-RED REDEFINES FIO-MENS-KEY.               
                 07 FIO-MENS-KDT                PIC X(05).              
                 07 FILLER                      PIC X(01).              
                 07 FIO-MENS-GBD                PIC X(10).              
                 07 FILLER                      PIC X(01).              
                 07 FIO-MENS-DBI                PIC X(05).              
                 07 FILLER                      PIC X(10).              
              05 FILLER                         PIC X(01).              
              05 FIO-MENS-GCM                   PIC X(03).              
              05 FILLER                         PIC X(01).              
              05 FIO-MENS-CMD                   PIC X(05).              
              05 FILLER                         PIC X(01).              
              05 FIO-MENS-GFL                   PIC X(04).              
              05 FILLER                         PIC X(01).              
              05 FIO-MENS-FIL                   PIC X(09).              
              05 FIO-MENS-FIL-RED REDEFINES FIO-MENS-FIL.               
                 07 FIO-MENS-SIS                PIC X(03).              
                 07 FIO-MENS-REG                PIC X(06).              
              05 FILLER                         PIC X(01).              
      *                                                                 
      *    Indicador de uso de Llave alternativa                        
           03 FIO-IAKY                 VALUE  0 PIC 9(04).              
              88 FIO-IAKY-CON          VALUE 26 THRU 35.                
      *                                                                 
      *    Indicador de uso de Llave alternativa                        
           03 FIO-IGET                 VALUE  0 PIC 9(04).              
              88 FIO-IGET-YES          VALUE  1 THRU 5, 26 THRU 29,     
                                             34, 35, 36, 39, 40.        
              88 FIO-ICBR-YES          VALUE  2, 34, 40.                
      *                                                                 
      *    Indicador de Llaves de Default                               
           03 FIO-KDEF                 VALUE 0 PIC 9(01).               
           03 FIO-KDEF-N               VALUE 0 PIC 9(01).               
           03 FIO-KDEF-S               VALUE 1 PIC 9(01).               
      *                                                                 
      *    Indicador de primera VEZ                                     
           03 FIO-IVEZ            VALUE SPACES PIC X(01).               
      *                                                                 
      *    Vector de status de archivos                                 
           03 FIO-MSFL VALUE SPACES.                                    
              05 FIO-VSFL OCCURS 20 INDEXED BY FIO-ITBL.                
                 07 FIO-NFIL                   PIC X(07).               
      *                                                                 
      *    Indice maximo                                                
           03 FIO-MXFL               VALUE 20  PIC 9(02).               
      *                                                                 
      *    Indicador de Start-Browse abierto                            
           03 FIO-ISBR               VALUE 'N' PIC X(01).               
      *                                                                 
      *    Indice auxiliar                                              
           03 FIO-IAUX               VALUE 0   PIC 9(02).               

       01 FIO-ORACLE.
           03 FIO-ORACLE-VARI                  PIC X(0080).
           03 FIO-ORACLE-DFLD                  PIC X(1536).
           03 FIO-ORACLE-RQA                   PIC X(0630).
           03 FIO-ORACLE-MENS                  PIC X(0080).
           03 FIO-ORACLE-PROG.
              05 FIO-ORACLE-PROG-TAB           PIC X(0003).
              05 FIO-ORACLE-PROG-NUM           PIC 9(0003).
           03 FIO-ORACLE-FILL                  PIC X(0668).

       01 RECV-STRING-FIO                      PIC X(3000).
       
       01 SEND-STRING-FIO                      PIC X(3000).
