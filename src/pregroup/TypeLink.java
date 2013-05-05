package pregroup;

//! A link between two types in a reduction
public class TypeLink
{
	public int start;
	public int end;
	
	public TypeLink(int s, int e)
	{
		start = s;
		end = e;
	}
	
	public String toString()
	{
		return "("+start+","+end+")";
	}
}