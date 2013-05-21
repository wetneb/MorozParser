package graphexpr;

public abstract class NodeExpr extends PatternExpr implements Cloneable
{
	public boolean isVar() { return (this instanceof NodeVarExpr); }
	public boolean isFresh() { return (this instanceof FreshExpr); }
	public boolean isNamedNode() { return (this instanceof NamedNodeExpr); }
	public boolean isMorph() { return (this instanceof MorphExpr); }
	public boolean isLiteral() { return (this instanceof LiteralExpr); }
	
	public abstract String toString();
	public abstract Object clone();
}