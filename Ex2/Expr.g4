grammar Expr;		
prog:	expr;
expr:	expr oper=('+'|'-') term
    	|  term;
term: term oper=('*'|'/') factor
	| factor;

factor: FRAC 
    | '('expr')'; 

SUMA : '+';
RESTA: '-';
MULTIPLICACION : '*'; 
DIVISION: '/';	    	
NEWLINE : [\r\n]+ ;
INT     : [0-9]+ ;
FRAC		: INT'%'[1-9][0-9]*;
