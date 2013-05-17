package graphexpr;

import java.util.HashMap;

class FreshExpr extends NodeExpr
{
	public int id;
	private static int nextId = 0;
	public FreshExpr() { id = nextId; nextId++; }
	
	public FreshExpr clone()
	{
		return new FreshExpr();
	}
	
	public void shift(HashMap<Integer,Integer> map, String name)
	{
		
	}
	
	public String toString()
	{
		return "fresh_node";
	}
}