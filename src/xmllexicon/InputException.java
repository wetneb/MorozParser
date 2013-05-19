package xmllexicon;

public class InputException extends Exception
{
	private static final long serialVersionUID = 1L;

	public String what;
	public InputException(String w)
	{
		what = w;
	}
}
