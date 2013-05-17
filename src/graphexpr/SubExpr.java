package graphexpr;

import java.util.HashMap;

public class SubExpr extends NodeExpr implements Cloneable
{
	public NodeExpr node;
	public SubExpr(NodeExpr n) { node = n; }

	public void shift(HashMap<Integer, Integer> map, String name)
	{
		node.shift(map, name);
	}
	
	public String toString()
	{
		return "sub("+node.toString()+")";
	}

	public Object clone()
	{
		return new SubExpr((NodeExpr)node.clone());
	}
}