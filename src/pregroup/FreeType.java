package pregroup;

//! A grammar in which every pair of basic types is incomparable
public class FreeType implements BasicType<FreeType>
{
	private String str = "1";
	
	public FreeType(String s)
	{
		str = s;
	}
	
	public boolean lessThan(FreeType t)
	{
		return false;
	}
	
	public String toString()
	{
		return str;
	}
}
