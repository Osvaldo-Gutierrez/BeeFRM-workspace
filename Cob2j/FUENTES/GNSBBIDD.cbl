      *Modulo interactivo que busca IDD.                                
       GNS-BUS-IDD SECTION.                                             
       INI-GNS-BUS-IDD.                                                 
           IF SCR-QIDD > SPACES                                         
      *EXEC CICS READQ TS                                               
      *          QUEUE(SCR-QIDD)                                        
      *          INTO(IDD-REGI)                                         
      *          LENGTH(SCR-LIDD)                                       
      *          ITEM(1)                                                
      *END-EXEC.     
      
     
           MOVE 'GET'    TO QUE-COM-SEND
           MOVE SCR-QIDD TO QUE-NAM-SEND
           MOVE 1        TO QUE-NUM-SEND
           MOVE SCR-LIDD TO QUE-LAR-SEND
           MOVE SPACES   TO QUE-TRX-SEND
           MOVE SPACES   TO QUE-DAT-SEND
           PERFORM GNS-MSJ-QUE
           IF QUE-STAT = QUE-STAT-OKS
             MOVE QUE-ITEM TO IDD-REGI     
             GO TO FIN-GNS-BUS-IDD.                                                 
       
           MOVE 'GIDD'    TO EIBTASKN-11
           MOVE EIBTASKN  TO EIBTASKN-12

           MOVE 'GET'      TO QUE-COM-SEND
           MOVE EIBTASKN-1 TO QUE-NAM-SEND
           MOVE 1          TO QUE-NUM-SEND
           MOVE SCR-LIDD   TO QUE-LAR-SEND
           MOVE SPACES     TO QUE-TRX-SEND
           MOVE SPACES     TO QUE-DAT-SEND
           PERFORM GNS-MSJ-QUE
           IF QUE-STAT = QUE-STAT-OKS
             MOVE QUE-ITEM TO IDD-REGI                                                             
             GO TO FIN-GNS-BUS-IDD.                                                                             
       
           DISPLAY 'NO ENCONTRO IDD :' EIBTASKN-1
                                       SCR-QIDD.

       FIN-GNS-BUS-IDD.                                                 
           EXIT.                                                        
