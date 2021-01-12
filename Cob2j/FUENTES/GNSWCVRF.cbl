      *    Constantes para VRF                                          00000010
       01  VRF-CTTS.                                                    00000020
      *    Verificador 'K'                                              00000030
           03 VRF-SVRF-K                VALUE 0         PIC 9(01).      00000040
      *    Verificador '0'                                              00000050
           03 VRF-SVRF-0                VALUE 1         PIC 9(01).      00000060
      *    Verificador '1'                                              00000070
           03 VRF-SVRF-1                VALUE 2         PIC 9(01).      00000080
      *    Validacion dado un Numero y su Verificador                   00000090
           03 VRF-VAL           COMP    VALUE 1         PIC 9(04).      00000100
      *    Obtencion del Verificador para un Numero dado.               00000110
           03 VRF-GET           COMP    VALUE 2         PIC 9(04).      00000120
      *    No acepta numero en cero                                     00000130
           03 VRF-ZERO-N                VALUE 0         PIC 9(01).      00000140
      *    Si acepta numero en cero                                     00000150
           03 VRF-ZERO-S                VALUE 1         PIC 9(01).      00000160
      *    Status BLK                                                   00000170
           03 VRF-SBLK                  VALUE 2         PIC 9(01).      00000180
