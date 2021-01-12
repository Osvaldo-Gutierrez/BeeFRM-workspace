      *    Archivo de Menu
      *    ---------------
      *
      *    Nombre Registro : MNU
      *    Clave(s)        : MNU-COD-NEMS(UU),MNU-COD-OPCS(UC),
      *                      MNU-COD-IMES(UC)
      *    Largo           : 492
      *    Bloqueo         : 1
      *    Observaciones   :
      *
       01  MNU.
      *
      *       Filler Compatibilidad VSAM/MVS
           03 MNU-GLS-FLAG                              PIC X(01).
      *
      *       Llave primaria nemotecnica
           03 MNU-COD-NEMS.
      *
      *       Llave primaria nemotecnica OLD
              05 MNU-COD-NEMO.
      *
      *          Sistema
                 07 MNU-COD-SYST                        PIC X(03).
      *
      *          Codigo accion
                 07 MNU-COD-CACC                        PIC X(03).
      *
      *          Codigo de Funcion
                 07 MNU-COD-FUNC.
      *
      *             Entidad
                    09 MNU-COD-ENTI                     PIC X(03).
      *
      *             Comando
                    09 MNU-COD-COMD                     PIC X(03).
      *
           03 MNU-COD-OPCS.
      *
              05 MNU-COD-IPCN.
      *       Llave secundaria 1: Opcion
                 07 MNU-COD-OPCI                        PIC X(03).
      *
      *       Llave secundaria 2: Menu + Ordinal
           03 MNU-COD-IMES.
      *
              05 MNU-COD-IMEN.
      *          Codigo menu
                 07 MNU-COD-CMEN                        PIC X(03).
      *
      *          Ordinal
                 07 MNU-NUM-ORDI                        PIC 9(03).
      *
      *CAH-INI 12-MAY-1998
      *    Time Stamp Transaccion
      *     03  MNU-STP-ITRN.
      *
      *        Fecha Transaccion
      *         05  MNU-FEC-FTRN.
      *             07  MNU-NUM-STRN                 PIC 9(02).
      *             07  MNU-NUM-ATRN                 PIC 9(02).
      *             07  MNU-NUM-MTRN                 PIC 9(02).
      *             07  MNU-NUM-DTRN                 PIC 9(02).
      *
      *            Hora Transaccion
      *         05  MNU-HRA-HRTR.
      *             07  MNU-NUM-HHTR                 PIC 9(02).
      *             07  MNU-NUM-MMTR                 PIC 9(02).
      *             07  MNU-NUM-SSTR                 PIC 9(02).
      *
      *REQ Indicador Tipo Accion
      *     03  MNU-MSC-TACC                             PIC X(01).
      *
      *    Indicador Status
      *     03  MNU-MSC-STAT                             PIC X(01).
      *
      *REQ Codigo Origen Transaccion
      *     03  MNU-COD-OTRN.
      *
      *        Indicador Tipo Origen
      *         05  MNU-MSC-TTRN                         PIC X(01).
      *
      *        Codigo Tipo Origen
      *         05  MNU-COD-TTRN                         PIC X(03).
      *
      *REQ Autor Transaccion
      *     03  MNU-COD-ATRN                             PIC X(12).
      *
      *       Tipo funcion
           03 MNU-COD-TFUN                              PIC X(03).
      *
      *       Glosa funcion menu
           03 MNU-GLS-FMEN                              PIC X(30).
      *
      *       Comando
           03 MNU-GLS-CMND.
      *
      *          Prefijo comando
              05 MNU-GLS-COMD                           PIC X(12).
      *
      *          Programa
              05 MNU-GLS-PROG                           PIC X(12).
      *
      *          Resto comando
              05 MNU-GLS-FILL                           PIC X(29).
      *
      *       Transaccion
           03 MNU-GLS-TRAN                              PIC X(04).
      *
      *       Comando ingreso programa
           03 MNU-COD-CMND                              PIC X(03).
      *
      *       Biblioteca documentacion.
           03 MNU-GLS-LDOC                              PIC X(07).
      *
      *       Nombre modulo documentacion
           03 MNU-GLS-NDOC                              PIC X(24).
      *
      *       Biblioteca formulario
           03 MNU-GLS-LFRM                              PIC X(07).
      *
      *       Nombre formulario
           03 MNU-GLS-NFRM                              PIC X(07).
      *
      *       Glosa funcion programa
           03 MNU-GLS-FPRO                              PIC X(30).
      *
      *       Fila
           03 MNU-NUM-FILA          COMP                PIC S9(02).
      *
      *       Columna
           03 MNU-NUM-COLU          COMP                PIC S9(02).      
  
      *
      *       Funcion retorno  (default)
           03 MNU-COD-FRET                              PIC X(12).
      *
      *       Indicador confirmacion
           03 MNU-IND-CONF                              PIC X(01).
      *
      *       Menu
           03 MNU-COD-MENU                              PIC X(03).
      *
      *       Indicador de privilegios
           03 MNU-IND-IPRV                              PIC X(01).
      *
      *       Instancia ingreso programa
           03 MNU-COD-INST                              PIC X(03).
      *
      *       Indicador si expande o no glosa de menu
           03 MNU-IND-EXGL                              PIC X(01).
      *
      *       Indicador transferencia de control
           03 MNU-IND-SEQU                              PIC X(03).
      *
      *       Sistema
           03 MNU-COD-SIST                              PIC X(03).
      *
      *       Codigo de traspaso de control al programa
           03 MNU-COD-TCTL                              PIC X(04).
      *
      *       Accion a ejecutar sobre formulario
           03 MNU-COD-EJFR                              PIC X(03).
      *
      *       Funcion anterior
           03 MNU-COD-FANT                              PIC X(12).
      *
      *       Codigo Tabla
           03 MNU-COD-TABL.
              05 MNU-COD-TTAB                           PIC X(03).
              05 MNU-COD-CTAB                           PIC X(12).
      *
      *       Indicador clear
           03 MNU-IND-NCLR                              PIC X(01).
      *
      *       Biblioteca formulario para VAX
           03 MNU-GLS-LFVX                              PIC X(07).
      *
      *       Nombre formulario para VAX
           03 MNU-GLS-NFVX                              PIC X(07).
      *
      *       Programa
           03 MNU-GLS-PRGM                              PIC X(08).
      *
      *       Independencia Fisica Datos
           03 MNU-COD-CIFD                              PIC X(12).
      *
      *       Codigo de traspaso de informacion al programa
           03 MNU-COD-TINF                              PIC X(03).
      *
      *       Modalidad de Salida del programa
           03 MNU-COD-MSAL                              PIC X(03).
      *
      *       Accion a ejecutar con pantalla
           03 MNU-COD-ASCR                              PIC X(01).
      *
      *       Accion a ejecutar con mapa programa
           03 MNU-COD-AMPG                              PIC X(01).
      *
      *       Nombre Mapa Header
           03 MNU-GLS-NMHD                              PIC X(07).
      *
      *       Libreria Mapa Header
           03 MNU-GLS-LMHD                              PIC X(07).
      *
      *       Accion a ejecutar con mapa header
           03 MNU-COD-AMHD                              PIC X(01).
      *
      *       Nombre Mapa Comandos
           03 MNU-GLS-NMCM                              PIC X(07).
      *
      *       Libreria Mapa Comandos
           03 MNU-GLS-LMCM                              PIC X(07).
      *
      *       Accion a ejecutar con Mapa comandos
           03 MNU-COD-AMCM                              PIC X(01).
      *
      *       Usa IDD
           03 MNU-COD-UIDD                              PIC X(03).
      *
      *       Disponible Futuras Ampliaciones
           03 MNU-GLS-DISP                              PIC X(118).
      *
      *    Variables de Menu
       01  MNU-VARI.
      *
      *    Nombre de Programa FIO para Menu
           03  MNU-GLS-FMNU.
      *
      *        Codigo Sistema
               05  MNU-COD-STMA                         PIC X(03).
      *
      *        Nombre 'fijo' de FIO Menu
               05  MNU-COD-FMNU           VALUE 'PFMNU' PIC X(05).
      *