package latex;

import graphexpr.ExprResolver;
import graphexpr.MorphExpr;
import graphexpr.NamedNodeExpr;
import graphexpr.NodeExpr;
import graphexpr.NodeVarExpr;
import graphexpr.PatternExpr;
import graphexpr.StmtExpr;
import graphexpr.TripleExpr;
import graphexpr.TripleVarExpr;

import java.util.List;

import pregroup.TypeLink;
import pregroup.TypeReduction;
import rdf.GraphString;

//! Creates a TikZ output from a graph string
public class TikzGraphExpr {
	
	private static final String tikzHeader =
			"\\begin{tikzpicture}[\n"+
		    "every node/.style={%\n"+
			"text height=1.5ex," +
			"text depth=0.25ex,"+
			"}]\n"+
			"% Diagram generated by http://github.com/wetneb/MorozParser"+
			"\n\n";
	private static final String tikzFooter = "\n\\end{tikzpicture}\n";
	
	//! Vertical space between the types and the links below them
	private static final double distToTypes = 0.25;
	//! Horizontal space between two simple types in the same word
	private static final double typeSpacing = 0.4;
	//! Horizontal space between the types of two words
	private static final double wordSpacing = 1.1;
	//! Vertical space between the original words and their types
	private static final double textDistance = 3;
	//! Vertical space between the graph expressions and their types
	private static final double graphExprDist = 0.25;
	
	//! Vertical spacing of fresh nodes
	private static final double freshNodeDist = 0.5;
	//! Vertical spacing of morph nodes (alpha & beta)
	private static final double morphDist = 1;
	//! Vertical spacing of literal nodes
	private static final double literalDist= 0.2;
	//! Horizontal spacing of links in a S link
	private static final double distanceStatement = 0.15;
	
	public static String draw(GraphString phrase, List<String> words, TypeReduction red, ExprResolver res, boolean expand)
	{
		int n = phrase.size();
		double[] pos = new double[n];
		boolean[] used = new boolean[n];
		
		String output = tikzHeader;
		
		//! Compute the used types
		for(int i = 0; i < n; i++)
			used[i] = false;
		for(TypeLink l : red)
		{
			used[l.start] = true;
			used[l.end] = true;
		}
		
		//! Compute the position of the used types
		double curPos = 0;
		int curWord = 0;
		int nbTypes = 0;
	    double sumPos = 0;
		for(int i = 0; i < n-1; i++)
		{
			if(used[i])
			{
				pos[i] = curPos;
				sumPos += curPos;
				nbTypes++;
				output += "\\node at ("+curPos+",0) (t"+i+") {$"+phrase.get(i).toLatex()+"$};\n";
				curPos += typeSpacing;
			}
			else if(phrase.get(i).isRB() && nbTypes > 0)
			{
				output += "\\node at ("+(sumPos/nbTypes)+","+textDistance+") (w"+curWord+") {"+words.get(curWord)+"};\n";
				curWord++;
				sumPos = 0;
				nbTypes = 0;
				curPos += wordSpacing-typeSpacing;
			}
		}
		
		//! Compute the maximum radius
		double maxRad = 0;
		for(TypeLink l : red)
		{
			double rad = (pos[l.end] - pos[l.start])/2.;
			if(rad > maxRad && l.end != n-1)
				maxRad = rad;
		}
		
		output += "\n\n% Curves below :\n\n";
		
		//! Draw the curves
		for(TypeLink l : red)
		{
			double from = pos[l.start];
			double to = pos[l.end];
			
			if(l.end != n-1)
			{
				if(phrase.get(l.start).isS())
					output += drawSLink(from, to, -distToTypes, false);
				else
					output += drawLoop(from, to, distToTypes, false);
				output += "\n";
			}
			else
			{
				output += "\\draw ("+(from-distanceStatement)+",-"+distToTypes+") -- ("
							+(from-distanceStatement)+",-"+(distToTypes+maxRad)+");\n" +
						"\\draw ("+from+",-"+distToTypes+") -- ("+from+",-"+(distToTypes+maxRad)+");\n" +
						"\\draw ("+(from+distanceStatement)+",-"+distToTypes+") -- ("+
						(from+distanceStatement)+",-"+(distToTypes+maxRad)+");\n";
			}
		}
		
		output += "\n% Curves above:\n\n";
		
		//! Draw the graph expressions
		for(int i = 0; i < n-1; i++)
		{
			if(used[i] && phrase.get(i).isProducer())
			{
				output += drawGraphExpr(phrase.getPattern(i), res, pos, pos[i], graphExprDist, expand);
				output += "\n";
			}
		}
		
		output += tikzFooter;
		return output;
	}
	
