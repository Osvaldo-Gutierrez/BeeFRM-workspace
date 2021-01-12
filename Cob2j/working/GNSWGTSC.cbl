      *Variables de procesador de menu y comandos                       
      *10-JUL-1990 14:50                                                
       01  TSC-CTTS.                                                    
           03 TSC-TTSC COMP             VALUE 894 PIC 9(04).            
       01  TSC-VARI.                                                    
           03 TSC-COLA.                                                 
              05  TSC-TYPE VALUE 'GTSC'           PIC X(04).            
              05  TSC-TERM                        PIC X(04).            
           03 TSC-LITM COMP                       PIC S9(04).           
           03 TSC-ITEM.                                                 
              05  TSC-ICMN                        PIC X(01).            
              05  TSC-TFUN                        PIC X(03).            
                  88 TSC-TFUN-OLD VALUE 'PGI' 'HMC' 'HMX'               
                                        'XMC' 'XMX' 'RET'.              
                  88 TSC-TFUN-NPC VALUE 'NPC'.                          
              05  TSC-INST                        PIC X(03).            
              05  TSC-PROG                        PIC X(08).            
              05  TSC-NTRN                        PIC X(04).            
              05  TSC-SIST                        PIC X(03).            
              05  TSC-SISG                        PIC X(03).            
              05  TSC-FRET                        PIC X(12).            
              05  TSC-FFLD                        PIC X(01).            
              05  TSC-NEMO                        PIC X(12).            
              05  TSC-CMNP                        PIC X(12).            
              05  TSC-CMND                        PIC X(03).            
              05  TSC-OPCI                        PIC X(03).            
              05  TSC-NLIB                        PIC X(07).            
              05  TSC-NMAP                        PIC X(07).            
              05  TSC-LDOC                        PIC X(12).            
              05  TSC-NDOC                        PIC X(25).            
              05  TSC-IPRV                        PIC X(01).            
              05  TSC-TINS                        PIC X(03).            
              05  TSC-TCTL                        PIC X(04).            
              05  TSC-TINF.                                             
                  07  TSC-TINV                    PIC X(01).            
                  07  TSC-TIND                    PIC X(01).            
                  07  FILLER                      PIC X(01).            
              05  TSC-TCMA               COMP PIC S9(04).               
              05  TSC-PROV                        PIC X(12).            
              05  TSC-NTRV                        PIC X(04).            
              05  TSC-CIDD                        PIC X(12).            
                                                                        
              05  TSC-I                           PIC 9(02).            
              05  TSC-PRMC                        PIC X(25).            
              05  TSC-USER                        PIC X(12).            
              05  TSC-OTRN                        PIC X(04).            
              05  TSC-CRPF.                                             
                  07  TSC-TABL OCCURS 10 INDEXED BY TSC-ITBL.           
                      09  TSC-CCMN                PIC X(03).            
                      09  TSC-CCPP                PIC X(03).            
                      09  TSC-STPP                PIC X(01).            
                      09  TSC-PRMT                PIC X(25).            
                      09  TSC-CONF                PIC X(25).            
                      09  TSC-UARC.                                     
                          11  TSC-NUAR            PIC X(08).            
                          11  TSC-TUAR            PIC X(04).            
              05  TSC-RFBY                        PIC X(01).            
