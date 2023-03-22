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
 
