package graphexpr;

import java.util.HashMap;

public abstract class PatternExpr implements Cloneable
{
	public boolean isNode() { return (this instanceof NodeExpr); }
	public boolean isTriple() { return (this instanceof TripleExpr); }
	
	public abstract void shift(HashMap<Integer,Integer> map, String name);
	
	public abstract Object clone();
	
	public abstract String toString();
}
