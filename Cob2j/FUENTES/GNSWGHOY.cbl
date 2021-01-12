      * Variables para Current-Date                                     00000010
       01  HOY-VARI.                                                    00000020
           03 HOY-STP-ITRN.                                             00000030
              05 HOY-FHOY.                                              00000040
                 07 HOY-SHOY                      PIC 9(02).            00000050
                 07 HOY-AHOY                      PIC 9(02).            00000060
                 07 HOY-MHOY                      PIC 9(02).            00000070
                 07 HOY-DHOY                      PIC 9(02).            00000080
              05 HOY-HHOY                         PIC 9(06).            00000090
              05 HOY-HHOY-RED REDEFINES HOY-HHOY.                       00000100
                 07 HOY-HHHY                      PIC 9(02).            00000110
                 07 HOY-MMHY                      PIC 9(02).            00000120
                 07 HOY-SSHY                      PIC 9(02).            00000130
