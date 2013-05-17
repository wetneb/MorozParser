package graphexpr;

import java.util.HashMap;

class NullExpr extends NodeExpr implements Cloneable
{
	public NullExpr() { }
	
	public void shift(HashMap<Integer,Integer> map, String name)
	{
		
	}
	
	public Object clone()
	{
		return new NullExpr();
	}
	
	public String toString()
	{
		return "null";
	}
}