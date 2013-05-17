package graphexpr;

import java.util.HashMap;

public class VarExpr extends NodeExpr implements Cloneable
{
	public int id;
	public VarExpr(int i) { id = i; }

	public void shift(HashMap<Integer, Integer> map, String name)
	{
		id = map.get(id);
	}

	public String toString()
	{
		return ""+id;
	}

	public Object clone()
	{
		return new VarExpr(id);
	}
}