package rdf;

public class TypeException extends Exception
{
	private static final long serialVersionUID = 1L;
	public String what;
	public TypeException(String w) { what = w; }
}