package rdf;

import graphexpr.ConsumerExpr;
import graphexpr.GraphExpr;
import graphexpr.PatternExpr;
import graphexpr.ProducerExpr;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import pregroup.PhraseString;
import pregroup.SimpleType;
import pregroup.TypeString;
import util.NotFoundException;
import util.UnknownTagException;
import xmllexicon.InputException;
import xmllexicon.SemanticLexicon;

public class GraphString extends PhraseString
{
	private static final long serialVersionUID = 1L;
	
	private HashMap<Integer, PatternExpr> patterns;

	public GraphString(SemanticLexicon lex, List<Pair<String,String>> sen, TypeString target) throws UnknownTagException, TypeException
	{
		this(lex.graphExprs(sen), sen, target);
	}
	
	public GraphString(SemanticLexicon lex, List<Pair<String,String>> sen, SimpleType target) throws UnknownTagException, TypeException
	{
		this(lex.graphExprs(sen), sen, new TypeString(target));
	}
	
	public PatternExpr getPattern(int index)
	{
		return patterns.get(index);
	}
	
	public void shiftPattern(HashMap<Integer, Integer> map, int idx, String name) throws NotFoundException
	{
		PatternExpr p = getPattern(idx);
		p.shift(map, name);
		patterns.put(idx, p);
	}
	
	public GraphString(List<List<List<GraphExpr>>> lst, List<Pair<String,String>> sen, TypeString target) throws TypeException
	{
		//! TODO Redesign this method : separate HashMap generation and type string generation
		patterns = new HashMap<Integer, PatternExpr>();
		int widx = 0;
		for(List<List<GraphExpr>> candidates : lst)
		{
			HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
			
			if(candidates.size() == 1 && candidates.get(0).size() == 1 && candidates.get(0).get(0).getType().isUnit())
				continue;
			
			addLB();
			addStar();
			for(List<GraphExpr> type : candidates)
			{
				int idx = this.size();
				
				TypeString str = new TypeString();
				for(GraphExpr ge : type)
				{
					if(ge.isConsumer())
					{
						ConsumerExpr c = (ConsumerExpr)ge;
						map.put(c.var, idx);
					}
					idx++;
				}
				
				idx = this.size();
				for(GraphExpr ge : type)
				{
					if(ge.isProducer())
					{
						ProducerExpr p = (ProducerExpr) ge;
						try {
							p.pattern.shift(map, sen.get(widx).getLeft());
						} catch(NotFoundException e)
						{
							throw new TypeException("Invalid pattern \""+p.pattern.toString()+
									"\": variable "+e.i+" is undefined.");
						}
						patterns.put(idx,p.pattern);
					}
					str.add(ge.getType());
					idx++;
				}
				
				addType(str);
				addStar();
			}
			
			addRB();
			widx++;
		}
		
		//! Add the candidate
		addLB();
		addStar();
		addType(target.right());
	}

}
