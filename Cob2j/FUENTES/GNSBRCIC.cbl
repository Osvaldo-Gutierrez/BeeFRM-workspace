      *    CODIGO INTERNO COMPUTACIONAL                                 00000010
      *    ----------------------------                                 00000020
      *                                                                 00000030
      *    Nombre Registro : CIC                                        00000040
      *    Clave(s)        : CIC-CAI-ICIC(UU)                           00000050
      *    Largo           : 48                                         00000060
      *    Bloqueo         : 1                                          00000070
      *    Observaciones   :                                            00000080
      *                                                                 00000090
       01  CIC.                                                         00000100
      *                                                                 00000110
      *    Filler Compatibilidad VSAM/MVS                               00000120
           03  CIC-GLS-FLAG                             PIC X(01).      00000130
      *                                                                 00000140
      *KEY Clave Primaria Registro                                      00000150
           03  CIC-KEY-IREG.                                            00000160
      *                                                                 00000170
      *        Identificacion Entidad                                   00000180
               05  CIC-KEY-ICIC.                                        00000190
      *                                                                 00000200
      *            Codigo Interno Computacional                         00000210
                   07  CIC-CIC-ICIC.                                    00000220
      *                                                                 00000230
      *                Centro Asignacion Identificacion                 00000240
                       09  CIC-CAI-ICIC.                                00000250
                           11  CIC-COD-TCIC             PIC X(01).      00000260
                           11  CIC-COD-CCIC             PIC X(03).      00000270
      *                                                                 00000280
      *                Identificacion Interna Computacional             00000290
                       09  CIC-NUM-ICIC                 PIC 9(08).      00000300
                       09  CIC-IIC-ICIC REDEFINES CIC-NUM-ICIC.         00000310
                           11  CIC-COD-OCIC.                            00000320
                               13  CIC-COD-SCIC         PIC X(02).      00000330
                               13  CIC-IND-SCIC         PIC X(01).      00000340
                           11  CIC-GLS-NCIC             PIC X(05).      00000350
      *                                                                 00000360
      *        Time Stamp Transaccion                                   00000370
               05  CIC-STP-ITRN.                                        00000380
      *                                                                 00000390
      *            Fecha Transaccion                                    00000400
                   07  CIC-FEC-FTRN.                                    00000410
                       09  CIC-NUM-STRN                 PIC 9(02).      00000420
                       09  CIC-NUM-ATRN                 PIC 9(02).      00000430
                       09  CIC-NUM-MTRN                 PIC 9(02).      00000440
                       09  CIC-NUM-DTRN                 PIC 9(02).      00000450
      *                                                                 00000460
      *            Hora Transaccion                                     00000470
                   07  CIC-HRA-HRTR.                                    00000480
                       09  CIC-NUM-HHTR                 PIC 9(02).      00000490
                       09  CIC-NUM-MMTR                 PIC 9(02).      00000500
                       09  CIC-NUM-SSTR                 PIC 9(02).      00000510
      *                                                                 00000520
      *    Indicador Tipo Accion                                        00000530
           03  CIC-MSC-TACC                             PIC X(01).      00000540
      *                                                                 00000550
      *    Indicador Status                                             00000560
           03  CIC-MSC-STAT                             PIC X(01).      00000570
      *                                                                 00000580
      *    Indicador de Vigencia Centro Asignacion                      00000590
           03  CIC-IND-VIGE REDEFINES CIC-MSC-STAT      PIC X(01).      00000600
      *                                                                 00000610
      *    Codigo Origen Transaccion                                    00000620
           03  CIC-COD-OTRN.                                            00000630
      *                                                                 00000640
      *        Indicador Tipo Origen                                    00000650
               05  CIC-MSC-TTRN                         PIC X(01).      00000660
      *                                                                 00000670
      *        Codigo Tipo Origen                                       00000680
               05  CIC-COD-TTRN                         PIC X(03).      00000690
      *                                                                 00000700
      *    Autor Transaccion                                            00000710
           03  CIC-COD-ATRN                             PIC X(12).      00000720
      *                                                                 00000730
      *    Disponible                                                   00000740
           03  CIC-GLS-DISP                             PIC X(03).      00000750
