package graphexpr;

import java.util.HashMap;

import pregroup.TypeLink;
import pregroup.TypeReduction;
import rdf.GraphString;

public class ExprResolver extends HashMap<Integer, PatternExpr>
{
	private static final long serialVersionUID = 1L;
	
	private int entrypoint;

	public ExprResolver(GraphString phr, TypeReduction red)
	{
		super();
		
		for(TypeLink link : red)
		{
			this.put(link.start, phr.getPattern(link.end));
			this.put(link.end, phr.getPattern(link.start));
			if(link.end == phr.size()-1)
				entrypoint = link.start;
		}
	}
	
	public int getEntryPoint()
	{
		return entrypoint;
	}
}
