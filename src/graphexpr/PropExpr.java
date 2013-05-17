package graphexpr;

import java.util.HashMap;

public abstract class PropExpr implements Cloneable
{
	public boolean isCst() { return (this instanceof CstExpr); }
	public boolean isRel() { return (this instanceof RelExpr); }
	
	public abstract void shift(HashMap<Integer,Integer> map, String name);
	
	public abstract String toString();
	public abstract Object clone();
}