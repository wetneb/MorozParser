package xmllexicon;
/* Lexer for a type string */

%%

%class TypeStringLexer

%line
%type Symbol

%eofval{
	return new Symbol(EOF, 0, 0);
%eofval}

%{
/* This code will be included in the class */
    public static final int BASIC_TYPE = 1;
    public static final int LBRA = 2;
    public static final int RBRA = 3;
    public static final int EXP = 4;
    public static final int EOF = 5;

    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}

LineTerminator = \r|\n|\r\n
WhiteSpace = {LineTerminator} | [ \t\f]

rel_int = 0|(-?[1-9][0-9]*)

basic_type = [\\A-Za-z_][\\A-Za-z_0-9]*


%%


<YYINITIAL> {
{basic_type}    { return symbol(BASIC_TYPE, yytext()); }
"^{"            { return symbol(LBRA); }
"}"             { return symbol(RBRA); }
{rel_int}       { return symbol(EXP, Integer.parseInt(yytext())); }
{WhiteSpace}    { /* ignore */ }
}

