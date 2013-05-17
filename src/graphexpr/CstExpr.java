package graphexpr;

import java.util.HashMap;

public class CstExpr extends PropExpr implements Cloneable
{
	public String str;
	public CstExpr(String s) { str = new String(s); }
	
	public void shift(HashMap<Integer,Integer> map, String name)
	{
		str = str.replaceAll("NAME", name);
	}
	
	public Object clone()
	{
		return new CstExpr(str);
	}
	
	public String toString()
	{
		return "\""+str+"\"";
	}
}