	private static String drawLoop(double from, double to, double height, boolean over)
	{			
		if(to < from)
		{
			double tmp = from;
			from = to;
			to = tmp;
		}
		double radius = (to - from)/2.;
		double center = (from + to) /2.;
		double vradius = (over ? -radius : radius);
		
		return "\\draw ("+from+",-"+height+")"+
				   " .. controls ("+from+",-"+(height+0.555*vradius)+")"+
						   " and ("+(center-0.555*radius)+",-"+(height+vradius)+")"+
						   	" .. ("+center+",-"+(height+vradius)+")"+
				   " .. controls ("+(center+0.555*radius)+",-"+(height+vradius)+")"+
						   " and ("+to+",-"+(height+0.555*vradius)+")"+
				            " .. ("+to+",-"+height+");\n";
	}
	
	private static String drawGraphExpr(PatternExpr p, ExprResolver res, double[] pos, double nodePos, double height, boolean expand)
	{
		if(p.isNode())
			return drawNodeExpr((NodeExpr)p,res,pos,nodePos,height,expand);
		else if(p.isStmt())
			return drawStmtExpr((StmtExpr)p,res,pos,nodePos,height,expand);
		
		return "";
	}
	
	private static String drawNodeExpr(NodeExpr n, ExprResolver res, double[] pos, double nodePos, double height, boolean expand)
	{
		if(n.isVar())
		{	
			NodeVarExpr nv = (NodeVarExpr)n;
			if(expand)
				return drawNodeExpr((NodeExpr) res.get(nv.id), res,pos,nodePos,height,expand);
			else
				return drawVarLink(nodePos, pos[nv.id], height);
		}
		else if(n.isFresh() || n.isNamedNode() || n.isLiteral())
		{
			double dist = 0;
			String size = "";
			if(n.isFresh() || n.isNamedNode())
				dist = freshNodeDist;
			else
			{
				dist = literalDist;
				size="minimum size=0.5cm, scale=0.2";
			}
			return "\\node[circle,draw,inner sep=0pt, "+size+"] at ("
		           +nodePos+","+(height+dist)+") (fresh) {};\n"+
				    "\\draw ("+nodePos+","+height+") -- (fresh);\n";
		}
		else if(n.isNamedNode())
		{
			return "\\node[circle,draw] at ("+nodePos+","+(height+freshNodeDist)+") (named) {};\n"+
				    "\\draw ("+nodePos+","+height+") -- (named);\n";
		}
		else if(n.isMorph())
		{
			MorphExpr m = (MorphExpr)n;
			String start = "\\node[rectangle,draw] at ("+nodePos+","+(height+morphDist)+")"+
					" (morph) {$"+(m.isReify ? "\\beta" : "\\alpha")+"$};\n"+
					"\\draw ("+nodePos+","+height+") -- (morph);\n";
			return start+drawStmtExpr(m.triple,res,pos,nodePos,height+morphDist+0.25, expand);
		}
		return "";
	}
	
	private static String drawStmtExpr(StmtExpr s, ExprResolver res, double[] pos, double nodePos, double height, boolean expand)
	{
		if(s.isTriple())
		{
			TripleExpr t = (TripleExpr)s;
			
			double pos_1 = nodePos - distanceStatement;
			double pos_2 = nodePos;
			double pos_3 = nodePos + distanceStatement;
			
			return drawNodeExpr(t.subj, res, pos, pos_1, height, expand) +
					drawNodeExpr(t.prop, res, pos, pos_2, height, expand) +
					drawNodeExpr(t.obj, res, pos, pos_3, height, expand);
		}
		else if(s.isVar())
		{
			TripleVarExpr v = (TripleVarExpr)s;
			double to = pos[v.id];

			return drawSLink(nodePos, to, height, true);
		
		}
		return "";
	}
	
	private static String drawVarLink(double from, double to, double height)
	{
		String output = drawLoop(from, to, -height, true);
		output += "\\draw ("+to+","+height+") -- ("+to+","+graphExprDist+");\n";
		return output;
	}
	
	private static String drawSLink(double from, double to, double height, boolean above)
	{
		if(above)
		return drawVarLink(from - distanceStatement, to + distanceStatement, height) +
				   drawVarLink(from, to, height) +
				   drawVarLink(from + distanceStatement, to - distanceStatement, height);
		else
			return drawLoop(from - distanceStatement, to + distanceStatement, -height, false) +
				   drawLoop(from, to, -height, false) +
				   drawLoop(from + distanceStatement, to - distanceStatement, -height, false);
	}
}
