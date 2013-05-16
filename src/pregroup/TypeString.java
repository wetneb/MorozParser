package pregroup;

import java.util.ArrayList;

//! A complex type (string of simple types)
public class TypeString extends ArrayList<SimpleType>
{
	private static final long serialVersionUID = 1L;
	
	//! Construct an empty type string
	public TypeString()
	{
		super();
	}
	
	//! Construct a type string from a simple type (makes a singleton)
	public TypeString(SimpleType s)
	{
		this.add(s);
	}
	
	//! Add a simple type
	public boolean add(String base, int exp)
	{
		this.add(new SimpleType(base, exp));
		return true;
	}

	//! Compute the left adjoint
	public TypeString left()
	{
		TypeString result = new TypeString();
		
		for(SimpleType s : this)
			result.add(0, s.left());
		
		return result;
	}
	
	//! Compute the right adjoint
	public TypeString right()
	{
		TypeString result = new TypeString();
		
		for(SimpleType s : this)
			result.add(0, s.right());
		
		return result;
	}
	
	//! Print the type as a string
	public String toString()
	{
		String res = "";
		
		for(SimpleType s : this)
			res = res + s.toString();
		
		return res;
	}
}
