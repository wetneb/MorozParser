package graphexpr;

import java.util.HashMap;

public class NamedNodeExpr extends NodeExpr
{
	public String name;
	public NamedNodeExpr(String s) { name = new String(s); } 
	
	public void shift(HashMap<Integer,Integer> map, String n)
	{
		name = name.replace("NAME",n);
	}
	
	public String toString()
	{
		return "node(\""+name+"\")";
	}

	public Object clone()
	{
		return new NamedNodeExpr(name);
	}
}