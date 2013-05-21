package graphexpr;

import java.util.HashMap;

import util.NotFoundException;

public class MorphExpr extends NodeExpr
{
	public boolean isReify;
	public StmtExpr triple;
	
	public MorphExpr(boolean reify, StmtExpr t)
	{
		isReify = reify;
		triple = t;
	}
	
	public String toString()
	{
		if(isReify)
			return "reify("+triple.toString()+")";
		else
			return "qlify("+triple.toString()+")";
	}

	public Object clone()
	{
		return new MorphExpr(isReify, (StmtExpr) triple.clone());
	}

	public void shift(HashMap<Integer, Integer> map, String name)
			throws NotFoundException
	{
		triple.shift(map,name);
	}

}
