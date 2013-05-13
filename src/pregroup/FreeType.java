package pregroup;

//! A grammar in which every pair of basic types is incomparable
public class FreeType implements BasicType<FreeType>
{
	private String str = "1";
	private Comparator<FreeType> comparator = null;
	
	public FreeType(String s, Comparator<FreeType> c)
	{
		str = s;
		comparator = c;
	}
	
	public boolean lessThan(FreeType t)
	{
		if(comparator == null)
			return this.str.equals(t.str);
		else return comparator.lessThan(this, t);
	}
	
	public String toString()
	{
		return str;
	}
	
	public boolean isUnit()
	{
		return str == "1";
	}
}
