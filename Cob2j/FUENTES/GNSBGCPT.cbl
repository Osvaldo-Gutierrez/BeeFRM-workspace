      * Rutina para compactar blancos de un string de caracteres        00000010
       CPT-BLKS SECTION.                                                00000020
       INI-CPT-BLKS.                                                    00000030
           MOVE 1   TO CPT-I CPT-J.                                     00000040
           MOVE 'N' TO CPT-IBLK.                                        00000050
       LUP-CPT-BLKS.                                                    00000060
           IF CPT-STRN-RED(CPT-J) > SPACES                              00000070
               MOVE CPT-STRN-RED(CPT-J) TO CPT-STRN-RED(CPT-I)          00000080
               ADD 1 TO CPT-I                                           00000090
               ADD 1 TO CPT-J                                           00000100
               MOVE 'S' TO CPT-IBLK                                     00000110
           ELSE                                                         00000120
               IF CPT-PONGO-BLANCO                                      00000130
                   MOVE SPACES TO CPT-STRN-RED(CPT-I)                   00000140
                   MOVE 'N'   TO CPT-IBLK                               00000150
                   MOVE CPT-I TO CPT-UBLK                               00000160
                   ADD 1 TO CPT-I                                       00000170
                   ADD 1 TO CPT-J                                       00000180
               ELSE                                                     00000190
                   ADD 1 TO CPT-J.                                      00000200
           IF CPT-J NOT > CPT-LENG                                      00000210
               GO TO LUP-CPT-BLKS.                                      00000220
       BLK-CPT-BLKS.                                                    00000230
           IF CPT-UBLK = ZEROES                                         00000240
               MOVE SPACES TO CPT-STRN                                  00000250
           ELSE                                                         00000260
           IF CPT-UBLK NOT > CPT-LENG                                   00000270
               MOVE SPACES TO CPT-STRN-RED(CPT-UBLK)                    00000280
               ADD 1 TO CPT-UBLK                                        00000290
               GO TO BLK-CPT-BLKS.                                      00000300
       FIN-CPT-BLKS.                                                    00000310
           EXIT.                                                        00000320
