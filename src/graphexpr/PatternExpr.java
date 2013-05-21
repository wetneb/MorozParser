package graphexpr;

import java.util.HashMap;

import util.NotFoundException;

public abstract class PatternExpr implements Cloneable
{
	public boolean isNode() { return (this instanceof NodeExpr); }
	public boolean isStmt() { return (this instanceof StmtExpr); }
	
	public abstract void shift(HashMap<Integer,Integer> map, String name) throws NotFoundException;
	
	public abstract Object clone();
	
	public abstract String toString();
}
