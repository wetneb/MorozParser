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

integer = 0|([1-9][0-9]*)

node_var = n{integer}
stmt_var = s{integer}

ident = [\\A-Za-z][A-Za-z_0-9]*
expl = l+
expr = r+

%state STRING

%%


<YYINITIAL> {
"fresh_node"    { return symbol(sym.NODE_FRESH); }
"node"          { return symbol(sym.NODE); }
{node_var}      { return symbol(sym.NODE_VAR, Integer.parseInt(yytext().substring(1,yytext().length()))); }
{stmt_var}      { return symbol(sym.STMT_VAR, Integer.parseInt(yytext().substring(1,yytext().length()))); }
"("             { return symbol(sym.LPAREN); }
")"             { return symbol(sym.RPAREN); }
","             { return symbol(sym.COMMA); }
";"             { return symbol(sym.SEP); }
"qlify"         { return symbol(sym.ALPHA); }
"reify"         { return symbol(sym.BETA); }
":"             { return symbol(sym.COLON); }
{expl}          { if(yytext().length() % 2 == 0)
					return symbol(sym.EXP_EVEN, -yytext().length());
				  else return symbol(sym.EXP_ODD, -yytext().length()); }
{expr}          { if(yytext().length() % 2 == 0)
					return symbol(sym.EXP_EVEN, yytext().length());
			      else return symbol(sym.EXP_ODD, yytext().length()); }
"\\1"			{ return symbol(sym.IDENT, "1"); }
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

