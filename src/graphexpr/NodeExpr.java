package graphexpr;

public abstract class NodeExpr extends PatternExpr implements Cloneable
{
	public boolean isNull() { return (this instanceof NullExpr); }
	public boolean isVar() { return (this instanceof VarExpr); }
	public boolean isFresh() { return (this instanceof FreshExpr); }
	public boolean isNamedNode() { return (this instanceof NamedNodeExpr); }
	public boolean isPlus() { return (this instanceof PlusExpr); }
	public boolean isSub() { return (this instanceof SubExpr); }
	public boolean isObj() { return (this instanceof ObjExpr); }
	
	public abstract String toString();
	public abstract Object clone();
}