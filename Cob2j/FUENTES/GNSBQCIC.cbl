      *
      * GNSBQCIC
      * Version 3.0.1 Nov-2005
      * 19-Jun-20 07:41 AM
      *
       SET-TAG-GNSBQCIC SECTION.
       INI-SET-TAG-GNSBQCIC.
           MOVE
           '<IDNMOD NOM=$GNSBQCIC$ VSN=${VSNBQ}$ VGM=$3.0.1$
      -    'GEN=$19-Jun-20 07:41 AM$ FNC=${FNCBQ}$/>'
               TO WSS-CVT-ITEM.
       FIN-SET-TAG-GNSBQCIC.
           EXIT.
           
       PUT-ALL-CIC SECTION.
       INI-PUT-ALL-CIC.
      * <<<< INI_PUT_ALL_CIC
      * >>>> INI_PUT_ALL_CIC
           PERFORM PUT-CIC-CIC.
      * <<<< FIN_PUT_ALL_CIC
      * >>>> FIN_PUT_ALL_CIC
       FIN-PUT-ALL-CIC.
           EXIT.
       
       PUT-CIC-CIC SECTION.
       INI-PUT-CIC-CIC.
      * <<<< INI_PUT_CIC_CIC
      * >>>> INI_PUT_CIC_CIC
           IF PGM-STAT-CIC-NUL
               GO TO FIN-PUT-CIC-CIC.
           IF NOT PGM-STAT-CIC-OKS
               PERFORM CLR-CIC-CIC
               GO TO FIN-PUT-CIC-CIC.
           MOVE CIC-COD-TCIC IN CIC TO CIC-COD-TCIC IN CIC-FLD.
           MOVE CIC-COD-CCIC IN CIC TO CIC-COD-CCIC IN CIC-FLD.
           MOVE CIC-NUM-ICIC IN CIC TO CIC-NUM-ICIC IN CIC-FLD.
           MOVE CIC-IND-VIGE IN CIC TO CIC-IND-VIGE IN CIC-FLD.
      * <<<< FIN_PUT_CIC_CIC
      * >>>> FIN_PUT_CIC_CIC
       FIN-PUT-CIC-CIC.
           EXIT.
       
       KEY-ALL-CIC SECTION.
       INI-KEY-ALL-CIC.
      * <<<< INI_KEY_ALL_CIC
      * >>>> INI_KEY_ALL_CIC
           PERFORM KEY-CIC-CIC.
      * <<<< FIN_KEY_ALL_CIC
      * >>>> FIN_KEY_ALL_CIC
       FIN-KEY-ALL-CIC.
           EXIT.
       
       KEY-CIC-CIC SECTION.
       INI-KEY-CIC-CIC.
      * <<<< INI_KEY_CIC_CIC
      * >>>> INI_KEY_CIC_CIC
           MOVE CIC-COD-TCIC IN CIC-FLD TO CIC-COD-TCIC IN CIC.
           MOVE CIC-COD-CCIC IN CIC-FLD TO CIC-COD-CCIC IN CIC.
      * <<<< FIN_KEY_CIC_CIC
      * >>>> FIN_KEY_CIC_CIC
       FIN-KEY-CIC-CIC.
           EXIT.
       
       SCR-CLRA-CIC SECTION.
       INI-SCR-CLRA-CIC.
      * <<<< INI_SCR_CLRA_CIC
      * >>>> INI_SCR_CLRA_CIC
           PERFORM CLR-KEY-CIC.
           PERFORM CLR-FLD-CIC.
      * <<<< FIN_SCR_CLRA_CIC
      * >>>> FIN_SCR_CLRA_CIC
       FIN-SCR-CLRA-CIC.
           EXIT.
       
       CLR-KEY-CIC SECTION.
       INI-CLR-KEY-CIC.
      * <<<< INI_CLR_KEY_CIC
      * >>>> INI_CLR_KEY_CIC
           MOVE SPACES TO CIC-COD-TCIC IN CIC-FLD.
           MOVE SPACES TO CIC-COD-CCIC IN CIC-FLD.
      * <<<< FIN_CLR_KEY_CIC
      * >>>> FIN_CLR_KEY_CIC
       FIN-CLR-KEY-CIC.
           EXIT.
       
       CLR-FLD-CIC SECTION.
       INI-CLR-FLD-CIC.
      * <<<< INI_CLR_FLD_CIC
      * >>>> INI_CLR_FLD_CIC
           PERFORM CLR-CIC-CIC.
      * <<<< FIN_CLR_FLD_CIC
      * >>>> FIN_CLR_FLD_CIC
       FIN-CLR-FLD-CIC.
           EXIT.
       
       CLR-CIC-CIC SECTION.
       INI-CLR-CIC-CIC.
      * <<<< INI_CLR_CIC_CIC
      * >>>> INI_CLR_CIC_CIC
           MOVE ZEROES TO CIC-NUM-ICIC IN CIC-FLD.
           MOVE SPACES TO CIC-IND-VIGE IN CIC-FLD.
      * <<<< FIN_CLR_CIC_CIC
      * >>>> FIN_CLR_CIC_CIC
       FIN-CLR-CIC-CIC.
           EXIT.
       
       FST-KEY-CIC SECTION.
       INI-FST-KEY-CIC.
      * <<<< INI_FST_KEY_CIC
      * >>>> INI_FST_KEY_CIC
           MOVE -1 TO CIC-COD-TCIC-LEN IN CIC-FLD.
      * <<<< FIN_FST_KEY_CIC
      * >>>> FIN_FST_KEY_CIC
       FIN-FST-KEY-CIC.
           EXIT.
       
       FST-FLD-CIC SECTION.
       INI-FST-FLD-CIC.
      * <<<< INI_FST_FLD_CIC
      * >>>> INI_FST_FLD_CIC
           MOVE -1 TO CIC-NUM-ICIC-LEN IN CIC-FLD.
      * <<<< FIN_FST_FLD_CIC
      * >>>> FIN_FST_FLD_CIC
       FIN-FST-FLD-CIC.
           EXIT.
       
       PRO-KEY-CIC SECTION.
       INI-PRO-KEY-CIC.
      * <<<< INI_PRO_KEY_CIC
      * >>>> INI_PRO_KEY_CIC
           PERFORM PRO-IKY-CIC.
           PERFORM PRO-AKY-CIC.
           PERFORM PRO-MKY-CIC.
      * <<<< FIN_PRO_KEY_CIC
      * >>>> FIN_PRO_KEY_CIC
       FIN-PRO-KEY-CIC.
           EXIT.
       
       PRO-IKY-CIC SECTION.
       INI-PRO-IKY-CIC.
      * <<<< INI_PRO_IKY_CIC
      * >>>> INI_PRO_IKY_CIC
           MOVE FRM-CPIM-AEY TO CIC-COD-TCIC-ATR IN CIC-FLD.
           MOVE FRM-CPIM-AEY TO CIC-COD-CCIC-ATR IN CIC-FLD.
      * <<<< FIN_PRO_IKY_CIC
      * >>>> FIN_PRO_IKY_CIC
       FIN-PRO-IKY-CIC.
           EXIT.
       
       PRO-MKY-CIC SECTION.
       INI-PRO-MKY-CIC.
      * <<<< INI_PRO_MKY_CIC
      * >>>> INI_PRO_MKY_CIC
      * <<<< FIN_PRO_MKY_CIC
      * >>>> FIN_PRO_MKY_CIC
       FIN-PRO-MKY-CIC.
           EXIT.
       
       PRO-AKY-CIC SECTION.
       INI-PRO-AKY-CIC.
      * <<<< INI_PRO_AKY_CIC
      * >>>> INI_PRO_AKY_CIC
      * <<<< FIN_PRO_AKY_CIC
      * >>>> FIN_PRO_AKY_CIC
       FIN-PRO-AKY-CIC.
           EXIT.
       
       UNP-KEY-CIC SECTION.
       INI-UNP-KEY-CIC.
      * <<<< INI_UNP_KEY_CIC
      * >>>> INI_UNP_KEY_CIC
           PERFORM UNP-IKY-CIC.
           PERFORM UNP-AKY-CIC.
           PERFORM UNP-MKY-CIC.
      * <<<< FIN_UNP_KEY_CIC
      * >>>> FIN_UNP_KEY_CIC
       FIN-UNP-KEY-CIC.
           EXIT.
       
       UNP-IKY-CIC SECTION.
       INI-UNP-IKY-CIC.
      * <<<< INI_UNP_IKY_CIC
      * >>>> INI_UNP_IKY_CIC
           MOVE FRM-CPIM-UBY TO CIC-COD-TCIC-ATR.
           MOVE FRM-CPIM-UBY TO CIC-COD-CCIC-ATR.
      * <<<< FIN_UNP_IKY_CIC
      * >>>> FIN_UNP_IKY_CIC
       FIN-UNP-IKY-CIC.
           EXIT.
       
       UNP-MKY-CIC SECTION.
       INI-UNP-MKY-CIC.
      * <<<< INI_UNP_MKY_CIC
      * >>>> INI_UNP_MKY_CIC
      * <<<< FIN_UNP_MKY_CIC
      * >>>> FIN_UNP_MKY_CIC
       FIN-UNP-MKY-CIC.
           EXIT.
       
       UNP-AKY-CIC SECTION.
       INI-UNP-AKY-CIC.
      * <<<< INI_UNP_AKY_CIC
      * >>>> INI_UNP_AKY_CIC
      * <<<< FIN_UNP_AKY_CIC
      * >>>> FIN_UNP_AKY_CIC
       FIN-UNP-AKY-CIC.
           EXIT.
       
       UNP-FLD-CIC SECTION.
       INI-UNP-FLD-CIC.
      * <<<< INI_UNP_FLD_CIC
      * >>>> INI_UNP_FLD_CIC
           PERFORM UNP-CIC-CIC.
      * <<<< FIN_UNP_FLD_CIC
      * >>>> FIN_UNP_FLD_CIC
       FIN-UNP-FLD-CIC.
           EXIT.
       
       UNP-CIC-CIC SECTION.
       INI-UNP-CIC-CIC.
      * <<<< INI_UNP_CIC_CIC
      * >>>> INI_UNP_CIC_CIC
           MOVE FRM-CPIM-UBY TO CIC-NUM-ICIC-ATR IN CIC-FLD.
           MOVE FRM-CPIM-UBY TO CIC-IND-VIGE-ATR IN CIC-FLD.
      * <<<< FIN_UNP_CIC_CIC
      * >>>> FIN_UNP_CIC_CIC
       FIN-UNP-CIC-CIC.
           EXIT.
       
       VAL-KEY-CIC SECTION.
       INI-VAL-KEY-CIC.
           PERFORM VAL-IKY-CIC.
           PERFORM VAL-MKY-CIC.
           PERFORM VAL-AKY-CIC.
       FIN-VAL-KEY-CIC.
           EXIT.
       
       VAL-IKY-CIC SECTION.
       INI-VAL-IKY-CIC.
      * <<<< INI_VAL_IKY_CIC
      * >>>> INI_VAL_IKY_CIC
           PERFORM VAL-CIC-COD-TCIC.
           IF FRM-SUAR = FRM-SUAR-MAL OR FRM-SUAR = FRM-SUAR-CLR
                MOVE FRM-IND-ERRO TO CIC-COD-TCIC-LEN IN CIC-FLD
                GO TO FIN-VAL-IKY-CIC.
           PERFORM VAL-CIC-COD-CCIC.
           IF FRM-SUAR = FRM-SUAR-MAL OR FRM-SUAR = FRM-SUAR-CLR
                MOVE FRM-IND-ERRO TO CIC-COD-CCIC-LEN IN CIC-FLD
                GO TO FIN-VAL-IKY-CIC.
      * <<<< FIN_VAL_IKY_CIC
      * >>>> FIN_VAL_IKY_CIC
       FIN-VAL-IKY-CIC.
           EXIT.
       
       VAL-MKY-CIC SECTION.
       INI-VAL-MKY-CIC.
      * <<<< INI_VAL_MKY_CIC
      * >>>> INI_VAL_MKY_CIC
      * <<<< FIN_VAL_MKY_CIC
      * >>>> FIN_VAL_MKY_CIC
       FIN-VAL-MKY-CIC.
           EXIT.
       
       VAL-AKY-CIC SECTION.
       INI-VAL-AKY-CIC.
      * <<<< INI_VAL_AKY_CIC
      * >>>> INI_VAL_AKY_CIC
      * <<<< FIN_VAL_AKY_CIC
      * >>>> FIN_VAL_AKY_CIC
       FIN-VAL-AKY-CIC.
           EXIT.
       
       VAL-CIC-COD-TCIC SECTION.
       INI-VAL-CIC-COD-TCIC.
      * <<<< INI_CIC_COD_TCIC
      * >>>> INI_CIC_COD_TCIC
           IF CIC-COD-TCIC IN CIC-FLD NOT > SPACES
              MOVE SPACES TO CIC-COD-TCIC IN CIC-FLD.
      * <<<< CIC_COD_TCIC
      * >>>> CIC_COD_TCIC
      * <<<< FIN_CIC_COD_TCIC
      * >>>> FIN_CIC_COD_TCIC
       FIN-VAL-CIC-COD-TCIC.
           EXIT.
       
       VAL-CIC-COD-CCIC SECTION.
       INI-VAL-CIC-COD-CCIC.
      * <<<< INI_CIC_COD_CCIC
      * >>>> INI_CIC_COD_CCIC
           IF CIC-COD-CCIC IN CIC-FLD NOT > SPACES
              MOVE SPACES TO CIC-COD-CCIC IN CIC-FLD.
      * <<<< CIC_COD_CCIC
      * >>>> CIC_COD_CCIC
      * <<<< FIN_CIC_COD_CCIC
      * >>>> FIN_CIC_COD_CCIC
       FIN-VAL-CIC-COD-CCIC.
           EXIT.
       
       VAL-CON-KEY-CIC SECTION.
       INI-VAL-CON-KEY-CIC.
      * <<<< INI_VAL_CON_KEY_CIC
           GO TO FIN-VAL-CON-KEY-CIC.
      * >>>> INI_VAL_CON_KEY_CIC
           IF     CIC-COD-TCIC IN CIC-FLD NOT > SPACES 
              AND CIC-COD-CCIC IN CIC-FLD NOT > SPACES 
                PERFORM ERR-KEY
                PERFORM FST-KEY-CIC.
      * <<<< FIN_VAL_CON_KEY_CIC
      * >>>> FIN_VAL_CON_KEY_CIC
       FIN-VAL-CON-KEY-CIC.
           EXIT.
       
       VAL-CON-IKY-CIC SECTION.
       INI-VAL-CON-IKY-CIC.
      * <<<< INI_VAL_CON_IKY_CIC
           GO TO FIN-VAL-CON-IKY-CIC.
      * >>>> INI_VAL_CON_IKY_CIC
           IF     CIC-COD-TCIC IN CIC-FLD NOT > SPACES 
              AND CIC-COD-CCIC IN CIC-FLD NOT > SPACES 
                PERFORM ERR-KEY
                PERFORM FST-KEY-CIC.
      * <<<< FIN_VAL_CON_IKY_CIC
      * >>>> FIN_VAL_CON_IKY_CIC
       FIN-VAL-CON-IKY-CIC.
           EXIT.
       
       VAL-NUM-KEY-CIC SECTION.
       INI-VAL-NUM-KEY-CIC.
           PERFORM VAL-NUM-IKY-CIC.
           PERFORM VAL-NUM-MKY-CIC.
           PERFORM VAL-NUM-AKY-CIC.
       FIN-VAL-NUM-KEY-CIC.
           EXIT.
       
       VAL-NUM-IKY-CIC SECTION.
       INI-VAL-NUM-IKY-CIC.
      * <<<< INI_VAL_NUM_IKY_CIC
      * >>>> INI_VAL_NUM_IKY_CIC
      * <<<< FIN_VAL_NUM_IKY_CIC
      * >>>> FIN_VAL_NUM_IKY_CIC
       FIN-VAL-NUM-IKY-CIC.
           EXIT.
       
       VAL-NUM-MKY-CIC SECTION.
       INI-VAL-NUM-MKY-CIC.
      * <<<< INI_VAL_NUM_MKY_CIC
      * >>>> INI_VAL_NUM_MKY_CIC
      * <<<< FIN_VAL_NUM_MKY_CIC
      * >>>> FIN_VAL_NUM_MKY_CIC
       FIN-VAL-NUM-MKY-CIC.
           EXIT.
       
       VAL-NUM-AKY-CIC SECTION.
       INI-VAL-NUM-AKY-CIC.
      * <<<< INI_VAL_NUM_AKY_CIC
      * >>>> INI_VAL_NUM_AKY_CIC
      * <<<< FIN_VAL_NUM_AKY_CIC
      * >>>> FIN_VAL_NUM_AKY_CIC
       FIN-VAL-NUM-AKY-CIC.
           EXIT.
       
       VAL-NUM-FLD-CIC SECTION.
       INI-VAL-NUM-FLD-CIC.
      * <<<< INI_VAL_NUM_FLD_CIC
      * >>>> INI_VAL_NUM_FLD_CIC
       VAL-NUM-CIC-NUM-ICIC.
           MOVE CIC-NUM-ICIC-ALF IN CIC-FLD TO NUM-NUME.
           MOVE NUM-ZERO-S TO NUM-ZERO.
           MOVE NUM-SGNO-N TO NUM-SGNO.
           MOVE 8 TO NUM-NENT.
           MOVE 0 TO NUM-NDCM.
           PERFORM VAL-NUM.
           IF NUM-STAT-OKS
                MOVE NUM-NN9N TO CIC-NUM-ICIC IN CIC-FLD
           ELSE
                MOVE NUM-MENS     TO FRM-MENS
                MOVE FRM-SUAR-MAL TO FRM-SUAR
                MOVE -9 TO CIC-NUM-ICIC-LEN IN CIC-FLD
                GO TO FIN-VAL-NUM-FLD-CIC.
      * <<<< FIN_VAL_NUM_FLD_CIC
      * >>>> FIN_VAL_NUM_FLD_CIC
       FIN-VAL-NUM-FLD-CIC.
           EXIT.
       
       EDT-KEY-CIC SECTION.
       INI-EDT-KEY-CIC.
           PERFORM EDT-IKY-CIC.
           PERFORM EDT-MKY-CIC.
           PERFORM EDT-AKY-CIC.
      * <<<< EDT_KEY_CIC
      * >>>> EDT_KEY_CIC
       FIN-EDT-KEY-CIC.
           EXIT.
       
       EDT-IKY-CIC SECTION.
       INI-EDT-IKY-CIC.
      * <<<< EDT_IKY_CIC
      * >>>> EDT_IKY_CIC
      * <<<< FIN_EDT_IKY_CIC
      * >>>> FIN_EDT_IKY_CIC
       FIN-EDT-IKY-CIC.
           EXIT.
       
       EDT-MKY-CIC SECTION.
       INI-EDT-MKY-CIC.
      * <<<< EDT_MKY_CIC
      * >>>> EDT_MKY_CIC
      * <<<< FIN_EDT_MKY_CIC
      * >>>> FIN_EDT_MKY_CIC
       FIN-EDT-MKY-CIC.
           EXIT.
       
       EDT-AKY-CIC SECTION.
       INI-EDT-AKY-CIC.
      * <<<< EDT_AKY_CIC
      * >>>> EDT_AKY_CIC
      * <<<< FIN_EDT_AKY_CIC
      * >>>> FIN_EDT_AKY_CIC
       FIN-EDT-AKY-CIC.
           EXIT.
       
       EDT-FLD-CIC SECTION.
       INI-EDT-FLD-CIC.
      * <<<< EDT_FLD_CIC
      * >>>> EDT_FLD_CIC
           IF CIC-NUM-ICIC-LEN IN CIC-FLD = FRM-ERR-NUME
                MOVE FRM-IND-ERRO TO CIC-NUM-ICIC-LEN IN CIC-FLD
                GO TO FIN-EDT-FLD-CIC.
           MOVE CIC-NUM-ICIC IN CIC-FLD TO CIC-NUM-ICIC-EDT IN CIC-EDT.
           MOVE CIC-NUM-ICIC-EDT IN CIC-EDT TO 
                CIC-NUM-ICIC-ALF IN CIC-FLD.
      * <<<< FIN_EDT_FLD_CIC
      * >>>> FIN_EDT_FLD_CIC
       FIN-EDT-FLD-CIC.
           EXIT.
      * <<<< EOF_BQ
      * >>>> EOF_BQ
      * <<<< EOF
      * >>>> EOF
      * <<<< EOF_IBM
      * >>>> EOF_IBM
