       01 IDM-CMMA.
           03 IDM-RIDD.
               05 IDM-QIDD.
                   07 IDM-QUEU            VALUE SPACES PIC X(04).
                   07 IDM-TERM            VALUE SPACES PIC X(04).
               05 IDM-LIDD          COMP VALUE ZEROES PIC S9(04).
           03 IDM-ENTR.
               05 IDM-SIST                             PIC X(03).
               05 IDM-KEY-TAB.
                   07 IDM-OPCI                         PIC X(09).
                   07 IDM-CANA                         PIC X(03).
           03 IDM-SALI.
               05 IDM-IND-ERROR           VALUE SPACES PIC X(01).
               05 IDM-COD-ERROR           VALUE SPACES PIC X(12).
               05 IDM-GLS-ERROR           VALUE SPACES PIC X(40).
               05 IDM-SEDE                VALUE SPACES PIC X(12).
               05 IDM-FUNC                VALUE SPACES PIC X(40).
               05 IDM-VIGE                VALUE SPACES PIC X(01).
      *--------------------------------------------------------------
       01 IDM-VARI.
           03 IDM-TCMA             VALUE +3000      PIC S9(04).
