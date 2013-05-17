package graphexpr;

import java.util.HashMap;

public class RelExpr extends PropExpr implements Cloneable
{
	public NodeExpr node;
	public RelExpr(NodeExpr n) { node = n; }
	
	public void shift(HashMap<Integer, Integer> map, String name)
	{
		node.shift(map, name);
	}
	
	public Object clone()
	{
		return new RelExpr((NodeExpr) node.clone());
	}
	
	public String toString()
	{
		return "rel("+node.toString()+")";
	}
}