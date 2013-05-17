package graphexpr;

import java.util.HashMap;

public class TripleExpr extends PatternExpr implements Cloneable
{
	public NodeExpr subj;
	public PropExpr prop;
	public NodeExpr obj;
	public TripleExpr(NodeExpr s, PropExpr p, NodeExpr o)
	{
		subj = s;
		prop = p;
		obj = o;
	}
	
	public void shift(HashMap<Integer,Integer> map, String name)
	{
		subj.shift(map, name);
		prop.shift(map, name);
		obj.shift(map, name);
	}

	public String toString()
	{
		return "("+subj.toString()+","+prop.toString()+","+obj.toString()+")";
	}

	public Object clone()
	{
		return new TripleExpr((NodeExpr)subj.clone(), (PropExpr) prop.clone(), (NodeExpr) obj.clone());
	}
}