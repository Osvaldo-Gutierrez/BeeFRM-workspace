      *                                                                 
       01  QUE-VARI.                                                    
           03 QUE-COLA.                                                 
              05 QUE-TERM                              PIC  X(04).      
              05 QUE-TYPE                              PIC  X(04).      
           03 QUE-NITM       COMP VALUE +0             PIC S9(04).      
           03 QUE-LITM       COMP                      PIC S9(04).      
           03 QUE-ITEM.                                                 
              05 QUE-IKEY                              PIC  X(03).      
              05 QUE-LDAT    COMP VALUE +0             PIC S9(04).      
              05 QUE-PCUR    COMP VALUE +0             PIC S9(04).      
              05 QUE-DATA                              PIC  X(3000).    
           03 QUE-STAT            VALUE 'OKS'          PIC  X(03).      
           03 QUE-STAT-OKS        VALUE 'OKS'          PIC  X(03).      
           03 QUE-STAT-NEX        VALUE 'NEX'          PIC  X(03).      
           03 QUE-STAT-EOQ        VALUE 'EOQ'          PIC  X(03).      
           03 QUE-CMND                                 PIC  X(03).      
           03 QUE-MENS.                                                 
              05 QUE-MEN1                              PIC  X(40).      
              05 QUE-MEN2                              PIC  X(39).
           01 QUE-NUM-STAT                             PIC  S9(09).
           01 QUE-GLS-STAT                             PIC  S9(09).
              
       01  QUE-CTTS.                                                    
           03 QUE-PUT             VALUE 'PUT'          PIC  X(03).      
           03 QUE-GET             VALUE 'GET'          PIC  X(03).      
           03 QUE-MOD             VALUE 'MOD'          PIC  X(03).      
           03 QUE-DEL             VALUE 'DEL'          PIC  X(03).      

       01  QUE-SEND.                                                    
           03 QUE-COM-SEND                             PIC  X(03).                                                 
           03 QUE-NAM-SEND                             PIC  X(300).      
           03 QUE-NUM-SEND                             PIC  9(04).      
           03 QUE-LAR-SEND                             PIC  9(04).      
           03 QUE-TRX-SEND                             PIC  X(256).      
           03 QUE-DAT-SEND                             PIC  X(9000).                    

       01  QUE-RECV.                                                    
           03 QUE-FIL-RECV                             PIC  9(02).                                                 
           03 QUE-STA-RECV                             PIC  9(18).                                                 
           03 QUE-NUM-RECV                             PIC  9(04).      
           03 QUE-LAR-RECV                             PIC  9(04).      
           03 QUE-TRX-RECV                             PIC  X(256).      
           03 QUE-DAT-RECV                             PIC  X(9000).                    

       01  QUE-TPTYPE-REC-SEND.
           05 QUE-REC-SEND-REC-TYPE  VALUE "CARRAY" PIC X(8).
           05 QUE-REC-SEND-SUB-TYPE                 PIC X(16).
           05 QUE-REC-SEND-LEN       VALUE 9568     PIC S9(9) COMP-5.
           05 QUE-REC-SEND-TPTYPE-STATUS            PIC S9(9) COMP-5.
              88 QUE-TPTYPE-REC-SEND-TPTYPEOK     VALUE 0.
              88 QUE-TPTYPE-REC-SEND-TPTRUNCATE   VALUE 1.

       01  QUE-TPTYPE-REC-RECV.
           05 QUE-REC-RECV-REC-TYPE  VALUE "CARRAY" PIC X(8).
           05 QUE-REC-RECV-SUB-TYPE                 PIC X(16).
           05 QUE-REC-RECV-LEN       VALUE 9285     PIC S9(9) COMP-5.
           05 QUE-REC-RECV-TPTYPE-STATUS            PIC S9(9) COMP-5.
              88 QUE-TPTYPE-REC-RECV-TPTYPEOK     VALUE 0.
              88 QUE-TPTYPE-REC-RECV-TPTRUNCATE   VALUE 1.
              
       01 QUE-TPSVCDEF-REC.
       05 QUE-COMM-HANDLE          PIC S9(9) COMP-5.
       05 QUE-TPBLOCK-FLAG         PIC S9(9) COMP-5.
               88 QUE-TPBLOCK         VALUE 0.
               88 QUE-TPNOBLOCK       VALUE 1.
       05 QUE-TPTRAN-FLAG          PIC S9(9) COMP-5.
               88 QUE-TPTRAN          VALUE 0.
               88 QUE-TPNOTRAN        VALUE 1.
       05 QUE-TPREPLY-FLAG         PIC S9(9) COMP-5.
               88 QUE-TPREPLY         VALUE 0.
               88 QUE-TPNOREPLY       VALUE 1.
       05 QUE-TPACK-FLAG         REDEFINES QUE-TPREPLY-FLAG.
          10 FILLER PIC S9(9) COMP-5.
               88 QUE-TPNOACK         VALUE 0.
               88 QUE-TPACK           VALUE 1.
       05 QUE-TPTIME-FLAG          PIC S9(9) COMP-5.
               88 QUE-TPTIME          VALUE 0.
               88 QUE-TPNOTIME        VALUE 1.
       05 QUE-TPSIGRSTRT-FLAG      PIC S9(9) COMP-5.
               88 QUE-TPNOSIGRSTRT    VALUE 0.
               88 QUE-TPSIGRSTRT      VALUE 1.
       05 QUE-TPGETANY-FLAG        PIC S9(9) COMP-5.
               88 QUE-TPGETHANDLE     VALUE 0.
               88 QUE-TPGETANY        VALUE 1.
       05 QUE-TPSENDRECV-FLAG      PIC S9(9) COMP-5.
               88 QUE-TPSENDONLY      VALUE 0.
               88 QUE-TPRECVONLY      VALUE 1.
       05 QUE-TPNOCHANGE-FLAG      PIC S9(9) COMP-5.
               88 QUE-TPCHANGE        VALUE 0.
               88 QUE-TPNOCHANGE      VALUE 1.
       05 QUE-TPSERVICETYPE-FLAG   PIC S9(9) COMP-5.
               88 QUE-TPREQRSP       VALUE IS 0.
               88 QUE-TPCONV         VALUE IS 1.
       05 QUE-APPKEY               PIC S9(9) COMP-5.
       05 QUE-CLIENTID OCCURS 4 TIMES PIC S9(9) COMP-5.
       05 QUE-SERVICE-NAME   VALUE "ts" PIC X(127).



      * VARIABLES PARA ENGANCHE PROGRAMAS COMENTARIOS                   
       01  KEY-VARI.                                                    
      *    ENTIDAD                                                      
           03 KEY-COD-ENTI                             PIC X(03).       
      *    NOMBRE                                                       
           03  KEY-GLS-NOMC                            PIC X(60).       
      *    RUT                                                          
           03  KEY-CIC-IRUT.                                            
               05  KEY-NUM-ICLI                        PIC 9(08).       
               05  KEY-VRF-ICLI                        PIC X(01).       
               05  KEY-IND-ICLI                        PIC X(01).       
               05  KEY-GLS-ICLI                        PIC X(03).       
      *    CIC OPE                                                      
           03  KEY-CIC-IOPE.                                            
               05  KEY-CAI-IOPE                        PIC X(04).       
               05  KEY-IIC-IOPE                        PIC X(08).       
      *    FECHA                                                        
           03  KEY-FEC-FENT.                                            
               05 KEY-NUM-DENT                         PIC 9(02).       
               05 KEY-NUM-MENT                         PIC 9(02).       
               05 KEY-NUM-SENT                         PIC 9(02).       
               05 KEY-NUM-AENT                         PIC 9(02).       
      *    CORRELATIVO                                                  
           03 KEY-NUM-IENT                             PIC 9(03).       
      *    CODIGO                                                       
           03 KEY-COD-IENT                             PIC X(03).       
      *    FECHA COMENTARIO                                             
           03  KEY-FEC-FCMT.                                            
               05 KEY-NUM-DCMT                         PIC 9(02).       
               05 KEY-NUM-MCMT                         PIC 9(02).       
               05 KEY-NUM-SCMT                         PIC 9(02).       
               05 KEY-NUM-ACMT                         PIC 9(02).       
      *    CORRELATIVO COMENTARIO                                       
           03 KEY-NUM-GCMT                             PIC 9(03).       
      *    USUARIO                                                      
           03 KEY-COD-USER                             PIC X(12).       