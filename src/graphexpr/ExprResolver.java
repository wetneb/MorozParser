package graphexpr;

import java.util.HashMap;
import java.util.List;

import pregroup.PhraseString;
import pregroup.TypeLink;
import pregroup.TypeReduction;

public class ExprResolver extends HashMap<Integer, PatternExpr>
{
	private static final long serialVersionUID = 1L;
	
	public ExprResolver(PhraseString phr, TypeReduction red, List<GraphExpr> lst)
	{
		super();
		
		for(TypeLink link : red)
		{
			this.put(link.start, lst.get(link.start).pattern);
			this.put(link.end, lst.get(link.end).pattern);
		}
	}
}
