package rdf;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.vocabulary.*;

import graphexpr.ExprResolver;
import graphexpr.LiteralExpr;
import graphexpr.MorphExpr;
import graphexpr.NodeExpr;
import graphexpr.PatternExpr;
import graphexpr.StmtExpr;
import graphexpr.TripleExpr;
import graphexpr.NodeVarExpr;
import graphexpr.NamedNodeExpr;
import graphexpr.TripleVarExpr;

public class GraphCompiler
{
	private Model model;
	private ExprResolver resolver;
	
	public GraphCompiler(ExprResolver r)
	{
		model = ModelFactory.createDefaultModel();
		resolver = r;
	}
	
	public String dumpTriples()
	{
		StringWriter writer = new StringWriter();
		model.write(writer, "N-TRIPLES");
		String res = writer.toString();
		System.out.println(res);
		return res;
	}
	
	public void assume(Statement stmt)
	{
		model.add(stmt);
	}
	
	public RDFNode compileNode(PatternExpr node) throws TypeException
	{
		if(node.isNode())
		{
			NodeExpr n = (NodeExpr)node;
			
			if(n.isVar())
			{
				return compileNode(resolver.get(((NodeVarExpr)n).id));
			}
			else if(n.isNamedNode())
			{
				return model.createResource(((NamedNodeExpr)n).name);
			}
			else if(n.isFresh())
			{
				return model.createResource();
			}
			else if(n.isMorph())
			{
				MorphExpr m = (MorphExpr)n;
				if(m.isReify)
				{
					return compileStmt(m.triple).createReifiedStatement();
				}
				else
				{
					Statement stmt = compileStmt(m.triple);
					Resource subj = stmt.getSubject();
					subj.addProperty(stmt.getPredicate(), stmt.getObject());
					return subj;
				}
			}
			else if(n.isLiteral())
			{
				LiteralExpr l = (LiteralExpr)n;
				return model.createLiteral(l.val);
			}
			else
				throw new TypeException("In "+node.toString()+", invalid node");
		}
		else
			throw new TypeException("In "+node.toString()+", invalid node");
	}
	
	public Statement compileStmt(PatternExpr node) throws TypeException
	{
		if(node == null)
			throw new TypeException("Triple is null");
		
		if(node.isStmt())
		{
			StmtExpr stmt = (StmtExpr)node;
			if(stmt.isVar())
			{
				return compileStmt(resolver.get(((TripleVarExpr)stmt).id));
			}
			else if(stmt.isTriple())
			{
				TripleExpr triple = (TripleExpr)stmt;
				RDFNode subj;
				RDFNode prop;
				RDFNode obj;
				try
				{
					subj = compileNode(triple.subj);
				}
				catch(TypeException t)
				{
					throw new TypeException("Invalid subject for triple "
								 +triple.toString()+":\n"+t.what);
				}
				try
				{
					prop = compileNode(triple.prop);
				}
				catch(TypeException t)
				{
					throw new TypeException("Invalid property for triple "
						+triple.toString()+":\n"+t.what);
				}
				try
				{
					obj = compileNode(triple.obj);
				}
				catch(TypeException t)
				{
					throw new TypeException("Invalid object for triple "+
										triple.toString()+":\n"+t.what);
				}
			
				try
				{
					Resource subj2 = (Resource)subj;
					return model.createStatement(subj2, model.createProperty(prop.toString()), obj);
				}
				catch(ClassCastException e)
				{
					throw new TypeException("Invalid subject for triple "+
							triple.toString()+": a resource is needed.\n");
				}	
			}
			else
				throw new TypeException("Invalid statement "+node.toString());
		}
		else
			throw new TypeException("Invalid statement "+node.toString());
		
	}
}

