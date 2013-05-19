package rdf;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.vocabulary.*;

import graphexpr.DoubleExpr;
import graphexpr.ExprResolver;
import graphexpr.NodeExpr;
import graphexpr.PlusExpr;
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
			else if(n.isPlus())
			{
				PlusExpr p = (PlusExpr)n;
				
				RDFNode base = compileNode(p.node);
				for(DoubleExpr d : p.doubles)
				{
					DoubleNode dn = compileDouble(d);
					((Resource)base).addProperty(dn.prop, dn.obj);
				}
				
				return base;
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
	
	public Property compileProp(PropExpr prop) throws TypeException
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
	
	public Statement compileStmt(PatternExpr node) throws TypeException
	{
		if(node == null)
			throw new TypeException("Triple is null");
		if(!node.isTriple())
			throw new TypeException("Invalid triple "+node.toString());
		else
		{
			TripleExpr triple = (TripleExpr)node;
			RDFNode subj;
			Property prop;
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
				prop = compileProp(triple.prop);
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
				return model.createStatement(subj2, prop, obj);
			}
			catch(ClassCastException e)
			{
				throw new TypeException("Invalid subject for triple "+
						triple.toString()+": a resource is needed.\n");
			}
					
		}
		
	}
	
	public DoubleNode compileDouble(DoubleExpr d) throws TypeException
	{
		return new DoubleNode(compileProp(d.prop), compileNode(d.node));
	}
}

class DoubleNode
{
	Property prop;
	RDFNode obj;
	public DoubleNode(Property p, RDFNode o)
	{
		prop = p;
		obj = o;
	}
}
