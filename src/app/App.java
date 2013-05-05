package app;

import java.util.ArrayList;
import java.util.List;

import xmllexicon.XmlLexicon;
import pregroup.FreeType;
import pregroup.PhraseString;
import pregroup.SimpleType;

public class App {
	public static void main(String[] args)
	{
		XmlLexicon lex = new XmlLexicon();
		lex.load("lexicon.xml");
		
		List<String> sentence = new ArrayList<String>();
		sentence.add("Jeanne");
		sentence.add("est");
		sentence.add("Jeannette");
		
		SimpleType<FreeType> target =
				new SimpleType<FreeType>(new FreeType("s"), 0);
		
		
		PhraseString<FreeType> phrase =
				new PhraseString<FreeType>(lex, sentence, target);
		
		System.out.println(phrase.toString());
		
	}
}
