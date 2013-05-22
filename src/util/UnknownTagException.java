package util;

public class UnknownTagException extends Exception {

	private static final long serialVersionUID = 1L;
	public final String what;
	public UnknownTagException(String s) { what = s; }

}
