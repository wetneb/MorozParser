package latex;

import pregroup.BasicType;
import pregroup.PhraseString;
import pregroup.TypeLink;
import pregroup.TypeReduction;

//! Creates a TikZ output from a parsing reduction
public class TikzReduction {
	
	private static final String tikzHeader = "\\begin{tikzpicture}\n\n";
	private static final String tikzFooter = "\n\\end{tikzpicture}\n";
	private static final double distToTypes = 0.25; 
	
	public static<BT extends BasicType<BT>> String draw(PhraseString<BT> phrase, TypeReduction red)
	{
		int n = phrase.size();
		int[] pos = new int[n];
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
		int curPos = 0;
		for(int i = 0; i < n; i++)
		{
			if(used[i])
			{
				pos[i] = curPos;
				output += "\\node at ("+curPos+",0) (t"+i+") {$"+phrase.get(i).toString()+"$};\n";
				curPos++;
			}
		}
		
		output += "\n";
		
		//! Draw the curves
		for(TypeLink l : red)
		{
			int from = pos[l.start];
			int to = pos[l.end];
			
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
		
		output += tikzFooter;
		return output;
	}
}
