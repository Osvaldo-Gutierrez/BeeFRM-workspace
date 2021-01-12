      *    Request Area                                                 
       01  ADR-REQA.                                                    
      *    Comando                                                      
           03 ADR-CMND                                  PIC  X(05).     
      *    Tabla                                                        
           03 ADR-TABL                                  PIC  X(03).     
      *    Descripcion de llave                                         
           03 ADR-DKEY                                  PIC  X(05).     
      *    Status                                                       
           03 ADR-STAT                  VALUE SPACES    PIC  X(02).     
              88 ADR-STAT-OKS           VALUE SPACES.                   
      *    Sub Status                                                   
           03 ADR-SSTT                  VALUE SPACES    PIC  X(01).     
      *    Identificacion de la base de datos                           
           03 ADR-DBID                          COMP    PIC S9(04).     
      *    Identificacion del Registro                                  
           03 ADR-RCID                                  PIC  X(07).     
      *    Reservado                                                    
           03 FILLER                                    PIC  X(25).     
      *    Contador Maximo                                              
           03 ADR-CTMX                          COMP    PIC S9(04).     
      *    Contador de Input/Output                                     
           03 ADR-CTIO                          COMP    PIC S9(04).     
      *    Reservado                                                    
           03 FILLER                                    PIC  X(22).     
      *    Valor de Llave                                               
           03 ADR-VKEY                                  PIC  X(180).    
      *    Valor de llave 1                                             
           03 ADR-VKY1                                  PIC  X(180).    
      *    Valor de llave 2                                             
           03 ADR-VKY2                                  PIC  X(180).    
