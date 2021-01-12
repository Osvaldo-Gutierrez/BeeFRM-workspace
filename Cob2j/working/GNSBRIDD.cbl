      *    Registro Independencia de Datos                              
      *    -------------------------------                              
      *                                                                 
      *    Nombre Registro : IDD                                        
      *    Clave(s)        : IDD-COD-CIDD                               
      *    Largo           : 490                                        
      *    Bloqueo         : 1                                          
      *    Observaciones   :                                            
      *                                                                 
       01  IDD.                                                         
      *                                                                 
      *    Filler Compatibilidad VSAM/MVS                               
           03 IDD-GLS-FLAG                              PIC X(01).      
      *                                                                 
      *    Codigo Identificacion IDD ( Clave Primaria Registro )        
           03 IDD-COD-CIDD                              PIC X(12).      
      *                                                                 
      *    Tabla Independencia de datos                                 
           03 IDD-GLS-FSIS.                                             
              05 IDD-GLS-VSIS OCCURS 43 INDEXED BY IDD-NUM-ITBL.        
      *                                                                 
      *          Descripcion de la entidad                              
                 07 IDD-GLS-DENT.                                       
      *                                                                 
      *             Sistema                                             
                    09 IDD-COD-SIST                     PIC X(03).      
      *                                                                 
      *             Grupo                                               
                    09 IDD-COD-GRPO                     PIC X(01).      
      *                                                                 
      *             Registro                                            
                    09 IDD-COD-RGST                     PIC X(03).      
      *                                                                 
      *          Tipo de la Entidad                                     
                 07 IDD-COD-TENT                        PIC X(01).      
      *                                                                 
      *          Identificacion de la Entidad                           
                 07 IDD-COD-IENT                        PIC X(03).      
      *                                                                 
      *    Disponible                                                   
           03 IDD-GLS-DISP                              PIC X(04).      
      *
