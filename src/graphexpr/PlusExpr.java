package graphexpr;

import java.util.List;

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