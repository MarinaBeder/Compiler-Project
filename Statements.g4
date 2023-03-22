grammar Statements;
prog:if_Statement+;
if_Statement:'if' '(' condition ')' (body_if_one|body_if)  ;
condition: (expr operator expr);
operator:'>'|'<'|'>='|'<='|'=='|'!=';
//boolean:'true'|'false';
body_if:'{'
NL
  (
   ( print if_Statement*  )|     //
   print //
  |(if_Statement*)//
  )
    '}'NL;
  print: (assignment NL 'print();'NL )
  |('print();' NL assignment NL )
  |('print();' NL|assignment NL);
  print_one_line:('print();' NL|assignment NL);

body_if_one: print_one_line ;

assignment: VAR '='  expr ';';

expr:INT
      |VAR
      |expr operation=('*'|'/') expr
      |expr operation=('+'|'-') expr ;
INT:[0-9]+;
VAR:[a-zA-Z]+;
NL:'\n';
WS:[ \t\r]+ -> skip;//ignore this tab
 
