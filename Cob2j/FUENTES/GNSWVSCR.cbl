       01  SCR-VARI.                                                    
           03 SCR-TCMA  COMP              PIC S9(04).                   
           03 SCR-SIST                    PIC X(03).                    
           03 SCR-SISG                    PIC X(03).                    
           03 SCR-NTRN                    PIC X(04).                    
           03 SCR-PROG                    PIC X(08).                    
           03 SCR-NTRV                    PIC X(04).                    
           03 SCR-PROV                    PIC X(08).                    
           03 SCR-NLIB                    PIC X(07).                    
           03 SCR-NMAP                    PIC X(07).                    
           03 SCR-RFBY                    PIC X(01).                    
           03 SCR-STAT                    PIC X(01).                    
           03 SCR-INST                    PIC X(03).                    
           03 SCR-ACTU                    PIC X(03).                    
           03 SCR-CMNP                    PIC X(08).                    
           03 SCR-CRPF.                                                 
              05 SCR-CMND                 PIC X(03).                    
              05 SCR-CCPP                 PIC X(03).                    
              05 SCR-STPP                 PIC X(01).                    
              05 SCR-PRMT                 PIC X(25).                    
              05 SCR-CONF                 PIC X(25).                    
           03 SCR-USER                    PIC X(12).                    
           03 SCR-OTRN                    PIC X(04).                    
           03 SCR-UMOD                    PIC X(14).                    
           03 SCR-ICMN                    PIC X(01).                    
              88 SCR-DESDE-MEN VALUE 'M'.                               
              88 SCR-DESDE-HDR VALUE 'H'.                               
              88 SCR-DESDE-CMN VALUE 'C'.                               
              88 SCR-DESDE-PGM VALUE 'P'.                               
           03 SCR-QIDD                    PIC X(08).                    
           03 SCR-LIDD COMP               PIC S9(04).                   
      *                                                                 
           03 SCR-NEMO                    PIC X(12).                    
           03 SCR-LDOC                    PIC X(12).                    
      *    03 SCR-NDOC  PIC X(25).                                      
           03 SCR-NDOC.                                                 
              05 SCR-HDR-BNCO             PIC X(00003).                 
              05 SCR-HDR-MRCA             PIC X(00003).                 
              05 SCR-HDR-CART             PIC X(00003).                 
              05 SCR-HDR-LENG             PIC X(00002).                 
              05 SCR-HDR-PAIS             PIC X(00002).                 
              05 SCR-HDR-VRNT             PIC X(00001).                 
              05 SCR-NDOC-DISP            PIC X(00011).                 
           03 SCR-FRET                    PIC X(12).                    
           03 SCR-IPRV                    PIC X(01).                    
      *                                                                 
           03 SCR-MFLD                    PIC X(01).                    
           03 SCR-VFLD                    PIC X(01).                    
           03 SCR-FFLD                    PIC X(01).                    
              88 SCR-FFLD-RET   VALUE ''''.                             
              88 SCR-FFLD-PF1   VALUE '1'.                              
              88 SCR-FFLD-PF2   VALUE '2'.                              
              88 SCR-FFLD-PF3   VALUE '3'.                              
              88 SCR-FFLD-PF4   VALUE '4'.                              
              88 SCR-FFLD-PF5   VALUE '5'.                              
              88 SCR-FFLD-PF6   VALUE '6'.                              
              88 SCR-FFLD-PF7   VALUE '7'.                              
              88 SCR-FFLD-PF8   VALUE '8'.                              
              88 SCR-FFLD-PF9   VALUE '9'.                              
              88 SCR-FFLD-PF10  VALUE ':'.                              
              88 SCR-FFLD-PF11  VALUE '#'.                              
              88 SCR-FFLD-PF12  VALUE '@'.                              
              88 SCR-FFLD-PFA   VALUE 'A'.                              
              88 SCR-FFLD-PFB   VALUE 'B'.                              
              88 SCR-FFLD-PFC   VALUE 'C'.                              
              88 SCR-FFLD-PFD   VALUE 'D'.                              
              88 SCR-FFLD-PFE   VALUE 'E'.                              
              88 SCR-FFLD-PFF   VALUE 'F'.                              
              88 SCR-FFLD-PFG   VALUE 'G'.                              
              88 SCR-FFLD-PFH   VALUE 'H'.                              
              88 SCR-FFLD-PFI   VALUE 'I'.                              
              88 SCR-FFLD-PFJ   VALUE ''.                              
              88 SCR-FFLD-PFK   VALUE '.'.                              
              88 SCR-FFLD-PFL   VALUE '<'.                              
           03 SCR-DISP                    PIC X(25).                    