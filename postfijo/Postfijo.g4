grammar Postfijo;

expr:   expr '+' term
      | expr '-' term
      | term
      | '(' expr ')' 
      ;
term:   '0'
      | '1'
      | '2'
      | '3'
      | '4'
      | '5'
      | '6'
      | '7'
      | '8'
      | '9';

SUM: '+';
SUB: '-';

ID : [a-z]+ ;             // match lower-case identifiers

WS : [ \t\r\n]+ -> skip ; // skip spaces, tabs, newlines
