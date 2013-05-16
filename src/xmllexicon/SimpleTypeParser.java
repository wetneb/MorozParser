package xmllexicon;

import java.io.IOException;
import java.io.StringReader;

import pregroup.PartialComparator;
import pregroup.TypeString;

public class SimpleTypeParser
{
	static TypeString parse(String input)
	{
		TypeStringLexer lex = new TypeStringLexer(new StringReader(input));
		TypeString ft = new TypeString();
		
		//! TODO :handle scan errors from TypeStringLexer
		//! Simple parsing algorithm
		try {
			Symbol sym = lex.yylex();
			while(sym.type != TypeStringLexer.EOF)
			{
				String bt = (String)sym.val;
				sym = lex.yylex();
				
				int exp = 0;
				if(sym.type == TypeStringLexer.LBRA)
				{
					sym = lex.yylex();
					//! TODO check that this cast is OK
					exp = (Integer)sym.val;
					sym = lex.yylex();
					sym = lex.yylex();
				}
				ft.add(bt, exp);
			}
		} catch(IOException ioe)
		{ ; }
		
		return ft;
	}
}
