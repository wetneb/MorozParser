package graphexpr;

import java.util.HashMap;

public class LiteralExpr extends NodeExpr
{
	public String val;
	
	public LiteralExpr(String str)
	{
		val = str;
	}

	public String toString()
	{
		return "\""+val+"\"";
	}

	public Object clone()
	{
		return new LiteralExpr(new String(val));
	}

	public void shift(HashMap<Integer, Integer> map, String name)
	{
		val = val.replace("NAME", name);
	}

}
