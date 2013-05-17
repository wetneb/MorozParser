package app;

import graphexpr.ExprResolver;
import graphexpr.GraphExprParser;
import graphexpr.GraphExprLexer;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import com.hp.hpl.jena.rdf.model.Statement;

import latex.TikzReduction;

import xmllexicon.SemanticLexicon;
import xmllexicon.TagLexicon;
import xmllexicon.XmlLexicon;
import pregroup.PhraseString;
import pregroup.SimpleType;
import pregroup.Parser;
import rdf.GraphCompiler;
import rdf.GraphString;
import rdf.TypeException;
import tagging.StanfordTagger;

public class App {
	public static void main(String[] args)
	{	
		SemanticLexicon sem = new SemanticLexicon();
		sem.load("semantics.xml");
		//lex.loadTagger();
		
		String input = "John loves a sweet girl";
		
		List<String> sentence = new SimpleTokenizer(input).toList();
		
		SimpleType target =
				new SimpleType("s", 0);
		
		StanfordTagger tagger = new StanfordTagger();
		tagger.loadTagger("taggers/english-left3words-distsim.tagger");
		
		GraphString phrase =
				new GraphString(sem, tagger.tagSentence(sentence), sentence, target);
		
		Parser p = new Parser(phrase, sem.getComparator());
		System.out.println(phrase.toString());
		if(p.run())
		{
			System.out.println("Valid sentence.");
			PrintWriter out;
			try {
				ExprResolver resolver = new ExprResolver(phrase, p.getReduction());
				GraphCompiler compiler = new GraphCompiler(resolver);
				// TODO
				try {
					Statement res = compiler.compileStmt(phrase.getPattern(resolver.getEntryPoint()));
					compiler.assume(res);
					
					System.out.println("## OUTPUT ##");
					compiler.dumpTriples();
				} catch (TypeException e) {
					System.out.println(e.what);
				}
				
				out = new PrintWriter("output.tex");
				out.println(TikzReduction.draw(phrase, sentence, p.getReduction()));
				out.close();
			} catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
		}
		else
			System.out.println("Invalid sentence.");
		
	}
}
