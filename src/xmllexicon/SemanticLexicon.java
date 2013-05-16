package xmllexicon;

import graphexpr.GraphExpr;
import graphexpr.GraphExprLexer;
import graphexpr.GraphExprParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import pregroup.TypeString;


public class SemanticLexicon
	extends HashMap<String, List<List<GraphExpr>>>
{
	private static final long serialVersionUID = 1L;

	private static TypeString stringOfList(List<GraphExpr> l)
	{
		TypeString res = new TypeString();
		for(GraphExpr g : l)
			res.add(g.type);
		return res;
	}
	
	public List<List<TypeString>> types(List<String> sentence)
	{
		List<List<TypeString>> res = new ArrayList<List<TypeString>>();
		for(String word : sentence)
		{
			List<List<GraphExpr>> o = get(word);
			List<TypeString> l = new ArrayList<TypeString>();
			if(o == null)
				res.add(new ArrayList<TypeString>());
			else
			{
				for(List<GraphExpr> g : o)
					l.add(stringOfList(g));
				res.add(l);
			}
		}
		return res;
	}
	
	public void load(String filename)
	{
		try {
		JAXBContext jaxbContext;
			jaxbContext = JAXBContext
					.newInstance("xmllexicon");
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		JAXBElement<?> lexicon = (JAXBElement<?>)unmarshaller
				.unmarshal(new FileInputStream(filename));
		
		RawLexicon rl = (RawLexicon)lexicon.getValue();
		Entries entries = rl.getEntries();
		TypeRelations rels = rl.getRelations();
		//! TODO : HANDLE RELATIONS !
		
		//! TODO : add error handling ! (if entries.getEntry() is null (when there's no <entries>)
		for(EntryType ent : entries.getEntry()) {
			String form = ent.getForm();
			List<String> rawTypes = ent.getType();
			List<List<GraphExpr>> res = new ArrayList<List<GraphExpr>>();
			
			for(String rt : rawTypes)
			{
				GraphExprLexer lexer = new GraphExprLexer(rt);
				GraphExprParser parser = new GraphExprParser(lexer);
				try {
					java_cup.runtime.Symbol s = parser.parse();
					if(s.value != null)
						res.add((List<GraphExpr>)(s.value));
				} catch (Exception e) {
					System.err.println("Unable to parse the following type:");
					System.err.println(rt);
					//! TODO throw an exception here
				}
			}
			
			put(form, res);
		}
		
		} catch (JAXBException je) {
			je.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
}
