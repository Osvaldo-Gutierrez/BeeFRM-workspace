      *Variables para independencia de datos 15-JAN-1990 17:04:48       
       01  IDD-VARI.                                                    
           03 IDD-PROG                          PIC X(08).              
           03 IDD-DAUX.                                                 
              05 IDD-SAUX                       PIC X(03).              
              05 IDD-GAUX                       PIC X(01).              
              05 IDD-RAUX                       PIC X(03).              
           03 IDD-IAUX                          PIC 9(02).              
           03 IDD-REGI.                                                 
              05 FILLER                         PIC X(01).              
              05 IDD-CIDD                       PIC X(12).              
              05 IDD-FSIS.                                              
                 07 IDD-VSIS OCCURS 43 INDEXED BY IDD-ITBL.             
                    09 IDD-DENT.                                        
                       11 IDD-SIST              PIC X(03).              
                       11 IDD-GRPO              PIC X(01).              
                       11 IDD-RGST              PIC X(03).              
                    09 IDD-TENT                 PIC X(01).              
                    09 IDD-IENT                 PIC X(03).              
      *ESTE REDEFINES TIENE COMO PROPOSITO COMPILAR                     
      *PROGRAMAS NUEVOS CON FIO'S ANTIGUAS ( SIN GENERARLAS )           
      *              09 IFD-GSIS REDEFINES IDD-IENT                     
      *                                          PIC X(03).             
              05 FILLER                         PIC X(04).              
