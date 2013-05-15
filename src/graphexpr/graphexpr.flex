package xmllexicon;
/* Lexer for a type string */

%%

%class TypeStringLexer
%unicode
%cup
%line

%{
/* This code will be included in the class */
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}

LineTerminator = \r|\n|\r\n
WhiteSpace = {LineTerminator} | [ \t\f]


var = 0|([1-9][0-9]*)


basic_type = [\\A-Za-z_][\\A-Za-z_0-9]*


%%


<YYINITIAL> {
"fresh_node"    { return symbol(NODE_FRESH); }
"node"          { return symbol(NODE); }
"<"             { return symbol(LCHEV); }
">"             { return symbol(RCHEV); }
"name"          { return symbol(NAME); }
{var}           { return symbol(VAR, yytext()); }
"}"             { return symbol(RBRA); }
"("             { return symbol(LPAREN); }
")"             { return symbol(RPAREN); }
","             { return symbol(COMMA); }
";"             { return symbol(SEP); }
"["             { return symbol(LCRO); }
"]"             { return symbol(RCRO); }
"+"             { return symbol(RCRO); }
"null"          { return symbol(NULL); }
{WhiteSpace}    { /* ignore */ }
}

