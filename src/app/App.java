package app;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import latex.TikzReduction;

import xmllexicon.TagLexicon;
import xmllexicon.XmlLexicon;
import pregroup.FreeType;
import pregroup.PhraseString;
import pregroup.SimpleType;
import pregroup.Parser;

public class App {
	public static void main(String[] args)
	{
		TagLexicon lex = new TagLexicon();
		lex.load("tags.xml");
		lex.loadTagger("taggers/english-left3words-distsim.tagger");
		
		String input = "John walks a coloured father";
		
		List<String> sentence = new SimpleTokenizer(input).toList();
		
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
