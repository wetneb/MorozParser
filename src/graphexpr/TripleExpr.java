package graphexpr;

import java.util.HashMap;

import util.NotFoundException;

public class TripleExpr extends StmtExpr implements Cloneable
{
	public NodeExpr subj;
	public NodeExpr prop;
	public NodeExpr obj;
	public TripleExpr(NodeExpr s, NodeExpr p, NodeExpr o)
	{
		subj = s;
		prop = p;
		obj = o;
	}
	
	public void shift(HashMap<Integer,Integer> map, String name) throws NotFoundException
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
		return new TripleExpr((NodeExpr)subj.clone(), (NodeExpr) prop.clone(), (NodeExpr) obj.clone());
	}
}