      * Variables para Codigo Interno Computacional                     00000010
       01  CIC-VARI.                                                    00000020
      *                                                                 00000030
      *    Digito Verificador                                           00000040
           03  CIC-DVRF                                 PIC X(01).      00000050
      *                                                                 00000060
      *    Status de Retorno                                            00000070
           03  CIC-STAT                    VALUE SPACES PIC X(03).      00000080
      *                                                                 00000090
      *    Mensaje                                                      00000100
           03  CIC-MENS                                 PIC X(80).      00000110
      *                                                                 00000120
      *    Comando                                                      00000130
           03  CIC-CMND         COMP                    PIC 9(04).      00000140
      *                                                                 00000150
      * Constantes para Codigo Interno Computacional                    00000160
       01  CIC-CTTS.                                                    00000170
           03  CIC-GET          COMP    VALUE 1         PIC 9(04).      00000180
           03  CIC-INI          COMP    VALUE 2         PIC 9(04).      00000190
           03  CIC-FIN          COMP    VALUE 3         PIC 9(04).      00000200
           03  CIC-STAT-OKS             VALUE SPACES    PIC X(05).      00000210
      *PGV 03  CIC-STAT-MAL             VALUE NOT SPACESPIC X(05).      00000220
           03  CIC-STAT-NEX             VALUE 'NEX'     PIC X(05).      00000230
           03  CIC-STAT-NVG             VALUE 'NVG'     PIC X(05).      00000240
           03  CIC-STAT-ERR             VALUE 'ERR'     PIC X(05).      00000250
           03  CIC-STAT-CNV             VALUE 'CNV'     PIC X(05).      00000260
