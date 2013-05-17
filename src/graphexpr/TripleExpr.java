package graphexpr;

public class TripleExpr extends PatternExpr
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
}