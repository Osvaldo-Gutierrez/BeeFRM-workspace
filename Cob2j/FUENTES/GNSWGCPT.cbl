      * Variables para compactar blancos de un string de caracteres     00000010
       01  CPT-VARI.                                                    00000020
           03 CPT-STRN.                                                 00000030
              05 CPT-STR1                         PIC  X(40).           00000040
              05 CPT-STR2                         PIC  X(60).           00000050
           03 CPT-STRN-RED REDEFINES CPT-STRN     PIC  X(01)            00000060
                           OCCURS 100.                                  00000070
           03 CPT-LENG                  VALUE 100 PIC  9(03).           00000080
           03 CPT-IBLK                            PIC  X(01).           00000090
              88 CPT-PONGO-BLANCO       VALUE 'S'.                      00000100
           03 CPT-UBLK                  VALUE 0   PIC  9(03).           00000110
           03 CPT-I                     VALUE 0   PIC  9(03).           00000120
           03 CPT-J                     VALUE 0   PIC  9(03).           00000130
