package app;

import java.util.ArrayList;
import java.util.List;

import xmllexicon.XmlLexicon;
import pregroup.FreeType;
import pregroup.PhraseString;
import pregroup.SimpleType;
import pregroup.Parser;

public class App {
	public static void main(String[] args)
	{
		XmlLexicon lex = new XmlLexicon();
		lex.load("lexicon.xml");
		
		List<String> sentence = new ArrayList<String>();
		sentence.add("grande");
		sentence.add("Jeanne");
		sentence.add("est");
		sentence.add("grande");
		
		SimpleType<FreeType> target =
				new SimpleType<FreeType>(new FreeType("s"), 0);
		
		
		PhraseString<FreeType> phrase =
				new PhraseString<FreeType>(lex, sentence, target);
		
		Parser<FreeType> p = new Parser<FreeType>(phrase);
		
		System.out.println(phrase.toString());
		
		System.out.println("Parsing result : "+p.run());
		
	}
}
