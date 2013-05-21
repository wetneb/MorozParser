package graphexpr;

import pregroup.SimpleType;

public class ConsumerExpr extends GraphExpr
{
	public SimpleType type;
	public Integer var;
	
	public ConsumerExpr(SimpleType t, Integer p)
	{
		type = t;
		var = p;
	}
	
	public Object clone()
	{
		return new ConsumerExpr(type,new Integer(var));
	}
	
	public String toString()
	{
		return type.toString() + " : " + var.toString();
	}
	
	public SimpleType getType()
	{
		return type;
	}
}
