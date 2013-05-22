package app;
/* Simple tokenizer */

import java.util.ArrayList;
import java.util.List;
import java.io.StringReader;
import java.io.IOException;
import util.TokenizerException;

%%

%class SimpleTokenizer

%line
%type String

%eofval{
	return null;
%eofval}

%{
	public SimpleTokenizer(String input) throws IOException
	{
		this(new StringReader(input));
	}
	
	public List<String> toList() throws IOException
	{
	    List<String> sentence = new ArrayList<String>();
		String token = yylex();
		while(token != null)
		{
			sentence.add(token);
			token = yylex();
		}

		return sentence;
	}
%}

LineTerminator = \r|\n|\r\n
WhiteSpace = {LineTerminator} | [ \t\f]

word = [0-9A-Za-z]*

punctuation = [\.,\?!\']

%%


<YYINITIAL> {
{word}    { return yytext(); }
{punctuation}		  { return yytext(); }
{WhiteSpace}    { /* ignore */ }
!([0-9A-Za-z\.,\?!\'\r\n ]*)	{ throw new TokenizerException(yytext()); }
}

