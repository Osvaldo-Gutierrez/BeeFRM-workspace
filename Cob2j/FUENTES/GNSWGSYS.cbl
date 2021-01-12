      *    Variables para Rutinas del Sistema. GNSWGSYS V-3.1
       01  SYS-VARI.
      *    Variables para Current-Date
           03 SYS-FHOY-2B.
              05 SYS-AHOY-2B                   PIC 9(02).
              05 SYS-MHOY-2B                   PIC 9(02).
              05 SYS-DHOY-2B                   PIC 9(02).
           03 SYS-SHOY                         PIC 9(02).
           03 SYS-FHOY.
              05 SYS-DHOY                      PIC 9(02).
              05 SYS-SLH1                      PIC X(01).
              05 SYS-MHOY                      PIC 9(02).
              05 SYS-SLH2                      PIC X(01).
              05 SYS-AHOY                      PIC 9(02).
           03 SYS-HHOY-2B  VALUE ZEROES        PIC 9(08).
           03 SYS-HHOY-2B-RED REDEFINES SYS-HHOY-2B.
              05 SYS-HHHY-2B                   PIC 9(02).
              05 SYS-MMHY-2B                   PIC 9(02).
              05 SYS-SSHY-2B                   PIC 9(02).
              05 SYS-CCHY-2B                   PIC 9(02).
           03 SYS-HHOY  VALUE ZEROES           PIC 9(06).
           03 SYS-HHOY-RED REDEFINES SYS-HHOY.
              05 SYS-HHHY                      PIC 9(02).
              05 SYS-MMHY                      PIC 9(02).
              05 SYS-SSHY                      PIC 9(02).
           03 SYS-JHOY                         PIC 9(05).
           03 SYS-JHOY-RED REDEFINES SYS-JHOY.
              05 SYS-AAHY                      PIC 9(02).
              05 SYS-DDHY                      PIC 9(03).
           03 SYS-TSTP.
              05 SYS-SSTP                      PIC 9(02).
              05 SYS-FSTP.
                 07 SYS-AATS                   PIC 9(02).
                 07 SYS-MMTS                   PIC 9(02).
                 07 SYS-DDTS                   PIC 9(02).
              05 SYS-HSTP                      PIC 9(06).
              05 SYS-HSTP-RED REDEFINES SYS-HSTP.
                 07 SYS-HHTS                   PIC 9(02).
                 07 SYS-MMTS                   PIC 9(02).
                 07 SYS-SSTS                   PIC 9(02).
      *    Tamano de Communication Area
           03 SYS-TCMA  COMP                   PIC S9(4).
      *    Communication Area
           03 SYS-CMMA.
              05 SYS-SCR-MENS                  PIC X(79).
              05 SYS-SCR-VARI                  PIC X(3421).
      *INI-PENTA TUXEDO ORACLE
              05 SYS-SCR-NTRN                  PIC X(04).
      *FIN-PENTA TUXEDO ORACLE
      *    Transaccion
           03 SYS-NTRN                         PIC X(04).
      *    Programa
           03 SYS-PROG                         PIC X(08).
           03 SYS-PROG-RED REDEFINES SYS-PROG
                                      OCCURS 8 PIC X(01).
      *    Programa a ABorTo
           03 SYS-PABT  VALUE 'GNSPPABT'       PIC X(08).
      *    Comando
           03 SYS-CMND                 VALUE 0 PIC 9(02).
      *    Mensaje
           03 SYS-MENS.
              05 SYS-MEN1                      PIC X(40).
              05 SYS-MEN2                      PIC X(40).
      *    Resto
           03 SYS-REST                         PIC 9(01).
      *    Indice
           03 SYS-SIND                         PIC 9(02).
      *    Status
           03 SYS-STAT                         PIC X(02).
           03 SYS-STAT-OKS        VALUE '00'   PIC X(02).
           03 SYS-STAT-NUM                     PIC 9(02).
      *    Indicador de Handler
           03 SYS-IHDL            VALUE SPACES PIC X(01).
      * MHM-INI 28-FEB-2011 MODERNIZACION MIGRACION DB2
      *    Indicador de Abend
           03 SYS-ABND            VALUE ' '    PIC X(01).
              88 SYS-ABND-YES     VALUE 'S'.

      * MHM-FIN 28-FEB-2011 MODERNIZACION MIGRACION DB2
      * IMV-INI 01-JUL-2014 MARCA SIMULACION FUTURA
           03 SYS-SMFT            VALUE 'N'    PIC X(01).
      * IMV-FIN 01-JUL-2014 MARCA SIMULACION FUTURA

      *INI-PENTA TUXEDO ORACLE

      *    FLAG SERVICIO DE FECHA
           03 SYS-HORA-HABI      VALUE 'N'     PIC X(01).
           03 SYS-HORA-FLAG      VALUE 'N'     PIC X(01).

      
       01 EIBTRMID       VALUE SPACES          PIC X(04).
       01 EIBTRNID       VALUE SPACES          PIC X(04).
       01 EIBTASKN       VALUE SPACES          PIC X(04).
       01 EIBCALEN       VALUE 1               PIC 9(04).
       01 EIBAID         VALUE ''''            PIC X(01).
       01 EIBRESP        VALUE 0               PIC S9(04).

       01 EIBTASKN-1.
          03 EIBTASKN-11 VALUE SPACES          PIC X(04).
          03 EIBTASKN-12 VALUE SPACES          PIC X(04).
      * Variables genericas para servicio de fecha y hora
       01  FYH-VARI.
           03  FYH-PROG            VALUE 'GNSPPFYH' PIC X(08).
           03  FYH-TCMA            VALUE 22         PIC 9(08).
           03  FYH-CMSG            VALUE SPACES     PIC X(12).
           03  FYH-MENS.
               05 FYH-MEN2         VALUE SPACES     PIC X(40).
      *    MENSAJE
           03  FYH-CMMA.
               05 FYH-GLS-RSPT.
      *           FECHA
                  07 FYH-FEC-FHOY.
                     09 FYH-NUM-SHOY                PIC 9(02).
                     09 FYH-NUM-AHOY                PIC 9(02).
                     09 FYH-NUM-MHOY                PIC 9(02).
                     09 FYH-NUM-DHOY                PIC 9(02).
      *           HORA
                  07 FYH-HRA-HHOY.
                     09 FYH-NUM-HHHY                PIC 9(02).
                     09 FYH-NUM-MMHY                PIC 9(02).
                     09 FYH-NUM-SSHY                PIC 9(02).
      *           JULIANO
                  07 FYH-NUM-JULI                   PIC 9(08).

      *FIN-PENTA TUXEDO ORACLE
      *
      *    Constantes para Rutinas del Sistema.
       01  SYS-CTTS.
      *    Comandos
           03 SYS-GET-DATE             VALUE 1 PIC 9(01).
           03 SYS-GET-TIME             VALUE 2 PIC 9(01).
           03 SYS-RTRN                 VALUE 3 PIC 9(01).
           03 SYS-XCTL                 VALUE 4 PIC 9(01).
           03 SYS-LINK                 VALUE 5 PIC 9(01).
           03 SYS-ABOR                 VALUE 6 PIC 9(01).
      *    Cantidad de Dias Acumulados en cada Mes
           03 SYS-VACU VALUE '000031060091121152182213244274305335'.
              05 SYS-DACU       OCCURS 12      PIC 9(03).
