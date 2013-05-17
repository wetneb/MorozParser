package graphexpr;

import java.util.HashMap;

public class ObjExpr extends NodeExpr implements Cloneable
{
	public NodeExpr node;
	public ObjExpr(NodeExpr n) { node = n; }
	
	public void shift(HashMap<Integer,Integer> map, String name)
	{
		node.shift(map, name);
	}
	
	public Object clone()
	{
		return new ObjExpr((NodeExpr) node.clone());
	}
	
	public String toString()
	{
		return "node("+node.toString()+")";
	}
}