package graphexpr;

public class NodeExpr extends PatternExpr
{
	public boolean isNull() { return (this instanceof NullExpr); }
	public boolean isVar() { return (this instanceof VarExpr); }
	public boolean isFresh() { return (this instanceof FreshExpr); }
	public boolean isNamedNode() { return (this instanceof NamedNodeExpr); }
	public boolean isPlus() { return (this instanceof PlusExpr); }
	public boolean isSub() { return (this instanceof SubExpr); }
	public boolean isObj() { return (this instanceof ObjExpr); }
}