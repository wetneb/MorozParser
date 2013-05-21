package graphexpr;

import java.util.HashMap;

import util.NotFoundException;

public class NodeVarExpr extends NodeExpr implements Cloneable
{
	public int id;
	public NodeVarExpr(int i) { id = i; }

	public void shift(HashMap<Integer, Integer> map, String name) throws NotFoundException
	{
		if(map.get(id) == null)
			throw new NotFoundException(id);
		id = map.get(id);
	}

	public String toString()
	{
		return ""+id;
	}

	public Object clone()
	{
		return new NodeVarExpr(id);
	}
}