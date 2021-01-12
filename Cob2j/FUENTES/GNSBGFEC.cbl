      * Modulo para Proceso de Fechas y Hora                            00000010
      * 24-MAY-1989 20:21:31                                            00000020
       PRO-FEC SECTION.                                                 00000030
       INI-PRO-FEC.                                                     00000040
           MOVE FEC-SOKS TO FEC-STT1                                    00000050
                            FEC-STT2.                                   00000060
           MOVE SPACES TO MSG-COD-MENS IN MSG.                          00000070
           IF FEC-CMND = FEC-VAL-FEC                                    00000080
               PERFORM FEC-VALD-FEC                                     00000090

      *        IF FEC-STAT-OKS AND NOT FEC-STAT-BLK AND FEC-TIENE-DIA   00000100
               IF FEC-STAT-OKS AND NOT FEC-STAT-BLK                     00000110
                   PERFORM FEC-OTRA-VAL                                 00000120
                   GO TO MSG-PRO-FEC                                    00000130
               ELSE                                                     00000140
                   GO TO MSG-PRO-FEC.                                   00000150
           IF FEC-CMND = FEC-CMP-FEC                                    00000160
               PERFORM FEC-COMP-FEC                                     00000170
               GO TO MSG-PRO-FEC.                                       00000180
       ERR-PRO-FEC.                                                     00000190
           MOVE 'GNS'          TO MSG-COD-SIST.                         00000200
           MOVE 'PROFEC CMDNX' TO MSG-COD-MENS IN MSG.                  00000210
           PERFORM GET-MSG.                                             00000220
           MOVE MSG-GLS-DESC IN MSG TO SYS-MEN1.                        00000230
           MOVE FEC-CMND            TO SYS-MEN2.                        00000240
           MOVE SYS-ABOR            TO SYS-CMND.                        00000250
           PERFORM GNS-PRO-SYS.                                         00000260
       MSG-PRO-FEC.                                                     00000270
           IF MSG-COD-MENS > SPACES                                     00000280
               MOVE 'GNS'     TO MSG-COD-SIST                           00000290
               PERFORM GET-MSG                                          00000300
               MOVE MSG-GLS-DESC IN MSG TO FEC-MENS                     00000310
           ELSE                                                         00000320
           IF NOT FEC-STAT-OKS                                          00000330
               MOVE 'FECSTAT' TO MSG-COD-TMSG IN MSG                    00000340
               MOVE FEC-STAT  TO MSG-COD-CMSG IN MSG                    00000350
               MOVE 'GNS'     TO MSG-COD-SIST                           00000360
               PERFORM GET-MSG                                          00000370
               MOVE MSG-GLS-DESC IN MSG TO FEC-MENS                     00000380
           ELSE                                                         00000390
           IF ( FEC-CMND = FEC-VAL-FEC OR FEC-RET-FEC OR FEC-SIG-HBL OR 00000400
                           FEC-SUM-DIA OR FEC-SUM-MES OR FEC-SUM-ANO OR 00000410
                           FEC-RST-DIA OR FEC-RST-MES OR FEC-RST-ANO )  00000420
              AND FEC-IEDT > SPACES                                     00000430
               PERFORM FEC-PUT-SLSH.                                    00000440
       FIN-PRO-FEC.                                                     00000450
           EXIT.                                                        00000460
                                                                        00000470
       FEC-VALD-FEC SECTION.                                            00000480
       INI-FEC-VALD-FEC.                                                00000490
      *     IF FEC-IEDT > SPACES                                        00000500
               PERFORM FEC-EXT-SLSH.                                    00000510
                                                                        00000520
           MOVE 1 TO FEC-SIND.                                          00000530
       LUP-FEC-VALD-FEC.                                                00000540
           IF FEC-FECH-CHR( FEC-SIND ) NOT > SPACES                     00000550
               MOVE ZEROES TO FEC-FECH-CHR( FEC-SIND ).                 00000560
           ADD 1 TO FEC-SIND.                                           00000570
           IF FEC-SIND NOT > 8                                          00000580
               GO TO LUP-FEC-VALD-FEC.                                  00000590
           MOVE FEC-ITM1-RED TO FEC-SVLD-RED.                           00000600
           MOVE FEC-ITM2-RED TO FEC-AVLD-RED.                           00000610
           MOVE FEC-ITM3-RED TO FEC-MVLD-RED.                           00000620
           MOVE FEC-ITM4-RED TO FEC-DVLD-RED.                           00000630
           PERFORM FEC-VNUM-FEC.                                        00000640
           IF NOT FEC-STAT-OKS                                          00000650
               GO TO FIN-FEC-VALD-FEC.                                  00000660
           MOVE FEC-FVLD TO FEC-FECH.                                   00000670
           IF FEC-STAT-BLK                                              00000680
               GO TO FIN-FEC-VALD-FEC.                                  00000690
           PERFORM FEC-TRDC-FEC.                                        00000700
           IF FEC-MVLD < 1 OR FEC-MVLD > 12                             00000710
               MOVE FEC-SMES TO FEC-STAT                                00000720
               GO TO FIN-FEC-VALD-FEC.                                  00000730
           IF FEC-MVLD NOT = 02                                         00000740
              IF FEC-DVLD < 1 OR FEC-DVLD > FEC-DMES(FEC-MVLD)          00000750
                  MOVE FEC-SDIA TO FEC-STAT                             00000760
                  GO TO FIN-FEC-VALD-FEC                                00000770
              ELSE                                                      00000780
                  NEXT SENTENCE                                         00000790
           ELSE                                                         00000800
               DIVIDE FEC-AVLD BY 4 GIVING FEC-REST REMAINDER FEC-REST  00000810
               IF FEC-REST = 0                                          00000820
                   IF FEC-DVLD < 1 OR FEC-DVLD > 29                     00000830
                       MOVE FEC-SDIA TO FEC-STAT                        00000840
                       GO TO FIN-FEC-VALD-FEC                           00000850
                   ELSE                                                 00000860
                       NEXT SENTENCE                                    00000870
               ELSE                                                     00000880
                   IF FEC-DVLD < 1 OR FEC-DVLD > 28                     00000890
                       MOVE FEC-SDIA TO FEC-STAT                        00000900
                       GO TO FIN-FEC-VALD-FEC.                          00000910
           IF FEC-SVLD < 18 OR FEC-SVLD > 20                            00000920
               MOVE FEC-SSIG TO FEC-STAT                                00000930
               GO TO FIN-FEC-VALD-FEC.                                  00000940
       FIN-FEC-VALD-FEC.                                                00000950
           EXIT.                                                        00000960
                                                                        00000970
       FEC-OTRA-VAL SECTION.                                            00000980
       INI-FEC-OTRA-VAL.                                                00000990
           IF FEC-CHOY = FEC-CHOY-L  OR FEC-CHOY-E  OR FEC-CHOY-G OR    00001000
                         FEC-CHOY-LE OR FEC-CHOY-GE OR FEC-CHOY-LG      00001010
               MOVE FEC-DVLD TO FEC-DEC1                                00001020
               MOVE FEC-MVLD TO FEC-MEC1                                00001030
               MOVE FEC-SVLD TO FEC-SEC1                                00001040
               MOVE FEC-AVLD TO FEC-AEC1                                00001050
               MOVE FEC-DHOY TO FEC-DEC2                                00001060
               MOVE FEC-MHOY TO FEC-MEC2                                00001070
               MOVE FEC-SHOY TO FEC-SEC2                                00001080
               MOVE FEC-AHOY TO FEC-AEC2                                00001090
               PERFORM CMP-FEC-COMP-FEC THRU FIN-FEC-COMP-FEC           00001100
               IF FEC-STAT-LES AND                                      00001110
                  ( FEC-CHOY = FEC-CHOY-E OR FEC-CHOY-G OR FEC-CHOY-GE )00001120
                   MOVE 'FEC    <HOY' TO MSG-COD-MENS                   00001130
                   MOVE FEC-SMAL TO FEC-STAT                            00001140
                   GO TO FIN-FEC-OTRA-VAL                               00001150
               ELSE                                                     00001160
               IF FEC-STAT-EQL AND                                      00001170
                  ( FEC-CHOY = FEC-CHOY-L OR FEC-CHOY-G OR FEC-CHOY-LG )00001180
                   MOVE 'FEC    =HOY' TO MSG-COD-MENS                   00001190
                   MOVE FEC-SMAL TO FEC-STAT                            00001200
                   GO TO FIN-FEC-OTRA-VAL                               00001210
               ELSE                                                     00001220
               IF FEC-STAT-GRT AND                                      00001230
                  ( FEC-CHOY = FEC-CHOY-L OR FEC-CHOY-E OR FEC-CHOY-LE )00001240
                   MOVE 'FEC    >HOY' TO MSG-COD-MENS                   00001250
                   MOVE FEC-SMAL TO FEC-STAT                            00001260
                   GO TO FIN-FEC-OTRA-VAL.                              00001270
           IF FEC-VHBL = FEC-VHBL-S AND FEC-TIENE-DIA                   00001280
               PERFORM FEC-VALD-HBL.                                    00001290
       FIN-FEC-OTRA-VAL.                                                00001300
           EXIT.                                                        00001310
                                                                        00001320
       FEC-COMP-FEC SECTION.                                            00001330
       INI-FEC-COMP-FEC.                                                00001340
           MOVE FEC-FEC1 TO FEC-FECH.                                   00001350
           PERFORM FEC-EXT-SLSH.                                        00001360
           PERFORM FEC-TRDC-FEC.                                        00001370
           MOVE FEC-DVLD TO FEC-DEC1.                                   00001380
           MOVE FEC-MVLD TO FEC-MEC1.                                   00001390
           MOVE FEC-SVLD TO FEC-SEC1.                                   00001400
           MOVE FEC-AVLD TO FEC-AEC1.                                   00001410
           MOVE FEC-FEC2 TO FEC-FECH.                                   00001420
           PERFORM FEC-EXT-SLSH.                                        00001430
           PERFORM FEC-TRDC-FEC.                                        00001440
           MOVE FEC-DVLD TO FEC-DEC2.                                   00001450
           MOVE FEC-MVLD TO FEC-MEC2.                                   00001460
           MOVE FEC-SVLD TO FEC-SEC2.                                   00001470
           MOVE FEC-AVLD TO FEC-AEC2.                                   00001480
       CMP-FEC-COMP-FEC.                                                00001490
           IF FEC-SEC1 > FEC-SEC2                                       00001500
               MOVE FEC-SGRT TO FEC-STAT                                00001510
           ELSE                                                         00001520
           IF FEC-SEC1 < FEC-SEC2                                       00001530
               MOVE FEC-SLES TO FEC-STAT                                00001540
           ELSE                                                         00001550
               MOVE FEC-SEQL TO FEC-STAT                                00001560
               IF FEC-AEC1 > FEC-AEC2                                   00001570
                   MOVE FEC-SGRT TO FEC-STAT                            00001580
               ELSE                                                     00001590
               IF FEC-AEC1 < FEC-AEC2                                   00001600
                   MOVE FEC-SLES TO FEC-STAT                            00001610
               ELSE                                                     00001620
                   MOVE FEC-SEQL TO FEC-STAT                            00001630
                   IF FEC-MEC1 > FEC-MEC2                               00001640
                       MOVE FEC-SGRT TO FEC-STAT                        00001650
                   ELSE                                                 00001660
                   IF FEC-MEC1 < FEC-MEC2                               00001670
                       MOVE FEC-SLES TO FEC-STAT                        00001680
                   ELSE                                                 00001690
                       MOVE FEC-SEQL TO FEC-STAT                        00001700
                       IF FEC-DEC1 > FEC-DEC2                           00001710
                           MOVE FEC-SGRT TO FEC-STAT                    00001720
                       ELSE                                             00001730
                       IF FEC-DEC1 < FEC-DEC2                           00001740
                           MOVE FEC-SLES TO FEC-STAT                    00001750
                       ELSE                                             00001760
                           MOVE FEC-SEQL TO FEC-STAT.                   00001770
       FIN-FEC-COMP-FEC.                                                00001780
           EXIT.                                                        00001790
                                                                        00001800
       FEC-TRDC-FEC SECTION.                                            00001810
       INI-FEC-TRDC-FEC.                                                00001820
           PERFORM FEC-GDAT.                                            00001830
           IF NOT FEC-TIENE-MES                                         00001840
               MOVE FEC-MHOY TO FEC-MVLD                                00001850
           ELSE                                                         00001860
           IF FEC-TIENE-DIA                                             00001870
               MOVE FEC-ITM2 TO FEC-MVLD                                00001880
           ELSE                                                         00001890
               MOVE FEC-ITM1 TO FEC-MVLD.                               00001900
           IF FEC-TIENE-DIA                                             00001910
               MOVE FEC-ITM1 TO FEC-DVLD                                00001920
           ELSE                                                         00001930
               IF FEC-MHOY = FEC-MVLD                                   00001940
                   MOVE FEC-DHOY TO FEC-DVLD                            00001950
               ELSE                                                     00001960
                   MOVE 1 TO FEC-DVLD.                                  00001970
           IF NOT FEC-TIENE-SIGLO                                       00001980
               MOVE FEC-SHOY TO FEC-SVLD                                00001990
           ELSE                                                         00002000
           IF FEC-TIENE-DIA AND FEC-TIENE-MES                           00002010
               MOVE FEC-ITM3 TO FEC-SVLD                                00002020
           ELSE                                                         00002030
           IF ( NOT FEC-TIENE-DIA ) AND ( NOT FEC-TIENE-MES )           00002040
               MOVE FEC-ITM1  TO FEC-SVLD                               00002050
           ELSE                                                         00002060
               MOVE FEC-ITM2 TO FEC-SVLD.                               00002070
           IF NOT FEC-TIENE-ANO                                         00002080
               MOVE FEC-AHOY TO FEC-AVLD                                00002090
           ELSE                                                         00002100
           IF FEC-TIENE-DIA AND FEC-TIENE-MES AND FEC-TIENE-SIGLO       00002110
               MOVE FEC-ITM4 TO FEC-AVLD                                00002120
           ELSE                                                         00002130
           IF ( FEC-TIENE-DIA AND FEC-TIENE-MES   ) OR                  00002140
              ( FEC-TIENE-MES AND FEC-TIENE-SIGLO )                     00002150
               MOVE FEC-ITM3 TO FEC-AVLD                                00002160
           ELSE                                                         00002170
           IF FEC-TIENE-MES OR FEC-TIENE-SIGLO                          00002180
               MOVE FEC-ITM2 TO FEC-AVLD                                00002190
           ELSE                                                         00002200
               MOVE FEC-ITM1 TO FEC-AVLD.                               00002210
           IF ( NOT FEC-TIENE-SIGLO ) AND ( FEC-TIENE-QUIEBRE )         00002220
      *JSS-INI 12-MAR-1999   (DAD)                                      00002230
      *    AND ( FEC-AVLD NOT > 50 )                                    00002240
      *        ADD 1 TO FEC-SVLD.                                       00002250
               IF FEC-SVLD = 19                                         00002260
                   IF FEC-AVLD NOT > 60                                 00002270
                       ADD 1 TO FEC-SVLD                                00002280
                   ELSE                                                 00002290
                       NEXT SENTENCE                                    00002300
               ELSE                                                     00002310
                   IF FEC-AVLD > 60                                     00002320
                       SUBTRACT 1 FROM FEC-SVLD.                        00002330
      *JSS-FIN 12-MAR-1999   (DAD)                                      00002340
       FIN-FEC-TRDC-FEC.                                                00002350
           EXIT.                                                        00002360
                                                                        00002370
       FEC-VNUM-FEC SECTION.                                            00002380
       INI-FEC-VNUM-FEC.                                                00002390
           IF ( FEC-FVLD NOT > SPACES OR FEC-FVLD = ZEROES ) AND        00002400
              FEC-FBLK = FEC-FBLK-S                                     00002410
               MOVE ZEROES TO FEC-FVLD                                  00002420
               MOVE FEC-SBLK TO FEC-STAT                                00002430
               GO TO FIN-FEC-VNUM-FEC.                                  00002440
           IF ( FEC-FVLD NOT > SPACES OR FEC-FVLD = ZEROES ) AND        00002450
              FEC-FBLK = FEC-FBLK-N                                     00002460
                MOVE FEC-SOBL TO FEC-STAT                               00002470
                GO TO FIN-FEC-VNUM-FEC.                                 00002480
           IF FEC-FVLD IS NOT NUMERIC                                   00002490
               MOVE FEC-SNN1 TO FEC-STAT.                               00002500
       FIN-FEC-VNUM-FEC.                                                00002510
           EXIT.                                                        00002520
                                                                        00002530
       FEC-GDAT SECTION.                                                00002540
       INI-FEC-GDAT.                                                    00002550
           PERFORM GET-FHOY.                                            00002560
           MOVE HOY-DHOY TO FEC-DHOY.                                   00002570
           MOVE HOY-MHOY TO FEC-MHOY.                                   00002580
           MOVE HOY-SHOY TO FEC-SHOY.                                   00002590
           MOVE HOY-AHOY TO FEC-AHOY.                                   00002600
           MOVE HOY-HHHY TO FEC-HHHY.                                   00002610
           MOVE HOY-MMHY TO FEC-MMHY.                                   00002620
           MOVE HOY-SSHY TO FEC-SSHY.                                   00002630
       FIN-FEC-GDAT.                                                    00002640
           EXIT.                                                        00002650
                                                                        00002660
       FEC-VALD-HBL SECTION.                                            00002670
       INI-FEC-VALD-HBL.                                                00002680
           PERFORM FEC-RTRN-JUL.                                        00002690
           DIVIDE FEC-FJUL BY 7 GIVING FEC-REST REMAINDER FEC-REST.     00002700
           SUBTRACT FEC-DIA1 FROM 7 GIVING FEC-AUXI.                    00002710
           ADD 1 FEC-AUXI GIVING FEC-SIND.                              00002720
           IF FEC-SIND > 6                                              00002730
               MOVE 0 TO FEC-SIND.                                      00002740
           IF FEC-REST = FEC-AUXI OR FEC-SIND                           00002750
               MOVE FEC-SFER TO FEC-STAT                                00002760
           ELSE                                                         00002770
               MOVE 'FER'        TO TAB-COD-TTAB IN TAB                 00002780
               MOVE FEC-FECH-FDM TO TAB-COD-CTAB IN TAB                 00002790
               MOVE 'GNS'        TO FIO-SIST                            00002800
               MOVE FIO-GET-KEY  TO FIO-CMND                            00002810
               PERFORM GNS-FIO-TAB                                      00002820
               IF FIO-STAT-OKS AND TAB-IND-VIGE IN TAB NOT = 'N'        00002830
                   MOVE FEC-SFER TO FEC-STAT                            00002840
               ELSE                                                     00002850
                   MOVE 'FER'    TO TAB-COD-TTAB IN TAB                 00002860
                   MOVE FEC-FECH TO TAB-COD-CTAB IN TAB                 00002870
                   MOVE 'GNS'       TO FIO-SIST                         00002880
                   MOVE FIO-GET-KEY TO FIO-CMND                         00002890
                   PERFORM GNS-FIO-TAB                                  00002900
                   IF FIO-STAT-OKS AND TAB-IND-VIGE IN TAB NOT = 'N'    00002910
                       MOVE FEC-SFER TO FEC-STAT                        00002920
                   ELSE                                                 00002930
                       MOVE FEC-SHBL TO FEC-STAT.                       00002940
       FIN-FEC-VALD-HBL.                                                00002950
           EXIT.                                                        00002960
                                                                        00002970
       FEC-RTRN-JUL SECTION.                                            00002980
       INI-FEC-RTRN-JUL.                                                00002990
           IF FEC-BST1 < FEC-FANO                                       00003000
               SUBTRACT FEC-BST1 FROM FEC-FANO GIVING FEC-FJUL          00003010
           ELSE                                                         00003020
               MOVE 0 TO FEC-FJUL.                                      00003030
           DIVIDE FEC-FJUL BY 4 GIVING FEC-FJUL REMAINDER FEC-REST.     00003040
           COMPUTE FEC-FJUL = FEC-FJUL + ( FEC-FANO - FEC-ANO1 ) * 365. 00003050
           IF FEC-REST > 0                                              00003060
               ADD 1 TO FEC-FJUL.                                       00003070
           MOVE 1 TO FEC-SIND.                                          00003080
       LUP-FEC-RTRN-JUL.                                                00003090
           IF FEC-SIND < FEC-FMES                                       00003100
               ADD FEC-DMES( FEC-SIND ) TO FEC-FJUL                     00003110
               ADD 1 TO FEC-SIND                                        00003120
               GO TO LUP-FEC-RTRN-JUL.                                  00003130
           ADD FEC-FDIA TO FEC-FJUL.                                    00003140
           DIVIDE FEC-FANO BY 4 GIVING FEC-REST REMAINDER FEC-REST.     00003150
           IF FEC-REST NOT = 0 AND FEC-FMES > 2                         00003160
               SUBTRACT 1 FROM FEC-FJUL.                                00003170
       FIN-FEC-RTRN-JUL.                                                00003180
           EXIT.                                                        00003190
                                                                        00003200
       FEC-EXT-SLSH SECTION.                                            00003210
       INI-FEC-EXT-SLSH.                                                00003220
           MOVE FEC-FECH TO FEC-FSLH.                                   00003230
           IF FEC-FORM = FEC-FORM-FEC OR FEC-FORM-DMA                   00003240
      *        IF FEC-FSLH-SL1 = FEC-IEDT AND FEC-FSLH-SL2 = FEC-IEDT   00003250
               IF FEC-FSLH-SL1 = '/' AND FEC-FSLH-SL2 = '/'             00003260
                   MOVE SPACES       TO FEC-FECH                        00003270
                   MOVE FEC-FSLH-IT1 TO FEC-ITM1                        00003280
                   MOVE FEC-FSLH-IT2 TO FEC-ITM2                        00003290
                   MOVE FEC-FSLH-IT3 TO FEC-ITM3                        00003300
                   MOVE FEC-FSLH-IT4 TO FEC-ITM4                        00003310
               ELSE                                                     00003320
                   NEXT SENTENCE                                        00003330
           ELSE                                                         00003340
           IF FEC-FORM = FEC-FORM-MSA OR FEC-FORM-FMA                   00003350
      *        IF FEC-FSLH-SL1 = FEC-IEDT                               00003360
               IF FEC-FSLH-SL1 = '/'                                    00003370
                   MOVE SPACES       TO FEC-FECH                        00003380
                   MOVE FEC-FSLH-IT1 TO FEC-ITM1                        00003390
                   MOVE FEC-FSLH-IT2 TO FEC-ITM2                        00003400
                   MOVE FEC-FSLH-IT5 TO FEC-ITM3                        00003410
                   MOVE FEC-FSLH-IT6 TO FEC-ITM4                        00003420
               ELSE                                                     00003430
                   NEXT SENTENCE.                                       00003440
       FIN-FEC-EXT-SLSH.                                                00003450
           EXIT.                                                        00003460
                                                                        00003470
       FEC-PUT-SLSH SECTION.                                            00003480
       INI-FEC-PUT-SLSH.                                                00003490
           MOVE SPACES TO FEC-FSLH.                                     00003500
           IF FEC-FORM = FEC-FORM-FEC OR FEC-FORM-DMA                   00003510
               MOVE FEC-ITM1 TO FEC-FSLH-IT1                            00003520
      *        MOVE FEC-IEDT TO FEC-FSLH-SL1                            00003530
               MOVE '/'      TO FEC-FSLH-SL1                            00003540
               MOVE FEC-ITM2 TO FEC-FSLH-IT2                            00003550
      *        MOVE FEC-IEDT TO FEC-FSLH-SL2                            00003560
               MOVE '/'      TO FEC-FSLH-SL2                            00003570
               MOVE FEC-ITM3 TO FEC-FSLH-IT3                            00003580
               MOVE FEC-ITM4 TO FEC-FSLH-IT4                            00003590
               MOVE FEC-FSLH TO FEC-FECH                                00003600
           ELSE                                                         00003610
           IF FEC-FORM = FEC-FORM-MSA OR FEC-FORM-FMA                   00003620
               MOVE FEC-ITM1 TO FEC-FSLH-IT1                            00003630
      *        MOVE FEC-IEDT TO FEC-FSLH-SL1                            00003640
               MOVE '/'      TO FEC-FSLH-SL1                            00003650
               MOVE FEC-ITM2 TO FEC-FSLH-IT5                            00003660
               MOVE FEC-ITM3 TO FEC-FSLH-IT6                            00003670
               MOVE FEC-FSLH TO FEC-FECH.                               00003680
           MOVE SPACES TO FEC-IEDT.                                     00003690
       FIN-FEC-PUT-SLSH.                                                00003700
           EXIT.                                                        00003710
