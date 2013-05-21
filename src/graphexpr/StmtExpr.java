package graphexpr;

import java.util.HashMap;

import util.NotFoundException;

public abstract class StmtExpr extends PatternExpr
{
	public boolean isTriple() { return (this instanceof TripleExpr); }
	public boolean isVar() { return (this instanceof TripleVarExpr); }

}
