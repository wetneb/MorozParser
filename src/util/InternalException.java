package util;

public class InternalException extends Exception
{
	private static final long serialVersionUID = 1L;
	public final String what;
	public InternalException(String s) { what = s; }
}
