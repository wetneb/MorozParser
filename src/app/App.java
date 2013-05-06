package app;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import latex.TikzReduction;

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
		sentence.add("Jeanne");
		sentence.add("est");
		sentence.add("une");
		sentence.add("grande");
		sentence.add("femme");
		
		SimpleType<FreeType> target =
				new SimpleType<FreeType>(new FreeType("s"), 0);
		
		
		PhraseString<FreeType> phrase =
				new PhraseString<FreeType>(lex, sentence, target);
		
		Parser<FreeType> p = new Parser<FreeType>(phrase);
		
		if(p.run())
		{
			System.out.println("Valid sentence.");
			PrintWriter out;
			try {
				out = new PrintWriter("output.tex");
				out.println(TikzReduction.draw(phrase, sentence, p.getReduction()));
				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		else
			System.out.println("Invalid sentence.");
		
	}
}
