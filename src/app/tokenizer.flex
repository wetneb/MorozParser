package app;
/* Simple tokenizer */

import java.util.ArrayList;
import java.util.List;
import java.io.StringReader;
import java.io.IOException;

%%

%class SimpleTokenizer

%line
%type String

%eofval{
	return null;
%eofval}

%{
	public SimpleTokenizer(String input)
	{
		this(new StringReader(input));
	}
	
	public List<String> toList()
	{
	    List<String> sentence = new ArrayList<String>();
		try {
			String token = yylex();
			while(token != null)
			{
				sentence.add(token);
				token = yylex();
			}
		} catch(IOException e)
		{
			e.printStackTrace();
		}
		return sentence;
	}
%}

LineTerminator = \r|\n|\r\n
WhiteSpace = {LineTerminator} | [ \t\f]

rel_int = 0|(-?[1-9][0-9]*)

word = [A-Za-z_]*


%%


<YYINITIAL> {
{word}    { return yytext(); }
{WhiteSpace}    { /* ignore */ }
}

