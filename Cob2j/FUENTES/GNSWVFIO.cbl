      *    Variables para las rutinas FIO's                             00000010
      *    ( Linkage Section para VSAM BATCH )                          00000020
       01  FIO-VARI.                                                    00000030
      *                                                                 00000040
      *    Nombre de la llave alternativa                               00000050
           03 FIO-AKEY       VALUE SPACES               PIC X(32).      00000060
      *                                                                 00000070
      *    Esta variable FILE STATUS es el codigo de retorno            00000080
      *    de las subrutinas FIO                                        00000090
           03 FIO-STAT.                                                 00000100
      *                                                                 00000110
      *          Created Duplicate Key                                  00000120
                 88 FIO-STAT-CDK        VALUE '02'.                     00000130
      *                                                                 00000140
      *          End Of File                                            00000150
                 88 FIO-STAT-EOF        VALUE '10'.                     00000160
      *                                                                 00000170
      *          No Ascending Key                                       00000180
                 88 FIO-STAT-NAK        VALUE '21'.                     00000190
      *                                                                 00000200
      *          Invalid KeY                                            00000210
                 88 FIO-STAT-IKY        VALUE '22' '23'.                00000220
      *                                                                 00000230
      *          Duplicate Alternate Key                                00000240
                 88 FIO-STAT-DAK        VALUE '22'.                     00000250
      *                                                                 00000260
      *          Record Not Found                                       00000270
                 88 FIO-STAT-RNF        VALUE '23'.                     00000280
      *                                                                 00000290
      *          Boundary Violation Error                               00000300
                 88 FIO-STAT-BVE        VALUE '24' '34'.                00000310
      *                                                                 00000320
      *          Other Permanent Errors                                 00000330
                 88 FIO-STAT-OPE        VALUE '30'.                     00000340
      *                                                                 00000350
      *          Other Device Errors                                    00000360
                 88 FIO-STAT-ODE        VALUE '90'.                     00000370
      *                                                                 00000380
      *          PassWord Failure                                       00000390
                 88 FIO-STAT-PWF        VALUE '91'.                     00000400
      *                                                                 00000410
      *          LoGic Error                                            00000420
                 88 FIO-STAT-LGE        VALUE '92'.                     00000430
      *                                                                 00000440
      *          Resource Not Available                                 00000450
                 88 FIO-STAT-RNA        VALUE '93'.                     00000460
      *                                                                 00000470
      *          No Previous Read                                       00000480
                 88 FIO-STAT-NPR        VALUE '94'.                     00000490
      *                                                                 00000500
      *          Invalid or incomplete File Information                 00000510
                 88 FIO-STAT-IFI        VALUE '95'.                     00000520
      *                                                                 00000530
      *          Bad File Identification                                00000540
                 88 FIO-STAT-BFI        VALUE '96'.                     00000550
      *                                                                 00000560
      *          File Intergrity Verified                               00000570
                 88 FIO-STAT-FIV        VALUE '97'.                     00000580
      *JSS                                                              00000590
      *             Fatal                                               00000600
                    88 FIO-STAT-FTL        VALUE '99'.                  00000610
      *JSS                                                              00000620
      *             Duplicate Master Key                                00000630
                    88 FIO-STAT-DMK        VALUE '22'.                  00000640
      *JSS                                                              00000650
      *             Invalid Master Key                                  00000660
                    88 FIO-STAT-IMK        VALUE '23'.                  00000670
      *JSS                                                              00000680
      *             Special Deleted Record                              00000690
                    88 FIO-STAT-SDR        VALUE '43'.                  00000700
      *JSS                                                              00000710
      *             Exclusive Control Duplicate                         00000720
                    88 FIO-STAT-ECD        VALUE '44'.                  00000730
      *JSS                                                              00000740
      *             Set Selection Interrupt                             00000750
                    88 FIO-STAT-SSI        VALUE '45'.                  00000760
      *JSS                                                              00000770
      *             Attempt to Position PAST END/BEG-OF-SET             00000780
                    88 FIO-STAT-APS        VALUE '46'.                  00000790
      *JSS                                                              00000800
      *             Exclusive Control Interlock                         00000810
                    88 FIO-STAT-ECI        VALUE '47'.                  00000820
      *                                                                 00000830
                 05 FIO-STT1                    PIC 9(01).              00000840
      *                                                                 00000850
      *               OK Status                                         00000860
                      88 FIO-STAT-OKS   VALUE 0.                        00000870
      *                                                                 00000880
      *               At End Status                                     00000890
                      88 FIO-STAT-AES   VALUE 1.                        00000900
      *                                                                 00000910
      *               Invalid Key Status                                00000920
                      88 FIO-STAT-IKS   VALUE 2.                        00000930
      *                                                                 00000940
      *               ERRors                                            00000950
                      88 FIO-STAT-ERR   VALUE 3.                        00000960
      *JSS                                                              00000970
      *               DATACOM Errors                                    00000980
                      88 FIO-STAT-DTC   VALUE 4.                        00000990
      *                                                                 00001000
      *               Device Dependant Errors                           00001010
                      88 FIO-STAT-DDE   VALUE 9.                        00001020
      *                                                                 00001030
                 05 FIO-STT2                    PIC 9(01).              00001040
      *                                                                 00001050
      *               No Further Information                            00001060
                      88 FIO-STAT-NFI   VALUE 0.                        00001070
      *                                                                 00001080
      *               SEQuential access                                 00001090
                      88 FIO-STAT-SEQ   VALUE 1.                        00001100
      *                                                                 00001110
      *               DUPlicates                                        00001120
                      88 FIO-STAT-DUP   VALUE 2.                        00001130
      *                                                                 00001140
      *               No Current Record                                 00001150
                      88 FIO-STAT-NCR   VALUE 3.                        00001160
      *                                                                 00001170
      *    Esta variable RELATIVE KEY indica a las subrutinas FIO       00001180
      *    la llave de un archivo relativo para su acceso.              00001190
           03 FIO-RKEY          COMP            PIC 9(09).              00001200
      *                                                                 00001210
      *    Comando de las Subrutinas FIO                                00001220
           03 FIO-CMND                 VALUE  0 PIC 9(04).              00001230
      *                                                                 00001240
      *    Esta variable  ACCESS indica a las subrutinas                00001250
      *    FIO la forma de abrir un archivo en cuanto al                00001260
      *    acceso desde otros programas                                 00001270
           03 FIO-ACCS                      PIC 9(01).                  00001280
      *                                                                 00001290
      *       0 = DEFault access                                        00001300
      *       1 = NOT     access                                        00001310
      *       2 = INPut   access                                        00001320
      *       3 = UPDate  access                                        00001330
      *                                                                 00001340
      *    Esta variable RECORD LOCKED indica a las subrutinas          00001350
      *    FIO si tomar o no el control cuando hay un registro          00001360
      *    ocupado                                                      00001370
           03 FIO-RLCK                      PIC 9(01).                  00001380
      *                                                                 00001390
      *       0 = FIO     control on record locked ( Default )          00001400
      *       1 = ProGraM control on record locked                      00001410
      *                                                                 00001420
      *    Esta variable INPUT FILE NOT FOUND indica a las              00001430
      *    subrutinas  FIO si tomar o no el control cuando              00001440
      *    al abrir un archivo de Input, este no existe                 00001450
           03 FIO-IFNF                      PIC 9(01).                  00001460
      *                                                                 00001470
      *       0 = FIO     control on file not found                     00001480
      *       1 = ProGraM control on file not found                     00001490
      *                                                                 00001500
      *    Esta  variable  RECORD LENGTH  debe ser  llenada  con el     00001510
      *    largo  del  registro, para  registros de largo variable,     00001520
      *    antes de llamar a las subrutinas FIO con comando REC_LEN     00001530
           03 FIO-RLEN     COMP                 PIC S9(04).             00001540
      *                                                                 00001550
      *    Value Of ID                                                  00001560
           03 FIO-VOID.                                                 00001570
      *                                                                 00001580
      *       Sistema                                                   00001590
              05 FIO-SIST                       PIC X(03).              00001600
      *                                                                 00001610
      *       Tipo                                                      00001620
              05 FIO-FTYP                       PIC X(01).              00001630
      *                                                                 00001640
      *       Nombre                                                    00001650
              05 FIO-FNAM                       PIC X(04).              00001660
                                                                        00001670
      *       RESPALDO FIO-SIST                                         00001680
           03 FIO-SIST-BKP                      PIC X(03).              00001690
                                                                        00001700
      *                                                                 00001710
      *    Filler                                                       00001720
           03 FILLER                            PIC X(15).              00001730
