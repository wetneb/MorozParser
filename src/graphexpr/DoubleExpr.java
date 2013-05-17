package graphexpr;

import java.util.HashMap;

public class DoubleExpr implements Cloneable
{
	public PropExpr prop;
	public NodeExpr node;
	public DoubleExpr(PropExpr p, NodeExpr n)
	{
		prop = p;
		node = n;
	}
	
	public void shift(HashMap<Integer,Integer> map, String name)
	{
		prop.shift(map, name);
		node.shift(map, name);
	}
	
	public Object clone()
	{
		return new DoubleExpr((PropExpr)prop.clone(),(NodeExpr)node.clone());
	}
	
	public String toString()
	{
		return "("+prop.toString()+", "+node.toString()+")";
	}
}