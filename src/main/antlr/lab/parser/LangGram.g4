grammar LangGram;

@header{ package lab.parser; }

// начальное правило грамматики
program: (statement)* EOF;


// список возможных операторов
statement: variableDeclaration
         | assignment
         | println
         | ifStatement
         | whileIteration
         | forIteration
         | blockStatement
         ;

// список возможных выражений
expression: '(' expression ')'                                              #parenthesisExpr
          | left=expression op=(ASTERISK | SLASH | MOD) right=expression    #mulDivExpr
          | left=expression op=(PLUS | MINUS) right=expression              #plusMinusExpr
          | left=expression compOperator right=expression                   #compExpr
          | IDENTIFIER                                                      #idExp
          | NUMBER                                                          #numExpr
          ;

// описания отдельных выражений и операторов
variableDeclaration: 'var' IDENTIFIER '=' expression ;

assignment: IDENTIFIER '=' expression ;

compOperator: op=(LESS | LESS_OR_EQUAL | EQUAL | NOT_EQUAL | GREATER | GREATER_OR_EQUAL) ;

println: 'println' expression ;

blockStatement: '{' (statement)* '}' ;

ifStatement: 'if' '(' expression ')' statement  elifStatement* elseStatement? ;
elifStatement:  'else if' '(' expression ')' statement ;
elseStatement: 'else' statement ;

whileIteration: 'while' '(' expression ')' statement ;
forIteration: 'for' '(' (variableDeclaration)? ';' expression ';' assignment? ')' statement ;

// список токенов
IDENTIFIER          : [a-zA-Z_] [a-zA-Z_0-9]* ;
NUMBER              : [0-9]+ ;

ASTERISK            : '*' ;
SLASH               : '/' ;
MOD                 : '%' ;
PLUS                : '+' ;
MINUS               : '-' ;

ASSIGN              : '=' ;
EQUAL               : '==' ;
NOT_EQUAL           : '!=' ;
LESS                : '<' ;
LESS_OR_EQUAL       : '<=' ;
GREATER             : '>' ;
GREATER_OR_EQUAL    : '>=' ;

// Комментарии
SPACE               : [ \r\n\t]+ -> skip;
LINE_COMMENT        : '//' ~[\n\r]* -> skip;
BLOCK_COMMENT       : '/*' .*? '*/' -> skip;
