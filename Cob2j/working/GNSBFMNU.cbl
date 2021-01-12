      * Modulo FIO para registro MNU en DATACOM
       GNS-FIO-MNU SECTION.
       INI-GNS-FIO-MNU.


           MOVE ADR-MNU-REQA       TO ADR-REQA.
           MOVE 'MNU'              TO ADR-TABL IN ADR-REQA.
      *
           MOVE FIO-SIST TO IDD-SAUX.
           MOVE 'C'      TO IDD-GAUX.
           MOVE SPACES   TO IDD-RAUX.
           MOVE 1 TO IDD-IAUX.
           SET IDD-ITBL TO 1.
           SEARCH IDD-VSIS VARYING IDD-IAUX
             WHEN IDD-DENT( IDD-ITBL ) = IDD-DAUX
               GO TO FSR-GNS-FIO-MNU.
       GRP-GNS-FIO-MNU.
           MOVE SPACES TO IDD-GAUX.
           MOVE 1      TO IDD-IAUX.
           SET IDD-ITBL TO 1.
           SEARCH IDD-VSIS VARYING IDD-IAUX
               AT END
                   MOVE 'En GNS-FIO-MNU, NO existe en IDD:' TO FIO-MEN1
                   MOVE IDD-DAUX                            TO FIO-MEN2
                   DISPLAY 'ABORTO NO ENCONTRO IDD'
                   PERFORM PRG-ABT
               WHEN IDD-DENT( IDD-ITBL ) = IDD-DAUX
                   NEXT SENTENCE.
       FSR-GNS-FIO-MNU.
           MOVE IDD-IENT( IDD-ITBL ) TO ADR-DBID IN ADR-REQA.

           IF FIO-AKEY NOT > SPACES
              MOVE 'MNU-COD-NEMO' TO FIO-AKEY.

           MOVE 'MNU00' TO ADR-ELM1.
           MOVE FIO-PROG TO ADR-PROG.
           MOVE FIO-CMND TO FIO-IAKY.
           IF NOT FIO-IAKY-CON AND
              ( FIO-AKEY = 'MNU-COD-NEMO' OR FIO-AKEY NOT > SPACES )
               MOVE MNU-COD-NEMO IN MNU TO ADR-VKEY IN ADR-REQA
               MOVE 'MNU00' TO ADR-DKEY IN ADR-REQA
           ELSE
           IF FIO-AKEY = 'MNU-COD-OPCI'
               MOVE MNU-COD-OPCI IN MNU TO ADR-VKEY IN ADR-REQA
               MOVE 'MNU01' TO ADR-DKEY IN ADR-REQA
           ELSE
           IF FIO-AKEY = 'MNU-COD-IMEN'
               MOVE MNU-COD-IMES IN MNU TO ADR-VKEY IN ADR-REQA
               MOVE 'MNU02' TO ADR-DKEY IN ADR-REQA
           ELSE
           IF FIO-AKEY = 'MNU-COD-SYST'
               MOVE MNU-COD-IMES IN MNU TO ADR-VKEY IN ADR-REQA
               MOVE 'MNU03' TO ADR-DKEY IN ADR-REQA
           ELSE
               MOVE 'En GNS-FIO-MNU, key' TO FIO-MENS
               MOVE FIO-AKEY   TO FIO-MENS-KEY
               MOVE 'Invalida' TO FIO-MENS-FIL
               PERFORM PRG-ABT.

           MOVE MNU TO FIO-DFLD.
           PERFORM GNS-FIO-DTC.
           IF FIO-STAT-OKS
               MOVE FIO-DFLD TO MNU
           ELSE
               MOVE FIO-SIST TO FIO-MENS-SIS
               MOVE 'MNU'    TO FIO-MENS-REG
               IF FIO-STAT-FTL
                   PERFORM PRG-ABT.

           MOVE SPACES   TO FIO-AKEY.
           MOVE ADR-REQA TO ADR-MNU-REQA.

       FIN-GNS-FIO-MNU.
           EXIT.
