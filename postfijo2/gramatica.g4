grammar gramatica;

prog: expr NEWLINE;
expr: expr ('+'| '-') term
    | term
    ;
term: '0'
    | '1'
    | '2'
    | '3'
    | '4'
    | '5'
    | '6'
    | '7'
    | '8'
    | '9'
    ;
NEWLINE : [\r\n]+ ;