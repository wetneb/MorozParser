package graphexpr;

public abstract class PatternExpr
{
	public boolean isNode() { return (this instanceof NodeExpr); }
	public boolean isTriple() { return (this instanceof TripleExpr); }
}
