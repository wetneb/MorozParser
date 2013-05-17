package graphexpr;

public abstract class PropExpr
{
	public boolean isCst() { return (this instanceof CstExpr); }
	public boolean isRel() { return (this instanceof RelExpr); }
}