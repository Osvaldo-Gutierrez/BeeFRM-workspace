      *    Registro Generico de Mensajes                                
      *    -----------------------------                                
      *                                                                 
      *    Nombre Registro : MSG                                        
      *    Clave(s)        : MSG-KY0-TABS(UU),
      *                      MSG-KY1-TABS(UU), MSG-KY2-TABS(UU)
      *    Largo           : 206
      *    Bloqueo         : 2                                          
      *    Observaciones   :                                            
      *                                                                 
       01  MSG.                                                         
      *                                                                 
      *    Filler Compatibilidad VSAM/MVS                               
           03  MSG-GLS-FLAG                             PIC X(01).      
      *                                                                 
      *    Clave Primaria Registro                                      
           03  MSG-KEY-IREG.                                            
      *                                                                 
      *KEY     Tipo + Codigo ( LLave Primaria )                         
               05  MSG-KY0-TABS.
                   07  MSG-COD-TABL.
      *                                                                 
      *            Codigo Tipo Tabla                                    
                       09  MSG-COD-TTAB                     PIC X(03).
      *                                                                 
      *            Codigo Mensaje                                       
                       09  MSG-COD-MENS.
      *                                                                 
      *                Tipo Mensaje                                     
                           11  MSG-COD-TMSG                 PIC X(07).
      *                                                                 
      *                Codigo Mensaje                                   
                           11  MSG-COD-CMSG                 PIC X(05).
      *                                                                 
      *        Time Stamp Transaccion                                   
               05  MSG-COD-ITRS.
                   07  MSG-STP-ITRN.
      *                                                                 
      *            Fecha Transaccion                                    
                       09  MSG-FEC-FTRN.
                           11  MSG-NUM-STRN                 PIC 9(02).
                           11  MSG-NUM-ATRN                 PIC 9(02).
                           11  MSG-NUM-MTRN                 PIC 9(02).
                           11  MSG-NUM-DTRN                 PIC 9(02).
      *                                                                 
      *            Hora Transaccion                                     
                       09  MSG-HRA-HRTR.
                           11  MSG-NUM-HHTR                 PIC 9(02).
                           11  MSG-NUM-MMTR                 PIC 9(02).
                           11  MSG-NUM-SSTR                 PIC 9(02).
      *                                                                 
      *    Indicador Tipo Accion                                        
           03  MSG-MSC-TACC                             PIC X(01).      
      *                                                                 
      *    Indicador Status                                             
           03  MSG-MSC-STAT                             PIC X(01).      
      *                                                                 
      *    Indicador Vigencia                           GNS VIGE        
           03  MSG-IND-VIGE  REDEFINES  MSG-MSC-STAT    PIC X(01).      
      *                                                                 
      *    Codigo Origen Transaccion                                    
           03  MSG-COD-OTRN.                                            
      *                                                                 
      *        Indicador Tipo Origen                                    
               05  MSG-MSC-TTRN                         PIC X(01).      
      *                                                                 
      *        Codigo Tipo Origen                                       
               05  MSG-COD-TTRN                         PIC X(03).      
      *                                                                 
      *    Autor Transaccion                                            
           03  MSG-COD-ATRN                             PIC X(12).      
      *                                                                 
      *KEY Tipo + Codigo ( Interno Computacional )                      
           03  MSG-KY1-TABS.
               05  MSG-CIC-TABL.
      *                                                                 
      *        Codigo Tipo Tabla                                        
                   07  MSG-CIC-TTAB                         PIC X(03).
      *                                                                 
      *        Codigo Mensaje                                           
                   07  MSG-CIC-MENS.
      *                                                                 
      *            Tipo Mensaje                                         
                       09  MSG-CIC-TMSG                     PIC X(07).
      *                                                                 
      *            Codigo Mensaje                                       
                       09  MSG-CIC-CMSG                     PIC X(05).
      *                                                                 
      *    Codigo Externo                                               
           03  MSG-KY2-TABS.
               05  MSG-EXT-TABL.
      *                                                                 
      *        Codigo Tipo Tabla                                        
                   07  MSG-EXT-TTAB                         PIC X(03).
      *                                                                 
      *        Codigo Tabla                                             
                   07  MSG-EXT-CTAB                         PIC X(05).
      *                                                                 
      *    Descripcion Corta                                            
           03  MSG-GLS-DCOR                             PIC X(12).      
      *                                                                 
      *    Abreviacion Descripcion                                      
           03  MSG-GLS-ABRV                             PIC X(05).      
      *                                                                 
      *    Descripcion del Codigo                                       
           03  MSG-GLS-DESC.                                            
               05  MSG-GLS-DES1                         PIC X(20).      
               05  MSG-GLS-DES2                         PIC X(20).      
      *                                                                 
      *    Datos Anexos                                                 
           03  MSG-GLS-DATA.                                            
      *                                                                 
      *        Glosa Mensaje                                            
               05  MSG-GLS-MENS                         PIC X(40).      
      *                                                                 
      *        Disponible                                               
               05  MSG-GLS-DISP                         PIC X(20).      
      *                                                                 
      *    Clave Soundex                                                
           03  MSG-SNX-TABL.                                            
               05  MSG-SNX-TTAB                         PIC X(03).      
               05  MSG-SNX-MENS                         PIC X(03).      
      *                                                                 
      *    Variables de Mensajes                                        
       01  MSG-VARI.                                                    
      *                                                                 
      *    Nombre de Programa FIO para Mensajes                         
           03  MSG-GLS-FMSG.                                            
      *                                                                 
      *        Codigo Sistema                                           
               05  MSG-COD-SIST                         PIC X(03).      
      *                                                                 
      *        Nombre 'fijo' de FIO Mensajes                            
               05  MSG-COD-FMSG           VALUE 'PFTAB' PIC X(05).      
      *