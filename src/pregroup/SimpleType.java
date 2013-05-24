package pregroup;

public class SimpleType
{
	private String base;
	private int exp;
	
	public SimpleType(String bt, int e)
	{
		base = bt;
		exp = e;
	}
	
	public boolean isUnit()
	{
		return base.equals("1");
	}
	
	//! Generalized Contraction rule
	public boolean gcon(SimpleType a, PartialComparator<String> c)
	{
		return 
		     	(a.exp == this.exp + 1) && 
				((c.lessThan(this.base, a.base) && this.exp % 2 == 0) ||
				 (c.lessThan(a.base, this.base) && this.exp % 2 != 0));
	}
	
	//! Left adjoint of the type
	public SimpleType left()
	{
		SimpleType adj = new SimpleType(base, exp);
		adj.exp--;
		return adj;
	}
	
	//! Right adjoint of the type
	public SimpleType right()
	{
		SimpleType adj = new SimpleType(base, exp);
		adj.exp++;
		return adj;
	}
	
	public boolean isProductive()
	{
		return (exp % 2 == 0);
	}
	
	public String toString()
	{	
		if(exp == 0)
			return base;
		
		return base + "^{" + exp + "}";
	}
	
	public String toLatex()
	{
		if(exp == 0)
			return base;
		String output = base + "^{";
		if(exp > 0)
		{
			for(int i = 0; i < exp; i++)
				output += "r";
		}
		else
			for(int i = 0; i > exp; i--)
				output += "l";
		return (output+"}");
	}
	
	public String getBase()
	{
		return base;
	}
}
