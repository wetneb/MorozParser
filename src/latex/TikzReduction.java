package latex;

import java.util.List;

import pregroup.BasicType;
import pregroup.PhraseString;
import pregroup.TypeLink;
import pregroup.TypeReduction;

//! Creates a TikZ output from a parsing reduction
public class TikzReduction {
	
	private static final String tikzHeader =
			"\\begin{tikzpicture}[\n"+
		    "every node/.style={%\n"+
			"text height=1.5ex," +
			"text depth=0.25ex,"+
			"}]\n\n";
	private static final String tikzFooter = "\n\\end{tikzpicture}\n";
	
	//! Vertical space between the types and the links below them
	private static final double distToTypes = 0.25;
	//! Horizontal space between two simple types in the same word
	private static final double typeSpacing = 0.6;
	//! Horizontal space between the types of two words
	private static final double wordSpacing = 1.7;
	//! Vertical space between the original words and their types
	private static final double textDistance = 0.6;
	
	public static<BT extends BasicType<BT>> String draw(PhraseString<BT> phrase, List<String> words, TypeReduction red)
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
			else if(phrase.get(i).isRB())
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
		
		output += "\n";
		
		//! Draw the curves
		for(TypeLink l : red)
		{
			double from = pos[l.start];
			double to = pos[l.end];
			
			if(l.end != n-1)
			{
				double radius = (to - from)/2.;
				double center = (from + to) /2.;
				
				output += "\\draw ("+from+",-"+distToTypes+")"+
				   " .. controls ("+from+",-"+(distToTypes+0.555*radius)+")"+
						   " and ("+(center-0.555*radius)+",-"+(distToTypes+radius)+")"+
						   	" .. ("+center+",-"+(distToTypes+radius)+")"+
				   " .. controls ("+(center+0.555*radius)+",-"+(distToTypes+radius)+")"+
						   " and ("+to+",-"+(distToTypes+0.555*radius)+")"+
				            " .. ("+to+",-"+distToTypes+");\n";
			}
			else
			{
				output += "\\draw ("+from+",-"+distToTypes+") -- ("+from+",-"+(distToTypes+maxRad)+");\n";
			}
		}
		
		output += tikzFooter;
		return output;
	}
}
