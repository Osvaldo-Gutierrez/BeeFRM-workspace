        01 TSK-TX-RETURN-STATUS.
           05 TSK-TX-STATUS PIC S9(9) COMP-5.
                88 TSK-TX-NOT-SUPPORTED             VALUE 1.
      * Normal execution
                88 TSK-TX-OK                        VALUE 0.
      * Normal execution
                88 TSK-TX-OUTSIDE                   VALUE -1.
      * Application is in an RM local transaction
                88 TSK-TX-ROLLBACK                  VALUE -2.
      * Transaction was rolled back
                88 TSK-TX-MIXED                     VALUE -3.
      * Transaction was partially committed and partially rolled
                88 TSK-TX-HAZARD                    VALUE -4.
      * Transaction may have been partially committed and partial
      * rolled back
                88 TSK-TX-PROTOCOL-ERROR            VALUE -5.
      * Routine invoked in an improper context
                88 TSK-TX-ERROR                     VALUE -6.
      * Transient error
                88 TSK-TX-FAIL                      VALUE -7.
      * Fatal error
                88 TSK-TX-EINVAL                    VALUE -8.
      * Invalid arguments were given
                88 TSK-TX-COMMITTED                 VALUE -9.
      * The transaction was heuristically committed
                88 TSK-TX-NO-BEGIN                  VALUE -100.
      * Transaction committed plus new transaction could not be s
                88 TSK-TX-ROLLBACK-NO-BEGIN         VALUE  -102.
      * Transaction rollback plus new transaction could not be st
                88 TSK-TX-MIXED-NO-BEGIN            VALUE  -103.
      * Mixed plus new transaction could not be started
                88 TSK-TX-HAZARD-NO-BEGIN           VALUE  -104.
      * Hazard plus new transaction could not be started
                88 TSK-TX-COMMITTED-NO-BEGIN        VALUE  -109.
      * Heuristically committed plus transaction could not be sta
      *
        01 TSK-TX-INFO-AREA.
      * XID record
           05 TSK-XID-REC.
              10 TSK-FORMAT-ID        PIC S9(9) COMP-5.
      * A value of -1 in FORMAT-ID means that the XID is null
              10 TSK-GTRID-LENGTH     PIC S9(9) COMP-5.
              10 TSK-BRANCH-LENGTH    PIC S9(9) COMP-5.
              10 TSK-XID-DATA         PIC X(128).
      * Transaction mode settings
           05 TSK-TRANSACTION-MODE     PIC S9(9) COMP-5.
              88 TSK-TX-NOT-IN-TRAN   VALUE 0.
              88 TSK-TX-IN-TRAN       VALUE 1.
      * Commit_return settings
           05 TSK-COMMIT-RETURN        PIC S9(9) COMP-5.
              88 TSK-TX-COMMIT-COMPLETED          VALUE 0.
              88 TSK-TX-COMMIT-DECISION-LOGGED    VALUE 1.
      * Transaction_control settings
           05 TSK-TRANSACTION-CONTROL  PIC S9(9) COMP-5.
              88 TSK-TX-UNCHAINED     VALUE 0.
              88 TSK-TX-CHAINED       VALUE 1.
      * Transaction_timeout value
           05 TSK-TRANSACTION-TIMEOUT  PIC S9(9) COMP-5.
              88 NO-TIMEOUT       VALUE 0.
      * Transaction_state information
           05 TSK-TRANSACTION-STATE    PIC S9(9) COMP-5.
              88 TSK-TX-ACTIVE        VALUE 0.
              88 TSK-TX-TIMEOUT-ROLLBACK-ONLY     VALUE 1.
              88 TSK-TX-ROLLBACK-ONLY             VALUE 2.


        01 TPTRXLEV-REC.
      *
      *  TPTRXLEV.cbl
      *
        05 TPTRXLEV-FLAG           PIC S9(9) COMP-5.
                88 TP-NOT-IN-TRAN  VALUE 0.
                88 TP-IN-TRAN      VALUE 1.
      *
      
        01 TPTRXDEF-REC.
      *
      *  TPTRXDEF.cbl
      *
        05 T-OUT        PIC S9(9) COMP-5 VALUE IS 0.
        05 TRANID       OCCURS 6 TIMES PIC S9(9) COMP-5.





       01  TSK-VARI.                                                    

            03 TSK-TERM-ORIGEN    VALUE 'N'           PIC  X(01).        

            03 TSK-TRANID.
               05 TSK-TRANID-1                        PIC S9(10).
               05 TSK-TRANID-2                        PIC S9(10).
               05 TSK-TRANID-3                        PIC S9(10).
               05 TSK-TRANID-4                        PIC S9(10).
               05 TSK-TRANID-5                        PIC S9(10).
               05 TSK-TRANID-6                        PIC S9(10).
            03 TSK-TRANID-ALF REDEFINES   TSK-TRANID  PIC  X(60).        

            03 TSK-INFO-TRAN.
               05 TSK-INFO-TRANID                     PIC 9(07).
               05 TSK-INFO-TRANID-ALF REDEFINES 
                                    TSK-INFO-TRANID   PIC X(07).                       
               05 TSK-INFO-COMMIT                     PIC 9(01).

            03 TSK-TERM-NUM               COMP-3      PIC S9(07).        
            03 TSK-TERM-ALF REDEFINES   TSK-TERM-NUM  PIC  X(04).        

            03 TSK-TERM-TUX                           PIC  X(256).  
            
            03 TSK-TERM-NUM-TUX                       PIC  9(07).        
            03 TSK-TERM-NUM-TUX-ALF REDEFINES 
                                    TSK-TERM-NUM-TUX  PIC  X(07).        

            03 TSK-TERM-NUM-TUX-6                     PIC  9(06).        
            03 TSK-TERM-NUM-TUX-ALF-6 REDEFINES 
                                  TSK-TERM-NUM-TUX-6  PIC  X(06).        



       01  HEADER-VARI.
           03 HEADER-NOM-TSPT.
              05 HEADER-COD-TERM   VALUE 'HE'              PIC X(02).       
              05 HEADER-COD-TYPE   VALUE SPACES            PIC X(06).       

       01  HEADER-MENS VALUE SPACES.                              
           03 HEADER-VERS                        PIC X(00004).
           03 HEADER-BNCO                        PIC X(00003).
           03 HEADER-MRCA                        PIC X(00003).
           03 HEADER-CART                        PIC X(00003).
           03 HEADER-LENG                        PIC X(00002).
           03 HEADER-PAIS                        PIC X(00002).
           03 HEADER-VRNT                        PIC X(00001).
           03 HEADER-USER                        PIC X(00012).
           03 HEADER-CNAL                        PIC X(00005).
           03 HEADER-UMUA                        PIC X(00012).
           03 HEADER-PROG                        PIC X(00008).
           03 HEADER-IBYA                        PIC X(00001).
           03 HEADER-BCKI                        PIC X(00001).
           03 HEADER-I24H                        PIC X(00001).
           03 HEADER-MODO                                    
                          REDEFINES HEADER-I24H PIC X(00001).            
           03 HEADER-MNSF                        PIC X(00001).
           03 HEADER-ORIG                        PIC X(00003).
           03 HEADER-MSGC                        PIC X(00001).
           03 HEADER-MSGM                        PIC X(00001).
           03 HEADER-DIS1                        PIC X(00026).
           03 HEADER-IREQ.                                    
              05 HEADER-IR01                     PIC X(00001).
              05 HEADER-IR02                     PIC X(00001).
              05 HEADER-IR03                     PIC X(00001).
              05 HEADER-IR04                     PIC X(00001).
              05 HEADER-IR05                     PIC X(00001).
              05 HEADER-IR06                     PIC X(00001).
              05 HEADER-IR07                     PIC X(00001).
              05 HEADER-IR08                     PIC X(00001).
              05 HEADER-IR09                     PIC X(00001).
              05 HEADER-IR10                     PIC X(00001).




       01  MULMSG-VARI.
           03 MULMSG-NOM-TSPT.
              05 MULMSG-COD-TERM   VALUE SPACES  PIC X(04).       
              05 MULMSG-COD-TYPE   VALUE 'MMSG'  PIC X(04).       

       01  MULMSG-MENS VALUE SPACES.                              
           03 MULMSG-TIPO                        PIC X(00001).
           03 MULMSG-FORM                        PIC X(00003).
           03 MULMSG-SIST                        PIC X(00003).
           03 MULMSG-CODI                        PIC X(00012).
           03 MULMSG-DATO                        PIC X(01005).



