package graphexpr

abstract class NodeExpr2
{
	override def toString() : String = this match {
	  case NodeVar(v) => v
	  case NodeFresh(id) => "blank-"+id
	  case NodeNamed(name) => name
	  case NodeAlpha(arg) => "qlify("+arg.toString()+")"
	  case NodeBeta(arg) => "reify("+arg.toString()+")"
	  case NodeLiteral(name) => "\""+name+"\""
	}
}

case class NodeVar(v: String) extends NodeExpr2
case class NodeFresh(id: Int) extends NodeExpr2
case class NodeNamed(name: String) extends NodeExpr2
case class NodeAlpha(arg: StmtExpr2) extends NodeExpr2
case class NodeBeta(arg: StmtExpr2) extends NodeExpr2
case class NodeLiteral(name: String) extends NodeExpr2
