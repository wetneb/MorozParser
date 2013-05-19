package rdf;

import graphexpr.GraphExpr;
import graphexpr.PatternExpr;
import graphexpr.NodeExpr;
import graphexpr.VarExpr;

import java.util.HashMap;
import java.util.List;

import pregroup.PhraseString;
import pregroup.SimpleType;
import pregroup.TypeString;
import xmllexicon.InputException;
import xmllexicon.SemanticLexicon;

public class GraphString extends PhraseString
{
	private static final long serialVersionUID = 1L;
	
	private HashMap<Integer, PatternExpr> patterns;

	public GraphString(SemanticLexicon lex, List<String> lst, List<String> sen, TypeString target) throws InputException
	{
		this(lex.graphExprs(lst), sen, target);
	}
	
	public GraphString(SemanticLexicon lex, List<String> lst, List<String> sen, SimpleType target) throws InputException
	{
		this(lex.graphExprs(lst), sen, new TypeString(target));
	}
	
	public PatternExpr getPattern(int index)
	{
		return patterns.get(index);
	}
	
	public void shiftPattern(HashMap<Integer, Integer> map, int idx, String name)
	{
		PatternExpr p = getPattern(idx);
		p.shift(map, name);
		patterns.put(idx, p);
	}
	
	public GraphString(List<List<List<GraphExpr>>> lst, List<String> sen, TypeString target)
	{
		patterns = new HashMap<Integer, PatternExpr>();
		int widx = 0;
		for(List<List<GraphExpr>> candidates : lst)
		{
			HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
			
			addLB();
			addStar();
			for(List<GraphExpr> type : candidates)
			{
				int idx = this.size();
				
				TypeString str = new TypeString();
				for(GraphExpr ge : type)
				{
					PatternExpr p = ge.pattern;
					if(p.isNode())
					{
						NodeExpr n = (NodeExpr)p;
						if(n.isVar())
						{
							map.put(((VarExpr)n).id, idx);
						}
					}
					idx++;
				}
				
				idx = this.size();
				for(GraphExpr ge : type)
				{
					PatternExpr p = ge.pattern;
					p.shift(map, sen.get(widx));
					patterns.put(idx,ge.pattern);
					str.add(ge.type);
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
