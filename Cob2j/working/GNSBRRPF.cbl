      *        RELACION PROGRAMA - FORMULARIO                           
      *
      *    Nombre Registro : RPF
      *    Clave(s)        : RPF-COD-DPTS(UU)
      *    Largo           : 128
      *    Bloqueo         : 1
      *    Observaciones   :
      *
       01  RPF.                                                         
      *                                                                 
      *    FILLER COMPATIBILIDAD VSAM/MVS                               
      *    03 RPF-GLS-FLAG                         PIC X(01).           
      *                                                                 
           03 RPF-COD-DPTS.
      *
      *        DESCRIPCION PROGRAMA + TIPO REGISTRO (LLAVE)             
               05 RPF-COD-DPTR.
      *                                                                 
      *        DESCRIPCION PROGRAMA                                     
                  07 RPF-COD-DPRO                      PIC X(12).
      *                                                                 
      *        TIPO REGISTRO Y CORRELATIVO                              
      *          A   =   AUTOR                                          
      *          B   =   ARCHIVO BASE                                   
      *          C   =   COMANDOS                                       
      *          C0  =   COMANDO 0                                      
      *          C1  =   COMANDO 1                                      
      *          .                                                      
      *          .                                                      
      *          C9  =   COMANDO 9                                      
      *          P1  =   FORMULARIO 1                                   
      *          .                                                      
      *          .                                                      
      *          P9  =   FORMULARIO 9                                   
      *          F   =   ARCHIVO ANEXO Y LUGAR EN DONDE SE LLENA        
      *           0  =   LLAVE                                          
      *           1  =   VARIABLE 1                                     
      *           .                                                     
      *           .                                                     
      *           9  =   VARIABLE 9                                     
      *                                                                 
                  07 RPF-COD-TRYC.
      *                                                                 
      *        TIPO REGISTRO                                            
                    09 RPF-COD-TREG                    PIC X(01).
      *                                                                 
      *        CORRELATIVO                                              
                 09 RPF-COD-CORR                       PIC 9(01).
      *                                                                 
      *        DESCRIPCION ARCHIVOS                                     
                  07 RPF-COD-DARC                      PIC X(08).
      *                                                                 
           03 RPF-KEY-DPTS REDEFINES RPF-COD-DPTS.
      *
               05 RPF-KEY-DPTR.
      *        DESCRIPCION PROGRAMA                                     
                  07 RPF-KEY-DPRO                      PIC X(12).
      *                                                                 
      *        TIPO REGISTRO Y CORRELATIVO                              
      *          A   =   AUTOR                                          
      *          B   =   ARCHIVO BASE                                   
      *          C   =   COMANDOS                                       
      *          C0  =   COMANDO 0                                      
      *          C1  =   COMANDO 1                                      
      *          .                                                      
      *          .                                                      
      *          C9  =   COMANDO 9                                      
      *          P1  =   FORMULARIO 1                                   
      *          .                                                      
      *          .                                                      
      *          P9  =   FORMULARIO 9                                   
      *          F   =   ARCHIVO ANEXO Y LUGAR EN DONDE SE LLENA        
      *           0  =   LLAVE                                          
      *           1  =   VARIABLE 1                                     
      *           .                                                     
      *           .                                                     
      *           9  =   VARIABLE 9                                     
      *                                                                 
                  07 RPF-KEY-TRYC.
      *                                                                 
      *        TIPO REGISTRO                                            
                    09 RPF-KEY-TREG                    PIC X(01).
      *                                                                 
      *        CORRELATIVO                                              
                 09 RPF-KEY-CORR                       PIC 9(01).           
      *                                                                 
      *        DESCRIPCION ARCHIVOS                                     
                  07 RPF-KEY-DARC                      PIC X(08).
      *
      *CAH-INI 12-MAY-1998
      *    Time Stamp Transaccion
      *     03  RPF-STP-ITRN.
      *
      *        Fecha Transaccion
      *         05  RPF-FEC-FTRN.
      *             07  RPF-NUM-STRN                 PIC 9(02).
      *             07  RPF-NUM-ATRN                 PIC 9(02).
      *             07  RPF-NUM-MTRN                 PIC 9(02).
      *             07  RPF-NUM-DTRN                 PIC 9(02).
      *
      *            Hora Transaccion
      *         05  RPF-HRA-HRTR.
      *             07  RPF-NUM-HHTR                 PIC 9(02).
      *             07  RPF-NUM-MMTR                 PIC 9(02).
      *             07  RPF-NUM-SSTR                 PIC 9(02).
      *
      *REQ Indicador Tipo Accion
      *     03  RPF-MSC-TACC                             PIC X(01).
      *
      *    Indicador Status
      *     03  RPF-MSC-STAT                             PIC X(01).
      *
      *REQ Codigo Origen Transaccion
      *     03  RPF-COD-OTRN.
      *
      *        Indicador Tipo Origen
      *         05  RPF-MSC-TTRN                         PIC X(01).
      *
      *        Codigo Tipo Origen
      *         05  RPF-COD-TTRN                         PIC X(03).
      *
      *REQ Autor Transaccion
      *     03  RPF-COD-ATRN                             PIC X(12).
      *
      *        DATO ANEXO                                               
           03 RPF-GLS-DATA                         PIC X(70).           
      *                                                                 
           03 RPF-GLS-DAT1 REDEFINES RPF-GLS-DATA.                      
      *                                                                 
      *        DESCRIPCION AUTOR                                        
              05 RPF-GLS-DAUT                      PIC X(42).           
      *                                                                 
      *        CODIGO INDEPEDENCIA FISICA DE DATOS                      
              05 RPF-COD-CIFD                      PIC X(12).           
      *                                                                 
      *        FILLER                                                   
              05 RPF-GLS-DIS1                      PIC X(16).           
      *                                                                 
           03 RPF-GLS-DAT2 REDEFINES RPF-GLS-DATA.                      
      *                                                                 
      *        ARCHIVO BASE                                             
              05 RPF-GLS-ABAS                      PIC X(08).           
      *                                                                 
      *        FILLER                                                   
              05 RPF-GLS-DIS2                      PIC X(62).           
      *                                                                 
           03 RPF-GLS-DAT3 REDEFINES RPF-GLS-DATA.                      
      *                                                                 
      *        FILLER                                                   
              05 RPF-COD-DIS3                      PIC X(03).           
      *                                                                 
      *        GLOSA COMANDOS                                           
              05 RPF-GLS-DCMN                      PIC X(25).           
      *                                                                 
      *        GLOSA ABORTO                                             
              05 RPF-GLS-ABRT                      PIC X(25).           
      *                                                                 
      *        SUBRUTINA ALTERNATIVA COMANDOS                           
              05 RPF-GLS-UARA                      PIC X(12).           
      *                                                                 
      *        FILLER                                                   
              05 RPF-GLS-DIS3                      PIC X(05).           
      *                                                                 
           03 RPF-GLS-DAT4 REDEFINES RPF-GLS-DATA.                      
      *                                                                 
      *        CODIGO COMANDO                                           
              05 RPF-COD-CCMN                      PIC X(03).           
      *                                                                 
      *        GLOSA PROMPT                                             
              05 RPF-GLS-PRMT                      PIC X(25).           
      *                                                                 
      *        GLOSA CONFIRMACION                                       
              05 RPF-GLS-CONF                      PIC X(25).           
      *                                                                 
      *        SUBRUTINA COMANDO                                        
              05 RPF-GLS-UARC                      PIC X(12).           
      *                                                                 
      *        CODIGO COMANDO PARA PROGRAMA                             
              05 RPF-COD-CCPP                      PIC X(03).           
      *                                                                 
      *        ESTADO COMANDO PARA PROGRAMA                             
              05 RPF-IND-STPP                      PIC X(01).           
      *                                                                 
      *        FILLER                                                   
              05 RPF-GLS-DIS4                      PIC X(01).           
      *                                                                 
           03 RPF-GLS-DAT5 REDEFINES RPF-GLS-DATA.                      
      *                                                                 
      *        DESCRIPCION BIBLIOTECA DE FORMULARIO                     
              05 RPF-GLS-LFRM                      PIC X(06).           
      *                                                                 
      *        DESCRIPCION DE FORMULARIO                                
              05 RPF-GLS-NFRM                      PIC X(06).           
      *                                                                 
      *        FILLER                                                   
              05 RPF-GLS-DIS5                      PIC X(58).           
      *                                                                 
           03 RPF-GLS-DAT6 REDEFINES RPF-GLS-DATA.                      
      *                                                                 
      *        LUGAR DEL CODIGO EN PROGRAMA                             
              05 RPF-KEY-LCEP                      PIC X(02).           
      *                                                                 
      *        FORMULARIO DEL CODIGO EN PROGRAMA                        
              05 RPF-KEY-FCEP                      PIC X(06).           
      *                                                                 
      *        VARIABLE DEL CODIGO EN PROGRAMA                          
              05 RPF-KEY-VCEP                      PIC X(32).           
      *                                                                 
      *        FILLER                                                   
              05 RPF-GLS-DIS6                      PIC X(30).           
      *                                                                 
           03 RPF-GLS-DAT7 REDEFINES RPF-GLS-DATA.                      
      *                                                                 
      *        DESCRIPCION LLAVE                                        
              05 RPF-GLS-DKEY                      PIC X(10).           
      *                                                                 
      *        FILLER                                                   
              05 RPF-GLS-DIS7                      PIC X(60).           
      *                                                                 
           03 RPF-GLS-DAT8 REDEFINES RPF-GLS-DATA.                      
      *                                                                 
      *        DESCRIPCION VARIABLE PARA FORMAR LLAVE                   
              05 RPF-GLS-DVAR                      PIC X(32).           
      *                                                                 
      *        FILLER                                                   
              05 RPF-GLS-DIS8                      PIC X(38).           
      *
