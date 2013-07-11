package graphexpr

abstract class StmtExpr2
{
	override def toString() : String = this match {
	  case StmtTriple(s, p, o) => "("+s.toString()+","+p.toString()+","+o.toString()+")"
	  case StmtVar(id) => id
	}
}

case class StmtTriple(s: NodeExpr2, p: NodeExpr2, o: NodeExpr2) extends StmtExpr2
case class StmtVar(id: String) extends StmtExpr2

