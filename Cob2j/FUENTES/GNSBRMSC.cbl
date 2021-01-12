      *    Registro Generico de Miscelaneos                             
      *    --------------------------------                             
      *                                                                 
      *    Nombre Registro : MSC                                        
      *    Clave(s)        : MSC-KY0-TABS(UU),
      *                      MSC-KY1-TABS(UU), MSC-KY2-TABS(DC)
      *    Largo           : 206
      *    Bloqueo         : 2                                          
      *    Observaciones   :                                            
      *                                                                 
       01  MSC.                                                         
      *                                                                 
      *    Filler Compatibilidad VSAM/MVS                               
           03  MSC-GLS-FLAG                             PIC X(01).      
      *                                                                 
      *    Clave Primaria Registro                                      
           03  MSC-KEY-IREG.                                            
      *                                                                 
      *KEY     Tipo + Codigo ( LLave Primaria )                         
               05  MSC-KY0-TABS.
                   07  MSC-COD-TABL.
      *                                                                 
      *            Codigo Tipo Tabla                                    
                       09  MSC-COD-TTAB                 PIC X(03).
      *                                                                 
      *            Codigo Miscelaneo                                    
                       09  MSC-COD-MSCL.
      *                                                                 
      *                Tipo Miscelaneo                                  
                           11  MSC-COD-TMSC             PIC X(04).
      *                                                                 
      *                Codigo Miscelaneo                                
                           11  MSC-COD-CMSC             PIC X(08).
      *                                                                 
      *        Time Stamp Transaccion                                   
               05  MSC-COD-ITRS.
                   07  MSC-STP-ITRN.
      *                                                                 
      *            Fecha Transaccion                                    
                       09  MSC-FEC-FTRN.
                           11  MSC-NUM-STRN             PIC 9(02).
                           11  MSC-NUM-ATRN             PIC 9(02).
                           11  MSC-NUM-MTRN             PIC 9(02).
                           11  MSC-NUM-DTRN             PIC 9(02).
      *                                                                 
      *            Hora Transaccion                                     
                       09  MSC-HRA-HRTR.
                           11  MSC-NUM-HHTR             PIC 9(02).
                           11  MSC-NUM-MMTR             PIC 9(02).
                           11  MSC-NUM-SSTR             PIC 9(02).
      *                                                                 
      *    Indicador Tipo Accion                                        
           03  MSC-MSC-TACC                             PIC X(01).      
      *                                                                 
      *    Indicador Status                                             
           03  MSC-MSC-STAT                             PIC X(01).      
      *                                                                 
      *    Indicador Vigencia                           GNS VIGE        
           03  MSC-IND-VIGE  REDEFINES  MSC-MSC-STAT    PIC X(01).      
      *                                                                 
      *    Codigo Origen Transaccion                                    
           03  MSC-COD-OTRN.                                            
      *                                                                 
      *        Indicador Tipo Origen                                    
               05  MSC-MSC-TTRN                         PIC X(01).      
      *                                                                 
      *        Codigo Tipo Origen                                       
               05  MSC-COD-TTRN                         PIC X(03).      
      *                                                                 
      *    Autor Transaccion                                            
           03  MSC-COD-ATRN                             PIC X(12).      
      *                                                                 
      *KEY Tipo + Codigo ( Interno Computacional )                      
           03  MSC-KY1-TABS.
               05  MSC-CIC-TABL.
      *                                                                 
      *        Codigo Tipo Tabla                                        
                   07  MSC-CIC-TTAB                     PIC X(03).
      *                                                                 
      *        Codigo Miscelaneo                                        
                   07  MSC-CIC-MSCL.
      *                                                                 
      *            Tipo Miscelaneo                                      
                       09  MSC-CIC-TMSC                 PIC X(04).
      *                                                                 
      *            Codigo Miscelaneo                                    
                       09  MSC-CIC-CMSC                 PIC X(08).
      *                                                                 
      *    Codigo Externo                                               
           03  MSC-KY2-TABS.
               05  MSC-EXT-TABL.
      *                                                                 
      *        Codigo Tipo Tabla                                        
                   07  MSC-EXT-TTAB                     PIC X(03).
      *                                                                 
      *        Codigo Tabla                                             
                   07  MSC-EXT-CTAB.
      *                                                                 
      *            Tipo Miscelaneo                                      
                       09  MSC-EXT-TMSC                 PIC X(04).
      *                                                                 
      *            Codigo Miscelaneo                                    
                       09  MSC-EXT-CMSC                 PIC X(01).
      *                                                                 
      *    Descripcion Corta                                            
           03  MSC-GLS-DCOR                             PIC X(12).      
      *                                                                 
      *    Abreviacion Descripcion                                      
           03  MSC-GLS-ABRV                             PIC X(05).      
      *                                                                 
      *    Descripcion del Codigo                                       
           03  MSC-GLS-DESC                             PIC X(40).      
      *                                                                 
      *    Datos Anexos                                                 
           03  MSC-GLS-DATA.                                            
      *                                                                 
      *        Glosa Mensaje                                            
               05  MSC-GLS-MENS                         PIC X(40).      
      *                                                                 
      *        Codigo Mensaje                                           
               05  MSC-COD-MENS                         PIC X(12).      
      *                                                                 
      *        Disponible                                               
               05  MSC-GLS-DISP                         PIC X(08).      
      *                                                                 
           03  MSC-GLS-DATA-RED REDEFINES MSC-GLS-DATA.                 
               05  MSC-GLS-DAT1.                                        
                   07  MSC-COD-DAT1     OCCURS 10       PIC X(01).      
               05  MSC-GLS-DAT2.                                        
                   07  MSC-COD-DAT2     OCCURS 10       PIC X(02).      
               05  MSC-GLS-DAT3.                                        
                   07  MSC-COD-DAT3     OCCURS 10       PIC X(03).      
      *                                                                 
      *    Clave Soundex                                                
           03  MSC-SNX-TABL.                                            
               05  MSC-SNX-TTAB                         PIC X(03).      
               05  MSC-SNX-MSCL                         PIC X(03).      
      *                                                                 
      *    Variables Miscelaneas                                        
       01  MSC-VARI.                                                    
      *                                                                 
      *    Codigo Sistema                                               
           03  MSC-COD-SIST                             PIC X(03).      
      *
