      *
      * GNSWICIC
      * Version 3.0.1 Nov-2005
      * 19-Jun-20 07:41 AM
      *
      * CODIGO_INTERNO_COMPUTACIONAL
       77  WSS-TAG-GNSWICIC PIC X(125) VALUE
           '<IDNMOD NOM=$GNSWICIC$ VSN=$01-00$ VGM=$3.0.1$
      -    'GEN=$19-Jun-20 07:41 AM$ FNC=$1902_06$/>'.
       01  CIC-FLD.
           05 FILLER-CIC                    PIC  X(12).
      *
      * ( F / C - 06 / 03 )
      * "01. Identificacion Centro de Asignacion"
      *
      * ( F / C - 06 / 44 ) ( IKY ) ( NO D.O. ) ( NO OBL )
           05 CIC-COD-TCIC-LEN       COMP   PIC S9(04).
           05 CIC-COD-TCIC-ATR              PIC  X(01).
           05 CIC-COD-TCIC                  PIC  X.
      *
      * ( F / C - 08 / 03 )
      * "02. Codigo Centro de Asignacion"
      *
      * ( F / C - 08 / 42 ) ( IKY ) ( NO D.O. ) ( NO OBL )
           05 CIC-COD-CCIC-LEN       COMP   PIC S9(04).
           05 CIC-COD-CCIC-ATR              PIC  X(01).
           05 CIC-COD-CCIC                  PIC  X(3).
      *
      * ( F / C - 10 / 03 )
      * "03. Numero Inicial de Folio"
      *
      * ( F / C - 10 / 37 ) ( FLD ) ( NO D.O. ) ( NO OBL )
           05 CIC-NUM-ICIC-LEN       COMP   PIC S9(04).
           05 CIC-NUM-ICIC-ATR              PIC  X(01).
           05 CIC-NUM-ICIC-ALF              PIC  X(8).
           05 CIC-NUM-ICIC      REDEFINES
              CIC-NUM-ICIC-ALF              PIC  99999999.
      *
      * ( F / C - 12 / 03 )
      * "04. Indicador de Vigencia"
      *
      * ( F / C - 12 / 44 ) ( FLD ) ( NO D.O. ) ( NO OBL )
           05 CIC-IND-VIGE-LEN       COMP   PIC S9(04).
           05 CIC-IND-VIGE-ATR              PIC  X(01).
           05 CIC-IND-VIGE                  PIC  X.

      * Linea de Mensajes
           05 CIC-GLS-MENS-LEN       COMP   PIC S9(04).
           05 CIC-GLS-MENS-ATR              PIC  X(01).
           05 CIC-GLS-MENS.
              07 CIC-GLS-MEN1               PIC  X(40).
              07 CIC-GLS-MEN2               PIC  X(39).
      *
      * REGISTRO IMAGEN PARA EDICION DE MAPA CIC
       01  CIC-STP.
           05 CIC-COD-TCIC-STP              PIC  X(01).
           05 CIC-COD-CCIC-STP              PIC  X(01).
           05 CIC-NUM-ICIC-STP              PIC  X(01).
           05 CIC-IND-VIGE-STP              PIC  X(01).
      *
      * REGISTRO IMAGEN PARA EDICION DE MAPA CIC
       01  CIC-EDT.
           05 CIC-NUM-ICIC-EDT  PIC  ZZZZZZZZ.