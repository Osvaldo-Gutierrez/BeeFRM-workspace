      * Variables para rutina redondeo decimales                        00000010
      *DAD  14-ABR-1993  AUMENTO A 13 ENTEROS VARIABLES                 00000020
      *DAD  02-AGO-1994  AGREGADA VARIABLE COD-VCAM                     00000030
       01  PES-VARI.                                                    00000040
           03  PES-NUM-DECI          VALUE ZEROES       PIC 9(01).      00000050
           03  PES-SGV-DECI             COMP-3          PIC S9(13)V9(4).00000060
           03  PES-SGV-ENTE             COMP-3          PIC S9(13)V9(4).00000070
           03  PES-SGV-ENT0             COMP-3          PIC S9(13).     00000080
           03  PES-SGV-ENT1             COMP-3          PIC S9(13)V9(1).00000090
           03  PES-SGV-ENT2             COMP-3          PIC S9(13)V9(2).00000100
           03  PES-SGV-ENT3             COMP-3          PIC S9(13)V9(3).00000110
           03  PES-COD-VCAM VALUE SPACES                PIC X(06).      00000120
           03  PES-CIC-VCAM VALUE SPACES.                               00000130
               04 PES-CIC-TVAL                          PIC X(01).      00000140
               04 PES-CIC-CVAL                          PIC X(03).      00000150
               04 PES-CIC-TCAM                          PIC X(08).      00000160
                                                                        00000170
      * ISP: INDEPENDENCIA DE CICS DE MONEDAS                           00000180
       01  PDB-VARI.                                                    00000190
      *    03  PDB-CIC-0999     VALUE '0999  '   PIC X(06).             00000200
           03  PDB-CIC-0999     VALUE '0999  '   PIC X(06).             00000210
                                                                        00000220
      *    03  PDB-CIC-0998     VALUE '0998  '   PIC X(06).             00000230
           03  PDB-CIC-0998     VALUE '0998  '   PIC X(06).             00000240
                                                                        00000250
           03  PDB-CIC-0013     VALUE '0994  '   PIC X(06).             00000260
      *    03  PDB-CIC-0013     VALUE '0013  '   PIC X(06).             00000270
                                                                        00000280
      *    03  PDB-CIC-1013     VALUE '1013  '   PIC X(06).             00000290
           03  PDB-CIC-1013     VALUE '1013  '   PIC X(06).             00000300
                                                                        00000310
      *    03  PDB-CIC-MNAC     VALUE '0'        PIC X(01).             00000320
           03  PDB-CIC-MNAC     VALUE '0'        PIC X(01).             00000330
                                                                        00000340
      *    03  PDB-CIC-MEXT     VALUE '1'        PIC X(01).             00000350
           03  PDB-CIC-MEXT     VALUE '1'        PIC X(01).             00000360
                                                                        00000370
      *    03  PDB-COD-TVAL-DOLO   VALUE '01'    PIC X(02).             00000380
           03  PDB-COD-TVAL-DOLO   VALUE '01'    PIC X(02).             00000390
                                                                        00000400
