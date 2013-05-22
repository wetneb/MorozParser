package util;

public class NotFoundException extends Exception
{
	private static final long serialVersionUID = 1L;
	public final int i;
	public NotFoundException(int id) { i = id; }
}
