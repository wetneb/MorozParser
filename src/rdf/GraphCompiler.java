package rdf;

import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.vocabulary.*;

import graphexpr.ExprResolver;
import graphexpr.NodeExpr;
import graphexpr.PropExpr;
import graphexpr.PatternExpr;
import graphexpr.RelExpr;
import graphexpr.TripleExpr;
import graphexpr.CstExpr;
import graphexpr.VarExpr;
import graphexpr.NamedNodeExpr;
import graphexpr.ObjExpr;
import graphexpr.SubExpr;

public class GraphCompiler
{
	private Model model;
	private ExprResolver resolver;
	private Resource nullNode;
	
	public GraphCompiler(ExprResolver r)
	{
		model = ModelFactory.createDefaultModel();
		resolver = r;
		nullNode = model.createResource("null");
	}
	
	RDFNode compileNode(PatternExpr node) throws TypeException
	{
		if(node.isNode())
		{
			NodeExpr n = (NodeExpr)node;
			
			if(n.isNull())
			{
				return nullNode;
			}
			else if(n.isVar())
			{
				return compileNode(resolver.get(((VarExpr)n).id));
			}
			else if(n.isNamedNode())
			{
				return model.createResource(((NamedNodeExpr)n).name);
			}
			else if(n.isFresh())
			{
				return model.createResource();
			}
			else if(n.isObj())
			{
				try
				{
					Statement stmt = compileStmt(((ObjExpr)n).node);
					return stmt.getObject();
				}
				catch(TypeException t)
				{
					throw new TypeException("Invalid statement in "+
							n.toString()+":\n"+t.what);
				}
			}
			else if(n.isSub())
			{
				try
				{
					Statement stmt = compileStmt(((SubExpr)n).node);
					return stmt.getSubject();
				}
				catch(TypeException t)
				{
					throw new TypeException("Invalid statement in "+
							n.toString()+":\n"+t.what);
				}
			}
			else
				throw new TypeException("Invalid node "+node.toString());
		}
		else
			throw new TypeException("In "+node.toString()+", invalid node");
	}
	
	Property compileProp(PropExpr prop) throws TypeException
	{
		if(prop.isCst())
		{
			return model.createProperty(((CstExpr)prop).str);
		}
		else if(prop.isRel())
		{
			try
			{
				RelExpr rel = (RelExpr)prop;
				Statement stmt = compileStmt(rel.node);
				return stmt.getPredicate();
			}
			catch(TypeException t)
			{
				throw new TypeException("In "+prop.toString()+", invalid statement:\n"
						+t.what);
			}
		}
		else
			throw new TypeException("Invalid property: "+prop.toString());
	}
	
	Statement compileStmt(PatternExpr node) throws TypeException
	{
		if(!node.isTriple())
			throw new TypeException("Invalid triple "+node.toString());
		else
		{
			TripleExpr triple = (TripleExpr)node;
			try
			{
				RDFNode subj = compileNode(triple.subj);
				
				try
				{
					Property prop = compileProp(triple.prop);
					
					try
					{
						RDFNode obj = compileNode(triple.obj);
						
						try
						{
							Resource subj2 = (Resource)subj;
							return model.createStatement(subj2, prop, obj);
						}
						catch(ClassCastException e)
						{
							throw new TypeException("Invalid subject for triple "+
									triple.toString()+": a resource is needed.\n");
						}
					}
					catch(TypeException t)
					{
						throw new TypeException("Invalid object for triple "+
									triple.toString()+":\n"+t.what);
					}
				}
				catch(TypeException t)
				{
					throw new TypeException("Invalid property for triple "
							+triple.toString()+":\n"+t.what);
				}
			}
			catch(TypeException t)
			{
				throw new TypeException("Invalid subject for triple "
						      +triple.toString()+":\n"+t.what);
			}
		}
	}
}

class TypeException extends Exception
{
	private static final long serialVersionUID = 1L;
	public String what;
	public TypeException(String w) { what = w; }
}
