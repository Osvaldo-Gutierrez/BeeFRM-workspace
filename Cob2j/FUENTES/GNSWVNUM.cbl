      * Variables para validacion numerica                              
       01  NUM-VARI.                                                    
           03 NUM-NUME                                PIC X(25).        
           03 NUM-CNDV.                                                 
              05 NUM-NENT                     VALUE 0 PIC 9(02).        
              05 NUM-NDCM                     VALUE 0 PIC 9(02).        
              05 NUM-ZERO                     VALUE 0 PIC 9(01).        
              05 NUM-SGNO                     VALUE 0 PIC 9(01).        
           03 NUM-STAT                        VALUE 0 PIC 9(02).        
              88 NUM-STAT-OKS                 VALUE 0.                  
           03 NUM-MENS                                PIC X(79).        
           03 NUM-NUMV.                                                 
              05 NUM-NS9V                             PIC S9(13)V9(05). 
              05 NUM-RED4     REDEFINES NUM-NS9V.                       
                 07 NUM-PENT                          PIC 9(13).        
                 07 NUM-PENT-RED REDEFINES NUM-PENT   PIC X(01)         
                                 OCCURS 13.                             
                 07 NUM-PDCM                          PIC V9(05).       
                 07 NUM-PDCM-RED REDEFINES NUM-PDCM   PIC X(01)         
                                 OCCURS 5.                              
              05 NUM-NS9N     REDEFINES NUM-NS9V      PIC S9(13)V9(05). 
              05 NUM-NN9V     REDEFINES NUM-NS9V      PIC S9(13)V9(05). 
              05 NUM-NN9N     REDEFINES NUM-NS9V      PIC S9(13)V9(05). 