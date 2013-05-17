package graphexpr;


import pregroup.SimpleType;

public class GraphExpr
{
	public SimpleType type;
	public PatternExpr pattern;
	public GraphExpr(SimpleType t, PatternExpr p)
	{
		type = t;
		pattern = p;
	}
}

