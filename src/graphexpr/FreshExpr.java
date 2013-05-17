package graphexpr;

class FreshExpr extends NodeExpr
{
	public int id;
	private static int nextId = 0;
	public FreshExpr() { id = nextId; nextId++; }
}