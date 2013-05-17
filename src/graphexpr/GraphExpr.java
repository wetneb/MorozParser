package graphexpr;


import pregroup.SimpleType;

public class GraphExpr implements Cloneable
{
	public SimpleType type;
	public PatternExpr pattern;
	public GraphExpr(SimpleType t, PatternExpr p)
	{
		type = t;
		pattern = p;
	}
	
	public Object clone()
	{
		return new GraphExpr(type, (PatternExpr) pattern.clone());
	}
	
	public String toString()
	{
		return type.toString() + " : " + pattern.toString();
	}
}

