package graphexpr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlusExpr extends NodeExpr
{
	public NodeExpr node;
	public List<DoubleExpr> doubles;
	public PlusExpr(NodeExpr n, List<DoubleExpr> l)
	{
		node = n;
		doubles = l;
	}
	
	public void shift(HashMap<Integer,Integer> map, String name)
	{
		node.shift(map, name);
		for(DoubleExpr d : doubles)
			d.shift(map, name);
	}
	
	public String toString()
	{
		String res = "["+node.toString()+"+";
		for(DoubleExpr d : doubles)
			res = res + d.toString();
		return res;
	}

	public Object clone()
	{
		List<DoubleExpr> cloned = new ArrayList<DoubleExpr>();
		for(DoubleExpr d : doubles)
			cloned.add((DoubleExpr) d.clone());
		return new PlusExpr((NodeExpr)node.clone(), cloned);
	}
}