package app;

import graphexpr.GraphExprParser;
import graphexpr.GraphExprLexer;

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
		GraphExprLexer lexer = new GraphExprLexer("blabla(ll) : [1+(name,2)]");
		GraphExprParser parser = new GraphExprParser(lexer);
		try {
			parser.parse();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		XmlLexicon lex = new XmlLexicon();
		lex.load("lexicon.xml");
		//lex.loadTagger("taggers/english-left3words-distsim.tagger");
		
		String input = "colourless green ideas sleep furiously";
		
		List<String> sentence = new SimpleTokenizer(input).toList();
		
		//! TODO null : this is a bug : fix this design issue
		SimpleType<FreeType> target =
				new SimpleType<FreeType>(new FreeType("s", null), 0);
		
		PhraseString<FreeType> phrase =
				new PhraseString<FreeType>(lex, sentence, target);
		
		Parser<FreeType> p = new Parser<FreeType>(phrase);
		System.out.println(phrase.toString());
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
