package pregroup;

import java.util.ArrayList;

//! A complex type (string of simple types)
public class TypeString<BT extends BasicType<BT>> extends ArrayList<SimpleType<BT>>
{
	private static final long serialVersionUID = 1L;
	
	//! Construct an empty type string
	public TypeString()
	{
		
	}
	
	//! Construct a type string from a simple type (makes a singleton)
	public TypeString(SimpleType<BT> s)
	{
		this.add(s);
	}
	
	//! Add a simple type
	public boolean add(BT base, int exp)
	{
		this.add(new SimpleType<BT>(base, exp));
		return true;
	}

	//! Compute the left adjoint
	public TypeString<BT> left()
	{
		TypeString<BT> result = new TypeString<BT>();
		
		for(SimpleType<BT> s : this)
			result.add(0, s.left());
		
		return result;
	}
	
	//! Compute the right adjoint
	public TypeString<BT> right()
	{
		TypeString<BT> result = new TypeString<BT>();
		
		for(SimpleType<BT> s : this)
			result.add(0, s.right());
		
		return result;
	}
	
	//! Print the type as a string
	public String toString()
	{
		String res = "";
		
		for(SimpleType<BT> s : this)
			res = res + s.toString();
		
		return res;
	}
}
