      *         EXEC CICS
      *         RETURN
      *     END-EXEC.

           MOVE LENGTH OF DFHCOMMAREA TO LEN
           SET TPSUCCESS TO TRUE
           CALL "TPRETURN" USING TPSVCRET-REC
                                 TPTYPE-REC
                                 DFHCOMMAREA
                                 TPSTATUS-REC
           IF NOT TPOK
                DISPLAY 'TPCALL TP-STATUS :' TP-STATUS
                GOBACK
           ELSE
                GOBACK.