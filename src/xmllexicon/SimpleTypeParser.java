package xmllexicon;

import java.io.IOException;
import java.io.StringReader;

import pregroup.Comparator;
import pregroup.FreeType;
import pregroup.TypeString;

public class SimpleTypeParser
{
	static TypeString<FreeType> parse(String input, Comparator<FreeType> c)
	{
		TypeStringLexer lex = new TypeStringLexer(new StringReader(input));
		TypeString<FreeType> ft = new TypeString<FreeType>();
		
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
				ft.add(new FreeType(bt,c), exp);
			}
		} catch(IOException ioe)
		{ ; }
		
		return ft;
	}
}
