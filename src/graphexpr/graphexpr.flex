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
    private StringBuffer string = new StringBuffer();

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

ident = [\\A-Za-z_][\\A-Za-z_0-9]*
expl = l+
expr = r+

%state STRING

%%


<YYINITIAL> {
"fresh_node"    { return symbol(sym.NODE_FRESH); }
"node"          { return symbol(sym.NODE); }
"name"          { return symbol(sym.NAME); }
{var}           { return symbol(sym.VAR, Integer.parseInt(yytext())); }
"("             { return symbol(sym.LPAREN); }
")"             { return symbol(sym.RPAREN); }
","             { return symbol(sym.COMMA); }
";"             { return symbol(sym.SEP); }
"["             { return symbol(sym.LCRO); }
"]"             { return symbol(sym.RCRO); }
"sub"           { return symbol(sym.SUB); }
"rel"           { return symbol(sym.REL); }
"obj"           { return symbol(sym.OBJ); }
"+"             { return symbol(sym.PLUS); }
":"             { return symbol(sym.COLON); }
"null"          { return symbol(sym.NULL); }
{expl}          { return symbol(sym.EXPL, yytext().length()); }
{expr}          { return symbol(sym.EXPR, yytext().length()); }
{ident}         { return symbol(sym.IDENT, yytext()); }
"\""            { string.setLength(0); yybegin(STRING); }
{WhiteSpace}    { /* ignore */ }
}

<STRING> {
    \"          { yybegin(YYINITIAL); return symbol(sym.STR,string.toString()); } 
    [^\"\\]     { string.append(yytext()); }
    \\\"        { string.append("\""); }
    \\          { string.append("\\"); }
}

