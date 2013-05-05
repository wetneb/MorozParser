package pregroup;

import java.util.ArrayList;

public class TypeReduction extends ArrayList<TypeLink>
{
	private static final long serialVersionUID = 1L;
	
	//! Create an empty type reduction
	public static TypeReduction empty()
	{
		return new TypeReduction();
	}

	//! Add a new link to an existing reduction
	public TypeReduction link(int s, int e)
	{
		TypeReduction res = new TypeReduction();
		for(TypeLink l : this)
			res.add(l);
		res.add(new TypeLink(s,e));
		return res;
	}
	
	//! Makes the union of two type reductions (supposed disjoint)
	public static TypeReduction union(TypeReduction lhs, TypeReduction rhs)
	{
		TypeReduction res = new TypeReduction();
		for(TypeLink l : lhs)
			res.add(l);
		for(TypeLink l : rhs)
			res.add(l);
		return res;
	}
	
	public String toString()
	{
		String res = "";
		for(TypeLink l : this)
			res += l.toString() + " ";
		return res;
	}
}