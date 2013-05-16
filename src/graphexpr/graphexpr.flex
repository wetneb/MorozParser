package graphexpr;
/* Lexer for a type string */

import java_cup.runtime.Symbol;
import java.io.StringReader;

%%

%class GraphExprLexer
%unicode
%cup
%line

%{
/* This code will be included in the class */
    public GraphExprLexer(String input)
    {
        this(new StringReader(input));
    }

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
"fresh_node"    { return symbol(sym.NODE_FRESH); }
"node"          { return symbol(sym.NODE); }
"<"             { return symbol(sym.LCHEV); }
">"             { return symbol(sym.RCHEV); }
"name"          { return symbol(sym.NAME); }
{var}           { return symbol(sym.VAR, Integer.parseInt(yytext())); }
"("             { return symbol(sym.LPAREN); }
")"             { return symbol(sym.RPAREN); }
","             { return symbol(sym.COMMA); }
";"             { return symbol(sym.SEP); }
"["             { return symbol(sym.LCRO); }
"]"             { return symbol(sym.RCRO); }
"+"             { return symbol(sym.PLUS); }
"null"          { return symbol(sym.NULL); }
{WhiteSpace}    { /* ignore */ }
}

