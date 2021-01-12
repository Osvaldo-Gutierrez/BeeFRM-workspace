      * Rutina para redondeo de decimales
       PES-SCTV SECTION.
       INI-PES-SCTV.
           IF PES-NUM-DECI IN PES-VARI NOT > 0
      *ADA-INI 8-ENE-2002
      *       IF PES-CIC-VCAM = PDB-CIC-1013
      *          MOVE 2 TO PES-NUM-DECI IN PES-VARI
      *       ELSE
      *       IF PES-CIC-VCAM = PDB-CIC-0998
      *          MOVE 4 TO PES-NUM-DECI IN PES-VARI.
              IF PES-CIC-VCAM = PDB-CIC-0999
                  NEXT SENTENCE
              ELSE
              IF PES-CIC-VCAM = PDB-CIC-0998
                  MOVE 4 TO PES-NUM-DECI IN PES-VARI
              ELSE
              IF PES-CIC-TVAL = PDB-CIC-MEXT
                  MOVE 2 TO PES-NUM-DECI IN PES-VARI.
      *ADA-FIN 8-ENE-2002

      * Parrafo para 0 ROUNDED
           IF PES-NUM-DECI IN PES-VARI = 0
              ADD 0 PES-SGV-DECI IN PES-VARI
              GIVING PES-SGV-ENT0 IN PES-VARI ROUNDED
              MOVE PES-SGV-ENT0 IN PES-VARI TO
                                PES-SGV-ENTE IN PES-VARI
           ELSE
      * Parrafo para 1 ROUNDED
           IF PES-NUM-DECI IN PES-VARI = 1
              ADD 0 PES-SGV-DECI IN PES-VARI
              GIVING PES-SGV-ENT1 IN PES-VARI ROUNDED
              MOVE PES-SGV-ENT1 IN PES-VARI TO
                                PES-SGV-ENTE IN PES-VARI
           ELSE
      * Parrafo para 2 ROUNDED
           IF PES-NUM-DECI IN PES-VARI = 2
              ADD 0 PES-SGV-DECI IN PES-VARI
              GIVING PES-SGV-ENT2 IN PES-VARI ROUNDED
              MOVE PES-SGV-ENT2 IN PES-VARI TO
                                PES-SGV-ENTE IN PES-VARI
           ELSE
      * Parrafo para 3 ROUNDED
           IF PES-NUM-DECI IN PES-VARI = 3
              ADD 0 PES-SGV-DECI IN PES-VARI
              GIVING PES-SGV-ENT3 IN PES-VARI ROUNDED
              MOVE PES-SGV-ENT3 IN PES-VARI TO
                                PES-SGV-ENTE IN PES-VARI
           ELSE
      * Parrafo para 4 ROUNDED
              ADD 0 PES-SGV-DECI IN PES-VARI
              GIVING PES-SGV-ENTE IN PES-VARI ROUNDED.

           MOVE 0      TO PES-NUM-DECI IN PES-VARI.
           MOVE SPACES TO PES-CIC-VCAM IN PES-VARI.
       FIN-PES-SCTV.
           EXIT.
