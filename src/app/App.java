package app;

import graphexpr.ExprResolver;
import graphexpr.GraphExprParser;
import graphexpr.GraphExprLexer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.hp.hpl.jena.rdf.model.Statement;

import latex.TikzReduction;

import xmllexicon.InputException;
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
import util.InternalException;
import util.TokenizerException;
import util.UnknownTagException;

public class App {
	public static void main(String[] args)
	{	
		org.apache.jena.atlas.logging.Log.setLog4j();
		
		SemanticLexicon sem = new SemanticLexicon();
		try {
			sem.load("semantics.xml");
		} catch (InternalException e1) {
			e1.printStackTrace();
		}
		//lex.loadTagger();
		
		String input = "John loves Mary who loves Peter.";
		
		List<String> sentence;
		try {
			sentence = new SimpleTokenizer(input).toList();

		
			SimpleType target =
					new SimpleType("s", 0);
			
			StanfordTagger tagger = new StanfordTagger();
			tagger.load("taggers/english-left3words-distsim.tagger");
			
			try
			{
				GraphString phrase =
						new GraphString(sem, tagger.tagSentence(sentence), target);
				
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
						/*
						try {
							/*
							Statement res = compiler.compileStmt(phrase.getPattern(resolver.getEntryPoint()));
							compiler.assume(res);
							
							System.out.println("## OUTPUT ##");
							System.out.println(compiler.dumpTriples());
						} catch (TypeException e) {
							System.out.println(e.what);
						}*/
						
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
			catch(UnknownTagException e)
			{
				System.out.println("Invalid input sentence:\n"+e.what);
			}
			catch(TypeException e)
			{
				System.out.println("Type exception:\n"+e.what);
			}
		
		} catch (TokenizerException e1) {
			System.out.println("The following token failed: \""+e1.what+"\"");
			e1.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
}
