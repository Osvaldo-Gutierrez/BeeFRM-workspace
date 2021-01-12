      * PTC:                                                            
      * VARIABLES SCR- 2.0                                              
       01  OSC-VARI.                                                    
           03 OSC-TCMA  COMP              PIC S9(04).                   
           03 OSC-SIST                    PIC X(03).                    
           03 OSC-FUNC                    PIC X(08).                    
           03 OSC-NEMO                    PIC X(12).                    
      *    03 OSC-CPRO                    PIC X(06).                    
           03 OSC-RFBY                    PIC X(01).                    
      *    03 FILLER                      PIC X(05).                    
           03 OSC-NTRV                    PIC X(04).                    
           03 FILLER                      PIC X(01).                    
      *                                                                 
           03 OSC-NTRN                    PIC X(04).                    
           03 OSC-PROG                    PIC X(08).                    
           03 IFD-PROG REDEFINES OSC-PROG PIC X(08).                    
           03 OSC-NLIB                    PIC X(07).                    
           03 OSC-NMAP                    PIC X(07).                    
           03 OSC-LDOC                    PIC X(25).                    
           03 OSC-NDOC                    PIC X(12).                    
           03 OSC-FRET                    PIC X(12).                    
           03 OSC-IPRV                    PIC X(01).                    
           03 OSC-SISG                    PIC X(03).                    
           03 OSC-STAT                    PIC X(01).                    
           03 OSC-INST                    PIC X(03).                    
           03 OSC-VFLD                    PIC X(01).                    
           03 OSC-ACTU                    PIC X(03).                    
           03 OSC-TFUN                    PIC X(03).                    
           03 OSC-CMNP                    PIC X(08).                    
           03 OSC-FFLD                    PIC X(01).                    
              88 OSC-FFLD-RET   VALUE ''''.                             
              88 OSC-FFLD-PF1   VALUE '1'.                              
              88 OSC-FFLD-PF2   VALUE '2'.                              
              88 OSC-FFLD-PF3   VALUE '3'.                              
              88 OSC-FFLD-PF4   VALUE '4'.                              
              88 OSC-FFLD-PF5   VALUE '5'.                              
              88 OSC-FFLD-PF6   VALUE '6'.                              
              88 OSC-FFLD-PF7   VALUE '7'.                              
              88 OSC-FFLD-PF8   VALUE '8'.                              
              88 OSC-FFLD-PF9   VALUE '9'.                              
              88 OSC-FFLD-PF10  VALUE ':'.                              
              88 OSC-FFLD-PF11  VALUE '#'.                              
              88 OSC-FFLD-PF12  VALUE '@'.                              
              88 OSC-FFLD-PFA   VALUE 'A'.                              
              88 OSC-FFLD-PFB   VALUE 'B'.                              
              88 OSC-FFLD-PFC   VALUE 'C'.                              
              88 OSC-FFLD-PFD   VALUE 'D'.                              
              88 OSC-FFLD-PFE   VALUE 'E'.                              
              88 OSC-FFLD-PFF   VALUE 'F'.                              
              88 OSC-FFLD-PFG   VALUE 'G'.                              
              88 OSC-FFLD-PFH   VALUE 'H'.                              
              88 OSC-FFLD-PFI   VALUE 'I'.                              
              88 OSC-FFLD-PFJ   VALUE ':'.                              
              88 OSC-FFLD-PFK   VALUE '.'.                              
              88 OSC-FFLD-PFL   VALUE '<'.                              
           03 OSC-I                       PIC 9(02).                    
           03 OSC-CMND                    PIC X(03).                    
           03 OSC-MFLD                    PIC X(01).                    
           03 OSC-PRMC                    PIC X(25).                    
           03 OSC-CCPP                    PIC X(03).                    
           03 OSC-STPP                    PIC X(01).                    
           03 OSC-CRPF.                                                 
              05 OSC-TABL OCCURS 10   INDEXED BY OSC-ITBL.              
                 07 OSC-COD-CCMN          PIC X(03).                    
                 07 OSC-COD-CCPP          PIC X(03).                    
                 07 OSC-IND-STPP          PIC X(01).                    
              05 OSC-GLS-UARC             PIC X(12) OCCURS 10.          
              05 OSC-GLS-PRMT             PIC X(25) OCCURS 10.          
              05 OSC-GLS-CONF             PIC X(25) OCCURS 10.          
           03 OSC-USER                    PIC X(12).                    
           03 OSC-OTRN                    PIC X(04).                    
      *    03 FILLER                      PIC X(09).                    
           03 OSC-PROV                    PIC X(08).                    
           03 FILLER                      PIC X(01).                    
      *                                                                 
           03 OSC-UMOD                    PIC X(14).                    
           03 IFD-FSIS.                                                 
              05 IFD-VSIS OCCURS 30   INDEXED BY IFD-ITBL.              
                 07 IFD-DSIS.                                           
                    09 IFD-SIST           PIC X(03).                    
                    09 IFD-QSIS           PIC X(01).                    
                 07 IFD-GSIS              PIC X(03).                    
           03 OSC-ICMN                    PIC X(01).                    
              88 OSC-DESDE-MEN VALUE 'M'.                               
              88 OSC-DESDE-HDR VALUE 'H'.                               
              88 OSC-DESDE-CMN VALUE 'C'.                               
              88 OSC-DESDE-PGM VALUE 'P'.                               
           03 OSC-OFRM                    PIC X(01).                    
              88 OSC-OFRM-SRV   VALUE 'S'.                              
              88 OSC-OFRM-BMS   VALUE 'B'.                              
           03 OSC-IERR                    PIC X(01).                    
              88 OSC-IERR-YES   VALUE 'S'.                              
              88 OSC-IERR-NOT   VALUE 'N'.                              
           03 OSC-DISP                    PIC X(03).                    