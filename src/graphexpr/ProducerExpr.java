package graphexpr;

import pregroup.SimpleType;

public class ProducerExpr extends GraphExpr implements Cloneable
{
	public SimpleType type;
	public PatternExpr pattern;
	public ProducerExpr(SimpleType t, PatternExpr p)
	{
		type = t;
		pattern = p;
	}
	
	public Object clone()
	{
		return new ProducerExpr(type, (PatternExpr) pattern.clone());
	}
	
	public String toString()
	{
		return type.toString() + " : " + pattern.toString();
	}
	
	public SimpleType getType()
	{
		return type;
	}
}
