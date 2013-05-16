package graphexpr;

import java.util.List;

import pregroup.SimpleType;

public class GraphExpr
{
	public SimpleType type;
	public PatternExpr pattern;
	public GraphExpr(SimpleType t, PatternExpr p)
	{
		type = t;
		pattern = p;
	}
}

abstract class PatternExpr
{
	public boolean isNode() { return (this instanceof NodeExpr); }
	public boolean isTriple() { return (this instanceof TripleExpr); }
}

class NodeExpr extends PatternExpr
{
	public boolean isNull() { return (this instanceof NullExpr); }
	public boolean isVar() { return (this instanceof VarExpr); }
	public boolean isFresh() { return (this instanceof FreshExpr); }
	public boolean isNamedNode() { return (this instanceof NamedNodeExpr); }
	public boolean isPlus() { return (this instanceof PlusExpr); }
}

class NullExpr extends NodeExpr
{
	public NullExpr() { }
}

class VarExpr extends NodeExpr
{
	public int id;
	public VarExpr(int i) { id = i; }
}

class FreshExpr extends NodeExpr
{
	public int id;
	private static int nextId = 0;
	public FreshExpr() { id = nextId; nextId++; }
}

class NamedNodeExpr extends NodeExpr
{
	public String name;
	public NamedNodeExpr(String s) { name = s; } 
}

class PlusExpr extends NodeExpr
{
	public NodeExpr node;
	public List<DoubleExpr> doubles;
	public PlusExpr(NodeExpr n, List<DoubleExpr> l)
	{
		node = n;
		doubles = l;
	}
}

class DoubleExpr
{
	public String prop;
	public NodeExpr node;
	public DoubleExpr(String p, NodeExpr n)
	{
		prop = p;
		node = n;
	}
}

class TripleExpr extends PatternExpr
{
	public NodeExpr subj;
	public String prop;
	public NodeExpr obj;
	public TripleExpr(NodeExpr s, String p, NodeExpr o)
	{
		subj = s;
		prop = p;
		obj = o;
	}
}

