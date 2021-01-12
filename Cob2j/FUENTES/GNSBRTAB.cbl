      * COPY GNSBRTAB.                                                   
      *    Registro Generico de Tablas                                  
      *    NECESARIO PARA COMPILAR CICS RESCATADO EL 02.07.98.          
      *    ---------------------------                                  
      *                                                                 
      *    Nombre Registro : TAB                                        
      *    Clave(s)        : TAB-KY0-TABS(UU),
      *                      TAB-KY1-TABS(UU), TAB-KY1-TABS(DC)
      *    Largo           : 206
      *    Bloqueo         : 2                                          
      *    Observaciones   :                                            
      *                                                                 
       01  TAB.                                                         
      *                                                                 
      *    Filler Compatibilidad VSAM/MVS                               
           03  TAB-GLS-FLAG                             PIC X(01).      
      *                                                                 
      *    Clave Primaria Registro                                      
           03  TAB-KEY-IREG.                                            
      *                                                                 
      *KEY     Tipo + Codigo ( LLave Primaria )                         
               05  TAB-KY0-TABS.
                   07  TAB-COD-TABL.
      *                                                                 
      *            Codigo Tipo Tabla                                    
                       09  TAB-COD-TTAB                 PIC X(03).
      *                                                                 
      *            Codigo Tabla                                         
                       09  TAB-COD-CTAB                 PIC X(12).
      *                                                                 
      *        Time Stamp Transaccion                                   
               05  TAB-COD-ITRS.
                   07  TAB-STP-ITRN.
      *                                                                 
      *            Fecha Transaccion                                    
                       09  TAB-FEC-FTRN.
                           11  TAB-NUM-STRN             PIC 9(02).
                           11  TAB-NUM-ATRN             PIC 9(02).
                           11  TAB-NUM-MTRN             PIC 9(02).
                           11  TAB-NUM-DTRN             PIC 9(02).
      *                                                                 
      *            Hora Transaccion                                     
                       09  TAB-HRA-HRTR.
                           11  TAB-NUM-HHTR             PIC 9(02).
                           11  TAB-NUM-MMTR             PIC 9(02).
                           11  TAB-NUM-SSTR             PIC 9(02).
      *                                                                 
      *    Indicador Tipo Accion                                        
           03  TAB-MSC-TACC                             PIC X(01).      
      *                                                                 
      *    Indicador Status                                             
           03  TAB-MSC-STAT                             PIC X(01).      
      *                                                                 
      *    Indicador Vigencia                           GNS VIGE        
           03  TAB-IND-VIGE  REDEFINES  TAB-MSC-STAT    PIC X(01).      
      *                                                                 
      *    Codigo Origen Transaccion                                    
           03  TAB-COD-OTRN.                                            
      *                                                                 
      *        Indicador Tipo Origen                                    
               05  TAB-MSC-TTRN                         PIC X(01).      
      *                                                                 
      *        Codigo Tipo Origen                                       
               05  TAB-COD-TTRN                         PIC X(03).      
      *                                                                 
      *    Autor Transaccion                                            
           03  TAB-COD-ATRN                             PIC X(12).      
      *                                                                 
      *KEY Tipo + Codigo ( Interno Computacional )                      
           03  TAB-KY1-TABS.
               05  TAB-CIC-TABL.
      *                                                                 
      *        Codigo Tipo Tabla                                        
                   07  TAB-CIC-TTAB                     PIC X(03).
      *                                                                 
      *        Codigo Tabla                                             
                   07  TAB-CIC-CTAB                     PIC X(12).
      *                                                                 
      *    Codigo Externo                                               
           03  TAB-KY2-TABS.
               05  TAB-EXT-TABL.
      *                                                                 
      *        Codigo Tipo Tabla                                        
                   07  TAB-EXT-TTAB                     PIC X(03).
      *                                                                 
      *        Codigo Tabla                                             
                   07  TAB-EXT-CTAB                     PIC X(05).
      *                                                                 
      *    Descripcion Corta                                            
           03  TAB-GLS-DCOR                             PIC X(12).      
      *                                                                 
      *    Abreviacion Descripcion                                      
           03  TAB-GLS-ABRV                             PIC X(05).      
      *                                                                 
      *    Descripcion del Codigo                                       
           03  TAB-GLS-DESC                             PIC X(40).      
      *                                                                 
      *    Datos Anexos                                                 
           03  TAB-GLS-DATA.                                            
               05  TAB-GLS-DAT1.                                        
                   07  TAB-COD-DAT1     OCCURS 10       PIC X(01).      
               05  TAB-GLS-DAT2.                                        
                   07  TAB-COD-DAT2     OCCURS 10       PIC X(02).      
               05  TAB-GLS-DAT3.                                        
                   07  TAB-COD-DAT3     OCCURS 10       PIC X(03).      
      *                                                                 
      *    Clave Soundex                                                
           03  TAB-SNX-TABL.                                            
               05  TAB-SNX-TTAB                         PIC X(03).      
               05  TAB-SNX-CTAB                         PIC X(03).      
      *                                                                 
      *    Variables de Tablas                                          
       01  TAB-VARI.                                                    
      *                                                                 
      *    Nombre de Programa FIO para TABlas                           
           03  TAB-GLS-FTAB.                                            
      *                                                                 
      *        Codigo Sistema                                           
               05  TAB-COD-SIST                         PIC X(03).      
      *                                                                 
      *        Nombre 'fijo' de FIO TABlas                              
               05  TAB-COD-FTAB           VALUE 'PFTAB' PIC X(05).      
      *