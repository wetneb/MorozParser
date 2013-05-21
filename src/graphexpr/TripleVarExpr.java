package graphexpr;

import java.util.HashMap;

import util.NotFoundException;

public class TripleVarExpr extends StmtExpr
{
	public int id;

	public TripleVarExpr(int i) { id = i; }

	public void shift(HashMap<Integer, Integer> map, String name)
			throws NotFoundException
	{
		if(map.get(id) == null)
			throw new NotFoundException(id);
		id = map.get(id);	
	}


	public Object clone()
	{
		return new TripleVarExpr(id);
	}

	public String toString()
	{
		return new Integer(id).toString();
	}
}
